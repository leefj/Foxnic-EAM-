package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.eam.page.CheckGroupItemPageController;
import com.dt.platform.eam.page.CheckGroupPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.CheckGroupItemServiceProxy;
import com.dt.platform.proxy.eam.CheckGroupServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class CheckGroupItemGtr extends BaseCodeGenerator {


    public CheckGroupItemGtr() {
        super(EAMTables.EAM_CHECK_GROUP_ITEM.$TABLE,"728712045951713281");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_CHECK_GROUP_ITEM.GROUP_ID,
                }
        );

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
        CheckGroupItemGtr g=new CheckGroupItemGtr();
        //生成代码
       g.generateCode();

     //   g.removeByBatchId("582429214846746624");
        //移除之前生成的菜单，视情况执行
      // g.generateMenu(CheckGroupItemServiceProxy.class, CheckGroupItemPageController.class);
        //生成菜单

    }

}
