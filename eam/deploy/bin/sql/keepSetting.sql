
drop table sys_menu_hidden_01;
create table sys_menu_hidden_01 as select * from sys_menu where hidden=1;


delete from sys_resourze;
delete from sys_menu;
delete from sys_menu_resource;

update sys_menu a set hidden=1 where a.id in (select id from sys_menu_hidden_01);



insert into sys_resourze select * from eam_clone.sys_resourze;
insert into sys_menu select * from eam_clone.sys_menu;
insert into sys_menu_resource select * from eam_clone.sys_menu_resource;

create table sys_config_1 as select * from sys_config




