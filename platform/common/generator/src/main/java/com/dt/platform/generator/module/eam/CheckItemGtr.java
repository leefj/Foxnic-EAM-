package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.CheckItemOwnerEnum;
import com.dt.platform.constants.enums.eam.CheckItemTypeEnum;
import com.dt.platform.constants.enums.eam.RfidStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.eam.meta.RfidLabelMeta;
import com.dt.platform.eam.page.CheckItemPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetServiceProxy;
import com.dt.platform.proxy.eam.CheckItemServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class CheckItemGtr extends BaseCodeGenerator {


    public CheckItemGtr() {
        super(EAMTables.EAM_CHECK_ITEM.$TABLE,"728712045951713281");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_CHECK_ITEM.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_CHECK_ITEM.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_CHECK_ITEM.CODE).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_CHECK_ITEM.OWNER,
                        EAMTables.EAM_CHECK_ITEM.STATUS,
                        EAMTables.EAM_CHECK_ITEM.TYPE,
                        EAMTables.EAM_CHECK_ITEM.NAME,
                        EAMTables.EAM_CHECK_ITEM.CODE,
                }
        );
        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(80);

        cfg.view().field(EAMTables.EAM_CHECK_ITEM.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_CHECK_ITEM.NOTES).form().textArea().height(150);
        cfg.view().field(EAMTables.EAM_CHECK_ITEM.TYPE).form().validate().required().form().radioBox().enumType(CheckItemTypeEnum.class).defaultIndex(0);
        cfg.view().field(EAMTables.EAM_CHECK_ITEM.OWNER).form().validate().required().form().radioBox().enumType(CheckItemOwnerEnum.class).defaultIndex(0);
        cfg.view().field(EAMTables.EAM_CHECK_ITEM.STATUS).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);
        cfg.view().field(EAMTables.EAM_CHECK_ITEM.CONFIG).form().textArea().height(200);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_CHECK_ITEM.NAME,
                        EAMTables.EAM_CHECK_ITEM.STATUS,
                        EAMTables.EAM_CHECK_ITEM.CHECK_DESC,
                },
                new Object[] {
                        EAMTables.EAM_CHECK_ITEM.CODE,
                        EAMTables.EAM_CHECK_ITEM.OWNER,

                }
        );

        cfg.view().form().addGroup("配置项",
                new Object[] {
                        EAMTables.EAM_CHECK_ITEM.TYPE,
                        EAMTables.EAM_CHECK_ITEM.CONFIG,
                        EAMTables.EAM_CHECK_ITEM.DEF_VALUE,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_CHECK_ITEM.NOTES,
                }
        );

        cfg.view().list().addJs("/module/commonFunction/eamCommonFunction.js");

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.WRITE_TEMP_FILE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        CheckItemGtr g=new CheckItemGtr();
        //生成代码
       g.generateCode();

     //   g.removeByBatchId("582429214846746624");
        //移除之前生成的菜单，视情况执行
    //  g.generateMenu(CheckItemServiceProxy.class, CheckItemPageController.class);
        //生成菜单

    }

}
