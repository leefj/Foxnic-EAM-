package com.dt.platform.generator.module.oa;

import com.dt.platform.constants.db.OaTables;
import com.dt.platform.constants.enums.oa.MeetingRoomStatusEnum;
import com.dt.platform.domain.oa.MeetingRoomPosition;
import com.dt.platform.domain.oa.meta.MeetingRoomMeta;
import com.dt.platform.domain.oa.meta.MeetingRoomPositionMeta;
import com.dt.platform.domain.oa.meta.VehicleMaintenanceMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.oa.page.MeetingRoomPageController;
import com.dt.platform.oa.page.MeetingRoomPositionPageController;
import com.dt.platform.proxy.oa.MeetingRoomPositionServiceProxy;
import com.dt.platform.proxy.oa.MeetingRoomServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class MeetingRoomGtr extends BaseCodeGenerator {


    public MeetingRoomGtr() {
        super(OaTables.OA_MEETING_ROOM.$TABLE,"616256779512184832");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(MeetingRoomPosition.class,"meetingRoomPosition","meetingRoomPosition","meetingRoomPosition");

        cfg.view().field(OaTables.OA_MEETING_ROOM.ID).basic().hidden(true);

        cfg.view().field(OaTables.OA_MEETING_ROOM.NAME).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        OaTables.OA_MEETING_ROOM.STATUS,
                        OaTables.OA_MEETING_ROOM.POSITION_ID,
                        OaTables.OA_MEETING_ROOM.NAME,
                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(OaTables.OA_MEETING_ROOM.NAME).form().validate().required();
        cfg.view().field(OaTables.OA_MEETING_ROOM.STATUS).form().validate().required().form().radioBox().enumType(MeetingRoomStatusEnum.class).defaultIndex(0);

        cfg.view().field(OaTables.OA_MEETING_ROOM.POSITION_ID).form().validate().required().form()
           .selectBox().queryApi(MeetingRoomPositionServiceProxy.QUERY_LIST)
                .paging(false).filter(false).toolbar(false)
                .valueField(MeetingRoomPositionMeta.ID).
                textField(MeetingRoomPositionMeta.NAME).
                fillWith(MeetingRoomMeta.MEETING_ROOM_POSITION).muliti(false);

        cfg.view().field(OaTables.OA_MEETING_ROOM.NOTES).form().textArea().height(150);
        cfg.view().field(OaTables.OA_MEETING_ROOM.PERSON_NUMBER).form().validate().required();
        cfg.view().formWindow().bottomSpace(150);
        cfg.view().formWindow().width(Config.baseFormWidth);

        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_MEETING_ROOM.NAME,
                        OaTables.OA_MEETING_ROOM.PERSON_NUMBER,
                        OaTables.OA_MEETING_ROOM.STATUS,
                        OaTables.OA_MEETING_ROOM.POSITION_ID,
                        OaTables.OA_MEETING_ROOM.NOTES,
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
        MeetingRoomGtr g=new MeetingRoomGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
        //
     // g.generateMenu(MeetingRoomServiceProxy.class, MeetingRoomPageController.class);
    }

}
