package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.CheckGroupItem;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;

public class CheckDemoGtr extends BaseCodeGenerator {


    public CheckDemoGtr() {
        super(EAMTables.EAM_DEMO_C2.$TABLE,"728712045951713281");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_DEMO_C2.VALID,
                }
        );
        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(80);

        cfg.view().field(EAMTables.EAM_DEMO_C2.PRICE).form().numberInput().scale(2).decimal().defaultValue(0.00).range(1.00,100.00);

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
        CheckDemoGtr g=new CheckDemoGtr();
        //生成代码
       g.generateCode();

     //   g.removeByBatchId("582429214846746624");
        //移除之前生成的菜单，视情况执行
     //  g.generateMenu(CheckGroupServiceProxy.class, CheckGroupPageController.class);
        //生成菜单

    }

}
