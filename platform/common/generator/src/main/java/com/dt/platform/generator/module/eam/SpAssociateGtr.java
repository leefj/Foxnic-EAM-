package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.RfidStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.DeviceAssociate;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.eam.meta.RfidLabelMeta;
import com.dt.platform.eam.page.DeviceAssociatePageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetServiceProxy;
import com.dt.platform.proxy.eam.DeviceAssociateServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class SpAssociateGtr extends BaseCodeGenerator {


    public SpAssociateGtr() {
        super(EAMTables.EAM_DEVICE_ASSOCIATE.$TABLE,"732382020847534081");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_DEVICE_ASSOCIATE.ID).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_DEVICE_ASSOCIATE.ID).table().hidden(true);

        cfg.view().field(EAMTables.EAM_DEVICE_ASSOCIATE.ASSOCIATE_NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_DEVICE_ASSOCIATE.HIERARCHY_NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_DEVICE_ASSOCIATE.NOTES).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_DEVICE_ASSOCIATE.ASSOCIATE_NAME,
                }
        );

        cfg.view().field(EAMTables.EAM_DEVICE_ASSOCIATE.NOTES).form().textArea().height(150);





        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(50);

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_DEVICE_ASSOCIATE.ASSOCIATE_NAME,
                        EAMTables.EAM_DEVICE_ASSOCIATE.HIERARCHY_NAME,
                        EAMTables.EAM_DEVICE_ASSOCIATE.NOTES,
                }
        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        SpAssociateGtr g=new SpAssociateGtr();
        //生成代码
       g.generateCode();

     //   g.removeByBatchId("582429214846746624");
        //移除之前生成的菜单，视情况执行
      //g.generateMenu(DeviceAssociateServiceProxy.class, DeviceAssociatePageController.class);
        //生成菜单

    }

}
