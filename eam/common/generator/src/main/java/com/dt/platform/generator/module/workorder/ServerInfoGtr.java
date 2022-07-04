package com.dt.platform.generator.module.workorder;
import com.dt.platform.constants.db.VehicleTables;
import com.dt.platform.constants.db.WorkorderTables;
import com.dt.platform.domain.vehicle.meta.InfoMeta;
import com.dt.platform.generator.config.Config;

import com.github.foxnic.generator.config.WriteMode;
import com.sun.corba.se.spi.orbutil.threadpool.Work;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class ServerInfoGtr extends BaseCodeGenerator {


    public ServerInfoGtr() {
        super(WorkorderTables.WO_SERVER_INFO.$TABLE,"596083254763716608");
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
        ServerInfoGtr g=new ServerInfoGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
       // g.generateMenu(ServerInfoProxy.class, InfoPageController.class);
    }

}
