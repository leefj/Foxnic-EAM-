package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;

public class SpAssociateItemGtr extends BaseCodeGenerator {


    public SpAssociateItemGtr() {
        super(EAMTables.EAM_DEVICE_ASSOCIATE_ITEM.$TABLE,"732382020847534081");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_DEVICE_ASSOCIATE_ITEM.ID).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_DEVICE_ASSOCIATE_ITEM.ID).table().hidden(true);


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_DEVICE_ASSOCIATE_ITEM.ASSOCIATE_ID,
                }
        );



        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(20);



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
        SpAssociateItemGtr g=new SpAssociateItemGtr();
        //生成代码
       g.generateCode();

     //   g.removeByBatchId("582429214846746624");
        //移除之前生成的菜单，视情况执行
    //  g.generateMenu(RfidLabelServiceProxy.class, RfidLabelPageController.class);
        //生成菜单

    }

}
