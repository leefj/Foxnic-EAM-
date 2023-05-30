package com.dt.platform.generator.module.common;

import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.FormColTypeEnum;
import com.dt.platform.constants.enums.common.LicenceStatusEnum;
import com.dt.platform.constants.enums.common.LicenceTypeEnum;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;

public class SysFormColGtr extends BaseCodeGenerator{
    public SysFormColGtr() {
        super(SysTables.SYS_FORM_DATA_COL.$TABLE,SE);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(SysTables.SYS_FORM_DATA_COL.ID).basic().hidden(true);


        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_FORM_DATA_COL.COL,

                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(SysTables.SYS_FORM_DATA_COL.STATUS).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class);
       cfg.view().field(SysTables.SYS_FORM_DATA_COL.COL_TYPE).form().validate().required().form().radioBox().enumType(FormColTypeEnum.class);



        //分成分组布局
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().formWindow().bottomSpace(200);
        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_FORM_DATA_COL.COL,

                }
        );


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        SysFormColGtr g=new SysFormColGtr();
        //生成代码
        g.generateCode();


        //生成菜单
        //g.removeByBatchId("");
       // g.generateMenu(LicenceSwitchServiceProxy.class, LicenceSwitchPageController.class);
    }


}
