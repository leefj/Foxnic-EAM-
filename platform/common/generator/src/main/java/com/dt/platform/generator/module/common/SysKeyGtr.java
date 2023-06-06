package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.KeyCodePageController;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.ScreenStatusEnum;
import com.dt.platform.constants.enums.common.StatusYNEnum;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.KeyCodeServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class SysKeyGtr extends BaseCodeGenerator {

    public SysKeyGtr() {
        super(SysTables.SYS_KEY_CODE.$TABLE,"463397133957988354");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(SysTables.SYS_KEY_CODE.ID).basic().hidden(true);
        cfg.view().field(SysTables.SYS_KEY_CODE.NAME).search().fuzzySearch();
        cfg.view().field(SysTables.SYS_KEY_CODE.KEY).search().fuzzySearch();
        cfg.view().field(SysTables.SYS_KEY_CODE.NOTES).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_KEY_CODE.STATUS,
                        SysTables.SYS_KEY_CODE.KEY,
                        SysTables.SYS_KEY_CODE.NAME,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(SysTables.SYS_KEY_CODE.KEY).form().validate().required();
        cfg.view().field(SysTables.SYS_KEY_CODE.NAME).form().validate().required();
        cfg.view().field(SysTables.SYS_KEY_CODE.STATUS).form().radioBox().enumType(StatusYNEnum.class).defaultIndex(0);
        cfg.view().field(SysTables.SYS_KEY_CODE.NOTES).form().textArea().height(150);

        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_KEY_CODE.KEY,
                        SysTables.SYS_KEY_CODE.STATUS,
                        SysTables.SYS_KEY_CODE.NAME,
                        SysTables.SYS_KEY_CODE.NOTES,

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
        SysKeyGtr g=new SysKeyGtr();

        //生成代码
        g.generateCode();

        //生成菜单
     //  g.generateMenu(KeyCodeServiceProxy.class, KeyCodePageController.class);
//       g.generateMenu(NodeLoadServiceProxy.class, NodeLoadPageController.class);
    }

}
