package com.dt.platform.generator.module.oa;

import com.dt.platform.constants.db.OaTables;
import com.dt.platform.constants.enums.oa.NetDiskMenuShowEnum;
import com.dt.platform.constants.enums.oa.NetDiskMenuTypeEnum;
import com.dt.platform.domain.oa.NetdiskFolder;
import com.dt.platform.generator.config.Config;
import com.dt.platform.oa.page.NetdiskFolderPageController;
import com.dt.platform.proxy.oa.NetdiskFolderServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class NetDiskFoldGtr extends BaseCodeGenerator {


    public NetDiskFoldGtr() {
        super(OaTables.OA_NETDISK_FOLDER.$TABLE,"755784921531809792");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(OaTables.OA_NETDISK_FOLDER.ID).basic().hidden(true);
        cfg.view().field(OaTables.OA_NETDISK_FOLDER.NAME).search().fuzzySearch();
        cfg.view().search().disable();
        cfg.view().list().disableBatchDelete();
        cfg.view().list().disableSingleDelete();


        cfg.getPoClassFile().addSimpleProperty(Employee.class,"ownerUser","ownerUser","ownerUser");
        cfg.view().field(OaTables.OA_NETDISK_FOLDER.USER_ID).table().fillBy("ownerUser","name");
        cfg.view().field(OaTables.OA_NETDISK_FOLDER.USER_ID).form().button().chooseEmployee(true);



        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().bottomSpace(50);

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
        NetDiskFoldGtr g=new NetDiskFoldGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
    //    g.generateMenu(NetdiskFolderServiceProxy.class, NetdiskFolderPageController.class);
    }

}
