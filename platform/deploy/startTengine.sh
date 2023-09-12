#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
cd $cur_dir
if [[ -f ./tengine/sbin/nginx ]];then
  if [[ -f ./tengine/logs/nginx.pid ]];then
      echo "tengine is running"
      ./tengine/sbin/nginx -s reload
  else
      ./tengine/sbin/nginx
      echo "tengine start success"
  fi
else
  echo "tengine not install"
  exit 1
fi
exit 0
