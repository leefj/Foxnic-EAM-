package com.dt.platform.generator.module.oa;

import com.dt.platform.constants.db.OaTables;
import com.dt.platform.constants.enums.oa.NetDiskShareExpirationMethodEnum;
import com.dt.platform.constants.enums.oa.NetDiskShareStatusEnum;
import com.dt.platform.constants.enums.oa.NetDiskShareTypeEnum;
import com.dt.platform.domain.oa.NetdiskFile;
import com.dt.platform.domain.oa.NetdiskOriginFile;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class NetDiskMyShareGtr extends BaseCodeGenerator {


    public NetDiskMyShareGtr() {
        super(OaTables.OA_NETDISK_MY_SHARE.$TABLE,"755784921531809792");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(NetdiskFile.class,"netdiskFile","netdiskFile","netdiskFile");
        cfg.getPoClassFile().addSimpleProperty(NetdiskOriginFile.class,"netdiskOriginFile","netdiskOriginFile","netdiskOriginFile");


        cfg.view().field(OaTables.OA_NETDISK_MY_SHARE.ID).basic().hidden(true);


        cfg.getPoClassFile().addSimpleProperty(Employee.class,"ownerUser","ownerUser","ownerUser");
        cfg.view().field(OaTables.OA_NETDISK_MY_SHARE.USER_ID).table().fillBy("ownerUser","name");
        cfg.view().field(OaTables.OA_NETDISK_MY_SHARE.USER_ID).form().button().chooseEmployee(true);



        cfg.view().field(OaTables.OA_NETDISK_MY_SHARE.TYPE).form().validate().required().form().radioBox().enumType(NetDiskShareTypeEnum.class);
        cfg.view().field(OaTables.OA_NETDISK_MY_SHARE.EXPIRATION_METHOD).form().validate().required().form().radioBox().enumType(NetDiskShareExpirationMethodEnum.class);

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().bottomSpace(50);

        cfg.view().search().disable();
        cfg.view().list().disableBatchDelete();
        cfg.view().list().disableSingleDelete();
        cfg.view().list().disableModify();
        cfg.view().list().disableCreateNew();
        cfg.view().list().disableFormView();
        cfg.view().list().disableSpaceColumn();

        cfg.view().field(OaTables.OA_NETDISK_MY_SHARE.USER_ID).table().disable(true);
        cfg.view().field(OaTables.OA_NETDISK_MY_SHARE.STATUS).form().validate().required().form().radioBox().enumType(NetDiskShareStatusEnum.class);

//        cfg.view().field(OaTables.OA_NETDISK_MY_SHARE.EXPIRATION_METHOD).form().validate().required().
//                form().radioBox().enumType(NetDiskFileShareExpirationMethodEnum.class).defaultIndex(0);

        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_NETDISK_MY_SHARE.USER_ID,
                        OaTables.OA_NETDISK_MY_SHARE.FILE_ID,
                        OaTables.OA_NETDISK_MY_SHARE.EXPIRATION_METHOD,
                        OaTables.OA_NETDISK_MY_SHARE.STATUS,
                }
        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.IGNORE) //表单HTML页
                .setListPage(WriteMode.WRITE_TEMP_FILE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        NetDiskMyShareGtr g=new NetDiskMyShareGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
       // g.generateMenu(NetdiskMyShareServiceProxy.class, NetdiskMySharePageController.class);
    }

}
