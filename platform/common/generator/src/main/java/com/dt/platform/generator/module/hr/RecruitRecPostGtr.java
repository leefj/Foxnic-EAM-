package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;


public class RecruitRecPostGtr extends BaseCodeGenerator {
    public RecruitRecPostGtr() {
        super(HrTables.HR_RECRUIT_POST_REC.$TABLE,"662287283122077696");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(HrTables.HR_RECRUIT_POST_REC.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_RECRUIT_POST_REC.NAME).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_RECRUIT_POST_REC.NAME,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(HrTables.HR_RECRUIT_POST_REC.NAME).form().validate().required();
        cfg.view().field(HrTables.HR_RECRUIT_POST_REC.POST_NAME).form().validate().required();

        cfg.view().field(HrTables.HR_RECRUIT_POST_REC.CONTENT).form().textArea().height(350);
        cfg.view().field(HrTables.HR_RECRUIT_POST_REC.NOTES).form().textArea().height(250);


        cfg.view().formWindow().width("70%");;
        cfg.view().formWindow().bottomSpace(60);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_RECRUIT_POST_REC.NAME,
                        HrTables.HR_RECRUIT_POST_REC.POST_NAME,
                        HrTables.HR_RECRUIT_POST_REC.CONTENT,
                        HrTables.HR_RECRUIT_POST_REC.NOTES
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
        RecruitRecPostGtr g=new RecruitRecPostGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
       // g.generateMenu(RecruitPostRecServiceProxy.class, RecruitPostRecPageController.class);
       //g.generateMenu(RecruitRecPostS.class, RecruitRecPostPageController.class);
    }
}
