package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.MonitorAlertEvent;
import com.dt.platform.domain.ops.MonitorAlertEventVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 告警事件 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-06 09:10:57
 */
@FeignClient(value = ServiceNames.OPS, contextId = MonitorAlertEventServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MonitorAlertEventServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-monitor-alert-event
     */
    public static final String API_CONTEXT_PATH = "ops-monitor-alert-event";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加告警事件
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除告警事件
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除告警事件
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新告警事件
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存告警事件
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个告警事件
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个告警事件
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询告警事件
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询告警事件
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加告警事件
     */
    @RequestMapping(MonitorAlertEventServiceProxy.INSERT)
    Result insert(@RequestParam(name = "monitorAlertEventVO") MonitorAlertEventVO monitorAlertEventVO);

    /**
     * 删除告警事件
     */
    @RequestMapping(MonitorAlertEventServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除告警事件
     */
    @RequestMapping(MonitorAlertEventServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新告警事件
     */
    @RequestMapping(MonitorAlertEventServiceProxy.UPDATE)
    Result update(@RequestParam(name = "monitorAlertEventVO") MonitorAlertEventVO monitorAlertEventVO);

    /**
     * 更新告警事件
     */
    @RequestMapping(MonitorAlertEventServiceProxy.SAVE)
    Result save(@RequestParam(name = "monitorAlertEventVO") MonitorAlertEventVO monitorAlertEventVO);

    /**
     * 获取告警事件
     */
    @RequestMapping(MonitorAlertEventServiceProxy.GET_BY_ID)
    Result<MonitorAlertEvent> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个告警事件
     */
    @RequestMapping(MonitorAlertEventServiceProxy.GET_BY_IDS)
    Result<List<MonitorAlertEvent>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询告警事件
     */
    @RequestMapping(MonitorAlertEventServiceProxy.QUERY_LIST)
    Result<List<MonitorAlertEvent>> queryList(@RequestParam(name = "sample") MonitorAlertEventVO sample);

    /**
     * 分页查询告警事件
     */
    @RequestMapping(MonitorAlertEventServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<MonitorAlertEvent>> queryPagedList(@RequestParam(name = "sample") MonitorAlertEventVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.MonitorAlertEventController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MonitorAlertEventServiceProxy api() {
        return APIProxy.get(MonitorAlertEventServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
