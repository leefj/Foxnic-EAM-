package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.domain.hr.AssessmentIndicator;
import com.dt.platform.domain.hr.AssessmentIndicatorValue;
import com.dt.platform.domain.hr.AssessmentTpl;
import com.dt.platform.domain.hr.Position;
import com.dt.platform.domain.hr.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.AssessmentTplPageController;
import com.dt.platform.proxy.hr.AssessmentTplServiceProxy;
import com.dt.platform.proxy.hr.PositionServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;


public class HrmAssessMentTplGtr extends BaseCodeGenerator {
    public HrmAssessMentTplGtr() {
        super(HrTables.HR_ASSESSMENT_TPL.$TABLE,"803970075315929088");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addListProperty(AssessmentIndicator.class,"assessmentIndicator","assessmentIndicator","assessmentIndicator");
        cfg.getPoClassFile().addSimpleProperty(String.class,"selectedCode","selectedCode","selectedCode");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"typeDict","typeDict","typeDict");

        cfg.getPoClassFile().addListProperty(Position.class,"positionList","positionList","positionList");
        cfg.getPoClassFile().addListProperty(String.class,"positionIds","positionIds","positionIds");

        cfg.view().field(HrTables.HR_ASSESSMENT_TPL.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_TPL.NAME).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_ASSESSMENT_TPL.TYPE,
                        HrTables.HR_ASSESSMENT_TPL.NAME
                }
        );
        cfg.view().list().disableBatchDelete();
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(HrTables.HR_ASSESSMENT_TPL.NAME).form().validate().required();
        cfg.view().field(HrTables.HR_ASSESSMENT_TPL.NOTES).form().textArea().height(80);
        cfg.view().field(HrTables.HR_ASSESSMENT_TPL.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_ASSESSMENT_TPL.CREATE_TIME).form().table().disable(true);
        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(80);

     //   cfg.view().field( AssessmentTplMeta.ORGANIZATION_IDS).basic().label("部门");
        cfg.view().field( AssessmentTplMeta.POSITION_IDS).basic().label("岗位");



        cfg.view().field(HrTables.HR_ASSESSMENT_TPL.ORG_ID)
                .form().form().button().chooseOrganization(false);

        cfg.view().field( HrTables.HR_ASSESSMENT_TPL.ORG_ID).table().disable(true);

        cfg.view().field(AssessmentTplMeta.POSITION_IDS)
                .form().selectBox().queryApi(PositionServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(PositionMeta.ID).
                textField(PositionMeta.NAME).
                fillWith(AssessmentTplMeta.POSITION_LIST).muliti(true);

        cfg.view().field(HrTables.HR_ASSESSMENT_TPL.TYPE)
                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=hr_assessment_type")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(AssessmentTplMeta.TYPE_DICT).muliti(false);





        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_ASSESSMENT_TPL.NAME,
                        HrTables.HR_ASSESSMENT_TPL.TYPE,
                },
                new Object[] {
                        HrTables.HR_ASSESSMENT_TPL.TOTAL_WEIGHT,
                }
        );
        cfg.view().form().addGroup("范围",
                new Object[] {
                        HrTables.HR_ASSESSMENT_TPL.ORG_ID,
                },
                new Object[] {
                        AssessmentTplMeta.POSITION_IDS,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_ASSESSMENT_TPL.NOTES,
                }
        );
        cfg.view().form().addPage("指标数据","indicatorSelectList");

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
        HrmAssessMentTplGtr g=new HrmAssessMentTplGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
       // g.generateMenu(AssessmentTplServiceProxy.class, AssessmentTplPageController.class);
    }
}
