package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.AssessmentTpl;
import com.dt.platform.domain.hr.AssessmentTplVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 考核模版 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-29 15:23:34
 */
@FeignClient(value = ServiceNames.HR, contextId = AssessmentTplServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssessmentTplServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-assessment-tpl
     */
    public static final String API_CONTEXT_PATH = "hr-assessment-tpl";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加考核模版
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除考核模版
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除考核模版
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新考核模版
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存考核模版
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个考核模版
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个考核模版
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询考核模版
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询考核模版
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加考核模版
     */
    @RequestMapping(AssessmentTplServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assessmentTplVO") AssessmentTplVO assessmentTplVO);

    /**
     * 删除考核模版
     */
    @RequestMapping(AssessmentTplServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除考核模版
     */
    @RequestMapping(AssessmentTplServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新考核模版
     */
    @RequestMapping(AssessmentTplServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assessmentTplVO") AssessmentTplVO assessmentTplVO);

    /**
     * 更新考核模版
     */
    @RequestMapping(AssessmentTplServiceProxy.SAVE)
    Result save(@RequestParam(name = "assessmentTplVO") AssessmentTplVO assessmentTplVO);

    /**
     * 获取考核模版
     */
    @RequestMapping(AssessmentTplServiceProxy.GET_BY_ID)
    Result<AssessmentTpl> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个考核模版
     */
    @RequestMapping(AssessmentTplServiceProxy.GET_BY_IDS)
    Result<List<AssessmentTpl>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询考核模版
     */
    @RequestMapping(AssessmentTplServiceProxy.QUERY_LIST)
    Result<List<AssessmentTpl>> queryList(@RequestParam(name = "sample") AssessmentTplVO sample);

    /**
     * 分页查询考核模版
     */
    @RequestMapping(AssessmentTplServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssessmentTpl>> queryPagedList(@RequestParam(name = "sample") AssessmentTplVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.AssessmentTplController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssessmentTplServiceProxy api() {
        return APIProxy.get(AssessmentTplServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
