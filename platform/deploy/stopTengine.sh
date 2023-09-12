#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
cd $cur_dir
if [[ -f ./tengine/sbin/nginx ]];then
  if [[ -f ./tengine/logs/nginx.pid ]];then
      echo "to stop tengine"
      ./tengine/sbin/nginx -s stop
  else
      echo "tengine is not running"
  fi
else
  echo "tengine not install"
  exit 1
fi
exit 0
