package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.DashboardLayerElePageController;
import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.DashBoardColTypeEnum;
import com.dt.platform.constants.enums.common.DashBoardLayerElTypeEnum;
import com.dt.platform.constants.enums.common.ScreenStatusEnum;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.common.DashboardLayer;
import com.dt.platform.domain.common.DashboardLayerEle;
import com.dt.platform.domain.common.Report;
import com.dt.platform.domain.common.ReportUDef;
import com.dt.platform.domain.common.meta.CodeRuleMeta;
import com.dt.platform.domain.common.meta.DashboardLayerEleMeta;
import com.dt.platform.domain.common.meta.DashboardLayerMeta;
import com.dt.platform.domain.common.meta.ReportMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.DashboardLayerEleServiceProxy;
import com.dt.platform.proxy.common.DashboardLayerServiceProxy;
import com.dt.platform.proxy.common.ReportServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.oauth.meta.MenuMeta;
import org.github.foxnic.web.proxy.oauth.MenuServiceProxy;

public class DashBoardLayerElsGtr extends BaseCodeGenerator {

    public DashBoardLayerElsGtr() {
        super(SysTables.SYS_DASHBOARD_LAYER_ELE.$TABLE,"715811803308752896");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(DashboardLayer.class,"dashboardLayer","dashboardLayer","dashboardLayer");
        cfg.getPoClassFile().addSimpleProperty(Report.class,"reportChart","reportChart","reportChart");
        cfg.view().field(SysTables.SYS_DASHBOARD_LAYER_ELE.ID).basic().hidden(true);


        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_DASHBOARD_LAYER_ELE.STATUS,

                }
        );



        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(SysTables.SYS_DASHBOARD_LAYER_ELE.CREATE_TIME).table().disable(true);

        cfg.view().field(SysTables.SYS_DASHBOARD_LAYER_ELE.DASHBOARD_ID).table().disable(true);
        cfg.view().field(SysTables.SYS_DASHBOARD_LAYER_ELE.UPDATE_BY).table().disable(true);
        cfg.view().field(SysTables.SYS_DASHBOARD_LAYER_ELE.TYPE).form().validate().required().form()
                .selectBox().enumType(DashBoardLayerElTypeEnum.class).defaultIndex(0).muliti(false);
        cfg.view().field(SysTables.SYS_DASHBOARD_LAYER_ELE.TITLE).form().validate().required();

        cfg.view().formWindow().bottomSpace(150);
        cfg.view().formWindow().width(Config.baseFormWidth);;


        cfg.view().field(SysTables.SYS_DASHBOARD_LAYER_ELE.STATUS).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);

        cfg.view().field(SysTables.SYS_DASHBOARD_LAYER_ELE.JSON).form().validate().required().form().textArea().height(150).defaultText("{}");
        cfg.view().field(SysTables.SYS_DASHBOARD_LAYER_ELE.NOTES).form().textArea().height(120);

        cfg.view().field(SysTables.SYS_DASHBOARD_LAYER_ELE.LAYER_ID)
                .form().validate().required()
                .form().selectBox().queryApi(DashboardLayerServiceProxy.QUERY_LIST).paging(false).filter(true).toolbar(false)
                .valueField(DashboardLayerMeta.ID).textField(DashboardLayerMeta.NAME).fillWith(DashboardLayerEleMeta.DASHBOARD_LAYER).muliti(false);

        cfg.view().field(SysTables.SYS_DASHBOARD_LAYER_ELE.SOURCE)
                .form().selectBox().queryApi(ReportServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(true)
                .valueField(ReportMeta.ID).textField(ReportMeta.NAME).fillWith(DashboardLayerEleMeta.REPORT_CHART).muliti(false);


        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_DASHBOARD_LAYER_ELE.TITLE,
                        SysTables.SYS_DASHBOARD_LAYER_ELE.LAYER_ID,
                        SysTables.SYS_DASHBOARD_LAYER_ELE.SOURCE,
                },
                new Object[] {
                        SysTables.SYS_DASHBOARD_LAYER_ELE.TYPE,
                        SysTables.SYS_DASHBOARD_LAYER_ELE.STATUS,
                        SysTables.SYS_DASHBOARD_LAYER_ELE.SORT,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_DASHBOARD_LAYER_ELE.JSON,
                        SysTables.SYS_DASHBOARD_LAYER_ELE.NOTES,

                }
        );
        cfg.view().list().addJsVariable("DASHBOARD_ID","[[${dashBoardId}]]","dashBoardId");
        cfg.view().form().addJsVariable("DASHBOARD_ID","[[${dashBoardId}]]","dashBoardId");
        cfg.view().list().disableBatchDelete();

        //文件生成覆盖模式
        cfg.overrides()
               .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.IGNORE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        DashBoardLayerElsGtr g=new DashBoardLayerElsGtr();

        //生成代码
        g.generateCode();

       // g.generateMenu(DashboardLayerEleServiceProxy.class, DashboardLayerElePageController.class);
        //生成菜单
      //  g.generateMenu(ScreenServiceProxy.class, ScreenPageController.class);
//       g.generateMenu(NodeLoadServiceProxy.class, NodeLoadPageController.class);
    }

}
