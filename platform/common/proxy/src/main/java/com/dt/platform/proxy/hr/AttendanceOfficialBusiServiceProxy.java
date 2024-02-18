package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.AttendanceOfficialBusi;
import com.dt.platform.domain.hr.AttendanceOfficialBusiVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 出差管理 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-15 21:09:06
 */
@FeignClient(value = ServiceNames.HR, contextId = AttendanceOfficialBusiServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AttendanceOfficialBusiServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-attendance-official-busi
     */
    public static final String API_CONTEXT_PATH = "hr-attendance-official-busi";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加出差管理
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除出差管理
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除出差管理
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新出差管理
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存出差管理
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个出差管理
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个出差管理
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询出差管理
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询出差管理
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出出差管理数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载出差管理导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入出差管理数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加出差管理
     */
    @RequestMapping(AttendanceOfficialBusiServiceProxy.INSERT)
    Result insert(@RequestParam(name = "attendanceOfficialBusiVO") AttendanceOfficialBusiVO attendanceOfficialBusiVO);

    /**
     * 删除出差管理
     */
    @RequestMapping(AttendanceOfficialBusiServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除出差管理
     */
    @RequestMapping(AttendanceOfficialBusiServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新出差管理
     */
    @RequestMapping(AttendanceOfficialBusiServiceProxy.UPDATE)
    Result update(@RequestParam(name = "attendanceOfficialBusiVO") AttendanceOfficialBusiVO attendanceOfficialBusiVO);

    /**
     * 更新出差管理
     */
    @RequestMapping(AttendanceOfficialBusiServiceProxy.SAVE)
    Result save(@RequestParam(name = "attendanceOfficialBusiVO") AttendanceOfficialBusiVO attendanceOfficialBusiVO);

    /**
     * 获取出差管理
     */
    @RequestMapping(AttendanceOfficialBusiServiceProxy.GET_BY_ID)
    Result<AttendanceOfficialBusi> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个出差管理
     */
    @RequestMapping(AttendanceOfficialBusiServiceProxy.GET_BY_IDS)
    Result<List<AttendanceOfficialBusi>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询出差管理
     */
    @RequestMapping(AttendanceOfficialBusiServiceProxy.QUERY_LIST)
    Result<List<AttendanceOfficialBusi>> queryList(@RequestParam(name = "sample") AttendanceOfficialBusiVO sample);

    /**
     * 导出 Excel
     */
    @RequestMapping(AttendanceOfficialBusiServiceProxy.EXPORT_EXCEL)
    void exportExcel(@RequestParam(name = "sample") AttendanceOfficialBusiVO sample, @RequestParam(name = "response") HttpServletResponse response) throws Exception;

    /**
     * 导出 Excel 模板
     */
    @RequestMapping(AttendanceOfficialBusiServiceProxy.EXPORT_EXCEL_TEMPLATE)
    void exportExcelTemplate(@RequestParam(name = "response") HttpServletResponse response) throws Exception;

    /**
     * 导入 Excel
     */
    @RequestMapping(AttendanceOfficialBusiServiceProxy.IMPORT_EXCEL)
    Result importExcel(@RequestParam(name = "request") MultipartHttpServletRequest request, @RequestParam(name = "response") HttpServletResponse response) throws Exception;

    /**
     * 分页查询出差管理
     */
    @RequestMapping(AttendanceOfficialBusiServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AttendanceOfficialBusi>> queryPagedList(@RequestParam(name = "sample") AttendanceOfficialBusiVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.AttendanceOfficialBusiController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AttendanceOfficialBusiServiceProxy api() {
        return APIProxy.get(AttendanceOfficialBusiServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
