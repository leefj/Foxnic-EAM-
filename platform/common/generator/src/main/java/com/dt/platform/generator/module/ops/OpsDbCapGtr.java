package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.ops.OpsDbRecoveryTypeEnum;
import com.dt.platform.domain.ops.DbCapacityRpt;
import com.dt.platform.domain.ops.DbInstance;
import com.dt.platform.domain.ops.meta.DbRecoveryRecMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.DbCapacityRptPageController;
import com.dt.platform.proxy.ops.DbCapacityRptServiceProxy;
import com.dt.platform.proxy.ops.DbInstanceServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;

public class OpsDbCapGtr extends BaseCodeGenerator{


    public OpsDbCapGtr() {
        super(OpsTables.OPS_DB_CAPACITY_RPT.$TABLE,"478178015856033792");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(OpsTables.OPS_DB_CAPACITY_RPT.ID).basic().hidden();


        cfg.view().field(OpsTables.OPS_DB_CAPACITY_RPT.NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_DB_CAPACITY_RPT.NOTES).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{

                        OpsTables.OPS_DB_RECOVERY_REC.NAME,
                        OpsTables.OPS_DB_RECOVERY_REC.NOTES,
                }

        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(OpsTables.OPS_DB_CAPACITY_RPT.FILE_ID).form().upload().maxFileCount(1).acceptAllType();
        cfg.view().field(OpsTables.OPS_DB_CAPACITY_RPT.NOTES).form()
               .textArea().height(Config.textAreaHeight);

        cfg.view().field(OpsTables.OPS_DB_CAPACITY_RPT.NAME).form().validate().required();

        cfg.view().field(OpsTables.OPS_DB_CAPACITY_RPT.ID).table().hidden(true);


        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().bottomSpace(60);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_DB_CAPACITY_RPT.NAME,
                        OpsTables.OPS_DB_CAPACITY_RPT.FILE_ID,
                        OpsTables.OPS_DB_CAPACITY_RPT.NOTES,
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
        OpsDbCapGtr g=new OpsDbCapGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
       // g.generateMenu(DbCapacityRptServiceProxy.class, DbCapacityRptPageController.class);
    }
}
