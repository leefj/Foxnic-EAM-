#!/bin/sh

cur_dir=$(cd `dirname $0`; pwd)
app_conf="${cur_dir}/app.conf"
app_dir=$cur_dir/..
backup_dir=$app_dir/backup/db
MYSQL=`cat $app_conf|grep -v "#"|grep MYSQL=|awk -F "=" '{print $2}'`
MYSQL_DUMP=`cat $app_conf|grep -v "#"|grep MYSQL_DUMP=|awk -F "=" '{print $2}'`
DB_NAME=`cat $app_conf|grep -v "#"|grep DB_NAME=|awk -F "=" '{print $2}'`
DB_HOST=`cat $app_conf|grep -v "#"|grep DB_HOST=|awk -F "=" '{print $2}'`
DB_USER=`cat $app_conf|grep -v "#"|grep DB_USER=|awk -F "=" '{print $2}'`
DB_PORT=`cat $app_conf|grep -v "#"|grep DB_PORT=|awk -F "=" '{print $2}'`
DB_PWD=`cat $app_conf|grep DB_PWD=|awk -F "=" '{print $2}'`

cd $cur_dir

#### 备份数据库
echo "备份数据库"
sh /app/app/bin/backupAppDB.sh foxnic

#### 删除数据库
echo "删除临时数据库"
echo "drop database app_docker;" >/tmp/drop_db.sql
sh runSql.sh /tmp/drop_db.sql mysql

#### 创建临时数据库
echo "创建临时数据库"
echo "CREATE DATABASE app_docker DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;" >/tmp/create_db.sql
sh runSql.sh /tmp/create_db.sql mysql

### 导入数据
echo "导入数据"
sh runSql.sh /app/app/backup/db/db.sql app_docker

### 清理数据
echo "清理数据"
sh runSql.sh /app/app/bin/sql/setting_common.sql app_docker
sh runSql.sh /app/app/bin/sql/cleardata.sql app_docker
sh runSql.sh /app/app/bin/sql/common_licence_free.sql app_docker
sh runSql.sh /app/app/bin/sql/setting_eam.sql app_docker

### 备份数据库
echo "备份数据库"
sh /app/app/bin/backupAppDB.sh app_docker


exit 0