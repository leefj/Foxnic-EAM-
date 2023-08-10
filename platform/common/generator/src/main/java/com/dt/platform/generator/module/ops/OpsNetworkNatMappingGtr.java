package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.domain.ops.NetworkNatMap;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.NetworkNatMapPageController;
import com.dt.platform.proxy.ops.NetworkNatMapServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class OpsNetworkNatMappingGtr extends BaseCodeGenerator{


    public OpsNetworkNatMappingGtr() {
        super(OpsTables.OPS_NETWORK_NAT_MAP.$TABLE,"605507841310064640");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        //node type

        cfg.view().field(OpsTables.OPS_NETWORK_NAT_MAP.ID).basic().hidden(true);

        cfg.view().field(OpsTables.OPS_NETWORK_NAT_MAP.LABEL).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_NETWORK_NAT_MAP.NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_NETWORK_NAT_MAP.NAT_IPV4).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_NETWORK_NAT_MAP.SOURCE_IPV4).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_NETWORK_NAT_MAP.NAME,
                        OpsTables.OPS_NETWORK_NAT_MAP.LABEL,
                        OpsTables.OPS_NETWORK_NAT_MAP.NAT_IPV4,
                        OpsTables.OPS_NETWORK_NAT_MAP.SOURCE_IPV4,
                }
        );

        cfg.view().field(OpsTables.OPS_NETWORK_NAT_MAP.NOTES).form().textArea().height(Config.textAreaHeight);
        cfg.view().field(OpsTables.OPS_NETWORK_NAT_MAP.NAT_IPV4).form().textArea().height(Config.textAreaHeight);
        cfg.view().field(OpsTables.OPS_NETWORK_NAT_MAP.SOURCE_IPV4).form().textArea().height(Config.textAreaHeight);
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);

        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().list().disableBatchDelete();
        cfg.view().list().excel(true,true);


        cfg.view().field(OpsTables.OPS_NETWORK_NAT_MAP.CREATE_TIME).table().disable(true);


        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_NETWORK_NAT_MAP.NAME,
                        OpsTables.OPS_NETWORK_NAT_MAP.LABEL,


                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_NETWORK_NAT_MAP.NAT_IPV4,

                },
                new Object[] {

                        OpsTables.OPS_NETWORK_NAT_MAP.SOURCE_IPV4,
                }
        );



        cfg.view().form().addGroup(null,
                new Object[] {



                        OpsTables.OPS_NETWORK_NAT_MAP.NOTES,
                }
        );


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setBpmEventAdaptor(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        OpsNetworkNatMappingGtr g=new OpsNetworkNatMappingGtr();
        //生成代码
        g.generateCode();

     //   g.generateMenu(NetworkNatMapServiceProxy.class, NetworkNatMapPageController.class);

    }
}
