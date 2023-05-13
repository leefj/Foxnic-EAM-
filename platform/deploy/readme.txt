
################  应用日常维护,启动停止服务 ################
#启动简单维护窗口
#k

#启动所有服务
sh startAll.sh

#停止所有服务
sh stopAll.sh

#重启所有服务
sh restartAll.sh

#检查环境
sh bin/checkAppEnvironment.sh

#crontab -l
###APP CRONTAB
58 23 * * *  sh /app/app/bin/clearDataSpace.sh
30 2 * * *   sh /app/app/bin/backupAppDB.sh foxnic




