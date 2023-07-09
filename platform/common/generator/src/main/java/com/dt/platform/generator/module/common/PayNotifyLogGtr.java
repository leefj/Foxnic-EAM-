package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.PayNotifyLogPageController;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.common.PayApp;
import com.dt.platform.domain.common.PayNotifyLog;
import com.dt.platform.domain.common.PayNotifyTask;
import com.dt.platform.domain.common.meta.PayAppMeta;
import com.dt.platform.domain.common.meta.PayNotifyLogMeta;
import com.dt.platform.domain.common.meta.PayNotifyTaskMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.PayAppServiceProxy;
import com.dt.platform.proxy.common.PayNotifyLogServiceProxy;
import com.dt.platform.proxy.common.PayNotifyTaskServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class PayNotifyLogGtr extends BaseCodeGenerator{
    public PayNotifyLogGtr() {
        super(SysTables.SYS_PAY_NOTIFY_LOG.$TABLE,"728502379380473856");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(SysTables.SYS_PAY_NOTIFY_LOG.ID).basic().hidden(true);

        cfg.getPoClassFile().addSimpleProperty(PayNotifyTask.class,"payNotifyTask","payNotifyTask","payNotifyTask");

        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_PAY_NOTIFY_LOG.STATUS,
                        SysTables.SYS_PAY_NOTIFY_LOG.TASK_ID
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(SysTables.SYS_PAY_NOTIFY_LOG.STATUS).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);
        cfg.view().field(SysTables.SYS_PAY_NOTIFY_LOG.RESPONSE).form().textArea().height(200);


        cfg.view().field(SysTables.SYS_PAY_NOTIFY_LOG.TASK_ID)
                .form().selectBox().queryApi(PayNotifyTaskServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(PayNotifyTaskMeta.ID).textField(PayNotifyTaskMeta.ID).fillWith(PayNotifyLogMeta.PAY_NOTIFY_TASK).muliti(false);



        cfg.view().formWindow().bottomSpace(100);
        cfg.view().formWindow().width(Config.baseFormWidth);;
//        cfg.view().form().addGroup(null,
//                new Object[] {
//                        SysTables.SYS_PAY_MERCHANT.NUMBER,
//                        SysTables.SYS_PAY_MERCHANT.NAME,
//                        SysTables.SYS_PAY_MERCHANT.SHORT_NAME,
//                        SysTables.SYS_PAY_MERCHANT.STATUS,
//                        SysTables.SYS_PAY_MERCHANT.NOTES,
//
//                }
//        );

        cfg.view().list().disableBatchDelete();
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        PayNotifyLogGtr g=new PayNotifyLogGtr();
        //生成代码
        g.generateCode();

        //生成菜单
        //g.removeByBatchId("");
       // g.generateMenu(PayNotifyLogServiceProxy.class, PayNotifyLogPageController.class);
    }


}
