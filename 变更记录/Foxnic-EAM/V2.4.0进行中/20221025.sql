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


INSERT INTO `sys_config` (`id`, `profile_id`, `catalog_code`, `code`, `name`, `type`, `type_desc`, `value`, `valid`, `notes`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`)
VALUES
('eam.assetCodeAutoCreate', 'default', 'eam', 'eam.assetCodeAutoCreate', '资产编码自动生成', 'ENUM', 'org.github.foxnic.web.constants.enums.system.YesNo', '1', 1, '资产编码自动生成', NULL, NULL, NULL, NULL, 0, NULL, NULL, 1);


