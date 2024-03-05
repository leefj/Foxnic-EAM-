package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.common.YesNoEnum;
import com.dt.platform.domain.hr.AttendanceProcess;
import com.dt.platform.domain.hr.Person;
import com.dt.platform.domain.hr.meta.AttendanceProcessMeta;
import com.dt.platform.domain.hr.meta.PersonMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.AttendanceProcessPageController;
import com.dt.platform.proxy.hr.AttendanceProcessServiceProxy;
import com.dt.platform.proxy.hr.PersonServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;


public class HrmAttendanceProcessGtr extends BaseCodeGenerator {
    public HrmAttendanceProcessGtr() {
        super(HrTables.HR_ATTENDANCE_PROCESS.$TABLE,"661509217017921536");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(HrTables.HR_ATTENDANCE_PROCESS.ID).basic().hidden(true);

        cfg.getPoClassFile().addListProperty(Person.class,"personList","personList","personList");
        cfg.getPoClassFile().addListProperty(String.class,"personIds","personIds","personIds");

        cfg.getPoClassFile().addListProperty(Organization.class,"organizationList","organizationList","organizationList");
        cfg.getPoClassFile().addListProperty(String.class,"organizationIds","organizationIds","organizationIds");

        cfg.view().field(HrTables.HR_ATTENDANCE_PROCESS.SDATE).form().validate().required().form().dateInput().type(DatePickerType.date).format("yyyy-MM-dd").search().range();
        cfg.view().field(HrTables.HR_ATTENDANCE_PROCESS.EDATE).form().validate().required().form().dateInput().type(DatePickerType.date).format("yyyy-MM-dd").search().range();

        cfg.view().field(HrTables.HR_ATTENDANCE_PROCESS.IS_ALL_PERSON).form().validate().required().form().radioBox().enumType(YesNoEnum.class).defaultIndex(1);

        cfg.view().field(AttendanceProcessMeta.PERSON_IDS).basic().label("人员")
                .form().selectBox().queryApi(PersonServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(PersonMeta.ID).
                textField(PersonMeta.NAME).
                fillWith(AttendanceProcessMeta.PERSON_LIST).muliti(true);
        cfg.view().field(AttendanceProcessMeta.PERSON_IDS).table().disable(false);

        cfg.view().field(HrTables.HR_ATTENDANCE_PROCESS.CREATE_TIME).table().disable(true);
        cfg.view().field(HrTables.HR_ATTENDANCE_PROCESS.UPDATE_BY).table().disable(true);

        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_ATTENDANCE_PROCESS.IS_ALL_PERSON,
                        HrTables.HR_ATTENDANCE_PROCESS.SDATE,
                }
        );

        cfg.view().list().disableBatchDelete();
        cfg.view().list().operationColumn().addActionButton("运行","processing","process-data","process-data");


        cfg.view().list().addToolButton("运行记录","processRcd","process-rcd");

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(150);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_ATTENDANCE_PROCESS.NAME,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_ATTENDANCE_PROCESS.IS_ALL_PERSON,
                        HrTables.HR_ATTENDANCE_PROCESS.SDATE,
                },
                new Object[] {
                        AttendanceProcessMeta.PERSON_IDS,
                        HrTables.HR_ATTENDANCE_PROCESS.EDATE,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_ATTENDANCE_PROCESS.NOTES
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
        HrmAttendanceProcessGtr g=new HrmAttendanceProcessGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
      // g.generateMenu(AttendanceProcessServiceProxy.class, AttendanceProcessPageController.class);
    }
}
