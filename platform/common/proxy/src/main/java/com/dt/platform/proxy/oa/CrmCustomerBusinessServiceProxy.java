package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.CrmCustomerBusiness;
import com.dt.platform.domain.oa.CrmCustomerBusinessVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 商机 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-14 16:45:00
 */
@FeignClient(value = ServiceNames.OA, contextId = CrmCustomerBusinessServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CrmCustomerBusinessServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-crm-customer-business
     */
    public static final String API_CONTEXT_PATH = "oa-crm-customer-business";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加商机
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除商机
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除商机
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新商机
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存商机
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个商机
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个商机
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询商机
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询商机
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加商机
     */
    @RequestMapping(CrmCustomerBusinessServiceProxy.INSERT)
    Result insert(@RequestParam(name = "crmCustomerBusinessVO") CrmCustomerBusinessVO crmCustomerBusinessVO);

    /**
     * 删除商机
     */
    @RequestMapping(CrmCustomerBusinessServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除商机
     */
    @RequestMapping(CrmCustomerBusinessServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新商机
     */
    @RequestMapping(CrmCustomerBusinessServiceProxy.UPDATE)
    Result update(@RequestParam(name = "crmCustomerBusinessVO") CrmCustomerBusinessVO crmCustomerBusinessVO);

    /**
     * 更新商机
     */
    @RequestMapping(CrmCustomerBusinessServiceProxy.SAVE)
    Result save(@RequestParam(name = "crmCustomerBusinessVO") CrmCustomerBusinessVO crmCustomerBusinessVO);

    /**
     * 获取商机
     */
    @RequestMapping(CrmCustomerBusinessServiceProxy.GET_BY_ID)
    Result<CrmCustomerBusiness> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个商机
     */
    @RequestMapping(CrmCustomerBusinessServiceProxy.GET_BY_IDS)
    Result<List<CrmCustomerBusiness>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询商机
     */
    @RequestMapping(CrmCustomerBusinessServiceProxy.QUERY_LIST)
    Result<List<CrmCustomerBusiness>> queryList(@RequestParam(name = "sample") CrmCustomerBusinessVO sample);

    /**
     * 分页查询商机
     */
    @RequestMapping(CrmCustomerBusinessServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CrmCustomerBusiness>> queryPagedList(@RequestParam(name = "sample") CrmCustomerBusinessVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.CrmCustomerBusinessController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CrmCustomerBusinessServiceProxy api() {
        return APIProxy.get(CrmCustomerBusinessServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
