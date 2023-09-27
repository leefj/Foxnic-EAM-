package com.dt.platform.generator.module.oa;

import com.dt.platform.constants.db.OaTables;
import com.dt.platform.generator.config.Config;
import com.dt.platform.oa.page.NetdiskResourceLimitPageController;
import com.dt.platform.proxy.oa.NetdiskResourceLimitServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class NetDiskResourceLimitGtr extends BaseCodeGenerator {


    public NetDiskResourceLimitGtr() {
        super(OaTables.OA_NETDISK_RESOURCE_LIMIT.$TABLE,"755784921531809792");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(OaTables.OA_NETDISK_RESOURCE_LIMIT.ID).basic().hidden(true);
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"user","user","user");
        cfg.view().field(OaTables.OA_NETDISK_RESOURCE_LIMIT.USER_ID).table().fillBy("user","name");
        cfg.view().field(OaTables.OA_NETDISK_RESOURCE_LIMIT.USER_ID).form().button().chooseEmployee(true);
        cfg.view().field(OaTables.OA_NETDISK_RESOURCE_LIMIT.USER_ID).form().readOnly();

        cfg.view().list().disableBatchDelete();
        cfg.view().list().disableSingleDelete();
        cfg.view().list().disableCreateNew();
        cfg.getPoClassFile().addSimpleProperty(String.class,"capacitySizeValue","capacitySizeValue","capacitySizeValue");
        cfg.getPoClassFile().addSimpleProperty(String.class,"currentSizeValue","currentSizeValue","currentSizeValue");

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().bottomSpace(120);

        cfg.view().search().inputLayout(
                new Object[]{
                        OaTables.OA_NETDISK_RESOURCE_LIMIT.USER_ID,
                }
        );

        cfg.view().field(OaTables.OA_NETDISK_RESOURCE_LIMIT.PLAY_MUSIC_VALID).table().disable(true);
        cfg.view().field(OaTables.OA_NETDISK_RESOURCE_LIMIT.PLAY_VIDEO_VALID).table().disable(true);
        cfg.view().field(OaTables.OA_NETDISK_RESOURCE_LIMIT.VIEW_DOC_VALID).table().disable(true);
        cfg.view().field(OaTables.OA_NETDISK_RESOURCE_LIMIT.VIEW_PHOTO_VALID).table().disable(true);
        cfg.view().field(OaTables.OA_NETDISK_RESOURCE_LIMIT.UPLOAD_FILE_TYPE).table().disable(true);


        cfg.view().field(OaTables.OA_NETDISK_RESOURCE_LIMIT.CAPACITY_SIZE_M).basic().label("最大容量(M)");
        cfg.view().field(OaTables.OA_NETDISK_RESOURCE_LIMIT.CURRENT_SIZE_B).basic().label("当前容量(M)");
        cfg.view().field(OaTables.OA_NETDISK_RESOURCE_LIMIT.UPLOAD_MAX_SIZE_M).basic().label("上传大小（M）");


        cfg.view().field(OaTables.OA_NETDISK_RESOURCE_LIMIT.UPLOAD_MAX_SIZE_M).form().validate()
                .required().form().numberInput().integer().scale(0);

        cfg.view().formWindow().width(Config.baseFormWidth_50);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_NETDISK_RESOURCE_LIMIT.USER_ID,
                        OaTables.OA_NETDISK_RESOURCE_LIMIT.CAPACITY_SIZE_M
                }
        );
        cfg.view().form().labelWidth(80);
        cfg.view().list().addToolButton("重新计算","recalculate","recalculate-button","oa_netdisk_resource_limit:recalculate");


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
        NetDiskResourceLimitGtr g=new NetDiskResourceLimitGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
        //g.generateMenu(NetdiskResourceLimitServiceProxy.class, NetdiskResourceLimitPageController.class);
    }

}
