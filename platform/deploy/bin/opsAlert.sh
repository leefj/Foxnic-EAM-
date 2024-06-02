#!/bin/sh
# sh opsAlert.sh 15700000000 "this is a test"
mobile=$1
msg=$2
cur_dir=$(cd `dirname $0`; pwd)
app_dir=$cur_dir/..
logFile=$app_dir/logs/opsAlert.log
d=`date +%Y%m%d%H%M%S`
echo "rcd time:$d">>$logFile
echo "mobile:$1"
echo "mobile:$1">>$logFile
echo "msg:$2"
echo "msg:$2">>$logFile

exit 0