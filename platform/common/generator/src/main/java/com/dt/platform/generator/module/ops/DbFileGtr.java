package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.domain.ops.DbApplyFile;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.DbApplyFilePageController;
import com.dt.platform.proxy.ops.DbApplyFileServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class DbFileGtr extends BaseCodeGenerator{


    public DbFileGtr() {
        super(OpsTables.OPS_DB_APPLY_FILE.$TABLE,"472036556115279872");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().search().disable();


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);



        cfg.view().field(OpsTables.OPS_DB_APPLY_FILE.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_DB_APPLY_FILE.ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_DB_APPLY_FILE.UPDATE_BY).table().disable(true);


        cfg.view().list().disableBatchDelete();
        cfg.view().form().labelWidth(65);

        cfg.view().formWindow().bottomSpace(50);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_DB_APPLY_FILE.FILE_ID,
                        OpsTables.OPS_DB_APPLY_FILE.SN,
                }
        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        DbFileGtr g=new DbFileGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
      //  g.generateMenu(DbApplyFileServiceProxy.class, DbApplyFilePageController.class);
    }
}
