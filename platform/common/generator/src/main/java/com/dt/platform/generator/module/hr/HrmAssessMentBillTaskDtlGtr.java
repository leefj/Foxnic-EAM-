package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.hr.AssessmentBillTaskDtlRelationshipEnum;
import com.dt.platform.constants.enums.hr.AssessmentBillTaskDtlStatusEnum;
import com.dt.platform.domain.hr.*;
import com.dt.platform.domain.hr.meta.AssessmentBillTaskDtlMeta;
import com.dt.platform.domain.hr.meta.AssessmentBillTaskMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.AssessmentBillTaskDtlPageController;
import com.dt.platform.proxy.hr.AssessmentBillTaskDtlServiceProxy;
import com.dt.platform.proxy.hr.AssessmentBillTaskServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;


public class HrmAssessMentBillTaskDtlGtr extends BaseCodeGenerator {
    public HrmAssessMentBillTaskDtlGtr() {
        super(HrTables.HR_ASSESSMENT_BILL_TASK_DTL.$TABLE,"803970075315929088");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());



        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK_DTL.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK_DTL.CREATE_TIME).search().range();
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"assessor","assessor","assessor");


        cfg.getPoClassFile().addSimpleProperty(AssessmentBill.class,"assessmentBill","assessmentBill","assessmentBill");
        cfg.getPoClassFile().addSimpleProperty(AssessmentBillTask.class,"AssessmentBillTask","AssessmentBillTask","AssessmentBillTask");
        cfg.getPoClassFile().addSimpleProperty(String.class,"assesseeStr","assesseeStr","assesseeStr");

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"withSelfUser","withSelfUser","withSelfUser");
        cfg.getPoClassFile().addListProperty(Employee.class,"withLeaderList","withLeaderList","withLeaderList");
        cfg.getPoClassFile().addListProperty(Employee.class,"withSecondLeaderList","withSecondLeaderList","withSecondLeaderList");
        cfg.getPoClassFile().addListProperty(Employee.class,"withSameUserList","withSameUserList","withSameUserList");


        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_ASSESSMENT_BILL_TASK_DTL.STATUS,
                }
        );

        cfg.view().list().disableBatchDelete();
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(120);


        cfg.view().list().disableBatchDelete();
        cfg.view().field(AssessmentBillTaskDtlMeta.ASSESSEE_STR).basic().label("被评人").table().disable(false);
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK_DTL.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK_DTL.CREATE_TIME).form().table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK_DTL.STATUS).form().radioBox().enumType(AssessmentBillTaskDtlStatusEnum.class);
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK_DTL.RELATIONSHIP).form().radioBox().enumType(AssessmentBillTaskDtlRelationshipEnum.class);
        cfg.view().list().operationColumn().addActionButton("评分","assessment","assessment-dtl");
        cfg.view().list().addJsVariable("BILL_TASK_ID",   "[[${billTaskId}]]","BILL_TASK_ID");
        cfg.view().list().addJsVariable("ROLE",   "[[${role}]]","role");

        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK_DTL.CREATE_TIME).form().table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK_DTL.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK_DTL.BILL_TASK_ID).form().table().disable(true);

        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_TASK_DTL.BILL_TASK_ID)
                .form().selectBox().queryApi(AssessmentBillTaskServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(AssessmentBillTaskMeta.ID).
                textField(AssessmentBillTaskMeta.NAME).
                fillWith(AssessmentBillTaskDtlMeta.ASSESSMENT_BILL_TASK).muliti(false);


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
        HrmAssessMentBillTaskDtlGtr g=new HrmAssessMentBillTaskDtlGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
      //  g.removeByBatchId("818749271795826688");
      //  //生成菜单
        //g.generateMenu(AssessmentBillTaskDtlServiceProxy.class, AssessmentBillTaskDtlPageController.class);
    }
}
