package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.GoodsStockRelated;
import com.dt.platform.domain.eam.GoodsStockRelatedVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 父子关联 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-12-17 09:50:48
 */
@FeignClient(value = ServiceNames.EAM, contextId = GoodsStockRelatedServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface GoodsStockRelatedServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-goods-stock-related
     */
    public static final String API_CONTEXT_PATH = "eam-goods-stock-related";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加父子关联
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除父子关联
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除父子关联
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新父子关联
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存父子关联
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个父子关联
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个父子关联
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询父子关联
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询父子关联
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";


    public static final String QUERY_PAGED_LIST_BY_SELECTED = API_PREFIX + "query-paged-list-by-selected";
    /**
     *
     */
    public static final String QUERY_PAGED_LIST_BY_SELECT = API_PREFIX + "query-paged-list-by-select";


    /**
     * 分页查询检查项
     */
    public static final String SELECT_SAVE_IDS = API_PREFIX + "select-save-ids";

    /**
     * 分页查询检查项
     */
    public static final String SELECT_DELETE_BY_ID = API_PREFIX + "select-delete-by-id";
    /**
     * 添加父子关联
     */
    @RequestMapping(GoodsStockRelatedServiceProxy.INSERT)
    Result insert(@RequestParam(name = "goodsStockRelatedVO") GoodsStockRelatedVO goodsStockRelatedVO);

    /**
     * 删除父子关联
     */
    @RequestMapping(GoodsStockRelatedServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除父子关联
     */
    @RequestMapping(GoodsStockRelatedServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新父子关联
     */
    @RequestMapping(GoodsStockRelatedServiceProxy.UPDATE)
    Result update(@RequestParam(name = "goodsStockRelatedVO") GoodsStockRelatedVO goodsStockRelatedVO);

    /**
     * 更新父子关联
     */
    @RequestMapping(GoodsStockRelatedServiceProxy.SAVE)
    Result save(@RequestParam(name = "goodsStockRelatedVO") GoodsStockRelatedVO goodsStockRelatedVO);

    /**
     * 获取父子关联
     */
    @RequestMapping(GoodsStockRelatedServiceProxy.GET_BY_ID)
    Result<GoodsStockRelated> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个父子关联
     */
    @RequestMapping(GoodsStockRelatedServiceProxy.GET_BY_IDS)
    Result<List<GoodsStockRelated>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询父子关联
     */
    @RequestMapping(GoodsStockRelatedServiceProxy.QUERY_LIST)
    Result<List<GoodsStockRelated>> queryList(@RequestParam(name = "sample") GoodsStockRelatedVO sample);

    /**
     * 分页查询父子关联
     */
    @RequestMapping(GoodsStockRelatedServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<GoodsStockRelated>> queryPagedList(@RequestParam(name = "sample") GoodsStockRelatedVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.GoodsStockRelatedController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static GoodsStockRelatedServiceProxy api() {
        return APIProxy.get(GoodsStockRelatedServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
