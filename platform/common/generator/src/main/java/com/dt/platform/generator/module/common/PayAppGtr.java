package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.PayAppPageController;
import com.dt.platform.common.page.TestPageController;
import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.common.ValidStatusEnum;
import com.dt.platform.domain.common.PayApp;
import com.dt.platform.domain.common.PayMerchant;
import com.dt.platform.domain.common.meta.CodeRuleMeta;
import com.dt.platform.domain.common.meta.PayAppMeta;
import com.dt.platform.domain.common.meta.PayMerchantMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.PayAppServiceProxy;
import com.dt.platform.proxy.common.PayMerchantServiceProxy;
import com.dt.platform.proxy.common.TestServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.meta.MenuMeta;
import org.github.foxnic.web.proxy.oauth.MenuServiceProxy;

public class PayAppGtr extends BaseCodeGenerator{
    public PayAppGtr() {
        super(SysTables.SYS_PAY_APP.$TABLE,"728502379380473856");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(PayMerchant.class,"payMerchant","payMerchant","payMerchant");

        cfg.view().field(SysTables.SYS_PAY_APP.ID).basic().hidden(true);
        cfg.view().field(SysTables.SYS_PAY_APP.NOTES).search().fuzzySearch();
        cfg.view().field(SysTables.SYS_PAY_APP.NAME).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_PAY_APP.STATUS,
                        SysTables.SYS_PAY_APP.MERCHANT_ID,
                        SysTables.SYS_PAY_APP.NAME,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(SysTables.SYS_PAY_APP.NAME).form().validate().required();
        cfg.view().field(SysTables.SYS_PAY_APP.STATUS).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);
        cfg.view().field(SysTables.SYS_PAY_APP.PAY_NOTIFY_URL).form().textArea().height(100);
        cfg.view().field(SysTables.SYS_PAY_APP.REFUND_NOTIFY_URL).form().textArea().height(100);
        cfg.view().field(SysTables.SYS_PAY_APP.NOTES).form().textArea().height(150);

        cfg.view().field(SysTables.SYS_PAY_APP.MERCHANT_ID)
                .form().validate().required()
                .form().selectBox().queryApi(PayMerchantServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(PayMerchantMeta.ID).textField(PayMerchantMeta.NAME).fillWith(PayAppMeta.PAY_MERCHANT).muliti(false);


        cfg.view().formWindow().bottomSpace(100);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_PAY_APP.CODE,
                        SysTables.SYS_PAY_APP.NAME,
                        SysTables.SYS_PAY_APP.MERCHANT_ID,
                        SysTables.SYS_PAY_APP.STATUS,
                        SysTables.SYS_PAY_APP.PAY_NOTIFY_URL,
                        SysTables.SYS_PAY_APP.REFUND_NOTIFY_URL,
                        SysTables.SYS_PAY_APP.NOTES,
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
        PayAppGtr g=new PayAppGtr();
        //生成代码
        g.generateCode();


        //生成菜单
        //g.removeByBatchId("");
       // g.generateMenu(PayAppServiceProxy.class, PayAppPageController.class);
    }


}
