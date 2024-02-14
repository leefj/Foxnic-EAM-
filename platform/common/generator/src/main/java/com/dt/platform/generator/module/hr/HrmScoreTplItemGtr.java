package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.hr.ScoreItemType;
import com.dt.platform.domain.hr.ScoreIndicator;
import com.dt.platform.domain.hr.ScoreTplItem;
import com.dt.platform.domain.hr.meta.PersonMeta;
import com.dt.platform.domain.hr.meta.ScoreIndicatorMeta;
import com.dt.platform.domain.hr.meta.ScoreTplItemMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.ScoreTplItemPageController;
import com.dt.platform.hr.page.ScoreTplPageController;
import com.dt.platform.proxy.hr.ScoreIndicatorServiceProxy;
import com.dt.platform.proxy.hr.ScoreTplItemServiceProxy;
import com.dt.platform.proxy.hr.ScoreTplServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;


public class HrmScoreTplItemGtr extends BaseCodeGenerator {
    public HrmScoreTplItemGtr() {
        super(HrTables.HR_SCORE_TPL_ITEM.$TABLE,"803970322595315713");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(HrTables.HR_SCORE_TPL_ITEM.ID).basic().hidden(true);



        cfg.view().field(HrTables.HR_SCORE_TPL_ITEM.NOTES).search().fuzzySearch();

        cfg.getPoClassFile().addSimpleProperty(ScoreIndicator.class,"scoreIndicator","scoreIndicator","scoreIndicator");

        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_SCORE_TPL_ITEM.GROUP_ID,
                        HrTables.HR_SCORE_TPL_ITEM.NOTES,
                }
        );


        cfg.view().list().disableBatchDelete();

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);



        cfg.view().field(HrTables.HR_SCORE_TPL_ITEM.GROUP_ID)
                .form().validate().required().form().selectBox().queryApi(ScoreIndicatorServiceProxy.QUERY_LIST)
                .paging(false).filter(false).toolbar(false)
                .valueField(ScoreIndicatorMeta.ID).
                textField(ScoreIndicatorMeta.NAME).
                fillWith(ScoreTplItemMeta.SCORE_INDICATOR).muliti(false);

        cfg.view().field(HrTables.HR_SCORE_TPL_ITEM.TPL_ID).form().table().disable(true);
        cfg.view().field(HrTables.HR_SCORE_TPL_ITEM.CREATE_TIME).form().table().disable(true);
        cfg.view().field(HrTables.HR_SCORE_TPL_ITEM.UPDATE_BY).form().table().disable(true);

        cfg.view().field(HrTables.HR_SCORE_TPL_ITEM.ITEM_NAME).form().validate().required();
        cfg.view().field(HrTables.HR_SCORE_TPL_ITEM.NOTES).form().textArea().height(80);
        cfg.view().field(HrTables.HR_SCORE_TPL_ITEM.ITEM_TYPE).form().validate().required().form().radioBox().enumType(ScoreItemType.class).defaultIndex(0);




        cfg.view().formWindow().width("70%");;
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_SCORE_TPL_ITEM.GROUP_ID,
                        },
                new Object[] {
                        HrTables.HR_SCORE_TPL_ITEM.SN,
                }
        );

        cfg.view().form().addGroup("配置",
                new Object[] {
                        HrTables.HR_SCORE_TPL_ITEM.ITEM_NAME,
                        HrTables.HR_SCORE_TPL_ITEM.ITEM_TYPE,
                        HrTables.HR_SCORE_TPL_ITEM.DEF_SCORE,
                },
                new Object[] {
                        HrTables.HR_SCORE_TPL_ITEM.MIN_SCORE,
                        HrTables.HR_SCORE_TPL_ITEM.MAX_SCORE,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_SCORE_TPL_ITEM.NOTES,
                }
        );

        cfg.view().list().addJsVariable("TPL_ID",   "[[${tplId}]]","tplId");
        cfg.view().form().addJsVariable("TPL_ID",   "[[${tplId}]]","tplId");

        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
                .setExtendJsFile(WriteMode.IGNORE);
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        HrmScoreTplItemGtr g=new HrmScoreTplItemGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单

       //g.generateMenu(ScoreTplItemServiceProxy.class, ScoreTplItemPageController.class);
    }
}
