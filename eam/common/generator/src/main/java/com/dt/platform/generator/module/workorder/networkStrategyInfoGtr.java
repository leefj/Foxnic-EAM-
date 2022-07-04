package com.dt.platform.generator.module.workorder;
import com.dt.platform.constants.db.WorkorderTables;
import com.dt.platform.proxy.workorder.NetworkStrategyInfoServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class networkStrategyInfoGtr extends BaseCodeGenerator {


    public networkStrategyInfoGtr() {
        super(WorkorderTables.WO_NETWORK_STRATEGY_INFO.$TABLE,"596083254763716608");
    }

    public void generateCode() throws Exception {

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setBpmEventAdaptor(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        networkStrategyInfoGtr g=new networkStrategyInfoGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
    //    g.generateMenu(NetworkStrategyInfoServiceProxy.class, NetworkStrategyInfoServiceProxy.class);
    }

}
