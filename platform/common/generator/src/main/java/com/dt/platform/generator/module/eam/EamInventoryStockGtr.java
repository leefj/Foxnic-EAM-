package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.eam.AssetInventoryActionStatusEnum;
import com.dt.platform.constants.enums.eam.AssetInventoryDataStatusEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.WarehouseServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.pcm.meta.CatalogMeta;
import org.github.foxnic.web.proxy.pcm.CatalogServiceProxy;

public class EamInventoryStockGtr extends BaseCodeGenerator{

    public EamInventoryStockGtr() {
        super(EAMTables.EAM_STOCK_INVENTORY_TASK.$TABLE,"839032550306349056");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addListProperty(StockInventoryAsset.class,"inventoryAssetInfoList","盘点资产数据","盘点资产数据");
        cfg.getPoClassFile().addSimpleProperty(Integer.class,"inventoryAssetCountByNotCounted","待盘点","待盘点");
        cfg.getPoClassFile().addSimpleProperty(Integer.class,"inventoryAssetCountByCounted","已盘点","已盘点");
        cfg.getPoClassFile().addSimpleProperty(Integer.class,"inventoryAssetCountByLoss","盘亏","盘亏");
        cfg.getPoClassFile().addSimpleProperty(Integer.class,"inventoryAssetCountBySurplus","盘盈","盘盈");
        cfg.getPoClassFile().addSimpleProperty(Integer.class,"inventoryAssetCountByException","异常","异常");
        cfg.getPoClassFile().addListProperty(Employee.class,"inventoryUserList","盘点人员","盘点人员");
        cfg.getPoClassFile().addListProperty(String.class,"inventoryUserIds","盘点人员列表","盘点人员列表");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"director","director","director");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addListProperty(Warehouse.class,"warehouseList","仓库","仓库");
        cfg.getPoClassFile().addListProperty(String.class,"warehouseIds","仓库Ids","仓库Ids");
        cfg.getPoClassFile().addListProperty(Catalog.class,"categoryList","资产分类","资产分类");
        cfg.getPoClassFile().addListProperty(String.class,"categoryIds","资产分类Ids","资产分类Ids");
        cfg.getPoClassFile().addSimpleProperty(String.class,"searchQuerySource","searchQuerySource","searchQuerySource");
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_TASK.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_TASK.PLAN_ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_TASK.TYPE).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_TASK.BUSINESS_DATE).search().range();
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_TASK.START_TIME).search().range();
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_TASK.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_TASK.NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_TASK.STATUS).table().disable(true);
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_TASK.OWNER_CODE).table().disable(true);
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_TASK.BUSINESS_DATE).table().disable(true);
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_TASK.NOTES).table().disable(true);

        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_TASK.START_TIME).search().range();

        cfg.view().field(StockInventoryTaskMeta.INVENTORY_USER_IDS).table().disable(true);
        cfg.view().field(StockInventoryTaskMeta.ORIGINATOR_ID).table().disable(true);
        cfg.view().field(StockInventoryTaskMeta.UPDATE_BY).table().disable(true);
        cfg.view().field(StockInventoryTaskMeta.CATEGORY_IDS).table().disable(true);

        cfg.view().field(StockInventoryTaskMeta.INVENTORY_ASSET_COUNT_BY_NOT_COUNTED).basic().label("待盘数").table().disable(false);
        cfg.view().field(StockInventoryTaskMeta.INVENTORY_ASSET_COUNT_BY_COUNTED).basic().label("已盘数").table().disable(false);
        cfg.view().field(StockInventoryTaskMeta.INVENTORY_ASSET_COUNT_BY_LOSS).basic().label("盘亏数").table().disable(false);
        cfg.view().field(StockInventoryTaskMeta.INVENTORY_ASSET_COUNT_BY_SURPLUS).basic().label("盘赢数").table().disable(false);
        cfg.view().field(StockInventoryTaskMeta.INVENTORY_ASSET_COUNT_BY_EXCEPTION).basic().label("异常数").table().disable(false);



        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_TASK.ORIGINATOR_ID).table().fillBy("originator","name");
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_TASK.ORIGINATOR_ID).form()
                .button().chooseEmployee(true);


        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_TASK.DIRECTOR_ID).table().fillBy("director","name");
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_TASK.DIRECTOR_ID).form().validate().required().form()
                .button().chooseEmployee(true);



        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_STOCK_INVENTORY_TASK.INVENTORY_STATUS,
                        EAMTables.EAM_STOCK_INVENTORY_TASK.BUSINESS_CODE,
                        EAMTables.EAM_STOCK_INVENTORY_TASK.NAME,
                        EAMTables.EAM_STOCK_INVENTORY_TASK.NOTES,
                },new Object[]{
                        EAMTables.EAM_STOCK_INVENTORY_TASK.START_TIME,

          }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth+30);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth+30);
        cfg.view().search().inputWidth(Config.searchInputWidth);



        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_TASK.DATA_STATUS).form().
                label("数据状态").selectBox().enumType(AssetInventoryDataStatusEnum.class).muliti(false);


        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_TASK.STATUS).form().
                label("业务状态").selectBox().enumType(AssetHandleStatusEnum.class).muliti(false);

        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_TASK.INVENTORY_STATUS).form().
                label("盘点状态").selectBox().enumType(AssetInventoryActionStatusEnum.class).muliti(false);

        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_TASK.NOTES).form().textArea().height(Config.textAreaHeight);

        cfg.view().field(InventoryMeta.INVENTORY_USER_IDS).basic().label("盘点人").form()
                .button().chooseEmployee(false);

        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_TASK.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_TASK.START_TIME).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_TASK.FINISH_TIME).form().dateInput().format("yyyy-MM-dd").search().range();


        cfg.view().field(StockInventoryTaskMeta.WAREHOUSE_IDS)
                .basic().label("所在仓库")
                .form().selectBox().queryApi(WarehouseServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(WarehouseMeta.ID).textField(WarehouseMeta.WAREHOUSE_NAME).fillWith(StockInventoryTaskMeta.WAREHOUSE_LIST).muliti(true);




        cfg.view().field(StockInventoryTaskMeta.CATEGORY_IDS)
                .basic().label("资产分类")
                .table().sort(false)
                .form().selectBox().queryApi(CatalogServiceProxy.QUERY_NODES)
                .paging(false).filter(false).toolbar(false)
                .valueField(CatalogMeta.ID).textField(CatalogMeta.NAME)
                .fillWith(StockInventoryTaskMeta.CATEGORY_LIST).muliti(true);



        cfg.view().list().disableBatchDelete();
        cfg.view().list().addToolButton("开始盘点","inventoryStart",null);
        cfg.view().list().addToolButton("结束盘点","inventoryFinish",null);
        cfg.view().list().addToolButton("取消","inventoryCancel",null);
        cfg.view().list().addToolButton("数据同步","inventoryDataSync",null);
        cfg.view().list().operationColumn().addActionButton("明细","inventoryDetail","inventory-detail-button");


        cfg.view().formWindow().bottomSpace(250);
         cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_STOCK_INVENTORY_TASK.BUSINESS_CODE,
                        EAMTables.EAM_STOCK_INVENTORY_TASK.NAME,
                },
                new Object[] {
                        EAMTables.EAM_STOCK_INVENTORY_TASK.DIRECTOR_ID,
                        StockInventoryTaskMeta.INVENTORY_USER_IDS,
                }

        );
        cfg.view().form().addGroup("盘点范围",
                new Object[]{
                        StockInventoryTaskMeta.WAREHOUSE_IDS
                },
                new Object[] {

                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_STOCK_INVENTORY_TASK.NOTES,
                }
        );

        cfg.view().form().addJsVariable("PLAN_ID","[[${planId}]]","PLAN_ID");
        cfg.view().form().addJsVariable("OWNER_CODE","[[${ownerCode}]]","OWNER_CODE");
        cfg.view().list().addJsVariable("OWNER_CODE","[[${ownerCode}]]","OWNER_CODE");
        cfg.view().form().addJsVariable("BILL_ID","[[${billId}]]","单据ID");


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
        EamInventoryStockGtr g=new EamInventoryStockGtr();

        g.generateCode();

        //生成菜单
        //g.generateMenu(StockInventoryTaskServiceProxy.class, StockInventoryTaskPageController.class);
    }
}
