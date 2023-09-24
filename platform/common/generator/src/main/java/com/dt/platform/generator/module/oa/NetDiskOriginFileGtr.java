package com.dt.platform.generator.module.oa;

import com.dt.platform.constants.db.OaTables;
import com.dt.platform.constants.enums.oa.NetDiskEncryptedEnum;
import com.dt.platform.constants.enums.oa.NetDiskFileTypeEnum;
import com.dt.platform.constants.enums.oa.NetDiskStoragTypeEnum;
import com.dt.platform.domain.oa.NetdiskOriginFile;
import com.dt.platform.generator.config.Config;
import com.dt.platform.oa.page.NetdiskOriginFilePageController;
import com.dt.platform.proxy.oa.NetdiskOriginFileServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class NetDiskOriginFileGtr extends BaseCodeGenerator {


    public NetDiskOriginFileGtr() {
        super(OaTables.OA_NETDISK_ORIGIN_FILE.$TABLE,"755784921531809792");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(OaTables.OA_NETDISK_ORIGIN_FILE.ID).basic().hidden(true);

        cfg.view().field(OaTables.OA_NETDISK_ORIGIN_FILE.CREATE_TIME).search().range();
        cfg.view().field(OaTables.OA_NETDISK_ORIGIN_FILE.FILE_NAME).search().fuzzySearch();



        cfg.getPoClassFile().addSimpleProperty(Employee.class,"ownerUser","ownerUser","ownerUser");
        cfg.view().field(OaTables.OA_NETDISK_ORIGIN_FILE.USER_ID).table().fillBy("ownerUser","name");
        cfg.view().field(OaTables.OA_NETDISK_ORIGIN_FILE.USER_ID).form().button().chooseEmployee(true);



        cfg.view().search().inputLayout(
                new Object[]{
                        OaTables.OA_NETDISK_ORIGIN_FILE.FILE_TYPE,
                        OaTables.OA_NETDISK_ORIGIN_FILE.STORAGE_TYPE,
                        OaTables.OA_NETDISK_ORIGIN_FILE.USER_ID,
                        OaTables.OA_NETDISK_ORIGIN_FILE.FILE_NAME,
                },
                new Object[]{
                        OaTables.OA_NETDISK_ORIGIN_FILE.ENCRYPTED,
                        OaTables.OA_NETDISK_ORIGIN_FILE.STORAGE_STORE_ID,
                        OaTables.OA_NETDISK_ORIGIN_FILE.CREATE_TIME,
                }
        );

        cfg.view().list().disableModify();
//        cfg.view().field(OaTables.OA_NETDISK_ORIGIN_FILE.LOCATION).table().disable(true);
        cfg.view().field(OaTables.OA_NETDISK_ORIGIN_FILE.ENCRYPTED).table().disable(true);
        cfg.view().field(OaTables.OA_NETDISK_ORIGIN_FILE.STORAGE_STORE_ID).table().disable(true);
        cfg.view().field(OaTables.OA_NETDISK_ORIGIN_FILE.MD5_VALUE).table().disable(true);
//        cfg.view().field(OaTables.OA_NETDISK_ORIGIN_FILE.REFERENCE_COUNT).table().disable(true);
//        cfg.view().field(OaTables.OA_NETDISK_ORIGIN_FILE.DOWNLOAD_COUNT).table().disable(true);

        cfg.view().field(OaTables.OA_NETDISK_ORIGIN_FILE.ENCRYPTED).form().validate().required().
                form().radioBox().enumType(NetDiskEncryptedEnum.class).defaultIndex(0);

        cfg.view().field(OaTables.OA_NETDISK_ORIGIN_FILE.FILE_TYPE).form().validate().required().
                form().selectBox().enumType(NetDiskFileTypeEnum.class).defaultIndex(0);

        cfg.view().field(OaTables.OA_NETDISK_ORIGIN_FILE.STORAGE_TYPE).form().validate().required().
                form().radioBox().enumType(NetDiskStoragTypeEnum.class).defaultIndex(0);

        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().search().rowsDisplay(1);
        cfg.view().list().disableBatchDelete();
        cfg.view().list().disableSingleDelete();
        cfg.view().list().disableCreateNew();
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().bottomSpace(50);

        cfg.view().form().addGroup("基本信息",
                new Object[] {
                        OaTables.OA_NETDISK_ORIGIN_FILE.FILE_NAME,
                        OaTables.OA_NETDISK_ORIGIN_FILE.FILE_TYPE,
                        OaTables.OA_NETDISK_ORIGIN_FILE.FILE_SIZE,

                },
                new Object[] {
                        OaTables.OA_NETDISK_ORIGIN_FILE.USER_ID,
                        OaTables.OA_NETDISK_ORIGIN_FILE.REFERENCE_COUNT,
                        OaTables.OA_NETDISK_ORIGIN_FILE.DOWNLOAD_COUNT,
                }

        );

        cfg.view().form().addGroup("存储信息",
                new Object[] {
                        OaTables.OA_NETDISK_ORIGIN_FILE.ENCRYPTED,
                        OaTables.OA_NETDISK_ORIGIN_FILE.MEDIA_TYPE,
                        OaTables.OA_NETDISK_ORIGIN_FILE.LOCATION,

                },
                new Object[] {
                        OaTables.OA_NETDISK_ORIGIN_FILE.MD5_VALUE,
                        OaTables.OA_NETDISK_ORIGIN_FILE.EXT_VALUE,
                        OaTables.OA_NETDISK_ORIGIN_FILE.STORAGE_TYPE,
                        OaTables.OA_NETDISK_ORIGIN_FILE.STORAGE_STORE_ID,

                }
        );



        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        NetDiskOriginFileGtr g=new NetDiskOriginFileGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
      //   g.generateMenu(NetdiskOriginFileServiceProxy.class, NetdiskOriginFilePageController.class);
    }

}
