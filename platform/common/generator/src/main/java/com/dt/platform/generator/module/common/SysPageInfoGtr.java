package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.PageInfoPageController;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.PageInfoServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class SysPageInfoGtr extends BaseCodeGenerator {

    public SysPageInfoGtr() {
        super(SysTables.SYS_PAGE_INFO.$TABLE,"841228807430995968");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(SysTables.SYS_PAGE_INFO.ID).basic().hidden(true);
        cfg.view().field(SysTables.SYS_PAGE_INFO.NAME).search().fuzzySearch();
        cfg.view().field(SysTables.SYS_PAGE_INFO.CODE).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_PAGE_INFO.CODE,
                        SysTables.SYS_PAGE_INFO.NAME,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(SysTables.SYS_PAGE_INFO.CREATE_TIME).table().disable(true);
        cfg.view().field(SysTables.SYS_PAGE_INFO.UPDATE_BY).table().disable(true);
        cfg.view().field(SysTables.SYS_PAGE_INFO.CODE).form().validate().required();
        cfg.view().field(SysTables.SYS_PAGE_INFO.NAME).form().validate().required();
        cfg.view().field(SysTables.SYS_PAGE_INFO.DEF_JSON).form().textArea().height(300);
        cfg.view().field(SysTables.SYS_PAGE_INFO.NOTES).form().textArea().height(80);

        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width(Config.baseFormWidth);

        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_PAGE_INFO.CODE,
                        SysTables.SYS_PAGE_INFO.NAME,
                        SysTables.SYS_PAGE_INFO.DEF_JSON,
                        SysTables.SYS_PAGE_INFO.NOTES,
                }
        );



        cfg.view().list().operationColumn().addActionButton("设计","designer","designer-button");
        cfg.view().list().operationColumn().addActionButton("预览","review","review-button");

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
        SysPageInfoGtr g=new SysPageInfoGtr();
        //生成代码
        g.generateCode();
        //生成菜单
       //g.generateMenu(PageInfoServiceProxy.class, PageInfoPageController.class);
    }

}
