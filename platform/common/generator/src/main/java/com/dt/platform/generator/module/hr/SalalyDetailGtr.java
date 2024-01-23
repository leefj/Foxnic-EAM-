package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.common.StatusYNEnum;
import com.dt.platform.constants.enums.common.ValidStatusEnum;
import com.dt.platform.constants.enums.hr.SalaryPersonDetailStatusEnum;
import com.dt.platform.domain.hr.Person;
import com.dt.platform.domain.hr.SalaryAction;
import com.dt.platform.domain.hr.SalaryDetail;
import com.dt.platform.domain.hr.SalaryTpl;
import com.dt.platform.domain.hr.meta.PersonMeta;
import com.dt.platform.domain.hr.meta.SalaryDetailMeta;
import com.dt.platform.domain.hr.meta.SalaryMeta;
import com.dt.platform.domain.hr.meta.SalaryTplMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.SalaryDetailPageController;
import com.dt.platform.hr.page.SalaryPageController;
import com.dt.platform.proxy.hr.*;
import com.github.foxnic.generator.config.WriteMode;


public class SalalyDetailGtr extends BaseCodeGenerator {
    public SalalyDetailGtr() {
        super(HrTables.HR_SALARY_DETAIL.$TABLE,"662315275764367360");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(HrTables.HR_SALARY_DETAIL.ID).basic().hidden(true);

        cfg.view().field(HrTables.HR_SALARY_DETAIL.USER_NAME).search().fuzzySearch();
        cfg.view().field(HrTables.HR_SALARY_DETAIL.JOB_NUMBER).search().fuzzySearch();
        cfg.view().field(HrTables.HR_SALARY_DETAIL.OPER_MSG).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_SALARY_DETAIL.STATUS,
                        HrTables.HR_SALARY_DETAIL.ACTION_MONTH,
                        HrTables.HR_SALARY_DETAIL.USER_NAME,
                        HrTables.HR_SALARY_DETAIL.JOB_NUMBER,
                        HrTables.HR_SALARY_DETAIL.OPER_MSG,
                }
        );
        cfg.getPoClassFile().addSimpleProperty(SalaryTpl.class,"salaryTpl","salaryTpl","salaryTpl");
        cfg.getPoClassFile().addSimpleProperty(SalaryAction.class,"salaryAction","salaryAction","salaryAction");
        cfg.getPoClassFile().addSimpleProperty(String.class,"extBank","extBank","extBank");
        cfg.getPoClassFile().addSimpleProperty(String.class,"extBankAccount","extBankAccount","extBankAccount");
        cfg.getPoClassFile().addSimpleProperty(Person.class,"person","person","person");

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().search().rowsDisplay(1);
        cfg.view().formWindow().width("95%");;
        cfg.view().formWindow().bottomSpace(80);


        cfg.view().field(HrTables.HR_SALARY_DETAIL.WELFARE_ZFGJJ_BASE).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.WELFAER_YRBX_BASE).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.WELFAER_GSBX_BASE).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.WELFAER_YLBX_BASE).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.WELFAER_SYBX_BASE).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.WELFARE_ZFGJJ_PERSON).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.WELFAER_YRBX_PERSON).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.WELFAER_GSBX_PERSON).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.WELFAER_YLBX_PERSON).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.WELFAER_SYBX_PERSON).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.WELFARE_ZFGJJ_COMPANY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.WELFAER_YRBX_COMPANY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.WELFAER_GSBX_COMPANY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.WELFAER_YLBX_COMPANY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.WELFAER_SYBX_COMPANY).form().numberInput().decimal().defaultValue(0.00).scale(2);


        cfg.view().field(HrTables.HR_SALARY_DETAIL.FIXED_SALARY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.COMMUNICATION_SALARY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.HOUSING_SALARY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.ACHIEVEMENT_SALARY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.TRAFFIC_SALARY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.COMMISSION_SALARY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.OVERTIME_SALARY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.HIGH_TEMPERATURE_SALARY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.OTHER_SALARY).form().numberInput().decimal().defaultValue(0.00).scale(2);


        cfg.view().field(HrTables.HR_SALARY_DETAIL.BASE_SALARY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.POST_SALARY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.WORKING_YEARS_SALARY).form().numberInput().decimal().defaultValue(0.00).scale(2);

        cfg.view().field(HrTables.HR_SALARY_DETAIL.PERSONAL_TAX_DBYL).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.PERSONAL_TAX_ERZH).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.PERSONAL_TAX_JXJY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.PERSONAL_TAX_SYLR).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.PERSONAL_TAX_ZFDK).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.PERSONAL_TAX_ZFZJ).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.PERSONAL_TAX_ZNJY).form().numberInput().decimal().defaultValue(0.00).scale(2);

        cfg.view().field(HrTables.HR_SALARY.WELFAER_SYEBX_COMPANY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.WELFAER_SYEBX_BASE).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.WELFAER_SYEBX_PERSON).form().numberInput().decimal().defaultValue(0.00).scale(2);

        cfg.view().field(HrTables.HR_SALARY_DETAIL.DEDUCT_GH).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.DEDUCT_KQ).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.DEDUCT_OTHER).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.DEDUCT_PERSONAL_TAX_RED).form().numberInput().decimal().defaultValue(0.00).scale(2);


        cfg.view().field(HrTables.HR_SALARY_DETAIL.TOTAL_AMOUNT).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.PAY_AMOUNT).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.ISSUED_AMOUNT).form().numberInput().decimal().defaultValue(0.00).scale(2);


        cfg.view().field(HrTables.HR_SALARY_DETAIL.PT_DKJS).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.PT_GRSDS).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.PT_SL_PCT).form().numberInput().decimal().defaultValue(0.00).scale(2);

        cfg.view().field(HrTables.HR_SALARY_DETAIL.ACTION_ID).table().disable(true);;
        cfg.view().field(HrTables.HR_SALARY_DETAIL.TPL_ID).table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.CREATE_TIME).table().disable(false);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.CREATE_BY).table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.UPDATE_BY).table().disable(true);

        cfg.view().field(HrTables.HR_SALARY_DETAIL.PERSON_ID).table().hidden();
        cfg.view().field(HrTables.HR_SALARY_DETAIL.WELFAER_GSBX_BASE).table().hidden();
        cfg.view().field(HrTables.HR_SALARY_DETAIL.WELFAER_SYBX_BASE).table().hidden();
        cfg.view().field(HrTables.HR_SALARY_DETAIL.WELFAER_SYEBX_BASE).table().hidden();
        cfg.view().field(HrTables.HR_SALARY_DETAIL.WELFAER_YLBX_BASE).table().hidden();
        cfg.view().field(HrTables.HR_SALARY_DETAIL.WELFAER_YRBX_BASE).table().hidden();
        cfg.view().field(HrTables.HR_SALARY_DETAIL.WELFARE_ZFGJJ_BASE).table().hidden();

        cfg.view().field(HrTables.HR_SALARY_DETAIL.PERSONAL_TAX_DBYL).table().hidden();
        cfg.view().field(HrTables.HR_SALARY_DETAIL.PERSONAL_TAX_ERZH).table().hidden();
        cfg.view().field(HrTables.HR_SALARY_DETAIL.PERSONAL_TAX_SYLR).table().hidden();
        cfg.view().field(HrTables.HR_SALARY_DETAIL.PERSONAL_TAX_ZFDK).table().hidden();
        cfg.view().field(HrTables.HR_SALARY_DETAIL.PERSONAL_TAX_ZFZJ).table().hidden();
        cfg.view().field(HrTables.HR_SALARY_DETAIL.PERSONAL_TAX_ZNJY).table().hidden();
        cfg.view().field(HrTables.HR_SALARY_DETAIL.PERSONAL_TAX_JXJY).table().hidden();

        cfg.view().field(HrTables.HR_SALARY_DETAIL.USER_NAME).form().readOnly();
        cfg.view().field(HrTables.HR_SALARY_DETAIL.JOB_NUMBER).form().readOnly();
        cfg.view().field(HrTables.HR_SALARY_DETAIL.BANK).form().readOnly();
        cfg.view().field(HrTables.HR_SALARY_DETAIL.BANK_ACCOUNT).form().readOnly();
        cfg.view().field(HrTables.HR_SALARY_DETAIL.EFFECT_TIME).form().readOnly();
        cfg.view().field(HrTables.HR_SALARY_DETAIL.OPER_MSG).form().readOnly();
        cfg.view().field(HrTables.HR_SALARY_DETAIL.STATUS).form().readOnly();
        cfg.view().list().disableCreateNew();
        cfg.getPoClassFile().addSimpleProperty(Person.class,"person","person","person");
        cfg.view().field(HrTables.HR_SALARY_DETAIL.PERSON_ID).table().fillBy("person","name");
        cfg.view().field(HrTables.HR_SALARY_DETAIL.PERSON_ID).form()
                .button().chooseEmployee(true);

        cfg.view().field(HrTables.HR_SALARY_DETAIL.STATUS).form().radioBox().enumType(SalaryPersonDetailStatusEnum.class).defaultIndex(0);

        cfg.view().field(HrTables.HR_SALARY_DETAIL.TPL_ID)
                .form().selectBox().queryApi(SalaryTplServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(SalaryTplMeta.ID).
                textField(SalaryTplMeta.NAME).
                fillWith(SalaryDetailMeta.SALARY_TPL).muliti(false).defaultIndex(0);

        cfg.view().field(HrTables.HR_SALARY_DETAIL.ACTION_ID)
                .form().selectBox().queryApi(SalaryActionServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(SalaryTplMeta.ID).
                textField(SalaryTplMeta.NAME).
                fillWith(SalaryDetailMeta.SALARY_ACTION).muliti(false).defaultIndex(0);


        cfg.view().field(HrTables.HR_SALARY_DETAIL.PERSON_ID)
                .form().selectBox().queryApi(PersonServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(PersonMeta.ID).
                textField(PersonMeta.NAME).
                fillWith(SalaryDetailMeta.PERSON).muliti(false);

        cfg.view().list().excel(true,true);
        cfg.view().form().addGroup("人员信息",
                new Object[] {
                        HrTables.HR_SALARY_DETAIL.USER_NAME,
                        HrTables.HR_SALARY_DETAIL.JOB_NUMBER,
                },
                new Object[]{
                        HrTables.HR_SALARY_DETAIL.BANK,
                        HrTables.HR_SALARY_DETAIL.BANK_ACCOUNT,
                }

        );

        cfg.view().form().addGroup("操作信息",
                new Object[] {
                        HrTables.HR_SALARY_DETAIL.STATUS,
                        HrTables.HR_SALARY_DETAIL.EFFECT_TIME,
                },
                new Object[] {
                        HrTables.HR_SALARY_DETAIL.OPER_MSG,
                },
                new Object[] {
                        HrTables.HR_SALARY_DETAIL.ACTION_MONTH,
                }
        );

        cfg.view().form().addGroup("基本工资",
                new Object[] {
                        HrTables.HR_SALARY_DETAIL.BASE_SALARY
                },
                new Object[]{
                        HrTables.HR_SALARY_DETAIL.POST_SALARY
                },
                new Object[]{
                        HrTables.HR_SALARY_DETAIL.WORKING_YEARS_SALARY
                }
        );

        cfg.view().form().addGroup("各类补贴",
                new Object[] {
                        HrTables.HR_SALARY_DETAIL.FIXED_SALARY,
                        HrTables.HR_SALARY_DETAIL.COMMUNICATION_SALARY,
                        HrTables.HR_SALARY_DETAIL.HOUSING_SALARY
                },
                new Object[]{
                        HrTables.HR_SALARY_DETAIL.ACHIEVEMENT_SALARY,
                        HrTables.HR_SALARY_DETAIL.TRAFFIC_SALARY,
                        HrTables.HR_SALARY_DETAIL.COMMISSION_SALARY
                },
                new Object[]{
                        HrTables.HR_SALARY_DETAIL.OVERTIME_SALARY,
                        HrTables.HR_SALARY_DETAIL.HIGH_TEMPERATURE_SALARY,
                        HrTables.HR_SALARY_DETAIL.OTHER_SALARY,
                }
        );

        cfg.view().form().addGroup("福利基数",
                new Object[] {
                        HrTables.HR_SALARY_DETAIL.WELFARE_ZFGJJ_BASE,
                        HrTables.HR_SALARY_DETAIL.WELFAER_YRBX_BASE,
                        HrTables.HR_SALARY_DETAIL.WELFAER_GSBX_BASE,
                        HrTables.HR_SALARY_DETAIL.WELFAER_YLBX_BASE,
                        HrTables.HR_SALARY_DETAIL.WELFAER_SYBX_BASE,
                        HrTables.HR_SALARY_DETAIL.WELFAER_SYEBX_BASE,
                },
                new Object[]{
                        HrTables.HR_SALARY_DETAIL.WELFARE_ZFGJJ_PERSON,
                        HrTables.HR_SALARY_DETAIL.WELFAER_YRBX_PERSON,
                        HrTables.HR_SALARY_DETAIL.WELFAER_GSBX_PERSON,
                        HrTables.HR_SALARY_DETAIL.WELFAER_YLBX_PERSON,
                        HrTables.HR_SALARY_DETAIL.WELFAER_SYBX_PERSON,
                        HrTables.HR_SALARY_DETAIL.WELFAER_SYEBX_PERSON,
                },
                new Object[]{
                        HrTables.HR_SALARY_DETAIL.WELFARE_ZFGJJ_COMPANY,
                        HrTables.HR_SALARY_DETAIL.WELFAER_YRBX_COMPANY,
                        HrTables.HR_SALARY_DETAIL.WELFAER_GSBX_COMPANY,
                        HrTables.HR_SALARY_DETAIL.WELFAER_YLBX_COMPANY,
                        HrTables.HR_SALARY_DETAIL.WELFAER_SYBX_COMPANY,
                        HrTables.HR_SALARY_DETAIL.WELFAER_SYEBX_COMPANY
                }
        );
        cfg.view().form().addGroup("应扣项目",
                new Object[] {
                        HrTables.HR_SALARY_DETAIL.DEDUCT_KQ,
                },
                new Object[]{
                        HrTables.HR_SALARY_DETAIL.DEDUCT_GH,
                },
                new Object[]{
                        HrTables.HR_SALARY_DETAIL.DEDUCT_OTHER
                },
                new Object[]{
                        HrTables.HR_SALARY_DETAIL.DEDUCT_PERSONAL_TAX_RED
                }
        );
        cfg.view().form().addGroup("个税减免",
                new Object[] {
                        HrTables.HR_SALARY_DETAIL.PERSONAL_TAX_DBYL,
                        HrTables.HR_SALARY_DETAIL.PERSONAL_TAX_ERZH,
                        HrTables.HR_SALARY_DETAIL.PERSONAL_TAX_JXJY,
                },
                new Object[]{
                        HrTables.HR_SALARY_DETAIL.PERSONAL_TAX_SYLR,
                        HrTables.HR_SALARY_DETAIL.PERSONAL_TAX_ZFDK,
                },
                new Object[]{
                        HrTables.HR_SALARY_DETAIL.PERSONAL_TAX_ZFZJ,
                        HrTables.HR_SALARY_DETAIL.PERSONAL_TAX_ZNJY,
                }
        );
        cfg.view().form().addGroup("个人所得税",
                new Object[] {
                        HrTables.HR_SALARY_DETAIL.PT_DKJS,
                },
                new Object[]{
                        HrTables.HR_SALARY_DETAIL.PT_SL_PCT,
                },
                new Object[]{
                        HrTables.HR_SALARY_DETAIL.PT_GRSDS,
                }
        );
        cfg.view().form().addGroup("小计",
                new Object[] {
                        HrTables.HR_SALARY_DETAIL.TOTAL_AMOUNT,
                },
                new Object[]{
                        HrTables.HR_SALARY_DETAIL.PAY_AMOUNT,
                },
                new Object[]{
                        HrTables.HR_SALARY_DETAIL.ISSUED_AMOUNT,
                }
        );

        cfg.view().list().disableBatchDelete();
        cfg.view().list().operationColumn().addActionButton("重置","resetData","person-reset-data","hr_salary_detail:reset");
        cfg.view().list().addToolButton("生效","validData","person-valid-data","hr_salary_detail:valid");
        cfg.view().list().addToolButton("导出","salaryExport","person-export-data");
        cfg.view().list().addToolButton("导入","salaryImport","person-import-data");


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.WRITE_TEMP_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.WRITE_TEMP_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
                .setExtendJsFile(WriteMode.IGNORE);
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        SalalyDetailGtr g=new SalalyDetailGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
       // g.generateMenu(SalaryDetailServiceProxy.class, SalaryDetailPageController.class);
    }
}
