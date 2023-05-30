package com.dt.platform.generator.module.common;

import com.dt.platform.constants.db.SysTables;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;

public class ScreenProjectDataGtr extends BaseCodeGenerator {

    public ScreenProjectDataGtr() {
        super(SysTables.SYS_SCREEN_PROJECT_DATA.$TABLE,"715831379228622848");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(SysTables.SYS_SCREEN_PROJECT_DATA.ID).basic().hidden(true);



        cfg.view().field(SysTables.SYS_SCREEN_PROJECT_DATA.PROJECT_ID).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_SCREEN_PROJECT_DATA.PROJECT_ID,

                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(SysTables.SYS_SCREEN_PROJECT_DATA.PROJECT_ID).form().textArea().height(400);

        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_SCREEN_PROJECT_DATA.PROJECT_ID,
                        SysTables.SYS_SCREEN_PROJECT_DATA.CONTENT_DATA

                }
        );


      //  cfg.view().list().disableBatchDelete();
        cfg.view().list().disableSingleDelete();


        //文件生成覆盖模式
        cfg.overrides()
               .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        ScreenProjectDataGtr g=new ScreenProjectDataGtr();

        //生成代码
        g.generateCode();
        //生成菜单
       // g.generateMenu(NodeLoadServiceProxy.class, NodeLoadPageController.class);
    }

}
