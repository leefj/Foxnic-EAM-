package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.domain.ops.DbExecuteUser;
import com.dt.platform.domain.ops.DbInfoApply;
import com.dt.platform.domain.ops.meta.DbChangeApplyMeta;
import com.dt.platform.domain.ops.meta.DbExecuteUserMeta;
import com.dt.platform.domain.ops.meta.DbInfoApplyMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.DbExecuteUserPageController;
import com.dt.platform.proxy.ops.DbExecuteUserServiceProxy;
import com.dt.platform.proxy.ops.DbInfoApplyServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class DbApplyUserGtr extends BaseCodeGenerator{


    public DbApplyUserGtr() {
        super(OpsTables.OPS_DB_EXECUTE_USER.$TABLE,"826837230944256000");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());





        cfg.getPoClassFile().addListProperty(DbInfoApply.class,"dbInfoApplyForYqList","dbInfoApplyForYqList","dbInfoApplyForYqList");
        cfg.getPoClassFile().addListProperty(String.class,"dbInfoApplyForYqIds","dbInfoApplyForYqIds","dbInfoApplyForYqIds");


        cfg.getPoClassFile().addListProperty(DbInfoApply.class,"dbInfoApplyForBbList","dbInfoApplyForBbList","dbInfoApplyForBbList");
        cfg.getPoClassFile().addListProperty(String.class,"dbInfoApplyForBbIds","dbInfoApplyForBbIds","dbInfoApplyForBbIds");


        cfg.view().search().disable();
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(OpsTables.OPS_DB_EXECUTE_USER.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_DB_EXECUTE_USER.ID).table().disable(true);

        cfg.view().field(DbExecuteUserMeta.DB_INFO_APPLY_FOR_BB_IDS).basic().label("选择数据库").table().disable(true);
        cfg.view().field(DbExecuteUserMeta.DB_INFO_APPLY_FOR_YQ_IDS).basic().label("选择数据库").table().disable(true);

        cfg.view().field(DbExecuteUserMeta.DB_INFO_APPLY_FOR_BB_IDS)
                .form().validate().required().form().selectBox().queryApi(DbInfoApplyServiceProxy.QUERY_EXECUTE_DB_PAGED_LIST+"?business=change")
                .paging(true).filter(true).toolbar(false)
                .valueField(DbInfoApplyMeta.CODE).
                textField(DbInfoApplyMeta.DB_FULL_NAME).
                fillWith(DbChangeApplyMeta.DB_INFO_APPLY).muliti(false).defaultIndex(0);


        cfg.view().field(OpsTables.OPS_DB_CHANGE_APPLY.DB_ID)
                .form().validate().required().form().selectBox().queryApi(DbInfoApplyServiceProxy.QUERY_LIST+"?datarange=change")
                .paging(false).filter(true).toolbar(false)
                .valueField(DbInfoApplyMeta.ID).
                textField(DbInfoApplyMeta.DB_FULL_NAME).
                fillWith(DbChangeApplyMeta.DB_INFO_APPLY).muliti(false).defaultIndex(0);



        cfg.view().field(OpsTables.OPS_DB_EXECUTE_USER.UPDATE_BY).table().disable(true);
        cfg.view().field(OpsTables.OPS_DB_EXECUTE_USER.NOTES).form().textArea().height(120);
        cfg.view().list().disableBatchDelete();
        cfg.view().form().labelWidth(65);
        cfg.view().formWindow().bottomSpace(50);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_DB_EXECUTE_USER.USER_ID,

                }
        );

        cfg.view().form().addGroup("YQ",
                new Object[] {
                        DbExecuteUserMeta.DB_INFO_APPLY_FOR_YQ_IDS,
                }
        );

        cfg.view().form().addGroup("BB",
                new Object[] {
                        DbExecuteUserMeta.DB_INFO_APPLY_FOR_BB_IDS,
                }
        );


        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_DB_EXECUTE_USER.NOTES,
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
        DbApplyUserGtr g=new DbApplyUserGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
        g.generateMenu(DbExecuteUserServiceProxy.class, DbExecuteUserPageController.class);
    }
}
