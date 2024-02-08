package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.SalaryProjectTimeRcd;
import com.dt.platform.domain.hr.SalaryProjectTimeRcdVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 计时项目记录 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-28 19:52:49
 */
@FeignClient(value = ServiceNames.HR, contextId = SalaryProjectTimeRcdServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface SalaryProjectTimeRcdServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-salary-project-time-rcd
     */
    public static final String API_CONTEXT_PATH = "hr-salary-project-time-rcd";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加计时项目记录
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除计时项目记录
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除计时项目记录
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新计时项目记录
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存计时项目记录
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个计时项目记录
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个计时项目记录
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询计时项目记录
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询计时项目记录
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
     * 添加计时项目记录
     */
    @RequestMapping(SalaryProjectTimeRcdServiceProxy.INSERT)
    Result insert(@RequestParam(name = "salaryProjectTimeRcdVO") SalaryProjectTimeRcdVO salaryProjectTimeRcdVO);

    /**
     * 删除计时项目记录
     */
    @RequestMapping(SalaryProjectTimeRcdServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除计时项目记录
     */
    @RequestMapping(SalaryProjectTimeRcdServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新计时项目记录
     */
    @RequestMapping(SalaryProjectTimeRcdServiceProxy.UPDATE)
    Result update(@RequestParam(name = "salaryProjectTimeRcdVO") SalaryProjectTimeRcdVO salaryProjectTimeRcdVO);

    /**
     * 更新计时项目记录
     */
    @RequestMapping(SalaryProjectTimeRcdServiceProxy.SAVE)
    Result save(@RequestParam(name = "salaryProjectTimeRcdVO") SalaryProjectTimeRcdVO salaryProjectTimeRcdVO);

    /**
     * 获取计时项目记录
     */
    @RequestMapping(SalaryProjectTimeRcdServiceProxy.GET_BY_ID)
    Result<SalaryProjectTimeRcd> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个计时项目记录
     */
    @RequestMapping(SalaryProjectTimeRcdServiceProxy.GET_BY_IDS)
    Result<List<SalaryProjectTimeRcd>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询计时项目记录
     */
    @RequestMapping(SalaryProjectTimeRcdServiceProxy.QUERY_LIST)
    Result<List<SalaryProjectTimeRcd>> queryList(@RequestParam(name = "sample") SalaryProjectTimeRcdVO sample);

    /**
     * 分页查询计时项目记录
     */
    @RequestMapping(SalaryProjectTimeRcdServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<SalaryProjectTimeRcd>> queryPagedList(@RequestParam(name = "sample") SalaryProjectTimeRcdVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.SalaryProjectTimeRcdController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static SalaryProjectTimeRcdServiceProxy api() {
        return APIProxy.get(SalaryProjectTimeRcdServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
