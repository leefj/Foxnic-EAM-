#!/bin/sh

# 从服务器下载最新数据，替换本地数据库压缩文件
cur_dir=$(cd `dirname $0`; pwd)
conf_file=$cur_dir/app.conf
hostname=`hostname`
tmp_dir=`cat $conf_file|grep ${hostname}.ops_dir|awk -F "=" '{print $2}'`
jar_dir=`cat $conf_file|grep ${hostname}.jar_dir|awk -F "=" '{print $2}'`
ops_jar_dir=`cat $conf_file|grep ${hostname}.ops_jar_dir|awk -F "=" '{print $2}'`
ops=$ops_jar_dir/ops.jar.1
ops_node_file="$tmp_dir/ops.node"
JAVA=java
ops_conf="/tmp/ops.conf"
echo "">$ops_conf
echo "sh /app/app/bin/release_db.sh foxnic" >>$ops_conf
#echo "sh /app/app/bin/backupAppDB.sh foxnic" >>$ops_conf

$JAVA  -jar $ops -e action -n $ops_node_file -c $ops_conf

#start download backupfile to /tmp
cat out.txt|tr -d ' '|tr -d '\r'>out.txt.tmp
file=`cat out.txt.tmp|grep tar.gz |awk -F ":" '{print $3}'|grep -v foxnic|grep tar.gz`
echo
if [[ -d "/Users/lankl/IdeaProjects/eam/platform/deploy/bin/sql" ]];then
   cd /Users/lankl/IdeaProjects/eam/platform/deploy/bin/sql
   if [[ -f db.tar.gz ]];then
      echo "start to del db.tar.gz"
      rm -rf db.tar.gz
   fi
fi
echo "start to down"
$JAVA -jar $ops -n $ops_node_file  -sftp download -s $file -df db.tar.gz -dd /Users/lankl/IdeaProjects/eam/platform/deploy/bin/sql
cp /Users/lankl/IdeaProjects/eam/platform/deploy/bin/sql/db.tar.gz /Users/lankl/IdeaProjects/eam/platform/deploy/bin/sql/db.tar.gz.bak
exit 0








