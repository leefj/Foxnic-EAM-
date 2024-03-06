package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.meta.AssetScanSceneMeta;
import com.dt.platform.domain.eam.meta.InspectionRouteMeta;
import com.dt.platform.domain.eam.meta.InspectionTaskPointMeta;
import com.dt.platform.eam.page.AssetScanScenePageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetScanSceneServiceProxy;
import com.dt.platform.proxy.eam.InspectionRouteServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class ScanMethodGtr extends BaseCodeGenerator {


    public ScanMethodGtr() {
        super(EAMTables.EAM_ASSET_SCAN_SCENE.$TABLE,"637280752681091072");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(EAMTables.EAM_ASSET_SCAN_SCENE.ID).basic().hidden(true);

        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"methodDict","methodDict","methodDict");

        cfg.view().field(EAMTables.EAM_ASSET_SCAN_SCENE.NAME).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_SCAN_SCENE.NAME,

                }
        );

        cfg.view().list().disableBatchDelete();

        cfg.view().field(EAMTables.EAM_ASSET_SCAN_SCENE.CREATE_TIME).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SCAN_SCENE.UPDATE_BY).table().disable(true);


        cfg.view().field(EAMTables.EAM_ASSET_SCAN_SCENE.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_SCAN_SCENE.CODE).form().validate().required();

        cfg.view().formWindow().bottomSpace(120);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_SCAN_SCENE.CODE,
                        EAMTables.EAM_ASSET_SCAN_SCENE.NAME,
                        EAMTables.EAM_ASSET_SCAN_SCENE.METHOD,
                }
        );

        cfg.view().field(EAMTables.EAM_ASSET_SCAN_SCENE.METHOD)
                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_label_scan_method")
                .paging(false).filter(true).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(AssetScanSceneMeta.METHOD_DICT).muliti(false).defaultIndex(0);

        cfg.view().search().inputWidth(Config.searchInputWidth);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        ScanMethodGtr g=new ScanMethodGtr();
        //生成代码
       g.generateCode();

     //   g.removeByBatchId("582429214846746624");
        //移除之前生成的菜单，视情况执行
     // g.generateMenu(AssetScanSceneServiceProxy.class, AssetScanScenePageController.class);
        //生成菜单

    }

}
