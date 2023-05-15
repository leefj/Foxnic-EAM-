package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.CCustRepairStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.CCustRepiarItem;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.eam.meta.CCustRepairApplyMeta;
import com.dt.platform.eam.page.CCustRepairTypePageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetServiceProxy;
import com.dt.platform.proxy.eam.CCustRepairTypeServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class CRepiarTypeGtr extends BaseCodeGenerator{
    public CRepiarTypeGtr() {
        super(EAMTables.EAM_C_CUST_REPAIR_TYPE.$TABLE,"694492212972486656");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());




        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_C_CUST_REPAIR_TYPE.NAME,
                }

        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_TYPE.NAME).search().fuzzySearch();
        cfg.view().formWindow().width("60%");;
        cfg.view().formWindow().bottomSpace(120);
        cfg.view().field(EAMTables.EAM_C_CUST_REPAIR_TYPE.NAME).form().validate().required();


        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_C_CUST_REPAIR_TYPE.NAME,
                        EAMTables.EAM_C_CUST_REPAIR_TYPE.NOTES,
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
        CRepiarTypeGtr g=new CRepiarTypeGtr();
        //生成代码
         g.generateCode();
        //生成菜单
        g.generateMenu(CCustRepairTypeServiceProxy.class, CCustRepairTypePageController.class);
    }
}
