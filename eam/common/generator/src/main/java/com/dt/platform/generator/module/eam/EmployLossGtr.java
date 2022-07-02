package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.eam.page.AssetEmployeeLossPageController;
import com.dt.platform.eam.page.AssetEmployeeRepairPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetEmployeeLossServiceProxy;
import com.dt.platform.proxy.eam.AssetEmployeeRepairServiceProxy;
import com.github.foxnic.api.bpm.IntegrateMode;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;

public class EmployLossGtr extends BaseCodeGenerator {


    public EmployLossGtr() {
        super(EAMTables.EAM_ASSET_EMPLOYEE_LOSS.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");

        cfg.getPoClassFile().addListProperty(Asset.class,"assetList","资产","资产");
        cfg.getPoClassFile().addListProperty(String.class,"assetIds","资产列表","资产列表");

        cfg.getPoClassFile().addSimpleProperty(Organization.class,"organization","使用公司/部门","使用公司/部门");
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_LOSS.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_LOSS.NAME).search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_LOSS.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_LOSS.NAME).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_EMPLOYEE_LOSS.STATUS,
                        EAMTables.EAM_ASSET_EMPLOYEE_LOSS.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_EMPLOYEE_LOSS.NAME,
                }
        );

        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_LOSS.ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_LOSS.NOTES).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_LOSS.SELECTED_CODE).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_LOSS.RECORD_TIME).table().disable(true);

        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_LOSS.NOTES).form().textArea().height(50);
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_LOSS.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_LOSS.CONTENT).form().validate().required().form().textArea().height(50);


        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_LOSS.ORG_ID)
                .form().validate().required().form().button().chooseOrganization(true);
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_LOSS.ORG_ID).table().fillBy("organization","fullName");


        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_LOSS.ORIGINATOR_ID).table().fillBy("originator","name");
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_LOSS.ORIGINATOR_ID).form()
                .button().chooseEmployee(true);


        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_LOSS.ORIGINATOR_ID).form()
                .button().chooseEmployee(true);

        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_LOSS.STATUS).basic().label("办理状态")
                .form().selectBox().enumType(AssetHandleStatusEnum.class);

        cfg.bpm().form("eam_asset_employee_loss");
        cfg.bpm().integrate(IntegrateMode.FRONT);
        cfg.view().form().labelWidth(70);
        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width("85%");
        cfg.view().formWindow().bottomSpace(30);

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_EMPLOYEE_LOSS.NAME,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_EMPLOYEE_LOSS.ORG_ID,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_EMPLOYEE_LOSS.CONTENT,
                }
        );


        cfg.view().form().addJsVariable("EMPLOYEE_ID",   "[[${user.getUser().getActivatedEmployeeId()}]]","用户ID");


        cfg.view().form().addPage("资产列表","goodsSelectList");

        cfg.view().search().inputWidth(Config.searchInputWidth);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setBpmEventAdaptor(WriteMode.IGNORE)
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EmployLossGtr g=new EmployLossGtr();
        //生成代码
       g.generateCode();

     //   g.removeByBatchId("582429214846746624");
        //移除之前生成的菜单，视情况执行
      // g.generateMenu(AssetEmployeeLossServiceProxy.class, AssetEmployeeLossPageController.class);

        //生成菜单

    }

}
