package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.hr.SalaryBusinessTypeEnum;
import com.dt.platform.constants.enums.hr.SalaryColumnTypeEnum;
import com.dt.platform.domain.hr.PerformanceLevel;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.PerformanceLevelPageController;
import com.dt.platform.proxy.hr.PerformanceLevelServiceProxy;
import com.github.foxnic.generator.config.WriteMode;


public class PerformLevelGtr extends BaseCodeGenerator {
    public PerformLevelGtr() {
        super(HrTables.HR_PERFORMANCE_LEVEL.$TABLE,"803970075315929088");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(HrTables.HR_PERFORMANCE_LEVEL.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_PERFORMANCE_LEVEL.CODE).search().fuzzySearch();
        cfg.view().field(HrTables.HR_PERFORMANCE_LEVEL.NAME).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_PERFORMANCE_LEVEL.CODE,
                        HrTables.HR_PERFORMANCE_LEVEL.NAME,
                }
        );

        cfg.view().list().disableBatchDelete();
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(HrTables.HR_PERFORMANCE_LEVEL.UPDATE_BY).form().table().disable(true);

        cfg.view().field(HrTables.HR_PERFORMANCE_LEVEL.CODE).form().validate().required();
        cfg.view().field(HrTables.HR_PERFORMANCE_LEVEL.NAME).form().validate().required();

        cfg.view().field(HrTables.HR_PERFORMANCE_LEVEL.LOWER_LIMIT).form().validate().required().form().numberInput().decimal().scale(2).defaultValue(0.00);
        cfg.view().field(HrTables.HR_PERFORMANCE_LEVEL.UPPER_LIMIT).form().validate().required().form().numberInput().decimal().scale(2).defaultValue(0.00);

        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_PERFORMANCE_LEVEL.CODE,
                        HrTables.HR_PERFORMANCE_LEVEL.LOWER_LIMIT
                },
                new Object[] {
                        HrTables.HR_PERFORMANCE_LEVEL.NAME,
                        HrTables.HR_PERFORMANCE_LEVEL.UPPER_LIMIT
                }
        );

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
        PerformLevelGtr g=new PerformLevelGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
        //
        g.generateMenu(PerformanceLevelServiceProxy.class, PerformanceLevelPageController.class);


    }
}
