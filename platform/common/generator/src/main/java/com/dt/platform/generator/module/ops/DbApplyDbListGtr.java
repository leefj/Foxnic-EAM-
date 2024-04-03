package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.ops.OpsDbApplyAssociatedSystemEnum;
import com.dt.platform.constants.enums.ops.OpsDbApplyRbEnum;
import com.dt.platform.domain.ops.DbInfo;
import com.dt.platform.domain.ops.DbInfoApply;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.DbInfoApplyPageController;
import com.dt.platform.proxy.ops.DbInfoApplyServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class DbApplyDbListGtr extends BaseCodeGenerator{


    public DbApplyDbListGtr() {
        super(OpsTables.OPS_DB_INFO_APPLY.$TABLE,"472036556115279872");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(String.class,"datarange","datarange","datarange");
        cfg.getPoClassFile().addSimpleProperty(String.class,"business","business","business");


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(OpsTables.OPS_DB_INFO_APPLY.DB_FULL_NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_DB_INFO_APPLY.DB_IP).search().fuzzySearch();



        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_DB_INFO_APPLY.ASSOCIATED_SYSTEM,
                        OpsTables.OPS_DB_INFO_APPLY.DB_FULL_NAME,
                        OpsTables.OPS_DB_INFO_APPLY.DB_IP,
                }
        );


        cfg.view().field(OpsTables.OPS_DB_INFO_APPLY.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_DB_INFO_APPLY.ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_DB_INFO_APPLY.UPDATE_BY).table().disable(true);

        cfg.view().field(OpsTables.OPS_DB_INFO_APPLY.ASSOCIATED_SYSTEM).form().validate().required()
                .form().selectBox().enumType(OpsDbApplyAssociatedSystemEnum.class).defaultIndex(0);


        cfg.view().list().disableBatchDelete();
        cfg.view().form().labelWidth(65);

        cfg.view().formWindow().bottomSpace(50);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_DB_INFO_APPLY.ASSOCIATED_SYSTEM,
                        OpsTables.OPS_DB_INFO_APPLY.CODE,
                        OpsTables.OPS_DB_INFO_APPLY.DB_FULL_NAME,
                        OpsTables.OPS_DB_INFO_APPLY.DB_IP,
                        OpsTables.OPS_DB_INFO_APPLY.DB_NAME,
                        OpsTables.OPS_DB_INFO_APPLY.DB_PORT
                }
        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        DbApplyDbListGtr g=new DbApplyDbListGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
     //   g.generateMenu(DbInfoApplyServiceProxy.class, DbInfoApplyPageController.class);
    }
}
