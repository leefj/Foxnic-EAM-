#!/bin/sh
##############################################################################################
#version 1.2.5 modify at 20231031
#
#	suport db version:mysql 8.0.x
#	support os version:Redhat 7.9
#
#	sh deploy_mysql8_cmd.sh mysql-8.0.35-linux-glibc2.17-x86_64.tar /app P@ssw0rd654321
##########################################################################################
mysqlsoft="mysql-8.0.35-linux-glibc2.17-x86_64.tar"
mysqldir="/db"
mysqlpwd=$3
########################################
#deploy mysql
########################################
echo "start to deploy mysql"
mysqldir="/db"
soft="soft.tar.gz"
mycnf="/etc/my.cnf"
port=3308
#################################### some base check
if [[ -n $1 ]];then
	soft=$1
else
	echo "deploy error!parameter failed"
	exit 1
fi
if [[ -n $2 ]];then
	mysqldir=$2
else
	echo "deploy error!parameter failed"
	exit 1
fi
if [[ -n $3 ]];then
	mysqlpwd=$3
else
	echo "deploy error!parameter failed"	
	exit 1
fi
cd /tmp/
if [[ ! -f $soft ]];then
	echo "Deply Soft Match Failed"
	exit 1
fi
glibcnt=`strings /lib64/libc.so.6|grep GLIBC|grep 2.17|wc -l`
if [[ $glibcnt -eq 0 ]];then
	echo "GLIBC 2.17 Match Failed"
	exit 1
fi
libcntck=`getconf GNU_LIBC_VERSION|grep 2.17|wc -l`
if [[ $libcntck -eq 0 ]];then
	echo "GLIBC 2.17 Match Failed"
	exit 1
fi
ifx86=`cat /proc/version|grep x86_64|wc -l`
if [[ $ifx86 -eq 0 ]];then
	echo "Linux x86_64 Match Failed"
	exit 1
fi
if [[ -d $mysqldir ]];then
	echo "$mysqldir is exist"
else
	echo "$mysqldir is not exist"
	exit 1
fi
if [[ -d "${mysqldir}/mysql" ]];then
	echo "${mysqldir}/mysql exists deploy failed,Please remove it first!"
	exit 1
fi
if [[ -d "${mysqldir}/mysql_data" ]];then
	echo "${mysqldir}/mysql_data,exists deploy failed,Please remove it first!"
	exit 1
fi
if [[ -d "${mysqldir}/mysql/data" ]];then
	echo "${mysqldir}/mysql/data exists deploy failed,Please remove it first!"
	exit 1
fi
################## base lib setup
yum -y install libaio numactl zlib openssl cmake
yum -y install unzip telnet net-tools wget
yum -y install glibc-*
mariadbCnt=`rpm -qa|grep mariadb-libs-5|grep "el7.x86_64"|wc -l`
mariadb=   `rpm -qa|grep mariadb-libs-5|grep "el7.x86_64"|awk '{print $NF}'`
if [[ $mariadbCnt -eq 1 ]];then
	echo "start to remove mariadb libs"
	rpm -e --nodeps $mariadb
fi
numactlCnt=`rpm -qa|grep numactl|wc -l`
if [[ $numactlCnt -eq 0 ]];then
	echo "please install numactl rpm first!,check yum is right!"
	exit 1
fi
#################################### user and direcotry create
user=mysql
groupadd $user
useradd -d /home/$user -r -g $user $user
echo 'P@ssw0rd123456' |passwd --stdin $user
if [[ -d "/home/$user" ]];then
	chmod 755 /home/$user
	chown $user:$user /home/$user
else 
	mkdir -p /home/$user
	chmod 755 /home/$user
	chown $user:$user /home/$user
fi
mkdir -p ${mysqldir}/mysql/data
chown -R $user:$user ${mysqldir}/mysql/data
#################################### os parameter config
echo "start to config os parameter"
if [[ -f "/etc/security/limits.conf" ]];then
	sed -i '/'"$user"'/d' /etc/security/limits.conf
	echo "$user soft nofile 65535 ">>/etc/security/limits.conf
	echo "$user hard nofile 65535 ">>/etc/security/limits.conf
	echo "$user soft nproc 16384 ">>/etc/security/limits.conf
	echo "$user hard nproc 65536 ">>/etc/security/limits.conf
	sed -i '/'"root soft"'/d' /etc/security/limits.conf
	sed -i '/'"root hard"'/d' /etc/security/limits.conf
	echo "root soft nofile 65535 ">>/etc/security/limits.conf
	echo "root hard nofile 65535 ">>/etc/security/limits.conf
	echo "root soft nproc 16384 ">>/etc/security/limits.conf
	echo "root hard nproc 65536 ">>/etc/security/limits.conf
fi
sed -i '/'"fs.nr_open"'/d' 	/etc/sysctl.conf
sed -i '/'"fs.file-max"'/d' /etc/sysctl.conf
echo "fs.nr_open=10000000">>/etc/sysctl.conf
echo "fs.file-max=10000000">>/etc/sysctl.conf
sysctl -p
#################################### start to install
cd /tmp
if [[ -f $mycnf ]];then
	d=`date "+%Y_%m_%d_%H_%M_%S"`
	mv $mycnf ${mycnf}_${d}
fi
#################################### start to create my.cnf
mycnftmp="/tmp/my.cnf.tmp"
innodb_buffer_pool_size=1024;
total_mem=`free -m|grep Mem|awk '{print $2}'`
innodb_buffer_pool_size_pre=`echo "$total_mem"|awk '{printf "%d",$1*0.4}'`
#<2048
if [[ $total_mem -lt 2048 ]];then
	innodb_buffer_pool_size=1024
else
	#2048<=v<4096
	innodb_buffer_pool_size=$innodb_buffer_pool_size_pre
fi
echo "setting innodb_buffer_pool_size value:${innodb_buffer_pool_size}m"
cat > $mycnftmp <<EOF
[mysql]
# 默认字符集
default-character-set=utf8mb4
[client]
port=$port
socket=/db/mysql/mysql.sock
[mysqld]
port=$port
server-id=1
user=mysql
socket=/db/mysql/mysql.sock
# 安装目录
basedir=/db/mysql 
# 数据存放目录
datadir=/db/mysql_data
log-bin=/db/mysql_data/mysql-bin
innodb_data_home_dir=/db/mysql_data
innodb_log_group_home_dir=/db/mysql_data
# 关闭mysqlX
mysqlx=0
# 日志及进程数据的存放目录
log-error=/db/mysql/mysqld.log
pid-file=/db/mysql/mysqld.pid
# 慢查询开启
slow_query_log=1
slow_query_log_file=/db/mysql/slow.log
long_query_time=5
# 服务端字符集
character-set-server=utf8mb4
lower_case_table_names=1
autocommit=1
sql_mode=STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION
##### 以上涉及文件夹明，注意修改
skip-external-locking
key_buffer_size=256M
max_allowed_packet=1M
table_open_cache=1024
sort_buffer_size=4M
net_buffer_length=8K
read_buffer_size=4M
read_rnd_buffer_size=512K
myisam_sort_buffer_size=64M
thread_cache_size=128
#query_cache_size=128M
tmp_table_size=128M
explicit_defaults_for_timestamp=true
# 连接数
max_connections=1000
max_connect_errors=500
open_files_limit=65535
# 日志
#binlog_format=mixed
#10 days
binlog_expire_logs_seconds=864000
max_binlog_size=1024M
# 创建表时使用的默认存储引擎
default_storage_engine=InnoDB
innodb_data_file_path=ibdata1:10M:autoextend
#默认 innodb_buffer_pool_chunk_size*innodb_buffer_pool_instances
innodb_buffer_pool_size=${innodb_buffer_pool_size}M
# 该参数已过期，动态调整
#innodb_log_file_size=256M
innodb_log_buffer_size=8M
innodb_flush_log_at_trx_commit=1
innodb_lock_wait_timeout=50
transaction-isolation=READ-COMMITTED
# 关闭ssl
skip_ssl
[mysqldump]
quick
max_allowed_packet=16M
[myisamchk]
key_buffer_size=256M
sort_buffer_size=4M
read_buffer=2M
write_buffer=2M
[mysqlhotcopy]
interactive-timeout
EOF
smysqldir="/db"
cat $mycnftmp |sed "s:${smysqldir}:${mysqldir}:g">$mycnf
mysql_soft_dir=$mysqldir/soft_`date "+%H%M%S"`
#mysql_soft_dir=$mysqldir/mysql`
mkdir -p $mysql_soft_dir
cp $soft $mysql_soft_dir
cd $mysql_soft_dir
tar xvf $soft
rm -rf $soft
mysql_xz=`ls -rtl |grep -v router|grep -v test|grep xz|awk '{print $NF}'`
tar -xvf $mysql_xz
softdir=`ls -rtl |tail -1|awk '{print $NF}'`
if [[ -d $mysqldir/mysql ]];then
	d=`date "+%Y%m%d%H%M%S"`
	mv $mysqldir/mysql $mysqldir/mysql_$d
fi 
mv $softdir $mysqldir/mysql
cd $mysqldir/mysql
chown -R $user:$user $mysqldir/mysql
cd $mysqldir/mysql/bin
echo "./mysqld --defaults-file=$mycnf --basedir=$mysqldir/mysql --datadir=$mysqldir/mysql_data --user=mysql --initialize-insecure"
./mysqld --defaults-file=$mycnf --basedir=$mysqldir/mysql --datadir=$mysqldir/mysql_data --user=mysql --initialize-insecure
echo "nohup $mysqldir/mysql/bin/mysqld_safe &"
cd /tmp
su - $user -c "nohup $mysqldir/mysql/bin/mysqld_safe &"
sleep 10

#配置数据库
echo "use mysql ;">init.sql
echo "alter user 'root'@'localhost' identified with mysql_native_password by '$mysqlpwd' ;" >>init.sql
echo "grant all privileges on *.* to root@'localhost' with grant option ;" >>init.sql
echo "flush privileges ;">>init.sql
$mysqldir/mysql/bin/mysql -uroot <init.sql
rm -rf init.sql

#开启root访问
rootRemote=1
if [[ $rootRemote -eq 1 ]];then
	echo "use mysql;" >remote.sql
	echo "update user set host='%' where user='root';" >>remote.sql
	echo "flush privileges ;">>remote.sql
	$mysqldir/mysql/bin/mysql -uroot -p${mysqlpwd}<remote.sql
	echo "grant all privileges on *.* to root@'%' with grant option ;" >remote.sql
	echo "flush privileges ;">>remote.sql
	$mysqldir/mysql/bin/mysql -uroot -p${mysqlpwd}<remote.sql
	rm -rf remote.sql
fi

#create dbmonitor user
echo "create user 'dbmonitor'@'%' identified with mysql_native_password by 'Ndhb@P@ssw0rdMon123';">create_monitor_user.sql
echo "grant replication client,process,show databases,show view on *.* to 'dbmonitor'@'%'; ">>create_monitor_user.sql
echo "flush privileges;" >>create_monitor_user.sql
$mysqldir/mysql/bin/mysql -uroot -p${mysqlpwd}<create_monitor_user.sql
rm -rf create_monitor_user.sql

#create app user and db
echo "create database appdb charset utf8 ;">app.sql
echo "create user 'app'@'%' identified with mysql_native_password by 'P@ssw0rdPpaN321';">>app.sql
echo "grant all privileges on appdb.* to app@'%' with grant option ;">>app.sql
echo "flush privileges;" >>app.sql
$mysqldir/mysql/bin/mysql -uroot -p${mysqlpwd}<app.sql
rm -rf app.sql

#################################### start to modify reboot and env
echo "start to modify reboot and env"
chmod +x /etc/rc.d/rc.local
chown $user:$user $mycnf
chown $user:$user $mysqldir/mysql
chown $user:$user $mysqldir/mysql_data
sed -i '/mysql/d' /etc/rc.d/rc.local
echo "su - $user -c \"nohup $mysqldir/mysql/bin/mysqld_safe &\"">> /etc/rc.d/rc.local
echo "PATH=$mysqldir/mysql/bin:\$PATH:\$HOME/bin">>/root/.bash_profile
echo "export PATH">>/root/.bash_profile
if [[ ! -d "/home/$user" ]];then
	mkdir -p "/home/$user"
	chown $user:$user /home/$user
fi
echo "PATH=$mysqldir/mysql/bin:\$PATH:\$HOME/bin">>/home/$user/.bash_profile
echo "export PATH">>/home/$user/.bash_profile
cat /etc/rc.d/rc.local
exit 0

#清除安装
ps -ef|grep mysql|grep -v grep|awk '{print $2}'|xargs kill -9
rm -rf /db/mysql
rm -rf /db/mysql_data

#连接数据库
mysql -uroot -pNdhb@Passw0rd

#创建数据库及用户
create database appdb charset utf8 ;
create user app identified with mysql_native_password by 'XXXXXXX' ;
grant all privileges on *.* to 'root'@'%'  with grant option;
flush privileges;

#创建监控用户
create user 'dbmonitor'@'%' identified with mysql_native_password by 'XXXXXXX';
grant replication client,process,show databases,show view on *.* to 'dbmonitor'@'%';
flush privileges;
