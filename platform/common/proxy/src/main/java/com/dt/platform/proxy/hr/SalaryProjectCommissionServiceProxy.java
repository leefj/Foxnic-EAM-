package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.SalaryProjectCommission;
import com.dt.platform.domain.hr.SalaryProjectCommissionVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 项目提成 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-28 14:05:13
 */
@FeignClient(value = ServiceNames.HR, contextId = SalaryProjectCommissionServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface SalaryProjectCommissionServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-salary-project-commission
     */
    public static final String API_CONTEXT_PATH = "hr-salary-project-commission";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加项目提成
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除项目提成
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除项目提成
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新项目提成
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存项目提成
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个项目提成
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个项目提成
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询项目提成
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询项目提成
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加项目提成
     */
    @RequestMapping(SalaryProjectCommissionServiceProxy.INSERT)
    Result insert(@RequestParam(name = "salaryProjectCommissionVO") SalaryProjectCommissionVO salaryProjectCommissionVO);

    /**
     * 删除项目提成
     */
    @RequestMapping(SalaryProjectCommissionServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除项目提成
     */
    @RequestMapping(SalaryProjectCommissionServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新项目提成
     */
    @RequestMapping(SalaryProjectCommissionServiceProxy.UPDATE)
    Result update(@RequestParam(name = "salaryProjectCommissionVO") SalaryProjectCommissionVO salaryProjectCommissionVO);

    /**
     * 更新项目提成
     */
    @RequestMapping(SalaryProjectCommissionServiceProxy.SAVE)
    Result save(@RequestParam(name = "salaryProjectCommissionVO") SalaryProjectCommissionVO salaryProjectCommissionVO);

    /**
     * 获取项目提成
     */
    @RequestMapping(SalaryProjectCommissionServiceProxy.GET_BY_ID)
    Result<SalaryProjectCommission> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个项目提成
     */
    @RequestMapping(SalaryProjectCommissionServiceProxy.GET_BY_IDS)
    Result<List<SalaryProjectCommission>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询项目提成
     */
    @RequestMapping(SalaryProjectCommissionServiceProxy.QUERY_LIST)
    Result<List<SalaryProjectCommission>> queryList(@RequestParam(name = "sample") SalaryProjectCommissionVO sample);

    /**
     * 分页查询项目提成
     */
    @RequestMapping(SalaryProjectCommissionServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<SalaryProjectCommission>> queryPagedList(@RequestParam(name = "sample") SalaryProjectCommissionVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.SalaryProjectCommissionController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static SalaryProjectCommissionServiceProxy api() {
        return APIProxy.get(SalaryProjectCommissionServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}