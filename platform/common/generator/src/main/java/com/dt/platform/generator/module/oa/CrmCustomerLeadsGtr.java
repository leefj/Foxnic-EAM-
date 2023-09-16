package com.dt.platform.generator.module.oa;

import com.dt.platform.constants.db.OaTables;
import com.dt.platform.domain.oa.*;
import com.dt.platform.domain.oa.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.oa.*;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class CrmCustomerLeadsGtr extends BaseCodeGenerator {


    //754084671628771328
    public CrmCustomerLeadsGtr() {
        super(OaTables.OA_CRM_CUSTOMER_LEADS.$TABLE,"616265395568902144");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(CrmCustomer.class,"crmCustomer","crmCustomer","crmCustomer");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","originator","originator");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"owner","owner","owner");



        cfg.getPoClassFile().addSimpleProperty(CrmCustomerIndustry.class,"crmCustomerIndustry","crmCustomerIndustry","crmCustomerIndustry");
        cfg.getPoClassFile().addSimpleProperty(CrmCustomerIntentional.class,"crmCustomerIntentional","crmCustomerIntentional","crmCustomerIntentional");
        cfg.getPoClassFile().addSimpleProperty(CrmCustomerLevel.class,"crmCustomerLevel","crmCustomerLevel","crmCustomerLevel");
        cfg.getPoClassFile().addSimpleProperty(CrmCustomerSource.class,"crmCustomerSource","crmCustomerSource","crmCustomerSource");

        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADS.RECENT_FOLLOW_TIME).form().dateInput().format("yyyy-MM-dd").type(DatePickerType.date).search().range();
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADS.NEXT_FOLLOW_TIME).form().dateInput().format("yyyy-MM-dd").type(DatePickerType.date).search().range();

        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADS.OWNER_ID).table().fillBy("owner","name");
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADS.OWNER_ID).form()
                .button().chooseEmployee(true);



        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADS.ORIGINATOR_ID).table().fillBy("originator","name");
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADS.ORIGINATOR_ID).form()
                .button().chooseEmployee(true);


        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADS.LEVEL)
                .form().validate().required().form().selectBox().queryApi(CrmCustomerLevelServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(CrmCustomerLevelMeta.ID).textField(CrmCustomerLevelMeta.NAME).fillWith(CrmCustomerLeadsMeta.CRM_CUSTOMER_LEVEL).muliti(false);

        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADS.SOURCE_ID)
                .form().validate().required().form().selectBox().queryApi(CrmCustomerSourceServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(CrmCustomerSourceMeta.ID).textField(CrmCustomerSourceMeta.NAME).fillWith(CrmCustomerLeadsMeta.CRM_CUSTOMER_SOURCE).muliti(false);

        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADS.INDUSTRY_ID)
                .form().validate().required().form().selectBox().queryApi(CrmCustomerIndustryServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(CrmCustomerIndustryMeta.ID).textField(CrmCustomerIndustryMeta.NAME).fillWith(CrmCustomerLeadsMeta.CRM_CUSTOMER_INDUSTRY).muliti(false);

        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADS.INTENTIONAL_STATE)
                .form().selectBox().queryApi(CrmCustomerIntentionalServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(CrmCustomerIntentionalMeta.ID).textField(CrmCustomerIntentionalMeta.NAME).fillWith(CrmCustomerLeadsMeta.CRM_CUSTOMER_INTENTIONAL).muliti(false);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADS.NOTES).form().textArea().height(120);



        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADS.ID).table().disable(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADS.OWNER_ID).table().disable(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADS.NOTES).table().disable(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADS.WEBSITE).table().disable(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADS.ADDRESS).table().disable(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADS.ORIGINATOR_ID).table().hidden(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADS.NEXT_FOLLOW_TIME).table().disable(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADS.RECENT_FOLLOW_TIME).table().disable(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADS.ID).table().disable(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADS.NOTES).table().disable(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADS.ORIGINATOR_ID).table().hidden(true);


        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADS.ID).basic().hidden(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADS.NAME).search().fuzzySearch();
        cfg.view().list().disableBatchDelete();
        cfg.view().search().inputLayout(
                new Object[]{
                        OaTables.OA_CRM_CUSTOMER_LEADS.NAME,
                        OaTables.OA_CRM_CUSTOMER_LEADS.LEVEL,
                        OaTables.OA_CRM_CUSTOMER_LEADS.INDUSTRY_ID,
                        OaTables.OA_CRM_CUSTOMER_LEADS.SOURCE_ID,
                }
        );
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADS.NAME).form().validate().required();
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADS.NOTES).form().textArea().height(120);



        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(OaTables.OA_CRM_CUSTOMER_CONTACT.NAME).form().validate().required();

        cfg.view().formWindow().bottomSpace(50);

        cfg.view().formWindow().width(Config.baseFormWidth);


        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_CRM_CUSTOMER_LEADS.NAME,
                        OaTables.OA_CRM_CUSTOMER_LEADS.INDUSTRY_ID,
                        OaTables.OA_CRM_CUSTOMER_LEADS.LEVEL,
                        OaTables.OA_CRM_CUSTOMER_LEADS.INTENTIONAL_STATE,
                },
                new Object[] {
                        OaTables.OA_CRM_CUSTOMER_LEADS.SOURCE_ID,
                        OaTables.OA_CRM_CUSTOMER_LEADS.OWNER_ID,
                        OaTables.OA_CRM_CUSTOMER_LEADS.CONTACTS,
                        OaTables.OA_CRM_CUSTOMER_LEADS.CONTACT_INFO,

                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_CRM_CUSTOMER_LEADS.WEBSITE,
                        OaTables.OA_CRM_CUSTOMER_LEADS.ADDRESS,
                        OaTables.OA_CRM_CUSTOMER_LEADS.NOTES,
                }
        );
        cfg.view().list().operationColumn().addActionButton("转客户","toCustomer","to-customer-button");

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
        CrmCustomerLeadsGtr g=new CrmCustomerLeadsGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
      //  g.generateMenu(CrmCustomerLeadsServiceProxy.class, CrmCustomerLeadsPageController.class);
    }

}
