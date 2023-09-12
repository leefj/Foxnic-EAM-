#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
cd $cur_dir
sh stopTengine.sh
sleep 1
sh startTengine.sh
exit 0
