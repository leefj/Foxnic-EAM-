package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.ScoreIndicator;
import com.dt.platform.domain.hr.ScoreIndicatorVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 评价指标 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-12 18:44:27
 */
@FeignClient(value = ServiceNames.HR, contextId = ScoreIndicatorServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ScoreIndicatorServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-score-indicator
     */
    public static final String API_CONTEXT_PATH = "hr-score-indicator";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加评价指标
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除评价指标
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除评价指标
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新评价指标
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存评价指标
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个评价指标
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个评价指标
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询评价指标
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询评价指标
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加评价指标
     */
    @RequestMapping(ScoreIndicatorServiceProxy.INSERT)
    Result insert(@RequestParam(name = "scoreIndicatorVO") ScoreIndicatorVO scoreIndicatorVO);

    /**
     * 删除评价指标
     */
    @RequestMapping(ScoreIndicatorServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除评价指标
     */
    @RequestMapping(ScoreIndicatorServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新评价指标
     */
    @RequestMapping(ScoreIndicatorServiceProxy.UPDATE)
    Result update(@RequestParam(name = "scoreIndicatorVO") ScoreIndicatorVO scoreIndicatorVO);

    /**
     * 更新评价指标
     */
    @RequestMapping(ScoreIndicatorServiceProxy.SAVE)
    Result save(@RequestParam(name = "scoreIndicatorVO") ScoreIndicatorVO scoreIndicatorVO);

    /**
     * 获取评价指标
     */
    @RequestMapping(ScoreIndicatorServiceProxy.GET_BY_ID)
    Result<ScoreIndicator> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个评价指标
     */
    @RequestMapping(ScoreIndicatorServiceProxy.GET_BY_IDS)
    Result<List<ScoreIndicator>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询评价指标
     */
    @RequestMapping(ScoreIndicatorServiceProxy.QUERY_LIST)
    Result<List<ScoreIndicator>> queryList(@RequestParam(name = "sample") ScoreIndicatorVO sample);

    /**
     * 分页查询评价指标
     */
    @RequestMapping(ScoreIndicatorServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ScoreIndicator>> queryPagedList(@RequestParam(name = "sample") ScoreIndicatorVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.ScoreIndicatorController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ScoreIndicatorServiceProxy api() {
        return APIProxy.get(ScoreIndicatorServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
