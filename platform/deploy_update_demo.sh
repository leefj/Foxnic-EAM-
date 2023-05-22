#!/bin/sh

# 更新demo
# 更新Demo数据库
# 从服务器上/tmp/app_release_last.tar.gz更新程序
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
echo "if [[ ! -f \"/tmp/app_release_last.tar.gz\" ]];then                                          ">>$ops_conf
echo "  echo \"file not found,failed\"                                                           ">>$ops_conf
echo "  exit 1                                                                                  ">>$ops_conf
echo "fi                                                                                          ">>$ops_conf
echo "sh /app/app/bin/deployDemoDbFromDev.sh  ">>$ops_conf
echo "sleep 1  ">>$ops_conf
echo "cd  /tmp">>$ops_conf
echo "ctime=`date +%Y%m%d_%H_%M_%S`">>$ops_conf
echo "mkdir /tmp/\$ctime">>$ops_conf
echo "cp /tmp/app_release_last.tar.gz /tmp/\$ctime">>$ops_conf
echo "cd  /tmp/\$ctime/">>$ops_conf
echo "tar xvf app_release_last.tar.gz">>$ops_conf
echo "cd  /tmp/\$ctime/bin/">>$ops_conf
echo "sh deployAppUpdate.sh">>$ops_conf
echo "cd /tmp">>$ops_conf
echo "rm -rf /tmp/\$ctime">>$ops_conf
$JAVA  -jar $ops -e action -n $ops_node_file -c $ops_conf
exit 0








