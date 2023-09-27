rem del
set PathDir="D:\dbbak"
forfiles /p %PathDir% /s /m ecology_*.bak /d -15 /c "cmd /c del /f /q /a @path"
rem backup
set stime=%date:~0,4%-%date:~5,2%-%date:~8,2% %time:~0,2%:%time:~3,2%:%time:~6,2%.000
set slog=%stime%^^^|method=local,uid=917704f6197d781e729bf5906604b6cc,action=db,status=acting,dbname=ecology,alias_name=ecology,ip=10.19.10.65,size=1638
echo %slog%>>D:\ecology.log
sqlcmd -S . -i D:\sqlserver_backup.sql
set PathDir="D:\dbbak"
set etime=%date:~0,4%-%date:~5,2%-%date:~8,2% %time:~0,2%:%time:~3,2%:%time:~6,2%.000
set elog=%etime%^^^|method=local,uid=917704f6197d781e729bf5906604b6cc,action=db,status=success,dbname=ecology,alias_name=ecology,ip=10.19.10.65,size=1638,result=success,stime=%stime%,etime=%etime%
echo %elog%>>D:\ecology.log

 



