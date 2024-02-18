package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.domain.hr.Position;
import com.dt.platform.domain.hr.TrainingInstitution;
import com.dt.platform.domain.hr.TrainingInstructor;
import com.dt.platform.domain.hr.meta.PersonMeta;
import com.dt.platform.domain.hr.meta.ProfessionalLevelMeta;
import com.dt.platform.domain.hr.meta.TrainingInstitutionMeta;
import com.dt.platform.domain.hr.meta.TrainingInstructorMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.TrainingInstructorPageController;
import com.dt.platform.proxy.hr.ProfessionalLevelServiceProxy;
import com.dt.platform.proxy.hr.TrainingInstitutionServiceProxy;
import com.dt.platform.proxy.hr.TrainingInstructorServiceProxy;
import com.github.foxnic.generator.config.WriteMode;


public class TrainingInstructorGtr extends BaseCodeGenerator {
    public TrainingInstructorGtr() {
        super(HrTables.HR_TRAINING_INSTRUCTOR.$TABLE,"811268060357853184");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(TrainingInstitution.class,"trainingInstitution","trainingInstitution","trainingInstitution");

        cfg.view().field(HrTables.HR_TRAINING_INSTRUCTOR.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_TRAINING_INSTRUCTOR.NAME).search().fuzzySearch();
        cfg.view().field(HrTables.HR_TRAINING_INSTRUCTOR.TITLE).search().fuzzySearch();
        cfg.view().field(HrTables.HR_TRAINING_INSTRUCTOR.CONTACT_INFORMATION).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_TRAINING_INSTRUCTOR.ORG_ID,
                        HrTables.HR_TRAINING_INSTRUCTOR.NAME,
                        HrTables.HR_TRAINING_INSTRUCTOR.CONTACT_INFORMATION,
                        HrTables.HR_TRAINING_INSTRUCTOR.TITLE,
                }
        );


        cfg.view().field(HrTables.HR_TRAINING_INSTRUCTOR.ORG_ID)
                .form().validate().required().form().selectBox().queryApi(TrainingInstitutionServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(TrainingInstitutionMeta.ID).
                textField(TrainingInstitutionMeta.NAME).
                fillWith(TrainingInstructorMeta.TRAINING_INSTITUTION).muliti(false);


        cfg.view().field(HrTables.HR_TRAINING_INSTRUCTOR.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_TRAINING_INSTRUCTOR.CREATE_TIME).form().table().disable(true);
        cfg.view().field(HrTables.HR_TRAINING_INSTRUCTOR.FILE_ID).form().table().disable(true);


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(HrTables.HR_TRAINING_INSTRUCTOR.NAME).form().validate().required();

        cfg.view().field(HrTables.HR_TRAINING_INSTRUCTOR.NOTES).form().textArea().height(120);

        cfg.view().field(HrTables.HR_TRAINING_INSTRUCTOR.FILE_ID).form().upload().acceptAllType().maxFileCount(1);

        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_TRAINING_INSTRUCTOR.NAME,
                        HrTables.HR_TRAINING_INSTRUCTOR.ORG_ID,
                        HrTables.HR_TRAINING_INSTRUCTOR.TITLE,
                        HrTables.HR_TRAINING_INSTRUCTOR.CONTACT_INFORMATION,
                        HrTables.HR_TRAINING_INSTRUCTOR.NOTES,
                        HrTables.HR_TRAINING_INSTRUCTOR.FILE_ID,
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
        TrainingInstructorGtr g=new TrainingInstructorGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
    //  g.generateMenu(TrainingInstructorServiceProxy.class, TrainingInstructorPageController.class);
    }
}
