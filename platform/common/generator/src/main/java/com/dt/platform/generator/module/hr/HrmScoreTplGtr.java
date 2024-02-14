package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.hr.ScoreTplItem;
import com.dt.platform.domain.hr.ScoreTplItemValue;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.ScoreTplPageController;
import com.dt.platform.proxy.hr.ScoreTplServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;


public class HrmScoreTplGtr extends BaseCodeGenerator {
    public HrmScoreTplGtr() {
        super(HrTables.HR_SCORE_TPL.$TABLE,"803970322595315713");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addListProperty(ScoreTplItem.class,"scoreTplItemList","scoreTplItemList","scoreTplItemList");


        cfg.view().field(HrTables.HR_SCORE_TPL.ID).basic().hidden(true);

        cfg.view().field(HrTables.HR_SCORE_TPL.NAME).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_SCORE_TPL.STATUS,
                        HrTables.HR_SCORE_TPL.NAME,

                }
        );

        cfg.view().list().disableBatchDelete();

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(HrTables.HR_SCORE_TPL.CREATE_TIME).form().table().disable(true);
        cfg.view().field(HrTables.HR_SCORE_TPL.UPDATE_BY).form().table().disable(true);

        cfg.view().field(HrTables.HR_SCORE_TPL.NAME).form().validate().required();

        cfg.view().field(HrTables.HR_SCORE_TPL.STATUS).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);
        cfg.view().field(HrTables.HR_SCORE_TPL.NOTES).form().textArea().height(60);



        cfg.view().formWindow().width("70%");;
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_SCORE_TPL.NAME,
                        HrTables.HR_SCORE_TPL.STATUS,
                        HrTables.HR_SCORE_TPL.NOTES,

                }
        );

        cfg.view().list().operationColumn().addActionButton("评分项","scoreItem","score-item");


        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
                .setExtendJsFile(WriteMode.IGNORE);
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        HrmScoreTplGtr g=new HrmScoreTplGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单

     //  g.generateMenu(ScoreTplServiceProxy.class, ScoreTplPageController.class);
    }
}
