#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
d=`date +%H%M%S`
db_update_name="update_$d"
app_conf="${cur_dir}/app.conf"
app_dir=$cur_dir/..
t=`date +%m%d%H%M%S`
db_name=`cat $app_conf|grep -v "#"|grep DB_NAME=|awk -F "=" '{print $2}'`
logfile="$app_dir/logs/db_resource_update.log";
mkdir -p $app_dir/logs
if [[ ! -d $app_dir/logs ]];then
  echo "$app_dir/logs not exists"
  exit 1
fi
######### create new database and load data #########
nowTime=`date +%Y$m%d%H%M%S`
echo "################### start to update db resource,time:$nowTime ######################">>$logfile
echo "########### execute create new database sql $db_update_name #########"
echo "start to create database $db_update_name">>$logfile
echo "CREATE DATABASE $db_update_name DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;">/tmp/db_create.sql
if [[ -f /tmp/db_create.sql ]];then
  echo "start to create new database"
  sh $app_dir/bin/runSql.sh /tmp/db_create.sql $db_name
else
  echo "/tmp/db_create.sql not exist"
  exit 1
fi
######### create load data #########
echo "########### execute load data #########"
if [[ -f /tmp/db.sql ]];then
  echo "start to create new database"
  sh $app_dir/bin/runSql.sh /tmp/db.sql $db_update_name
else
  echo "/tmp/db.sql not exist"
  echo "/tmp/db.sql not exist">>$logfile
  exit 1
fi
echo ""
######### start to backup database #########
echo "start to backup database"
echo "start to backup database">>$logfile
sh $app_dir/bin/backupAppDB.sh $db_name
######### stop app #########
echo "start to stop app"
echo "start to stop app">>$logfile
sh $app_dir/stopApp.sh
######### start to update resource #########
updateSql=/tmp/update.sql
echo "########### execute resource sql list #########"
echo "update sys_config set value='$t' where code='system.cachekey';"                            >$updateSql
#echo "drop table sys_config_$t;"                                                                 >>$updateSql
#echo "create table sys_config_$t as select * from sys_config;"                                   >>$updateSql
echo "drop table sys_resourze_$t;"                                                                >>$updateSql
echo "create table sys_resourze_$t as select * from sys_resourze;"                                >>$updateSql
echo "delete from sys_resourze where 1=1;"                                                        >>$updateSql
echo "insert into sys_resourze select * from $db_update_name.sys_resourze;"                       >>$updateSql
echo "drop table sys_menu_$t;"                                                                    >>$updateSql
echo "create table sys_menu_$t as select * from sys_menu;"                                        >>$updateSql
echo "delete from sys_menu where 1=1;"                                                            >>$updateSql
echo "insert into sys_menu select * from $db_update_name.sys_menu;"                               >>$updateSql
echo "drop table sys_menu_resource_$t;"                                                           >>$updateSql
echo "create table sys_menu_resource_$t as select * from sys_menu_resource;"                      >>$updateSql
echo "delete from sys_menu_resource where 1=1;"                                                   >>$updateSql
echo "insert into sys_menu_resource select * from $db_update_name.sys_menu_resource;"             >>$updateSql
echo "update sys_menu a set hidden=1 where a.id in (select id from sys_menu_$t where hidden=1);"  >>$updateSql
echo "update sys_resourze set access_type='LOGIN';">>$updateSql
echo "update resource sql list:">>$logfile
cat $updateSql>>$logfile
echo "start to load update.sql">>$logfile
sh $app_dir/bin/runSql.sh $updateSql $db_name
echo "restart app">>$logfile
sh $app_dir/restartApp.sh
echo "########### update finish #########"
echo "########### update finish #########">>$logfile
echo "">>$logfile
echo ""
exit 0

select * from information_schema.tables where  table_schema='foxnic' order by table_rows desc
delete from sys_job_log where 1=1;
delete from ddelete from sys_licence_free_full;
delete from sys_licence_free_sta;
insert into sys_licence_free_full select * from sys_licence;
insert into sys_licence_free_sta select * from sys_licence;