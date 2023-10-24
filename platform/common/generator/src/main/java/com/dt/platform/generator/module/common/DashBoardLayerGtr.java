package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.DashboardLayerPageController;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.DashBoardColTypeEnum;
import com.dt.platform.constants.enums.common.DashBoardLayerElTypeEnum;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.common.DashboardLayer;
import com.dt.platform.domain.common.DashboardLayerEle;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.DashboardLayerServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class DashBoardLayerGtr extends BaseCodeGenerator {

    public DashBoardLayerGtr() {
        super(SysTables.SYS_DASHBOARD_LAYER.$TABLE,"715811803308752896");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addListProperty(DashboardLayer.class,"dashboardLayerEle","dashboardLayerEle","dashboardLayerEle");

        cfg.getPoClassFile().addListProperty(DashboardLayerEle.class,"dashboardLayerEleValid","dashboardLayerEleValid","dashboardLayerEleValid");


        cfg.view().field(SysTables.SYS_DASHBOARD_LAYER.ID).basic().hidden(true);
        cfg.view().field(SysTables.SYS_DASHBOARD_LAYER.COL_TYPE).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_DASHBOARD_LAYER.STATUS,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(SysTables.SYS_DASHBOARD_LAYER.CREATE_TIME).table().disable(true);
        cfg.view().field(SysTables.SYS_DASHBOARD_LAYER.UPDATE_BY).table().disable(true);
        cfg.view().field(SysTables.SYS_DASHBOARD_LAYER.NAME).form().validate().required();
        cfg.view().field(SysTables.SYS_DASHBOARD_LAYER.COL_TYPE).form().validate().required().form()
                .selectBox().enumType(DashBoardColTypeEnum.class).defaultIndex(0).muliti(false);
        cfg.view().field(SysTables.SYS_DASHBOARD_LAYER.DASHBOARD_ID).table().disable(true);
        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_DASHBOARD_LAYER.NAME,
                        SysTables.SYS_DASHBOARD_LAYER.STATUS,
                        SysTables.SYS_DASHBOARD_LAYER.COL_TYPE,
                        SysTables.SYS_DASHBOARD_LAYER.SORT,
                }
        );

        cfg.view().field(SysTables.SYS_DASHBOARD_LAYER.STATUS).form().validate().required().form()
                .radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);



        cfg.view().list().addJsVariable("DASHBOARD_ID","[[${dashBoardId}]]","dashBoardId");
        cfg.view().form().addJsVariable("DASHBOARD_ID","[[${dashBoardId}]]","dashBoardId");
        cfg.view().list().disableBatchDelete();

        //文件生成覆盖模式
        cfg.overrides()
               .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        DashBoardLayerGtr g=new DashBoardLayerGtr();

        //生成代码
        g.generateCode();

        //生成菜单
      //  g.generateMenu(ScreenServiceProxy.class, ScreenPageController.class);
    //   g.generateMenu(DashboardLayerServiceProxy.class, DashboardLayerPageController.class);
    }

}
