package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.hr.AttendanceRcdProcessStatusEnum;
import com.dt.platform.domain.hr.AttendanceRecord;
import com.dt.platform.domain.hr.Person;
import com.dt.platform.domain.hr.meta.AttendanceRecordMeta;
import com.dt.platform.domain.hr.meta.AttendanceTypeMeta;
import com.dt.platform.domain.hr.meta.PersonAbsenceApplyMeta;
import com.dt.platform.domain.hr.meta.PersonMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.AttendanceDataPageController;
import com.dt.platform.hr.page.AttendanceRecordPageController;
import com.dt.platform.proxy.hr.AttendanceDataServiceProxy;
import com.dt.platform.proxy.hr.AttendanceRecordServiceProxy;
import com.dt.platform.proxy.hr.AttendanceTypeServiceProxy;
import com.dt.platform.proxy.hr.PersonServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;



public class HrmAttendanceRecordGtr extends BaseCodeGenerator {
    public HrmAttendanceRecordGtr() {
        super(HrTables.HR_ATTENDANCE_RECORD.$TABLE,"662281190966820864");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(Person.class,"person","person","person");

        cfg.view().field(HrTables.HR_ATTENDANCE_RECORD.EMPLOYEE_NUMBER).search().fuzzySearch();
        cfg.view().field(HrTables.HR_ATTENDANCE_RECORD.EMPLOYEE_NAME).search().fuzzySearch();
        cfg.view().field(HrTables.HR_ATTENDANCE_RECORD.NOTES).search().fuzzySearch();
        cfg.view().field(HrTables.HR_ATTENDANCE_RECORD.BATCH_CODE).search().fuzzySearch();
        cfg.view().field(HrTables.HR_ATTENDANCE_RECORD.SOURCE).search().fuzzySearch();
        cfg.view().field(HrTables.HR_ATTENDANCE_RECORD.RCD_TIME).search().range();
        cfg.view().field(HrTables.HR_ATTENDANCE_RECORD.ID).basic().hidden(true);

        cfg.view().field(HrTables.HR_ATTENDANCE_RECORD.RCD_TIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").search().range();

        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_ATTENDANCE_RECORD.PERSON_ID,
                        HrTables.HR_ATTENDANCE_RECORD.EMPLOYEE_NUMBER,
                        HrTables.HR_ATTENDANCE_RECORD.EMPLOYEE_NAME,
                        HrTables.HR_ATTENDANCE_RECORD.BATCH_CODE,
                },
                new Object[]{
                        HrTables.HR_ATTENDANCE_RECORD.SOURCE,
                        HrTables.HR_ATTENDANCE_RECORD.PROCESS_STATUS,
                        HrTables.HR_ATTENDANCE_RECORD.RCD_TIME,

                }
        );

        cfg.view().field(HrTables.HR_ATTENDANCE_RECORD.EMPLOYEE_ID).form().table().disable(true);
        cfg.view().field(HrTables.HR_ATTENDANCE_RECORD.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_ATTENDANCE_RECORD.CREATE_TIME).form().table().disable(true);
        cfg.view().field(HrTables.HR_ATTENDANCE_RECORD.EMPLOYEE_NAME).form().table().disable(true);

        cfg.view().field(HrTables.HR_ATTENDANCE_RECORD.PROCESS_STATUS).form().validate().required().form().radioBox().enumType(AttendanceRcdProcessStatusEnum.class).defaultIndex(0);

        cfg.view().field(HrTables.HR_ATTENDANCE_RECORD.PERSON_ID)
                .form().validate().required().form().selectBox().queryApi(PersonServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(PersonMeta.ID).
                textField(PersonMeta.NAME).
                fillWith(AttendanceRecordMeta.PERSON).muliti(false);


        cfg.view().field(HrTables.HR_ATTENDANCE_RECORD.RCD_TIME).form().dateInput().type(DatePickerType.datetime);


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_ATTENDANCE_RECORD.PERSON_ID,
                        HrTables.HR_ATTENDANCE_RECORD.EMPLOYEE_NUMBER,
                },
                new Object[] {

                        HrTables.HR_ATTENDANCE_RECORD.SOURCE,
                        HrTables.HR_ATTENDANCE_RECORD.BATCH_CODE
                }
        );

        cfg.view().form().addGroup("处理情况",
                new Object[] {
                        HrTables.HR_ATTENDANCE_RECORD.PROCESS_STATUS,
                        HrTables.HR_ATTENDANCE_RECORD.PROCESS_RESULT,
                },
                new Object[] {
                        HrTables.HR_ATTENDANCE_RECORD.RCD_TIME,
                        HrTables.HR_ATTENDANCE_RECORD.PROCESS_TIME,
                }
        );
        cfg.view().form().addGroup("处理情况",
                new Object[] {

                        HrTables.HR_ATTENDANCE_RECORD.NOTES,

                }
        );

        cfg.view().list().excel(true,true);
        cfg.view().list().addToolButton("导入","importData","import-data");
        cfg.view().list().addToolButton("导出","exportData","export-data");

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
        HrmAttendanceRecordGtr g=new HrmAttendanceRecordGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
      // g.generateMenu(AttendanceRecordServiceProxy.class, AttendanceRecordPageController.class);

    }
}
