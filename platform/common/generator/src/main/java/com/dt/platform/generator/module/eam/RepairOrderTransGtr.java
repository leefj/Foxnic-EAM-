package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.eam.RepairOrderStatusEnum;
import com.dt.platform.constants.enums.eam.RepairOrderTypeEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.eam.page.RepairOrderTranserPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.meta.PersonMeta;

public class RepairOrderTransGtr extends BaseCodeGenerator{
    public RepairOrderTransGtr() {
        super(EAMTables.EAM_REPAIR_ORDER_TRANSER.$TABLE,"568078396299415552");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());




        cfg.getPoClassFile().addSimpleProperty(RepairOrder.class,"order","维修申请","维修申请");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"executor","执行人","执行人");
        cfg.getPoClassFile().addSimpleProperty(RepairGroup.class,"repairGroup","维修班组","维修班组");


        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_TRANSER.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_TRANSER.ID).table().hidden(true);


        cfg.view().list().operationColumn().width(120);
        cfg.view().formWindow().width("98%");
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_REPAIR_ORDER_TRANSER.GROUP_ID,
                        EAMTables.EAM_REPAIR_ORDER_TRANSER.EXECUTOR_ID,
                }

        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().list().disableBatchDelete();

        cfg.view().list().disableCreateNew();
        cfg.view().list().operationColumn().width(300);


        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_TRANSER.GROUP_ID)
                .form().validate().required().form().selectBox().queryApi(RepairGroupServiceProxy.QUERY_LIST)
                .paging(false).filter(true).toolbar(false)
                .valueField(RepairGroupMeta.ID).
                textField(RepairGroupMeta.NAME).
                fillWith(RepairOrderTranserMeta.REPAIR_GROUP).muliti(false).defaultIndex(0);

        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_TRANSER.EXECUTOR_ID)
                .form().selectBox().queryApi(GroupUserServiceProxy.QUERY_EMPLOYEE_PERSON)
                .paging(false).filter(false).toolbar(false)
                .valueField("employeeId").
                textField(PersonMeta.NAME).
                fillWith(RepairOrderTranserMeta.EXECUTOR).muliti(false);

        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_TRANSER.NOTES).form().textArea().height(Config.textAreaHeight);

        cfg.view().form().addJsVariable("ORDER_ID","[[${orderId}]]","工单");

        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_REPAIR_ORDER_TRANSER.GROUP_ID,
                },
                new Object[] {
                        EAMTables.EAM_REPAIR_ORDER_TRANSER.EXECUTOR_ID,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_REPAIR_ORDER_TRANSER.NOTES,
                }
        );




        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        RepairOrderTransGtr g=new RepairOrderTransGtr();
        //生成代码
         g.generateCode();


        //生成菜单
       //   g.removeByBatchId("583540584287830016");
       // g.generateMenu(RepairOrderTranserServiceProxy.class, RepairOrderTranserPageController.class);
    }
}
