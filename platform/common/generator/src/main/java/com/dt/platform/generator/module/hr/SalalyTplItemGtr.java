package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.hr.SalaryTplIncludeExpressEnum;
import com.dt.platform.constants.enums.hr.SalaryTplItemCodeEnum;
import com.dt.platform.domain.hr.SalaryColumn;
import com.dt.platform.domain.hr.SalaryTplItem;
import com.dt.platform.domain.hr.meta.PersonMeta;
import com.dt.platform.domain.hr.meta.SalaryColumnMeta;
import com.dt.platform.domain.hr.meta.SalaryTplItemMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.SalaryTplItemPageController;
import com.dt.platform.proxy.hr.SalaryColumnServiceProxy;
import com.dt.platform.proxy.hr.SalaryTplItemServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;


public class SalalyTplItemGtr extends BaseCodeGenerator {
    public SalalyTplItemGtr() {
        super(HrTables.HR_SALARY_TPL_ITEM.$TABLE,"662315275764367360");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(SalaryColumn.class,"salaryColumn","salaryColumn","salaryColumn");

        cfg.getPoClassFile().addSimpleProperty(String.class,"salaryColumnCode","salaryColumnCode","salaryColumnCode");


        cfg.view().field(HrTables.HR_SALARY_TPL_ITEM.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_SALARY_TPL_ITEM.CODE).search().fuzzySearch();
        cfg.view().field(HrTables.HR_SALARY_TPL_ITEM.NAME).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_SALARY_TPL_ITEM.NAME,
                }
        );

        cfg.view().list().disableBatchDelete();
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(HrTables.HR_SALARY_TPL_ITEM.TPL_ID).form().table().disable(true);

        cfg.view().field(SalaryTplItemMeta.SALARY_COLUMN_CODE).basic().label("字段编码").form().table().disable(false);
        cfg.view().field(SalaryTplItemMeta.SALARY_COLUMN_CODE).table().fillBy("salaryColumn","colCode");

        cfg.view().field(HrTables.HR_SALARY_TPL_ITEM.EXPRESSION_SHOW).form().table().disable(true);



      //  cfg.view().field(HrTables.HR_SALARY_TPL_ITEM.CODE).form().validate().required().form().validate().form().selectBox().enumType(SalaryTplItemCodeEnum.class).muliti(false);

        cfg.view().field(HrTables.HR_SALARY_TPL_ITEM.EXPRESSION_VALUE).form().textArea().height(80);
        cfg.view().field(HrTables.HR_SALARY_TPL_ITEM.EXPRESSION_SHOW).form().textArea().height(80);
        cfg.view().field(HrTables.HR_SALARY_TPL_ITEM.STATUS).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);
        cfg.view().field(HrTables.HR_SALARY_TPL_ITEM.INCLUDE_EXPRESSION).form().validate().required().form().radioBox().enumType(SalaryTplIncludeExpressEnum.class).defaultIndex(1);
        cfg.view().field(HrTables.HR_SALARY_TPL_ITEM.NOTES).form().textArea().height(80);

        cfg.view().field(HrTables.HR_SALARY_TPL_ITEM.NAME).table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_TPL_ITEM.CREATE_TIME).table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_TPL_ITEM.CREATE_BY).table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_TPL_ITEM.UPDATE_BY).table().disable(true);
        cfg.view().field(HrTables.HR_SALARY_TPL_ITEM.UPDATE_TIME).table().disable(true);


        cfg.view().field(HrTables.HR_SALARY_TPL_ITEM.CODE)
                .form().validate().required().form().selectBox().queryApi(SalaryColumnServiceProxy.QUERY_LIST)
                .paging(false).filter(true).toolbar(false)
                .valueField(SalaryColumnMeta.COL_CODE).
                textField(SalaryColumnMeta.COL_NAME).
                fillWith(SalaryTplItemMeta.SALARY_COLUMN).muliti(false);

        cfg.view().formWindow().width("80%");;
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_SALARY_TPL_ITEM.CODE,
                        HrTables.HR_SALARY_TPL_ITEM.INCLUDE_EXPRESSION
                },
                new Object[] {
                        HrTables.HR_SALARY_TPL_ITEM.STATUS,
                        HrTables.HR_SALARY_TPL_ITEM.SORT
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_SALARY_TPL_ITEM.EXPRESSION_VALUE,
                        HrTables.HR_SALARY_TPL_ITEM.NOTES,

                }
        );

        cfg.view().list().addJsVariable("TPL_ID",   "[[${tplId}]]","tplId");
        cfg.view().form().addJsVariable("TPL_ID",   "[[${tplId}]]","tplId");

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
        SalalyTplItemGtr g=new SalalyTplItemGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
      // g.generateMenu(SalaryTplItemServiceProxy.class, SalaryTplItemPageController.class);
    }
}
