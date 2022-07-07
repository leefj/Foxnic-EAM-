#!/bin/sh
#2 2 * * * sh /app/app/bin/clearData.sh
cur_dir=$(cd `dirname $0`; pwd)
app_dir=$cur_dir/..
log_dir=$cur_dir/..
log_file=$log_dir/logs/clearData.log
#delete logs file
if [[ -d "$app_dir" ]];then
  cd $app_dir
  find ./ -mtime +90 -name "*.log" -exec rm -rf {} \;
  echo "delete logs file success">>$log_file
fi
exit 0


