#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
cd $cur_dir

sh stopApp.sh
sh stopBpm.sh
sh stopJob.sh

exit 0

