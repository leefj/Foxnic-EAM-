#!/bin/bash
#00 2 * * * sh /dbbak/dnname/backup_db2.sh /app/appinst/.bash_profile /dbbak/dbname DBNAME /app/db2inst1/archivelog/appinst/DBNAME/NODE0000/LOGSTREAM0000/C0000004
PROFILE=$1
BAKDIR=$2
DBNAME=$3
DBLOGBAKDIR=$4
echo "PROFILE:$PROFILE"
echo "BAKDIR:$BAKDIR"
echo "DBNAME:$DBNAME"
echo "DBLOGBAKDIR:$DBLOGBAKDIR"
if [[ ! -f $PROFILE ]];then
	echo "PROFILE Configure Error"
	exit 1
fi
if [[ ! -d $BAKDIR ]];then
	echo "BAKDIR Configure Error"
	exit 1
fi
. $PROFILE
#####record dbft start
d=`date "+%Y%m%d"`
dbft_dbname=$DBNAME
dbft_record=$dbft_dbname
dbft_name=$dbft_dbname
dbft_aliasname=$dbft_record
dbft_file=$BAKDIR/db_backup_${dbft_record}.log
dbft_id=`date +"%Y%m%d%H%M%S"`
dbft_stime=`date +"%Y-%m-%d %H:%M:%S.000"`
hip=`hostname -I|awk '{print $1}'`
echo $dbft_name$hip>/tmp/md5file
muid=`md5sum /tmp/md5file|awk '{print $1}'`
echo "$dbft_stime|method=local,uid=$muid,action=db,status=acting,dbname=$dbft_name,alias_name=$dbft_aliasname,ip=$hip,size=0">>$dbft_file
cd ${BAKDIR}
echo "start backup"
db2 backup db ${DBNAME} online to ${BAKDIR} compress include logs >> ${BAKDIR}/dbbackup.log
#####record dbft end
dbft_dfile=`ls -rtl |grep 001|tail -1|awk '{print $NF}'`
dbft_etime=`date +"%Y-%m-%d %H:%M:%S.000"`
dbft_size=`du -sm $dbft_dfile|awk '{print $1}'`
dbft_stat=`tail ${BAKDIR}/dbbackup.log|grep $d |awk '{print $2}'`
        if [[ $dbft_stat = "successful." ]];then
            echo "$dbft_etime|method=local,uid=$muid,action=db,status=success,dbname=$dbft_name,alias_name=$dbft_aliasname,ip=$hip,size=$dbft_size,result=success,stime=$dbft_stime,etime=$dbft_etime">>$dbft_file
            else
            echo "$dbft_etime|method=local,uid=$muid,action=db,status=failed,dbname=$dbft_name,alias_name=$dbft_aliasname,ip=$hip,size=$dbft_size,result=failed,stime=$dbft_stime,etime=$dbft_etime">>$dbft_file
		fi
if [[ -d ${BAKDIR} ]];then
	cd ${BAKDIR}
	bcnt=`ls -rtl |grep $DBNAME|grep -v grep |wc -l`
	if [[ $bcnt -gt 3 ]];then
		echo "start to clear backup file"
		find ${BAKDIR} -name "${DBNAME}*DB*001" -mtime +7 -exec rm -rf {} \;
	fi 
fi
if [[ -d ${DBLOGBAKDIR} ]];then
	echo "start to clear archlog"
	find ${DBLOGBAKDIR} -name "*.LOG" -mtime +100 -exec rm -rf {} \;
fi
exit 0