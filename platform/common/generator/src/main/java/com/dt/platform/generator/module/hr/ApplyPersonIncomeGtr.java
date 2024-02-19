package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.hr.PersonIncomeCertificateApply;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.api.bpm.IntegrateMode;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Person;


public class ApplyPersonIncomeGtr extends BaseCodeGenerator {
    public ApplyPersonIncomeGtr() {
        super(HrTables.HR_PERSON_INCOME_CERTIFICATE_APPLY.$TABLE,"807235387075330049");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_PERSON_INCOME_CERTIFICATE_APPLY.BUSINESS_CODE).search().fuzzySearch();

        cfg.getPoClassFile().addSimpleProperty(Organization.class,"organization","organization","organization");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"person","person","person");


        cfg.view().field(HrTables.HR_PERSON_INCOME_CERTIFICATE_APPLY.CONFIRM_DATE).form().dateInput().type(DatePickerType.date).format("yyyy-MM-dd").search().range();


        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_PERSON_INCOME_CERTIFICATE_APPLY.STATUS,
                        HrTables.HR_PERSON_INCOME_CERTIFICATE_APPLY.BUSINESS_CODE,
                        HrTables.HR_PERSON_INCOME_CERTIFICATE_APPLY.ORG_ID,
                        HrTables.HR_PERSON_INCOME_CERTIFICATE_APPLY.PERSON_ID,
                }

        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().form().labelWidth(70);


        cfg.view().field(HrTables.HR_PERSON_INCOME_CERTIFICATE_APPLY.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_INCOME_CERTIFICATE_APPLY.CREATE_TIME).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_INCOME_CERTIFICATE_APPLY.FILE_ID).form().table().disable(true);



        cfg.view().field(HrTables.HR_PERSON_INCOME_CERTIFICATE_APPLY.NOTE).form().textArea().height(80);

        cfg.view().field(HrTables.HR_PERSON_INCOME_CERTIFICATE_APPLY.FILE_ID).form().upload().acceptAllType().maxFileCount(1);


        cfg.view().field(HrTables.HR_PERSON_INCOME_CERTIFICATE_APPLY.ORG_ID)
               .form().button().chooseOrganization(true);
        cfg.view().field(HrTables.HR_PERSON_INCOME_CERTIFICATE_APPLY.ORG_ID).table().fillBy("organization","fullName");



        cfg.view().field(HrTables.HR_PERSON_INCOME_CERTIFICATE_APPLY.PERSON_ID).table().fillBy("person","name");
        cfg.view().field(HrTables.HR_PERSON_INCOME_CERTIFICATE_APPLY.PERSON_ID).form()
                .button().chooseEmployee(true);



        cfg.bpm().form("hr_person_income_certificate_apply");
        cfg.bpm().integrate(IntegrateMode.FRONT);


        cfg.view().field(HrTables.HR_PERSON_INCOME_CERTIFICATE_APPLY.STATUS).form()
                .label("办理状态").selectBox().enumType(AssetHandleStatusEnum.class);




        cfg.view().formWindow().width("76%");;
        cfg.view().formWindow().bottomSpace(60);




        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_PERSON_INCOME_CERTIFICATE_APPLY.PERSON_ID,
                        HrTables.HR_PERSON_INCOME_CERTIFICATE_APPLY.CARD,
                        HrTables.HR_PERSON_INCOME_CERTIFICATE_APPLY.PERIOD,

                },
                new Object[] {
                        HrTables.HR_PERSON_INCOME_CERTIFICATE_APPLY.ORG_ID,
                        HrTables.HR_PERSON_INCOME_CERTIFICATE_APPLY.CONFIRM_DATE,
                }
        );



        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_PERSON_INCOME_CERTIFICATE_APPLY.CONTENT,
                        HrTables.HR_PERSON_INCOME_CERTIFICATE_APPLY.FILE_ID,

                }
        );


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setBpmEventAdaptor(WriteMode.IGNORE) //页面控制器
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
                .setExtendJsFile(WriteMode.IGNORE);
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        ApplyPersonIncomeGtr g=new ApplyPersonIncomeGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
      // g.generateMenu(PersonIncomeCertificateApplyServiceProxy.class, PersonIncomeCertificateApplyPageController.class);
    }
}
