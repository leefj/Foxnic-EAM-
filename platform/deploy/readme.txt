

################  应用日常维护,启动停止服务 ################
#启动服务
sh startAll.sh

#停止服务
sh stopAll.sh

#重启服务
sh restartAll.sh

#检查环境
sh bin/checkAppEnvironment.sh

#crontab -e
###APP CRONTAB
0 */1 * * * sh /opt/app/bin/checkIfRestartApp.sh
12 12 * * * sh /opt/app/bin/backupAppDB.sh foxnic




