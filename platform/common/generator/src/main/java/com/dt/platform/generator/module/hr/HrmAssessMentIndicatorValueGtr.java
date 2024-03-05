package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;


public class HrmAssessMentIndicatorValueGtr extends BaseCodeGenerator {
    public HrmAssessMentIndicatorValueGtr() {
        super(HrTables.HR_ASSESSMENT_INDICATOR_VALUE.$TABLE,"803970075315929088");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(HrTables.HR_ASSESSMENT_INDICATOR_VALUE.ID).basic().hidden(true);
        cfg.view().search().disable();
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
        HrmAssessMentIndicatorValueGtr g=new HrmAssessMentIndicatorValueGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
       // g.generateMenu(AssessmentIndicatorServiceProxy.class, AssessmentIndicatorPageController.class);
    }
}
