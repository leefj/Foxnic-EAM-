package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.FormDataExtPageController;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.FormDataExtServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;

public class SysFormDataExtGtr extends BaseCodeGenerator{
    public SysFormDataExtGtr() {
        super(SysTables.SYS_FORM_DATA_EXT.$TABLE,"484683104078794753");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(SysTables.SYS_FORM_DATA.ID).basic().hidden(true);

        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_FORM_DATA_EXT.DATA_ID,
                }
        );
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        //分成分组布局
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(200);

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
        SysFormDataExtGtr g=new SysFormDataExtGtr();
        //生成代码
        g.generateCode();
        //生成菜单
        //g.removeByBatchId("");
      // g.generateMenu(FormDataExtServiceProxy.class, FormDataExtPageController.class);
    }


}
