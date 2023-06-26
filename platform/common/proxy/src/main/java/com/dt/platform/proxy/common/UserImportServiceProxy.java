package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.UserImport;
import com.dt.platform.domain.common.UserImportVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 员工导入 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-18 14:16:24
 */
@FeignClient(value = ServiceNames.COMMON, contextId = UserImportServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface UserImportServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-user-import
     */
    public static final String API_CONTEXT_PATH = "sys-user-import";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加员工导入
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除员工导入
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除员工导入
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新员工导入
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存员工导入
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个员工导入
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个员工导入
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询员工导入
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询员工导入
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 分页查询员工导入
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 分页查询员工导入
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 导入
     */
    public static final String IMPORT_EMPLOYEE_BY_ID = API_PREFIX + "import-employee-by-id";



    /**
     * 添加员工导入
     */
    @RequestMapping(UserImportServiceProxy.INSERT)
    Result insert(@RequestParam(name = "userImportVO") UserImportVO userImportVO);

    /**
     * 删除员工导入
     */
    @RequestMapping(UserImportServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除员工导入
     */
    @RequestMapping(UserImportServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新员工导入
     */
    @RequestMapping(UserImportServiceProxy.UPDATE)
    Result update(@RequestParam(name = "userImportVO") UserImportVO userImportVO);

    /**
     * 更新员工导入
     */
    @RequestMapping(UserImportServiceProxy.SAVE)
    Result save(@RequestParam(name = "userImportVO") UserImportVO userImportVO);

    /**
     * 获取员工导入
     */
    @RequestMapping(UserImportServiceProxy.GET_BY_ID)
    Result<UserImport> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个员工导入
     */
    @RequestMapping(UserImportServiceProxy.GET_BY_IDS)
    Result<List<UserImport>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询员工导入
     */
    @RequestMapping(UserImportServiceProxy.QUERY_LIST)
    Result<List<UserImport>> queryList(@RequestParam(name = "sample") UserImportVO sample);

    /**
     * 分页查询员工导入
     */
    @RequestMapping(UserImportServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<UserImport>> queryPagedList(@RequestParam(name = "sample") UserImportVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.UserImportController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static UserImportServiceProxy api() {
        return APIProxy.get(UserImportServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
