package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.SalaryProjectCommissionPageController;
import com.dt.platform.proxy.hr.SalaryProjectCommissionServiceProxy;
import com.github.foxnic.generator.config.WriteMode;


public class SalalyProjectCommissionGtr extends BaseCodeGenerator {
    public SalalyProjectCommissionGtr() {
        super(HrTables.HR_SALARY_PROJECT_COMMISSION.$TABLE,"662315275764367360");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION.CODE).search().fuzzySearch();
        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION.NAME).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_SALARY_PROJECT_COMMISSION.CODE,
                        HrTables.HR_SALARY_PROJECT_COMMISSION.NAME,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION.COMMISSION_RATIO).form().validate().required().form().numberInput().decimal().scale(2).defaultValue(0.00);
        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION.CODE).form().validate().required();
        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION.NAME).form().validate().required();
        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION.NOTES).form().textArea().height(120);
        cfg.view().list().disableBatchDelete();

        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION.CREATE_TIME).table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_PROJECT_TIME.CREATE_BY).table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION.UPDATE_BY).table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION.UPDATE_TIME).table().disable(true);

        cfg.view().formWindow().width("65%");;
        cfg.view().formWindow().bottomSpace(50);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_SALARY_PROJECT_COMMISSION.CODE,
                        HrTables.HR_SALARY_PROJECT_COMMISSION.NAME,
                        HrTables.HR_SALARY_PROJECT_COMMISSION.COMMISSION_RATIO,
                        HrTables.HR_SALARY_PROJECT_COMMISSION.NOTES,
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
        SalalyProjectCommissionGtr g=new SalalyProjectCommissionGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
        //
          g.generateMenu(SalaryProjectCommissionServiceProxy.class, SalaryProjectCommissionPageController.class);
    }
}
