package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.hr.AttendanceType;
import com.dt.platform.domain.hr.PersonAbsenceApply;
import com.dt.platform.domain.hr.meta.AttendanceTypeMeta;
import com.dt.platform.domain.hr.meta.PersonAbsenceApplyMeta;
import com.dt.platform.domain.hr.meta.PersonMeta;
import com.dt.platform.domain.hr.meta.RankMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.hr.AttendanceTypeServiceProxy;
import com.dt.platform.proxy.hr.RankServiceProxy;
import com.github.foxnic.api.bpm.IntegrateMode;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Person;


public class HrmPersonApplyAbsenceGtr extends BaseCodeGenerator {
    public HrmPersonApplyAbsenceGtr() {
        super(HrTables.HR_PERSON_ABSENCE_APPLY.$TABLE,"807235387075330049");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(Person.class,"person","person","person");
        cfg.getPoClassFile().addSimpleProperty(AttendanceType.class,"attendanceType","attendanceType","attendanceType");


        cfg.view().field(HrTables.HR_PERSON_ABSENCE_APPLY.APPLY_S_DATE).form().dateInput().type(DatePickerType.datetime).format("yyyy-MM-dd").search().range();
        cfg.view().field(HrTables.HR_PERSON_ABSENCE_APPLY.APPLY_E_DATE).form().dateInput().type(DatePickerType.datetime).format("yyyy-MM-dd").search().range();


        cfg.view().field(HrTables.HR_PERSON_ABSENCE_APPLY.ID).basic().hidden(true);


        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_PERSON_ABSENCE_APPLY.STATUS,
                        HrTables.HR_PERSON_ABSENCE_APPLY.PERSON_ID,
                        HrTables.HR_PERSON_ABSENCE_APPLY.APPLY_S_DATE,

                }
        );
        cfg.bpm().form("hr_person_absence");
        cfg.bpm().integrate(IntegrateMode.FRONT);


        cfg.view().field(HrTables.HR_PERSON_ABSENCE_APPLY.STATUS).form()
                .label("办理状态").selectBox().enumType(AssetHandleStatusEnum.class);


        cfg.view().field(HrTables.HR_PERSON_ABSENCE_APPLY.APPLY_TYPE)
                .form().validate().required().form().selectBox().queryApi(AttendanceTypeServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(AttendanceTypeMeta.CODE).
                textField(AttendanceTypeMeta.NAME).
                fillWith(PersonAbsenceApplyMeta.ATTENDANCE_TYPE).muliti(false);


        cfg.view().field(HrTables.HR_PERSON_ABSENCE_APPLY.OPER_USER_ID).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_ABSENCE_APPLY.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_ABSENCE_APPLY.FILE_IDS).form().table().disable(true);

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(HrTables.HR_PERSON_ABSENCE_APPLY.PERSON_ID).table().form().readOnly().table().fillBy("person","name");
        cfg.view().field(HrTables.HR_PERSON_ABSENCE_APPLY.PERSON_ID).form().readOnly().form()
                .button().chooseEmployee(true);


        cfg.view().field(HrTables.HR_PERSON_ABSENCE_APPLY.CONTENT).form().textArea().height(80);

        cfg.view().field(HrTables.HR_PERSON_ABSENCE_APPLY.NOTE).form().textArea().height(80);
        cfg.view().field(HrTables.HR_PERSON_ABSENCE_APPLY.FILE_IDS).form().upload().maxFileCount(3).acceptAllType();



        cfg.view().search().rowsDisplay(1);
        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_PERSON_ABSENCE_APPLY.PERSON_ID,
                        HrTables.HR_PERSON_ABSENCE_APPLY.APPLY_S_DATE,
                },
                new Object[] {
                        HrTables.HR_PERSON_ABSENCE_APPLY.APPLY_TYPE,
                        HrTables.HR_PERSON_ABSENCE_APPLY.APPLY_E_DATE,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_PERSON_ABSENCE_APPLY.CONTENT,
                        HrTables.HR_PERSON_ABSENCE_APPLY.NOTE,
                        HrTables.HR_PERSON_ABSENCE_APPLY.FILE_IDS,

                }

        );

        cfg.view().list().addJsVariable("CODE","[[${code}]]","code");
        cfg.view().form().addJsVariable("CUR_EMP_ID","[[${curEmpId}]]","curEmpId");
        cfg.view().form().addJsVariable("CUR_USER_NAME","[[${curUserName}]]","curUserName");

        cfg.view().list().disableBatchDelete();

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setBpmEventAdaptor(WriteMode.IGNORE)
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
                .setExtendJsFile(WriteMode.IGNORE);
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        HrmPersonApplyAbsenceGtr g=new HrmPersonApplyAbsenceGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
        //
     //   g.generateMenu(PersonAbsenceApplyServiceProxy.class, PersonAbsenceApplyPageController.class);
    }
}
