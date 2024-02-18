package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.AttendanceHoliday;
import com.dt.platform.domain.hr.AttendanceHolidayVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 休假管理 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-15 21:08:52
 */
@FeignClient(value = ServiceNames.HR, contextId = AttendanceHolidayServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AttendanceHolidayServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-attendance-holiday
     */
    public static final String API_CONTEXT_PATH = "hr-attendance-holiday";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加休假管理
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除休假管理
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除休假管理
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新休假管理
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存休假管理
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个休假管理
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个休假管理
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询休假管理
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询休假管理
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出休假管理数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载休假管理导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入休假管理数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加休假管理
     */
    @RequestMapping(AttendanceHolidayServiceProxy.INSERT)
    Result insert(@RequestParam(name = "attendanceHolidayVO") AttendanceHolidayVO attendanceHolidayVO);

    /**
     * 删除休假管理
     */
    @RequestMapping(AttendanceHolidayServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除休假管理
     */
    @RequestMapping(AttendanceHolidayServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新休假管理
     */
    @RequestMapping(AttendanceHolidayServiceProxy.UPDATE)
    Result update(@RequestParam(name = "attendanceHolidayVO") AttendanceHolidayVO attendanceHolidayVO);

    /**
     * 更新休假管理
     */
    @RequestMapping(AttendanceHolidayServiceProxy.SAVE)
    Result save(@RequestParam(name = "attendanceHolidayVO") AttendanceHolidayVO attendanceHolidayVO);

    /**
     * 获取休假管理
     */
    @RequestMapping(AttendanceHolidayServiceProxy.GET_BY_ID)
    Result<AttendanceHoliday> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个休假管理
     */
    @RequestMapping(AttendanceHolidayServiceProxy.GET_BY_IDS)
    Result<List<AttendanceHoliday>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询休假管理
     */
    @RequestMapping(AttendanceHolidayServiceProxy.QUERY_LIST)
    Result<List<AttendanceHoliday>> queryList(@RequestParam(name = "sample") AttendanceHolidayVO sample);

    /**
     * 导出 Excel
     */
    @RequestMapping(AttendanceHolidayServiceProxy.EXPORT_EXCEL)
    void exportExcel(@RequestParam(name = "sample") AttendanceHolidayVO sample, @RequestParam(name = "response") HttpServletResponse response) throws Exception;

    /**
     * 导出 Excel 模板
     */
    @RequestMapping(AttendanceHolidayServiceProxy.EXPORT_EXCEL_TEMPLATE)
    void exportExcelTemplate(@RequestParam(name = "response") HttpServletResponse response) throws Exception;

    /**
     * 导入 Excel
     */
    @RequestMapping(AttendanceHolidayServiceProxy.IMPORT_EXCEL)
    Result importExcel(@RequestParam(name = "request") MultipartHttpServletRequest request, @RequestParam(name = "response") HttpServletResponse response) throws Exception;

    /**
     * 分页查询休假管理
     */
    @RequestMapping(AttendanceHolidayServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AttendanceHoliday>> queryPagedList(@RequestParam(name = "sample") AttendanceHolidayVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.AttendanceHolidayController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AttendanceHolidayServiceProxy api() {
        return APIProxy.get(AttendanceHolidayServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
