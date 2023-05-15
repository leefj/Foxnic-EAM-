package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.DownloadFile;
import com.dt.platform.domain.oa.DownloadFileVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 常用下载 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-15 11:59:36
 */
@FeignClient(value = ServiceNames.OA, contextId = DownloadFileServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface DownloadFileServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-download-file
     */
    public static final String API_CONTEXT_PATH = "oa-download-file";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加常用下载
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除常用下载
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除常用下载
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新常用下载
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存常用下载
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个常用下载
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个常用下载
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询常用下载
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询常用下载
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";


    /**
     * 分页查询常用下载
     */
    public static final String QUERY_PAGED_DATA = API_PREFIX + "query-paged-data";

    /**
     * 添加常用下载
     */
    @RequestMapping(DownloadFileServiceProxy.INSERT)
    Result insert(@RequestParam(name = "downloadFileVO") DownloadFileVO downloadFileVO);

    /**
     * 删除常用下载
     */
    @RequestMapping(DownloadFileServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除常用下载
     */
    @RequestMapping(DownloadFileServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新常用下载
     */
    @RequestMapping(DownloadFileServiceProxy.UPDATE)
    Result update(@RequestParam(name = "downloadFileVO") DownloadFileVO downloadFileVO);

    /**
     * 更新常用下载
     */
    @RequestMapping(DownloadFileServiceProxy.SAVE)
    Result save(@RequestParam(name = "downloadFileVO") DownloadFileVO downloadFileVO);

    /**
     * 获取常用下载
     */
    @RequestMapping(DownloadFileServiceProxy.GET_BY_ID)
    Result<DownloadFile> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个常用下载
     */
    @RequestMapping(DownloadFileServiceProxy.GET_BY_IDS)
    Result<List<DownloadFile>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询常用下载
     */
    @RequestMapping(DownloadFileServiceProxy.QUERY_LIST)
    Result<List<DownloadFile>> queryList(@RequestParam(name = "sample") DownloadFileVO sample);

    /**
     * 分页查询常用下载
     */
    @RequestMapping(DownloadFileServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<DownloadFile>> queryPagedList(@RequestParam(name = "sample") DownloadFileVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.DownloadFileController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static DownloadFileServiceProxy api() {
        return APIProxy.get(DownloadFileServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
