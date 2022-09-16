#!/bin/sh
#cron:
#   0 */1 * * * sh /app/app/bin/checkIfRestartApp.sh
checkfile="/tmp/checkEamRunning.log"
cur_dir=$(cd `dirname $0`; pwd)
app_dir=$cur_dir/..
d=`date`
echo "$d">>$checkfile
port=`cat $app_dir/app/app/application.yml |grep -v "#"|grep port|head -1|awk -F ":" '{print $NF}'|awk '{print $NF}'`
echo "Command:curl --connect-timeout 5 -m 100 http://127.0.0.1:$port/login.html 2>/dev/null"
c=`curl --connect-timeout 5 -m 20 http://127.0.0.1:$port/login.html 2>/dev/null|wc -l`
if [[ $c -lt 120 ]];then
  cd $app_dir
  echo "check failed,go to restart!">>$checkfile
  sh restartApp.sh
else
  echo "check success!"
  echo "check success!">>$checkfile
fi
exit 0
