#!/bin/sh
#58 23 * * * sh /app/app/bin/clearDataSpace.sh
cur_dir=$(cd `dirname $0`; pwd)
app_dir=$cur_dir/..
log_file=$app_dir/tmp/clearDataSpace.log
rcdtime=`date`

function rec(){
  echo $1
  echo $1>>$log_file
  return 0
}
echo "#############clear data space start at $rcdtime############">>$log_file
####db backup clear######

rec "start to clear backup"
dbbackup=$base_dir/backup/db
if [[ -d $dbbackup ]];then
  echo "clear db backup file start,dir:$dbbackup">>$log_file
  cd $dbbackup
  find ./ -mtime +30 -name "*backup_*.tar.gz" -exec rm -rf {} \;
  rec "clear db backup file finish"
fi

####app logfile######
echo "start to clear app log">>$log_file
app_log_dir=$app_dir/app/app/app_logs
if [[ -d "$app_log_dir" ]];then
  cd $app_log_dir
  rec "clear app log file start,dir:$app_log_dir"
  find ./ -mtime +30 -name "*.log" -exec rm -rf {} \;
  rec "clear app log file finish"

  rec "clear app.jar.log"
  jarlogfile=app.jar.log
  if [[ -f "$app_dir/logs/$jarlogfile" ]];then
    cd $app_dir/logs/
    jarTime=`date +%Y$m%d%H%M%S`
    cat ${jarlogfile}>${jarlogfile}.${jarTime}
    tar zcvf ${jarlogfile}.${jarTime}.tar.gz ./${jarlogfile}.${jarTime}
    echo "">${jarlogfile}
    rm -rf ${jarlogfile}.${jarTime}
    find ./ -mtime +60 -name "*.tar.gz" -exec rm -rf {} \;
    rec "clear app.jar.log finish"
  fi
fi

####bpm logfile######
echo "start to clear bpm log">>$log_file
bpm_log_dir=$app_dir/app/bpm/bpm_logs
if [[ -d "$bpm_log_dir" ]];then
  cd $bpm_log_dir
  rec "clear app log file start,dir:$bpm_log_dir"
  find ./ -mtime +30 -name "*.log" -exec rm -rf {} \;
  rec "clear bpm log file finish"

  rec "clear bpm.jar.log"
  jarlogfile=bpm.jar.log
  if [[ -f "$app_dir/logs/$jarlogfile" ]];then
    cd $app_dir/logs/
    jarTime=`date +%Y$m%d%H%M%S`
    cat ${jarlogfile}>${jarlogfile}.${jarTime}
    tar zcvf ${jarlogfile}.${jarTime}.tar.gz ./${jarlogfile}.${jarTime}
    echo "">${jarlogfile}
    rm -rf ${jarlogfile}.${jarTime}
    find ./ -mtime +60 -name "*.tar.gz" -exec rm -rf {} \;
    rec "clear bpm.jar.log finish"
  fi
fi

####app tmp file ####
rec "start to clear tmp data"
app_tmp_dir=$app_dir/tmp
if [[ -d "$app_tmp_dir" ]];then
  cd $app_tmp_dir
  rec "clear tmp log file start,dir:$app_tmp_dir"
  find ./ -mtime +30 -name "*.tmp" -exec rm -rf {} \;
  find ./ -mtime +30 -name "*.pdf" -exec rm -rf {} \;
  find ./ -mtime +30 -name "*.xls" -exec rm -rf {} \;
  find ./ -mtime +30 -name "*.jpg" -exec rm -rf {} \;
  rec "clear tmp log file finish"
fi
rec "#############clear data space finish ############"

echo "">>$log_file
echo "">>$log_file
echo "">>$log_file




exit 0


