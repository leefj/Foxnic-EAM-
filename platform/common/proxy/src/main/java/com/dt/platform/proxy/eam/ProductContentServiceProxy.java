package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.ProductContent;
import com.dt.platform.domain.eam.ProductContentVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 设备内容 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-08 07:37:34
 */
@FeignClient(value = ServiceNames.EAM, contextId = ProductContentServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ProductContentServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , iot-product-content
     */
    public static final String API_CONTEXT_PATH = "iot-product-content";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加设备内容
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除设备内容
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除设备内容
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新设备内容
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存设备内容
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个设备内容
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个设备内容
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询设备内容
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询设备内容
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加设备内容
     */
    @RequestMapping(ProductContentServiceProxy.INSERT)
    Result insert(@RequestParam(name = "productContentVO") ProductContentVO productContentVO);

    /**
     * 删除设备内容
     */
    @RequestMapping(ProductContentServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除设备内容
     */
    @RequestMapping(ProductContentServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新设备内容
     */
    @RequestMapping(ProductContentServiceProxy.UPDATE)
    Result update(@RequestParam(name = "productContentVO") ProductContentVO productContentVO);

    /**
     * 更新设备内容
     */
    @RequestMapping(ProductContentServiceProxy.SAVE)
    Result save(@RequestParam(name = "productContentVO") ProductContentVO productContentVO);

    /**
     * 获取设备内容
     */
    @RequestMapping(ProductContentServiceProxy.GET_BY_ID)
    Result<ProductContent> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个设备内容
     */
    @RequestMapping(ProductContentServiceProxy.GET_BY_IDS)
    Result<List<ProductContent>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询设备内容
     */
    @RequestMapping(ProductContentServiceProxy.QUERY_LIST)
    Result<List<ProductContent>> queryList(@RequestParam(name = "sample") ProductContentVO sample);

    /**
     * 分页查询设备内容
     */
    @RequestMapping(ProductContentServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ProductContent>> queryPagedList(@RequestParam(name = "sample") ProductContentVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.ProductContentController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ProductContentServiceProxy api() {
        return APIProxy.get(ProductContentServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
