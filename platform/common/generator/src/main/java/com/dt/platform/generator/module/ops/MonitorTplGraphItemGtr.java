package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.ops.MonitorEnableEnum;
import com.dt.platform.constants.enums.ops.MonitorStatusEnum;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.MonitorTplGraphItem;
import com.dt.platform.domain.ops.meta.MonitorTplGraphMeta;
import com.dt.platform.domain.ops.meta.MonitorTplMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.MonitorTplGraphItemPageController;
import com.dt.platform.proxy.ops.MonitorTplGraphItemServiceProxy;
import com.dt.platform.proxy.ops.MonitorTplServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import com.dt.platform.constants.db.OpsTables;
public class MonitorTplGraphItemGtr extends BaseCodeGenerator{


    public MonitorTplGraphItemGtr() {
        super(OpsTables.OPS_MONITOR_TPL_GRAPH_ITEM.$TABLE,MONITOR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        //node type
        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_MONITOR_TPL_GRAPH_ITEM.NAME,
                        OpsTables.OPS_MONITOR_TPL_GRAPH_ITEM.INDICATOR_CODE,
                }
        );

        cfg.view().search().disable();

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(OpsTables.OPS_MONITOR_TPL_GRAPH_ITEM.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_GRAPH_ITEM.ID).table().disable(true);

        cfg.view().field(OpsTables.OPS_MONITOR_TPL_GRAPH_ITEM.NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_GRAPH_ITEM.INDICATOR_CODE).search().fuzzySearch();

        cfg.view().field(OpsTables.OPS_MONITOR_TPL_GRAPH_ITEM.CREATE_TIME).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_GRAPH_ITEM.GRAPH_ID).table().disable(true);

        cfg.view().field(OpsTables.OPS_MONITOR_TPL_GRAPH_ITEM.NAME).form().validate().required();
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_GRAPH_ITEM.INDICATOR_CODE).form().validate().required();
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_GRAPH_ITEM.ROUTE).form().validate().required();
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_GRAPH_ITEM.STATUS).form().validate().required().form().radioBox().defaultIndex(0).enumType(MonitorEnableEnum.class);;

        cfg.view().list().disableBatchDelete();

        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width("80%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_MONITOR_TPL_GRAPH_ITEM.NAME,
                        OpsTables.OPS_MONITOR_TPL_GRAPH_ITEM.STATUS,
                        OpsTables.OPS_MONITOR_TPL_GRAPH_ITEM.INDICATOR_CODE,
                        OpsTables.OPS_MONITOR_TPL_GRAPH_ITEM.ROUTE
                }
        );


        cfg.view().list().addJsVariable("PAGE_ACTION","[[${pageAction}]]","pageAction");
        cfg.view().list().addJsVariable("GRAPH_ID","[[${graphId}]]","graphId");
        cfg.view().form().addJsVariable("GRAPH_ID","[[${graphId}]]","graphId");

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        MonitorTplGraphItemGtr g=new MonitorTplGraphItemGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // g.generateMenu(MonitorTplGraphItemServiceProxy.class, MonitorTplGraphItemPageController.class);


    }
}
