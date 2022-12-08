truncate table eam_asset_depreciation_detail;
CREATE TABLE `eam_asset_depreciation_detail` (
                                                 `id` varchar(50) NOT NULL COMMENT '主键',
                                                 `depreciation_id` varchar(50) DEFAULT NULL COMMENT '折旧方案',
                                                 `oper_id` varchar(50) DEFAULT NULL COMMENT '折旧操作',
                                                 `action_code` varchar(50) DEFAULT NULL COMMENT '折旧动作',
                                                 `first_depreciation_method` varchar(50) DEFAULT NULL COMMENT '首次折旧方式',
                                                 `depreciation_method` varchar(50) DEFAULT NULL COMMENT '折旧方式',
                                                 `business_date` date DEFAULT NULL COMMENT '业务日期',
                                                 `result` varchar(50) DEFAULT NULL COMMENT '折旧结果',
                                                 `result_detail` varchar(500) DEFAULT NULL COMMENT '折旧结果明细',
                                                 `asset_id` varchar(50) DEFAULT NULL COMMENT '资产',
                                                 `asset_category_id` varchar(50) DEFAULT NULL COMMENT '资产类别',
                                                 `asset_category_name` varchar(500) DEFAULT NULL COMMENT '资产类别',
                                                 `asset_finance_category_id` varchar(50) DEFAULT NULL COMMENT '财务分类',
                                                 `asset_finance_category_name` varchar(500) DEFAULT NULL COMMENT '财务分类',
                                                 `asset_code` varchar(50) DEFAULT NULL COMMENT '资产编码',
                                                 `asset_name` varchar(50) DEFAULT NULL COMMENT '资产名称',
                                                 `asset_model` varchar(500) DEFAULT NULL COMMENT '资产型号',
                                                 `asset_status_name` varchar(50) DEFAULT NULL COMMENT '资产状态',
                                                 `asset_purchase_date` date DEFAULT NULL COMMENT '采购日期',
                                                 `asset_register_date` date DEFAULT NULL COMMENT '入账日期',
                                                 `asset_original_unit_price` decimal(10,2) DEFAULT NULL COMMENT '资产原值',
                                                 `asset_purchase_unit_price` decimal(10,2) DEFAULT NULL COMMENT '含税单价',
                                                 `asset_nav_price` decimal(10,2) DEFAULT NULL COMMENT '资产净值,(当前)',
                                                 `asset_tax_amount_rate` decimal(10,2) DEFAULT NULL COMMENT '税额',
                                                 `asset_service_life` decimal(10,2) DEFAULT NULL COMMENT '可使用期限,月',
                                                 `asset_finance_service_life` decimal(10,2) DEFAULT NULL COMMENT '可使用期限,月',
                                                 `asset_residuals_rate` decimal(10,2) DEFAULT NULL COMMENT '本期残值率',
                                                 `asset_residuals_price` decimal(10,2) DEFAULT NULL COMMENT '本期残值',
                                                 `s_original_price` decimal(10,2) DEFAULT NULL COMMENT '(期初)期初原值',
                                                 `s_depreciation_amount` decimal(10,2) DEFAULT NULL COMMENT '(期初)期初累计折旧',
                                                 `s_nav_amount` decimal(10,2) DEFAULT NULL COMMENT '(期初)期初净值',
                                                 `s_recoverable_amount` decimal(10,2) DEFAULT NULL COMMENT '(期初)期初可回收净额',
                                                 `c_used_service_life` decimal(10,2) DEFAULT NULL COMMENT '已使用期限,月',
                                                 `c_original_price_increase` decimal(10,2) DEFAULT NULL COMMENT '(本期发生)原值增加',
                                                 `c_depreciation_amount` decimal(10,2) DEFAULT NULL COMMENT '(本期发生)本期折旧额',
                                                 `c_year_depreciation_amount` decimal(10,2) DEFAULT NULL COMMENT '(本期发生)本年累计折旧额',
                                                 `e_original_price` decimal(10,2) DEFAULT NULL COMMENT '(期末)期末原值',
                                                 `e_depreciation_amount` decimal(10,2) DEFAULT NULL COMMENT '(期末)期末累计折旧',
                                                 `e_nav_amount` decimal(10,2) DEFAULT NULL COMMENT '(期末)期末净值',
                                                 `e_recoverable_amount` decimal(10,2) DEFAULT NULL COMMENT '(期末)期末可回收金额',
                                                 `accounting_service_life` decimal(10,2) DEFAULT NULL COMMENT '会计期间已使用期限,月',
                                                 `first_depreciation` varchar(10) DEFAULT NULL COMMENT '首次折旧,0否,1是',
                                                 `use_user_id` varchar(50) DEFAULT NULL COMMENT '使用人ID',
                                                 `use_user_name` varchar(50) DEFAULT NULL COMMENT '使用人',
                                                 `manager_id` varchar(50) DEFAULT NULL COMMENT '管理人员',
                                                 `manager_name` varchar(50) DEFAULT NULL COMMENT '管理人员',
                                                 `use_org_id` varchar(50) DEFAULT NULL COMMENT '部门ID',
                                                 `use_org_name` varchar(50) DEFAULT NULL COMMENT '使用部门',
                                                 `financial_option_key` varchar(50) DEFAULT NULL COMMENT '财务选项KEY',
                                                 `expense_item_key` varchar(50) DEFAULT NULL COMMENT '费用项目KEY',
                                                 `financial_option_name` varchar(50) DEFAULT NULL COMMENT '财务选项',
                                                 `expense_item_name` varchar(50) DEFAULT NULL COMMENT '费用项目',
                                                 `customer_info` varchar(200) DEFAULT NULL COMMENT '客户情况',
                                                 `detail_id_source` varchar(50) DEFAULT NULL COMMENT '源资产',
                                                 `detail_id_target` varchar(50) DEFAULT NULL COMMENT '目标资产',
                                                 `last_oper_id` varchar(50) DEFAULT NULL COMMENT '上次折旧单据',
                                                 `last_oper_time` datetime DEFAULT NULL COMMENT '上次折旧时间',
                                                 `create_by` varchar(18) NOT NULL COMMENT '创建人ID',
                                                 `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                                 `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                                 `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                                 `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除',
                                                 `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                                 `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                                 `version` int(11) NOT NULL DEFAULT '1',
                                                 `result_value_str` varchar(500) DEFAULT NULL COMMENT '结果字符串',
                                                 `result_value_float` decimal(10,2) DEFAULT NULL COMMENT '结果浮点',
                                                 PRIMARY KEY (`id`) USING BTREE,
                                                 KEY `eam_asset_depreciation_detail_1` (`depreciation_id`),
                                                 KEY `eam_asset_depreciation_detail_2` (`oper_id`),
                                                 KEY `eam_asset_depreciation_detail_3` (`oper_id`,`result`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='折旧明细表';
