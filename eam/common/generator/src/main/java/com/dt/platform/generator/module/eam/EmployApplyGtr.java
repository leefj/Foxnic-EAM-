package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.eam.page.AssetEmployeeApplyPageController;
import com.dt.platform.eam.service.IAssetEmployeeApplyService;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetEmployeeApplyServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;

public class EmployApplyGtr extends BaseCodeGenerator {


    public EmployApplyGtr() {
        super(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");

        cfg.getPoClassFile().addSimpleProperty(Organization.class,"organization","使用公司/部门","使用公司/部门");
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.ID).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.NAME).search().fuzzySearch();


        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.NAME).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_EMPLOYEE_APPLY.STATUS,
                        EAMTables.EAM_ASSET_EMPLOYEE_APPLY.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_EMPLOYEE_APPLY.NAME,
                }
        );

        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width("85%");
        cfg.view().formWindow().bottomSpace(30);


        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.NOTES).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.SELECTED_CODE).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.RECORD_TIME).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.APPLY_COUNT).table().disable(true);


        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.NOTES).form().textArea().height(50);
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.CONTENT).form().validate().required().form().textArea().height(50);


        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.ORG_ID)
                .form().validate().required().form().button().chooseOrganization(true);
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.ORG_ID).table().fillBy("organization","fullName");


        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.ORIGINATOR_ID).table().fillBy("originator","name");
        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.ORIGINATOR_ID).form()
                .button().chooseEmployee(true);

        cfg.view().field(EAMTables.EAM_ASSET_EMPLOYEE_APPLY.STATUS).basic().label("办理状态")
                .form().selectBox().enumType(AssetHandleStatusEnum.class);


        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_EMPLOYEE_APPLY.NAME,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_EMPLOYEE_APPLY.ORG_ID,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_EMPLOYEE_APPLY.CONTENT,
                }
        );



        cfg.view().form().addPage("物品列表","goodsSelectList");
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
        EmployApplyGtr g=new EmployApplyGtr();
        //生成代码
       g.generateCode();

     //   g.removeByBatchId("582429214846746624");
        //移除之前生成的菜单，视情况执行
      // g.generateMenu(AssetEmployeeApplyServiceProxy.class, AssetEmployeeApplyPageController.class);

        //生成菜单

    }

}
