package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class EamProcessRecordGtr extends BaseCodeGenerator{
    public EamProcessRecordGtr() {
        super(EAMTables.EAM_ASSET_PROCESS_RECORD.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());


        cfg.view().field(EAMTables.EAM_ASSET_PROCESS_RECORD.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET_PROCESS_RECORD.CONTENT).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_PROCESS_RECORD.NOTES).search().fuzzySearch();
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"operUser","operUser","operUser");


        cfg.view().field(EAMTables.EAM_ASSET_PROCESS_RECORD.PROCESSD_TIME).form().dateInput().type(DatePickerType.datetime).format("yyyy-MM-dd HH:mm:ss").search().range();
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_PROCESS_RECORD.PROCESS_TYPE,
                        EAMTables.EAM_ASSET_PROCESS_RECORD.CONTENT,
                        EAMTables.EAM_ASSET_PROCESS_RECORD.NOTES,
                }
        );


        cfg.view().list().disableBatchDelete();
        cfg.view().list().disableCreateNew();
        cfg.view().list().disableModify();
        cfg.view().list().disableSingleDelete();
        cfg.view().list().disableSpaceColumn();
        cfg.view().field(EAMTables.EAM_ASSET_PROCESS_RECORD.PROCESS_TYPE).form()
                .label("操作类型").selectBox().enumType(AssetOperateEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET_PROCESS_RECORD.ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_PROCESS_RECORD.CREATE_TIME).table().hidden();

        cfg.view().field(EAMTables.EAM_ASSET_PROCESS_RECORD.USE_USER_ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_PROCESS_RECORD.NOTES).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_PROCESS_RECORD.CREATE_TIME).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_PROCESS_RECORD.UPDATE_BY).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_PROCESS_RECORD.ASSET_ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_PROCESS_RECORD.NOTES).form().textArea().height(120);
        cfg.view().field(EAMTables.EAM_ASSET_PROCESS_RECORD.PROCESSD_TIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").search().range();

        cfg.view().field(EAMTables.EAM_ASSET_PROCESS_RECORD.ID).form().hidden();
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().formWindow().width(Config.baseFormWidth);

        cfg.view().field(EAMTables.EAM_ASSET_PROCESS_RECORD.PROCESS_USER_ID).table().fillBy("operUser","name");
        cfg.view().field(EAMTables.EAM_ASSET_PROCESS_RECORD.PROCESS_USER_ID).form()
                .button().chooseEmployee(true);


        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_PROCESS_RECORD.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_PROCESS_RECORD.PROCESS_USER_ID,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_PROCESS_RECORD.PROCESS_TYPE,
                        EAMTables.EAM_ASSET_PROCESS_RECORD.PROCESSD_TIME,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_PROCESS_RECORD.CONTENT,
                        EAMTables.EAM_ASSET_PROCESS_RECORD.NOTES,
                }
        );



        cfg.view().list().addJsVariable("SOURCE","[[${source}]]","source");
        cfg.view().list().addJsVariable("ASSET_ID","[[${assetId}]]","资产ID");

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.WRITE_TEMP_FILE) //表单HTML页
                .setListPage(WriteMode.WRITE_TEMP_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EamProcessRecordGtr g=new EamProcessRecordGtr();
        //生成代码
         g.generateCode();
        //g.generateMenu(AssetProcessRecordServiceProxy.class, AssetProcessRecordPageController.class);

    }
}
