package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.NetdiskMenu;
import com.dt.platform.domain.oa.NetdiskMenuVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 网盘菜单 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-17 17:52:47
 */
@FeignClient(value = ServiceNames.OA, contextId = NetdiskMenuServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface NetdiskMenuServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-netdisk-menu
     */
    public static final String API_CONTEXT_PATH = "oa-netdisk-menu";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加网盘菜单
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除网盘菜单
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除网盘菜单
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新网盘菜单
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存网盘菜单
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个网盘菜单
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个网盘菜单
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询网盘菜单
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询网盘菜单
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加网盘菜单
     */
    @RequestMapping(NetdiskMenuServiceProxy.INSERT)
    Result insert(@RequestParam(name = "netdiskMenuVO") NetdiskMenuVO netdiskMenuVO);

    /**
     * 删除网盘菜单
     */
    @RequestMapping(NetdiskMenuServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除网盘菜单
     */
    @RequestMapping(NetdiskMenuServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新网盘菜单
     */
    @RequestMapping(NetdiskMenuServiceProxy.UPDATE)
    Result update(@RequestParam(name = "netdiskMenuVO") NetdiskMenuVO netdiskMenuVO);

    /**
     * 更新网盘菜单
     */
    @RequestMapping(NetdiskMenuServiceProxy.SAVE)
    Result save(@RequestParam(name = "netdiskMenuVO") NetdiskMenuVO netdiskMenuVO);

    /**
     * 获取网盘菜单
     */
    @RequestMapping(NetdiskMenuServiceProxy.GET_BY_ID)
    Result<NetdiskMenu> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个网盘菜单
     */
    @RequestMapping(NetdiskMenuServiceProxy.GET_BY_IDS)
    Result<List<NetdiskMenu>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询网盘菜单
     */
    @RequestMapping(NetdiskMenuServiceProxy.QUERY_LIST)
    Result<List<NetdiskMenu>> queryList(@RequestParam(name = "sample") NetdiskMenuVO sample);

    /**
     * 分页查询网盘菜单
     */
    @RequestMapping(NetdiskMenuServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<NetdiskMenu>> queryPagedList(@RequestParam(name = "sample") NetdiskMenuVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.NetdiskMenuController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static NetdiskMenuServiceProxy api() {
        return APIProxy.get(NetdiskMenuServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
