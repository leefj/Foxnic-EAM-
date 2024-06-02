package com.dt.platform.generator.module.ops;


import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.common.YesNoEnum;
import com.dt.platform.domain.ops.*;
import com.dt.platform.domain.ops.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.ops.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.BusiRole;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.BusiRoleMeta;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.BusiRoleServiceProxy;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;


public class MonitorAlertBookGtr extends BaseCodeGenerator{


    public MonitorAlertBookGtr() {
        super(OpsTables.OPS_MONITOR_ALERT_BOOK.$TABLE,"474155549546512385");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_MONITOR_ALERT_BOOK.NAME,
                }
        );


        cfg.getPoClassFile().addListProperty(BusiRole.class,"userGroupList","人员群组","人员群组");
        cfg.getPoClassFile().addListProperty(String.class,"userGroupIds","人员群组","人员群组");
        cfg.getPoClassFile().addListProperty(Employee.class,"userGroupUserList","userGroupUserList","userGroupUserList");
        cfg.getPoClassFile().addListProperty(Employee.class,"userList","人员","人员");
        cfg.getPoClassFile().addListProperty(String.class,"userIds","人员","人员");





        cfg.getPoClassFile().addListProperty(MonitorNodeGroup.class,"nodeGroupList","nodeGroupList","nodeGroupList");
        cfg.getPoClassFile().addListProperty(String.class,"nodeGroupIds","nodeGroupIds","nodeGroupIds");

        cfg.getPoClassFile().addListProperty(MonitorNode.class,"nodeList","nodeList","nodeList");
        cfg.getPoClassFile().addListProperty(String.class,"nodeIds","nodeIds","nodeIds");

        cfg.getPoClassFile().addListProperty(DictItem.class,"levelList","levelList","levelList");
        cfg.getPoClassFile().addListProperty(String.class,"levelIds","levelIds","levelIds");

        cfg.getPoClassFile().addListProperty(MonitorAlertMethod.class,"alertMethodList","alertMethodList","alertMethodList");
        cfg.getPoClassFile().addListProperty(String.class,"alertMethodIds","alertMethodIds","alertMethodIds");






        //ops_alert_level
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);


        cfg.view().search().inputWidth(Config.searchInputWidth);

       // cfg.view().search().disable();
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_BOOK.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_BOOK.ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_BOOK.CREATE_TIME).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_BOOK.UPDATE_BY).table().disable(true);

        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_BOOK.NAME).form().validate().required();
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_BOOK.STATUS).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class);



        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_BOOK.NOTES).form().textArea().height(150);
        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_BOOK.NOTES).table().disable(true);


        cfg.view().field(OpsTables.OPS_MONITOR_ALERT_BOOK.MONITOR_IS_ALL).form().radioBox().enumType(YesNoEnum.class);


        cfg.view().field(MonitorAlertBookMeta.NODE_GROUP_IDS).basic().label("节点组").table().disable(false);
        cfg.view().field(MonitorAlertBookMeta.NODE_IDS).basic().label("节点").table().disable(false);
        cfg.view().field(MonitorAlertBookMeta.LEVEL_IDS).basic().label("告警等级").table().disable(false);
        cfg.view().field(MonitorAlertBookMeta.ALERT_METHOD_IDS).basic().label("告警方式").table().disable(false);


        cfg.view().field(MonitorAlertBookMeta.USER_GROUP_IDS).basic().label("用户组").table().disable(false);
        cfg.view().field(MonitorAlertBookMeta.USER_IDS).basic().label("用户").table().disable(true);


        cfg.view().field(MonitorAlertBookMeta.ALERT_METHOD_IDS)
                .form().validate().required().form().selectBox().queryApi(MonitorAlertMethodServiceProxy.QUERY_PAGED_LIST)
                .valueField(MonitorAlertMethodMeta.ID).textField(MonitorAlertMethodMeta.NAME)
                .toolbar(false).paging(true)
                .fillWith(MonitorAlertBookMeta.ALERT_METHOD_LIST).muliti(true);

        cfg.view().field(MonitorAlertBookMeta.LEVEL_IDS)
                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=ops_alert_level")
                .valueField(DictItemMeta.CODE).textField(DictItemMeta.LABEL)
                .toolbar(false).paging(false)
                .fillWith(MonitorAlertBookMeta.LEVEL_LIST).muliti(true);

        cfg.view().field(MonitorAlertBookMeta.NODE_GROUP_IDS)
                .form().selectBox().queryApi(MonitorNodeGroupServiceProxy.QUERY_PAGED_LIST)
                .valueField(MonitorNodeGroupMeta.ID).textField(MonitorNodeGroupMeta.NAME)
                .toolbar(false).paging(true)
                .fillWith(MonitorAlertBookMeta.NODE_GROUP_LIST).muliti(true);

        cfg.view().field(MonitorAlertBookMeta.NODE_IDS)
                .form().selectBox().queryApi(MonitorNodeServiceProxy.QUERY_PAGED_LIST)
                .valueField(MonitorNodeMeta.ID).textField(MonitorNodeMeta.NODE_NAME_SHOW)
                .toolbar(false).paging(true)
                .fillWith(MonitorAlertBookMeta.NODE_LIST).muliti(true);

        cfg.view().field(MonitorAlertBookMeta.USER_GROUP_IDS)
                .form().selectBox().queryApi(BusiRoleServiceProxy.QUERY_PAGED_LIST)
                .valueField(BusiRoleMeta.ID).textField(BusiRoleMeta.NAME)
                .toolbar(false).paging(true)
                .fillWith(MonitorAlertBookMeta.USER_GROUP_LIST).muliti(true);


        cfg.view().field(MonitorAlertBookMeta.USER_IDS).form()
                .button().chooseEmployee(false);



        cfg.view().list().disableBatchDelete();

        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_MONITOR_ALERT_BOOK.NAME,
                },
                new Object[] {
                        OpsTables.OPS_MONITOR_ALERT_BOOK.STATUS,
                }
        );
        cfg.view().form().addGroup("告警范围",
                new Object[] {
                        OpsTables.OPS_MONITOR_ALERT_BOOK.MONITOR_IS_ALL,
                        MonitorAlertBookMeta.NODE_GROUP_IDS,
                        MonitorAlertBookMeta.NODE_IDS,
                        MonitorAlertBookMeta.LEVEL_IDS,
                        MonitorAlertBookMeta.ALERT_METHOD_IDS,
                }
        );
        cfg.view().form().addGroup("发送对象",
                new Object[] {
                        MonitorAlertBookMeta.USER_GROUP_IDS,
                        MonitorAlertBookMeta.USER_IDS,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_MONITOR_ALERT_BOOK.NOTES
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
        MonitorAlertBookGtr g=new MonitorAlertBookGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
    //   g.generateMenu(MonitorObjectTypeMapServiceProxy.class, MonitorObjectTypeMapPageController.class);

       //g.generateMenu(MonitorAlertBookServiceProxy.class, MonitorAlertBookPageController.class);
    }
}
