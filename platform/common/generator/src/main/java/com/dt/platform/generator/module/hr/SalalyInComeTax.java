package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.common.StatusYNEnum;
import com.dt.platform.constants.enums.hr.SalaryTypeEnum;
import com.dt.platform.domain.hr.SalaryIncomeTax;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.SalaryIncomeTaxPageController;
import com.dt.platform.proxy.hr.SalaryIncomeTaxServiceProxy;
import com.github.foxnic.generator.config.WriteMode;


public class SalalyInComeTax extends BaseCodeGenerator {
    public SalalyInComeTax() {
        super(HrTables.HR_SALARY_INCOME_TAX.$TABLE,"662315275764367360");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(HrTables.HR_SALARY_INCOME_TAX.ID).basic().hidden(true);

        cfg.view().search().disable();

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(HrTables.HR_SALARY_INCOME_TAX.VALUE_LEVEL).form().validate().required();
        cfg.view().field(HrTables.HR_SALARY_INCOME_TAX.START).form().validate().required();
        cfg.view().field(HrTables.HR_SALARY_INCOME_TAX.END).form().validate().required();
        cfg.view().field(HrTables.HR_SALARY_INCOME_TAX.TAX).form().validate().required();
        cfg.view().field(HrTables.HR_SALARY_INCOME_TAX.QUICK_DEDUCT).form().validate().required();
        cfg.view().field(HrTables.HR_SALARY_INCOME_TAX.NOTES).form().textArea().height(120);
        cfg.view().field(HrTables.HR_SALARY_INCOME_TAX.CREATE_TIME).table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_INCOME_TAX.CREATE_BY).table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_INCOME_TAX.UPDATE_BY).table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_INCOME_TAX.UPDATE_TIME).table().disable(true);
        cfg.view().list().disableBatchDelete();


        cfg.view().formWindow().width("65%");;
        cfg.view().formWindow().bottomSpace(50);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_SALARY_INCOME_TAX.VALUE_LEVEL,
                        HrTables.HR_SALARY_INCOME_TAX.START,
                        HrTables.HR_SALARY_INCOME_TAX.END,
                        HrTables.HR_SALARY_INCOME_TAX.TAX,
                        HrTables.HR_SALARY_INCOME_TAX.QUICK_DEDUCT,
                        HrTables.HR_SALARY_INCOME_TAX.NOTES
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
        SalalyInComeTax g=new SalalyInComeTax();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
    //  g.generateMenu(SalaryIncomeTaxServiceProxy.class, SalaryIncomeTaxPageController.class);
    }
}
