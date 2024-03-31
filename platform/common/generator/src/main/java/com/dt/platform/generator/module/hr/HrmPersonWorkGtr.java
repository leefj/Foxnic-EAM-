package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.hr.ApprovalStatusEnum;
import com.dt.platform.domain.hr.Person;
import com.dt.platform.domain.hr.PersonWorkExperience;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.PersonWorkExperiencePageController;
import com.dt.platform.proxy.hr.PersonWorkExperienceServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;


public class HrmPersonWorkGtr extends BaseCodeGenerator {
    public HrmPersonWorkGtr() {
        super(HrTables.HR_PERSON_WORK_EXPERIENCE.$TABLE,"766183428553965568");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"person","person","person");
        cfg.getPoClassFile().addSimpleProperty(Person.class,"user","user","user");
        cfg.view().field(HrTables.HR_PERSON_WORK_EXPERIENCE.ID).basic().hidden(true);
        cfg.getPoClassFile().addSimpleProperty(String.class,"role","role","role");
        cfg.view().search().disable();

        cfg.view().search().rowsDisplay(1);
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(HrTables.HR_PERSON_WORK_EXPERIENCE.EMPLOYEE_ID).table().fillBy("person","name");


        cfg.view().field(HrTables.HR_PERSON_WORK_EXPERIENCE.S_TIME).form().validate().required().form().dateInput().type(DatePickerType.date).format("yyyy-MM-dd");
        cfg.view().field(HrTables.HR_PERSON_WORK_EXPERIENCE.E_TIME).form().dateInput().type(DatePickerType.date).format("yyyy-MM-dd");
        cfg.view().field(HrTables.HR_PERSON_WORK_EXPERIENCE.NAME).form().validate().required();
        cfg.view().field(HrTables.HR_PERSON_WORK_EXPERIENCE.POST).form().validate().required();
        cfg.view().field(HrTables.HR_PERSON_WORK_EXPERIENCE.STATUS).form().radioBox().enumType(ApprovalStatusEnum.class);
        cfg.view().field(HrTables.HR_PERSON_WORK_EXPERIENCE.WORK_CONTENT).form().validate().required().form().textArea().height(120);

        cfg.view().field(HrTables.HR_PERSON_WORK_EXPERIENCE.EMPLOYEE_ID).table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_WORK_EXPERIENCE.CREATE_TIME).table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_WORK_EXPERIENCE.UPDATE_TIME).table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_WORK_EXPERIENCE.UPDATE_BY).table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_WORK_EXPERIENCE.CREATE_BY).table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_WORK_EXPERIENCE.REL_ID).table().disable(true);
      //  cfg.view().field(HrTables.HR_PERSON_WORK_EXPERIENCE.PERSON_ID).table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_WORK_EXPERIENCE.EMPLOYEE_ID).table().disable(true);

        cfg.view().field(HrTables.HR_PERSON_WORK_EXPERIENCE.PERSON_ID).table().fillBy("user","name");
        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width("65%");;
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup(null,
                new Object[]{
                        HrTables.HR_PERSON_WORK_EXPERIENCE.NAME,
                        HrTables.HR_PERSON_WORK_EXPERIENCE.POST,
                },
                new Object[]{
                        HrTables.HR_PERSON_WORK_EXPERIENCE.S_TIME,
                        HrTables.HR_PERSON_WORK_EXPERIENCE.E_TIME,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[]{
                        HrTables.HR_PERSON_WORK_EXPERIENCE.WORK_CONTENT,
                }
        );

        cfg.view().list().addJsVariable("MODIFY_PERM","[[${modifyPerm}]]","是否可以修改");



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
        HrmPersonWorkGtr g=new HrmPersonWorkGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
        //
         //g.generateMenu(PersonWorkExperienceServiceProxy.class, PersonWorkExperiencePageController.class);
    }
}
