package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.ops.OpsDbRecoveryTypeEnum;
import com.dt.platform.domain.ops.DbBackupRecord;
import com.dt.platform.domain.ops.DbInstance;
import com.dt.platform.domain.ops.DbRecoveryRec;
import com.dt.platform.domain.ops.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.DbRecoveryRecPageController;
import com.dt.platform.proxy.ops.DbInfoServiceProxy;
import com.dt.platform.proxy.ops.DbInstanceServiceProxy;
import com.dt.platform.proxy.ops.DbRecoveryRecServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class OpsDbRecoverRecGtr extends BaseCodeGenerator{


    public OpsDbRecoverRecGtr() {
        super(OpsTables.OPS_DB_RECOVERY_REC.$TABLE,"478178015856033792");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.getPoClassFile().addSimpleProperty(DbInstance.class,"dbInstance","dbInstance","dbInstance");

        cfg.view().field(OpsTables.OPS_DB_DOC.NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_DB_DOC.NOTES).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_DB_RECOVERY_REC.REC_DATE).search().range();
        cfg.view().field(OpsTables.OPS_DB_RECOVERY_REC.REC_DATE).form().dateInput().format("yyyy-MM-dd");
        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_DB_RECOVERY_REC.TYPE,
                        OpsTables.OPS_DB_RECOVERY_REC.DB_INSTANCE_ID,
                        OpsTables.OPS_DB_RECOVERY_REC.NAME,
                        OpsTables.OPS_DB_RECOVERY_REC.NOTES,
                },
                new Object[]{
                        OpsTables.OPS_DB_RECOVERY_REC.REC_DATE,
                }

        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(OpsTables.OPS_DB_RECOVERY_REC.TYPE).form().validate().required().form().radioBox().enumType(OpsDbRecoveryTypeEnum.class).defaultIndex(0);
        cfg.view().field(OpsTables.OPS_DB_RECOVERY_REC.FILE_ID).form().upload().maxFileCount(6).acceptAllType();
        cfg.view().field(OpsTables.OPS_DB_RECOVERY_REC.NOTES).form()
               .textArea().height(Config.textAreaHeight);

        cfg.view().field(OpsTables.OPS_DB_RECOVERY_REC.NAME).form().validate().required();


        cfg.view().field(OpsTables.OPS_DB_RECOVERY_REC.DB_INSTANCE_ID)
                .form().selectBox().queryApi(DbInfoServiceProxy.QUERY_PAGED_LIST)
                .valueField(DbInfoMeta.ID).textField(DbInfoMeta.NAME)
                .toolbar(false).paging(true)
                .fillWith(DbRecoveryRecMeta.DB_INSTANCE).muliti(false);


        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().bottomSpace(60);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_DB_RECOVERY_REC.NAME,
                        OpsTables.OPS_DB_RECOVERY_REC.DB_INSTANCE_ID,
                        OpsTables.OPS_DB_RECOVERY_REC.TYPE,
                        OpsTables.OPS_DB_RECOVERY_REC.REC_DATE,
                        OpsTables.OPS_DB_RECOVERY_REC.FILE_ID,
                        OpsTables.OPS_DB_RECOVERY_REC.NOTES,
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
        OpsDbRecoverRecGtr g=new OpsDbRecoverRecGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
     //   g.generateMenu(DbRecoveryRecServiceProxy.class, DbRecoveryRecPageController.class);
    }
}
