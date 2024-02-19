package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.common.StatusYNEnum;
import com.dt.platform.constants.enums.hr.InterViewStatusEnum;
import com.dt.platform.domain.hr.Interview;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.InterviewPageController;
import com.dt.platform.proxy.hr.InterviewServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;


public class InterViewGtr extends BaseCodeGenerator {
    public InterViewGtr() {
        super(HrTables.HR_INTERVIEW.$TABLE,"811710163416252416");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"employee","employee","employee");
        cfg.view().field(HrTables.HR_INTERVIEW.INTERVIEW_DATE).form().dateInput().type(DatePickerType.date).format("yyyy-MM-dd").search().range();


        cfg.view().field(HrTables.HR_INTERVIEW.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_INTERVIEW.NAME).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_INTERVIEW.NAME,
                        HrTables.HR_INTERVIEW.STATUS,
                        HrTables.HR_INTERVIEW.INTERVIEW_DATE,

                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(HrTables.HR_INTERVIEW.NAME).form().validate().required();

        cfg.view().list().disableBatchDelete();
        cfg.view().field(HrTables.HR_INTERVIEW.STATUS).form().radioBox().enumType(InterViewStatusEnum.class).defaultIndex(0);

        cfg.view().field(HrTables.HR_INTERVIEW.NOTES).form().textArea().height(80);
        cfg.view().field(HrTables.HR_INTERVIEW.CONTENT).form().textArea().height(120);
        cfg.view().field(HrTables.HR_INTERVIEW.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_INTERVIEW.CREATE_TIME).form().table().disable(true);
        cfg.view().field(HrTables.HR_INTERVIEW.NOTES).form().table().disable(true);
        cfg.view().field(HrTables.HR_INTERVIEW.FILE_ID).form().table().disable(true);
        cfg.view().field(HrTables.HR_INTERVIEW.FILE_ID).form().upload().maxFileCount(1).acceptAllType();

        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(80);

        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_INTERVIEW.NAME,
                },
                new Object[] {
                        HrTables.HR_INTERVIEW.STATUS,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_INTERVIEW.INTERVIEW_DATE,
                        HrTables.HR_INTERVIEW.CONTENT,
                        HrTables.HR_INTERVIEW.FILE_ID,
                }
        );



        cfg.view().form().addPage("人员明细","personSelectList");

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
        InterViewGtr g=new InterViewGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
     // g.generateMenu(InterviewServiceProxy.class, InterviewPageController.class);
    }
}
