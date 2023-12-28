package com.dt.platform.generator.module.common;

import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.ReportSourceEnum;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.common.ReportCategory;
import com.dt.platform.domain.common.ReportUDef;
import com.dt.platform.domain.common.meta.ReportCategoryMeta;
import com.dt.platform.domain.common.meta.ReportMeta;
import com.dt.platform.domain.common.meta.ReportUDefMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.ReportCategoryServiceProxy;
import com.dt.platform.proxy.common.ReportUDefServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;

public class SysReportAclGtr extends BaseCodeGenerator{
    public SysReportAclGtr() {
        super(SysTables.SYS_REPORT_ACL.$TABLE,"711645138962612224");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.IGNORE) //表单HTML页
                .setListPage(WriteMode.IGNORE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        SysReportAclGtr g=new SysReportAclGtr();
        //生成代码
        g.generateCode();


        //生成菜单
        //g.removeByBatchId("");
       // g.generateMenu(ReportServiceProxy.class, ReportPageController.class);
    }


}
