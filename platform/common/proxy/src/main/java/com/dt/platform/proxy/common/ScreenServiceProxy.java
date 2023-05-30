package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.Screen;
import com.dt.platform.domain.common.ScreenVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 大屏 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-30 13:57:57
 */
@FeignClient(value = ServiceNames.COMMON, contextId = ScreenServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ScreenServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-screen
     */
    public static final String API_CONTEXT_PATH = "sys-screen";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加大屏
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除大屏
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除大屏
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新大屏
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存大屏
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个大屏
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个大屏
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询大屏
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询大屏
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加大屏
     */
    @RequestMapping(ScreenServiceProxy.INSERT)
    Result insert(@RequestParam(name = "screenVO") ScreenVO screenVO);

    /**
     * 删除大屏
     */
    @RequestMapping(ScreenServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除大屏
     */
    @RequestMapping(ScreenServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新大屏
     */
    @RequestMapping(ScreenServiceProxy.UPDATE)
    Result update(@RequestParam(name = "screenVO") ScreenVO screenVO);

    /**
     * 更新大屏
     */
    @RequestMapping(ScreenServiceProxy.SAVE)
    Result save(@RequestParam(name = "screenVO") ScreenVO screenVO);

    /**
     * 获取大屏
     */
    @RequestMapping(ScreenServiceProxy.GET_BY_ID)
    Result<Screen> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个大屏
     */
    @RequestMapping(ScreenServiceProxy.GET_BY_IDS)
    Result<List<Screen>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询大屏
     */
    @RequestMapping(ScreenServiceProxy.QUERY_LIST)
    Result<List<Screen>> queryList(@RequestParam(name = "sample") ScreenVO sample);

    /**
     * 分页查询大屏
     */
    @RequestMapping(ScreenServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Screen>> queryPagedList(@RequestParam(name = "sample") ScreenVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.ScreenController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ScreenServiceProxy api() {
        return APIProxy.get(ScreenServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
