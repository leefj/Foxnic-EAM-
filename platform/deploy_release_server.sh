#!/bin/sh
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
echo "if [[ -f \"/opt/tomcat/tomcat_shopprod/webapps/upload/app_release_last.tar.gz\" ]];then    ">>$ops_conf
echo "  rm -rf "/opt/tomcat/tomcat_shopprod/webapps/upload/app_release_last.tar.gz"               ">>$ops_conf
echo "  cp /tmp/app_release_last.tar.gz /opt/tomcat/tomcat_shopprod/webapps/upload/                 ">>$ops_conf
echo " echo \"release success \" ">>$ops_conf
echo "fi   ">>$ops_conf
$JAVA  -jar $ops -e action -n $ops_node_file -c $ops_conf

exit 0








