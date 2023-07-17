package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.DeviceSpType;
import com.dt.platform.eam.page.DeviceSpTypePageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.DeviceSpTypeServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class SpTypeGtr extends BaseCodeGenerator {


    public SpTypeGtr() {
        super(EAMTables.EAM_DEVICE_SP_TYPE.$TABLE,"732382020847534081");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_DEVICE_SP_TYPE.ID).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_DEVICE_SP_TYPE.ID).table().hidden(true);



        cfg.view().field(EAMTables.EAM_DEVICE_SP_TYPE.CATEGORY_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_DEVICE_SP_TYPE.CREATE_TIME).search().range();


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_DEVICE_SP_TYPE.HIERARCHY_NAME,

                }
        );

        cfg.view().field(EAMTables.EAM_DEVICE_SP_TYPE.HIERARCHY_NAME).form().textArea().height(150);


        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(50);



        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.IGNORE) //表单HTML页
                .setListPage(WriteMode.IGNORE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        SpTypeGtr g=new SpTypeGtr();
        //生成代码
       g.generateCode();

     //   g.removeByBatchId("582429214846746624");
        //移除之前生成的菜单，视情况执行
     // g.generateMenu(DeviceSpTypeServiceProxy.class, DeviceSpTypePageController.class);
        //生成菜单

    }

}
