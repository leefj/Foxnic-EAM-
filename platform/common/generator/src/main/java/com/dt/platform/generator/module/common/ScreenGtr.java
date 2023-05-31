package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.ScreenPageController;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.ScreenStatusEnum;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.ScreenServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class ScreenGtr extends BaseCodeGenerator {

    public ScreenGtr() {
        super(SysTables.SYS_SCREEN.$TABLE,"715831379228622848");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(SysTables.SYS_SCREEN.ID).basic().hidden(true);

        cfg.view().field(SysTables.SYS_SCREEN.NAME).search().fuzzySearch();
        cfg.view().field(SysTables.SYS_SCREEN.CODE).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_SCREEN.STATUS,
                        SysTables.SYS_SCREEN.CODE,
                        SysTables.SYS_SCREEN.NAME,

                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(SysTables.SYS_SCREEN.JSON_DATA).table().disable(true);
        cfg.view().field(SysTables.SYS_SCREEN.CODE).form().validate().required();
        cfg.view().field(SysTables.SYS_SCREEN.NAME).form().validate().required();
        cfg.view().field(SysTables.SYS_SCREEN.STATUS).form().radioBox().enumType(ScreenStatusEnum.class);
        cfg.view().field(SysTables.SYS_SCREEN.JSON_DATA).form().textArea().height(500);

        cfg.view().list().operationColumn().addActionButton("设计","screenDesinger","screen-designer-button","sys_screen:designer");
        cfg.view().list().operationColumn().addActionButton("预览","screenView","screen-view-button","sys_screen:view");
        cfg.view().list().operationColumn().addActionButton("应用","screenApply","screen-apply","sys_screen:apply");
        cfg.view().list().operationColumn().addActionButton("复制","screenCopy","screen-copy","sys_screen:copy");


        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_SCREEN.CODE,
                        SysTables.SYS_SCREEN.NAME,
                        SysTables.SYS_SCREEN.NOTES,
                        SysTables.SYS_SCREEN.JSON_DATA,
                }
        );

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
        ScreenGtr g=new ScreenGtr();

        //生成代码
        g.generateCode();

        //生成菜单
      //  g.generateMenu(ScreenServiceProxy.class, ScreenPageController.class);
//       g.generateMenu(NodeLoadServiceProxy.class, NodeLoadPageController.class);
    }

}
