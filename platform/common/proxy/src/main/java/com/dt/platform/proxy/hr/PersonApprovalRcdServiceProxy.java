package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.PersonApprovalRcd;
import com.dt.platform.domain.hr.PersonApprovalRcdVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 审批记录 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-14 22:04:51
 */
@FeignClient(value = ServiceNames.HR, contextId = PersonApprovalRcdServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PersonApprovalRcdServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-person-approval-rcd
     */
    public static final String API_CONTEXT_PATH = "hr-person-approval-rcd";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加审批记录
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除审批记录
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除审批记录
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新审批记录
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存审批记录
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个审批记录
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个审批记录
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询审批记录
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询审批记录
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加审批记录
     */
    @RequestMapping(PersonApprovalRcdServiceProxy.INSERT)
    Result insert(@RequestParam(name = "personApprovalRcdVO") PersonApprovalRcdVO personApprovalRcdVO);

    /**
     * 删除审批记录
     */
    @RequestMapping(PersonApprovalRcdServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除审批记录
     */
    @RequestMapping(PersonApprovalRcdServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新审批记录
     */
    @RequestMapping(PersonApprovalRcdServiceProxy.UPDATE)
    Result update(@RequestParam(name = "personApprovalRcdVO") PersonApprovalRcdVO personApprovalRcdVO);

    /**
     * 更新审批记录
     */
    @RequestMapping(PersonApprovalRcdServiceProxy.SAVE)
    Result save(@RequestParam(name = "personApprovalRcdVO") PersonApprovalRcdVO personApprovalRcdVO);

    /**
     * 获取审批记录
     */
    @RequestMapping(PersonApprovalRcdServiceProxy.GET_BY_ID)
    Result<PersonApprovalRcd> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个审批记录
     */
    @RequestMapping(PersonApprovalRcdServiceProxy.GET_BY_IDS)
    Result<List<PersonApprovalRcd>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询审批记录
     */
    @RequestMapping(PersonApprovalRcdServiceProxy.QUERY_LIST)
    Result<List<PersonApprovalRcd>> queryList(@RequestParam(name = "sample") PersonApprovalRcdVO sample);

    /**
     * 分页查询审批记录
     */
    @RequestMapping(PersonApprovalRcdServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<PersonApprovalRcd>> queryPagedList(@RequestParam(name = "sample") PersonApprovalRcdVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.PersonApprovalRcdController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static PersonApprovalRcdServiceProxy api() {
        return APIProxy.get(PersonApprovalRcdServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
