package com.dt.platform.generator.module.oa;

import com.dt.platform.constants.db.OaTables;
import com.dt.platform.domain.oa.VehicleApply;
import com.dt.platform.domain.oa.VehicleInfo;
import com.dt.platform.domain.oa.VehicleMaintenance;

import com.github.foxnic.generator.config.WriteMode;

public class VehicleSelectItemGtr extends BaseCodeGenerator {

    public VehicleSelectItemGtr() {
        super(OaTables.OA_VEHICLE_SELECT_ITEM.$TABLE,"616256885288337408");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.view().search().inputLayout(
                new Object[]{
                        OaTables.OA_VEHICLE_SELECT_ITEM.ID,
                }
        );

        cfg.setRelationField(VehicleApply.class,OaTables.OA_VEHICLE_SELECT_ITEM.HANDLE_ID, VehicleInfo.class, OaTables.OA_VEHICLE_SELECT_ITEM.ASSET_ID,true);
        cfg.setRelationField(VehicleMaintenance.class,OaTables.OA_VEHICLE_SELECT_ITEM.HANDLE_ID, VehicleInfo.class,OaTables.OA_VEHICLE_SELECT_ITEM.ASSET_ID,true);


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
        VehicleSelectItemGtr g=new VehicleSelectItemGtr();

        //生成代码
        g.generateCode();
        //生成菜单

    }

}