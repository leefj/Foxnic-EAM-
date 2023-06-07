package com.dt.platform.generator.module.common;


import com.dt.platform.constants.db.SysTables;
import com.dt.platform.generator.config.Config;

import com.github.foxnic.generator.config.WriteMode;

public class SysSystemLogGtr extends BaseCodeGenerator {

    public SysSystemLogGtr() {
        super(SysTables.SYS_INVOKE_LOG.$TABLE,"463397133957988354");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(SysTables.SYS_INVOKE_LOG.ID).basic().hidden(true);
        cfg.view().field(SysTables.SYS_INVOKE_LOG.APPLICATION).search().fuzzySearch();
        cfg.view().field(SysTables.SYS_INVOKE_LOG.HOST_NAME).search().fuzzySearch();
        cfg.view().field(SysTables.SYS_INVOKE_LOG.CLIENT_IP).search().fuzzySearch();
        cfg.view().field(SysTables.SYS_INVOKE_LOG.URI).search().fuzzySearch();
        cfg.view().field(SysTables.SYS_INVOKE_LOG.TYPE).search().fuzzySearch();
        cfg.view().field(SysTables.SYS_INVOKE_LOG.START_TIME).search().range();
        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_INVOKE_LOG.TYPE,
                        SysTables.SYS_INVOKE_LOG.APPLICATION,
                        SysTables.SYS_INVOKE_LOG.HOST_NAME,
                        SysTables.SYS_INVOKE_LOG.CLIENT_IP,
                },
                new Object[]{
                        SysTables.SYS_INVOKE_LOG.USER_AGENT,
                        SysTables.SYS_INVOKE_LOG.HTTP_METHOD,
                        SysTables.SYS_INVOKE_LOG.START_TIME,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().list().disableCreateNew();
        cfg.view().list().disableSingleDelete();
        cfg.view().list().disableBatchDelete();


        cfg.view().field(SysTables.SYS_INVOKE_LOG.PARAMETER).table().disable(true);
        cfg.view().field(SysTables.SYS_INVOKE_LOG.RESPONSE).table().disable(true);
        cfg.view().field(SysTables.SYS_INVOKE_LOG.EXCEPTION).table().disable(true);
        cfg.view().field(SysTables.SYS_INVOKE_LOG.USER_ID).table().disable(true);
        cfg.view().field(SysTables.SYS_INVOKE_LOG.TOKEN).table().disable(true);
        cfg.view().field(SysTables.SYS_INVOKE_LOG.TID).table().disable(true);
        cfg.view().field(SysTables.SYS_INVOKE_LOG.SESSION_ID).table().disable(true);
        cfg.view().field(SysTables.SYS_INVOKE_LOG.USER_AGENT).table().hidden();

        cfg.view().field(SysTables.SYS_INVOKE_LOG.PARAMETER).form().textArea().height(200);
        cfg.view().field(SysTables.SYS_INVOKE_LOG.RESPONSE).form().textArea().height(200);
        cfg.view().field(SysTables.SYS_INVOKE_LOG.EXCEPTION).form().textArea().height(200);

        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width("85%");

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
        SysSystemLogGtr g=new SysSystemLogGtr();

        //生成代码
        g.generateCode();

        //生成菜单
        //
//      g.generateMenu(InvokeLogServiceProxy.class, InvokeLogPageController.class);
//       g.generateMenu(NodeLoadServiceProxy.class, NodeLoadPageController.class);
    }

}
