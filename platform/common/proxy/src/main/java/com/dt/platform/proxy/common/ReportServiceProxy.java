package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.Report;
import com.dt.platform.domain.common.ReportVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 报表列 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-19 13:01:27
 */
@FeignClient(value = ServiceNames.COMMON, contextId = ReportServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ReportServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-report
     */
    public static final String API_CONTEXT_PATH = "sys-report";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加报表列
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除报表列
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除报表列
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新报表列
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存报表列
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个报表列
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个报表列
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询报表列
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询报表列
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";


    public static final String COPY_DATA = API_PREFIX + "copy-data";
    /**
     * 添加报表列
     */
    @RequestMapping(ReportServiceProxy.INSERT)
    Result insert(@RequestParam(name = "reportVO") ReportVO reportVO);

    /**
     * 删除报表列
     */
    @RequestMapping(ReportServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除报表列
     */
    @RequestMapping(ReportServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新报表列
     */
    @RequestMapping(ReportServiceProxy.UPDATE)
    Result update(@RequestParam(name = "reportVO") ReportVO reportVO);

    /**
     * 更新报表列
     */
    @RequestMapping(ReportServiceProxy.SAVE)
    Result save(@RequestParam(name = "reportVO") ReportVO reportVO);

    /**
     * 获取报表列
     */
    @RequestMapping(ReportServiceProxy.GET_BY_ID)
    Result<Report> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个报表列
     */
    @RequestMapping(ReportServiceProxy.GET_BY_IDS)
    Result<List<Report>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询报表列
     */
    @RequestMapping(ReportServiceProxy.QUERY_LIST)
    Result<List<Report>> queryList(@RequestParam(name = "sample") ReportVO sample);

    /**
     * 分页查询报表列
     */
    @RequestMapping(ReportServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Report>> queryPagedList(@RequestParam(name = "sample") ReportVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.ReportController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ReportServiceProxy api() {
        return APIProxy.get(ReportServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
