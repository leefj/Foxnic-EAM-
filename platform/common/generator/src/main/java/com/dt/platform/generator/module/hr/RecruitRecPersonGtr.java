package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.common.StatusYNEnum;
import com.dt.platform.domain.hr.RecruitPersonRec;
import com.dt.platform.domain.hr.RecruitPostRec;
import com.dt.platform.domain.hr.meta.RecruitPersonRecMeta;
import com.dt.platform.domain.hr.meta.RecruitPostRecMeta;
import com.dt.platform.domain.hr.meta.SalaryActionMeta;
import com.dt.platform.domain.hr.meta.SalaryMonthMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.RecruitPersonRecPageController;
import com.dt.platform.proxy.hr.RecruitPersonRecServiceProxy;
import com.dt.platform.proxy.hr.RecruitPostRecServiceProxy;
import com.dt.platform.proxy.hr.SalaryMonthServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;


public class RecruitRecPersonGtr extends BaseCodeGenerator {
    public RecruitRecPersonGtr() {
        super(HrTables.HR_RECRUIT_PERSON_REC.$TABLE,"662287283122077696");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(RecruitPostRec.class,"recruitPostRec","recruitPostRec","recruitPostRec");


        cfg.view().field(HrTables.HR_RECRUIT_PERSON_REC.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_RECRUIT_PERSON_REC.NAME).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_RECRUIT_PERSON_REC.NAME,
                }
        );

        cfg.view().field(HrTables.HR_RECRUIT_PERSON_REC.POST_ID)
                .form().validate().required().form().selectBox().queryApi(RecruitPostRecServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(RecruitPostRecMeta.ID).
                textField(RecruitPostRecMeta.NAME).
                fillWith(RecruitPersonRecMeta.RECRUIT_POST_REC).muliti(false);



        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(HrTables.HR_RECRUIT_PERSON_REC.END_DATE).form().dateInput().format("yyyy-MM-dd");
        cfg.view().field(HrTables.HR_RECRUIT_PERSON_REC.START_DATE).form().dateInput().format("yyyy-MM-dd");
        cfg.view().field(HrTables.HR_RECRUIT_PERSON_REC.NAME).form().validate().required();


        cfg.view().formWindow().width("70%");;
        cfg.view().formWindow().bottomSpace(60);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_RECRUIT_PERSON_REC.NAME,
                        HrTables.HR_RECRUIT_PERSON_REC.POST_ID,
                        HrTables.HR_RECRUIT_PERSON_REC.POST_NAME,
                        HrTables.HR_RECRUIT_PERSON_REC.START_DATE,
                        HrTables.HR_RECRUIT_PERSON_REC.END_DATE,
                        HrTables.HR_RECRUIT_PERSON_REC.CONTENT,
                        HrTables.HR_RECRUIT_PERSON_REC.NOTES,
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
        RecruitRecPersonGtr g=new RecruitRecPersonGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
      //g.generateMenu(RecruitPersonRecServiceProxy.class, RecruitPersonRecPageController.class);


    }
}
