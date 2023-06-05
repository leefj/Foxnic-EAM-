package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.common.StatusYNEnum;
import com.dt.platform.constants.enums.hr.SalaryTypeEnum;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.SalaryCtlPageController;
import com.dt.platform.proxy.hr.SalaryCtlServiceProxy;
import com.github.foxnic.generator.config.WriteMode;


public class SalalyCtlGtr extends BaseCodeGenerator {
    public SalalyCtlGtr() {
        super(HrTables.HR_SALARY_CTL.$TABLE,"662315275764367360");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(HrTables.HR_SALARY_CTL.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_SALARY_CTL.CODE).search().fuzzySearch();
        cfg.view().field(HrTables.HR_SALARY_CTL.NAME).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_SALARY_CTL.CODE,
                        HrTables.HR_SALARY_CTL.NAME,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(HrTables.HR_SALARY_TPL.CODE).form().validate().required();
        cfg.view().field(HrTables.HR_SALARY_CTL.NAME).form().validate().required();

        //只有当枚举生效
        cfg.view().field(HrTables.HR_SALARY_CTL.VALUE_EN).form().radioBox().enumType(StatusYNEnum.class);
        cfg.view().field(HrTables.HR_SALARY_CTL.TYPE).form().readOnly().form().radioBox().enumType(SalaryTypeEnum.class);
        cfg.view().field(HrTables.HR_SALARY_CTL.NAME).form().validate().required();
        cfg.view().field(HrTables.HR_SALARY_CTL.NOTES).form().textArea().height(150);

        cfg.view().field(HrTables.HR_SALARY_CTL.CODE).form().readOnly();
        cfg.view().list().disableBatchDelete();
        cfg.view().list().disableCreateNew();
        cfg.view().list().disableSingleDelete();


        cfg.view().formWindow().width("65%");;
        cfg.view().formWindow().bottomSpace(50);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_SALARY_CTL.CODE,
                        HrTables.HR_SALARY_CTL.NAME,
                        HrTables.HR_SALARY_CTL.TYPE,
                        HrTables.HR_SALARY_CTL.VALUE_EN,
                        HrTables.HR_SALARY_CTL.VALUE_STR,
                        HrTables.HR_SALARY_CTL.VALUE_D,
                        HrTables.HR_SALARY_CTL.NOTES
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
        SalalyCtlGtr g=new SalalyCtlGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
    //  g.generateMenu(SalaryCtlServiceProxy.class, SalaryCtlPageController.class);
    }
}
