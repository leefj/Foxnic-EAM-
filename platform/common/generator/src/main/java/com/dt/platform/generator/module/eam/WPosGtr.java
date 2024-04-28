package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.RepairOrderMeta;
import com.dt.platform.domain.eam.meta.RepairUrgencyMeta;
import com.dt.platform.domain.eam.meta.WarehouseMeta;
import com.dt.platform.domain.eam.meta.WarehousePositionMeta;
import com.dt.platform.eam.page.WarehousePositionPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.RepairUrgencyServiceProxy;
import com.dt.platform.proxy.eam.WarehousePositionServiceProxy;
import com.dt.platform.proxy.eam.WarehouseServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class WPosGtr extends BaseCodeGenerator{
    public WPosGtr() {
        super(EAMTables.EAM_WAREHOUSE_POSITION.$TABLE,"471620638545543168");
    }


    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(Warehouse.class,"warehouse","warehouse","warehouse");

        cfg.view().field(EAMTables.EAM_WAREHOUSE_POSITION.ID).basic().hidden(true);


        cfg.view().field(EAMTables.EAM_WAREHOUSE_POSITION.CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_WAREHOUSE_POSITION.NAME).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_WAREHOUSE_POSITION.ID,
                        EAMTables.EAM_WAREHOUSE_POSITION.CODE,
                        EAMTables.EAM_WAREHOUSE_POSITION.NAME,
                }
        );

        cfg.view().field(EAMTables.EAM_WAREHOUSE_POSITION.UPDATE_BY).table().disable(true);

        cfg.view().field(EAMTables.EAM_WAREHOUSE_POSITION.WAREHOUSE_ID)
                .form().selectBox().queryApi(WarehouseServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(WarehouseMeta.ID).
                textField(WarehouseMeta.WAREHOUSE_NAME).
                fillWith(WarehousePositionMeta.WAREHOUSE).muliti(false).defaultIndex(0);

        cfg.view().field(EAMTables.EAM_WAREHOUSE_POSITION.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_WAREHOUSE_POSITION.CODE).form().validate().required();
        cfg.view().field(EAMTables.EAM_WAREHOUSE_POSITION.NOTES).form().textArea().height(80);

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().form().addJsVariable("WAREHOUSE_ID","[[${warehouseId}]]","warehouse_id");
        cfg.view().list().addJsVariable("WAREHOUSE_ID","[[${warehouseId}]]","warehouse_id");

        cfg.view().formWindow().width(Config.baseFormWidth_75);
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_WAREHOUSE_POSITION.CODE,
                        EAMTables.EAM_WAREHOUSE_POSITION.NAME,
                        EAMTables.EAM_WAREHOUSE_POSITION.MAXIMUM_CAPACITY,
                        EAMTables.EAM_WAREHOUSE_POSITION.NOTES,
                }
        );

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
        WPosGtr g=new WPosGtr();
        //生成代码
         g.generateCode();

        //生成菜单
        //  g.removeByBatchId("");
       // g.generateMenu(WarehousePositionServiceProxy.class, WarehousePositionPageController.class);
    }
}
