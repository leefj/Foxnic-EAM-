package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.ScreenDsDbPageController;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.ScreenDbTypeEnum;
import com.dt.platform.constants.enums.common.ScreenDsEnum;
import com.dt.platform.constants.enums.common.ScreenSourceEnum;
import com.dt.platform.domain.common.ScreenDsDb;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.ScreenDsDbServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class ScreenDsDBGtr extends BaseCodeGenerator {

    public ScreenDsDBGtr() {
        super(SysTables.SYS_SCREEN_DS_DB.$TABLE,"715811803308752896");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(SysTables.SYS_SCREEN_DS_DB.ID).basic().hidden(true);

        cfg.view().field(SysTables.SYS_SCREEN_DS_DB.NAME).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_SCREEN_DS_DB.DS_TYPE,
                        SysTables.SYS_SCREEN_DS_DB.NAME,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(SysTables.SYS_SCREEN_DS_DB.UPDATE_BY).table().disable(true);
        cfg.view().field(SysTables.SYS_SCREEN_DS_DB.TYPE).table().disable(true);
        cfg.view().field(SysTables.SYS_SCREEN_DS_DB.CREATE_TIME).table().disable(true);

        cfg.view().field(SysTables.SYS_SCREEN_DS_DB.DS_TYPE).form().validate().required()
        .form().radioBox().enumType(ScreenDbTypeEnum.class).defaultIndex(0);

        cfg.view().field(SysTables.SYS_SCREEN_DS_DB.NAME).form().validate().required();
        cfg.view().field(SysTables.SYS_SCREEN_DS_DB.USER).form().validate().required();
        cfg.view().field(SysTables.SYS_SCREEN_DS_DB.PWD).form().validate().required();
        cfg.view().field(SysTables.SYS_SCREEN_DS_DB.URI).form().validate().required();
        cfg.view().field(SysTables.SYS_SCREEN_DS_DB.NOTES).form().textArea().height(120);

        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_SCREEN_DS_DB.NAME,
                        SysTables.SYS_SCREEN_DS_DB.DS_TYPE,
                        SysTables.SYS_SCREEN_DS_DB.USER,
                        SysTables.SYS_SCREEN_DS_DB.PWD,
                        SysTables.SYS_SCREEN_DS_DB.URI,
                        SysTables.SYS_SCREEN_DS_DB.NOTES,
                }

        );


        cfg.view().list().operationColumn().addActionButton("测试","test","test-button");

        cfg.view().list().disableBatchDelete();

        //文件生成覆盖模式
        cfg.overrides()
               .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        ScreenDsDBGtr g=new ScreenDsDBGtr();

        //生成代码
        g.generateCode();

        //生成菜单
       // g.generateMenu(ScreenDsDbServiceProxy.class, ScreenDsDbPageController.class);
    }

}
