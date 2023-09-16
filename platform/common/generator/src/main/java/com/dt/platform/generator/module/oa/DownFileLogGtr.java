package com.dt.platform.generator.module.oa;

import com.dt.platform.constants.db.OaTables;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;

public class DownFileLogGtr extends BaseCodeGenerator {


    public DownFileLogGtr() {
        super(OaTables.OA_DOWNLOAD_LOG.$TABLE,"710459401026142208");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(OaTables.OA_DOWNLOAD_LOG.ID).basic().hidden(true);

        cfg.view().search().inputLayout(
                new Object[]{
                        OaTables.OA_DOWNLOAD_LOG.REC_ID,

                }
        );

        cfg.view().field(OaTables.OA_DOWNLOAD_LOG.REC_ID).search().fuzzySearch();


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_DOWNLOAD_LOG.REC_ID,
                }
        );


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        DownFileLogGtr g=new DownFileLogGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
     //   g.generateMenu(DownloadLogServiceProxy.class, DownloadLogPageController.class);
    }

}
