package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.hr.AttendanceRcdProcessStatusEnum;
import com.dt.platform.domain.hr.Person;
import com.dt.platform.domain.hr.meta.AttendanceDataMeta;
import com.dt.platform.domain.hr.meta.AttendanceDataProcessMeta;
import com.dt.platform.domain.hr.meta.PersonMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.AttendanceDataProcessPageController;
import com.dt.platform.proxy.hr.AttendanceDataProcessServiceProxy;
import com.dt.platform.proxy.hr.PersonServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;


public class HrmAttendanceProcessRcdGtr extends BaseCodeGenerator {
    public HrmAttendanceProcessRcdGtr() {
        super(HrTables.HR_ATTENDANCE_DATA_PROCESS.$TABLE,"662281190966820864");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());



        cfg.view().field(HrTables.HR_ATTENDANCE_DATA_PROCESS.ID).basic().hidden(true);
        cfg.getPoClassFile().addSimpleProperty(Person.class,"person","person","person");
        cfg.view().field(HrTables.HR_ATTENDANCE_DATA_PROCESS.PROCESS_DATE).form().dateInput().type(DatePickerType.datetime).format("yyyy-MM-dd HH:mm:ss").search().range();



        cfg.view().field(HrTables.HR_ATTENDANCE_DATA_PROCESS.KQ_RQ).form().dateInput().type(DatePickerType.date).format("yyyy-MM-dd").search().range();


        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_ATTENDANCE_DATA_PROCESS.PERSON_ID,
                        HrTables.HR_ATTENDANCE_DATA_PROCESS.STATUS,
                        HrTables.HR_ATTENDANCE_DATA_PROCESS.KQ_RQ,
                }

        );

        cfg.view().field(HrTables.HR_ATTENDANCE_DATA_PROCESS.STATUS).form().radioBox().enumType(AttendanceRcdProcessStatusEnum.class);


        cfg.view().field(HrTables.HR_ATTENDANCE_DATA_PROCESS.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_ATTENDANCE_DATA_PROCESS.CREATE_TIME).form().table().disable(true);



        cfg.view().field(HrTables.HR_ATTENDANCE_DATA_PROCESS.NOTES).form().textArea().height(80);

        cfg.view().field(HrTables.HR_ATTENDANCE_DATA_PROCESS.PERSON_ID)
                .form().validate().required().form().selectBox().queryApi(PersonServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(PersonMeta.ID).
                textField(PersonMeta.NAME).
                fillWith(AttendanceDataProcessMeta.PERSON).muliti(false);



        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_ATTENDANCE_DATA_PROCESS.PERSON_ID,
                        HrTables.HR_ATTENDANCE_DATA_PROCESS.STATUS,
                        HrTables.HR_ATTENDANCE_DATA_PROCESS.KQ_RQ,
                        HrTables.HR_ATTENDANCE_DATA_PROCESS.PROCESS_DATE,
                        HrTables.HR_ATTENDANCE_DATA_PROCESS.NOTES,
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
        HrmAttendanceProcessRcdGtr g=new HrmAttendanceProcessRcdGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
     // g.generateMenu(AttendanceDataProcessServiceProxy.class, AttendanceDataProcessPageController.class);

    }
}
