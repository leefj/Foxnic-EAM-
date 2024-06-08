package com.dt.platform.generator.module.ops;
import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.ops.MonitorEnableEnum;
import com.dt.platform.constants.enums.ops.MonitorWarnLevelEnum;
import com.dt.platform.constants.enums.ops.OpsTriggerRuleTypeEnum;
import com.dt.platform.domain.ops.MonitorNode;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.meta.MonitorTplMeta;
import com.dt.platform.domain.ops.meta.MonitorTplTriggerMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.MonitorNodeTriggerPageController;
import com.dt.platform.proxy.ops.MonitorNodeTriggerServiceProxy;
import com.dt.platform.proxy.ops.MonitorTplServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class MonitorTriggerGtr extends BaseCodeGenerator{


    public MonitorTriggerGtr() {
        super(OpsTables.OPS_MONITOR_NODE_TRIGGER.$TABLE,MONITOR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(MonitorTpl.class,"tpl","节点模版","节点模版");

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_MONITOR_NODE_TRIGGER.STATUS,
                       OpsTables.OPS_MONITOR_NODE_TRIGGER.NAME,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(OpsTables.OPS_MONITOR_NODE_TRIGGER.NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_MONITOR_NODE_TRIGGER.NOTES).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_MONITOR_NODE_TRIGGER.MONITOR_TPL_CODE).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_MONITOR_NODE_TRIGGER.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_MONITOR_NODE_TRIGGER.ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_NODE_TRIGGER.CREATE_TIME).table().disable(true);

        cfg.view().field(OpsTables.OPS_MONITOR_NODE_TRIGGER.STATUS).form().validate().required().form()
                .label("状态").radioBox().defaultIndex(0).enumType(MonitorEnableEnum.class);

        cfg.view().field(OpsTables.OPS_MONITOR_NODE_TRIGGER.NOTES).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_NODE_TRIGGER.UPDATE_BY).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_NODE_TRIGGER.CONTENT_VALUE).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_NODE_TRIGGER.CONTENT_VALUE).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_NODE_TRIGGER.MONITOR_TPL_CODE).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_NODE_TRIGGER.RULE).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_NODE_TRIGGER.NODE_ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_NODE_TRIGGER.TRIGGER_ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_NODE_TRIGGER.RULE).form().validate().required().form().textArea().height(Config.textAreaHeight);
        cfg.view().field(OpsTables.OPS_MONITOR_NODE_TRIGGER.NOTES).form().textArea().height(Config.textAreaHeight);

        cfg.view().field(OpsTables.OPS_MONITOR_NODE_TRIGGER.CONTENT_VALUE).form().validate().required();

        cfg.view().field(OpsTables.OPS_MONITOR_NODE_TRIGGER.WARN_LEVEL).form().validate().required().form()
                .label("告警等级").selectBox().enumType(MonitorWarnLevelEnum.class);

        cfg.view().field(OpsTables.OPS_MONITOR_NODE_TRIGGER.RULE_TYPE).form().validate().required().form()
                .radioBox().enumType(OpsTriggerRuleTypeEnum.class);

        cfg.view().field(OpsTables.OPS_MONITOR_NODE_TRIGGER.MONITOR_TPL_CODE)
                .form().validate().required().form().selectBox().queryApi(MonitorTplServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(MonitorTplMeta.CODE).
                textField(MonitorTplMeta.NAME).
                fillWith(MonitorTplTriggerMeta.TPL).muliti(false);

        cfg.view().field(OpsTables.OPS_MONITOR_NODE_TRIGGER.NAME).form().validate().required();

        cfg.view().formWindow().bottomSpace(80);
        cfg.view().formWindow().width(Config.baseFormWidth);

        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_MONITOR_NODE_TRIGGER.NAME,
                        OpsTables.OPS_MONITOR_NODE_TRIGGER.STATUS,

                },
                new Object[] {
                        OpsTables.OPS_MONITOR_NODE_TRIGGER.RULE_TYPE,

                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_MONITOR_NODE_TRIGGER.WARN_LEVEL,
                        OpsTables.OPS_MONITOR_NODE_TRIGGER.RULE,
                        OpsTables.OPS_MONITOR_NODE_TRIGGER.CONTENT_VALUE,
                        OpsTables.OPS_MONITOR_TPL_TRIGGER.NOTES,
                }
        );


        cfg.view().list().addJsVariable("NODE_ID","[[${nodeId}]]","nodeId");



        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setBpmEventAdaptor(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        MonitorTriggerGtr g=new MonitorTriggerGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
      //  g.generateMenu(MonitorNodeTriggerServiceProxy.class, MonitorNodeTriggerPageController.class);


    }
}
