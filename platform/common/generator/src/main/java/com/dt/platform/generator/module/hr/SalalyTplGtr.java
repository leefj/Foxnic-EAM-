package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.domain.hr.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.SalaryTplPageController;
import com.dt.platform.proxy.hr.SalaryTplServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

import java.math.BigDecimal;


public class SalalyTplGtr extends BaseCodeGenerator {
    public SalalyTplGtr() {
        super(HrTables.HR_SALARY_TPL.$TABLE,"662315275764367360");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addListProperty(SalaryTplItem.class,"salaryTplItem","salaryTplItem","salaryTplItem");
        cfg.getPoClassFile().addListProperty(SalaryTplItem.class,"validSalaryTplItem","validSalaryTplItem","validSalaryTplItem");

        cfg.getPoClassFile().addSimpleProperty(SalaryCtl.class,"salaryCtl","salaryCtl","salaryCtl");
        cfg.getPoClassFile().addListProperty(SalaryIncomeTax.class,"salaryIncomeTaxList","salaryIncomeTaxList","salaryIncomeTaxList");

        cfg.getPoClassFile().addSimpleProperty(BigDecimal.class,"confNonConversionRatio","confNonConversionRatio","confNonConversionRatio");
        cfg.getPoClassFile().addSimpleProperty(String.class,"confCurMonth","confCurMonth","confCurMonth");

        cfg.view().field(HrTables.HR_SALARY.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_SALARY_TPL.CODE).search().fuzzySearch();
        cfg.view().field(HrTables.HR_SALARY_TPL.NAME).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_SALARY_TPL.CODE,
                        HrTables.HR_SALARY_TPL.NAME,
                }
        );

        cfg.view().list().disableBatchDelete();
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(HrTables.HR_SALARY_TPL.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_TPL.UPDATE_TIME).form().table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_TPL.METHOD).form().table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_TPL.METHOD).form().table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_TPL.METHOD_SCRIPT).form().table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_TPL.CODE).form().validate().required();
        cfg.view().field(HrTables.HR_SALARY_TPL.NAME).form().validate().required();
        cfg.view().field(HrTables.HR_SALARY_TPL.METHOD_SCRIPT).form().textArea().height(350);
        cfg.view().field(HrTables.HR_SALARY_TPL.NOTES).form().textArea().height(80);
        cfg.view().list().operationColumn().addActionButton("计算规则","rule","salary-rule");
        cfg.view().list().operationColumn().addActionButton("人员","detail","person-detail");
        //cfg.view().list().operationColumn().addActionButton("计算方式","salaryConfig","salary-config");



        cfg.view().formWindow().width("90%");;
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_SALARY_TPL.CODE,
                        HrTables.HR_SALARY_TPL.NAME,
                        HrTables.HR_SALARY_TPL.START_M_DAY,
                        HrTables.HR_SALARY_TPL.END_M_DAY,
                        HrTables.HR_SALARY_TPL.NOTES,
                }
        );

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
        SalalyTplGtr g=new SalalyTplGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
      // g.generateMenu(SalaryTplServiceProxy.class, SalaryTplPageController.class);
    }
}
