package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.ScoreTaskOrg;
import com.dt.platform.domain.hr.ScoreTaskOrgVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 任务部门 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-14 17:20:59
 */
@FeignClient(value = ServiceNames.HR, contextId = ScoreTaskOrgServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ScoreTaskOrgServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-score-task-org
     */
    public static final String API_CONTEXT_PATH = "hr-score-task-org";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加任务部门
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除任务部门
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除任务部门
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新任务部门
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存任务部门
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个任务部门
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个任务部门
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询任务部门
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询任务部门
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加任务部门
     */
    @RequestMapping(ScoreTaskOrgServiceProxy.INSERT)
    Result insert(@RequestParam(name = "scoreTaskOrgVO") ScoreTaskOrgVO scoreTaskOrgVO);

    /**
     * 删除任务部门
     */
    @RequestMapping(ScoreTaskOrgServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除任务部门
     */
    @RequestMapping(ScoreTaskOrgServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新任务部门
     */
    @RequestMapping(ScoreTaskOrgServiceProxy.UPDATE)
    Result update(@RequestParam(name = "scoreTaskOrgVO") ScoreTaskOrgVO scoreTaskOrgVO);

    /**
     * 更新任务部门
     */
    @RequestMapping(ScoreTaskOrgServiceProxy.SAVE)
    Result save(@RequestParam(name = "scoreTaskOrgVO") ScoreTaskOrgVO scoreTaskOrgVO);

    /**
     * 获取任务部门
     */
    @RequestMapping(ScoreTaskOrgServiceProxy.GET_BY_ID)
    Result<ScoreTaskOrg> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个任务部门
     */
    @RequestMapping(ScoreTaskOrgServiceProxy.GET_BY_IDS)
    Result<List<ScoreTaskOrg>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询任务部门
     */
    @RequestMapping(ScoreTaskOrgServiceProxy.QUERY_LIST)
    Result<List<ScoreTaskOrg>> queryList(@RequestParam(name = "sample") ScoreTaskOrgVO sample);

    /**
     * 分页查询任务部门
     */
    @RequestMapping(ScoreTaskOrgServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ScoreTaskOrg>> queryPagedList(@RequestParam(name = "sample") ScoreTaskOrgVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.ScoreTaskOrgController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ScoreTaskOrgServiceProxy api() {
        return APIProxy.get(ScoreTaskOrgServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
