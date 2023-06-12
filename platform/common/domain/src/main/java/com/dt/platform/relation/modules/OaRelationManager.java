package com.dt.platform.relation.modules;

 
import com.dt.platform.constants.db.OaTables;

import com.dt.platform.domain.oa.meta.SystemInformationMeta;
import com.dt.platform.domain.oa.meta.VehicleApplyMeta;
import com.dt.platform.domain.oa.meta.VehicleInfoMeta;
import com.dt.platform.domain.oa.meta.VehicleMaintenanceMeta;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;

public class OaRelationManager extends RelationManager {

	@Override
	protected void config() {
		this.setupSystemInformation();


		this.setupInfo();
		this.setupVehicleApply();
		this.setupVehicleMaintenance();

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
