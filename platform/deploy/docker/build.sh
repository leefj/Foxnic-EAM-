#!/bin/sh
#################################################################################
#
#
#################################################################################
cur_dir=$(cd `dirname $0`; pwd)
cd $cur_dir
build_db=1
build_redis=1
build_nginx=1
build_app=1
build_bpm=1
#################################################################################

build_select=""
build_version="2.9.2"

if [[ -n $1 ]];then
  build_select=$1
  build_db=0
  build_redis=0
  build_nginx=0
  build_app=0
  build_bpm=0
else
  echo "sh build.sh all 2.9.2"
  echo "sh build.sh app"
  echo "sh build.sh setv 2.9.3"
  exit 1
fi

if [[ $build_select == "help" ]];then
  echo "sh build.sh all 2.9.2"
  echo "sh build.sh app"
  echo "sh build.sh setv 2.9.3"
  exit 1
fi

if [[ $build_select == "db" ]];then
  build_db=1
fi
if [[ $build_select == "redis" ]];then
  build_redis=1
fi
if [[ $build_select == "nginx" ]];then
  build_nginx=1
fi
if [[ $build_select == "app" ]];then
  build_app=1
fi
if [[ $build_select == "bpm" ]];then
  build_bpm=1
fi
if [[ $build_select == "all" ]];then
  build_db=1
  build_redis=1
  build_nginx=1
  build_app=1
  build_bpm=1
fi

if [[ $build_select == "setv" ]];then
  curV=`cat docker-compose.yml |grep fapp|head -1|awk -F ':' '{print $NF}'|awk -F '_' '{print $NF}'`
  newV=`echo $curV`
  if [[ -n $2 ]];then
    newV=$2
  fi
  echo "curV:$curV,newV:$newV"
  sed -i "s/$curV/$newV/g" docker-compose.yml
  exit 1
fi



if [[ -n $2 ]];then
  build_version=$2
fi
echo "build verson:$build_version"
echo "build_db:$build_db,build_redis:$build_redis,build_nginx:$build_nginx,build_app:$build_app,build_bpm:$build_bpm"

if [[ $build_db -eq 1 ]];then
  echo "build db...."
  cd $cur_dir
  sh docker_db.sh $build_version
fi

if [[ $build_nginx -eq 1 ]];then
  echo "build nginx...."
  cd $cur_dir
  cat docker_nginx.sh>$cur_dir/../tengine/docker_nginx.sh
  cd $cur_dir/../tengine/
  sh docker_nginx.sh $build_version
fi

if [[ $build_app -eq 1 ]];then
  echo "build app...."
  cd $cur_dir
  cat docker_app.sh>$cur_dir/../app/docker_app.sh
  cd $cur_dir/../app/
  sh docker_app.sh $build_version
fi

if [[ $build_bpm -eq 1 ]];then
  echo "build bpm...."
  cd $cur_dir
  cat docker_bpm.sh>$cur_dir/../bpm/docker_bpm.sh
  cd $cur_dir/../bpm/
  sh docker_bpm.sh $build_version
fi

if [[ $build_redis -eq 1 ]];then
  echo "build redis...."
  cd $cur_dir
  sh docker_redis.sh $build_version
fi

exit 0

#删除
docker images|grep fapp_|awk '{print "docker rmi " $3}'


docker images


#push
docker push registry.cn-hangzhou.aliyuncs.com/lank/app:fapp_app_2.9.2
docker push registry.cn-hangzhou.aliyuncs.com/lank/app:fapp_bpm_2.9.2
docker push registry.cn-hangzhou.aliyuncs.com/lank/redis:fapp_redis_2.9.2
docker push registry.cn-hangzhou.aliyuncs.com/lank/mysql:fapp_db_2.9.2
docker push registry.cn-hangzhou.aliyuncs.com/lank/nginx:fapp_nginx_2.9.2

#全部清理
docker stop app_bpm
docker rm app_bpm
docker stop app_app
docker rm app_app
docker stop app_nginx
docker rm app_nginx
docker stop app_redis
docker rm app_redis
docker stop app_minio
docker rm app_minio
docker stop app_mysql
docker rm app_mysql
rm -rf /app/docker/
echo "clear finish"

#启动
docker-compose up -d