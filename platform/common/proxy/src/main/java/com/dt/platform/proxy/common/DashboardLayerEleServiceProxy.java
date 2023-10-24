package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.DashboardLayerEle;
import com.dt.platform.domain.common.DashboardLayerEleVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 组件 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-23 16:32:44
 */
@FeignClient(value = ServiceNames.COMMON, contextId = DashboardLayerEleServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface DashboardLayerEleServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-dashboard-layer-ele
     */
    public static final String API_CONTEXT_PATH = "sys-dashboard-layer-ele";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加组件
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除组件
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除组件
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新组件
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存组件
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个组件
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个组件
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询组件
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询组件
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加组件
     */
    @RequestMapping(DashboardLayerEleServiceProxy.INSERT)
    Result insert(@RequestParam(name = "dashboardLayerEleVO") DashboardLayerEleVO dashboardLayerEleVO);

    /**
     * 删除组件
     */
    @RequestMapping(DashboardLayerEleServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除组件
     */
    @RequestMapping(DashboardLayerEleServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新组件
     */
    @RequestMapping(DashboardLayerEleServiceProxy.UPDATE)
    Result update(@RequestParam(name = "dashboardLayerEleVO") DashboardLayerEleVO dashboardLayerEleVO);

    /**
     * 更新组件
     */
    @RequestMapping(DashboardLayerEleServiceProxy.SAVE)
    Result save(@RequestParam(name = "dashboardLayerEleVO") DashboardLayerEleVO dashboardLayerEleVO);

    /**
     * 获取组件
     */
    @RequestMapping(DashboardLayerEleServiceProxy.GET_BY_ID)
    Result<DashboardLayerEle> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个组件
     */
    @RequestMapping(DashboardLayerEleServiceProxy.GET_BY_IDS)
    Result<List<DashboardLayerEle>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询组件
     */
    @RequestMapping(DashboardLayerEleServiceProxy.QUERY_LIST)
    Result<List<DashboardLayerEle>> queryList(@RequestParam(name = "sample") DashboardLayerEleVO sample);

    /**
     * 分页查询组件
     */
    @RequestMapping(DashboardLayerEleServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<DashboardLayerEle>> queryPagedList(@RequestParam(name = "sample") DashboardLayerEleVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.DashboardLayerEleController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static DashboardLayerEleServiceProxy api() {
        return APIProxy.get(DashboardLayerEleServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
