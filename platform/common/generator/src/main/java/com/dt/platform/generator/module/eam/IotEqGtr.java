package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.IotTables;
import com.dt.platform.constants.enums.eam.IotEqStatusEnum;
import com.dt.platform.domain.eam.Equipment;
import com.dt.platform.domain.eam.Product;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.eam.page.EquipmentPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.EquipmentServiceProxy;
import com.dt.platform.proxy.eam.ProductServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class IotEqGtr extends BaseCodeGenerator{
    public IotEqGtr() {
        super(IotTables.IOT_EQUIPMENT.$TABLE,"829049441838170112");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(Product.class,"iotProduct","iotProduct","iotProduct");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"group","group","group");


        cfg.view().field(IotTables.IOT_EQUIPMENT.DN).search().fuzzySearch();

        cfg.view().field(IotTables.IOT_EQUIPMENT.ID).basic().hidden(true);
        cfg.view().search().inputLayout(
                new Object[]{
                        IotTables.IOT_EQUIPMENT.GROUP_CODE,
                        IotTables.IOT_EQUIPMENT.PRODUCT_ID,
                        IotTables.IOT_EQUIPMENT.DN,
                        IotTables.IOT_EQUIPMENT.STATUS,
                }

        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(IotTables.IOT_EQUIPMENT.UPDATE_BY).table().disable(true);

        cfg.view().field(IotTables.IOT_EQUIPMENT.DN)
                .form().validate().required();

        cfg.view().field(IotTables.IOT_EQUIPMENT.PRODUCT_ID)
                .form().validate().required().form().selectBox().
                queryApi(ProductServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(ProductMeta.ID).textField(ProductMeta.NAME)
                .fillWith(EquipmentMeta.IOT_PRODUCT).muliti(false);


        cfg.view().field(IotTables.IOT_EQUIPMENT.STATUS).form().radioBox().enumType(IotEqStatusEnum.class);

        cfg.view().field(IotTables.IOT_EQUIPMENT.GROUP_CODE)
                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_iot_product_group")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(EquipmentMeta.GROUP).muliti(false);




        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(75);



        cfg.view().form().addGroup(null,
                new Object[] {
                        IotTables.IOT_EQUIPMENT.GROUP_CODE,
                        IotTables.IOT_EQUIPMENT.PRODUCT_ID,
                        IotTables.IOT_EQUIPMENT.DN,
                        IotTables.IOT_EQUIPMENT.NOTES,
                }
        );
        cfg.view().list().operationColumn().addActionButton("详细","detail","obj-detail");
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
        IotEqGtr g=new IotEqGtr();
        //生成代码
         g.generateCode();

        //生成菜单
        //  g.removeByBatchId("");
     //   g.generateMenu(EquipmentServiceProxy.class, EquipmentPageController.class);
    }
}
