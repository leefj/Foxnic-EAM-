
-- 每个box类型，一个source一条记录，insert 前会判断是否有解密权限，没有解密权限无法插入，
-- 有解密权限:可以插入，可以更新，可以查看
-- 无解密权限:查看密文
--

CREATE TABLE `ops_ciphertext_box` (
                                      `id` varchar(50) NOT NULL COMMENT '主键',
                                      `name` varchar(50) DEFAULT NULL COMMENT '名称',
                                      `type` varchar(50) DEFAULT NULL COMMENT '类型',
                                      `encryption_key` varchar(50) DEFAULT 'box' COMMENT 'KEY',
                                      `notes` varchar(500) DEFAULT NULL COMMENT '备注',
                                      `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                      `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                      `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                      `deleted` tinyint(1) DEFAULT '0' COMMENT '是否已删除',
                                      `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                      `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                      `version` int(11) NOT NULL DEFAULT '1',
                                      PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='密文箱';

CREATE TABLE `ops_ciphertext_box_data` (
                                           `id` varchar(50) NOT NULL COMMENT '主键',
                                           `source_id` varchar(50) NOT NULL COMMENT '来源',
                                           `box_id` varchar(50) DEFAULT NULL COMMENT '密码箱',
                                           `box_type` varchar(50) DEFAULT NULL COMMENT '密码类型',
                                           `name` varchar(50) DEFAULT NULL COMMENT '名称',
                                           `content` varchar(1000) DEFAULT NULL COMMENT '内容',
                                           `plaintext` varchar(1000) DEFAULT NULL COMMENT '加密',
                                           `ciphertext` varchar(1000) DEFAULT NULL COMMENT '密文',
                                           `notes` varchar(50) DEFAULT NULL COMMENT '备注',
                                           `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
                                           `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                           `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                           `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                           `deleted` tinyint(1) DEFAULT '0' COMMENT '是否已删除',
                                           `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                           `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                           `version` int(11) NOT NULL DEFAULT '1',
                                           PRIMARY KEY (`id`) USING BTREE,
                                           UNIQUE KEY `ciphertext_box_data_id1` (`source_id`,`box_id`,`deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='密文数据';

CREATE TABLE `ops_ciphertext_conf` (
                                       `id` varchar(50) NOT NULL COMMENT '主键',
                                       `box_id` varchar(50) DEFAULT NULL COMMENT '类型',
                                       `user_id` varchar(50) DEFAULT NULL COMMENT '人员',
                                       `decryption_perm_status` varchar(50) DEFAULT NULL COMMENT '解密权限',
                                       `notes` varchar(500) DEFAULT NULL COMMENT '备注',
                                       `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                       `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                       `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                       `deleted` tinyint(1) DEFAULT '0' COMMENT '是否已删除',
                                       `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                       `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                       `version` int(11) NOT NULL DEFAULT '1',
                                       PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限配置';

CREATE TABLE `ops_ciphertext_history` (
                                          `id` varchar(50) NOT NULL COMMENT '主键',
                                          `type` varchar(50) DEFAULT NULL COMMENT '类型',
                                          `box_type` varchar(50) DEFAULT NULL COMMENT '密文箱类型',
                                          `source_value` varchar(50) DEFAULT NULL COMMENT '来源',
                                          `content` varchar(2000) DEFAULT NULL COMMENT '内容',
                                          `encryption_content` varchar(2500) DEFAULT NULL COMMENT '加密内容',
                                          `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                          `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                          `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                          `deleted` tinyint(1) DEFAULT '0' COMMENT '是否已删除',
                                          `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                          `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                          `version` int(11) NOT NULL DEFAULT '1',
                                          PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='历史记录';