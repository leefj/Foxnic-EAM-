package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.CrmCustomerLeads;
import com.dt.platform.domain.oa.CrmCustomerLeadsVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 线索 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-14 13:06:39
 */
@FeignClient(value = ServiceNames.OA, contextId = CrmCustomerLeadsServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CrmCustomerLeadsServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-crm-customer-leads
     */
    public static final String API_CONTEXT_PATH = "oa-crm-customer-leads";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加线索
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除线索
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除线索
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新线索
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存线索
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个线索
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个线索
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询线索
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询线索
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";


    /**
     * 分页查询线索
     */
    public static final String CONVERT_TO_CUSTOMER = API_PREFIX + "convert-to-customer";

    /**
     * 添加线索
     */
    @RequestMapping(CrmCustomerLeadsServiceProxy.INSERT)
    Result insert(@RequestParam(name = "crmCustomerLeadsVO") CrmCustomerLeadsVO crmCustomerLeadsVO);

    /**
     * 删除线索
     */
    @RequestMapping(CrmCustomerLeadsServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除线索
     */
    @RequestMapping(CrmCustomerLeadsServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新线索
     */
    @RequestMapping(CrmCustomerLeadsServiceProxy.UPDATE)
    Result update(@RequestParam(name = "crmCustomerLeadsVO") CrmCustomerLeadsVO crmCustomerLeadsVO);

    /**
     * 更新线索
     */
    @RequestMapping(CrmCustomerLeadsServiceProxy.SAVE)
    Result save(@RequestParam(name = "crmCustomerLeadsVO") CrmCustomerLeadsVO crmCustomerLeadsVO);

    /**
     * 获取线索
     */
    @RequestMapping(CrmCustomerLeadsServiceProxy.GET_BY_ID)
    Result<CrmCustomerLeads> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个线索
     */
    @RequestMapping(CrmCustomerLeadsServiceProxy.GET_BY_IDS)
    Result<List<CrmCustomerLeads>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询线索
     */
    @RequestMapping(CrmCustomerLeadsServiceProxy.QUERY_LIST)
    Result<List<CrmCustomerLeads>> queryList(@RequestParam(name = "sample") CrmCustomerLeadsVO sample);

    /**
     * 分页查询线索
     */
    @RequestMapping(CrmCustomerLeadsServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CrmCustomerLeads>> queryPagedList(@RequestParam(name = "sample") CrmCustomerLeadsVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.CrmCustomerLeadsController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CrmCustomerLeadsServiceProxy api() {
        return APIProxy.get(CrmCustomerLeadsServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
