package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.PayRefund;
import com.dt.platform.domain.common.PayRefundVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 退款订单 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-04 16:15:46
 */
@FeignClient(value = ServiceNames.COMMON, contextId = PayRefundServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PayRefundServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-pay-refund
     */
    public static final String API_CONTEXT_PATH = "sys-pay-refund";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加退款订单
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除退款订单
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除退款订单
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新退款订单
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存退款订单
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个退款订单
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个退款订单
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询退款订单
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询退款订单
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加退款订单
     */
    @RequestMapping(PayRefundServiceProxy.INSERT)
    Result insert(@RequestParam(name = "payRefundVO") PayRefundVO payRefundVO);

    /**
     * 删除退款订单
     */
    @RequestMapping(PayRefundServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除退款订单
     */
    @RequestMapping(PayRefundServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新退款订单
     */
    @RequestMapping(PayRefundServiceProxy.UPDATE)
    Result update(@RequestParam(name = "payRefundVO") PayRefundVO payRefundVO);

    /**
     * 更新退款订单
     */
    @RequestMapping(PayRefundServiceProxy.SAVE)
    Result save(@RequestParam(name = "payRefundVO") PayRefundVO payRefundVO);

    /**
     * 获取退款订单
     */
    @RequestMapping(PayRefundServiceProxy.GET_BY_ID)
    Result<PayRefund> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个退款订单
     */
    @RequestMapping(PayRefundServiceProxy.GET_BY_IDS)
    Result<List<PayRefund>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询退款订单
     */
    @RequestMapping(PayRefundServiceProxy.QUERY_LIST)
    Result<List<PayRefund>> queryList(@RequestParam(name = "sample") PayRefundVO sample);

    /**
     * 分页查询退款订单
     */
    @RequestMapping(PayRefundServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<PayRefund>> queryPagedList(@RequestParam(name = "sample") PayRefundVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.PayRefundController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static PayRefundServiceProxy api() {
        return APIProxy.get(PayRefundServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
