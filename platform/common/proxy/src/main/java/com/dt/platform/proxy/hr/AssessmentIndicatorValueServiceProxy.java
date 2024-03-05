package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.AssessmentIndicatorValue;
import com.dt.platform.domain.hr.AssessmentIndicatorValueVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 考核结果 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-28 10:43:18
 */
@FeignClient(value = ServiceNames.HR, contextId = AssessmentIndicatorValueServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssessmentIndicatorValueServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-assessment-indicator-value
     */
    public static final String API_CONTEXT_PATH = "hr-assessment-indicator-value";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加考核结果
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除考核结果
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除考核结果
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新考核结果
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存考核结果
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个考核结果
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个考核结果
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询考核结果
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询考核结果
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加考核结果
     */
    @RequestMapping(AssessmentIndicatorValueServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assessmentIndicatorValueVO") AssessmentIndicatorValueVO assessmentIndicatorValueVO);

    /**
     * 删除考核结果
     */
    @RequestMapping(AssessmentIndicatorValueServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除考核结果
     */
    @RequestMapping(AssessmentIndicatorValueServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新考核结果
     */
    @RequestMapping(AssessmentIndicatorValueServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assessmentIndicatorValueVO") AssessmentIndicatorValueVO assessmentIndicatorValueVO);

    /**
     * 更新考核结果
     */
    @RequestMapping(AssessmentIndicatorValueServiceProxy.SAVE)
    Result save(@RequestParam(name = "assessmentIndicatorValueVO") AssessmentIndicatorValueVO assessmentIndicatorValueVO);

    /**
     * 获取考核结果
     */
    @RequestMapping(AssessmentIndicatorValueServiceProxy.GET_BY_ID)
    Result<AssessmentIndicatorValue> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个考核结果
     */
    @RequestMapping(AssessmentIndicatorValueServiceProxy.GET_BY_IDS)
    Result<List<AssessmentIndicatorValue>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询考核结果
     */
    @RequestMapping(AssessmentIndicatorValueServiceProxy.QUERY_LIST)
    Result<List<AssessmentIndicatorValue>> queryList(@RequestParam(name = "sample") AssessmentIndicatorValueVO sample);

    /**
     * 分页查询考核结果
     */
    @RequestMapping(AssessmentIndicatorValueServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssessmentIndicatorValue>> queryPagedList(@RequestParam(name = "sample") AssessmentIndicatorValueVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.AssessmentIndicatorValueController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssessmentIndicatorValueServiceProxy api() {
        return APIProxy.get(AssessmentIndicatorValueServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
