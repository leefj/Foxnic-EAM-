package com.dt.platform.generator.module.oa;

import com.dt.platform.constants.db.OaTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.oa.NoticeIfTopEnum;
import com.dt.platform.constants.enums.oa.NoticeTypeEnum;
import com.dt.platform.generator.config.Config;
import com.dt.platform.oa.page.NoticePageController;
import com.dt.platform.proxy.oa.NoticeServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;

public class NoticeGtr extends BaseCodeGenerator {


    public NoticeGtr() {
        super(OaTables.OA_NOTICE.$TABLE,"708039216537272320");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(OaTables.OA_NOTICE.ID).basic().hidden(true);
        cfg.view().field(OaTables.OA_NOTICE.TITLE).search().fuzzySearch();
        cfg.view().field(OaTables.OA_NOTICE.NUMBER).search().fuzzySearch();

        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"typeData","类型","类型");

        cfg.view().search().inputLayout(
                new Object[]{
                        OaTables.OA_NOTICE.STATUS,
                        OaTables.OA_NOTICE.TYPE,
                        OaTables.OA_NOTICE.TITLE,
                        OaTables.OA_NOTICE.NUMBER,
                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(OaTables.OA_NOTICE.STATUS).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);
        cfg.view().field(OaTables.OA_NOTICE.IFTOP).form().validate().required().form().radioBox().enumType(NoticeIfTopEnum.class).defaultIndex(1);


        cfg.view().field(OaTables.OA_NOTICE.TITLE).form().validate().required();

        cfg.view().field(OaTables.OA_NOTICE.ATTACH)
                .form().label("附件").upload().buttonLabel("选择附件").maxFileCount(1).displayFileName(false);



        cfg.view().field(OaTables.OA_NOTICE.TYPE).form().validate().required().form().radioBox().enumType(NoticeTypeEnum.class).defaultIndex(0);



        cfg.view().field(OaTables.OA_NOTICE.ATTACH).table().disable(true);
        cfg.view().field(OaTables.OA_NOTICE.CONTENT).table().disable(true);

        cfg.view().formWindow().bottomSpace(150);
        cfg.view().formWindow().width(Config.baseFormWidth);

        cfg.view().list().operationColumn().addActionButton("预览","reviewNotice","oa_notice-view","oa_notice:view");

        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_NOTICE.TITLE,
                        OaTables.OA_NOTICE.TYPE,
                        OaTables.OA_NOTICE.IFTOP,
                },
                new Object[] {
                        OaTables.OA_NOTICE.NUMBER,
                        OaTables.OA_NOTICE.STATUS,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_NOTICE.ATTACH,
                        OaTables.OA_NOTICE.CONTENT,

                }
        );


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        NoticeGtr g=new NoticeGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
      //  g.generateMenu(NoticeServiceProxy.class, NoticePageController.class);
    }

}
