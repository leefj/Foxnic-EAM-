package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.common.StatusSuccessFailedEnum;
import com.dt.platform.domain.hr.AssessmentBillTask;
import com.dt.platform.domain.hr.AssessmentTask;
import com.dt.platform.domain.hr.meta.AssessmentBillUserMapMeta;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;


public class HrmAssessMentBillUserMapGtr extends BaseCodeGenerator {
    public HrmAssessMentBillUserMapGtr() {
        super(HrTables.HR_ASSESSMENT_BILL_USER_MAP.$TABLE,"803970075315929088");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_USER_MAP.ID).basic().hidden(true);

        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_USER_MAP.CREATE_TIME).search().range();
        cfg.getPoClassFile().addSimpleProperty(AssessmentTask.class,"assessmentTask","assessmentTask","assessmentTask");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"assesseeUser","assesseeUser","assesseeUser");

        cfg.getPoClassFile().addListProperty(Employee.class,"sameUserList","sameUserList","sameUserList");
        cfg.getPoClassFile().addListProperty(String.class,"sameUserIds","sameUserIds","sameUserIds");

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"leaderUser","leaderUser","leaderUser");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"secondLeaderUser","secondLeaderUser","secondLeaderUser");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"hrUser","hrUser","hrUser");



        cfg.getPoClassFile().addListProperty(Employee.class,"sameUserListRel","sameUserListRel","sameUserListRel");
        cfg.getPoClassFile().addListProperty(String.class,"sameUserIdsRel","sameUserIdsRel","sameUserIdsRel");

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"leaderUserRel","leaderUserRel","leaderUserRel");
        cfg.getPoClassFile().addSimpleProperty(String.class,"leaderUserIdRel","leaderUserIdRel","leaderUserIdRel");

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"secondLeaderUserRel","secondLeaderUserRel","secondLeaderUserRel");
        cfg.getPoClassFile().addSimpleProperty(String.class,"secondLeaderUserIdRel","secondLeaderUserIdRel","secondLeaderUserIdRel");

        cfg.getPoClassFile().addSimpleProperty(AssessmentBillTask.class,"assessmentBillTaskList","assessmentBillTaskList","assessmentBillTaskList");



        cfg.getPoClassFile().addSimpleProperty(String.class,"selfScoreValue","selfScoreValue","selfScoreValue");
        cfg.getPoClassFile().addSimpleProperty(String.class,"sameUserAvgScoreValue","sameUserAvgScoreValue","sameUserAvgScoreValue");
        cfg.getPoClassFile().addSimpleProperty(String.class,"sameUserNeedCount","sameUserNeedCount","sameUserNeedCount");
        cfg.getPoClassFile().addSimpleProperty(String.class,"sameUserFinishCount","sameUserFinishCount","sameUserFinishCount");
        cfg.getPoClassFile().addSimpleProperty(String.class,"leaderScoreValue","leaderScoreValue","sameUserScoreValue");
        cfg.getPoClassFile().addSimpleProperty(String.class,"secondLeaderScoreValue","secondLeaderScoreValue","secondLeaderScoreValue");
        cfg.getPoClassFile().addSimpleProperty(String.class,"ifHrConfirm","ifHrConfirm","ifHrConfirm");

        cfg.getPoClassFile().addSimpleProperty(String.class,"sOrgId","sOrgId","sOrgId");

        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_ASSESSMENT_BILL_USER_MAP.STATUS,
                        HrTables.HR_ASSESSMENT_BILL_USER_MAP.ASSESSEE_ID,
                        HrTables.HR_ASSESSMENT_BILL_USER_MAP.LEADER_ID,
                        HrTables.HR_ASSESSMENT_BILL_USER_MAP.HR_USER_ID,
                },
                new Object[]{

                        HrTables.HR_ASSESSMENT_BILL_USER_MAP.SECOND_LEADER_ID,
                        HrTables.HR_ASSESSMENT_BILL_USER_MAP.RESULT,
                        HrTables.HR_ASSESSMENT_BILL_USER_MAP.CREATE_TIME,
                }
        );


        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_USER_MAP.ASSESSEE_ID).table().fillBy("assesseeUser","name");
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_USER_MAP.ASSESSEE_ID).form().validate().required().form()
                .button().chooseEmployee(true);


        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_USER_MAP.LEADER_ID).table().fillBy("leaderUser","name");
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_USER_MAP.LEADER_ID).form()
                .button().chooseEmployee(true);

        cfg.view().field(AssessmentBillUserMapMeta.LEADER_USER_ID_REL).basic().label("直属领导【参考】");
        cfg.view().field(AssessmentBillUserMapMeta.LEADER_USER_ID_REL).table().disable(false);
        cfg.view().field(AssessmentBillUserMapMeta.LEADER_USER_ID_REL).table().fillBy("leaderUserRel","name");
        cfg.view().field(AssessmentBillUserMapMeta.LEADER_USER_ID_REL).form()
                .button().chooseEmployee(true);



        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_USER_MAP.HR_USER_ID).table().fillBy("hrUser","name");
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_USER_MAP.HR_USER_ID).form()
                .button().chooseEmployee(true);

        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_USER_MAP.SECOND_LEADER_ID).table().fillBy("secondLeaderUser","name");
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_USER_MAP.SECOND_LEADER_ID).form()
                .button().chooseEmployee(true);

        cfg.view().field(AssessmentBillUserMapMeta.SECOND_LEADER_USER_ID_REL).basic().label("上上级领导【参考】");
        cfg.view().field(AssessmentBillUserMapMeta.SECOND_LEADER_USER_ID_REL).table().disable(false);
        cfg.view().field(AssessmentBillUserMapMeta.SECOND_LEADER_USER_ID_REL).table().fillBy("secondLeaderUserRel","name");
        cfg.view().field(AssessmentBillUserMapMeta.SECOND_LEADER_USER_ID_REL).form()
                .button().chooseEmployee(true);


        cfg.view().field(AssessmentBillUserMapMeta.SAME_USER_IDS).basic().label("人员互评");
        cfg.view().field(AssessmentBillUserMapMeta.SAME_USER_IDS).form().table().disable(false);
        cfg.view().field(AssessmentBillUserMapMeta.SAME_USER_IDS).table().fillBy("sameUserList","name");
        cfg.view().field(AssessmentBillUserMapMeta.SAME_USER_IDS).form()
                .button().chooseEmployee(false);

        cfg.view().field(AssessmentBillUserMapMeta.SAME_USER_IDS_REL).basic().label("人员互评【参考】");
        cfg.view().field(AssessmentBillUserMapMeta.SAME_USER_IDS_REL).table().disable(false);
        cfg.view().field(AssessmentBillUserMapMeta.SAME_USER_IDS_REL).table().fillBy("sameUserListRel","name");
        cfg.view().field(AssessmentBillUserMapMeta.SAME_USER_IDS_REL).form()
                .button().chooseEmployee(false);


        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().list().disableBatchDelete();
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_USER_MAP.UPDATE_BY).form().table().disable(true);


        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_USER_MAP.MESSAGE).form().table().disable(true);
      //  cfg.view().field(HrTables.HR_ASSESSMENT_BILL_USER_MAP.OWNER_ID).form().table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_USER_MAP.ORG_ID).form().table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_USER_MAP.BILL_ID).form().table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_USER_MAP.MESSAGE).form().textArea().height(80);


        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_USER_MAP.STATUS).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);
        cfg.view().field(HrTables.HR_ASSESSMENT_BILL_USER_MAP.RESULT).form().radioBox().enumType(StatusSuccessFailedEnum.class).defaultIndex(0);

        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup("",
                new Object[] {
                        HrTables.HR_ASSESSMENT_BILL_USER_MAP.STATUS,
                },
                new Object[] {
                        HrTables.HR_ASSESSMENT_BILL_USER_MAP.ASSESSEE_ID,
                }
        );

        cfg.view().form().addGroup("人员信息",
                new Object[] {
                        HrTables.HR_ASSESSMENT_BILL_USER_MAP.LEADER_ID,
                        HrTables.HR_ASSESSMENT_BILL_USER_MAP.SECOND_LEADER_ID,
                },
                new Object[] {
                        AssessmentBillUserMapMeta.SAME_USER_IDS
                }
        );

        cfg.view().form().addGroup("生成记录",
                new Object[] {
                        HrTables.HR_ASSESSMENT_BILL_USER_MAP.MESSAGE,
                }
        );

        cfg.view().list().addToolButton("1>生成用户","resetData","reset-data");
        cfg.view().list().addToolButton("2>下发任务","BillTaskDown","bill-task-down");
        cfg.view().list().addToolButton("3>下发评分表","createPaper","create-paper");

        cfg.view().list().addJsVariable("OWNER_ID",   "[[${ownerId}]]","ownerId");
        cfg.view().form().addJsVariable("OWNER_ID",   "[[${ownerId}]]","ownerId");
        cfg.view().list().addJsVariable("BILL_ID",   "[[${billId}]]","billId");
        cfg.view().form().addJsVariable("BILL_ID",   "[[${billId}]]","billId");

        cfg.view().list().operationColumn().addActionButton("评分情况","pfDetail","pf-dtl");


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
        HrmAssessMentBillUserMapGtr g=new HrmAssessMentBillUserMapGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
     //   g.generateMenu(AssessmentBillUserMapServiceProxy.class, AssessmentBillUserMapPageController.class);
    }
}
