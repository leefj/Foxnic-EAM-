package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.eam.page.GoodsStockUsagePageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.GoodsStockUsageServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class EamGoodStockUsageGtr extends BaseCodeGenerator{
    public EamGoodStockUsageGtr() {
        super(EAMTables.EAM_GOODS_STOCK_USAGE.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.view().field(EAMTables.EAM_GOODS_STOCK_USAGE.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_GOODS_STOCK_USAGE.LABEL).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK_USAGE.CONTENT).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK_USAGE.REC_TIME).search().range();

        cfg.view().field(EAMTables.EAM_GOODS_STOCK_USAGE.BILL_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK_USAGE.OPER_USER_NAME).search().fuzzySearch();
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"opsUser","opsUser","opsUser");

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_GOODS_STOCK_USAGE.BILL_CODE,
                        EAMTables.EAM_GOODS_STOCK_USAGE.OPER_USER_NAME,
                        EAMTables.EAM_GOODS_STOCK_USAGE.LABEL,
                        EAMTables.EAM_GOODS_STOCK_USAGE.CONTENT,
                }
        );

        cfg.view().list().disableBatchDelete();
        cfg.view().list().disableCreateNew();


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);

        cfg.view().search().inputWidth(Config.searchInputWidth);



        cfg.view().field(EAMTables.EAM_GOODS_STOCK_USAGE.OPER_USER_ID).table().fillBy("opsUser","name");
        cfg.view().field(EAMTables.EAM_GOODS_STOCK_USAGE.OPER_USER_ID).form()
                .button().chooseEmployee(true);


        cfg.view().field(EAMTables.EAM_GOODS_STOCK_USAGE.CONTENT).form().textArea().height(Config.textAreaHeight);

        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_GOODS_STOCK_USAGE.LABEL,
                        EAMTables.EAM_GOODS_STOCK_USAGE.OPER_USER_NAME,
                        EAMTables.EAM_GOODS_STOCK_USAGE.REC_TIME,
                        EAMTables.EAM_GOODS_STOCK_USAGE.OPER_NUMBER,
                        EAMTables.EAM_GOODS_STOCK_USAGE.CONTENT,

                }

        );

        cfg.view().search().rowsDisplay(1);
        cfg.view().list().addJsVariable("OWNER_ID","[[${ownerId}]]","ownerId");

        cfg.view().field(EAMTables.EAM_GOODS_STOCK_USAGE.OWNER_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_GOODS_STOCK_USAGE.OPER_USER_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_GOODS_STOCK_USAGE.OPER).table().disable(true);
        cfg.view().field(EAMTables.EAM_GOODS_STOCK_USAGE.CREATE_TIME).table().disable(true);


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EamGoodStockUsageGtr g=new EamGoodStockUsageGtr();
        //生成代码
         g.generateCode();


        //生成菜单
        //  g.removeByBatchId("");
      //  g.generateMenu(GoodsStockUsageServiceProxy.class, GoodsStockUsagePageController.class);
    }
}
