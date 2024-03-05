package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.common.YesNoEnum;
import com.dt.platform.constants.enums.hr.AssessmentCycleEnum;
import com.dt.platform.constants.enums.hr.AssessmentTaskOwnerEnum;
import com.dt.platform.domain.hr.AssessmentBill;
import com.dt.platform.domain.hr.AssessmentIndicator;
import com.dt.platform.domain.hr.AssessmentTpl;
import com.dt.platform.domain.hr.Position;
import com.dt.platform.domain.hr.meta.AssessmentTaskMeta;
import com.dt.platform.domain.hr.meta.AssessmentTplMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.AssessmentTaskPageController;
import com.dt.platform.proxy.hr.AssessmentTaskServiceProxy;
import com.dt.platform.proxy.hr.AssessmentTplServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Person;


public class HrmAssessMentTaskGtr extends BaseCodeGenerator {
    public HrmAssessMentTaskGtr() {
        super(HrTables.HR_ASSESSMENT_TASK.$TABLE,"803970075315929088");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(AssessmentTpl.class,"assessmentTpl","assessmentTpl","assessmentTpl");


        cfg.getPoClassFile().addListProperty(AssessmentIndicator.class,"assessmentIndicatorList","assessmentIndicatorList","assessmentIndicator");
        cfg.getPoClassFile().addSimpleProperty(String.class,"selectedCode","selectedCode","selectedCode");



        cfg.getPoClassFile().addListProperty(Organization.class,"organizationList","organizationList","organizationList");
        cfg.getPoClassFile().addListProperty(String.class,"organizationIds","organizationIds","organizationIds");

        cfg.getPoClassFile().addListProperty(Person.class,"personList","personList","personList");
        cfg.getPoClassFile().addListProperty(String.class,"personIds","personIds","personIds");


        cfg.getPoClassFile().addListProperty(Person.class,"excludePersonList","excludePersonList","excludePersonList");
        cfg.getPoClassFile().addListProperty(String.class,"excludePersonIds","excludePersonIds","excludePersonIds");



        cfg.view().field(HrTables.HR_ASSESSMENT_TASK.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_TASK.NAME).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_ASSESSMENT_TASK.NAME,
                        HrTables.HR_ASSESSMENT_TASK.SOURCE
                }
        );
        cfg.view().list().disableBatchDelete();
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(HrTables.HR_ASSESSMENT_TASK.NAME).form().validate().required();
        cfg.view().field(HrTables.HR_ASSESSMENT_TASK.NOTES).form().textArea().height(80);
        cfg.view().field(HrTables.HR_ASSESSMENT_TASK.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_TASK.CREATE_TIME).form().table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_TASK.OWNER).form().table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_TASK.OWNER).form().radioBox().enumType(AssessmentTaskOwnerEnum.class);
        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(80);

        cfg.view().field(HrTables.HR_ASSESSMENT_TASK.CYCLE).form().validate().required().form().radioBox().enumType(AssessmentCycleEnum.class).defaultIndex(0);
        cfg.view().field(HrTables.HR_ASSESSMENT_TASK.HAS_SELF_ASSESSMENT).form().validate().required().form().radioBox().enumType(YesNoEnum.class).defaultIndex(0);
        cfg.view().field(HrTables.HR_ASSESSMENT_TASK.HAS_LEADER_ASSESSMENT).form().validate().required().form().radioBox().enumType(YesNoEnum.class).defaultIndex(0);
        cfg.view().field(HrTables.HR_ASSESSMENT_TASK.HAS_SECOND_LEADER_ASSESSMENT).form().validate().required().form().radioBox().enumType(YesNoEnum.class).defaultIndex(1);
        cfg.view().field(HrTables.HR_ASSESSMENT_TASK.HAS_SAME_ASSESSMENT).form().validate().required().form().radioBox().enumType(YesNoEnum.class).defaultIndex(1);
        cfg.view().field(HrTables.HR_ASSESSMENT_TASK.HAS_HR_CONFIRM).form().validate().required().form().radioBox().enumType(YesNoEnum.class).defaultIndex(1);


        cfg.view().field(HrTables.HR_ASSESSMENT_TASK.IS_ALL_PERSON).form().validate().required().form().radioBox().enumType(YesNoEnum.class).defaultIndex(1);


        cfg.view().field(HrTables.HR_ASSESSMENT_TASK.TPL_ID)
                .form().selectBox().queryApi(AssessmentTplServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(AssessmentTplMeta.ID).
                textField(AssessmentTplMeta.NAME).
                fillWith(AssessmentTaskMeta.ASSESSMENT_TPL).muliti(false);


        cfg.view().form().addGroup(null,
                new Object[] {

                        HrTables.HR_ASSESSMENT_TASK.CYCLE,
                },
                new Object[] {
                        HrTables.HR_ASSESSMENT_TASK.TOTAL_WEIGHT,
                        HrTables.HR_ASSESSMENT_TASK.HAS_HR_CONFIRM,
                }
        );

        cfg.view().form().addGroup("范围",
                new Object[] {
                        HrTables.HR_ASSESSMENT_TASK.IS_ALL_PERSON,
                        AssessmentTaskMeta.EXCLUDE_PERSON_IDS,
                },
                new Object[] {
                        AssessmentTaskMeta.ORGANIZATION_IDS,
                        AssessmentTaskMeta.PERSON_IDS
                }
        );


        cfg.view().form().addGroup("评分方式",
                new Object[] {
                        HrTables.HR_ASSESSMENT_TASK.HAS_SELF_ASSESSMENT,
                        HrTables.HR_ASSESSMENT_TASK.HAS_SAME_ASSESSMENT,
                },
                new Object[] {
                        HrTables.HR_ASSESSMENT_TASK.HAS_LEADER_ASSESSMENT,
                        HrTables.HR_ASSESSMENT_TASK.HAS_SECOND_LEADER_ASSESSMENT,
                }
        );

        cfg.view().form().addPage("指标数据","indicatorSelectList");


        cfg.view().list().operationColumn().addActionButton("生成明细","createTaskDtl","task-dtl");


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
        HrmAssessMentTaskGtr g=new HrmAssessMentTaskGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
     //   g.generateMenu(AssessmentTaskServiceProxy.class, AssessmentTaskPageController.class);
    }
}
