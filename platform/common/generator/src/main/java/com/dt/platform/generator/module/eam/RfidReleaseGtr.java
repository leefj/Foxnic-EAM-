package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.RfidStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.RfidLabel;
import com.dt.platform.domain.eam.RfidRelease;
import com.dt.platform.eam.page.RfidReleasePageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.RfidReleaseServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class RfidReleaseGtr extends BaseCodeGenerator {


    public RfidReleaseGtr() {
        super(EAMTables.EAM_RFID_RELEASE.$TABLE,"489424103724285952");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_RFID_LABEL.ID).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_RFID_RELEASE.NAME).search().fuzzySearch();


        cfg.getPoClassFile().addListProperty(RfidLabel.class,"rfidLabelList","rfidLabelList","rfidLabelList");
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_RFID_RELEASE.STATUS,
                        EAMTables.EAM_RFID_RELEASE.NAME,
                }
        );

        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().list().excel(false,false);

        cfg.view().list().disableBatchDelete();

        cfg.view().field(EAMTables.EAM_RFID_RELEASE.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_RFID_RELEASE.STATUS).form().validate().required().form().radioBox().enumType(RfidStatusEnum.class).defaultIndex(0);
        cfg.view().list().operationColumn().addActionButton("明细","detail_data","detail_data");

        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_RFID_RELEASE.NAME,
                        EAMTables.EAM_RFID_RELEASE.NOTES,
                }
        );

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
        RfidReleaseGtr g=new RfidReleaseGtr();
        //生成代码
       g.generateCode();

     //   g.removeByBatchId("582429214846746624");
        //移除之前生成的菜单，视情况执行
   //   g.generateMenu(RfidReleaseServiceProxy.class, RfidReleasePageController.class);
        //生成菜单

    }

}
