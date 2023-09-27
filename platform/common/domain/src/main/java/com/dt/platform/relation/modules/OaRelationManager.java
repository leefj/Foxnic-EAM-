package com.dt.platform.relation.modules;

 
import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.OaTables;

import com.dt.platform.constants.enums.oa.NetDiskFileTypeEnum;
import com.dt.platform.domain.eam.meta.DeviceSpMeta;
import com.dt.platform.domain.oa.*;
import com.dt.platform.domain.oa.meta.*;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;

public class OaRelationManager extends RelationManager {

	@Override
	protected void config() {
		this.setupSystemInformation();
		this.setupInfo();
		this.setupVehicleApply();
		this.setupVehicleMaintenance();
		this.setupSchedulePlan();
		this.setupNotice();
		this.setupWorkRpt();
		this.setupMeetingRoom();
		this.setupMeetingRoomBookRcd();

		this.setupCustomerLeader();
		this.setupCustomerLeads();
		this.setupCustomerBusiness();
		this.setupCustomerReview();
		this.setupCustomerRecord();
		this.setupCustomerContact();
		this.setupCustomerFollow();
		this.setupCustomerTeam();
		this.setupCustomer();

		this.setupNetDiskFile();
		this.setupNetDiskFolder();
		this.setupNetDiskMyFav();
		this.setupNetDiskOriginFile();
		this.setupNetDiskShareMe();
		this.setupNetDiskMyShare();
		this.setupNetDiskRecycle();
		this.setupNetDiskVirtualFile();
		this.setupNetDiskResourceLimit();
	}

	public void setupNetDiskResourceLimit() {
		this.property(NetdiskResourceLimitMeta.USER_PROP)
				.using(OaTables.OA_NETDISK_RESOURCE_LIMIT.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

	}

	public void setupNetDiskVirtualFile() {
		this.property(NetdiskVirtualFdMeta.OWNER_USER_PROP)
				.using(OaTables.OA_NETDISK_VIRTUAL_FD.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(NetdiskVirtualFdMeta.NETDISK_FILE_PROP)
				.using(OaTables.OA_NETDISK_VIRTUAL_FD.FD_ID).join(OaTables.OA_NETDISK_FILE.ID);

		this.property(NetdiskVirtualFdMeta.NETDISK_ORIGIN_FILE_PROP)
				.using(OaTables.OA_NETDISK_VIRTUAL_FD.FD_ID).join(OaTables.OA_NETDISK_FILE.ID)
				.using(OaTables.OA_NETDISK_FILE.ORIGIN_FILE_ID).join(OaTables.OA_NETDISK_ORIGIN_FILE.ID);

	}
	public void setupNetDiskFile() {
		this.property(NetdiskFileMeta.OWNER_USER_PROP)
				.using(OaTables.OA_NETDISK_FILE.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(NetdiskFileMeta.NETDISK_ORIGIN_FILE_PROP)
				.using(OaTables.OA_NETDISK_FILE.ORIGIN_FILE_ID).join(OaTables.OA_NETDISK_ORIGIN_FILE.ID);

		this.property(NetdiskFileMeta.NETDISK_FOLDER_PROP)
				.using(OaTables.OA_NETDISK_FILE.FOLDER_ID).join(OaTables.OA_NETDISK_FOLDER.ID);

	}

	public void setupNetDiskFolder() {
		this.property(NetdiskFolderMeta.OWNER_USER_PROP)
				.using(OaTables.OA_NETDISK_FOLDER.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

	}


	public void setupNetDiskRecycle() {

		this.property(NetdiskRecycleMeta.OWNER_USER_PROP)
				.using(OaTables.OA_NETDISK_RECYCLE.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(NetdiskRecycleMeta.NETDISK_ORIGIN_FILE_PROP)
				.using(OaTables.OA_NETDISK_RECYCLE.FD_ID).join(OaTables.OA_NETDISK_FILE.ID)
				.using(OaTables.OA_NETDISK_FILE.ORIGIN_FILE_ID).join(OaTables.OA_NETDISK_ORIGIN_FILE.ID);

		this.property(NetdiskRecycleMeta.NETDISK_FILE_PROP)
				.using(OaTables.OA_NETDISK_RECYCLE.FD_ID).join(OaTables.OA_NETDISK_FILE.ID);

		this.property(NetdiskRecycleMeta.NETDISK_FOLDER_PROP)
				.using(OaTables.OA_NETDISK_RECYCLE.FD_ID).join(OaTables.OA_NETDISK_FOLDER.ID);

	}

	public void setupNetDiskMyFav() {

		this.property(NetdiskMyFavoriteMeta.OWNER_USER_PROP)
				.using(OaTables.OA_NETDISK_MY_FAVORITE.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(NetdiskMyFavoriteMeta.NETDISK_ORIGIN_FILE_PROP)
				.using(OaTables.OA_NETDISK_MY_FAVORITE.FD_ID).join(OaTables.OA_NETDISK_FILE.ID)
					.using(OaTables.OA_NETDISK_FILE.ORIGIN_FILE_ID).join(OaTables.OA_NETDISK_ORIGIN_FILE.ID);


		this.property(NetdiskMyFavoriteMeta.NETDISK_FILE_PROP)
				.using(OaTables.OA_NETDISK_MY_FAVORITE.FD_ID).join(OaTables.OA_NETDISK_FILE.ID);

	}

	public void setupNetDiskOriginFile() {
		this.property(NetdiskOriginFileMeta.OWNER_USER_PROP)
				.using(OaTables.OA_NETDISK_ORIGIN_FILE.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

	}

	public void setupNetDiskMyShare() {

		this.property(NetdiskMyShareMeta.OWNER_USER_PROP)
				.using(OaTables.OA_NETDISK_MY_SHARE.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(NetdiskMyShareMeta.NETDISK_FILE_PROP)
				.using(OaTables.OA_NETDISK_MY_SHARE.FILE_ID).join(OaTables.OA_NETDISK_FILE.ID);

		this.property(NetdiskMyShareMeta.NETDISK_ORIGIN_FILE_PROP)
				.using(OaTables.OA_NETDISK_MY_SHARE.FILE_ID).join(OaTables.OA_NETDISK_FILE.ID)
				.using(OaTables.OA_NETDISK_FILE.ORIGIN_FILE_ID).join(OaTables.OA_NETDISK_ORIGIN_FILE.ID);


	}

	public void setupNetDiskShareMe() {
		this.property(NetdiskShareMeMeta.OWNER_USER_PROP)
				.using(OaTables.OA_NETDISK_SHARE_ME.OWNER_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(NetdiskShareMeMeta.USER_PROP)
				.using(OaTables.OA_NETDISK_SHARE_ME.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(NetdiskShareMeMeta.NETDISK_ORIGIN_FILE_PROP)
				.using(OaTables.OA_NETDISK_SHARE_ME.FILE_ID).join(OaTables.OA_NETDISK_FILE.ID)
				.using(OaTables.OA_NETDISK_FILE.ORIGIN_FILE_ID).join(OaTables.OA_NETDISK_ORIGIN_FILE.ID);

		this.property(NetdiskShareMeMeta.NETDISK_FILE_PROP)
				.using(OaTables.OA_NETDISK_SHARE_ME.FILE_ID).join(OaTables.OA_NETDISK_FILE.ID);


	}

	public void setupCustomerLeads() {

		this.property(CrmCustomerLeadsMeta.ORIGINATOR_PROP)
				.using(OaTables.OA_CRM_CUSTOMER_LEADS.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(CrmCustomerLeadsMeta.OWNER_PROP)
				.using(OaTables.OA_CRM_CUSTOMER_LEADS.OWNER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(CrmCustomerLeadsMeta.CRM_CUSTOMER_INDUSTRY_PROP)
				.using(OaTables.OA_CRM_CUSTOMER_LEADS.INDUSTRY_ID).join(OaTables.OA_CRM_CUSTOMER_INDUSTRY.ID);

		this.property(CrmCustomerLeadsMeta.CRM_CUSTOMER_LEVEL_PROP)
				.using(OaTables.OA_CRM_CUSTOMER_LEADS.LEVEL).join(OaTables.OA_CRM_CUSTOMER_LEVEL.ID);

		this.property(CrmCustomerLeadsMeta.CRM_CUSTOMER_INTENTIONAL_PROP)
				.using(OaTables.OA_CRM_CUSTOMER_LEADS.INTENTIONAL_STATE).join(OaTables.OA_CRM_CUSTOMER_INTENTIONAL.ID);

		this.property(CrmCustomerLeadsMeta.CRM_CUSTOMER_SOURCE_PROP)
				.using(OaTables.OA_CRM_CUSTOMER_LEADS.SOURCE_ID).join(OaTables.OA_CRM_CUSTOMER_SOURCE.ID);


	}

	public void setupCustomer() {


		this.property(CrmCustomerMeta.CRM_CUSTOMER_BUSINESS_LIST_PROP)
				.using(OaTables.OA_CRM_CUSTOMER.ID).join(OaTables.OA_CRM_CUSTOMER_BUSINESS.CUSTOMER_ID);

		this.property(CrmCustomerMeta.CRM_CUSTOMER_CONTACT_LIST_PROP)
				.using(OaTables.OA_CRM_CUSTOMER.ID).join(OaTables.OA_CRM_CUSTOMER_CONTACT.CUSTOMER_ID);

		this.property(CrmCustomerMeta.CRM_CUSTOMER_REVIEW_LIST_PROP)
				.using(OaTables.OA_CRM_CUSTOMER.ID).join(OaTables.OA_CRM_CUSTOMER_REVIEW.CUSTOMER_ID);


		this.property(CrmCustomerMeta.CRM_CUSTOMER_RECORD_LIST_PROP)
				.using(OaTables.OA_CRM_CUSTOMER.ID).join(OaTables.OA_CRM_CUSTOMER_RECORD.CUSTOMER_ID);

		this.property(CrmCustomerMeta.CRM_CUSTOMER_FOLLOW_LIST_PROP)
				.using(OaTables.OA_CRM_CUSTOMER.ID).join(OaTables.OA_CRM_CUSTOMER_FOLLOW.CUSTOMER_ID);



		this.property(CrmCustomerMeta.CRM_FIRST_CUSTOMER_CONTACT_PROP)
				.using(OaTables.OA_CRM_CUSTOMER.ID).join(OaTables.OA_CRM_CUSTOMER_CONTACT.CUSTOMER_ID)
				.condition("role='first_contact'");


		this.property(CrmCustomerMeta.ORIGINATOR_PROP)
				.using(OaTables.OA_CRM_CUSTOMER.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(CrmCustomerMeta.OWNER_PROP)
				.using(OaTables.OA_CRM_CUSTOMER.OWNER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);



		this.property(CrmCustomerMeta.CRM_CUSTOMER_INDUSTRY_PROP)
				.using(OaTables.OA_CRM_CUSTOMER.INDUSTRY_ID).join(OaTables.OA_CRM_CUSTOMER_INDUSTRY.ID);

		this.property(CrmCustomerMeta.CRM_CUSTOMER_LEVEL_PROP)
				.using(OaTables.OA_CRM_CUSTOMER.LEVEL).join(OaTables.OA_CRM_CUSTOMER_LEVEL.ID);

		this.property(CrmCustomerMeta.CRM_CUSTOMER_INTENTIONAL_PROP)
				.using(OaTables.OA_CRM_CUSTOMER.INTENTIONAL_STATE).join(OaTables.OA_CRM_CUSTOMER_INTENTIONAL.ID);

		this.property(CrmCustomerMeta.CRM_CUSTOMER_SOURCE_PROP)
				.using(OaTables.OA_CRM_CUSTOMER.SOURCE_ID).join(OaTables.OA_CRM_CUSTOMER_SOURCE.ID);


	}


	public void setupCustomerTeam() {

		this.property(CrmCustomerTeamMeta.USER_PROP)
				.using(OaTables.OA_CRM_CUSTOMER_TEAM.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(CrmCustomerTeamMeta.CRM_CUSTOMER_PROP)
				.using(OaTables.OA_CRM_CUSTOMER_TEAM.CUSTOMER_ID).join(OaTables.OA_CRM_CUSTOMER.ID);

	}


	public void setupCustomerBusiness() {
		this.property(CrmCustomerBusinessMeta.ORIGINATOR_PROP)
				.using(OaTables.OA_CRM_CUSTOMER_BUSINESS.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(CrmCustomerBusinessMeta.CRM_CUSTOMER_PROP)
				.using(OaTables.OA_CRM_CUSTOMER_BUSINESS.CUSTOMER_ID).join(OaTables.OA_CRM_CUSTOMER.ID);

	}

	public void setupCustomerRecord() {
		this.property(CrmCustomerRecordMeta.ORIGINATOR_PROP)
				.using(OaTables.OA_CRM_CUSTOMER_RECORD.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(CrmCustomerRecordMeta.CRM_CUSTOMER_PROP)
				.using(OaTables.OA_CRM_CUSTOMER_RECORD.CUSTOMER_ID).join(OaTables.OA_CRM_CUSTOMER.ID);

	}


	public void setupCustomerLeader() {




	}


	public void setupCustomerFollow() {
		this.property(CrmCustomerFollowMeta.ORIGINATOR_PROP)
				.using(OaTables.OA_CRM_CUSTOMER_FOLLOW.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(CrmCustomerFollowMeta.CRM_CUSTOMER_PROP)
				.using(OaTables.OA_CRM_CUSTOMER_FOLLOW.CUSTOMER_ID).join(OaTables.OA_CRM_CUSTOMER.ID);

	}

	public void setupCustomerContact() {
		this.property(CrmCustomerContactMeta.ORIGINATOR_PROP)
				.using(OaTables.OA_CRM_CUSTOMER_CONTACT.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(CrmCustomerContactMeta.CRM_CUSTOMER_PROP)
				.using(OaTables.OA_CRM_CUSTOMER_CONTACT.CUSTOMER_ID).join(OaTables.OA_CRM_CUSTOMER.ID);

	}


	public void setupCustomerReview() {
		this.property(CrmCustomerReviewMeta.ORIGINATOR_PROP)
				.using(OaTables.OA_CRM_CUSTOMER_REVIEW.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(CrmCustomerReviewMeta.REVIEW_USER_PROP)
				.using(OaTables.OA_CRM_CUSTOMER_REVIEW.REVIEW_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);


		this.property(CrmCustomerReviewMeta.CRM_CUSTOMER_PROP)
				.using(OaTables.OA_CRM_CUSTOMER_REVIEW.CUSTOMER_ID).join(OaTables.OA_CRM_CUSTOMER.ID);

		this.property(CrmCustomerReviewMeta.REVIEW_METHOD_PROP)
				.using(OaTables.OA_CRM_CUSTOMER_REVIEW.METHOD_ID).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='crm_customer_review_type'");

		this.property(CrmCustomerReviewMeta.SATISFACTION_PROP)
				.using(OaTables.OA_CRM_CUSTOMER_REVIEW.SATISFACTION_ID).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='crm_customer_satisfaction'");



	}

	public void setupMeetingRoomBookRcd() {
		this.property(MeetingRoomBookRcdMeta.MEETING_ROOM_PROP)
				.using(OaTables.OA_MEETING_ROOM_BOOK_RCD.ROOM_ID).join(OaTables.OA_MEETING_ROOM.ID);

		this.property(MeetingRoomBookRcdMeta.BOOKER_PROP)
				.using(OaTables.OA_MEETING_ROOM_BOOK_RCD.BOOKER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(MeetingRoomBookRcdMeta.USER_PROP)
				.using(OaTables.OA_MEETING_ROOM_BOOK_RCD.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(MeetingRoomBookRcdMeta.ORG_PROP)
				.using(OaTables.OA_MEETING_ROOM_BOOK_RCD.ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

	}

	public void setupMeetingRoom() {
		this.property(MeetingRoomMeta.MEETING_ROOM_POSITION_PROP)
				.using(OaTables.OA_MEETING_ROOM.POSITION_ID).join(OaTables.OA_MEETING_ROOM_POSITION.ID);

	}
	public void setupWorkRpt() {
		this.property(WorkRptMeta.RECEIVER_PROP)
				.using(OaTables.OA_WORK_RPT.RECEIVER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(WorkRptMeta.REPORT_USER_PROP)
				.using(OaTables.OA_WORK_RPT.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

	}


	public void setupNotice() {

		this.property(NoticeMeta.USER_PROP)
				.using(OaTables.OA_NOTICE.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

	}




	public void setupSchedulePlan() {
		this.property(SchedulePlanMeta.SCHEDULE_REMIND_PROP)
				.using(OaTables.OA_SCHEDULE_PLAN.REMIND).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='oa_schedule_remind'");

	}




	public void setupSystemInformation() {

		this.property(SystemInformationMeta.TYPE_DATA_PROP)
				.using(OaTables.OA_SYSTEM_INFORMATION.TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='oa_system_information_type'");

	}



	public void setupInfo() {
		// 关联字段
		//关联 所属公司
		this.property(VehicleInfoMeta.VEHICLE_INSURANCE_COMPANY_PROP)
				.using(OaTables.OA_VEHICLE_INFO.INSURANCE_COMPANY).join(OaTables.OA_VEHICLE_INSURANCE_COMPANY.ID);

		this.property(VehicleInfoMeta.OWNER_COMPANY_PROP)
				.using(OaTables.OA_VEHICLE_INFO.OWNER_ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

		//关联 使用组织
		this.property(VehicleInfoMeta.USE_ORGANIZATION_PROP)
				.using(OaTables.OA_VEHICLE_INFO.USE_ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

		this.property(VehicleInfoMeta.VEHICLE_TYPE_DICT_PROP)
				.using(OaTables.OA_VEHICLE_INFO.TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='vehicle_type'");

		this.property(VehicleInfoMeta.VEHICLE_STATUS_DICT_PROP)
				.using(OaTables.OA_VEHICLE_INFO.VEHICLE_STATUS).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='vehicle_status'");

		//制单人
		this.property(VehicleInfoMeta.ORIGINATOR_PROP)
				.using(OaTables.OA_VEHICLE_INFO.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(VehicleInfoMeta.USE_USER_PROP)
				.using(OaTables.OA_VEHICLE_INFO.USE_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);


//

	}

	public void setupVehicleApply() {
		// 关联字段
		this.property(VehicleApplyMeta.USE_ORGANIZATION_PROP)
				.using(OaTables.OA_VEHICLE_APPLY.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(VehicleApplyMeta.RECEIVER_PROP)
				.using(OaTables.OA_VEHICLE_APPLY.RECEIVER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(VehicleApplyMeta.VEHICLE_INFO_PROP)
				.using(OaTables.OA_VEHICLE_APPLY.VEHICLE_ID ).join(OaTables.OA_VEHICLE_INFO.ID);


	}

	public void setupVehicleMaintenance() {

		// 关联字段
		this.property(VehicleMaintenanceMeta.MAINTENANCE_DICT_PROP)
				.using(OaTables.OA_VEHICLE_MAINTENANCE.TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='vehicle_maintenance_type'");

		this.property(VehicleMaintenanceMeta.ORIGINATOR_PROP)
				.using(OaTables.OA_VEHICLE_MAINTENANCE.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

//		this.property(VehicleMaintenanceMeta.VEHICLE_INFO_LIST_PROP)
//				.using(OaTables.OA_VEHICLE_MAINTENANCE.ID ).join(OaTables.OA_VEHICLE_M_SELECT_ITEM.HANDLE_ID)
//				.using( OaTables.OA_VEHICLE_M_SELECT_ITEM.ASSET_ID).join( OaTables.OA_VEHICLE_INFO.ID);

		this.property(VehicleMaintenanceMeta.VEHICLE_INFO_PROP)
				.using(OaTables.OA_VEHICLE_MAINTENANCE.VEHICLE_ID ).join(OaTables.OA_VEHICLE_INFO.ID);


	}




}
