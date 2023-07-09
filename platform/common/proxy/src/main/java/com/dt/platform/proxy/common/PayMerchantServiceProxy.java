package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.PayMerchant;
import com.dt.platform.domain.common.PayMerchantVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 商户信息 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-04 10:43:19
 */
@FeignClient(value = ServiceNames.COMMON, contextId = PayMerchantServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PayMerchantServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-pay-merchant
     */
    public static final String API_CONTEXT_PATH = "sys-pay-merchant";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加商户信息
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除商户信息
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除商户信息
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新商户信息
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存商户信息
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个商户信息
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个商户信息
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询商户信息
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询商户信息
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加商户信息
     */
    @RequestMapping(PayMerchantServiceProxy.INSERT)
    Result insert(@RequestParam(name = "payMerchantVO") PayMerchantVO payMerchantVO);

    /**
     * 删除商户信息
     */
    @RequestMapping(PayMerchantServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除商户信息
     */
    @RequestMapping(PayMerchantServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新商户信息
     */
    @RequestMapping(PayMerchantServiceProxy.UPDATE)
    Result update(@RequestParam(name = "payMerchantVO") PayMerchantVO payMerchantVO);

    /**
     * 更新商户信息
     */
    @RequestMapping(PayMerchantServiceProxy.SAVE)
    Result save(@RequestParam(name = "payMerchantVO") PayMerchantVO payMerchantVO);

    /**
     * 获取商户信息
     */
    @RequestMapping(PayMerchantServiceProxy.GET_BY_ID)
    Result<PayMerchant> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个商户信息
     */
    @RequestMapping(PayMerchantServiceProxy.GET_BY_IDS)
    Result<List<PayMerchant>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询商户信息
     */
    @RequestMapping(PayMerchantServiceProxy.QUERY_LIST)
    Result<List<PayMerchant>> queryList(@RequestParam(name = "sample") PayMerchantVO sample);

    /**
     * 分页查询商户信息
     */
    @RequestMapping(PayMerchantServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<PayMerchant>> queryPagedList(@RequestParam(name = "sample") PayMerchantVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.PayMerchantController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static PayMerchantServiceProxy api() {
        return APIProxy.get(PayMerchantServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
