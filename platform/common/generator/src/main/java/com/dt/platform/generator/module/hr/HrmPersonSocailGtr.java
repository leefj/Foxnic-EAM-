package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.common.YesNoEnum;
import com.dt.platform.constants.enums.hr.ApprovalStatusEnum;
import com.dt.platform.domain.hr.Person;
import com.dt.platform.domain.hr.meta.PersonSocialRelationMeta;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;


public class HrmPersonSocailGtr extends BaseCodeGenerator {
    public HrmPersonSocailGtr() {
        super(HrTables.HR_PERSON_SOCIAL_RELATION.$TABLE,"766183428553965568");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"person","person","person");
        cfg.getPoClassFile().addSimpleProperty(Person.class,"user","user","user");
        cfg.view().field(HrTables.HR_PERSON_SOCIAL_RELATION.ID).basic().hidden(true);
        cfg.getPoClassFile().addSimpleProperty(String.class,"role","role","role");
        cfg.view().search().disable();

        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"socialRelation","socialRelation","socialRelation");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"socialRelationType","socialRelationType","socialRelationType");


        cfg.view().search().rowsDisplay(1);
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(HrTables.HR_PERSON_SOCIAL_RELATION.EMPLOYEE_ID).table().fillBy("person","name");

        cfg.view().field(HrTables.HR_PERSON_SOCIAL_RELATION.REL)
                .basic().label("关系")
                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=hr_social_relation")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(PersonSocialRelationMeta.SOCIAL_RELATION).muliti(false);

        cfg.view().field(HrTables.HR_PERSON_SOCIAL_RELATION.REL_TYPE)
                .basic().label("关系类型")
                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=hr_social_relation_type")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(PersonSocialRelationMeta.SOCIAL_RELATION_TYPE).muliti(false);

        cfg.view().field(HrTables.HR_PERSON_SOCIAL_RELATION.STATUS).form().radioBox().enumType(ApprovalStatusEnum.class);

        cfg.view().field(HrTables.HR_PERSON_SOCIAL_RELATION.NAME).form().validate().required();

        cfg.view().field(HrTables.HR_PERSON_SOCIAL_RELATION.EMERGENCY_CONTACT).form().radioBox().enumType(YesNoEnum.class).defaultIndex(1);


        cfg.view().field(HrTables.HR_PERSON_SOCIAL_RELATION.EMPLOYEE_ID).table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_SOCIAL_RELATION.CREATE_TIME).table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_SOCIAL_RELATION.UPDATE_TIME).table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_SOCIAL_RELATION.UPDATE_BY).table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_SOCIAL_RELATION.CREATE_BY).table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_SOCIAL_RELATION.REL_ID).table().disable(true);
      //  cfg.view().field(HrTables.HR_PERSON_SOCIAL_RELATION.PERSON_ID).table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_WORK_EXPERIENCE.EMPLOYEE_ID).table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_WORK_EXPERIENCE.PERSON_ID).table().fillBy("user","name");
        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width("65%");;
        cfg.view().formWindow().bottomSpace(50);
        cfg.view().form().addGroup(null,
                new Object[]{
                        HrTables.HR_PERSON_SOCIAL_RELATION.REL_TYPE,
                        HrTables.HR_PERSON_SOCIAL_RELATION.NAME,
                        HrTables.HR_PERSON_SOCIAL_RELATION.WORK_COMPANY,


                },
                new Object[]{
                        HrTables.HR_PERSON_SOCIAL_RELATION.REL,
                        HrTables.HR_PERSON_SOCIAL_RELATION.CONCAT,
                        HrTables.HR_PERSON_SOCIAL_RELATION.EMERGENCY_CONTACT,

                }
        );
        cfg.view().form().addGroup(null,
                new Object[]{
                        HrTables.HR_PERSON_SOCIAL_RELATION.NOTES
                }
        );

        cfg.view().list().addJsVariable("MODIFY_PERM","[[${modifyPerm}]]","是否可以修改");

        //文件生成覆盖模式
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
        HrmPersonSocailGtr g=new HrmPersonSocailGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
        //
       ///  g.generateMenu(PersonSocialRelationServiceProxy.class, PersonSocialRelationPageController.class);
    }
}
