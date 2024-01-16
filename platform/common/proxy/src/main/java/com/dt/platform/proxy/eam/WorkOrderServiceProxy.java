package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.WorkOrder;
import com.dt.platform.domain.eam.WorkOrderVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 问题工单 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-13 20:51:40
 */
@FeignClient(value = ServiceNames.EAM, contextId = WorkOrderServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface WorkOrderServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-work-order
     */
    public static final String API_CONTEXT_PATH = "eam-work-order";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加问题工单
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除问题工单
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除问题工单
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新问题工单
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存问题工单
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个问题工单
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个问题工单
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询问题工单
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询问题工单
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 取消
     */
    public static final String CANCEL = API_PREFIX + "cancel";

    /**
     * 添加问题工单
     */
    @RequestMapping(WorkOrderServiceProxy.INSERT)
    Result insert(@RequestParam(name = "workOrderVO") WorkOrderVO workOrderVO);

    /**
     * 删除问题工单
     */
    @RequestMapping(WorkOrderServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除问题工单
     */
    @RequestMapping(WorkOrderServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新问题工单
     */
    @RequestMapping(WorkOrderServiceProxy.UPDATE)
    Result update(@RequestParam(name = "workOrderVO") WorkOrderVO workOrderVO);

    /**
     * 更新问题工单
     */
    @RequestMapping(WorkOrderServiceProxy.SAVE)
    Result save(@RequestParam(name = "workOrderVO") WorkOrderVO workOrderVO);

    /**
     * 获取问题工单
     */
    @RequestMapping(WorkOrderServiceProxy.GET_BY_ID)
    Result<WorkOrder> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个问题工单
     */
    @RequestMapping(WorkOrderServiceProxy.GET_BY_IDS)
    Result<List<WorkOrder>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询问题工单
     */
    @RequestMapping(WorkOrderServiceProxy.QUERY_LIST)
    Result<List<WorkOrder>> queryList(@RequestParam(name = "sample") WorkOrderVO sample);

    /**
     * 分页查询问题工单
     */
    @RequestMapping(WorkOrderServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<WorkOrder>> queryPagedList(@RequestParam(name = "sample") WorkOrderVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.WorkOrderController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static WorkOrderServiceProxy api() {
        return APIProxy.get(WorkOrderServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
