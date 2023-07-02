package com.dt.platform.generator.module.oa;

import com.dt.platform.constants.db.OaTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.oa.NoticeIfTopEnum;
import com.dt.platform.constants.enums.oa.NoticeTypeEnum;
import com.dt.platform.domain.oa.MeetingRoomPosition;
import com.dt.platform.generator.config.Config;
import com.dt.platform.oa.page.MeetingRoomPositionPageController;
import com.dt.platform.proxy.oa.MeetingRoomPositionServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;

public class MeetingRoomPosGtr extends BaseCodeGenerator {


    public MeetingRoomPosGtr() {
        super(OaTables.OA_MEETING_ROOM_POSITION.$TABLE,"616256779512184832");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());



        cfg.view().field(OaTables.OA_MEETING_ROOM_POSITION.ID).basic().hidden(true);

        cfg.view().field(OaTables.OA_MEETING_ROOM_POSITION.NAME).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        OaTables.OA_MEETING_ROOM_POSITION.NAME,

                }
        );



        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().list().disableBatchDelete();

        cfg.view().field(OaTables.OA_MEETING_ROOM_POSITION.NAME).form().validate().required();
        cfg.view().field(OaTables.OA_MEETING_ROOM_POSITION.SORT).table().disable(true);

        cfg.view().formWindow().bottomSpace(150);
        cfg.view().formWindow().width(Config.baseFormWidth);

        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_MEETING_ROOM_POSITION.NAME,
                        OaTables.OA_MEETING_ROOM_POSITION.SORT,
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
        MeetingRoomPosGtr g=new MeetingRoomPosGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
        //g.generateMenu(MeetingRoomPositionServiceProxy.class, MeetingRoomPositionPageController.class);
    }

}
