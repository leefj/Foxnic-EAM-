package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.eam.page.InspectionProcessActionPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.InspectionProcessActionServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class InspecProcessActionGtr extends BaseCodeGenerator{
    public InspecProcessActionGtr() {
        super(EAMTables.EAM_INSPECTION_PROCESS_ACTION.$TABLE,BASIC_SETTING_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.view().field(EAMTables.EAM_INSPECTION_PROCESS_ACTION.ID).basic().hidden(true);


        cfg.view().field(EAMTables.EAM_INSPECTION_PROCESS_ACTION.CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_INSPECTION_PROCESS_ACTION.NAME).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_INSPECTION_PROCESS_ACTION.CODE,
                        EAMTables.EAM_INSPECTION_PROCESS_ACTION.NAME,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().list().disableBatchDelete();
        cfg.view().field(EAMTables.EAM_INSPECTION_PROCESS_ACTION.CODE).form().validate().required();
        cfg.view().field(EAMTables.EAM_INSPECTION_PROCESS_ACTION.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_INSPECTION_PROCESS_ACTION.NOTES).form().textArea().height(80);
        cfg.view().field(EAMTables.EAM_INSPECTION_PROCESS_ACTION.CREATE_TIME).table().disable();
        cfg.view().field(EAMTables.EAM_INSPECTION_PROCESS_ACTION.UPDATE_BY).table().disable();


        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_INSPECTION_PROCESS_ACTION.CODE,
                        EAMTables.EAM_INSPECTION_PROCESS_ACTION.NAME,
                        EAMTables.EAM_INSPECTION_PROCESS_ACTION.CLASS_VALUE,
                        EAMTables.EAM_INSPECTION_PROCESS_ACTION.NOTES,
                }
        );

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
        InspecProcessActionGtr g=new InspecProcessActionGtr();
        //生成代码
        g.generateCode();


        //生成菜单
        //  g.removeByBatchId("");
        // g.generateMenu(InspectionProcessActionServiceProxy.class, InspectionProcessActionPageController.class);
    }
}
