#!/bin/sh
##########################################
#os:redhat7.9
#tomcat:mysql5.7.43
#version 1.2.3 modify at 20210412
#sh deploy_mysql.sh mysql.tar.gz /app/mysql P@ssw0rd123456
##########################################
mysqlsoft="mysql-5.7.32-linux-glibc2.12-x86_64.tar.gz"
mysqldir="/app/mysql"
mysqlpwd="P@ssw0rd123456"
MYSQL_PORT=3306
MYSQL_CNF=/etc/my.cnf
MYSQL_SOCK_NAME=mysql.sock
########################################
#Deploy Mysql
########################################
echo "start to deploy mysql"
if [[ -n $1 ]];then
	mysqlsoft=$1
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
if [[ ! -f $mysqlsoft ]];then
	echo "Deply Soft Match Failed"
	exit 1
fi
if [[ -d $mysqldir ]];then
	echo "deploy error,mysqldir:$mysqldir exist,please remove it first."
	exit 1
fi
glibcnt=`strings /lib64/libc.so.6|grep GLIBC|grep 2.12|wc -l`
if [[ $glibcnt -eq 0 ]];then
	echo "GLIBC 2.12 Match Failed"
	exit 1
fi
ifx86=`cat /proc/version|grep x86_64|wc -l`
if [[ $ifx86 -eq 0 ]];then
	echo "Linux x86_64 Match Failed"
	exit 1
fi

id mysql
userCK=`echo $?`
if [[ $userCK -eq 1 ]];then
  groupadd mysql
  useradd -r -g mysql mysql
  mkdir -p /home/mysql
  chown mysql:mysql /home/mysql
  chmod 755 /home/mysql
  usermod -s /bin/bash mysql
  echo 'P@ssw0rd123456' |passwd --stdin mysql
fi

#pre linux setting
sed -i 's/SELINUX=enforcing/SELINUX=disabled/' /etc/selinux/config
systemctl stop      firewalld.service
systemctl disable   firewalld.service
systemctl stop 		postfix.service
systemctl disable   postfix.service
sed -i '/nofile/d' /etc/rc.d/rc.local
sed -i '/nproc/d' /etc/rc.d/rc.local
echo "* soft nofile 65536 ">>/etc/security/limits.conf
echo "* hard nofile 65536 ">>/etc/security/limits.conf
echo "* soft nproc 65536 ">>/etc/security/limits.conf
echo "* hard nproc 65536 ">>/etc/security/limits.conf
#pre install
echo "yum -y install nc libaio unzip zip telnet net-tools wget java numactl"
yum -y install nc libaio unzip zip telnet net-tools wget java numactl >/dev/null
echo "yum -y install glibc-*"
yum -y install glibc-* >/dev/null
#strings command need it
echo "yum -y install binutils*base*x86_64"
yum -y install binutils*base*x86_64 >/dev/null
#centos 8.0
echo "yum -y install libncurses*"
yum -y install libncurses* >/dev/null
#pre dir
mkdir -p $mysqldir
mkdir -p ${mysqldir}/data
#chown -R mysql:mysql /usr/local/mysql
if [[ -f "/etc/my.cnf" ]];then
  d=`date "+%Y_%m_%d_%H_%M_%S"`
  mv /etc/my.cnf /etc/my.cnf.$d
fi
mycnftmp="/tmp/my.cnf.tmp"
mkdir -p /usr/local/mysql
innodb_buffer_pool_size=1024;
total_mem=`free -m|grep Mem|awk '{print $2}'`
innodb_buffer_pool_size_pre=`echo "$total_mem"|awk '{printf "%d",$1*0.5*0.75}'`
#<2048
if [[ $total_mem -lt 2048 ]];then
  innodb_buffer_pool_size=512
fi
#2048<=v<4096
if [[ $total_mem -ge 2048 && $total_mem -lt 4096 ]];then
  innodb_buffer_pool_size=1024
fi
#4096<=v<8192
if [[ $total_mem -ge 4096 && $total_mem -lt 8192 ]];then
  innodb_buffer_pool_size=2048
fi
#8192<=v<16384
if [[ $total_mem -ge 8192 && $total_mem -lt 16384 ]];then
  innodb_buffer_pool_size=$innodb_buffer_pool_size_pre
fi
#v>16384
if [[ $total_mem -ge 16384 ]];then
  innodb_buffer_pool_size=8192
fi
echo "setting innodb_buffer_pool_size value:${innodb_buffer_pool_size}m"
cat > $mycnftmp <<EOF
[mysqld]
lower_case_table_names = 1
max_allowed_packet = 100M
basedir=/usr/local/mysql
datadir=/usr/local/mysql/data
pid-file=/usr/local/mysql/mysqld.pid
socket=/usr/local/mysql/mysql.sock
log-error=/usr/local/mysql/mysqld.log
lc-messages=en_US
lc-messages-dir=/usr/local/mysql/share
symbolic-links=0
port=$MYSQL_PORT
sql_mode='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION'
[client]
default-character-set=utf8
socket=/usr/local/mysql/mysql.sock
[mysql]
default-character-set=utf8
socket=/usr/local/mysql/mysql.sock
[mysqld]
server_id=1
log-bin=mysql-bin
expire_logs_days=3
binlog-format=ROW
binlog_cache_size=128m
max_binlog_cache_size=512m
max_binlog_size=256m
max_connections=1000
max_connect_errors=2000
max_allowed_packet=256M
skip-external-locking
skip-name-resolve
init_connect='set names utf8'
character-set-server=utf8
skip-character-set-client-handshake
slow_query_log=on
slow_query_log=1
long_query_time=3
slow_query_log_file=/usr/local/mysql/mysql_slow.log
back_log=500
open_files_limit=65535
connect_timeout=60
wait_timeout=3600
key_buffer_size=512m
interactive_timeout=3600
table_open_cache=2000
max_heap_table_size=10M
tmp_table_size=50M
read_buffer_size=10M
read_rnd_buffer_size=10M
sort_buffer_size=20M
join_buffer_size=20M
thread_cache_size=120
innodb_file_per_table=on
innodb_buffer_pool_instances=8
innodb_io_capacity_max=4000
innodb_io_capacity=2000
innodb_log_file_size=512m
innodb_log_buffer_size=64M
innodb_log_files_in_group=4
innodb_buffer_pool_size=${innodb_buffer_pool_size}m
innodb_open_files=65535
innodb_page_cleaners=8
innodb_lock_wait_timeout=10
innodb_read_io_threads=16
innodb_write_io_threads=16
innodb_flush_log_at_trx_commit=2
EOF
#innodb_buffer_pool_size=75%memory
smysqldir="/usr/local/mysql"
cat $mycnftmp |sed "s:${smysqldir}:${mysqldir}:g">$MYSQL_CNF
cd /tmp
cp $mysqlsoft $mysqldir
cd $mysqldir
echo "tar xvf $mysqlsoft"
tar xvf $mysqlsoft >/dev/null
onedir=`ls -rtl |tail -1 |awk '{print $NF}'`
cd $onedir
mv * ..
cd $mysqldir
chown -R mysql:mysql $mysqldir
rm -rf /tmp/$MYSQL_SOCK_NAME
ln -s $mysqldir/mysql.sock /tmp/$MYSQL_SOCK_NAME
echo "$mysqldir/bin/mysqld  --defaults-file=$MYSQL_CNF --initialize-insecure --user=mysql --basedir=$mysqldir --datadir=$mysqldir/data"
$mysqldir/bin/mysqld  --defaults-file=$MYSQL_CNF --initialize-insecure --user=mysql --basedir=$mysqldir --datadir=$mysqldir/data
echo "start mysql command list:"
echo "nohup $mysqldir/bin/mysqld_safe --defaults-file=$MYSQL_CNF &"
echo "start mysql"
su - mysql -c "nohup $mysqldir/bin/mysqld_safe --defaults-file=$MYSQL_CNF &"
sleep 5
echo "modify root password"
echo "use mysql;">init.sql
echo "update mysql.user set authentication_string=password('$mysqlpwd') where user='root' and Host = 'localhost';">>init.sql
echo "grant all privileges on *.* to 'root'@'%' identified by '$mysqlpwd' with grant option;">>init.sql
echo "flush privileges;">>init.sql
$mysqldir/bin/mysql -uroot -S/tmp/$MYSQL_SOCK_NAME <init.sql
rm -rf init.sql
chmod +x /etc/rc.d/rc.local
chown mysql:mysql $MYSQL_CNF
echo "add rc.local"
sed -i '/mysql/d' /etc/rc.d/rc.local
echo "sleep 10">> /etc/rc.d/rc.local
echo "#to start mysql">>/etc/rc.d/rc.local
echo "su - mysql -c \"cd /tmp/;nohup $mysqldir/bin/mysqld_safe &\"">> /etc/rc.d/rc.local
chmod +x /etc/rc.d/rc.local
cat /etc/rc.d/rc.local
chown -R mysql:mysql $mysqldir
echo "add mysql environment"
#add env
if [[ -f /root/.bash_profile ]];then
  echo "PATH=$mysqldir/bin:\$PATH">>/root/.bash_profile
  echo "export PATH">>/root/.bash_profile
fi
if [[ -d "/home/mysql" ]];then
  echo "PATH=$mysqldir/bin:\$PATH">>/home/mysql/.bash_profile
  echo "export PATH">>/home/mysql/.bash_profile
fi
echo "deploy success!"
