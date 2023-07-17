package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.RepairGroup;
import com.dt.platform.domain.eam.RepairOrder;
import com.dt.platform.domain.eam.meta.RepairGroupMeta;
import com.dt.platform.domain.eam.meta.RepairOrderTranserMeta;
import com.dt.platform.domain.eam.meta.RepairOrderTransferMeta;
import com.dt.platform.eam.page.RepairOrderTransferPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.GroupUserServiceProxy;
import com.dt.platform.proxy.eam.RepairGroupServiceProxy;
import com.dt.platform.proxy.eam.RepairOrderTransferServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.meta.PersonMeta;

public class RepairOrderTransFerGtr extends BaseCodeGenerator{
    public RepairOrderTransFerGtr() {
        super(EAMTables.EAM_REPAIR_ORDER_TRANSFER.$TABLE,"568078396299415552");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());




        cfg.getPoClassFile().addSimpleProperty(RepairOrder.class,"order","维修申请","维修申请");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"executor","执行人","执行人");
        cfg.getPoClassFile().addSimpleProperty(RepairGroup.class,"repairGroup","维修班组","维修班组");


        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_TRANSFER.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_TRANSFER.ID).table().hidden(true);


        cfg.view().list().operationColumn().width(120);
        cfg.view().formWindow().width("98%");
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_REPAIR_ORDER_TRANSFER.GROUP_ID,
                        EAMTables.EAM_REPAIR_ORDER_TRANSFER.EXECUTOR_ID,
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


        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_TRANSFER.GROUP_ID)
                .form().validate().required().form().selectBox().queryApi(RepairGroupServiceProxy.QUERY_LIST)
                .paging(false).filter(true).toolbar(false)
                .valueField(RepairGroupMeta.ID).
                textField(RepairGroupMeta.NAME).
                fillWith(RepairOrderTransferMeta.REPAIR_GROUP).muliti(false).defaultIndex(0);

        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_TRANSFER.EXECUTOR_ID)
                .form().selectBox().queryApi(GroupUserServiceProxy.QUERY_EMPLOYEE_PERSON)
                .paging(false).filter(false).toolbar(false)
                .valueField("employeeId").
                textField(PersonMeta.NAME).
                fillWith(RepairOrderTransferMeta.EXECUTOR).muliti(false);

        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_TRANSFER.NOTES).form().textArea().height(Config.textAreaHeight);

        cfg.view().form().addJsVariable("ORDER_ID","[[${orderId}]]","工单");

        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_REPAIR_ORDER_TRANSFER.GROUP_ID,
                },
                new Object[] {
                        EAMTables.EAM_REPAIR_ORDER_TRANSFER.EXECUTOR_ID,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[]{
                        EAMTables.EAM_REPAIR_ORDER_TRANSFER.NOTES
                }

        );




        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        RepairOrderTransFerGtr g=new RepairOrderTransFerGtr();
        //生成代码
         g.generateCode();


        //生成菜单
        // g.removeByBatchId("733422818825338880");
        //g.generateMenu(RepairOrderTransferServiceProxy.class, RepairOrderTransferPageController.class);
    }
}
