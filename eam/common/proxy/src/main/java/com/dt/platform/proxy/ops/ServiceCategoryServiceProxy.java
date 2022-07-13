package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.ServiceCategory;
import com.dt.platform.domain.ops.ServiceCategoryVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 服务类型  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-12 22:05:27
 */
@FeignClient(value = ServiceNames.OPS, contextId = ServiceCategoryServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ServiceCategoryServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-service-category
     */
    public static final String API_CONTEXT_PATH = "ops-service-category";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加服务类型
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除服务类型
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除服务类型
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新服务类型
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存服务类型
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个服务类型
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个服务类型
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询服务类型
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询服务类型
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加服务类型
     */
    @RequestMapping(ServiceCategoryServiceProxy.INSERT)
    Result insert(@RequestParam(name = "serviceCategoryVO") ServiceCategoryVO serviceCategoryVO);

    /**
     * 删除服务类型
     */
    @RequestMapping(ServiceCategoryServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除服务类型
     */
    @RequestMapping(ServiceCategoryServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新服务类型
     */
    @RequestMapping(ServiceCategoryServiceProxy.UPDATE)
    Result update(@RequestParam(name = "serviceCategoryVO") ServiceCategoryVO serviceCategoryVO);

    /**
     * 更新服务类型
     */
    @RequestMapping(ServiceCategoryServiceProxy.SAVE)
    Result save(@RequestParam(name = "serviceCategoryVO") ServiceCategoryVO serviceCategoryVO);

    /**
     * 获取服务类型
     */
    @RequestMapping(ServiceCategoryServiceProxy.GET_BY_ID)
    Result<ServiceCategory> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个服务类型
     */
    @RequestMapping(ServiceCategoryServiceProxy.GET_BY_IDS)
    Result<List<ServiceCategory>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询服务类型
     */
    @RequestMapping(ServiceCategoryServiceProxy.QUERY_LIST)
    Result<List<ServiceCategory>> queryList(@RequestParam(name = "sample") ServiceCategoryVO sample);

    /**
     * 分页查询服务类型
     */
    @RequestMapping(ServiceCategoryServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ServiceCategory>> queryPagedList(@RequestParam(name = "sample") ServiceCategoryVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.ServiceCategoryController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ServiceCategoryServiceProxy api() {
        return APIProxy.get(ServiceCategoryServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
