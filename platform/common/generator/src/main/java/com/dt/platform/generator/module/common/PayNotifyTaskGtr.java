package com.dt.platform.generator.module.common;

import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.PayNotifyStatusEnum;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.common.PayApp;
import com.dt.platform.domain.common.PayMerchant;
import com.dt.platform.domain.common.meta.PayAppMeta;
import com.dt.platform.domain.common.meta.PayMerchantMeta;
import com.dt.platform.domain.common.meta.PayNotifyTaskMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.PayAppServiceProxy;
import com.dt.platform.proxy.common.PayMerchantServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;

public class PayNotifyTaskGtr extends BaseCodeGenerator{
    public PayNotifyTaskGtr() {
        super(SysTables.SYS_PAY_NOTIFY_TASK.$TABLE,"728502379380473856");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(PayMerchant.class,"payMerchant","payMerchant","payMerchant");
        cfg.getPoClassFile().addSimpleProperty(PayApp.class,"payApp","payApp","payApp");


        cfg.view().field(SysTables.SYS_PAY_NOTIFY_TASK.ID).basic().hidden(true);

        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_PAY_NOTIFY_TASK.STATUS,
                        SysTables.SYS_PAY_NOTIFY_TASK.APP_ID,
                        SysTables.SYS_PAY_NOTIFY_TASK.MERCHANT_ID,
                }
        );

        cfg.view().field(SysTables.SYS_PAY_NOTIFY_TASK.MERCHANT_ID)
                .form().selectBox().queryApi(PayMerchantServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(PayMerchantMeta.ID).textField(PayMerchantMeta.NAME).fillWith(PayNotifyTaskMeta.PAY_MERCHANT).muliti(false);

        cfg.view().field(SysTables.SYS_PAY_NOTIFY_TASK.APP_ID)
                .form().selectBox().queryApi(PayAppServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(PayAppMeta.ID).textField(PayAppMeta.NAME).fillWith(PayNotifyTaskMeta.PAY_APP).muliti(false);

        cfg.view().field(SysTables.SYS_PAY_NOTIFY_TASK.NEXT_NOTIFY_TIME).form().dateInput().type(DatePickerType.datetime);
        cfg.view().field(SysTables.SYS_PAY_NOTIFY_TASK.LAST_EXECUTE_TIME).form().dateInput().type(DatePickerType.datetime);
        cfg.view().field(SysTables.SYS_PAY_NOTIFY_TASK.STATUS).form().validate().required().form().radioBox().enumType(PayNotifyStatusEnum.class).defaultIndex(0);
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(SysTables.SYS_PAY_NOTIFY_TASK.STATUS).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);


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
        PayNotifyTaskGtr g=new PayNotifyTaskGtr();
        //生成代码
        g.generateCode();

        //生成菜单
        //g.removeByBatchId("");
      // g.generateMenu(PayNotifyTaskServiceProxy.class, PayNotifyTaskPageController.class);
    }


}
