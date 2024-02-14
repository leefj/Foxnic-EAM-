package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.ScoreTplItem;
import com.dt.platform.domain.hr.ScoreTplItemVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 评分项目 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-13 12:57:42
 */
@FeignClient(value = ServiceNames.HR, contextId = ScoreTplItemServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ScoreTplItemServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-score-tpl-item
     */
    public static final String API_CONTEXT_PATH = "hr-score-tpl-item";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加评分项目
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除评分项目
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除评分项目
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新评分项目
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存评分项目
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个评分项目
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个评分项目
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询评分项目
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询评分项目
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加评分项目
     */
    @RequestMapping(ScoreTplItemServiceProxy.INSERT)
    Result insert(@RequestParam(name = "scoreTplItemVO") ScoreTplItemVO scoreTplItemVO);

    /**
     * 删除评分项目
     */
    @RequestMapping(ScoreTplItemServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除评分项目
     */
    @RequestMapping(ScoreTplItemServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新评分项目
     */
    @RequestMapping(ScoreTplItemServiceProxy.UPDATE)
    Result update(@RequestParam(name = "scoreTplItemVO") ScoreTplItemVO scoreTplItemVO);

    /**
     * 更新评分项目
     */
    @RequestMapping(ScoreTplItemServiceProxy.SAVE)
    Result save(@RequestParam(name = "scoreTplItemVO") ScoreTplItemVO scoreTplItemVO);

    /**
     * 获取评分项目
     */
    @RequestMapping(ScoreTplItemServiceProxy.GET_BY_ID)
    Result<ScoreTplItem> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个评分项目
     */
    @RequestMapping(ScoreTplItemServiceProxy.GET_BY_IDS)
    Result<List<ScoreTplItem>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询评分项目
     */
    @RequestMapping(ScoreTplItemServiceProxy.QUERY_LIST)
    Result<List<ScoreTplItem>> queryList(@RequestParam(name = "sample") ScoreTplItemVO sample);

    /**
     * 分页查询评分项目
     */
    @RequestMapping(ScoreTplItemServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ScoreTplItem>> queryPagedList(@RequestParam(name = "sample") ScoreTplItemVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.ScoreTplItemController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ScoreTplItemServiceProxy api() {
        return APIProxy.get(ScoreTplItemServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
