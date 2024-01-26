package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.SalaryProjectTime;
import com.dt.platform.domain.hr.SalaryProjectTimeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 计时项目 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-26 14:49:23
 */
@FeignClient(value = ServiceNames.HR, contextId = SalaryProjectTimeServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface SalaryProjectTimeServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-salary-project-time
     */
    public static final String API_CONTEXT_PATH = "hr-salary-project-time";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加计时项目
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除计时项目
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除计时项目
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新计时项目
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存计时项目
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个计时项目
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个计时项目
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询计时项目
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询计时项目
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加计时项目
     */
    @RequestMapping(SalaryProjectTimeServiceProxy.INSERT)
    Result insert(@RequestParam(name = "salaryProjectTimeVO") SalaryProjectTimeVO salaryProjectTimeVO);

    /**
     * 删除计时项目
     */
    @RequestMapping(SalaryProjectTimeServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除计时项目
     */
    @RequestMapping(SalaryProjectTimeServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新计时项目
     */
    @RequestMapping(SalaryProjectTimeServiceProxy.UPDATE)
    Result update(@RequestParam(name = "salaryProjectTimeVO") SalaryProjectTimeVO salaryProjectTimeVO);

    /**
     * 更新计时项目
     */
    @RequestMapping(SalaryProjectTimeServiceProxy.SAVE)
    Result save(@RequestParam(name = "salaryProjectTimeVO") SalaryProjectTimeVO salaryProjectTimeVO);

    /**
     * 获取计时项目
     */
    @RequestMapping(SalaryProjectTimeServiceProxy.GET_BY_ID)
    Result<SalaryProjectTime> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个计时项目
     */
    @RequestMapping(SalaryProjectTimeServiceProxy.GET_BY_IDS)
    Result<List<SalaryProjectTime>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询计时项目
     */
    @RequestMapping(SalaryProjectTimeServiceProxy.QUERY_LIST)
    Result<List<SalaryProjectTime>> queryList(@RequestParam(name = "sample") SalaryProjectTimeVO sample);

    /**
     * 分页查询计时项目
     */
    @RequestMapping(SalaryProjectTimeServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<SalaryProjectTime>> queryPagedList(@RequestParam(name = "sample") SalaryProjectTimeVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.SalaryProjectTimeController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static SalaryProjectTimeServiceProxy api() {
        return APIProxy.get(SalaryProjectTimeServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
