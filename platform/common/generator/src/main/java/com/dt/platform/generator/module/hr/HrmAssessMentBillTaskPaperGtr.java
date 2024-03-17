package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.domain.hr.*;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;


public class HrmAssessMentBillTaskPaperGtr extends BaseCodeGenerator {
    public HrmAssessMentBillTaskPaperGtr() {
        super(HrTables.HR_ASSESSMENT_BILL_TASK_PAPER.$TABLE,"666923829754331136");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK_PAPER.ID).basic().hidden(true);


        cfg.getPoClassFile().addListProperty(AssessmentIndicatorValue.class,"assessmentIndicatorValueList","assessmentIndicatorValueList","assessmentIndicatorValueList");

        cfg.getPoClassFile().addSimpleProperty(AssessmentBillTaskDtl.class,"assessmentBillTaskDtl","assessmentBillTaskDtl","assessmentBillTaskDtl");

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"assessee","assessee","assessee");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"assessor","assessor","assessor");

//
//        cfg.getPoClassFile().addSimpleProperty(String.class,"selfScoreValue","selfScoreValue","selfScoreValue");
//        cfg.getPoClassFile().addSimpleProperty(String.class,"sameUserAvgScoreValue","sameUserAvgScoreValue","sameUserAvgScoreValue");
//        cfg.getPoClassFile().addSimpleProperty(String.class,"sameUserNeedCount","sameUserNeedCount","sameUserNeedCount");
//        cfg.getPoClassFile().addSimpleProperty(String.class,"sameUserFinishCount","sameUserFinishCount","sameUserFinishCount");
//        cfg.getPoClassFile().addSimpleProperty(String.class,"leaderScoreValue","leaderScoreValue","sameUserScoreValue");
//        cfg.getPoClassFile().addSimpleProperty(String.class,"secondLeaderScoreValue","secondLeaderScoreValue","secondLeaderScoreValue");





        cfg.view().field(HrTables.HR_CERTIFICATE.NAME).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_ASSESSMENT_BILL_TASK_PAPER.ASSESSEE_ID,
                }
        );


        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK_PAPER.ASSESSEE_ID).table().fillBy("assessee","name");
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK_PAPER.ASSESSEE_ID).form()
                .button().chooseEmployee(true);

        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK_PAPER.ASSESSOR_ID).table().fillBy("assessor","name");
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK_PAPER.ASSESSOR_ID).form()
                .button().chooseEmployee(true);


        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK_PAPER.CONTENT).form().table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK_PAPER.EVALUATE_CONTENT).form().table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK_PAPER.SCORE_VALUE).form().table().disable(true);


        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK_PAPER.ASSESSOR_ID).form().table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK_PAPER.CREATE_TIME).form().table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK_PAPER.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK_PAPER.BILL_TASK_DTL_ID).form().table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK_PAPER.BILL_TASK_ID).form().table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK_PAPER.BILL_ID).form().table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK_PAPER.CONTENT).form().table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK_PAPER.EVALUATE_CONTENT).form().textArea().height(250);

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().list().addJsVariable("BILL_TASK_DTL_ID",   "[[${billTaskDtlId}]]","billTaskDtlId");
        cfg.view().list().addJsVariable("RELATIONSHIP",   "[[${relationship}]]","relationship");
      //  cfg.view().list().addJsVariable("BILL_TASK_DTL_ID",   "[[${billTaskDtlId}]]","billTaskDtlId");
        cfg.view().list().disableBatchDelete();
        cfg.view().search().disable();

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
                .setExtendJsFile(WriteMode.IGNORE);
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        HrmAssessMentBillTaskPaperGtr g=new HrmAssessMentBillTaskPaperGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
     //  g.generateMenu(AssessmentBillTaskPaperServiceProxy.class, AssessmentBillTaskPaperPageController.class);
    }
}
