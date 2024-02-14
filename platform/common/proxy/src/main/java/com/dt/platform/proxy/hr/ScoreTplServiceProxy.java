package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.ScoreTpl;
import com.dt.platform.domain.hr.ScoreTplVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 评分模版 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-13 08:59:02
 */
@FeignClient(value = ServiceNames.HR, contextId = ScoreTplServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ScoreTplServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-score-tpl
     */
    public static final String API_CONTEXT_PATH = "hr-score-tpl";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加评分模版
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除评分模版
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除评分模版
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新评分模版
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存评分模版
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个评分模版
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个评分模版
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询评分模版
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询评分模版
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加评分模版
     */
    @RequestMapping(ScoreTplServiceProxy.INSERT)
    Result insert(@RequestParam(name = "scoreTplVO") ScoreTplVO scoreTplVO);

    /**
     * 删除评分模版
     */
    @RequestMapping(ScoreTplServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除评分模版
     */
    @RequestMapping(ScoreTplServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新评分模版
     */
    @RequestMapping(ScoreTplServiceProxy.UPDATE)
    Result update(@RequestParam(name = "scoreTplVO") ScoreTplVO scoreTplVO);

    /**
     * 更新评分模版
     */
    @RequestMapping(ScoreTplServiceProxy.SAVE)
    Result save(@RequestParam(name = "scoreTplVO") ScoreTplVO scoreTplVO);

    /**
     * 获取评分模版
     */
    @RequestMapping(ScoreTplServiceProxy.GET_BY_ID)
    Result<ScoreTpl> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个评分模版
     */
    @RequestMapping(ScoreTplServiceProxy.GET_BY_IDS)
    Result<List<ScoreTpl>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询评分模版
     */
    @RequestMapping(ScoreTplServiceProxy.QUERY_LIST)
    Result<List<ScoreTpl>> queryList(@RequestParam(name = "sample") ScoreTplVO sample);

    /**
     * 分页查询评分模版
     */
    @RequestMapping(ScoreTplServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ScoreTpl>> queryPagedList(@RequestParam(name = "sample") ScoreTplVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.ScoreTplController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ScoreTplServiceProxy api() {
        return APIProxy.get(ScoreTplServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
