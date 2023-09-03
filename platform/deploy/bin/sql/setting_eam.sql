-- only eam.sql
update sys_config set value=0 where code='eam.assetDataPermissions';
update sys_config set value=1 where code='eam.assetDirectUpdateMode';
update sys_config set value=0 where code='eam.assetImportAssetCodeKeep';
update sys_config set value=0 where code='eam.assetImportDataReplenish';
update sys_config set value=0 where code='eam.assetSerialNumberIsUnique';
update sys_config set value=0 where code='eam.assetStatusColumnDisable';
update sys_config set value='固资系统' where code='system.title';
update sys_config set value='固资系统' where code='system.login.title';
-- 演示
update sys_menu set hidden=1 where id='610152549789466624';
-- 设备
update sys_menu set hidden=1 where id='568076619713875968';
-- 合同
update sys_menu set hidden=1 where id='565279980485869568';
-- 车辆
update sys_menu set hidden=1 where id='616256885288337408';
-- 会议
update sys_menu set hidden=1 where id='616256779512184832';
-- 运维
update sys_menu set hidden=1 where id='472036556115279872';
-- 运维
update sys_menu set hidden=1 where id='474155549546512385';
-- wms
update sys_menu set hidden=1 where id='682489463259004928';
-- crm
update sys_menu set hidden=1 where id='616265395568902144';
-- hr
update sys_menu set hidden=1 where id in ('662204540778446848','666943320815042560','660861237046804480','662315275764367360','662281190966820864','662287283122077696','623153794699493376');

