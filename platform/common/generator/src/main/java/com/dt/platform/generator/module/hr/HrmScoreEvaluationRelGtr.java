package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.hr.EvaluationRelation;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.EvaluationRelationPageController;
import com.dt.platform.proxy.hr.EvaluationRelationServiceProxy;
import com.github.foxnic.generator.config.WriteMode;


public class HrmScoreEvaluationRelGtr extends BaseCodeGenerator {
    public HrmScoreEvaluationRelGtr() {
        super(HrTables.HR_EVALUATION_RELATION.$TABLE,"803970322595315713");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(HrTables.HR_EVALUATION_RELATION.ID).basic().hidden(true);

        cfg.view().field(HrTables.HR_EVALUATION_RELATION.NAME).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_EVALUATION_RELATION.STATUS,
                        HrTables.HR_EVALUATION_RELATION.NAME,

                }
        );

        cfg.view().list().disableBatchDelete();

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(HrTables.HR_EVALUATION_RELATION.CREATE_TIME).form().table().disable(true);
        cfg.view().field(HrTables.HR_EVALUATION_RELATION.UPDATE_BY).form().table().disable(true);

        cfg.view().field(HrTables.HR_EVALUATION_RELATION.CODE).form().validate().required();
        cfg.view().field(HrTables.HR_EVALUATION_RELATION.NAME).form().validate().required();

        cfg.view().field(HrTables.HR_EVALUATION_RELATION.STATUS).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);




        cfg.view().formWindow().width("70%");;
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_EVALUATION_RELATION.CODE,
                        HrTables.HR_EVALUATION_RELATION.NAME,
                        HrTables.HR_EVALUATION_RELATION.STATUS,
                }
        );




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
        HrmScoreEvaluationRelGtr g=new HrmScoreEvaluationRelGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单

       //g.generateMenu(EvaluationRelationServiceProxy.class, EvaluationRelationPageController.class);
    }
}
