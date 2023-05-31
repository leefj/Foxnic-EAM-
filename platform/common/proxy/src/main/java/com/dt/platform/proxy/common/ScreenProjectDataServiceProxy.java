package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.ScreenProjectData;
import com.dt.platform.domain.common.ScreenProjectDataVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 项目数据 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-30 14:10:29
 */
@FeignClient(value = ServiceNames.COMMON, contextId = ScreenProjectDataServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ScreenProjectDataServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-screen-project-data
     */
    public static final String API_CONTEXT_PATH = "sys-screen-project-data";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加项目数据
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除项目数据
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除项目数据
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新项目数据
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存项目数据
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个项目数据
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个项目数据
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询项目数据
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询项目数据
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加项目数据
     */
    @RequestMapping(ScreenProjectDataServiceProxy.INSERT)
    Result insert(@RequestParam(name = "screenProjectDataVO") ScreenProjectDataVO screenProjectDataVO);

    /**
     * 删除项目数据
     */
    @RequestMapping(ScreenProjectDataServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除项目数据
     */
    @RequestMapping(ScreenProjectDataServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新项目数据
     */
    @RequestMapping(ScreenProjectDataServiceProxy.UPDATE)
    Result update(@RequestParam(name = "screenProjectDataVO") ScreenProjectDataVO screenProjectDataVO);

    /**
     * 更新项目数据
     */
    @RequestMapping(ScreenProjectDataServiceProxy.SAVE)
    Result save(@RequestParam(name = "screenProjectDataVO") ScreenProjectDataVO screenProjectDataVO);

    /**
     * 获取项目数据
     */
    @RequestMapping(ScreenProjectDataServiceProxy.GET_BY_ID)
    Result<ScreenProjectData> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个项目数据
     */
    @RequestMapping(ScreenProjectDataServiceProxy.GET_BY_IDS)
    Result<List<ScreenProjectData>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询项目数据
     */
    @RequestMapping(ScreenProjectDataServiceProxy.QUERY_LIST)
    Result<List<ScreenProjectData>> queryList(@RequestParam(name = "sample") ScreenProjectDataVO sample);

    /**
     * 分页查询项目数据
     */
    @RequestMapping(ScreenProjectDataServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ScreenProjectData>> queryPagedList(@RequestParam(name = "sample") ScreenProjectDataVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.ScreenProjectDataController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ScreenProjectDataServiceProxy api() {
        return APIProxy.get(ScreenProjectDataServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
