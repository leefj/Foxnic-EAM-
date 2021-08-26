package com.dt.platform.relation.modules;


import com.dt.platform.constants.db.EAMTables;

import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.*;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.domain.hrm.meta.PersonMeta;

public class EAMRelationManager extends RelationManager {
    @Override
    protected void config() {
        this.setupRelations();
        this.setupProperties();
        this.setupGoods();

        this.setupAsset();
        this.setupAssetFinancial();
        this.setupAssetMaintainer();
        this.setupAssetEaintainer();


        this.setupAssetBorrow();
        this.setupAssetCollection();
        this.setupAssetCollectionReturn();
        this.setupAssetHandle();
        this.setupAssetRepair();
        this.setupAssetTranfer();

        this.setupInventory();

    }
    public void setupProperties() {


    }


    public void setupInventory() {


        // 关联位置
        this.property(InventoryMeta.POSITION_PROP)
                .using(EAMTables.EAM_INVENTORY.POSITION_ID).join(EAMTables.EAM_POSITION.ID);


    }

    public void setupAssetBorrow() {
        // 关联资产
        this.property(AssetBorrowMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_BORROW.ID )
                .join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using(EAMTables.EAM_ASSET.ID)
                .join(EAMTables.EAM_ASSET_ITEM.ASSET_ID);

        // 关联制单人
        this.property(AssetBorrowMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_BORROW.ORIGINATOR_ID).join(FoxnicWeb.HRM_PERSON.ID);


        // 关联借用人
        this.property(AssetBorrowMeta.BORROWER_PROP)
                .using(EAMTables.EAM_ASSET_BORROW.BORROWER_ID).join(FoxnicWeb.HRM_PERSON.ID);
    }


    public void setupAssetCollection() {
        // 关联资产
        this.property(AssetCollectionMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_COLLECTION.ID)
                .join( EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using(EAMTables.EAM_ASSET.ID)
                .join(EAMTables.EAM_ASSET_ITEM.ASSET_ID);

        // 关联位置
        this.property(AssetCollectionMeta.POSITION_PROP)
                .using(EAMTables.EAM_ASSET_COLLECTION.POSITION_ID)
                .join( EAMTables.EAM_POSITION.ID);

        // 关联制单人
        this.property(AssetCollectionMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_COLLECTION.ORIGINATOR_ID).join(FoxnicWeb.HRM_PERSON.ID);

        // 关联使用人
        this.property(AssetCollectionMeta.USE_USER_PROP)
                .using(EAMTables.EAM_ASSET_COLLECTION.USE_USER_ID).join(FoxnicWeb.HRM_PERSON.ID);


    }


    public void setupAssetCollectionReturn() {
        // 关联资产
        this.property(AssetCollectionReturnMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_COLLECTION_RETURN.ID)
                .join( EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using(EAMTables.EAM_ASSET.ID)
                .join(EAMTables.EAM_ASSET_ITEM.ASSET_ID);

        // 关联位置
        this.property(AssetCollectionReturnMeta.POSITION_PROP)
                .using(EAMTables.EAM_ASSET_COLLECTION_RETURN.POSITION_ID)
                .join( EAMTables.EAM_POSITION.ID);

        // 关联制单人
        this.property(AssetCollectionReturnMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_COLLECTION_RETURN.ORIGINATOR_ID).join(FoxnicWeb.HRM_PERSON.ID);

    }


    public void setupAssetRepair() {
        // 关联资产
        this.property(AssetRepairMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_REPAIR.ID)
                .join( EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using(EAMTables.EAM_ASSET.ID)
                .join(EAMTables.EAM_ASSET_ITEM.ASSET_ID);


        // 关联制单人
        this.property(AssetRepairMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_REPAIR.ORIGINATOR_ID).join(FoxnicWeb.HRM_PERSON.ID);

        // 报修人
        this.property(AssetRepairMeta.REPORT_USER_PROP)
                .using(EAMTables.EAM_ASSET_REPAIR.REPORT_USER_ID).join(FoxnicWeb.HRM_PERSON.ID);


    }

    public void setupAssetTranfer() {

        // 关联位置
        this.property(AssetTranferMeta.POSITION_PROP)
                .using(EAMTables.EAM_ASSET_TRANFER.POSITION_ID).join(EAMTables.EAM_POSITION.ID);


        // 关联资产
        this.property(AssetTranferMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_TRANFER.ID)
                .join( EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using(EAMTables.EAM_ASSET.ID)
                .join(EAMTables.EAM_ASSET_ITEM.ASSET_ID);

        // 关联制单人
        this.property(AssetTranferMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_TRANFER.ORIGINATOR_ID).join(FoxnicWeb.HRM_PERSON.ID);

        // 关联管理人员
        this.property(AssetTranferMeta.MANAGER_PROP)
                .using(EAMTables.EAM_ASSET_TRANFER.MANAGER_ID).join(FoxnicWeb.HRM_PERSON.ID);

        // 关联使用人员
        this.property(AssetTranferMeta.USE_USER_PROP)
                .using(EAMTables.EAM_ASSET_TRANFER.USE_USER_ID).join(FoxnicWeb.HRM_PERSON.ID);


    }

    public void setupAssetHandle() {
        // 关联资产
        this.property(AssetHandleMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_HANDLE.ID)
                .join( EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using(EAMTables.EAM_ASSET.ID)
                .join(EAMTables.EAM_ASSET_ITEM.ASSET_ID);

        // 关联制单人
        this.property(AssetHandleMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_HANDLE.ORIGINATOR_ID).join(FoxnicWeb.HRM_PERSON.ID);

    }



//    public void setupAssetAssetExtAttribution() {
//
//        // 关联仓库
//        this.property(AssetExtAttributionMeta.WAREHOUSE_PROP)
//                .using(EAMTables.EAM_ASSET_EXT_ATTRIBUTION.WAREHOUSE_ID).join(EAMTables.EAM_WAREHOUSE.ID);
//
//
//
//    }
        public void setupAssetEaintainer() {

        // 关联区域
        this.property(AssetExtEquipmentMeta.AREA_PROP)
                .using(EAMTables.EAM_ASSET_EXT_EQUIPMENT.AREA_ID).join(EAMTables.DC_AREA.ID);

        // 关联层级
        this.property(AssetExtEquipmentMeta.LAYER_PROP)
                .using(EAMTables.EAM_ASSET_EXT_EQUIPMENT.LAYER_ID).join(EAMTables.DC_LAYER.ID);

        // 关联机柜
        this.property(AssetExtEquipmentMeta.RACK_PROP)
                .using(EAMTables.EAM_ASSET_EXT_EQUIPMENT.RACK_ID).join(EAMTables.DC_RACK.ID);

    }

    public void setupAssetMaintainer() {

        // 关联维保商
        this.property(AssetExtMaintainerMeta.MAINTNAINER_PROP)
                .using(EAMTables.EAM_ASSET_EXT_MAINTAINER.MAINTAINER_ID).join(EAMTables.EAM_MAINTAINER.ID);
    }

    public void setupAssetFinancial() {

        // 关联供应商
        this.property(AssetExtFinancialMeta.SUPPLIER_PROP)
                .using(EAMTables.EAM_ASSET_EXT_FINANCIAL.SUPPLIER_ID).join(EAMTables.EAM_SUPPLIER.ID);

    }

    public void setupAsset() {

        // 关联使用人
        this.property(AssetMeta.USE_USER_PROP)
                .using(EAMTables.EAM_ASSET.USE_USER_ID).join(FoxnicWeb.HRM_PERSON.ID);

        // 关联管理人员
        this.property(AssetMeta.MANAGER_PROP)
                .using(EAMTables.EAM_ASSET.MANUFACTURER_ID).join(FoxnicWeb.HRM_PERSON.ID);


        // 关联物品档案
        this.property(AssetMeta.GOODS_PROP)
                .using(EAMTables.EAM_ASSET.GOODS_ID).join(EAMTables.EAM_GOODS.ID);

        // 关联分类
        this.property(AssetMeta.CATEGORY_PROP)
                .using(EAMTables.EAM_ASSET.CATEGORY_ID).join(EAMTables.EAM_CATEGORY.ID);


//        // 关联品牌
//        this.property(AssetMeta.BRAND_PROP)
//                .using(EAMTables.EAM_ASSET.BRAND_ID).join(EAMTables.EAM_BRAND.ID);

        // 关联生产厂商
        this.property(AssetMeta.MANUFACTURER_PROP)
                .using(EAMTables.EAM_ASSET.ID).join(EAMTables.EAM_MANUFACTURER.ID);


        // 关联位置
        this.property(AssetMeta.POSITION_PROP)
                .using(EAMTables.EAM_ASSET.POSITION_ID).join(EAMTables.EAM_POSITION.ID);


        // 关联设备数据
        this.property(AssetMeta.ASSET_EQUIPMENT_PROP)
                .using(EAMTables.EAM_ASSET.ID).join(EAMTables.EAM_ASSET_EXT_EQUIPMENT.ASSET_ID);

        // 关联财务数据
        this.property(AssetMeta.ASSET_FINANCIAL_PROP)
                .using(EAMTables.EAM_ASSET.ID).join(EAMTables.EAM_ASSET_EXT_FINANCIAL.ASSET_ID);



        // 关联维保数据
        this.property(AssetMeta.ASSET_MAINTAINER_PROP)
                .using(EAMTables.EAM_ASSET.ID).join(EAMTables.EAM_ASSET_EXT_MAINTAINER.ASSET_ID);



        // 关联软件数据
        this.property(AssetMeta.ASSET_EXT_SOFTWARE_PROP)
                .using(EAMTables.EAM_ASSET.ID).join(EAMTables.EAM_ASSET_EXT_SOFTWARE.ASSET_ID);

        // 关联仓库
        this.property(AssetMeta.WAREHOUSE_PROP)
                .using(EAMTables.EAM_ASSET.WAREHOUSE_ID).join(EAMTables.EAM_ASSET.ID);

    }


    private void setupRelations() {

    }
    private void setupGoods() {

        // 关联品牌
//        this.property(GoodsMeta.BRAND_PROP)
//                .using(EAMTables.EAM_GOODS.BRAND_ID).join(EAMTables.EAM_BRAND.ID);

        // 关联生产厂商
        this.property(GoodsMeta.MANUFACTURER_PROP)
                .using(EAMTables.EAM_GOODS.MANUFACTURER_ID).join(EAMTables.EAM_MANUFACTURER.ID);

        // 关联分类
        this.property(GoodsMeta.CATEGORY_PROP)
                .using(EAMTables.EAM_GOODS.CATEGORY_ID).join(EAMTables.EAM_CATEGORY.ID);

    }

}
