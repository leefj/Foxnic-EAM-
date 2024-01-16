package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.eam.WorkOrderResultStatusEnum;
import com.dt.platform.constants.enums.hr.ApprovalResultStatusEnum;
import com.dt.platform.constants.enums.hr.ApprovalStatusEnum;
import com.dt.platform.domain.hr.PersonApprovalRcd;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.PersonApprovalRcdPageController;
import com.dt.platform.proxy.hr.PersonApprovalRcdServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;


public class HrmPersonApproveRcdGtr extends BaseCodeGenerator {
    public HrmPersonApproveRcdGtr() {
        super(HrTables.HR_PERSON_APPROVAL_RCD.$TABLE,"766183428553965568");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"operUser","operUser","operUser");
        cfg.getPoClassFile().addListProperty(String.class,"itemIds","itemIds","itemIds");
        cfg.view().field(HrTables.HR_PERSON_APPROVAL_RCD.ID).basic().hidden(true);

        cfg.view().search().disable();

        cfg.view().search().rowsDisplay(1);
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(HrTables.HR_PERSON_APPROVAL_RCD.OPER_USER_ID).table().fillBy("operUser","name");
        cfg.view().field(HrTables.HR_PERSON_APPROVAL_RCD.RESULT).form().validate().required().form().radioBox().enumType(ApprovalResultStatusEnum.class).defaultIndex(0);
        cfg.view().field(HrTables.HR_PERSON_APPROVAL_RCD.CONTENT).form().textArea().height(120);

        cfg.view().field(HrTables.HR_PERSON_APPROVAL_RCD.CREATE_TIME).table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_APPROVAL_RCD.UPDATE_TIME).table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_APPROVAL_RCD.UPDATE_BY).table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_APPROVAL_RCD.CREATE_BY).table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_APPROVAL_RCD.TYPE).table().disable(true);

        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width("65%");;
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup(null,
                new Object[]{
                        HrTables.HR_PERSON_APPROVAL_RCD.RESULT,
                        HrTables.HR_PERSON_APPROVAL_RCD.CONTENT,
                }
        );


        cfg.view().form().addJsVariable("ITEM_IDS","[[${itemIds}]]","itemIds");
        cfg.view().form().addJsVariable("TYPE","[[${type}]]","type");
        cfg.view().form().addJsVariable("ITEM_FLAG","[[${itemFlag}]]","itemFlag");

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
                .setExtendJsFile(WriteMode.IGNORE);
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        HrmPersonApproveRcdGtr g=new HrmPersonApproveRcdGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
        //
        // g.generateMenu(PersonApprovalRcdServiceProxy.class, PersonApprovalRcdPageController.class);
    }
}
