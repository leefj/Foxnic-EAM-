package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.MaterialResourcePageController;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.CollectStatusEnum;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.MaterialResourceServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class SysMaterialResourceGtr extends BaseCodeGenerator {

    public SysMaterialResourceGtr() {
        super(SysTables.SYS_MATERIAL_RESOURCE.$TABLE,"463397133957988354");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(SysTables.SYS_MATERIAL_RESOURCE.ID).basic().hidden(true);
        cfg.view().field(SysTables.SYS_MATERIAL_RESOURCE.CREATE_TIME).search().range();
        cfg.view().field(SysTables.SYS_MATERIAL_RESOURCE.NAME).form().validate().required().search().fuzzySearch();
        cfg.view().field(SysTables.SYS_MATERIAL_RESOURCE.FILE_ID).form().validate().required().form().upload().maxFileCount(1);

        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_MATERIAL_RESOURCE.NAME,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_MATERIAL_RESOURCE.NAME,
                        SysTables.SYS_MATERIAL_RESOURCE.FILE_ID,
                        SysTables.SYS_MATERIAL_RESOURCE.NOTES
                }
        );

      //  cfg.view().list().disableCreateNew();
        cfg.view().list().disableBatchDelete();


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        SysMaterialResourceGtr g=new SysMaterialResourceGtr();

        //生成代码
        g.generateCode();
        //生成菜单
      //  g.generateMenu(MaterialResourceServiceProxy.class, MaterialResourcePageController.class);
    }

}
