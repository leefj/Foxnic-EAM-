package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.ops.CertificateStatusEnum;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.ops.*;
import com.dt.platform.domain.ops.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.AutoNodePageController;
import com.dt.platform.proxy.ops.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class AutoNodeGtr extends BaseCodeGenerator{


    public AutoNodeGtr() {
        super(OpsTables.OPS_AUTO_NODE.$TABLE,"613652361268690944");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"typeDict","typeDict","typeDict");
        cfg.getPoClassFile().addSimpleProperty(AutoGroup.class,"group","group","group");
        cfg.getPoClassFile().addSimpleProperty(AutoVoucher.class,"voucher","voucher","voucher");

        cfg.view().field(OpsTables.OPS_AUTO_NODE.NOTES).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_AUTO_NODE.NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_AUTO_NODE.IP).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_AUTO_NODE.STATUS,
                        OpsTables.OPS_AUTO_NODE.NAME,
                        OpsTables.OPS_AUTO_NODE.IP,
                        OpsTables.OPS_AUTO_NODE.NOTES,
                }
        );


        cfg.view().field(OpsTables.OPS_AUTO_NODE.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_AUTO_NODE.STATUS).table().form().validate().required().form().radioBox().enumType(StatusEnableEnum.class).defaultIndex(0);
        cfg.view().field(OpsTables.OPS_AUTO_NODE.NAME).table().form().validate().required();
        cfg.view().field(OpsTables.OPS_AUTO_NODE.NOTES).table().form().textArea().height(Config.textAreaHeight);


        cfg.view().field(OpsTables.OPS_AUTO_NODE.TYPE)
                .form().validate().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=ops_auto_node_type")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(AutoNodeMeta.TYPE_DICT).muliti(false);


        cfg.view().field(OpsTables.OPS_AUTO_NODE.GROUP_ID)
                .form().selectBox().queryApi(AutoGroupServiceProxy.QUERY_LIST)
                .paging(false).filter(false).toolbar(false)
                .valueField(AutoGroupMeta.ID).
                textField(AutoGroupMeta.NAME).
                fillWith(AutoNodeMeta.GROUP).muliti(false);



        cfg.view().field(OpsTables.OPS_AUTO_NODE.VOUCHER_ID)
                .basic().label("凭证").form().validate().form()
                .form().selectBox().queryApi(MonitorVoucherServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(AutoVoucherMeta.ID).
                textField(AutoVoucherMeta.NAME).
                fillWith(AutoNodeMeta.VOUCHER).muliti(false);



        cfg.view().formWindow().bottomSpace(80);
        cfg.view().formWindow().width(Config.baseFormWidth);;
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_AUTO_NODE.NAME,
                        OpsTables.OPS_AUTO_NODE.GROUP_ID,
                        OpsTables.OPS_AUTO_NODE.STATUS,
                        OpsTables.OPS_AUTO_NODE.TYPE,
                        OpsTables.OPS_AUTO_NODE.IP,
                        OpsTables.OPS_AUTO_NODE.VOUCHER_ID,
                        OpsTables.OPS_AUTO_NODE.NOTES,
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
        AutoNodeGtr g=new AutoNodeGtr();
        //生成代码
        g.generateCode();
      //  g.generateMenu(AutoNodeServiceProxy.class, AutoNodePageController.class);
    }
}
