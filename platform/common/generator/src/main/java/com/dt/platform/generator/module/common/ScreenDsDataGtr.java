package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.ScreenDsDataPageController;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.ScreenDsEnum;
import com.dt.platform.constants.enums.common.ScreenStatusEnum;
import com.dt.platform.domain.common.ScreenDsData;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.ScreenDsDataServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class ScreenDsDataGtr extends BaseCodeGenerator {

    public ScreenDsDataGtr() {
        super(SysTables.SYS_SCREEN_DS_DATA.$TABLE,"715831379228622848");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(SysTables.SYS_SCREEN_DS_DATA.ID).basic().hidden(true);

        cfg.view().field(SysTables.SYS_SCREEN_DS_DATA.NAME).search().fuzzySearch();
        cfg.view().field(SysTables.SYS_SCREEN_DS_DATA.CODE).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_SCREEN_DS_DATA.DS_CODE,
                        SysTables.SYS_SCREEN_DS_DATA.CODE,
                        SysTables.SYS_SCREEN_DS_DATA.NAME,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(SysTables.SYS_SCREEN_DS_DATA.SQL_TEXT).table().disable(true);
        cfg.view().field(SysTables.SYS_SCREEN_DS_DATA.UPDATE_BY).table().disable(true);

        cfg.view().field(SysTables.SYS_SCREEN_DS_DATA.DS_CODE).form().validate().required().
                form().radioBox().enumType(ScreenDsEnum.class).defaultIndex(0);

        cfg.view().field(SysTables.SYS_SCREEN_DS_DATA.CODE).form().validate().required();
        cfg.view().field(SysTables.SYS_SCREEN_DS_DATA.NAME).form().validate().required();
        cfg.view().field(SysTables.SYS_SCREEN_DS_DATA.SQL_TEXT).form().validate().required().form()
                .form().textArea().height(200);
        cfg.view().field(SysTables.SYS_SCREEN_DS_DATA.NOTES).form().textArea().height(120);
        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_SCREEN_DS_DATA.CODE,
                        SysTables.SYS_SCREEN_DS_DATA.NAME,
                },
                new Object[] {
                        SysTables.SYS_SCREEN_DS_DATA.DS_CODE,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_SCREEN_DS_DATA.SQL_TEXT,
                        SysTables.SYS_SCREEN_DS_DATA.NOTES,
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
        ScreenDsDataGtr g=new ScreenDsDataGtr();

        //生成代码
        g.generateCode();

        //生成菜单
      //  g.generateMenu(ScreenDsDataServiceProxy.class, ScreenDsDataPageController.class);
    }

}
