package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.RepairOrderProcess;
import com.dt.platform.domain.eam.RepairOrderProcessVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 流转过程 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-04 06:54:32
 */
@FeignClient(value = ServiceNames.EAM, contextId = RepairOrderProcessServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface RepairOrderProcessServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-repair-order-process
     */
    public static final String API_CONTEXT_PATH = "eam-repair-order-process";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加流转过程
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除流转过程
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除流转过程
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新流转过程
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存流转过程
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个流转过程
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个流转过程
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询流转过程
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询流转过程
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加流转过程
     */
    @RequestMapping(RepairOrderProcessServiceProxy.INSERT)
    Result insert(@RequestParam(name = "repairOrderProcessVO") RepairOrderProcessVO repairOrderProcessVO);

    /**
     * 删除流转过程
     */
    @RequestMapping(RepairOrderProcessServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除流转过程
     */
    @RequestMapping(RepairOrderProcessServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新流转过程
     */
    @RequestMapping(RepairOrderProcessServiceProxy.UPDATE)
    Result update(@RequestParam(name = "repairOrderProcessVO") RepairOrderProcessVO repairOrderProcessVO);

    /**
     * 更新流转过程
     */
    @RequestMapping(RepairOrderProcessServiceProxy.SAVE)
    Result save(@RequestParam(name = "repairOrderProcessVO") RepairOrderProcessVO repairOrderProcessVO);

    /**
     * 获取流转过程
     */
    @RequestMapping(RepairOrderProcessServiceProxy.GET_BY_ID)
    Result<RepairOrderProcess> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个流转过程
     */
    @RequestMapping(RepairOrderProcessServiceProxy.GET_BY_IDS)
    Result<List<RepairOrderProcess>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询流转过程
     */
    @RequestMapping(RepairOrderProcessServiceProxy.QUERY_LIST)
    Result<List<RepairOrderProcess>> queryList(@RequestParam(name = "sample") RepairOrderProcessVO sample);

    /**
     * 分页查询流转过程
     */
    @RequestMapping(RepairOrderProcessServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<RepairOrderProcess>> queryPagedList(@RequestParam(name = "sample") RepairOrderProcessVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.RepairOrderProcessController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static RepairOrderProcessServiceProxy api() {
        return APIProxy.get(RepairOrderProcessServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
