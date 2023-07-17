package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.DeviceSpModifyStatusEnum;
import com.dt.platform.eam.page.DeviceSpStatusPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.DeviceSpStatusServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class SpStatusGtr extends BaseCodeGenerator {


    public SpStatusGtr() {
        super(EAMTables.EAM_DEVICE_SP_STATUS.$TABLE,"728713069663879169");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_DEVICE_SP_STATUS.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_DEVICE_SP_STATUS.ID).table().hidden(true);

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_DEVICE_SP_STATUS.SP_ID,
                        EAMTables.EAM_DEVICE_SP_STATUS.STATUS,

                }
        );

        cfg.view().field(EAMTables.EAM_DEVICE_SP_STATUS.STATUS).form().validate().required().form().radioBox().enumType(DeviceSpModifyStatusEnum.class).defaultValue(0);
        cfg.view().field(EAMTables.EAM_DEVICE_SP_STATUS.CONTENT).form().textArea().height(150);


        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(50);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_DEVICE_SP_STATUS.STATUS,
                        EAMTables.EAM_DEVICE_SP_STATUS.CONTENT,

                }

        );

        cfg.view().form().addJsVariable("SP_ID","[[${spId}]]","spId");

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
        SpStatusGtr g=new SpStatusGtr();
        //生成代码
       g.generateCode();

     //   g.removeByBatchId("582429214846746624");
        //移除之前生成的菜单，视情况执行
      //g.generateMenu(DeviceSpStatusServiceProxy.class, DeviceSpStatusPageController.class);
        //生成菜单

    }

}
