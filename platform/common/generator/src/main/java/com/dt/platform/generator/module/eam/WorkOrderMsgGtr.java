package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.WorkOrderStatusEnum;
import com.dt.platform.domain.eam.WorkOrderMsg;
import com.dt.platform.eam.page.WorkOrderMsgPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.WorkOrderMsgServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class WorkOrderMsgGtr extends BaseCodeGenerator {


    public WorkOrderMsgGtr() {
        super(EAMTables.EAM_WORK_ORDER_MSG.$TABLE,"592108832759488512");
    }

    public void generateCode() throws Exception {


        cfg.getPoClassFile().addSimpleProperty(Employee.class,"user","user","user");
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_WORK_ORDER_MSG.ID).basic().hidden(true);

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_WORK_ORDER_MSG.CONTENT,
                }
        );
        cfg.view().list().disableBatchDelete();
        cfg.view().list().disableSingleDelete();
        cfg.view().field(EAMTables.EAM_WORK_ORDER_MSG.USER_ID).table().fillBy("user","name");
        cfg.view().field(EAMTables.EAM_WORK_ORDER_MSG.USER_ID).form()
                .button().chooseEmployee(true);
        cfg.view().field(EAMTables.EAM_WORK_ORDER_MSG.ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_WORK_ORDER_MSG.CREATE_TIME).table().disable(true);
        cfg.view().field(EAMTables.EAM_WORK_ORDER_MSG.UPDATE_BY).table().disable(true);
        cfg.view().field(EAMTables.EAM_WORK_ORDER_MSG.UPDATE_TIME).table().disable(true);
        cfg.view().field(EAMTables.EAM_WORK_ORDER_MSG.FILE_IDS).table().disable(true);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(EAMTables.EAM_WORK_ORDER_MSG.CONTENT).form().validate().required().form().textArea().height(120);
        cfg.view().field(EAMTables.EAM_WORK_ORDER_MSG.STATUS).form().validate().required().form().label("状态").radioBox().enumType(WorkOrderStatusEnum.class).defaultIndex(0);
        cfg.view().field(EAMTables.EAM_WORK_ORDER_MSG.FILE_IDS).form().upload().maxFileCount(6).buttonLabel("上传附件");
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().formWindow().width(Config.baseFormWidth_75);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_WORK_ORDER_MSG.STATUS,
                        EAMTables.EAM_WORK_ORDER_MSG.CONTENT,
                        EAMTables.EAM_WORK_ORDER_MSG.FILE_IDS
                }
        );


        cfg.view().form().addJsVariable("ROLE","[[${role}]]","role");
        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        WorkOrderMsgGtr g=new WorkOrderMsgGtr();
        //生成代码
       g.generateCode();

     //   g.removeByBatchId("582429214846746624");
        //移除之前生成的菜单，视情况执行
      // g.generateMenu(WorkOrderMsgServiceProxy.class, WorkOrderMsgPageController.class);

        //生成菜单

    }

}
