package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.domain.ops.SecurityInfoLib;
import com.dt.platform.domain.ops.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.SecurityInfoLibPageController;
import com.dt.platform.proxy.ops.DbApplyExecuteServiceProxy;
import com.dt.platform.proxy.ops.SecurityInfoLibServiceProxy;
import com.dt.platform.proxy.ops.ServiceInfoServiceProxy;
import com.dt.platform.proxy.ops.VoucherPrivServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

import java.util.Arrays;

public class LIbGtr extends BaseCodeGenerator{


    public LIbGtr() {
        super(OpsTables.OPS_SECURITY_INFO_LIB.$TABLE,"472036556115279872");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(OpsTables.OPS_SECURITY_INFO_LIB.ID).basic().hidden(true);


        cfg.view().field(OpsTables.OPS_SECURITY_INFO_LIB.NAME).form().search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_SECURITY_INFO_LIB.BUSINESS_DATA).search().range();

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_SECURITY_INFO_LIB.NAME,
                        OpsTables.OPS_SECURITY_INFO_LIB.TYPE,
                        OpsTables.OPS_SECURITY_INFO_LIB.SOURCE,
                        OpsTables.OPS_SECURITY_INFO_LIB.SEC_LEVEL,
                },
                new Object[]{
                        OpsTables.OPS_SECURITY_INFO_LIB.BUSINESS_DATA,

                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);

        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(OpsTables.OPS_SECURITY_INFO_LIB.NAME).form().validate().required();

        cfg.view().field(OpsTables.OPS_SECURITY_INFO_LIB.DATA_SCORE).form().textArea().height(150);
        cfg.view().field(OpsTables.OPS_SECURITY_INFO_LIB.PROCESS_CT).form().textArea().height(150);
        cfg.view().field(OpsTables.OPS_SECURITY_INFO_LIB.NOTES).form().textArea().height(150);

        cfg.view().field(OpsTables.OPS_SECURITY_INFO_LIB.BUSINESS_DATA).form().dateInput().type(DatePickerType.date).format("yyyy-MM-dd");


        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"typeDict","typeDict","typeDict");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"sourceDict","sourceDict","sourceDict");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"levelDict","levelDict","levelDict");


        cfg.view().formWindow().bottomSpace(60);
        cfg.view().formWindow().width(Config.baseFormWidth);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_SECURITY_INFO_LIB.NAME,
                        OpsTables.OPS_SECURITY_INFO_LIB.TYPE,
                        OpsTables.OPS_SECURITY_INFO_LIB.BUSINESS_DATA,
                },
                new Object[] {
                        OpsTables.OPS_SECURITY_INFO_LIB.SEC_LEVEL,
                        OpsTables.OPS_SECURITY_INFO_LIB.SOURCE,
                        OpsTables.OPS_SECURITY_INFO_LIB.SOURCE_NAME,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_SECURITY_INFO_LIB.DATA_SCORE,
                        OpsTables.OPS_SECURITY_INFO_LIB.PROCESS_CT,
                        OpsTables.OPS_SECURITY_INFO_LIB.NOTES

                }
        );

        cfg.view().field(OpsTables.OPS_SECURITY_INFO_LIB.UPDATE_BY).table().disable(true);

        cfg.view().field(OpsTables.OPS_SECURITY_INFO_LIB.NOTES).table().disable(true);

        cfg.view().field(OpsTables.OPS_SECURITY_INFO_LIB.PROCESS_CT).table().disable(true);


        cfg.view().field(OpsTables.OPS_SECURITY_INFO_LIB.TYPE)
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=ops_lib_type")
                .valueField(DictItemMeta.CODE).textField(DictItemMeta.LABEL)
                .toolbar(false).paging(false)
                .fillWith(SecurityInfoLibMeta.TYPE_DICT).muliti(false);

        cfg.view().field(OpsTables.OPS_SECURITY_INFO_LIB.SOURCE)
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=ops_lib_source")
                .valueField(DictItemMeta.CODE).textField(DictItemMeta.LABEL)
                .toolbar(false).paging(false)
                .fillWith(SecurityInfoLibMeta.SOURCE_DICT).muliti(false);

        cfg.view().field(OpsTables.OPS_SECURITY_INFO_LIB.SEC_LEVEL)
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=ops_lib_level")
                .valueField(DictItemMeta.CODE).textField(DictItemMeta.LABEL)
                .toolbar(false).paging(false)
                .fillWith(SecurityInfoLibMeta.LEVEL_DICT).muliti(false);
          cfg.view().list().operationColumn().width(280);

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

//        String ABC="这是测试#<list_value>#，当前数据为#<list_value2>#。";
//
//        String[] msg=ABC.split("#<");
//        for(int i=0;i<msg.length;i++){
//            if(msg[i].contains(">#")){
//                System.out.println(msg[i]);
//                String[] key= msg[i].split(">#") ;
//                System.out.println(key[0]);
//            }
//        }
//        System.out.println(msg.length);


        LIbGtr g=new LIbGtr();

        g.generateCode();

        g.removeByBatchId("478921035245158400");
        g.generateMenu(SecurityInfoLibServiceProxy.class, SecurityInfoLibPageController.class);
    }
}
