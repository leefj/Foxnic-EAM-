#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
cd $cur_dir

sh startApp.sh
sh startBpm.sh
sh startJob.sh

exit 0

