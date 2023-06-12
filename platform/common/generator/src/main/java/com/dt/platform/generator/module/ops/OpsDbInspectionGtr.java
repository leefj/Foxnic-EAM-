package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.domain.ops.DbInstance;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.DbInspectionPageController;
import com.dt.platform.proxy.ops.DbInspectionServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class OpsDbInspectionGtr extends BaseCodeGenerator{


    public OpsDbInspectionGtr() {
        super(OpsTables.OPS_DB_INSPECTION.$TABLE,"719091995426947072");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.getPoClassFile().addSimpleProperty(DbInstance.class,"dbInstance","dbInstance","dbInstance");


        cfg.view().field(OpsTables.OPS_DB_INSPECTION.ID).basic().hidden();
        cfg.view().field(OpsTables.OPS_DB_INSPECTION.NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_DB_INSPECTION.NOTES).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_DB_INSPECTION.RCD_DATE).form().dateInput().format("yyyy-MM-dd");
        cfg.view().field(OpsTables.OPS_DB_INSPECTION.RCD_DATE).search().range();
        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_DB_INSPECTION.NAME,
                        OpsTables.OPS_DB_INSPECTION.RCD_DATE,
                }

        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);



        cfg.view().field(OpsTables.OPS_DB_INSPECTION.NAME).form().validate().required();

        cfg.view().field(OpsTables.OPS_DB_INSPECTION.RESULT).form().textArea().height(150);

        cfg.view().field(OpsTables.OPS_DB_INSPECTION.FILE_ID).form().validate().required().form().upload().acceptSingleFile();

        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().bottomSpace(60);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_DB_INSPECTION.NAME,
                        OpsTables.OPS_DB_INSPECTION.ACTION_USER,
                        OpsTables.OPS_DB_INSPECTION.RESULT,
                        OpsTables.OPS_DB_INSPECTION.RCD_DATE,
                        OpsTables.OPS_DB_INSPECTION.FILE_ID,
                        OpsTables.OPS_DB_FAULT_RCD.NOTES,
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
        OpsDbInspectionGtr g=new OpsDbInspectionGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
      //  g.generateMenu(DbInspectionServiceProxy.class, DbInspectionPageController.class);
    }
}
