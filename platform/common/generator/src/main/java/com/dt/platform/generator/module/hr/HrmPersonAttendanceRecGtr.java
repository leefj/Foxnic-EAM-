package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.hr.PersonFileNewEnum;
import com.dt.platform.constants.enums.hr.PersonFileStatusEnum;
import com.dt.platform.domain.hr.Person;
import com.dt.platform.domain.hr.PersonAttendanceRec;
import com.dt.platform.domain.hr.meta.PersonAttendanceRecMeta;
import com.dt.platform.domain.hr.meta.PersonFileMeta;
import com.dt.platform.domain.hr.meta.PersonMeta;
import com.dt.platform.domain.hr.meta.SalaryDetailMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.PersonAttendanceRecPageController;
import com.dt.platform.proxy.hr.PersonAttendanceRecServiceProxy;
import com.dt.platform.proxy.hr.PersonServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.meta.EmployeeMeta;
import org.github.foxnic.web.proxy.hrm.EmployeeServiceProxy;


public class HrmPersonAttendanceRecGtr extends BaseCodeGenerator {
    public HrmPersonAttendanceRecGtr() {
        super(HrTables.HR_PERSON_ATTENDANCE_REC.$TABLE,"662281190966820864");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(Person.class,"person","person","person");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"employee","employee","employee");


        cfg.view().field(HrTables.HR_PERSON_ATTENDANCE_REC.ID).basic().hidden(true);
//        cfg.view().field(HrTables.HR_PERSON_ATTENDANCE_REC.USER_NAME).search().fuzzySearch();
        cfg.view().field(HrTables.HR_PERSON_ATTENDANCE_REC.JOB_NUMBER).search().fuzzySearch();
        cfg.view().field(HrTables.HR_PERSON_ATTENDANCE_REC.REC_TIME).search().range();
        cfg.view().field(HrTables.HR_PERSON_ATTENDANCE_REC.REC_TIME).form().validate().required().form().dateInput().format("yyyy-MM-dd");


        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_PERSON_ATTENDANCE_REC.PERSON_ID,
                        HrTables.HR_PERSON_ATTENDANCE_REC.JOB_NUMBER,
                        HrTables.HR_PERSON_ATTENDANCE_REC.REC_TIME,
                },
                new Object[]{
                        HrTables.HR_PERSON_ATTENDANCE_REC.BATCH_CODE
                }
        );


        cfg.view().field(HrTables.HR_PERSON_ATTENDANCE_REC.PERSON_ID)
                .form().selectBox().queryApi(PersonServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(PersonMeta.ID).
                textField(PersonMeta.NAME).
                fillWith(PersonAttendanceRecMeta.PERSON).muliti(false);

        cfg.view().field(HrTables.HR_PERSON_ATTENDANCE_REC.EMPLOYEE_ID)
                .form().selectBox().queryApi(EmployeeServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(EmployeeMeta.ID).
                textField(EmployeeMeta.NAME).
                fillWith(PersonAttendanceRecMeta.EMPLOYEE).muliti(false);

        cfg.view().field(HrTables.HR_PERSON_ATTENDANCE_REC.EMPLOYEE_ID).form().readOnly();
        cfg.view().field(HrTables.HR_PERSON_ATTENDANCE_REC.JOB_NUMBER).form().readOnly();
//        cfg.view().field(HrTables.HR_PERSON_ATTENDANCE_REC.USER_NAME).form().readOnly();
        cfg.view().field(HrTables.HR_PERSON_ATTENDANCE_REC.EMPLOYEE_ID).table().disable(true);

        cfg.view().field(HrTables.HR_PERSON_ATTENDANCE_REC.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_ATTENDANCE_REC.CREATE_TIME).form().table().disable(true);

        cfg.view().field(HrTables.HR_PERSON_ATTENDANCE_REC.JB_CNT).basic().label("加班(天)").form().numberInput().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_PERSON_ATTENDANCE_REC.NJ_CNT).basic().label("年假(天)").form().numberInput().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_PERSON_ATTENDANCE_REC.CC_CNT).basic().label("出差(天)").form().numberInput().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_PERSON_ATTENDANCE_REC.SJ_CNT).basic().label("事假(天)").form().numberInput().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_PERSON_ATTENDANCE_REC.BJ_CNT).basic().label("病假(天)").form().numberInput().defaultValue(0.00).scale(2);
        cfg.view().field(HrTables.HR_PERSON_ATTENDANCE_REC.OTHER_CNT).basic().label("其他(天)").form().numberInput().defaultValue(0.00).scale(2);

        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(50);
        cfg.view().form().addGroup("人员信息",
                new Object[] {
                        HrTables.HR_PERSON_ATTENDANCE_REC.PERSON_ID,
                        HrTables.HR_PERSON_ATTENDANCE_REC.JOB_NUMBER,
                },
                new Object[] {
                        HrTables.HR_PERSON_ATTENDANCE_REC.REC_TIME,
                }
        );
        cfg.view().form().addGroup("考勤信息",
                new Object[] {
                        HrTables.HR_PERSON_ATTENDANCE_REC.JB_CNT,
                        HrTables.HR_PERSON_ATTENDANCE_REC.NJ_CNT,
                        HrTables.HR_PERSON_ATTENDANCE_REC.CC_CNT,
                },
                new Object[] {
                        HrTables.HR_PERSON_ATTENDANCE_REC.SJ_CNT,
                        HrTables.HR_PERSON_ATTENDANCE_REC.BJ_CNT,
                        HrTables.HR_PERSON_ATTENDANCE_REC.OTHER_CNT,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_PERSON_ATTENDANCE_REC.NOTES,
                }
        );


        cfg.view().list().addToolButton("导入","importData","import-data");
        cfg.view().list().addToolButton("导出","exportData","export-data");


        cfg.view().list().excel(true,true);
        cfg.view().search().rowsDisplay(1);
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);



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
        HrmPersonAttendanceRecGtr g=new HrmPersonAttendanceRecGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
      //g.generateMenu(PersonAttendanceRecServiceProxy.class, PersonAttendanceRecPageController.class);


    }
}
