package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.IotTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.IotDataTypeEnum;
import com.dt.platform.constants.enums.eam.IotFunctionPropertyAclEnum;
import com.dt.platform.constants.enums.eam.IotProductFunctionEnum;
import com.dt.platform.domain.eam.ProductFunction;
import com.dt.platform.domain.eam.ProductFunctionItem;
import com.dt.platform.eam.page.ProductFunctionPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.ProductFunctionServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class IotProductFunctionGtr extends BaseCodeGenerator{
    public IotProductFunctionGtr() {
        super(IotTables.IOT_PRODUCT_FUNCTION.$TABLE,"829049441838170112");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addListProperty(ProductFunctionItem.class,"inputFunctionParams","inputFunctionParams","inputFunctionParams");
        cfg.getPoClassFile().addListProperty(ProductFunctionItem.class,"outputFunctionParams","outputFunctionParams","outputFunctionParams");

        cfg.view().field(IotTables.IOT_PRODUCT_FUNCTION.NAME).search().fuzzySearch();
        cfg.view().field(IotTables.IOT_PRODUCT_FUNCTION.IDENTIFIER).search().fuzzySearch();


        cfg.view().field(IotTables.IOT_PRODUCT_FUNCTION.ID).basic().hidden(true);
        cfg.view().search().inputLayout(
                new Object[]{
                        IotTables.IOT_PRODUCT_FUNCTION.TYPE,
                        IotTables.IOT_PRODUCT_FUNCTION.NAME,
                        IotTables.IOT_PRODUCT_FUNCTION.IDENTIFIER,
                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(IotTables.IOT_PRODUCT_FUNCTION.NAME).form().validate().required();
        cfg.view().field(IotTables.IOT_PRODUCT_FUNCTION.IDENTIFIER).form().validate().required();

        cfg.view().field(IotTables.IOT_PRODUCT_FUNCTION.TYPE).form().validate().required().form().selectBox().
                enumType(IotProductFunctionEnum.class).defaultIndex(0);


        cfg.view().field(IotTables.IOT_PRODUCT_FUNCTION.ACL).form().radioBox().
                enumType(IotFunctionPropertyAclEnum.class).defaultIndex(0);

        cfg.view().field(IotTables.IOT_PRODUCT_FUNCTION.DATA_TYPE).form().selectBox().
                enumType(IotDataTypeEnum.class).defaultIndex(0);

        cfg.view().list().disableBatchDelete();

        cfg.view().field(IotTables.IOT_PRODUCT_FUNCTION.UPDATE_BY).table().disable(true);
        cfg.view().field(IotTables.IOT_PRODUCT_FUNCTION.PRODUCT_ID).table().disable(true);





        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup(null,
                new Object[] {
                        IotTables.IOT_PRODUCT_FUNCTION.TYPE,
                },
                new Object[] {
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        IotTables.IOT_PRODUCT_FUNCTION.NAME,


                },
                new Object[] {
                        IotTables.IOT_PRODUCT_FUNCTION.IDENTIFIER,


                }
        );


        cfg.view().form().addGroup("dataDefine","属性定义",
                new Object[] {
                        IotTables.IOT_PRODUCT_FUNCTION.FUNCTION_DESC,
                        IotTables.IOT_PRODUCT_FUNCTION.FUNCTION_UNIT,
                        IotTables.IOT_PRODUCT_FUNCTION.DATA_TYPE,
                        IotTables.IOT_PRODUCT_FUNCTION.ACL,
                },
                new Object[] {
                }
        );
        cfg.view().form().addPage("inputParam","输入参数","inputParamList");
        cfg.view().form().addPage("outputParam","输出参数","outputParamList");
        cfg.view().list().addJsVariable("PRODUCT_ID","[[${productId}]]","productId");
        cfg.view().form().addJsVariable("PRODUCT_ID","[[${productId}]]","productId");

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
        IotProductFunctionGtr g=new IotProductFunctionGtr();
        //生成代码
         g.generateCode();

        //生成菜单
        //  g.removeByBatchId("");
       // g.generateMenu(ProductFunctionServiceProxy.class, ProductFunctionPageController.class);
    }
}
