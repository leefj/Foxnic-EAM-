package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.common.StatusValidEnum;
import com.dt.platform.constants.enums.common.ValidStatusEnum;
import com.dt.platform.domain.hr.PersonFileOut;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.PersonFileOutPageController;
import com.dt.platform.proxy.hr.PersonFileOutServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;


public class HrmFileOutGtr extends BaseCodeGenerator {
    public HrmFileOutGtr() {
        super(HrTables.HR_PERSON_FILE_OUT.$TABLE,"623153794699493376");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(HrTables.HR_PERSON_FILE_OUT.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_PERSON_FILE_OUT.CONTENT).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_PERSON_FILE_OUT.CONTENT
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(HrTables.HR_PERSON_FILE_OUT.OUT_DATE).form().validate().required().form().dateInput().type(DatePickerType.date).format("yyyy-MM-dd");
        cfg.view().field(HrTables.HR_PERSON_FILE_OUT.CONTENT).form().validate().required().form().textArea().height(150);
        cfg.view().field(HrTables.HR_PERSON_FILE_OUT.NOTES).form().textArea().height(150);

        cfg.view().field(HrTables.HR_PERSON_FILE_OUT.STATUS).form().radioBox().enumType(ValidStatusEnum.class);

        cfg.view().field(HrTables.HR_PERSON_FILE_OUT.FILE_ID).table().disable(true);

        cfg.view().list().operationColumn().addActionButton("确认","confirmFunc","person-file-out");

        cfg.view().list().addJsVariable("FILE_ID","[[${fileId}]]","FILE_ID");
        cfg.view().form().addJsVariable("FILE_ID","[[${fileId}]]","FILE_ID");
        cfg.view().list().disableBatchDelete();

        cfg.view().formWindow().width("65%");;
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_PERSON_FILE_OUT.OUT_DATE,
                        HrTables.HR_PERSON_FILE_OUT.CONTENT,
                        HrTables.HR_PERSON_FILE_OUT.NOTES,
                }
        );

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
        HrmFileOutGtr g=new HrmFileOutGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
      //g.generateMenu(PersonFileOutServiceProxy.class, PersonFileOutPageController.class);
    }
}
