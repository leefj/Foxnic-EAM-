package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.common.YesNoEnum;
import com.dt.platform.constants.enums.hr.AssessmentBillStatusEnum;
import com.dt.platform.domain.hr.AssessmentBillTask;
import com.dt.platform.domain.hr.AssessmentTask;
import com.dt.platform.domain.hr.meta.AssessmentBillMeta;
import com.dt.platform.domain.hr.meta.AssessmentBillTaskMeta;
import com.dt.platform.domain.hr.meta.AssessmentTaskMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.hr.AssessmentTaskServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;


public class HrmAssessMentBillGtr extends BaseCodeGenerator {
    public HrmAssessMentBillGtr() {
        super(HrTables.HR_ASSESSMENT_BILL.$TABLE,"803970075315929088");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());



        cfg.view().field(HrTables.HR_ASSESSMENT_BILL.ID).basic().hidden(true);

        cfg.view().field(HrTables.HR_ASSESSMENT_BILL.CREATE_TIME).search().range();
        cfg.getPoClassFile().addSimpleProperty(AssessmentTask.class,"assessmentTask","assessmentTask","assessmentTask");
        cfg.getPoClassFile().addSimpleProperty(AssessmentTask.class,"assessmentDataTask","assessmentDataTask","assessmentDataTask");

        cfg.view().field(HrTables.HR_ASSESSMENT_BILL.TASK_NAME).search().fuzzySearch();
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL.STIME).form().dateInput().type(DatePickerType.datetime).format("yyyy-MM-dd HH:mm:ss").search().range();
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL.ETIME).form().dateInput().type(DatePickerType.datetime).format("yyyy-MM-dd HH:mm:ss").search().range();

        cfg.getPoClassFile().addListProperty(AssessmentBillTask.class,"assessmentBillTaskList","assessmentBillTaskList","assessmentBillTaskList");



        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_ASSESSMENT_BILL.TASK_ID,
                        HrTables.HR_ASSESSMENT_BILL.STATUS,
                        HrTables.HR_ASSESSMENT_BILL.TASK_NAME,
                }
        );

        cfg.view().field(HrTables.HR_ASSESSMENT_BILL.TASK_ID)
                .form().selectBox().queryApi(AssessmentTaskServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(AssessmentTaskMeta.ID).
                textField(AssessmentTaskMeta.NAME).
                fillWith(AssessmentBillMeta.ASSESSMENT_TASK).muliti(false);

        cfg.view().field(HrTables.HR_ASSESSMENT_BILL.TASK_DATA_ID)
                .form().selectBox().queryApi(AssessmentTaskServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(AssessmentTaskMeta.ID).
                textField(AssessmentTaskMeta.NAME).
                fillWith(AssessmentBillMeta.ASSESSMENT_DATA_TASK).muliti(false);

        cfg.view().list().disableBatchDelete();
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(HrTables.HR_ASSESSMENT_BILL.TASK_DATA_ID).form().table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL.UPDATE_BY).form().table().disable(true);

        cfg.view().list().disableBatchDelete();
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL.UPDATE_BY).form().table().disable(true);

        cfg.view().field(HrTables.HR_ASSESSMENT_BILL.STATUS).form().radioBox().enumType(AssessmentBillStatusEnum.class);

        cfg.view().field(HrTables.HR_ASSESSMENT_BILL.NOTES).form().form().textArea().height(80);
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL.TASK_NAME).form().validate().required();
        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(150);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_ASSESSMENT_BILL.TASK_NAME,
                        HrTables.HR_ASSESSMENT_BILL.STATUS,
                        HrTables.HR_ASSESSMENT_BILL.IS_SHOW,
                },
                new Object[] {
                        HrTables.HR_ASSESSMENT_BILL.STIME,
                        HrTables.HR_ASSESSMENT_BILL.ETIME,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_ASSESSMENT_BILL.NOTES,
                }

        );

        cfg.view().field(HrTables.HR_ASSESSMENT_BILL.IS_SHOW).form().validate().required().form().radioBox().enumType(YesNoEnum.class).defaultIndex(1);


        cfg.view().list().addToolButton("新建任务","createBillTask","create-bill-task");
        cfg.view().list().operationColumn().addActionButton("考核明细","personData","person-data");
        cfg.view().list().operationColumn().addActionButton("评分人员","pfrData","pfr-data");
        cfg.view().list().operationColumn().addActionButton("取消","BillTaskCancel","bill-task-cancel");
        cfg.view().list().operationColumn().addActionButton("复制","BillTaskCopy","bill-task-copy");
        cfg.view().list().addJsVariable("TASK_ID",   "[[${taskId}]]","taskId");


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
        HrmAssessMentBillGtr g=new HrmAssessMentBillGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
       // g.generateMenu(AssessmentBillServiceProxy.class, AssessmentBillPageController.class);
    }
}
