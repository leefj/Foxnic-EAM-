package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.eam.page.GoodsStockRelatedPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.GoodsStockRelatedServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class StockEamGoodsStockStockRelatedGtr extends BaseCodeGenerator{
    public StockEamGoodsStockStockRelatedGtr() {
        super(EAMTables.EAM_GOODS_STOCK_RELATED.$TABLE,BASIC_SETTING_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());



        cfg.view().field(EAMTables.EAM_ASSET_LABEL.ID).basic().hidden(true);
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_GOODS_STOCK_RELATED.GOODS_ID,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


         cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_GOODS_STOCK_RELATED.GOODS_ID,

                },
                new Object[] {
                        EAMTables.EAM_GOODS_STOCK_RELATED.PARENT_GOODS_ID,
                }
        );


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.IGNORE) //表单HTML页
                .setListPage(WriteMode.IGNORE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        StockEamGoodsStockStockRelatedGtr g=new StockEamGoodsStockStockRelatedGtr();
        //生成代码
         g.generateCode();


        //生成菜单
        //  g.removeByBatchId("");
      // g.generateMenu(GoodsStockRelatedServiceProxy.class, GoodsStockRelatedPageController.class);
    }
}
