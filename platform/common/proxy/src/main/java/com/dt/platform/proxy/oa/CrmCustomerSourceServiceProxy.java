package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.CrmCustomerSource;
import com.dt.platform.domain.oa.CrmCustomerSourceVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 客户渠道 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-13 07:30:49
 */
@FeignClient(value = ServiceNames.OA, contextId = CrmCustomerSourceServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CrmCustomerSourceServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-crm-customer-source
     */
    public static final String API_CONTEXT_PATH = "oa-crm-customer-source";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加客户渠道
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除客户渠道
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除客户渠道
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新客户渠道
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存客户渠道
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个客户渠道
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个客户渠道
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询客户渠道
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询客户渠道
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加客户渠道
     */
    @RequestMapping(CrmCustomerSourceServiceProxy.INSERT)
    Result insert(@RequestParam(name = "crmCustomerSourceVO") CrmCustomerSourceVO crmCustomerSourceVO);

    /**
     * 删除客户渠道
     */
    @RequestMapping(CrmCustomerSourceServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除客户渠道
     */
    @RequestMapping(CrmCustomerSourceServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新客户渠道
     */
    @RequestMapping(CrmCustomerSourceServiceProxy.UPDATE)
    Result update(@RequestParam(name = "crmCustomerSourceVO") CrmCustomerSourceVO crmCustomerSourceVO);

    /**
     * 更新客户渠道
     */
    @RequestMapping(CrmCustomerSourceServiceProxy.SAVE)
    Result save(@RequestParam(name = "crmCustomerSourceVO") CrmCustomerSourceVO crmCustomerSourceVO);

    /**
     * 获取客户渠道
     */
    @RequestMapping(CrmCustomerSourceServiceProxy.GET_BY_ID)
    Result<CrmCustomerSource> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个客户渠道
     */
    @RequestMapping(CrmCustomerSourceServiceProxy.GET_BY_IDS)
    Result<List<CrmCustomerSource>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询客户渠道
     */
    @RequestMapping(CrmCustomerSourceServiceProxy.QUERY_LIST)
    Result<List<CrmCustomerSource>> queryList(@RequestParam(name = "sample") CrmCustomerSourceVO sample);

    /**
     * 分页查询客户渠道
     */
    @RequestMapping(CrmCustomerSourceServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CrmCustomerSource>> queryPagedList(@RequestParam(name = "sample") CrmCustomerSourceVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.CrmCustomerSourceController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CrmCustomerSourceServiceProxy api() {
        return APIProxy.get(CrmCustomerSourceServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
