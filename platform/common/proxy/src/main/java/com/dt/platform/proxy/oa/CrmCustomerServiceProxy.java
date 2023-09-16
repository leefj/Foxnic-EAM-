package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.CrmCustomer;
import com.dt.platform.domain.oa.CrmCustomerVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 客户 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-14 13:06:49
 */
@FeignClient(value = ServiceNames.OA, contextId = CrmCustomerServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CrmCustomerServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-crm-customer
     */
    public static final String API_CONTEXT_PATH = "oa-crm-customer";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加客户
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除客户
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除客户
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新客户
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存客户
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个客户
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个客户
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询客户
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询客户
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    public static final String UNLOCK = API_PREFIX + "unlock";

    public static final String LOCK = API_PREFIX + "lock";

    public static final String DEAL = API_PREFIX + "deal";

    //转入公海
    public static final String TO_OPEN_SEA = API_PREFIX + "to-open-sea";

    //转入无效
    public static final String TO_INVALID = API_PREFIX + "to-invalid";

    //领用
    public static final String COLLECT = API_PREFIX + "collect";

    //共享
    public static final String ADD_USERS = API_PREFIX + "add-users";

    //转移
    public static final String TRANSFER = API_PREFIX + "transfer";

    //分配
    public static final String ALLOCATE = API_PREFIX + "allocate";

    //关乎
    public static final String CARE = API_PREFIX + "care";

    //取消关注
    public static final String CARE_CANCEL = API_PREFIX + "care-cancel";

    //批量转移
    public static final String BATCH_TRANSFER = API_PREFIX + "batch-transfer";

    //批量分配
    public static final String BATCH_ALLOCATE = API_PREFIX + "batch-allocate";

    /**
     * 添加客户
     */
    @RequestMapping(CrmCustomerServiceProxy.INSERT)
    Result insert(@RequestParam(name = "crmCustomerVO") CrmCustomerVO crmCustomerVO);

    /**
     * 删除客户
     */
    @RequestMapping(CrmCustomerServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除客户
     */
    @RequestMapping(CrmCustomerServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新客户
     */
    @RequestMapping(CrmCustomerServiceProxy.UPDATE)
    Result update(@RequestParam(name = "crmCustomerVO") CrmCustomerVO crmCustomerVO);

    /**
     * 更新客户
     */
    @RequestMapping(CrmCustomerServiceProxy.SAVE)
    Result save(@RequestParam(name = "crmCustomerVO") CrmCustomerVO crmCustomerVO);

    /**
     * 获取客户
     */
    @RequestMapping(CrmCustomerServiceProxy.GET_BY_ID)
    Result<CrmCustomer> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个客户
     */
    @RequestMapping(CrmCustomerServiceProxy.GET_BY_IDS)
    Result<List<CrmCustomer>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询客户
     */
    @RequestMapping(CrmCustomerServiceProxy.QUERY_LIST)
    Result<List<CrmCustomer>> queryList(@RequestParam(name = "sample") CrmCustomerVO sample);

    /**
     * 分页查询客户
     */
    @RequestMapping(CrmCustomerServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CrmCustomer>> queryPagedList(@RequestParam(name = "sample") CrmCustomerVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.CrmCustomerController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CrmCustomerServiceProxy api() {
        return APIProxy.get(CrmCustomerServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
