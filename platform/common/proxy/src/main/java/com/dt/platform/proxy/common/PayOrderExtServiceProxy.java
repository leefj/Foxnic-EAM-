package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.PayOrderExt;
import com.dt.platform.domain.common.PayOrderExtVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 支付订单 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-04 16:25:47
 */
@FeignClient(value = ServiceNames.COMMON, contextId = PayOrderExtServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PayOrderExtServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-pay-order-ext
     */
    public static final String API_CONTEXT_PATH = "sys-pay-order-ext";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加支付订单
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除支付订单
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除支付订单
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新支付订单
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存支付订单
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个支付订单
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个支付订单
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询支付订单
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询支付订单
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加支付订单
     */
    @RequestMapping(PayOrderExtServiceProxy.INSERT)
    Result insert(@RequestParam(name = "payOrderExtVO") PayOrderExtVO payOrderExtVO);

    /**
     * 删除支付订单
     */
    @RequestMapping(PayOrderExtServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除支付订单
     */
    @RequestMapping(PayOrderExtServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新支付订单
     */
    @RequestMapping(PayOrderExtServiceProxy.UPDATE)
    Result update(@RequestParam(name = "payOrderExtVO") PayOrderExtVO payOrderExtVO);

    /**
     * 更新支付订单
     */
    @RequestMapping(PayOrderExtServiceProxy.SAVE)
    Result save(@RequestParam(name = "payOrderExtVO") PayOrderExtVO payOrderExtVO);

    /**
     * 获取支付订单
     */
    @RequestMapping(PayOrderExtServiceProxy.GET_BY_ID)
    Result<PayOrderExt> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个支付订单
     */
    @RequestMapping(PayOrderExtServiceProxy.GET_BY_IDS)
    Result<List<PayOrderExt>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询支付订单
     */
    @RequestMapping(PayOrderExtServiceProxy.QUERY_LIST)
    Result<List<PayOrderExt>> queryList(@RequestParam(name = "sample") PayOrderExtVO sample);

    /**
     * 分页查询支付订单
     */
    @RequestMapping(PayOrderExtServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<PayOrderExt>> queryPagedList(@RequestParam(name = "sample") PayOrderExtVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.PayOrderExtController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static PayOrderExtServiceProxy api() {
        return APIProxy.get(PayOrderExtServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
