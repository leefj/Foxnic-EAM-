package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.ScoreTask;
import com.dt.platform.domain.hr.ScoreTaskVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 任务单 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-12 00:01:41
 */
@FeignClient(value = ServiceNames.HR, contextId = ScoreTaskServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ScoreTaskServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-score-task
     */
    public static final String API_CONTEXT_PATH = "hr-score-task";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加任务单
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除任务单
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除任务单
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新任务单
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存任务单
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个任务单
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个任务单
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询任务单
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询任务单
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加任务单
     */
    @RequestMapping(ScoreTaskServiceProxy.INSERT)
    Result insert(@RequestParam(name = "scoreTaskVO") ScoreTaskVO scoreTaskVO);

    /**
     * 删除任务单
     */
    @RequestMapping(ScoreTaskServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除任务单
     */
    @RequestMapping(ScoreTaskServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新任务单
     */
    @RequestMapping(ScoreTaskServiceProxy.UPDATE)
    Result update(@RequestParam(name = "scoreTaskVO") ScoreTaskVO scoreTaskVO);

    /**
     * 更新任务单
     */
    @RequestMapping(ScoreTaskServiceProxy.SAVE)
    Result save(@RequestParam(name = "scoreTaskVO") ScoreTaskVO scoreTaskVO);

    /**
     * 获取任务单
     */
    @RequestMapping(ScoreTaskServiceProxy.GET_BY_ID)
    Result<ScoreTask> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个任务单
     */
    @RequestMapping(ScoreTaskServiceProxy.GET_BY_IDS)
    Result<List<ScoreTask>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询任务单
     */
    @RequestMapping(ScoreTaskServiceProxy.QUERY_LIST)
    Result<List<ScoreTask>> queryList(@RequestParam(name = "sample") ScoreTaskVO sample);

    /**
     * 分页查询任务单
     */
    @RequestMapping(ScoreTaskServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ScoreTask>> queryPagedList(@RequestParam(name = "sample") ScoreTaskVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.ScoreTaskController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ScoreTaskServiceProxy api() {
        return APIProxy.get(ScoreTaskServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
