package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.ScoreUser;
import com.dt.platform.domain.hr.ScoreUserVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 考评用户 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-14 17:36:10
 */
@FeignClient(value = ServiceNames.HR, contextId = ScoreUserServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ScoreUserServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-score-user
     */
    public static final String API_CONTEXT_PATH = "hr-score-user";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加考评用户
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除考评用户
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除考评用户
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新考评用户
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存考评用户
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个考评用户
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个考评用户
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询考评用户
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询考评用户
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加考评用户
     */
    @RequestMapping(ScoreUserServiceProxy.INSERT)
    Result insert(@RequestParam(name = "scoreUserVO") ScoreUserVO scoreUserVO);

    /**
     * 删除考评用户
     */
    @RequestMapping(ScoreUserServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除考评用户
     */
    @RequestMapping(ScoreUserServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新考评用户
     */
    @RequestMapping(ScoreUserServiceProxy.UPDATE)
    Result update(@RequestParam(name = "scoreUserVO") ScoreUserVO scoreUserVO);

    /**
     * 更新考评用户
     */
    @RequestMapping(ScoreUserServiceProxy.SAVE)
    Result save(@RequestParam(name = "scoreUserVO") ScoreUserVO scoreUserVO);

    /**
     * 获取考评用户
     */
    @RequestMapping(ScoreUserServiceProxy.GET_BY_ID)
    Result<ScoreUser> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个考评用户
     */
    @RequestMapping(ScoreUserServiceProxy.GET_BY_IDS)
    Result<List<ScoreUser>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询考评用户
     */
    @RequestMapping(ScoreUserServiceProxy.QUERY_LIST)
    Result<List<ScoreUser>> queryList(@RequestParam(name = "sample") ScoreUserVO sample);

    /**
     * 分页查询考评用户
     */
    @RequestMapping(ScoreUserServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ScoreUser>> queryPagedList(@RequestParam(name = "sample") ScoreUserVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.ScoreUserController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ScoreUserServiceProxy api() {
        return APIProxy.get(ScoreUserServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
