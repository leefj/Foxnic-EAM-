package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;

import com.dt.platform.constants.enums.hr.PersonStoreStatusEnum;
import com.dt.platform.domain.hr.*;
import com.dt.platform.domain.hr.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.hr.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;


public class InterViewPersonStoreGtr extends BaseCodeGenerator {
    public InterViewPersonStoreGtr() {
        super(HrTables.HR_PERSON_STORE.$TABLE,"811710163416252416");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());




        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"sexDict","sexDict","sexDict");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"maritalStatusDict","maritalStatusDict","maritalStatusDict");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"educationData","educationData","educationData");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"politicCountenanceData","politicCountenanceData","politicCountenanceData");



        cfg.view().field(HrTables.HR_PERSON_STORE.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_PERSON_STORE.NAME).search().fuzzySearch();
        cfg.view().field(HrTables.HR_PERSON_STORE.IDENTITY_CARD).search().fuzzySearch();




        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_PERSON_STORE.NAME,
                        HrTables.HR_PERSON_STORE.CONTACT_INFORMATION,
                        HrTables.HR_PERSON_STORE.IDENTITY_CARD,
                        HrTables.HR_PERSON_STORE.EDUCATION_CODE,
                },
                new Object[]{
                        HrTables.HR_PERSON_STORE.STATUS,
                        HrTables.HR_PERSON_STORE.SEX_CODE,
                }
        );
        cfg.view().list().disableBatchDelete();
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(HrTables.HR_PERSON_STORE.BIRTHDAY).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_STORE.NATION_CODE).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_STORE.NATIVE_PLACE_CODE).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_STORE.MARITAL_STATUS).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_STORE.BIRTHDAY).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_STORE.IDENTITY_CARD).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_STORE.GRADUATION_SCHOOL).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_STORE.MAJOR).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_STORE.GRADUATION_DATE).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_STORE.GRADUATION_SCHOOL).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_STORE.FOREIGN_LANGUAGE).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_STORE.FOREIGN_LANGUAGE_LEVEL).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_STORE.COMPUTER_ABILITY).form().table().disable(true);

        cfg.view().field(HrTables.HR_PERSON_STORE.JOIN_PART_DATE).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_STORE.OWNER_CODE).form().table().disable(true);

        cfg.view().field(HrTables.HR_PERSON_STORE.FILE_ID).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_STORE.UPDATE_BY).form().table().disable(true);


        cfg.view().field(HrTables.HR_PERSON_STORE.BIRTHDAY).form().dateInput().format("yyyy-MM-dd").search().range();

        cfg.view().field(HrTables.HR_PERSON_STORE.FIRST_WORK_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(HrTables.HR_PERSON_STORE.JOIN_PART_DATE).form().dateInput().format("yyyy-MM-dd").search().range();

        cfg.view().field(HrTables.HR_PERSON_STORE.GRADUATION_DATE).form().dateInput().format("yyyy-MM-dd").search().range();

        cfg.view().field(HrTables.HR_PERSON_STORE.STATUS).form().selectBox().enumType(PersonStoreStatusEnum.class);



        cfg.view().field(HrTables.HR_PERSON_STORE.FILE_ID).table().disable(true);

        cfg.view().field(HrTables.HR_PERSON_STORE.PICTURE_ID).form().upload().acceptImageType().buttonLabel("选择图片").maxFileCount(3);
        cfg.view().field(HrTables.HR_PERSON_STORE.FILE_ID).form().upload().maxFileCount(6);

        cfg.view().field(HrTables.HR_PERSON_STORE.NAME).form().validate().required();
        cfg.view().field(HrTables.HR_PERSON_STORE.IDENTITY_CARD).form().validate().required();

        cfg.view().field(HrTables.HR_PERSON_STORE.NOTE).form().textArea().height(Config.textAreaHeight);


        cfg.view().field(HrTables.HR_PERSON_STORE.EDUCATION_CODE)
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=hr_education")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(PersonMeta.EDUCATION_DATA).muliti(false);




        cfg.view().field(HrTables.HR_PERSON_STORE.SEX_CODE)
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=sex")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(PersonMeta.SEX_DICT).muliti(false);



        cfg.view().field(HrTables.HR_PERSON_STORE.MARITAL_STATUS)
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=hr_marital_status")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(PersonMeta.MARITAL_STATUS_DICT).muliti(false);


        cfg.view().field(HrTables.HR_PERSON_STORE.POLITIC_COUNTENANCE_CODE)
           .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=hr_politic_countenance")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(PersonMeta.POLITIC_COUNTENANCE_DATA).muliti(false);


        cfg.view().search().rowsDisplay(1);
        cfg.view().formWindow().width("80%");;
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup("基本信息",
                new Object[] {
                        HrTables.HR_PERSON_STORE.NAME,
                        HrTables.HR_PERSON_STORE.IDENTITY_CARD,
                        HrTables.HR_PERSON_STORE.SEX_CODE,
                        HrTables.HR_PERSON_STORE.BIRTHDAY,

                },
                new Object[] {
                        HrTables.HR_PERSON_STORE.NATION_CODE,
                        HrTables.HR_PERSON_STORE.NATIVE_PLACE_CODE,
                        HrTables.HR_PERSON_STORE.MARITAL_STATUS,
                }
        );


        cfg.view().form().addGroup("个人情况",
                new Object[] {
                        HrTables.HR_PERSON_STORE.POLITIC_COUNTENANCE_CODE,
                        HrTables.HR_PERSON_STORE.JOIN_PART_DATE,
                        HrTables.HR_PERSON_STORE.SPECIAL_SKILL,
                },
                new Object[] {
                        HrTables.HR_PERSON_STORE.CONTACT_INFORMATION,
                        HrTables.HR_PERSON_STORE.EMAIL,
                }
        );

        cfg.view().form().addGroup("学业信息",
                new Object[] {
                        HrTables.HR_PERSON_STORE.EDUCATION_CODE,
                        HrTables.HR_PERSON_STORE.MAJOR,
                        HrTables.HR_PERSON_STORE.FOREIGN_LANGUAGE,
                        HrTables.HR_PERSON_STORE.COMPUTER_ABILITY,
                },
                new Object[] {
                        HrTables.HR_PERSON_STORE.GRADUATION_SCHOOL,
                        HrTables.HR_PERSON_STORE.FOREIGN_LANGUAGE_LEVEL,
                        HrTables.HR_PERSON_STORE.GRADUATION_DATE
                }
        );

        cfg.view().form().addGroup("工作信息",
                new Object[] {

                        HrTables.HR_PERSON_STORE.NOW_SALARY,
                        HrTables.HR_PERSON_STORE.JOB_REQUIREMENT,

                },
                new Object[] {
                        HrTables.HR_PERSON_STORE.FOR_SALARY,
                        HrTables.HR_PERSON_STORE.SOURCE,

                }
        );


        cfg.view().form().addGroup("其他信息",
                new Object[] {
                        HrTables.HR_PERSON_STORE.STATUS,
                        HrTables.HR_PERSON_STORE.REVIEW_RESULT,
                        HrTables.HR_PERSON_STORE.PICTURE_ID,
                        HrTables.HR_PERSON_STORE.FILE_ID,
                        HrTables.HR_PERSON_STORE.NOTE
                }
        );


      //  cfg.view().list().addToolButton("导入","importData","import-data");
       // cfg.view().list().addToolButton("导出","exportData","export-data");

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
        InterViewPersonStoreGtr g=new InterViewPersonStoreGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
     //  g.generateMenu(PersonServiceProxy.class, PersonPageController.class);
    }
}
