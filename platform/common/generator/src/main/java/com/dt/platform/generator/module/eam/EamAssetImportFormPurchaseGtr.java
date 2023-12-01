package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetImportStatusEnum;
import com.dt.platform.constants.enums.eam.AssetImportSourceTypeEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.domain.eam.PurchaseApply;
import com.dt.platform.domain.eam.meta.PositionMeta;
import com.dt.platform.domain.eam.meta.PurchaseImportMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.PositionServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;

public class EamAssetImportFormPurchaseGtr extends BaseCodeGenerator {

    public EamAssetImportFormPurchaseGtr() {
        super(EAMTables.EAM_PURCHASE_IMPORT.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.view().field(EAMTables.EAM_PURCHASE_IMPORT.ID).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_PURCHASE_IMPORT.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_PURCHASE_IMPORT.NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_PURCHASE_IMPORT.ORDER_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_PURCHASE_IMPORT.ORDER_NAME).search().fuzzySearch();

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"operUser","操作人员","操作人员");

        cfg.getPoClassFile().addSimpleProperty(PurchaseApply.class,"purchaseApply","purchaseApply","purchaseApply");
        cfg.getPoClassFile().addListProperty(Asset.class,"assetList","assetList","assetList");

        cfg.getPoClassFile().addSimpleProperty(String.class,"selectedCode","selectedCode","selectedCode");

        cfg.getPoClassFile().addSimpleProperty(Organization.class,"ownerCompany","所属公司","所属公司");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"useOrganization","使用公司/部门","使用公司/部门");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"useUser","使用人员","使用人员");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"manager","管理人员","管理人员");
        cfg.getPoClassFile().addSimpleProperty(Position.class,"position","存放位置","存放位置");
        cfg.getPoClassFile().addSimpleProperty(String.class,"fill","填充数据","填充数据");

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_PURCHASE_IMPORT.ORDER_CODE,
                        EAMTables.EAM_PURCHASE_IMPORT.ORDER_NAME,
                        EAMTables.EAM_PURCHASE_IMPORT.NAME,
                        EAMTables.EAM_PURCHASE_IMPORT.NOTES,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(EAMTables.EAM_PURCHASE_IMPORT.ORDER_ID).table().disable(true);

        cfg.view().field(EAMTables.EAM_PURCHASE_IMPORT.NOTES).table().disable(true);
        cfg.view().field(EAMTables.EAM_PURCHASE_IMPORT.STATUS).form().radioBox().enumType(AssetImportStatusEnum.class);
        cfg.view().field(EAMTables.EAM_PURCHASE_IMPORT.IMPORT_TO_TYPE).form().radioBox().enumType(AssetImportSourceTypeEnum.class);
        cfg.view().field(EAMTables.EAM_PURCHASE_IMPORT.NAME).form().validate().required();

        cfg.view().field(EAMTables.EAM_PURCHASE_IMPORT.ORDER_ID).form().validate().required().form().button().action("选择","selectOrder");
        cfg.view().field(EAMTables.EAM_PURCHASE_IMPORT.IMPORT_TO_TYPE).table().disable(true);
        cfg.view().field(EAMTables.EAM_PURCHASE_IMPORT.UPDATE_BY).table().disable(true);
        cfg.view().field(EAMTables.EAM_PURCHASE_IMPORT.UPDATE_TIME).table().disable(true);
        cfg.view().field(EAMTables.EAM_PURCHASE_IMPORT.CREATE_BY).table().disable(true);
        cfg.view().field(EAMTables.EAM_PURCHASE_IMPORT.CREATE_TIME).table().disable(true);
        cfg.view().field(EAMTables.EAM_PURCHASE_IMPORT.NOTES).table().disable(true);
        cfg.view().field(PurchaseImportMeta.FILL).table().disable(true);
        cfg.view().field(PurchaseImportMeta.FILL).basic().label("填充数据").form().button().action("填充数据","fillData");
        cfg.view().field(EAMTables.EAM_PURCHASE_IMPORT.PURCHASE_DATE).form().dateInput().format("yyyy-MM-dd").search().range();

        cfg.view().field(EAMTables.EAM_PURCHASE_IMPORT.POSITION_ID)
                .basic().label("位置")
                .form().selectBox().queryApi(PositionServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(PositionMeta.ID).textField(PositionMeta.HIERARCHY_NAME).fillWith(PurchaseImportMeta.POSITION).muliti(false);

        cfg.view().field(EAMTables.EAM_PURCHASE_IMPORT.OWN_COMPANY_ID)
                .form().button().chooseCompany(true);
        cfg.view().field(EAMTables.EAM_PURCHASE_IMPORT.OWN_COMPANY_ID).table().fillBy("ownerCompany","fullName");

        cfg.view().field(EAMTables.EAM_PURCHASE_IMPORT.USE_ORG_ID)
                .form().button().chooseOrganization(true);
        cfg.view().field(EAMTables.EAM_PURCHASE_IMPORT.USE_ORG_ID).table().fillBy("useOrganization","fullName");

        cfg.view().field(EAMTables.EAM_PURCHASE_IMPORT.USE_USER_ID).table().fillBy("useUser","name");
        cfg.view().field(EAMTables.EAM_PURCHASE_IMPORT.USE_USER_ID).form()
                .button().chooseEmployee(true);

        cfg.view().field(EAMTables.EAM_PURCHASE_IMPORT.MANAGER_ID).table().fillBy("manager","name");
        cfg.view().field(EAMTables.EAM_PURCHASE_IMPORT.MANAGER_ID).form()
                .button().chooseEmployee(true);


        cfg.view().form().addJsVariable("IMPORT_TYPE","[[${importType}]]","importType");
        cfg.view().list().addJsVariable("IMPORT_TYPE","[[${importType}]]","importType");


        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().list().disableBatchDelete();
        cfg.view().field(EAMTables.EAM_PURCHASE_IMPORT.OPER_USER_ID).table().fillBy("operUser","name");
        cfg.view().field(EAMTables.EAM_PURCHASE_IMPORT.OPER_USER_ID).form()
                .button().chooseEmployee(true);

        cfg.view().list().operationColumn().addActionButton("取消","cancelAction","cancel-action-button");
        cfg.view().list().operationColumn().addActionButton("确认","sureAction","sure-action-button");


        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_PURCHASE_IMPORT.NAME,
                },
                new Object[] {
                        EAMTables.EAM_PURCHASE_IMPORT.ORDER_ID,
                }
        );
        cfg.view().form().addGroup("数据覆盖",
                new Object[] {
                        EAMTables.EAM_PURCHASE_IMPORT.OWN_COMPANY_ID,
                        EAMTables.EAM_PURCHASE_IMPORT.MANAGER_ID,
                        EAMTables.EAM_PURCHASE_IMPORT.POSITION_ID,
                        EAMTables.EAM_PURCHASE_IMPORT.ASSET_NOTES,
                },
                new Object[] {
                        EAMTables.EAM_PURCHASE_IMPORT.USE_ORG_ID,
                        EAMTables.EAM_PURCHASE_IMPORT.USE_USER_ID,
                        EAMTables.EAM_PURCHASE_IMPORT.PURCHASE_DATE,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        PurchaseImportMeta.FILL
                },
                new Object[] {
                }
        );

        cfg.view().form().addPage("assetListEl","资产信息","assetList");
        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.IGNORE);
        ; //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        EamAssetImportFormPurchaseGtr g=new EamAssetImportFormPurchaseGtr();

        //生成代码
        g.generateCode();
        //生成菜单
        //g.generateMenu(PurchaseImportServiceProxy.class, PurchaseImportPageController.class);
    }

}
