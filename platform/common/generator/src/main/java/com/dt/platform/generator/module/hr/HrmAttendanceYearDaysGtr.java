package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Person;


public class HrmAttendanceYearDaysGtr extends BaseCodeGenerator {
    public HrmAttendanceYearDaysGtr() {
        super(HrTables.HR_ATTENDANCE_YEAR_DAY.$TABLE,"662281190966820864");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(Person.class,"person","person","person");

        cfg.view().field(HrTables.HR_ATTENDANCE_YEAR_DAY.ID).basic().hidden(true);

        cfg.view().field(HrTables.HR_ATTENDANCE_YEAR_DAY.BATCH_CODE).search().range();

        cfg.view().field(HrTables.HR_ATTENDANCE_YEAR_DAY.SDATE).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(HrTables.HR_ATTENDANCE_YEAR_DAY.EDATE).form().dateInput().format("yyyy-MM-dd").search().range();


        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_ATTENDANCE_YEAR_DAY.PERSON_ID,
                        HrTables.HR_ATTENDANCE_YEAR_DAY.BATCH_CODE,
                        HrTables.HR_ATTENDANCE_YEAR_DAY.SDATE,
                }

        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(HrTables.HR_ATTENDANCE_YEAR_DAY.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_ATTENDANCE_YEAR_DAY.NOTES).form().textArea().height(80);


        cfg.view().field(HrTables.HR_ATTENDANCE_YEAR_DAY.PERSON_ID).table().fillBy("person","name");
        cfg.view().field(HrTables.HR_ATTENDANCE_YEAR_DAY.PERSON_ID).form()
                .button().chooseEmployee(true);


        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(120);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_ATTENDANCE_YEAR_DAY.PERSON_ID,
                        HrTables.HR_ATTENDANCE_YEAR_DAY.SDATE,
                        HrTables.HR_ATTENDANCE_YEAR_DAY.DAYS,

                },
                new Object[] {
                        HrTables.HR_ATTENDANCE_YEAR_DAY.BATCH_CODE,
                        HrTables.HR_ATTENDANCE_YEAR_DAY.EDATE,
                        HrTables.HR_ATTENDANCE_YEAR_DAY.LAST_DAYS,

                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_ATTENDANCE_YEAR_DAY.NOTES,
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
        HrmAttendanceYearDaysGtr g=new HrmAttendanceYearDaysGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
     // g.generateMenu(AttendanceYearDayServiceProxy.class, AttendanceYearDayPageController.class);

    }
}
