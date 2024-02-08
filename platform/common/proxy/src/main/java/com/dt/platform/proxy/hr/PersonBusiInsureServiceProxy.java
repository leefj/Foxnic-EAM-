package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.PersonBusiInsure;
import com.dt.platform.domain.hr.PersonBusiInsureVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 商业保险 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-06 21:03:03
 */
@FeignClient(value = ServiceNames.HR, contextId = PersonBusiInsureServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PersonBusiInsureServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-person-busi-insure
     */
    public static final String API_CONTEXT_PATH = "hr-person-busi-insure";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加商业保险
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除商业保险
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除商业保险
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新商业保险
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存商业保险
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个商业保险
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个商业保险
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询商业保险
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询商业保险
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出商业保险数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载商业保险导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入商业保险数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加商业保险
     */
    @RequestMapping(PersonBusiInsureServiceProxy.INSERT)
    Result insert(@RequestParam(name = "personBusiInsureVO") PersonBusiInsureVO personBusiInsureVO);

    /**
     * 删除商业保险
     */
    @RequestMapping(PersonBusiInsureServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除商业保险
     */
    @RequestMapping(PersonBusiInsureServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新商业保险
     */
    @RequestMapping(PersonBusiInsureServiceProxy.UPDATE)
    Result update(@RequestParam(name = "personBusiInsureVO") PersonBusiInsureVO personBusiInsureVO);

    /**
     * 更新商业保险
     */
    @RequestMapping(PersonBusiInsureServiceProxy.SAVE)
    Result save(@RequestParam(name = "personBusiInsureVO") PersonBusiInsureVO personBusiInsureVO);

    /**
     * 获取商业保险
     */
    @RequestMapping(PersonBusiInsureServiceProxy.GET_BY_ID)
    Result<PersonBusiInsure> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个商业保险
     */
    @RequestMapping(PersonBusiInsureServiceProxy.GET_BY_IDS)
    Result<List<PersonBusiInsure>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询商业保险
     */
    @RequestMapping(PersonBusiInsureServiceProxy.QUERY_LIST)
    Result<List<PersonBusiInsure>> queryList(@RequestParam(name = "sample") PersonBusiInsureVO sample);

    /**
     * 导出 Excel
     */
    @RequestMapping(PersonBusiInsureServiceProxy.EXPORT_EXCEL)
    void exportExcel(@RequestParam(name = "sample") PersonBusiInsureVO sample, @RequestParam(name = "response") HttpServletResponse response) throws Exception;

    /**
     * 导出 Excel 模板
     */
    @RequestMapping(PersonBusiInsureServiceProxy.EXPORT_EXCEL_TEMPLATE)
    void exportExcelTemplate(@RequestParam(name = "response") HttpServletResponse response) throws Exception;

    /**
     * 导入 Excel
     */
    @RequestMapping(PersonBusiInsureServiceProxy.IMPORT_EXCEL)
    Result importExcel(@RequestParam(name = "request") MultipartHttpServletRequest request, @RequestParam(name = "response") HttpServletResponse response) throws Exception;

    /**
     * 分页查询商业保险
     */
    @RequestMapping(PersonBusiInsureServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<PersonBusiInsure>> queryPagedList(@RequestParam(name = "sample") PersonBusiInsureVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.PersonBusiInsureController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static PersonBusiInsureServiceProxy api() {
        return APIProxy.get(PersonBusiInsureServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
