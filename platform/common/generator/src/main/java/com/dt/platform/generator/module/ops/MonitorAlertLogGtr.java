package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.ops.MonitorAlertMethodProcessStatusEnum;
import com.dt.platform.domain.ops.DbInfoApply;
import com.dt.platform.domain.ops.MonitorAlert;
import com.dt.platform.domain.ops.MonitorAlertLog;
import com.dt.platform.domain.ops.MonitorAlertMethod;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.MonitorAlertLogPageController;
import com.dt.platform.proxy.ops.MonitorAlertLogServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class MonitorAlertLogGtr extends BaseCodeGenerator{


    public MonitorAlertLogGtr() {
        super(OpsTables.OPS_MONITOR_ALERT_LOG.$TABLE,"844676703916654592");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(MonitorAlertMethod.class,"monitorAlertMethod","monitorAlertMethod","monitorAlertMethod");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"sendUser","sendUser","sendUser");

        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_LOG.ALERT_METHOD).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_LOG.MSG).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_MONITOR_ALERT_LOG.ACTION_RESULT_STATUS,
                        OpsTables.OPS_MONITOR_ALERT_LOG.USER_ID,
                        OpsTables.OPS_MONITOR_ALERT_LOG.ALERT_METHOD,
                        OpsTables.OPS_MONITOR_ALERT_LOG.MSG,
                },
                new Object[]{
                        OpsTables.OPS_MONITOR_ALERT_LOG.RCD_TIME,
                }
        );

        cfg.view().list().disableBatchDelete();
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_LOG.RCD_TIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").search().range();


        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_LOG.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_LOG.ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_LOG.ALERT_ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_LOG.CREATE_TIME).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_LOG.UPDATE_BY).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_LOG.NOTES).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_LOG.ACTION_RESULT).table().disable(true);

        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_LOG.ACTION_RESULT_STATUS).form().radioBox().enumType(MonitorAlertMethodProcessStatusEnum.class);


        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_LOG.MSG).form().textArea().height(250);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_LOG.ACTION_RESULT).form().textArea().height(120);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_LOG.NOTES).form().textArea().height(120);


        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_LOG.USER_ID).table().fillBy("sendUser","name");
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_LOG.USER_ID).form()
                .button().chooseEmployee(true);


        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_MONITOR_ALERT_LOG.USER_ID,
                },
                new Object[] {
                        OpsTables.OPS_MONITOR_ALERT_LOG.RCD_TIME,
                }
        );

        cfg.view().form().addGroup("处理结果",
                new Object[] {
                        OpsTables.OPS_MONITOR_ALERT_LOG.ALERT_METHOD,
                },
                new Object[] {
                        OpsTables.OPS_MONITOR_ALERT_LOG.ACTION_RESULT_STATUS,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_MONITOR_ALERT_LOG.ACTION_RESULT,
                }
        );

        cfg.view().form().addGroup("通知内容",
                new Object[] {
                        OpsTables.OPS_MONITOR_ALERT_LOG.MSG,
                        OpsTables.OPS_MONITOR_ALERT_LOG.NOTES,
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
        MonitorAlertLogGtr g=new MonitorAlertLogGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
        //g.generateMenu(MonitorAlertLogServiceProxy.class, MonitorAlertLogPageController.class);
    }
}
