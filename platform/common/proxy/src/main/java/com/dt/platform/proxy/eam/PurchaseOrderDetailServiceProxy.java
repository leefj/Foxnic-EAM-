package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.PurchaseOrderDetail;
import com.dt.platform.domain.eam.PurchaseOrderDetailVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 清单明细 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-07 21:23:16
 */
@FeignClient(value = ServiceNames.EAM, contextId = PurchaseOrderDetailServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PurchaseOrderDetailServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-purchase-order-detail
     */
    public static final String API_CONTEXT_PATH = "eam-purchase-order-detail";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加清单明细
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除清单明细
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除清单明细
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新清单明细
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存清单明细
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个清单明细
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个清单明细
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询清单明细
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询清单明细
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加清单明细
     */
    @RequestMapping(PurchaseOrderDetailServiceProxy.INSERT)
    Result insert(@RequestParam(name = "purchaseOrderDetailVO") PurchaseOrderDetailVO purchaseOrderDetailVO);

    /**
     * 删除清单明细
     */
    @RequestMapping(PurchaseOrderDetailServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除清单明细
     */
    @RequestMapping(PurchaseOrderDetailServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新清单明细
     */
    @RequestMapping(PurchaseOrderDetailServiceProxy.UPDATE)
    Result update(@RequestParam(name = "purchaseOrderDetailVO") PurchaseOrderDetailVO purchaseOrderDetailVO);

    /**
     * 更新清单明细
     */
    @RequestMapping(PurchaseOrderDetailServiceProxy.SAVE)
    Result save(@RequestParam(name = "purchaseOrderDetailVO") PurchaseOrderDetailVO purchaseOrderDetailVO);

    /**
     * 获取清单明细
     */
    @RequestMapping(PurchaseOrderDetailServiceProxy.GET_BY_ID)
    Result<PurchaseOrderDetail> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个清单明细
     */
    @RequestMapping(PurchaseOrderDetailServiceProxy.GET_BY_IDS)
    Result<List<PurchaseOrderDetail>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询清单明细
     */
    @RequestMapping(PurchaseOrderDetailServiceProxy.QUERY_LIST)
    Result<List<PurchaseOrderDetail>> queryList(@RequestParam(name = "sample") PurchaseOrderDetailVO sample);

    /**
     * 分页查询清单明细
     */
    @RequestMapping(PurchaseOrderDetailServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<PurchaseOrderDetail>> queryPagedList(@RequestParam(name = "sample") PurchaseOrderDetailVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.PurchaseOrderDetailController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static PurchaseOrderDetailServiceProxy api() {
        return APIProxy.get(PurchaseOrderDetailServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
