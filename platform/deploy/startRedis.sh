#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
cd $cur_dir
rediscnt=`ps -ef|grep redis-server|grep -v grep |wc -l`
if [[ $rediscnt -gt 0 ]];then
  echo "redis already running"
else
  $cur_dir/redis/bin/redis-server $cur_dir/redis/etc/redis.conf
  echo "redis start success"
fi
exit 0




