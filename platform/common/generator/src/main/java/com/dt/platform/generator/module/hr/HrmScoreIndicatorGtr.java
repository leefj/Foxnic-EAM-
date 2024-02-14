package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.hr.ScoreIndicator;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.ScoreIndicatorPageController;
import com.dt.platform.proxy.hr.ScoreIndicatorServiceProxy;
import com.github.foxnic.generator.config.WriteMode;


public class HrmScoreIndicatorGtr extends BaseCodeGenerator {
    public HrmScoreIndicatorGtr() {
        super(HrTables.HR_SCORE_INDICATOR.$TABLE,"803970322595315713");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(HrTables.HR_SCORE_INDICATOR.ID).basic().hidden(true);

        cfg.view().field(HrTables.HR_SCORE_INDICATOR.NAME).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_SCORE_INDICATOR.STATUS,
                        HrTables.HR_SCORE_INDICATOR.NAME,

                }
        );

        cfg.view().list().disableBatchDelete();

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(HrTables.HR_SCORE_INDICATOR.CREATE_TIME).form().table().disable(true);
        cfg.view().field(HrTables.HR_SCORE_INDICATOR.UPDATE_BY).form().table().disable(true);

        cfg.view().field(HrTables.HR_SCORE_INDICATOR.NAME).form().validate().required();

        cfg.view().field(HrTables.HR_SCORE_INDICATOR.STATUS).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);
        cfg.view().field(HrTables.HR_SCORE_INDICATOR.NOTES).form().textArea().height(60);



        cfg.view().formWindow().width("70%");;
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup(null,
                new Object[] {

                        HrTables.HR_SCORE_INDICATOR.NAME,
                        HrTables.HR_SCORE_INDICATOR.STATUS,
                        HrTables.HR_SCORE_INDICATOR.WEIGHT,
                        HrTables.HR_SCORE_INDICATOR.NOTES,

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
        HrmScoreIndicatorGtr g=new HrmScoreIndicatorGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单

      // g.generateMenu(ScoreIndicatorServiceProxy.class, ScoreIndicatorPageController.class);
    }
}
