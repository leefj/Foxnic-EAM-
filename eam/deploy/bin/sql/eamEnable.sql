update sys_config set value=0 where value='eam.assetDataPermissions';
update sys_config set value=1 where value='eam.assetDirectUpdateMode';
update sys_config set value=0 where value='eam.assetImportAssetCodeKeep';
update sys_config set value=0 where value='eam.assetImportDataReplenish';
update sys_config set value=0 where value='eam.assetSerialNumberIsUnique';
update sys_config set value=0 where value='eam.assetStatusColumnDisable';
update sys_config set value=0 where value='eam.assetDataPermissions';

-- 功能演示
update sys_menu set hidden=1 where id='495201409763901440';

-- 流程中心
update sys_menu set hidden=1 where id='577783476611198976';

-- 工单
update sys_menu set hidden=1 where id='472358185009676289';

-- 知识库
update sys_menu set hidden=1 where id='472036810977968129';

-- 合同管理
update sys_menu set hidden=1 where id='474157822892834817';

-- 回收站
update sys_menu set hidden=1 where id='473612721665867776';

-- 运维
update sys_menu set hidden=1 where id='472036556115279872';

-- 监控
update sys_menu set hidden=1 where id='474155549546512385';

-- 设备
update sys_menu set hidden=1 where id='568076619713875968';

-- 车辆
update sys_menu set hidden=1 where id='562317041218879488';

-- 员工
update sys_menu set hidden=1 where id='592108832759488512';
update sys_menu set hidden=1 where id='592348823129427968';

-- 财务
update sys_menu set hidden=1 where id='475955437510852608';


-- 财务
update sys_menu set hidden=1 where id='471985681850171393';