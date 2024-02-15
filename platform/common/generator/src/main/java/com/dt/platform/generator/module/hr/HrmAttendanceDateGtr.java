package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.common.YesNoEnum;
import com.dt.platform.constants.enums.hr.AttendanceRcdProcessStatusEnum;
import com.dt.platform.constants.enums.hr.WeekEnum;
import com.dt.platform.domain.hr.AttendanceData;
import com.dt.platform.domain.hr.AttendanceDate;
import com.dt.platform.domain.hr.meta.AttendanceDateMeta;
import com.dt.platform.domain.hr.meta.AttendanceRecordMeta;
import com.dt.platform.domain.hr.meta.PersonMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.AttendanceDatePageController;
import com.dt.platform.proxy.hr.AttendanceDateServiceProxy;
import com.dt.platform.proxy.hr.PersonServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Person;

import java.util.Date;


public class HrmAttendanceDateGtr extends BaseCodeGenerator {
    public HrmAttendanceDateGtr() {
        super(HrTables.HR_ATTENDANCE_DATE.$TABLE,"809767273022619648");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(HrTables.HR_ATTENDANCE_DATE.DATE_STR).search().fuzzySearch();
        cfg.view().field(HrTables.HR_ATTENDANCE_DATE.ID).basic().hidden(true);


        cfg.getPoClassFile().addSimpleProperty(Date.class,"confSDate","confSDate","confSDate");
        cfg.getPoClassFile().addSimpleProperty(Date.class,"confEDate","confEDate","confEDate");
        cfg.getPoClassFile().addSimpleProperty(String.class,"confCreateDate","confCreateDate","confCreateDate");

        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_ATTENDANCE_DATE.YEAR,
                        HrTables.HR_ATTENDANCE_DATE.WEEK,
                        HrTables.HR_ATTENDANCE_DATE.DATE_STR,
                        HrTables.HR_ATTENDANCE_DATE.ATTENDANC_SIGN
                },
                new Object[]{
                        HrTables.HR_ATTENDANCE_DATE.STATUTORY_HOLIDAY,
                        HrTables.HR_ATTENDANCE_DATE.HOLIDAY,
                }
        );

        cfg.view().field(HrTables.HR_ATTENDANCE_DATE.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_ATTENDANCE_DATE.CREATE_TIME).form().table().disable(true);

        cfg.view().field(AttendanceDateMeta.CONF_S_DATE).form().table().disable(true);
        cfg.view().field(AttendanceDateMeta.CONF_E_DATE).form().table().disable(true);
        cfg.view().field(AttendanceDateMeta.CONF_CREATE_DATE).form().table().disable(true);


        cfg.view().field(HrTables.HR_ATTENDANCE_DATE.WEEK).form().validate().required().form().radioBox().enumType(WeekEnum.class).defaultIndex(0);
        cfg.view().field(HrTables.HR_ATTENDANCE_DATE.DATE_STR).form().validate().required();
        cfg.view().field(HrTables.HR_ATTENDANCE_DATE.YEAR).form().validate().required();
        cfg.view().field(HrTables.HR_ATTENDANCE_DATE.ATTENDANC_SIGN).form().validate().required().form().radioBox().enumType(YesNoEnum.class).defaultIndex(0);
        cfg.view().field(HrTables.HR_ATTENDANCE_DATE.STATUTORY_HOLIDAY).form().validate().required().form().radioBox().enumType(YesNoEnum.class).defaultIndex(1);
        cfg.view().field(AttendanceDateMeta.CONF_CREATE_DATE).basic().label("生成数据").form().validate().required().form().radioBox().enumType(YesNoEnum.class).defaultIndex(1);

        cfg.view().field(AttendanceDateMeta.CONF_S_DATE).basic().label("开始日期").form().validate().required().form().dateInput().type(DatePickerType.date).format("yyyy-MM-dd").defaultNow();
        cfg.view().field(AttendanceDateMeta.CONF_E_DATE).basic().label("结束日期").form().validate().required().form().dateInput().type(DatePickerType.date).format("yyyy-MM-dd").defaultNow();





        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(120);
        cfg.view().form().addGroup("考勤日期",
                new Object[] {
                        HrTables.HR_ATTENDANCE_DATE.DATE_STR,
                        HrTables.HR_ATTENDANCE_DATE.YEAR,
                        HrTables.HR_ATTENDANCE_DATE.WEEK,
                        HrTables.HR_ATTENDANCE_DATE.STATUTORY_HOLIDAY,
                        HrTables.HR_ATTENDANCE_DATE.HOLIDAY,
                        HrTables.HR_ATTENDANCE_DATE.ATTENDANC_SIGN
                }
        );
        cfg.view().form().addGroup("生成数据",
                new Object[] {
                        AttendanceDateMeta.CONF_CREATE_DATE

                }
        ); cfg.view().form().addGroup(null,
                new Object[] {
                        AttendanceDateMeta.CONF_S_DATE,
                },
                new Object[] {
                        AttendanceDateMeta.CONF_E_DATE,
                }
        );

        cfg.view().list().addToolButton("考勤模版","tplConf","tpl-conf");

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
        HrmAttendanceDateGtr g=new HrmAttendanceDateGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
   //    g.generateMenu(AttendanceDateServiceProxy.class, AttendanceDatePageController.class);

    }
}
