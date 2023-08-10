package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.NetworkNatMap;
import com.dt.platform.domain.ops.NetworkNatMapVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 地址映射 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-10 09:03:13
 */
@FeignClient(value = ServiceNames.OPS, contextId = NetworkNatMapServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface NetworkNatMapServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-network-nat-map
     */
    public static final String API_CONTEXT_PATH = "ops-network-nat-map";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加地址映射
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除地址映射
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除地址映射
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新地址映射
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存地址映射
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个地址映射
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个地址映射
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询地址映射
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询地址映射
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出地址映射数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载地址映射导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入地址映射数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加地址映射
     */
    @RequestMapping(NetworkNatMapServiceProxy.INSERT)
    Result insert(@RequestParam(name = "networkNatMapVO") NetworkNatMapVO networkNatMapVO);

    /**
     * 删除地址映射
     */
    @RequestMapping(NetworkNatMapServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除地址映射
     */
    @RequestMapping(NetworkNatMapServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新地址映射
     */
    @RequestMapping(NetworkNatMapServiceProxy.UPDATE)
    Result update(@RequestParam(name = "networkNatMapVO") NetworkNatMapVO networkNatMapVO);

    /**
     * 更新地址映射
     */
    @RequestMapping(NetworkNatMapServiceProxy.SAVE)
    Result save(@RequestParam(name = "networkNatMapVO") NetworkNatMapVO networkNatMapVO);

    /**
     * 获取地址映射
     */
    @RequestMapping(NetworkNatMapServiceProxy.GET_BY_ID)
    Result<NetworkNatMap> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个地址映射
     */
    @RequestMapping(NetworkNatMapServiceProxy.GET_BY_IDS)
    Result<List<NetworkNatMap>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询地址映射
     */
    @RequestMapping(NetworkNatMapServiceProxy.QUERY_LIST)
    Result<List<NetworkNatMap>> queryList(@RequestParam(name = "sample") NetworkNatMapVO sample);

    /**
     * 导出 Excel
     */
    @RequestMapping(NetworkNatMapServiceProxy.EXPORT_EXCEL)
    void exportExcel(@RequestParam(name = "sample") NetworkNatMapVO sample, @RequestParam(name = "response") HttpServletResponse response) throws Exception;

    /**
     * 导出 Excel 模板
     */
    @RequestMapping(NetworkNatMapServiceProxy.EXPORT_EXCEL_TEMPLATE)
    void exportExcelTemplate(@RequestParam(name = "response") HttpServletResponse response) throws Exception;

    /**
     * 导入 Excel
     */
    @RequestMapping(NetworkNatMapServiceProxy.IMPORT_EXCEL)
    Result importExcel(@RequestParam(name = "request") MultipartHttpServletRequest request, @RequestParam(name = "response") HttpServletResponse response) throws Exception;

    /**
     * 分页查询地址映射
     */
    @RequestMapping(NetworkNatMapServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<NetworkNatMap>> queryPagedList(@RequestParam(name = "sample") NetworkNatMapVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.NetworkNatMapController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static NetworkNatMapServiceProxy api() {
        return APIProxy.get(NetworkNatMapServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
