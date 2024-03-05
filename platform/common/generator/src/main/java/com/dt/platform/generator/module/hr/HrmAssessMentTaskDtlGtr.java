package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.domain.hr.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.AssessmentTaskDtlPageController;
import com.dt.platform.hr.page.AssessmentTaskPageController;
import com.dt.platform.proxy.hr.AssessmentTaskDtlServiceProxy;
import com.dt.platform.proxy.hr.AssessmentTaskServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Person;


public class HrmAssessMentTaskDtlGtr extends BaseCodeGenerator {
    public HrmAssessMentTaskDtlGtr() {
        super(HrTables.HR_ASSESSMENT_TASK_DTL.$TABLE,"803970075315929088");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(AssessmentTask.class,"assessmentTask","assessmentTask","assessmentTask");
        cfg.getPoClassFile().addSimpleProperty(AssessmentBill.class,"assessmentBill","assessmentBill","assessmentBill");



        cfg.getPoClassFile().addListProperty(AssessmentIndicator.class,"assessmentIndicatorList","assessmentIndicatorList","assessmentIndicator");
        cfg.getPoClassFile().addSimpleProperty(String.class,"selectedCode","selectedCode","selectedCode");



        cfg.getPoClassFile().addSimpleProperty(Person.class,"assesseeUser","assesseeUser","assesseeUser");
        cfg.getPoClassFile().addSimpleProperty(Person.class,"assessorUser","assessorUser","assessorUser");




        cfg.view().field(HrTables.HR_ASSESSMENT_TASK_DTL.ASSESSOR_ID).table().fillBy("assessorUser","name");
        cfg.view().field(HrTables.HR_ASSESSMENT_TASK_DTL.ASSESSOR_ID).form()
                .button().chooseEmployee(true);

        cfg.view().field(HrTables.HR_ASSESSMENT_TASK_DTL.ASSESSEE_ID).table().fillBy("assesseeUser","name");
        cfg.view().field(HrTables.HR_ASSESSMENT_TASK_DTL.ASSESSEE_ID).form()
                .button().chooseEmployee(true);




        cfg.view().field(HrTables.HR_ASSESSMENT_TASK_DTL.ID).basic().hidden(true);

        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_ASSESSMENT_TASK_DTL.BILL_ID,
                        HrTables.HR_ASSESSMENT_TASK_DTL.ASSESSEE_ID,
                        HrTables.HR_ASSESSMENT_TASK_DTL.ASSESSOR_ID,
                        HrTables.HR_ASSESSMENT_TASK_DTL.RCD_TIME,
                }
        );
        cfg.view().list().disableBatchDelete();
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(80);


        cfg.view().field(HrTables.HR_ASSESSMENT_TASK_DTL.EVALUATE_CONTENT).form().textArea().height(250);

        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_ASSESSMENT_TASK_DTL.TASK_ID,

                },
                new Object[] {
                        HrTables.HR_ASSESSMENT_TASK_DTL.BILL_ID,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {

                        HrTables.HR_ASSESSMENT_TASK_DTL.ASSESSEE_ID,
                },
                new Object[] {
                        HrTables.HR_ASSESSMENT_TASK_DTL.ASSESSOR_ID,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_ASSESSMENT_TASK_DTL.SCORE_VALUE,
                        HrTables.HR_ASSESSMENT_TASK_DTL.EVALUATE_CONTENT,
                }
        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE);
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        HrmAssessMentTaskDtlGtr g=new HrmAssessMentTaskDtlGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
       // g.generateMenu(AssessmentTaskDtlServiceProxy.class, AssessmentTaskDtlPageController.class);
    }
}
