package com.dt.platform.constants.enums.eam;

import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.github.foxnic.api.constant.CodeTextEnum;

public enum AssetOperateEnum implements CodeTextEnum {

    //资产
    EAM_ASSET_INSERT("eam_asset_insert" , "EAM_资产-登记"),
    EAM_ASSET_IMPORT("eam_asset_import" , "EAM_资产-导入"),

    //软件资产
    EAM_ASSET_SOFTWARE_INSERT("eam_asset_software_insert" , "EAM_资产软件-登记"),

    //资产单据
    EAM_ASSET_COLLECTION(CodeModuleEnum.EAM_ASSET_COLLECTION.code() , "EAM_资产单据-领用"),
    EAM_ASSET_COLLECTION_RETURN(CodeModuleEnum.EAM_ASSET_COLLECTION_RETURN.code() , "EAM_资产单据-退库"),
    EAM_ASSET_BORROW(CodeModuleEnum.EAM_ASSET_BORROW.code() , "EAM_资产单据-借用"),
    EAM_ASSET_BORROW_RETURN(CodeModuleEnum.EAM_ASSET_BORROW_RETURN.code() , "EAM_资产单据-借用归还"),
    EAM_ASSET_REPAIR(CodeModuleEnum.EAM_ASSET_REPAIR.code() , "EAM_资产单据-报修"),
    EAM_ASSET_SCRAP(CodeModuleEnum.EAM_ASSET_SCRAP.code() , "EAM_资产单据-报废"),
    EAM_ASSET_ALLOCATE(CodeModuleEnum.EAM_ASSET_ALLOCATE.code() , "EAM_资产单据-调拨"),
    EAM_ASSET_TRANFER(CodeModuleEnum.EAM_ASSET_TRANFER.code() , "EAM_资产单据-转移"),
    EAM_ASSET_CLEAN(CodeModuleEnum.EAM_ASSET_CLEAN.code() , "EAM_资产单据-清理"),
    EAM_ASSET_INVENTORY(CodeModuleEnum.EAM_ASSET_INVENTORY.code() , "EAM_资产盘点"),

    //资产变更
    EAM_ASSET_CHANGE_BASE_INFO(CodeModuleEnum.EAM_ASSET_CHANGE_BASE_INFO.code() , "EAM_资产变更-基本"),
    EAM_ASSET_CHANGE_MAINTENANCE(CodeModuleEnum.EAM_ASSET_CHANGE_MAINTENANCE.code() , "EAM_资产变更-维保"),
    EAM_ASSET_CHANGE_FINANCIAL(CodeModuleEnum.EAM_ASSET_CHANGE_FINANCIAL.code() , "EAM_资产变更-财务"),
    EAM_ASSET_CHANGE_EQUIPMENT(CodeModuleEnum.EAM_ASSET_CHANGE_EQUIPMENT.code() , "EAM_资产变更-设备"),

    //耗材
    EAM_ASSET_CONSUMABLES_STOCK_IN(CodeModuleEnum.EAM_ASSET_CONSUMABLES_STOCK_IN.code() , "EAM_资产耗材单据-入库"),
    EAM_ASSET_CONSUMABLES_STOCK_OUT(CodeModuleEnum.EAM_ASSET_CONSUMABLES_STOCK_OUT.code() , "EAM_资产耗材单据-出库"),
    EAM_ASSET_CONSUMABLES_COLLECTION(CodeModuleEnum.EAM_ASSET_CONSUMABLES_COLLECTION.code() , "EAM_资产耗材单据-领用"),
    EAM_ASSET_CONSUMABLES_TRANFER(CodeModuleEnum.EAM_ASSET_CONSUMABLES_TRANFER.code() , "EAM_资产耗材单据-转移"),
//    EAM_ASSET_CONSUMABLES_ALLOCATE(CodeModuleEnum.EAM_ASSET_CONSUMABLES_ALLOCATE.code() , "EAM_资产耗材单据-调拨"),

    //库存
    EAM_ASSET_STOCK_OUT(CodeModuleEnum.EAM_ASSET_STOCK_OUT.code() , "EAM_资产库存-出库"),
    EAM_ASSET_STOCK_IN(CodeModuleEnum.EAM_ASSET_STOCK_IN.code() , "EAM_资产库存-入库"),
    EAM_ASSET_STOCK_ALLOCATE(CodeModuleEnum.EAM_ASSET_STOCK_ALLOCATE.code() , "EAM_资产库存-调拨"),
    EAM_ASSET_STOCK_DISTRIBUTE(CodeModuleEnum.EAM_ASSET_STOCK_DISTRIBUTE.code() , "EAM_资产库存-分配"),
    EAM_ASSET_STOCK_INVENTORY(CodeModuleEnum.EAM_ASSET_STOCK_INVENTORY.code()  , "EAM_资产库存-盘点"),

    //单据下载
    EAM_DOWNLOAD_ASSET("eam_download_asset", "EAM_资产数据下载"),
    EAM_DOWNLOAD_ASSET_REGISTER_BILL("eam_download_asset_register_bill" , "EAM_资产登记单据"),
    EAM_DOWNLOAD_ASSET_CARD("eam_download_asset_card" , "EAM_资产卡片下载"),
    EAM_DOWNLOAD_ASSET_LABEl("eam_download_asset_label" , "EAM_资产标签下载"),
    EAM_DOWNLOAD_ASSET_TRANFER_BILL("eam_download_asset_tranfer_bill" , "EAM_资产转移下载"),
    EAM_DOWNLOAD_ASSET_ALLOCATE_BILL("eam_download_asset_allocate_bill" , "EAM_资产调拨下载"),
    EAM_DOWNLOAD_ASSET_COLLECTION_BILL("eam_download_asset_collection_bill" , "EAM_资产领用下载"),
    EAM_DOWNLOAD_ASSET_COLLECTION_RETURN_BILL("eam_download_asset_collection_return_bill" , "EAM_资产退库下载"),
    EAM_DOWNLOAD_ASSET_BORROW_BILL("eam_download_asset_borrow_bill" , "EAM_资产借用下载"),
    EAM_DOWNLOAD_ASSET_REPAIR_BILL("eam_download_asset_repair_bill" , "EAM_资产报修下载"),
    EAM_DOWNLOAD_ASSET_SCRAP_BILL("eam_download_asset_scrap_bill" , "EAM_资产报废下载"),
    ;


    private String code;
    private String text;
    private AssetOperateEnum(String code, String text)  {
        this.code=code;
        this.text=text;
    }

    public String code() {
        return code;
    }

    public String text() {
        return text;
    }


}
