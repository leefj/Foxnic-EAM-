package com.dt.platform.generator.module.oa;

import com.dt.platform.constants.db.OaTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.oa.NoticeIfTopEnum;
import com.dt.platform.constants.enums.oa.NoticeTypeEnum;
import com.dt.platform.domain.oa.WorkRpt;
import com.dt.platform.generator.config.Config;
import com.dt.platform.oa.page.WorkRptPageController;
import com.dt.platform.proxy.oa.WorkRptServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;

public class WorkRptGtr extends BaseCodeGenerator {


    public WorkRptGtr() {
        super(OaTables.OA_WORK_RPT.$TABLE,"724920223844532224");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"reportUser","reportUser","reportUser");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"receiver","receiver","receiver");

        cfg.view().field(OaTables.OA_WORK_RPT.ID).basic().hidden(true);
        cfg.view().field(OaTables.OA_WORK_RPT.F_TIME).search().range();




        cfg.view().search().inputLayout(
                new Object[]{
                        OaTables.OA_WORK_RPT.F_TIME,

                }
        );

        cfg.view().field(OaTables.OA_WORK_RPT.USER_ID).table().hidden(true);
        cfg.view().field(OaTables.OA_WORK_RPT.RECEIVER_ID).table().disable(true);

        cfg.view().field(OaTables.OA_WORK_RPT.USER_ID).table().fillBy("reportUser","name");
        cfg.view().field(OaTables.OA_WORK_RPT.USER_ID).form()
                .button().chooseEmployee(true);

        cfg.view().field(OaTables.OA_WORK_RPT.RECEIVER_ID).table().fillBy("receiver","name");
        cfg.view().field(OaTables.OA_WORK_RPT.RECEIVER_ID).form()
                .button().chooseEmployee(true);


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().list().disableBatchDelete();
        cfg.view().field(OaTables.OA_WORK_RPT.FILE_ID).table().disable(true);

        cfg.view().field(OaTables.OA_WORK_RPT.CONTENT).form().validate().required().form().textArea().height(150);
        cfg.view().field(OaTables.OA_WORK_RPT.NEXT_CONTENT).form().validate().required().form().textArea().height(150);
        cfg.view().field(OaTables.OA_WORK_RPT.FILE_ID)
                .form().label("附件").upload().buttonLabel("选择附件").maxFileCount(1).displayFileName(false);

        cfg.view().field(OaTables.OA_WORK_RPT.F_TIME).form().validate().required().form().dateInput().type(DatePickerType.date).format("yyyy-MM-dd");
        cfg.view().field(OaTables.OA_WORK_RPT.T_TIME).form().validate().required().form().dateInput().type(DatePickerType.date).format("yyyy-MM-dd");


        cfg.view().formWindow().bottomSpace(150);
        cfg.view().formWindow().width(Config.baseFormWidth);

        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_WORK_RPT.F_TIME,
                },
                new Object[] {
                        OaTables.OA_WORK_RPT.T_TIME,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_WORK_RPT.CONTENT,
                        OaTables.OA_WORK_RPT.NEXT_CONTENT,
                        OaTables.OA_WORK_RPT.OTHER,
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
        //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        WorkRptGtr g=new WorkRptGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
     //  g.generateMenu(WorkRptServiceProxy.class, WorkRptPageController.class);
    }

}
