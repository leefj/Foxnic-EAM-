package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.DeviceSpStatusEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.eam.page.DeviceSpPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.*;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class SpGtr extends BaseCodeGenerator {


    public SpGtr() {
        super(EAMTables.EAM_DEVICE_SP.$TABLE,"572717805598670848");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_DEVICE_SP.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_DEVICE_SP.ID).table().hidden(true);


        cfg.getPoClassFile().addSimpleProperty(GoodsStock.class,"goods","goods","goods");
        cfg.getPoClassFile().addSimpleProperty(String.class,"goodsFillCode","goodsFillCode","goodsFillCode");
        cfg.getPoClassFile().addSimpleProperty(String.class,"goodsFillModel","goodsFillModel","goodsFillModel");

        cfg.getPoClassFile().addSimpleProperty(DeviceSpType.class,"deviceSpType","deviceSpType","deviceSpType");

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"manager","manager","manager");
        cfg.getPoClassFile().addSimpleProperty(Position.class,"position","存放位置","存放位置");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"usage","usage","usage");

        cfg.getPoClassFile().addListProperty(Asset.class,"assetList","assetList","assetList");
        cfg.getPoClassFile().addListProperty(DeviceAssociate.class,"deviceAssociate","deviceAssociate","deviceAssociate");


        cfg.getPoClassFile().addSimpleProperty(Warehouse.class,"warehouse","仓库","仓库");

        cfg.getPoClassFile().addSimpleProperty(String.class,"ownerType","ownerType","ownerType");
        cfg.getPoClassFile().addSimpleProperty(String.class,"selectedCode","selectedCode","selectedCode");
        cfg.getPoClassFile().addSimpleProperty(String.class,"ownerId","ownerId","ownerId");


        cfg.getPoClassFile().addSimpleProperty(String.class,"psCategoryId","psCategoryId","psCategoryId");
      //  cfg.getPoClassFile().addSimpleProperty(String.class,"listCategoryName","listCategoryName","listCategoryName");

        cfg.view().field(EAMTables.EAM_DEVICE_SP.SUPPLIER).search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_DEVICE_SP.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_DEVICE_SP.CREATE_TIME).search().range();
        cfg.view().field(EAMTables.EAM_DEVICE_SP.INSERT_TIME).search().range();
        cfg.view().field(EAMTables.EAM_DEVICE_SP.SOURCE_DESC).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_DEVICE_SP.CODE).search().fuzzySearch();
//        cfg.view().field(EAMTables.EAM_DEVICE_SP.INSERT_TIME).form().dateInput().type(DatePickerType.date);

        cfg.view().field(EAMTables.EAM_DEVICE_SP.INSERT_TIME).form().dateInput().format("yyyy-MM-dd");
        cfg.view().field(EAMTables.EAM_DEVICE_SP.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_DEVICE_SP.ADAPTING_DEVICE).search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_DEVICE_SP.SN).search().fuzzySearch();
        cfg.view().field( DeviceSpMeta.GOODS_FILL_CODE).search().fuzzySearch();
        cfg.view().field( DeviceSpMeta.GOODS_FILL_MODEL).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_DEVICE_SP.STATUS,
                        EAMTables.EAM_DEVICE_SP.MANAGER_USER_ID,
                        EAMTables.EAM_DEVICE_SP.USAGE_RANGE,
                        EAMTables.EAM_DEVICE_SP.SUPPLIER,

                },
                new Object[]{
                        EAMTables.EAM_DEVICE_SP.CODE,
                        EAMTables.EAM_DEVICE_SP.NAME,
                        EAMTables.EAM_DEVICE_SP.SN,
                        EAMTables.EAM_DEVICE_SP.SOURCE_DESC,
                },
                new Object[]{
                        EAMTables.EAM_DEVICE_SP.WAREHOUSE_ID,
                        EAMTables.EAM_DEVICE_SP.ADAPTING_DEVICE,
                        EAMTables.EAM_DEVICE_SP.INSERT_TIME,
                },
                new Object[]{
                        EAMTables.EAM_DEVICE_SP.GOOD_ID,
                        DeviceSpMeta.GOODS_FILL_CODE,
                        DeviceSpMeta.GOODS_FILL_MODEL
                }

        );


        cfg.view().field( DeviceSpMeta.GOODS_FILL_CODE).basic().label("物品档案编号").table().disable(false);
        cfg.view().field( DeviceSpMeta.GOODS_FILL_MODEL).basic().label("物品档案型号").table().disable(false);

        cfg.view().field( DeviceSpMeta.GOODS_FILL_CODE).table().fillBy("goods","code");
        cfg.view().field( DeviceSpMeta.GOODS_FILL_MODEL).table().fillBy("goods","model");


        cfg.view().field(EAMTables.EAM_DEVICE_SP.PICTURE_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_DEVICE_SP.LOCKED).table().disable(true);
        cfg.view().field(EAMTables.EAM_DEVICE_SP.CREATE_TIME).table().disable(true);
        cfg.view().field(EAMTables.EAM_DEVICE_SP.SP_NUMBER).table().disable(true);
        cfg.view().field(EAMTables.EAM_DEVICE_SP.TYPE).table().disable(true);

        cfg.view().field(EAMTables.EAM_DEVICE_SP.NOTES).table().disable(true);
        cfg.view().field(EAMTables.EAM_DEVICE_SP.NOTES).table().disable(true);

        cfg.view().field(EAMTables.EAM_DEVICE_SP.NOTES).form().textArea().height(150);

        cfg.view().field(EAMTables.EAM_DEVICE_SP.PICTURE_ID).form().upload().acceptImageType().maxFileCount(1);

        cfg.view().field(EAMTables.EAM_DEVICE_SP.MANAGER_USER_ID).table().fillBy("manager","name");
        cfg.view().field(EAMTables.EAM_DEVICE_SP.MANAGER_USER_ID).form()
                .button().chooseEmployee(true);

        cfg.view().field(EAMTables.EAM_DEVICE_SP.STATUS).form().radioBox().enumType(DeviceSpStatusEnum.class).defaultIndex(0);
        cfg.view().field(EAMTables.EAM_DEVICE_SP.TYPE)
                .form().selectBox().queryApi(DeviceSpTypeServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(DeviceSpTypeMeta.ID).textField( DeviceSpTypeMeta.HIERARCHY_NAME).fillWith(DeviceSpMeta.DEVICE_SP_TYPE).muliti(false);

        cfg.view().field(EAMTables.EAM_DEVICE_SP.WAREHOUSE_ID)
                .form().validate().required().form().selectBox().queryApi(WarehouseServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(WarehouseMeta.ID).textField( WarehouseMeta.WAREHOUSE_NAME).fillWith(DeviceSpMeta.WAREHOUSE).muliti(false);


//        cfg.view().field(EAMTables.EAM_DEVICE_SP.GOOD_ID)
//                .form().validate().required().form().selectBox().queryApi(GoodsStockServiceProxy.QUERY_PAGED_LIST+"?ownerCode=goods").paging(true).filter(true).toolbar(false)
//                .valueField(GoodsStockMeta.ID).textField(GoodsStockMeta.NAME).fillWith(DeviceSpMeta.GOODS).muliti(false);

        cfg.view().field(EAMTables.EAM_DEVICE_SP.GOOD_ID).form().validate().required().form().button().action("物品选择","goodsSelect");

        cfg.view().field(EAMTables.EAM_DEVICE_SP.LOC_ID)
                .basic().label("存放位置")
                .form().selectBox().queryApi(PositionServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(PositionMeta.ID).textField( PositionMeta.HIERARCHY_NAME).fillWith(DeviceSpMeta.POSITION).muliti(false);

        cfg.view().field(EAMTables.EAM_DEVICE_SP.USAGE_RANGE)
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_sp_usage_range").paging(false).filter(true).toolbar(false)
                .valueField(DictItemMeta.CODE).textField( DictItemMeta.LABEL).fillWith(DeviceSpMeta.USAGE).muliti(false);

        cfg.view().list().addToolButton("批量确认","bathSure","device-bath-sure-button","eam_device_sp:batchsure");
        cfg.view().list().operationColumn().addActionButton("状态","modifyStatus","device-status-button","eam_device_sp:status");
        cfg.view().list().operationColumn().addActionButton("使用记录","usedDetail","device-detail-button","eam_device_sp:detail");


        cfg.view().list().disableBatchDelete();

        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);

        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(100);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_DEVICE_SP.CODE,
                        EAMTables.EAM_DEVICE_SP.GOOD_ID,
                        EAMTables.EAM_DEVICE_SP.NAME,
                        EAMTables.EAM_DEVICE_SP.MODEL,
                        EAMTables.EAM_DEVICE_SP.SN,
                        EAMTables.EAM_DEVICE_SP.USAGE_RANGE,
                },
                new Object[] {
                        EAMTables.EAM_DEVICE_SP.MANAGER_USER_ID,
                        EAMTables.EAM_DEVICE_SP.WAREHOUSE_ID,
                        EAMTables.EAM_DEVICE_SP.LOC_ID,
                        EAMTables.EAM_DEVICE_SP.SUPPLIER,
                        EAMTables.EAM_DEVICE_SP.INSERT_TIME
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_DEVICE_SP.SOURCE_DESC,
                        EAMTables.EAM_DEVICE_SP.ADAPTING_DEVICE,
                        EAMTables.EAM_DEVICE_SP.NOTES,
                        EAMTables.EAM_DEVICE_SP.PICTURE_ID
                }
        );


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        SpGtr g=new SpGtr();
        //生成代码
       g.generateCode();

     //   g.removeByBatchId("582429214846746624");
        //移除之前生成的菜单，视情况执行
   //  g.generateMenu(DeviceSpServiceProxy.class, DeviceSpPageController.class);
        //生成菜单

    }

}
