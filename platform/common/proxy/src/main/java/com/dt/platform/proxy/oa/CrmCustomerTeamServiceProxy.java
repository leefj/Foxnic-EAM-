package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.CrmCustomerTeam;
import com.dt.platform.domain.oa.CrmCustomerTeamVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 团队成员 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-14 19:07:58
 */
@FeignClient(value = ServiceNames.OA, contextId = CrmCustomerTeamServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CrmCustomerTeamServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-crm-customer-team
     */
    public static final String API_CONTEXT_PATH = "oa-crm-customer-team";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加团队成员
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除团队成员
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除团队成员
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新团队成员
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存团队成员
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个团队成员
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个团队成员
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询团队成员
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询团队成员
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加团队成员
     */
    @RequestMapping(CrmCustomerTeamServiceProxy.INSERT)
    Result insert(@RequestParam(name = "crmCustomerTeamVO") CrmCustomerTeamVO crmCustomerTeamVO);

    /**
     * 删除团队成员
     */
    @RequestMapping(CrmCustomerTeamServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除团队成员
     */
    @RequestMapping(CrmCustomerTeamServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新团队成员
     */
    @RequestMapping(CrmCustomerTeamServiceProxy.UPDATE)
    Result update(@RequestParam(name = "crmCustomerTeamVO") CrmCustomerTeamVO crmCustomerTeamVO);

    /**
     * 更新团队成员
     */
    @RequestMapping(CrmCustomerTeamServiceProxy.SAVE)
    Result save(@RequestParam(name = "crmCustomerTeamVO") CrmCustomerTeamVO crmCustomerTeamVO);

    /**
     * 获取团队成员
     */
    @RequestMapping(CrmCustomerTeamServiceProxy.GET_BY_ID)
    Result<CrmCustomerTeam> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个团队成员
     */
    @RequestMapping(CrmCustomerTeamServiceProxy.GET_BY_IDS)
    Result<List<CrmCustomerTeam>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询团队成员
     */
    @RequestMapping(CrmCustomerTeamServiceProxy.QUERY_LIST)
    Result<List<CrmCustomerTeam>> queryList(@RequestParam(name = "sample") CrmCustomerTeamVO sample);

    /**
     * 分页查询团队成员
     */
    @RequestMapping(CrmCustomerTeamServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CrmCustomerTeam>> queryPagedList(@RequestParam(name = "sample") CrmCustomerTeamVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.CrmCustomerTeamController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CrmCustomerTeamServiceProxy api() {
        return APIProxy.get(CrmCustomerTeamServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
