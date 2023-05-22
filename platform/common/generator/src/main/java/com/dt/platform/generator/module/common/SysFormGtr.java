package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.FormInfoPageController;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.ReportSourceEnum;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.common.FormCategory;
import com.dt.platform.domain.common.ReportCategory;
import com.dt.platform.domain.common.ReportUDef;
import com.dt.platform.domain.common.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.FormCategoryServiceProxy;
import com.dt.platform.proxy.common.FormInfoServiceProxy;
import com.dt.platform.proxy.common.ReportCategoryServiceProxy;
import com.dt.platform.proxy.common.ReportUDefServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class SysFormGtr extends BaseCodeGenerator{
    public SysFormGtr() {
        super(SysTables.SYS_FORM_INFO.$TABLE,"484683104078794753");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(FormCategory.class,"formCategory","formCategory","reportCategory");

        cfg.view().field(SysTables.SYS_FORM_INFO.ID).basic().hidden(true);
        cfg.view().field(SysTables.SYS_FORM_INFO.NOTES).search().fuzzySearch();
        cfg.view().field(SysTables.SYS_FORM_INFO.NAME).search().fuzzySearch();
        cfg.view().field(SysTables.SYS_FORM_INFO.CODE).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_FORM_INFO.STATUS,
                        SysTables.SYS_FORM_INFO.NAME,
                        SysTables.SYS_FORM_INFO.CODE,
                        SysTables.SYS_FORM_INFO.NOTES,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

//
//        cfg.view().field(SysTables.SYS_FORM_INFO.DESIGNER_DATA).table().disable(true);

        cfg.view().field(SysTables.SYS_FORM_INFO.ROUTE).form().readOnly();

        cfg.view().field(SysTables.SYS_FORM_INFO.CATALOG_ID)
                .form().selectBox().queryApi(FormCategoryServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(FormCategoryMeta.ID).
                textField(FormCategoryMeta.HIERARCHY_NAME).
                fillWith(FormInfoMeta.FORM_CATEGORY).muliti(false);


//        cfg.view().field(SysTables.SYS_REPORT.REPORT_TPL_ID)
//                .form().validate().required().form().selectBox().queryApi(ReportUDefServiceProxy.QUERY_PAGED_LIST+"?ownerType=tpl")
//                .paging(true).filter(true).toolbar(false)
//                .valueField(ReportUDefMeta.ID).
//                textField(ReportUDefMeta.FILE_NAME).
//                fillWith(ReportMeta.REPORT_TPL).muliti(false).defaultIndex(0);
//

        cfg.view().field(SysTables.SYS_FORM_INFO.STATUS).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);

        cfg.view().field(SysTables.SYS_FORM_INFO.NAME).form().validate().required();
        cfg.view().field(SysTables.SYS_FORM_INFO.CODE).form().readOnly();
//
//        cfg.view().field(SysTables.SYS_FORM_INFO.DESIGNER_DATA).form().textArea().height(300).form().readOnly();

        cfg.view().list().disableBatchDelete();

        cfg.view().list().operationColumn().addActionButton("条目","formDesinger","form-designer-button","sys_form:designer");
//        cfg.view().list().operationColumn().addActionButton("预览","formView","form-view-button","sys_form:view");
        cfg.view().list().operationColumn().addActionButton("复制","formCopy","form-copy","sys_form:copy");

        //分成分组布局
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(200);
        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_FORM_INFO.CODE,
                        SysTables.SYS_FORM_INFO.NAME,
                        SysTables.SYS_FORM_INFO.STATUS,
                },
                new Object[] {
                        SysTables.SYS_FORM_INFO.ROUTE,
                        SysTables.SYS_FORM_INFO.CATALOG_ID,
                }
        );

            cfg.view().form().addGroup(null,
                    new Object[] {
                            SysTables.SYS_FORM_INFO.NOTES,
//                            SysTables.SYS_FORM_INFO.DESIGNER_DATA,
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
        SysFormGtr g=new SysFormGtr();
        //生成代码
        g.generateCode();

        //生成菜单
        //g.removeByBatchId("");
       // g.generateMenu(FormInfoServiceProxy.class, FormInfoPageController.class);
    }


}
