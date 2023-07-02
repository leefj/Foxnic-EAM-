package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.MeetingRoom;
import com.dt.platform.domain.oa.MeetingRoomVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 会议室 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-28 22:10:52
 */
@FeignClient(value = ServiceNames.OA, contextId = MeetingRoomServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MeetingRoomServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-meeting-room
     */
    public static final String API_CONTEXT_PATH = "oa-meeting-room";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加会议室
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除会议室
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除会议室
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新会议室
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存会议室
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个会议室
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个会议室
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询会议室
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询会议室
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加会议室
     */
    @RequestMapping(MeetingRoomServiceProxy.INSERT)
    Result insert(@RequestParam(name = "meetingRoomVO") MeetingRoomVO meetingRoomVO);

    /**
     * 删除会议室
     */
    @RequestMapping(MeetingRoomServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除会议室
     */
    @RequestMapping(MeetingRoomServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新会议室
     */
    @RequestMapping(MeetingRoomServiceProxy.UPDATE)
    Result update(@RequestParam(name = "meetingRoomVO") MeetingRoomVO meetingRoomVO);

    /**
     * 更新会议室
     */
    @RequestMapping(MeetingRoomServiceProxy.SAVE)
    Result save(@RequestParam(name = "meetingRoomVO") MeetingRoomVO meetingRoomVO);

    /**
     * 获取会议室
     */
    @RequestMapping(MeetingRoomServiceProxy.GET_BY_ID)
    Result<MeetingRoom> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个会议室
     */
    @RequestMapping(MeetingRoomServiceProxy.GET_BY_IDS)
    Result<List<MeetingRoom>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询会议室
     */
    @RequestMapping(MeetingRoomServiceProxy.QUERY_LIST)
    Result<List<MeetingRoom>> queryList(@RequestParam(name = "sample") MeetingRoomVO sample);

    /**
     * 分页查询会议室
     */
    @RequestMapping(MeetingRoomServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<MeetingRoom>> queryPagedList(@RequestParam(name = "sample") MeetingRoomVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.MeetingRoomController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MeetingRoomServiceProxy api() {
        return APIProxy.get(MeetingRoomServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
