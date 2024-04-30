package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.ValidStatusEnum;
import com.dt.platform.constants.enums.common.YesNoEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetHandleTypeMeta;
import com.dt.platform.domain.eam.meta.AssetScrapMeta;
import com.dt.platform.domain.eam.meta.AssetStatusMeta;
import com.dt.platform.eam.page.AssetHandleTypePageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetHandleTypeServiceProxy;
import com.dt.platform.proxy.eam.AssetStatusServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import jdk.jfr.Enabled;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

import java.util.logging.Handler;

public class EamAssetHandleTypeGtr extends BaseCodeGenerator{
    public EamAssetHandleTypeGtr() {
        super(EAMTables.EAM_ASSET_HANDLE_TYPE.$TABLE,"471986431431016449");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(AssetStatus.class,"assetStatusData","assetStatusData","assetStatusData");

        cfg.view().field(EAMTables.EAM_ASSET_HANDLE_TYPE.ID).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_ASSET_HANDLE_TYPE.LABEL).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_HANDLE_TYPE.STATUS,
                        EAMTables.EAM_ASSET_HANDLE_TYPE.CLEAN_STATUS,
                        EAMTables.EAM_ASSET_HANDLE_TYPE.LABEL,
                        EAMTables.EAM_ASSET_HANDLE_TYPE.CODE,
                }
        );
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().list().disableBatchDelete();
        cfg.view().form().labelWidth(70);
        cfg.view().list().operationColumn().width(350);
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE_TYPE.LABEL).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE_TYPE.STATUS).form().validate().required().form().radioBox().enumType(ValidStatusEnum.class).defaultIndex(0);
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE_TYPE.CLEAN_STATUS).form().validate().required().form().radioBox().enumType(YesNoEnum.class).defaultIndex(0);
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE_TYPE.CODE).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE_TYPE.NOTES).form().textArea().height(80);
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE_TYPE.NOTES).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE_TYPE.UPDATE_BY).table().disable(true);

        cfg.view().field(EAMTables.EAM_ASSET_HANDLE_TYPE.HANDLE_STATUS)
                .form().validate().required().form().selectBox().queryApi(AssetStatusServiceProxy.QUERY_LIST)
                .paging(false).filter(true).toolbar(false)
                .valueField(AssetStatusMeta.CODE).
                textField(AssetStatusMeta.NAME).
                fillWith(AssetHandleTypeMeta.ASSET_STATUS_DATA).muliti(false).defaultIndex(0);
        //分成分组布局
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_HANDLE_TYPE.CODE,
                        EAMTables.EAM_ASSET_HANDLE_TYPE.LABEL,
                        EAMTables.EAM_ASSET_HANDLE_TYPE.STATUS,
                        EAMTables.EAM_ASSET_HANDLE_TYPE.HANDLE_STATUS,
                        EAMTables.EAM_ASSET_HANDLE_TYPE.CLEAN_STATUS,
                        EAMTables.EAM_ASSET_HANDLE_TYPE.ACTION_METHOD,
                        EAMTables.EAM_ASSET_HANDLE_TYPE.NOTES,
                }
        );


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EamAssetHandleTypeGtr g=new EamAssetHandleTypeGtr();
        //生成代码
         g.generateCode();
         //g.generateMenu(AssetHandleTypeServiceProxy.class, AssetHandleTypePageController.class);
    }
}
