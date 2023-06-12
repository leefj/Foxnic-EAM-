package com.dt.platform.generator.module.oa;

import com.dt.platform.constants.db.OaTables;
import com.dt.platform.constants.enums.vehicle.VehicleHandleStatusEnum;
import com.dt.platform.constants.enums.vehicle.VehicleRepairStatusEnum;
import com.dt.platform.domain.oa.VehicleApply;
import com.dt.platform.domain.oa.VehicleInfo;
import com.dt.platform.domain.oa.meta.VehicleInfoMeta;
import com.dt.platform.domain.oa.meta.VehicleMaintenanceMeta;
import com.dt.platform.domain.oa.meta.VehicleMaintenanceVOMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.oa.page.VehicleMaintenancePageController;
import com.dt.platform.oa.service.impl.VehicleMSelectItemServiceImpl;
import com.dt.platform.proxy.oa.VehicleInfoServiceProxy;
import com.dt.platform.proxy.oa.VehicleMaintenanceServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class VehicleMaintenanceGtr extends BaseCodeGenerator {


    public VehicleMaintenanceGtr() {
        super(OaTables.OA_VEHICLE_MAINTENANCE.$TABLE,"616256885288337408");
    }

    public void generateCode() throws Exception {


        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(VehicleInfo.class,"vehicleInfo","车辆","车辆");



        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"maintenanceDict","报修类型","报修类型");

        cfg.view().list().disableBatchDelete();
        cfg.view().field(OaTables.OA_VEHICLE_MAINTENANCE.ID).basic().hidden(true);
        cfg.view().field(OaTables.OA_VEHICLE_MAINTENANCE.NAME).search().fuzzySearch();
        cfg.view().field(OaTables.OA_VEHICLE_MAINTENANCE.CONTENT).search().fuzzySearch();
        cfg.view().field(OaTables.OA_VEHICLE_MAINTENANCE.BUSINESS_CODE).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        OaTables.OA_VEHICLE_MAINTENANCE.REPAIR_STATUS,
                        OaTables.OA_VEHICLE_MAINTENANCE.BUSINESS_CODE,
                        OaTables.OA_VEHICLE_MAINTENANCE.REPORT_USER_NAME,
                        OaTables.OA_VEHICLE_MAINTENANCE.CONTENT
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(OaTables.OA_VEHICLE_MAINTENANCE.NAME).form().validate().required();
        cfg.view().field(OaTables.OA_VEHICLE_MAINTENANCE.TYPE).form().validate().required();


        cfg.view().field(OaTables.OA_VEHICLE_MAINTENANCE.ID).table().disable(true);
        cfg.view().field(OaTables.OA_VEHICLE_MAINTENANCE.PROC_ID).table().disable(true);
        cfg.view().field(OaTables.OA_VEHICLE_MAINTENANCE.REPORT_USER_ID).table().disable(true);
        cfg.view().field(OaTables.OA_VEHICLE_MAINTENANCE.SELECTED_CODE).table().disable(true);
        cfg.view().field(OaTables.OA_VEHICLE_MAINTENANCE.CREATE_TIME).table().disable(true);
        cfg.view().field(OaTables.OA_VEHICLE_MAINTENANCE.ORIGINATOR_ID).table().disable(true);
        cfg.view().field(OaTables.OA_VEHICLE_MAINTENANCE.PICTURE_ID).table().disable(true);
        cfg.view().field(OaTables.OA_VEHICLE_MAINTENANCE.STATUS).table().disable(true);
        //前端还在

        cfg.view().field(OaTables.OA_VEHICLE_MAINTENANCE.ID).table().hidden(true);

        cfg.view().field(OaTables.OA_VEHICLE_MAINTENANCE.STATUS).form().
                label("办理状态").selectBox().enumType(VehicleHandleStatusEnum.class);

        cfg.view().field(OaTables.OA_VEHICLE_MAINTENANCE.REPAIR_STATUS).form().
                label("业务状态").selectBox().enumType(VehicleRepairStatusEnum.class);

        cfg.view().field(OaTables.OA_VEHICLE_MAINTENANCE.PLAN_FINISH_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(OaTables.OA_VEHICLE_MAINTENANCE.ACTUAL_FINISH_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(OaTables.OA_VEHICLE_MAINTENANCE.BUSINESS_DATE).form().dateInput().format("yyyy-MM-dd").search().range();


        cfg.view().field(OaTables.OA_VEHICLE_MAINTENANCE.TYPE)
                .basic().label("报修类型")
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=vehicle_maintenance_type")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(VehicleMaintenanceMeta.MAINTENANCE_DICT).muliti(false);


        cfg.view().field(OaTables.OA_VEHICLE_MAINTENANCE.VEHICLE_ID)
                .form().validate().required().form().selectBox().queryApi(VehicleInfoServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(false).toolbar(false)
                .valueField(VehicleInfoMeta.ID).
                textField(VehicleInfoMeta.NAME).
                fillWith(VehicleMaintenanceMeta.VEHICLE_INFO).muliti(false);

        cfg.view().field(OaTables.OA_VEHICLE_MAINTENANCE.CONTENT).form().textArea().height(30);
        cfg.view().field(OaTables.OA_VEHICLE_MAINTENANCE.PICTURE_ID)
                .form().label("图片").upload().buttonLabel("选择图片").maxFileCount(3).displayFileName(false);

        cfg.view().list().disableBatchDelete();

//        cfg.view().list().operationColumn().addActionButton("确认维修","confirmData","confirm-data-button","vehicle_maintenance:confirm");
//        cfg.view().list().operationColumn().addActionButton("结束维修","finishData","finish-data-button","vehicle_maintenance:finish");
//        cfg.view().list().operationColumn().addActionButton("取消","cancelData","cancel-data-button","vehicle_maintenance:cancel");



        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width("98%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_VEHICLE_MAINTENANCE.NAME,
                        OaTables.OA_VEHICLE_MAINTENANCE.TYPE,
                },
                new Object[] {
                        OaTables.OA_VEHICLE_MAINTENANCE.REPORT_USER_NAME,
                        OaTables.OA_VEHICLE_MAINTENANCE.COST,
                },
                new Object[] {
                        OaTables.OA_VEHICLE_MAINTENANCE.PLAN_FINISH_DATE,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_VEHICLE_MAINTENANCE.CONTENT,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_VEHICLE_MAINTENANCE.PICTURE_ID,
                }
        );



//        cfg.service().addRelationSaveAction(VehicleMSelectItemServiceImpl.class, VehicleMaintenanceVOMeta.VEHICLE_INFO_IDS);

   //     cfg.view().form().addPage("车辆列表","vehicleSelectList");

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        VehicleMaintenanceGtr g=new VehicleMaintenanceGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
      //  g.generateMenu(VehicleMaintenanceServiceProxy.class, VehicleMaintenancePageController.class);
    }

}
