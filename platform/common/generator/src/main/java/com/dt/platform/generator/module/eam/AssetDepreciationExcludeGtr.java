package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;

public class AssetDepreciationExcludeGtr extends BaseCodeGenerator{
    public AssetDepreciationExcludeGtr() {
        super(EAMTables.EAM_ASSET_DEPRECIATION_EXCLUDE.$TABLE,BASIC_CY_MENU_ID);
    }


    public void generateCode() throws Exception {


        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_EXCLUDE.ID)
                .basic().hidden(true);


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_DEPRECIATION_EXCLUDE.DEPRECIATION_ID,
                        EAMTables.EAM_ASSET_DEPRECIATION_EXCLUDE.NOTES,
                }
        );


        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().list().disableBatchDelete();

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        AssetDepreciationExcludeGtr g=new AssetDepreciationExcludeGtr();
        //生成代码
        g.generateCode();
        //生成菜单
      //  g.removeByBatchId("");
      //  g.generateMenu(AssetDepreciationExcludeServiceProxy.class, AssetDepreciationExcludePageController.class);


    }
}
