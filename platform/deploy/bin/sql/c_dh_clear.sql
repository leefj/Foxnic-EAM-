-- wms
delete from sys_menu where hierarchy like '%682489463259004928%';
-- 保养
delete from sys_menu where hierarchy like '%583187884257837056%';
-- 巡检
delete from sys_menu where hierarchy like '%568078307707326464%';
-- 工作安排
delete from sys_menu where hierarchy like '%724920223844532224%';
-- 合同
delete from sys_menu where hierarchy like '%565279980485869568%';
-- 客户
delete from sys_menu where hierarchy like '%616265395568902144%';
-- 车辆
delete from sys_menu where hierarchy like '%616256885288337408%';
-- 会议
delete from sys_menu where hierarchy like '%616256779512184832%';
-- 人员报表
delete from sys_menu where hierarchy like '%801757091264987136%';
-- 人事 系统配置
delete from sys_menu where hierarchy like '%662204540778446848%';
-- 协同 系统配置
delete from sys_menu where hierarchy like '%798117773350797312%';
-- 知识
delete from sys_menu where hierarchy like '%472037131183718400%';
-- 通知
delete from sys_menu where hierarchy like '%708039216537272320%';
-- 协同办公修改为网盘
update sys_menu set label='个人网盘' where id='616256291005792256';
-- 设备管理-备件
delete from sys_menu where hierarchy like '%732553385097560064%';
-- 设备管理-维护
delete from sys_menu where hierarchy like '%568078396299415552%';
-- eam采购
delete from sys_menu where hierarchy like '%566986193363795968%';
-- eam软件资产
delete from sys_menu where hierarchy like '%479388413435314177%';
-- eam财务
delete from sys_menu where hierarchy like '%475955437510852608%';
-- eam盘点
delete from sys_menu where hierarchy like '%471985681850171393%';
-- 人事我的信息
delete from sys_menu where hierarchy like '%766183428553965568%';
-- 人事人员信息
delete from sys_menu where hierarchy like '%666943320815042560%';
-- 人事系统 系统配置
delete from sys_menu where hierarchy like '%662204540778446848%';
-- 人员合同
delete from sys_menu where hierarchy like '%660861237046804480%';
-- 招聘管理
delete from sys_menu where hierarchy like '%662287283122077696%';
-- 薪酬管理
delete from sys_menu where hierarchy like '%662315275764367360%';
-- 考勤管理
delete from sys_menu where hierarchy like '%662281190966820864%';
-- 档案管理
delete from sys_menu where hierarchy like '%623153794699493376%';
-- 移动应用
delete from sys_menu where hierarchy like '%591252483909615616%';
-- 库存领用
delete from sys_menu where hierarchy like '%782363997021143040%';
-- 支付管理
delete from sys_menu where hierarchy like '%728502379380473856%';
-- 其他固资-资产变更，员工申请，维护维保
delete from sys_menu where hierarchy like '%638424019464355840%';
delete from sys_menu where hierarchy like '%479208678382108672%';
delete from sys_menu where hierarchy like '%592108913319485440%';
delete from sys_menu where hierarchy like '%592348947209523200%';
delete from sys_menu where hierarchy like '%782907749779374081%';
delete from sys_menu where hierarchy like '%592349052897595392%';
delete from sys_menu where hierarchy like '%592349239971942400%';
delete from sys_menu where hierarchy like '%592349186557480960%';
delete from sys_menu where hierarchy like '%798654405602705408%';
delete from sys_menu where hierarchy like '%638295219103596544%';
delete from sys_menu where hierarchy like '%592109055049211904%';
-- 我的流程
delete from sys_menu where hierarchy like '%768485399684186114%';
delete from sys_menu where hierarchy like '%768485298425298944%';
delete from sys_menu where hierarchy like '%768002841599016960%';
commit;

