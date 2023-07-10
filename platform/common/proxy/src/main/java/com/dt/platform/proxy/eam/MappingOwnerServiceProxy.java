package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.MappingOwner;
import com.dt.platform.domain.eam.MappingOwnerVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 归属 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-10 18:26:18
 */
@FeignClient(value = ServiceNames.EAM, contextId = MappingOwnerServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MappingOwnerServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-mapping-owner
     */
    public static final String API_CONTEXT_PATH = "eam-mapping-owner";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加归属
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除归属
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除归属
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新归属
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存归属
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个归属
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个归属
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询归属
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询归属
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加归属
     */
    @RequestMapping(MappingOwnerServiceProxy.INSERT)
    Result insert(@RequestParam(name = "mappingOwnerVO") MappingOwnerVO mappingOwnerVO);

    /**
     * 删除归属
     */
    @RequestMapping(MappingOwnerServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除归属
     */
    @RequestMapping(MappingOwnerServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新归属
     */
    @RequestMapping(MappingOwnerServiceProxy.UPDATE)
    Result update(@RequestParam(name = "mappingOwnerVO") MappingOwnerVO mappingOwnerVO);

    /**
     * 更新归属
     */
    @RequestMapping(MappingOwnerServiceProxy.SAVE)
    Result save(@RequestParam(name = "mappingOwnerVO") MappingOwnerVO mappingOwnerVO);

    /**
     * 获取归属
     */
    @RequestMapping(MappingOwnerServiceProxy.GET_BY_ID)
    Result<MappingOwner> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个归属
     */
    @RequestMapping(MappingOwnerServiceProxy.GET_BY_IDS)
    Result<List<MappingOwner>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询归属
     */
    @RequestMapping(MappingOwnerServiceProxy.QUERY_LIST)
    Result<List<MappingOwner>> queryList(@RequestParam(name = "sample") MappingOwnerVO sample);

    /**
     * 分页查询归属
     */
    @RequestMapping(MappingOwnerServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<MappingOwner>> queryPagedList(@RequestParam(name = "sample") MappingOwnerVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.MappingOwnerController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MappingOwnerServiceProxy api() {
        return APIProxy.get(MappingOwnerServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
