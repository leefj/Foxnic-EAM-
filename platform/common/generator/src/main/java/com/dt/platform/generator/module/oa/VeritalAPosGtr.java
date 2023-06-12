package com.dt.platform.generator.module.oa;

import com.dt.platform.constants.db.OaTables;
import com.dt.platform.domain.oa.VehicleApply;
import com.github.foxnic.generator.config.WriteMode;

public class VeritalAPosGtr extends BaseCodeGenerator {

    public VeritalAPosGtr() {
        super(OaTables.OA_VEHICLE_POSITION.$TABLE,"616256885288337408");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.view().search().inputLayout(
                new Object[]{
                        OaTables.OA_VEHICLE_POSITION.ID,
                }
        );


        //  public void setRelationField(Class masterPoType, DBField masterIdField, Class slavePoType, DBField slaveIdField, boolean clearWhenEmpty) {
        //一对多， A=Apply B=Info，  中间保存表VehicleTables.VEHICLE_A_SELECT_ITEM.HANDLE_ID
     //   cfg.setRelationField(VehicleApply.class,OaTables.OA_VEHICLE_POSITION.HANDLE_ID, Info.class, VehicleTables.VEHICLE_A_SELECT_ITEM.ASSET_ID,true);


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE);
        ; //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        VeritalAPosGtr g=new VeritalAPosGtr();

        //生成代码
        g.generateCode();
        //生成菜单

    }

}
