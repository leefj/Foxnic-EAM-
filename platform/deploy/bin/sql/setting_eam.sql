-- only eam.sql
update sys_config set value='固资系统' where code='system.title';
update sys_config set value='固资系统' where code='system.login.title';
-- default free version
update sys_config set value='sq' where code='system.version.applyType';
