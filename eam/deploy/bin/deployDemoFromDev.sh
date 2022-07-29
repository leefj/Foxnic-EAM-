#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
app_dir=$cur_dir/..

cd $cur_dir
sh backupAppData.sh

if [[ ! -f "/tmp/app.tar" ]];then
  echo "app.tar not exist"
  exit 1
fi

if [[ ! -d "$app_dir/app/app" ]];then
  echo "$app_dir/app/app path not exit"
  exit 1
fi

cd $cur_dir
sh backupAppDB.sh eam
sh runSql.sh $app_dir/backup/db/db.sql eam_demo

cd $app_dir/app/app
rm -rf lib*
rm -rf *.jar
cp /tmp/app.tar .
tar xvf app.tar
exit 0