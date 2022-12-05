drop table eam_asset_label;
CREATE TABLE `eam_asset_label` (
                                   `id` varchar(50) NOT NULL COMMENT '主键',
                                   `code` varchar(50) NOT NULL COMMENT '编码',
                                   `label_tpl_id` varchar(50) DEFAULT NULL COMMENT '标签',
                                   `label_width` decimal(10,2) DEFAULT '8.00' COMMENT '标签宽度(mm)',
                                   `label_height` decimal(10,2) DEFAULT '3.00' COMMENT '标签高度(mm)',
                                   `label_layout` varchar(50) DEFAULT 'center' COMMENT '标签布局(暂时不用)',
                                   `label_table_margin` decimal(10,2) DEFAULT '2.10' COMMENT '标签间隔',
                                   `label_key_font_size` decimal(10,2) DEFAULT '8.00' COMMENT '字体大小(mm)',
                                   `label_key_width` decimal(10,2) DEFAULT '0.00' COMMENT 'Key宽度',
                                   `label_value_font_size` decimal(10,2) DEFAULT '8.00' COMMENT '字体大小(mm)',
                                   `image_contain_height` decimal(10,2) DEFAULT '10.00' COMMENT '图像容器大小(mm)',
                                   `image_width` decimal(10,2) DEFAULT '0.00' COMMENT '图形宽度',
                                   `image_height` decimal(10,2) DEFAULT '0.00' COMMENT '图形高度',
                                   `image_margin_top` decimal(10,2) DEFAULT '1.00' COMMENT '图片marginTop',
                                   `image_margin_bottom` decimal(10,2) DEFAULT '1.00' COMMENT '图片marginBottom',
                                   `paper_type_id` varchar(50) DEFAULT NULL COMMENT '纸张类型',
                                   `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
                                   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                   `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                   `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                   `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除',
                                   `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                   `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                   `version` int(11) NOT NULL DEFAULT '1',
                                   `tenant_id` varchar(18) DEFAULT NULL COMMENT '租户',
                                   PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='资产标签';

INSERT INTO `eam_asset_label` (`id`, `code`, `label_tpl_id`, `label_width`, `label_height`, `label_layout`, `label_table_margin`, `label_key_font_size`, `label_key_width`, `label_value_font_size`, `image_contain_height`, `image_width`, `image_height`, `image_margin_top`, `image_margin_bottom`, `paper_type_id`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`, `tenant_id`)
VALUES
('1', 'T001', '650449362169626624', 8.00, 6.00, NULL, 2.10, 2.80, 13.00, 2.80, NULL, 0.00, 0.00, 1.00, 10.00, '1', NULL, NULL, '110588348101165911', '2022-12-03 14:06:23', 0, NULL, NULL, 32, 'T001');




drop table eam_asset_label_layout;
    CREATE TABLE `eam_asset_label_layout` (
    `id` varchar(50) NOT NULL COMMENT '主键',
    `tpl_id` varchar(50) DEFAULT NULL COMMENT '模版',
    `col_id` varchar(50) DEFAULT NULL COMMENT '字段ID',
    `col_code` varchar(50) DEFAULT 'default' COMMENT '字段编码',
    `type` varchar(50) DEFAULT 'label' COMMENT '类型',
    `row_number` int(11) DEFAULT '1' COMMENT '行数',
    `row_height` decimal(10,2) DEFAULT '8.00' COMMENT '行高度(mm)',
    `row_span` int(11) DEFAULT '1' COMMENT 'row_span',
    `col_span` int(11) DEFAULT '1' COMMENT 'col_span',
    `sort` int(11) DEFAULT '0' COMMENT '顺序',
    `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
    `update_time` datetime DEFAULT NULL COMMENT '修改时间',
    `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除',
    `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
    `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
    `version` int(11) NOT NULL DEFAULT '1',
    PRIMARY KEY (`id`) USING BTREE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='标签布局';

INSERT INTO `eam_asset_label_layout` (`id`, `tpl_id`, `col_id`, `col_code`, `type`, `row_number`, `row_height`, `row_span`, `col_span`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`)
VALUES
('1', '650449362169626624', NULL, '资产编号', 'label', 1, 9.00, 1, 1, 10, NULL, NULL, NULL, NULL, 0, NULL, NULL, 1),
('10', '650449362169626624', NULL, '启用日期', 'label', 4, 9.00, 1, 1, 100, NULL, NULL, NULL, NULL, 0, NULL, NULL, 1),
('11', '650449362169626624', NULL, 'purchaseDate', 'value', 4, 9.00, 1, 2, 110, NULL, NULL, NULL, NULL, 0, NULL, NULL, 1),
('12', '650449362169626624', NULL, '所属公司', 'label', 5, 9.00, 1, 1, 120, NULL, NULL, NULL, NULL, 0, NULL, NULL, 1),
('13', '650449362169626624', NULL, 'ownCompanyName', 'value', 5, 9.00, 1, 2, 130, NULL, NULL, NULL, NULL, 0, NULL, NULL, 1),
('2', '650449362169626624', NULL, 'assetCode', 'value', 1, 9.00, 1, 1, 20, NULL, NULL, NULL, NULL, 0, NULL, NULL, 1),
('3', '650449362169626624', NULL, '资产名称', 'label', 1, 9.00, 1, 1, 30, NULL, NULL, NULL, NULL, 0, NULL, NULL, 1),
('4', '650449362169626624', NULL, 'name', 'value', 1, 9.00, 1, 1, 40, NULL, NULL, NULL, NULL, 0, NULL, NULL, 1),
('5', '650449362169626624', NULL, '规格型号', 'label', 2, 16.00, 1, 1, 50, NULL, NULL, NULL, NULL, 0, NULL, NULL, 1),
('6', '650449362169626624', NULL, 'model', 'value', 2, 16.00, 1, 2, 60, NULL, NULL, NULL, NULL, 0, NULL, NULL, 1),
('7', '650449362169626624', NULL, '图像', 'qr_code', 2, 9.00, 4, 1, 70, NULL, NULL, NULL, NULL, 0, NULL, NULL, 1),
('8', '650449362169626624', NULL, '资产序列', 'label', 3, 9.00, 1, 1, 80, NULL, NULL, NULL, NULL, 0, NULL, NULL, 1),
('9', '650449362169626624', NULL, 'serialNumber', 'value', 3, 9.00, 1, 2, 90, NULL, NULL, NULL, NULL, 0, NULL, NULL, 1);
