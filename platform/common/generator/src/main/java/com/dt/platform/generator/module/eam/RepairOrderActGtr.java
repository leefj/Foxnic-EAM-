package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.RepairOrderActStatusEnum;
import com.dt.platform.constants.enums.eam.RepairOrderStatusEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.eam.page.RepairOrderActPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.GroupUserServiceProxy;
import com.dt.platform.proxy.eam.RepairCategoryTplServiceProxy;
import com.dt.platform.proxy.eam.RepairGroupServiceProxy;
import com.dt.platform.proxy.eam.RepairOrderActServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.meta.PersonMeta;
import org.github.foxnic.web.proxy.hrm.PersonServiceProxy;

public class RepairOrderActGtr extends BaseCodeGenerator {


    public RepairOrderActGtr() {
        super(EAMTables.EAM_REPAIR_ORDER_ACT.$TABLE,"568078396299415552");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addListProperty(RepairOrderProcess.class,"repairOrderProcess","repairOrderProcess","repairOrderProcess");
        cfg.getPoClassFile().addListProperty(RepairOrderActSp.class,"RepairOrderActSpList","RepairOrderActSpList","RepairOrderActSpList");
        cfg.getPoClassFile().addListProperty(String.class,"idsList","idsList","idsList");
        cfg.getPoClassFile().addSimpleProperty(RepairOrder.class,"order","维修申请","维修申请");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"executor","执行人","执行人");
        cfg.getPoClassFile().addSimpleProperty(RepairGroup.class,"repairGroup","维修班组","维修班组");
        cfg.getPoClassFile().addSimpleProperty(String.class,"status","status","status");
        cfg.getPoClassFile().addListProperty(GoodsStock.class,"goodsStockPartList","goodsStockPartList","备件信息");
        cfg.getPoClassFile().addSimpleProperty(RepairOrderAcceptance.class,"repairOrderAcceptance","repairOrderAcceptance","repairOrderAcceptance");

        cfg.getPoClassFile().addSimpleProperty(RepairCategoryTpl.class,"categoryTpl","报修故障","报修故障");

        cfg.getPoClassFile().addSimpleProperty(Asset.class,"asset","asset","asset");

        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.START_TIME).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.FINISH_TIME).form().dateInput().format("yyyy-MM-dd").search().range();


        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.ORDER_NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.ORDER_BUSINESS_CODE).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{

                        EAMTables.EAM_REPAIR_ORDER_ACT.GROUP_ID,
                        EAMTables.EAM_REPAIR_ORDER_ACT.BUSINESS_CODE,
                        EAMTables.EAM_REPAIR_ORDER_ACT.ORDER_NAME,
                },
                new Object[]{
                        EAMTables.EAM_REPAIR_ORDER_ACT.ORDER_BUSINESS_CODE,
                        EAMTables.EAM_REPAIR_ORDER_ACT.START_TIME,
                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.CAUSE_REASON_CODE)
                .form().validate().required().form().selectBox().queryApi(RepairCategoryTplServiceProxy.QUERY_LIST)
                .paging(false).filter(true).toolbar(false)
                .valueField(RepairCategoryTplMeta.ID).
                textField(RepairCategoryTplMeta.NAME).
                fillWith(RepairOrderActMeta.CATEGORY_TPL).muliti(false);


        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.ORIGINATOR_ID).table().fillBy("originator","name");
//        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.ORIGINATOR_ID).form()
//                .button().chooseEmployee(true);
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.ORIGINATOR_ID).table().disable();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.PICTURE_ID).table().disable();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.NOTES).table().disable();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.ORDER_ID).table().disable();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.SELECTED_CODE).table().disable();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.REPAIR_COST).table().disable();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.WITH_ACCEPTANCE).table().disable();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.OWNER_TYPE).table().disable();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.UPDATE_BY).table().disable();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.ASSET_ID).table().disable();
//
//        cfg.view().field(EAMTables.EAM_REPAIR_ORDER.REPAIR_STATUS).form()
//                .form().selectBox().enumType(RepairOrderStatusEnum.class);

        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.GROUP_ID)
                .form().validate().required().form().selectBox().queryApi(RepairGroupServiceProxy.QUERY_LIST)
                .paging(false).filter(true).toolbar(false)
                .valueField(RepairGroupMeta.ID).
                textField(RepairGroupMeta.NAME).
                fillWith(RepairOrderActMeta.REPAIR_GROUP).muliti(false).defaultIndex(0);

        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.EXECUTOR_ID)
                .form().selectBox().queryApi(GroupUserServiceProxy.QUERY_EMPLOYEE_PERSON)
                .paging(false).filter(false).toolbar(false)
                .valueField("employeeId").
                textField(PersonMeta.NAME).
                fillWith(RepairOrderActMeta.EXECUTOR).muliti(false);

        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.NOTES).form().textArea().height(Config.textAreaHeight);


        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.PICTURE_ID).form().upload().acceptImageType().maxFileCount(6);
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.START_TIME).form().dateInput().type(DatePickerType.datetime);
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.FINISH_TIME).form().dateInput().type(DatePickerType.datetime);

        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.START_TIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss");
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.FINISH_TIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss");
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.REPAIR_COST).form().numberInput().allowNegative(false).scale(2);

//        cfg.view().field(RepairOrderActMeta.ORDER_BUSINESS_CODE).table().label("订单编号").fillBy("order","businessCode");
//        cfg.view().field(RepairOrderActMeta.ORDER_NAME).table().label("订单名称").fillBy("order","name");
//        cfg.view().field(RepairOrderActMeta.ORDER_REPAIR_STATUS).table().label("订单状态").fillBy("order","repairStatus");
//        cfg.view().field(RepairOrderActMeta.ORDER_REPAIR_STATUS).table().disable(true);
         cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(200);
        cfg.view().list().operationColumn().width(300);
        cfg.view().list().disableBatchDelete();
       // cfg.view().list().disableCreateNew();
        cfg.view().list().disableSingleDelete();


//        cfg.view().form().addPage("维修申请","repairOrderApply");
        cfg.view().search().rowsDisplay(1);
        cfg.view().form().addGroup("订单信息",
                new Object[] {
                        EAMTables.EAM_REPAIR_ORDER_ACT.ORDER_NAME,
                },
                new Object[] {
                        EAMTables.EAM_REPAIR_ORDER_ACT.ORDER_BUSINESS_CODE,
                }
        );



        cfg.view().form().addGroup("维修信息",
                new Object[] {
                        EAMTables.EAM_REPAIR_ORDER_ACT.BUSINESS_CODE,
                        EAMTables.EAM_REPAIR_ORDER_ACT.REPAIR_COST,
                        EAMTables.EAM_REPAIR_ORDER_ACT.CAUSE_REASON_CODE
                   //     EAMTables.EAM_REPAIR_ORDER_ACT.WITH_ACCEPTANCE,
                },
                new Object[] {
                        EAMTables.EAM_REPAIR_ORDER_ACT.START_TIME,
                        EAMTables.EAM_REPAIR_ORDER_ACT.FINISH_TIME,

                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_REPAIR_ORDER_ACT.GROUP_ID,
                },
                new Object[] {
                        EAMTables.EAM_REPAIR_ORDER_ACT.EXECUTOR_ID,
                }
        );




        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_REPAIR_ORDER_ACT.PICTURE_ID,
                        EAMTables.EAM_REPAIR_ORDER_ACT.NOTES,
                }
        );

        cfg.view().form().addPage("设备列表","assetSelectList");
        cfg.view().form().addPage("备件列表","deviceSpList");
        cfg.view().form().addPage("timeLineList","工作时间轴","timeLineList");

        cfg.view().list().addJsVariable("REPAIR_STATUS","[[${repairStatus}]]","单据ID");
        cfg.view().form().addJsVariable("ORDER_ID","[[${orderId}]]","工单");

        cfg.view().list().operationColumn().addActionButton("开始维修","start","start-button","eam_repair_order_act:start");
        cfg.view().list().operationColumn().addActionButton("维修","maintenance","maintenance-button","eam_repair_order_act:maintenance");
        cfg.view().list().operationColumn().addActionButton("结束维修","finish","finish-button","eam_repair_order_act:finish");
        cfg.view().list().operationColumn().addActionButton("验收单","acceptance","acceptance-button","eam_repair_order_act:acceptance");
        cfg.view().list().operationColumn().addActionButton("取消 ","cancel","cancel-button","eam_repair_order_act:cancel");
        cfg.view().list().operationColumn().addActionButton(" 维修单据","repairBill","repair-bill");




        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        RepairOrderActGtr g=new RepairOrderActGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
     //  g.generateMenu(RepairOrderActServiceProxy.class, RepairOrderActPageController.class);

        //生成菜单

    }

}
