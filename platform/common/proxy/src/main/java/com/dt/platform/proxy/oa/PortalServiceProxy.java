package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.Portal;
import com.dt.platform.domain.oa.PortalVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 门户 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-08 22:18:39
 */
@FeignClient(value = ServiceNames.OA, contextId = PortalServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PortalServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-portal
     */
    public static final String API_CONTEXT_PATH = "oa-portal";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加门户
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除门户
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除门户
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新门户
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存门户
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个门户
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个门户
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询门户
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询门户
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加门户
     */
    @RequestMapping(PortalServiceProxy.INSERT)
    Result insert(@RequestParam(name = "portalVO") PortalVO portalVO);

    /**
     * 删除门户
     */
    @RequestMapping(PortalServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除门户
     */
    @RequestMapping(PortalServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新门户
     */
    @RequestMapping(PortalServiceProxy.UPDATE)
    Result update(@RequestParam(name = "portalVO") PortalVO portalVO);

    /**
     * 更新门户
     */
    @RequestMapping(PortalServiceProxy.SAVE)
    Result save(@RequestParam(name = "portalVO") PortalVO portalVO);

    /**
     * 获取门户
     */
    @RequestMapping(PortalServiceProxy.GET_BY_ID)
    Result<Portal> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个门户
     */
    @RequestMapping(PortalServiceProxy.GET_BY_IDS)
    Result<List<Portal>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询门户
     */
    @RequestMapping(PortalServiceProxy.QUERY_LIST)
    Result<List<Portal>> queryList(@RequestParam(name = "sample") PortalVO sample);

    /**
     * 分页查询门户
     */
    @RequestMapping(PortalServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Portal>> queryPagedList(@RequestParam(name = "sample") PortalVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.PortalController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static PortalServiceProxy api() {
        return APIProxy.get(PortalServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
