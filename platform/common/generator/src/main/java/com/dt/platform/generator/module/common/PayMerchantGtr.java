package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.PayAppPageController;
import com.dt.platform.common.page.PayMerchantPageController;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.PayAppServiceProxy;
import com.dt.platform.proxy.common.PayMerchantServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class PayMerchantGtr extends BaseCodeGenerator{
    public PayMerchantGtr() {
        super(SysTables.SYS_PAY_MERCHANT.$TABLE,"728502379380473856");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(SysTables.SYS_PAY_MERCHANT.ID).basic().hidden(true);
        cfg.view().field(SysTables.SYS_PAY_MERCHANT.NOTES).search().fuzzySearch();
        cfg.view().field(SysTables.SYS_PAY_MERCHANT.NAME).search().fuzzySearch();
        cfg.view().field(SysTables.SYS_PAY_MERCHANT.NUMBER).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_PAY_MERCHANT.NUMBER,
                        SysTables.SYS_PAY_MERCHANT.NAME,

                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(SysTables.SYS_PAY_MERCHANT.NAME).form().validate().required();
        cfg.view().field(SysTables.SYS_PAY_MERCHANT.NOTES).form().textArea().height(120);
        cfg.view().field(SysTables.SYS_PAY_MERCHANT.STATUS).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);



        cfg.view().formWindow().bottomSpace(100);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_PAY_MERCHANT.STATUS,
                        SysTables.SYS_PAY_MERCHANT.NAME,
                },
                new Object[]{
                        SysTables.SYS_PAY_MERCHANT.NUMBER,
                        SysTables.SYS_PAY_MERCHANT.SHORT_NAME
                }

        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_PAY_MERCHANT.NOTES,
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
        PayMerchantGtr g=new PayMerchantGtr();
        //生成代码
        g.generateCode();

        //生成菜单
        //g.removeByBatchId("");
        //g.generateMenu(PayMerchantServiceProxy.class, PayMerchantPageController.class);
    }


}
