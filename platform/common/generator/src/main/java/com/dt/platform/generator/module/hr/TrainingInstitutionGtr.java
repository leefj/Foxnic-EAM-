package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.domain.hr.TrainingInstitution;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.TrainingInstitutionPageController;
import com.dt.platform.proxy.hr.TrainingInstitutionServiceProxy;
import com.github.foxnic.generator.config.WriteMode;


public class TrainingInstitutionGtr extends BaseCodeGenerator {
    public TrainingInstitutionGtr() {
        super(HrTables.HR_TRAINING_INSTITUTION.$TABLE,"811268060357853184");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(HrTables.HR_TRAINING_INSTITUTION.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_TRAINING_INSTITUTION.NAME).search().fuzzySearch();
        cfg.view().field(HrTables.HR_TRAINING_INSTITUTION.CONTACT).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_TRAINING_INSTITUTION.NAME,
                        HrTables.HR_TRAINING_INSTITUTION.CONTACT,

                }
        );


        cfg.view().field(HrTables.HR_TRAINING_INSTITUTION.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_TRAINING_INSTITUTION.CREATE_TIME).form().table().disable(true);


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(HrTables.HR_TRAINING_INSTITUTION.NAME).form().validate().required();

        cfg.view().field(HrTables.HR_TRAINING_INSTITUTION.NOTES).form().textArea().height(120);
        cfg.view().field(HrTables.HR_TRAINING_INSTITUTION.FILE_ID).form().upload().acceptAllType().maxFileCount(1);

        cfg.view().formWindow().width("75%");
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_TRAINING_INSTITUTION.NAME,
                },
                new Object[] {
                        HrTables.HR_TRAINING_INSTITUTION.WEBSITE,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_TRAINING_INSTITUTION.PROFILE,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_TRAINING_INSTITUTION.CONTACT,
                },new Object[] {
                        HrTables.HR_TRAINING_INSTITUTION.CONTACT_INFORMATION,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_TRAINING_INSTITUTION.NOTES,
                        HrTables.HR_TRAINING_INSTITUTION.FILE_ID,
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
        TrainingInstitutionGtr g=new TrainingInstitutionGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
     // g.generateMenu(TrainingInstitutionServiceProxy.class, TrainingInstitutionPageController.class);
    }
}
