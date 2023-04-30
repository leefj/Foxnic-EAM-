ALTER TABLE eam_asset_data_permissions ADD COLUMN `warehouse_authority_enable` varchar(50) NULL COMMENT '' AFTER `position_notes`;
ALTER TABLE eam_asset_data_permissions ADD COLUMN `warehouse_notes` varchar(500) NULL COMMENT '' AFTER `position_notes`;
CREATE TABLE `eam_asset_data_permissions_wh` (
                                                 `id` varchar(50) NOT NULL COMMENT '主键',
                                                 `permission_id` varchar(50) DEFAULT NULL COMMENT '权限',
                                                 `value` varchar(50) DEFAULT NULL COMMENT '值',
                                                 `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
                                                 `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                                 `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                                 `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                                 `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除',
                                                 `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                                 `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                                 PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='仓库';