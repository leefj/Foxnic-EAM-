package com.dt.platform.generator.module.oa;

import com.dt.platform.constants.db.OaTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.oa.DownloadFile;
import com.dt.platform.generator.config.Config;
import com.dt.platform.oa.page.DownloadFilePageController;
import com.dt.platform.proxy.oa.DownloadFileServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class DowmFileGtr extends BaseCodeGenerator {


    public DowmFileGtr() {
        super(OaTables.OA_DOWNLOAD_FILE.$TABLE,"710459401026142208");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(OaTables.OA_DOWNLOAD_FILE.ID).basic().hidden(true);
        cfg.view().field(OaTables.OA_DOWNLOAD_FILE.NAME).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{

                        OaTables.OA_DOWNLOAD_FILE.STATUS,
                        OaTables.OA_DOWNLOAD_FILE.NAME,

                }
        );

        cfg.view().field(OaTables.OA_DOWNLOAD_FILE.NAME).form().validate().required();
        cfg.view().field(OaTables.OA_DOWNLOAD_FILE.STATUS).form().radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);
        cfg.view().field(OaTables.OA_DOWNLOAD_FILE.FILE_ID).form().validate().required().form().upload().maxFileCount(1).acceptSingleFile();


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_DOWNLOAD_FILE.NAME,
                        OaTables.OA_DOWNLOAD_FILE.STATUS,
                        OaTables.OA_DOWNLOAD_FILE.FILE_ID,
                        OaTables.OA_DOWNLOAD_FILE.NOTES,
                        OaTables.OA_DOWNLOAD_FILE.SORT,
                }
        );


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        DowmFileGtr g=new DowmFileGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
       // g.generateMenu(DownloadFileServiceProxy.class, DownloadFilePageController.class);
    }

}
