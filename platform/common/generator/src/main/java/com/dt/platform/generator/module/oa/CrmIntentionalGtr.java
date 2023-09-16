package com.dt.platform.generator.module.oa;

import com.dt.platform.constants.db.OaTables;
import com.dt.platform.domain.oa.CrmCustomerIntentional;
import com.dt.platform.generator.config.Config;
import com.dt.platform.oa.page.CrmCustomerIndustryPageController;
import com.dt.platform.oa.page.CrmCustomerIntentionalPageController;
import com.dt.platform.proxy.oa.CrmCustomerIndustryServiceProxy;
import com.dt.platform.proxy.oa.CrmCustomerIntentionalServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class CrmIntentionalGtr extends BaseCodeGenerator {


    //754084671628771328
    public CrmIntentionalGtr() {
        super(OaTables.OA_CRM_CUSTOMER_INTENTIONAL.$TABLE,"616265527676895232");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());



        cfg.view().field(OaTables.OA_CRM_CUSTOMER_INTENTIONAL.ID).basic().hidden(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_INTENTIONAL.NAME).search().fuzzySearch();

        cfg.view().list().disableBatchDelete();

        cfg.view().search().inputLayout(
                new Object[]{
                        OaTables.OA_CRM_CUSTOMER_INTENTIONAL.NAME,
                }
        );

        cfg.view().field(OaTables.OA_CRM_CUSTOMER_INTENTIONAL.ID).table().disable(true);


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_INTENTIONAL.NAME).form().validate().required();
        cfg.view().formWindow().bottomSpace(50);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_CRM_CUSTOMER_INTENTIONAL.NAME,
                        OaTables.OA_CRM_CUSTOMER_INTENTIONAL.NOTES
                }
        );
        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        CrmIntentionalGtr g=new CrmIntentionalGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
     //  g.generateMenu(CrmCustomerIntentionalServiceProxy.class, CrmCustomerIntentionalPageController.class);
    }

}
