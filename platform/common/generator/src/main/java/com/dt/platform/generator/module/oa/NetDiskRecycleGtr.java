package com.dt.platform.generator.module.oa;

import com.dt.platform.constants.db.OaTables;
import com.dt.platform.domain.oa.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.oa.page.NetdiskRecyclePageController;
import com.dt.platform.oa.page.NetdiskVirtualFdPageController;
import com.dt.platform.proxy.oa.NetdiskRecycleServiceProxy;
import com.dt.platform.proxy.oa.NetdiskVirtualFdServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class NetDiskRecycleGtr extends BaseCodeGenerator {


    public NetDiskRecycleGtr() {
        super(OaTables.OA_NETDISK_RECYCLE.$TABLE,"755784921531809792");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(OaTables.OA_NETDISK_RECYCLE.ID).basic().hidden(true);

        cfg.getPoClassFile().addSimpleProperty(NetdiskFile.class,"netdiskFile","netdiskFile","netdiskFile");
        cfg.getPoClassFile().addSimpleProperty(NetdiskOriginFile.class,"netdiskOriginFile","netdiskOriginFile","netdiskOriginFile");
        cfg.getPoClassFile().addSimpleProperty(NetdiskFolder.class,"netdiskFolder","netdiskFolder","netdiskFolder");


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().bottomSpace(50);

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"ownerUser","ownerUser","ownerUser");
        cfg.view().field(OaTables.OA_NETDISK_RECYCLE.USER_ID).table().fillBy("ownerUser","name");
        cfg.view().field(OaTables.OA_NETDISK_RECYCLE.USER_ID).form().button().chooseEmployee(true);



        cfg.view().search().disable();
        cfg.view().list().disableBatchDelete();
        cfg.view().list().disableSingleDelete();
        cfg.view().list().disableModify();
        cfg.view().list().disableCreateNew();
        cfg.view().list().disableFormView();
        cfg.view().list().disableSpaceColumn();
        cfg.view().field(OaTables.OA_NETDISK_RECYCLE.USER_ID).table().disable(true);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_NETDISK_RECYCLE.FD_ID,
                }
        );

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
        NetDiskRecycleGtr g=new NetDiskRecycleGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
     //  g.generateMenu(NetdiskVirtualFdServiceProxy.class, NetdiskVirtualFdPageController.class);
    }

}
