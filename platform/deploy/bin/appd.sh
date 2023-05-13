#!/bin/sh
#nohup sh appd.sh &
cur_dir=$(cd `dirname $0`; pwd)
app_dir=$cur_dir/..
logFile=$app_dir/logs/appd.log
cd $cur_dir
name=app
while true
do
  d=`date`
  echo "$d">>$logFile
  cd $cur_dir
  statusCnt=`sh app.sh status $name|grep "is running"|grep pid|wc -l`
  if [[ $statusCnt -gt 0 ]];then
    echo "$name status is running" >>$logFile
  else
    echo "$name go to restart" >>$logFile
    cd $cur_dir
    sh app.sh restart $name
  fi
sleep 300
done
exit 0