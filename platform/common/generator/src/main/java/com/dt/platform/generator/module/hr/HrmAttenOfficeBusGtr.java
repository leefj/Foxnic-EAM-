package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.domain.hr.Person;
import com.dt.platform.domain.hr.meta.AttendanceHolidayMeta;
import com.dt.platform.domain.hr.meta.AttendanceOfficialBusiMeta;
import com.dt.platform.domain.hr.meta.AttendanceOvertimeMeta;
import com.dt.platform.domain.hr.meta.PersonMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.AttendanceOfficialBusiPageController;
import com.dt.platform.proxy.hr.AttendanceOfficialBusiServiceProxy;
import com.dt.platform.proxy.hr.PersonServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;


public class HrmAttenOfficeBusGtr extends BaseCodeGenerator {
    public HrmAttenOfficeBusGtr() {
        super(HrTables.HR_ATTENDANCE_OFFICIAL_BUSI.$TABLE,"662281190966820864");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(HrTables.HR_ATTENDANCE_OFFICIAL_BUSI.ID).basic().hidden(true);

        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"typeDict","typeDict","typeDict");
        cfg.getPoClassFile().addSimpleProperty(Person.class,"person","person","person");


        cfg.getPoClassFile().addSimpleProperty(String.class,"personJobNumber","personJobNumber","personJobNumber");
        cfg.getPoClassFile().addSimpleProperty(String.class,"sOrgId","sOrgId","sOrgId");
        cfg.view().field(HrTables.HR_ATTENDANCE_OFFICIAL_BUSI.ACTION_DATE).form().validate().required().form().dateInput().type(DatePickerType.date).format("yyyy-MM-dd").search().range();
        cfg.view().field(HrTables.HR_ATTENDANCE_OFFICIAL_BUSI.ACTION_S_TIME).form().validate().required().form().dateInput().type(DatePickerType.datetime).format("yyyy-MM-dd HH:mm:ss").search().range();
        cfg.view().field(HrTables.HR_ATTENDANCE_OFFICIAL_BUSI.ACTION_E_TIME).form().validate().required().form().dateInput().type(DatePickerType.datetime).format("yyyy-MM-dd HH:mm:ss").search().range();
        cfg.view().field(HrTables.HR_ATTENDANCE_OFFICIAL_BUSI.BATCH_CODE).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_ATTENDANCE_OFFICIAL_BUSI.PERSON_ID,
                        HrTables.HR_ATTENDANCE_OFFICIAL_BUSI.ACTION_TYPE,
                        AttendanceOfficialBusiMeta.PERSON_JOB_NUMBER,
                        HrTables.HR_ATTENDANCE_OFFICIAL_BUSI.BATCH_CODE,
                },
                new Object[]{
                        HrTables.HR_ATTENDANCE_OFFICIAL_BUSI.ACTION_DATE,
                        HrTables.HR_ATTENDANCE_OFFICIAL_BUSI.ACTION_S_TIME,
                }

        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);



        cfg.view().field(HrTables.HR_ATTENDANCE_OFFICIAL_BUSI.ACTION_TYPE)
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=hr_attendance_ob_type")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(AttendanceOfficialBusiMeta.TYPE_DICT).muliti(false);


        cfg.view().field(HrTables.HR_ATTENDANCE_OFFICIAL_BUSI.PERSON_ID)
                .form().validate().required().form().selectBox().queryApi(PersonServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(PersonMeta.ID).
                textField(PersonMeta.NAME).
                fillWith(AttendanceOfficialBusiMeta.PERSON).muliti(false);


        cfg.view().field(HrTables.HR_ATTENDANCE_OFFICIAL_BUSI.NOTES).form().textArea().height(120);
        cfg.view().field(HrTables.HR_ATTENDANCE_OFFICIAL_BUSI.ACTION_DAYS).form().validate().required().form().numberInput().defaultValue(0).decimal().scale(2);
        cfg.view().field(HrTables.HR_ATTENDANCE_OFFICIAL_BUSI.FILE_ID).form().upload().maxFileCount(1).acceptAllType();


        cfg.view().field(AttendanceOfficialBusiMeta.PERSON_JOB_NUMBER).basic().label("工号").table().disable(false);
        cfg.view().field(AttendanceOfficialBusiMeta.PERSON_JOB_NUMBER).table().fillBy("person","jobNumber");

        cfg.view().field(AttendanceOfficialBusiMeta.PERSON_JOB_NUMBER).form().readOnly();
        cfg.view().field(HrTables.HR_ATTENDANCE_OFFICIAL_BUSI.FILE_ID).form().table().disable(true);
        cfg.view().field(HrTables.HR_ATTENDANCE_OFFICIAL_BUSI.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_ATTENDANCE_OFFICIAL_BUSI.CREATE_TIME).form().table().hidden(true);

        cfg.view().list().excel(true,true);
        cfg.view().list().addToolButton("导入","importData","import-data");
        cfg.view().list().addToolButton("导出","exportData","export-data");

        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup("人员信息",
                new Object[] {
                        HrTables.HR_ATTENDANCE_OFFICIAL_BUSI.PERSON_ID,
                },
                new Object[] {
                        AttendanceOfficialBusiMeta.PERSON_JOB_NUMBER
                }
        );

        cfg.view().form().addGroup("考勤信息",
                new Object[] {
                        HrTables.HR_ATTENDANCE_OFFICIAL_BUSI.ACTION_DATE,
                        HrTables.HR_ATTENDANCE_OFFICIAL_BUSI.ACTION_S_TIME,
                        HrTables.HR_ATTENDANCE_OFFICIAL_BUSI.ACTION_DAYS,
                        HrTables.HR_ATTENDANCE_OFFICIAL_BUSI.NOTES,
                },
                new Object[] {
                        HrTables.HR_ATTENDANCE_OFFICIAL_BUSI.ACTION_TYPE,
                        HrTables.HR_ATTENDANCE_OFFICIAL_BUSI.ACTION_E_TIME,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_ATTENDANCE_OFFICIAL_BUSI.FILE_ID,
                }
        );




        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.IGNORE) //列表HTML页
                .setExtendJsFile(WriteMode.IGNORE);
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        HrmAttenOfficeBusGtr g=new HrmAttenOfficeBusGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
     //  g.generateMenu(AttendanceOfficialBusiServiceProxy.class, AttendanceOfficialBusiPageController.class);

    }
}
