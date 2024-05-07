package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.eam.StockInventoryTask;
import com.dt.platform.domain.eam.meta.StockInventoryPlanMeta;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class EamInventoryStockPlanAssetGtr extends BaseCodeGenerator{

    public EamInventoryStockPlanAssetGtr() {
        super(EAMTables.EAM_STOCK_INVENTORY_PLAN.$TABLE,"839032550306349056");
    }

    public void generateCode() throws Exception {

        //盘点明细
        cfg.getPoClassFile().addSimpleProperty(StockInventoryTask.class,"inventoryTask","盘点任务","盘点任务");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"inventoryPlanType","盘点类型","盘点类型");



        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_PLAN.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_PLAN.OWNER_CODE).basic().hidden(true);

        //eam_asset_change_data
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_PLAN.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_PLAN.NAME).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_STOCK_INVENTORY_PLAN.STATUS,
                        EAMTables.EAM_STOCK_INVENTORY_PLAN.NAME,
                        EAMTables.EAM_STOCK_INVENTORY_PLAN.NOTES
                }
        );

        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_PLAN.TPL_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_PLAN.CREATE_TIME).table().hidden(true);
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_PLAN.UPDATE_BY).table().disable(true);
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_PLAN.OWNER_CODE).table().disable(true);
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_PLAN.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_PLAN.STATUS).form().validate().required().form()
                .label("状态").radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);

        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_PLAN.NOTES).form().textArea().height(120);

        cfg.view().field(EAMTables.EAM_STOCK_INVENTORY_PLAN.PLAN_TYPE)
                .basic().label("计划类型")
                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_inventory_plan_type")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(StockInventoryPlanMeta.INVENTORY_PLAN_TYPE).muliti(false);

        cfg.view().formWindow().bottomSpace(250);
         cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_STOCK_INVENTORY_PLAN.NAME,
                        EAMTables.EAM_STOCK_INVENTORY_PLAN.STATUS,

                }, new Object[] {
                        EAMTables.EAM_STOCK_INVENTORY_PLAN.PLAN_TYPE,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_STOCK_INVENTORY_PLAN.NOTES,

                }
        );

        cfg.view().list().disableBatchDelete();
      //  cfg.view().list().operationColumn().addActionButton("查看模板","viewTpl","viewTpl");
        cfg.view().list().operationColumn().addActionButton("修改模板","modifyTpl","modifyTpl");
        cfg.view().list().operationColumn().addActionButton("应用模板","applyTpl","applyTpl");

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
        EamInventoryStockPlanAssetGtr g=new EamInventoryStockPlanAssetGtr();
        g.generateCode();
        //生成菜单
       // g.generateMenu(StockInventoryPlanServiceProxy.class, StockInventoryPlanPageController.class);
    }
}
