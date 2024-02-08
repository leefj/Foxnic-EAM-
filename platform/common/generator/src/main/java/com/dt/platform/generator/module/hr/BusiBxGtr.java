package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.domain.hr.Person;
import com.dt.platform.domain.hr.PersonBusiInsureType;
import com.dt.platform.domain.hr.SalaryTpl;
import com.dt.platform.domain.hr.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.PersonBusiInsurePageController;
import com.dt.platform.proxy.hr.PersonBusiInsureServiceProxy;
import com.dt.platform.proxy.hr.PersonBusiInsureTypeServiceProxy;
import com.dt.platform.proxy.hr.PersonServiceProxy;
import com.dt.platform.proxy.hr.PositionServiceProxy;
import com.github.foxnic.generator.config.WriteMode;


public class BusiBxGtr extends BaseCodeGenerator {
    public BusiBxGtr() {
        super(HrTables.HR_PERSON_BUSI_INSURE.$TABLE,"806983031972691968");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(Person.class,"person","person","person");
        cfg.getPoClassFile().addSimpleProperty(PersonBusiInsureType.class,"personBusiInsureType","personBusiInsureType","personBusiInsureType");
        cfg.getPoClassFile().addSimpleProperty(String.class,"personJobNumber","personJobNumber","personJobNumber");
        cfg.getPoClassFile().addSimpleProperty(String.class,"personCardNumber","personCardNumber","personCardNumber");

        cfg.view().field(HrTables.HR_PERSON_BUSI_INSURE.END_TIME).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(HrTables.HR_PERSON_BUSI_INSURE.START_TIME).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(HrTables.HR_PERSON_BUSI_INSURE.RCD_TIME).form().dateInput().format("yyyy-MM-dd").search().range();


        cfg.view().field(HrTables.HR_PERSON_BUSI_INSURE.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_PERSON_BUSI_INSURE.NAME).search().fuzzySearch();
        cfg.view().field(HrTables.HR_PERSON_BUSI_INSURE.NOTES).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_PERSON_BUSI_INSURE.PERSON_ID,
                        HrTables.HR_PERSON_BUSI_INSURE.TYPE_CODE,
                        HrTables.HR_PERSON_BUSI_INSURE.BATCH_CODE,
                        HrTables.HR_PERSON_BUSI_INSURE.NOTES,

                },
                new Object[]{
                        HrTables.HR_PERSON_BUSI_INSURE.RCD_TIME,
                        HrTables.HR_PERSON_BUSI_INSURE.START_TIME,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(HrTables.HR_PERSON_BUSI_INSURE.NAME).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_BUSI_INSURE.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_BUSI_INSURE.CREATE_TIME).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_BUSI_INSURE.FILE_IDS).form().table().disable(true);
        cfg.view().field(PersonBusiInsureMeta.PERSON_CARD_NUMBER).basic().label("卡号").form().readOnly().table().disable(false);
        cfg.view().field(PersonBusiInsureMeta.PERSON_JOB_NUMBER).basic().label("工号").form().readOnly().table().disable(false);
        cfg.view().field(HrTables.HR_PERSON_BUSI_INSURE.FILE_IDS).form().table().disable(true);


        cfg.view().field(PersonBusiInsureMeta.PERSON_JOB_NUMBER).basic().label("工号").table().fillBy("person","jobNumber");
        cfg.view().field(PersonBusiInsureMeta.PERSON_CARD_NUMBER).basic().label("身份证").table().fillBy("person","identityCard");


        cfg.view().field(HrTables.HR_PERSON_BUSI_INSURE.PERSON_ID)
                .form().validate().required().form().selectBox().queryApi(PersonServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(PersonMeta.ID).
                textField(PersonMeta.NAME).
                fillWith(PersonBusiInsureMeta.PERSON).muliti(false);


        cfg.view().field(HrTables.HR_PERSON_BUSI_INSURE.TYPE_CODE)
                .form().validate().required().form().selectBox().queryApi(PersonBusiInsureTypeServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(PersonBusiInsureTypeMeta.CODE).
                textField(PersonBusiInsureTypeMeta.NAME).
                fillWith(PersonBusiInsureMeta.PERSON_BUSI_INSURE_TYPE).muliti(false);


        cfg.view().list().excel(true,true);





        cfg.view().field(HrTables.HR_PERSON_BUSI_INSURE.NOTES).form().textArea().height(120);
        cfg.view().field(HrTables.HR_PERSON_BUSI_INSURE.FILE_IDS).form().upload().acceptAllType().maxFileCount(3);
        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_PERSON_BUSI_INSURE.PERSON_ID,
                        PersonBusiInsureMeta.PERSON_JOB_NUMBER,
                },
                new Object[] {
                        PersonBusiInsureMeta.PERSON_CARD_NUMBER,
                }
        );
        cfg.view().form().addGroup("保险明细",
                new Object[] {
                        HrTables.HR_PERSON_BUSI_INSURE.TYPE_CODE,
                        HrTables.HR_PERSON_BUSI_INSURE.BILL_CODE,
                        HrTables.HR_PERSON_BUSI_INSURE.PERSON_PAY,
                        HrTables.HR_PERSON_BUSI_INSURE.START_TIME,
                },
                new Object[] {
                        HrTables.HR_PERSON_BUSI_INSURE.RCD_TIME,
                        HrTables.HR_PERSON_BUSI_INSURE.PAY,
                        HrTables.HR_PERSON_BUSI_INSURE.COMPANY_PAY,
                        HrTables.HR_PERSON_BUSI_INSURE.END_TIME,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {

                        HrTables.HR_PERSON_BUSI_INSURE.FILE_IDS,
                        HrTables.HR_PERSON_BUSI_INSURE.NOTES,
                }
        );
        cfg.view().list().addToolButton("导入","importData","import-data");
        cfg.view().list().addToolButton("导出","exportData","export-data");


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
        BusiBxGtr g=new BusiBxGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
       //  g.generateMenu(PersonBusiInsureServiceProxy.class, PersonBusiInsurePageController.class);
    }
}
