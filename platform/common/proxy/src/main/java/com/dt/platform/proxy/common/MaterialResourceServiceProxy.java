package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.MaterialResource;
import com.dt.platform.domain.common.MaterialResourceVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 素材资源 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-02 15:29:00
 */
@FeignClient(value = ServiceNames.COMMON, contextId = MaterialResourceServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MaterialResourceServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-material-resource
     */
    public static final String API_CONTEXT_PATH = "sys-material-resource";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加素材资源
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除素材资源
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除素材资源
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新素材资源
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存素材资源
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个素材资源
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个素材资源
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询素材资源
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询素材资源
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加素材资源
     */
    @RequestMapping(MaterialResourceServiceProxy.INSERT)
    Result insert(@RequestParam(name = "materialResourceVO") MaterialResourceVO materialResourceVO);

    /**
     * 删除素材资源
     */
    @RequestMapping(MaterialResourceServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除素材资源
     */
    @RequestMapping(MaterialResourceServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新素材资源
     */
    @RequestMapping(MaterialResourceServiceProxy.UPDATE)
    Result update(@RequestParam(name = "materialResourceVO") MaterialResourceVO materialResourceVO);

    /**
     * 更新素材资源
     */
    @RequestMapping(MaterialResourceServiceProxy.SAVE)
    Result save(@RequestParam(name = "materialResourceVO") MaterialResourceVO materialResourceVO);

    /**
     * 获取素材资源
     */
    @RequestMapping(MaterialResourceServiceProxy.GET_BY_ID)
    Result<MaterialResource> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个素材资源
     */
    @RequestMapping(MaterialResourceServiceProxy.GET_BY_IDS)
    Result<List<MaterialResource>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询素材资源
     */
    @RequestMapping(MaterialResourceServiceProxy.QUERY_LIST)
    Result<List<MaterialResource>> queryList(@RequestParam(name = "sample") MaterialResourceVO sample);

    /**
     * 分页查询素材资源
     */
    @RequestMapping(MaterialResourceServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<MaterialResource>> queryPagedList(@RequestParam(name = "sample") MaterialResourceVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.MaterialResourceController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MaterialResourceServiceProxy api() {
        return APIProxy.get(MaterialResourceServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
