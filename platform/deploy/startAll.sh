#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
cd $cur_dir
sleep 1
echo "to start App"
sh startApp.sh
sleep 1
echo "to start Bpm"
sh startBpm.sh
sleep 1
echo "to start Job"
sh startJob.sh
sleep 1
echo "to start Tengine"
sh startTengine.sh
exit 0

