package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.NetdiskStorage;
import com.dt.platform.domain.oa.NetdiskStorageVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 存储方式 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-18 14:21:10
 */
@FeignClient(value = ServiceNames.OA, contextId = NetdiskStorageServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface NetdiskStorageServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-netdisk-storage
     */
    public static final String API_CONTEXT_PATH = "oa-netdisk-storage";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加存储方式
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除存储方式
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除存储方式
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新存储方式
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存存储方式
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个存储方式
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个存储方式
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询存储方式
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询存储方式
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加存储方式
     */
    @RequestMapping(NetdiskStorageServiceProxy.INSERT)
    Result insert(@RequestParam(name = "netdiskStorageVO") NetdiskStorageVO netdiskStorageVO);

    /**
     * 删除存储方式
     */
    @RequestMapping(NetdiskStorageServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除存储方式
     */
    @RequestMapping(NetdiskStorageServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新存储方式
     */
    @RequestMapping(NetdiskStorageServiceProxy.UPDATE)
    Result update(@RequestParam(name = "netdiskStorageVO") NetdiskStorageVO netdiskStorageVO);

    /**
     * 更新存储方式
     */
    @RequestMapping(NetdiskStorageServiceProxy.SAVE)
    Result save(@RequestParam(name = "netdiskStorageVO") NetdiskStorageVO netdiskStorageVO);

    /**
     * 获取存储方式
     */
    @RequestMapping(NetdiskStorageServiceProxy.GET_BY_ID)
    Result<NetdiskStorage> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个存储方式
     */
    @RequestMapping(NetdiskStorageServiceProxy.GET_BY_IDS)
    Result<List<NetdiskStorage>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询存储方式
     */
    @RequestMapping(NetdiskStorageServiceProxy.QUERY_LIST)
    Result<List<NetdiskStorage>> queryList(@RequestParam(name = "sample") NetdiskStorageVO sample);

    /**
     * 分页查询存储方式
     */
    @RequestMapping(NetdiskStorageServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<NetdiskStorage>> queryPagedList(@RequestParam(name = "sample") NetdiskStorageVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.NetdiskStorageController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static NetdiskStorageServiceProxy api() {
        return APIProxy.get(NetdiskStorageServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
