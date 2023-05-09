package com.dt.platform.generator.module.oa;

import com.dt.platform.constants.db.OaTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.common.StatusValidEnum;
import com.dt.platform.domain.oa.SystemInformation;
import com.dt.platform.domain.oa.meta.SystemInformationMeta;
import com.dt.platform.domain.vehicle.meta.InfoMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.oa.page.BannerPageController;
import com.dt.platform.oa.page.SystemInformationPageController;
import com.dt.platform.proxy.oa.BannerServiceProxy;
import com.dt.platform.proxy.oa.SystemInformationServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class SystemInformationGtr extends BaseCodeGenerator {


    public SystemInformationGtr() {
        super(OaTables.OA_SYSTEM_INFORMATION.$TABLE,"616256406374318080");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(OaTables.OA_SYSTEM_INFORMATION.ID).basic().hidden(true);
        cfg.view().field(OaTables.OA_SYSTEM_INFORMATION.NAME).search().fuzzySearch();
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"typeData","类型","类型");
        cfg.view().search().inputLayout(
                new Object[]{
                        OaTables.OA_SYSTEM_INFORMATION.STATUS,
                        OaTables.OA_SYSTEM_INFORMATION.TYPE,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(OaTables.OA_SYSTEM_INFORMATION.STATUS).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);

        cfg.view().field(OaTables.OA_SYSTEM_INFORMATION.NAME).form().validate().required();
        cfg.view().field(OaTables.OA_SYSTEM_INFORMATION.PICTURE_ID)
                .form().label("图片").upload().buttonLabel("选择图片").maxFileCount(1).displayFileName(false);

        cfg.view().field(OaTables.OA_SYSTEM_INFORMATION.TYPE)
                .basic().label("分类")
                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=oa_system_information_type")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(SystemInformationMeta.TYPE_DATA).muliti(false);


        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_SYSTEM_INFORMATION.NAME,
                        OaTables.OA_SYSTEM_INFORMATION.TYPE,
                        OaTables.OA_SYSTEM_INFORMATION.STATUS,
                        OaTables.OA_SYSTEM_INFORMATION.URL,
                        OaTables.OA_SYSTEM_INFORMATION.PICTURE_ID,
                        OaTables.OA_SYSTEM_INFORMATION.NOTES,

                }
        );


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        SystemInformationGtr g=new SystemInformationGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
       g.generateMenu(SystemInformationServiceProxy.class, SystemInformationPageController.class);
    }

}
