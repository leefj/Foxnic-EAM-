package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.ReportUDefPageController;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.ReportUDefServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;

public class SysReportUDefGtr extends BaseCodeGenerator{
    public SysReportUDefGtr() {
        super(SysTables.SYS_REPORT_U_DEF.$TABLE,"711645138962612224");
    }

    public void generateCode() throws Exception {


        cfg.view().field(SysTables.SYS_REPORT_U_DEF.FILE_NAME).form().validate().required();
        cfg.view().field(SysTables.SYS_REPORT_U_DEF.CONTENT).form().textArea().height(300);

        cfg.view().field(SysTables.SYS_REPORT_U_DEF.ID).basic().hidden(true);
        cfg.view().field(SysTables.SYS_REPORT_U_DEF.CONTENT).table().disable(true);
        cfg.view().field(SysTables.SYS_REPORT_U_DEF.FILE_NAME).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_REPORT_U_DEF.FILE_NAME,
                }
        );

        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        //分成分组布局
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(200);
        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_REPORT_U_DEF.FILE_NAME,
                        SysTables.SYS_REPORT_U_DEF.CONTENT,

                }
        );

        cfg.view().field(SysTables.SYS_REPORT_U_DEF.CREATE_TIME).form().dateInput().type(DatePickerType.datetime);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        SysReportUDefGtr g=new SysReportUDefGtr();
        //生成代码
        g.generateCode();


        //生成菜单
        //g.removeByBatchId("");
       // g.generateMenu(ReportUDefServiceProxy.class, ReportUDefPageController.class);
    }


}
