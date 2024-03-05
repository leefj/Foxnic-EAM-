package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.hr.AssessmentIndicatorPropertyEnum;
import com.dt.platform.domain.hr.meta.IndicatorLibMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.IndicatorLibPageController;
import com.dt.platform.proxy.hr.IndicatorLibServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;


public class HrmAssessMentIndicatorLibGtr extends BaseCodeGenerator {
    public HrmAssessMentIndicatorLibGtr() {
        super(HrTables.HR_INDICATOR_LIB.$TABLE,"803970075315929088");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"typeDict","typeDict","typeDict");


        cfg.view().field(HrTables.HR_INDICATOR_LIB.ID).basic().hidden(true);

        cfg.view().field(HrTables.HR_INDICATOR_LIB.NAME).search().fuzzySearch();
        cfg.view().field(HrTables.HR_INDICATOR_LIB.DEF).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_INDICATOR_LIB.TYPE_CODE,
                        HrTables.HR_INDICATOR_LIB.NAME,
                        HrTables.HR_INDICATOR_LIB.DEF,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(HrTables.HR_INDICATOR_LIB.NAME).form().validate().required();



        cfg.view().field(HrTables.HR_INDICATOR_LIB.TYPE_CODE).form().validate().required()
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=hr_indicator_lib")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(IndicatorLibMeta.TYPE_DICT).muliti(false);



        cfg.view().field(HrTables.HR_INDICATOR_LIB.PROPERTY).form().validate().required().form().radioBox().enumType(AssessmentIndicatorPropertyEnum.class).defaultIndex(0);

        cfg.view().field(HrTables.HR_INDICATOR_LIB.DEF).form().textArea().height(80);
        cfg.view().field(HrTables.HR_INDICATOR_LIB.SCORING_BASE).form().textArea().height(80);
        cfg.view().field(HrTables.HR_INDICATOR_LIB.SCORING_BY).form().textArea().height(80);

        cfg.view().field(HrTables.HR_INDICATOR_LIB.CREATE_TIME).table().disable(true);
        cfg.view().field(HrTables.HR_INDICATOR_LIB.UPDATE_BY).table().disable(true);

        cfg.view().formWindow().width("75%");;
        cfg.view().formWindow().bottomSpace(80);




        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_INDICATOR_LIB.NAME,
                        HrTables.HR_INDICATOR_LIB.PROPERTY,
                },
                new Object[] {
                        HrTables.HR_INDICATOR_LIB.TYPE_CODE,
                        HrTables.HR_INDICATOR_LIB.UNIT,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_INDICATOR_LIB.DEF,
                        HrTables.HR_INDICATOR_LIB.SCORING_BASE,
                        HrTables.HR_INDICATOR_LIB.SCORING_BY,
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
        HrmAssessMentIndicatorLibGtr g=new HrmAssessMentIndicatorLibGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
     //   g.generateMenu(IndicatorLibServiceProxy.class, IndicatorLibPageController.class);
    }
}
