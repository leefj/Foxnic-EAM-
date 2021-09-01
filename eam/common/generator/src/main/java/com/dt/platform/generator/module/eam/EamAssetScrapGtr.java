package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetScrap;
import com.dt.platform.domain.eam.meta.AssetRepairVOMeta;
import com.dt.platform.domain.eam.meta.AssetScrapVOMeta;
import com.dt.platform.eam.page.AssetScrapPageController;
import com.dt.platform.eam.service.impl.AssetItemServiceImpl;
import com.dt.platform.proxy.eam.AssetScrapServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Person;

public class EamAssetScrapGtr extends BaseCodeGenerator {

    public EamAssetScrapGtr() {
        super(EAMTables.EAM_ASSET_SCRAP.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addListProperty(Asset.class,"assetList","资产","资产");
        cfg.getPoClassFile().addListProperty(String.class,"assetIds","资产列表","资产列表");

        cfg.service().addRelationSaveAction(AssetItemServiceImpl.class, AssetScrapVOMeta.ASSET_IDS);
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");


        cfg.view().field(EAMTables.EAM_MAINTAINER.ID).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.CONTENT).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.NAME).search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.SCRAP_DATE).search().range();


        cfg.view().field(EAMTables.EAM_ASSET_REPAIR.STATUS).form().selectBox().enumType(AssetHandleStatusEnum.class);
        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.CONTENT).form().textArea().height(30);


        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.SCRAP_DATE).form().validate().required();

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_SCRAP.STATUS,
                        EAMTables.EAM_ASSET_SCRAP.NAME,
                        EAMTables.EAM_ASSET_SCRAP.SCRAP_DATE
                },
                new Object[]{
                        EAMTables.EAM_ASSET_SCRAP.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_SCRAP.CONTENT
                }
        );


        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.CLEAN_STATUS).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_SCRAP.NAME).table().disable();


        cfg.view().list().operationColumn().addActionButton("单据","downloadBill",null);
        cfg.view().list().operationColumn().width(250);

        //分成分组布局
        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width("85%");
        cfg.view().form().addGroup(null,
                new Object[]
                        {
                                EAMTables.EAM_ASSET_SCRAP.NAME
                        },
              new Object[]
                      {
                        EAMTables.EAM_ASSET_SCRAP.SCRAP_DATE
                }, new Object[] {
                        EAMTables.EAM_ASSET_SCRAP.ORIGINATOR_ID
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_SCRAP.CONTENT,
                }
        );




        cfg.view().form().addJsVariable("EMPLOYEE_ID",   "[[${user.getUser().getActivatedEmployeeId()}]]","用户ID");
        cfg.view().form().addJsVariable("EMPLOYEE_NAME", "[[${user.getUser().getActivatedEmployeeName()}]]","用户姓名");


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.CREATE_IF_NOT_EXISTS); //列表HTML页; //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        EamAssetScrapGtr g=new EamAssetScrapGtr();

        //生成代码
        g.generateCode();
        //生成菜单
       // g.generateMenu(AssetScrapServiceProxy.class, AssetScrapPageController.class);
    }

}
