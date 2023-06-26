-- only eam.sql
update sys_config set value=0 where code='eam.assetDataPermissions';
update sys_config set value=1 where code='eam.assetDirectUpdateMode';
update sys_config set value=0 where code='eam.assetImportAssetCodeKeep';
update sys_config set value=0 where code='eam.assetImportDataReplenish';
update sys_config set value=0 where code='eam.assetSerialNumberIsUnique';
update sys_config set value=0 where code='eam.assetStatusColumnDisable';
update sys_config set value='固资系统' where code='system.title';
update sys_config set value='固资系统' where code='system.login.title';
