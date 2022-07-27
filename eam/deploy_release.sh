#!/bin/sh
#

release_dir="/tmp/app_deploy"
hostname=`hostname`
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

echo "$release_dir/app/app/lib/"
ls -rtl $jar_dir/lib/

cp -r $jar_dir/lib/* $release_dir/app/app/lib/
cp $jar_dir/wrapper-all-0.0.2.RELEASE.jar  $release_dir/app/app/app.jar

#cp -r $jar_dir/lib/* $release_dir/app/bpm/lib/
cp  $bpm_jar_dir/wrapper-camunda-0.0.2.RELEASE.jar $release_dir/app/bpm/bpm.jar

tar -zcvf app_release_last.tar.gz ./*
open .
exit 0










