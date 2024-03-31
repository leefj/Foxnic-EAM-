package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.domain.ops.DbApplyExecute;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.DbApplyExecutePageController;
import com.dt.platform.proxy.ops.DbApplyExecuteServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class DbApplyExecuteGtr extends BaseCodeGenerator{


    public DbApplyExecuteGtr() {
        super(OpsTables.OPS_DB_APPLY_EXECUTE.$TABLE,"472036556115279872");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(OpsTables.OPS_DB_APPLY_EXECUTE.TITLE).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_DB_APPLY_EXECUTE.RESULT).search().fuzzySearch();

        cfg.view().field(OpsTables.OPS_DB_APPLY_EXECUTE.CREATE_TIME).form().dateInput().type(DatePickerType.datetime).format("yyyy-MM-dd HH:mm:ss").search().range();

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"operUser","operUser","operUser");

        cfg.view().field(OpsTables.OPS_DB_APPLY_EXECUTE.CREATE_TIME).search().range();
        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_DB_APPLY_EXECUTE.TITLE,
                        OpsTables.OPS_DB_APPLY_EXECUTE.RESULT,
                        OpsTables.OPS_DB_APPLY_EXECUTE.CREATE_TIME,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(OpsTables.OPS_DB_APPLY_EXECUTE.OPER_ID).form().button().chooseEmployee(true);
        cfg.view().field(OpsTables.OPS_DB_APPLY_EXECUTE.OPER_ID).table().fillBy("operUser","name");
        cfg.view().field(OpsTables.OPS_DB_APPLY_EXECUTE.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_DB_APPLY_EXECUTE.ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_DB_APPLY_EXECUTE.UPDATE_BY).table().disable(true);
        cfg.view().field(OpsTables.OPS_DB_APPLY_EXECUTE.OWNER_ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_DB_APPLY_EXECUTE.SOURCE).table().disable(true);
        cfg.view().field(OpsTables.OPS_DB_APPLY_EXECUTE.RESULT).form().textArea().height(300);

        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().bottomSpace(50);
        cfg.view().formWindow().width(Config.baseFormWidth);

        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_DB_APPLY_EXECUTE.TITLE
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_DB_APPLY_EXECUTE.OPER_ID,
                },
                new Object[] {
                        OpsTables.OPS_DB_APPLY_EXECUTE.SOURCE,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_DB_APPLY_EXECUTE.RESULT,
                        OpsTables.OPS_DB_APPLY_EXECUTE.CREATE_TIME,
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
        DbApplyExecuteGtr g=new DbApplyExecuteGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
       // g.generateMenu(DbApplyExecuteServiceProxy.class, DbApplyExecutePageController.class);
    }
}
