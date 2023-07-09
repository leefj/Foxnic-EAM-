package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.CheckItemOwnerEnum;
import com.dt.platform.constants.enums.eam.CheckItemTypeEnum;
import com.dt.platform.domain.eam.CheckGroupItem;
import com.dt.platform.eam.page.CheckGroupPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.CheckGroupServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class CheckGroupGtr extends BaseCodeGenerator {


    public CheckGroupGtr() {
        super(EAMTables.EAM_CHECK_GROUP.$TABLE,"728712045951713281");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(EAMTables.EAM_CHECK_GROUP.ID).basic().hidden(true);


        cfg.getPoClassFile().addListProperty(CheckGroupItem.class,"itemList","itemList","itemList");
        cfg.getPoClassFile().addListProperty(String.class,"idsList","idsList","idsList");

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_CHECK_GROUP.NAME,
                }
        );
        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(80);

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
        CheckGroupGtr g=new CheckGroupGtr();
        //生成代码
       g.generateCode();

     //   g.removeByBatchId("582429214846746624");
        //移除之前生成的菜单，视情况执行
     //  g.generateMenu(CheckGroupServiceProxy.class, CheckGroupPageController.class);
        //生成菜单

    }

}
