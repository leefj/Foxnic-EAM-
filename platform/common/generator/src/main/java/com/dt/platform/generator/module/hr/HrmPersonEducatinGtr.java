package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.hr.ApprovalStatusEnum;
import com.dt.platform.domain.hr.Person;
import com.dt.platform.domain.hr.PersonEducation;
import com.dt.platform.domain.hr.meta.PersonEducationMeta;
import com.dt.platform.domain.hr.meta.PersonSocialRelationMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.PersonEducationPageController;
import com.dt.platform.proxy.hr.PersonEducationServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;


public class HrmPersonEducatinGtr extends BaseCodeGenerator {
    public HrmPersonEducatinGtr() {
        super(HrTables.HR_PERSON_EDUCATION.$TABLE,"766183428553965568");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"person","person","person");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"educationInfo","educationInfo","educationInfo");
        cfg.getPoClassFile().addSimpleProperty(Person.class,"user","user","user");
        cfg.getPoClassFile().addSimpleProperty(String.class,"role","role","role");


        cfg.view().field(HrTables.HR_PERSON_EDUCATION.ID).basic().hidden(true);

        cfg.view().search().disable();



        cfg.view().search().rowsDisplay(1);
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(HrTables.HR_PERSON_EDUCATION.EMPLOYEE_ID).table().fillBy("person","name");
        cfg.view().field(HrTables.HR_PERSON_EDUCATION.S_TIME).form().validate().required().form().dateInput().type(DatePickerType.date).format("yyyy-mm-dd");
        cfg.view().field(HrTables.HR_PERSON_EDUCATION.E_TIME).form().dateInput().type(DatePickerType.date).format("yyyy-mm-dd");

        cfg.view().field(HrTables.HR_PERSON_EDUCATION.STATUS).form().radioBox().enumType(ApprovalStatusEnum.class);
        cfg.view().field(HrTables.HR_PERSON_EDUCATION.FILE_IDS).form().upload().buttonLabel("附件").acceptAllType().maxFileCount(1);


        cfg.view().field(HrTables.HR_PERSON_EDUCATION.EMPLOYEE_ID).table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_EDUCATION.CREATE_TIME).table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_EDUCATION.UPDATE_TIME).table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_EDUCATION.UPDATE_BY).table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_EDUCATION.CREATE_BY).table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_EDUCATION.REL_ID).table().disable(true);
        //cfg.view().field(HrTables.HR_PERSON_EDUCATION.PERSON_ID).table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_EDUCATION.EMPLOYEE_ID).table().disable(true);

        cfg.view().field(HrTables.HR_PERSON_EDUCATION.EDUCATIONAL_INSTITUTIONS).form().validate().required();
        cfg.view().field(HrTables.HR_PERSON_EDUCATION.MAJOY_STUDIED).form().validate().required();

        cfg.view().field(HrTables.HR_PERSON_EDUCATION.PERSON_ID).table().fillBy("user","name");
        cfg.view().field(HrTables.HR_PERSON_EDUCATION.EDUCATION)
                .basic().label("学历")
                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=hr_person_education")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(PersonEducationMeta.EDUCATION_INFO).muliti(false);


        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width("80%");;
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[]{
                        HrTables.HR_PERSON_EDUCATION.EDUCATIONAL_INSTITUTIONS,
                        HrTables.HR_PERSON_EDUCATION.MAJOY_STUDIED,
                        HrTables.HR_PERSON_EDUCATION.EDUCATION,

                },
                new Object[]{
                        HrTables.HR_PERSON_EDUCATION.S_TIME,
                        HrTables.HR_PERSON_EDUCATION.E_TIME,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[]{
                        HrTables.HR_PERSON_EDUCATION.NOTES,
                        HrTables.HR_PERSON_EDUCATION.FILE_IDS,
                }
        );

        cfg.view().list().addJsVariable("MODIFY_PERM","[[${modifyPerm}]]","是否可以修改");

        //文件生成覆盖模式
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
        HrmPersonEducatinGtr g=new HrmPersonEducatinGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
        //
        // g.generateMenu(PersonEducationServiceProxy.class, PersonEducationPageController.class);
    }
}
