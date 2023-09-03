#!/bin/sh
###################################
#os:redhat7.9
#tomcat:1.24.1
#version 1.2.3 modify at 20210412
#sh deploy_nginx.sh nginx.tar.gz /app/nginx nginx
###################################
soft=$1
nginxdir=$2
user=$3
if [[ -d $nginx ]];then
	echo "deploy error,nginxdir exist,please remove first"
	exit 1
fi
cd /tmp
if [[ ! -f $soft ]];then
	echo "deploy error,soft not exist"
	exit 1
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
echo "yum -y install gcc wget gcc-c++ automake autoconf libtool libxml2-devel libxslt-devel perl-devel perl-ExtUtils-Embed pcre-devel openssl-devel"
yum -y install gcc wget gcc-c++ automake autoconf libtool libxml2-devel libxslt-devel perl-devel perl-ExtUtils-Embed pcre-devel openssl-devel>/dev/null
#pre create user
id $user
userCK=`echo $?`
if [[ $userCK -eq 1 ]];then
  echo "create user $user"
  groupadd $user
  useradd -g $user -m -d /home/$user $user
  echo 'P@ssw0rd123456' |passwd --stdin $user
fi
sn=`date +%s`
tempdir="nginx.$sn"
mkdir $tempdir
cp $soft $tempdir
cd $tempdir
echo "tar xvf $soft"
tar xvf $soft>/dev/null
onedir=`ls -rtl |grep -v tar|grep -v gz|grep -v zip |tail -1 |awk '{print $NF}'`
cd $onedir
mkdir -p $nginxdir
echo "./configure --prefix=$nginxdir"
./configure --prefix=$nginxdir >/dev/null
make
make install
chown -R $user:$user $nginxdir
sed -i 's/80/7799/g' $nginxdir/conf/nginx.conf
echo "add rc.local"
sed -i '/nginx/d' /etc/rc.d/rc.local
echo "su - $user -c \"$nginxdir/sbin/nginx -c $nginxdir/conf/nginx.conf\"">>/etc/rc.d/rc.local
su - $user -c "$nginxdir/sbin/nginx -c $nginxdir/conf/nginx.conf"
echo "deploy success!"
exit 0