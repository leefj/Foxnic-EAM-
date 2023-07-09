package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.CheckIfCheckEnum;
import com.dt.platform.constants.enums.eam.CheckItemOwnerEnum;
import com.dt.platform.constants.enums.eam.CheckItemTypeEnum;
import com.dt.platform.domain.eam.CheckItem;
import com.dt.platform.domain.eam.InspectionPoint;
import com.dt.platform.domain.eam.InspectionTask;
import com.dt.platform.domain.eam.InspectionTaskPoint;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.eam.page.CheckSelectPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.*;
import com.github.foxnic.generator.config.WriteMode;

public class CheckSelectGtr extends BaseCodeGenerator {


    public CheckSelectGtr() {
        super(EAMTables.EAM_CHECK_SELECT.$TABLE,"728712045951713281");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(CheckItem.class,"checkItem","checkItem","checkItem");
        cfg.getPoClassFile().addSimpleProperty(InspectionTask.class,"inspectionTask","inspectionTask","inspectionTask");
        cfg.getPoClassFile().addSimpleProperty(InspectionPoint.class,"inspectionPoint","inspectionPoint","inspectionPoint");
        cfg.getPoClassFile().addSimpleProperty(InspectionTaskPoint.class,"inspectionTaskPoint","inspectionTaskPoint","inspectionTaskPoint");


        cfg.view().field(EAMTables.EAM_CHECK_SELECT.ITEM_CODE).form().search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_CHECK_SELECT.ITEM_NAME).form().search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_CHECK_SELECT.ITEM_CODE,
                        EAMTables.EAM_CHECK_SELECT.ITEM_NAME
                }
        );

        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().field(EAMTables.EAM_CHECK_SELECT.ITEM_NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_CHECK_SELECT.IF_CHECK).form().validate().required().form().radioBox().enumType(CheckIfCheckEnum.class).defaultIndex(0);

        cfg.view().field(EAMTables.EAM_CHECK_SELECT.TASK_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_CHECK_SELECT.TASK_POINT_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_CHECK_SELECT.POINT_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_CHECK_SELECT.TYPE).table().disable(true);
        cfg.view().field(EAMTables.EAM_CHECK_SELECT.RESULT_META_DATA).table().disable(true);
        cfg.view().field(EAMTables.EAM_CHECK_SELECT.CONFIG).table().disable(true);
        cfg.view().field(EAMTables.EAM_CHECK_SELECT.CONFIG_DEF_VALUE).table().disable(true);

        cfg.view().field(EAMTables.EAM_CHECK_SELECT.ITEM_ID)
                .form().selectBox().queryApi(CheckItemServiceProxy.QUERY_PAGED_LIST+"?status=enable")
                .valueField(CheckItemMeta.ID).textField(CheckItemMeta.NAME)
                .toolbar(false).paging(true).filter(false)
                .fillWith(CheckSelectMeta.CHECK_ITEM).muliti(false);

        cfg.view().field(EAMTables.EAM_CHECK_SELECT.POINT_ID)
                .form().selectBox().queryApi(InspectionPointServiceProxy.QUERY_PAGED_LIST)
                .valueField(InspectionPointMeta.ID).textField(InspectionPointMeta.NAME)
                .toolbar(false).paging(true).filter(false)
                .fillWith(CheckSelectMeta.INSPECTION_POINT).muliti(false);

        cfg.view().field(EAMTables.EAM_CHECK_SELECT.TASK_ID)
                .form().selectBox().queryApi(InspectionTaskServiceProxy.QUERY_PAGED_LIST)
                .valueField(InspectionTaskMeta.ID).textField(InspectionTaskMeta.PLAN_NAME)
                .toolbar(false).paging(true).filter(false)
                .fillWith(CheckSelectMeta.INSPECTION_TASK).muliti(false);

        cfg.view().field(EAMTables.EAM_CHECK_SELECT.TASK_POINT_ID)
                .form().selectBox().queryApi(InspectionTaskPointServiceProxy.QUERY_PAGED_LIST)
                .valueField(InspectionTaskPointMeta.ID).textField(InspectionTaskPointMeta.POINT_NAME)
                .toolbar(false).paging(true).filter(false)
                .fillWith(CheckSelectMeta.INSPECTION_TASK_POINT).muliti(false);


        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_CHECK_SELECT.ITEM_CODE,
                        EAMTables.EAM_CHECK_SELECT.ITEM_NAME,
                        EAMTables.EAM_CHECK_SELECT.IF_CHECK,
                        EAMTables.EAM_CHECK_SELECT.RESULT,
                }
        );
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
        CheckSelectGtr g=new CheckSelectGtr();
        //生成代码
       g.generateCode();

     //   g.removeByBatchId("582429214846746624");
        //移除之前生成的菜单，视情况执行
    // g.generateMenu(CheckSelectServiceProxy.class, CheckSelectPageController.class);
        //生成菜单

    }

}
