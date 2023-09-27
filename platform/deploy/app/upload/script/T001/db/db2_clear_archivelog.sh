#!/bin/bash
#########################################################################
#
#* */2 * * * sh /dblog/clear_archive.sh
#force delete archive log file
#	filesystem used>80 and keep 300 archive log file
#########################################################################
logfile="/dbbak/clear_archive.log"
arch_dir="/archive_log/db2inst1/PAMS/NODE0000/LOGSTREAM0000/C0000001"
fsUsed=80
#about 100G keep
keepfileN=200
#########################################################################
stime=`date +"%Y-%m-%d %H:%M:%S.000"`
echo " ">>$logfile
echo "----- start -----">>$logfile
echo "start to clear,time:$stime">>$logfile
if [[ ! -d $arch_dir ]];then
	echo "$arch_dir directory not exist!">>$logfile
	echo "-----finish-----">>$logfile
	echo "$arch_dir directory not exist!"
	exit 0
fi
fsPct=`df -PT $arch_dir|awk '{print $6}'|awk -F '%' '{print $1}'|tail -1`
echo "$arch_dir filesystem used:$fsPct">>$logfile
#used > 80,run 
if [[ $fsPct -gt $fsUsed ]];then
	echo "start to clear archive log">>$logfile
	cd $arch_dir
	logfiles=`ls -tl |grep LOG|grep S|awk '{print $NF}'`
	inx=0
	#to keep file 
	for file in $logfiles 
	do
		((inx++))
		if [[ -f $arch_dir/$file ]];then
			if [[ $inx -gt $keepfileN ]];then
				echo "$inx,current file:$arch_dir/$file,to delete">>$logfile
				rm -rf $arch_dir/$file
			else
				echo "$inx,current file:$arch_dir/$file,to keep">>$logfile
			fi
		fi
	done
else
	echo "$arch_dir filesystem used:$fsPct,not need to clear！">>$logfile
	echo "-----finish-----">>$logfile
	exit 0
fi
etime=`date +"%Y-%m-%d %H:%M:%S.000"`
echo "clear finish $etime">>$logfile
echo "----- end -----">>$logfile
exit 0