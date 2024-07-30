#!/bin/sh
#################################################################################
#
#
#################################################################################
cur_dir=$(cd `dirname $0`; pwd)
cd $cur_dir

#全部清理
docker stop app_bpm
docker rm app_bpm
docker stop app_app
docker rm app_app
docker stop app_nginx
docker rm app_nginx
docker stop app_redis
docker rm app_redis
#docker stop app_minio
#docker rm app_minio
docker stop app_mysql
docker rm app_mysql
rm -rf /app/docker/
echo "clear finish"

docker images|grep fapp_|awk '{print "docker rmi " $3}'>/tmp/rmimage.sh
sh /tmp/rmimage.sh

sh build.sh

cd $cur_dir
docker network rm app_app_docker_network
docker-compose up -d

exit 0

