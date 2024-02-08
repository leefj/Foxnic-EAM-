package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.PerformanceLevel;
import com.dt.platform.domain.hr.PerformanceLevelVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 考核等级 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-28 16:05:00
 */
@FeignClient(value = ServiceNames.HR, contextId = PerformanceLevelServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PerformanceLevelServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-performance-level
     */
    public static final String API_CONTEXT_PATH = "hr-performance-level";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加考核等级
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除考核等级
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除考核等级
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新考核等级
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存考核等级
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个考核等级
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个考核等级
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询考核等级
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询考核等级
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加考核等级
     */
    @RequestMapping(PerformanceLevelServiceProxy.INSERT)
    Result insert(@RequestParam(name = "performanceLevelVO") PerformanceLevelVO performanceLevelVO);

    /**
     * 删除考核等级
     */
    @RequestMapping(PerformanceLevelServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除考核等级
     */
    @RequestMapping(PerformanceLevelServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新考核等级
     */
    @RequestMapping(PerformanceLevelServiceProxy.UPDATE)
    Result update(@RequestParam(name = "performanceLevelVO") PerformanceLevelVO performanceLevelVO);

    /**
     * 更新考核等级
     */
    @RequestMapping(PerformanceLevelServiceProxy.SAVE)
    Result save(@RequestParam(name = "performanceLevelVO") PerformanceLevelVO performanceLevelVO);

    /**
     * 获取考核等级
     */
    @RequestMapping(PerformanceLevelServiceProxy.GET_BY_ID)
    Result<PerformanceLevel> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个考核等级
     */
    @RequestMapping(PerformanceLevelServiceProxy.GET_BY_IDS)
    Result<List<PerformanceLevel>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询考核等级
     */
    @RequestMapping(PerformanceLevelServiceProxy.QUERY_LIST)
    Result<List<PerformanceLevel>> queryList(@RequestParam(name = "sample") PerformanceLevelVO sample);

    /**
     * 分页查询考核等级
     */
    @RequestMapping(PerformanceLevelServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<PerformanceLevel>> queryPagedList(@RequestParam(name = "sample") PerformanceLevelVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.PerformanceLevelController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static PerformanceLevelServiceProxy api() {
        return APIProxy.get(PerformanceLevelServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
