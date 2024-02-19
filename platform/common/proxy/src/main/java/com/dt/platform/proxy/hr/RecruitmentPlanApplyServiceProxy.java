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
import com.dt.platform.domain.hr.RecruitmentPlanApply;
import com.dt.platform.domain.hr.RecruitmentPlanApplyVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 招聘计划申请 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-19 15:58:49
 */
@FeignClient(value = ServiceNames.HR, contextId = RecruitmentPlanApplyServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface RecruitmentPlanApplyServiceProxy extends BpmCallbackController {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-recruitment-plan-apply
     */
    public static final String API_CONTEXT_PATH = "hr-recruitment-plan-apply";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加招聘计划申请
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除招聘计划申请
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除招聘计划申请
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新招聘计划申请
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存招聘计划申请
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个招聘计划申请
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个招聘计划申请
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询招聘计划申请
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询招聘计划申请
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 流程事件回调接收接口
     */
    public static final String BPM_CALLBACK = API_PREFIX + "bpm-callback";

    /**
     * 添加招聘计划申请
     */
    @RequestMapping(RecruitmentPlanApplyServiceProxy.INSERT)
    Result insert(@RequestParam(name = "recruitmentPlanApplyVO") RecruitmentPlanApplyVO recruitmentPlanApplyVO);

    /**
     * 删除招聘计划申请
     */
    @RequestMapping(RecruitmentPlanApplyServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除招聘计划申请
     */
    @RequestMapping(RecruitmentPlanApplyServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新招聘计划申请
     */
    @RequestMapping(RecruitmentPlanApplyServiceProxy.UPDATE)
    Result update(@RequestParam(name = "recruitmentPlanApplyVO") RecruitmentPlanApplyVO recruitmentPlanApplyVO);

    /**
     * 更新招聘计划申请
     */
    @RequestMapping(RecruitmentPlanApplyServiceProxy.SAVE)
    Result save(@RequestParam(name = "recruitmentPlanApplyVO") RecruitmentPlanApplyVO recruitmentPlanApplyVO);

    /**
     * 获取招聘计划申请
     */
    @RequestMapping(RecruitmentPlanApplyServiceProxy.GET_BY_ID)
    Result<RecruitmentPlanApply> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个招聘计划申请
     */
    @RequestMapping(RecruitmentPlanApplyServiceProxy.GET_BY_IDS)
    Result<List<RecruitmentPlanApply>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询招聘计划申请
     */
    @RequestMapping(RecruitmentPlanApplyServiceProxy.QUERY_LIST)
    Result<List<RecruitmentPlanApply>> queryList(@RequestParam(name = "sample") RecruitmentPlanApplyVO sample);

    /**
     * 分页查询招聘计划申请
     */
    @RequestMapping(RecruitmentPlanApplyServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<RecruitmentPlanApply>> queryPagedList(@RequestParam(name = "sample") RecruitmentPlanApplyVO sample);

    /**
     * 分页查询招聘计划申请
     */
    @RequestMapping(RecruitmentPlanApplyServiceProxy.BPM_CALLBACK)
    BpmActionResult onProcessCallback(@RequestParam(name = "event") BpmEvent event);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.RecruitmentPlanApplyController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static RecruitmentPlanApplyServiceProxy api() {
        return APIProxy.get(RecruitmentPlanApplyServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
