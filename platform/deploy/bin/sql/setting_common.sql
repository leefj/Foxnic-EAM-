update sys_config set name='参数' where id='673570483181977600';
delete from sys_profile where id<>'default';
delete from sys_config where profile_id<>'default';
update sys_config set value='1' where code='system.index.portal.enable';
update sys_config set value='0' where code='system.external.portal.enable';
update sys_config set value='{account:"",password:"",captcha:""}'  where code='system.login.default';
update sys_config set value=0 where code='system.login.captcha.any';
update sys_config set value='123456' where value='system.password.default';
update sys_config set value='/assets/images/bg_login_21.jpg' where code='system.login.background';
update sys_config set value='/pages/index/index' where code='eam.mobileLoginIndex';
update eam_asset_label set font_path='/app/app/bin/msyh.ttf' where id='1';
update sys_menu set css='fa fa-circle-o'  where type='page' and ( css is null or css='');
update sys_user set portrait_id ='T001_image_head' where 1=1;
-- setting some common sql
update sys_user set language ='zh_cn' where 1=1;
-- 功能演示
update sys_menu set hidden=1 where id='495201409763901440';
update sys_menu set hidden=1 where id='610152549789466624';
-- 回收站
update sys_menu set hidden=1 where id='694545227850973184';
-- 资产字段配置，开发人员使用
update sys_menu set hidden=1 where id='487568362436558848';
update sys_menu set hidden=1 where id='487559533120454656';
-- 流程门户
update sys_menu set hidden=1 where id='577783476611198976';
update sys_menu set hidden=1 where hierarchy like '%577783476611198976%';
update sys_menu set hidden=1 where hierarchy like '%734474163506380800%';




