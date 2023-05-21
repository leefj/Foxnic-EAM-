package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.FormCategoryPageController;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.proxy.common.FormCategoryServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class SysFormCategoryGtr extends BaseCodeGenerator{
    public SysFormCategoryGtr() {
        super(SysTables.SYS_FORM_CATEGORY.$TABLE,"484683104078794753");
    }

    public void generateCode() throws Exception {


        cfg.view().field(SysTables.SYS_FORM_CATEGORY.CODE).form().validate().required();
        cfg.view().field(SysTables.SYS_FORM_CATEGORY.NAME).form().validate().required();


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控
                .setFormPage(WriteMode.IGNORE) //表单HTML页
                .setListPage(WriteMode.IGNORE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        SysFormCategoryGtr g=new SysFormCategoryGtr();
        //生成代码
        g.generateCode();


        //生成菜单
        //g.removeByBatchId("");
      //  g.generateMenu(FormCategoryServiceProxy.class, FormCategoryPageController.class);
    }


}
