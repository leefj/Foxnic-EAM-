package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.hr.ScoreTaskStatusEnum;
import com.dt.platform.domain.hr.EvaluationRelation;
import com.dt.platform.domain.hr.ScoreTpl;
import com.dt.platform.domain.hr.ScoreUser;
import com.dt.platform.domain.hr.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.ScoreUserPageController;
import com.dt.platform.proxy.hr.EvaluationRelationServiceProxy;
import com.dt.platform.proxy.hr.PositionServiceProxy;
import com.dt.platform.proxy.hr.ScoreTplServiceProxy;
import com.dt.platform.proxy.hr.ScoreUserServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Person;


public class HrmTaskScoreUserGtr extends BaseCodeGenerator {
    public HrmTaskScoreUserGtr() {
        super(HrTables.HR_SCORE_USER.$TABLE,"803970322595315713");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(Organization.class,"organization","organization","organization");
        cfg.getPoClassFile().addSimpleProperty(Person.class,"raterUser","raterUser","raterUser");
        cfg.getPoClassFile().addSimpleProperty(Person.class,"ratedUser","ratedUser","ratedUser");
        cfg.getPoClassFile().addSimpleProperty(ScoreTpl.class,"scoreTpl","scoreTpl","scoreTpl");
        cfg.getPoClassFile().addSimpleProperty(EvaluationRelation.class,"evaluationRelation","evaluationRelation","evaluationRelation");



        cfg.view().field(HrTables.HR_SCORE_USER.ID).basic().hidden(true);


        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_SCORE_USER.TPL_ID,
                        HrTables.HR_SCORE_USER.ORG_ID,
                        HrTables.HR_SCORE_USER.RATER_ID,
                        HrTables.HR_SCORE_USER.RATED_ID,
                }
        );

        cfg.view().list().disableBatchDelete();

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(HrTables.HR_SCORE_USER.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_SCORE_USER.CREATE_TIME).form().table().disable(true);
        cfg.view().field(HrTables.HR_SCORE_USER.UPDATE_BY).form().table().disable(true);


         cfg.view().field(HrTables.HR_SCORE_USER.NOTES).form().textArea().height(60);


        cfg.view().field(HrTables.HR_SCORE_USER.ORG_ID)
                .form().validate().required().form().button().chooseOrganization(true);
        cfg.view().field(HrTables.HR_SCORE_USER.ORG_ID).table().fillBy("organization","fullName");


        cfg.view().field(HrTables.HR_SCORE_USER.RATER_ID).table().fillBy("raterUser","name");
        cfg.view().field(HrTables.HR_SCORE_USER.RATER_ID).form().validate().required().form()
                .button().chooseEmployee(true);



        cfg.view().field(HrTables.HR_SCORE_USER.TPL_ID)
                .form().validate().required().form().selectBox().queryApi(ScoreTplServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(ScoreTplMeta.ID).
                textField(ScoreTplMeta.NAME).
                fillWith(ScoreUserMeta.SCORE_TPL).muliti(false);

        cfg.view().field(HrTables.HR_SCORE_USER.RELATIONSHIP)
                .form().validate().required().form().selectBox().queryApi(EvaluationRelationServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(EvaluationRelationMeta.CODE).
                textField(EvaluationRelationMeta.NAME).
                fillWith(ScoreUserMeta.EVALUATION_RELATION).muliti(true);

        cfg.view().field(HrTables.HR_SCORE_USER.RATED_ID).table().fillBy("ratedUser","name");
        cfg.view().field(HrTables.HR_SCORE_USER.RATER_ID).form().validate().required().form()
                .button().chooseEmployee(true);


        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_SCORE_USER.ORG_ID,
                        HrTables.HR_SCORE_USER.RELATIONSHIP,
                        HrTables.HR_SCORE_USER.RATER_ID,
                        HrTables.HR_SCORE_USER.RATED_ID,
                        HrTables.HR_SCORE_USER.TPL_ID,
                        HrTables.HR_SCORE_USER.NOTES,
                }
        );




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
        HrmTaskScoreUserGtr g=new HrmTaskScoreUserGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
     //   g.generateMenu(ScoreUserServiceProxy.class, ScoreUserPageController.class);
    }
}
