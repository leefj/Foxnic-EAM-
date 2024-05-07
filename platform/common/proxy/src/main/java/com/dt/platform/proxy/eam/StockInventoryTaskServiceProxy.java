package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.StockInventoryTask;
import com.dt.platform.domain.eam.StockInventoryTaskVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 盘点任务2 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-05-04 08:33:48
 */
@FeignClient(value = ServiceNames.EAM, contextId = StockInventoryTaskServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface StockInventoryTaskServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-stock-inventory-task
     */
    public static final String API_CONTEXT_PATH = "eam-stock-inventory-task";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加盘点任务2
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除盘点任务2
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除盘点任务2
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新盘点任务2
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存盘点任务2
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个盘点任务2
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个盘点任务2
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询盘点任务2
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询盘点任务2
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";


    /**
     * 盘点开始
     */
    public static final String START = API_PREFIX + "start";

    /**
     * 盘点结束
     */
    public static final String FINISH = API_PREFIX + "finish";

    /**
     * 盘点取消
     */
    public static final String CANCEL = API_PREFIX + "cancel";

    /**
     * 同步数据
     */
    public static final String DATA_SYNC = API_PREFIX + "data-sync";

    /**
     * 盘点资产
     */
    public static final String INVENTORY_ASSET = API_PREFIX + "inventory-asset";

    /**
     * 新增盘赢资产
     */
    public static final String ASSET_PLUS_DATA = API_PREFIX + "asset-plus-data";


    /**
     * 查询盘点任务2
     */
    public static final String  QUERY_ASSET_BY_INVENTORY = API_PREFIX + "query-asset-by-inventory";


    /**
     * 下载资产
     */
    public static final String DOWNLOAD_ASSET = API_PREFIX + "download-asset";


    /**
     * 添加盘点任务2
     */
    @RequestMapping(StockInventoryTaskServiceProxy.INSERT)
    Result insert(@RequestParam(name = "stockInventoryTaskVO") StockInventoryTaskVO stockInventoryTaskVO);

    /**
     * 删除盘点任务2
     */
    @RequestMapping(StockInventoryTaskServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除盘点任务2
     */
    @RequestMapping(StockInventoryTaskServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新盘点任务2
     */
    @RequestMapping(StockInventoryTaskServiceProxy.UPDATE)
    Result update(@RequestParam(name = "stockInventoryTaskVO") StockInventoryTaskVO stockInventoryTaskVO);

    /**
     * 更新盘点任务2
     */
    @RequestMapping(StockInventoryTaskServiceProxy.SAVE)
    Result save(@RequestParam(name = "stockInventoryTaskVO") StockInventoryTaskVO stockInventoryTaskVO);

    /**
     * 获取盘点任务2
     */
    @RequestMapping(StockInventoryTaskServiceProxy.GET_BY_ID)
    Result<StockInventoryTask> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个盘点任务2
     */
    @RequestMapping(StockInventoryTaskServiceProxy.GET_BY_IDS)
    Result<List<StockInventoryTask>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询盘点任务2
     */
    @RequestMapping(StockInventoryTaskServiceProxy.QUERY_LIST)
    Result<List<StockInventoryTask>> queryList(@RequestParam(name = "sample") StockInventoryTaskVO sample);

    /**
     * 分页查询盘点任务2
     */
    @RequestMapping(StockInventoryTaskServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<StockInventoryTask>> queryPagedList(@RequestParam(name = "sample") StockInventoryTaskVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.StockInventoryTaskController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static StockInventoryTaskServiceProxy api() {
        return APIProxy.get(StockInventoryTaskServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
