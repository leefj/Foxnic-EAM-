package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.RepairGroup;
import com.dt.platform.domain.eam.RepairOrder;
import com.dt.platform.domain.eam.meta.RepairGroupMeta;
import com.dt.platform.domain.eam.meta.RepairOrderActMeta;
import com.dt.platform.eam.page.RepairOrderActSpPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.GroupUserServiceProxy;
import com.dt.platform.proxy.eam.RepairGroupServiceProxy;
import com.dt.platform.proxy.eam.RepairOrderActSpServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.meta.PersonMeta;

public class RepairOrderActSPGtr extends BaseCodeGenerator {


    public RepairOrderActSPGtr() {
        super(EAMTables.EAM_REPAIR_ORDER_ACT_SP.$TABLE,"728713069663879169");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());



        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT_SP.ID).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT_SP.SP_NAME).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_REPAIR_ORDER_ACT_SP.SP_NAME,

                }

        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);



//
//        cfg.view().field(EAMTables.EAM_REPAIR_ORDER.REPAIR_STATUS).form()
//                .form().selectBox().enumType(RepairOrderStatusEnum.class);
//
//        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.GROUP_ID)
//                .form().validate().required().form().selectBox().queryApi(RepairGroupServiceProxy.QUERY_LIST)
//                .paging(false).filter(true).toolbar(false)
//                .valueField(RepairGroupMeta.ID).
//                textField(RepairGroupMeta.NAME).
//                fillWith(RepairOrderActMeta.REPAIR_GROUP).muliti(false).defaultIndex(0);
//
//        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.EXECUTOR_ID)
//                .form().selectBox().queryApi(GroupUserServiceProxy.QUERY_EMPLOYEE_PERSON)
//                .paging(false).filter(false).toolbar(false)
//                .valueField("employeeId").
//                textField(PersonMeta.NAME).
//                fillWith(RepairOrderActMeta.EXECUTOR).muliti(false);
//
//        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.NOTES).form().textArea().height(Config.textAreaHeight);



        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_REPAIR_ORDER_ACT_SP.SP_NAME,
                        EAMTables.EAM_REPAIR_ORDER_ACT_SP.SP_CODE,
                        EAMTables.EAM_REPAIR_ORDER_ACT_SP.SP_SN,
                        EAMTables.EAM_REPAIR_ORDER_ACT_SP.SP_NOTES,


                }

        );


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
        RepairOrderActSPGtr g=new RepairOrderActSPGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
      // g.generateMenu(RepairOrderActSpServiceProxy.class, RepairOrderActSpPageController.class);

        //生成菜单

    }

}
