
ALTER TABLE `foxnic`.`sys_user`
    ADD COLUMN `notes` varchar(512) NULL COMMENT '备注' AFTER `version`;

ALTER TABLE `foxnic`.`sys_menu`
    ADD COLUMN `notes` varchar(512) NULL COMMENT '备注' AFTER `version`;


ALTER TABLE `foxnic`.`sys_role`
    ADD COLUMN `notes` varchar(512) NULL COMMENT '备注' AFTER `version`;

ALTER TABLE `foxnic`.`sys_busi_role`
    ADD COLUMN `notes` varchar(512) NULL COMMENT '备注' AFTER `version`;
