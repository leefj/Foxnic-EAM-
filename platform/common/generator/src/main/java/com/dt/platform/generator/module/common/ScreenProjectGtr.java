package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.ScreenPageController;
import com.dt.platform.common.page.ScreenProjectPageController;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.ScreenProjectServiceProxy;
import com.dt.platform.proxy.common.ScreenServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class ScreenProjectGtr extends BaseCodeGenerator {

    public ScreenProjectGtr() {
        super(SysTables.SYS_SCREEN_PROJECT.$TABLE,"715831379228622848");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(SysTables.SYS_SCREEN_PROJECT.ID).basic().hidden(true);

        cfg.view().field(SysTables.SYS_SCREEN_PROJECT.PROJECT_NAME).search().fuzzySearch();
        cfg.view().field(SysTables.SYS_SCREEN_PROJECT.REMARKS).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_SCREEN_PROJECT.PROJECT_NAME,
                        SysTables.SYS_SCREEN_PROJECT.REMARKS,
                }
        );
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_SCREEN_PROJECT.PROJECT_NAME,
                        SysTables.SYS_SCREEN_PROJECT.INDEX_IMAGE,
                        SysTables.SYS_SCREEN_PROJECT.REMARKS,
                }
        );



        cfg.view().list().disableSingleDelete();

        //文件生成覆盖模式
        cfg.overrides()
               .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setBpmEventAdaptor(WriteMode.IGNORE) //页面控制器
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        ScreenProjectGtr g=new ScreenProjectGtr();

        //生成代码
        g.generateCode();
        //生成菜单
//        g.removeByBatchId("715929183712182272");
//        g.generateMenu(ScreenProjectServiceProxy.class, ScreenProjectPageController.class);
    }

}
