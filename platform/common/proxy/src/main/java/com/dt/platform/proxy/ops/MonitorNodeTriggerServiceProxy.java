package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.MonitorNodeTrigger;
import com.dt.platform.domain.ops.MonitorNodeTriggerVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 触发器 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-06-04 06:12:55
 */
@FeignClient(value = ServiceNames.OPS, contextId = MonitorNodeTriggerServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MonitorNodeTriggerServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-monitor-node-trigger
     */
    public static final String API_CONTEXT_PATH = "ops-monitor-node-trigger";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加触发器
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除触发器
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除触发器
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新触发器
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存触发器
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个触发器
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个触发器
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询触发器
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询触发器
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加触发器
     */
    @RequestMapping(MonitorNodeTriggerServiceProxy.INSERT)
    Result insert(@RequestParam(name = "monitorNodeTriggerVO") MonitorNodeTriggerVO monitorNodeTriggerVO);

    /**
     * 删除触发器
     */
    @RequestMapping(MonitorNodeTriggerServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除触发器
     */
    @RequestMapping(MonitorNodeTriggerServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新触发器
     */
    @RequestMapping(MonitorNodeTriggerServiceProxy.UPDATE)
    Result update(@RequestParam(name = "monitorNodeTriggerVO") MonitorNodeTriggerVO monitorNodeTriggerVO);

    /**
     * 更新触发器
     */
    @RequestMapping(MonitorNodeTriggerServiceProxy.SAVE)
    Result save(@RequestParam(name = "monitorNodeTriggerVO") MonitorNodeTriggerVO monitorNodeTriggerVO);

    /**
     * 获取触发器
     */
    @RequestMapping(MonitorNodeTriggerServiceProxy.GET_BY_ID)
    Result<MonitorNodeTrigger> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个触发器
     */
    @RequestMapping(MonitorNodeTriggerServiceProxy.GET_BY_IDS)
    Result<List<MonitorNodeTrigger>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询触发器
     */
    @RequestMapping(MonitorNodeTriggerServiceProxy.QUERY_LIST)
    Result<List<MonitorNodeTrigger>> queryList(@RequestParam(name = "sample") MonitorNodeTriggerVO sample);

    /**
     * 分页查询触发器
     */
    @RequestMapping(MonitorNodeTriggerServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<MonitorNodeTrigger>> queryPagedList(@RequestParam(name = "sample") MonitorNodeTriggerVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.MonitorNodeTriggerController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MonitorNodeTriggerServiceProxy api() {
        return APIProxy.get(MonitorNodeTriggerServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
