package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.DownloadLog;
import com.dt.platform.domain.oa.DownloadLogVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 下载日志 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-28 22:03:10
 */
@FeignClient(value = ServiceNames.OA, contextId = DownloadLogServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface DownloadLogServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-download-log
     */
    public static final String API_CONTEXT_PATH = "oa-download-log";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加下载日志
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除下载日志
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除下载日志
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新下载日志
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存下载日志
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个下载日志
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个下载日志
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询下载日志
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询下载日志
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加下载日志
     */
    @RequestMapping(DownloadLogServiceProxy.INSERT)
    Result insert(@RequestParam(name = "downloadLogVO") DownloadLogVO downloadLogVO);

    /**
     * 删除下载日志
     */
    @RequestMapping(DownloadLogServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除下载日志
     */
    @RequestMapping(DownloadLogServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新下载日志
     */
    @RequestMapping(DownloadLogServiceProxy.UPDATE)
    Result update(@RequestParam(name = "downloadLogVO") DownloadLogVO downloadLogVO);

    /**
     * 更新下载日志
     */
    @RequestMapping(DownloadLogServiceProxy.SAVE)
    Result save(@RequestParam(name = "downloadLogVO") DownloadLogVO downloadLogVO);

    /**
     * 获取下载日志
     */
    @RequestMapping(DownloadLogServiceProxy.GET_BY_ID)
    Result<DownloadLog> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个下载日志
     */
    @RequestMapping(DownloadLogServiceProxy.GET_BY_IDS)
    Result<List<DownloadLog>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询下载日志
     */
    @RequestMapping(DownloadLogServiceProxy.QUERY_LIST)
    Result<List<DownloadLog>> queryList(@RequestParam(name = "sample") DownloadLogVO sample);

    /**
     * 分页查询下载日志
     */
    @RequestMapping(DownloadLogServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<DownloadLog>> queryPagedList(@RequestParam(name = "sample") DownloadLogVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.DownloadLogController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static DownloadLogServiceProxy api() {
        return APIProxy.get(DownloadLogServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
