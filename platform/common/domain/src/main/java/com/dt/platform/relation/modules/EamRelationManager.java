package com.dt.platform.relation.modules;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.AssetInventoryDetailStatusEnum;

import com.dt.platform.constants.enums.eam.InspectionTaskPointStatusEnum;
import com.dt.platform.constants.enums.eam.MaintainTaskProjectStatusEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.*;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EamRelationManager extends RelationManager {
    @Override
    protected void config() {

//定制
//        this.setupCustRepairItem();
//        this.setupCustRepairApply();
//        this.setupCustInspectItem();
//        this.setupCustInspectTask();
//        this.setupCustInspectPlan();
//        this.setupCustInspectTpl();

//通用
        this.setupRelations();
        this.setupProperties();
        this.setupAssetDataPermissions();
        this.setupAsset();
        this.setupAlloction();
        this.setupAssetBorrow();
        this.setupAssetCollection();
        this.setupAssetCollectionReturn();
        this.setupAssetHandle();
        this.setupAssetRepair();
        this.setupAssetStorage();
        this.setupAssetTranfer();



        this.setupScrap();
        this.setupAssetAttributeItem();
        this.setupInventoryPlan();
        this.setupInventory();
        this.setupInventoryUser();
        this.setupInventoryDirecotor();
        this.setupInventoryAsset();
        this.setupInventoryManager();
        this.setupTplFile();
        this.setupAssetDataChange();


        this.setupGoods();
        this.setupGoodsStock();
        this.setupAssetStockIn();
        this.setupAssetStockOut();
        this.setupAssetStockAdjust();
        this.setupAssetStockTranfer();
        this.setupAssetStockUsage();

        this.setupAssetStock();
        this.setupAssetStockCollection();
        this.setupAssetStockDeliver();
        this.setupAssetStockGoods();

        this.setupAssetStockUse();

        this.setupPurchaseApply();
        this.setupPurchaseCheck();
        this.setupPurchaseOrder();
        this.setupPurchaseImport();

        this.setupInspectionGroup();
        this.setupInspectionPlan();
        this.setupInspectionPoint();
        this.setupInspectionTask();
        this.setupInspectionTaskAbnormal();
        this.setupInspectionTaskPoint();
        this.setupInspectionOwner();


        this.setupAssetDepreciationDetail();
        this.setupAssetDepreciationOper();
        this.setupAssetDepreciation();
        this.setupAssetDepreciationExclude();
        this.setupAssetDepreciationCalRule();
        this.setupAssetDepreciationHistory();

        this.setupAssetSoftware();
        this.setupAssetSoftwareDistribute();
        this.setupAssetSoftChange();
        this.setupAssetSoftChangeDetail();
        this.setupAssetSoftMaintenance();
        this.setupAssetLabel();
        this.setupAssetLabelTpl();
        this.setupAssetLabelTplItem();


        this.setupFailureRegistration();
        this.setupRepairGroup();
        this.setupRepairCategoryTpl();
        this.setupRepairOrder();
        this.setupRepairOrderAct();
        this.setupRepairOrderTransfer();
        this.setupRepairOrderAccept();
        this.setupRepairRule();

        this.setupMaintainProject();
        this.setupMaintainPlan();
        this.setupMaintainGroup();
        this.setupMaintainTask();
        this.setupMaintainTaskProject();
        this.setupCrontab();

        this.setupEmployeeApply();
        this.setupEmployeeRepair();
        this.setupEmployeeLoss();
        this.setupEmployeeHandover();

        this.setupSupplier();
        this.setupAssetStatusRuleV();


        this.setupAssetRack2();
        this.setupAssetRackInfo();
        this.setupAssetMaintenanceRecord();
        this.setupAssetMaintenanceRecordUpdate();
        this.setupAssetBorrowReturn();

        this.setupRfidLabel();
        this.setupRfidRelease();
        this.setupCheckGroup();
        this.setupCheckSelect();

        this.setupDeviceSp();
        this.setupDeviceSpRcd();

        this.setupStockImport();
    }

    public void setupAssetStockUse() {

        this.property(AssetStockGoodsUseMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS_USE.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(AssetStockGoodsUseMeta.ASSET_STOCK_GOODS_LIST_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS_USE.ID).join(EAMTables.EAM_GOODS_STOCK.OWNER_ID)
             .condition("owner_tmp_id='none'");

    }


    public void setupDeviceSp() {
        this.property(DeviceSpMeta.WAREHOUSE_PROP)
                .using(EAMTables.EAM_DEVICE_SP.WAREHOUSE_ID).join(EAMTables.EAM_WAREHOUSE.ID);

        this.property(DeviceSpMeta.GOODS_PROP)
                .using(EAMTables.EAM_DEVICE_SP.GOOD_ID).join(EAMTables.EAM_GOODS_STOCK.ID);

        this.property(DeviceSpMeta.DEVICE_SP_TYPE_PROP)
                .using(EAMTables.EAM_DEVICE_SP.TYPE).join(EAMTables.EAM_DEVICE_SP_TYPE.ID);

        this.property(DeviceSpMeta.POSITION_PROP)
                .using(EAMTables.EAM_DEVICE_SP.LOC_ID).join(EAMTables.EAM_POSITION.ID);

        this.property(DeviceSpMeta.MANAGER_PROP)
                .using(EAMTables.EAM_DEVICE_SP.MANAGER_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(DeviceSpMeta.USAGE_PROP)
                .using(EAMTables.EAM_DEVICE_SP.USAGE_RANGE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_sp_usage_range'");


    }
    public void setupDeviceSpRcd() {
        this.property(DeviceSpRcdMeta.DEVICE_SP_PROP)
                .using(EAMTables.EAM_DEVICE_SP_RCD.SP_ID).join(EAMTables.EAM_DEVICE_SP.ID);

        this.property(DeviceSpRcdMeta.OPER_USER_PROP)
                .using(EAMTables.EAM_DEVICE_SP_RCD.OPER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
    }
    public void setupCheckSelect() {
        this.property(CheckSelectMeta.CHECK_ITEM_PROP)
                .using(EAMTables.EAM_CHECK_SELECT.ITEM_ID).join(EAMTables.EAM_CHECK_ITEM.ID);

        this.property(CheckSelectMeta.INSPECTION_POINT_PROP)
                .using(EAMTables.EAM_CHECK_SELECT.POINT_ID).join(EAMTables.EAM_INSPECTION_POINT.ID);

        this.property(CheckSelectMeta.INSPECTION_TASK_POINT_PROP)
                .using(EAMTables.EAM_CHECK_SELECT.TASK_POINT_ID).join(EAMTables.EAM_INSPECTION_TASK_POINT.ID);

        this.property(CheckSelectMeta.INSPECTION_TASK_PROP)
                .using(EAMTables.EAM_CHECK_SELECT.TASK_ID).join(EAMTables.EAM_INSPECTION_TASK.ID);

    }

    public void setupCheckGroup() {

        this.property(CheckGroupMeta.ITEM_LIST_PROP)
                .using(EAMTables.EAM_CHECK_GROUP.ID).join(EAMTables.EAM_CHECK_GROUP_ITEM.GROUP_ID)
             .using(EAMTables.EAM_CHECK_GROUP_ITEM.ITEM_ID).join(EAMTables.EAM_CHECK_ITEM.ID);
    }


    public void setupRfidRelease() {
        this.property(RfidReleaseMeta.RFID_LABEL_LIST_PROP)
                .using(EAMTables.EAM_RFID_RELEASE.ID).join(EAMTables.EAM_RFID_LABEL.RELEASE_ID);
    }


    public void setupRfidLabel() {
        this.property(RfidLabelMeta.ASSET_PROP)
                .using(EAMTables.EAM_RFID_LABEL.ASSET_ID).join(EAMTables.EAM_ASSET.ID);

        this.property(RfidLabelMeta.OPER_USER_PROP)
                .using(EAMTables.EAM_RFID_LABEL.OPER_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
    }

//    public void setupCustInspectTpl() {
//                  this.property(CCustInspectTplMeta.ASSET_LIST_PROP)
//                .using(EAMTables.EAM_C_CUST_INSPECT_TPL.ID).join(EAMTables.EAM_C_CUST_INSPECT_TPL_ASSET.OWNER_ID)
//                .using(EAMTables.EAM_C_CUST_INSPECT_TPL_ASSET.ASSET_ID).join(EAMTables.EAM_ASSET.ID);
//
//    }


//    public void setupCustInspectItem() {
//        this.property(CCustInspectItemMeta.INSPECT_USER_PROP)
//                .using(EAMTables.EAM_C_CUST_INSPECT_ITEM.INSPECT_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//
//        this.property(CCustInspectItemMeta.ASSET_PROP)
//                .using(EAMTables.EAM_C_CUST_INSPECT_ITEM.ASSET_ID).join(EAMTables.EAM_ASSET.ID);
//
//    }
//    public void setupCustInspectTask() {
//        this.property(CCustInspectTaskMeta.CUST_INSPECT_TPL_PROP)
//                .using(EAMTables.EAM_C_CUST_INSPECT_TASK.TPL_ID).join(EAMTables.EAM_C_CUST_INSPECT_TPL.ID);
//
//        this.property(CCustInspectTaskMeta.LEADER_PROP)
//                .using(EAMTables.EAM_C_CUST_INSPECT_TASK.INSPECT_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//
//        this.property(CCustInspectTaskMeta.MEMBER_LIST_PROP)
//                .using(EAMTables.EAM_C_CUST_INSPECT_TASK.ID).join(EAMTables.EAM_C_CUST_INSPECT_USER_S.OWNER_ID)
//                .using(EAMTables.EAM_C_CUST_INSPECT_USER_S.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//
//        this.property(CCustInspectTaskMeta.CUST_INSPECT_ITEM_LIST_PROP)
//                .using(EAMTables.EAM_C_CUST_INSPECT_TASK.ID).join(EAMTables.EAM_C_CUST_INSPECT_ITEM.OWNER_ID);
//
//        this.property(CCustInspectTaskMeta.ASSET_IN_TPL_LIST_PROP)
//                .using(EAMTables.EAM_C_CUST_INSPECT_TASK.TPL_ID).join(EAMTables.EAM_C_CUST_INSPECT_TPL_ASSET.OWNER_ID)
//                .using(EAMTables.EAM_C_CUST_INSPECT_TPL_ASSET.ASSET_ID).join(EAMTables.EAM_ASSET.ID);
//
//
//    }

//    public void setupCustInspectPlan() {
//
//        this.property(CCustInspectPlanMeta.ASSET_IN_TPL_LIST_PROP)
//                .using(EAMTables.EAM_C_CUST_INSPECT_PLAN.TPL_ID).join(EAMTables.EAM_C_CUST_INSPECT_TPL_ASSET.OWNER_ID)
//          .using(EAMTables.EAM_C_CUST_INSPECT_TPL_ASSET.ASSET_ID).join(EAMTables.EAM_ASSET.ID);
//
//        this.property(CCustInspectPlanMeta.CUST_INSPECT_TPL_PROP)
//                .using(EAMTables.EAM_C_CUST_INSPECT_PLAN.TPL_ID).join(EAMTables.EAM_C_CUST_INSPECT_TPL.ID);
//
//        this.property(CCustInspectPlanMeta.LEADER_PROP)
//                .using(EAMTables.EAM_C_CUST_INSPECT_PLAN.INSPECT_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//
//        this.property(CCustInspectPlanMeta.MEMBER_LIST_PROP)
//                .using(EAMTables.EAM_C_CUST_INSPECT_PLAN.ID).join(EAMTables.EAM_C_CUST_INSPECT_USER_S.OWNER_ID)
//                .using(EAMTables.EAM_C_CUST_INSPECT_USER_S.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//
//        this.property(CCustInspectPlanMeta.CUST_INSPECT_ITEM_LIST_PROP)
//                .using(EAMTables.EAM_C_CUST_INSPECT_PLAN.ID).join(EAMTables.EAM_C_CUST_INSPECT_ITEM.OWNER_ID);
//
//
//    }

//    public void setupCustRepairApply() {
//
//        this.property(CCustRepairApplyMeta.REPAIR_TYPE_PROP)
//                .using(EAMTables.EAM_C_CUST_REPAIR_APPLY.TYPE).join(EAMTables.EAM_C_CUST_REPAIR_TYPE.ID);
//
//        this.property(CCustRepairApplyMeta.REPORT_USER_PROP)
//                .using(EAMTables.EAM_C_CUST_REPAIR_APPLY.REPORT_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//
//        this.property(CCustRepairApplyMeta.PROCESS_USER_PROP)
//                .using(EAMTables.EAM_C_CUST_REPAIR_APPLY.PROCESS_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//
//        this.property(CCustRepairApplyMeta.REPIAR_ITEM_DATA_PROP)
//                .using(EAMTables.EAM_C_CUST_REPAIR_APPLY.ID).join(EAMTables.EAM_C_CUST_REPIAR_ITEM.REPAIR_ID);
//
//        this.property(CCustRepairApplyMeta.ASSET_LIST_PROP)
//                .using(EAMTables.EAM_C_CUST_REPAIR_APPLY.ID).join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
//           .using(EAMTables.EAM_ASSET_ITEM.ASSET_ID).join(EAMTables.EAM_ASSET.ID);
//
//    }

//    public void setupCustRepairItem() {
//        this.property(CCustRepiarItemMeta.PROCESS_USER_PROP)
//                .using(EAMTables.EAM_C_CUST_REPIAR_ITEM.PROCESS_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//
//
//    }

    public void setupAssetBorrowReturn() {

        this.property(AssetBorrowReturnMeta.ASSET_ITEM_LIST_PROP)
                .using(EAMTables.EAM_ASSET_BORROW_RETURN.ID )
                .join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID);


        // 关联资产
        this.property(AssetBorrowReturnMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_BORROW_RETURN.ID ).join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using( EAMTables.EAM_ASSET_ITEM.ASSET_ID).join( EAMTables.EAM_ASSET.ID);


        // 关联位置
        this.property(AssetBorrowReturnMeta.POSITION_PROP)
                .using(EAMTables.EAM_ASSET_BORROW_RETURN.POSITION_ID)
                .join( EAMTables.EAM_POSITION.ID);

        // 关联制单人
        this.property(AssetBorrowReturnMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_BORROW_RETURN.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);

        // 关联制单人
        this.property(AssetBorrowReturnMeta.MANAGER_PROP)
                .using(EAMTables.EAM_ASSET_BORROW_RETURN.MANAGER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(AssetBorrowReturnMeta.USE_USER_PROP)
                .using(EAMTables.EAM_ASSET_BORROW_RETURN.USE_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);


        this.property(AssetBorrowReturnMeta.USE_ORGANIZATION_PROP)
                .using(EAMTables.EAM_ASSET_BORROW_RETURN.USE_ORGANIZATION_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);


    }



    public void setupAssetRackInfo(){


        this.property(AssetRackInfoMeta.TYPE_DICT_PROP)
                .using(EAMTables.EAM_ASSET_RACK_INFO.RACK_TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='ops_dc_rack_type'");


        this.property(AssetRackInfoMeta.STATUS_DICT_PROP)
                .using(EAMTables.EAM_ASSET_RACK_INFO.STATUS).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='ops_dc_rack_status'");

        this.property(AssetRackInfoMeta.USED_TYPE_DICT_PROP)
                .using(EAMTables.EAM_ASSET_RACK_INFO.RACK_USED_TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='ops_dc_rack_used_type'");

        this.property(AssetRackInfoMeta.ENVIRONMENT_DICT_PROP)
                .using(EAMTables.EAM_ASSET_RACK_INFO.ENVIRONMENT).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='ops_dc_rack_environment'");
    }
    public void setupAssetRack2() {

        this.property(AssetRackMeta.RACK_INFO_PROP)
                .using(EAMTables.EAM_ASSET_RACK.RACK_ID).join(EAMTables.EAM_ASSET_RACK_INFO.ID);
    }


    public void setupAssetStatusRuleV() {
        this.property(AssetStatusRuleVMeta.ASSET_STATUS_RULE_PROP)
                .using(EAMTables.EAM_ASSET_STATUS_RULE_V.OPER_CODE).join(EAMTables.EAM_ASSET_STATUS_RULE.OPER_CODE);

        this.property(AssetStatusRuleVMeta.ASSET_CYCLE_STATUS_PROP)
                .using(EAMTables.EAM_ASSET_STATUS_RULE_V.STATUS_CODE).join(EAMTables.EAM_ASSET_STATUS.CODE);
    }

    public void setupSupplier() {


        this.property(SupplierMeta.GRADE_DICT_PROP)
                .using(EAMTables.EAM_SUPPLIER.GRADE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_supplier_grade'");


    }



    public void setupEmployeeApply() {
        this.property(AssetEmployeeApplyMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(AssetEmployeeApplyMeta.ORGANIZATION_PROP)
                .using(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);


    }

    public void setupEmployeeRepair() {
        this.property(AssetEmployeeRepairMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_EMPLOYEE_REPAIR.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(AssetEmployeeRepairMeta.ORGANIZATION_PROP)
                .using(EAMTables.EAM_ASSET_EMPLOYEE_REPAIR.ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);


    }
    public void setupEmployeeLoss() {
        this.property(AssetEmployeeLossMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_EMPLOYEE_LOSS.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(AssetEmployeeLossMeta.ORGANIZATION_PROP)
                .using(EAMTables.EAM_ASSET_EMPLOYEE_LOSS.ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

    }

    public void setupEmployeeHandover() {
        this.property(AssetEmployeeHandoverMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_EMPLOYEE_HANDOVER.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(AssetEmployeeHandoverMeta.RECEIVER_USER_PROP)
                .using(EAMTables.EAM_ASSET_EMPLOYEE_HANDOVER.RECEIVE_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(AssetEmployeeHandoverMeta.ORGANIZATION_PROP)
                .using(EAMTables.EAM_ASSET_EMPLOYEE_HANDOVER.ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

        this.property(AssetEmployeeHandoverMeta.RECEIVE_ORGANIZATION_PROP)
                .using(EAMTables.EAM_ASSET_EMPLOYEE_HANDOVER.RECEIVE_ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);
    }

    public void setupMaintainTaskProject() {
        this.property(MaintainTaskProjectMeta.MAINTAIN_TYPE_DICT_PROP)
                .using(EAMTables.EAM_MAINTAIN_TASK_PROJECT.PROJECT_MAINTAIN_TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_maintain_type'");

    }


    public void setupCrontab() {
        this.property(ActionCrontabMeta.ACTION_CRONTAB_LOG_PROP)
                .using(EAMTables.EAM_ACTION_CRONTAB.ID).join(EAMTables.EAM_ACTION_CRONTAB_LOG.CRONTAB_ID);
    }

    private HashMap<String,Integer> calculateMaintainTaskProjectStatusStatistics(List<MaintainTaskProject> assets){
        HashMap<String,Integer> map=new HashMap<>();
        int allCount=0;
        int waitCount=0;
        if(assets!=null&&assets.size()>0){
            for(int i=0;i<assets.size();i++){
                allCount++;
                if(MaintainTaskProjectStatusEnum.UNEXECUTED.code().equals(assets.get(i).getStatus())){
                    waitCount++;
                }
            }
            map.put("itemCount",allCount);
            map.put("waitCount",waitCount);
        }
        return map;
    }



    public void setupMaintainTask() {
        this.property(MaintainTaskMeta.ASSET_PROP)
                .using(EAMTables.EAM_MAINTAIN_TASK.ASSET_ID ).join( EAMTables.EAM_ASSET.ID);

        this.property(MaintainTaskMeta.TASK_PROJECT_LIST_PROP)
                .using(EAMTables.EAM_MAINTAIN_TASK.ID).join(EAMTables.EAM_MAINTAIN_TASK_PROJECT.TASK_ID).after((tag,point,checkItems,map)->{
            HashMap<String,Integer> data= calculateMaintainTaskProjectStatusStatistics(checkItems);
            point.setItemCount(data.getOrDefault("itemCount",0)+"");
            point.setWaitCount(data.getOrDefault("waitCount",0)+"");
            return checkItems;
        }).condition("selected_code='def'");


        this.property(MaintainTaskMeta.PROJECT_LIST_PROP)
                .using(EAMTables.EAM_MAINTAIN_TASK.PLAN_ID ).join(EAMTables.EAM_MAINTAIN_PROJECT_SELECT.OWNER_ID)
                .using( EAMTables.EAM_MAINTAIN_PROJECT_SELECT.PROJECT_ID).join( EAMTables.EAM_MAINTAIN_PROJECT.ID);


        this.property(MaintainTaskMeta.MAINTAIN_TYPE_DICT_PROP)
                .using(EAMTables.EAM_MAINTAIN_TASK.MAINTAIN_TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_maintain_type'");


        //制单人
        this.property(MaintainTaskMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_MAINTAIN_TASK.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        //验收人
        this.property(MaintainTaskMeta.EXECUTOR_PROP)
                .using(EAMTables.EAM_MAINTAIN_TASK.EXECUTOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);


        this.property(MaintainTaskMeta.MAINTAIN_GROUP_PROP)
                .using(EAMTables.EAM_MAINTAIN_TASK.GROUP_ID).join(EAMTables.EAM_MAINTAIN_GROUP.ID);





    }

    private HashMap<String,Integer> calculateMaintainPlanProjectStatusStatistics(List<MaintainProject> assets){
        HashMap<String,Integer> map=new HashMap<>();
        int allCount=0;
        int waitCount=0;
        if(assets!=null&&assets.size()>0){
//            for(int i=0;i<assets.size();i++){
//                allCount++;
//                if(MaintainTaskProjectStatusEnum.UNEXECUTED.code().equals(assets.get(i).getStatus())){
//                    waitCount++;
//                }
//            }
            map.put("itemCount",assets.size());
        }else{
            map.put("itemCount",0);
        }
        return map;
    }


    public void setupMaintainPlan() {


        // 关联资产
        this.property(MaintainPlanMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_MAINTAIN_PLAN.ID ).join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using( EAMTables.EAM_ASSET_ITEM.ASSET_ID).join( EAMTables.EAM_ASSET.ID);

        //项目
        this.property(MaintainPlanMeta.PROJECT_LIST_PROP)
                .using(EAMTables.EAM_MAINTAIN_PLAN.ID ).join(EAMTables.EAM_MAINTAIN_PROJECT_SELECT.OWNER_ID).condition("selected_code='def'")
                .using( EAMTables.EAM_MAINTAIN_PROJECT_SELECT.PROJECT_ID).join(EAMTables.EAM_MAINTAIN_PROJECT.ID).after((tag,point,checkItems,map)->{
            HashMap<String,Integer> data= calculateMaintainPlanProjectStatusStatistics(checkItems);
            point.setItemCount(data.getOrDefault("itemCount",0)+"");
            return checkItems;
        });



        this.property(MaintainPlanMeta.ASSET_PROP)
                .using(EAMTables.EAM_MAINTAIN_PLAN.ASSET_ID).join(EAMTables.EAM_ASSET.ID);


        this.property(MaintainPlanMeta.MAINTAIN_TYPE_DICT_PROP)
                .using(EAMTables.EAM_MAINTAIN_PLAN.MAINTAIN_TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_maintain_type'");

        this.property(MaintainPlanMeta.ACTION_CRONTAB_PROP)
                .using(EAMTables.EAM_MAINTAIN_PLAN.ACTION_CYCLE_ID).join(EAMTables.EAM_ACTION_CRONTAB.ID);

        this.property(MaintainPlanMeta.MAINTAIN_GROUP_PROP)
                .using(EAMTables.EAM_MAINTAIN_PLAN.GROUP_ID).join(EAMTables.EAM_MAINTAIN_GROUP.ID);

        this.property(MaintainPlanMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_MAINTAIN_PLAN.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

    }


    public void setupMaintainProject() {

        this.property(MaintainProjectMeta.MAINTAIN_TYPE_DICT_PROP)
                .using(EAMTables.EAM_MAINTAIN_PROJECT.MAINTAIN_TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_maintain_type'");

        this.property(MaintainProjectMeta.ACTION_CRONTAB_PROP)
                .using(EAMTables.EAM_MAINTAIN_PROJECT.ACTION_CYCLE_ID).join(EAMTables.EAM_ACTION_CRONTAB.ID);


    }
    public void setupRepairRule() {
        this.property(RepairRuleMeta.REPAIR_GROUP_PROP)
                .using(EAMTables.EAM_REPAIR_RULE.GROUP_ID).join(EAMTables.EAM_REPAIR_GROUP.ID);

        this.property(RepairRuleMeta.USER_PROP)
                .using(EAMTables.EAM_REPAIR_RULE.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

    }


    public void setupMaintainGroup() {

        this.property(MaintainGroupMeta.LEADER_PROP)
                .using(EAMTables.EAM_MAINTAIN_GROUP.LEADER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(MaintainGroupMeta.MEMBER_LIST_PROP)
                .using(EAMTables.EAM_MAINTAIN_GROUP.ID).join(EAMTables.EAM_GROUP_USER.GROUP_ID)
                .using(EAMTables.EAM_GROUP_USER.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);


    }

    public void setupRepairOrderAccept() {
        //制单人
        this.property(RepairOrderAcceptanceMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        //验收人
        this.property(RepairOrderAcceptanceMeta.ACCEPTER_PROP)
                .using(EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.ACCEPTER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);


        this.property(RepairOrderAcceptanceMeta.RESULT_TYPE_DICT_PROP)
                .using(EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.RESULT_TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_repair_result_type'");


        this.property(RepairOrderAcceptanceMeta.CATEGORY_TPL_PROP)
                .using(EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.CATEGORY_TPL_ID).join(EAMTables.EAM_REPAIR_CATEGORY_TPL.ID);

        //订单
        this.property(RepairOrderAcceptanceMeta.ORDER_PROP)
                .using(EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.ORDER_ID).join(EAMTables.EAM_REPAIR_ORDER.ID);

        //维修单
        this.property(RepairOrderAcceptanceMeta.ORDER_ACT_PROP)
                .using(EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.ORDER_ACT_ID).join(EAMTables.EAM_REPAIR_ORDER_ACT.ID);
    }


    public void setupRepairOrderTransfer() {
        //维修组
        this.property(RepairOrderTransferMeta.REPAIR_GROUP_PROP)
                .using(EAMTables.EAM_REPAIR_ORDER_TRANSFER.GROUP_ID).join(EAMTables.EAM_REPAIR_GROUP.ID);

        //执行人
        this.property(RepairOrderTransferMeta.EXECUTOR_PROP)
                .using(EAMTables.EAM_REPAIR_ORDER_TRANSFER.EXECUTOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        //订单
        this.property(RepairOrderTransferMeta.ORDER_PROP)
                .using(EAMTables.EAM_REPAIR_ORDER_TRANSFER.ORDER_ID).join(EAMTables.EAM_REPAIR_ORDER.ID);

        //维修
        this.property(RepairOrderTransferMeta.ORDER_ACT_PROP)
                .using(EAMTables.EAM_REPAIR_ORDER_TRANSFER.ORDER_ACT_ID).join(EAMTables.EAM_REPAIR_ORDER_ACT.ID);

    }
    public void setupRepairOrderAct() {

        this.property(RepairOrderActMeta.REPAIR_ORDER_ACCEPTANCE_PROP)
                .using(EAMTables.EAM_REPAIR_ORDER_ACT.ID).join(EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.ORDER_ACT_ID);

        this.property(RepairOrderActMeta.GOODS_STOCK_PART_LIST_PROP)
                .using(EAMTables.EAM_REPAIR_ORDER_ACT.ID).join(EAMTables.EAM_GOODS_STOCK.OWNER_ID).condition("owner_code='part'");

        this.property(RepairOrderActMeta.REPAIR_ORDER_PROCESS_PROP)
                .using(EAMTables.EAM_REPAIR_ORDER_ACT.ID).join(EAMTables.EAM_REPAIR_ORDER_PROCESS.ACT_ID);

        this.property(RepairOrderActMeta.REPAIR_ORDER_ACT_SP_LIST_PROP)
                .using(EAMTables.EAM_REPAIR_ORDER_ACT.ID).join(EAMTables.EAM_REPAIR_ORDER_ACT_SP.ACT_ID).condition("selected_code='def'");


        this.property(RepairOrderActMeta.REPAIR_GROUP_PROP)
                .using(EAMTables.EAM_REPAIR_ORDER_ACT.GROUP_ID).join(EAMTables.EAM_REPAIR_GROUP.ID);

        //制单人
        this.property(RepairOrderActMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_REPAIR_ORDER_ACT.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        //执行人
        this.property(RepairOrderActMeta.EXECUTOR_PROP)
                .using(EAMTables.EAM_REPAIR_ORDER_ACT.EXECUTOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        //订单
        this.property(RepairOrderActMeta.ORDER_PROP)
                .using(EAMTables.EAM_REPAIR_ORDER_ACT.ORDER_ID).join(EAMTables.EAM_REPAIR_ORDER.ID);



    }

    public void setupRepairOrder() {
        this.property(RepairOrderMeta.REPAIR_ORDER_PROCESS_PROP)
                .using(EAMTables.EAM_REPAIR_ORDER.ID).join(EAMTables.EAM_REPAIR_ORDER_PROCESS.ORDER_ID);

        this.property(RepairOrderMeta.ASSET_PROP)
                .using(EAMTables.EAM_REPAIR_ORDER.ASSET_ID).join(EAMTables.EAM_ASSET.ID);


        //制单人
        this.property(RepairOrderMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_REPAIR_ORDER.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(RepairOrderMeta.REPAIR_URGENCY_PROP)
                .using(EAMTables.EAM_REPAIR_ORDER.URGENCY_ID).join(EAMTables.EAM_REPAIR_URGENCY.ID);

        this.property(RepairOrderMeta.REPORT_USER_PROP)
                .using(EAMTables.EAM_REPAIR_ORDER.REPORT_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(RepairOrderMeta.ORGANIZATION_PROP)
                .using(EAMTables.EAM_REPAIR_ORDER.REPORT_ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

        this.property(RepairOrderMeta.CATEGORY_TPL_PROP)
                .using(EAMTables.EAM_REPAIR_ORDER.CATEGORY_TPL_ID).join(EAMTables.EAM_REPAIR_CATEGORY_TPL.ID);


        this.property(RepairOrderMeta.ORDER_ACT_PROP)
                .using(EAMTables.EAM_REPAIR_ORDER.ID).join(EAMTables.EAM_REPAIR_ORDER_ACT.ORDER_ID);

        this.property(RepairOrderMeta.ORDER_ACCEPTANCE_PROP)
                .using(EAMTables.EAM_REPAIR_ORDER.ID).join(EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.ORDER_ID);

        // 关联资产
        this.property(RepairOrderMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_REPAIR_ORDER.ID ).join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using( EAMTables.EAM_ASSET_ITEM.ASSET_ID).join( EAMTables.EAM_ASSET.ID);

    }

    public void setupRepairGroup() {

        this.property(RepairGroupMeta.LEADER_PROP)
                .using(EAMTables.EAM_REPAIR_GROUP.LEADER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(RepairGroupMeta.MEMBER_LIST_PROP)
                .using(EAMTables.EAM_REPAIR_GROUP.ID).join(EAMTables.EAM_GROUP_USER.GROUP_ID)
                .using(EAMTables.EAM_GROUP_USER.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);


    }

    public void setupRepairCategoryTpl() {

        this.property(RepairCategoryTplMeta.CATEGORY_PROP)
                .using(EAMTables.EAM_REPAIR_CATEGORY_TPL.CATEGORY_ID).join(EAMTables.EAM_REPAIR_CATEGORY.ID);
    }



    public void setupFailureRegistration() {

        //制单人
        this.property(FailureRegistrationMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_FAILURE_REGISTRATION.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(FailureRegistrationMeta.TYPE_DICT_PROP)
                .using(EAMTables.EAM_FAILURE_REGISTRATION.TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_equipment_failure'");


        // 关联资产
        this.property(FailureRegistrationMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_FAILURE_REGISTRATION.ID ).join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using( EAMTables.EAM_ASSET_ITEM.ASSET_ID).join( EAMTables.EAM_ASSET.ID);



    }

    public void setupAssetLabel() {

        this.property(AssetLabelMeta.ASSET_TPL_PROP)
                .using(EAMTables.EAM_ASSET_LABEL.LABEL_TPL_ID).join(EAMTables.EAM_ASSET_LABEL_TPL.ID);

        this.property(AssetLabelMeta.ASSET_PAPER_PROP)
                .using(EAMTables.EAM_ASSET_LABEL.PAPER_TYPE_ID).join(EAMTables.EAM_ASSET_LABEL_PAPER.ID);

    }


    public void setupAssetLabelTpl() {
        this.property(AssetLabelTplMeta.ASSET_LABEL_ITEM_LIST_PROP)
                .using(EAMTables.EAM_ASSET_LABEL_TPL.ID).join(EAMTables.EAM_ASSET_LABEL_TPL_ITEM.TPL_ID);

        this.property(AssetLabelTplMeta.ASSET_LABEL_COLUMNL_LIST_PROP)
                .using(EAMTables.EAM_ASSET_LABEL_TPL.ID).join(EAMTables.EAM_ASSET_LABEL_TPL_ITEM.TPL_ID)
         .using(EAMTables.EAM_ASSET_LABEL_TPL_ITEM.COL_ID).join(EAMTables.EAM_ASSET_LABEL_COL.ID);

        this.property(AssetLabelTplMeta.ASSET_LABEL_LAYOUT_LIST_PROP)
                .using(EAMTables.EAM_ASSET_LABEL_TPL.ID).join(EAMTables.EAM_ASSET_LABEL_LAYOUT.TPL_ID);

    }

    public void setupAssetLabelTplItem() {
        this.property(AssetLabelTplItemMeta.ASSET_LABEL_COL_PROP)
                .using(EAMTables.EAM_ASSET_LABEL_TPL_ITEM.COL_ID).join(EAMTables.EAM_ASSET_LABEL_COL.ID);

    }




    public void setupAssetSoftChange() {
        //制单人
        this.property(AssetSoftwareChangeMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_SOFTWARE_CHANGE.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(AssetSoftwareChangeMeta.ASSET_SOFTWARE_CHANGE_DETAIL_LIST_PROP)
                .using(EAMTables.EAM_ASSET_SOFTWARE_CHANGE.ID).join(EAMTables.EAM_ASSET_SOFTWARE_CHANGE_DETAIL.CHANGE_ID);

    }

    public void setupAssetSoftChangeDetail() {
        this.property(AssetSoftwareChangeDetailMeta.ASSET_SOFTWARE_PROP)
                .using(EAMTables.EAM_ASSET_SOFTWARE_CHANGE_DETAIL.SOFTWARE_ID).join(EAMTables.EAM_ASSET_SOFTWARE.ID);

        this.property(AssetSoftwareChangeDetailMeta.ASSET_SOFTWARE_BEFORE_PROP)
                .using(EAMTables.EAM_ASSET_SOFTWARE_CHANGE_DETAIL.BEFORE_SOFTWARE_ID).join(EAMTables.EAM_ASSET_SOFTWARE.ID);

        this.property(AssetSoftwareChangeDetailMeta.ASSET_SOFTWARE_AFTER_PROP)
                .using(EAMTables.EAM_ASSET_SOFTWARE_CHANGE_DETAIL.AFTER_SOFTWARE_ID).join(EAMTables.EAM_ASSET_SOFTWARE.ID);
    }



    public void setupAssetSoftMaintenance() {
        //制单人
        this.property(AssetSoftwareMaintenanceMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(AssetSoftwareMaintenanceMeta.ASSET_SOFTWARE_LIST_PROP)
                .using(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.ID).join(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE_DETAIL.MAINTENANCE_ID)
                .using(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE_DETAIL.SOFTWARE_ID).join(EAMTables.EAM_ASSET_SOFTWARE.ID);



        this.property(AssetSoftwareMaintenanceMeta.USE_ORGANIZATION_PROP)
                .using(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.USE_ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);


        this.property(AssetSoftwareMaintenanceMeta.MANAGER_PROP)
                .using(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.MANAGER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(AssetSoftwareMaintenanceMeta.MAINTAINER_PROP)
                .using(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.MAINTAINER_ID).join(EAMTables.EAM_MAINTAINER.ID);



    }


    public void setupAssetSoftwareDistribute() {
        //制单人
        this.property(AssetSoftwareDistributeMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(AssetSoftwareDistributeMeta.USE_USER_PROP)
                .using(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.USE_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);


        this.property(AssetSoftwareDistributeMeta.ASSET_SOFTWARE_LIST_PROP)
        .using(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.ID).join(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE_DATA.DISTRIBUTE_ID)
                .using(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE_DATA.SOFTWARE_ID).join(EAMTables.EAM_ASSET_SOFTWARE.ID);

        this.property(AssetSoftwareDistributeMeta.ASSET_SOFTWARE_DISTRIBUTE_LIST_PROP)
                .using(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.ID).join(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE_DATA.DISTRIBUTE_ID);




//        this.property(AssetSoftwareDistributeMeta.ASSET_SOFTWARE_DISTRIBUTE_DATA_PROP)
//                .using(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.ID).join(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE_DATA.DISTRIBUTE_ID);
//
//        this.property(AssetSoftwareDistributeMeta.ASSET_PROP)
//                .using(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.ASSET_ID).join(EAMTables.EAM_ASSET.ID);
//
//        this.property(AssetSoftwareDistributeMeta.ASSET_SOFTWARE_PROP)
//                .using(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.ASSET_SOFTWARE_ID).join(EAMTables.EAM_ASSET_SOFTWARE.ID);


        this.property(AssetSoftwareDistributeMeta.USE_ORGANIZATION_PROP)
                .using(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.USE_ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);


    }
    public void setupAssetSoftware() {
        //关联 所属公司
        this.property(AssetSoftwareMeta.OWNER_COMPANY_PROP)
                .using(EAMTables.EAM_ASSET_SOFTWARE.OWN_COMPANY_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

        this.property(AssetSoftwareMeta.USE_ORGANIZATION_PROP)
                .using(EAMTables.EAM_ASSET_SOFTWARE.USE_ORGANIZATION_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

        //制单人
        this.property(AssetSoftwareMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_SOFTWARE.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(AssetSoftwareMeta.MANAGER_PROP)
                .using(EAMTables.EAM_ASSET_SOFTWARE.MANAGER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);


        // 关联来源
        this.property(AssetSoftwareMeta.SOURCE_PROP)
                .using(EAMTables.EAM_ASSET_SOFTWARE.SOURCE_ID).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_source'");


        this.property(AssetSoftwareMeta.CATEGORY_PROP)
                .using(EAMTables.EAM_ASSET_SOFTWARE.CATEGORY_ID).join(FoxnicWeb.PCM_CATALOG.ID);


        this.property(AssetSoftwareMeta.COPYRIGHT_TYPE_DICT_PROP)
                .using(EAMTables.EAM_ASSET_SOFTWARE.COPYRIGHT_TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='asset_software_copyright_type'");

        this.property(AssetSoftwareMeta.LICENSE_MODE_DICT_PROP)
                .using(EAMTables.EAM_ASSET_SOFTWARE.LICENSE_MODE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='asset_software_license_mode'");


        this.property(AssetSoftwareMeta.MAINTAINER_PROP)
                .using(EAMTables.EAM_ASSET_SOFTWARE.MAINTAINER_ID).join(EAMTables.EAM_MAINTAINER.ID);


        this.property(AssetSoftwareMeta.SUPPLIER_PROP)
                .using(EAMTables.EAM_ASSET_SOFTWARE.SUPPLIER_ID).join(EAMTables.EAM_SUPPLIER.ID);

    }

    public void setupAssetDepreciationDetail() {


        // 费用方式
        this.property(AssetDepreciationDetailMeta.EXPENSE_ITEM_DICT_PROP)
                .using(EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.EXPENSE_ITEM_KEY).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_expense_items'");

        // 财务选项
        this.property(AssetDepreciationDetailMeta.FINANCIAL_OPTION_DICT_PROP)
                .using(EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.FINANCIAL_OPTION_KEY).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_financial_options'");

        //关联 使用组织
        this.property(AssetDepreciationDetailMeta.USE_ORGANIZATION_PROP)
                .using(EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.USE_ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);


        // 关联使用人
        this.property(AssetDepreciationDetailMeta.USE_USER_PROP)
                .using(EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.USE_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//

        this.property(AssetDepreciationDetailMeta.MANAGER_PROP)
                .using(EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.MANAGER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//


        this.property(AssetDepreciationDetailMeta.ASSET_TARGET_PROP)
                .using(EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.DETAIL_ID_TARGET).join(EAMTables.EAM_ASSET.ID);

        this.property(AssetDepreciationDetailMeta.ASSET_SOURCE_PROP)
                .using(EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.DETAIL_ID_SOURCE).join(EAMTables.EAM_ASSET.ID);

        this.property(AssetDepreciationDetailMeta.ASSET_PROP)
                .using(EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.ASSET_ID).join(EAMTables.EAM_ASSET.ID);


        this.property(AssetDepreciationDetailMeta.ASSET_DEPRECIATION_PROP)
                .using(EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.DEPRECIATION_ID).join(EAMTables.EAM_ASSET_DEPRECIATION.ID);

        this.property(AssetDepreciationDetailMeta.ASSET_DEPRECIATION_OPER_PROP)
                .using(EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.OPER_ID).join(EAMTables.EAM_ASSET_DEPRECIATION_OPER.ID);

        this.property(AssetDepreciationDetailMeta.CAL_RULE_LIST_PROP)
                .using(EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.DEPRECIATION_ID).join(EAMTables.EAM_ASSET_DEPRECIATION_CAL_RULE.DEPRECIATION_ID);

        this.property(AssetDepreciationDetailMeta.LAST_ASSET_DEPRECIATION_DETAIL_PROP)
                .using(EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.OPER_ID).join(EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.ID);

    }


    public void  setupAssetDepreciationHistory(){
        //制单人
        this.property(AssetDepreciationHistoryMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_DEPRECIATION_HISTORY.OPER_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(AssetDepreciationHistoryMeta.ASSET_PROP)
                .using(EAMTables.EAM_ASSET_DEPRECIATION_HISTORY.ASSET_ID).join(EAMTables.EAM_ASSET.ID);

    }

    public void setupAssetDepreciationCalRule() {

        this.property(AssetDepreciationCalRuleMeta.ASSET_DEPRECIATION_PROP)
                .using(EAMTables.EAM_ASSET_DEPRECIATION_CAL_RULE.DEPRECIATION_ID)
                .join(EAMTables.EAM_ASSET_DEPRECIATION.ID);

    }


    public void setupAssetDepreciationExclude() {

        this.property(AssetDepreciationExcludeMeta.ASSET_PROP)
                .using(EAMTables.EAM_ASSET_DEPRECIATION_EXCLUDE.ASSET_ID).join(EAMTables.EAM_ASSET.ID);

        this.property(AssetDepreciationExcludeMeta.ASSET_DEPRECIATION_PROP)
                .using(EAMTables.EAM_ASSET_DEPRECIATION_EXCLUDE.DEPRECIATION_ID).join(EAMTables.EAM_ASSET_DEPRECIATION.ID);

    }

    public void setupAssetDepreciation() {

        this.property(AssetDepreciationMeta.CAL_RULE_LIST_PROP)
                .using(EAMTables.EAM_ASSET_DEPRECIATION.ID).join(EAMTables.EAM_ASSET_DEPRECIATION_CAL_RULE.DEPRECIATION_ID);


        // 关联资产分类
        this.property(AssetDepreciationMeta.CATEGORY_PROP)
                .using(EAMTables.EAM_ASSET_DEPRECIATION.ID).join(EAMTables.EAM_ASSET_DEPRECIATION_CATEGORY.DEPRECIATION_ID)
                .using(EAMTables.EAM_ASSET_DEPRECIATION_CATEGORY.CATEGORY_ID).join(FoxnicWeb.PCM_CATALOG.ID);

    }

    public void setupAssetDepreciationOper() {

        //制单人
        this.property(AssetDepreciationOperMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_DEPRECIATION_OPER.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(AssetDepreciationOperMeta.ASSET_DEPRECIATION_PROP)
                .using(EAMTables.EAM_ASSET_DEPRECIATION_OPER.DEPRECIATION_ID).join(EAMTables.EAM_ASSET_DEPRECIATION.ID);

        this.property(AssetDepreciationOperMeta.ASSET_DEPRECIATION_LIST_PROP)
                .using(EAMTables.EAM_ASSET_DEPRECIATION_OPER.ID).join(EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.OPER_ID);

    }


    public void setupInspectionGroup() {
        //制单人
        this.property(InspectionGroupMeta.LEADER_PROP)
                .using(EAMTables.EAM_INSPECTION_GROUP.LEADER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        //成员
        this.property(InspectionGroupMeta.MEMBER_LIST_PROP)
                .using(EAMTables.EAM_INSPECTION_GROUP.ID).join(EAMTables.EAM_INSPECTION_GROUP_USER.GROUP_ID)
                .using(EAMTables.EAM_INSPECTION_GROUP_USER.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

    }

    private HashMap<String,Integer> calculateInspectPointStatusStatistics(List<InspectionPoint> assets){
        HashMap<String,Integer> map=new HashMap<>();
        int allCount=0;
        int disableCount=0;
        if(assets!=null&&assets.size()>0){
            for(int i=0;i<assets.size();i++){
                allCount++;
                if(StatusEnableEnum.DISABLE.code().equals(assets.get(i).getStatus())){
                    disableCount++;
                }
            }
            map.put("allCount",allCount);
            map.put("disableCount",disableCount);
        }
        return map;
    }

    public void setupInspectionPlan() {
        this.property(InspectionPlanMeta.INSPECTION_POINT_LIST_PROP)
                .using(EAMTables.EAM_INSPECTION_PLAN.ID).join(EAMTables.EAM_INSPECTION_POINT_OWNER.OWNER_ID)
                .condition("selected_code='def'")
                .using(EAMTables.EAM_INSPECTION_POINT_OWNER.POINT_ID).join(EAMTables.EAM_INSPECTION_POINT.ID).after((tag,point,checkItems,map)->{
            if(checkItems==null||checkItems.size()==0) {
                point.setItemDisableCount("0");
                point.setItemCount("0");
            }
            HashMap<String,Integer> data= calculateInspectPointStatusStatistics(checkItems);
            point.setItemDisableCount(data.getOrDefault("disableCount",0)+"");
            point.setItemCount(data.getOrDefault("allCount",0)+"");
            return checkItems;
        });

        this.property(InspectionPlanMeta.ACTION_CRONTAB_PROP)
                .using(EAMTables.EAM_INSPECTION_PLAN.ACTION_CYCLE_ID).join(EAMTables.EAM_ACTION_CRONTAB.ID);

//        this.property(InspectionPlanMeta.INSPECTION_PLAN_POINT_LIST_PROP)
//                .using(EAMTables.EAM_INSPECTION_PLAN.ID).join(EAMTables.EAM_INSPECTION_POINT_OWNER.OWNER_ID)
//                .using(EAMTables.EAM_INSPECTION_POINT_OWNER.POINT_ID).join(EAMTables.EAM_INSPECTION_POINT.ID);

        this.property(InspectionPlanMeta.INSPECTION_POINT_OWNER_LIST_PROP)
                .using(EAMTables.EAM_INSPECTION_PLAN.ID).join(EAMTables.EAM_INSPECTION_POINT_OWNER.OWNER_ID)
                .condition("selected_code='def'");

        this.property(InspectionPlanMeta.INSPECTION_GROUP_PROP)
                .using(EAMTables.EAM_INSPECTION_PLAN.GROUP_ID).join(EAMTables.EAM_INSPECTION_GROUP.ID);
//
//        this.property(InspectionPlanMeta.TIME_DICT_PROP)
//                .using(EAMTables.EAM_INSPECTION_PLAN.COMPLETION_TIME).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
//                .condition("dict_code='eam_completion_time'");


    }
    private HashMap<String,Integer> calculateInspectPointCheckItemStatusStatistics(List<CheckItem> assets){
        HashMap<String,Integer> map=new HashMap<>();
        int allCount=0;
        int disableCount=0;
        if(assets!=null&&assets.size()>0){
            for(int i=0;i<assets.size();i++){
                allCount++;
                if(StatusEnableEnum.DISABLE.code().equals(assets.get(i).getStatus())){
                    disableCount++;
                }
            }
            map.put("allCount",allCount);
            map.put("disableCount",disableCount);
        }
        return map;
    }
    public void setupInspectionPoint() {
        this.property(InspectionPointMeta.CHECK_ITEM_LIST_PROP)
                .using(EAMTables.EAM_INSPECTION_POINT.ID).join(EAMTables.EAM_INSPECTION_POINT_ITEM.POINT_ID)
                .condition("select_code='def'")
              .using(EAMTables.EAM_INSPECTION_POINT_ITEM.ITEM_ID).join(EAMTables.EAM_CHECK_ITEM.ID).after((tag,point,checkItems,map)->{
            if(checkItems==null||checkItems.size()==0) {
                point.setItemDisableCount("0");
                point.setItemCount("0");
            }
            HashMap<String,Integer> data= calculateInspectPointCheckItemStatusStatistics(checkItems);
            point.setItemDisableCount(data.getOrDefault("disableCount",0)+"");
            point.setItemCount(data.getOrDefault("allCount",0)+"");
            return checkItems;
        });


        this.property(InspectionPointMeta.ASSET_PROP)
                .using(EAMTables.EAM_INSPECTION_POINT.ASSET_ID).join(EAMTables.EAM_ASSET.ID);


        this.property(InspectionPointMeta.INSPECTION_POINT_POS_PROP)
                .using(EAMTables.EAM_INSPECTION_POINT.POS_ID).join(EAMTables.EAM_INSPECTION_POINT_POS.ID);

        this.property(InspectionPointMeta.ROUTE_PROP)
                .using(EAMTables.EAM_INSPECTION_POINT.ROUTE_ID).join(EAMTables.EAM_INSPECTION_ROUTE.ID);
    }

    public void setupInspectionOwner() {
        this.property(InspectionPointOwnerMeta.INSPECTION_POINT_PROP)
                .using(EAMTables.EAM_INSPECTION_POINT_OWNER.POINT_ID).join(EAMTables.EAM_INSPECTION_POINT.ID);

        this.property(InspectionPointOwnerMeta.CHECK_ITEM_LIST_PROP)
                .using(EAMTables.EAM_INSPECTION_POINT_OWNER.POINT_ID).join(EAMTables.EAM_INSPECTION_POINT.ID)
                 .using(EAMTables.EAM_INSPECTION_POINT.ID).join(EAMTables.EAM_INSPECTION_POINT_ITEM.POINT_ID)
                .condition(" select_code='def'")
                 .using(EAMTables.EAM_INSPECTION_POINT_ITEM.ITEM_ID).join(EAMTables.EAM_CHECK_ITEM.ID);


    }

    private HashMap<String,Integer> calculateInspectTaskPointItemStatistics(List<CheckSelect> assets){
        HashMap<String,Integer> map=new HashMap<>();
        int allCount=0;
        if(assets!=null&&assets.size()>0){
            map.put("allCount",assets.size());
        }else{
            map.put("allCount",0);
        }
        return map;
    }

    public void setupInspectionTaskPoint() {

        this.property(InspectionTaskPointMeta.INSPECTION_POINT_PROP)
                .using(EAMTables.EAM_INSPECTION_TASK_POINT.POINT_ID).join(EAMTables.EAM_INSPECTION_POINT.ID);

        this.property(InspectionTaskPointMeta.ASSET_PROP)
                .using(EAMTables.EAM_INSPECTION_TASK_POINT.POINT_ID).join(EAMTables.EAM_INSPECTION_POINT.ID)
                .using(EAMTables.EAM_INSPECTION_POINT.ASSET_ID).join(EAMTables.EAM_ASSET.ID);

        this.property(InspectionTaskPointMeta.CHECK_ITEM_LIST_PROP)
                .using(EAMTables.EAM_INSPECTION_TASK_POINT.POINT_ID).join(EAMTables.EAM_INSPECTION_POINT.ID)
                  .using(EAMTables.EAM_INSPECTION_POINT.ID).join(EAMTables.EAM_INSPECTION_POINT_ITEM.POINT_ID)
                  .using(EAMTables.EAM_INSPECTION_POINT_ITEM.ITEM_ID).join(EAMTables.EAM_CHECK_ITEM.ID);


        this.property(InspectionTaskPointMeta.CHECK_SELECT_LIST_PROP)
                .using(EAMTables.EAM_INSPECTION_TASK_POINT.ID).join(EAMTables.EAM_CHECK_SELECT.TASK_POINT_ID)
                .after((tag,point,checkItems,map)->{
                    HashMap<String,Integer> data= calculateInspectTaskPointItemStatistics(checkItems);
                point.setItemCount(data.getOrDefault("allCount",0)+"");
                    return checkItems;
                });

        this.property(InspectionTaskPointMeta.OPER_USER_PROP)
                .using(EAMTables.EAM_INSPECTION_TASK_POINT.OPER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(InspectionTaskPointMeta.ROUTE_PROP)
                .using(EAMTables.EAM_INSPECTION_TASK_POINT.POINT_ROUTE_ID).join(EAMTables.EAM_INSPECTION_ROUTE.ID);

        this.property(InspectionTaskPointMeta.TASK_PROP)
                .using(EAMTables.EAM_INSPECTION_TASK_POINT.TASK_ID).join(EAMTables.EAM_INSPECTION_TASK.ID);

        this.property(InspectionTaskPointMeta.INSPECTION_POINT_POS_PROP)
                .using(EAMTables.EAM_INSPECTION_TASK_POINT.POINT_POS_ID).join(EAMTables.EAM_INSPECTION_POINT_POS.ID);

    }


    private HashMap<String,Integer> calculateInspectTaskPointStatusStatistics(List<InspectionTaskPoint> assets){
        HashMap<String,Integer> map=new HashMap<>();
        int pointCount=0;
        int pointNormalCount=0;
        int pointAbormalCount=0;
        int pointWaitCount=0;

        if(assets!=null&&assets.size()>0){
            for(int i=0;i<assets.size();i++){
                pointCount++;
                if(InspectionTaskPointStatusEnum.WAIT.code().equals(assets.get(i).getPointStatus())){
                    pointWaitCount++;
                }else if(InspectionTaskPointStatusEnum.NORMAL.code().equals(assets.get(i).getPointStatus())){
                    pointNormalCount++;
                }else if(InspectionTaskPointStatusEnum.ABNORMAL.code().equals(assets.get(i).getPointStatus())){
                    pointAbormalCount++;
                }
            }
            map.put("pointCount",pointCount);
            map.put("pointNormalCount",pointNormalCount);
            map.put("pointAbormalCount",pointAbormalCount);
            map.put("pointWaitCount",pointWaitCount);
        }
        return map;
    }

    public void setupInspectionTaskAbnormal() {
        this.property(InspectionTaskAbnormalMeta.OPER_USER_PROP)
                .using(EAMTables.EAM_INSPECTION_TASK_ABNORMAL.OPER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(InspectionTaskAbnormalMeta.TASK_PROP)
                .using(EAMTables.EAM_INSPECTION_TASK_ABNORMAL.TASK_ID).join(EAMTables.EAM_INSPECTION_TASK.ID);

    }


    public void setupInspectionTask() {

        this.property(InspectionTaskMeta.INSPECTION_TASK_POINT_LIST_PROP)
                .using(EAMTables.EAM_INSPECTION_TASK.ID).join(EAMTables.EAM_INSPECTION_TASK_POINT.TASK_ID).after((tag,point,checkItems,map)->{
            HashMap<String,Integer> data= calculateInspectTaskPointStatusStatistics(checkItems);
            point.setPointCount(data.getOrDefault("pointCount",0)+"");
            point.setPointNormalCount(data.getOrDefault("pointNormalCount",0)+"");
            point.setPointAbormalCount(data.getOrDefault("pointAbormalCount",0)+"");
            point.setPointWaitCount(data.getOrDefault("pointWaitCount",0)+"");
            return checkItems;
        });

        // 关联来源
        this.property(InspectionTaskMeta.INSPECTION_PLAN_PROP)
                .using(EAMTables.EAM_INSPECTION_TASK.PLAN_ID).join(EAMTables.EAM_INSPECTION_PLAN.ID);

        //制单人
        this.property(InspectionTaskMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_INSPECTION_TASK.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        //制单人
        this.property(InspectionTaskMeta.EXECUTOR_PROP)
                .using(EAMTables.EAM_INSPECTION_TASK.EXECUTOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);




        this.property(InspectionTaskMeta.INSPECTION_GROUP_PROP)
                .using(EAMTables.EAM_INSPECTION_TASK.GROUP_ID).join(EAMTables.EAM_INSPECTION_GROUP.ID);

        this.property(InspectionTaskMeta.INSPECT_USER_LIST_PROP)
                .using(EAMTables.EAM_INSPECTION_TASK.GROUP_ID).join(EAMTables.EAM_INSPECTION_GROUP.ID)
                 .using(EAMTables.EAM_INSPECTION_GROUP.ID).join(EAMTables.EAM_INSPECTION_GROUP_USER.GROUP_ID)
                 .using(EAMTables.EAM_INSPECTION_GROUP_USER.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
    }

    public void setupAssetStockOut(){
        //关联 所属公司
        this.property(AssetStockGoodsOutMeta.USE_OWN_COMPANY_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.USE_OWN_COMPANY_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

        this.property(AssetStockGoodsOutMeta.USE_ORGANIZATION_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.USE_ORGANIZATION_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

        //制单人
        this.property(AssetStockGoodsOutMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(AssetStockGoodsOutMeta.USE_USER_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.USE_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        //关联 仓库
        this.property(AssetStockGoodsOutMeta.WAREHOUSE_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.WAREHOUSE_ID).join(EAMTables.EAM_WAREHOUSE.ID);


        this.property(AssetStockGoodsOutMeta.STOCK_TYPE_DICT_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.STOCK_TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_stock_out_type'");

        this.property(AssetStockGoodsOutMeta.GOODS_LIST_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.ID).join(EAMTables.EAM_GOODS_STOCK.OWNER_ID);
//                .condition("status='eam_stock_out_type'");

    }
    public void setupAssetStockAdjust(){
        //制单人
        this.property(AssetStockGoodsAdjustMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS_ADJUST.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        //关联 仓库
        this.property(AssetStockGoodsAdjustMeta.WAREHOUSE_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS_ADJUST.WAREHOUSE_ID).join(EAMTables.EAM_WAREHOUSE.ID);

        this.property(AssetStockGoodsAdjustMeta.GOODS_LIST_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS_ADJUST.ID).join(EAMTables.EAM_GOODS_STOCK.OWNER_ID);


    }

    public void setupAssetStockUsage(){

        this.property(GoodsStockUsageMeta.OPS_USER_PROP)
                .using(EAMTables.EAM_GOODS_STOCK_USAGE.OPER_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

    }
    public void setupAssetStockTranfer(){

        //制单人
        this.property(AssetStockGoodsTranferMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        //关联 仓库
        this.property(AssetStockGoodsTranferMeta.WAREHOUSE_IN_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.WAREHOUSE_IN_ID).join(EAMTables.EAM_WAREHOUSE.ID);

        //关联 仓库
        this.property(AssetStockGoodsTranferMeta.WAREHOUSE_OUT_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.WAREHOUSE_OUT_ID).join(EAMTables.EAM_WAREHOUSE.ID);

        this.property(AssetStockGoodsTranferMeta.GOODS_LIST_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.ID).join(EAMTables.EAM_GOODS_STOCK.OWNER_ID);

    }


    public void setupAssetStorage() {

        //制单人
        this.property(AssetStorageMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_STORAGE.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        //管理人
        this.property(AssetStorageMeta.MANAGER_USER_PROP)
                .using(EAMTables.EAM_ASSET_STORAGE.MANAGER_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);


        //关联 所属公司
        this.property(AssetStorageMeta.OWNER_COMPANY_PROP)
                .using(EAMTables.EAM_ASSET_STORAGE.OWN_COMPANY_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

        //关联 供应商
        this.property(AssetStorageMeta.SUPPLIER_PROP)
                .using(EAMTables.EAM_ASSET_STORAGE.SUPPLIER_ID).join(EAMTables.EAM_SUPPLIER.ID);


        //资产
        this.property(AssetStorageMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_STORAGE.ID).join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using(EAMTables.EAM_ASSET_ITEM.ASSET_ID).join(EAMTables.EAM_ASSET.ID);

    }


    public void setupAssetStockIn() {
        this.property(AssetStockGoodsInMeta.GOODS_LIST_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS_IN.ID).join(EAMTables.EAM_GOODS_STOCK.OWNER_ID);


        this.property(AssetStockGoodsInMeta.SOURCE_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS_IN.SOURCE_ID).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_source'");

        this.property(AssetStockGoodsInMeta.STOCK_TYPE_DICT_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS_IN.STOCK_TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_stock_in_type'");


        //关联 仓库
        this.property(AssetStockGoodsInMeta.WAREHOUSE_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS_IN.WAREHOUSE_ID).join(EAMTables.EAM_WAREHOUSE.ID);

        //制单人
        this.property(AssetStockGoodsInMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS_IN.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        //管理人
        this.property(AssetStockGoodsInMeta.MANAGER_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS_IN.MANAGER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);


        //关联 所属公司
        this.property(AssetStockGoodsInMeta.OWNER_COMPANY_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS_IN.OWN_COMPANY_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);


    }



    private void setupGoodsStock(){

        // 关联子级档案
        this.property(GoodsStockMeta.SUB_GOODS_STOCK_LIST_PROP)
                .using(EAMTables.EAM_GOODS_STOCK.ID).join(EAMTables.EAM_GOODS_STOCK_RELATED.PARENT_GOODS_ID).condition("select_code='def'")
                .using(EAMTables.EAM_GOODS_STOCK_RELATED.GOODS_ID).join(EAMTables.EAM_GOODS_STOCK.ID);

        // 关联父级档案
        this.property(GoodsStockMeta.PARENT_GOODS_STOCK_LIST_PROP)
                .using(EAMTables.EAM_GOODS_STOCK.ID).join(EAMTables.EAM_GOODS_STOCK_RELATED.GOODS_ID).condition("select_code='def'")
               .using(EAMTables.EAM_GOODS_STOCK_RELATED.PARENT_GOODS_ID).join(EAMTables.EAM_GOODS_STOCK.ID);

        //物品分级档案
        this.property(GoodsStockMeta.GOODS_PARENT_GOODS_STOCK_LIST_PROP)
                .using(EAMTables.EAM_GOODS_STOCK.GOODS_ID).join(EAMTables.EAM_GOODS_STOCK_RELATED.GOODS_ID).condition("select_code='def'")
                .using(EAMTables.EAM_GOODS_STOCK_RELATED.PARENT_GOODS_ID).join(EAMTables.EAM_GOODS_STOCK.ID);



        // 关联品牌
        this.property(GoodsStockMeta.BRAND_PROP)
                .using(EAMTables.EAM_GOODS_STOCK.BRAND_ID).join(EAMTables.EAM_BRAND.ID);

        // 关联生产厂商
        this.property(GoodsStockMeta.MANUFACTURER_PROP)
                .using(EAMTables.EAM_GOODS_STOCK.MANUFACTURER_ID).join(EAMTables.EAM_MANUFACTURER.ID);

        // 关联分类
        this.property(GoodsStockMeta.CATEGORY_PROP)
                .using(EAMTables.EAM_GOODS_STOCK.CATEGORY_ID).join(FoxnicWeb.PCM_CATALOG.ID);


        // 关联来源
        this.property(GoodsStockMeta.SOURCE_PROP)
                .using(EAMTables.EAM_GOODS_STOCK.SOURCE_ID).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_source'");


        //关联 所属公司
        this.property(GoodsStockMeta.OWNER_COMPANY_PROP)
                .using(EAMTables.EAM_GOODS_STOCK.OWN_COMPANY_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);


        //关联 仓库
        this.property(GoodsStockMeta.WAREHOUSE_PROP)
                .using(EAMTables.EAM_GOODS_STOCK.WAREHOUSE_ID).join(EAMTables.EAM_WAREHOUSE.ID);

        //关联 使用公司
        this.property(GoodsStockMeta.USE_ORGANIZATION_PROP)
                .using(EAMTables.EAM_GOODS_STOCK.USE_ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

        //制单人
        this.property(GoodsStockMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_GOODS_STOCK.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        //管理人
        this.property(GoodsStockMeta.MANAGER_PROP)
                .using(EAMTables.EAM_GOODS_STOCK.MANAGER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        //物品
        this.property(GoodsStockMeta.GOODS_PROP)
                .using(EAMTables.EAM_GOODS_STOCK.GOODS_ID).join(EAMTables.EAM_GOODS_STOCK.ID);

        //库存数据
        this.property(GoodsStockMeta.REAL_GOODS_PROP)
                .using(EAMTables.EAM_GOODS_STOCK.REAL_STOCK_ID).join(EAMTables.EAM_GOODS_STOCK.ID);

    }
    public void setupAssetStockGoods(){
        // 关联来源
        this.property(AssetStockGoodsMeta.SOURCE_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS.SOURCE_ID).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_source'");


        // 关联供应商
        this.property(AssetStockGoodsMeta.SUPPLIER_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS.SUPPLIER_ID).join(EAMTables.EAM_SUPPLIER.ID);



        //关联 所属公司
        this.property(AssetStockGoodsMeta.OWNER_COMPANY_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS.OWN_COMPANY_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);


        //关联 仓库
        this.property(AssetStockGoodsMeta.WAREHOUSE_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS.WAREHOUSE_ID).join(EAMTables.EAM_WAREHOUSE.ID);

        //关联 使用公司
        this.property(AssetStockGoodsMeta.USE_ORGANIZATION_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS.USE_ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

        //制单人
        this.property(AssetStockGoodsMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        //物品
        this.property(AssetStockGoodsMeta.GOODS_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_GOODS.GOODS_ID).join(EAMTables.EAM_GOODS_STOCK.ID);
    }

    public void setupAssetStockDeliver(){

        this.property(AssetStockDeliverMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_DELIVER.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(AssetStockDeliverMeta.RECEIVER_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_DELIVER.RECEIVER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(AssetStockDeliverMeta.RECEIVING_COMPANY_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_DELIVER.RECEIVING_COMPANY_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

        this.property(AssetStockDeliverMeta.RECEIVING_ORG_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_DELIVER.RECEIVING_ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);


        // 关联资产
        this.property(AssetStockDeliverMeta.DELIVER_ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_DELIVER.ID ).join(EAMTables.EAM_ASSET.INTERNAL_CONTROL_LABEL);



    }

    public void setupStockImport(){

        this.property(StockImportMeta.STOCK_GOODS_OUT_PROP)
                .using(EAMTables.EAM_STOCK_IMPORT.ORDER_ID).join(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.ID);

        this.property(StockImportMeta.OPER_USER_PROP)
                .using(EAMTables.EAM_STOCK_IMPORT.OPER_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(StockImportMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_STOCK_IMPORT.ID).join(EAMTables.EAM_ASSET.BILL_ID);

        this.property(StockImportMeta.MANAGER_PROP)
                .using(EAMTables.EAM_STOCK_IMPORT.MANAGER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(StockImportMeta.USE_USER_PROP)
                .using(EAMTables.EAM_STOCK_IMPORT.USE_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(StockImportMeta.USE_ORGANIZATION_PROP)
                .using(EAMTables.EAM_STOCK_IMPORT.USE_ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

        this.property(StockImportMeta.OWNER_COMPANY_PROP)
                .using(EAMTables.EAM_STOCK_IMPORT.OWN_COMPANY_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

        this.property(StockImportMeta.POSITION_PROP)
                .using(EAMTables.EAM_STOCK_IMPORT.POSITION_ID).join(EAMTables.EAM_POSITION.ID);

    }

    public void setupPurchaseImport(){

        this.property(PurchaseImportMeta.PURCHASE_APPLY_PROP)
                .using(EAMTables.EAM_PURCHASE_IMPORT.ORDER_ID).join(EAMTables.EAM_PURCHASE_APPLY.ID);

        this.property(PurchaseImportMeta.OPER_USER_PROP)
                .using(EAMTables.EAM_PURCHASE_IMPORT.OPER_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(PurchaseImportMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_PURCHASE_IMPORT.ID).join(EAMTables.EAM_ASSET.BILL_ID);

        this.property(PurchaseImportMeta.MANAGER_PROP)
                .using(EAMTables.EAM_PURCHASE_IMPORT.MANAGER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(PurchaseImportMeta.USE_USER_PROP)
                .using(EAMTables.EAM_PURCHASE_IMPORT.USE_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(PurchaseImportMeta.USE_ORGANIZATION_PROP)
                .using(EAMTables.EAM_PURCHASE_IMPORT.USE_ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

        this.property(PurchaseImportMeta.OWNER_COMPANY_PROP)
                .using(EAMTables.EAM_PURCHASE_IMPORT.OWN_COMPANY_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

        this.property(PurchaseImportMeta.POSITION_PROP)
                .using(EAMTables.EAM_PURCHASE_IMPORT.POSITION_ID).join(EAMTables.EAM_POSITION.ID);

    }

    public void setupPurchaseOrder() {

        this.property(PurchaseOrderMeta.GOODS_PROP)
                .using(EAMTables.EAM_PURCHASE_ORDER.GOODS_ID).join(EAMTables.EAM_GOODS_STOCK.ID);

        this.property(PurchaseOrderMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_PURCHASE_ORDER.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(PurchaseOrderMeta.PURCHASE_APPLY_PROP)
                .using(EAMTables.EAM_PURCHASE_ORDER.APPLY_ID).join(EAMTables.EAM_PURCHASE_APPLY.ID);

        this.property(PurchaseOrderMeta.PURCHASE_CHECK_PROP)
                .using(EAMTables.EAM_PURCHASE_ORDER.CHECK_ID).join(EAMTables.EAM_PURCHASE_CHECK.ID);






    }


    public void setupPurchaseApply() {


        this.property(PurchaseApplyMeta.ORDER_LIST_PROP)
                .using(EAMTables.EAM_PURCHASE_APPLY.ID).join(EAMTables.EAM_PURCHASE_ORDER.APPLY_ID)
                .condition("selected_code='def'");;


        this.property(PurchaseApplyMeta.APPLY_ORG_PROP)
                .using(EAMTables.EAM_PURCHASE_APPLY.APPLY_ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);


        this.property(PurchaseApplyMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_PURCHASE_APPLY.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(PurchaseApplyMeta.SUPPLIER_PROP)
                .using(EAMTables.EAM_PURCHASE_APPLY.SUPPLIER_ID).join(EAMTables.EAM_SUPPLIER.ID);


    }

    public void setupPurchaseCheck() {

        this.property(PurchaseCheckMeta.PURCHASE_APPLY_PROP)
                .using(EAMTables.EAM_PURCHASE_CHECK.APPLY_ID).join(EAMTables.EAM_PURCHASE_APPLY.ID);

//        this.property(PurchaseCheckMeta.CHECK_ORG_PROP)
//                .using(EAMTables.EAM_PURCHASE_CHECK.CHECK_ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

        this.property(PurchaseCheckMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_PURCHASE_CHECK.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(PurchaseCheckMeta.SUPPLIER_PROP)
                .using(EAMTables.EAM_PURCHASE_CHECK.SUPPLIER_ID).join(EAMTables.EAM_SUPPLIER.ID);


    }

    public void setupAssetDataPermissions(){

        this.property(AssetDataPermissionsMeta.BUSI_ROLE_PROP)
                .using(EAMTables.EAM_ASSET_DATA_PERMISSIONS.ROLE_CODE)
                .join(FoxnicWeb.SYS_BUSI_ROLE.CODE);

        this.property(AssetDataPermissionsMeta.POSITION_PROP)
                .using(EAMTables.EAM_ASSET_DATA_PERMISSIONS.ID).join(EAMTables.EAM_ASSET_DATA_PERMISSIONS_POSITION.PERMISSION_ID)
                .using(EAMTables.EAM_ASSET_DATA_PERMISSIONS_POSITION.VALUE).join(EAMTables.EAM_POSITION.ID)
                .after((tag,dp,pos,m)->{
                     if(dp.getPositionIds()==null){
                         dp.setPositionIds(new ArrayList<>());
                     }
                      if(dp.getPositionIds().size()==0&&pos.size()>0){
                          for(int i=0;i<pos.size();i++){
                              dp.getPositionIds().add(pos.get(i).getId());
                          }
                      }
                    return pos;
                });
        this.property(AssetDataPermissionsMeta.WAREHOUSE_PROP)
                .using(EAMTables.EAM_ASSET_DATA_PERMISSIONS.ID).join(EAMTables.EAM_ASSET_DATA_PERMISSIONS_WH.PERMISSION_ID)
                .using(EAMTables.EAM_ASSET_DATA_PERMISSIONS_WH.VALUE).join(EAMTables.EAM_WAREHOUSE.ID)
                .after((tag,dp,pos,m)->{
                    if(dp.getWarehouseIds()==null){
                        dp.setWarehouseIds(new ArrayList<>());
                    }
                    if(dp.getWarehouseIds().size()==0&&pos.size()>0){
                        for(int i=0;i<pos.size();i++){
                            dp.getWarehouseIds().add(pos.get(i).getId());
                        }
                    }
                    return pos;
                });

        this.property(AssetDataPermissionsMeta.CATEGORY_PROP)
                .using(EAMTables.EAM_ASSET_DATA_PERMISSIONS.ID).join(EAMTables.EAM_ASSET_DATA_PERMISSIONS_CATALOG.PERMISSION_ID)
                .using(EAMTables.EAM_ASSET_DATA_PERMISSIONS_CATALOG.VALUE).join(FoxnicWeb.PCM_CATALOG.ID)
                .after((tag,dp,catalog,m)->{
            if(dp.getCategoryIds()==null){
                dp.setCategoryIds(new ArrayList<>());
            }
            if(dp.getCategoryIds().size()==0&&catalog.size()>0){
                for(int i=0;i<catalog.size();i++){
                    dp.getCategoryIds().add(catalog.get(i).getId());
                }
            }
            return catalog;
        });

        this.property(AssetDataPermissionsMeta.ORGANIZATION_PROP)
                .using(EAMTables.EAM_ASSET_DATA_PERMISSIONS.ID).join(EAMTables.EAM_ASSET_DATA_PERMISSIONS_ORG.PERMISSION_ID)
                .using(EAMTables.EAM_ASSET_DATA_PERMISSIONS_ORG.VALUE).join(FoxnicWeb.HRM_ORGANIZATION.ID)
                .after((tag,dp,org,m)->{
            if(dp.getOrganizationIds()==null){
                dp.setOrganizationIds(new ArrayList<>());
            }
            if(dp.getOrganizationIds().size()==0&&org.size()>0){
                for(int i=0;i<org.size();i++){
                    dp.getOrganizationIds().add(org.get(i).getId());
                }
            }
            return org;
        });

        this.property(AssetDataPermissionsMeta.OWN_ORGANIZATION_PROP)
                .using(EAMTables.EAM_ASSET_DATA_PERMISSIONS.ID).join(EAMTables.EAM_ASSET_DATA_PERMISSIONS_O_ORG.PERMISSION_ID)
                .using(EAMTables.EAM_ASSET_DATA_PERMISSIONS_O_ORG.VALUE).join(FoxnicWeb.HRM_ORGANIZATION.ID)
                .after((tag,dp,org,m)->{
                    if(dp.getOwnOrganizationIds()==null){
                        dp.setOwnOrganizationIds(new ArrayList<>());
                    }
                    if(dp.getOwnOrganizationIds().size()==0&&org.size()>0){
                        for(int i=0;i<org.size();i++){
                            dp.getOwnOrganizationIds().add(org.get(i).getId());
                        }
                    }
                    return org;
                });


    }

    public void setupScrap(){
        this.property(AssetScrapMeta.METHOD_DICT_PROP)
                .using(EAMTables.EAM_ASSET_SCRAP.METHOD).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_scrap_method'");

        this.property(AssetScrapMeta.CHANGE_INSTANCE_PROP)
                .using(EAMTables.EAM_ASSET_SCRAP.CHANGE_INSTANCE_ID )
                .join(FoxnicWeb.CHS_CHANGE_INSTANCE.ID);

        this.property(AssetScrapMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_SCRAP.ID ).join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using(EAMTables.EAM_ASSET_ITEM.ASSET_ID).join( EAMTables.EAM_ASSET.ID);


        this.property(AssetScrapMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_SCRAP.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
    }

    public void setupAssetDataChange(){

        this.property(AssetDataChangeMeta.CHANGE_INSTANCE_PROP)
                .using(EAMTables.EAM_ASSET_DATA_CHANGE.CHANGE_INSTANCE_ID )
                .join(FoxnicWeb.CHS_CHANGE_INSTANCE.ID);

        // 关联资产
        this.property(AssetDataChangeMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_DATA_CHANGE.ID )
                .join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using(EAMTables.EAM_ASSET_ITEM.ASSET_ID)
                .join( EAMTables.EAM_ASSET.ID);


        //变更数据
        this.property(AssetDataChangeMeta.CHANGE_DATA_PROP)
                .using(EAMTables.EAM_ASSET_DATA_CHANGE.ASSET_CHANGE_ID).join(EAMTables.EAM_ASSET.ID);


        // 制单人
        this.property(AssetDataChangeMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_DATA_CHANGE.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

    }




    public void setupAlloction() {

        // 关联资产
        this.property(AssetAllocationMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_ALLOCATION.ID ).join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using( EAMTables.EAM_ASSET_ITEM.ASSET_ID).join( EAMTables.EAM_ASSET.ID);

        // 关联
        this.property(AssetAllocationMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_ALLOCATION.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);



        this.property(AssetAllocationMeta.MANAGER_PROP)
                .using(EAMTables.EAM_ASSET_ALLOCATION.MANAGER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);

        this.property(AssetAllocationMeta.IN_OWNER_COMPANY_PROP)
                .using(EAMTables.EAM_ASSET_ALLOCATION.IN_OWN_COMPANY_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

        this.property(AssetAllocationMeta.OUT_OWNER_COMPANY_PROP)
                .using(EAMTables.EAM_ASSET_ALLOCATION.OUT_OWN_COMPANY_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

    }


    private void setupTplFile() {
        this.property(TplFileMeta.BUSINESS_CODE_PROP)
                .using(EAMTables.EAM_TPL_FILE.CODE).join(EAMTables.SYS_CODE_REGISTER.CODE);

    }


    public void setupAssetAttributeItem() {
        // 关联字段
        this.property(AssetAttributeItemMeta.ATTRIBUTE_PROP)
                .using(EAMTables.EAM_ASSET_ATTRIBUTE_ITEM.ATTRIBUTE_ID).join(EAMTables.EAM_ASSET_ATTRIBUTE.ID);

    }


    public void setupInventoryPlan() {


        // 关联来源
        this.property(InventoryPlanMeta.INVENTORY_PLAN_TYPE_PROP)
                .using(EAMTables.EAM_INVENTORY_PLAN.PLAN_TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_inventory_plan_type'");

        this.property(InventoryPlanMeta.INVENTORY_PROP)
                .using(EAMTables.EAM_INVENTORY_PLAN.ID).join(EAMTables.EAM_INVENTORY.PLAN_ID);




    }




    private HashMap<String,Integer> calculateInventoryAssetQuantityStatistics(List<InventoryAsset> assets){
        HashMap<String,Integer> map=new HashMap<>();
        int notCount=0;
        int count=0;
        int loss=0;
        int surplus=0;
        int dataException=0;
        if(assets!=null&&assets.size()>0){
            for(int i=0;i<assets.size();i++){
                if(AssetInventoryDetailStatusEnum.NOT_COUNTED.code().equals( assets.get(i).getStatus())){
                    notCount++;
                }else if(AssetInventoryDetailStatusEnum.COUNTED.code().equals( assets.get(i).getStatus())){
                    count++;
                }else if(AssetInventoryDetailStatusEnum.LOSS.code().equals( assets.get(i).getStatus())){
                    loss++;
                }else if(AssetInventoryDetailStatusEnum.SURPLUS.code().equals( assets.get(i).getStatus())){
                    surplus++;
                }else if(AssetInventoryDetailStatusEnum.EXCEPTION.code().equals( assets.get(i).getStatus())){
                    dataException++;
                }
            }
            map.put(AssetInventoryDetailStatusEnum.NOT_COUNTED.code(),notCount);
            map.put(AssetInventoryDetailStatusEnum.COUNTED.code(),count);
            map.put(AssetInventoryDetailStatusEnum.LOSS.code(),loss);
            map.put(AssetInventoryDetailStatusEnum.SURPLUS.code(),surplus);
            map.put(AssetInventoryDetailStatusEnum.EXCEPTION.code(),dataException);
        }
        return map;
    }

    public void setupInventory() {

        this.property(InventoryMeta.INVENTORY_ASSET_INFO_LIST_PROP)
                .using(EAMTables.EAM_INVENTORY.ID).join(EAMTables.EAM_INVENTORY_ASSET.INVENTORY_ID).after((tag,inventory,assets,map)->{

            HashMap<String,Integer> data= calculateInventoryAssetQuantityStatistics(assets);
            inventory.setInventoryAssetCountByNotCounted(data.getOrDefault(AssetInventoryDetailStatusEnum.NOT_COUNTED.code(),0));
            inventory.setInventoryAssetCountByCounted(data.getOrDefault(AssetInventoryDetailStatusEnum.COUNTED.code(),0));
            inventory.setInventoryAssetCountByLoss(data.getOrDefault(AssetInventoryDetailStatusEnum.LOSS.code(),0));
            inventory.setInventoryAssetCountBySurplus(data.getOrDefault(AssetInventoryDetailStatusEnum.SURPLUS.code(),0));
            inventory.setInventoryAssetCountByException(data.getOrDefault(AssetInventoryDetailStatusEnum.EXCEPTION.code(),0));
            return assets;
        });

        this.property(Inventory.class,InventoryMeta.INVENTORY_ASSET_COUNT_BY_LOSS,InventoryAsset.class)
                .using(EAMTables.EAM_INVENTORY.ID).join(EAMTables.EAM_INVENTORY_ASSET.ASSET_ID).groupForCount();

        //位置
        this.property(InventoryMeta.POSITION_PROP)
                .using(EAMTables.EAM_INVENTORY.ID).join(EAMTables.EAM_INVENTORY_POSITION.INVENTORY_ID)
                .using(EAMTables.EAM_INVENTORY_POSITION.VALUE).join(EAMTables.EAM_POSITION.ID);

        //仓库
        this.property(InventoryMeta.WAREHOUSE_PROP)
                .using(EAMTables.EAM_INVENTORY.ID).join(EAMTables.EAM_INVENTORY_WAREHOUSE.INVENTORY_ID)
                .using(EAMTables.EAM_INVENTORY_WAREHOUSE.VALUE).join(EAMTables.EAM_WAREHOUSE.ID);

        //关联 使用组织
        this.property(InventoryMeta.USE_ORGANIZATION_PROP)
                .using(EAMTables.EAM_INVENTORY.USE_ORGANIZATION_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

        //关联 所属公司
        this.property(InventoryMeta.OWNER_COMPANY_PROP)
                .using(EAMTables.EAM_INVENTORY.OWN_COMPANY_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

        // 关联资产分类
        this.property(InventoryMeta.CATEGORY_PROP)
                .using(EAMTables.EAM_INVENTORY.ID).join(EAMTables.EAM_INVENTORY_CATALOG.INVENTORY_ID)
                .using(EAMTables.EAM_INVENTORY_CATALOG.VALUE).join(FoxnicWeb.PCM_CATALOG.ID);


        //制单人
        this.property(InventoryMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_INVENTORY.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        //盘点人
        this.property(InventoryMeta.INVENTORY_USER_PROP)
                .using(EAMTables.EAM_INVENTORY.ID).join(EAMTables.EAM_INVENTORY_USER.INVENTORY_ID)
                .using(EAMTables.EAM_INVENTORY_USER.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        //负责人
        this.property(InventoryMeta.DIRECTOR_PROP)
                .using(EAMTables.EAM_INVENTORY.ID).join(EAMTables.EAM_INVENTORY_DIRECTOR.INVENTORY_ID)
                .using(EAMTables.EAM_INVENTORY_DIRECTOR.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        //管理人
        this.property(InventoryMeta.MANAGER_PROP)
                .using(EAMTables.EAM_INVENTORY.ID).join(EAMTables.EAM_INVENTORY_MANAGER.INVENTORY_ID)
                .using(EAMTables.EAM_INVENTORY_MANAGER.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

    }



    public void setupAssetStockCollection(){
        // 关联资产
        this.property(AssetStockCollectionMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_COLLECTION.ID ).join(EAMTables.EAM_ASSET.INTERNAL_CONTROL_LABEL);


        // 关联位置
        this.property(AssetStockCollectionMeta.POSITION_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_COLLECTION.POSITION_ID)
                .join( EAMTables.EAM_POSITION.ID);

        // 关联制单人
        this.property(AssetStockCollectionMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_COLLECTION.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);

        // 关联使用人
        this.property(AssetStockCollectionMeta.USE_USER_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_COLLECTION.USE_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);

        this.property(AssetStockCollectionMeta.USE_ORGANIZATION_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_COLLECTION.USE_ORGANIZATION_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);
    }



    public void setupAssetStock(){
        this.property(StockMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_STOCK.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        // 关联资产
        this.property(StockMeta.STOCK_ASSET_LIST_PROP)
                .using(EAMTables.EAM_STOCK.ID ).join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using(EAMTables.EAM_ASSET_ITEM.ASSET_ID).join(EAMTables.EAM_ASSET.ID);


        this.property(StockMeta.CHANGE_INSTANCE_PROP)
                .using(EAMTables.EAM_STOCK.CHANGE_INSTANCE_ID ).join(FoxnicWeb.CHS_CHANGE_INSTANCE.ID);


        // 关联来源
        this.property(StockMeta.SOURCE_PROP)
                .using(EAMTables.EAM_STOCK.SOURCE_ID).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_source'");

        // 关联供应商
        this.property(StockMeta.SUPPLIER_PROP)
                .using(EAMTables.EAM_STOCK.SUPPLIER_ID).join(EAMTables.EAM_SUPPLIER.ID);


        // 关联仓库
        this.property(StockMeta.WAREHOUSE_PROP)
                .using(EAMTables.EAM_STOCK.WAREHOUSE_ID).join(EAMTables.EAM_WAREHOUSE.ID);


        // 关联管理人员
        this.property(StockMeta.MANAGER_PROP)
                .using(EAMTables.EAM_STOCK.MANAGER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
        //    .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);


        //关联 所属公司
        this.property(StockMeta.OWNER_COMPANY_PROP)
                .using(EAMTables.EAM_STOCK.OWN_COMPANY_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);




    }

    public void setupInventoryAsset() {

        this.property(InventoryAssetMeta.OPERATER_PROP)
                .using(EAMTables.EAM_INVENTORY_ASSET.OPER_EMPL_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(InventoryAssetMeta.ASSET_PROP)
                .using(EAMTables.EAM_INVENTORY_ASSET.ASSET_ID).join(EAMTables.EAM_ASSET.ID);

        this.property(InventoryAssetMeta.INVENTORY_PROP)
                .using(EAMTables.EAM_INVENTORY_ASSET.INVENTORY_ID).join(EAMTables.EAM_INVENTORY.ID);

    }

    public void setupInventoryDirecotor(){
        this.property(InventoryDirectorMeta.INVENTORY_DIRECTOR_PROP)
                .using(EAMTables.EAM_INVENTORY_DIRECTOR.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
    }

    public void setupInventoryUser() {

        this.property(InventoryUserMeta.INVENTORY_USER_PROP)
                .using(EAMTables.EAM_INVENTORY_USER.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

    }


    public void setupInventoryManager() {

        this.property(InventoryManagerMeta.INVENTORY_MANAGER_PROP)
                .using(EAMTables.EAM_INVENTORY_MANAGER.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

    }


    public void setupAssetBorrow() {

        this.property(AssetBorrowMeta.ASSET_ITEM_LIST_PROP)
                .using(EAMTables.EAM_ASSET_BORROW.ID )
                .join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID);


        // 关联资产
        this.property(AssetBorrowMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_BORROW.ID )
                .join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using( EAMTables.EAM_ASSET_ITEM.ASSET_ID)
                .join( EAMTables.EAM_ASSET.ID);


        // 关联制单人
        this.property(AssetBorrowMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_BORROW.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);

        // 关联借用人
        this.property(AssetBorrowMeta.BORROWER_PROP)
                .using(EAMTables.EAM_ASSET_BORROW.BORROWER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);

    }


    public void setupAssetCollection() {

        // 关联资产
        this.property(AssetCollectionMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_COLLECTION.ID ).join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using( EAMTables.EAM_ASSET_ITEM.ASSET_ID).join( EAMTables.EAM_ASSET.ID);



        // 关联位置
        this.property(AssetCollectionMeta.POSITION_PROP)
                .using(EAMTables.EAM_ASSET_COLLECTION.POSITION_ID).join( EAMTables.EAM_POSITION.ID);

        // 关联制单人
        this.property(AssetCollectionMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_COLLECTION.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);

        // 关联使用人
        this.property(AssetCollectionMeta.USE_USER_PROP)
                .using(EAMTables.EAM_ASSET_COLLECTION.USE_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);

        this.property(AssetCollectionMeta.USE_ORGANIZATION_PROP)
                .using(EAMTables.EAM_ASSET_COLLECTION.USE_ORGANIZATION_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

    }


    public void setupAssetCollectionReturn() {

        // 关联资产
        this.property(AssetCollectionReturnMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_COLLECTION_RETURN.ID ).join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using( EAMTables.EAM_ASSET_ITEM.ASSET_ID).join( EAMTables.EAM_ASSET.ID);



        // 关联位置
        this.property(AssetCollectionReturnMeta.POSITION_PROP)
                .using(EAMTables.EAM_ASSET_COLLECTION_RETURN.POSITION_ID)
                .join( EAMTables.EAM_POSITION.ID);

        // 关联制单人
        this.property(AssetCollectionReturnMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_COLLECTION_RETURN.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//               .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);


        this.property(AssetCollectionReturnMeta.USE_ORGANIZATION_PROP)
                .using(EAMTables.EAM_ASSET_COLLECTION_RETURN.USE_ORGANIZATION_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

    }


    public void setupAssetRepair() {


        // 关联资产
        this.property(AssetRepairMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_REPAIR.ID ).join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using( EAMTables.EAM_ASSET_ITEM.ASSET_ID).join( EAMTables.EAM_ASSET.ID);



        // 关联制单人
        this.property(AssetRepairMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_REPAIR.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);



        // 维修类型
        this.property(AssetRepairMeta.REPAIR_TYPE_PROP)
                .using(EAMTables.EAM_ASSET_REPAIR.TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_repair_type'");



        // 报修人
        this.property(AssetRepairMeta.REPORT_USER_PROP)
                .using(EAMTables.EAM_ASSET_REPAIR.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);


//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);



    }

    public void setupAssetTranfer() {

        // 关联资产
        this.property(AssetTranferMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_TRANFER.ID ).join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using( EAMTables.EAM_ASSET_ITEM.ASSET_ID).join( EAMTables.EAM_ASSET.ID);


        this.property(AssetTranferMeta.IN_USE_ORGANIZATION_PROP)
                .using(EAMTables.EAM_ASSET_TRANFER.IN_USE_ORGANIZATION_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

        this.property(AssetTranferMeta.OUT_USE_ORGANIZATION_PROP)
                .using(EAMTables.EAM_ASSET_TRANFER.OUT_USE_ORGANIZATION_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);


        // 关联位置
        this.property(AssetTranferMeta.POSITION_PROP)
                .using(EAMTables.EAM_ASSET_TRANFER.POSITION_ID).join(EAMTables.EAM_POSITION.ID);


        // 关联制单人
        this.property(AssetTranferMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_TRANFER.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);


        // 关联人员
        this.property(AssetTranferMeta.MANAGER_PROP)
                .using(EAMTables.EAM_ASSET_TRANFER.MANAGER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);

        // 关联使用人员
        this.property(AssetTranferMeta.USE_USER_PROP)
                .using(EAMTables.EAM_ASSET_TRANFER.USE_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);

    }

    public void setupAssetHandle() {
        // 关联资产
        this.property(AssetHandleMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_HANDLE.ID).join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using(EAMTables.EAM_ASSET_ITEM.ASSET_ID).join(EAMTables.EAM_ASSET.ID);




        // 关联制单人
        this.property(AssetHandleMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_HANDLE.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);


    }



//    public void setupAssetAssetExtAttribution() {
//
//        // 关联仓库
//        this.property(AssetExtAttributionMeta.WAREHOUSE_PROP)
//                .using(EAMTables.EAM_ASSET_EXT_ATTRIBUTION.WAREHOUSE_ID).join(EAMTables.EAM_WAREHOUSE.ID);
//
//
//
//    }
//        public void setupAssetEaintainer() {
//
////        // 关联区域
////        this.property(AssetExtEquipmentMeta.AREA_PROP)
////                .using(EAMTables.EAM_ASSET_EXT_EQUIPMENT.AREA_ID).join(DataCenterTables.DC_AREA.ID);
////
////        // 关联层级
////        this.property(AssetExtEquipmentMeta.LAYER_PROP)
////                .using(EAMTables.EAM_ASSET_EXT_EQUIPMENT.LAYER_ID).join(DataCenterTables.DC_LAYER.ID);
//
//        // 关联机柜
//        this.property(AssetExtEquipmentMeta.RACK_PROP)
//                .using(EAMTables.EAM_ASSET_EXT_EQUIPMENT.RACK_ID).join(DataCenterTables.DC_RACK.ID);
//
//    }

//    public void setupAssetMaintainer() {
//
//        // 关联维保商
//        this.property(AssetExtMaintainerMeta.MAINTNAINER_PROP)
//                .using(EAMTables.EAM_ASSET_EXT_MAINTAINER.MAINTAINER_ID).join(EAMTables.EAM_MAINTAINER.ID);
//    }
//
//    public void setupAssetFinancial() {
//



//    }

    public void  setupAssetMaintenanceRecordUpdate(){

        // 关联维保商
        this.property(AssetMaintenanceRecordUMeta.MAINTNAINER_PROP)
                .using(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.MAINTAINER_ID).join(EAMTables.EAM_MAINTAINER.ID);

        // 建议维保方式
        this.property(AssetMaintenanceRecordUMeta.MAINTENANCE_METHOD_DATA_PROP)
                .using(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.MAINTENANCE_METHOD).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_maintenance_method'");

        // 维保方式
        this.property(AssetMaintenanceRecordUMeta.SUGGEST_MAINTENANCE_METHOD_DATA_PROP)
                .using(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.SUGGEST_MAINTENANCE_METHOD).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_suggest_maintenance_method'");

        this.property(AssetMaintenanceRecordUMeta.ASSET_MAINTENANCE_STATUS_PROP)
                .using(EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U.MAINTENANCE_STATUS).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_maintenance_status'");

    }

    public void setupAssetMaintenanceRecord() {

        this.property(AssetMaintenanceRecordMeta.ASSET_MAINTENANCE_UPDATE_PROP)
                .using(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.MAINTENANCE_UPDATE_ID).join(EAMTables.EAM_ASSET_MAINTENANCE_UPDATE.ID);


        this.property(AssetMaintenanceRecordMeta.ASSET_STATUS_PROP)
                .using(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.ASSET_ID).join(EAMTables.EAM_ASSET.ID)
                .using(EAMTables.EAM_ASSET.ASSET_STATUS).join(EAMTables.EAM_ASSET_STATUS.CODE);

        // 关联资产分类
        this.property(AssetMaintenanceRecordMeta.CATEGORY_PROP)
                .using(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.ASSET_ID).join(EAMTables.EAM_ASSET.ID)
                .using(EAMTables.EAM_ASSET.CATEGORY_ID).join(FoxnicWeb.PCM_CATALOG.ID);


        this.property(AssetMaintenanceRecordMeta.ASSET_PROP)
                .using(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.ASSET_ID).join(EAMTables.EAM_ASSET.ID);


        // 关联维保商
        this.property(AssetMaintenanceRecordMeta.MAINTNAINER_PROP)
                .using(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.MAINTAINER_ID).join(EAMTables.EAM_MAINTAINER.ID);

        // 建议维保方式
        this.property(AssetMaintenanceRecordMeta.MAINTENANCE_METHOD_DATA_PROP)
                .using(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.MAINTENANCE_METHOD).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_maintenance_method'");

        // 维保方式
        this.property(AssetMaintenanceRecordMeta.SUGGEST_MAINTENANCE_METHOD_DATA_PROP)
                .using(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.SUGGEST_MAINTENANCE_METHOD).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_suggest_maintenance_method'");

        this.property(AssetMaintenanceRecordMeta.ASSET_MAINTENANCE_STATUS_PROP)
                .using(EAMTables.EAM_ASSET_MAINTENANCE_RECORD.MAINTENANCE_STATUS).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_maintenance_status'");

    }
    public void setupAsset() {




        this.property(AssetMeta.PART_ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET.GOODS_STOCK_ID).join(EAMTables.EAM_GOODS_STOCK.ID)
                .using(EAMTables.EAM_GOODS_STOCK.ID).join(EAMTables.EAM_GOODS_STOCK.PID)
                .using(EAMTables.EAM_GOODS_STOCK.PID).join(EAMTables.EAM_ASSET.GOODS_STOCK_ID);


        //领用
        this.property(AssetMeta.ASSET_BORROW_PROP)
                .using(EAMTables.EAM_ASSET.BORROW_ID ).join(EAMTables.EAM_ASSET_BORROW.ID);


        //借用
        this.property(AssetMeta.ASSET_COLLECTION_PROP)
                .using(EAMTables.EAM_ASSET.COLLECTION_ID ).join(EAMTables.EAM_ASSET_COLLECTION.ID);


        this.property(AssetMeta.CHANGE_INSTANCE_PROP)
                .using(EAMTables.EAM_ASSET.CHANGE_INSTANCE_ID ).join(FoxnicWeb.CHS_CHANGE_INSTANCE.ID);

        // 关联维保商
        this.property(AssetMeta.MAINTNAINER_PROP)
                .using(EAMTables.EAM_ASSET.MAINTAINER_ID).join(EAMTables.EAM_MAINTAINER.ID);

        // 关联来源
        this.property(AssetMeta.SOURCE_PROP)
                .using(EAMTables.EAM_ASSET.SOURCE_ID).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
          .condition("dict_code='eam_source'");

        // 建议维保方式
        this.property(AssetMeta.MAINTENANCE_METHOD_DATA_PROP)
                .using(EAMTables.EAM_ASSET.MAINTENANCE_METHOD).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_maintenance_method'");


        // 维保方式
        this.property(AssetMeta.SUGGEST_MAINTENANCE_METHOD_DATA_PROP)
                .using(EAMTables.EAM_ASSET.SUGGEST_MAINTENANCE_METHOD).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_suggest_maintenance_method'");


        // 费用方式
        this.property(AssetMeta.EXPENSE_ITEM_DICT_PROP)
                .using(EAMTables.EAM_ASSET.EXPENSE_ITEM).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_expense_items'");

        // 财务选项
        this.property(AssetMeta.FINANCIAL_OPTION_DICT_PROP)
                .using(EAMTables.EAM_ASSET.FINANCIAL_OPTION).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_financial_options'");



        // 关联安全等级
        this.property(AssetMeta.SAFETY_LEVEL_PROP)
                .using(EAMTables.EAM_ASSET.SAFETY_LEVEL_CODE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_safety_level'");

        // 关联运行环境
        this.property(AssetMeta.EQUIPMENT_ENVIRONMENT_PROP)
                .using(EAMTables.EAM_ASSET.EQUIPMENT_ENVIRONMENT_CODE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_equipment_environment'");

        // 关联维保
        this.property(AssetMeta.ASSET_MAINTENANCE_STATUS_PROP)
                .using(EAMTables.EAM_ASSET.MAINTENANCE_STATUS).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_maintenance_status'");

        // 关联机柜
        this.property(AssetMeta.RACK_PROP)
                .using(EAMTables.EAM_ASSET.RACK_ID).join(EAMTables.EAM_ASSET_RACK.ID);


        // 不在使用
        this.property(AssetMeta.GOODS_STOCK_PROP)
                .using(EAMTables.EAM_ASSET.GOODS_STOCK_ID).join(EAMTables.EAM_GOODS_STOCK.ID);

        // 关联物品档案
        this.property(AssetMeta.GOODS_PROP)
                .using(EAMTables.EAM_ASSET.GOODS_ID).join(EAMTables.EAM_GOODS_STOCK.ID);


        // 关联供应商
        this.property(AssetMeta.SUPPLIER_PROP)
                .using(EAMTables.EAM_ASSET.SUPPLIER_ID).join(EAMTables.EAM_SUPPLIER.ID);

        // 资产状态
        this.property(AssetMeta.ASSET_CYCLE_STATUS_PROP)
                .using(EAMTables.EAM_ASSET.ASSET_STATUS).join(EAMTables.EAM_ASSET_STATUS.CODE);

        // 关联生产厂商
        this.property(AssetMeta.MANUFACTURER_PROP)
                .using(EAMTables.EAM_ASSET.MANUFACTURER_ID).join(EAMTables.EAM_MANUFACTURER.ID);


        // 关联位置
        this.property(AssetMeta.POSITION_PROP)
                .using(EAMTables.EAM_ASSET.POSITION_ID).join(EAMTables.EAM_POSITION.ID);


        // 关联财务分类
        this.property(AssetMeta.CATEGORY_FINANCE_PROP)
                .using(EAMTables.EAM_ASSET.FINANCIAL_CATEGORY_ID).join(EAMTables.EAM_CATEGORY_FINANCE.ID);


        // 关联存放区域
        this.property(AssetMeta.REGION_PROP)
                .using(EAMTables.EAM_ASSET.REGION_ID).join(EAMTables.EAM_ASSET_REGION.ID);

        // 关联资产分类
        this.property(AssetMeta.CATEGORY_PROP)
                .using(EAMTables.EAM_ASSET.CATEGORY_ID).join(FoxnicWeb.PCM_CATALOG.ID);

        // 关联仓库
        this.property(AssetMeta.WAREHOUSE_PROP)
                .using(EAMTables.EAM_ASSET.WAREHOUSE_ID).join(EAMTables.EAM_ASSET.ID);

        // 关联使用人
        this.property(AssetMeta.USE_USER_PROP)
                .using(EAMTables.EAM_ASSET.USE_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);

        // 关联管理人员
        this.property(AssetMeta.MANAGER_PROP)
                .using(EAMTables.EAM_ASSET.MANAGER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
            //    .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);

        // 关联制单人
        this.property(AssetMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);


        //关联 使用组织
        this.property(AssetMeta.USE_ORGANIZATION_PROP)
                .using(EAMTables.EAM_ASSET.USE_ORGANIZATION_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

        //关联 所属公司
        this.property(AssetMeta.OWNER_COMPANY_PROP)
                .using(EAMTables.EAM_ASSET.OWN_COMPANY_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

    }


    private void setupRelations() {

    }


    public void setupProperties() {

    }

    private void setupGoods() {

        // 关联品牌
//        this.property(GoodsMeta.BRAND_PROP)
//                .using(EAMTables.EAM_GOODS.BRAND_ID).join(EAMTables.EAM_BRAND.ID);

        // 关联生产厂商
        this.property(GoodsMeta.MANUFACTURER_PROP)
                .using(EAMTables.EAM_GOODS.MANUFACTURER_ID).join(EAMTables.EAM_MANUFACTURER.ID);

        // 关联分类
        this.property(GoodsMeta.CATEGORY_PROP)
                .using(EAMTables.EAM_GOODS.CATEGORY_ID).join(EAMTables.EAM_CATEGORY.ID);

    }

}
