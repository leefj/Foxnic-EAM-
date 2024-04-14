package com.dt.platform.relation.modules;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.IotTables;
import com.dt.platform.constants.db.WmsTables;
import com.dt.platform.domain.eam.VirtEquipment;
import com.dt.platform.domain.eam.meta.AssetScanSceneMeta;
import com.dt.platform.domain.eam.meta.EquipmentMeta;
import com.dt.platform.domain.eam.meta.ProductMeta;
import com.dt.platform.domain.eam.meta.VirtEquipmentMeta;
import com.dt.platform.domain.wms.meta.*;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;

public class IotRelationManager extends RelationManager {

    @Override
    protected void config() {


        this.setupProduct();

        this.setupEq();

        this.setupVirtEq();

    }

    public void setupEq() {

        this.property(EquipmentMeta.IOT_PRODUCT_PROP)
                .using(IotTables.IOT_EQUIPMENT.PRODUCT_ID).join(IotTables.IOT_PRODUCT.ID);


        this.property(EquipmentMeta.GROUP_PROP)
                .using(IotTables.IOT_EQUIPMENT.GROUP_CODE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_iot_product_group'");


    }

    public void setupVirtEq() {

        this.property(VirtEquipmentMeta.IOT_PRODUCT_PROP)
                .using(IotTables.IOT_VIRT_EQUIPMENT.OWNER_ID).join(IotTables.IOT_PRODUCT.ID);
    }



    public void setupProduct() {

        this.property(ProductMeta.CATEGORY_PROP)
                .using(IotTables.IOT_PRODUCT.CATEGORY_ID).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_iot_product_category'");

    }

}
