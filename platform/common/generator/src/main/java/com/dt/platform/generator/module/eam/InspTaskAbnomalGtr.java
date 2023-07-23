package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.InspectionMethodEnum;
import com.dt.platform.constants.enums.eam.InspectionTaskAbnormalStatusEnum;
import com.dt.platform.constants.enums.eam.InspectionTaskStatusEnum;
import com.dt.platform.constants.enums.eam.InspectionTimeoutHandleEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.InspectionGroupMeta;
import com.dt.platform.domain.eam.meta.InspectionTaskAbnormalMeta;
import com.dt.platform.domain.eam.meta.InspectionTaskMeta;
import com.dt.platform.eam.page.InspectionTaskAbnormalPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.InspectionGroupServiceProxy;
import com.dt.platform.proxy.eam.InspectionTaskAbnormalServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;

public class InspTaskAbnomalGtr extends BaseCodeGenerator {


    public InspTaskAbnomalGtr() {
        super(EAMTables.EAM_INSPECTION_TASK_ABNORMAL.$TABLE,"568078307707326464");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(InspectionTask.class,"task","task","task");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"operUser","operUser","operUser");


        cfg.getPoClassFile().addSimpleProperty(String.class,"taskCode","taskCode","taskCode");
        cfg.getPoClassFile().addSimpleProperty(String.class,"taskCreateTime","taskCreateTime","taskCreateTime");



        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_ABNORMAL.TASK_ABNORMAL_INFO).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_ABNORMAL.CREATE_TIME).search().range();
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_ABNORMAL.CONTENT).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_ABNORMAL.CREATE_TIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").search().range();

        cfg.view().field(InspectionTaskAbnormalMeta.TASK_CODE).table().disable(false);
        cfg.view().field(InspectionTaskAbnormalMeta.TASK_CODE).basic().label("任务单据").table().fillBy("task","taskCode");

        cfg.view().field(InspectionTaskAbnormalMeta.TASK_CREATE_TIME).table().disable(false);
        cfg.view().field(InspectionTaskAbnormalMeta.TASK_CREATE_TIME).basic().label("任务创建时间").table().fillBy("task","createTime");

        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_ABNORMAL.OPER_ID).table().fillBy("operUser","name");
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_INSPECTION_TASK_ABNORMAL.STATUS,
                        EAMTables.EAM_INSPECTION_TASK_ABNORMAL.TASK_ABNORMAL_INFO,
                        EAMTables.EAM_INSPECTION_TASK_ABNORMAL.CONTENT,
                },
                new Object[]{
                        EAMTables.EAM_INSPECTION_TASK_ABNORMAL.CREATE_TIME,
                }

        );

        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_ABNORMAL.OPER_ID).table().fillBy("operUser","name");

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_ABNORMAL.ID).table().disable(true);

        cfg.view().list().disableBatchDelete();

        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_ABNORMAL.STATUS).form().validate().
                required().form().radioBox().enumType(InspectionTaskAbnormalStatusEnum.class).defaultIndex(0);


        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_ABNORMAL.TASK_ID)
                .form().readOnly().form().selectBox().
                queryApi(InspectionGroupServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(InspectionTaskMeta.ID).textField(InspectionTaskMeta.PLAN_NAME)
                .fillWith(InspectionTaskAbnormalMeta.TASK).muliti(false);

        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_ABNORMAL.CONTENT).form().textArea().height(120);

        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_ABNORMAL.NOTES).form().textArea().height(120);

        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(85);

        cfg.view().form().addGroup("任务信息",
                new Object[] {
                        EAMTables.EAM_INSPECTION_TASK_ABNORMAL.TASK_ID,
                        EAMTables.EAM_INSPECTION_TASK_ABNORMAL.TASK_ABNORMAL_INFO,
                }
        );

        cfg.view().form().addGroup("处理记录",
                new Object[] {
                        EAMTables.EAM_INSPECTION_TASK_ABNORMAL.STATUS,
                        EAMTables.EAM_INSPECTION_TASK_ABNORMAL.CONTENT,
                        EAMTables.EAM_INSPECTION_TASK_ABNORMAL.NOTES,
                }
        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
         //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        InspTaskAbnomalGtr g=new InspTaskAbnomalGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
    //   g.generateMenu(InspectionTaskAbnormalServiceProxy.class, InspectionTaskAbnormalPageController.class);
        //生成菜单

    }


}
