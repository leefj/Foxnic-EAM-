package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.domain.hr.*;
import com.dt.platform.domain.hr.meta.CertificateLevelMeta;
import com.dt.platform.domain.hr.meta.CertificateMeta;
import com.dt.platform.domain.hr.meta.CertificateTypeMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.PersonResignationPageController;
import com.dt.platform.hr.page.PersonScorePageController;
import com.dt.platform.proxy.hr.CertificateLevelServiceProxy;
import com.dt.platform.proxy.hr.CertificateTypeServiceProxy;
import com.dt.platform.proxy.hr.PersonResignationServiceProxy;
import com.dt.platform.proxy.hr.PersonScoreServiceProxy;
import com.github.foxnic.generator.config.WriteMode;


public class HrmPersonScoreGtr extends BaseCodeGenerator {
    public HrmPersonScoreGtr() {
        super(HrTables.HR_PERSON_SCORE.$TABLE,"666923829754331136");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.getPoClassFile().addSimpleProperty(Person.class,"person","person","person");

        cfg.view().field(HrTables.HR_PERSON_SCORE.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_PERSON_SCORE.CONTENT).search().fuzzySearch();
        cfg.view().field(HrTables.HR_PERSON_SCORE.RCD_TIME).search().range();
        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_PERSON_SCORE.CONTENT,
                        HrTables.HR_PERSON_SCORE.RCD_TIME,
                }
        );

        cfg.view().list().disableBatchDelete();

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(HrTables.HR_PERSON_SCORE.OPER_TYPE_ID).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_SCORE.OPER_USER_ID).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_SCORE.UPDATE_BY).form().table().disable(true);

        cfg.view().field(HrTables.HR_PERSON_SCORE.PERSON_ID).table().fillBy("person","name");



        cfg.view().formWindow().width("70%");;
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_PERSON_SCORE.TYPE,
                        HrTables.HR_PERSON_SCORE.SCORE,
                        HrTables.HR_PERSON_SCORE.CONTENT,
                }
        );


        cfg.view().list().addJsVariable("PERSON_ID",   "[[${personId}]]","personId");
        //文件生成覆盖模式
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
        HrmPersonScoreGtr g=new HrmPersonScoreGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单

      // g.generateMenu(PersonResignationServiceProxy.class, PersonResignationPageController.class);
    }
}
