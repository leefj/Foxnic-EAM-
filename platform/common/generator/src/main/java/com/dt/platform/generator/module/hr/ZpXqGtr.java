package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.hr.PersonnelRequirementApply;
import com.dt.platform.domain.hr.Position;
import com.dt.platform.domain.hr.meta.TrainingInstitutionMeta;
import com.dt.platform.domain.hr.meta.TrainingInstructorMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.PersonnelRequirementApplyPageController;
import com.dt.platform.proxy.hr.PersonnelRequirementApplyServiceProxy;
import com.dt.platform.proxy.hr.TrainingInstitutionServiceProxy;
import com.github.foxnic.api.bpm.IntegrateMode;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Person;


public class ZpXqGtr extends BaseCodeGenerator {
    public ZpXqGtr() {
        super(HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.$TABLE,"662287283122077696");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.ID).basic().hidden(true);


        cfg.getPoClassFile().addSimpleProperty(Organization.class,"organization","organization","organization");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"person","person","person");
        cfg.view().field(HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.TITLE).search().fuzzySearch();
        cfg.view().field(HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.POS).search().fuzzySearch();



        cfg.view().field(HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.SDATE).search().range();

        cfg.view().field(HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.SDATE).form().dateInput().type(DatePickerType.date).format("yyyy-MM-dd").search().range();

        cfg.view().field(HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.EDATE).form().dateInput().type(DatePickerType.date).format("yyyy-MM-dd").search().range();

        cfg.view().form().labelWidth(70);

        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.STATUS,
                        HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.BUSINESS_CODE,
                        HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.ORG_ID,
                },
                new Object[]{
                        HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.TITLE,
                        HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.POS,
                        HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.SDATE,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
      //  cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.PROCESS_CODE).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.CREATE_TIME).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.NOTES).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.TITLE).form().validate().required();

        cfg.view().field(HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.JOB_REQUIREMENT).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.WORK_CONTENT).form().table().disable(true);

        cfg.view().field(HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.JOB_REQUIREMENT).form().textArea().height(120);
        cfg.view().field(HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.WORK_CONTENT).form().textArea().height(120);
        cfg.view().field(HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.NOTES).form().textArea().height(60);


        cfg.view().field(HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.ORG_ID)
                .form().validate().required().form().button().chooseOrganization(true);
        cfg.view().field(HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.ORG_ID).table().fillBy("organization","fullName");


        cfg.bpm().form("hr_personnel_requirement_apply");
        cfg.bpm().integrate(IntegrateMode.FRONT);


        cfg.view().field(HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.STATUS).form()
                .label("办理状态").selectBox().enumType(AssetHandleStatusEnum.class);


        cfg.view().field(HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.APPLY_USER_ID).table().fillBy("person","name");
        cfg.view().field(HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.APPLY_USER_ID).form()
                .button().chooseEmployee(true);


        cfg.view().formWindow().width("76%");;
        cfg.view().formWindow().bottomSpace(60);


        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.TITLE,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.ORG_ID,
                        HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.PERSON_NUMBER,
                        HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.SDATE,
                        HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.POS,

                },
                new Object[] {
//                        HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.PROCESS_CODE,
                        HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.METHOD,
                        HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.SALARY,
                        HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.EDATE,
                }
        );



        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.JOB_REQUIREMENT,
                        HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.WORK_CONTENT,
                        HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.NOTES,
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
        ZpXqGtr g=new ZpXqGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
     //  g.generateMenu(PersonnelRequirementApplyServiceProxy.class, PersonnelRequirementApplyPageController.class);
    }
}