package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.api.bpm.IntegrateMode;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Person;


public class HrmPersonApplyLeaveGtr extends BaseCodeGenerator {
    public HrmPersonApplyLeaveGtr() {
        super(HrTables.HR_PERSON_LEAVE.$TABLE,"807235387075330049");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());




        cfg.getPoClassFile().addSimpleProperty(Employee.class,"person","person","person");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"handover","handover","handover");

        cfg.view().field(HrTables.HR_PERSON_LEAVE.LEAVE_DATE).form().dateInput().format("yyyy-MM-dd").search().range();

        cfg.view().field(HrTables.HR_PERSON_LEAVE.BUSINESS_CODE).search().fuzzySearch();

        cfg.view().field(HrTables.HR_PERSON_LEAVE.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_PERSON_LEAVE.LEAVE_DATE).search().range();

        cfg.view().form().labelWidth(70);

        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_PERSON_LEAVE.STATUS,
                        HrTables.HR_PERSON_LEAVE.BUSINESS_CODE,
                        HrTables.HR_PERSON_LEAVE.PERSON_ID,
                        HrTables.HR_PERSON_LEAVE.CONTENT,

                },
                new Object[]{
                        HrTables.HR_PERSON_LEAVE.LEAVE_DATE,

                }
        );


        cfg.bpm().form("hr_person_leave");
        cfg.bpm().integrate(IntegrateMode.FRONT);





        cfg.view().field(HrTables.HR_PERSON_LEAVE.PERSON_ID).table().fillBy("person","name");
        cfg.view().field(HrTables.HR_PERSON_LEAVE.PERSON_ID).form().readOnly().form()
                .button().chooseEmployee(true);

        cfg.view().field(HrTables.HR_PERSON_LEAVE.HANDOVER_ID).table().fillBy("handover","name");
        cfg.view().field(HrTables.HR_PERSON_LEAVE.HANDOVER_ID).form()
                .button().chooseEmployee(true);



        cfg.view().field(HrTables.HR_PERSON_LEAVE.OPER_USER_ID).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_LEAVE.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_LEAVE.FILE_IDS).form().table().disable(true);

        cfg.view().field(HrTables.HR_PERSON_LEAVE.CONTENT).form().textArea().height(80);
        cfg.view().field(HrTables.HR_PERSON_LEAVE.NOTE).form().textArea().height(80);

        cfg.view().field(HrTables.HR_PERSON_LEAVE.FILE_IDS).form().upload().maxFileCount(3).acceptAllType();


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().list().addJsVariable("CUR_EMP_ID","[[${curEmpId}]]","curEmpId");
        cfg.view().list().addJsVariable("CODE","[[${code}]]","code");
        cfg.view().form().addJsVariable("CUR_EMP_ID","[[${curEmpId}]]","curEmpId");
        cfg.view().form().addJsVariable("CUR_USER_NAME","[[${curUserName}]]","curUserName");

        cfg.view().field(HrTables.HR_PERSON_LEAVE.STATUS).form()
                .label("办理状态").selectBox().enumType(AssetHandleStatusEnum.class);


        cfg.view().search().rowsDisplay(1);
        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_PERSON_LEAVE.PERSON_ID,
                        HrTables.HR_PERSON_LEAVE.HANDOVER_ID,
                },
                new Object[] {
                        HrTables.HR_PERSON_LEAVE.LEAVE_DATE,

                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_PERSON_LEAVE.CONTENT,
                        HrTables.HR_PERSON_LEAVE.NOTE,
                        HrTables.HR_PERSON_LEAVE.FILE_IDS,
                }
        );



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
        HrmPersonApplyLeaveGtr g=new HrmPersonApplyLeaveGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
        //
      //  g.generateMenu(PersonLeaveServiceProxy.class, PersonLeavePageController.class);
    }
}
