package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.DeviceSp;
import com.dt.platform.domain.eam.DeviceSpRcd;
import com.dt.platform.domain.eam.meta.DeviceSpMeta;
import com.dt.platform.domain.eam.meta.DeviceSpRcdMeta;
import com.dt.platform.domain.eam.meta.PositionMeta;
import com.dt.platform.eam.page.DeviceSpRcdPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.DeviceSpRcdServiceProxy;
import com.dt.platform.proxy.eam.DeviceSpServiceProxy;
import com.dt.platform.proxy.eam.PositionServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class SpRcdGtr extends BaseCodeGenerator {


    public SpRcdGtr() {
        super(EAMTables.EAM_DEVICE_SP_RCD.$TABLE,"732382020847534081");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_DEVICE_SP_RCD.ID).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_DEVICE_SP_RCD.ID).table().hidden(true);

        cfg.getPoClassFile().addSimpleProperty(DeviceSp.class,"deviceSp","deviceSp","deviceSp");

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"operUser","operUser","operUser");
        cfg.view().field(EAMTables.EAM_DEVICE_SP_RCD.SP_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_DEVICE_SP_RCD.OPER_TIME).search().range();
        cfg.view().field(EAMTables.EAM_DEVICE_SP_RCD.CONTENT).search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_DEVICE_SP_RCD.OPER_TIME).form().dateInput().type(DatePickerType.datetime);
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_DEVICE_SP_RCD.SP_CODE,
                        EAMTables.EAM_DEVICE_SP_RCD.CONTENT,
                        EAMTables.EAM_DEVICE_SP_RCD.OPER_TIME,
                }
        );

        cfg.view().field(EAMTables.EAM_DEVICE_SP_RCD.SP_CODE).table().disable(true);
        cfg.view().field(EAMTables.EAM_DEVICE_SP_RCD.CONTENT).form().textArea().height(150);
        cfg.view().field(EAMTables.EAM_DEVICE_SP_RCD.OPER_ID).table().fillBy("operUser","name");
        cfg.view().field(EAMTables.EAM_DEVICE_SP_RCD.OPER_ID).form()
                .button().chooseEmployee(true);

        cfg.view().field(EAMTables.EAM_DEVICE_SP_RCD.SP_ID)
                .form().selectBox().queryApi(DeviceSpServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(DeviceSpMeta.ID).textField( DeviceSpMeta.NAME).fillWith(DeviceSpRcdMeta.DEVICE_SP).muliti(false);


        cfg.view().list().disableBatchDelete();
        cfg.view().list().disableCreateNew();
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(50);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_DEVICE_SP_RCD.SP_CODE,
                        EAMTables.EAM_DEVICE_SP_RCD.SP_ID,
                        EAMTables.EAM_DEVICE_SP_RCD.OPER_ID,
                        EAMTables.EAM_DEVICE_SP_RCD.OPER_TIME,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_DEVICE_SP_RCD.CONTENT,

                }
        );
        cfg.view().list().addJsVariable("SP_ID","[[${spId}]]","spId");

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        SpRcdGtr g=new SpRcdGtr();
        //生成代码
       g.generateCode();

     //   g.removeByBatchId("582429214846746624");
        //移除之前生成的菜单，视情况执行
  //    g.generateMenu(DeviceSpRcdServiceProxy.class, DeviceSpRcdPageController.class);
        //生成菜单

    }


}
