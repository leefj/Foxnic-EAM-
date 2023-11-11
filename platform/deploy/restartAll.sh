#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
cd $cur_dir
sleep 1
sh restartApp.sh
sleep 1
sh restartBpm.sh
sleep 1
sh restartJob.sh
sleep 1
sh restartTengine.sh
exit 0

