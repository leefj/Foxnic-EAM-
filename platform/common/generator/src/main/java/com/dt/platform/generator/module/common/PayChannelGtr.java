package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.PayChannelPageController;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.common.PayApp;
import com.dt.platform.domain.common.PayChannel;
import com.dt.platform.domain.common.PayMerchant;
import com.dt.platform.domain.common.meta.PayAppMeta;
import com.dt.platform.domain.common.meta.PayChannelMeta;
import com.dt.platform.domain.common.meta.PayMerchantMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.PayAppServiceProxy;
import com.dt.platform.proxy.common.PayChannelServiceProxy;
import com.dt.platform.proxy.common.PayMerchantServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class PayChannelGtr extends BaseCodeGenerator{
    public PayChannelGtr() {
        super(SysTables.SYS_PAY_CHANNEL.$TABLE,"728502379380473856");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.getPoClassFile().addSimpleProperty(PayMerchant.class,"payMerchant","payMerchant","payMerchant");
        cfg.getPoClassFile().addSimpleProperty(PayApp.class,"payApp","payApp","payApp");


        cfg.view().field(SysTables.SYS_PAY_CHANNEL.ID).basic().hidden(true);
        cfg.view().field(SysTables.SYS_PAY_CHANNEL.NOTES).search().fuzzySearch();
        cfg.view().field(SysTables.SYS_PAY_CHANNEL.NAME).search().fuzzySearch();
        cfg.view().field(SysTables.SYS_PAY_CHANNEL.CODE).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_PAY_CHANNEL.APP_ID,
                        SysTables.SYS_PAY_CHANNEL.CODE,
                        SysTables.SYS_PAY_CHANNEL.NAME,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(SysTables.SYS_PAY_CHANNEL.NAME).form().validate().required();
        cfg.view().field(SysTables.SYS_PAY_CHANNEL.NOTES).form().textArea().height(500);
        cfg.view().field(SysTables.SYS_PAY_CHANNEL.STATUS).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);

        cfg.view().field(SysTables.SYS_PAY_CHANNEL.MERCHANT_ID)
                .form().selectBox().queryApi(PayMerchantServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(PayMerchantMeta.ID).textField(PayMerchantMeta.NAME).fillWith(PayChannelMeta.PAY_MERCHANT).muliti(false);

        cfg.view().field(SysTables.SYS_PAY_CHANNEL.APP_ID)
                .form().selectBox().queryApi(PayAppServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(PayAppMeta.ID).textField(PayAppMeta.NAME).fillWith(PayChannelMeta.PAY_APP).muliti(false);


        cfg.view().formWindow().bottomSpace(100);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_PAY_CHANNEL.APP_ID,
                        SysTables.SYS_PAY_CHANNEL.NAME,
                        SysTables.SYS_PAY_CHANNEL.STATUS,
                        SysTables.SYS_PAY_CHANNEL.CODE,
                        SysTables.SYS_PAY_CHANNEL.FEE_RATE,
                        SysTables.SYS_PAY_CHANNEL.CONFIG,
                        SysTables.SYS_PAY_CHANNEL.NOTES,
                }
        );

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
        PayChannelGtr g=new PayChannelGtr();
        //生成代码
        g.generateCode();

        //生成菜单
        //g.removeByBatchId("");
       // g.generateMenu(PayChannelServiceProxy.class, PayChannelPageController.class);
    }


}
