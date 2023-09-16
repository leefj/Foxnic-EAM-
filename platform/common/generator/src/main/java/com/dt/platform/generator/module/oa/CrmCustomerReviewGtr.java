package com.dt.platform.generator.module.oa;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.OaTables;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.oa.CrmCustomer;
import com.dt.platform.domain.oa.meta.CrmCustomerBusinessMeta;
import com.dt.platform.domain.oa.meta.CrmCustomerMeta;
import com.dt.platform.domain.oa.meta.CrmCustomerReviewMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.oa.page.CrmCustomerReviewPageController;
import com.dt.platform.proxy.oa.CrmCustomerReviewServiceProxy;
import com.dt.platform.proxy.oa.CrmCustomerServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class CrmCustomerReviewGtr extends BaseCodeGenerator {


    //754084671628771328
    public CrmCustomerReviewGtr() {
        super(OaTables.OA_CRM_CUSTOMER_REVIEW.$TABLE,"616265395568902144");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());



        cfg.getPoClassFile().addSimpleProperty(CrmCustomer.class,"crmCustomer","crmCustomer","crmCustomer");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","originator","originator");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"reviewUser","reviewUser","reviewUser");

        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"reviewMethod","reviewMethod","reviewMethod");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"satisfaction","satisfaction","satisfaction");


        cfg.view().field(OaTables.OA_CRM_CUSTOMER_REVIEW.ORIGINATOR_ID).table().fillBy("originator","name");
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_REVIEW.ORIGINATOR_ID).form()
                .button().chooseEmployee(true);

        cfg.view().field(OaTables.OA_CRM_CUSTOMER_REVIEW.REVIEW_USER_ID).table().fillBy("reviewUser","name");
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_REVIEW.REVIEW_USER_ID).form().validate().required().form()
                .button().chooseEmployee(true);


        cfg.view().field(OaTables.OA_CRM_CUSTOMER_REVIEW.ID).basic().hidden(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_REVIEW.ORIGINATOR_ID).basic().hidden(true);

        cfg.view().field(OaTables.OA_CRM_CUSTOMER_REVIEW.NOTES).search().fuzzySearch();
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_REVIEW.NAME).search().fuzzySearch();
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_REVIEW.REVIEW_DATE).form().dateInput().format("yyyy-MM-dd").search().range();


        cfg.view().field(OaTables.OA_CRM_CUSTOMER_REVIEW.CUSTOMER_ID)
                .basic().label("客户")
             .form().selectBox().queryApi(CrmCustomerServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(CrmCustomerMeta.ID).textField(CrmCustomerMeta.NAME).fillWith(CrmCustomerReviewMeta.CRM_CUSTOMER).muliti(false);

        cfg.view().field(OaTables.OA_CRM_CUSTOMER_REVIEW.METHOD_ID)
                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=crm_customer_review_type")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(CrmCustomerReviewMeta.REVIEW_METHOD).muliti(false);


        cfg.view().field(OaTables.OA_CRM_CUSTOMER_REVIEW.SATISFACTION_ID)
                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=crm_customer_satisfaction")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(CrmCustomerReviewMeta.SATISFACTION).muliti(false);


        cfg.view().list().disableBatchDelete();
        cfg.view().search().inputLayout(
                new Object[]{
                        OaTables.OA_CRM_CUSTOMER_REVIEW.NAME,
                        OaTables.OA_CRM_CUSTOMER_REVIEW.NOTES,
                        OaTables.OA_CRM_CUSTOMER_REVIEW.REVIEW_DATE,
                }
        );


        cfg.view().field(OaTables.OA_CRM_CUSTOMER_REVIEW.ID).table().disable(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_REVIEW.NOTES).table().disable(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_REVIEW.ORIGINATOR_ID).table().hidden(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_REVIEW.NOTES).form().textArea().height(120);


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(OaTables.OA_CRM_CUSTOMER_REVIEW.NAME).form().validate().required();
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_REVIEW.REVIEW_DATE).form().validate().required().form().dateInput().type(DatePickerType.date);



        cfg.view().field(OaTables.OA_CRM_CUSTOMER_REVIEW.FILE_ID).table().disable(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_REVIEW.FILE_ID).form().upload().acceptAllType().maxFileCount(6);


        cfg.view().formWindow().bottomSpace(80);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_CRM_CUSTOMER_REVIEW.NAME,
                        OaTables.OA_CRM_CUSTOMER_REVIEW.METHOD_ID,
                        OaTables.OA_CRM_CUSTOMER_REVIEW.SATISFACTION_ID,
                },
                new Object[] {
                        OaTables.OA_CRM_CUSTOMER_REVIEW.REVIEW_USER_ID,
                        OaTables.OA_CRM_CUSTOMER_REVIEW.REVIEW_DATE,

                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_CRM_CUSTOMER_REVIEW.FILE_ID,
                        OaTables.OA_CRM_CUSTOMER_REVIEW.NOTES,
                }
        );



        cfg.view().form().addJsVariable("CUSTOMER_ID","[[${customerId}]]","customerId");
        cfg.view().list().addJsVariable("CUSTOMER_ID","[[${customerId}]]","customerId");


        cfg.view().form().addJsVariable("CUR_EMP_ID","[[${curEmpId}]]","curEmpId");
        cfg.view().form().addJsVariable("CUR_USER_NAME","[[${curUserName}]]","curUserName");

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
        CrmCustomerReviewGtr g=new CrmCustomerReviewGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
    //    g.generateMenu(CrmCustomerReviewServiceProxy.class, CrmCustomerReviewPageController.class);
    }

}
