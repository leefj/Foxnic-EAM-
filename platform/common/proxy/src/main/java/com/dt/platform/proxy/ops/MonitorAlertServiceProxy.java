package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.MonitorAlert;
import com.dt.platform.domain.ops.MonitorAlertVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 监控告警 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-05 15:45:56
 */
@FeignClient(value = ServiceNames.OPS, contextId = MonitorAlertServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MonitorAlertServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-monitor-alert
     */
    public static final String API_CONTEXT_PATH = "ops-monitor-alert";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加监控告警
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除监控告警
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除监控告警
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新监控告警
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存监控告警
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个监控告警
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个监控告警
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询监控告警
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询监控告警
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加监控告警
     */
    @RequestMapping(MonitorAlertServiceProxy.INSERT)
    Result insert(@RequestParam(name = "monitorAlertVO") MonitorAlertVO monitorAlertVO);

    /**
     * 删除监控告警
     */
    @RequestMapping(MonitorAlertServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除监控告警
     */
    @RequestMapping(MonitorAlertServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新监控告警
     */
    @RequestMapping(MonitorAlertServiceProxy.UPDATE)
    Result update(@RequestParam(name = "monitorAlertVO") MonitorAlertVO monitorAlertVO);

    /**
     * 更新监控告警
     */
    @RequestMapping(MonitorAlertServiceProxy.SAVE)
    Result save(@RequestParam(name = "monitorAlertVO") MonitorAlertVO monitorAlertVO);

    /**
     * 获取监控告警
     */
    @RequestMapping(MonitorAlertServiceProxy.GET_BY_ID)
    Result<MonitorAlert> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个监控告警
     */
    @RequestMapping(MonitorAlertServiceProxy.GET_BY_IDS)
    Result<List<MonitorAlert>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询监控告警
     */
    @RequestMapping(MonitorAlertServiceProxy.QUERY_LIST)
    Result<List<MonitorAlert>> queryList(@RequestParam(name = "sample") MonitorAlertVO sample);

    /**
     * 分页查询监控告警
     */
    @RequestMapping(MonitorAlertServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<MonitorAlert>> queryPagedList(@RequestParam(name = "sample") MonitorAlertVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.MonitorAlertController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MonitorAlertServiceProxy api() {
        return APIProxy.get(MonitorAlertServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
