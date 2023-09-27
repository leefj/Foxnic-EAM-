GO
DECLARE @btime VARCHAR(20)
DECLARE @fname VARCHAR(200)
select @btime=(CONVERT(VARCHAR(8),GETDATE(),112)+replace(CONVERT(VARCHAR(8),GETDATE(),114),':',''))
select @fname ='D:\dbbak\ecology_'+@btime+'.bak'
backup database ecology to disk=@fname with INIT,COMPRESSION
