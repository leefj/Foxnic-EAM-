package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.eam.page.InspectionPointPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.*;
import com.github.foxnic.generator.config.WriteMode;

public class InspPointGtr extends BaseCodeGenerator {


    public InspPointGtr() {
        super(EAMTables.EAM_INSPECTION_POINT.$TABLE,BASIC_INSP);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.ID).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.CODE).search().fuzzySearch();

        cfg.getPoClassFile().addSimpleProperty(Asset.class,"asset","asset","asset");
        cfg.getPoClassFile().addSimpleProperty(InspectionRoute.class,"route","route","route");
        cfg.getPoClassFile().addSimpleProperty(InspectionPointPos.class,"inspectionPointPos","inspectionPointPos","inspectionPointPos");

        cfg.getPoClassFile().addListProperty(CheckItem.class,"checkItemList","checkItemList","checkItemList");
        cfg.getPoClassFile().addListProperty(String.class,"idsList","idsList","idsList");
       // cfg.getPoClassFile().addSimpleProperty(String.class,"selectCode","selectCode","selectCode");

        cfg.getPoClassFile().addSimpleProperty(String.class,"selectedCode","selectedCode","selectedCode");
        cfg.getPoClassFile().addSimpleProperty(String.class,"itemCount","itemCount","itemCount");
        cfg.getPoClassFile().addSimpleProperty(String.class,"itemDisableCount","itemDisableCount","itemDisableCount");

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_INSPECTION_POINT.STATUS,
                        EAMTables.EAM_INSPECTION_POINT.POS_ID,
                        EAMTables.EAM_INSPECTION_POINT.CODE,
                        EAMTables.EAM_INSPECTION_POINT.NAME,
                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(InspectionPointMeta.ITEM_COUNT).basic().label("检查项数").table().alignLeft().disable(false);
        cfg.view().field(InspectionPointMeta.ITEM_DISABLE_COUNT).basic().label("检查项数(未启用)").table().alignLeft().disable(false);
        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.PICTURE_ID).table().disable(true);

        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.ROUTE_ID).table().disable(true);
//        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.SELECTED_CODE).table().disable(true);
        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.POS_LONGITUDE).table().disable(true);
        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.POS_LATITUDE).table().disable(true);
        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.NOTES).table().disable(true);
        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.POS).table().disable(true);
        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.STATUS).form().validate().required().form().selectBox().enumType(StatusEnableEnum.class).defaultIndex(0);
        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.NAME).form().validate().required();

        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.POS_LATITUDE).form().numberInput().defaultValue(0).decimal().scale(2);
        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.POS_LONGITUDE).form().numberInput().defaultValue(0).decimal().scale(2);



        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.CREATE_TIME).table().disable(true);

        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.NOTES).form().textArea().height(Config.textAreaHeight);
        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.CONTENT).form().textArea().height(Config.textAreaHeight);
        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.PICTURE_ID)
                .form().label("图片").upload().buttonLabel("选择图片").acceptImageType().acceptSingleImage();


        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.ASSET_ID)
                .form().selectBox().queryApi(AssetServiceProxy.QUERY_PAGED_LIST+"?ownerCode=asset")
                .paging(true).filter(true).toolbar(false)
                .valueField(AssetMeta.ID).
                textField(AssetMeta.ASSET_CODE).
                fillWith(InspectionPointMeta.ASSET).muliti(false);

        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.ROUTE_ID)
                .form().validate().required().form().selectBox().queryApi(InspectionRouteServiceProxy.QUERY_LIST)
                .paging(false).filter(true).toolbar(false)
                .valueField(InspectionRouteMeta.ID).
                textField(InspectionRouteMeta.NAME).
                fillWith(InspectionPointMeta.ROUTE).muliti(false).defaultIndex(0);

        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.POS_ID)
                .form().selectBox().queryApi(InspectionPointPosServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(InspectionPointPosMeta.ID).
                textField(InspectionPointPosMeta.HIERARCHY_NAME).
                fillWith(InspectionPointMeta.INSPECTION_POINT_POS).muliti(false);


         cfg.view().formWindow().width(Config.baseFormWidth);

        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_INSPECTION_POINT.NAME,
                        EAMTables.EAM_INSPECTION_POINT.CODE,
                        EAMTables.EAM_INSPECTION_POINT.STATUS,

                },
                new Object[] {
                        EAMTables.EAM_INSPECTION_POINT.RFID,
                        EAMTables.EAM_INSPECTION_POINT.POS_LONGITUDE,
                        EAMTables.EAM_INSPECTION_POINT.POS_LATITUDE,
                },
                new Object[] {
                        EAMTables.EAM_INSPECTION_POINT.ROUTE_ID,
                        EAMTables.EAM_INSPECTION_POINT.POS_ID,
                        EAMTables.EAM_INSPECTION_POINT.POS,

                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_INSPECTION_POINT.ASSET_ID,
                        EAMTables.EAM_INSPECTION_POINT.CONTENT,
                        EAMTables.EAM_INSPECTION_POINT.NOTES,
                        EAMTables.EAM_INSPECTION_POINT.PICTURE_ID,
                }
        );

        cfg.view().search().rowsDisplay(1);
        cfg.view().form().addPage("巡检项","checkSelectList");

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
        InspPointGtr g=new InspPointGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
       //g.generateMenu(InspectionPointServiceProxy.class, InspectionPointPageController.class);
        //生成菜单

    }

}
