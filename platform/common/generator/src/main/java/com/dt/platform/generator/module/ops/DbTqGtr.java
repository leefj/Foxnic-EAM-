package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.ops.OpsDbApplyCheckEnum;
import com.dt.platform.constants.enums.ops.OpsDbApplyOrderStatusEnum;
import com.dt.platform.constants.enums.ops.OpsDbApplyStatusEnum;
import com.dt.platform.domain.ops.DbApplyExecute;
import com.dt.platform.domain.ops.DbExtractApply;
import com.dt.platform.domain.ops.DbInfoApply;
import com.dt.platform.domain.ops.meta.DbExtractApplyMeta;
import com.dt.platform.domain.ops.meta.DbInfoApplyMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.DbExtractApplyPageController;
import com.dt.platform.proxy.ops.DbApplyExecuteServiceProxy;
import com.dt.platform.proxy.ops.DbExtractApplyServiceProxy;
import com.dt.platform.proxy.ops.DbInfoApplyServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;

public class DbTqGtr extends BaseCodeGenerator{


    public DbTqGtr() {
        super(OpsTables.OPS_DB_EXTRACT_APPLY.$TABLE,"472036556115279872");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());
        cfg.view().field(OpsTables.OPS_DB_EXTRACT_APPLY.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_DB_EXTRACT_APPLY.NOTES).search().fuzzySearch();
        cfg.getPoClassFile().addSimpleProperty(DbInfoApply.class,"dbInfoApply","dbInfoApply","dbInfoApply");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"applyUser","applyUser","applyUser");

        cfg.getPoClassFile().addSimpleProperty(DbApplyExecute.class,"requestOrder","requestOrder","requestOrder");

        cfg.getPoClassFile().addSimpleProperty(String.class,"buttonCheck","buttonCheck","buttonCheck");
        cfg.getPoClassFile().addSimpleProperty(String.class,"buttonCheckDetail","buttonCheckDetail","buttonCheckDetail");


        cfg.view().list().disableBatchDelete();


        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_DB_EXTRACT_APPLY.STATUS,
                        OpsTables.OPS_DB_EXTRACT_APPLY.DB_FULL_NAME,
                        OpsTables.OPS_DB_EXTRACT_APPLY.APPLY_USER_ID,
                }
        );
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(OpsTables.OPS_DB_EXTRACT_APPLY.ITEM_CODE).table().disable(true);
        cfg.view().field(OpsTables.OPS_DB_EXTRACT_APPLY.DB_IP).table().disable(true);
        cfg.view().field(OpsTables.OPS_DB_EXTRACT_APPLY.DB_PORT).table().disable(true);
        cfg.view().field(OpsTables.OPS_DB_EXTRACT_APPLY.DB_ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_DB_EXTRACT_APPLY.DB_NAME).table().disable(true);
        cfg.view().field(OpsTables.OPS_DB_EXTRACT_APPLY.UPDATE_BY).table().disable(true);
        cfg.view().field(OpsTables.OPS_DB_EXTRACT_APPLY.SQL_AREA).table().disable(true);

        cfg.view().field(DbExtractApplyMeta.BUTTON_CHECK).table().disable(true);

        cfg.view().field(OpsTables.OPS_DB_EXTRACT_APPLY.ORDER_ID).table().disable(true);




        cfg.view().field(OpsTables.OPS_DB_EXTRACT_APPLY.DB_USER).table().disable(true);
        cfg.view().field(OpsTables.OPS_DB_EXTRACT_APPLY.SELECTED_CODE).table().disable(true);
        cfg.view().field(OpsTables.OPS_DB_EXTRACT_APPLY.NOTES).table().disable(true);
        cfg.view().field(OpsTables.OPS_DB_EXTRACT_APPLY.PUSH_RESULT).table().disable(true);
        cfg.view().field(OpsTables.OPS_DB_EXTRACT_APPLY.PUSH_ORDER_STATUS).table().disable(true);
        cfg.view().field(OpsTables.OPS_DB_EXTRACT_APPLY.ASSOCIATED_SYSTEM).table().disable(true);

        cfg.view().field(OpsTables.OPS_DB_EXTRACT_APPLY.NOTES).form().textArea().height(20);



        cfg.view().field(OpsTables.OPS_DB_EXTRACT_APPLY.DB_ID)
                .form().validate().required().form().selectBox().queryApi(DbInfoApplyServiceProxy.QUERY_LIST+"?datarange=extract")
                .paging(false).filter(true).toolbar(false)
                .valueField(DbInfoApplyMeta.ID).
                textField(DbInfoApplyMeta.DB_FULL_NAME).
                fillWith(DbExtractApplyMeta.DB_INFO_APPLY).muliti(false).defaultIndex(0);



        cfg.view().field(OpsTables.OPS_DB_EXTRACT_APPLY.ITEM_CODE)
                 .form().selectBox().queryApi(DbApplyExecuteServiceProxy.QUERY_PAGED_LIST+"?datarange=extract")
                .paging(false).filter(true).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(DbExtractApplyMeta.REQUEST_ORDER).muliti(false).defaultIndex(0);
        cfg.view().field(OpsTables.OPS_DB_EXTRACT_APPLY.CHECK_RESULT).form().validate().required().form().readOnly().form().selectBox().enumType(OpsDbApplyCheckEnum.class).defaultIndex(0);
        cfg.view().field(OpsTables.OPS_DB_EXTRACT_APPLY.PUSH_ORDER_STATUS).form().selectBox().enumType(OpsDbApplyOrderStatusEnum.class).defaultIndex(0);
        cfg.view().field(OpsTables.OPS_DB_EXTRACT_APPLY.STATUS).form().radioBox().enumType(OpsDbApplyStatusEnum.class).defaultIndex(0);
        cfg.view().field(OpsTables.OPS_DB_EXTRACT_APPLY.APPLY_USER_ID).form().button().chooseEmployee(true);
        cfg.view().field(OpsTables.OPS_DB_EXTRACT_APPLY.APPLY_USER_ID).table().fillBy("applyUser","name");
        cfg.view().field(DbExtractApplyMeta.BUTTON_CHECK).basic().label("按钮").form().button().action("验证","checkSql","check-Sql","");
        cfg.view().field(DbExtractApplyMeta.BUTTON_CHECK_DETAIL).basic().label("按钮").form().button().action("结果明细","checkSqlResult","check-Sql-result","");
        cfg.view().formWindow().width(Config.baseFormWidth_95);
        cfg.view().formWindow().bottomSpace(120);


        cfg.view().field(OpsTables.OPS_DB_EXTRACT_APPLY.SQL_AREA).form().textArea().height(150);
        cfg.view().field(OpsTables.OPS_DB_EXTRACT_APPLY.SQL_AREA2).form().textArea().height(150);
        cfg.view().field(OpsTables.OPS_DB_EXTRACT_APPLY.SQL_AREA3).form().textArea().height(150);
        cfg.view().field(OpsTables.OPS_DB_EXTRACT_APPLY.SQL_AREA4).form().textArea().height(150);
        cfg.view().field(OpsTables.OPS_DB_EXTRACT_APPLY.SQL_AREA5).form().textArea().height(150);

        cfg.view().list().disableBatchDelete();
        cfg.view().form().addGroup("关联信息",
                new Object[] {
                        OpsTables.OPS_DB_EXTRACT_APPLY.ITEM_CODE,
                        OpsTables.OPS_DB_EXTRACT_APPLY.CONTENT
                },
                new Object[] {
                        OpsTables.OPS_DB_EXTRACT_APPLY.DB_ID
                }
        );
        cfg.view().form().addGroup("查询的SQL文本放于此处,一个框一个提取语句",
                new Object[] {
                        OpsTables.OPS_DB_EXTRACT_APPLY.SQL_AREA,
                        OpsTables.OPS_DB_EXTRACT_APPLY.SQL_AREA2,
                        OpsTables.OPS_DB_EXTRACT_APPLY.SQL_AREA3,
                        OpsTables.OPS_DB_EXTRACT_APPLY.SQL_AREA4,
                        OpsTables.OPS_DB_EXTRACT_APPLY.SQL_AREA5,
                }
        );
        cfg.view().form().addJsVariable("ASSOCIATED_SYSTEM","[[${associatedSystem}]]","associatedSystem");
        cfg.view().list().operationColumn().addActionButton("提交","submitOrder","submit-order");

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
        DbTqGtr g=new DbTqGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
        //
        //
       // g.generateMenu(DbExtractApplyServiceProxy.class, DbExtractApplyPageController.class);
    }
}
