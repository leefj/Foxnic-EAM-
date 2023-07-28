package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.eam.RelatedItems;
import com.dt.platform.eam.page.RelatedItemsPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.RelatedItemsServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class CommonRelatedItemsGtr extends BaseCodeGenerator {


    public CommonRelatedItemsGtr() {
        super(EAMTables.EAM_RELATED_ITEMS.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_RELATED_ITEMS.ID).basic().hidden(true);



        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_RELATED_ITEMS.OWNER_ID,

                }
        );

        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_RELATED_ITEMS.OWNER_ID,
                        EAMTables.EAM_RELATED_ITEMS.ITEM_ID,
                }
        );

        cfg.view().search().inputWidth(Config.searchInputWidth);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        CommonRelatedItemsGtr g=new CommonRelatedItemsGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
      // g.generateMenu(RelatedItemsServiceProxy.class, RelatedItemsPageController.class);
        //生成菜单

    }

}
