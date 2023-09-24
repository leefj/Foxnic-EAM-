package com.dt.platform.generator.module.oa;

import com.dt.platform.constants.db.OaTables;
import com.dt.platform.constants.enums.oa.NetDiskEncryptedEnum;
import com.dt.platform.constants.enums.oa.NetDiskStoragTypeEnum;
import com.dt.platform.constants.enums.oa.NetDiskStoreStatusEnum;
import com.dt.platform.generator.config.Config;
import com.dt.platform.oa.page.NetdiskStoragePageController;
import com.dt.platform.proxy.oa.NetdiskStorageServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class NetDiskStoreGtr extends BaseCodeGenerator {


    public NetDiskStoreGtr() {
        super(OaTables.OA_NETDISK_STORAGE.$TABLE,"755784921531809792");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(OaTables.OA_NETDISK_STORAGE.ID).basic().hidden(true);

        cfg.view().search().disable();
        cfg.view().list().disableBatchDelete();
        cfg.view().list().disableSingleDelete();
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().bottomSpace(50);

        cfg.view().field(OaTables.OA_NETDISK_STORAGE.NAME).form().validate().required();

        cfg.view().field(OaTables.OA_NETDISK_STORAGE.CODE).form().validate().required();

        cfg.view().field(OaTables.OA_NETDISK_STORAGE.STATUS).form().validate().required().
                form().radioBox().enumType(NetDiskStoreStatusEnum.class).defaultIndex(0);



        cfg.view().field(OaTables.OA_NETDISK_STORAGE.CODE).form().validate().required().
                form().radioBox().enumType(NetDiskStoragTypeEnum.class).defaultIndex(0);



        cfg.view().field(OaTables.OA_NETDISK_STORAGE.ENCRYPTED).form().validate().required().
                form().radioBox().enumType(NetDiskEncryptedEnum.class).defaultIndex(0);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.IGNORE) //表单HTML页
                .setListPage(WriteMode.IGNORE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        NetDiskStoreGtr g=new NetDiskStoreGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
     //   g.generateMenu(NetdiskStorageServiceProxy.class, NetdiskStoragePageController.class);
    }

}
