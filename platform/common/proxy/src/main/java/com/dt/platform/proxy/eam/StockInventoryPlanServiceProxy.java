package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.StockInventoryPlan;
import com.dt.platform.domain.eam.StockInventoryPlanVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 盘点计划2 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-05-04 07:52:49
 */
@FeignClient(value = ServiceNames.EAM, contextId = StockInventoryPlanServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface StockInventoryPlanServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-stock-inventory-plan
     */
    public static final String API_CONTEXT_PATH = "eam-stock-inventory-plan";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加盘点计划2
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除盘点计划2
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除盘点计划2
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新盘点计划2
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存盘点计划2
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个盘点计划2
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个盘点计划2
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询盘点计划2
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询盘点计划2
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    public static final String APPLY_TPL = API_PREFIX + "apply-tpl";


    /**
     * 添加盘点计划2
     */
    @RequestMapping(StockInventoryPlanServiceProxy.INSERT)
    Result insert(@RequestParam(name = "stockInventoryPlanVO") StockInventoryPlanVO stockInventoryPlanVO);

    /**
     * 删除盘点计划2
     */
    @RequestMapping(StockInventoryPlanServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除盘点计划2
     */
    @RequestMapping(StockInventoryPlanServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新盘点计划2
     */
    @RequestMapping(StockInventoryPlanServiceProxy.UPDATE)
    Result update(@RequestParam(name = "stockInventoryPlanVO") StockInventoryPlanVO stockInventoryPlanVO);

    /**
     * 更新盘点计划2
     */
    @RequestMapping(StockInventoryPlanServiceProxy.SAVE)
    Result save(@RequestParam(name = "stockInventoryPlanVO") StockInventoryPlanVO stockInventoryPlanVO);

    /**
     * 获取盘点计划2
     */
    @RequestMapping(StockInventoryPlanServiceProxy.GET_BY_ID)
    Result<StockInventoryPlan> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个盘点计划2
     */
    @RequestMapping(StockInventoryPlanServiceProxy.GET_BY_IDS)
    Result<List<StockInventoryPlan>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询盘点计划2
     */
    @RequestMapping(StockInventoryPlanServiceProxy.QUERY_LIST)
    Result<List<StockInventoryPlan>> queryList(@RequestParam(name = "sample") StockInventoryPlanVO sample);

    /**
     * 分页查询盘点计划2
     */
    @RequestMapping(StockInventoryPlanServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<StockInventoryPlan>> queryPagedList(@RequestParam(name = "sample") StockInventoryPlanVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.StockInventoryPlanController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static StockInventoryPlanServiceProxy api() {
        return APIProxy.get(StockInventoryPlanServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
