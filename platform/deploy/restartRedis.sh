#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
cd $cur_dir
sh stopRedis.sh
sleep 1
sh startRedis.sh
exit 0
