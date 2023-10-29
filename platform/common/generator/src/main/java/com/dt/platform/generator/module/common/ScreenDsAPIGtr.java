package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.ScreenDsApiPageController;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.ScreenDsApiReqTypeEnum;
import com.dt.platform.constants.enums.common.ScreenDsEnum;
import com.dt.platform.constants.enums.common.ScreenSourceEnum;
import com.dt.platform.domain.common.ScreenDsApi;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.ScreenDsApiServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class ScreenDsAPIGtr extends BaseCodeGenerator {

    public ScreenDsAPIGtr() {
        super(SysTables.SYS_SCREEN_DS_API.$TABLE,"715811803308752896");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(SysTables.SYS_SCREEN_DS_API.ID).basic().hidden(true);

        cfg.view().field(SysTables.SYS_SCREEN_DS_API.NAME).search().fuzzySearch();
        cfg.view().field(SysTables.SYS_SCREEN_DS_API.CODE).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_SCREEN_DS_API.CODE,
                        SysTables.SYS_SCREEN_DS_API.NAME,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);



        cfg.view().field(SysTables.SYS_SCREEN_DS_API.UPDATE_BY).table().disable(true);
        cfg.view().field(SysTables.SYS_SCREEN_DS_API.CREATE_TIME).table().disable(true);



        cfg.view().field(SysTables.SYS_SCREEN_DS_API.CODE).form().validate().required();
        cfg.view().field(SysTables.SYS_SCREEN_DS_API.NAME).form().validate().required();
        cfg.view().field(SysTables.SYS_SCREEN_DS_API.URL).form().validate().required();
        cfg.view().field(SysTables.SYS_SCREEN_DS_API.REQ_TYPE).form().validate().required().form()
                .radioBox().enumType(ScreenDsApiReqTypeEnum.class).defaultIndex(0);

        cfg.view().field(SysTables.SYS_SCREEN_DS_API.PARAM).form()
                .form().textArea().height(200);

        cfg.view().field(SysTables.SYS_SCREEN_DS_API.HEADER).form()
                .form().textArea().height(200);
        cfg.view().field(SysTables.SYS_SCREEN_DS_API.BODY).form()
                .form().textArea().height(200);

        cfg.view().field(SysTables.SYS_SCREEN_DS_API.NOTES).form()
                .form().textArea().height(200);


        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_SCREEN_DS_API.CODE,
                        SysTables.SYS_SCREEN_DS_API.NAME,
                        SysTables.SYS_SCREEN_DS_API.URL,
                        SysTables.SYS_SCREEN_DS_API.REQ_TYPE,
                        SysTables.SYS_SCREEN_DS_API.HEADER,
                        SysTables.SYS_SCREEN_DS_API.PARAM,
                        SysTables.SYS_SCREEN_DS_API.BODY,
                        SysTables.SYS_SCREEN_DS_API.NOTES,

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
        ScreenDsAPIGtr g=new ScreenDsAPIGtr();

        //生成代码
        g.generateCode();

        //生成菜单
       //g.generateMenu(ScreenDsApiServiceProxy.class, ScreenDsApiPageController.class);
    }

}
