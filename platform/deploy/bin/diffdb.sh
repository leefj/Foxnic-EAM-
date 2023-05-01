#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
cd $cur_dir/java/diffdb
if [[ -f "changeOut.sql" ]];then
  rm -rf changeOut.sql
fi
echo "nohup java -jar diffdb.jar.1 &"
java -jar diffdb.jar.1
echo "result file:$cur_dir/java/diffdb/changeOut.sql"
echo "-- content "
if [[ -f $cur_dir/java/diffdb/changeOut.sql ]];then
  cat $cur_dir/java/diffdb/changeOut.sql
fi
exit 0


