package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.IotTables;
import com.dt.platform.constants.enums.eam.IotEqStatusEnum;
import com.dt.platform.constants.enums.eam.IotVirtEqStatusEnum;
import com.dt.platform.constants.enums.eam.IotVirtEqTriggerTypeEnum;
import com.dt.platform.constants.enums.eam.IotVirtEqTypeEnum;
import com.dt.platform.domain.eam.InspectionPlan;
import com.dt.platform.domain.eam.Product;
import com.dt.platform.domain.eam.VirtEquipment;
import com.dt.platform.domain.eam.meta.InspectionGroupMeta;
import com.dt.platform.domain.eam.meta.InspectionTaskMeta;
import com.dt.platform.domain.eam.meta.ProductMeta;
import com.dt.platform.domain.eam.meta.VirtEquipmentMeta;
import com.dt.platform.eam.page.EquipmentPageController;
import com.dt.platform.eam.page.VirtEquipmentPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.EquipmentServiceProxy;
import com.dt.platform.proxy.eam.InspectionGroupServiceProxy;
import com.dt.platform.proxy.eam.ProductServiceProxy;
import com.dt.platform.proxy.eam.VirtEquipmentServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class IotVirtEqGtr extends BaseCodeGenerator{
    public IotVirtEqGtr() {
        super(IotTables.IOT_VIRT_EQUIPMENT.$TABLE,"829049441838170112");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(Product.class,"iotProduct","iotProduct","iotProduct");



        cfg.view().field(IotTables.IOT_VIRT_EQUIPMENT.NAME).search().fuzzySearch();


        cfg.view().field(IotTables.IOT_VIRT_EQUIPMENT.ID).basic().hidden(true);
        cfg.view().search().inputLayout(
                new Object[]{
                        IotTables.IOT_VIRT_EQUIPMENT.OWNER_ID,
                        IotTables.IOT_VIRT_EQUIPMENT.TYPE,
                        IotTables.IOT_VIRT_EQUIPMENT.TRIGGER_TYPE,
                        IotTables.IOT_VIRT_EQUIPMENT.NAME,
                }
                ,
                new Object[]{
                        IotTables.IOT_VIRT_EQUIPMENT.STATUS,

                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(IotTables.IOT_VIRT_EQUIPMENT.STATUS).form().radioBox().enumType(IotEqStatusEnum.class);
  //      cfg.view().field(IotTables.IOT_VIRT_EQUIPMENT.TYPE).form().radioBox().enumType(IotVirtEqStatusEnum.class);

        cfg.view().field(IotTables.IOT_VIRT_EQUIPMENT.TRIGGER_TYPE).form().validate().required().form().radioBox().enumType(IotVirtEqTriggerTypeEnum.class).defaultIndex(0);

        cfg.view().field(IotTables.IOT_VIRT_EQUIPMENT.TYPE).form().validate().required().form().radioBox().enumType(IotVirtEqTypeEnum.class).defaultIndex(0);

        cfg.view().field(IotTables.IOT_VIRT_EQUIPMENT.UPDATE_BY).table().disable(true);

        cfg.view().field(IotTables.IOT_VIRT_EQUIPMENT.OWNER_ID)
                .form().validate().required().form().selectBox().
                queryApi(ProductServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(ProductMeta.ID).textField(ProductMeta.NAME)
                .fillWith(VirtEquipmentMeta.IOT_PRODUCT).muliti(false);

        cfg.view().field(IotTables.IOT_VIRT_EQUIPMENT.NAME)
                .form().validate().required();


        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(75);
        cfg.view().form().addGroup(null,
                new Object[] {
                        IotTables.IOT_VIRT_EQUIPMENT.OWNER_ID,
                        IotTables.IOT_VIRT_EQUIPMENT.NAME,



                },
                new Object[] {
                        IotTables.IOT_VIRT_EQUIPMENT.TYPE,
                        IotTables.IOT_VIRT_EQUIPMENT.TRIGGER_TYPE,

                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {

                        IotTables.IOT_VIRT_EQUIPMENT.NOTES,

                }
        );

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
        IotVirtEqGtr g=new IotVirtEqGtr();
        //生成代码
         g.generateCode();

        //生成菜单
        //  g.removeByBatchId("");
       // g.generateMenu(VirtEquipmentServiceProxy.class, VirtEquipmentPageController.class);
    }
}
