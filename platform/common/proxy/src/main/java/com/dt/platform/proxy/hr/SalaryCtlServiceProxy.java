package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.SalaryCtl;
import com.dt.platform.domain.hr.SalaryCtlVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 薪酬控制 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-05 10:15:34
 */
@FeignClient(value = ServiceNames.HR, contextId = SalaryCtlServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface SalaryCtlServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-salary-ctl
     */
    public static final String API_CONTEXT_PATH = "hr-salary-ctl";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加薪酬控制
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除薪酬控制
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除薪酬控制
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新薪酬控制
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存薪酬控制
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个薪酬控制
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个薪酬控制
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询薪酬控制
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询薪酬控制
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加薪酬控制
     */
    @RequestMapping(SalaryCtlServiceProxy.INSERT)
    Result insert(@RequestParam(name = "salaryCtlVO") SalaryCtlVO salaryCtlVO);

    /**
     * 删除薪酬控制
     */
    @RequestMapping(SalaryCtlServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除薪酬控制
     */
    @RequestMapping(SalaryCtlServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新薪酬控制
     */
    @RequestMapping(SalaryCtlServiceProxy.UPDATE)
    Result update(@RequestParam(name = "salaryCtlVO") SalaryCtlVO salaryCtlVO);

    /**
     * 更新薪酬控制
     */
    @RequestMapping(SalaryCtlServiceProxy.SAVE)
    Result save(@RequestParam(name = "salaryCtlVO") SalaryCtlVO salaryCtlVO);

    /**
     * 获取薪酬控制
     */
    @RequestMapping(SalaryCtlServiceProxy.GET_BY_ID)
    Result<SalaryCtl> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个薪酬控制
     */
    @RequestMapping(SalaryCtlServiceProxy.GET_BY_IDS)
    Result<List<SalaryCtl>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询薪酬控制
     */
    @RequestMapping(SalaryCtlServiceProxy.QUERY_LIST)
    Result<List<SalaryCtl>> queryList(@RequestParam(name = "sample") SalaryCtlVO sample);

    /**
     * 分页查询薪酬控制
     */
    @RequestMapping(SalaryCtlServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<SalaryCtl>> queryPagedList(@RequestParam(name = "sample") SalaryCtlVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.SalaryCtlController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static SalaryCtlServiceProxy api() {
        return APIProxy.get(SalaryCtlServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
