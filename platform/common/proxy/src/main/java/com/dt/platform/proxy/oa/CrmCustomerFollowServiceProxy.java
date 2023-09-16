package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.CrmCustomerFollow;
import com.dt.platform.domain.oa.CrmCustomerFollowVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 跟进记录 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-15 14:16:05
 */
@FeignClient(value = ServiceNames.OA, contextId = CrmCustomerFollowServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CrmCustomerFollowServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-crm-customer-follow
     */
    public static final String API_CONTEXT_PATH = "oa-crm-customer-follow";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加跟进记录
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除跟进记录
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除跟进记录
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新跟进记录
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存跟进记录
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个跟进记录
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个跟进记录
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询跟进记录
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询跟进记录
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加跟进记录
     */
    @RequestMapping(CrmCustomerFollowServiceProxy.INSERT)
    Result insert(@RequestParam(name = "crmCustomerFollowVO") CrmCustomerFollowVO crmCustomerFollowVO);

    /**
     * 删除跟进记录
     */
    @RequestMapping(CrmCustomerFollowServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除跟进记录
     */
    @RequestMapping(CrmCustomerFollowServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新跟进记录
     */
    @RequestMapping(CrmCustomerFollowServiceProxy.UPDATE)
    Result update(@RequestParam(name = "crmCustomerFollowVO") CrmCustomerFollowVO crmCustomerFollowVO);

    /**
     * 更新跟进记录
     */
    @RequestMapping(CrmCustomerFollowServiceProxy.SAVE)
    Result save(@RequestParam(name = "crmCustomerFollowVO") CrmCustomerFollowVO crmCustomerFollowVO);

    /**
     * 获取跟进记录
     */
    @RequestMapping(CrmCustomerFollowServiceProxy.GET_BY_ID)
    Result<CrmCustomerFollow> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个跟进记录
     */
    @RequestMapping(CrmCustomerFollowServiceProxy.GET_BY_IDS)
    Result<List<CrmCustomerFollow>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询跟进记录
     */
    @RequestMapping(CrmCustomerFollowServiceProxy.QUERY_LIST)
    Result<List<CrmCustomerFollow>> queryList(@RequestParam(name = "sample") CrmCustomerFollowVO sample);

    /**
     * 分页查询跟进记录
     */
    @RequestMapping(CrmCustomerFollowServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CrmCustomerFollow>> queryPagedList(@RequestParam(name = "sample") CrmCustomerFollowVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.CrmCustomerFollowController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CrmCustomerFollowServiceProxy api() {
        return APIProxy.get(CrmCustomerFollowServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
