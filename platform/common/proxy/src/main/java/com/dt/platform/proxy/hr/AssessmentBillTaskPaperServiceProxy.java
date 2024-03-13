package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.AssessmentBillTaskPaper;
import com.dt.platform.domain.hr.AssessmentBillTaskPaperVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 考核试卷 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-12 17:23:38
 */
@FeignClient(value = ServiceNames.HR, contextId = AssessmentBillTaskPaperServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssessmentBillTaskPaperServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-assessment-bill-task-paper
     */
    public static final String API_CONTEXT_PATH = "hr-assessment-bill-task-paper";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加考核试卷
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除考核试卷
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除考核试卷
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新考核试卷
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存考核试卷
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个考核试卷
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个考核试卷
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询考核试卷
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询考核试卷
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加考核试卷
     */
    @RequestMapping(AssessmentBillTaskPaperServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assessmentBillTaskPaperVO") AssessmentBillTaskPaperVO assessmentBillTaskPaperVO);

    /**
     * 删除考核试卷
     */
    @RequestMapping(AssessmentBillTaskPaperServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除考核试卷
     */
    @RequestMapping(AssessmentBillTaskPaperServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新考核试卷
     */
    @RequestMapping(AssessmentBillTaskPaperServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assessmentBillTaskPaperVO") AssessmentBillTaskPaperVO assessmentBillTaskPaperVO);

    /**
     * 更新考核试卷
     */
    @RequestMapping(AssessmentBillTaskPaperServiceProxy.SAVE)
    Result save(@RequestParam(name = "assessmentBillTaskPaperVO") AssessmentBillTaskPaperVO assessmentBillTaskPaperVO);

    /**
     * 获取考核试卷
     */
    @RequestMapping(AssessmentBillTaskPaperServiceProxy.GET_BY_ID)
    Result<AssessmentBillTaskPaper> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个考核试卷
     */
    @RequestMapping(AssessmentBillTaskPaperServiceProxy.GET_BY_IDS)
    Result<List<AssessmentBillTaskPaper>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询考核试卷
     */
    @RequestMapping(AssessmentBillTaskPaperServiceProxy.QUERY_LIST)
    Result<List<AssessmentBillTaskPaper>> queryList(@RequestParam(name = "sample") AssessmentBillTaskPaperVO sample);

    /**
     * 分页查询考核试卷
     */
    @RequestMapping(AssessmentBillTaskPaperServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssessmentBillTaskPaper>> queryPagedList(@RequestParam(name = "sample") AssessmentBillTaskPaperVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.AssessmentBillTaskPaperController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssessmentBillTaskPaperServiceProxy api() {
        return APIProxy.get(AssessmentBillTaskPaperServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
