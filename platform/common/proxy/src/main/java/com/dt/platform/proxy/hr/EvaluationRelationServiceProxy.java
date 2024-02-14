package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.EvaluationRelation;
import com.dt.platform.domain.hr.EvaluationRelationVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 评价关系 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-12 18:46:23
 */
@FeignClient(value = ServiceNames.HR, contextId = EvaluationRelationServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface EvaluationRelationServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-evaluation-relation
     */
    public static final String API_CONTEXT_PATH = "hr-evaluation-relation";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加评价关系
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除评价关系
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除评价关系
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新评价关系
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存评价关系
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个评价关系
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个评价关系
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询评价关系
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询评价关系
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加评价关系
     */
    @RequestMapping(EvaluationRelationServiceProxy.INSERT)
    Result insert(@RequestParam(name = "evaluationRelationVO") EvaluationRelationVO evaluationRelationVO);

    /**
     * 删除评价关系
     */
    @RequestMapping(EvaluationRelationServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除评价关系
     */
    @RequestMapping(EvaluationRelationServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新评价关系
     */
    @RequestMapping(EvaluationRelationServiceProxy.UPDATE)
    Result update(@RequestParam(name = "evaluationRelationVO") EvaluationRelationVO evaluationRelationVO);

    /**
     * 更新评价关系
     */
    @RequestMapping(EvaluationRelationServiceProxy.SAVE)
    Result save(@RequestParam(name = "evaluationRelationVO") EvaluationRelationVO evaluationRelationVO);

    /**
     * 获取评价关系
     */
    @RequestMapping(EvaluationRelationServiceProxy.GET_BY_ID)
    Result<EvaluationRelation> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个评价关系
     */
    @RequestMapping(EvaluationRelationServiceProxy.GET_BY_IDS)
    Result<List<EvaluationRelation>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询评价关系
     */
    @RequestMapping(EvaluationRelationServiceProxy.QUERY_LIST)
    Result<List<EvaluationRelation>> queryList(@RequestParam(name = "sample") EvaluationRelationVO sample);

    /**
     * 分页查询评价关系
     */
    @RequestMapping(EvaluationRelationServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<EvaluationRelation>> queryPagedList(@RequestParam(name = "sample") EvaluationRelationVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.EvaluationRelationController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static EvaluationRelationServiceProxy api() {
        return APIProxy.get(EvaluationRelationServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
