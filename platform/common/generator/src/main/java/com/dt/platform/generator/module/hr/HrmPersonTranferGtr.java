package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.common.StatusYNEnum;
import com.dt.platform.constants.enums.hr.EmployeeStatusEnum;
import com.dt.platform.constants.enums.hr.PersonBillStatusEnum;
import com.dt.platform.domain.hr.*;
import com.dt.platform.domain.hr.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.PersonTransferPageController;
import com.dt.platform.proxy.hr.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;


public class HrmPersonTranferGtr extends BaseCodeGenerator {
    public HrmPersonTranferGtr() {
        super(HrTables.HR_PERSON_TRANSFER.$TABLE,"623153794699493376");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(Position.class,"position","position","position");
        cfg.view().field(HrTables.HR_PERSON_TRANSFER.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_PERSON_TRANSFER.CONTENT).search().fuzzySearch();
        cfg.view().field(HrTables.HR_PERSON_TRANSFER.TRANSFER_DATE).search().range();
        cfg.view().field(HrTables.HR_PERSON_TRANSFER.STATUS).search().fuzzySearch();

        cfg.getPoClassFile().addSimpleProperty(Organization.class,"organization","所在部门","所在部门");


        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_PERSON_TRANSFER.STATUS,
                        HrTables.HR_PERSON_TRANSFER.BUSINESS_CODE,
                        HrTables.HR_PERSON_TRANSFER.TRANSFER_DATE,

                }

        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(HrTables.HR_PERSON_TRANSFER.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_TRANSFER.FILE_IDS).table().disable(true);

        cfg.view().field(HrTables.HR_PERSON_TRANSFER.TRANSFER_DATE).form().validate().required().form().dateInput().format("yyyy-MM-dd").search().range();

        cfg.view().field(HrTables.HR_PERSON_TRANSFER.CONTENT).form().validate().required().form().textArea().height(120);
        cfg.view().field(HrTables.HR_PERSON_TRANSFER.NOTE).form().textArea().height(120);

        cfg.view().field(HrTables.HR_PERSON_TRANSFER.STATUS).form().radioBox().enumType(PersonBillStatusEnum.class).defaultIndex(0);



        cfg.view().field(HrTables.HR_PERSON_TRANSFER.POSITION_CODE)
                .form().selectBox().queryApi(PositionServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(PositionMeta.ID).
                textField(PositionMeta.NAME).
                fillWith(PersonTransferMeta.POSITION).muliti(false);


        cfg.view().field(HrTables.HR_PERSON_TRANSFER.ORG_ID)
                .form().button().chooseOrganization(true);
        cfg.view().field(HrTables.HR_PERSON_TRANSFER.ORG_ID).table().fillBy("organization","fullName");

        cfg.view().field(HrTables.HR_PERSON_TRANSFER.FILE_IDS).form().upload().maxFileCount(6);

        cfg.view().list().disableBatchDelete();
        cfg.view().search().rowsDisplay(1);
        cfg.view().formWindow().width("80%");;
        cfg.view().formWindow().bottomSpace(50);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_PERSON_TRANSFER.TRANSFER_DATE,
                        HrTables.HR_PERSON_TRANSFER.CONTENT,
                        HrTables.HR_PERSON_TRANSFER.NOTE,
                        HrTables.HR_PERSON_TRANSFER.FILE_IDS,
                }
        );
        cfg.view().form().addGroup("调动信息",
                new Object[] {

                        HrTables.HR_PERSON_TRANSFER.ORG_ID,
                        HrTables.HR_PERSON_TRANSFER.POSITION_CODE,
                }
        );


        cfg.view().list().operationColumn().addActionButton("确认","actionSure","transfer-sure");
        cfg.view().list().operationColumn().addActionButton("取消","actionCancel","transfer-cancel");
        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE);
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        HrmPersonTranferGtr g=new HrmPersonTranferGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
     //   g.removeByBatchId("801740270562443264");
      //  //生成菜单
      // g.generateMenu(PersonTransferServiceProxy.class, PersonTransferPageController.class);
    }
}
