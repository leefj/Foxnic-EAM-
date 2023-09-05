#!/bin/sh
####################################
#os:redhat7.9
#tomcat:9.0.80
#sh deploy_tomcat.sh /app/tomcat tomcat.tar.gz tomcat 8080
#user:user_tomcat
#appfile:tomcat.tar.gz
#appdir:/app/tomcat
#appsubdir:tomcat
###################################
appdir="/app/tomcat"
appfile="tomcat.tar.gz"
user="app"
port=8080
if [[ -n $1 ]];then
	appdir=$1
else
	echo "parameter error"
	exit 1
fi
if [[ -n $2 ]];then
	appfile=$2
else
	echo "parameter error"
	exit 1
fi
if [[ -n $3 ]];then
	user=$3
else
	echo "parameter error"
	exit 1
fi
if [[ -n $4 ]];then
	port=$4
fi
#check deploy dir
if [[ -d $appdir ]];then
  echo "$appdir exists,please remove first."
  exit 1
fi
#pre linux setting
sed -i 's/SELINUX=enforcing/SELINUX=disabled/' /etc/selinux/config
systemctl stop      firewalld.service
systemctl disable   firewalld.service
systemctl stop 		  postfix.service
systemctl disable   postfix.service
sed -i '/nofile/d' /etc/rc.d/rc.local
sed -i '/nproc/d' /etc/rc.d/rc.local
echo "* soft nofile 65536 ">>/etc/security/limits.conf
echo "* hard nofile 65536 ">>/etc/security/limits.conf
echo "* soft nproc 65536 ">>/etc/security/limits.conf
echo "* hard nproc 65536 ">>/etc/security/limits.conf
#pre install
echo "yum -y install java"
yum -y install java>/dev/null
#pre create user
id $user
userCK=`echo $?`
if [[ $userCK -eq 1 ]];then
  echo "create user $user"
  groupadd $user
  useradd -g $user -m -d /home/$user $user
  echo 'P@ssw0rd123456' |passwd --stdin $user
else
  usermod -s /bin/bash $user
fi
########deploy##########
mkdir -p $appdir
cd /tmp/
cp ${appfile} ${appdir}/
cd $appdir
echo "deploy_tomcat.sh"
tar xvf $appfile>/dev/null
onedir=`ls -rtl |tail -1 |awk '{print $NF}'`
if [[ -d $appdir/$onedir ]];then
  cd $appdir/$onedir
  mv * ..
else
  echo "deploy failed,$appdir/$onedir not exits"
  exit 1
fi
cd $appdir
rm -rf $appdir/webapps/*
echo "add rc.local"
chown -R $user:$user $appdir
chmod +x /etc/rc.d/rc.local
sed -i '\/'"${appdir}"'\/bin\/startup.sh/d' /etc/rc.d/rc.local
echo "su - $user -c \"sh $appdir/bin/startup.sh\"">>/etc/rc.d/rc.local
sed -i "s@port=\"8080\"@port=\"$port\"@g"  $appdir/conf/server.xml
su - $user -c "$appdir/bin/startup.sh"
echo "deploy success!"
exit 0