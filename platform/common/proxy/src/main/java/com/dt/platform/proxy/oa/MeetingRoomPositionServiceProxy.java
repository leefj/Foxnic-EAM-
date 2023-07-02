package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.MeetingRoomPosition;
import com.dt.platform.domain.oa.MeetingRoomPositionVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 会议室位置 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-28 23:01:15
 */
@FeignClient(value = ServiceNames.OA, contextId = MeetingRoomPositionServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MeetingRoomPositionServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-meeting-room-position
     */
    public static final String API_CONTEXT_PATH = "oa-meeting-room-position";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加会议室位置
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除会议室位置
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除会议室位置
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新会议室位置
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存会议室位置
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个会议室位置
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个会议室位置
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询会议室位置
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询会议室位置
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加会议室位置
     */
    @RequestMapping(MeetingRoomPositionServiceProxy.INSERT)
    Result insert(@RequestParam(name = "meetingRoomPositionVO") MeetingRoomPositionVO meetingRoomPositionVO);

    /**
     * 删除会议室位置
     */
    @RequestMapping(MeetingRoomPositionServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除会议室位置
     */
    @RequestMapping(MeetingRoomPositionServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新会议室位置
     */
    @RequestMapping(MeetingRoomPositionServiceProxy.UPDATE)
    Result update(@RequestParam(name = "meetingRoomPositionVO") MeetingRoomPositionVO meetingRoomPositionVO);

    /**
     * 更新会议室位置
     */
    @RequestMapping(MeetingRoomPositionServiceProxy.SAVE)
    Result save(@RequestParam(name = "meetingRoomPositionVO") MeetingRoomPositionVO meetingRoomPositionVO);

    /**
     * 获取会议室位置
     */
    @RequestMapping(MeetingRoomPositionServiceProxy.GET_BY_ID)
    Result<MeetingRoomPosition> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个会议室位置
     */
    @RequestMapping(MeetingRoomPositionServiceProxy.GET_BY_IDS)
    Result<List<MeetingRoomPosition>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询会议室位置
     */
    @RequestMapping(MeetingRoomPositionServiceProxy.QUERY_LIST)
    Result<List<MeetingRoomPosition>> queryList(@RequestParam(name = "sample") MeetingRoomPositionVO sample);

    /**
     * 分页查询会议室位置
     */
    @RequestMapping(MeetingRoomPositionServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<MeetingRoomPosition>> queryPagedList(@RequestParam(name = "sample") MeetingRoomPositionVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.MeetingRoomPositionController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MeetingRoomPositionServiceProxy api() {
        return APIProxy.get(MeetingRoomPositionServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
