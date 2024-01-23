package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.SalaryColumn;
import com.dt.platform.domain.hr.SalaryColumnVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 薪酬字段 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-22 14:09:26
 */
@FeignClient(value = ServiceNames.HR, contextId = SalaryColumnServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface SalaryColumnServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-salary-column
     */
    public static final String API_CONTEXT_PATH = "hr-salary-column";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加薪酬字段
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除薪酬字段
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除薪酬字段
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新薪酬字段
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存薪酬字段
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个薪酬字段
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个薪酬字段
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询薪酬字段
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询薪酬字段
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加薪酬字段
     */
    @RequestMapping(SalaryColumnServiceProxy.INSERT)
    Result insert(@RequestParam(name = "salaryColumnVO") SalaryColumnVO salaryColumnVO);

    /**
     * 删除薪酬字段
     */
    @RequestMapping(SalaryColumnServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除薪酬字段
     */
    @RequestMapping(SalaryColumnServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新薪酬字段
     */
    @RequestMapping(SalaryColumnServiceProxy.UPDATE)
    Result update(@RequestParam(name = "salaryColumnVO") SalaryColumnVO salaryColumnVO);

    /**
     * 更新薪酬字段
     */
    @RequestMapping(SalaryColumnServiceProxy.SAVE)
    Result save(@RequestParam(name = "salaryColumnVO") SalaryColumnVO salaryColumnVO);

    /**
     * 获取薪酬字段
     */
    @RequestMapping(SalaryColumnServiceProxy.GET_BY_ID)
    Result<SalaryColumn> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个薪酬字段
     */
    @RequestMapping(SalaryColumnServiceProxy.GET_BY_IDS)
    Result<List<SalaryColumn>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询薪酬字段
     */
    @RequestMapping(SalaryColumnServiceProxy.QUERY_LIST)
    Result<List<SalaryColumn>> queryList(@RequestParam(name = "sample") SalaryColumnVO sample);

    /**
     * 分页查询薪酬字段
     */
    @RequestMapping(SalaryColumnServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<SalaryColumn>> queryPagedList(@RequestParam(name = "sample") SalaryColumnVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.SalaryColumnController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static SalaryColumnServiceProxy api() {
        return APIProxy.get(SalaryColumnServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
