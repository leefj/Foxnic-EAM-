package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetDataPermissionsWh;
import com.dt.platform.domain.eam.AssetDataPermissionsWhVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 仓库 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-26 07:46:41
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetDataPermissionsWhServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetDataPermissionsWhServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-data-permissions-wh
     */
    public static final String API_CONTEXT_PATH = "eam-asset-data-permissions-wh";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加仓库
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除仓库
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除仓库
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新仓库
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存仓库
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个仓库
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个仓库
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询仓库
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询仓库
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加仓库
     */
    @RequestMapping(AssetDataPermissionsWhServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetDataPermissionsWhVO") AssetDataPermissionsWhVO assetDataPermissionsWhVO);

    /**
     * 删除仓库
     */
    @RequestMapping(AssetDataPermissionsWhServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除仓库
     */
    @RequestMapping(AssetDataPermissionsWhServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新仓库
     */
    @RequestMapping(AssetDataPermissionsWhServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetDataPermissionsWhVO") AssetDataPermissionsWhVO assetDataPermissionsWhVO);

    /**
     * 更新仓库
     */
    @RequestMapping(AssetDataPermissionsWhServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetDataPermissionsWhVO") AssetDataPermissionsWhVO assetDataPermissionsWhVO);

    /**
     * 获取仓库
     */
    @RequestMapping(AssetDataPermissionsWhServiceProxy.GET_BY_ID)
    Result<AssetDataPermissionsWh> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个仓库
     */
    @RequestMapping(AssetDataPermissionsWhServiceProxy.GET_BY_IDS)
    Result<List<AssetDataPermissionsWh>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询仓库
     */
    @RequestMapping(AssetDataPermissionsWhServiceProxy.QUERY_LIST)
    Result<List<AssetDataPermissionsWh>> queryList(@RequestParam(name = "sample") AssetDataPermissionsWhVO sample);

    /**
     * 分页查询仓库
     */
    @RequestMapping(AssetDataPermissionsWhServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetDataPermissionsWh>> queryPagedList(@RequestParam(name = "sample") AssetDataPermissionsWhVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetDataPermissionsWhController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetDataPermissionsWhServiceProxy api() {
        return APIProxy.get(AssetDataPermissionsWhServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
