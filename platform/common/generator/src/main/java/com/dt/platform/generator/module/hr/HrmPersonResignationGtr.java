package com.dt.platform.generator.module.hr;


import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.enums.common.StatusYNEnum;
import com.dt.platform.constants.enums.hr.EmployeeStatusEnum;
import com.dt.platform.domain.hr.*;
import com.dt.platform.domain.hr.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.hr.page.PersonResignationPageController;
import com.dt.platform.proxy.hr.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;


public class HrmPersonResignationGtr extends BaseCodeGenerator {
    public HrmPersonResignationGtr() {
        super(HrTables.HR_PERSON_RESIGNATION.$TABLE,"623153794699493376");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(Person.class,"person","person","person");
        cfg.getPoClassFile().addSimpleProperty(Position.class,"position","position","position");

        cfg.view().field(HrTables.HR_PERSON_RESIGNATION.ID).basic().hidden(true);
        cfg.view().field(HrTables.HR_PERSON_RESIGNATION.RESIGNATION_DATE).search().range();

        cfg.view().search().inputLayout(
                new Object[]{
                        HrTables.HR_PERSON_RESIGNATION.CONTENT,
                        HrTables.HR_PERSON_RESIGNATION.RESIGNATION_DATE,
                }

        );

        cfg.view().field(HrTables.HR_PERSON_RESIGNATION.PERSON_ID).table().fillBy("person","name");



        cfg.view().field(HrTables.HR_PERSON_RESIGNATION.OPER_USER_ID).form().table().disable(true);
        cfg.view().field(HrTables.HR_PERSON_RESIGNATION.UPDATE_BY).form().table().disable(true);

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().search().rowsDisplay(1);
        cfg.view().formWindow().width("80%");;
        cfg.view().formWindow().bottomSpace(50);
        cfg.view().form().addGroup(null,
                new Object[] {
                        HrTables.HR_PERSON_RESIGNATION.CONTENT,
                        HrTables.HR_PERSON_RESIGNATION.RESIGNATION_DATE,
                }
        );

        cfg.view().list().disableBatchDelete();

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
        HrmPersonResignationGtr g=new HrmPersonResignationGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
      //  //生成菜单
    //  g.generateMenu(PersonResignationServiceProxy.class, PersonResignationPageController.class);
    }
}
