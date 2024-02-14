package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.ScoreTaskDtl;
import com.dt.platform.domain.hr.ScoreTaskDtlVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 任务单明细 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-12 00:04:02
 */
@FeignClient(value = ServiceNames.HR, contextId = ScoreTaskDtlServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ScoreTaskDtlServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-score-task-dtl
     */
    public static final String API_CONTEXT_PATH = "hr-score-task-dtl";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加任务单明细
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除任务单明细
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除任务单明细
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新任务单明细
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存任务单明细
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个任务单明细
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个任务单明细
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询任务单明细
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询任务单明细
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加任务单明细
     */
    @RequestMapping(ScoreTaskDtlServiceProxy.INSERT)
    Result insert(@RequestParam(name = "scoreTaskDtlVO") ScoreTaskDtlVO scoreTaskDtlVO);

    /**
     * 删除任务单明细
     */
    @RequestMapping(ScoreTaskDtlServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除任务单明细
     */
    @RequestMapping(ScoreTaskDtlServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新任务单明细
     */
    @RequestMapping(ScoreTaskDtlServiceProxy.UPDATE)
    Result update(@RequestParam(name = "scoreTaskDtlVO") ScoreTaskDtlVO scoreTaskDtlVO);

    /**
     * 更新任务单明细
     */
    @RequestMapping(ScoreTaskDtlServiceProxy.SAVE)
    Result save(@RequestParam(name = "scoreTaskDtlVO") ScoreTaskDtlVO scoreTaskDtlVO);

    /**
     * 获取任务单明细
     */
    @RequestMapping(ScoreTaskDtlServiceProxy.GET_BY_ID)
    Result<ScoreTaskDtl> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个任务单明细
     */
    @RequestMapping(ScoreTaskDtlServiceProxy.GET_BY_IDS)
    Result<List<ScoreTaskDtl>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询任务单明细
     */
    @RequestMapping(ScoreTaskDtlServiceProxy.QUERY_LIST)
    Result<List<ScoreTaskDtl>> queryList(@RequestParam(name = "sample") ScoreTaskDtlVO sample);

    /**
     * 分页查询任务单明细
     */
    @RequestMapping(ScoreTaskDtlServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ScoreTaskDtl>> queryPagedList(@RequestParam(name = "sample") ScoreTaskDtlVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.ScoreTaskDtlController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ScoreTaskDtlServiceProxy api() {
        return APIProxy.get(ScoreTaskDtlServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
