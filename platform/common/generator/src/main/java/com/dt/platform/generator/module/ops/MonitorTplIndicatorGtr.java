package com.dt.platform.generator.module.ops;



import com.dt.platform.constants.enums.ops.MonitorEnableEnum;
import com.dt.platform.constants.enums.ops.MonitorIndicatorColumnRowColTypeEnum;
import com.dt.platform.constants.enums.ops.MonitorIndicatorValueColumnTypeEnum;
import com.dt.platform.constants.enums.ops.MonitorMethodEnum;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.MonitorTplIndicatorType;
import com.dt.platform.domain.ops.meta.MonitorTplIndicatorMeta;
import com.dt.platform.domain.ops.meta.MonitorTplIndicatorTypeMeta;
import com.dt.platform.domain.ops.meta.MonitorTplMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.ops.MonitorTplIndicatorTypeServiceProxy;
import com.dt.platform.proxy.ops.MonitorTplServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import com.dt.platform.constants.db.OpsTables;
public class MonitorTplIndicatorGtr extends BaseCodeGenerator{


    public MonitorTplIndicatorGtr() {
        super(OpsTables.OPS_MONITOR_TPL_INDICATOR.$TABLE,MONITOR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(MonitorTpl.class,"tpl","节点模版","节点模版");
        cfg.getPoClassFile().addSimpleProperty(MonitorTplIndicatorType.class,"monitorIndicatorType","指标类型","指标类型");
        cfg.view().search().rowsDisplay(1);
        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.MONITOR_TPL_CODE,
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.STATUS,
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.CODE,
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.NAME,

                },
                new Object[]{
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.LABEL,
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.COMMAND,
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.NOTES,

                }

        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.CODE).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.NOTES).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.COMMAND).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.COMMAND_VALUE).search().fuzzySearch();

        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.LABEL).search().fuzzySearch();


        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.LABEL).table().disable(true);

        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.UPDATE_BY).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.COMMAND_VALUE).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.COMMAND_VALUE).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.CREATE_TIME).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.SNMP_OID).table().disable(true);

        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.TIME_OUT).basic().label("超时时间(秒)");
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.INTERVAL_TIME).basic().label("间隔时间(秒)");
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.DATA_KEEP_DAY).basic().label("保留时间(天)");


        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.MONITOR_TPL_CODE)
                .basic().label("模版")
                .form().validate().required().form().selectBox().queryApi(MonitorTplServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(MonitorTplMeta.CODE).
                textField(MonitorTplMeta.NAME).
                fillWith(MonitorTplIndicatorMeta.TPL).muliti(false);


        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.INDICATOR_TYPE)
                .basic().label("指标类型")
                .form().validate().required().form().selectBox().queryApi(MonitorTplIndicatorTypeServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(MonitorTplIndicatorTypeMeta.CODE).
                textField(MonitorTplIndicatorTypeMeta.NAME).
                fillWith(MonitorTplIndicatorMeta.MONITOR_INDICATOR_TYPE).muliti(false);

        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.ROW_COL_TYPE).form().validate().required();
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.ROW_COL_TYPE).form().validate().required();


        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.VALUE_COLUMN_NAME).form().validate().required();
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.VALUE_COLUMN_MAP).form().validate().required();
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.VALUE_COLUMN).form().validate().required();
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.CODE).form().validate().required();
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.NAME).form().validate().required();
        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.NOTES).form().textArea().height(Config.textAreaHeight);

        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.STATUS).form().validate().required().form()
                .label("状态").radioBox().defaultIndex(0).enumType(MonitorEnableEnum.class);

        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.MONITOR_METHOD).form().validate().required().form()
                .label("采集方式").selectBox().enumType(MonitorMethodEnum.class);

        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.VALUE_COLUMN_TYPE).form().validate().required().form().form().validate().required().form()
                .label("数值类型").selectBox().enumType(MonitorIndicatorValueColumnTypeEnum.class);


        cfg.view().field(OpsTables.OPS_MONITOR_TPL_INDICATOR.ROW_COL_TYPE).form()
                .label("值行列数").validate().required().form().selectBox()
                .enumType(MonitorIndicatorColumnRowColTypeEnum.class).defaultIndex(0);


        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width("90%");


        cfg.view().form().addGroup("基本信息",
                new Object[] {
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.CODE,
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.NAME,

                },
                new Object[] {
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.MONITOR_TPL_CODE,
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.STATUS,

                },
                new Object[] {
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.INDICATOR_TYPE,
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.ITEM_SORT,
                }
        );
        cfg.view().form().addGroup("采集方式",
                new Object[] {
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.MONITOR_METHOD,
                },
                new Object[] {
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.INTERVAL_TIME,
                },
                new Object[] {
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.TIME_OUT,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.COMMAND,
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.INDICATOR_VARIABLE,
                }
        );


        cfg.view().form().addGroup("数据填充",
                new Object[] {
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.VALUE_COLUMN_TYPE,
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.VALUE_COLUMN_NAME,
                },
                new Object[] {
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.VALUE_COLUMN,
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.VALUE_COLUMN_MAP,
                },
                new Object[] {
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.ROW_COL_TYPE,

                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_MONITOR_TPL_INDICATOR.NOTES
                }
        );

        cfg.view().list().addJsVariable("TPL_CODE","[[${tplCode}]]","tplCode");
        cfg.view().form().addJsVariable("TPL_CODE","[[${tplCode}]]","tplCode");

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setBpmEventAdaptor(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        MonitorTplIndicatorGtr g=new MonitorTplIndicatorGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
       //  g.generateMenu(MonitorTplIndicatorServiceProxy.class, MonitorTplIndicatorPageController.class);
    }
}
