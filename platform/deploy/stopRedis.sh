#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
cd $cur_dir
rediscnt=`ps -ef|grep redis-server|grep -v grep |wc -l`
if [[ $rediscnt -gt 0 ]];then
  ps -ef|grep redis-server|grep -v grep|awk '{print $2}'|xargs kill -9
  echo "redis stop success"
else
    echo "redis not running"
fi
exit 0




