package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.hr.PersonInterViewStatusEnum;
import com.dt.platform.domain.hr.Interview;
import com.dt.platform.domain.hr.PersonInterview;
import com.dt.platform.domain.hr.meta.InterviewMeta;
import com.dt.platform.domain.hr.meta.PersonInterviewMeta;
import com.dt.platform.domain.hr.meta.PersonMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.PersonInterviewPageController;
import com.dt.platform.proxy.hr.InterviewServiceProxy;
import com.dt.platform.proxy.hr.PersonInterviewServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;


public class InterViewPersonGtr extends BaseCodeGenerator {
    public InterViewPersonGtr() {
        super(HrTables.HR_PERSON_INTERVIEW.$TABLE,"811710163416252416");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(HrTables.HR_PERSON_INTERVIEW.INTERVIEW_DATE).form().dateInput().type(DatePickerType.date).format("yyyy-MM-dd").search().range();
        cfg.view().field(HrTables.HR_PERSON_INTERVIEW.BIRTHDAY).form().dateInput().type(DatePickerType.date).format("yyyy-MM-dd").search().range();
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"educationData","educationData","educationData");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"sexDict","sexDict","sexDict");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"interviewMethodDict","interviewMethodDict","interviewMethodDict");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"sourceDict","sourceDict","sourceDict");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"organization","organization","organization");
        cfg.getPoClassFile().addSimpleProperty(Interview.class,"interview","interview","interview");


        cfg.view().field(HrTables.HR_PERSON_INTERVIEW.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_PERSON_INTERVIEW.NAME).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_PERSON_INTERVIEW.NAME,
                        HrTables.HR_PERSON_INTERVIEW.STATUS,
                        HrTables.HR_PERSON_INTERVIEW.EDUCATION_CODE,
                        HrTables.HR_PERSON_INTERVIEW.SOURCE,
                },
                new Object[]{
                        HrTables.HR_PERSON_INTERVIEW.POS,
                        HrTables.HR_PERSON_INTERVIEW.INTERVIEW_METHOD,
                        HrTables.HR_PERSON_INTERVIEW.INTERVIEW_DATE,

                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(HrTables.HR_PERSON_INTERVIEW.NAME).form().validate().required();
        cfg.view().field(HrTables.HR_PERSON_INTERVIEW.FILE_ID).form().upload().maxFileCount(1).acceptAllType();
        cfg.view().field(HrTables.HR_PERSON_INTERVIEW.NOTES).form().textArea().height(80);

        cfg.view().field(HrTables.HR_PERSON_INTERVIEW.STATUS).form().radioBox().enumType(PersonInterViewStatusEnum.class);


        cfg.view().field(HrTables.HR_PERSON_INTERVIEW.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_INTERVIEW.CREATE_TIME).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_INTERVIEW.NOTES).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_INTERVIEW.INTERVIEW_ID).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_INTERVIEW.FILE_ID).form().table().disable(true);
        cfg.view().list().disableBatchDelete();

        cfg.view().field(HrTables.HR_PERSON_INTERVIEW.BIRTHDAY).form().table().hidden(true);
        cfg.view().field(HrTables.HR_PERSON_INTERVIEW.SEX_CODE).form().table().hidden(true);
        cfg.view().field(HrTables.HR_PERSON_INTERVIEW.INTERVIEW_DATE).form().table().hidden(true);
        cfg.view().field(HrTables.HR_PERSON_INTERVIEW.INTERVIEW_METHOD).form().table().hidden(true);
        cfg.view().field(HrTables.HR_PERSON_INTERVIEW.CONTACT_INFORMATION).form().table().hidden(true);
        cfg.view().field(HrTables.HR_PERSON_INTERVIEW.ORG_ID).form().table().hidden(true);

        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(80);

        cfg.view().field(HrTables.HR_PERSON_INTERVIEW.ORG_ID)
                .form().button().chooseOrganization(true);
        cfg.view().field(HrTables.HR_PERSON_INTERVIEW.ORG_ID).table().fillBy("organization","fullName");


        cfg.view().field(HrTables.HR_PERSON_INTERVIEW.INTERVIEW_ID)
                .form().selectBox().queryApi(InterviewServiceProxy.QUERY_LIST)
                .paging(false).filter(false).toolbar(false)
                .valueField(InterviewMeta.ID).
                textField(InterviewMeta.NAME).
                fillWith(PersonInterviewMeta.INTERVIEW).muliti(false);


        cfg.view().field(HrTables.HR_PERSON_INTERVIEW.SEX_CODE)
                .form().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=sex")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(PersonInterviewMeta.SEX_DICT).muliti(false);


        cfg.view().field(HrTables.HR_PERSON_INTERVIEW.INTERVIEW_METHOD)
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=hr_interview_method")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(PersonInterviewMeta.INTERVIEW_METHOD_DICT).muliti(false);


        cfg.view().field(HrTables.HR_PERSON_INTERVIEW.SOURCE)
               .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=hr_interview_profile_source")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(PersonInterviewMeta.SOURCE_DICT).muliti(false);


        cfg.view().form().addGroup("人员信息",
                new Object[] {
                        HrTables.HR_PERSON_INTERVIEW.NAME,
                        HrTables.HR_PERSON_INTERVIEW.SEX_CODE,
                        HrTables.HR_PERSON_INTERVIEW.GRADUATION_SCHOOL,
                        HrTables.HR_PERSON_INTERVIEW.MAJOR,
                },
                new Object[] {
                        HrTables.HR_PERSON_INTERVIEW.BIRTHDAY,
                        HrTables.HR_PERSON_INTERVIEW.CONTACT_INFORMATION,
                        HrTables.HR_PERSON_INTERVIEW.EDUCATION_CODE,
                }
        );
        cfg.view().form().addGroup("面试信息",
                new Object[] {
                      //  HrTables.HR_PERSON_INTERVIEW.CONTENT,
                        HrTables.HR_PERSON_INTERVIEW.ORG_ID,
                        HrTables.HR_PERSON_INTERVIEW.SOURCE,
                        HrTables.HR_PERSON_INTERVIEW.INTERVIEW_DATE,
                },
                new Object[] {
                        HrTables.HR_PERSON_INTERVIEW.POS,
                        HrTables.HR_PERSON_INTERVIEW.INTERVIEW_METHOD,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_PERSON_INTERVIEW.STATUS,
                        HrTables.HR_PERSON_INTERVIEW.RESULT,
                }

        );


        cfg.view().form().addGroup("其他信息",
                new Object[] {

                        HrTables.HR_PERSON_INTERVIEW.NOTES,
                        HrTables.HR_PERSON_INTERVIEW.FILE_ID,
                }

        );

        cfg.view().list().addJsVariable("INTERVIEW_ID",   "[[${interviewId}]]","interviewId");
      //  cfg.view().list().addJsVariable("selected_Code",   "[[${selectedCode}]]","selectedCode");
        cfg.view().list().addJsVariable("ACTION",   "[[${action}]]","action");

        cfg.view().form().addJsVariable("INTERVIEW_ID",   "[[${interviewId}]]","interviewId");
       // cfg.view().form().addJsVariable("selectedCode",   "[[${selectedCode}]]","selectedCode");
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
        InterViewPersonGtr g=new InterViewPersonGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
      //g.generateMenu(PersonInterviewServiceProxy.class, PersonInterviewPageController.class);
    }
}
