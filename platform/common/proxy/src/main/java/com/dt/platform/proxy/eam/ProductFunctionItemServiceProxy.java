package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.ProductFunctionItem;
import com.dt.platform.domain.eam.ProductFunctionItemVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 内容 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-08 07:38:31
 */
@FeignClient(value = ServiceNames.EAM, contextId = ProductFunctionItemServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ProductFunctionItemServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , iot-product-function-item
     */
    public static final String API_CONTEXT_PATH = "iot-product-function-item";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加内容
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除内容
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除内容
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新内容
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存内容
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个内容
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个内容
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询内容
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询内容
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加内容
     */
    @RequestMapping(ProductFunctionItemServiceProxy.INSERT)
    Result insert(@RequestParam(name = "productFunctionItemVO") ProductFunctionItemVO productFunctionItemVO);

    /**
     * 删除内容
     */
    @RequestMapping(ProductFunctionItemServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除内容
     */
    @RequestMapping(ProductFunctionItemServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新内容
     */
    @RequestMapping(ProductFunctionItemServiceProxy.UPDATE)
    Result update(@RequestParam(name = "productFunctionItemVO") ProductFunctionItemVO productFunctionItemVO);

    /**
     * 更新内容
     */
    @RequestMapping(ProductFunctionItemServiceProxy.SAVE)
    Result save(@RequestParam(name = "productFunctionItemVO") ProductFunctionItemVO productFunctionItemVO);

    /**
     * 获取内容
     */
    @RequestMapping(ProductFunctionItemServiceProxy.GET_BY_ID)
    Result<ProductFunctionItem> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个内容
     */
    @RequestMapping(ProductFunctionItemServiceProxy.GET_BY_IDS)
    Result<List<ProductFunctionItem>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询内容
     */
    @RequestMapping(ProductFunctionItemServiceProxy.QUERY_LIST)
    Result<List<ProductFunctionItem>> queryList(@RequestParam(name = "sample") ProductFunctionItemVO sample);

    /**
     * 分页查询内容
     */
    @RequestMapping(ProductFunctionItemServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ProductFunctionItem>> queryPagedList(@RequestParam(name = "sample") ProductFunctionItemVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.ProductFunctionItemController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ProductFunctionItemServiceProxy api() {
        return APIProxy.get(ProductFunctionItemServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
