package com.dt.platform.generator.module.oa;

import com.dt.platform.constants.db.OaTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.oa.NetDiskMenuShowEnum;
import com.dt.platform.constants.enums.oa.NetDiskMenuTypeEnum;
import com.dt.platform.generator.config.Config;
import com.dt.platform.oa.page.NetdiskMenuPageController;
import com.dt.platform.proxy.oa.NetdiskMenuServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class NetDiskMenuGtr extends BaseCodeGenerator {


    public NetDiskMenuGtr() {
        super(OaTables.OA_NETDISK_MENU.$TABLE,"755784921531809792");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(OaTables.OA_NETDISK_MENU.ID).basic().hidden(true);
        cfg.view().field(OaTables.OA_NETDISK_MENU.NAME).search().fuzzySearch();
        cfg.view().search().disable();
        cfg.view().list().disableBatchDelete();
        cfg.view().list().disableSingleDelete();

        cfg.view().field(OaTables.OA_NETDISK_MENU.CODE).form().readOnly();
        cfg.view().field(OaTables.OA_NETDISK_MENU.NAME).form().validate().required();
        cfg.view().field(OaTables.OA_NETDISK_MENU.SORT_VALUE).form().validate().required();
        cfg.view().field(OaTables.OA_NETDISK_MENU.CODE).form().validate().required();
        cfg.view().field(OaTables.OA_NETDISK_MENU.TYPE).form().validate().required().form().radioBox().enumType(NetDiskMenuTypeEnum.class).defaultIndex(0);
        cfg.view().field(OaTables.OA_NETDISK_MENU.SHOW_VALUE).form().validate().required().form().radioBox().enumType(NetDiskMenuShowEnum.class).defaultIndex(0);
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().bottomSpace(50);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_NETDISK_MENU.CODE,
                        OaTables.OA_NETDISK_MENU.NAME,
                        OaTables.OA_NETDISK_MENU.SHOW_VALUE,
                        OaTables.OA_NETDISK_MENU.ICON_CODE,
                        OaTables.OA_NETDISK_MENU.TYPE,
                        OaTables.OA_NETDISK_MENU.SORT_VALUE,
                }
        );
        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.WRITE_TEMP_FILE) //表单HTML页
                .setListPage(WriteMode.WRITE_TEMP_FILE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        NetDiskMenuGtr g=new NetDiskMenuGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
       // g.generateMenu(NetdiskMenuServiceProxy.class, NetdiskMenuPageController.class);
    }

}
