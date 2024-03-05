package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;

import com.dt.platform.constants.enums.hr.AttendanceTypeEnum;
import com.dt.platform.constants.enums.hr.WeekEnum;
import com.dt.platform.domain.hr.AttendanceTpl;
import com.dt.platform.domain.hr.AttendanceTplDtl;
import com.dt.platform.domain.hr.Person;
import com.dt.platform.domain.hr.meta.AttendanceTplMeta;
import com.dt.platform.domain.hr.meta.PersonMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.AttendanceTplDtlPageController;
import com.dt.platform.hr.page.AttendanceTplPageController;
import com.dt.platform.proxy.hr.AttendanceTplDtlServiceProxy;
import com.dt.platform.proxy.hr.AttendanceTplServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;


public class HrmAttendanceTplGtr extends BaseCodeGenerator {
    public HrmAttendanceTplGtr() {
        super(HrTables.HR_ATTENDANCE_TPL.$TABLE,"662281190966820864");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(HrTables.HR_ATTENDANCE_TPL.ID).basic().hidden(true);

        cfg.view().field(HrTables.HR_ATTENDANCE_TPL.CODE).search().fuzzySearch();
        cfg.view().field(HrTables.HR_ATTENDANCE_TPL.NAME).search().fuzzySearch();
        cfg.view().field(HrTables.HR_ATTENDANCE_TPL.NOTES).search().fuzzySearch();

        cfg.getPoClassFile().addSimpleProperty(String.class,"selectedCode","selectedCode","selectedCode");

//        cfg.getPoClassFile().addListProperty(DictItem.class,"weekDict","weekDict","weekDict");
//        cfg.getPoClassFile().addListProperty(String.class,"weekList","weekList","weekList");
//
//        cfg.getPoClassFile().addListProperty(DictItem.class,"upDayWeekDict","upDayWeekDict","upDayWeekDict");
//        cfg.getPoClassFile().addListProperty(String.class,"upWeekList","upWeekList","upWeekList");
//
//        cfg.getPoClassFile().addListProperty(DictItem.class,"downDayWeekDict","downDayWeekDict","downDayWeekDict");
//        cfg.getPoClassFile().addListProperty(String.class,"downWeekList","downWeekList","downWeekList");

        cfg.view().field(HrTables.HR_ATTENDANCE_TPL.TPL_TYPE).form().validate().required().form().radioBox().enumType(AttendanceTypeEnum.class).defaultIndex(0);

        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_ATTENDANCE_TPL.TPL_TYPE,
                        HrTables.HR_ATTENDANCE_TPL.CODE,
                        HrTables.HR_ATTENDANCE_TPL.NAME,

                }

        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().list().disableBatchDelete();
        cfg.view().field(HrTables.HR_ATTENDANCE_TPL.CREATE_TIME).form().table().disable(true);
        cfg.view().field(HrTables.HR_ATTENDANCE_TPL.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_ATTENDANCE_TPL.CODE).form().validate().required().search().range();
        cfg.view().field(HrTables.HR_ATTENDANCE_TPL.NAME).form().validate().required();


//
//        cfg.view().field(HrTables.HR_ATTENDANCE_TPL.ON_WORK_TIME).form().validate().required().form().dateInput().type(DatePickerType.time);
//        cfg.view().field(HrTables.HR_ATTENDANCE_TPL.OFF_WORK_TIME).form().validate().required().form().dateInput().type(DatePickerType.time);
//
//
//        cfg.view().field(HrTables.HR_ATTENDANCE_TPL.ON_WORK_TIME_UP).form().validate().required().form().dateInput().type(DatePickerType.time);
//        cfg.view().field(HrTables.HR_ATTENDANCE_TPL.OFF_WORK_TIME_UP).form().validate().required().form().dateInput().type(DatePickerType.time);
//
//
//        cfg.view().field(HrTables.HR_ATTENDANCE_TPL.ON_WORK_TIME_DOWN).form().validate().required().form().dateInput().type(DatePickerType.time);
//        cfg.view().field(HrTables.HR_ATTENDANCE_TPL.OFF_WORK_TIME_DOWN).form().validate().required().form().dateInput().type(DatePickerType.time);
//
//
//        cfg.view().field(HrTables.HR_ATTENDANCE_TPL.ON_WORK_TIME).form().dateInput().type(DatePickerType.time).format("HH:mm:ss").search().range();
//        cfg.view().field(HrTables.HR_ATTENDANCE_TPL.OFF_WORK_TIME).form().dateInput().type(DatePickerType.time).format("HH:mm:ss").search().range();
//        cfg.view().field(HrTables.HR_ATTENDANCE_TPL.ON_WORK_TIME_UP).form().dateInput().type(DatePickerType.time).format("HH:mm:ss").search().range();
//        cfg.view().field(HrTables.HR_ATTENDANCE_TPL.OFF_WORK_TIME_UP).form().dateInput().type(DatePickerType.time).format("HH:mm:ss").search().range();
//        cfg.view().field(HrTables.HR_ATTENDANCE_TPL.ON_WORK_TIME_DOWN).form().dateInput().type(DatePickerType.time).format("HH:mm:ss").search().range();
//        cfg.view().field(HrTables.HR_ATTENDANCE_TPL.OFF_WORK_TIME_DOWN).form().dateInput().type(DatePickerType.time).format("HH:mm:ss").search().range();
//
//
//        cfg.view().field(HrTables.HR_ATTENDANCE_TPL.HALF_U_DAY_WORK_TIME).form().validate().required().form().dateInput().type(DatePickerType.time);
//        cfg.view().field(HrTables.HR_ATTENDANCE_TPL.HALF_U_DAY_WORK_TIME).form().dateInput().type(DatePickerType.time).format("HH:mm:ss").search().range();
//        cfg.view().field(HrTables.HR_ATTENDANCE_TPL.HALF_D_DAY_WORK_TIME).form().validate().required().form().dateInput().type(DatePickerType.time);
//        cfg.view().field(HrTables.HR_ATTENDANCE_TPL.HALF_D_DAY_WORK_TIME).form().dateInput().type(DatePickerType.time).format("HH:mm:ss").search().range();


        cfg.view().field(HrTables.HR_ATTENDANCE_TPL.NAME).form().validate().required();


//        cfg.view().field(AttendanceTplMeta.WEEK_LIST).basic().label("工作日").form().validate().required().form().selectBox()
//                .queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=hr_attendance_week")
//                .paging(false).filter(false).toolbar(false)
//                .valueField(DictItemMeta.CODE).
//                textField(DictItemMeta.LABEL).
//                fillWith(AttendanceTplMeta.WEEK_DICT).muliti(true);
//
//
//        cfg.view().field(AttendanceTplMeta.UP_WEEK_LIST).basic().label("上午").form().selectBox()
//                .queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=hr_attendance_week")
//                .paging(false).filter(false).toolbar(false)
//                .valueField(DictItemMeta.CODE).
//                textField(DictItemMeta.LABEL).
//                fillWith(AttendanceTplMeta.UP_DAY_WEEK_DICT).muliti(true);
//
//        cfg.view().field(AttendanceTplMeta.DOWN_WEEK_LIST).basic().label("下午").form().selectBox()
//                .queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=hr_attendance_week")
//                .paging(false).filter(false).toolbar(false)
//                .valueField(DictItemMeta.CODE).
//                textField(DictItemMeta.LABEL).
//                fillWith(AttendanceTplMeta.DOWN_DAY_WEEK_DICT).muliti(true);

        cfg.view().field(HrTables.HR_ATTENDANCE_TPL.NOTES).form().textArea().height(120);

        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(150);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_ATTENDANCE_TPL.CODE,
                        HrTables.HR_ATTENDANCE_TPL.NAME,
                        HrTables.HR_ATTENDANCE_TPL.TPL_TYPE,
                        HrTables.HR_ATTENDANCE_TPL.NOTES,
                }
        );

        cfg.view().form().addPage("工作日","weekSelectList");

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
        HrmAttendanceTplGtr g=new HrmAttendanceTplGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单


    }
}
