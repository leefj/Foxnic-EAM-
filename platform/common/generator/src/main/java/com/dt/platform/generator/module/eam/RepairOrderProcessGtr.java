package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.eam.RepairGroup;
import com.dt.platform.domain.eam.meta.RepairGroupMeta;
import com.dt.platform.domain.eam.meta.RepairRuleMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.GroupUserServiceProxy;
import com.dt.platform.proxy.eam.RepairGroupServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.meta.PersonMeta;

public class RepairOrderProcessGtr extends BaseCodeGenerator {


    public RepairOrderProcessGtr() {
        super(EAMTables.EAM_REPAIR_ORDER_PROCESS.$TABLE,"583208716988317696");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_PROCESS.ID).basic().hidden(true);

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_REPAIR_ORDER_PROCESS.ORDER_ID,
                        EAMTables.EAM_REPAIR_ORDER_PROCESS.ACT_ID,
                }
        );

        cfg.view().formWindow().width("75%");
        cfg.view().formWindow().bottomSpace(120);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_REPAIR_ORDER_PROCESS.ORDER_ID,
                        EAMTables.EAM_REPAIR_ORDER_PROCESS.ACT_ID,
                        EAMTables.EAM_REPAIR_ORDER_PROCESS.USER_ID,
                        EAMTables.EAM_REPAIR_ORDER_PROCESS.USER_NAME,
                        EAMTables.EAM_REPAIR_ORDER_PROCESS.PROCESS_CONTENT,
                        EAMTables.EAM_REPAIR_ORDER_PROCESS.NOTES,
                }

        );
        
        cfg.view().list().disableBatchDelete();
        cfg.view().search().inputWidth(Config.searchInputWidth);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        RepairOrderProcessGtr g=new RepairOrderProcessGtr();
        //生成代码
        g.generateCode();

        // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
        //g.generateMenu(RepairRuleServiceProxy.class, RepairRulePageController.class);
        //生成菜单

    }

}