package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.AssessmentBillTask;
import com.dt.platform.domain.hr.AssessmentBillTaskVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 单据任务 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-11 15:13:19
 */
@FeignClient(value = ServiceNames.HR, contextId = AssessmentBillTaskServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssessmentBillTaskServiceProxy {




    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-assessment-bill-task
     */
    public static final String API_CONTEXT_PATH = "hr-assessment-bill-task";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加单据任务
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除单据任务
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除单据任务
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新单据任务
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存单据任务
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个单据任务
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个单据任务
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询单据任务
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询单据任务
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    public static final String SUBMIT = API_PREFIX + "submit";

    /**
     * 添加单据任务
     */
    @RequestMapping(AssessmentBillTaskServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assessmentBillTaskVO") AssessmentBillTaskVO assessmentBillTaskVO);

    /**
     * 删除单据任务
     */
    @RequestMapping(AssessmentBillTaskServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除单据任务
     */
    @RequestMapping(AssessmentBillTaskServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新单据任务
     */
    @RequestMapping(AssessmentBillTaskServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assessmentBillTaskVO") AssessmentBillTaskVO assessmentBillTaskVO);

    /**
     * 更新单据任务
     */
    @RequestMapping(AssessmentBillTaskServiceProxy.SAVE)
    Result save(@RequestParam(name = "assessmentBillTaskVO") AssessmentBillTaskVO assessmentBillTaskVO);

    /**
     * 获取单据任务
     */
    @RequestMapping(AssessmentBillTaskServiceProxy.GET_BY_ID)
    Result<AssessmentBillTask> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个单据任务
     */
    @RequestMapping(AssessmentBillTaskServiceProxy.GET_BY_IDS)
    Result<List<AssessmentBillTask>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询单据任务
     */
    @RequestMapping(AssessmentBillTaskServiceProxy.QUERY_LIST)
    Result<List<AssessmentBillTask>> queryList(@RequestParam(name = "sample") AssessmentBillTaskVO sample);

    /**
     * 分页查询单据任务
     */
    @RequestMapping(AssessmentBillTaskServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssessmentBillTask>> queryPagedList(@RequestParam(name = "sample") AssessmentBillTaskVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.AssessmentBillTaskController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssessmentBillTaskServiceProxy api() {
        return APIProxy.get(AssessmentBillTaskServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
