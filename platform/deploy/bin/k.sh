#!/bin/sh
cur_dir=$(cd `dirname $0`; pwd)
app_dir=$cur_dir/..
help(){
  echo ""
  echo "以下是快捷命令:"
  echo "ga=cd /app/app/app/app"
  echo "gb=cd /app/app/app/bpm"
  echo "gj=cd /app/app/app/job"
  echo "gn=cd /app/app/app/nginx"
  echo "g=cd /app/app"
  echo "ka_restart=restartApp"
  echo "kb_restart=restartBpm"
  echo "kj_restart=restartJob"
  echo "kn_restart=restartNginx"
  echo "tdb=mysql foxnic"
  echo "tdb_none=mysql "
  return 0
}
checkService(){
  echo "check app process"
  cd $cur_dir
  sh app.sh status app
  echo ""
  echo "check bpm process"
  cd $cur_dir
  sh app.sh status bpm
  echo ""
  echo "check job process"
  cd $cur_dir
  sh app.sh status job
  echo ""
  echo "check nginx process"
  cd $cur_dir
  nginxcnt=`ps -ef|grep nginx|grep process|grep -v grep|wc -l`
  if [[ $nginxcnt -gt 0 ]];then
    echo "nginx is running,process number count:$nginxcnt"
  else
    echo "nginx is not running"
  fi
  echo ""
  echo "check mysql process"
  mysqlcnt=`ps -ef|grep mysqld|grep basedir|grep -v grep|wc -l`
  if [[ $mysqlcnt -gt 0 ]];then
    echo "mysql is running,process number count:$mysqlcnt"
  else
    echo "mysql is not running"
  fi
  echo ""
  return 0
}

function menu {
	clear
	echo
	echo -e "\t\t\t简单维护界面\n"
	echo -e "\t1. 启动应用程序"
	echo -e "\t2. 停止应用程序"
	echo -e "\t3. 重启应用程序,ka_restart"
	echo -e "\t4. 启动流程引擎"
	echo -e "\t5. 停止流程引擎"
	echo -e "\t6. 重启流程引擎,kb_restart"
	echo -e "\t7. 启动Nginx"
	echo -e "\t8. 停止Nginx"
	echo -e "\t9. 重启Nginx,kn_restart"
	echo -e "\tc. 检查所有服务"
	echo -e "\th. 帮助"
	echo -e "\t0. 退出程序\n\n"
	echo -en "\t\t请输入序号，选择您要执行的操作: "
	read -n 1 option
}
#主程序
while [ 1 ]
do
	menu
	case $option in
	0)
	  break ;;
	1)
  	cd $app_dir;echo "";sh startApp.sh ;;
	2)
  	cd $app_dir;echo "";sh stopApp.sh ;;
	3)
  	cd $app_dir;echo "";sh restartApp.sh ;;
	4)
  	cd $app_dir;echo "";sh startBpm.sh ;;
	5)
  	cd $app_dir;echo "";sh stopBpm.sh ;;
	6)
  	cd $app_dir;echo "";sh restartBpm.sh ;;
	7)
  	cd $app_dir;echo "";sh startNginx.sh ;;
	8)
  	cd $app_dir;echo "";sh stopNginx.sh ;;
	9)
  	cd $app_dir;echo "";sh restartNginx.sh ;;
	'c')
	  echo "";checkService ;;
	'h')
	  help ;;
	*)
	clear
	echo "你选择了错误的序号";;
	esac
	echo -en "\n\n\t\t\t选择任意键返回菜单"
	read -n 1 line
done
clear


exit 0
