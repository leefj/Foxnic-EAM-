package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.github.foxnic.web.proxy.bpm.BpmCallbackController;
import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.AssessmentPlan;
import com.dt.platform.domain.hr.AssessmentPlanVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 考核计划 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-04 07:40:29
 */
@FeignClient(value = ServiceNames.HR, contextId = AssessmentPlanServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssessmentPlanServiceProxy extends BpmCallbackController {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-assessment-plan
     */
    public static final String API_CONTEXT_PATH = "hr-assessment-plan";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加考核计划
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除考核计划
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除考核计划
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新考核计划
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存考核计划
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个考核计划
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个考核计划
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询考核计划
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询考核计划
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 流程事件回调接收接口
     */
    public static final String BPM_CALLBACK = API_PREFIX + "bpm-callback";

    /**
     * 添加考核计划
     */
    @RequestMapping(AssessmentPlanServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assessmentPlanVO") AssessmentPlanVO assessmentPlanVO);

    /**
     * 删除考核计划
     */
    @RequestMapping(AssessmentPlanServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除考核计划
     */
    @RequestMapping(AssessmentPlanServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新考核计划
     */
    @RequestMapping(AssessmentPlanServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assessmentPlanVO") AssessmentPlanVO assessmentPlanVO);

    /**
     * 更新考核计划
     */
    @RequestMapping(AssessmentPlanServiceProxy.SAVE)
    Result save(@RequestParam(name = "assessmentPlanVO") AssessmentPlanVO assessmentPlanVO);

    /**
     * 获取考核计划
     */
    @RequestMapping(AssessmentPlanServiceProxy.GET_BY_ID)
    Result<AssessmentPlan> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个考核计划
     */
    @RequestMapping(AssessmentPlanServiceProxy.GET_BY_IDS)
    Result<List<AssessmentPlan>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询考核计划
     */
    @RequestMapping(AssessmentPlanServiceProxy.QUERY_LIST)
    Result<List<AssessmentPlan>> queryList(@RequestParam(name = "sample") AssessmentPlanVO sample);

    /**
     * 分页查询考核计划
     */
    @RequestMapping(AssessmentPlanServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssessmentPlan>> queryPagedList(@RequestParam(name = "sample") AssessmentPlanVO sample);

    /**
     * 分页查询考核计划
     */
    @RequestMapping(AssessmentPlanServiceProxy.BPM_CALLBACK)
    BpmActionResult onProcessCallback(@RequestParam(name = "event") BpmEvent event);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.AssessmentPlanController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssessmentPlanServiceProxy api() {
        return APIProxy.get(AssessmentPlanServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
