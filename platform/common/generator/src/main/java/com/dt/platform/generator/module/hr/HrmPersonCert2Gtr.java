package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.hr.ApprovalStatusEnum;

import com.dt.platform.domain.hr.Person;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;


public class HrmPersonCert2Gtr extends BaseCodeGenerator {
    public HrmPersonCert2Gtr() {
        super(HrTables.HR_PERSON_CERTIFICATE.$TABLE,"766183428553965568");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"person","person","person");
        cfg.getPoClassFile().addSimpleProperty(Person.class,"user","user","user");
        cfg.getPoClassFile().addSimpleProperty(String.class,"role","role","role");

        cfg.view().field(HrTables.HR_PERSON_CERTIFICATE.ID).basic().hidden(true);

        cfg.view().search().disable();



        cfg.view().search().rowsDisplay(1);
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(HrTables.HR_PERSON_CERTIFICATE.EMPLOYEE_ID).table().fillBy("person","name");
        cfg.view().field(HrTables.HR_PERSON_CERTIFICATE.GET_TIME).form().dateInput().type(DatePickerType.date).format("yyyy-mm-dd");
        cfg.view().field(HrTables.HR_PERSON_CERTIFICATE.NAME).form().validate().required();
        cfg.view().field(HrTables.HR_PERSON_CERTIFICATE.NOTES).form().textArea().height(80);
        cfg.view().field(HrTables.HR_PERSON_CERTIFICATE.STATUS).form().radioBox().enumType(ApprovalStatusEnum.class);

        cfg.view().field(HrTables.HR_PERSON_CERTIFICATE.FILE_IDS).form().upload().buttonLabel("附件").acceptAllType().maxFileCount(1);

        cfg.view().field(HrTables.HR_PERSON_CERTIFICATE.EMPLOYEE_ID).table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_CERTIFICATE.CREATE_TIME).table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_CERTIFICATE.UPDATE_TIME).table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_CERTIFICATE.UPDATE_BY).table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_CERTIFICATE.CREATE_BY).table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_CERTIFICATE.REL_ID).table().disable(true);

        cfg.view().field(HrTables.HR_PERSON_CERTIFICATE.EMPLOYEE_ID).table().disable(true);

        cfg.view().field(HrTables.HR_PERSON_CERTIFICATE.PERSON_ID).table().fillBy("user","name");


        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width("65%");;
        cfg.view().formWindow().bottomSpace(120);
        cfg.view().form().addGroup(null,
                new Object[]{
                        HrTables.HR_PERSON_CERTIFICATE.NAME,
                },
                new Object[]{
                        HrTables.HR_PERSON_CERTIFICATE.GET_TIME
                }
        );
        cfg.view().form().addGroup(null,
                new Object[]{
                        HrTables.HR_PERSON_CERTIFICATE.NOTES,
                        HrTables.HR_PERSON_CERTIFICATE.FILE_IDS,
                }
        );

        cfg.view().list().addJsVariable("MODIFY_PERM","[[${modifyPerm}]]","modifyPerm");
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
        HrmPersonCert2Gtr g=new HrmPersonCert2Gtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
        //
        // g.generateMenu(PersonCertificateServiceProxy.class, PersonCertificatePageController.class);
    }
}
