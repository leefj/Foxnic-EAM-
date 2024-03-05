package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.common.YesNoEnum;
import com.dt.platform.constants.enums.hr.AttendanceTplDayTypeEnum;
import com.dt.platform.domain.hr.AttendanceTplGroup;
import com.dt.platform.domain.hr.meta.AttendanceTplDtlMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.AttendanceTplGroupPageController;
import com.dt.platform.proxy.hr.AttendanceTplGroupServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;


public class HrmAttendanceTplGroupGtr extends BaseCodeGenerator {
    public HrmAttendanceTplGroupGtr() {
        super(HrTables.HR_ATTENDANCE_TPL_GROUP.$TABLE,"809767273022619648");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_GROUP.ID).basic().hidden(true);






        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_ATTENDANCE_TPL_GROUP.NAME,
                }

        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().list().disableBatchDelete();
        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_GROUP.CREATE_TIME).form().table().disable(true);


        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_GROUP.UPDATE_BY).form().table().disable(true);


        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_GROUP.ON_WORK_TIME).form().validate().required().form().dateInput().type(DatePickerType.time);
        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_GROUP.OFF_WORK_TIME).form().validate().required().form().dateInput().type(DatePickerType.time);


        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_GROUP.ON_WORK_TIME_UP).form().validate().required().form().dateInput().type(DatePickerType.time);
        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_GROUP.OFF_WORK_TIME_UP).form().validate().required().form().dateInput().type(DatePickerType.time);


        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_GROUP.ON_WORK_TIME_DOWN).form().validate().required().form().dateInput().type(DatePickerType.time);
        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_GROUP.OFF_WORK_TIME_DOWN).form().validate().required().form().dateInput().type(DatePickerType.time);


        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_GROUP.ON_WORK_TIME).form().validate().required().form().dateInput().type(DatePickerType.time).format("HH:mm:ss").search().range();
        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_GROUP.OFF_WORK_TIME).form().validate().required().form().dateInput().type(DatePickerType.time).format("HH:mm:ss").search().range();
        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_GROUP.ON_WORK_TIME_UP).form().validate().required().form().dateInput().type(DatePickerType.time).format("HH:mm:ss").search().range();
        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_GROUP.OFF_WORK_TIME_UP).form().validate().required().form().dateInput().type(DatePickerType.time).format("HH:mm:ss").search().range();
        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_GROUP.ON_WORK_TIME_DOWN).form().validate().required().form().dateInput().type(DatePickerType.time).format("HH:mm:ss").search().range();
        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_GROUP.OFF_WORK_TIME_DOWN).form().validate().required().form().dateInput().type(DatePickerType.time).format("HH:mm:ss").search().range();


        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_GROUP.HALF_WORK_DOWN).form().validate().required().form().dateInput().type(DatePickerType.time).format("HH:mm:ss").search().range();
        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_GROUP.HALF_WORK_UP).form().validate().required().form().dateInput().type(DatePickerType.time).format("HH:mm:ss").search().range();



        cfg.view().field(HrTables.HR_ATTENDANCE_TPL_GROUP.NOTES).form().textArea().height(120);

        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(150);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_ATTENDANCE_TPL_GROUP.NAME,

                }
        );

        cfg.view().form().addGroup("打卡情况",
                new Object[] {
                        HrTables.HR_ATTENDANCE_TPL_GROUP.ON_WORK_TIME,
                        HrTables.HR_ATTENDANCE_TPL_GROUP.ON_WORK_TIME_UP,
                        HrTables.HR_ATTENDANCE_TPL_GROUP.ON_WORK_TIME_DOWN
                },
                new Object[] {
                        HrTables.HR_ATTENDANCE_TPL_GROUP.OFF_WORK_TIME,
                        HrTables.HR_ATTENDANCE_TPL_GROUP.OFF_WORK_TIME_UP,
                        HrTables.HR_ATTENDANCE_TPL_GROUP.OFF_WORK_TIME_DOWN,
                }
        );


        cfg.view().form().addGroup("午休情况",
                new Object[] {
                        HrTables.HR_ATTENDANCE_TPL_GROUP.HALF_WORK_UP,

                },
                new Object[] {
                        HrTables.HR_ATTENDANCE_TPL_GROUP.HALF_WORK_DOWN,

                }
        );


        cfg.view().form().addGroup(null,
                new Object[] {

                        HrTables.HR_ATTENDANCE_TPL_GROUP.NOTES,
                }
        );



        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
                .setExtendJsFile(WriteMode.IGNORE);
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        HrmAttendanceTplGroupGtr g=new HrmAttendanceTplGroupGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
       // g.removeByBatchId("814846252763054080");
      //  //生成菜单
        //g.generateMenu(AttendanceTplGroupServiceProxy.class, AttendanceTplGroupPageController.class);

    }
}
