-- only oa.sql
delete from oa_banner where 1=1;
INSERT INTO `oa_banner` (`id`, `name`, `status`, `picture_id`, `url`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`, `tenant_id`)VALUES('708057333552381952', 'banner2 默认', 'enable', 'T001_image_banner2', '/business/oa/portal/banner.png', 2, '110588348101165911', '2023-05-08 20:47:03', '110588348101165911', '2023-05-26 13:17:37', 0, NULL, NULL, 7, 'T001'),('714466896212131841', 'banner1 默认', 'enable', 'T001_image_banner1', '/business/oa/portal/banner.png', 1, '110588348101165911', '2023-05-26 13:16:22', '110588348101165911', '2023-05-26 13:17:29', 0, NULL, NULL, 3, 'T001');
update oa_system_information set picture_id='T001_image_project';

