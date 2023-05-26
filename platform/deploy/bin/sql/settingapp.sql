-- foxnic config
update sys_config set name='参数' where id='673570483181977600';
delete from sys_profile where id<>'default';
delete from sys_config where profile_id<>'default';
update sys_config set value='2.6.0' where code='system.version.code';
update sys_config set value='PROD' where code='system.version.name';
update sys_config set value='PROD' where code='system.version.type';
update sys_config set value='1' where code='system.index.portal.enable';
update sys_config set value='0' where code='system.external.portal.enable';
update sys_config set value='{account:"",password:"",captcha:""}'  where code='system.login.default';
update sys_config set value=0 where code='system.login.captcha.any';
update sys_config set value='123456' where value='system.password.default';
update sys_config set value=0 where code='eam.assetDataPermissions';
update sys_config set value=1 where code='eam.assetDirectUpdateMode';
update sys_config set value=0 where code='eam.assetImportAssetCodeKeep';
update sys_config set value=0 where code='eam.assetImportDataReplenish';
update sys_config set value=0 where code='eam.assetSerialNumberIsUnique';
update sys_config set value=0 where code='eam.assetStatusColumnDisable';
update sys_config set value='/assets/images/bg_login_21.jpg' where code='system.login.background';
update sys_config set value='固资系统' where code='system.title';
update sys_config set value='固资系统' where code='system.login.title';
update sys_config set value='/pages/index/index' where code='eam.mobileLoginIndex';
update eam_asset_label set font_path='/app/app/bin/msyh.ttf' where id='1';

-- 协同
update sys_menu set hidden=1 where id='616256291005792256';
-- 功能演示
update sys_menu set hidden=1 where id='495201409763901440';
update sys_menu set hidden=1 where id='610152549789466624';
-- 回收站
update sys_menu set hidden=1 where id='473612721665867776';
-- 流程中心
-- update sys_menu set hidden=1 where id='577783476611198976';
-- 工单
update sys_menu set hidden=1 where id='472358185009676289';
-- 知识库
-- update sys_menu set hidden=1 where id='472036810977968129';
-- 合同管理
update sys_menu set hidden=1 where id='474157822892834817';
-- 运维
update sys_menu set hidden=1 where id='472036556115279872';
-- 监控
update sys_menu set hidden=1 where id='474155549546512385';
-- 设备
update sys_menu set hidden=1 where id='568076619713875968';
-- 车辆
update sys_menu set hidden=1 where id='562317041218879488';
-- 员工
-- update sys_menu set hidden=1 where id='592108832759488512';
update sys_menu set hidden=1 where id='592348823129427968';
-- 财务管理
-- update sys_menu set hidden=1 where id='475955437510852608';
-- 采购管理
-- update sys_menu set hidden=1 where id='566986193363795968';
-- 盘点
-- update sys_menu set hidden=1 where id='471985681850171393';
-- 资产字段配置，开发人员使用
update sys_menu set hidden=1 where id='487568362436558848';
update sys_menu set hidden=1 where id='487559533120454656';
-- 版本切换
update sys_menu set hidden=1 where id='578624635919138816';
-- 人员档案
update sys_menu set hidden=1 where id='623153794699493376';
-- 接口管理
update sys_menu set hidden=1 where id='622447317160558592';
-- #########
-- 授权管理
-- delete from sys_menu where id='558628496125984768';
-- delete from sys_menu where id='616256291005792256';
-- delete from sys_menu where id='495201409763901440';
-- delete from sys_menu where id='610152549789466624';
-- delete from sys_menu where id='473612721665867776';
-- -- delete from sys_menu where id='577783476611198976';
-- delete from sys_menu where id='472358185009676289';
-- -- delete from sys_menu where id='472036810977968129';
-- delete from sys_menu where id='474157822892834817';
-- delete from sys_menu where id='472036556115279872';
-- delete from sys_menu where id='474155549546512385';
-- delete from sys_menu where id='568076619713875968';
-- delete from sys_menu where id='562317041218879488';
-- -- delete from sys_menu where id='592108832759488512';
-- delete from sys_menu where id='592348823129427968';
-- -- delete from sys_menu where id='475955437510852608';
-- -- delete from sys_menu where id='566986193363795968';
-- -- delete from sys_menu where id='471985681850171393';
-- delete from sys_menu where id='487568362436558848';
-- delete from sys_menu where id='487559533120454656';
-- delete from sys_menu where id='578624635919138816';
update sys_user set portrait_id ='T001_image_head' where 1=1;
update sys_user set language ='zh_cn' where 1=1;
update oa_system_information set picture_id='T001_image_project';
delete from sys_file where id in ('T001_image_head','T001_image_banner1','T001_image_banner2');
delete from sys_file where id in ('T001_image_project');
INSERT INTO sys_file(`id`, `file_name`, `location`, `size`, `media_type`, `file_type`, `download_url`, `latest_visit_time`, `downloads`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`) VALUES ('T001_image_head', 'head.png', '/image/T001/head.png', 66222, 'image/png', 'png', NULL, '2023-05-12 13:30:32', 64, '110588348101165911', '2023-05-12 07:32:51', NULL, NULL, 0, NULL, NULL, 1);
INSERT INTO sys_file(`id`, `file_name`, `location`, `size`, `media_type`, `file_type`, `download_url`, `latest_visit_time`, `downloads`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`) VALUES ('T001_image_banner1', 'banner1.png', '/image/T001/portal_banner1.png', 66222, 'image/png', 'png', NULL, '2023-05-12 13:30:32', 64, '110588348101165911', '2023-05-12 07:32:51', NULL, NULL, 0, NULL, NULL, 1);
INSERT INTO sys_file(`id`, `file_name`, `location`, `size`, `media_type`, `file_type`, `download_url`, `latest_visit_time`, `downloads`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`) VALUES ('T001_image_banner2', 'banner2.png', '/image/T001/portal_banner2.png', 66222, 'image/png', 'png', NULL, '2023-05-12 13:30:32', 64, '110588348101165911', '2023-05-12 07:32:51', NULL, NULL, 0, NULL, NULL, 1);
INSERT INTO sys_file(`id`, `file_name`, `location`, `size`, `media_type`, `file_type`, `download_url`, `latest_visit_time`, `downloads`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`) VALUES ('T001_image_project', 'project.png', '/image/T001/project.png', 66222, 'image/png', 'png', NULL, '2023-05-12 13:30:32', 64, '110588348101165911', '2023-05-12 07:32:51', NULL, NULL, 0, NULL, NULL, 1);

delete from oa_banner;
INSERT INTO `oa_banner` (`id`, `name`, `status`, `picture_id`, `url`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`, `tenant_id`)VALUES('708057333552381952', 'banner2 默认', 'enable', 'T001_image_banner2', '/business/oa/portal/banner.png', 2, '110588348101165911', '2023-05-08 20:47:03', '110588348101165911', '2023-05-26 13:17:37', 0, NULL, NULL, 7, 'T001'),('714466896212131841', 'banner1 默认', 'enable', 'T001_image_banner1', '/business/oa/portal/banner.png', 1, '110588348101165911', '2023-05-26 13:16:22', '110588348101165911', '2023-05-26 13:17:29', 0, NULL, NULL, 3, 'T001');

