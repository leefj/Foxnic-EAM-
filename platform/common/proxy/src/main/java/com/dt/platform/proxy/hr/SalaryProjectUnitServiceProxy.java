package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.SalaryProjectUnit;
import com.dt.platform.domain.hr.SalaryProjectUnitVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 计件项目 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-26 14:49:35
 */
@FeignClient(value = ServiceNames.HR, contextId = SalaryProjectUnitServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface SalaryProjectUnitServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-salary-project-unit
     */
    public static final String API_CONTEXT_PATH = "hr-salary-project-unit";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加计件项目
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除计件项目
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除计件项目
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新计件项目
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存计件项目
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个计件项目
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个计件项目
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询计件项目
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询计件项目
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加计件项目
     */
    @RequestMapping(SalaryProjectUnitServiceProxy.INSERT)
    Result insert(@RequestParam(name = "salaryProjectUnitVO") SalaryProjectUnitVO salaryProjectUnitVO);

    /**
     * 删除计件项目
     */
    @RequestMapping(SalaryProjectUnitServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除计件项目
     */
    @RequestMapping(SalaryProjectUnitServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新计件项目
     */
    @RequestMapping(SalaryProjectUnitServiceProxy.UPDATE)
    Result update(@RequestParam(name = "salaryProjectUnitVO") SalaryProjectUnitVO salaryProjectUnitVO);

    /**
     * 更新计件项目
     */
    @RequestMapping(SalaryProjectUnitServiceProxy.SAVE)
    Result save(@RequestParam(name = "salaryProjectUnitVO") SalaryProjectUnitVO salaryProjectUnitVO);

    /**
     * 获取计件项目
     */
    @RequestMapping(SalaryProjectUnitServiceProxy.GET_BY_ID)
    Result<SalaryProjectUnit> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个计件项目
     */
    @RequestMapping(SalaryProjectUnitServiceProxy.GET_BY_IDS)
    Result<List<SalaryProjectUnit>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询计件项目
     */
    @RequestMapping(SalaryProjectUnitServiceProxy.QUERY_LIST)
    Result<List<SalaryProjectUnit>> queryList(@RequestParam(name = "sample") SalaryProjectUnitVO sample);

    /**
     * 分页查询计件项目
     */
    @RequestMapping(SalaryProjectUnitServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<SalaryProjectUnit>> queryPagedList(@RequestParam(name = "sample") SalaryProjectUnitVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.SalaryProjectUnitController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static SalaryProjectUnitServiceProxy api() {
        return APIProxy.get(SalaryProjectUnitServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
