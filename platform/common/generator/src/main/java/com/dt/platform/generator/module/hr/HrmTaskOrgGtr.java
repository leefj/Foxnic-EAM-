package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.hr.ScoreTaskStatusEnum;
import com.dt.platform.domain.hr.EvaluationRelation;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;


public class HrmTaskOrgGtr extends BaseCodeGenerator {
    public HrmTaskOrgGtr() {
        super(HrTables.HR_SCORE_TASK_ORG.$TABLE,"803970322595315713");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(HrTables.HR_SCORE_TASK.ID).basic().hidden(true);

        cfg.view().field(HrTables.HR_SCORE_TASK.NAME).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_SCORE_TASK.STATUS,
                        HrTables.HR_SCORE_TASK.NAME,
                }
        );

        cfg.view().list().disableBatchDelete();

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(HrTables.HR_SCORE_TASK.USER_ID).form().table().disable(true);
        cfg.view().field(HrTables.HR_SCORE_TASK.CREATE_OWNER_ID).form().table().disable(true);
        cfg.view().field(HrTables.HR_SCORE_TASK.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_SCORE_TASK.CREATE_TIME).form().table().disable(true);
        cfg.view().field(HrTables.HR_SCORE_TASK.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_SCORE_TASK.NAME).form().validate().required();
        cfg.view().field(HrTables.HR_SCORE_TASK.STATUS).form().validate().required().form().radioBox().enumType(ScoreTaskStatusEnum.class).defaultIndex(0);
        cfg.view().field(HrTables.HR_SCORE_TASK.NOTES).form().textArea().height(60);



        cfg.view().formWindow().width("70%");;
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_SCORE_TASK.NAME,
                        HrTables.HR_SCORE_TASK.STATUS,
                        HrTables.HR_SCORE_TASK.NOTES,

                }
        );

        cfg.view().list().operationColumn().addActionButton("评分","scoreItem","score-item");


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
        HrmTaskOrgGtr g=new HrmTaskOrgGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
     //   g.generateMenu(ScoreTaskServiceProxy.class, ScoreTaskPageController.class);
    }
}
