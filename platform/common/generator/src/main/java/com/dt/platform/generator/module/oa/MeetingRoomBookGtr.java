package com.dt.platform.generator.module.oa;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.OaTables;
import com.dt.platform.constants.enums.oa.MeetingRoomBookStatusEnum;
import com.dt.platform.constants.enums.oa.MeetingRoomStatusEnum;
import com.dt.platform.domain.eam.Maintainer;
import com.dt.platform.domain.oa.MeetingRoom;
import com.dt.platform.domain.oa.MeetingRoomBookRcd;
import com.dt.platform.domain.oa.MeetingRoomPosition;
import com.dt.platform.domain.oa.meta.MeetingRoomBookRcdMeta;
import com.dt.platform.domain.oa.meta.MeetingRoomMeta;
import com.dt.platform.domain.oa.meta.MeetingRoomPositionMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.oa.page.MeetingRoomBookRcdPageController;
import com.dt.platform.proxy.oa.MeetingRoomBookRcdServiceProxy;
import com.dt.platform.proxy.oa.MeetingRoomPositionServiceProxy;
import com.dt.platform.proxy.oa.MeetingRoomServiceProxy;
import com.github.foxnic.generator.builder.view.config.DatePickerType;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;

public class MeetingRoomBookGtr extends BaseCodeGenerator {


    public MeetingRoomBookGtr() {
        super(OaTables.OA_MEETING_ROOM_BOOK_RCD.$TABLE,"616256779512184832");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(MeetingRoom.class,"meetingRoom","meetingRoom","meetingRoom");

        cfg.view().field(OaTables.OA_MEETING_ROOM_BOOK_RCD.CREATE_TIME).basic().hidden(true);
        cfg.view().field(OaTables.OA_MEETING_ROOM_BOOK_RCD.ID).basic().hidden(true);
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"org","组织部门","组织部门");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"booker","booker","booker");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"user","user","user");


        cfg.view().field(OaTables.OA_MEETING_ROOM_BOOK_RCD.NAME).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        OaTables.OA_MEETING_ROOM_BOOK_RCD.STATUS,
                        OaTables.OA_MEETING_ROOM_BOOK_RCD.ROOM_ID,
                        OaTables.OA_MEETING_ROOM_BOOK_RCD.NAME,
                }
        );

        cfg.view().field(OaTables.OA_MEETING_ROOM_BOOK_RCD.BOOKER_ID).table().fillBy("booker","name");
        cfg.view().field(OaTables.OA_MEETING_ROOM_BOOK_RCD.BOOKER_ID).form().validate().required().form()
                .button().chooseEmployee(true);

        cfg.view().field(OaTables.OA_MEETING_ROOM_BOOK_RCD.ORG_ID)
                .form().validate().required().form().button().chooseCompany(true);
        cfg.view().field(OaTables.OA_MEETING_ROOM_BOOK_RCD.ORG_ID).table().fillBy("org","fullName");


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(OaTables.OA_MEETING_ROOM_BOOK_RCD.START_TIME).form().validate().required().form().dateInput().type(DatePickerType.datetime).search().range();
        cfg.view().field(OaTables.OA_MEETING_ROOM_BOOK_RCD.END_TIME).form().validate().required().form().dateInput().type(DatePickerType.datetime).search().range();

        cfg.view().field(OaTables.OA_MEETING_ROOM_BOOK_RCD.USER_ID).table().disable(true);

        cfg.view().field(OaTables.OA_MEETING_ROOM_BOOK_RCD.CREATE_TIME).table().disable(true);
        cfg.view().field(OaTables.OA_MEETING_ROOM_BOOK_RCD.NAME).form().validate().required();
        cfg.view().field(OaTables.OA_MEETING_ROOM_BOOK_RCD.STATUS).form().radioBox().enumType(MeetingRoomBookStatusEnum.class).defaultIndex(0);
        cfg.view().field(OaTables.OA_MEETING_ROOM_BOOK_RCD.NOTES).form().textArea().height(150);



        cfg.view().field(OaTables.OA_MEETING_ROOM_BOOK_RCD.ROOM_ID).form().validate().required().form()
                .selectBox().queryApi(MeetingRoomServiceProxy.QUERY_PAGED_LIST+"?status=available")
                .paging(true).filter(false).toolbar(false)
                .valueField(MeetingRoomMeta.ID).
                textField(MeetingRoomMeta.NAME).
                fillWith(MeetingRoomBookRcdMeta.MEETING_ROOM).muliti(false);

        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().bottomSpace(150);
        cfg.view().formWindow().width(Config.baseFormWidth);

        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_MEETING_ROOM_BOOK_RCD.NAME,
                        OaTables.OA_MEETING_ROOM_BOOK_RCD.START_TIME,
                },
                new Object[] {
                        OaTables.OA_MEETING_ROOM_BOOK_RCD.ROOM_ID,
                        OaTables.OA_MEETING_ROOM_BOOK_RCD.END_TIME,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_MEETING_ROOM_BOOK_RCD.ORG_ID,
                        OaTables.OA_MEETING_ROOM_BOOK_RCD.BOOKER_ID,
                },
                new Object[] {
                        OaTables.OA_MEETING_ROOM_BOOK_RCD.CONTACT_INFORMATION,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        OaTables.OA_MEETING_ROOM_BOOK_RCD.NOTES,
                }
        );

        cfg.view().list().operationColumn().addActionButton("确认","sure","sure-button","oa_book_rcd:sure");
        cfg.view().list().operationColumn().addActionButton("完成","finish","finish-button","oa_book_rcd:finish");
        cfg.view().list().operationColumn().addActionButton("取消","cancel","cancel-button","oa_book_rcd:cancel");


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
        MeetingRoomBookGtr g=new MeetingRoomBookGtr();
        //生成代码
        g.generateCode();

        //g.generateMenu(MeetingRoomBookRcdServiceProxy.class, MeetingRoomBookRcdPageController.class);
    }

}
