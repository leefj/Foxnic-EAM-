package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;


public class BusiBxTypeGtr extends BaseCodeGenerator {
    public BusiBxTypeGtr() {
        super(HrTables.HR_PERSON_BUSI_INSURE_TYPE.$TABLE,"806983031972691968");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(HrTables.HR_PERSON_BUSI_INSURE_TYPE.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_PERSON_BUSI_INSURE_TYPE.NAME).search().fuzzySearch();
        cfg.view().field(HrTables.HR_PERSON_BUSI_INSURE_TYPE.CODE).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_PERSON_BUSI_INSURE_TYPE.CODE,
                        HrTables.HR_PERSON_BUSI_INSURE_TYPE.NAME,
                }
        );


        cfg.view().field(HrTables.HR_PERSON_BUSI_INSURE_TYPE.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_BUSI_INSURE_TYPE.CREATE_TIME).form().table().disable(true);


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(HrTables.HR_PERSON_BUSI_INSURE_TYPE.NAME).form().validate().required();
        cfg.view().field(HrTables.HR_PERSON_BUSI_INSURE_TYPE.CODE).form().validate().required();
        cfg.view().field(HrTables.HR_PERSON_BUSI_INSURE_TYPE.NOTES).form().textArea().height(120);
        cfg.view().formWindow().width("65%");;
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_PERSON_BUSI_INSURE_TYPE.CODE,
                        HrTables.HR_PERSON_BUSI_INSURE_TYPE.NAME,
                        HrTables.HR_PERSON_BUSI_INSURE_TYPE.RECYCLE,
                        HrTables.HR_PERSON_BUSI_INSURE_TYPE.MONEY,
                        HrTables.HR_PERSON_BUSI_INSURE_TYPE.NOTES,
                }
        );
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
        BusiBxTypeGtr g=new BusiBxTypeGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
     // g.generateMenu(PersonBusiInsureTypeServiceProxy.class, PersonBusiInsureTypePageController.class);
    }
}
