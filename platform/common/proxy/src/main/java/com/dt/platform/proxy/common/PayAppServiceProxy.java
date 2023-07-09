package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.PayApp;
import com.dt.platform.domain.common.PayAppVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 应用 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-04 11:38:06
 */
@FeignClient(value = ServiceNames.COMMON, contextId = PayAppServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PayAppServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-pay-app
     */
    public static final String API_CONTEXT_PATH = "sys-pay-app";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加应用
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除应用
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除应用
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新应用
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存应用
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个应用
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个应用
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询应用
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询应用
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加应用
     */
    @RequestMapping(PayAppServiceProxy.INSERT)
    Result insert(@RequestParam(name = "payAppVO") PayAppVO payAppVO);

    /**
     * 删除应用
     */
    @RequestMapping(PayAppServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除应用
     */
    @RequestMapping(PayAppServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新应用
     */
    @RequestMapping(PayAppServiceProxy.UPDATE)
    Result update(@RequestParam(name = "payAppVO") PayAppVO payAppVO);

    /**
     * 更新应用
     */
    @RequestMapping(PayAppServiceProxy.SAVE)
    Result save(@RequestParam(name = "payAppVO") PayAppVO payAppVO);

    /**
     * 获取应用
     */
    @RequestMapping(PayAppServiceProxy.GET_BY_ID)
    Result<PayApp> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个应用
     */
    @RequestMapping(PayAppServiceProxy.GET_BY_IDS)
    Result<List<PayApp>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询应用
     */
    @RequestMapping(PayAppServiceProxy.QUERY_LIST)
    Result<List<PayApp>> queryList(@RequestParam(name = "sample") PayAppVO sample);

    /**
     * 分页查询应用
     */
    @RequestMapping(PayAppServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<PayApp>> queryPagedList(@RequestParam(name = "sample") PayAppVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.PayAppController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static PayAppServiceProxy api() {
        return APIProxy.get(PayAppServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
