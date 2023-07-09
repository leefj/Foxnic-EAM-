package com.dt.platform.relation.modules;


import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.domain.common.*;
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

        this.setupPayApp();
        this.setupPayChannel();
        this.setupPayNotifyLog();
        this.setupPayNotifyTask();
        this.setupPayOrderExt();
        this.setupPayOrder();
        this.setupRefund();



    }

    public void setupPayOrderExt() {
        this.property(PayOrderExtMeta.PAY_ORDER_PROP)
                .using(SysTables.SYS_PAY_ORDER_EXT.ORDER_ID).join(SysTables.SYS_PAY_ORDER.ID);
    }


    public void setupPayNotifyLog() {
        this.property(PayNotifyLogMeta.PAY_NOTIFY_TASK_PROP)
                .using(SysTables.SYS_PAY_NOTIFY_LOG.TASK_ID).join(SysTables.SYS_PAY_NOTIFY_TASK.ID);

    }

    public void setupPayNotifyTask() {
        this.property(PayNotifyTaskMeta.PAY_APP_PROP)
                .using(SysTables.SYS_PAY_NOTIFY_TASK.APP_ID).join(SysTables.SYS_PAY_APP.ID);
        this.property(PayNotifyTaskMeta.PAY_MERCHANT_PROP)
                .using(SysTables.SYS_PAY_NOTIFY_TASK.MERCHANT_ID).join(SysTables.SYS_PAY_MERCHANT.ID);
    }



    public void setupPayOrder() {

        this.property(PayOrderMeta.PAY_APP_PROP)
                .using(SysTables.SYS_PAY_ORDER.APP_ID).join(SysTables.SYS_PAY_APP.ID);
        this.property(PayOrderMeta.PAY_MERCHANT_PROP)
                .using(SysTables.SYS_PAY_ORDER.MERCHANT_ID).join(SysTables.SYS_PAY_MERCHANT.ID);
        this.property(PayOrderMeta.PAY_CHANNEL_PROP)
                .using(SysTables.SYS_PAY_ORDER.CHANNEL_ID).join(SysTables.SYS_PAY_CHANNEL.ID);
        this.property(PayOrderMeta.PAY_ORDER_EXT_PROP)
                .using(SysTables.SYS_PAY_ORDER.ID).join(SysTables.SYS_PAY_ORDER_EXT.ORDER_ID);

    }

    public void setupRefund() {
        this.property(PayRefundMeta.PAY_APP_PROP)
                .using(SysTables.SYS_PAY_REFUND.ID).join(SysTables.SYS_PAY_APP.ID);

        this.property(PayRefundMeta.PAY_MERCHANT_PROP)
                .using(SysTables.SYS_PAY_REFUND.MERCHANT_ID).join(SysTables.SYS_PAY_MERCHANT.ID);

        this.property(PayRefundMeta.PAY_CHANNEL_PROP)
                .using(SysTables.SYS_PAY_REFUND.CHANNEL_ID).join(SysTables.SYS_PAY_CHANNEL.ID);

        this.property(PayRefundMeta.PAY_ORDER_PROP)
                .using(SysTables.SYS_PAY_REFUND.ORDER_ID).join(SysTables.SYS_PAY_ORDER.ID);
    }

    public void setupPayApp() {
        this.property(PayAppMeta.PAY_MERCHANT_PROP)
                .using(SysTables.SYS_PAY_APP.MERCHANT_ID).join(SysTables.SYS_PAY_MERCHANT.ID);

    }
    public void setupPayChannel() {
        this.property(PayChannelMeta.PAY_MERCHANT_PROP)
                .using(SysTables.SYS_PAY_CHANNEL.MERCHANT_ID).join(SysTables.SYS_PAY_MERCHANT.ID);

        this.property(PayChannelMeta.PAY_APP_PROP)
                .using(SysTables.SYS_PAY_CHANNEL.APP_ID).join(SysTables.SYS_PAY_APP.ID);
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
