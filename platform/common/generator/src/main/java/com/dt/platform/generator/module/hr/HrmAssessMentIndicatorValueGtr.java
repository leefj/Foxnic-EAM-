package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.domain.hr.AssessmentIndicator;
import com.dt.platform.domain.hr.AssessmentIndicatorValue;
import com.dt.platform.domain.hr.IndicatorLib;
import com.dt.platform.domain.hr.meta.AssessmentBillUserMapMeta;
import com.dt.platform.domain.hr.meta.AssessmentIndicatorValueMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.AssessmentIndicatorValuePageController;
import com.dt.platform.proxy.hr.AssessmentIndicatorValueServiceProxy;
import com.github.foxnic.generator.config.WriteMode;


public class HrmAssessMentIndicatorValueGtr extends BaseCodeGenerator {
    public HrmAssessMentIndicatorValueGtr() {
        super(HrTables.HR_ASSESSMENT_INDICATOR_VALUE.$TABLE,"803970075315929088");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(HrTables.HR_ASSESSMENT_INDICATOR_VALUE.ID).basic().hidden(true);


        cfg.getPoClassFile().addSimpleProperty(AssessmentIndicator.class,"assessmentIndicator","assessmentIndicator","assessmentIndicator");
        cfg.getPoClassFile().addSimpleProperty(String.class,"IndicatorGroupName","IndicatorGroupName","IndicatorGroupName");
        cfg.getPoClassFile().addSimpleProperty(String.class,"IndicatorName","IndicatorName","IndicatorName");
        cfg.getPoClassFile().addSimpleProperty(String.class,"IndicatorScoringBase","IndicatorScoringBase","IndicatorScoringBase");
        cfg.getPoClassFile().addSimpleProperty(String.class,"IndicatorDef","IndicatorDef","IndicatorDef");
        cfg.getPoClassFile().addSimpleProperty(String.class,"IndicatorMinValue","IndicatorMinValue","IndicatorMinValue");
        cfg.getPoClassFile().addSimpleProperty(String.class,"IndicatorMaxValue","IndicatorMaxValue","IndicatorMaxValue");



        cfg.view().list().disableBatchDelete();
        cfg.view().search().disable();
        cfg.view().list().addJsVariable("PAPER_ID",   "[[${paperId}]]","paperId");




        cfg.view().field(AssessmentIndicatorValueMeta.INDICATOR_GROUP_NAME).basic().label("分类").table().fillBy("assessmentIndicator","IndicatorGroupName");
        cfg.view().field(AssessmentIndicatorValueMeta.INDICATOR_NAME).basic().label("名称").table().fillBy("assessmentIndicator","IndicatorGroupName");
        cfg.view().field(AssessmentIndicatorValueMeta.INDICATOR_SCORING_BASE).basic().label("评份标准").table().fillBy("assessmentIndicator","IndicatorScoringBase");
        cfg.view().field(AssessmentIndicatorValueMeta.INDICATOR_DEF).basic().label("评份定义").table().fillBy("assessmentIndicator","IndicatorDef");
        cfg.view().field(AssessmentIndicatorValueMeta.INDICATOR_MIN_VALUE).basic().label("最低分").table().fillBy("assessmentIndicator","IndicatorMinValue");
        cfg.view().field(AssessmentIndicatorValueMeta.INDICATOR_MAX_VALUE).basic().label("最高分").table().fillBy("assessmentIndicator","IndicatorMaxValue");
        cfg.view().field(AssessmentIndicatorValueMeta.ASSESSMENT_INDICATOR).basic().label("分类").table().disable(false);

        cfg.view().field(HrTables.HR_ASSESSMENT_INDICATOR_VALUE.CREATE_TIME).table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_INDICATOR_VALUE.UPDATE_BY).table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_INDICATOR_VALUE.INDICATOR_ID).table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_INDICATOR_VALUE.TASK_PAPER_ID).table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_INDICATOR_VALUE.SN).table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_INDICATOR_VALUE.CONTENT).table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_INDICATOR_VALUE.CONTENT).form().textArea().height(250);

        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_ASSESSMENT_INDICATOR_VALUE.VALUE,
                        HrTables.HR_ASSESSMENT_INDICATOR_VALUE.CONTENT
                }
        );

        //cfg.view().list().addJsVariable("IND_DATA",   "[[${indData}]]","indData");
        cfg.view().form().addJsVariable("IND_DATA",   "[[${indData}]]","indData");

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
        HrmAssessMentIndicatorValueGtr g=new HrmAssessMentIndicatorValueGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
      //  g.removeByBatchId("470160949404237824");
      //  //生成菜单
       // g.generateMenu(AssessmentIndicatorValueServiceProxy.class, AssessmentIndicatorValuePageController.class);
    }
}
