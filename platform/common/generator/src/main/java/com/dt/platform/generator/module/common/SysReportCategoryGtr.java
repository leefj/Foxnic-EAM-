package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.ReportCategoryPageController;
import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.LicenceStatusEnum;
import com.dt.platform.constants.enums.common.LicenceTypeEnum;
import com.dt.platform.domain.common.ReportCategory;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.ReportCategoryServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.oauth.Menu;

public class SysReportCategoryGtr extends BaseCodeGenerator{
    public SysReportCategoryGtr() {
        super(SysTables.SYS_REPORT_CATEGORY.$TABLE,"711645138962612224");
    }

    public void generateCode() throws Exception {


        cfg.view().field(SysTables.SYS_REPORT_CATEGORY.CODE).form().validate().required();
        cfg.view().field(SysTables.SYS_REPORT_CATEGORY.NAME).form().validate().required();


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
        SysReportCategoryGtr g=new SysReportCategoryGtr();
        //生成代码
        g.generateCode();


        //生成菜单
        //g.removeByBatchId("");
       // g.generateMenu(ReportCategoryServiceProxy.class, ReportCategoryPageController.class);
    }


}
