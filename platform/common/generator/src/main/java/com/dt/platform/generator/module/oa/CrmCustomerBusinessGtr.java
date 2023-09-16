package com.dt.platform.generator.module.oa;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.OaTables;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.eam.meta.GoodsStockMeta;
import com.dt.platform.domain.oa.*;
import com.dt.platform.domain.oa.meta.CrmCustomerBusinessMeta;
import com.dt.platform.domain.oa.meta.CrmCustomerMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.oa.page.CrmCustomerBusinessPageController;
import com.dt.platform.oa.page.CrmCustomerReviewPageController;
import com.dt.platform.proxy.eam.GoodsStockServiceProxy;
import com.dt.platform.proxy.oa.CrmCustomerBusinessServiceProxy;
import com.dt.platform.proxy.oa.CrmCustomerReviewServiceProxy;
import com.dt.platform.proxy.oa.CrmCustomerServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class CrmCustomerBusinessGtr extends BaseCodeGenerator {


    //754084671628771328
    public CrmCustomerBusinessGtr() {
        super(OaTables.OA_CRM_CUSTOMER_BUSINESS.$TABLE,"616265395568902144");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(CrmCustomer.class,"crmCustomer","crmCustomer","crmCustomer");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","originator","originator");


        cfg.view().field(OaTables.OA_CRM_CUSTOMER_BUSINESS.ID).basic().hidden(true);



        cfg.view().field(OaTables.OA_CRM_CUSTOMER_BUSINESS.NOTES).search().fuzzySearch();
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_BUSINESS.CONTENT).search().fuzzySearch();



        cfg.view().field(OaTables.OA_CRM_CUSTOMER_BUSINESS.CUSTOMER_ID)
                .basic().label("客户")
                .form().selectBox().queryApi(CrmCustomerServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(CrmCustomerMeta.ID).textField(CrmCustomerMeta.NAME).fillWith(CrmCustomerBusinessMeta.CRM_CUSTOMER).muliti(false);

        cfg.view().field(OaTables.OA_CRM_CUSTOMER_BUSINESS.AMOUNT).form().numberInput().scale(2).defaultValue(0.0);

        cfg.view().field(OaTables.OA_CRM_CUSTOMER_BUSINESS.NOTES).form().textArea().height(120);

        cfg.view().field(OaTables.OA_CRM_CUSTOMER_BUSINESS.ORIGINATOR_ID).table().fillBy("originator","name");
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_BUSINESS.ORIGINATOR_ID).form()
                .button().chooseEmployee(true);
        cfg.view().list().disableBatchDelete();

        cfg.view().search().inputLayout(
                new Object[]{
                        OaTables.OA_CRM_CUSTOMER_BUSINESS.CUSTOMER_ID,
                        OaTables.OA_CRM_CUSTOMER_BUSINESS.CONTENT,
                        OaTables.OA_CRM_CUSTOMER_BUSINESS.NOTES

                }
        );



        cfg.view().field(OaTables.OA_CRM_CUSTOMER_BUSINESS.ID).table().disable(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_BUSINESS.NOTES).table().disable(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_BUSINESS.ORIGINATOR_ID).table().hidden(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_BUSINESS.FILE_ID).table().disable(true);

        cfg.view().field(OaTables.OA_CRM_CUSTOMER_BUSINESS.FILE_ID).form().upload().acceptAllType().maxFileCount(6);


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(OaTables.OA_CRM_CUSTOMER_BUSINESS.CONTENT).form().validate().required();

        cfg.view().formWindow().bottomSpace(80);

        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_CRM_CUSTOMER_BUSINESS.CONTENT,
                        OaTables.OA_CRM_CUSTOMER_BUSINESS.STAGE,
                        OaTables.OA_CRM_CUSTOMER_BUSINESS.AMOUNT,
                        OaTables.OA_CRM_CUSTOMER_BUSINESS.FILE_ID,
                        OaTables.OA_CRM_CUSTOMER_BUSINESS.NOTES,
                }
        );

        cfg.view().form().addJsVariable("CUSTOMER_ID","[[${customerId}]]","customerId");
        cfg.view().list().addJsVariable("CUSTOMER_ID","[[${customerId}]]","customerId");


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        CrmCustomerBusinessGtr g=new CrmCustomerBusinessGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
       // g.generateMenu(CrmCustomerBusinessServiceProxy.class, CrmCustomerBusinessPageController.class);
    }

}
