package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.constants.enums.common.ValidStatusEnum;
import com.dt.platform.domain.ops.meta.DbDocMeta;
import com.dt.platform.domain.ops.meta.HostMeta;
import com.dt.platform.domain.ops.meta.HostVOMeta;
import com.dt.platform.domain.ops.meta.VoucherMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.DbDocPageController;
import com.dt.platform.proxy.ops.DbDocServiceProxy;
import com.dt.platform.proxy.ops.VoucherPrivServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class OpsDbDocGtr extends BaseCodeGenerator{


    public OpsDbDocGtr() {
        super(OpsTables.OPS_DB_DOC.$TABLE,"478178015856033792");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"typeData","typeData","typeData");

        cfg.view().field(OpsTables.OPS_DB_DOC.NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_DB_DOC.NOTES).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_DB_DOC.TYPE,
                        OpsTables.OPS_DB_DOC.STATUS,
                        OpsTables.OPS_DB_DOC.NAME,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(OpsTables.OPS_DB_DOC.STATUS).form().validate().required().form().radioBox().enumType(ValidStatusEnum.class).defaultIndex(0);
        cfg.view().field(OpsTables.OPS_DB_DOC.FILE_ID).form().upload().maxFileCount(6).acceptAllType();

        cfg.view().field(OpsTables.OPS_DB_DOC.TYPE)
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=ops_doc_type")
                .valueField(DictItemMeta.CODE).textField(DictItemMeta.LABEL)
                .toolbar(false).paging(false)
                .fillWith(DbDocMeta.TYPE_DATA).muliti(false);

        cfg.view().field(OpsTables.OPS_DB_DOC.NOTES).form()
               .textArea().height(Config.textAreaHeight);

        cfg.view().list().disableBatchDelete();

        cfg.view().formWindow().bottomSpace(60);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_DB_DOC.NAME,
                        OpsTables.OPS_DB_DOC.TYPE,
                        OpsTables.OPS_DB_DOC.STATUS,
                        OpsTables.OPS_DB_DOC.FILE_ID,
                        OpsTables.OPS_DB_DOC.NOTES,
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
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        OpsDbDocGtr g=new OpsDbDocGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
       // g.generateMenu(DbDocServiceProxy.class, DbDocPageController.class);
    }
}
