package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.SalaryTaxPct;
import com.dt.platform.domain.hr.SalaryTaxPctVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 薪酬税率 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-04 15:41:55
 */
@FeignClient(value = ServiceNames.HR, contextId = SalaryTaxPctServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface SalaryTaxPctServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-salary-tax-pct
     */
    public static final String API_CONTEXT_PATH = "hr-salary-tax-pct";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加薪酬税率
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除薪酬税率
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除薪酬税率
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新薪酬税率
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存薪酬税率
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个薪酬税率
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个薪酬税率
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询薪酬税率
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询薪酬税率
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加薪酬税率
     */
    @RequestMapping(SalaryTaxPctServiceProxy.INSERT)
    Result insert(@RequestParam(name = "salaryTaxPctVO") SalaryTaxPctVO salaryTaxPctVO);

    /**
     * 删除薪酬税率
     */
    @RequestMapping(SalaryTaxPctServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除薪酬税率
     */
    @RequestMapping(SalaryTaxPctServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新薪酬税率
     */
    @RequestMapping(SalaryTaxPctServiceProxy.UPDATE)
    Result update(@RequestParam(name = "salaryTaxPctVO") SalaryTaxPctVO salaryTaxPctVO);

    /**
     * 更新薪酬税率
     */
    @RequestMapping(SalaryTaxPctServiceProxy.SAVE)
    Result save(@RequestParam(name = "salaryTaxPctVO") SalaryTaxPctVO salaryTaxPctVO);

    /**
     * 获取薪酬税率
     */
    @RequestMapping(SalaryTaxPctServiceProxy.GET_BY_ID)
    Result<SalaryTaxPct> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个薪酬税率
     */
    @RequestMapping(SalaryTaxPctServiceProxy.GET_BY_IDS)
    Result<List<SalaryTaxPct>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询薪酬税率
     */
    @RequestMapping(SalaryTaxPctServiceProxy.QUERY_LIST)
    Result<List<SalaryTaxPct>> queryList(@RequestParam(name = "sample") SalaryTaxPctVO sample);

    /**
     * 分页查询薪酬税率
     */
    @RequestMapping(SalaryTaxPctServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<SalaryTaxPct>> queryPagedList(@RequestParam(name = "sample") SalaryTaxPctVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.SalaryTaxPctController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static SalaryTaxPctServiceProxy api() {
        return APIProxy.get(SalaryTaxPctServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
