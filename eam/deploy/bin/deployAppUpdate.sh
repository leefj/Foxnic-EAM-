#!/bin/sh
prod_app_dir=/app/app
cur_dir=$(cd `dirname $0`; pwd)
app_dir=$cur_dir/..
echo "cur_dir:$cur_dir"
if [[ ! -d "$prod_app_dir/app/app/lib" ]];then
  echo "directory config error"
  exit 1
fi
if [[ -f "$prod_app_dir/app/app/app.jar" ]];then
  cd $app_dir/app/app
  echo "cp app.jar $prod_app_dir/app/app/"
  cp app.jar $prod_app_dir/app/app/
else
  echo "app.jar error"
  exit 1
fi
cd $app_dir/app/app/lib/
echo "cp * $prod_app_dir/app/app/lib"
cp * $prod_app_dir/app/app/lib
cd $prod_app_dir
sh restartApp.sh
exit 0
