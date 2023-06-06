package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.PersonAttendanceRec;
import com.dt.platform.domain.hr.PersonAttendanceRecVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 人员考勤 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-06 10:58:37
 */
@FeignClient(value = ServiceNames.HR, contextId = PersonAttendanceRecServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PersonAttendanceRecServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-person-attendance-rec
     */
    public static final String API_CONTEXT_PATH = "hr-person-attendance-rec";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加人员考勤
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除人员考勤
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除人员考勤
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新人员考勤
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存人员考勤
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个人员考勤
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个人员考勤
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询人员考勤
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询人员考勤
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出人员考勤数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载人员考勤导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入人员考勤数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加人员考勤
     */
    @RequestMapping(PersonAttendanceRecServiceProxy.INSERT)
    Result insert(@RequestParam(name = "personAttendanceRecVO") PersonAttendanceRecVO personAttendanceRecVO);

    /**
     * 删除人员考勤
     */
    @RequestMapping(PersonAttendanceRecServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除人员考勤
     */
    @RequestMapping(PersonAttendanceRecServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新人员考勤
     */
    @RequestMapping(PersonAttendanceRecServiceProxy.UPDATE)
    Result update(@RequestParam(name = "personAttendanceRecVO") PersonAttendanceRecVO personAttendanceRecVO);

    /**
     * 更新人员考勤
     */
    @RequestMapping(PersonAttendanceRecServiceProxy.SAVE)
    Result save(@RequestParam(name = "personAttendanceRecVO") PersonAttendanceRecVO personAttendanceRecVO);

    /**
     * 获取人员考勤
     */
    @RequestMapping(PersonAttendanceRecServiceProxy.GET_BY_ID)
    Result<PersonAttendanceRec> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个人员考勤
     */
    @RequestMapping(PersonAttendanceRecServiceProxy.GET_BY_IDS)
    Result<List<PersonAttendanceRec>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询人员考勤
     */
    @RequestMapping(PersonAttendanceRecServiceProxy.QUERY_LIST)
    Result<List<PersonAttendanceRec>> queryList(@RequestParam(name = "sample") PersonAttendanceRecVO sample);

    /**
     * 导出 Excel
     */
    @RequestMapping(PersonAttendanceRecServiceProxy.EXPORT_EXCEL)
    void exportExcel(@RequestParam(name = "sample") PersonAttendanceRecVO sample, @RequestParam(name = "response") HttpServletResponse response) throws Exception;

    /**
     * 导出 Excel 模板
     */
    @RequestMapping(PersonAttendanceRecServiceProxy.EXPORT_EXCEL_TEMPLATE)
    void exportExcelTemplate(@RequestParam(name = "response") HttpServletResponse response) throws Exception;

    /**
     * 导入 Excel
     */
    @RequestMapping(PersonAttendanceRecServiceProxy.IMPORT_EXCEL)
    Result importExcel(@RequestParam(name = "request") MultipartHttpServletRequest request, @RequestParam(name = "response") HttpServletResponse response) throws Exception;

    /**
     * 分页查询人员考勤
     */
    @RequestMapping(PersonAttendanceRecServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<PersonAttendanceRec>> queryPagedList(@RequestParam(name = "sample") PersonAttendanceRecVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.PersonAttendanceRecController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static PersonAttendanceRecServiceProxy api() {
        return APIProxy.get(PersonAttendanceRecServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
