#!/bin/sh
#sh deployRedis.sh /app/app /app/app/redis/redis-5.0.14.tar.gz.1
#port 16379
########################################
cur_dir=$(cd `dirname $0`; pwd)
appdir=$cur_dir/../redis
user=root
port=26379
soft_file=$2
if [[ -n $1 ]];then
	rootdir=$1
	appdir=$rootdir/redis
fi
if [[ ! -f $soft_file ]];then
  echo "soft_file not exist,soft:$soft_file"
  exit 1
fi
cd /tmp
c1=`id $user|wc -l`
if [[ $c1 -eq 0 ]];then
	echo "deploy error,user:$user not exist"
	exit 1
fi
yum -y install gcc lsof psmisc unzip telnet net-tools wget

mkdir -p $appdir
mkdir -p $appdir/{data,logs,etc,run,bin}
sn=`date +%s`
cd $appdir
soft=`ls -rtl |grep redis|grep tar.gz|awk '{print $NF}'`
mkdir redis_$sn
cp $soft redis_$sn
cd redis_$sn
tar xvf $soft
onedir=`ls -rtl |grep -v tar|grep -v gz|grep -v zip |tail -1 |awk '{print $NF}'`
cd $onedir
make
cp redis.conf $appdir/etc
cd src
cp redis-sentinel redis-check-aof redis-benchmark redis-check-rdb redis-cli redis-server $appdir/bin
echo never > /sys/kernel/mm/transparent_hugepage/enabled
sed -i '/vm.overcommit_memory/d' /etc/sysctl.conf
echo "vm.overcommit_memory = 1">>/etc/sysctl.conf
sed -i '/net.core.somaxconn/d' /etc/sysctl.conf
echo "net.core.somaxconn = 1024">>/etc/sysctl.conf
sed -i '/'"$user"'/d' /etc/security/limits.conf
echo "$user soft nofile 65536" >>/etc/security/limits.conf
echo "$user hard nofile 65536" >>/etc/security/limits.conf
echo "$user soft nproc 65536" >>/etc/security/limits.conf
echo "$user hard nproc 65536" >>/etc/security/limits.conf
sysctl -p
cd $appdir/etc
cp redis.conf redis.conf_$sn.bak
sed -i "s@bind 127.0.0.1@bind 0.0.0.0@g"                              			redis.conf
sed -i "s@port 6379@port $port@g"                              			        redis.conf
sed -i "s@daemonize no@daemonize yes@g"                               			redis.conf
sed -i "s@protected-mode yes@protected-mode no@g"                     			redis.conf
sed -i "s@redis_6379.pid@redis_${port}.pid@g"                         			redis.conf
sed -i "s@logfile \"\"@logfile \"$appdir/logs/redis_${port}.log\"@g"      	redis.conf
sed -i "s@dir ./@dir $appdir/data@g"                             				    redis.conf
sed -i "s@redis_6379.pid@redis_${port}.pid@g"                              	redis.conf
cd /tmp
#启动
chmod +x /etc/rc.d/rc.local
sed -i '/redis/d' /etc/rc.d/rc.local
sed -i '/never/d' /etc/rc.d/rc.local
echo "echo never > /sys/kernel/mm/transparent_hugepage/enabled">>/etc/rc.d/rc.local
echo "sleep 5">>/etc/rc.d/rc.local
if [[ $user == "root" ]];then
  echo "nohup $appdir/bin/redis-server $appdir/etc/redis.conf &">>/etc/rc.d/rc.local
  nohup $appdir/bin/redis-server $appdir/etc/redis.conf &
else
  chown -R $user:$user $appdir

  echo "su - $user -c \"cd /tmp;nohup $appdir/bin/redis-server $appdir/etc/redis.conf &\"">>/etc/rc.d/rc.local
  su - $user -c "cd /tmp;nohup $appdir/bin/redis-server $appdir/etc/redis.conf &"
fi
exit 0