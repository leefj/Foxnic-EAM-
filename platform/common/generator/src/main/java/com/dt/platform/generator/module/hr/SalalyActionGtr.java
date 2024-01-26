package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.hr.SalaryActionLabelEnum;
import com.dt.platform.constants.enums.hr.SalaryActionStatusEnum;
import com.dt.platform.domain.hr.Person;
import com.dt.platform.domain.hr.SalaryDetail;
import com.dt.platform.domain.hr.SalaryMonth;
import com.dt.platform.domain.hr.SalaryTpl;
import com.dt.platform.domain.hr.meta.SalaryActionMeta;
import com.dt.platform.domain.hr.meta.SalaryMonthMeta;
import com.dt.platform.domain.hr.meta.SalaryTplMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.hr.SalaryMonthServiceProxy;
import com.dt.platform.proxy.hr.SalaryTplServiceProxy;
import com.github.foxnic.generator.config.WriteMode;


public class SalalyActionGtr extends BaseCodeGenerator {
    public SalalyActionGtr() {
        super(HrTables.HR_SALARY_ACTION.$TABLE,"662315275764367360");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addListProperty(SalaryDetail.class,"SalaryDetailList","SalaryDetailList","SalaryDetailList");


        cfg.getPoClassFile().addSimpleProperty(SalaryTpl.class,"salaryTpl","salaryTpl","salaryTpl");
        cfg.getPoClassFile().addSimpleProperty(SalaryMonth.class,"salaryMonth","salaryMonth","salaryMonth");
        cfg.getPoClassFile().addListProperty(Person.class,"personList","personList","personList");


        cfg.view().field(HrTables.HR_SALARY.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_SALARY_ACTION.STATUS).search().fuzzySearch();
        cfg.view().field(HrTables.HR_SALARY_ACTION.NAME).search().fuzzySearch();
        cfg.view().field(HrTables.HR_SALARY_ACTION.ACTION_MONTH).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_SALARY_ACTION.STATUS,
                        HrTables.HR_SALARY_ACTION.TPL_ID,
                        HrTables.HR_SALARY_ACTION.ACTION_MONTH,
                        HrTables.HR_SALARY_ACTION.NAME,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);







        cfg.view().field(HrTables.HR_SALARY_ACTION.STATUS).form().radioBox().enumType(SalaryActionStatusEnum.class);
        cfg.view().field(HrTables.HR_SALARY_ACTION.LABEL).form().radioBox().enumType(SalaryActionLabelEnum.class).defaultIndex(0);
        cfg.view().field(HrTables.HR_SALARY_ACTION.NAME).form().validate().required();
        cfg.view().field(HrTables.HR_SALARY_ACTION.NOTES).form().textArea().height(150);




        cfg.view().field(HrTables.HR_SALARY_ACTION.TPL_ID)
                .form().validate().required().form().selectBox().queryApi(SalaryTplServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(SalaryTplMeta.ID).
                textField(SalaryTplMeta.NAME).
                fillWith(SalaryActionMeta.SALARY_TPL).muliti(false).defaultIndex(0);

        cfg.view().field(HrTables.HR_SALARY_ACTION.ACTION_MONTH)
                .form().validate().required().form().selectBox().queryApi(SalaryMonthServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(SalaryMonthMeta.CODE).
                textField(SalaryMonthMeta.NAME).
                fillWith(SalaryActionMeta.SALARY_MONTH).muliti(false).defaultIndex(0);


        cfg.view().formWindow().width("65%");;
        cfg.view().formWindow().bottomSpace(50);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_SALARY_ACTION.NAME,
                        HrTables.HR_SALARY_ACTION.LABEL,
                        HrTables.HR_SALARY_ACTION.TPL_ID,
                        HrTables.HR_SALARY_ACTION.ACTION_MONTH,
                        HrTables.HR_SALARY_ACTION.NOTES,
                }
        );

        cfg.view().list().disableBatchDelete();
        cfg.view().list().operationColumn().addActionButton("生成数据","createData","create-data","hr_salary_action:data");
        cfg.view().list().operationColumn().addActionButton("员工","detail","person-detail","hr_salary_action:detail");
        cfg.view().list().operationColumn().addActionButton("薪酬列表","salaryDetail","person-salary-detail","hr_salary_action:salary");


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
        SalalyActionGtr g=new SalalyActionGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
     //   g.generateMenu(SalaryActionServiceProxy.class, SalaryActionPageController.class);
    }
}
