package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.Notice;
import com.dt.platform.domain.oa.NoticeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 通知公告 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-08 20:49:25
 */
@FeignClient(value = ServiceNames.OA, contextId = NoticeServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface NoticeServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-notice
     */
    public static final String API_CONTEXT_PATH = "oa-notice";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加通知公告
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除通知公告
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除通知公告
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新通知公告
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存通知公告
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个通知公告
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个通知公告
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询通知公告
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询通知公告
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加通知公告
     */
    @RequestMapping(NoticeServiceProxy.INSERT)
    Result insert(@RequestParam(name = "noticeVO") NoticeVO noticeVO);

    /**
     * 删除通知公告
     */
    @RequestMapping(NoticeServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除通知公告
     */
    @RequestMapping(NoticeServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新通知公告
     */
    @RequestMapping(NoticeServiceProxy.UPDATE)
    Result update(@RequestParam(name = "noticeVO") NoticeVO noticeVO);

    /**
     * 更新通知公告
     */
    @RequestMapping(NoticeServiceProxy.SAVE)
    Result save(@RequestParam(name = "noticeVO") NoticeVO noticeVO);

    /**
     * 获取通知公告
     */
    @RequestMapping(NoticeServiceProxy.GET_BY_ID)
    Result<Notice> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个通知公告
     */
    @RequestMapping(NoticeServiceProxy.GET_BY_IDS)
    Result<List<Notice>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询通知公告
     */
    @RequestMapping(NoticeServiceProxy.QUERY_LIST)
    Result<List<Notice>> queryList(@RequestParam(name = "sample") NoticeVO sample);

    /**
     * 分页查询通知公告
     */
    @RequestMapping(NoticeServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Notice>> queryPagedList(@RequestParam(name = "sample") NoticeVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.NoticeController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static NoticeServiceProxy api() {
        return APIProxy.get(NoticeServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
