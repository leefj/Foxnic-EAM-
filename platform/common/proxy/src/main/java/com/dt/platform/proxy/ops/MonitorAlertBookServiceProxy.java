package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.MonitorAlertBook;
import com.dt.platform.domain.ops.MonitorAlertBookVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 告警订阅 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-06-01 17:54:29
 */
@FeignClient(value = ServiceNames.OPS, contextId = MonitorAlertBookServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MonitorAlertBookServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-monitor-alert-book
     */
    public static final String API_CONTEXT_PATH = "ops-monitor-alert-book";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加告警订阅
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除告警订阅
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除告警订阅
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新告警订阅
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存告警订阅
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个告警订阅
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个告警订阅
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询告警订阅
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询告警订阅
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加告警订阅
     */
    @RequestMapping(MonitorAlertBookServiceProxy.INSERT)
    Result insert(@RequestParam(name = "monitorAlertBookVO") MonitorAlertBookVO monitorAlertBookVO);

    /**
     * 删除告警订阅
     */
    @RequestMapping(MonitorAlertBookServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除告警订阅
     */
    @RequestMapping(MonitorAlertBookServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新告警订阅
     */
    @RequestMapping(MonitorAlertBookServiceProxy.UPDATE)
    Result update(@RequestParam(name = "monitorAlertBookVO") MonitorAlertBookVO monitorAlertBookVO);

    /**
     * 更新告警订阅
     */
    @RequestMapping(MonitorAlertBookServiceProxy.SAVE)
    Result save(@RequestParam(name = "monitorAlertBookVO") MonitorAlertBookVO monitorAlertBookVO);

    /**
     * 获取告警订阅
     */
    @RequestMapping(MonitorAlertBookServiceProxy.GET_BY_ID)
    Result<MonitorAlertBook> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个告警订阅
     */
    @RequestMapping(MonitorAlertBookServiceProxy.GET_BY_IDS)
    Result<List<MonitorAlertBook>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询告警订阅
     */
    @RequestMapping(MonitorAlertBookServiceProxy.QUERY_LIST)
    Result<List<MonitorAlertBook>> queryList(@RequestParam(name = "sample") MonitorAlertBookVO sample);

    /**
     * 分页查询告警订阅
     */
    @RequestMapping(MonitorAlertBookServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<MonitorAlertBook>> queryPagedList(@RequestParam(name = "sample") MonitorAlertBookVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.MonitorAlertBookController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MonitorAlertBookServiceProxy api() {
        return APIProxy.get(MonitorAlertBookServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
