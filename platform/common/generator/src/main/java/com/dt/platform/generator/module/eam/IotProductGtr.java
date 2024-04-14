package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.IotTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.common.YesNoEnum;
import com.dt.platform.constants.enums.eam.IotLocationMethodEnum;
import com.dt.platform.constants.enums.eam.IotNodeTypeEnum;
import com.dt.platform.constants.enums.eam.IotVirtEqTypeEnum;
import com.dt.platform.domain.eam.Product;
import com.dt.platform.domain.eam.ProductFunction;
import com.dt.platform.domain.eam.meta.EquipmentMeta;
import com.dt.platform.domain.eam.meta.ProductMeta;
import com.dt.platform.eam.page.ProductPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.ProductServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class IotProductGtr extends BaseCodeGenerator{
    public IotProductGtr() {
        super(IotTables.IOT_PRODUCT.$TABLE,"829049441838170112");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"category","category","category");

        cfg.getPoClassFile().addSimpleProperty(String.class,"selectedCode","selectedCode","selectedCode");

        cfg.getPoClassFile().addListProperty(ProductFunction.class,"productFunctionEvent","productFunctionEvent","productFunctionEvent");


        cfg.getPoClassFile().addListProperty(ProductFunction.class,"productFunctionProperty","productFunctionProperty","productFunctionProperty");
        cfg.getPoClassFile().addListProperty(ProductFunction.class,"productFunctionService","productFunctionService","productFunctionService");


        cfg.view().field(IotTables.IOT_PRODUCT.PRODUCT_KEY).search().fuzzySearch();


        cfg.view().field(IotTables.IOT_PRODUCT.ID).basic().hidden(true);
        cfg.view().search().inputLayout(
                new Object[]{
                        IotTables.IOT_PRODUCT.CATEGORY_ID,
                        IotTables.IOT_PRODUCT.PRODUCT_TYPE,
                        IotTables.IOT_PRODUCT.LOCATION_STATUS,
                        IotTables.IOT_PRODUCT.PRODUCT_KEY
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(IotTables.IOT_PRODUCT.IMAGE_ID).table().disable(true);
        cfg.view().field(IotTables.IOT_PRODUCT.IMAGE_ID).form().upload().acceptSingleImage();
        cfg.view().field(IotTables.IOT_PRODUCT.UPDATE_BY).table().disable(true);


        cfg.view().field(IotTables.IOT_PRODUCT.PRODUCT_TRANSPARENT).form().validate().required().form().radioBox().enumType(YesNoEnum.class).defaultIndex(0);
        cfg.view().field(IotTables.IOT_PRODUCT.LOCATION_STATUS).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);

        cfg.view().field(IotTables.IOT_PRODUCT.LOCATION_METHOD).form().radioBox().enumType(IotLocationMethodEnum.class).defaultIndex(0);


        cfg.view().field(IotTables.IOT_PRODUCT.PRODUCT_TYPE).form().validate().required().form().radioBox().enumType(IotNodeTypeEnum.class).defaultIndex(0);


        cfg.view().field(IotTables.IOT_PRODUCT.NAME)
                .form().validate().required();


        cfg.view().field(IotTables.IOT_PRODUCT.CATEGORY_ID)

                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_iot_product_category")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(ProductMeta.CATEGORY).muliti(false);



        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(75);
        cfg.view().form().addGroup(null,
                new Object[] {
                        IotTables.IOT_PRODUCT.PRODUCT_KEY,
                        IotTables.IOT_PRODUCT.NAME,
                        IotTables.IOT_PRODUCT.LOCATION_STATUS,
                        IotTables.IOT_PRODUCT.LOCATION_METHOD,
                },
                new Object[] {
                        IotTables.IOT_PRODUCT.CATEGORY_ID,
                        IotTables.IOT_PRODUCT.PRODUCT_TYPE,
                        IotTables.IOT_PRODUCT.PRODUCT_TRANSPARENT,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        IotTables.IOT_PRODUCT.IMAGE_ID,
                }
        );

        cfg.view().list().operationColumn().addActionButton("物模型","objModel","obj-model");
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
        IotProductGtr g=new IotProductGtr();
        //生成代码
         g.generateCode();

        //生成菜单
        //  g.removeByBatchId("");
       // g.generateMenu(ProductServiceProxy.class, ProductPageController.class);
    }
}
