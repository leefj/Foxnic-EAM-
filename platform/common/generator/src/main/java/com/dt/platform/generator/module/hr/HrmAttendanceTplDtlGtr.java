package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.common.YesNoEnum;
import com.dt.platform.constants.enums.hr.AttendanceTplDayTypeEnum;
import com.dt.platform.domain.hr.AttendanceTplDtl;
import com.dt.platform.domain.hr.AttendanceTplGroup;
import com.dt.platform.domain.hr.meta.AttendanceTplDtlMeta;
import com.dt.platform.domain.hr.meta.AttendanceTplGroupMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.AttendanceTplDtlPageController;
import com.dt.platform.proxy.hr.AttendanceTplDtlServiceProxy;
import com.dt.platform.proxy.hr.AttendanceTplGroupServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;


public class HrmAttendanceTplDtlGtr extends BaseCodeGenerator {
    public HrmAttendanceTplDtlGtr() {
        super(HrTables.HR_ATTENDANCE_TPL_DTL.$TABLE,"662281190966820864");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_DTL.ID).basic().hidden(true);

        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_DTL.OWNER_ID).search().fuzzySearch();

       cfg.getPoClassFile().addSimpleProperty(DictItem.class,"weekDict","weekDict","weekDict");


        cfg.getPoClassFile().addSimpleProperty(AttendanceTplGroup.class,"firstGroup","firstGroup","firstGroup");
        cfg.getPoClassFile().addSimpleProperty(AttendanceTplGroup.class,"secondGroup","secondGroup","secondGroup");

//        cfg.getPoClassFile().addListProperty(DictItem.class,"weekDict","weekDict","weekDict");
//        cfg.getPoClassFile().addListProperty(String.class,"weekList","weekList","weekList");
//
//        cfg.getPoClassFile().addListProperty(DictItem.class,"upDayWeekDict","upDayWeekDict","upDayWeekDict");
//        cfg.getPoClassFile().addListProperty(String.class,"upWeekList","upWeekList","upWeekList");
//
//        cfg.getPoClassFile().addListProperty(DictItem.class,"downDayWeekDict","downDayWeekDict","downDayWeekDict");
//        cfg.getPoClassFile().addListProperty(String.class,"downWeekList","downWeekList","downWeekList");

        cfg.view().search().disable();

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().list().disableBatchDelete();
        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_DTL.CREATE_TIME).form().table().disable(true);
        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_DTL.OWNER_ID).form().table().disable(true);
        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_DTL.UPDATE_BY).form().table().disable(true);


//        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_DTL.ON_WORK_TIME).form().validate().required().form().dateInput().type(DatePickerType.time);
//        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_DTL.OFF_WORK_TIME).form().validate().required().form().dateInput().type(DatePickerType.time);
//
//
//        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_DTL.ON_WORK_TIME_UP).form().validate().required().form().dateInput().type(DatePickerType.time);
//        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_DTL.OFF_WORK_TIME_UP).form().validate().required().form().dateInput().type(DatePickerType.time);
//
//
//        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_DTL.ON_WORK_TIME_DOWN).form().validate().required().form().dateInput().type(DatePickerType.time);
//        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_DTL.OFF_WORK_TIME_DOWN).form().validate().required().form().dateInput().type(DatePickerType.time);
//
//
//        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_DTL.ON_WORK_TIME).form().validate().required().form().dateInput().type(DatePickerType.time).format("HH:mm:ss").search().range();
//        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_DTL.OFF_WORK_TIME).form().validate().required().form().dateInput().type(DatePickerType.time).format("HH:mm:ss").search().range();
//        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_DTL.ON_WORK_TIME_UP).form().validate().required().form().dateInput().type(DatePickerType.time).format("HH:mm:ss").search().range();
//        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_DTL.OFF_WORK_TIME_UP).form().validate().required().form().dateInput().type(DatePickerType.time).format("HH:mm:ss").search().range();
//        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_DTL.ON_WORK_TIME_DOWN).form().validate().required().form().dateInput().type(DatePickerType.time).format("HH:mm:ss").search().range();
//        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_DTL.OFF_WORK_TIME_DOWN).form().validate().required().form().dateInput().type(DatePickerType.time).format("HH:mm:ss").search().range();

        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_DTL.DAY_TYPE).form().validate().required().form().radioBox().enumType(AttendanceTplDayTypeEnum.class).defaultIndex(0);

        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_DTL.IS_WORK_DAY).form().validate().required().form().radioBox().enumType(YesNoEnum.class).defaultIndex(0);

        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_DTL.FIRST_WORK).form().validate().required().form().selectBox()
                .queryApi(AttendanceTplGroupServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(AttendanceTplGroupMeta.ID).
                textField(AttendanceTplGroupMeta.NAME).
                fillWith(AttendanceTplDtlMeta.FIRST_GROUP).muliti(false);

        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_DTL.SECOND_WORK).form().selectBox()
                .queryApi(AttendanceTplGroupServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(AttendanceTplGroupMeta.ID).
                textField(AttendanceTplGroupMeta.NAME).
                fillWith(AttendanceTplDtlMeta.SECOND_GROUP).muliti(false);




        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_DTL.WEEK).form().validate().required().form().selectBox()
                .queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=hr_attendance_week")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(AttendanceTplDtlMeta.WEEK_DICT).muliti(false);


        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_DTL.NOTES).form().textArea().height(120);

        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(150);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_ATTENDANCE_TPL_DTL.WEEK,
                        HrTables.HR_ATTENDANCE_TPL_DTL.IS_WORK_DAY,
                        HrTables.HR_ATTENDANCE_TPL_DTL.DAY_TYPE
                }
        );

        cfg.view().form().addGroup("打卡情况",
                new Object[] {
                        HrTables.HR_ATTENDANCE_TPL_DTL.FIRST_WORK,
                },
                new Object[] {
                        HrTables.HR_ATTENDANCE_TPL_DTL.SECOND_WORK,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {

                        HrTables.HR_ATTENDANCE_TPL.NOTES,
                }
        );


        cfg.view().list().addJsVariable("OWNER_ID",   "[[${ownerId}]]","ownerId");
        cfg.view().form().addJsVariable("OWNER_ID",   "[[${ownerId}]]","ownerId");


        cfg.view().list().addJsVariable("ACTION",   "[[${action}]]","action");

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
                .setExtendJsFile(WriteMode.IGNORE);
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        HrmAttendanceTplDtlGtr g=new HrmAttendanceTplDtlGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
      //  g.generateMenu(AttendanceTplDtlServiceProxy.class, AttendanceTplDtlPageController.class);

    }
}
