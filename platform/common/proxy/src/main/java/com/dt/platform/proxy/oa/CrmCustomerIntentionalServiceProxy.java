package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.CrmCustomerIntentional;
import com.dt.platform.domain.oa.CrmCustomerIntentionalVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 客户意向 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-13 07:32:22
 */
@FeignClient(value = ServiceNames.OA, contextId = CrmCustomerIntentionalServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CrmCustomerIntentionalServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-crm-customer-intentional
     */
    public static final String API_CONTEXT_PATH = "oa-crm-customer-intentional";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加客户意向
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除客户意向
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除客户意向
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新客户意向
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存客户意向
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个客户意向
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个客户意向
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询客户意向
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询客户意向
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加客户意向
     */
    @RequestMapping(CrmCustomerIntentionalServiceProxy.INSERT)
    Result insert(@RequestParam(name = "crmCustomerIntentionalVO") CrmCustomerIntentionalVO crmCustomerIntentionalVO);

    /**
     * 删除客户意向
     */
    @RequestMapping(CrmCustomerIntentionalServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除客户意向
     */
    @RequestMapping(CrmCustomerIntentionalServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新客户意向
     */
    @RequestMapping(CrmCustomerIntentionalServiceProxy.UPDATE)
    Result update(@RequestParam(name = "crmCustomerIntentionalVO") CrmCustomerIntentionalVO crmCustomerIntentionalVO);

    /**
     * 更新客户意向
     */
    @RequestMapping(CrmCustomerIntentionalServiceProxy.SAVE)
    Result save(@RequestParam(name = "crmCustomerIntentionalVO") CrmCustomerIntentionalVO crmCustomerIntentionalVO);

    /**
     * 获取客户意向
     */
    @RequestMapping(CrmCustomerIntentionalServiceProxy.GET_BY_ID)
    Result<CrmCustomerIntentional> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个客户意向
     */
    @RequestMapping(CrmCustomerIntentionalServiceProxy.GET_BY_IDS)
    Result<List<CrmCustomerIntentional>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询客户意向
     */
    @RequestMapping(CrmCustomerIntentionalServiceProxy.QUERY_LIST)
    Result<List<CrmCustomerIntentional>> queryList(@RequestParam(name = "sample") CrmCustomerIntentionalVO sample);

    /**
     * 分页查询客户意向
     */
    @RequestMapping(CrmCustomerIntentionalServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CrmCustomerIntentional>> queryPagedList(@RequestParam(name = "sample") CrmCustomerIntentionalVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.CrmCustomerIntentionalController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CrmCustomerIntentionalServiceProxy api() {
        return APIProxy.get(CrmCustomerIntentionalServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
