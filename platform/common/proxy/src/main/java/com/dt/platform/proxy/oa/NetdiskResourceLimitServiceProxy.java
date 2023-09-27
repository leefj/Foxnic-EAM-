package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.NetdiskResourceLimit;
import com.dt.platform.domain.oa.NetdiskResourceLimitVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 资源限制 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-27 15:59:06
 */
@FeignClient(value = ServiceNames.OA, contextId = NetdiskResourceLimitServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface NetdiskResourceLimitServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-netdisk-resource-limit
     */
    public static final String API_CONTEXT_PATH = "oa-netdisk-resource-limit";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加资源限制
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除资源限制
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除资源限制
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新资源限制
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存资源限制
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个资源限制
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个资源限制
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询资源限制
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询资源限制
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    public static final String GET_MY_RESOURCE = API_PREFIX + "get-my-resource";

    public static final String RECALCULATE = API_PREFIX + "recalculate";



    /**
     * 添加资源限制
     */
    @RequestMapping(NetdiskResourceLimitServiceProxy.INSERT)
    Result insert(@RequestParam(name = "netdiskResourceLimitVO") NetdiskResourceLimitVO netdiskResourceLimitVO);

    /**
     * 删除资源限制
     */
    @RequestMapping(NetdiskResourceLimitServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除资源限制
     */
    @RequestMapping(NetdiskResourceLimitServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新资源限制
     */
    @RequestMapping(NetdiskResourceLimitServiceProxy.UPDATE)
    Result update(@RequestParam(name = "netdiskResourceLimitVO") NetdiskResourceLimitVO netdiskResourceLimitVO);

    /**
     * 更新资源限制
     */
    @RequestMapping(NetdiskResourceLimitServiceProxy.SAVE)
    Result save(@RequestParam(name = "netdiskResourceLimitVO") NetdiskResourceLimitVO netdiskResourceLimitVO);

    /**
     * 获取资源限制
     */
    @RequestMapping(NetdiskResourceLimitServiceProxy.GET_BY_ID)
    Result<NetdiskResourceLimit> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个资源限制
     */
    @RequestMapping(NetdiskResourceLimitServiceProxy.GET_BY_IDS)
    Result<List<NetdiskResourceLimit>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询资源限制
     */
    @RequestMapping(NetdiskResourceLimitServiceProxy.QUERY_LIST)
    Result<List<NetdiskResourceLimit>> queryList(@RequestParam(name = "sample") NetdiskResourceLimitVO sample);

    /**
     * 分页查询资源限制
     */
    @RequestMapping(NetdiskResourceLimitServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<NetdiskResourceLimit>> queryPagedList(@RequestParam(name = "sample") NetdiskResourceLimitVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.NetdiskResourceLimitController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static NetdiskResourceLimitServiceProxy api() {
        return APIProxy.get(NetdiskResourceLimitServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
