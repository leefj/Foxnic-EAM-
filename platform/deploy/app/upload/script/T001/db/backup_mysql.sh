#!/bin/sh
#30 1 * * * sh /dbbak/backup_mysql.sh 
user=root
pwd=XXXXX
dbname=XXXXX
time=`date "+%Y-%m-%d"`
echo $time
dir=/dbbak/data
bkdump=/db/mysql/mysql/bin/mysqldump
#####record dbft start
dbft_dbname=$dbname
dbft_record=$dbft_dbname
dbft_name=$dbft_dbname
dbft_aliasname=$dbft_record
dbft_file=/tmp/db_backup_${dbft_record}.log
dbft_id=`date +"%Y%m%d%H%M%S"`
dbft_stime=`date +"%Y-%m-%d %H:%M:%S.000"`
hip=`hostname -I|awk '{print $1}'`
echo $dbft_name$hip>/tmp/md5file
muid=`md5sum /tmp/md5file|awk '{print $1}'`
echo "$dbft_stime|method=local,uid=$muid,action=db,status=acting,dbname=$dbft_name,alias_name=$dbft_aliasname,ip=$hip,size=0">>$dbft_file
$bkdump -u$user -p$pwd -h127.0.0.1 -R -E $dbname >$dir/fullbackup.$time.sql
tar -czvf $dir/fullbackup.$time.tar.gz $dir/fullbackup.$time.sql
dbft_dfile=$dir/fullbackup.$time.sql
sleep 1
dbft_etime=`date +"%Y-%m-%d %H:%M:%S.000"`
dbft_size=`du -sm $dbft_dfile|awk '{print $1}'`
dbbak_stat=`tail $dbft_dfile|grep completed|awk '{print $3}'`
if [[ $dbbak_stat = "completed" ]];then
	echo "$dbft_etime|method=local,uid=$muid,action=db,status=success,dbname=$dbft_name,alias_name=$dbft_aliasname,ip=$hip,size=$dbft_size,result=success,stime=$dbft_stime,etime=$dbft_etime">>$dbft_file
else
	echo "$dbft_etime|method=local,uid=$muid,action=db,status=failed,dbname=$dbft_name,alias_name=$dbft_aliasname,ip=$hip,size=$dbft_size,result=failed,stime=$dbft_stime,etime=$dbft_etime">>$dbft_file
fi
if [[ -d ${dir} ]];then
 echo "del backup"
 cd $dir
 find ${dir} -name "*.sql" -mtime +14 -exec rm -rf {} \;
 find ${dir} -name "*.tar.gz" -mtime +14 -exec rm -rf {} \;
fi
exit 0