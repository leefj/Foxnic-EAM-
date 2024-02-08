package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.domain.hr.Person;
import com.dt.platform.domain.hr.SalaryProjectCommission;
import com.dt.platform.domain.hr.SalaryProjectTime;
import com.dt.platform.domain.hr.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.SalaryProjectTimeRcdPageController;
import com.dt.platform.proxy.hr.PersonServiceProxy;
import com.dt.platform.proxy.hr.SalaryProjectCommissionServiceProxy;
import com.dt.platform.proxy.hr.SalaryProjectTimeRcdServiceProxy;
import com.dt.platform.proxy.hr.SalaryProjectTimeServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;


public class SalalyProjectTimeRcdGtr extends BaseCodeGenerator {
    public SalalyProjectTimeRcdGtr() {
        super(HrTables.HR_SALARY_PROJECT_TIME_RCD.$TABLE,"802993642565271552");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(SalaryProjectTime.class,"project","project","project");
        cfg.getPoClassFile().addSimpleProperty(Person.class,"person","person","person");
        cfg.getPoClassFile().addSimpleProperty(String.class,"projectCodeValue","projectCodeValue","projectCodeValue");


        cfg.view().field(HrTables.HR_SALARY_PROJECT_TIME_RCD.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_SALARY_PROJECT_TIME_RCD.PROJECT_CODE).search().fuzzySearch();
        cfg.view().field(HrTables.HR_SALARY_PROJECT_TIME_RCD.JOB_NUMBER).search().fuzzySearch();
        cfg.view().field(HrTables.HR_SALARY_PROJECT_TIME_RCD.PROJECT_NAME).search().fuzzySearch();
        cfg.view().field(HrTables.HR_SALARY_PROJECT_TIME_RCD.NOTES).search().fuzzySearch();
        cfg.view().field(HrTables.HR_SALARY_PROJECT_TIME_RCD.RCD_DATE).search().range(true);
        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_SALARY_PROJECT_TIME_RCD.PERSON_ID,
                        HrTables.HR_SALARY_PROJECT_TIME_RCD.JOB_NUMBER,
                        HrTables.HR_SALARY_PROJECT_TIME_RCD.BATCH_CODE,
                        HrTables.HR_SALARY_PROJECT_TIME_RCD.NOTES,
                },
                new Object[]{
                        HrTables.HR_SALARY_PROJECT_TIME_RCD.PROJECT_CODE,
                        HrTables.HR_SALARY_PROJECT_TIME_RCD.PROJECT_NAME,
                        HrTables.HR_SALARY_PROJECT_TIME_RCD.RCD_DATE,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);



        cfg.view().field(HrTables.HR_SALARY_PROJECT_TIME_RCD.FINISH_HOUR).form().validate().required().form().validate().required().form().numberInput().decimal().scale(2).defaultValue(0.00);
        cfg.view().field(HrTables.HR_SALARY_PROJECT_TIME_RCD.TOTAL_PRICE).form().validate().required().form().validate().required().form().numberInput().decimal().scale(2).defaultValue(0.00);

        cfg.view().field(HrTables.HR_SALARY_PROJECT_TIME_RCD.FILE_IDS).form().upload().maxFileCount(3);
        cfg.view().field(HrTables.HR_SALARY_PROJECT_TIME_RCD.NOTES).form().textArea().height(120);


        cfg.view().field(HrTables.HR_SALARY_PROJECT_TIME_RCD.RCD_DATE).form().validate().required().form().dateInput().type(DatePickerType.date).format("yyyy-MM-dd");

        cfg.view().field(HrTables.HR_SALARY_PROJECT_TIME_RCD.JOB_NUMBER).form().readOnly();
        cfg.view().field(HrTables.HR_SALARY_PROJECT_TIME_RCD.PROJECT_NAME).form().readOnly();
        cfg.view().field(HrTables.HR_SALARY_PROJECT_TIME_RCD.PROJECT_UNIT_PRICE).form().readOnly();

        cfg.view().list().disableBatchDelete();

        cfg.view().field(HrTables.HR_SALARY_PROJECT_TIME_RCD.CREATE_TIME).table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_PROJECT_TIME_RCD.CREATE_BY).table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_PROJECT_TIME_RCD.UPDATE_BY).table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_PROJECT_TIME_RCD.UPDATE_TIME).table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_PROJECT_TIME_RCD.FILE_IDS).table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_PROJECT_TIME_RCD.PROJECT_CODE).table().disable(true);
        cfg.view().field(SalaryProjectTimeRcdMeta.PROJECT_CODE_VALUE).table().disable(false);
        cfg.view().field(SalaryProjectTimeRcdMeta.PROJECT_CODE_VALUE).basic().label("项目编码").table().fillBy("project","code");


        cfg.view().field(HrTables.HR_SALARY_PROJECT_TIME_RCD.PROJECT_CODE)
                .form().validate().required().form().selectBox().queryApi(SalaryProjectTimeServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(SalaryProjectTimeMeta.CODE).
                textField(SalaryProjectTimeMeta.NAME).
                fillWith(SalaryProjectTimeRcdMeta.PROJECT).muliti(false);



        cfg.view().field(HrTables.HR_SALARY_PROJECT_TIME_RCD.PERSON_ID)
                .form().validate().required().form().selectBox().queryApi(PersonServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(PersonMeta.ID).
                textField(PersonMeta.NAME).
                fillWith(SalaryProjectTimeRcdMeta.PERSON).muliti(false);



        cfg.view().formWindow().width("80%");;
        cfg.view().formWindow().bottomSpace(60);
        cfg.view().form().addGroup("员工信息",
                new Object[] {
                        HrTables.HR_SALARY_PROJECT_TIME_RCD.PERSON_ID,
                },
                new Object[] {
                        HrTables.HR_SALARY_PROJECT_TIME_RCD.JOB_NUMBER,
                }
        );
        cfg.view().form().addGroup("计时提成",
                new Object[] {
                        HrTables.HR_SALARY_PROJECT_TIME_RCD.PROJECT_CODE,
                        HrTables.HR_SALARY_PROJECT_TIME_RCD.PROJECT_UNIT_PRICE,
                        HrTables.HR_SALARY_PROJECT_TIME_RCD.TOTAL_PRICE
                },
                new Object[] {
                        HrTables.HR_SALARY_PROJECT_TIME_RCD.PROJECT_NAME,
                        HrTables.HR_SALARY_PROJECT_TIME_RCD.FINISH_HOUR,
                        HrTables.HR_SALARY_PROJECT_TIME_RCD.RCD_DATE,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_SALARY_PROJECT_TIME_RCD.BATCH_CODE,
                        HrTables.HR_SALARY_PROJECT_TIME_RCD.NOTES,
                        HrTables.HR_SALARY_PROJECT_TIME_RCD.FILE_IDS,
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
        SalalyProjectTimeRcdGtr g=new SalalyProjectTimeRcdGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
        //
      //   g.generateMenu(SalaryProjectTimeRcdServiceProxy.class, SalaryProjectTimeRcdPageController.class);
    }
}
