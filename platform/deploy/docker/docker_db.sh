#!/bin/sh
#################################################################################
# 任意目录下
#
#################################################################################
cur_dir=$(cd `dirname $0`; pwd)
cd $cur_dir

docker_image_version=2.9.2
if [[ -n $1 ]];then
  docker_image_version=$1
fi
docker_image_flag=fapp_db_${docker_image_version}
echo "docker image:$docker_image_flag"

sh /app/app/bin/release_db.sh foxnic
initSQL=/app/app/backup/db/db.sql
if [[ -f init.sql ]];then
  rm -rf init.sql
fi
cp $initSQL init.sql
cat << EOF > Dockerfile
FROM registry.cn-hangzhou.aliyuncs.com/lank/mysql:s_5.7.42
MAINTAINER DB
ADD init.sql /docker-entrypoint-initdb.d
EOF

docker build ./ -t registry.cn-hangzhou.aliyuncs.com/lank/mysql:$docker_image_flag
if [[ -f init.sql ]];then
  rm -rf init.sql
fi
exit 0




