CREATE TABLE `eam_asset_copy` (
                                  `id` varchar(64) NOT NULL COMMENT '主键',
                                  `asset_id` varchar(50) DEFAULT NULL COMMENT '资产',
                                  `asset_number` int(11) DEFAULT NULL COMMENT '复制数量',
                                  `notes` varchar(512) DEFAULT NULL COMMENT '说明',
                                  `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
                                  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                  `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除',
                                  `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                  `tenant_id` varchar(18) DEFAULT NULL COMMENT '租户',
                                  `version` int(11) NOT NULL DEFAULT '1' COMMENT '数据版本号',
                                  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='资产复制';

CREATE TABLE `eam_asset_copy_record` (
                                         `id` varchar(64) NOT NULL COMMENT '主键',
                                         `copy_id` varchar(50) DEFAULT NULL COMMENT '复制',
                                         `copy_asset_id` int(11) DEFAULT NULL COMMENT '资产',
                                         `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
                                         `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                         `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                         `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                         `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除',
                                         `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                         `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                         `tenant_id` varchar(18) DEFAULT NULL COMMENT '租户',
                                         `version` int(11) NOT NULL DEFAULT '1' COMMENT '数据版本号',
                                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='资产复制记录';


-- modify eam_asset
alter table eam_asset add column suggest_maintenance_method varchar(50) default null comment '建议维保方式' after maintenance_status;
alter table eam_asset add column maintenance_method varchar(50) default null comment '维保方式' after maintenance_status;


-- add sys_config data
INSERT INTO `sys_config` (`id`, `profile_id`, `catalog_code`, `code`, `name`, `type`, `type_desc`, `value`, `valid`, `notes`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`)
VALUES
('eam.assetCodeAutoCreate', 'default', 'eam', 'eam.assetCodeAutoCreate', '资产编码自动生成', 'ENUM', 'org.github.foxnic.web.constants.enums.system.YesNo', '1', 1, '资产编码自动生成', NULL, NULL, NULL, NULL, 0, NULL, NULL, 1);



-- add dict data
INSERT INTO `sys_dict` (`id`, `is_tree`, `name`, `code`, `module`, `notes`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`)
VALUES
	('638426144403619840', 0, '建议维保方式', 'eam_suggest_maintenance_method', 'eam', '', '110588348101165911', '2022-10-28 17:17:34', NULL, NULL, 0, NULL, NULL, 1),
	('638426183687471104', 0, '维保方式', 'eam_maintenance_method', 'eam', '', '110588348101165911', '2022-10-28 17:17:44', NULL, NULL, 0, NULL, NULL, 1);


INSERT INTO `eam_asset_attribute` (`id`, `code`, `label`, `value_type`, `value_path`, `label_notes`, `dimension`, `status`, `required`, `required_modify`, `component_type`, `component_content`, `notes`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`, `tenant_id`, `owner`)
VALUES
('638434244581916672', 'suggest_maintenance_method', '建议维保方式', 'dict', 'suggestMaintenanceMethodData,label', '', 'maintainer', 'valid', '0', '1', 'select_box', '', '', '110588348101165911', '2022-10-28 17:49:45', '110588348101165911', '2022-10-28 17:50:11', 0, NULL, NULL, 2, 'T001', 'asset'),
('638434602091806720', 'maintenance_method', '维保方式', 'dict', 'maintenanceMethodData,label', '', 'maintainer', 'valid', '0', '1', 'select_box', '', '', '110588348101165911', '2022-10-28 17:51:11', NULL, NULL, 0, NULL, NULL, 1, 'T001', 'asset');

INSERT INTO `eam_asset_attribute_item` (`id`, `owner_code`, `attribute_id`, `dimension`, `required`, `layout_type`, `list_show`, `list_content`, `list_sort`, `form_show`, `layout_row`, `layout_column`, `notes`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`, `tenant_id`)
VALUES
('638435508103413760', 'base', '638434244581916672', 'maintainer', '0', '3', '0', '', 999, '1', 3, 3, '', '110588348101165911', '2022-10-28 17:54:47', '110588348101165911', '2022-10-28 18:41:59', 0, NULL, NULL, 2, 'T001'),
('638435683752476672', 'base', '638434602091806720', 'maintainer', '0', '3', '1', '', 999, '1', 3, 2, '', '110588348101165911', '2022-10-28 17:55:29', '110588348101165911', '2022-10-28 18:41:51', 0, NULL, NULL, 2, 'T001');

-- eam_inventory_asset 表结果变更未写


