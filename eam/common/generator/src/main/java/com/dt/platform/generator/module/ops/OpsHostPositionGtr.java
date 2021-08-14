package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.constants.enums.ops.HostMonitorStatusEnum;
import com.dt.platform.constants.enums.ops.HostStatusEnum;

import com.github.foxnic.generator.config.WriteMode;

public class OpsHostPositionGtr extends BaseCodeGenerator{


    public OpsHostPositionGtr() {
        super(EAMTables.OPS_HOST_POSITION.$TABLE,BASIC_HOSTMGR_MENU_ID);
    }

    public void generateCode() throws Exception {



        cfg.view().field(EAMTables.OPS_HOST_POSITION.ID).basic().hidden(true);


        cfg.view().field(EAMTables.OPS_HOST_POSITION.NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.OPS_HOST_POSITION.NAME).search().fuzzySearch();

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        OpsHostPositionGtr g=new OpsHostPositionGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("474331804975759360");
        //g.generateMenu(HostPositionServiceProxy.class, HostPositionPageController.class);
    }
}
