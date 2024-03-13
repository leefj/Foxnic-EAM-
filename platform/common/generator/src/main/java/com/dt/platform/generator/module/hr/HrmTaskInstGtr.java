package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.domain.hr.EvaluationRelation;
import com.dt.platform.domain.hr.ScoreTaskInst;
import com.dt.platform.domain.hr.ScoreTpl;
import com.dt.platform.domain.hr.meta.EvaluationRelationMeta;
import com.dt.platform.domain.hr.meta.ScoreTaskConfMeta;
import com.dt.platform.domain.hr.meta.ScoreTaskInstMeta;
import com.dt.platform.domain.hr.meta.ScoreTplMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.ScoreTaskInstPageController;
import com.dt.platform.proxy.hr.EvaluationRelationServiceProxy;
import com.dt.platform.proxy.hr.ScoreTaskInstServiceProxy;
import com.dt.platform.proxy.hr.ScoreTplServiceProxy;
import com.github.foxnic.generator.config.WriteMode;


public class HrmTaskInstGtr extends BaseCodeGenerator {
    public HrmTaskInstGtr() {
        super(HrTables.HR_SCORE_TASK_INST.$TABLE,"803970322595315713");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(HrTables.HR_SCORE_TASK_INST.ID).basic().hidden(true);

        cfg.view().field(HrTables.HR_SCORE_TASK_INST.NAME).search().fuzzySearch();


        cfg.getPoClassFile().addSimpleProperty(ScoreTpl.class,"scoreTpl","scoreTpl","scoreTpl");
        cfg.getPoClassFile().addSimpleProperty(EvaluationRelation.class,"evaluationRelation","evaluationRelation","evaluationRelation");

        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_SCORE_TASK_INST.NAME,
                        HrTables.HR_SCORE_TASK_INST.RELATIONSHIP,
                        HrTables.HR_SCORE_TASK_INST.TPL_ID,

                }
        );

        cfg.view().list().disableBatchDelete();

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);



        cfg.view().field(HrTables.HR_SCORE_TASK_INST.CREATE_TIME).form().table().disable(true);
        cfg.view().field(HrTables.HR_SCORE_TASK_INST.UPDATE_BY).form().table().disable(true);

        cfg.view().field(HrTables.HR_SCORE_TASK_INST.CONF_ID).form().table().disable(true);


        cfg.view().field(HrTables.HR_SCORE_TASK_INST.NAME).form().validate().required();
        cfg.view().field(HrTables.HR_SCORE_TASK_INST.NOTES).form().textArea().height(60);

        cfg.view().field(HrTables.HR_SCORE_TASK_INST.TPL_ID)
                .form().validate().required().form().selectBox().queryApi(ScoreTplServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(ScoreTplMeta.ID).
                textField(ScoreTplMeta.NAME).
                fillWith(ScoreTaskInstMeta.SCORE_TPL).muliti(false);

        cfg.view().field(HrTables.HR_SCORE_TASK_INST.RELATIONSHIP)
                .form().validate().required().form().selectBox().queryApi(EvaluationRelationServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(EvaluationRelationMeta.CODE).
                textField(EvaluationRelationMeta.NAME).
                fillWith(ScoreTaskInstMeta.EVALUATION_RELATION).muliti(true);


        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_SCORE_TASK_INST.NAME,
                        HrTables.HR_SCORE_TASK_INST.TPL_ID,
                        HrTables.HR_SCORE_TASK_INST.RELATIONSHIP,
                        HrTables.HR_SCORE_TASK_INST.NOTES,

                }
        );

        cfg.view().form().addJsVariable("CONF_ID","[[${confId}]]","confId");

        cfg.view().list().operationColumn().addActionButton("配置","taskConf","task-conf");


        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
                .setExtendJsFile(WriteMode.IGNORE);
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        HrmTaskInstGtr g=new HrmTaskInstGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
      //  g.generateMenu(ScoreTaskInstServiceProxy.class, ScoreTaskInstPageController.class);
    }
}