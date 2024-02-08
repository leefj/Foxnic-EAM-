package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.SalaryProjectCommissionRcd;
import com.dt.platform.domain.hr.SalaryProjectCommissionRcdVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 项目提成记录 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-28 19:52:22
 */
@FeignClient(value = ServiceNames.HR, contextId = SalaryProjectCommissionRcdServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface SalaryProjectCommissionRcdServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-salary-project-commission-rcd
     */
    public static final String API_CONTEXT_PATH = "hr-salary-project-commission-rcd";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加项目提成记录
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除项目提成记录
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除项目提成记录
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新项目提成记录
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存项目提成记录
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个项目提成记录
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个项目提成记录
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询项目提成记录
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询项目提成记录
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 生效
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";
    /**
     * 生效
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 添加项目提成记录
     */
    @RequestMapping(SalaryProjectCommissionRcdServiceProxy.INSERT)
    Result insert(@RequestParam(name = "salaryProjectCommissionRcdVO") SalaryProjectCommissionRcdVO salaryProjectCommissionRcdVO);

    /**
     * 删除项目提成记录
     */
    @RequestMapping(SalaryProjectCommissionRcdServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除项目提成记录
     */
    @RequestMapping(SalaryProjectCommissionRcdServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新项目提成记录
     */
    @RequestMapping(SalaryProjectCommissionRcdServiceProxy.UPDATE)
    Result update(@RequestParam(name = "salaryProjectCommissionRcdVO") SalaryProjectCommissionRcdVO salaryProjectCommissionRcdVO);

    /**
     * 更新项目提成记录
     */
    @RequestMapping(SalaryProjectCommissionRcdServiceProxy.SAVE)
    Result save(@RequestParam(name = "salaryProjectCommissionRcdVO") SalaryProjectCommissionRcdVO salaryProjectCommissionRcdVO);

    /**
     * 获取项目提成记录
     */
    @RequestMapping(SalaryProjectCommissionRcdServiceProxy.GET_BY_ID)
    Result<SalaryProjectCommissionRcd> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个项目提成记录
     */
    @RequestMapping(SalaryProjectCommissionRcdServiceProxy.GET_BY_IDS)
    Result<List<SalaryProjectCommissionRcd>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询项目提成记录
     */
    @RequestMapping(SalaryProjectCommissionRcdServiceProxy.QUERY_LIST)
    Result<List<SalaryProjectCommissionRcd>> queryList(@RequestParam(name = "sample") SalaryProjectCommissionRcdVO sample);

    /**
     * 分页查询项目提成记录
     */
    @RequestMapping(SalaryProjectCommissionRcdServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<SalaryProjectCommissionRcd>> queryPagedList(@RequestParam(name = "sample") SalaryProjectCommissionRcdVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.SalaryProjectCommissionRcdController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static SalaryProjectCommissionRcdServiceProxy api() {
        return APIProxy.get(SalaryProjectCommissionRcdServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
