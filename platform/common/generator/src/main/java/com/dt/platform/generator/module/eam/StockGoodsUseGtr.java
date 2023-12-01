package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.GoodsStock;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.api.bpm.IntegrateMode;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class StockGoodsUseGtr extends BaseCodeGenerator {


    public StockGoodsUseGtr() {
        super(EAMTables.EAM_ASSET_STOCK_GOODS_USE.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {


        cfg.getPoClassFile().addListProperty(GoodsStock.class,"assetStockGoodsList","assetStockGoodsList","assetStockGoodsList");
//        cfg.getPoClassFile().addSimpleProperty(Organization.class,"organization","使用公司/部门","使用公司/部门");
//        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
//        cfg.getPoClassFile().addSimpleProperty(String.class,"originatorUserName","申请人","申请人");

        cfg.getPoClassFile().addSimpleProperty(String.class,"selectedCode","selectedCode","selectedCode");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_USE.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_USE.NAME).search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_USE.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_USE.NAME).search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_USE.BUSINESS_DATE).form().dateInput().format("yyyy-MM-dd").search().range();

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_USE.STATUS).form()
                .label("办理状态").selectBox().enumType(AssetHandleStatusEnum.class);

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_STOCK_GOODS_USE.STATUS,
                        EAMTables.EAM_ASSET_STOCK_GOODS_USE.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_STOCK_GOODS_USE.NAME,
                        EAMTables.EAM_ASSET_STOCK_GOODS_USE.BUSINESS_DATE,
                }
        );

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_USE.CONTENT).form().validate().required().form().textArea().height(80);

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_USE.ORIGINATOR_ID).table().fillBy("originator","name");
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_USE.ORIGINATOR_ID).form()
                .button().chooseEmployee(true);

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_USE.ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_USE.OWNER_TYPE).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_USE.UPDATE_BY).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_USE.UPDATE_TIME).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_USE.ATTACH_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_USE.CREATE_TIME).table().disable(true);

        cfg.bpm().form("eam_asset_stock_goods_use");
        cfg.bpm().integrate(IntegrateMode.FRONT);
        cfg.view().form().labelWidth(70);
        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(30);

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_STOCK_GOODS_USE.BUSINESS_DATE
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_STOCK_GOODS_USE.CONTENT,
                }
        );

        cfg.view().list().addJsVariable("OPER_TYPE","[[${operType}]]","operType");
        cfg.view().form().addJsVariable("OPER_TYPE","[[${operType}]]","operType");

        cfg.view().list().addJsVariable("OWNER_CODE","[[${ownerCode}]]","ownerCode");
        cfg.view().form().addJsVariable("OWNER_CODE","[[${ownerCode}]]","ownerCode");

        cfg.view().list().addJsVariable("OWNER_TYPE","[[${ownerType}]]","ownerType");
        cfg.view().form().addJsVariable("OWNER_TYPE","[[${ownerType}]]","ownerType");

        cfg.view().form().addPage("物品列表","goodsSelectList");
        cfg.view().search().inputWidth(Config.searchInputWidth);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setBpmEventAdaptor(WriteMode.IGNORE)
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        StockGoodsUseGtr g=new StockGoodsUseGtr();
        //生成代码
       g.generateCode();

     //   g.removeByBatchId("582429214846746624");
        //移除之前生成的菜单，视情况执行
     //  g.generateMenu(AssetStockGoodsUseServiceProxy.class, AssetStockGoodsUsePageController.class);

        //生成菜单

    }

}
