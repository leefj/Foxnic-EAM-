package com.dt.platform.generator.module.oa;

import com.dt.platform.constants.db.OaTables;
import com.dt.platform.constants.enums.oa.CustomerTeamUserRoleEnum;
import com.dt.platform.domain.oa.CrmCustomer;
import com.dt.platform.domain.oa.CrmCustomerTeam;
import com.dt.platform.domain.oa.meta.CrmCustomerLeaderMeta;
import com.dt.platform.domain.oa.meta.CrmCustomerMeta;
import com.dt.platform.domain.oa.meta.CrmCustomerTeamMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.oa.page.CrmCustomerTeamPageController;
import com.dt.platform.proxy.oa.CrmCustomerServiceProxy;
import com.dt.platform.proxy.oa.CrmCustomerTeamServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class CrmCustomerTeamGtr extends BaseCodeGenerator {


    //754084671628771328
    public CrmCustomerTeamGtr() {
        super(OaTables.OA_CRM_CUSTOMER_TEAM.$TABLE,"616265395568902144");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(CrmCustomer.class,"crmCustomer","crmCustomer","crmCustomer");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"user","user","user");


        cfg.view().field(OaTables.OA_CRM_CUSTOMER_TEAM.ID).basic().hidden(true);
        cfg.view().list().disableBatchDelete();
        cfg.view().search().disable();

        cfg.view().field(OaTables.OA_CRM_CUSTOMER_TEAM.ID).table().disable(true);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_TEAM.USER_ROLE).table().disable(true);
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(OaTables.OA_CRM_CUSTOMER_TEAM.CUSTOMER_ID)
                .basic().label("客户")
                .form().selectBox().queryApi(CrmCustomerServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(CrmCustomerMeta.ID).textField(CrmCustomerMeta.NAME).fillWith(CrmCustomerTeamMeta.CRM_CUSTOMER).muliti(false);

        cfg.view().search().rowsDisplay(1);

        cfg.view().field(OaTables.OA_CRM_CUSTOMER_TEAM.USER_ROLE).form().validate().required().form().radioBox().enumType(CustomerTeamUserRoleEnum.class).defaultIndex(0);
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_TEAM.USER_ID).table().fillBy("user","name");
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_TEAM.USER_ID).form().validate().required().form()
                .button().chooseEmployee(true);

        cfg.view().field(OaTables.OA_CRM_CUSTOMER_TEAM.NOTES).form().textArea().height(120);
        cfg.view().form().addJsVariable("CUSTOMER_ID","[[${customerId}]]","customerId");
        cfg.view().list().addJsVariable("CUSTOMER_ID","[[${customerId}]]","customerId");

        cfg.view().formWindow().bottomSpace(80);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_CRM_CUSTOMER_TEAM.USER_ID,
                        OaTables.OA_CRM_CUSTOMER_TEAM.NOTES,
                }
        );
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
        CrmCustomerTeamGtr g=new CrmCustomerTeamGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
     //  g.generateMenu(CrmCustomerTeamServiceProxy.class, CrmCustomerTeamPageController.class);
    }

}
