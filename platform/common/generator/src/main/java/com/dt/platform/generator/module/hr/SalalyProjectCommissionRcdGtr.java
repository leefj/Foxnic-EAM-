package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.domain.hr.Person;
import com.dt.platform.domain.hr.SalaryDetail;
import com.dt.platform.domain.hr.SalaryProjectCommission;
import com.dt.platform.domain.hr.SalaryProjectCommissionRcd;
import com.dt.platform.domain.hr.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.SalaryProjectCommissionPageController;
import com.dt.platform.hr.page.SalaryProjectCommissionRcdPageController;
import com.dt.platform.proxy.hr.PersonServiceProxy;
import com.dt.platform.proxy.hr.SalaryActionServiceProxy;
import com.dt.platform.proxy.hr.SalaryProjectCommissionRcdServiceProxy;
import com.dt.platform.proxy.hr.SalaryProjectCommissionServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;


public class SalalyProjectCommissionRcdGtr extends BaseCodeGenerator {
    public SalalyProjectCommissionRcdGtr() {
        super(HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.$TABLE,"662315275764367360");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(SalaryProjectCommission.class,"project","project","project");
        cfg.getPoClassFile().addSimpleProperty(Person.class,"person","person","person");
        cfg.getPoClassFile().addSimpleProperty(String.class,"projectCodeValue","projectCodeValue","projectCodeValue");


        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.PROJECT_CODE).search().fuzzySearch();
        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.JOB_NUMBER).search().fuzzySearch();
        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.PROJECT_NAME).search().fuzzySearch();
        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.NOTES).search().fuzzySearch();
        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.RCD_DATE).search().range(true);
        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.PERSON_ID,
                        HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.JOB_NUMBER,
                        HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.BATCH_CODE,
                        HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.NOTES,
                },
                new Object[]{
                        HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.PROJECT_CODE,
                        HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.PROJECT_NAME,
                        HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.RCD_DATE,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.PROJECT_COMMISSION_RATIO).form().numberInput().decimal().scale(2).defaultValue(0.00);
        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.COMMISSION_SALARY).form().validate().required().form().validate().required().form().numberInput().decimal().scale(2).defaultValue(0.00);
        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.BUSINESS_VALUE).form().validate().required().form().validate().required().form().numberInput().decimal().scale(2).defaultValue(0.00);

        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.FILE_IDS).form().upload().maxFileCount(3);
        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.NOTES).form().textArea().height(120);


        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.RCD_DATE).form().validate().required().form().dateInput().type(DatePickerType.date).format("yyyy-MM-dd");

        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.JOB_NUMBER).form().readOnly();
        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.PROJECT_NAME).form().readOnly();
        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.PROJECT_COMMISSION_RATIO).form().readOnly();

        cfg.view().list().disableBatchDelete();

        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.CREATE_TIME).table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.CREATE_BY).table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.UPDATE_BY).table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.UPDATE_TIME).table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.PROJECT_CODE).table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.FILE_IDS).table().disable(true);
        cfg.view().field(SalaryProjectCommissionRcdMeta.PROJECT_CODE_VALUE).table().disable(false);
        cfg.view().field(SalaryProjectCommissionRcdMeta.PROJECT_CODE_VALUE).basic().label("项目编码").table().fillBy("project","code");

        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.PROJECT_CODE)
                .form().validate().required().form().selectBox().queryApi(SalaryProjectCommissionServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(SalaryProjectCommissionMeta.CODE).
                textField(SalaryProjectCommissionMeta.NAME).
                fillWith(SalaryProjectCommissionRcdMeta.PROJECT).muliti(false);



        cfg.view().field(HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.PERSON_ID)
                .form().validate().required().form().selectBox().queryApi(PersonServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(PersonMeta.ID).
                textField(PersonMeta.NAME).
                fillWith(SalaryProjectCommissionRcdMeta.PERSON).muliti(false);



        cfg.view().formWindow().width("80%");;
        cfg.view().formWindow().bottomSpace(60);
        cfg.view().form().addGroup("员工信息",
                new Object[] {
                        HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.PERSON_ID,
                },
                new Object[] {
                        HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.JOB_NUMBER,
                }
        );
        cfg.view().form().addGroup("提成信息",
                new Object[] {
                        HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.PROJECT_CODE,
                        HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.PROJECT_COMMISSION_RATIO,
                        HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.COMMISSION_SALARY,
                },
                new Object[] {
                        HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.PROJECT_NAME,
                        HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.BUSINESS_VALUE,
                        HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.RCD_DATE,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.BATCH_CODE,
                        HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.NOTES,
                        HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.FILE_IDS,
                }
        );
        cfg.view().list().addToolButton("导入","importData","import-data");
        cfg.view().list().addToolButton("导出","exportData","export-data");

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
        SalalyProjectCommissionRcdGtr g=new SalalyProjectCommissionRcdGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
        //
       //  g.generateMenu(SalaryProjectCommissionRcdServiceProxy.class, SalaryProjectCommissionRcdPageController.class);
    }
}
