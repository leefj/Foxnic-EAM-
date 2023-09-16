package com.dt.platform.generator.module.oa;

import com.dt.platform.constants.db.OaTables;
import com.dt.platform.constants.enums.oa.CustomerLockStatusEnum;
import com.dt.platform.constants.enums.oa.CustomerRolePosEnum;
import com.dt.platform.constants.enums.oa.TransactionStatusEnum;
import com.dt.platform.domain.oa.*;
import com.dt.platform.domain.oa.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.oa.page.CrmCustomerIndustryPageController;
import com.dt.platform.oa.page.CrmCustomerPageController;
import com.dt.platform.proxy.oa.*;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class CrmCustomerGtr extends BaseCodeGenerator {


    //754084671628771328
    public CrmCustomerGtr() {
        super(OaTables.OA_CRM_CUSTOMER.$TABLE,"616265395568902144");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","originator","originator");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"owner","owner","owner");

        cfg.getPoClassFile().addListProperty(CrmCustomerLeader.class,"crmCustomerLeaderList","crmCustomerLeaderList","crmCustomerLeaderList");
        cfg.getPoClassFile().addListProperty(CrmCustomerBusiness.class,"crmCustomerBusinessList","crmCustomerBusinessList","crmCustomerLeaderList");
        cfg.getPoClassFile().addListProperty(CrmCustomerContact.class,"crmCustomerContactList","crmCustomerContactList","crmCustomerLeaderList");
        cfg.getPoClassFile().addListProperty(CrmCustomerReview.class,"crmCustomerReviewList","crmCustomerReviewList","crmCustomerReviewList");
        cfg.getPoClassFile().addListProperty(CrmCustomerRecord.class,"crmCustomerRecordList","crmCustomerRecordList","crmCustomerRecordList");
        cfg.getPoClassFile().addListProperty(CrmCustomerFollow.class,"crmCustomerFollowList","crmCustomerFollowList","crmCustomerRecordList");
        cfg.getPoClassFile().addSimpleProperty(CrmCustomerContact.class,"crmFirstCustomerContact","crmFirstCustomerContact","crmFirstCustomerContact");

        cfg.getPoClassFile().addSimpleProperty(CrmCustomerIndustry.class,"crmCustomerIndustry","crmCustomerIndustry","crmCustomerIndustry");
        cfg.getPoClassFile().addSimpleProperty(CrmCustomerIntentional.class,"crmCustomerIntentional","crmCustomerIntentional","crmCustomerIntentional");
        cfg.getPoClassFile().addSimpleProperty(CrmCustomerLevel.class,"crmCustomerLevel","crmCustomerLevel","crmCustomerLevel");
        cfg.getPoClassFile().addSimpleProperty(CrmCustomerSource.class,"crmCustomerSource","crmCustomerSource","crmCustomerSource");

        cfg.getPoClassFile().addSimpleProperty(String.class,"searchCustomerType","searchCustomerType","searchCustomerType");

        cfg.view().search().rowsDisplay(1);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER.OWNER_ID).table().fillBy("owner","name");
        cfg.view().field(OaTables.OA_CRM_CUSTOMER.OWNER_ID).form().readOnly()
                .button().chooseEmployee(true);


        cfg.view().field(OaTables.OA_CRM_CUSTOMER.ORIGINATOR_ID).table().fillBy("originator","name");
        cfg.view().field(OaTables.OA_CRM_CUSTOMER.ORIGINATOR_ID).form()
                .button().chooseEmployee(true);


        cfg.view().field(OaTables.OA_CRM_CUSTOMER.RECENT_FOLLOW_TIME).form().dateInput().format("yyyy-MM-dd").type(DatePickerType.date).search().range();
        cfg.view().field(OaTables.OA_CRM_CUSTOMER.NEXT_FOLLOW_TIME).form().dateInput().format("yyyy-MM-dd").type(DatePickerType.date).search().range();
        cfg.view().field(OaTables.OA_CRM_CUSTOMER.TRANSACTION_STATUS).form().radioBox().enumType(TransactionStatusEnum.class);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER.LOCKED).form().radioBox().enumType(CustomerLockStatusEnum.class);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER.ROLE_POS).form().radioBox().enumType(CustomerRolePosEnum.class);

        cfg.view().field(OaTables.OA_CRM_CUSTOMER.ID).basic().hidden(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER.NAME).search().fuzzySearch();
        cfg.view().field(OaTables.OA_CRM_CUSTOMER.RECENT_FOLLOW_TIME).search().range();
        cfg.view().list().disableBatchDelete();

        cfg.view().search().inputLayout(
                new Object[]{
                        OaTables.OA_CRM_CUSTOMER.NAME,
                        OaTables.OA_CRM_CUSTOMER.LEVEL,
                        OaTables.OA_CRM_CUSTOMER.INTENTIONAL_STATE,
                        OaTables.OA_CRM_CUSTOMER.INDUSTRY_ID,

                },
                new Object[]{
                        OaTables.OA_CRM_CUSTOMER.SOURCE_ID,
                        OaTables.OA_CRM_CUSTOMER.OWNER_ID,
                        OaTables.OA_CRM_CUSTOMER.RECENT_FOLLOW_TIME,

                }
        );


        cfg.view().field(OaTables.OA_CRM_CUSTOMER.LEVEL)
                .form().validate().required().form().selectBox().queryApi(CrmCustomerLevelServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(CrmCustomerLevelMeta.ID).textField(CrmCustomerLevelMeta.NAME).fillWith(CrmCustomerLeadsMeta.CRM_CUSTOMER_LEVEL).muliti(false);

        cfg.view().field(OaTables.OA_CRM_CUSTOMER.SOURCE_ID)
                .form().validate().required().form().selectBox().queryApi(CrmCustomerSourceServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(CrmCustomerSourceMeta.ID).textField(CrmCustomerSourceMeta.NAME).fillWith(CrmCustomerLeadsMeta.CRM_CUSTOMER_SOURCE).muliti(false);

        cfg.view().field(OaTables.OA_CRM_CUSTOMER.INDUSTRY_ID)
                .form().validate().required().form().selectBox().queryApi(CrmCustomerIndustryServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(CrmCustomerIndustryMeta.ID).textField(CrmCustomerIndustryMeta.NAME).fillWith(CrmCustomerLeadsMeta.CRM_CUSTOMER_INDUSTRY).muliti(false);

        cfg.view().field(OaTables.OA_CRM_CUSTOMER.INTENTIONAL_STATE)
                .form().selectBox().queryApi(CrmCustomerIntentionalServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(CrmCustomerIntentionalMeta.ID).textField(CrmCustomerIntentionalMeta.NAME).fillWith(CrmCustomerLeadsMeta.CRM_CUSTOMER_INTENTIONAL).muliti(false);



        cfg.view().field(OaTables.OA_CRM_CUSTOMER.ID).table().disable(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER.PROFILE).table().disable(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER.NOTES).table().disable(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER.WEBSITE).table().disable(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER.INTENTIONAL_STATE).table().disable(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER.ADDRESS).table().disable(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER.CREATE_TIME).table().disable(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER.ROLE_POS).table().disable(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER.NEXT_FOLLOW_TIME).table().hidden(true);

        cfg.view().field(OaTables.OA_CRM_CUSTOMER.ORIGINATOR_ID).table().hidden(true);
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER.NAME).form().validate().required();
        cfg.view().field(OaTables.OA_CRM_CUSTOMER.NOTES).form().textArea().height(120);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER.PROFILE).form().textArea().height(120);
        cfg.view().formWindow().bottomSpace(50);
        cfg.view().formWindow().width(Config.baseFormWidth);

        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_CRM_CUSTOMER.NAME,
                        OaTables.OA_CRM_CUSTOMER.INDUSTRY_ID,
                        OaTables.OA_CRM_CUSTOMER.LEVEL,
                        OaTables.OA_CRM_CUSTOMER.INTENTIONAL_STATE,
                },
                new Object[] {
                        OaTables.OA_CRM_CUSTOMER.SOURCE_ID,
                        OaTables.OA_CRM_CUSTOMER.OWNER_ID,
                        OaTables.OA_CRM_CUSTOMER.CONTACTS,
                        OaTables.OA_CRM_CUSTOMER.CONTACT_INFO,

                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_CRM_CUSTOMER.WEBSITE,
                        OaTables.OA_CRM_CUSTOMER.ADDRESS,
                        OaTables.OA_CRM_CUSTOMER.PROFILE,
                        OaTables.OA_CRM_CUSTOMER.NOTES,
                }
        );




        cfg.view().list().addToolButton("批量分配","batchAllocate","to-batch-allocate-button","oa_crm_customer:batch_allocate");
        cfg.view().list().addToolButton("批量移交","batchTransfer","batch-transfer-button","oa_crm_customer:bath_transfer");
//        cfg.view().list().addToolButton("分享给用户","shareCustomer","share-customer-button","oa_crm_customer:shareuser");
//        cfg.view().list().addToolButton("转无效客户","toInvalid","to-invalid-button","oa_crm_customer:invalid");
//        cfg.view().list().addToolButton("转入公海","toOpenSea","to-opensea-button","oa_crm_customer:opensea");
        cfg.view().list().operationColumn().addActionButton("跟进","followup","followup-button","oa_crm_customer:followup");
        cfg.view().list().operationColumn().addActionButton("领用","collect","collect-button","oa_crm_customer:collect");


        cfg.view().list().operationColumn().addActionButton("取消关注","cancelCare","cancel-care");


        cfg.view().list().operationColumn().addActionMenu("review","回访","oa_crm_customer:review");
        cfg.view().list().operationColumn().addActionMenu("business","商机","oa_crm_customer:business");
        cfg.view().list().operationColumn().addActionMenu("deal","成交","oa_crm_customer:deal");
        cfg.view().list().operationColumn().addActionMenu("lock","锁定","oa_crm_customer:lock");
        cfg.view().list().operationColumn().addActionMenu("unlock","解锁","oa_crm_customer:unlock");
        cfg.view().list().operationColumn().addActionMenu("transfer","移交","oa_crm_customer:transfer");
        cfg.view().list().operationColumn().addActionMenu("shareuser","共享成员","oa_crm_customer:shareuser");
        cfg.view().list().operationColumn().addActionMenu("care","关注");
        cfg.view().list().operationColumn().addActionMenu("toinvalid","转无效客户","oa_crm_customer:invalid");
        cfg.view().list().operationColumn().addActionMenu("opensean","转入公海","oa_crm_customer:opensea");


        cfg.view().list().addJsVariable("TAB_STATUS","[[${tabStatus}]]","tabStatus");
        cfg.view().form().addJsVariable("CUR_EMP_ID","[[${curEmpId}]]","curEmpId");
        cfg.view().form().addJsVariable("CUR_USER_NAME","[[${curUserName}]]","curUserName");

        cfg.view().form().addJsVariable("ROLE_POS","[[${rolePos}]]","rolePos");


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
        CrmCustomerGtr g=new CrmCustomerGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
     //   g.generateMenu(CrmCustomerServiceProxy.class, CrmCustomerPageController.class);
    }

}
