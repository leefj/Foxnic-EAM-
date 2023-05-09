#!/bin/sh
#2 2 * * * sh /app/app/bin/clearDataSpace.sh
cur_dir=$(cd `dirname $0`; pwd)
app_dir=$cur_dir/..
log_file=$app_dir/tmp/clearDataSpace.log
rcdtime=`date`

echo "#############clear data space start at $rcdtime############">>$log_file
####db backup clear######
echo "start to clear backup">>$log_file
dbbackup=$base_dir/backup/db
if [[ -d $dbbackup ]];then
  echo "clear db backup file start,dir:$dbbackup">>$log_file
  cd $dbbackup
  find ./ -mtime +30 -name "*backup_*.tar.gz" -exec rm -rf {} \;
  echo "clear db backup file finish">>$log_file
fi

####app logfile######
echo "start to clear app log">>$log_file
app_log_dir=$app_dir/app/app/app_logs
if [[ -d "$app_log_dir" ]];then
  cd $app_log_dir
  echo "clear app log file start,dir:$app_log_dir">>$log_file
  find ./ -mtime +30 -name "*.log" -exec rm -rf {} \;
  echo "clear app log file finish">>$log_file
fi

####bpm logfile######
echo "start to clear bpm log">>$log_file
bpm_log_dir=$app_dir/app/bpm/bpm_logs
if [[ -d "$bpm_log_dir" ]];then
  cd $bpm_log_dir
  echo "clear app log file start,dir:$bpm_log_dir">>$log_file
  find ./ -mtime +30 -name "*.log" -exec rm -rf {} \;
  echo "clear bpm log file finish">>$log_file
fi

####app tmp file ####
echo "start to clear tmp data">>$log_file
app_tmp_dir=$app_dir/tmp
if [[ -d "$app_tmp_dir" ]];then
  cd $app_tmp_dir
  echo "clear tmp log file start,dir:$app_tmp_dir">>$log_file
  find ./ -mtime +30 -name "*.tmp" -exec rm -rf {} \;
  find ./ -mtime +30 -name "*.pdf" -exec rm -rf {} \;
  find ./ -mtime +30 -name "*.xls" -exec rm -rf {} \;
  find ./ -mtime +30 -name "*.jpg" -exec rm -rf {} \;
  echo "clear tmp log file finish">>$log_file
fi
echo "#############clear data space finish ############">>$log_file
echo "">>$log_file
echo "">>$log_file
echo "">>$log_file
exit 0


