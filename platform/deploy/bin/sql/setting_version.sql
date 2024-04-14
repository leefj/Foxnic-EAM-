update sys_config set value='2.9.0' where code='system.version.code';
update sys_config set value='PROD' where code='system.version.name';
update sys_config set value='PROD' where code='system.version.type';
update sys_menu set css='fa fa-circle-o'  where type='page' and ( css is null or css='');
update sys_config set value=date_format(now(),'%Y%m%d%H%i%s'),notes='app update' where id='system.cachekey';