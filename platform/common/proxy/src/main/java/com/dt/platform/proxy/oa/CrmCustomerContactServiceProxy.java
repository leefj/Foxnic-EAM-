package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.CrmCustomerContact;
import com.dt.platform.domain.oa.CrmCustomerContactVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 联系人 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-14 10:56:31
 */
@FeignClient(value = ServiceNames.OA, contextId = CrmCustomerContactServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CrmCustomerContactServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-crm-customer-contact
     */
    public static final String API_CONTEXT_PATH = "oa-crm-customer-contact";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加联系人
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除联系人
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除联系人
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新联系人
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存联系人
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个联系人
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个联系人
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询联系人
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询联系人
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加联系人
     */
    @RequestMapping(CrmCustomerContactServiceProxy.INSERT)
    Result insert(@RequestParam(name = "crmCustomerContactVO") CrmCustomerContactVO crmCustomerContactVO);

    /**
     * 删除联系人
     */
    @RequestMapping(CrmCustomerContactServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除联系人
     */
    @RequestMapping(CrmCustomerContactServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新联系人
     */
    @RequestMapping(CrmCustomerContactServiceProxy.UPDATE)
    Result update(@RequestParam(name = "crmCustomerContactVO") CrmCustomerContactVO crmCustomerContactVO);

    /**
     * 更新联系人
     */
    @RequestMapping(CrmCustomerContactServiceProxy.SAVE)
    Result save(@RequestParam(name = "crmCustomerContactVO") CrmCustomerContactVO crmCustomerContactVO);

    /**
     * 获取联系人
     */
    @RequestMapping(CrmCustomerContactServiceProxy.GET_BY_ID)
    Result<CrmCustomerContact> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个联系人
     */
    @RequestMapping(CrmCustomerContactServiceProxy.GET_BY_IDS)
    Result<List<CrmCustomerContact>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询联系人
     */
    @RequestMapping(CrmCustomerContactServiceProxy.QUERY_LIST)
    Result<List<CrmCustomerContact>> queryList(@RequestParam(name = "sample") CrmCustomerContactVO sample);

    /**
     * 分页查询联系人
     */
    @RequestMapping(CrmCustomerContactServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CrmCustomerContact>> queryPagedList(@RequestParam(name = "sample") CrmCustomerContactVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.CrmCustomerContactController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CrmCustomerContactServiceProxy api() {
        return APIProxy.get(CrmCustomerContactServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
