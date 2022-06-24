package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetEmployeeLoss;
import com.dt.platform.domain.eam.AssetEmployeeLossVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 资产报失  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-23 15:53:48
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetEmployeeLossServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetEmployeeLossServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-employee-loss
     */
    public static final String API_CONTEXT_PATH = "eam-asset-employee-loss";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加资产报失
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除资产报失
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除资产报失
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新资产报失
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存资产报失
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个资产报失
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个资产报失
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询资产报失
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询资产报失
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出资产报失数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载资产报失导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入资产报失数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加资产报失
     */
    @RequestMapping(AssetEmployeeLossServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetEmployeeLossVO") AssetEmployeeLossVO assetEmployeeLossVO);

    /**
     * 删除资产报失
     */
    @RequestMapping(AssetEmployeeLossServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除资产报失
     */
    @RequestMapping(AssetEmployeeLossServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新资产报失
     */
    @RequestMapping(AssetEmployeeLossServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetEmployeeLossVO") AssetEmployeeLossVO assetEmployeeLossVO);

    /**
     * 更新资产报失
     */
    @RequestMapping(AssetEmployeeLossServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetEmployeeLossVO") AssetEmployeeLossVO assetEmployeeLossVO);

    /**
     * 获取资产报失
     */
    @RequestMapping(AssetEmployeeLossServiceProxy.GET_BY_ID)
    Result<AssetEmployeeLoss> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个资产报失
     */
    @RequestMapping(AssetEmployeeLossServiceProxy.GET_BY_IDS)
    Result<List<AssetEmployeeLoss>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询资产报失
     */
    @RequestMapping(AssetEmployeeLossServiceProxy.QUERY_LIST)
    Result<List<AssetEmployeeLoss>> queryList(@RequestParam(name = "sample") AssetEmployeeLossVO sample);

    /**
     * 分页查询资产报失
     */
    @RequestMapping(AssetEmployeeLossServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetEmployeeLoss>> queryPagedList(@RequestParam(name = "sample") AssetEmployeeLossVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetEmployeeLossController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetEmployeeLossServiceProxy api() {
        return APIProxy.get(AssetEmployeeLossServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
