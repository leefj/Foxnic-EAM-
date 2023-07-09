package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.CheckItem;
import com.dt.platform.domain.eam.InspectionPointPos;
import com.dt.platform.domain.eam.InspectionRoute;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.eam.meta.InspectionPointMeta;
import com.dt.platform.domain.eam.meta.InspectionPointPosMeta;
import com.dt.platform.domain.eam.meta.InspectionRouteMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetServiceProxy;
import com.dt.platform.proxy.eam.InspectionPointPosServiceProxy;
import com.dt.platform.proxy.eam.InspectionRouteServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class InspPointItemGtr extends BaseCodeGenerator {


    public InspPointItemGtr() {
        super(EAMTables.EAM_INSPECTION_POINT_ITEM.$TABLE,BASIC_INSP);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_INSPECTION_POINT_ITEM.ID).basic().hidden(true);


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_INSPECTION_POINT_ITEM.ITEM_ID,
                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().formWindow().width(Config.baseFormWidth);

        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().bottomSpace(20);


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
        InspPointItemGtr g=new InspPointItemGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
       //g.generateMenu(InspectionPointServiceProxy.class, InspectionPointPageController.class);
        //生成菜单

    }

}
