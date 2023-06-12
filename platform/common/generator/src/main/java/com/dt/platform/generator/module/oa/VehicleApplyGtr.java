package com.dt.platform.generator.module.oa;

import com.dt.platform.constants.db.OaTables;
import com.dt.platform.constants.enums.oa.VehicleApplyReturnEnum;
import com.dt.platform.constants.enums.oa.VehicleHandleStatusEnum;
import com.dt.platform.domain.oa.VehicleInfo;
import com.dt.platform.domain.oa.meta.VehicleApplyMeta;
import com.dt.platform.domain.oa.meta.VehicleApplyVOMeta;
import com.dt.platform.domain.oa.meta.VehicleInfoMeta;
import com.dt.platform.domain.oa.meta.VehicleMaintenanceMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.oa.service.impl.VehicleASelectItemServiceImpl;
import com.dt.platform.proxy.oa.VehicleInfoServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;

public class VehicleApplyGtr extends BaseCodeGenerator {


    public VehicleApplyGtr() {
        super(OaTables.OA_VEHICLE_APPLY.$TABLE,"616256885288337408");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(OaTables.OA_VEHICLE_APPLY.ID).basic().hidden(true);

//        cfg.getPoClassFile().addListProperty(VehicleInfo.class,"vehicleInfoList","车辆","车辆");
//        cfg.getPoClassFile().addListProperty(String.class,"vehicleInfoIds","车辆列表","车辆列表");
        cfg.getPoClassFile().addSimpleProperty(VehicleInfo.class,"vehicleInfo","车辆","车辆");

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"receiver","领用人","领用人");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"useOrganization","使用公司/部门","使用公司/部门");


        cfg.view().field(OaTables.OA_VEHICLE_APPLY.NAME).search().fuzzySearch();
        cfg.view().field(OaTables.OA_VEHICLE_APPLY.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(OaTables.OA_VEHICLE_APPLY.DRIVER).search().fuzzySearch();
        cfg.view().field(OaTables.OA_VEHICLE_APPLY.NOTES).search().fuzzySearch();
        cfg.view().field(OaTables.OA_VEHICLE_APPLY.CONTENT).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        OaTables.OA_VEHICLE_APPLY.STATUS,
                        OaTables.OA_VEHICLE_APPLY.BUSINESS_CODE,
                        OaTables.OA_VEHICLE_APPLY.DRIVER,
                        OaTables.OA_VEHICLE_APPLY.RECEIVER_ID
                },
                new Object[]{
                        OaTables.OA_VEHICLE_APPLY.COLLECTION_DATE
//                        VehicleTables.VEHICLE_APPLY.PLAN_RETURN_DATE
                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(OaTables.OA_VEHICLE_APPLY.NAME).form().validate().required();
        cfg.view().field(OaTables.OA_VEHICLE_APPLY.RECEIVER_ID).form().validate().required();
        cfg.view().field(OaTables.OA_VEHICLE_APPLY.COLLECTION_DATE).form().validate().required();

        cfg.view().field(OaTables.OA_VEHICLE_APPLY.SELECTED_CODE).table().disable(true);

        cfg.view().field(OaTables.OA_VEHICLE_APPLY.CREATE_TIME).table().disable(true);
        cfg.view().field(OaTables.OA_VEHICLE_APPLY.ORIGINATOR_ID).table().disable(true);
        cfg.view().field(OaTables.OA_VEHICLE_APPLY.ATTACH).table().disable(true);
        cfg.view().field(OaTables.OA_VEHICLE_APPLY.CONTENT).table().disable(true);


        cfg.view().field(OaTables.OA_VEHICLE_APPLY.COLLECTION_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(OaTables.OA_VEHICLE_APPLY.PLAN_RETURN_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(OaTables.OA_VEHICLE_APPLY.ACT_RETURN_DATE).form().dateInput().format("yyyy-MM-dd").search().range();


        cfg.view().field(OaTables.OA_VEHICLE_APPLY.IF_RETURN).form().
                label("是否归还").selectBox().enumType(VehicleApplyReturnEnum.class);


        cfg.view().field(OaTables.OA_VEHICLE_APPLY.STATUS).form().
                label("办理状态").selectBox().enumType(VehicleHandleStatusEnum.class);

        cfg.view().field(OaTables.OA_VEHICLE_APPLY.CONTENT).form().textArea().height(30);
        cfg.view().field(OaTables.OA_VEHICLE_APPLY.NOTES).form().textArea().height(30);

        cfg.view().field(OaTables.OA_VEHICLE_APPLY.ORG_ID)
                .form().button().chooseOrganization(true);
        cfg.view().field(OaTables.OA_VEHICLE_APPLY.ORG_ID).table().fillBy("useOrganization","fullName");


        cfg.view().field(OaTables.OA_VEHICLE_APPLY.RECEIVER_ID).table().fillBy("receiver","name");
        cfg.view().field(OaTables.OA_VEHICLE_APPLY.RECEIVER_ID).form()
                .button().chooseEmployee(true);

        cfg.view().field(OaTables.OA_VEHICLE_APPLY.ATTACH)
                .form().label("附件").upload().buttonLabel("选择附件").maxFileCount(3).displayFileName(false);


        cfg.view().field(OaTables.OA_VEHICLE_APPLY.VEHICLE_ID)
                .form().validate().required().form().selectBox().queryApi(VehicleInfoServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(false).toolbar(false)
                .valueField(VehicleInfoMeta.ID).
                textField(VehicleInfoMeta.NAME).
                fillWith(VehicleApplyMeta.VEHICLE_INFO).muliti(false);

        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width("98%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_VEHICLE_APPLY.NAME,
                        OaTables.OA_VEHICLE_APPLY.DRIVER,
                        OaTables.OA_VEHICLE_APPLY.CONTACT,
                },
                new Object[] {
                        OaTables.OA_VEHICLE_APPLY.ORG_ID,
                        OaTables.OA_VEHICLE_APPLY.RECEIVER_ID,
                },

                new Object[] {
                        OaTables.OA_VEHICLE_APPLY.COLLECTION_DATE,
                        OaTables.OA_VEHICLE_APPLY.PLAN_RETURN_DATE,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_VEHICLE_APPLY.CONTENT,

                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_VEHICLE_APPLY.NOTES,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_VEHICLE_APPLY.ATTACH,

                }
        );



        cfg.view().list().disableBatchDelete();
//        cfg.view().form().addPage("车辆列表","vehicleSelectList");
//        cfg.view().list().operationColumn().addActionButton("确认","confirmData","confirm-data-button","vehicle_apply:confirm");
//        cfg.view().list().operationColumn().addActionButton("取消","cancelData","cancel-data-button","vehicle_apply:cancel");
//        cfg.view().list().operationColumn().addActionButton("归还","returnData","return-data-button","vehicle_apply:return");


        //Info中间数据  ，Apply为A
     //   cfg.service().addRelationSaveAction(VehicleASelectItemServiceImpl.class, VehicleApplyVOMeta.VEHICLE_INFO_IDS);

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
        VehicleApplyGtr g=new VehicleApplyGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
      // g.removeByBatchId("471622036347682816");
        //生成菜单
       // g.generateMenu(VehicleApplyServiceProxy.class, VehicleApplyPageController.class);
    }

}
