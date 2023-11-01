#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
app_dir=$cur_dir/..
yum -y install openssl* libnl‐dev* gcc-c++
yum -y install gcc curl libnl3-devel net-snmpdevel
cd /usr/local/src/keepalived-2.2.2/ && ./configure --prefix=/usr/local/keepalived --disable-fwmark
make -j $CUP && make install
mkdir /etc/keepalived && cp /usr/local/keepalived/etc/keepalived/keepalived.conf /etc/keepalived
exit 0


