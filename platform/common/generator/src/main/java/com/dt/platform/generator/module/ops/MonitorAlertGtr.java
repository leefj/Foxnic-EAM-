package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.ops.MonitorWarnLevelEnum;
import com.dt.platform.constants.enums.ops.MonitorWarnProcessStatusEnum;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.MonitorTplIndicator;
import com.dt.platform.domain.ops.MonitorTplTrigger;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.MonitorAlertPageController;
import com.dt.platform.ops.page.MonitorTplTypePageController;
import com.dt.platform.proxy.ops.MonitorAlertServiceProxy;
import com.dt.platform.proxy.ops.MonitorTplTypeServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class MonitorAlertGtr extends BaseCodeGenerator{


    public MonitorAlertGtr() {
        super(OpsTables.OPS_MONITOR_ALERT.$TABLE,MONITOR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(MonitorTpl.class,"tpl","节点模版","节点模版");
        cfg.getPoClassFile().addListProperty(MonitorTplTrigger.class,"monitorTplTrigger","monitorTplTrigger","monitorTplTrigger");

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_MONITOR_ALERT.STATUS,
                        OpsTables.OPS_MONITOR_ALERT.WARN_LEVEL,
                        OpsTables.OPS_MONITOR_ALERT.NODE_SHOW_NAME,
                        OpsTables.OPS_MONITOR_ALERT.TRIGGER_NAME,
                },
                new Object[]{
                        OpsTables.OPS_MONITOR_ALERT.TRIGGER_ID,
                        OpsTables.OPS_MONITOR_ALERT.MONITOR_TPL_CODE,
                        OpsTables.OPS_MONITOR_ALERT.NOTES,
                },
                new Object[]{
                        OpsTables.OPS_MONITOR_ALERT.WARN_TIME,
                        OpsTables.OPS_MONITOR_ALERT.HANDLED_TIME
                }
        );


        cfg.getPoClassFile().addSimpleProperty(Employee.class,"user","user","user");
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT.USER_ID).table().fillBy("user","name");
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT.USER_ID).form().readOnly()
                .button().chooseEmployee(true);

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().search().rowsDisplay(1);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT.WARN_TIME).search().range();
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT.HANDLED_TIME).search().range();
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT.TRIGGER_NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT.NODE_SHOW_NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT.NOTES).search().fuzzySearch();

        cfg.view().field(OpsTables.OPS_MONITOR_ALERT.PROCESS_MESSAGE).search().fuzzySearch();

        cfg.view().field(OpsTables.OPS_MONITOR_ALERT.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT.ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT.CREATE_TIME).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT.USER_ID).table().disable(true);


        cfg.view().field(OpsTables.OPS_MONITOR_ALERT.STATUS).form()
                .label("处理状态").selectBox().enumType(MonitorWarnProcessStatusEnum.class);

        cfg.view().field(OpsTables.OPS_MONITOR_ALERT.WARN_LEVEL).form()
                .label("告警等级").selectBox().enumType(MonitorWarnLevelEnum.class);

        cfg.view().field(OpsTables.OPS_MONITOR_ALERT.NODE_ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT.TRIGGER_ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT.CREATE_TIME).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT.NOTES).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT.USER_ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT.MONITOR_TPL_CODE).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT.TRIGGER_RULE_DESC).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT.PROCESS_MESSAGE).form().textArea().height(120);
        cfg.view().list().disableSingleDelete();
        cfg.view().list().disableBatchDelete();
        cfg.view().list().disableCreateNew();


        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width("85%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_MONITOR_ALERT.NODE_SHOW_NAME,
                        OpsTables.OPS_MONITOR_ALERT.WARN_LEVEL,
                },
                new Object[] {
                        OpsTables.OPS_MONITOR_ALERT.STATUS,
                        OpsTables.OPS_MONITOR_ALERT.WARN_TIME,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_MONITOR_ALERT.TRIGGER_NAME,
                        OpsTables.OPS_MONITOR_ALERT.TRIGGER_RULE_DESC,
                },
                new Object[] {
                        OpsTables.OPS_MONITOR_ALERT.ALERT_VALUE,
                }
        );

        cfg.view().form().addGroup("处理",
                new Object[] {
                        OpsTables.OPS_MONITOR_ALERT.HANDLED_TIME,


                },
                new Object[] {
                        OpsTables.OPS_MONITOR_ALERT.USER_ID,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_MONITOR_ALERT.PROCESS_MESSAGE,
                }
        );

      //  cfg.view().list().operationColumn().addActionButton("确认","process","process-button","ops_monitor_alert:process");

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        MonitorAlertGtr g=new MonitorAlertGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
        //zg.generateMenu(MonitorAlertServiceProxy.class, MonitorAlertPageController.class);
    }
}
