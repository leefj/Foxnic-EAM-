#!/bin/sh
######################################################################################
#
#	使用:	sh db2_db_restore.sh
#	功能:	db2数据库一键还原，db2备份文件和脚本放置于同一个目录下即可	
#	版本:	支持DB2 v11
#
#
#				【【注意:本脚本禁止在生产环境中执行！！！】】
#
#									modify by Lank
#										2023-09-20
######################################################################################
curdir=$(cd `dirname $0`;pwd)
cd $curdir
starttime=`date "+%Y/%m/%d %H:%M:%S"`
echo "start time:$starttime"
echo "cur dir is $curdir"
restorefile=`ls -rtl|grep DBPART|grep 00|tail -1|awk '{print $NF}'`
echo "restore file is $restorefile"
if [[ -f $restorefile ]];then 
	echo "restore file $restorefile exist" 
else 
	echo "restore file $restorefile not exist" 
	exit 1
fi
dbname=`ls -rtl |grep DBPART|awk '{print $NF}'|awk -F "." '{print $1}'`
dbfileseq=`ls -rtl |grep DBPART|awk '{print $NF}'|awk -F "." '{print $5}'`
db2user=`ls -rtl |grep DBPART|awk '{print $NF}'|awk -F "." '{print $3}'`
curuser=`whoami`
echo "db name is $dbname,db seq is $dbfileseq"
echo "start to generate restore.sql"
if [[ -f restore.sql ]];then
	echo "remove exist restore.sql"
	rm -rf restore.sql
fi
echo "command:db2 restore database $dbname from $curdir taken at $dbfileseq redirect generate script restore.sql"
db2 restore database $dbname from $curdir taken at $dbfileseq redirect generate script restore.sql
data_dir=`cat restore.sql|grep "\-\- ON"|head -1|awk '{print $NF}'|sed "s@'@@g"`
mkdir -p $data_dir
echo "data_dir:$data_dir"
if [[ ! -d $data_dir ]];then
	echo "can not create data_dir,data_dir:$data_dir"
	exit 1
fi
echo "start to edit restore.sql"
echo "start modify parameter restore.sql"
targetseq=`date "+%Y%m%d%H%M%S"`
logtargetdir=/home/$curuser/logtarget_$targetseq
mkdir -p $logtargetdir
echo "log target dir:$logtargetdir"
if [[ ! -d $logtargetdir ]];then
	echo "can not create logtargetdir,logtargetdir:$logtargetdir"
	exit 1
fi
sed -i "s@-- DBPATH ON '<target-directory>'@DBPATH ON '/home/$curuser'@g" restore.sql
sed -i "s@-- LOGTARGET '<directory>'@LOGTARGET '$logtargetdir'@g" restore.sql
sed -i "s@-- LOGTARGET '<directory>'@LOGTARGET '$logtargetdir'@g" restore.sql
sed -i "s@-- REPLACE EXISTING@   REPLACE EXISTING@g" restore.sql
sed -i "s@-- REPLACE HISTORY FILE@  REPLACE HISTORY FILE@g" restore.sql
#sed -i "s@-- WITH <num-buff> BUFFERS@  WITH 1 BUFFERS@g" restore.sql
#sed -i "s@-- BUFFER <buffer-size>@  BUFFER 4096@g" restore.sql
sed -i "s@-- WITHOUT PROMPTING@  WITHOUT PROMPTING@g" restore.sql
logpath=`cat restore.sql|grep NEWLOGPATH|awk '{print $NF}'|sed "s@'@@g"`
echo "logpath is $logpath"
mkdir -p $logpath
if [[ ! -d $logpath ]];then
	echo "can not create logpath,logpath:$logpath"
	exit 1
fi

#生成新的文件
#截取头部
upHeaderDataNo=`cat -n restore.sql|grep "table space definition"|awk '{print $1}'`
head -n $upHeaderDataNo restore.sql>restore_cmd.sql
echo "start modify tablespace hight water mark"
#截取表空间
echo "start to process tablespace hwm"
mkdir -p tmp
#scount=358-43
scount=`cat restore.sql|wc -l`
hcount=`cat -n restore.sql|grep "table space definition"|head -1|awk '{print $1}'`
vcount=$((scount-hcount))
tail -n $vcount restore.sql>restore2.sql
cat restore2.sql|grep -v "RESTORE DATABASE">tbs.file
cat tbs.file|grep -v "\-\-">tbs_min.file
OLD_IFS="$IFS"
IFS=";"
ct=`cat tbs_min.file`
ct_arr=($ct)
for s in ${ct_arr[@]}
do
	tbsno=`echo $s|grep "TABLESPACE CONTAINERS"|awk '{print $NF}'`
	echo "$s">tmp/$tbsno.file
done
IFS="$OLD_IFS"
cat tbs.file|grep "Tablespace name"|while read line;do
	tbs=`echo $line|awk '{print $NF}'`
	cat tbs.file|grep -A 14 "$tbs">tmp/$tbs.file
	tbs_type=`cat tmp/$tbs.file|grep "Tablespace Type"|awk -F "=" '{print $NF}'|head -1|sed "s@ @@g"`
	tbs_c_type=`cat tmp/$tbs.file|grep "Tablespace Content Type"|head -1|awk -F "=" '{print $NF}'|sed "s@ @@g"`
	tbs_id=`cat tmp/$tbs.file|grep "Tablespace ID"|head -1|awk '{print $NF}'|sed "s@ @@g"`
	tbs_as=`cat tmp/$tbs.file|grep "Using automatic storage"|head -1|awk '{print $NF}'|sed "s@ @@g"`
	tbs_hwm=`cat tmp/$tbs.file|grep "High water mark"|head -1|awk '{print $NF}'|sed "s@ @@g"`
	echo "tbs_id:$tbs_id,tbs:$tbs,tbs_type:$tbs_type,tbs_c_type:$tbs_c_type,tbs_as:$tbs_as,tbs_hwm:$tbs_hwm"
	#备注输出 output
	#cat tmp/$tbs.file|grep '\-\-'>>restore_cmd.sql
	#如果是自动调整,则不考虑高水位直接输出,存在数据文件则直接输出
	if [[ $tbs_as == "Yes" ]];then
		if [[ -f tmp/$tbs_id.file ]];then
			cat tmp/$tbs_id.file>>restore_cmd.sql
		fi 
		continue;
	fi
	#表空间管理方式为DMS，判断高水位，根据高水位修改防止空间不足
	if [[ $tbs_type == "Databasemanagedspace" ]];then
		#如果高水位<100000,直接输出
		if [[ $tbs_hwm -lt 100000 ]];then
			echo "SET TABLESPACE CONTAINERS FOR $tbs_id"	>>restore_cmd.sql
			echo "	USING (                            "	>>restore_cmd.sql
			echo "	FILE  '$data_dir/${tbs}_1' 150000  "	>>restore_cmd.sql
			echo " );                                  " 	>>restore_cmd.sql
		else
			#如果高水位线>100000
			echo "SET TABLESPACE CONTAINERS FOR $tbs_id"	>>restore_cmd.sql
			echo "	USING (                            "	>>restore_cmd.sql
			echo "	FILE  '$data_dir/${tbs}_1' $tbs_hwm"	>>restore_cmd.sql
			echo " ,FILE  '$data_dir/${tbs}_2' 200000  "	>>restore_cmd.sql
			echo " );                                  " 	>>restore_cmd.sql
		fi
	fi
	#表空间管理方式为SMS,则判断有数据文件就输出
	if [[ $tbs_type == "Systemmanagedspace" ]];then
		if [[ $tbs_c_type == "SystemTemporarydata" ]];then
			cat tmp/$tbs_id.file>>restore_cmd.sql
		fi
	fi
done

#截取结束
echo "RESTORE DATABASE $dbname CONTINUE;">>restore_cmd.sql

#开始停数据库
echo "stop database"
db2 force application all
db2set db2comm="" 
db2stop force
db2start 

#恢复数据库
echo "start to restore database"
echo "db2 -tvf restore_cmd.sql"
db2 -tvf restore_cmd.sql

#追平日志
echo "start to rollforward"
echo "rollforward database $dbname to end of logs and complete overflow log path('$logtargetdir')"
db2 "rollforward database $dbname to end of logs and complete overflow log path('$logtargetdir')"
echo "restore database success!"

#连接数据库
echo "start connect to database"
db2 connect to $dbname

#关闭归档
#echo "archive disable"
db2 update db cfg for $dbname using LOGARCHMETH1 off

#修改其他参数
db2 update db cfg for $dbname using SELF_TUNING_MEM on
db2 update db cfg for $dbname using LOGPRIMARY 30
db2 update db cfg for $dbname using LOGSECOND 15

#修改buffpool
echo "before modify bufferpools"
db2pd -d $dbname -buff|grep 0x00
echo "">bufferpool.sql
db2pd -d $dbname -buff|grep 0x00|while read line;do
	bname=`echo $line|awk '{print $3}'|head -1|sed "s@ @@g"`
	pagesize=`echo $line|awk '{print $4}'|head -1|sed "s@ @@g"`
	pagesizeK=$((pagesize/1024))
	pagenum=`echo $line|awk '{print $5}'|head -1|sed "s@ @@g"`
	rsize=$((pagesizeK*pagenum/1024))
	echo "bname:$bname,pagesize:$pagesizeK,pagenum:$pagenum,rsize_m:$rsize"
	maxsize=2048
	if [[ $rsize -gt $maxsize ]];then
		pagenumNew=$((maxsize*1024/pagesizeK))
		echo "alter bufferpool $bname immediate size $pagenumNew ;"
		echo "alter bufferpool $bname immediate size $pagenumNew ;">>bufferpool.sql
	fi
done
poolModifyCount=`cat bufferpool.sql|grep alter|wc -l`
if [[ $poolModifyCount -gt 0 ]];then
	echo "start to modify pool,db2 -tvf bufferpool.sql"
	db2 -tvf bufferpool.sql
fi 
#echo after modify
echo "after modify bufferpools"
db2pd -d $dbname -buff|grep 0x00
db2 "select BPNAME,NPAGES,PAGESIZE from syscat.bufferpools"
db2 terminate

#重启数据库
echo "restart database"
db2set db2comm=TCPIP
db2 force application all
db2stop force
db2start

#显示表空间
db2 connect to $dbname
db2 "select 'tbs_data_rcd' data, TBSP_ID,substr(TBSP_NAME,1,50),TBSP_TOTAL_SIZE_KB/1024/1024 as TBSP_TOTAL_SIZE,TBSP_USED_SIZE_KB/1024/1024 as TBSP_USED_SIZE,TBSP_FREE_SIZE_KB/1024/1024 as TBSP_FREE_SIZE,int(TBSP_UTILIZATION_PERCENT) TBSP_UTILIZATION_PERCENT from sysibmadm.TBSP_UTILIZATION order by TBSP_ID">tbs_space.txt
#处理是否要表空间扩容
cat tbs_space.txt
echo "">extend_space.sql
cat tbs_space.txt|grep tbs_data_rcd|grep -v SYSCATSPACE|while read line;do
	tbs_name=`echo $line|awk '{print $3}'|sed "s@ @@g"`
	tbs_used_pct=`echo $line|awk '{print $NF}'|sed "s@ @@g"`
	tbs_type=`cat tmp/$tbs_name.file|grep "Tablespace Type"|awk -F "=" '{print $NF}'|head -1|sed "s@ @@g"`
	tbs_c_type=`cat tmp/$tbs_name.file|grep "Tablespace Content Type"|head -1|awk -F "=" '{print $NF}'|sed "s@ @@g"`
	tbs_as=`cat tmp/$tbs_name.file|grep "Using automatic storage"|head -1|awk '{print $NF}'|sed "s@ @@g"`
	echo "tbs_name:$tbs_name,tbs_used_pct:$tbs_used_pct,tbs_type:$tbs_type,tbs_as:$tbs_as"
	warnPct=90
	if [[ $tbs_as == "Yes" ]];then
		continue;
	fi
	if [[ $tbs_used_pct -gt $warnPct ]];then
		echo "ALTER TABLESPACE $tbs_name EXTEND (ALL 65536);">>extend_space.sql
	fi
done
exSpaceCnt=`cat extend_space.sql|grep "ALTER"|wc -l`
if [[ $exSpaceCnt -gt 0 ]];then
	echo "suggust extend some tablespace,list:"
	cat extend_space.sql
else
	echo "no tablespace need to extend!"
fi
db2 terminate
#编译对象
#db2 -x "select 'REBIND PACKAGE ' || rtrim(pkgschema) || '.' || rtrim(pkgname) || ';' as command from syscat.packages"> rebind.sql
#db2 -tvf rebind.sql

#恢复完成
endtime=`date "+%Y/%m/%d %H:%M:%S"`
echo "endtime:$endtime"
echo "database restore finish!"
exit 0

############################################end###################################################
#Q1
db2stat 后 DB2COMM 问题
kill -9 /home/db2inst1/sqllib/bin/db2bp 进程
#Q2 tbs extend
# 1G
#4K  262144
#8K  131072
#16K 65536
#32K 32768
#
db2 "ALTER TABLESPACE tbs_name EXTEND (ALL 65536)"

 