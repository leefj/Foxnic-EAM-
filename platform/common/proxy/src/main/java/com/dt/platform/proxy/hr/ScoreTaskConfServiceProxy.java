package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.ScoreTaskConf;
import com.dt.platform.domain.hr.ScoreTaskConfVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 任务配置 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-14 17:34:02
 */
@FeignClient(value = ServiceNames.HR, contextId = ScoreTaskConfServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ScoreTaskConfServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-score-task-conf
     */
    public static final String API_CONTEXT_PATH = "hr-score-task-conf";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加任务配置
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除任务配置
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除任务配置
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新任务配置
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存任务配置
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个任务配置
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个任务配置
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询任务配置
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询任务配置
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加任务配置
     */
    @RequestMapping(ScoreTaskConfServiceProxy.INSERT)
    Result insert(@RequestParam(name = "scoreTaskConfVO") ScoreTaskConfVO scoreTaskConfVO);

    /**
     * 删除任务配置
     */
    @RequestMapping(ScoreTaskConfServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除任务配置
     */
    @RequestMapping(ScoreTaskConfServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新任务配置
     */
    @RequestMapping(ScoreTaskConfServiceProxy.UPDATE)
    Result update(@RequestParam(name = "scoreTaskConfVO") ScoreTaskConfVO scoreTaskConfVO);

    /**
     * 更新任务配置
     */
    @RequestMapping(ScoreTaskConfServiceProxy.SAVE)
    Result save(@RequestParam(name = "scoreTaskConfVO") ScoreTaskConfVO scoreTaskConfVO);

    /**
     * 获取任务配置
     */
    @RequestMapping(ScoreTaskConfServiceProxy.GET_BY_ID)
    Result<ScoreTaskConf> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个任务配置
     */
    @RequestMapping(ScoreTaskConfServiceProxy.GET_BY_IDS)
    Result<List<ScoreTaskConf>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询任务配置
     */
    @RequestMapping(ScoreTaskConfServiceProxy.QUERY_LIST)
    Result<List<ScoreTaskConf>> queryList(@RequestParam(name = "sample") ScoreTaskConfVO sample);

    /**
     * 分页查询任务配置
     */
    @RequestMapping(ScoreTaskConfServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ScoreTaskConf>> queryPagedList(@RequestParam(name = "sample") ScoreTaskConfVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.ScoreTaskConfController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ScoreTaskConfServiceProxy api() {
        return APIProxy.get(ScoreTaskConfServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
