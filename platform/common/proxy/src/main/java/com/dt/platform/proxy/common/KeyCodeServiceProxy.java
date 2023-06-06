package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.KeyCode;
import com.dt.platform.domain.common.KeyCodeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 菜单键值 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-06 19:37:06
 */
@FeignClient(value = ServiceNames.COMMON, contextId = KeyCodeServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface KeyCodeServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-key-code
     */
    public static final String API_CONTEXT_PATH = "sys-key-code";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加菜单键值
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除菜单键值
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除菜单键值
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新菜单键值
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存菜单键值
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个菜单键值
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个菜单键值
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询菜单键值
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询菜单键值
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加菜单键值
     */
    @RequestMapping(KeyCodeServiceProxy.INSERT)
    Result insert(@RequestParam(name = "keyCodeVO") KeyCodeVO keyCodeVO);

    /**
     * 删除菜单键值
     */
    @RequestMapping(KeyCodeServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除菜单键值
     */
    @RequestMapping(KeyCodeServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新菜单键值
     */
    @RequestMapping(KeyCodeServiceProxy.UPDATE)
    Result update(@RequestParam(name = "keyCodeVO") KeyCodeVO keyCodeVO);

    /**
     * 更新菜单键值
     */
    @RequestMapping(KeyCodeServiceProxy.SAVE)
    Result save(@RequestParam(name = "keyCodeVO") KeyCodeVO keyCodeVO);

    /**
     * 获取菜单键值
     */
    @RequestMapping(KeyCodeServiceProxy.GET_BY_ID)
    Result<KeyCode> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个菜单键值
     */
    @RequestMapping(KeyCodeServiceProxy.GET_BY_IDS)
    Result<List<KeyCode>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询菜单键值
     */
    @RequestMapping(KeyCodeServiceProxy.QUERY_LIST)
    Result<List<KeyCode>> queryList(@RequestParam(name = "sample") KeyCodeVO sample);

    /**
     * 分页查询菜单键值
     */
    @RequestMapping(KeyCodeServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<KeyCode>> queryPagedList(@RequestParam(name = "sample") KeyCodeVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.KeyCodeController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static KeyCodeServiceProxy api() {
        return APIProxy.get(KeyCodeServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
