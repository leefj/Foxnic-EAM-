#!/bin/sh
#################################################################################
# put /app/app/app目录下
#
#################################################################################
cur_dir=$(cd `dirname $0`; pwd)
cd $cur_dir

docker_image_version=2.9.2
if [[ -n $1 ]];then
  docker_image_version=$1
fi
docker_image_flag=fapp_app_${docker_image_version}
echo "docker image:$docker_image_flag"


###### 修改配置文件
nginx_ip=16.88.88.86
bpm_ip=16.88.88.87
app_ip=16.88.88.88
db_ip=16.88.88.89
redis_ip=16.88.88.90

app_port=8089
bpm_port=8099
db_port=3306
db_name=app
db_user=root
db_pwd=P@ssw0rd123456

##修改application.yml文件
application_yml=application_tpl_docker.yml
if [[ ! -f application_tpl.yml ]];then
  echo "application_tpl.yml not found"
  exit 1
fi
cat application_tpl.yml>$application_yml
sed -i "s/APP_WEB_PORT/$app_port/g"                 $application_yml
sed -i "s/APP_DB_PORT/$db_port/g"                   $application_yml
sed -i "s/APP_DB_NAME/$db_name/g"                   $application_yml
sed -i "s/APP_DB_USERNAME/$db_user/g"               $application_yml
sed -i "s/APP_DB_PASSWORD/$db_pwd/g"                $application_yml
sed -i "s/127.0.0.1:3306/${db_ip}:${db_port}/g"     $application_yml
sed -i "s/127.0.0.1:8089/${app_ip}:${app_port}/g"   $application_yml
sed -i "s/127.0.0.1:8099/${bpm_ip}:${bpm_port}/g"   $application_yml


##生成entrypoint.sh文件
cat << EOF > entrypoint.sh
#!/bin/bash
touch cmd.conf
echo "jdbc:mysql://$db_ip:$db_port/mysql?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf-8|22|root|$db_pwd|key=select count(1) cnt from information_schema.tables where table_schema @eq@ '$db_name' and table_name like '%sys_%'">/mysql.node
#connect check
while true
do
  java -jar /ops.jar -n /mysql.node -mysql connectCheck >/tmp/connect.log
  connectCnt=\`cat /tmp/connect.log |grep 20|wc -l\`
  echo "Current Connect Status:\$connectCnt"
  if [[ \$connectCnt -gt 0 ]];then
    echo "mysql connect success!"
    break;
  fi
  sleep 2
done

#db check
while true
do
  java -jar /ops.jar -n /mysql.node -mysql exec >/tmp/db.log
  dbCnt=\`cat /tmp/db.log |grep -v select|grep cnt|awk -F ':' '{print \$NF}'\`
  echo "Current Table Count Status:\$dbCnt"
  if [[ \$dbCnt -gt 100 ]];then
    echo "mysql table success!"
    break;
  fi
done


tsize=\`du -sm /app/app/app/upload|awk '{print \$1}'\`
if [[ \$tsize -lt 5 ]];then
  cp -r  /app/app/app/upload_source/* /app/app/app/upload
fi
java -noverify -Dfile.encoding=UTF-8 -Djava.io.tmpdir=/app/app/app/tmp -Dloader.path=/app/app/app/lib -jar /app/app/app/app.jar --spring.config.location=/app/app/app/application.yml
EOF


if [[ -f ops.jar ]];then
  rm -rf ops.jar
fi
cp /app/app/bin/ops.jar.1 ops.jar
##生成Dockerfile文件
cat << EOF > Dockerfile
FROM registry.cn-hangzhou.aliyuncs.com/lank/jdk:s_1.8.342
MAINTAINER APP
USER root
RUN mkdir -p         /app/app/app
RUN mkdir -p         /app/app/app/tmp
RUN mkdir -p         /app/app/app/app_logs
RUN mkdir -p         /app/app/app/lib
RUN mkdir -p         /app/app/app/netdisk
RUN mkdir -p         /app/app/app/upload
ADD ops.jar          /ops.jar
ADD app.jar          /app/app/app/app.jar
ADD lib/*.jar        /app/app/app/lib/
ADD upload           /app/app/app/upload_source
ADD $application_yml /app/app/app/application.yml
COPY entrypoint.sh   /entrypoint.sh
RUN chmod +x         /entrypoint.sh
ENTRYPOINT ["/entrypoint.sh"]
EOF

##build 生成image
docker build ./ -t registry.cn-hangzhou.aliyuncs.com/lank/app:$docker_image_flag

exit 0

#docker run -it -v /app/test:/app/app/app/upload  -d docker.io/openjdk:app10
