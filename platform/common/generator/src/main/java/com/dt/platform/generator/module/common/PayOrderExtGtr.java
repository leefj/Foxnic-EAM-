package com.dt.platform.generator.module.common;

import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.common.PayChannel;
import com.dt.platform.domain.common.PayOrder;
import com.dt.platform.domain.common.PayOrderExt;
import com.dt.platform.domain.common.meta.PayAppMeta;
import com.dt.platform.domain.common.meta.PayChannelMeta;
import com.dt.platform.domain.common.meta.PayOrderExtMeta;
import com.dt.platform.domain.common.meta.PayOrderMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.PayAppServiceProxy;
import com.dt.platform.proxy.common.PayOrderServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class PayOrderExtGtr extends BaseCodeGenerator{
    public PayOrderExtGtr() {
        super(SysTables.SYS_PAY_ORDER_EXT.$TABLE,"728502379380473856");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(PayOrder.class,"payOrder","payOrder","payOrder");


        cfg.view().field(SysTables.SYS_PAY_ORDER_EXT.ID).basic().hidden(true);

        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_PAY_ORDER_EXT.ORDER_ID,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(SysTables.SYS_PAY_ORDER_EXT.ORDER_ID)
                .form().selectBox().queryApi(PayOrderServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(PayOrderMeta.ID).textField(PayOrderMeta.SUBJECT).fillWith(PayOrderExtMeta.PAY_ORDER).muliti(false);

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
        PayOrderExtGtr g=new PayOrderExtGtr();
        //生成代码
        g.generateCode();

        //生成菜单
        //g.removeByBatchId("");

    }


}
