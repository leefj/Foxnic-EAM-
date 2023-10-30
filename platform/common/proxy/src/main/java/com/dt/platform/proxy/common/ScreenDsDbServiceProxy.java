package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.ScreenDsDb;
import com.dt.platform.domain.common.ScreenDsDbVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 数据库 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-28 07:56:45
 */
@FeignClient(value = ServiceNames.COMMON, contextId = ScreenDsDbServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ScreenDsDbServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-screen-ds-db
     */
    public static final String API_CONTEXT_PATH = "sys-screen-ds-db";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加数据库
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除数据库
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除数据库
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新数据库
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存数据库
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个数据库
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个数据库
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询数据库
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询数据库
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    public static final String TEST = API_PREFIX + "test";

    /**
     * 添加数据库
     */
    @RequestMapping(ScreenDsDbServiceProxy.INSERT)
    Result insert(@RequestParam(name = "screenDsDbVO") ScreenDsDbVO screenDsDbVO);

    /**
     * 删除数据库
     */
    @RequestMapping(ScreenDsDbServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除数据库
     */
    @RequestMapping(ScreenDsDbServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新数据库
     */
    @RequestMapping(ScreenDsDbServiceProxy.UPDATE)
    Result update(@RequestParam(name = "screenDsDbVO") ScreenDsDbVO screenDsDbVO);

    /**
     * 更新数据库
     */
    @RequestMapping(ScreenDsDbServiceProxy.SAVE)
    Result save(@RequestParam(name = "screenDsDbVO") ScreenDsDbVO screenDsDbVO);

    /**
     * 获取数据库
     */
    @RequestMapping(ScreenDsDbServiceProxy.GET_BY_ID)
    Result<ScreenDsDb> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个数据库
     */
    @RequestMapping(ScreenDsDbServiceProxy.GET_BY_IDS)
    Result<List<ScreenDsDb>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询数据库
     */
    @RequestMapping(ScreenDsDbServiceProxy.QUERY_LIST)
    Result<List<ScreenDsDb>> queryList(@RequestParam(name = "sample") ScreenDsDbVO sample);

    /**
     * 分页查询数据库
     */
    @RequestMapping(ScreenDsDbServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ScreenDsDb>> queryPagedList(@RequestParam(name = "sample") ScreenDsDbVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.ScreenDsDbController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ScreenDsDbServiceProxy api() {
        return APIProxy.get(ScreenDsDbServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}