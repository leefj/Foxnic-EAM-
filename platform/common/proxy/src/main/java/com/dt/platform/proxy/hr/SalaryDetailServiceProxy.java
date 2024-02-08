package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.SalaryDetail;
import com.dt.platform.domain.hr.SalaryDetailVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 薪酬明细 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-04 13:01:46
 */
@FeignClient(value = ServiceNames.HR, contextId = SalaryDetailServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface SalaryDetailServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-salary-detail
     */
    public static final String API_CONTEXT_PATH = "hr-salary-detail";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加薪酬明细
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除薪酬明细
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除薪酬明细
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新薪酬明细
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存薪酬明细
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个薪酬明细
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个薪酬明细
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询薪酬明细
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询薪酬明细
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 分页查询薪酬明细
     */
    public static final String MY_QUERY_PAGED_LIST = API_PREFIX + "my-query-paged-list";

    /**
     * 分页查询薪酬明细
     */
    public static final String ACTION_QUERY_PAGED_LIST = API_PREFIX + "action-query-paged-list";

    /**
     * 重置
     */
    public static final String RESET = API_PREFIX + "reset";

    /**
     * 生效
     */
    public static final String VALID = API_PREFIX + "valid";

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



    public static final String QUERY_STATISTICAL_DATA_BY_ACTION_ID = API_PREFIX + "query-statistical-data-by-action-id";

    /**
     * 添加薪酬明细
     */
    @RequestMapping(SalaryDetailServiceProxy.INSERT)
    Result insert(@RequestParam(name = "salaryDetailVO") SalaryDetailVO salaryDetailVO);

    /**
     * 删除薪酬明细
     */
    @RequestMapping(SalaryDetailServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除薪酬明细
     */
    @RequestMapping(SalaryDetailServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新薪酬明细
     */
    @RequestMapping(SalaryDetailServiceProxy.UPDATE)
    Result update(@RequestParam(name = "salaryDetailVO") SalaryDetailVO salaryDetailVO);

    /**
     * 更新薪酬明细
     */
    @RequestMapping(SalaryDetailServiceProxy.SAVE)
    Result save(@RequestParam(name = "salaryDetailVO") SalaryDetailVO salaryDetailVO);

    /**
     * 获取薪酬明细
     */
    @RequestMapping(SalaryDetailServiceProxy.GET_BY_ID)
    Result<SalaryDetail> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个薪酬明细
     */
    @RequestMapping(SalaryDetailServiceProxy.GET_BY_IDS)
    Result<List<SalaryDetail>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询薪酬明细
     */
    @RequestMapping(SalaryDetailServiceProxy.QUERY_LIST)
    Result<List<SalaryDetail>> queryList(@RequestParam(name = "sample") SalaryDetailVO sample);

    /**
     * 分页查询薪酬明细
     */
    @RequestMapping(SalaryDetailServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<SalaryDetail>> queryPagedList(@RequestParam(name = "sample") SalaryDetailVO sample);

    /**
     * 导出 Excel
     */
    @RequestMapping(SalaryDetailServiceProxy.EXPORT_EXCEL)
    void exportExcel(@RequestParam(name = "sample") SalaryDetailVO sample, @RequestParam(name = "response") HttpServletResponse response) throws Exception;

    /**
     * 导出 Excel 模板
     */
    @RequestMapping(SalaryDetailServiceProxy.EXPORT_EXCEL_TEMPLATE)
    void exportExcelTemplate(@RequestParam(name = "response") HttpServletResponse response) throws Exception;

    /**
     * 导入 Excel
     */
    @RequestMapping(SalaryDetailServiceProxy.IMPORT_EXCEL)
    Result importExcel(@RequestParam(name = "request") MultipartHttpServletRequest request, @RequestParam(name = "response") HttpServletResponse response) throws Exception;

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.SalaryDetailController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static SalaryDetailServiceProxy api() {
        return APIProxy.get(SalaryDetailServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
