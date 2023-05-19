package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.ReportPageController;
import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.LicenceStatusEnum;
import com.dt.platform.constants.enums.common.LicenceTypeEnum;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.common.ReportCategory;
import com.dt.platform.domain.common.meta.ReportCategoryMeta;
import com.dt.platform.domain.common.meta.ReportMeta;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.eam.meta.AssetRackMeta;
import com.dt.platform.domain.eam.meta.AssetStatusMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.ReportCategoryServiceProxy;
import com.dt.platform.proxy.common.ReportServiceProxy;
import com.dt.platform.proxy.eam.AssetRackServiceProxy;
import com.dt.platform.proxy.eam.AssetStatusServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class SysReportGtr extends BaseCodeGenerator{
    public SysReportGtr() {
        super(SysTables.SYS_REPORT.$TABLE,"711645138962612224");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(ReportCategory.class,"reportCategory","reportCategory","reportCategory");


        cfg.view().field(SysTables.SYS_REPORT.ID).basic().hidden(true);
        cfg.view().field(SysTables.SYS_REPORT.NOTES).search().fuzzySearch();
        cfg.view().field(SysTables.SYS_REPORT.NAME).search().fuzzySearch();
        cfg.view().field(SysTables.SYS_REPORT.CODE).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_REPORT.STATUS,
                        SysTables.SYS_REPORT.NAME,
                        SysTables.SYS_REPORT.CODE,
                        SysTables.SYS_REPORT.NOTES,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(SysTables.SYS_REPORT.CATALOG_ID)
                .form().selectBox().queryApi(ReportCategoryServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(ReportCategoryMeta.ID).
                textField(ReportCategoryMeta.HIERARCHY_NAME).
                fillWith(ReportMeta.REPORT_CATEGORY).muliti(false);


        cfg.view().field(SysTables.SYS_REPORT.STATUS).form().validate().required().form().radioBox().enumType( StatusEnableEnum.class);
        cfg.view().field(SysTables.SYS_REPORT.NAME).form().validate().required();
        cfg.view().field(SysTables.SYS_REPORT.CODE).form().readOnly();
        cfg.view().list().disableBatchDelete();

        cfg.view().list().operationColumn().addActionButton("设计","reportDesinger","report-designer-button","sys_report:designer");
        cfg.view().list().operationColumn().addActionButton("预览","reportView","report-view-button","sys_report:view");



        //分成分组布局
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(200);
        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_REPORT.CODE,
                        SysTables.SYS_REPORT.NAME,
                        SysTables.SYS_REPORT.CATALOG_ID,
                        SysTables.SYS_REPORT.STATUS,
                        SysTables.SYS_REPORT.ROUTE,
                        SysTables.SYS_REPORT.NOTES,
                }
        );


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        SysReportGtr g=new SysReportGtr();
        //生成代码
        g.generateCode();


        //生成菜单
        //g.removeByBatchId("");
       // g.generateMenu(ReportServiceProxy.class, ReportPageController.class);
    }


}
