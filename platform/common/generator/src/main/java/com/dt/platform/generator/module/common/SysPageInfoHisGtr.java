package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.PageInfoHisPageController;
import com.dt.platform.common.page.PageInfoPageController;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.domain.common.PageInfo;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.PageInfoHisServiceProxy;
import com.dt.platform.proxy.common.PageInfoServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class SysPageInfoHisGtr extends BaseCodeGenerator {

    public SysPageInfoHisGtr() {
        super(SysTables.SYS_PAGE_INFO_HIS.$TABLE,"841228807430995968");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(PageInfo.class,"pageInfo","pageInfo","pageInfo");

        cfg.view().field(SysTables.SYS_PAGE_INFO_HIS.ID).basic().hidden(true);
        cfg.view().field(SysTables.SYS_PAGE_INFO_HIS.PAGE_ID).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_PAGE_INFO_HIS.PAGE_ID,

                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(SysTables.SYS_PAGE_INFO_HIS.CREATE_TIME).table().disable(true);
        cfg.view().field(SysTables.SYS_PAGE_INFO_HIS.UPDATE_BY).table().disable(true);
        cfg.view().field(SysTables.SYS_PAGE_INFO_HIS.DEF_JSON).form().textArea().height(300);
        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_PAGE_INFO_HIS.PAGE_ID,
                        SysTables.SYS_PAGE_INFO_HIS.DEF_JSON,

                }
        );

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
        SysPageInfoHisGtr g=new SysPageInfoHisGtr();
        //生成代码
        g.generateCode();

       // g.generateMenu(PageInfoHisServiceProxy.class, PageInfoHisPageController.class);
        //生成菜单
     //  g.generateMenu(DashboardServiceProxy.class, DashboardPageController.class);
    }

}
