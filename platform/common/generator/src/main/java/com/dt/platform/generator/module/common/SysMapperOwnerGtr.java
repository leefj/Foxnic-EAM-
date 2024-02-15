package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.TestPageController;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.TestServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class SysMapperOwnerGtr extends BaseCodeGenerator{
    public SysMapperOwnerGtr() {
        super(SysTables.SYS_MAPPING_OWNER.$TABLE,"463397133957988354");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(SysTables.SYS_MAPPING_OWNER.ID).basic().hidden(true);


        cfg.view().search().inputLayout(
                new Object[]{

                        SysTables.SYS_MAPPING_OWNER.OWNER_ID,

                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);



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
        SysMapperOwnerGtr g=new SysMapperOwnerGtr();
        //生成代码
        g.generateCode();


        //生成菜单
        //g.removeByBatchId("");
       // g.generateMenu(TestServiceProxy.class, TestPageController.class);
    }


}
