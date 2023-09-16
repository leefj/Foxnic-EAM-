package com.dt.platform.generator.module.oa;

import com.dt.platform.constants.db.OaTables;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class CrmCustomerCareGtr extends BaseCodeGenerator {


    //754084671628771328
    public CrmCustomerCareGtr() {
        super(OaTables.OA_CRM_CUSTOMER_CARE.$TABLE,"616265395568902144");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(Employee.class,"user","user","user");


        cfg.view().field(OaTables.OA_CRM_CUSTOMER_CARE.ID).basic().hidden(true);
        cfg.view().list().disableBatchDelete();
        cfg.view().search().disable();

        cfg.view().field(OaTables.OA_CRM_CUSTOMER_CARE.ID).table().disable(true);
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);



        cfg.view().field(OaTables.OA_CRM_CUSTOMER_CARE.USER_ID).table().fillBy("user","name");
        cfg.view().field(OaTables.OA_CRM_CUSTOMER_CARE.USER_ID).form().validate().required().form()
                .button().chooseEmployee(true);
        cfg.view().formWindow().bottomSpace(50);

        cfg.view().formWindow().width(Config.baseFormWidth_50);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_CRM_CUSTOMER_CARE.USER_ID,
                }
        );
        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //IGNORE
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        CrmCustomerCareGtr g=new CrmCustomerCareGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
  //      g.generateMenu(CrmCustomerLeaderServiceProxy.class, CrmCustomerLeaderPageController.class);
    }

}
