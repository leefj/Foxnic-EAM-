#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
cd $cur_dir
if [[ -f ./nginx/sbin/nginx ]];then
  if [[ -f ./nginx/logs/nginx.pid ]];then
      echo "nginx is running"
      ./nginx/sbin/nginx -s reload
  else
      ./nginx/sbin/nginx
      echo "nginx start success"
  fi
else
  echo "nginx not install"
  exit 1
fi
exit 0
