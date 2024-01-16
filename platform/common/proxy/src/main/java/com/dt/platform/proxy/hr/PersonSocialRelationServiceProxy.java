package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.PersonSocialRelation;
import com.dt.platform.domain.hr.PersonSocialRelationVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 社会关系 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-14 16:05:43
 */
@FeignClient(value = ServiceNames.HR, contextId = PersonSocialRelationServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PersonSocialRelationServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-person-social-relation
     */
    public static final String API_CONTEXT_PATH = "hr-person-social-relation";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加社会关系
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除社会关系
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除社会关系
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新社会关系
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存社会关系
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个社会关系
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个社会关系
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询社会关系
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询社会关系
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 分页查询社会关系
     */
    public static final String QUERY_DATA_PAGED_LIST = API_PREFIX + "query-data-paged-list";

    public static final String APPROVE = API_PREFIX + "approve";

    public static final String DIRECT_UPDATE = API_PREFIX + "direct-update";

    public static final String DIRECT_INSERT = API_PREFIX + "direct-insert";
    /**
     * 添加社会关系
     */
    @RequestMapping(PersonSocialRelationServiceProxy.INSERT)
    Result insert(@RequestParam(name = "personSocialRelationVO") PersonSocialRelationVO personSocialRelationVO);

    /**
     * 删除社会关系
     */
    @RequestMapping(PersonSocialRelationServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除社会关系
     */
    @RequestMapping(PersonSocialRelationServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新社会关系
     */
    @RequestMapping(PersonSocialRelationServiceProxy.UPDATE)
    Result update(@RequestParam(name = "personSocialRelationVO") PersonSocialRelationVO personSocialRelationVO);

    /**
     * 更新社会关系
     */
    @RequestMapping(PersonSocialRelationServiceProxy.SAVE)
    Result save(@RequestParam(name = "personSocialRelationVO") PersonSocialRelationVO personSocialRelationVO);

    /**
     * 获取社会关系
     */
    @RequestMapping(PersonSocialRelationServiceProxy.GET_BY_ID)
    Result<PersonSocialRelation> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个社会关系
     */
    @RequestMapping(PersonSocialRelationServiceProxy.GET_BY_IDS)
    Result<List<PersonSocialRelation>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询社会关系
     */
    @RequestMapping(PersonSocialRelationServiceProxy.QUERY_LIST)
    Result<List<PersonSocialRelation>> queryList(@RequestParam(name = "sample") PersonSocialRelationVO sample);

    /**
     * 分页查询社会关系
     */
    @RequestMapping(PersonSocialRelationServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<PersonSocialRelation>> queryPagedList(@RequestParam(name = "sample") PersonSocialRelationVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.PersonSocialRelationController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static PersonSocialRelationServiceProxy api() {
        return APIProxy.get(PersonSocialRelationServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
