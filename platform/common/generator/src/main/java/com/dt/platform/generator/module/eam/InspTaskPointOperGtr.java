package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.InspectionTaskPointStatusEnum;
import com.dt.platform.domain.eam.InspectionProcessAction;
import com.dt.platform.domain.eam.InspectionTaskPointOper;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.eam.page.InspectionTaskPointOperPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.InspectionProcessActionServiceProxy;
import com.dt.platform.proxy.eam.InspectionTaskPointOperServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class InspTaskPointOperGtr extends BaseCodeGenerator {


    public InspTaskPointOperGtr() {
        super(EAMTables.EAM_INSPECTION_TASK_POINT_OPER.$TABLE,BASIC_INSP);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT_OPER.ID).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT_OPER.NOTES).search().fuzzySearch();
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"inspector","巡检人","巡检人");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"operUser","操作人","操作人");
        cfg.getPoClassFile().addSimpleProperty(InspectionProcessAction.class,"inspectionProcessAction","inspectionProcessAction","inspectionProcessAction");

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_INSPECTION_TASK_POINT_OPER.NOTES,
                }
        );
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
         cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(80);

        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT_OPER.UPDATE_BY).table().disable(true);
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT_OPER.TASK_ID).table().disable(true);



        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT_OPER.POINT_STATUS).form()
                .radioBox().enumType(InspectionTaskPointStatusEnum.class).defaultIndex(0);

        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT_OPER.INSPECTOR_ID).table().fillBy("inspector","name");
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT_OPER.INSPECTOR_ID).form()
                .button().chooseEmployee(true);

        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT_OPER.OPER_USER_ID).table().fillBy("operUser","name");
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT_OPER.OPER_USER_ID).form()
                .button().chooseEmployee(true);


        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT_OPER.IS_POINT_STATUS).form().validate().required().form()
                .radioBox().enumType(StatusEnableEnum.class).defaultIndex(1);

        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT_OPER.IS_ACTION_LABEL).form().validate().required().form()
                .radioBox().enumType(StatusEnableEnum.class).defaultIndex(1);


        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT_OPER.IS_INSPECTOR_ID).form().validate().required().form()
                .radioBox().enumType(StatusEnableEnum.class).defaultIndex(1);


        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT_OPER.IS_CONTENT).form().validate().required().form()
                .radioBox().enumType(StatusEnableEnum.class).defaultIndex(1);

        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT_OPER.ACTION_LABEL)
                .form().selectBox().queryApi(InspectionProcessActionServiceProxy.QUERY_LIST)
                .paging(false).filter(true).toolbar(false)
                .valueField(InspectionProcessActionMeta.CODE).
                textField(InspectionProcessActionMeta.NAME).
                fillWith(InspectionTaskPointOperMeta.INSPECTION_PROCESS_ACTION).muliti(false);


        cfg.view().list().disableBatchDelete();
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_INSPECTION_TASK_POINT_OPER.IS_POINT_STATUS,
                        EAMTables.EAM_INSPECTION_TASK_POINT_OPER.IS_ACTION_LABEL,
                        EAMTables.EAM_INSPECTION_TASK_POINT_OPER.IS_INSPECTOR_ID,
                        EAMTables.EAM_INSPECTION_TASK_POINT_OPER.IS_CONTENT,
                },
                new Object[] {
                        EAMTables.EAM_INSPECTION_TASK_POINT_OPER.POINT_STATUS,
                        EAMTables.EAM_INSPECTION_TASK_POINT_OPER.ACTION_LABEL,
                        EAMTables.EAM_INSPECTION_TASK_POINT_OPER.INSPECTOR_ID,
                        EAMTables.EAM_INSPECTION_TASK_POINT_OPER.CONTENT,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_INSPECTION_TASK_POINT_OPER.NOTES,
                }
        );

        cfg.view().list().addJsVariable("TASK_ID","[[${taskId}]]","taskId");
        cfg.view().form().addJsVariable("TASK_ID","[[${taskId}]]","taskId");

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
        InspTaskPointOperGtr g=new InspTaskPointOperGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
     //  g.generateMenu(InspectionTaskPointOperServiceProxy.class, InspectionTaskPointOperPageController.class);

        //生成菜单

    }

}
