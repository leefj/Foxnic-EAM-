#!/bin/sh
#cron:
#   0 */1 * * * sh /app/app/bin/checkIfRestartApp.sh
checkfile="/tmp/checkAppRunning.log"
cur_dir=$(cd `dirname $0`; pwd)
app_dir=$cur_dir/..
d=`date +"%Y-%m-%d %H:%M:%S"`
port=`cat $app_dir/app/app/application.yml |grep -v "#"|grep port|head -1|awk -F ":" '{print $NF}'|awk '{print $NF}'`
## connect-timeout 5s
## -m 10s
echo "Command:curl --connect-timeout 5 -m 10 http://127.0.0.1:$port/login.html 2>/dev/null"
c=`curl --connect-timeout 5 -m 10 http://127.0.0.1:$port/login.html 2>/dev/null|wc -l`
if [[ $c -lt 120 ]];then
  cd $app_dir
  echo "$d | check failed,value is $c,will go to restart!"
  echo "$d | check failed,value is $c,will go to restart!">>$checkfile
  sh restartApp.sh
else
  echo "$d | check success,value is $c"
  echo "$d | check success,value is $c">>$checkfile
fi
exit 0

