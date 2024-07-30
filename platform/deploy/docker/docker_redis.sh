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
docker_image_flag=fapp_redis_${docker_image_version}

echo "docker image:$docker_image_flag"
##生成Dockerfile文件
cat << EOF > Dockerfile
FROM registry.cn-hangzhou.aliyuncs.com/lank/redis:s_5.0.14
MAINTAINER REDIS
EOF

##build 生成image
docker build ./ -t registry.cn-hangzhou.aliyuncs.com/lank/redis:$docker_image_flag

if [[ -f Dockerfile ]];then
  rm -rf Dockerfile
fi

exit 0
