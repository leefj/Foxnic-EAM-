package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.IotTables;
import com.dt.platform.constants.enums.eam.IotDataTypeEnum;
import com.dt.platform.domain.eam.ProductFunctionItem;
import com.dt.platform.eam.page.ProductFunctionItemPageController;
import com.dt.platform.eam.service.impl.ProductFunctionItemServiceImpl;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.ProductFunctionItemServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class IotProductFunctionItemGtr extends BaseCodeGenerator{
    public IotProductFunctionItemGtr() {
        super(IotTables.IOT_PRODUCT_FUNCTION_ITEM.$TABLE,"829049441838170112");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());



        cfg.view().field(IotTables.IOT_PRODUCT_FUNCTION_ITEM.NAME).search().fuzzySearch();
        cfg.view().field(IotTables.IOT_PRODUCT_FUNCTION_ITEM.IDENTIFIER).search().fuzzySearch();


        cfg.view().field(IotTables.IOT_PRODUCT_FUNCTION_ITEM.ID).basic().hidden(true);
        cfg.view().search().inputLayout(
                new Object[]{
                        IotTables.IOT_PRODUCT_FUNCTION_ITEM.NAME,
                        IotTables.IOT_PRODUCT_FUNCTION_ITEM.IDENTIFIER,
                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().list().disableBatchDelete();


        cfg.view().field(IotTables.IOT_PRODUCT_FUNCTION_ITEM.NAME).form().validate().required();
        cfg.view().field(IotTables.IOT_PRODUCT_FUNCTION_ITEM.IDENTIFIER).form().validate().required();

        cfg.view().field(IotTables.IOT_PRODUCT_FUNCTION_ITEM.DATA_TYPE).form().validate().required().form().selectBox().
                enumType(IotDataTypeEnum.class);

        cfg.view().field(IotTables.IOT_PRODUCT_FUNCTION_ITEM.UPDATE_BY).table().disable(true);
        cfg.view().field(IotTables.IOT_PRODUCT_FUNCTION_ITEM.OWNER_ID).table().disable(true);

        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(180);
        cfg.view().form().addGroup(null,
                new Object[] {
                        IotTables.IOT_PRODUCT_FUNCTION_ITEM.NAME,
                        IotTables.IOT_PRODUCT_FUNCTION_ITEM.IDENTIFIER,
                        IotTables.IOT_PRODUCT_FUNCTION_ITEM.FUNCTION_DESC,
                        IotTables.IOT_PRODUCT_FUNCTION_ITEM.FUNCTION_UNIT,
                        IotTables.IOT_PRODUCT_FUNCTION_ITEM.DATA_TYPE,
                        IotTables.IOT_PRODUCT_FUNCTION_ITEM.DATA_VALUE,
                }
        );
        cfg.view().list().addJsVariable("OWNER_ID","[[${ownerId}]]","ownerId");
        cfg.view().form().addJsVariable("OWNER_ID","[[${ownerId}]]","ownerId");
        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        IotProductFunctionItemGtr g=new IotProductFunctionItemGtr();
        //生成代码
         g.generateCode();

        //生成菜单
        //  g.removeByBatchId("");
       // g.generateMenu(ProductFunctionItemServiceProxy.class, ProductFunctionItemPageController.class);
    }
}
