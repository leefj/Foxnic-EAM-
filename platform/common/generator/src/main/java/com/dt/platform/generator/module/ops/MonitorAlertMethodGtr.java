package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.ops.AutomaticEnableStatusEnum;
import com.dt.platform.constants.enums.ops.MonitorAlertMethodEnum;
import com.dt.platform.domain.ops.MonitorAlertMethod;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.MonitorAlertMethodPageController;
import com.dt.platform.proxy.ops.MonitorAlertMethodServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class MonitorAlertMethodGtr extends BaseCodeGenerator{


    public MonitorAlertMethodGtr() {
        super(OpsTables.OPS_MONITOR_ALERT_METHOD.$TABLE,"844676703916654592");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());



        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_MONITOR_ALERT_METHOD.STATUS,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);



        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_METHOD.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_METHOD.ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_METHOD.CREATE_TIME).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_METHOD.UPDATE_BY).table().disable(true);

        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_METHOD.NOTES).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_METHOD.BODY).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_METHOD.PS).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_METHOD.CMD).table().disable(true);

        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_METHOD.STATUS).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_METHOD.TYPE).form().readOnly().form().radioBox().enumType(MonitorAlertMethodEnum.class);


       // cfg.view().list().disableBatchDelete();
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_METHOD.NAME).form().validate().required();
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_METHOD.TYPE).form().readOnly();
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_METHOD.PS).form().textArea().height(150);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_METHOD.PS).form().textArea().height(150);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_METHOD.BODY).form().textArea().height(150);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_METHOD.NOTES).form().textArea().height(150);


      //  cfg.view().search().disable();

        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_MONITOR_ALERT_METHOD.NAME,
                        OpsTables.OPS_MONITOR_ALERT_METHOD.TYPE,
                },
                new Object[] {
                        OpsTables.OPS_MONITOR_ALERT_METHOD.STATUS,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_MONITOR_ALERT_METHOD.PS,
                        OpsTables.OPS_MONITOR_ALERT_METHOD.CMD,
                        OpsTables.OPS_MONITOR_ALERT_METHOD.BODY,
                        OpsTables.OPS_MONITOR_ALERT_METHOD.NOTES,
                }
        );

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
        MonitorAlertMethodGtr g=new MonitorAlertMethodGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
        //g.generateMenu(MonitorAlertMethodServiceProxy.class, MonitorAlertMethodPageController.class);
    }
}
