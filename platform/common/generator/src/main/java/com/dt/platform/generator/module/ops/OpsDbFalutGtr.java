package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.domain.ops.DbFaultRcd;
import com.dt.platform.domain.ops.DbInstance;
import com.dt.platform.domain.ops.meta.DbFaultRcdMeta;
import com.dt.platform.domain.ops.meta.DbInfoMeta;
import com.dt.platform.domain.ops.meta.DbInstanceMeta;
import com.dt.platform.domain.ops.meta.DbRecoveryRecMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.DbFaultRcdPageController;
import com.dt.platform.proxy.ops.DbFaultRcdServiceProxy;
import com.dt.platform.proxy.ops.DbInfoServiceProxy;
import com.dt.platform.proxy.ops.DbInstanceServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;

public class OpsDbFalutGtr extends BaseCodeGenerator{


    public OpsDbFalutGtr() {
        super(OpsTables.OPS_DB_FAULT_RCD.$TABLE,"478178015856033792");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.getPoClassFile().addSimpleProperty(DbInstance.class,"dbInstance","dbInstance","dbInstance");


        cfg.view().field(OpsTables.OPS_DB_FAULT_RCD.NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_DB_FAULT_RCD.NOTES).search().fuzzySearch();

        cfg.view().field(OpsTables.OPS_DB_FAULT_RCD.RCD_DATE).form().dateInput().format("yyyy-MM-dd");

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_DB_FAULT_RCD.DB_INSTANCE_ID,
                        OpsTables.OPS_DB_FAULT_RCD.NAME,
                        OpsTables.OPS_DB_FAULT_RCD.NOTES,
                }

        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(OpsTables.OPS_DB_FAULT_RCD.REASON).form()
                .textArea().height(Config.textAreaHeight);


        cfg.view().field(OpsTables.OPS_DB_FAULT_RCD.PROCESS).form()
                .textArea().height(Config.textAreaHeight);
        cfg.view().field(OpsTables.OPS_DB_FAULT_RCD.FILE_ID).form().upload().maxFileCount(6).acceptAllType();
        cfg.view().field(OpsTables.OPS_DB_FAULT_RCD.NOTES).form()
               .textArea().height(Config.textAreaHeight);

        cfg.view().field(OpsTables.OPS_DB_FAULT_RCD.NAME).form().validate().required();


        cfg.view().field(OpsTables.OPS_DB_FAULT_RCD.DB_INSTANCE_ID)
                .form().selectBox().queryApi(DbInfoServiceProxy.QUERY_PAGED_LIST)
                .valueField(DbInfoMeta.ID).textField(DbInfoMeta.NAME)
                .toolbar(false).paging(true)
                .fillWith(DbFaultRcdMeta.DB_INSTANCE).muliti(false);



        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().bottomSpace(60);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_DB_FAULT_RCD.NAME,
                        OpsTables.OPS_DB_FAULT_RCD.DB_INSTANCE_ID,
                        OpsTables.OPS_DB_FAULT_RCD.RCD_DATE,
                        OpsTables.OPS_DB_FAULT_RCD.REASON,
                        OpsTables.OPS_DB_FAULT_RCD.PROCESS,
                        OpsTables.OPS_DB_FAULT_RCD.FILE_ID,
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
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        OpsDbFalutGtr g=new OpsDbFalutGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
       // g.generateMenu(DbFaultRcdServiceProxy.class, DbFaultRcdPageController.class);
    }
}
