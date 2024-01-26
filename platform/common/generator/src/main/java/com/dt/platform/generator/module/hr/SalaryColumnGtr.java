package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.hr.SalaryActionStatusEnum;
import com.dt.platform.constants.enums.hr.SalaryBusinessTypeEnum;
import com.dt.platform.constants.enums.hr.SalaryColumnTypeEnum;
import com.dt.platform.domain.hr.Person;
import com.dt.platform.domain.hr.SalaryColumn;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.SalaryColumnPageController;
import com.dt.platform.proxy.hr.SalaryColumnServiceProxy;
import com.github.foxnic.generator.config.WriteMode;


public class SalaryColumnGtr extends BaseCodeGenerator {
    public SalaryColumnGtr() {
        super(HrTables.HR_SALARY_COLUMN.$TABLE,"717668718989017088");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(HrTables.HR_SALARY_COLUMN.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_SALARY_COLUMN.COL_NAME).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_SALARY_COLUMN.COL_NAME,
                        HrTables.HR_SALARY_COLUMN.BUSI_TYPE,
                }
        );

        cfg.view().list().disableBatchDelete();
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(HrTables.HR_SALARY_COLUMN.UPDATE_BY).form().table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_COLUMN.CAL_METHOD).form().table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_COLUMN.CAL_METHOD).form().table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_COLUMN.COL_CODE).form().validate().required();
        cfg.view().field(HrTables.HR_SALARY_COLUMN.COL_NAME).form().validate().required();
        cfg.view().field(HrTables.HR_SALARY_COLUMN.DS_SOURCE).form().validate().required();
        cfg.view().field(HrTables.HR_SALARY_COLUMN.NOTES).form().textArea().height(120);
        cfg.view().field(HrTables.HR_SALARY_COLUMN.COL_TYPE).form().validate().required().form().radioBox().enumType(SalaryColumnTypeEnum.class).defaultIndex(0);
        cfg.view().field(HrTables.HR_SALARY_COLUMN.BUSI_TYPE).form().validate().required().form().radioBox().enumType(SalaryBusinessTypeEnum.class).defaultIndex(0);
        cfg.view().field(HrTables.HR_SALARY_COLUMN.COL_VALUE).form().validate().required().form().numberInput().decimal().scale(2).defaultValue(0.00);


        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_SALARY_COLUMN.COL_CODE,
                        HrTables.HR_SALARY_COLUMN.COL_NAME,
                        HrTables.HR_SALARY_COLUMN.COL_TYPE,
                        HrTables.HR_SALARY_COLUMN.COL_VALUE,
                        HrTables.HR_SALARY_COLUMN.DS_SOURCE,
                        HrTables.HR_SALARY_COLUMN.BUSI_TYPE,
                        HrTables.HR_SALARY_COLUMN.NOTES,
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
        SalaryColumnGtr g=new SalaryColumnGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
       //g.generateMenu(SalaryColumnServiceProxy.class, SalaryColumnPageController.class);


    }
}
