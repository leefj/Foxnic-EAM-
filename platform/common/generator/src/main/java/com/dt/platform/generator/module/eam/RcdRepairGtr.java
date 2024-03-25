package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.RepairRcd;
import com.dt.platform.eam.page.RepairRcdPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.RepairRcdServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class RcdRepairGtr extends BaseCodeGenerator{
    public RcdRepairGtr() {
        super(EAMTables.EAM_REPAIR_RCD.$TABLE,"489424103724285952");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.view().field(EAMTables.EAM_REPAIR_RCD.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_REPAIR_RCD.CONTENT).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_REPAIR_RCD.BUSINESS_CODE).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_REPAIR_RCD.BUSINESS_CODE,
                }
        );

        cfg.view().field(EAMTables.EAM_REPAIR_RCD.UPDATE_BY).table().disable(true);
        cfg.view().field(EAMTables.EAM_REPAIR_RCD.OPER_USER_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_REPAIR_RCD.CREATE_TIME).table().disable(true);
        cfg.view().field(EAMTables.EAM_REPAIR_RCD.OPER_USER_NAME).table().disable(true);
        cfg.view().field(EAMTables.EAM_REPAIR_RCD.ASSET_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_REPAIR_RCD.CONTENT).form().textArea().height(Config.textAreaHeight);


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().search().rowsDisplay(1);

        cfg.view().list().disableCreateNew();
        cfg.view().list().disableSpaceColumn();
        cfg.view().list().disableModify();
        cfg.view().list().disableBatchDelete();
        cfg.view().list().disableSingleDelete();
        cfg.view().search().disable();

        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_REPAIR_RCD.BUSINESS_CODE,
                        EAMTables.EAM_REPAIR_RCD.RCD_TIME,
                        EAMTables.EAM_REPAIR_RCD.CONTENT,

                }
        );
        cfg.view().list().addToolButton("详细情况","rcdDetail","rcd-detail");
        cfg.view().list().addJsVariable("ASSET_ID","[[${assetId}]]","assetId");
        cfg.view().list().addJsVariable("SOURCE","[[${source}]]","source");
        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        RcdRepairGtr g=new RcdRepairGtr();
        //生成代码
         g.generateCode();


        //生成菜单
        //  g.removeByBatchId("");
     //  g.generateMenu(RepairRcdServiceProxy.class, RepairRcdPageController.class);
    }
}
