package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.IotTables;
import com.dt.platform.constants.enums.eam.IotEqStatusEnum;
import com.dt.platform.constants.enums.eam.IotVirtEqTriggerTypeEnum;
import com.dt.platform.constants.enums.eam.IotVirtEqTypeEnum;
import com.dt.platform.domain.eam.EquipmentLabel;
import com.dt.platform.domain.eam.Product;
import com.dt.platform.domain.eam.meta.ProductMeta;
import com.dt.platform.domain.eam.meta.VirtEquipmentMeta;
import com.dt.platform.eam.page.EquipmentLabelPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.EquipmentLabelServiceProxy;
import com.dt.platform.proxy.eam.ProductServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class IotEqLabelGtr extends BaseCodeGenerator{
    public IotEqLabelGtr() {
        super(IotTables.IOT_EQUIPMENT_LABEL.$TABLE,"829049441838170112");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());



        cfg.view().field(IotTables.IOT_EQUIPMENT_LABEL.NAME).search().fuzzySearch();


        cfg.view().field(IotTables.IOT_EQUIPMENT_LABEL.ID).basic().hidden(true);
        cfg.view().search().inputLayout(
                new Object[]{
                        IotTables.IOT_EQUIPMENT_LABEL.NAME,
                }
        );
        cfg.view().search().disable();

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().list().disableBatchDelete();

        cfg.view().field(IotTables.IOT_EQUIPMENT_LABEL.UPDATE_BY).table().disable(true);
        cfg.view().field(IotTables.IOT_EQUIPMENT_LABEL.OWNER_ID).table().disable(true);

        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(75);
        cfg.view().form().addGroup(null,
                new Object[] {
                        IotTables.IOT_EQUIPMENT_LABEL.OWNER_ID,
                        IotTables.IOT_EQUIPMENT_LABEL.NAME,
                        IotTables.IOT_EQUIPMENT_LABEL.IDENTIFIER,
                        IotTables.IOT_EQUIPMENT_LABEL.VALUE,

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
        IotEqLabelGtr g=new IotEqLabelGtr();
        //生成代码
         g.generateCode();


        //生成菜单
        //  g.removeByBatchId("");
       // g.generateMenu(EquipmentLabelServiceProxy.class, EquipmentLabelPageController.class);
    }
}
