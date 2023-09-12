#!/bin/sh
#H5:8091
#API:8090
#sh deployNginx.sh
########################################
cur_dir=$(cd `dirname $0`; pwd)
app_dir=$cur_dir/..
app_name=tengine-3.0.0.tar.gz.1
mkdir -p $app_dir/tengine
app_dir=$app_dir/tengine
echo "install tengine,dir:$app_dir"
echo "app dir dir:$app_dir"
function help(){
	echo "cd $app_dir"
	echo "$app_dir/sbin/nginx -s stop"
	echo "rm -rf sbin"
	echo "rm -rf html"
	echo "rm -rf *temp"
	echo "rm -rf logs"
	echo "rm -rf conf"
}
if [[ ! -d $app_dir ]];then
  echo "tengine directory not exist";
  exit 1
fi
if [[ -f $app_dir/conf/nginx.conf ]];then
	echo "tengine already exists!you can remove it,";
	help
	exit 1
fi
nginx_tar=$app_dir/$app_name
yum -y install gcc wget gcc-c++ automake autoconf libtool libxml2-devel libxslt-devel perl-devel perl-ExtUtils-Embed pcre-devel openssl-devel
cd $app_dir
tar xvf $app_name
ng=`ls -rtl |grep tengine-|grep -v tar.gz|grep -v conf|awk '{print $NF}'`
cd $ng
echo "start to install tengine"
./configure --prefix=$app_dir
make && make install
#clear
cd $app_dir
rm -rf $ng
#deploy h5 html
mkdir -p html
mkdir -p cert
h5tar=h5.tar.gz.1
if [[ -f $h5tar ]];then
  cp $h5tar html
  cd html
  tar xvf $h5tar
fi
#deploy h5 html
cd $app_dir
if [[ -f nginx.conf ]];then
  cat nginx.conf>conf/nginx.conf
fi
#start
if [[ -f ./sbin/nginx ]];then
  ./sbin/nginx
else
  echo "tengine install failed,./sbin/nginx not exist"
  exit 1
fi
# 已将startall加入到自启动脚本，此处不需要
#chmod +x /etc/rc.d/rc.local
#sed -i '/nginx/d' /etc/rc.d/rc.local
#echo "$app_dir/sbin/nginx">> /etc/rc.d/rc.local
exit 0
#to clear
./sbin/nginx -s stop
rm -rf sbin
rm -rf html
rm -rf *temp
rm -rf logs
rm -rf conf

