package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.constants.enums.common.ValidStatusEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetHandle;
import com.dt.platform.domain.eam.AssetHandleType;
import com.dt.platform.domain.eam.meta.*;

import com.dt.platform.eam.service.impl.AssetItemServiceImpl;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetHandleServiceProxy;
import com.dt.platform.proxy.eam.AssetHandleTypeServiceProxy;
import com.github.foxnic.api.bpm.IntegrateMode;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class EamAssetHandleGtr extends BaseCodeGenerator{
    public EamAssetHandleGtr() {
        super(EAMTables.EAM_ASSET_HANDLE.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());
        cfg.getPoClassFile().addListProperty(Asset.class,"assetList","资产","资产");
        cfg.getPoClassFile().addListProperty(String.class,"assetIds","资产列表","资产列表");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(AssetHandleType.class,"assetHandleType","assetHandleType","assetHandleType");





        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.NOTES).search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.CONTENT).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.PLAN_FINISH_DATE).search().range();
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_HANDLE.STATUS,
                        EAMTables.EAM_ASSET_HANDLE.TYPE,
                        EAMTables.EAM_ASSET_HANDLE.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_HANDLE.NAME,
                },
                new Object[]{
                        EAMTables.EAM_ASSET_HANDLE.PLAN_FINISH_DATE,

                }
        );

        cfg.view().search().rowsDisplay(1);
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.ORIGINATOR_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.ORIGINATOR_ID).table().label("申请人").form().label("申请人")
                .form().fillBy("originator","name");


        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.SELECTED_CODE).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.FILE_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.NOTES).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.CONTENT).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.CHS_TYPE).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.CHS_VERSION).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.CHANGE_INSTANCE_ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.SUMMARY).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.LATEST_APPROVER_ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.LATEST_APPROVER_NAME).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.NEXT_APPROVER_IDS).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.NEXT_APPROVER_NAMES).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.APPROVAL_OPINION).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.UPDATE_BY).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.PROC_ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.CHS_STATUS).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE_TYPE.STATUS).form().radioBox().enumType(AssetHandleStatusEnum.class).defaultIndex(0);


        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.TYPE)
                .form().validate().required().form().selectBox().queryApi(AssetHandleTypeServiceProxy.QUERY_LIST)
                .paging(false).filter(false).toolbar(false)
                .valueField(AssetHandleTypeMeta.CODE).
                textField(AssetHandleTypeMeta.LABEL).
                fillWith(AssetHandleMeta.ASSET_HANDLE_TYPE).muliti(false).defaultIndex(0);

        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.CONTENT).form().textArea().height(150);
        cfg.bpm().form("eam_asset_handle");
        cfg.bpm().integrate(IntegrateMode.FRONT);

        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.FILE_ID).form().upload().maxFileCount(6);

        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.PLAN_FINISH_DATE).form().validate().required().form().dateInput().type(DatePickerType.date).defaultNow().format("yyyy-MM-dd").search().range();


        cfg.view().list().disableBatchDelete();
        cfg.view().form().labelWidth(70);
        cfg.view().list().operationColumn().width(350);
        //分成分组布局
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_HANDLE.TYPE,
                        EAMTables.EAM_ASSET_HANDLE.PLAN_FINISH_DATE,
                }, new Object[] {
                        EAMTables.EAM_ASSET_HANDLE.ORIGINATOR_ID,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_HANDLE.CONTENT,
                        EAMTables.EAM_ASSET_HANDLE.FILE_ID,
                }
        );

        cfg.view().list().disableBatchDelete();
        cfg.view().form().addPage("资产列表","assetSelectList");
        cfg.view().form().addJsVariable("BILL_ID","[[${billId}]]","单据ID");
        cfg.view().form().addJsVariable("INSTANCE_DATA","[[${instanceData}]]","instanceData");
        cfg.view().list().addJs("/extmodule/commonFunction/commonFunction.js");
        cfg.view().form().addJsVariable("EMPLOYEE_ID",   "[[${user.getUser().getActivatedEmployeeId()}]]","用户ID");
        cfg.view().form().addJsVariable("EMPLOYEE_NAME", "[[${user.getUser().getActivatedEmployeeName()}]]","用户姓名");

        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setBpmEventAdaptor(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EamAssetHandleGtr g=new EamAssetHandleGtr();
        //生成代码
         g.generateCode();


        //生成菜单
        //g.removeByBatchId("");
       //  g.generateMenu(AssetHandleServiceProxy.class, AssetHandlePageController.class);
    }
}
