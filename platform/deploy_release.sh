#!/bin/sh
cd /Users/lankl/IdeaProjects/eam/platform
MVN=/Users/lankl/.m2/wrapper/dists/apache-maven-3.5.3-bin/2c22a6s60afpuloj4v181qvild/apache-maven-3.5.3/bin/mvn
$MVN clean
$MVN install
version=2.7.0.6
# 本地打包
release_dir="/tmp/app_deploy"
method="local"
hostname=""
if [[ -n "$1" ]];then
  hostname=$1
  method="ops"
  release_dir="/root/workspace/eam_deploy/out"
  mkdir -p /root/workspace/eam_deploy/out
else
  hostname=`hostname`
fi
echo "hostname:$hostname"

cur_dir=$(cd `dirname $0`; pwd)
conf_file=$cur_dir/app.conf
jar_dir=`cat $conf_file|grep ${hostname}.jar_dir|awk -F "=" '{print $2}'`
bpm_jar_dir=`cat $conf_file|grep ${hostname}.bpm_jar_dir|awk -F "=" '{print $2}'`
deploy_dir=`cat $conf_file|grep ${hostname}.deploy_dir|awk -F "=" '{print $2}'`
if [[ -d $release_dir ]];then
  rm -rf $release_dir
fi
mkdir -p $release_dir
echo "jar_dir:$jar_dir"
echo "deploy_dir:$deploy_dir"
echo "conf_file:$conf_file"
echo "release_dir:$release_dir"
cd $release_dir
cp -r $deploy_dir/* .

# process app.jar
echo "$release_dir/app/lib/"
mkdir -p $release_dir/app/lib/
ls -rtl $jar_dir/lib/
cp -r $jar_dir/lib/* $release_dir/app/lib/
cp $jar_dir/wrapper-all-${version}.jar  $release_dir/app/app.jar

# process bpm.jar
#cp -r $jar_dir/lib/* $release_dir/app/bpm/lib/
ls $bpm_jar_dir/wrapper-camunda-${version}.jar
ls $release_dir/bpm
cp $bpm_jar_dir/wrapper-camunda-${version}.jar $release_dir/bpm/bpm.jar
echo "start to ys"
tar -zcvf app_release_last.tar.gz ./*
if [[ $method == "local" ]];then
  open .
fi

#upload
exit 0





