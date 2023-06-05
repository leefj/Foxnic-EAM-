package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.common.StatusYNEnum;
import com.dt.platform.constants.enums.common.ValidStatusEnum;
import com.dt.platform.domain.hr.Person;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.SalaryPageController;
import com.dt.platform.hr.page.SalaryTplPersonPageController;
import com.dt.platform.proxy.hr.SalaryServiceProxy;
import com.dt.platform.proxy.hr.SalaryTplPersonServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;


public class SalalyPersonGtr extends BaseCodeGenerator {
    public SalalyPersonGtr() {
        super(HrTables.HR_SALARY.$TABLE,"662315275764367360");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(HrTables.HR_SALARY.ID).basic().hidden(true);

        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_SALARY.PERSON_ID,
                }
        );

        cfg.getPoClassFile().addSimpleProperty(Person.class,"person","person","person");

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

     //   cfg.view().field(HrTables.HR_SALARY.STATUS).form().validate().required().form().radioBox().enumType(StatusYNEnum.class).defaultIndex(0);


        cfg.view().field(HrTables.HR_SALARY.WELFARE_ZFGJJ_BASE).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.WELFAER_YRBX_BASE).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.WELFAER_GSBX_BASE).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.WELFAER_YLBX_BASE).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.WELFAER_SYBX_BASE).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.WELFARE_ZFGJJ_PERSON).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.WELFAER_YRBX_PERSON).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.WELFAER_GSBX_PERSON).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.WELFAER_YLBX_PERSON).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.WELFAER_SYBX_PERSON).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.WELFARE_ZFGJJ_COMPANY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.WELFAER_YRBX_COMPANY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.WELFAER_GSBX_COMPANY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.WELFAER_YLBX_COMPANY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.WELFAER_SYBX_COMPANY).form().numberInput().decimal().defaultValue(0.00).scale(2);

        cfg.view().field(HrTables.HR_SALARY.WELFAER_SYEBX_COMPANY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.WELFAER_SYEBX_BASE).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.WELFAER_SYEBX_PERSON).form().numberInput().decimal().defaultValue(0.00).scale(2);

        cfg.view().field(HrTables.HR_SALARY.FIXED_SALARY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.COMMUNICATION_SALARY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.HOUSING_SALARY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.ACHIEVEMENT_SALARY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.TRAFFIC_SALARY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.COMMISSION_SALARY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.OVERTIME_SALARY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.HIGH_TEMPERATURE_SALARY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.OTHER_SALARY).form().numberInput().decimal().defaultValue(0.00).scale(2);


        cfg.view().field(HrTables.HR_SALARY.BASE_SALARY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.POST_SALARY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.WORKING_YEARS_SALARY).form().numberInput().decimal().defaultValue(0.00).scale(2);

        cfg.view().field(HrTables.HR_SALARY.PERSONAL_TAX_DBYL).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.PERSONAL_TAX_ERZH).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.PERSONAL_TAX_JXJY).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.PERSONAL_TAX_SYLR).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.PERSONAL_TAX_ZFDK).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.PERSONAL_TAX_ZFZJ).form().numberInput().decimal().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_SALARY.PERSONAL_TAX_ZNJY).form().numberInput().decimal().defaultValue(0.00).scale(2);


        cfg.view().field(HrTables.HR_SALARY.HIGH_TEMPERATURE_SALARY).table().disable(true);

        cfg.view().field(HrTables.HR_SALARY.PERSON_ID).table().fillBy("person","name");
        cfg.view().field(HrTables.HR_SALARY.PERSON_ID).form()
                .button().chooseEmployee(true);

        cfg.view().search().rowsDisplay(1);
        cfg.view().formWindow().width("80%");;
        cfg.view().formWindow().bottomSpace(80);
//        cfg.view().form().addGroup("人员信息",
//                new Object[] {
//                        HrTables.HR_SALARY.PERSON_ID,
//                }
//                //,
////                new Object[]{
////                  //      HrTables.HR_SALARY.STATUS,
////                }
//        );

        cfg.view().form().addGroup("基本工资",
                new Object[] {
                        HrTables.HR_SALARY.BASE_SALARY
                },
                new Object[]{
                        HrTables.HR_SALARY.POST_SALARY
                },
                new Object[]{
                        HrTables.HR_SALARY.WORKING_YEARS_SALARY
                }
        );

        cfg.view().form().addGroup("各类补贴",
                new Object[] {
                        HrTables.HR_SALARY.FIXED_SALARY,
                        HrTables.HR_SALARY.COMMUNICATION_SALARY,
                        HrTables.HR_SALARY.HOUSING_SALARY
                },
                new Object[]{
                        HrTables.HR_SALARY.ACHIEVEMENT_SALARY,
                        HrTables.HR_SALARY.TRAFFIC_SALARY,
                        HrTables.HR_SALARY.COMMISSION_SALARY
                },
                new Object[]{
                        HrTables.HR_SALARY.OVERTIME_SALARY,
                        HrTables.HR_SALARY.OTHER_SALARY,
                }
        );

        cfg.view().form().addGroup("福利基数",
                new Object[] {
                        HrTables.HR_SALARY.WELFARE_ZFGJJ_BASE,
                        HrTables.HR_SALARY.WELFAER_YRBX_BASE,
                        HrTables.HR_SALARY.WELFAER_GSBX_BASE,
                        HrTables.HR_SALARY.WELFAER_YLBX_BASE,
                        HrTables.HR_SALARY.WELFAER_SYBX_BASE,
                        HrTables.HR_SALARY.WELFAER_SYEBX_BASE,
                },
                new Object[]{
                        HrTables.HR_SALARY.WELFARE_ZFGJJ_PERSON,
                        HrTables.HR_SALARY.WELFAER_YRBX_PERSON,
                        HrTables.HR_SALARY.WELFAER_GSBX_PERSON,
                        HrTables.HR_SALARY.WELFAER_YLBX_PERSON,
                        HrTables.HR_SALARY.WELFAER_SYBX_PERSON,
                        HrTables.HR_SALARY.WELFAER_SYEBX_PERSON,
                },
                new Object[]{
                        HrTables.HR_SALARY.WELFARE_ZFGJJ_COMPANY,
                        HrTables.HR_SALARY.WELFAER_YRBX_COMPANY,
                        HrTables.HR_SALARY.WELFAER_GSBX_COMPANY,
                        HrTables.HR_SALARY.WELFAER_YLBX_COMPANY,
                        HrTables.HR_SALARY.WELFAER_SYBX_COMPANY,
                        HrTables.HR_SALARY.WELFAER_SYEBX_COMPANY
                }
        );



        cfg.view().form().addGroup("个税减免",
                new Object[] {
                        HrTables.HR_SALARY.PERSONAL_TAX_DBYL,
                        HrTables.HR_SALARY.PERSONAL_TAX_ERZH,
                        HrTables.HR_SALARY.PERSONAL_TAX_JXJY,
                },
                new Object[]{
                        HrTables.HR_SALARY.PERSONAL_TAX_SYLR,
                        HrTables.HR_SALARY.PERSONAL_TAX_ZFDK,
                },
                new Object[]{
                        HrTables.HR_SALARY.PERSONAL_TAX_ZFZJ,
                        HrTables.HR_SALARY.PERSONAL_TAX_ZNJY,
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
        SalalyPersonGtr g=new SalalyPersonGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
     //  g.generateMenu(SalaryServiceProxy.class, SalaryPageController.class);
    }
}
