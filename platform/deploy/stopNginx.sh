#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
cd $cur_dir
if [[ -f ./nginx/sbin/nginx ]];then
  if [[ -f ./nginx/logs/nginx.pid ]];then
      echo "to stop nginx"
      ./nginx/sbin/nginx -s stop
  else
      echo "nginx is not running"
  fi
else
  echo "nginx not install"
  exit 1
fi
exit 0
