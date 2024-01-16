package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.WorkOrderMsg;
import com.dt.platform.domain.eam.WorkOrderMsgVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 工单消息 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-14 10:36:56
 */
@FeignClient(value = ServiceNames.EAM, contextId = WorkOrderMsgServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface WorkOrderMsgServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-work-order-msg
     */
    public static final String API_CONTEXT_PATH = "eam-work-order-msg";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加工单消息
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除工单消息
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除工单消息
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新工单消息
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存工单消息
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个工单消息
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个工单消息
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询工单消息
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询工单消息
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加工单消息
     */
    @RequestMapping(WorkOrderMsgServiceProxy.INSERT)
    Result insert(@RequestParam(name = "workOrderMsgVO") WorkOrderMsgVO workOrderMsgVO);

    /**
     * 删除工单消息
     */
    @RequestMapping(WorkOrderMsgServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除工单消息
     */
    @RequestMapping(WorkOrderMsgServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新工单消息
     */
    @RequestMapping(WorkOrderMsgServiceProxy.UPDATE)
    Result update(@RequestParam(name = "workOrderMsgVO") WorkOrderMsgVO workOrderMsgVO);

    /**
     * 更新工单消息
     */
    @RequestMapping(WorkOrderMsgServiceProxy.SAVE)
    Result save(@RequestParam(name = "workOrderMsgVO") WorkOrderMsgVO workOrderMsgVO);

    /**
     * 获取工单消息
     */
    @RequestMapping(WorkOrderMsgServiceProxy.GET_BY_ID)
    Result<WorkOrderMsg> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个工单消息
     */
    @RequestMapping(WorkOrderMsgServiceProxy.GET_BY_IDS)
    Result<List<WorkOrderMsg>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询工单消息
     */
    @RequestMapping(WorkOrderMsgServiceProxy.QUERY_LIST)
    Result<List<WorkOrderMsg>> queryList(@RequestParam(name = "sample") WorkOrderMsgVO sample);

    /**
     * 分页查询工单消息
     */
    @RequestMapping(WorkOrderMsgServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<WorkOrderMsg>> queryPagedList(@RequestParam(name = "sample") WorkOrderMsgVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.WorkOrderMsgController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static WorkOrderMsgServiceProxy api() {
        return APIProxy.get(WorkOrderMsgServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
