package com.dt.platform.relation.modules;


import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.domain.common.BpmFormData;
import com.dt.platform.domain.common.meta.*;
import com.dt.platform.domain.eam.meta.RepairOrderActMeta;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;

public class CommonRelationManager extends RelationManager {
    @Override
    protected void config() {
        this.setupRelations();
        this.setupAllocation();
        this.setupCode();
        this.setupCodeAllocation();
        this.setupTplFile();
        this.setupDbBackup();
        this.setupAutoRoleGrantRcd();
        this.setupReport();
        this.setupFormInfo();
        this.setupBpmFormData();

    }

    public void setupBpmFormData() {
        this.property(BpmFormDataMeta.FORM_DATA_PROP)
                .using(SysTables.SYS_BPM_FORM_DATA.FORM_DATA_ID).join(SysTables.SYS_FORM_DATA.ID);

    }


    public void setupFormInfo() {
        this.property(FormInfoMeta.FORM_CATEGORY_PROP)
                .using(SysTables.SYS_FORM_INFO.CATALOG_ID).join(SysTables.SYS_FORM_CATEGORY.ID);

        this.property(FormInfoMeta.FORM_DEF_PROP)
                .using(SysTables.SYS_FORM_INFO.ID).join(SysTables.SYS_FORM_DEF.FORM_ID)
                .condition("status='apply'");
    }

    public void setupReport() {
        this.property(ReportMeta.REPORT_CATEGORY_PROP)
                .using(SysTables.SYS_REPORT.CATALOG_ID).join(SysTables.SYS_REPORT_CATEGORY.ID);

        this.property(ReportMeta.REPORT_TPL_PROP)
                .using(SysTables.SYS_REPORT.REPORT_TPL_ID).join(SysTables.SYS_REPORT_U_DEF.ID);

    }

    public void setupAutoRoleGrantRcd() {
        //制单人
        this.property(AutoRoleGrantRcdMeta.USER_PROP)
                .using(SysTables.SYS_AUTO_ROLE_GRANT_RCD.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
    }

    public void setupDbBackup() {
        // 管理规则
//        this.property(BackupDbMeta.FILE_PROP)
//                .using(SysTables.SYS_BACKUP_DB.FILE_ID).join(FoxnicWeb.SYS_FILE.ID);
    }

    public void setupAllocation() {
        // 管理规则
        this.property(CodeAllocationMeta.RULE_PROP)
                .using(EAMTables.SYS_CODE_ALLOCATION.RULE_ID).join(EAMTables.SYS_CODE_RULE.ID);

    }


    private void setupTplFile() {
        this.property(TplFileMeta.BUSINESS_CODE_PROP)
                .using(EAMTables.SYS_TPL_FILE.CODE).join(EAMTables.SYS_CODE_REGISTER.CODE);
    }


    private void setupRelations() {

    }

    private void setupCode() {
        this.property(CodeRuleMeta.MODULE_PROP)
                .using(EAMTables.SYS_CODE_RULE.MODULE_ID).join(FoxnicWeb.SYS_MENU.ID);

    }

    private void setupCodeAllocation() {
        this.property(CodeAllocationMeta.BUSINESS_CODE_PROP)
                .using(EAMTables.SYS_CODE_ALLOCATION.CODE).join(EAMTables.SYS_CODE_REGISTER.CODE);

    }


}
