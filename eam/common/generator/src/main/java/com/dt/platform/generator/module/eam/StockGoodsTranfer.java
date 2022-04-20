package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.AssetStockGoodsTranfer;
import com.dt.platform.eam.page.AssetStockGoodsTranferPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetStockGoodsTranferServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class StockGoodsTranfer extends BaseCodeGenerator {


    public StockGoodsTranfer() {
        super(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.$TABLE,BASIC_STOCK_GOODS_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.ID).basic().hidden(true);

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.ID,

                }
        );

        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.ID,

                }
        );

        cfg.view().search().inputWidth(Config.searchInputWidth);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页


        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        StockGoodsTranfer g=new StockGoodsTranfer();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
     // g.generateMenu(AssetStockGoodsTranferServiceProxy.class, AssetStockGoodsTranferPageController.class);
        //生成菜单

    }

}
