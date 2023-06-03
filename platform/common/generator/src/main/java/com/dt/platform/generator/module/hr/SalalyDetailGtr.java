package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.common.StatusYNEnum;
import com.dt.platform.constants.enums.common.ValidStatusEnum;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.SalaryDetailPageController;
import com.dt.platform.hr.page.SalaryPageController;
import com.dt.platform.proxy.hr.SalaryDetailServiceProxy;
import com.dt.platform.proxy.hr.SalaryServiceProxy;
import com.github.foxnic.generator.config.WriteMode;


public class SalalyDetailGtr extends BaseCodeGenerator {
    public SalalyDetailGtr() {
        super(HrTables.HR_SALARY_DETAIL.$TABLE,"662315275764367360");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(HrTables.HR_SALARY_DETAIL.ID).basic().hidden(true);
        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_SALARY_DETAIL.PERSON_ID,
                        HrTables.HR_SALARY_DETAIL.ACTION_MONTH,
                        HrTables.HR_SALARY_DETAIL.STATUS,
                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().search().rowsDisplay(1);
        cfg.view().formWindow().width("80%");;
        cfg.view().formWindow().bottomSpace(80);


        cfg.view().field(HrTables.HR_SALARY_DETAIL.STATUS).form().radioBox().enumType(ValidStatusEnum.class).defaultIndex(0);




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


        cfg.view().field(HrTables.HR_SALARY_DETAIL.DEDUCT_GH).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.DEDUCT_KQ).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.DEDUCT_OTHER).form().numberInput().decimal().defaultValue(0.00).scale(2);


        cfg.view().field(HrTables.HR_SALARY_DETAIL.INDIVIDUAL_TAX).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.TOTAL_AMOUNT).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.PAY_AMOUNT).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.ISSUED_AMOUNT).form().numberInput().decimal().defaultValue(0.00).scale(2);


        cfg.view().field(HrTables.HR_SALARY_DETAIL.PT_DKJS).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.PT_GRSDS).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY_DETAIL.PT_SL_PCT).form().numberInput().decimal().defaultValue(0.00).scale(2);

        cfg.view().form().addGroup("人员信息",
                new Object[] {
                        HrTables.HR_SALARY_DETAIL.PERSON_ID,
                        HrTables.HR_SALARY_DETAIL.ACTION_MONTH,
                },
                new Object[]{
                        HrTables.HR_SALARY_DETAIL.EFFECT_TIME,
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
                },
                new Object[]{
                        HrTables.HR_SALARY_DETAIL.WELFARE_ZFGJJ_PERSON,
                        HrTables.HR_SALARY_DETAIL.WELFAER_YRBX_PERSON,
                        HrTables.HR_SALARY_DETAIL.WELFAER_GSBX_PERSON,
                        HrTables.HR_SALARY_DETAIL.WELFAER_YLBX_PERSON,
                        HrTables.HR_SALARY_DETAIL.WELFAER_SYBX_PERSON,
                },
                new Object[]{
                        HrTables.HR_SALARY_DETAIL.WELFARE_ZFGJJ_COMPANY,
                        HrTables.HR_SALARY_DETAIL.WELFAER_YRBX_COMPANY,
                        HrTables.HR_SALARY_DETAIL.WELFAER_GSBX_COMPANY,
                        HrTables.HR_SALARY_DETAIL.WELFAER_YLBX_COMPANY,
                        HrTables.HR_SALARY_DETAIL.WELFAER_SYBX_COMPANY
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
