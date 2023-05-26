package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.FormDefPageController;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.FormDefStatusEnum;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.common.FormCategory;
import com.dt.platform.domain.common.meta.FormCategoryMeta;
import com.dt.platform.domain.common.meta.FormInfoMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.FormCategoryServiceProxy;
import com.dt.platform.proxy.common.FormDefServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;

public class SysFormDefGtr extends BaseCodeGenerator{
    public SysFormDefGtr() {
        super(SysTables.SYS_FORM_DEF.$TABLE,"484683104078794753");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());



        cfg.view().field(SysTables.SYS_FORM_DEF.ID).basic().hidden(true);


        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_FORM_DEF.STATUS,

                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().list().operationColumn().addActionButton("设计","formDesinger","form-designer-button","sys_form_def:designer");
      //  cfg.view().list().operationColumn().addActionButton("预览","formView","form-view-button","sys_form_def:view");
        cfg.view().list().operationColumn().addActionButton("应用","formApply","form-apply","sys_form_def:apply");
        cfg.view().list().operationColumn().addActionButton("复制","formCopy","form-copy","sys_form_def:copy");

        cfg.view().field(SysTables.SYS_FORM_DEF.CREATE_TIME).form().dateInput().type(DatePickerType.datetime);

        cfg.view().field(SysTables.SYS_FORM_DEF.STATUS).form().radioBox().enumType(FormDefStatusEnum.class).defaultIndex(0);
        cfg.view().field(SysTables.SYS_FORM_DEF.DESIGNER_DATA).form().readOnly().form().textArea().height(350);
        cfg.view().list().disableBatchDelete();
        cfg.view().list().addJsVariable("FORM_ID","[[${formId}]]","formId");
        cfg.view().form().addJsVariable("FORM_ID","[[${formId}]]","formId");

        //分成分组布局
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(200);
        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_FORM_DEF.NOTES,
                        SysTables.SYS_FORM_DEF.DESIGNER_DATA
                }
        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        SysFormDefGtr g=new SysFormDefGtr();
        //生成代码
        g.generateCode();

        //生成菜单
        //g.removeByBatchId("");
       // g.generateMenu(FormDefServiceProxy.class, FormDefPageController.class);
    }


}
