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
-- 财务管理
update sys_menu set hidden=1 where id='475955437510852608';
-- 软件资产
update sys_menu set hidden=1 where id='479388413435314177';
-- 库存物品
update sys_menu set hidden=1 where id='568725500025896960';
-- OA 工作安排
update sys_menu set hidden=1 where id='724920223844532224';
-- OA 我的流程
update sys_menu set hidden=1 where id='768002841599016960';
-- OA 我的流程
update sys_menu set hidden=1 where id='768002841599016960';
-- OA 合同
update sys_menu set hidden=1 where id='565279980485869568';
-- OA 客户
update sys_menu set hidden=1 where id='616265395568902144';
-- OA 车辆
update sys_menu set hidden=1 where id='616256885288337408';
-- OA 会议
update sys_menu set hidden=1 where id='616256779512184832';
-- OA 设置
update sys_menu set hidden=1 where id='616256406374318080';
-- 系统 支付
update sys_menu set hidden=1 where id='728502379380473856';
-- 系统 序列
update sys_menu set hidden=1 where id='489077805410156544';
-- 系统 多语言
update sys_menu set hidden=1 where id='463401581010747392';
-- 系统 编码配置
update sys_menu set hidden=1 where id='476517102736375808';
-- 系统 权限系统资源
update sys_menu set hidden=1 where id='463397732229316608';
-- 系统 公司管理
update sys_menu set hidden=1 where id='482877676386779136';
-- 系统 租户管理
update sys_menu set hidden=1 where id='482864634051690496';
-- 系统 开发工具
update sys_menu set hidden=1 where id='631513237405302784';
-- 系统 日志管理
update sys_menu set hidden=1 where id='765908751092809728';
-- 系统 计划任务执行日志
update sys_menu set hidden=1 where id='530779933585178624';
-- 系统监控
update sys_menu set hidden=1 where id='724547250738429952';
-- 采购管理
update sys_menu set hidden=1 where id='566986193363795968';
-- 资产入库
update sys_menu set hidden=1 where id='579666873201721344';
-- 资产维护维保
update sys_menu set hidden=1 where id='638424019464355840';
-- 资产调拨
update sys_menu set hidden=1 where id='480488576866320384';
-- 资产转移
update sys_menu set hidden=1 where id='480492959574261760';
-- 资产系统设置 资产状态
update sys_menu set hidden=1 where id='608232291948298240';
-- 资产系统设置 资产资产配置
update sys_menu set hidden=1 where id='487568362436558848';
-- 资产系统设置 数据权限
update sys_menu set hidden=1 where id='523843695414345728';
-- 资产系统设置 资产操作
update sys_menu set hidden=1 where id='494597318092259328';
-- 资产品牌
update sys_menu set hidden=1 where id='582429852791996416';
-- 资产系统设置 辅助工具
update sys_menu set hidden=1 where id='637280752681091072';
-- 人事系统 我的人事
-- update sys_menu set hidden=1 where id='766183428553965568';
-- 人事系统 人员信息
-- update sys_menu set hidden=1 where id='666943320815042560';
-- 人事系统 人员合同
-- update sys_menu set hidden=1 where id='660861237046804480';
-- 人事系统 招聘
-- update sys_menu set hidden=1 where id='662287283122077696';
-- 人事系统 薪酬
-- update sys_menu set hidden=1 where id='662315275764367360';
-- 人事系统 考勤
-- update sys_menu set hidden=1 where id='662281190966820864';
-- 人事系统 档案
-- update sys_menu set hidden=1 where id='623153794699493376';
-- 人事系统  配置
-- update sys_menu set hidden=1 where id='662204540778446848';
-- 我的人事
-- update sys_menu set hidden=1 where id='766183428553965568';
-- hr
-- update sys_menu set hidden=1 where id in ('662204540778446848','666943320815042560','660861237046804480','662315275764367360','662281190966820864','662287283122077696','623153794699493376');

