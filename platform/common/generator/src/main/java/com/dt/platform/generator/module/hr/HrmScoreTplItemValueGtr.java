package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.hr.ScoreItemType;
import com.dt.platform.domain.hr.ScoreTplItemValue;
import com.dt.platform.domain.hr.meta.ScoreTplItemMeta;
import com.dt.platform.domain.hr.meta.ScoreTplItemValueMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.ScoreTplItemValuePageController;
import com.dt.platform.proxy.hr.ScoreTplItemValueServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;


public class HrmScoreTplItemValueGtr extends BaseCodeGenerator {
    public HrmScoreTplItemValueGtr() {
        super(HrTables.HR_SCORE_TPL_ITEM_VALUE.$TABLE,"803970322595315713");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(HrTables.HR_SCORE_TPL_ITEM_VALUE.ID).basic().hidden(true);

        cfg.view().field(HrTables.HR_SCORE_TPL_ITEM_VALUE.NOTES).search().fuzzySearch();

        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"scoreGroup","scoreGroup","scoreGroup");

        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_SCORE_TPL_ITEM_VALUE.GROUP_ID,
                        HrTables.HR_SCORE_TPL_ITEM_VALUE.NOTES,
                }
        );


        cfg.view().list().disableBatchDelete();

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);



        cfg.view().field(HrTables.HR_SCORE_TPL_ITEM_VALUE.GROUP_ID)
                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=hr_score_group")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(ScoreTplItemValueMeta.GROUP_ID).muliti(false);


        cfg.view().field(HrTables.HR_SCORE_TPL_ITEM_VALUE.CREATE_TIME).form().table().disable(true);
        cfg.view().field(HrTables.HR_SCORE_TPL_ITEM_VALUE.UPDATE_BY).form().table().disable(true);

        cfg.view().field(HrTables.HR_SCORE_TPL_ITEM_VALUE.ITEM_NAME).form().validate().required();
        cfg.view().field(HrTables.HR_SCORE_TPL_ITEM_VALUE.NOTES).form().textArea().height(80);
        cfg.view().field(HrTables.HR_SCORE_TPL_ITEM_VALUE.ITEM_TYPE).form().validate().required().form().radioBox().enumType(ScoreItemType.class).defaultIndex(0);




        cfg.view().formWindow().width("70%");;
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_SCORE_TPL_ITEM_VALUE.GROUP_ID,
                        },
                new Object[] {
                        HrTables.HR_SCORE_TPL_ITEM_VALUE.ITEM_NAME,
                }
        );

        cfg.view().form().addGroup("配置",
                new Object[] {
                        HrTables.HR_SCORE_TPL_ITEM_VALUE.ITEM_TYPE,
                        HrTables.HR_SCORE_TPL_ITEM_VALUE.DEF_SCORE,
                },
                new Object[] {
                        HrTables.HR_SCORE_TPL_ITEM_VALUE.MAX_SCORE,
                        HrTables.HR_SCORE_TPL_ITEM_VALUE.MIN_SCORE,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_SCORE_TPL_ITEM_VALUE.SN,
                        HrTables.HR_SCORE_TPL_ITEM_VALUE.NOTES,
                }
        );

        cfg.view().list().addJsVariable("TPL_ID",   "[[${tplId}]]","tplId");
        cfg.view().form().addJsVariable("TPL_ID",   "[[${tplId}]]","tplId");

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
        HrmScoreTplItemValueGtr g=new HrmScoreTplItemValueGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
    //    g.generateMenu(ScoreTplItemValueServiceProxy.class, ScoreTplItemValuePageController.class);
    }
}
