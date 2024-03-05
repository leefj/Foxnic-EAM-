package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.IndicatorLib;
import com.dt.platform.domain.hr.IndicatorLibVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 指标库 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-29 16:32:19
 */
@FeignClient(value = ServiceNames.HR, contextId = IndicatorLibServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface IndicatorLibServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-indicator-lib
     */
    public static final String API_CONTEXT_PATH = "hr-indicator-lib";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加指标库
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除指标库
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除指标库
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新指标库
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存指标库
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个指标库
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个指标库
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询指标库
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询指标库
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加指标库
     */
    @RequestMapping(IndicatorLibServiceProxy.INSERT)
    Result insert(@RequestParam(name = "indicatorLibVO") IndicatorLibVO indicatorLibVO);

    /**
     * 删除指标库
     */
    @RequestMapping(IndicatorLibServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除指标库
     */
    @RequestMapping(IndicatorLibServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新指标库
     */
    @RequestMapping(IndicatorLibServiceProxy.UPDATE)
    Result update(@RequestParam(name = "indicatorLibVO") IndicatorLibVO indicatorLibVO);

    /**
     * 更新指标库
     */
    @RequestMapping(IndicatorLibServiceProxy.SAVE)
    Result save(@RequestParam(name = "indicatorLibVO") IndicatorLibVO indicatorLibVO);

    /**
     * 获取指标库
     */
    @RequestMapping(IndicatorLibServiceProxy.GET_BY_ID)
    Result<IndicatorLib> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个指标库
     */
    @RequestMapping(IndicatorLibServiceProxy.GET_BY_IDS)
    Result<List<IndicatorLib>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询指标库
     */
    @RequestMapping(IndicatorLibServiceProxy.QUERY_LIST)
    Result<List<IndicatorLib>> queryList(@RequestParam(name = "sample") IndicatorLibVO sample);

    /**
     * 分页查询指标库
     */
    @RequestMapping(IndicatorLibServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<IndicatorLib>> queryPagedList(@RequestParam(name = "sample") IndicatorLibVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.IndicatorLibController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static IndicatorLibServiceProxy api() {
        return APIProxy.get(IndicatorLibServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
