package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.UserImportPageController;
import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.CodeAttrTypeEnum;
import com.dt.platform.constants.enums.common.StatusYNEnum;
import com.dt.platform.constants.enums.common.UserImportActionStatusEnum;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.UserImportServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class SysUserImportGtr extends BaseCodeGenerator {

    public SysUserImportGtr() {
        super(SysTables.SYS_USER_IMPORT.$TABLE,"463397133957988354");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(SysTables.SYS_USER_IMPORT.ID).basic().hidden(true);
        cfg.view().field(SysTables.SYS_USER_IMPORT.ACTION_CODE).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_USER_IMPORT.ACTION_STATUS,
                        SysTables.SYS_USER_IMPORT.ACTION_CODE,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().list().disableCreateNew();

        cfg.view().field(SysTables.SYS_USER_IMPORT.ACTION_STATUS).basic()
                .form().validate().required().form().radioBox().enumType(UserImportActionStatusEnum.class);


        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width(Config.baseFormWidth);;


        cfg.view().list().addToolButton("导入","importData","import-data","sys_user_import:import-data");
   ///     cfg.view().list().operationColumn().addActionButton("重导","importRowData","row-import-data","sys_user_import:row_import");


        //文件生成覆盖模式
        cfg.overrides()
               .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        SysUserImportGtr g=new SysUserImportGtr();

        //生成代码
        g.generateCode();

        //生成菜单
       //  g.generateMenu(UserImportServiceProxy.class, UserImportPageController.class);

    }

}
