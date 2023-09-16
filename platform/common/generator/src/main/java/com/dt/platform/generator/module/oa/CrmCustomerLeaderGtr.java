package com.dt.platform.generator.module.oa;

import com.dt.platform.constants.db.OaTables;
import com.dt.platform.domain.oa.CrmCustomer;
import com.dt.platform.domain.oa.CrmCustomerLeader;
import com.dt.platform.domain.oa.meta.CrmCustomerContactMeta;
import com.dt.platform.domain.oa.meta.CrmCustomerLeaderMeta;
import com.dt.platform.domain.oa.meta.CrmCustomerMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.oa.page.CrmCustomerLeaderPageController;
import com.dt.platform.proxy.oa.CrmCustomerLeaderServiceProxy;
import com.dt.platform.proxy.oa.CrmCustomerServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class CrmCustomerLeaderGtr extends BaseCodeGenerator {


    //754084671628771328
    public CrmCustomerLeaderGtr() {
        super(OaTables.OA_CRM_CUSTOMER_LEADER.$TABLE,"616265395568902144");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(Employee.class,"user","user","user");


        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADER.ID).basic().hidden(true);
        cfg.view().list().disableBatchDelete();
        cfg.view().search().disable();

        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADER.ID).table().disable(true);
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().form().addJsVariable("CUSTOMER_IDS","[[${customerIds}]]","customerIds");

        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADER.USER_ID).table().fillBy("user","name");
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_LEADER.USER_ID).form().validate().required().form()
                .button().chooseEmployee(true);
        cfg.view().formWindow().bottomSpace(50);

        cfg.view().formWindow().width(Config.baseFormWidth_50);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_CRM_CUSTOMER_LEADER.USER_ID,
                }
        );
        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.IGNORE) //IGNORE
                .setListPage(WriteMode.IGNORE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        CrmCustomerLeaderGtr g=new CrmCustomerLeaderGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
  //      g.generateMenu(CrmCustomerLeaderServiceProxy.class, CrmCustomerLeaderPageController.class);
    }

}
