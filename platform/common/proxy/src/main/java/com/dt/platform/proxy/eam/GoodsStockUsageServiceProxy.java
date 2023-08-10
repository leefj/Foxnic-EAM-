package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.GoodsStockUsage;
import com.dt.platform.domain.eam.GoodsStockUsageVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 使用情况 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-10 14:57:00
 */
@FeignClient(value = ServiceNames.EAM, contextId = GoodsStockUsageServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface GoodsStockUsageServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-goods-stock-usage
     */
    public static final String API_CONTEXT_PATH = "eam-goods-stock-usage";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加使用情况
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除使用情况
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除使用情况
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新使用情况
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存使用情况
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个使用情况
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个使用情况
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询使用情况
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询使用情况
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";


    /**
     * 添加使用情况
     */
    @RequestMapping(GoodsStockUsageServiceProxy.INSERT)
    Result insert(@RequestParam(name = "goodsStockUsageVO") GoodsStockUsageVO goodsStockUsageVO);

    /**
     * 删除使用情况
     */
    @RequestMapping(GoodsStockUsageServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除使用情况
     */
    @RequestMapping(GoodsStockUsageServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新使用情况
     */
    @RequestMapping(GoodsStockUsageServiceProxy.UPDATE)
    Result update(@RequestParam(name = "goodsStockUsageVO") GoodsStockUsageVO goodsStockUsageVO);

    /**
     * 更新使用情况
     */
    @RequestMapping(GoodsStockUsageServiceProxy.SAVE)
    Result save(@RequestParam(name = "goodsStockUsageVO") GoodsStockUsageVO goodsStockUsageVO);

    /**
     * 获取使用情况
     */
    @RequestMapping(GoodsStockUsageServiceProxy.GET_BY_ID)
    Result<GoodsStockUsage> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个使用情况
     */
    @RequestMapping(GoodsStockUsageServiceProxy.GET_BY_IDS)
    Result<List<GoodsStockUsage>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询使用情况
     */
    @RequestMapping(GoodsStockUsageServiceProxy.QUERY_LIST)
    Result<List<GoodsStockUsage>> queryList(@RequestParam(name = "sample") GoodsStockUsageVO sample);

    /**
     * 分页查询使用情况
     */
    @RequestMapping(GoodsStockUsageServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<GoodsStockUsage>> queryPagedList(@RequestParam(name = "sample") GoodsStockUsageVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.GoodsStockUsageController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static GoodsStockUsageServiceProxy api() {
        return APIProxy.get(GoodsStockUsageServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
