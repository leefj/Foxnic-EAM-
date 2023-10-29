package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.ScreenDsCategoryPageController;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.ScreenDsEnum;
import com.dt.platform.constants.enums.common.ScreenSourceEnum;
import com.dt.platform.domain.common.ScreenDsCategory;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.ScreenDsCategoryServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class ScreenDsCategoryGtr extends BaseCodeGenerator {

    public ScreenDsCategoryGtr() {
        super(SysTables.SYS_SCREEN_DS_CATEGORY.$TABLE,"715811803308752896");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(SysTables.SYS_SCREEN_DS_CATEGORY.ID).basic().hidden(true);

        cfg.view().field(SysTables.SYS_SCREEN_DS_CATEGORY.CATEGORY_NAME).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_SCREEN_DS_CATEGORY.CATEGORY_NAME,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(SysTables.SYS_SCREEN_DS_CATEGORY.UPDATE_BY).table().disable(true);
        cfg.view().field(SysTables.SYS_SCREEN_DS_CATEGORY.CREATE_TIME).table().disable(true);

        cfg.view().field(  SysTables.SYS_SCREEN_DS_CATEGORY.CATEGORY_NAME).form().validate().required();

        cfg.view().formWindow().bottomSpace(50);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_SCREEN_DS_CATEGORY.CATEGORY_NAME
                }

        );



        cfg.view().list().disableBatchDelete();

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
        ScreenDsCategoryGtr g=new ScreenDsCategoryGtr();

        //生成代码
        g.generateCode();

        //生成菜单
      //  g.generateMenu(ScreenDsCategoryServiceProxy.class, ScreenDsCategoryPageController.class);
    }

}
