package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.BpmFormDataPageController;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.FormDefStatusEnum;
import com.dt.platform.domain.common.BpmFormData;
import com.dt.platform.domain.common.FormCategory;
import com.dt.platform.domain.common.FormData;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.BpmFormDataServiceProxy;
import com.github.foxnic.api.bpm.IntegrateMode;
import com.github.foxnic.generator.config.WriteMode;

public class SysBpmFormDataGtr extends BaseCodeGenerator{
    public SysBpmFormDataGtr() {
        super(SysTables.SYS_BPM_FORM_DATA.$TABLE,"484683104078794753");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(FormData.class,"formData","formData","formData");
        cfg.view().field(SysTables.SYS_BPM_FORM_DATA.ID).basic().hidden(true);

        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_BPM_FORM_DATA.NOTES,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.bpm().form("sys_bpm_common");
        cfg.bpm().integrate(IntegrateMode.FRONT);
        cfg.view().list().disableBatchDelete();

        //分成分组布局
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(200);
        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_BPM_FORM_DATA.ID,
                }
        );

        cfg.view().form().addJsVariable("CODE",   "[[${code}]]","CODE");
        cfg.view().form().addJsVariable("FORM_DATA_ID",   "[[${formDataId}]]","formDataId");
        cfg.view().form().addJsVariable("PAGE_TYPE",   "[[${pageType}]]","pageType");

        cfg.view().form().addPage(null,"formFunction");
        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setBpmEventAdaptor(WriteMode.COVER_EXISTS_FILE)
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        SysBpmFormDataGtr g=new SysBpmFormDataGtr();
        //生成代码
        g.generateCode();

        //生成菜单
        //g.removeByBatchId("");
     //   g.generateMenu(BpmFormDataServiceProxy.class, BpmFormDataPageController.class);
    }


}
