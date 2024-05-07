package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.eam.AssetInventoryActionStatusEnum;
import com.dt.platform.constants.enums.eam.AssetInventoryDataStatusEnum;
import com.dt.platform.constants.enums.eam.AssetInventoryDetailStatusEnum;
import com.dt.platform.domain.eam.GoodsStock;
import com.dt.platform.domain.eam.InventoryAsset;
import com.dt.platform.domain.eam.Warehouse;
import com.dt.platform.domain.eam.meta.InventoryMeta;
import com.dt.platform.domain.eam.meta.StockInventoryAssetMeta;
import com.dt.platform.domain.eam.meta.StockInventoryTaskMeta;
import com.dt.platform.domain.eam.meta.WarehouseMeta;
import com.dt.platform.eam.page.StockInventoryAssetPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.StockInventoryAssetServiceProxy;
import com.dt.platform.proxy.eam.WarehouseServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.pcm.meta.CatalogMeta;
import org.github.foxnic.web.proxy.pcm.CatalogServiceProxy;

public class EamInventoryStockAssetGtr extends BaseCodeGenerator{

    public EamInventoryStockAssetGtr() {
        super(EAMTables.EAM_STOCK_INVENTORY_ASSET.$TABLE,"839032550306349056");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(GoodsStock.class,"goodsStockAsset","goodsStockAsset","goodsStockAsset");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"operUser","操作人员","操作人员");
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_ASSET.UPDATE_BY).table().disable(true);
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_ASSET.CREATE_TIME).table().disable(true);
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_ASSET.ASSET_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_ASSET.TASK_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_ASSET.ID).basic().hidden(true);
        cfg.getPoClassFile().addSimpleProperty(String.class,"withGoodsStockType","withGoodsStockType","withGoodsStockType");
        cfg.getPoClassFile().addSimpleProperty(String.class,"withWarehouse","withWarehouse","withWarehouse");
        cfg.getPoClassFile().addSimpleProperty(String.class,"withPosition","withPosition","withPosition");
        cfg.getPoClassFile().addSimpleProperty(String.class,"withName","withName","withName");
        cfg.getPoClassFile().addSimpleProperty(String.class,"withCode","withCode","withCode");
        cfg.getPoClassFile().addSimpleProperty(String.class,"withModel","withModel","withModel");
        cfg.getPoClassFile().addSimpleProperty(String.class,"withBrand","withBrand","withBrand");
        cfg.getPoClassFile().addSimpleProperty(String.class,"withManufacturer","withManufacturer","withManufacturer");
        cfg.getPoClassFile().addSimpleProperty(String.class,"withNumber","withNumber","withNumber");

        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_ASSET.OPER_TIME).form().validate().required().form().dateInput().type(DatePickerType.datetime).format("yyyy-MM-dd HH:mm:ss").search().range();
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_ASSET.INVENTORY_NOTES).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_STOCK_INVENTORY_ASSET.INVENTORY_STATUS,
                        EAMTables.EAM_STOCK_INVENTORY_ASSET.OPER_ID,
                        EAMTables.EAM_STOCK_INVENTORY_ASSET.INVENTORY_NOTES,
                }
        );
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_ASSET.INVENTORY_STATUS).form().validate().required().form()
                .label("盘点状态").selectBox().enumType(AssetInventoryDetailStatusEnum.class);

        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_ASSET.ASSET_NUMBER).form().validate().required().form().numberInput().integer().defaultValue(0.0);

        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_ASSET.OPER_ID).table().fillBy("operUser","name");
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_ASSET.OPER_ID).form().validate().required().form()
                .button().chooseEmployee(true);

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_ASSET.INVENTORY_NOTES).form().textArea().height(120);

        cfg.view().field(StockInventoryAssetMeta.WITH_GOODS_STOCK_TYPE).basic().label("物品类型").table().disable(false);
        cfg.view().field(StockInventoryAssetMeta.WITH_WAREHOUSE).basic().label("仓库").table().disable(false);
        cfg.view().field(StockInventoryAssetMeta.WITH_POSITION).basic().label("库位").table().disable(false);
        cfg.view().field(StockInventoryAssetMeta.WITH_NAME).basic().label("名称").table().disable(false);
        cfg.view().field(StockInventoryAssetMeta.WITH_CODE).basic().label("编号").table().disable(false);
        cfg.view().field(StockInventoryAssetMeta.WITH_MODEL).basic().label("型号").table().disable(false);
        cfg.view().field(StockInventoryAssetMeta.WITH_NUMBER).basic().label("数量").table().disable(false);
        cfg.view().field(StockInventoryAssetMeta.WITH_MANUFACTURER).basic().label("厂商").table().disable(false);
        cfg.view().field(StockInventoryAssetMeta.WITH_BRAND).basic().label("品牌").table().disable(false);


        cfg.view().formWindow().bottomSpace(150);
         cfg.view().formWindow().width(Config.baseFormWidth_95);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        StockInventoryAssetMeta.WITH_GOODS_STOCK_TYPE,
                        StockInventoryAssetMeta.WITH_NAME,
                        StockInventoryAssetMeta.WITH_WAREHOUSE,
                        StockInventoryAssetMeta.WITH_POSITION,
                        StockInventoryAssetMeta.WITH_NUMBER,
                },
                new Object[] {
                        StockInventoryAssetMeta.WITH_MANUFACTURER,
                        StockInventoryAssetMeta.WITH_BRAND,
                        StockInventoryAssetMeta.WITH_CODE,
                        StockInventoryAssetMeta.WITH_MODEL,
                }
        );
        cfg.view().form().addGroup("盘点信息",
                new Object[] {
                        EAMTables.EAM_STOCK_INVENTORY_ASSET.INVENTORY_STATUS,
                        EAMTables.EAM_STOCK_INVENTORY_ASSET.OPER_ID,

                },
                new Object[]{
                        EAMTables.EAM_STOCK_INVENTORY_ASSET.ASSET_NUMBER,
                        EAMTables.EAM_STOCK_INVENTORY_ASSET.OPER_TIME,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_STOCK_INVENTORY_ASSET.INVENTORY_NOTES,
                }
        );


        cfg.view().list().addJsVariable("TASK_ID","[[${taskId}]]","taskId");



        //文件生成覆盖模式

        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();


    }

    public static void main(String[] args) throws Exception {
        EamInventoryStockAssetGtr g=new EamInventoryStockAssetGtr();

        g.generateCode();

        //生成菜单
     //   g.generateMenu(  StockInventoryAssetServiceProxy.class,  StockInventoryAssetPageController.class);
    }
}
