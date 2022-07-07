#!/bin/sh
#cron:
########################################
cur_dir=$(cd `dirname $0`; pwd)
app_conf="${cur_dir}/app.conf"
cd $cur_dir
sh runSql.sh ./sql/cleardata.sql eam_demo
exit 0

