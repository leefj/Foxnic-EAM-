package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.eam.WorkOrderStatusEnum;
import com.dt.platform.domain.eam.GoodsStock;
import com.dt.platform.domain.eam.WorkOrder;
import com.dt.platform.eam.page.WorkOrderPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.WorkOrderServiceProxy;
import com.github.foxnic.api.bpm.IntegrateMode;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class WorkOrderGtr extends BaseCodeGenerator {


    public WorkOrderGtr() {
        super(EAMTables.EAM_WORK_ORDER.$TABLE,"592108832759488512");
    }

    public void generateCode() throws Exception {


        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_WORK_ORDER.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_WORK_ORDER.TITLE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_WORK_ORDER.RCD_TIME).search().range();
        cfg.view().field(EAMTables.EAM_WORK_ORDER.RCD_TIME).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_WORK_ORDER.STATUS).form().label("工单状态").selectBox().enumType(WorkOrderStatusEnum.class);
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_WORK_ORDER.STATUS,
                        EAMTables.EAM_WORK_ORDER.TITLE,
                        EAMTables.EAM_WORK_ORDER.RCD_TIME,
                }
        );
        cfg.view().list().disableBatchDelete();
        cfg.view().list().disableSingleDelete();
        cfg.view().field(EAMTables.EAM_WORK_ORDER.RCD_USER_ID).table().fillBy("originator","name");
        cfg.view().field(EAMTables.EAM_WORK_ORDER.RCD_USER_ID).form()
                .button().chooseEmployee(true);
        cfg.view().field(EAMTables.EAM_WORK_ORDER.ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_WORK_ORDER.CREATE_TIME).table().disable(true);
        cfg.view().field(EAMTables.EAM_WORK_ORDER.UPDATE_BY).table().disable(true);
        cfg.view().field(EAMTables.EAM_WORK_ORDER.UPDATE_TIME).table().disable(true);
        cfg.view().field(EAMTables.EAM_WORK_ORDER.FILE_IDS).table().disable(true);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(EAMTables.EAM_WORK_ORDER.CONTENT).form().validate().required().form().textArea().height(120);
        cfg.view().field(EAMTables.EAM_WORK_ORDER.TITLE).form().validate().required();
        cfg.view().field(EAMTables.EAM_WORK_ORDER.FILE_IDS).form().upload().maxFileCount(6).buttonLabel("上传附件");
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().formWindow().width(Config.baseFormWidth_75);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_WORK_ORDER.TITLE,
                        EAMTables.EAM_WORK_ORDER.CONTENT,
                        EAMTables.EAM_WORK_ORDER.CONTACT_INFORMATION,
                        EAMTables.EAM_WORK_ORDER.FILE_IDS
                }
        );
        cfg.view().list().addJsVariable("ROLE","[[${role}]]","role");
        cfg.view().list().operationColumn().addActionButton("查看","processRcd","process-rcd-button");
        cfg.view().list().operationColumn().addActionButton("取消","cancelRcd","cancel-rcd-button");

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
        WorkOrderGtr g=new WorkOrderGtr();
        //生成代码
       g.generateCode();

     //   g.removeByBatchId("582429214846746624");
        //移除之前生成的菜单，视情况执行
     //  g.generateMenu(WorkOrderServiceProxy.class, WorkOrderPageController.class);

        //生成菜单

    }

}
