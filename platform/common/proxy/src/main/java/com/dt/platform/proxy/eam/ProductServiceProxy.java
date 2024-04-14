package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.Product;
import com.dt.platform.domain.eam.ProductVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 产品管理 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-08 07:38:38
 */
@FeignClient(value = ServiceNames.EAM, contextId = ProductServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ProductServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , iot-product
     */
    public static final String API_CONTEXT_PATH = "iot-product";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加产品管理
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除产品管理
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除产品管理
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新产品管理
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存产品管理
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个产品管理
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个产品管理
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询产品管理
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询产品管理
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加产品管理
     */
    @RequestMapping(ProductServiceProxy.INSERT)
    Result insert(@RequestParam(name = "productVO") ProductVO productVO);

    /**
     * 删除产品管理
     */
    @RequestMapping(ProductServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除产品管理
     */
    @RequestMapping(ProductServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新产品管理
     */
    @RequestMapping(ProductServiceProxy.UPDATE)
    Result update(@RequestParam(name = "productVO") ProductVO productVO);

    /**
     * 更新产品管理
     */
    @RequestMapping(ProductServiceProxy.SAVE)
    Result save(@RequestParam(name = "productVO") ProductVO productVO);

    /**
     * 获取产品管理
     */
    @RequestMapping(ProductServiceProxy.GET_BY_ID)
    Result<Product> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个产品管理
     */
    @RequestMapping(ProductServiceProxy.GET_BY_IDS)
    Result<List<Product>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询产品管理
     */
    @RequestMapping(ProductServiceProxy.QUERY_LIST)
    Result<List<Product>> queryList(@RequestParam(name = "sample") ProductVO sample);

    /**
     * 分页查询产品管理
     */
    @RequestMapping(ProductServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Product>> queryPagedList(@RequestParam(name = "sample") ProductVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.ProductController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ProductServiceProxy api() {
        return APIProxy.get(ProductServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
