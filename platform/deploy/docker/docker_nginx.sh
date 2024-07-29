#!/bin/sh
#################################################################################
# /app/app/tengine目录下
#
#################################################################################
cur_dir=$(cd `dirname $0`; pwd)
cd $cur_dir


docker_image_version=2.9.2
if [[ -n $1 ]];then
  docker_image_version=$1
fi
docker_image_flag=fapp_nginx_${docker_image_version}
echo "docker image:$docker_image_flag"

app_ip=16.88.88.88
app_port=8089
app_api=http://${app_ip}:${app_port}

##生成Dockerfile文件
cat << EOF > nginx_docker.conf

worker_processes  2;
events {
    worker_connections  1024;
}
http {
    include       mime.types;
    default_type  application/octet-stream;
    client_max_body_size 50m;
    sendfile        on;
    keepalive_timeout  65;
    server {
        listen       12345;
        server_name  localhost;
        location / {
            root   html;
            index  index.html index.htm;
        }
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }
    }
    server {
        listen 8090 ssl;
        server_name app.com;
        keepalive_timeout 60;
        ssl_certificate /nginx/cert/8803285_app.com.pem;
        ssl_certificate_key /nginx/cert/8803285_app.com.key;
        ssl_session_timeout 5m;
        ssl_ciphers ECDHE-RSA-AES128-GCM-SHA256:ECDHE:ECDH:AES:HIGH:!NULL:!aNULL:!MD5:!ADH:!RC4;
        location / {
          proxy_pass $app_api;
          proxy_redirect http:// https://;
          proxy_set_header Host \$host:\$server_port;
          proxy_set_header X-Real-IP \$remote_addr;
          proxy_set_header X-Forwarded-For \$proxy_add_x_forwarded_for;
        }
    }
    server {
        #nginx status
        listen *:8899 default_server;
        server_name app.com;
        location /ngx_status {
            stub_status on;
            access_log on;
            #allow 127.0.0.1;
            #deny all;
          }
    }
    server {
        listen 8091 ssl;
        server_name app.com;
        root  /nginx/html;
        index index.html index.htm;
        ssl_certificate /nginx/cert/8803285_app.com.pem;
        ssl_certificate_key /nginx/cert/8803285_app.com.key;
        ssl_session_timeout 5m;
        ssl_ciphers ECDHE-RSA-AES128-GCM-SHA256:ECDHE:ECDH:AES:HIGH:!NULL:!aNULL:!MD5:!ADH:!RC4;
        ssl_prefer_server_ciphers on;
        location / {
            index index.html index.htm;
            proxy_set_header HOST \$host;
            proxy_set_header X-Real-IP \$remote_addr;
            proxy_set_header X-Forwarded-FOR \$proxy_add_x_forwarded_for;
         }
        location /service  { proxy_pass $app_api;}
        location /security { proxy_pass $app_api;}
    }
}

EOF

##生成Dockerfile文件
cp cert/8803285_app.com.pem 8803285_app.com.pem
cp cert/8803285_app.com.key 8803285_app.com.key

cat << EOF > Dockerfile
FROM registry.cn-hangzhou.aliyuncs.com/lank/nginx:s_1.21.5
MAINTAINER NGINX
RUN mkdir -p              /nginx/cert
RUN mkdir -p              /nginx/html
COPY nginx_docker.conf    /etc/nginx/nginx.conf
ADD 8803285_app.com.pem   /nginx/cert
ADD 8803285_app.com.key   /nginx/cert
ADD html                  /nginx/html
EOF

##build 生成image
docker build ./ -t registry.cn-hangzhou.aliyuncs.com/lank/nginx:$docker_image_flag
exit 0



