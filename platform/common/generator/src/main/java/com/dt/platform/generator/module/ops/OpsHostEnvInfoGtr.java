package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.ops.OpsDbEnvEnum;
import com.dt.platform.domain.ops.CiphertextBoxData;
import com.dt.platform.domain.ops.DbInfo;
import com.dt.platform.domain.ops.Host;
import com.dt.platform.domain.ops.InformationSystem;
import com.dt.platform.domain.ops.meta.DbEnvInfoMeta;
import com.dt.platform.domain.ops.meta.HostEnvInfoMeta;
import com.dt.platform.domain.ops.meta.HostMeta;
import com.dt.platform.domain.ops.meta.InformationSystemMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.HostEnvInfoPageController;
import com.dt.platform.proxy.ops.HostEnvInfoServiceProxy;
import com.dt.platform.proxy.ops.InformationSystemServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class OpsHostEnvInfoGtr extends BaseCodeGenerator{


    public OpsHostEnvInfoGtr() {
        super(OpsTables.OPS_HOST_ENV_INFO.$TABLE,"472818410917462016");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

//        cfg.view().field(OpsTables.OPS_DB_ENV_INFO.DB_INST_ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_HOST_ENV_INFO.ID).table().disable(true);
//        cfg.getPoClassFile().addSimpleProperty(Host.class,"host","host","host");
//        cfg.getPoClassFile().addSimpleProperty(String.class,"hostName","hostName","hostName");
//        cfg.getPoClassFile().addSimpleProperty(String.class,"hostIp","hostIp","hostIp");
//        cfg.getPoClassFile().addSimpleProperty(DbInfo.class,"dbInfo","dbInfo","dbInfo");
//        cfg.getPoClassFile().addSimpleProperty(String.class,"dbName","dbName","dbName");

        cfg.getPoClassFile().addSimpleProperty(CiphertextBoxData.class,"ciphertextBoxData","ciphertextBoxData","ciphertextBoxData");


        cfg.view().field(OpsTables.OPS_DB_ENV_INFO.IP).search().fuzzySearch();


        cfg.getPoClassFile().addSimpleProperty(InformationSystem.class,"infoSystem","信息系统","信息系统");


        cfg.view().field(OpsTables.OPS_HOST_ENV_INFO.NOTES).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_HOST_ENV_INFO.IP).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_HOST_ENV_INFO.VIP).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_HOST_ENV_INFO.HOST_DESC).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_HOST_ENV_INFO.IP).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_HOST_ENV_INFO.SYSTEM_ID,
                        OpsTables.OPS_HOST_ENV_INFO.LABEL,
                        OpsTables.OPS_HOST_ENV_INFO.IP,
                        OpsTables.OPS_HOST_ENV_INFO.VIP,

                },
                new Object[]{
                        OpsTables.OPS_HOST_ENV_INFO.HOST_DESC,
                        OpsTables.OPS_HOST_ENV_INFO.NOTES,
                }
        );




        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().list().disableBatchDelete();

        cfg.view().field(OpsTables.OPS_HOST_ENV_INFO.HOSTNAME).form().validate().required();
        cfg.view().field(OpsTables.OPS_HOST_ENV_INFO.IP).form().validate().required();

        cfg.view().field(OpsTables.OPS_HOST_ENV_INFO.LABEL).form().validate().required().form()
                .radioBox().enumType(OpsDbEnvEnum.class).defaultIndex(0);


        cfg.view().field(OpsTables.OPS_HOST_ENV_INFO.IPV6).table().disable(true);

        cfg.view().field(OpsTables.OPS_HOST_ENV_INFO.NOTES).form().textArea().height(120);
        cfg.view().field(OpsTables.OPS_HOST_ENV_INFO.VOUCHER).form().textArea().height(150);
        cfg.view().field(OpsTables.OPS_HOST_ENV_INFO.VOUCHER).table().hidden(true);
        cfg.view().field(OpsTables.OPS_HOST_ENV_INFO.CREATE_TIME).table().hidden(true);

        cfg.view().field(OpsTables.OPS_HOST_ENV_INFO.SYSTEM_ID)
                .basic().label("信息系统")
                .table().sort(false)
                .form().selectBox().queryApi(InformationSystemServiceProxy.QUERY_LIST)
                .valueField(InformationSystemMeta.ID).textField(InformationSystemMeta.NAME)
                .toolbar(false).paging(false)
                .fillWith(HostEnvInfoMeta.INFO_SYSTEM).muliti(false);


        cfg.view().formWindow().bottomSpace(200);
        cfg.view().formWindow().width(Config.baseFormWidth_95);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_HOST_ENV_INFO.LABEL,
                        OpsTables.OPS_HOST_ENV_INFO.HOSTNAME,
                        OpsTables.OPS_HOST_ENV_INFO.IP,


                },
                new Object[] {
                        OpsTables.OPS_HOST_ENV_INFO.SYSTEM_ID,
                        OpsTables.OPS_HOST_ENV_INFO.HOST_DESC,
                        OpsTables.OPS_HOST_ENV_INFO.VIP,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {

                        OpsTables.OPS_HOST_ENV_INFO.VOUCHER,
                        OpsTables.OPS_HOST_ENV_INFO.NOTES,
                }

        );

//        cfg.view().list().addJsVariable("INST_ID","[[${instId}]]","INST_ID");
//        cfg.view().form().addJsVariable("INST_ID","[[${instId}]]","INST_ID");


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setBpmEventAdaptor(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        OpsHostEnvInfoGtr g=new OpsHostEnvInfoGtr();
        //生成代码
        g.generateCode();
        //g.generateMenu(HostEnvInfoServiceProxy.class, HostEnvInfoPageController.class);

    }
}
