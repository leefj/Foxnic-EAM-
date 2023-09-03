package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.ops.OpsAutoTaskResultStatusEnum;
import com.dt.platform.domain.ops.AutoAction;
import com.dt.platform.domain.ops.AutoNode;
import com.dt.platform.domain.ops.AutoTask;
import com.dt.platform.domain.ops.AutoTaskMLog;
import com.dt.platform.domain.ops.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.AutoTaskLogDtlPageController;
import com.dt.platform.proxy.ops.*;
import com.github.foxnic.generator.config.WriteMode;

public class AutoTaskLogDtlGtr extends BaseCodeGenerator{


    public AutoTaskLogDtlGtr() {
        super(OpsTables.OPS_AUTO_TASK_LOG_DTL.$TABLE,"613652361268690944");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_AUTO_TASK_LOG_DTL.IND,
                }
        );

        cfg.view().list().disableSingleDelete();
        cfg.view().list().disableCreateNew();
        cfg.view().list().disableModify();
        cfg.view().list().disableBatchDelete();

        cfg.view().search().rowsDisplay(1);
        cfg.view().field(OpsTables.OPS_AUTO_TASK_LOG_DTL.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_AUTO_TASK_LOG_DTL.CREATE_TIME).basic().hidden(true);

        cfg.view().field(OpsTables.OPS_AUTO_TASK_LOG_DTL.ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_AUTO_TASK_LOG_DTL.CREATE_TIME).table().disable(true);

        cfg.view().formWindow().bottomSpace(80);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_AUTO_TASK_LOG_DTL.IND,
                        OpsTables.OPS_AUTO_TASK_LOG_DTL.CONTENT
                }
        );
        cfg.view().list().addJsVariable("OWNER_ID","[[${ownerId}]]","ownerId");

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
        AutoTaskLogDtlGtr g=new AutoTaskLogDtlGtr();
        //生成代码
        g.generateCode();
     //   g.generateMenu(AutoTaskLogDtlServiceProxy.class, AutoTaskLogDtlPageController.class);
    }
}
