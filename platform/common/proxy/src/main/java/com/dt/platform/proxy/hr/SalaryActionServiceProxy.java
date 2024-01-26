package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.SalaryAction;
import com.dt.platform.domain.hr.SalaryActionVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 薪酬发放 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-04 15:19:31
 */
@FeignClient(value = ServiceNames.HR, contextId = SalaryActionServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface SalaryActionServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-salary-action
     */
    public static final String API_CONTEXT_PATH = "hr-salary-action";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加薪酬发放
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除薪酬发放
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除薪酬发放
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新薪酬发放
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存薪酬发放
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个薪酬发放
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个薪酬发放
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询薪酬发放
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询薪酬发放
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";


    /**
     * 分页查询薪酬发放
     */
    public static final String CREATE_DATA = API_PREFIX + "create-data";


    public static final String CALCULATE = API_PREFIX + "calculate";

    /**
     * 添加薪酬发放
     */
    @RequestMapping(SalaryActionServiceProxy.INSERT)
    Result insert(@RequestParam(name = "salaryActionVO") SalaryActionVO salaryActionVO);

    /**
     * 删除薪酬发放
     */
    @RequestMapping(SalaryActionServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除薪酬发放
     */
    @RequestMapping(SalaryActionServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新薪酬发放
     */
    @RequestMapping(SalaryActionServiceProxy.UPDATE)
    Result update(@RequestParam(name = "salaryActionVO") SalaryActionVO salaryActionVO);

    /**
     * 更新薪酬发放
     */
    @RequestMapping(SalaryActionServiceProxy.SAVE)
    Result save(@RequestParam(name = "salaryActionVO") SalaryActionVO salaryActionVO);

    /**
     * 获取薪酬发放
     */
    @RequestMapping(SalaryActionServiceProxy.GET_BY_ID)
    Result<SalaryAction> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个薪酬发放
     */
    @RequestMapping(SalaryActionServiceProxy.GET_BY_IDS)
    Result<List<SalaryAction>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询薪酬发放
     */
    @RequestMapping(SalaryActionServiceProxy.QUERY_LIST)
    Result<List<SalaryAction>> queryList(@RequestParam(name = "sample") SalaryActionVO sample);

    /**
     * 分页查询薪酬发放
     */
    @RequestMapping(SalaryActionServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<SalaryAction>> queryPagedList(@RequestParam(name = "sample") SalaryActionVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.SalaryActionController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static SalaryActionServiceProxy api() {
        return APIProxy.get(SalaryActionServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
