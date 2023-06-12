package com.dt.platform.generator.module.oa;

import com.dt.platform.constants.db.OaTables;
import com.github.foxnic.generator.config.WriteMode;

public class VehicleCompanyGtr extends BaseCodeGenerator {

    public VehicleCompanyGtr() {
        super(OaTables.OA_VEHICLE_INSURANCE_COMPANY.$TABLE,"616256885288337408");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.view().field(OaTables.OA_VEHICLE_INSURANCE_COMPANY.ID).basic().hidden(true);

        cfg.view().field(OaTables.OA_VEHICLE_INSURANCE_COMPANY.NAME).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        OaTables.OA_VEHICLE_INSURANCE_COMPANY.NAME
                }
        );

        cfg.view().list().disableBatchDelete();
        cfg.view().field(OaTables.OA_VEHICLE_INSURANCE_COMPANY.NAME).form().validate().required();
        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width("75%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_VEHICLE_INSURANCE_COMPANY.NAME,
                        OaTables.OA_VEHICLE_INSURANCE_COMPANY.NOTES,
                         }
                );

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
        VehicleCompanyGtr g=new VehicleCompanyGtr();
        //生成代码
        g.generateCode();
        //生成菜单

     // g.generateMenu(VehicleInsuranceCompanyServiceProxy.class, VehicleInsuranceCompanyPageController.class);
    }

}
