package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.DashboardPageController;
import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.ScreenStatusEnum;
import com.dt.platform.domain.common.Dashboard;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.DashboardServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class DashBoardGtr extends BaseCodeGenerator {

    public DashBoardGtr() {
        super(SysTables.SYS_DASHBOARD.$TABLE,"715811803308752896");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(SysTables.SYS_DASHBOARD.ID).basic().hidden(true);
        cfg.view().field(SysTables.SYS_DASHBOARD.NAME).search().fuzzySearch();
        cfg.view().field(SysTables.SYS_DASHBOARD.CODE).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_DASHBOARD.CODE,
                        SysTables.SYS_DASHBOARD.NAME,
                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(SysTables.SYS_DASHBOARD.CREATE_TIME).table().disable(true);
        cfg.view().field(SysTables.SYS_DASHBOARD.UPDATE_BY).table().disable(true);
        cfg.view().field(SysTables.SYS_DASHBOARD.CODE).form().validate().required();
        cfg.view().field(SysTables.SYS_DASHBOARD.NAME).form().validate().required();
        cfg.view().field(SysTables.SYS_DASHBOARD.NOTES).form().textArea().height(120);
        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width(Config.baseFormWidth);

        cfg.view().list().operationColumn().addActionButton("分层","layerFuc","layer-button");
        cfg.view().list().operationColumn().addActionButton("组件","layerEleFuc","layerEle-button");
        cfg.view().list().operationColumn().addActionButton("预览","review","review-button");
        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_DASHBOARD.CODE,
                        SysTables.SYS_DASHBOARD.NAME,
                        SysTables.SYS_DASHBOARD.NOTES,
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
        DashBoardGtr g=new DashBoardGtr();
        //生成代码
        g.generateCode();
        //生成菜单
     //  g.generateMenu(DashboardServiceProxy.class, DashboardPageController.class);
    }

}
