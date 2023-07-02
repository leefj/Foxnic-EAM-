package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.MeetingRoomBookRcd;
import com.dt.platform.domain.oa.MeetingRoomBookRcdVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 会议室预定 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-28 21:40:41
 */
@FeignClient(value = ServiceNames.OA, contextId = MeetingRoomBookRcdServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MeetingRoomBookRcdServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-meeting-room-book-rcd
     */
    public static final String API_CONTEXT_PATH = "oa-meeting-room-book-rcd";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加会议室预定
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除会议室预定
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除会议室预定
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新会议室预定
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存会议室预定
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个会议室预定
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个会议室预定
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询会议室预定
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询会议室预定
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    public static final String CANCEL = API_PREFIX + "cancel";
    public static final String FINISH = API_PREFIX + "finish";
    public static final String SURE= API_PREFIX + "sure";

    public static final String QUERY_DATA= API_PREFIX + "query-data";
    /**
     * 添加会议室预定
     */
    @RequestMapping(MeetingRoomBookRcdServiceProxy.INSERT)
    Result insert(@RequestParam(name = "meetingRoomBookRcdVO") MeetingRoomBookRcdVO meetingRoomBookRcdVO);

    /**
     * 删除会议室预定
     */
    @RequestMapping(MeetingRoomBookRcdServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除会议室预定
     */
    @RequestMapping(MeetingRoomBookRcdServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新会议室预定
     */
    @RequestMapping(MeetingRoomBookRcdServiceProxy.UPDATE)
    Result update(@RequestParam(name = "meetingRoomBookRcdVO") MeetingRoomBookRcdVO meetingRoomBookRcdVO);

    /**
     * 更新会议室预定
     */
    @RequestMapping(MeetingRoomBookRcdServiceProxy.SAVE)
    Result save(@RequestParam(name = "meetingRoomBookRcdVO") MeetingRoomBookRcdVO meetingRoomBookRcdVO);

    /**
     * 获取会议室预定
     */
    @RequestMapping(MeetingRoomBookRcdServiceProxy.GET_BY_ID)
    Result<MeetingRoomBookRcd> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个会议室预定
     */
    @RequestMapping(MeetingRoomBookRcdServiceProxy.GET_BY_IDS)
    Result<List<MeetingRoomBookRcd>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询会议室预定
     */
    @RequestMapping(MeetingRoomBookRcdServiceProxy.QUERY_LIST)
    Result<List<MeetingRoomBookRcd>> queryList(@RequestParam(name = "sample") MeetingRoomBookRcdVO sample);

    /**
     * 分页查询会议室预定
     */
    @RequestMapping(MeetingRoomBookRcdServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<MeetingRoomBookRcd>> queryPagedList(@RequestParam(name = "sample") MeetingRoomBookRcdVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.MeetingRoomBookRcdController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MeetingRoomBookRcdServiceProxy api() {
        return APIProxy.get(MeetingRoomBookRcdServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
