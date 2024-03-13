package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.hr.AssessmentIndicatorPropertyEnum;
import com.dt.platform.domain.hr.AssessmentIndicator;
import com.dt.platform.domain.hr.AssessmentIndicatorValue;
import com.dt.platform.domain.hr.IndicatorLib;
import com.dt.platform.domain.hr.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.AssessmentIndicatorPageController;
import com.dt.platform.hr.page.IndicatorLibPageController;
import com.dt.platform.proxy.hr.AssessmentIndicatorServiceProxy;
import com.dt.platform.proxy.hr.IndicatorLibServiceProxy;
import com.dt.platform.proxy.hr.PersonServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;


public class HrmAssessMentIndicatorGtr extends BaseCodeGenerator {
    public HrmAssessMentIndicatorGtr() {
        super(HrTables.HR_ASSESSMENT_INDICATOR.$TABLE,"803970075315929088");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());




        cfg.getPoClassFile().addSimpleProperty(AssessmentIndicatorValue.class,"selfAssessmentValue","selfAssessmentValue","selfAssessmentValue");
        cfg.getPoClassFile().addSimpleProperty(AssessmentIndicatorValue.class,"leaderAssessmentValue","leaderAssessmentValue","leaderAssessmentValue");
        cfg.getPoClassFile().addListProperty(AssessmentIndicatorValue.class,"sameAssessmentValue","sameAssessmentValue","sameAssessmentValue");

        cfg.getPoClassFile().addListProperty(IndicatorLib.class,"indicatorLib","indicatorLib","indicatorLib");

        cfg.view().field(HrTables.HR_ASSESSMENT_INDICATOR.PROPERTY).form().validate().required().form().radioBox().enumType(AssessmentIndicatorPropertyEnum.class).defaultIndex(0);


        cfg.view().field(HrTables.HR_ASSESSMENT_INDICATOR.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_INDICATOR.NAME).search().fuzzySearch();
        cfg.view().field(HrTables.HR_ASSESSMENT_INDICATOR.DEF).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_ASSESSMENT_INDICATOR.NAME,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(HrTables.HR_ASSESSMENT_INDICATOR.NAME).form().validate().required();


        cfg.view().field(HrTables.HR_ASSESSMENT_INDICATOR.TPL_INDICATOR_ID).form()
                .selectBox().queryApi(IndicatorLibServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(IndicatorLibMeta.ID).
                textField(IndicatorLibMeta.NAME).
                fillWith(AssessmentIndicatorMeta.INDICATOR_LIB).muliti(false);


        cfg.view().field(HrTables.HR_ASSESSMENT_INDICATOR.CREATE_TIME).table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_INDICATOR.UPDATE_BY).table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_INDICATOR.UPDATE_BY).table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_INDICATOR.ASSESSMENT_ID).table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_INDICATOR.TPL_INDICATOR_ID).table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_INDICATOR.DEF).form().textArea().height(120);
        cfg.view().field(HrTables.HR_ASSESSMENT_INDICATOR.SCORING_BASE).form().textArea().height(80);
        cfg.view().field(HrTables.HR_ASSESSMENT_INDICATOR.SCORING_BY).form().textArea().height(80);

        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup("指标说明",
                new Object[] {
                        HrTables.HR_ASSESSMENT_INDICATOR.TPL_INDICATOR_ID,
                        HrTables.HR_ASSESSMENT_INDICATOR.PROPERTY,
                        HrTables.HR_ASSESSMENT_INDICATOR.UNIT,
                },
                new Object[] {
                        HrTables.HR_ASSESSMENT_INDICATOR.GROUPNAME,
                        HrTables.HR_ASSESSMENT_INDICATOR.NAME,
                        HrTables.HR_ASSESSMENT_INDICATOR.WEIGHT,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_ASSESSMENT_INDICATOR.DEF,
                        HrTables.HR_ASSESSMENT_INDICATOR.SCORING_BASE,
                        HrTables.HR_ASSESSMENT_INDICATOR.SCORING_BY,
                }
        );
        cfg.view().form().addGroup("得分情况",
                new Object[] {
                        HrTables.HR_ASSESSMENT_INDICATOR.TARGET_MIN_VALUE,
                        HrTables.HR_ASSESSMENT_INDICATOR.TARGET_MAX_VALUE,
                },
                new Object[] {
                        HrTables.HR_ASSESSMENT_INDICATOR.DEFAULT_VALUE,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_ASSESSMENT_INDICATOR.SN,

                }
        );
        cfg.view().list().addJsVariable("ASSESSMENT_ID",   "[[${assessmentId}]]","assessmentId");
        cfg.view().form().addJsVariable("ASSESSMENT_ID",   "[[${assessmentId}]]","assessmentId");

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
        HrmAssessMentIndicatorGtr g=new HrmAssessMentIndicatorGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
       // g.generateMenu(AssessmentIndicatorServiceProxy.class, AssessmentIndicatorPageController.class);
    }
}
