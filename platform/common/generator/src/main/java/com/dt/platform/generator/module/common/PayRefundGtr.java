package com.dt.platform.generator.module.common;

import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.PayRefundStatusEnum;
import com.dt.platform.constants.enums.common.PayNotifyStatusEnum;
import com.dt.platform.constants.enums.common.PayRefundTypeEnum;
import com.dt.platform.domain.common.PayApp;
import com.dt.platform.domain.common.PayChannel;
import com.dt.platform.domain.common.PayMerchant;
import com.dt.platform.domain.common.PayOrder;
import com.dt.platform.domain.common.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.PayAppServiceProxy;
import com.dt.platform.proxy.common.PayMerchantServiceProxy;
import com.dt.platform.proxy.common.PayOrderServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;

public class PayRefundGtr extends BaseCodeGenerator{
    public PayRefundGtr() {
        super(SysTables.SYS_PAY_REFUND.$TABLE,"728502379380473856");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(PayMerchant.class,"payMerchant","payMerchant","payMerchant");
        cfg.getPoClassFile().addSimpleProperty(PayApp.class,"payApp","payApp","payApp");
        cfg.getPoClassFile().addSimpleProperty(PayChannel.class,"payChannel","payChannel","payChannel");
        cfg.getPoClassFile().addSimpleProperty(PayOrder.class,"payOrder","payOrder","payOrder");

        cfg.view().field(SysTables.SYS_PAY_REFUND.ID).basic().hidden(true);
        cfg.view().field(SysTables.SYS_PAY_REFUND.REASON).search().fuzzySearch();
        cfg.view().field(SysTables.SYS_PAY_REFUND.TRADE_NO).search().fuzzySearch();
        cfg.view().field(SysTables.SYS_PAY_REFUND.CREATE_TIME).search().range();
        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_PAY_REFUND.APP_ID,
                        SysTables.SYS_PAY_REFUND.MERCHANT_ID,
                        SysTables.SYS_PAY_REFUND.CHANNEL_ID,
                        SysTables.SYS_PAY_REFUND.TRADE_NO,
                },
                new Object[]{
                        SysTables.SYS_PAY_REFUND.STATUS,
                        SysTables.SYS_PAY_REFUND.NOTIFY_STATUS,
                        SysTables.SYS_PAY_REFUND.ORDER_ID,
                        SysTables.SYS_PAY_REFUND.TYPE,

                },
                new Object[]{
                        SysTables.SYS_PAY_REFUND.REASON,
                        SysTables.SYS_PAY_REFUND.CREATE_TIME,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(SysTables.SYS_PAY_REFUND.STATUS).form().validate().required().form().radioBox().enumType(PayRefundStatusEnum.class).defaultIndex(0);
        cfg.view().field(SysTables.SYS_PAY_REFUND.NOTIFY_STATUS).form().validate().required().form().radioBox().enumType(PayNotifyStatusEnum.class).defaultIndex(0);
        cfg.view().field(SysTables.SYS_PAY_REFUND.TYPE).form().validate().required().form().radioBox().enumType(PayRefundTypeEnum.class).defaultIndex(0);

        cfg.view().field(SysTables.SYS_PAY_REFUND.CREATE_TIME).form().dateInput().type(DatePickerType.datetime);
        cfg.view().field(SysTables.SYS_PAY_REFUND.EXPIRE_TIME).form().dateInput().type(DatePickerType.datetime);
        cfg.view().field(SysTables.SYS_PAY_REFUND.NOTIFY_TIME).form().dateInput().type(DatePickerType.datetime);
        cfg.view().field(SysTables.SYS_PAY_REFUND.SUCCESS_TIME).form().dateInput().type(DatePickerType.datetime);


        cfg.view().field(SysTables.SYS_PAY_REFUND.EXPIRE_TIME).table().disable(true);
        cfg.view().field(SysTables.SYS_PAY_REFUND.NOTIFY_TIME).table().disable(true);
        cfg.view().field(SysTables.SYS_PAY_REFUND.NOTIFY_TIME).table().disable(true);
        cfg.view().field(SysTables.SYS_PAY_REFUND.USER_IP).table().disable(true);
        cfg.view().field(SysTables.SYS_PAY_REFUND.CHANNEL_EXTRAS).table().disable(true);
        cfg.view().field(SysTables.SYS_PAY_REFUND.CHANNEL_ERROR_CODE).table().disable(true);
        cfg.view().field(SysTables.SYS_PAY_REFUND.CHANNEL_ERROR_MSG).table().disable(true);
        cfg.view().field(SysTables.SYS_PAY_REFUND.CHANNEL_CODE).table().disable(true);


        cfg.view().field(SysTables.SYS_PAY_REFUND.MERCHANT_ID)
                .form().selectBox().queryApi(PayMerchantServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(PayMerchantMeta.ID).textField(PayMerchantMeta.NAME).fillWith(PayOrderMeta.PAY_MERCHANT).muliti(false);

        cfg.view().field(SysTables.SYS_PAY_REFUND.APP_ID)
                .form().selectBox().queryApi(PayAppServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(PayAppMeta.ID).textField(PayAppMeta.NAME).fillWith(PayOrderMeta.PAY_APP).muliti(false);

        cfg.view().field(SysTables.SYS_PAY_REFUND.CHANNEL_ID)
                .form().selectBox().queryApi(PayAppServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(PayChannelMeta.ID).textField(PayChannelMeta.NAME).fillWith(PayOrderMeta.PAY_CHANNEL).muliti(false);


        cfg.view().field(SysTables.SYS_PAY_REFUND.ORDER_ID)
                .form().selectBox().queryApi(PayOrderServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(PayOrderMeta.ID).textField(PayOrderMeta.SUBJECT).fillWith(PayRefundMeta.PAY_ORDER).muliti(false);

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
        PayRefundGtr g=new PayRefundGtr();
        //生成代码
        g.generateCode();

        //生成菜单
        //g.removeByBatchId("");
      // g.generateMenu(PayRefundServiceProxy.class, PayRefundPageController.class);
    }


}
