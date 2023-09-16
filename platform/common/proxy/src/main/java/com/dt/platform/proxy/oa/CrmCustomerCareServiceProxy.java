package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.CrmCustomerCare;
import com.dt.platform.domain.oa.CrmCustomerCareVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 我的关注 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-16 12:56:44
 */
@FeignClient(value = ServiceNames.OA, contextId = CrmCustomerCareServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CrmCustomerCareServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-crm-customer-care
     */
    public static final String API_CONTEXT_PATH = "oa-crm-customer-care";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加我的关注
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除我的关注
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除我的关注
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新我的关注
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存我的关注
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个我的关注
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个我的关注
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询我的关注
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询我的关注
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加我的关注
     */
    @RequestMapping(CrmCustomerCareServiceProxy.INSERT)
    Result insert(@RequestParam(name = "crmCustomerCareVO") CrmCustomerCareVO crmCustomerCareVO);

    /**
     * 删除我的关注
     */
    @RequestMapping(CrmCustomerCareServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除我的关注
     */
    @RequestMapping(CrmCustomerCareServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新我的关注
     */
    @RequestMapping(CrmCustomerCareServiceProxy.UPDATE)
    Result update(@RequestParam(name = "crmCustomerCareVO") CrmCustomerCareVO crmCustomerCareVO);

    /**
     * 更新我的关注
     */
    @RequestMapping(CrmCustomerCareServiceProxy.SAVE)
    Result save(@RequestParam(name = "crmCustomerCareVO") CrmCustomerCareVO crmCustomerCareVO);

    /**
     * 获取我的关注
     */
    @RequestMapping(CrmCustomerCareServiceProxy.GET_BY_ID)
    Result<CrmCustomerCare> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个我的关注
     */
    @RequestMapping(CrmCustomerCareServiceProxy.GET_BY_IDS)
    Result<List<CrmCustomerCare>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询我的关注
     */
    @RequestMapping(CrmCustomerCareServiceProxy.QUERY_LIST)
    Result<List<CrmCustomerCare>> queryList(@RequestParam(name = "sample") CrmCustomerCareVO sample);

    /**
     * 分页查询我的关注
     */
    @RequestMapping(CrmCustomerCareServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CrmCustomerCare>> queryPagedList(@RequestParam(name = "sample") CrmCustomerCareVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.CrmCustomerCareController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CrmCustomerCareServiceProxy api() {
        return APIProxy.get(CrmCustomerCareServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
