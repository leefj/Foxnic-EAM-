package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.common.YesNoEnum;
import com.dt.platform.domain.hr.AttendanceData;
import com.dt.platform.domain.hr.AttendanceTpl;
import com.dt.platform.domain.hr.Person;
import com.dt.platform.domain.hr.meta.AttendanceDataMeta;
import com.dt.platform.domain.hr.meta.AttendanceRecordMeta;
import com.dt.platform.domain.hr.meta.AttendanceTplMeta;
import com.dt.platform.domain.hr.meta.PersonMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.AttendanceDataPageController;
import com.dt.platform.proxy.hr.AttendanceDataServiceProxy;
import com.dt.platform.proxy.hr.AttendanceTplServiceProxy;
import com.dt.platform.proxy.hr.PersonServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;


public class HrmAttendanceDataGtr extends BaseCodeGenerator {
    public HrmAttendanceDataGtr() {
        super(HrTables.HR_ATTENDANCE_DATA.$TABLE,"662281190966820864");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(Person.class,"person","person","person");
        cfg.getPoClassFile().addSimpleProperty(AttendanceTpl.class,"attendanceTpl","attendanceTpl","attendanceTpl");
        cfg.getPoClassFile().addSimpleProperty(String.class,"personJobName","personJobName","personJobName");
        cfg.getPoClassFile().addSimpleProperty(String.class,"sJobNumber","sJobNumber","sJobNumber");
        cfg.getPoClassFile().addSimpleProperty(String.class,"rq","rq","rq");
        cfg.getPoClassFile().addSimpleProperty(String.class,"days","days","days");

        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.BATCH_CODE).search().fuzzySearch();
        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.NOTES).search().fuzzySearch();
        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.ATTENDANCE_DATE).search().range();
        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.IS_WORK_DAY).form().validate().required().form().radioBox().enumType(YesNoEnum.class).defaultIndex(0);

        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.ATTENDANCE_DATE).form().validate().required().form().dateInput().type(DatePickerType.date).format("yyyy-MM-dd").search().range();
        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.ON_WORK_TIME).form().dateInput().type(DatePickerType.datetime).format("yyyy-MM-dd HH:mm:ss").search().range();
        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.ON_WORK_TIME2).form().dateInput().type(DatePickerType.datetime).format("yyyy-MM-dd HH:mm:ss").search().range();
        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.OFF_WORK_TIME).form().dateInput().type(DatePickerType.datetime).format("yyyy-MM-dd HH:mm:ss").search().range();
        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.OFF_WORK_TIME2).form().dateInput().type(DatePickerType.datetime).format("yyyy-MM-dd HH:mm:ss").search().range();



        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.NOTES).form().textArea().height(120);

        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_ATTENDANCE_DATA.PERSON_ID,
                        AttendanceDataMeta.S_JOB_NUMBER,
                        HrTables.HR_ATTENDANCE_DATA.ATTENDANCE_TPL_CODE,
                        HrTables.HR_ATTENDANCE_DATA.ATTENDANCE_DATE,
                },
                new Object[]{
                        HrTables.HR_ATTENDANCE_DATA.IS_WORK_DAY,
                        HrTables.HR_ATTENDANCE_DATA.BATCH_CODE,
                        HrTables.HR_ATTENDANCE_DATA.NOTES,
                }

        );

        cfg.view().search().rowsDisplay(1);
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.ATTENDANCE_DATE_STR).form().table().disable(true);

        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.CREATE_TIME).form().table().disable(true);
        cfg.view().field(AttendanceDataMeta.S_JOB_NUMBER).basic().label("工号").form().table().disable(true);

        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.REL_ID).form().table().disable(true);

        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.PERSON_ID)
                .form().validate().required().form().selectBox().queryApi(PersonServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(PersonMeta.ID).
                textField(PersonMeta.NAME).
                fillWith(AttendanceDataMeta.PERSON).muliti(false);

        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.ATTENDANCE_TPL_CODE)
                .form().validate().required().form().selectBox().queryApi(AttendanceTplServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(AttendanceTplMeta.CODE).
                textField(AttendanceTplMeta.NAME).
                fillWith(AttendanceDataMeta.ATTENDANCE_TPL).muliti(false);

        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.NORMAL_DAY).basic().label("正常(天)").form().numberInput().decimal().scale(2);

        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.LEAVE_EARLY).basic().label("迟到(次)").form().numberInput().integer();
        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.LEAVE_EARLY_TIME).basic().label("迟到(分)").form().numberInput().decimal().scale(2);

        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.LEAVE_LATE).basic().label("早退(次)").form().numberInput().integer();
        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.LEAVE_LATE_TIME).basic().label("早退(分)").form().numberInput().decimal().scale(2);

        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.LOSS_EARLY).basic().label("上班缺卡(次)").form().numberInput().integer();
        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.LOSS_LATE).basic().label("下班缺卡(次)").form().numberInput().integer();

        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.LOSS_PROCESS).basic().label("缺卡处理(次)").form().numberInput().decimal().scale(2);

        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.CC).basic().label("出差(天)").form().numberInput().decimal().scale(2);

        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.JB_GZR).basic().label("工作日加班(小时)").form().numberInput().decimal().scale(2);
        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.JB_XXR).basic().label("休息日加班(小时)").form().numberInput().decimal().scale(2);
        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.JB_JJR).basic().label("节假日加班(小时)").form().numberInput().decimal().scale(2);

        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.QJ_BJ).basic().label("病假(天)").form().numberInput().decimal().scale(2);
        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.QJ_CJ).basic().label("产假(天)").form().numberInput().decimal().scale(2);
        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.QJ_GSJ).basic().label("工伤假(天)").form().numberInput().decimal().scale(2);
        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.QJ_HJ).basic().label("婚假(天)").form().numberInput().decimal().scale(2);

        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.QJ_NJ).basic().label("年假(天)").form().numberInput().decimal().scale(2);
        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.QJ_PLJ).basic().label("哺乳假(天)").form().numberInput().decimal().scale(2);
        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.QJ_SJ).basic().label("事假(天)").form().numberInput().decimal().scale(2);
        cfg.view().field(HrTables.HR_ATTENDANCE_DATA.QJ_TXJ).basic().label("调休假(天)").form().numberInput().decimal().scale(2);

        cfg.view().formWindow().width("85%");;
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup("打卡情况",
                new Object[] {
                        HrTables.HR_ATTENDANCE_DATA.PERSON_ID,
                        HrTables.HR_ATTENDANCE_DATA.ON_WORK_TIME,
                        HrTables.HR_ATTENDANCE_DATA.ON_WORK_TIME2,
                },
                new Object[] {
                        HrTables.HR_ATTENDANCE_DATA.ATTENDANCE_DATE,
                        HrTables.HR_ATTENDANCE_DATA.OFF_WORK_TIME,
                        HrTables.HR_ATTENDANCE_DATA.OFF_WORK_TIME2,
                }
        );

        cfg.view().form().addGroup("打卡统计",
                new Object[] {
                        HrTables.HR_ATTENDANCE_DATA.LEAVE_EARLY,
                        HrTables.HR_ATTENDANCE_DATA.LEAVE_LATE,
                        HrTables.HR_ATTENDANCE_DATA.LOSS_EARLY,
                        HrTables.HR_ATTENDANCE_DATA.LOSS_PROCESS,
                },
                new Object[] {
                        HrTables.HR_ATTENDANCE_DATA.LEAVE_EARLY_TIME,
                        HrTables.HR_ATTENDANCE_DATA.LEAVE_LATE_TIME,
                        HrTables.HR_ATTENDANCE_DATA.LOSS_LATE,
                }
        );

        cfg.view().form().addGroup("请假情况",
                new Object[] {
                        HrTables.HR_ATTENDANCE_DATA.QJ_BJ,
                        HrTables.HR_ATTENDANCE_DATA.QJ_CJ,
                        HrTables.HR_ATTENDANCE_DATA.QJ_GSJ,
                        HrTables.HR_ATTENDANCE_DATA.QJ_HJ,
                },
                new Object[] {
                        HrTables.HR_ATTENDANCE_DATA.QJ_NJ,
                        HrTables.HR_ATTENDANCE_DATA.QJ_PLJ,
                        HrTables.HR_ATTENDANCE_DATA.QJ_TXJ,
                        HrTables.HR_ATTENDANCE_DATA.QJ_SJ,
                }
        );
        cfg.view().form().addGroup("加班情况",
                new Object[] {
                        HrTables.HR_ATTENDANCE_DATA.JB_GZR,
                        HrTables.HR_ATTENDANCE_DATA.JB_JJR,
                },
                new Object[] {
                        HrTables.HR_ATTENDANCE_DATA.JB_XXR,
                }
        );


        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_ATTENDANCE_DATA.CC,
                        HrTables.HR_ATTENDANCE_DATA.ATTENDANCE_TPL_CODE,
                        HrTables.HR_ATTENDANCE_DATA.RESULT,
                        HrTables.HR_ATTENDANCE_DATA.IS_WORK_DAY,
                        HrTables.HR_ATTENDANCE_DATA.BATCH_CODE,
                        HrTables.HR_ATTENDANCE_DATA.NOTES,
                }
        );

       // cfg.view().list().addToolButton("原始记录","sourceRcd","source-rcd");
        cfg.view().list().addJsVariable("PERSON_ID",   "[[${personId}]]","personId");
        cfg.view().list().addJsVariable("CODE",   "[[${code}]]","code");
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
        HrmAttendanceDataGtr g=new HrmAttendanceDataGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
     //  g.generateMenu(AttendanceDataServiceProxy.class, AttendanceDataPageController.class);

    }
}
