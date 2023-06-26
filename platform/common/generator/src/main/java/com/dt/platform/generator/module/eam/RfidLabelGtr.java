package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.RfidStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.eam.meta.InventoryMeta;
import com.dt.platform.domain.eam.meta.PositionMeta;
import com.dt.platform.domain.eam.meta.RfidLabelMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetServiceProxy;
import com.dt.platform.proxy.eam.PositionServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class RfidLabelGtr extends BaseCodeGenerator {


    public RfidLabelGtr() {
        super(EAMTables.EAM_RFID_LABEL.$TABLE,"489424103724285952");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_RFID_LABEL.ID).basic().hidden(true);
        cfg.getPoClassFile().addSimpleProperty(Asset.class,"asset","资产","资产");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"operUser","operUser","operUser");

        cfg.view().field(EAMTables.EAM_RFID_LABEL.ASSET_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_RFID_LABEL.LABEL).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_RFID_LABEL.STATUS,
                        EAMTables.EAM_RFID_LABEL.ASSET_ID,
                        EAMTables.EAM_RFID_LABEL.ASSET_CODE,
                        EAMTables.EAM_RFID_LABEL.LABEL,
                }
        );


        cfg.view().field(EAMTables.EAM_RFID_LABEL.OPER_USER_ID).table().fillBy("operUser","name");
        cfg.view().field(EAMTables.EAM_RFID_LABEL.OPER_USER_ID).form()
                .button().chooseEmployee(true);

        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().list().excel(true,true);
        cfg.view().list().disableCreateNew();

        cfg.view().field(EAMTables.EAM_RFID_LABEL.STATUS).form().validate().required().form().radioBox().enumType(RfidStatusEnum.class).defaultIndex(0);
        cfg.view().field(EAMTables.EAM_RFID_LABEL.RELEASE_ID).form().table().disable(true);

        cfg.view().list().addToolButton("选择资产","select_data","select_data","eam_rfid_release:select_data");
        cfg.view().list().addToolButton("导入","import_data","import_data","eam_rfid_release:import_data");
        cfg.view().list().addToolButton("发卡","release_data","release_data","eam_rfid_release:release_data");
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(EAMTables.EAM_RFID_LABEL.ASSET_ID)
                .form().validate().required().form().selectBox().queryApi(AssetServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(AssetMeta.ID).textField(AssetMeta.NAME).fillWith(RfidLabelMeta.ASSET).muliti(false);

        cfg.view().list().addJsVariable("RELEASE_ID",   "[[${releaseId}]]","releaseId");
        cfg.view().list().addJsVariable("STATUS",   "[[${status}]]","status");

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_RFID_LABEL.ASSET_ID,
                        EAMTables.EAM_RFID_LABEL.LABEL,
                        EAMTables.EAM_RFID_LABEL.OPER_TIME,
                        EAMTables.EAM_RFID_LABEL.NOTES,
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
        RfidLabelGtr g=new RfidLabelGtr();
        //生成代码
       g.generateCode();

     //   g.removeByBatchId("582429214846746624");
        //移除之前生成的菜单，视情况执行
    //  g.generateMenu(RfidLabelServiceProxy.class, RfidLabelPageController.class);
        //生成菜单

    }

}
