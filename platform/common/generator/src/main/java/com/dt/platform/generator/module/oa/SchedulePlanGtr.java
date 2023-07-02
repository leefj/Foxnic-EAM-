package com.dt.platform.generator.module.oa;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.OaTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.common.StatusYNEnum;
import com.dt.platform.constants.enums.oa.NoticeIfTopEnum;
import com.dt.platform.constants.enums.oa.NoticeTypeEnum;
import com.dt.platform.constants.enums.oa.ScheduleRankEnum;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.oa.SchedulePlan;
import com.dt.platform.domain.oa.meta.SchedulePlanMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.oa.page.SchedulePlanPageController;
import com.dt.platform.proxy.oa.SchedulePlanServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class SchedulePlanGtr extends BaseCodeGenerator {


    public SchedulePlanGtr() {
        super(OaTables.OA_SCHEDULE_PLAN.$TABLE,"724920223844532224");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(OaTables.OA_SCHEDULE_PLAN.ID).basic().hidden(true);

        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"scheduleRemind","scheduleRemind","scheduleRemind");

        cfg.view().search().inputLayout(
                new Object[]{
                        OaTables.OA_SCHEDULE_PLAN.RANK,
                        OaTables.OA_SCHEDULE_PLAN.F_TIME,
                }
        );




        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(OaTables.OA_SCHEDULE_PLAN.F_TIME).form().validate().required().form().dateInput().type(DatePickerType.datetime);
        cfg.view().field(OaTables.OA_SCHEDULE_PLAN.T_TIME).form().validate().required().form().dateInput().type(DatePickerType.datetime);
        cfg.view().field(OaTables.OA_SCHEDULE_PLAN.REMIND_TIME).form().validate().required().form().dateInput().type(DatePickerType.datetime);
        cfg.view().field(OaTables.OA_SCHEDULE_PLAN.FULL_DAY).form().validate().required().form().radioBox().enumType(StatusYNEnum.class).defaultIndex(1);

        cfg.view().field(OaTables.OA_SCHEDULE_PLAN.RANK).form().validate().required().form().radioBox().enumType(ScheduleRankEnum.class).defaultIndex(0);
        cfg.view().field(OaTables.OA_SCHEDULE_PLAN.CONTENT).form().validate().required();
        cfg.view().field(OaTables.OA_SCHEDULE_PLAN.DETAIL).form().textArea().height(150);
        cfg.view().field(OaTables.OA_SCHEDULE_PLAN.USER_ID).table().disable(true);
        cfg.view().formWindow().bottomSpace(150);
        cfg.view().formWindow().width(Config.baseFormWidth);

        cfg.view().field(OaTables.OA_SCHEDULE_PLAN.REMIND)
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=oa_schedule_remind")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(SchedulePlanMeta.SCHEDULE_REMIND).muliti(false);

        cfg.view().field(OaTables.OA_SCHEDULE_PLAN.REMIND).table().disable(true);

        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_SCHEDULE_PLAN.CONTENT,
                        OaTables.OA_SCHEDULE_PLAN.F_TIME
                },
                new Object[] {
                        OaTables.OA_SCHEDULE_PLAN.RANK,
                        OaTables.OA_SCHEDULE_PLAN.T_TIME
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_SCHEDULE_PLAN.FULL_DAY,
                        OaTables.OA_SCHEDULE_PLAN.REMIND,
                        OaTables.OA_SCHEDULE_PLAN.DETAIL,
                        OaTables.OA_SCHEDULE_PLAN.NOTES,
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
        SchedulePlanGtr g=new SchedulePlanGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
     // g.generateMenu(SchedulePlanServiceProxy.class, SchedulePlanPageController.class);
    }

}
