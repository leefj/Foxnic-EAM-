package com.dt.platform.proxy.common;

import com.alibaba.fastjson.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.ScreenDsData;
import com.dt.platform.domain.common.ScreenDsDataVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 数据源 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-27 13:03:15
 */
@FeignClient(value = ServiceNames.COMMON, contextId = ScreenDsDataServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ScreenDsDataServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-screen-ds-data
     */
    public static final String API_CONTEXT_PATH = "sys-screen-ds-data";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加数据源
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除数据源
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除数据源
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新数据源
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存数据源
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个数据源
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个数据源
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询数据源
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询数据源
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 查询数据源
     */
    public static final String QUERY_DATA_BY_CODE = API_PREFIX + "query-data-by-code";

    /**
     * 添加数据源
     */
    @RequestMapping(ScreenDsDataServiceProxy.INSERT)
    Result insert(@RequestParam(name = "screenDsDataVO") ScreenDsDataVO screenDsDataVO);

    /**
     * 删除数据源
     */
    @RequestMapping(ScreenDsDataServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除数据源
     */
    @RequestMapping(ScreenDsDataServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新数据源
     */
    @RequestMapping(ScreenDsDataServiceProxy.UPDATE)
    Result update(@RequestParam(name = "screenDsDataVO") ScreenDsDataVO screenDsDataVO);

    /**
     * 更新数据源
     */
    @RequestMapping(ScreenDsDataServiceProxy.SAVE)
    Result save(@RequestParam(name = "screenDsDataVO") ScreenDsDataVO screenDsDataVO);

    /**
     * 获取数据源
     */
    @RequestMapping(ScreenDsDataServiceProxy.GET_BY_ID)
    Result<ScreenDsData> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个数据源
     */
    @RequestMapping(ScreenDsDataServiceProxy.GET_BY_IDS)
    Result<List<ScreenDsData>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询数据源
     */
    @RequestMapping(ScreenDsDataServiceProxy.QUERY_LIST)
    Result<List<ScreenDsData>> queryList(@RequestParam(name = "sample") ScreenDsDataVO sample);

    /**
     * 查询数据源
     */
    @RequestMapping(ScreenDsDataServiceProxy.QUERY_DATA_BY_CODE)
    Result<JSONArray> queryDataByCode(@RequestParam(name = "code") String code);

    /**
     * 分页查询数据源
     */
    @RequestMapping(ScreenDsDataServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ScreenDsData>> queryPagedList(@RequestParam(name = "sample") ScreenDsDataVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.ScreenDsDataController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ScreenDsDataServiceProxy api() {
        return APIProxy.get(ScreenDsDataServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
