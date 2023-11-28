package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.PurchaseImport;
import com.dt.platform.domain.eam.PurchaseImportVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 采购单导入 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-11-25 21:35:08
 */
@FeignClient(value = ServiceNames.EAM, contextId = PurchaseImportServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PurchaseImportServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-purchase-import
     */
    public static final String API_CONTEXT_PATH = "eam-purchase-import";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加采购单导入
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除采购单导入
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除采购单导入
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新采购单导入
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存采购单导入
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个采购单导入
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个采购单导入
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询采购单导入
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询采购单导入
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";


    /**
     * 导入资产
     */
    public static final String LOAD_ASSET = API_PREFIX + "load-asset";

    /**
     * 取消
     */
    public static final String CANCEL = API_PREFIX + "cancel";

    /**
     * 确认
     */
    public static final String SURE = API_PREFIX + "sure";

    /**
     * 确认
     */
    public static final String FILL = API_PREFIX + "fill";

    /**
     * 添加采购单导入
     */
    @RequestMapping(PurchaseImportServiceProxy.INSERT)
    Result insert(@RequestParam(name = "purchaseImportVO") PurchaseImportVO purchaseImportVO);

    /**
     * 删除采购单导入
     */
    @RequestMapping(PurchaseImportServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除采购单导入
     */
    @RequestMapping(PurchaseImportServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新采购单导入
     */
    @RequestMapping(PurchaseImportServiceProxy.UPDATE)
    Result update(@RequestParam(name = "purchaseImportVO") PurchaseImportVO purchaseImportVO);

    /**
     * 更新采购单导入
     */
    @RequestMapping(PurchaseImportServiceProxy.SAVE)
    Result save(@RequestParam(name = "purchaseImportVO") PurchaseImportVO purchaseImportVO);

    /**
     * 获取采购单导入
     */
    @RequestMapping(PurchaseImportServiceProxy.GET_BY_ID)
    Result<PurchaseImport> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个采购单导入
     */
    @RequestMapping(PurchaseImportServiceProxy.GET_BY_IDS)
    Result<List<PurchaseImport>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询采购单导入
     */
    @RequestMapping(PurchaseImportServiceProxy.QUERY_LIST)
    Result<List<PurchaseImport>> queryList(@RequestParam(name = "sample") PurchaseImportVO sample);

    /**
     * 分页查询采购单导入
     */
    @RequestMapping(PurchaseImportServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<PurchaseImport>> queryPagedList(@RequestParam(name = "sample") PurchaseImportVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.PurchaseImportController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static PurchaseImportServiceProxy api() {
        return APIProxy.get(PurchaseImportServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
