package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.hr.AssessmentCycleEnum;
import com.dt.platform.domain.hr.AssessmentIndicator;
import com.dt.platform.domain.hr.AssessmentTpl;
import com.dt.platform.domain.hr.meta.AssessmentPlanMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.hr.AssessmentPlanServiceProxy;
import com.github.foxnic.api.bpm.IntegrateMode;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Person;

import javax.management.Query;


public class HrmAssessMentPlanGtr extends BaseCodeGenerator {
    public HrmAssessMentPlanGtr() {
        super(HrTables.HR_ASSESSMENT_PLAN.$TABLE,"803970075315929088");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(AssessmentTpl.class,"assessmentTpl","assessmentTpl","assessmentTpl");
        cfg.getPoClassFile().addListProperty(AssessmentIndicator.class,"assessmentIndicatorList","assessmentIndicatorList","assessmentIndicator");
        cfg.getPoClassFile().addSimpleProperty(String.class,"selectedCode","selectedCode","selectedCode");
        cfg.getPoClassFile().addSimpleProperty(String.class,"buttonAction","buttonAction","buttonAction");

        cfg.getPoClassFile().addSimpleProperty(Person.class,"assesseeUser","assesseeUser","assesseeUser");
        cfg.getPoClassFile().addSimpleProperty(Person.class,"assessorUser","assessorUser","assessorUser");





        cfg.view().field(HrTables.HR_ASSESSMENT_PLAN.ASSESSOR_ID).table().fillBy("assessorUser","name");
        cfg.view().field(HrTables.HR_ASSESSMENT_PLAN.ASSESSOR_ID).form()
                .button().chooseEmployee(true);

        cfg.view().field(HrTables.HR_ASSESSMENT_PLAN.ASSESSEE_ID).table().fillBy("assesseeUser","name");
        cfg.view().field(HrTables.HR_ASSESSMENT_PLAN.ASSESSEE_ID).form()
                .button().chooseEmployee(true);


        cfg.view().field(HrTables.HR_ASSESSMENT_PLAN.ID).basic().hidden(true);

        cfg.view().field(HrTables.HR_ASSESSMENT_PLAN.NAME).search().fuzzySearch();
        cfg.view().field(HrTables.HR_ASSESSMENT_PLAN.NOTES).search().fuzzySearch();
        cfg.view().field(HrTables.HR_ASSESSMENT_PLAN.CREATE_TIME).search().range();
        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_ASSESSMENT_PLAN.STATUS,
                        HrTables.HR_ASSESSMENT_PLAN.ASSESSEE_ID,
                        HrTables.HR_ASSESSMENT_PLAN.NAME,
                },
                new Object[]{
                        HrTables.HR_ASSESSMENT_PLAN.CREATE_TIME,

                }
        );
        cfg.view().list().disableBatchDelete();
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(HrTables.HR_ASSESSMENT_PLAN.STATUS).form().radioBox().enumType(AssetHandleStatusEnum.class);
        cfg.view().field(HrTables.HR_ASSESSMENT_PLAN.NAME).form().validate().required();
        cfg.view().field(HrTables.HR_ASSESSMENT_PLAN.NOTES).form().textArea().height(80);
        cfg.view().field(HrTables.HR_ASSESSMENT_PLAN.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_PLAN.CREATE_TIME).form().table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_PLAN.TPL_ID).form().table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_PLAN.NOTES).form().table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_PLAN.ASSESSOR_SECOND_ID).form().table().disable(true);

        cfg.view().field(HrTables.HR_ASSESSMENT_PLAN.ASSESSOR_ID).form().table().disable(true);

        cfg.view().field(AssessmentPlanMeta.BUTTON_ACTION).form().table().disable(true);


        cfg.view().field(AssessmentPlanMeta.BUTTON_ACTION).form().button().action("加载指标","loadTplData");

        cfg.view().field(HrTables.HR_ASSESSMENT_PLAN.CYCLE).form().validate().required().form().radioBox().enumType(AssessmentCycleEnum.class).defaultIndex(0);

        cfg.view().field(HrTables.HR_ASSESSMENT_PLAN.ASSESSOR_ID).form().selectBox()
        .queryApi(AssessmentPlanServiceProxy.QUERY_PAGED_LIST+"?dictCode=hr_attendance_week")
        .paging(true).filter(true).toolbar(false)
        .valueField(AssessmentPlanMeta.ID).
        textField(AssessmentPlanMeta.NAME).
        fillWith(AssessmentPlanMeta.ASSESSMENT_TPL).muliti(false);


        cfg.view().formWindow().width("80%");;
        cfg.view().formWindow().bottomSpace(80);


        cfg.bpm().form("hr_assessment_plan");
        cfg.bpm().integrate(IntegrateMode.FRONT);
        cfg.view().form().labelWidth(70);


        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_ASSESSMENT_PLAN.NAME,
                        HrTables.HR_ASSESSMENT_PLAN.ASSESSEE_ID,
                },
                new Object[] {
                        HrTables.HR_ASSESSMENT_PLAN.TPL_ID,
                        HrTables.HR_ASSESSMENT_PLAN.TOTAL_WEIGHT,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        AssessmentPlanMeta.BUTTON_ACTION
                }
        );

        cfg.view().form().addPage("指标数据","indicatorSelectList");

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setBpmEventAdaptor(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE);
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        HrmAssessMentPlanGtr g=new HrmAssessMentPlanGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
       // g.generateMenu(AssessmentBillServiceProxy.class, AssessmentPlanPageController.class);
    }
}
