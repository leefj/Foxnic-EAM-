package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.RepairOrderTransfer;
import com.dt.platform.domain.eam.RepairOrderTransferVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 工单转派 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-17 21:04:59
 */
@FeignClient(value = ServiceNames.EAM, contextId = RepairOrderTransferServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface RepairOrderTransferServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-repair-order-transfer
     */
    public static final String API_CONTEXT_PATH = "eam-repair-order-transfer";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加工单转派
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除工单转派
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除工单转派
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新工单转派
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存工单转派
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个工单转派
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个工单转派
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询工单转派
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询工单转派
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加工单转派
     */
    @RequestMapping(RepairOrderTransferServiceProxy.INSERT)
    Result insert(@RequestParam(name = "repairOrderTransferVO") RepairOrderTransferVO repairOrderTransferVO);

    /**
     * 删除工单转派
     */
    @RequestMapping(RepairOrderTransferServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除工单转派
     */
    @RequestMapping(RepairOrderTransferServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新工单转派
     */
    @RequestMapping(RepairOrderTransferServiceProxy.UPDATE)
    Result update(@RequestParam(name = "repairOrderTransferVO") RepairOrderTransferVO repairOrderTransferVO);

    /**
     * 更新工单转派
     */
    @RequestMapping(RepairOrderTransferServiceProxy.SAVE)
    Result save(@RequestParam(name = "repairOrderTransferVO") RepairOrderTransferVO repairOrderTransferVO);

    /**
     * 获取工单转派
     */
    @RequestMapping(RepairOrderTransferServiceProxy.GET_BY_ID)
    Result<RepairOrderTransfer> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个工单转派
     */
    @RequestMapping(RepairOrderTransferServiceProxy.GET_BY_IDS)
    Result<List<RepairOrderTransfer>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询工单转派
     */
    @RequestMapping(RepairOrderTransferServiceProxy.QUERY_LIST)
    Result<List<RepairOrderTransfer>> queryList(@RequestParam(name = "sample") RepairOrderTransferVO sample);

    /**
     * 分页查询工单转派
     */
    @RequestMapping(RepairOrderTransferServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<RepairOrderTransfer>> queryPagedList(@RequestParam(name = "sample") RepairOrderTransferVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.RepairOrderTransferController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static RepairOrderTransferServiceProxy api() {
        return APIProxy.get(RepairOrderTransferServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
