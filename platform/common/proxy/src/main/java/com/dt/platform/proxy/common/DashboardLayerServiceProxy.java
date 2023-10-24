package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.DashboardLayer;
import com.dt.platform.domain.common.DashboardLayerVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 面板层 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-23 15:37:14
 */
@FeignClient(value = ServiceNames.COMMON, contextId = DashboardLayerServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface DashboardLayerServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-dashboard-layer
     */
    public static final String API_CONTEXT_PATH = "sys-dashboard-layer";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加面板层
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除面板层
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除面板层
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新面板层
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存面板层
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个面板层
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个面板层
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询面板层
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询面板层
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加面板层
     */
    @RequestMapping(DashboardLayerServiceProxy.INSERT)
    Result insert(@RequestParam(name = "dashboardLayerVO") DashboardLayerVO dashboardLayerVO);

    /**
     * 删除面板层
     */
    @RequestMapping(DashboardLayerServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除面板层
     */
    @RequestMapping(DashboardLayerServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新面板层
     */
    @RequestMapping(DashboardLayerServiceProxy.UPDATE)
    Result update(@RequestParam(name = "dashboardLayerVO") DashboardLayerVO dashboardLayerVO);

    /**
     * 更新面板层
     */
    @RequestMapping(DashboardLayerServiceProxy.SAVE)
    Result save(@RequestParam(name = "dashboardLayerVO") DashboardLayerVO dashboardLayerVO);

    /**
     * 获取面板层
     */
    @RequestMapping(DashboardLayerServiceProxy.GET_BY_ID)
    Result<DashboardLayer> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个面板层
     */
    @RequestMapping(DashboardLayerServiceProxy.GET_BY_IDS)
    Result<List<DashboardLayer>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询面板层
     */
    @RequestMapping(DashboardLayerServiceProxy.QUERY_LIST)
    Result<List<DashboardLayer>> queryList(@RequestParam(name = "sample") DashboardLayerVO sample);

    /**
     * 分页查询面板层
     */
    @RequestMapping(DashboardLayerServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<DashboardLayer>> queryPagedList(@RequestParam(name = "sample") DashboardLayerVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.DashboardLayerController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static DashboardLayerServiceProxy api() {
        return APIProxy.get(DashboardLayerServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
