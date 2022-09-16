package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.generator.config.Config;


import com.dt.platform.hr.page.PersonPageController;
import com.dt.platform.proxy.hr.PersonServiceProxy;
import com.github.foxnic.generator.config.WriteMode;


public class HrmPersonGtr extends BaseCodeGenerator {
    public HrmPersonGtr() {
        super(HrTables.HR_PERSON.$TABLE,"623153794699493376");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(HrTables.HR_PERSON.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_PERSON.NAME).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_PERSON.JOB_NUMBER,
                        HrTables.HR_PERSON.NAME,
                        HrTables.HR_PERSON.EMPLOYEE_STATUS,

                }

        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().formWindow().width("65%");;
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup("基本信息",
                new Object[] {
                        HrTables.HR_PERSON.JOB_NUMBER,
                        HrTables.HR_PERSON.NAME,
                        HrTables.HR_PERSON.IDENTITY_CARD,
                        HrTables.HR_PERSON.SEX_CODE,
                        HrTables.HR_PERSON.MARITAL_STATUS,
                },
                new Object[] {
                        HrTables.HR_PERSON.EMPLOYEE_TYPE_CODE,
                        HrTables.HR_PERSON.BIRTHDAY,
                        HrTables.HR_PERSON.NATION_CODE,
                        HrTables.HR_PERSON.NATIVE_PLACE_CODE,
                }
        );

        cfg.view().form().addGroup("个人情况",
                new Object[] {
                        HrTables.HR_PERSON.CONTACT_INFORMATION,
                        HrTables.HR_PERSON.EMERGENCY_CONTACT,
                        HrTables.HR_PERSON.HOME_ADDRESS,
                        HrTables.HR_PERSON.EDUCATION_CODE,
                        HrTables.HR_PERSON.FOREIGN_LANGUAGE,
                        HrTables.HR_PERSON.COMPUTER_ABILITY,
                        HrTables.HR_PERSON.POLITIC_COUNTENANCE_CODE,
                        HrTables.HR_PERSON.BLOOD_TYPE,
                        HrTables.HR_PERSON.BODY_WEIGHT,
                },
                new Object[] {
                        HrTables.HR_PERSON.EMAIL,
                        HrTables.HR_PERSON.EMERGENCY_CONTACT_NO,
                        HrTables.HR_PERSON.WEIXIN_ID,
                        HrTables.HR_PERSON.GRADUATION_SCHOOL,
                        HrTables.HR_PERSON.FOREIGN_LANGUAGE_LEVEL,
                        HrTables.HR_PERSON.COMPUTER_LEVEL,
                        HrTables.HR_PERSON.JOIN_PART_DATE,
                        HrTables.HR_PERSON.BODY_HEIGHT,
                }
        );
        cfg.view().form().addGroup("单位信息",
                new Object[] {
                        HrTables.HR_PERSON.EMPLOYMENT_DATE,
                        HrTables.HR_PERSON.EMPLOYMENT_CONFIRM_DATE,
                        HrTables.HR_PERSON.ORG_ID,
                        HrTables.HR_PERSON.POSITION_CODE,
                        HrTables.HR_PERSON.LEAVE_DATE
                },
                new Object[] {
                        HrTables.HR_PERSON.FIRST_EMPLOYMENT_DATE,
                        HrTables.HR_PERSON.FIRST_WORK_DATE,
                        HrTables.HR_PERSON.EMPLOYEE_TITLE_CODE,
                        HrTables.HR_PERSON.RANK_CODE,
                        HrTables.HR_PERSON.LEAVE_RESON
                }
        );

        cfg.view().form().addGroup("工资信息",
                new Object[] {
                        HrTables.HR_PERSON.PAYROLL_CARD_BANK_CODE
                },
                new Object[] {
                        HrTables.HR_PERSON.PAYROLL_CARD
                }
        );
        cfg.view().form().addGroup("其他信息",
                new Object[] {
                        HrTables.HR_PERSON.PERSON_PICTURE_ID,
                        HrTables.HR_PERSON.FILE_ID,
                        HrTables.HR_PERSON.NOTE
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
        HrmPersonGtr g=new HrmPersonGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
     //  g.generateMenu(PersonServiceProxy.class, PersonPageController.class);
    }
}
