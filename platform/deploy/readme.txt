################  应用日常维护,启动停止服务 ################
######启动简单维护窗口
k

######启动所有服务
sh startAll.sh

######停止所有服务
sh stopAll.sh

######重启所有服务
sh restartAll.sh

######重启应用
ka_restart

######重启流程
kb_restart

######检查环境
sh /app/app/bin/checkAppEnvironment.sh


################  应用访问 ################
######PC
http://127.0.0.1:8089
https://127.0.0.1:8090

######移动端
https://127.0.0.1:8091

######默认密码
admin 123456


################  定时任务 ################
###app crontab
58 23 * * *  sh /app/bin/clearDataSpace.sh
30 2 * * *   sh /app/bin/backupAppDB.sh foxnic




