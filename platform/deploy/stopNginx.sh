#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
cd $cur_dir
if [[ -f ./app/nginx/sbin/nginx ]];then
  if [[ -f ./app/nginx/sbin/logs/nginx.pid ]];then
      ./app/nginx/sbin/nginx -s stop
  fi
else
  echo "nginx not install"
  exit 1
fi
exit 0
