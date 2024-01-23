package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.common.ValidStatusEnum;
import com.dt.platform.domain.ops.DbReport;
import com.dt.platform.domain.ops.meta.DbDocMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.DbReportPageController;
import com.dt.platform.proxy.ops.DbReportServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class OpsDbReportGtr extends BaseCodeGenerator{


    public OpsDbReportGtr() {
        super(OpsTables.OPS_DB_REPORT.$TABLE,"478178015856033792");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(OpsTables.OPS_DB_DOC.ID).basic().hidden();

        cfg.view().field(OpsTables.OPS_DB_REPORT.NAME).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_DB_REPORT.NAME

                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(OpsTables.OPS_DB_REPORT.NAME).form().validate().required();
        cfg.view().field(OpsTables.OPS_DB_REPORT.FILE_ID).form().upload().maxFileCount(3).acceptAllType();

        cfg.view().field(OpsTables.OPS_DB_REPORT.CONTENT).form()
                .textArea().height(300);

        cfg.view().field(OpsTables.OPS_DB_REPORT.NOTES).form()
               .textArea().height(Config.textAreaHeight);

        cfg.view().list().disableBatchDelete();

        cfg.view().field(OpsTables.OPS_DB_REPORT.ID).table().hidden(true);
        cfg.view().field(OpsTables.OPS_DB_REPORT.CONTENT).table().disable(true);

        cfg.view().field(OpsTables.OPS_DB_REPORT.CREATE_TIME).table().disable(true);
        cfg.view().field(OpsTables.OPS_DB_REPORT.CREATE_BY).table().disable(true);
        cfg.view().field(OpsTables.OPS_DB_REPORT.UPDATE_BY).table().disable(true);
        cfg.view().field(OpsTables.OPS_DB_REPORT.UPDATE_TIME).table().disable(true);

        cfg.view().formWindow().bottomSpace(60);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_DB_REPORT.NAME,
                        OpsTables.OPS_DB_REPORT.CONTENT,
                        OpsTables.OPS_DB_REPORT.NOTES,
                        OpsTables.OPS_DB_REPORT.FILE_ID,
                }
        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        OpsDbReportGtr g=new OpsDbReportGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
       // g.generateMenu(DbReportServiceProxy.class, DbReportPageController.class);
    }
}
