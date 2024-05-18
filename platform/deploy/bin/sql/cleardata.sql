delete from magic_cron_log where 1=1;
delete from sys_invoke_log where 1=1;
delete from magic_cron_log where 1=1;
delete from oa_banner where 1=1;
-- bpm
delete from bpm_form_instance where 1=1;
delete from bpm_form_instance_bill where 1=1;
delete from bpm_process_instance where 1=1;
delete from bpm_task where 1=1;
delete from oa_notice where iftop='N';
-- oa
delete from oa_work_rpt where 1=1;
delete from oa_schedule_plan where 1=1;
-- system
delete from sys_token where 1=1;
delete from hrm_company where id<>'001';
delete from sys_tenant where id<>'T001';
update sys_tenant set valid=1 where id='T001';
delete from sys_dict where deleted<>0;
delete from sys_dict_item where deleted<>0;
update sys_dict set create_time=now();
update sys_dict_item set create_time=now();
delete from sys_config where deleted<>0;
delete from sys_role where deleted<>0;
delete from sys_role where name like '测试%';
delete from sys_role_menu where role_id not in (select id from sys_role);
delete from sys_role_user where role_id not in (select id from sys_role);
delete from sys_busi_role where deleted<>0;
delete from sys_busi_role_member where role_id not in (select id from sys_busi_role);
delete from sys_busi_role_member where 1=1;
delete from sys_job where deleted<>0;
delete from sys_job_log where 1=1;
delete from sys_menu where deleted=1;
delete from sys_menu_resource where menu_id not in (select id from sys_menu);
delete from sys_tenant where deleted=1;
delete from sys_code_allocation where deleted=1;
delete from sys_code_attr where deleted=1;
delete from sys_code_register where deleted=1;
delete from sys_code_rule where deleted=1;
delete from sys_tpl_file where deleted=1;
delete from sys_backup_db where 1=1;
-- system time
-- update sys_config set create_time=null,create_by=null;
-- update sys_dict_item set create_time=null,create_by=null;
-- update sys_dict set create_time=null,create_by=null;
update sys_role set create_time=null,create_by=null;
update sys_busi_role set create_time=null,create_by=null;
update sys_tenant set create_time=null,create_by=null;
update hrm_company set create_time=null,create_by=null;
update sys_job set create_time=null,create_by=null;
update sys_code_allocation set create_time=null,create_by=null;
update sys_code_attr set create_time=null,create_by=null;
update sys_code_register set create_time=null,create_by=null;
update sys_code_rule set create_time=null,create_by=null;
update sys_tpl_file set create_time=null,create_by=null;
update sys_licence_switch set create_time=null,create_by=null;
-- eam
delete from eam_asset where 1=1    ;
delete from eam_asset_item where 1=1;
delete from eam_asset_batch where 1=1;
delete from eam_asset_process_record where 1=1;
delete from eam_asset_selected_data where 1=1;
delete from eam_asset_data_change where 1=1    ;
delete from eam_asset_repair where 1=1    ;
delete from eam_asset_scrap where 1=1    ;
delete from eam_asset_allocation where 1=1    ;
delete from eam_asset_borrow where 1=1    ;
delete from eam_failure_registration where 1=1   ;
delete from eam_asset_borrow_return where 1=1   ;
delete from eam_asset_collection where 1=1    ;
delete from eam_asset_collection_return where 1=1    ;
delete from eam_asset_handle where 1=1    ;
delete from eam_asset_tranfer where 1=1    ;
delete from eam_asset_storage where 1=1    ;
delete from eam_purchase_apply  where 1=1    ;
delete from eam_purchase_apply_item  where 1=1    ;
delete from eam_purchase_check  where 1=1    ;
delete from eam_purchase_order_detail  where 1=1    ;
delete from eam_asset_storage  where 1=1    ;
delete from eam_purchase_order  where 1=1    ;
-- delete from eam_asset_depreciation  where 1=1;
-- eam_asset_depreciation
delete from eam_asset_depreciation_oper  where 1=1;
delete from eam_asset_depreciation_detail  where 1=1;
delete from eam_asset_depreciation_detail  where 1=1;
delete from eam_asset_depreciation_exclude  where 1=1;
delete from eam_asset_maintenance_update  where 1=1;
-- software
delete from eam_asset_software  where 1=1    ;
delete from eam_asset_software_change  where 1=1    ;
delete from eam_asset_software_change_detail  where 1=1 ;
delete from eam_asset_software_distribute  where 1=1    ;
delete from eam_asset_software_distribute_data  where 1=1 ;
delete from eam_asset_software_maintenance  where 1=1    ;
delete from eam_asset_software_maintenance_detail  where 1=1;
-- stock
delete from eam_asset_stock_deliver  where 1=1   ;
delete from eam_asset_stock_collection  where 1=1   ;
delete from eam_asset_stock_goods  where 1=1   ;
delete from eam_asset_stock_goods_adjust  where 1=1   ;
delete from eam_asset_stock_goods_detail  where 1=1  ;
delete from eam_asset_stock_goods_in  where 1=1   ;
delete from eam_asset_stock_goods_out  where 1=1   ;
delete from eam_asset_stock_goods_tranfer  where 1=1   ;
delete from eam_asset_stock_goods_use  where 1=1   ;
delete from eam_goods_stock_usage  where 1=1;
delete from eam_goods_stock where owner_code<>'goods';
-- inventory
delete from eam_inventory where 1=1   ;
delete from eam_inventory_asset where 1=1 ;
delete from eam_inventory_director where 1=1 ;
delete from eam_inventory_manager where 1=1 ;
delete from eam_inventory_user where 1=1 ;
delete from eam_inventory_plan where 1=1   ;
delete from eam_group_user where 1=1;
-- eam_maintain
delete from eam_maintain_plan where tenant_id='T001';
delete from eam_maintain_group where tenant_id='T001';
delete from eam_maintain_project where tenant_id='T001';
delete from eam_maintain_project_select where 1=1;
delete from eam_maintain_task where tenant_id='T001';
delete from eam_maintain_task_project where 1=1;
delete from eam_purchase_import where 1=1;
delete from eam_stock_import where 1=1;
-- repair
-- delete from eam_repair_category where tenant_id='T001';
-- delete from eam_repair_category_tpl where tenant_id='T001';
delete from eam_repair_group  where tenant_id='T001';
delete from eam_repair_order  where tenant_id='T001';
delete from eam_repair_order_acceptance  where tenant_id='T001';
delete from eam_repair_order_act  where tenant_id='T001';
delete from eam_repair_rule  where tenant_id='T001';
delete from eam_repair_rule_item where 1=1;
-- inspection
-- delete from eam_inspection_group where tenant_id='T001';
delete from eam_inspection_group_user where 1=1;
delete from eam_inspection_plan  where tenant_id='T001';
delete from eam_inspection_plan_point  where tenant_id='T001';
-- delete from eam_inspection_point  where tenant_id='T001';
delete from eam_inspection_point_owner  where tenant_id='T001';
-- delete from eam_inspection_route  where tenant_id='T001';
delete from eam_inspection_task  where tenant_id='T001';
delete from eam_inspection_task_point  where 1=1;
-- stock
delete from eam_stock where 1=1   ;
delete from eam_asset_stock_collection where 1=1;
-- asset rack
-- delete from eam_asset_rack where 1=1;
-- delete from eam_asset_rack_info where 1=1;
-- cont
delete from cont_contract where 1=1   ;
delete from cont_contract_attachment where 1=1    ;
delete from cont_contract_performance where 1=1    ;
delete from cont_contract_signer where 1=1   ;
delete from cont_contract_archive where 1=1   ;
delete from cont_contract_collect where 1=1   ;
delete from cont_contract_invoice where 1=1   ;
delete from cont_contract_pay where 1=1   ;
delete from cont_contract_collect where 1=1   ;
-- maintenance
delete from eam_asset_maintenance_record where 1=1;
delete from eam_asset_maintenance_record_u where 1=1;
delete from eam_asset_maintenance_update where 1=1;
-- other
delete from eam_feedback where 1=1 ;
-- job
delete from sys_job_log where 1=1;
-- kn
delete from kn_content where 1=1   ;
-- ops
delete from ops_host where 1=1   ;
delete from ops_host_db where 1=1 ;
delete from ops_host_mid where 1=1;
delete from ops_host_os where 1=1;
delete from ops_information_system where 1=1   ;
delete from ops_db_instance where 1=1   ;
delete from ops_voucher where 1=1   ;
delete from ops_voucher_history where 1=1   ;
delete from ops_voucher_owner where 1=1   ;
delete from ops_voucher_priv where 1=1   ;
delete from ops_person where 1=1   ;
delete from ops_ip_address_range where 1=1;
delete from ops_system_console_info where 1=1;
delete from ops_ciphertext_history where 1=1;
delete from ops_ciphertext_box_data where 1=1;
delete from ops_ciphertext_box where deleted=1;
delete from ops_ciphertext_conf where deleted=1;
delete from ops_ciphertext_conf where user_id<>'E001';
delete from ops_db_info where 1=1;
delete from ops_db_backup_record where 1=1;
delete from ops_db_backup_log where 1=1;
-- ops_certificate
delete from ops_certificate where 1=1;
-- eam employ
delete from eam_asset_employee_apply where 1=1   ;
delete from eam_asset_employee_handover where 1=1   ;
delete from eam_asset_employee_loss where 1=1   ;
delete from eam_asset_employee_repair where 1=1   ;
delete from eam_device_sp where 1=1   ;
-- workorder
delete from wo_network_strategy_apply where 1=1   ;
delete from wo_network_strategy_info ;
delete from wo_server_apply where 1=1   ;
delete from wo_server_info where 1=1;
delete from wo_slb_strategy_apply where 1=1   ;
delete from wo_slb_strategy_info where 1=1;
-- vehicle
delete from vehicle_a_select_item where 1=1;
delete from vehicle_apply where 1=1;
delete from vehicle_info where 1=1;
delete from vehicle_insurance_record where 1=1;
delete from vehicle_m_select_item where 1=1;
delete from vehicle_maintenance where 1=1;
delete from vehicle_select_item where 1=1;
-- BPM
delete from bpm_demo_leave;
delete from bpm_demo_common;
delete from bpm_form_instance;
delete from bpm_form_instance_bill;
delete from bpm_process_instance;
delete from bpm_task;
delete from bpm_task_approval;
delete from bpm_process_error;
delete from bpm_task_assignee;
delete from bpm_process_definition_deploy;
delete from bpm_process_definition_node_assignee where node_id not in (select id from bpm_process_definition_node where process_definition_file_id in (select id from bpm_process_definition_file where activated=1));
delete from bpm_process_definition_node where process_definition_file_id in (select id from bpm_process_definition_file where activated=0);
delete from bpm_process_definition_file where activated=0;
delete from bpm_form_definition where deleted=1;
-- PCM
delete from pcm_catalog where id='484764974338543617';
delete from pcm_catalog where id='484764976855126017';
-- HRM
delete from hr_person  where 1=1;
delete from hr_person_contract  where 1=1;
delete from hr_salary_action  where 1=1;
delete from hr_person_resume  where 1=1;
delete from hr_person_attendance where 1=1;
delete from hr_person_attendance_money where 1=1;
delete from hr_person_attendance_rec where 1=1;
delete from hr_person_cert where 1=1;
delete from hr_person_file where 1=1;
delete from hr_person_file_out where 1=1;
delete from hrm_employee  where deleted=1;
delete from hrm_person  where deleted=1;
delete from hrm_company  where deleted=1;
delete from hrm_organization  where deleted=1;
delete from hrm_position  where deleted=1;
delete from hrm_employee_position  where deleted=1;
delete from hrm_favourite_group  where deleted=1;
delete from hrm_favourite_group_item  where deleted=1;
-- ops auto
delete from ops_auto_batch  where 1=1;
delete from ops_auto_batch_node  where  1=1;
delete from ops_auto_group  where  1=1;
delete from ops_auto_node  where  1=1;
delete from ops_auto_node_select  where  1=1;
delete from ops_auto_task  where  1=1;
delete from ops_auto_task_log  where  1=1;
delete from ops_auto_task_m_log  where  1=1;
delete from ops_auto_task_node  where  1=1;
delete from ops_auto_voucher  where 1=1;
delete from ops_monitor_node  where 1=1;
-- ops auto deploy
delete from ops_auto_action_file where id not like 'T001%';
delete from ops_auto_action_script where id not like 'T001%';
delete from ops_software_media where 1=1;
delete from ops_auto_node where 1=1;
delete from ops_auto_action where id not like 'T001%';
-- custom middle table
delete from eam_c1_mapping where 1=1;
delete from eam_c1_qh_fa_additions where 1=1;
delete from eam_c1_sync_asset_record where 1=1;
delete from eam_c1_sync_asset where 1=1;
delete from sys_log_collect where 1=1;
delete from sys_material_resource where 1=1;
-- clear hrm
-- delete from hrm_organization where id not in ('2');
delete from sys_user where deleted=1;
delete from sys_user_tenant where deleted=1;
delete from hrm_employee where deleted=1;
delete from hrm_person where deleted=1;
delete from sys_user where account not in (select value from sys_user_keep);
delete from sys_user_tenant where user_id not in (select id from sys_user);
delete from hrm_employee where id not in (select employee_id from sys_user_tenant);
delete from hrm_person where id not in (select person_id from hrm_employee);
-- clear hr
delete from hr_person where deleted=1;
delete from hr_person_contract where 1=1;
delete from sys_user_import where 1=1;
-- check data
-- select * from sys_user a,sys_user_tenant b,hrm_employee c,hrm_person d,hrm_employee_position f where a.id=b.user_id and b.employee_id=c.id and c.person_id=d.id and f.employee_id=c.id
delete from sys_user where deleted=1;
delete from sys_user_tenant where deleted=1;
delete from hrm_employee where deleted=1;
delete from hrm_person where deleted=1;
delete from sys_role_user where deleted=1;
delete from hrm_employee_position where deleted=1;
delete from hrm_position where deleted=1;
-- user
update sys_user set portrait_id='T001_image_head';
delete from sys_user_tenant where user_id not in (select id from sys_user);
delete from hrm_employee where id not in ( select employee_id from sys_user_tenant);
delete from hrm_person where id not in (select person_id from hrm_employee);
delete from sys_role_user where user_id not in (select id from sys_user);
delete from hrm_employee_position where employee_id not in (select id from hrm_employee);
-- menu
delete from sys_role where deleted=1;
delete from sys_menu where deleted=1;
delete from sys_role_menu where role_id not in (select id from sys_role);
delete from sys_role_menu where menu_id not in (select id from sys_menu);
delete from sys_menu_resource where menu_id not in (select id from sys_menu);
delete from sys_menu_resource where resource_id not in (select id from sys_resourze);
-- netdisk
delete from oa_netdisk_file where 1=1;
delete from oa_netdisk_folder where 1=1;
delete from oa_netdisk_origin_file where 1=1;
delete from oa_netdisk_recycle where 1=1;
delete from oa_netdisk_share_me where 1=1;
delete from oa_netdisk_virtual_fd where 1=1;
delete from oa_netdisk_my_share where 1=1;
delete from oa_netdisk_my_favorite where 1=1;
-- delete
update sys_user set portrait_id ='T001_image_head' where 1=1;
-- select * from sys_user a,sys_user_tenant b,hrm_employee c,hrm_person d,hrm_employee_position f where a.id=b.user_id and b.employee_id=c.id and c.person_id=d.id and f.employee_id=c.id
delete from sys_user where deleted=1;
delete from sys_user_tenant where deleted=1;
delete from hrm_employee where deleted=1;
delete from hrm_person where deleted=1;
delete from sys_role_user where deleted=1;
delete from hrm_employee_position where deleted=1;
delete from hrm_position where deleted=1;
delete from hrm_position where org_id not in (select id from hrm_organization);
-- user
update sys_user set portrait_id='T001_image_head';
delete from sys_user_tenant where user_id not in (select id from sys_user);
delete from hrm_employee where id not in ( select employee_id from sys_user_tenant);
delete from hrm_person where id not in (select person_id from hrm_employee);
delete from sys_role_user where user_id not in (select id from sys_user);
delete from hrm_employee_position where employee_id not in (select id from hrm_employee);
-- menu
delete from sys_role where deleted=1;
delete from sys_menu where deleted=1;
delete from sys_role_menu where role_id not in (select id from sys_role);
delete from sys_role_menu where menu_id not in (select id from sys_menu);
delete from sys_menu_resource where menu_id not in (select id from sys_menu);
delete from sys_menu_resource where resource_id not in (select id from sys_resourze);
commit;
