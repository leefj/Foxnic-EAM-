package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.SalaryTplItem;
import com.dt.platform.domain.hr.SalaryTplItemVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 计算项目 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-26 15:47:24
 */
@FeignClient(value = ServiceNames.HR, contextId = SalaryTplItemServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface SalaryTplItemServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-salary-tpl-item
     */
    public static final String API_CONTEXT_PATH = "hr-salary-tpl-item";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加计算项目
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除计算项目
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除计算项目
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新计算项目
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存计算项目
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个计算项目
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个计算项目
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询计算项目
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询计算项目
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加计算项目
     */
    @RequestMapping(SalaryTplItemServiceProxy.INSERT)
    Result insert(@RequestParam(name = "salaryTplItemVO") SalaryTplItemVO salaryTplItemVO);

    /**
     * 删除计算项目
     */
    @RequestMapping(SalaryTplItemServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除计算项目
     */
    @RequestMapping(SalaryTplItemServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新计算项目
     */
    @RequestMapping(SalaryTplItemServiceProxy.UPDATE)
    Result update(@RequestParam(name = "salaryTplItemVO") SalaryTplItemVO salaryTplItemVO);

    /**
     * 更新计算项目
     */
    @RequestMapping(SalaryTplItemServiceProxy.SAVE)
    Result save(@RequestParam(name = "salaryTplItemVO") SalaryTplItemVO salaryTplItemVO);

    /**
     * 获取计算项目
     */
    @RequestMapping(SalaryTplItemServiceProxy.GET_BY_ID)
    Result<SalaryTplItem> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个计算项目
     */
    @RequestMapping(SalaryTplItemServiceProxy.GET_BY_IDS)
    Result<List<SalaryTplItem>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询计算项目
     */
    @RequestMapping(SalaryTplItemServiceProxy.QUERY_LIST)
    Result<List<SalaryTplItem>> queryList(@RequestParam(name = "sample") SalaryTplItemVO sample);

    /**
     * 分页查询计算项目
     */
    @RequestMapping(SalaryTplItemServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<SalaryTplItem>> queryPagedList(@RequestParam(name = "sample") SalaryTplItemVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.SalaryTplItemController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static SalaryTplItemServiceProxy api() {
        return APIProxy.get(SalaryTplItemServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
