package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.hr.AssessmentBillTaskStatusEnum;
import com.dt.platform.domain.hr.*;
import com.dt.platform.domain.hr.meta.AssessmentBillTaskMeta;
import com.dt.platform.domain.hr.meta.AssessmentTaskMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.AssessmentBillTaskPageController;
import com.dt.platform.proxy.hr.AssessmentBillTaskServiceProxy;
import com.dt.platform.proxy.hr.AssessmentTaskServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;


public class HrmAssessMentBillTaskGtr extends BaseCodeGenerator {
    public HrmAssessMentBillTaskGtr() {
        super(HrTables.HR_ASSESSMENT_BILL_TASK.$TABLE,"803970075315929088");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(String.class,"sOrgId","sOrgId","sOrgId");

        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK.CREATE_TIME).search().range();
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"assessor","assessor","assessor");
        cfg.getPoClassFile().addSimpleProperty(AssessmentTask.class,"assessmentTask","assessmentTask","assessmentTask");
        cfg.getPoClassFile().addSimpleProperty(AssessmentTask.class,"assessmentDataTask","assessmentDataTask","assessmentDataTask");

        cfg.getPoClassFile().addListProperty(Employee.class,"withLeaderList","withLeaderList","withLeaderList");
        cfg.getPoClassFile().addListProperty(Employee.class,"withSecondLeaderList","withSecondLeaderList","withSecondLeaderList");
        cfg.getPoClassFile().addListProperty(Employee.class,"withSameUserList","withSameUserList","withSameUserList");


        cfg.getPoClassFile().addSimpleProperty(AssessmentBill.class,"assessmentBill","assessmentBill","assessmentBill");
        cfg.getPoClassFile().addSimpleProperty(String.class,"nameStr","nameStr","nameStr");
        cfg.getPoClassFile().addSimpleProperty(String.class,"stimeStr","stimeStr","stimeStr");
        cfg.getPoClassFile().addSimpleProperty(String.class,"etimeStr","etimeStr","etimeStr");
        cfg.getPoClassFile().addSimpleProperty(String.class,"sRole","sRole","sRole");
        cfg.getPoClassFile().addListProperty(AssessmentBillTaskDtl.class,"assessmentBillTaskDtlList","assessmentBillTaskDtlList","assessmentBillTaskDtlList");

        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK.RCD_TIME).form().dateInput().type(DatePickerType.datetime).format("yyyy-MM-dd HH:mm:ss").search().range();
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK.ASSESSOR_ID).table().fillBy("assessor","name");
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK.ASSESSOR_ID).form()
                .button().chooseEmployee(true);

        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_ASSESSMENT_BILL_TASK.ASSESSOR_ID,
                }
        );

        cfg.view().field(AssessmentBillTaskMeta.NAME_STR).table().fillBy("assessmentBill","nameStr");
        cfg.view().field(AssessmentBillTaskMeta.STIME_STR).table().fillBy("assessmentBill","stimeStr");
        cfg.view().field(AssessmentBillTaskMeta.ETIME_STR).table().fillBy("assessmentBill","etimeStr");


        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK.ASSESSOR_ID).table().fillBy("assessor","name");
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK.ASSESSOR_ID).form()
                .button().chooseEmployee(true);

        cfg.view().list().disableBatchDelete();
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(120);


        cfg.view().list().disableBatchDelete();
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK.BILL_ID).form().table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK.NAME).form().table().disable(true);
        cfg.view().field(AssessmentBillTaskMeta.STIME_STR).basic().label("开始时间").form().table().disable(false);
        cfg.view().field(AssessmentBillTaskMeta.ETIME_STR).basic().label("结束时间").form().table().disable(false);
        cfg.view().field(AssessmentBillTaskMeta.NAME_STR).basic().label("名称").form().table().disable(false);

        cfg.view().field(AssessmentBillTaskMeta.STIME_STR).form().dateInput().type(DatePickerType.datetime).format("yyyy-MM-dd HH:mm:ss").search().range();

        cfg.view().field(AssessmentBillTaskMeta.ETIME_STR).form().dateInput().type(DatePickerType.datetime).format("yyyy-MM-dd HH:mm:ss").search().range();


        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK.CREATE_TIME).form().table().disable(true);

        cfg.view().list().addJsVariable("BILL_ID",   "[[${billId}]]","billId");

        cfg.view().list().operationColumn().addActionButton("任务单","taskAction","task-Action");


        cfg.view().list().addJsVariable("ROLE",   "[[${role}]]","role");
        cfg.view().list().addJsVariable("OPER_USER_ID",   "[[${operUserId}]]","operUserId");


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
        HrmAssessMentBillTaskGtr g=new HrmAssessMentBillTaskGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
      //  g.removeByBatchId("818749271795826688");
      //  //生成菜单
      //  g.generateMenu(AssessmentBillTaskServiceProxy.class, AssessmentBillTaskPageController.class);
    }
}
