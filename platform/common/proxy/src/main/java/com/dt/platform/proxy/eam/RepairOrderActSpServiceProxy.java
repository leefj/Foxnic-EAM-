package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.RepairOrderActSp;
import com.dt.platform.domain.eam.RepairOrderActSpVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 维修备件 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-17 15:16:56
 */
@FeignClient(value = ServiceNames.EAM, contextId = RepairOrderActSpServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface RepairOrderActSpServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-repair-order-act-sp
     */
    public static final String API_CONTEXT_PATH = "eam-repair-order-act-sp";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加维修备件
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除维修备件
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除维修备件
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新维修备件
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存维修备件
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个维修备件
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个维修备件
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询维修备件
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询维修备件
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 分页查询维修备件
     */
    public static final String QUERY_SELECTED_PAGED_LIST = API_PREFIX + "query-selected-paged-list";

    /**
     * 添加维修备件
     */
    @RequestMapping(RepairOrderActSpServiceProxy.INSERT)
    Result insert(@RequestParam(name = "repairOrderActSpVO") RepairOrderActSpVO repairOrderActSpVO);

    /**
     * 删除维修备件
     */
    @RequestMapping(RepairOrderActSpServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除维修备件
     */
    @RequestMapping(RepairOrderActSpServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新维修备件
     */
    @RequestMapping(RepairOrderActSpServiceProxy.UPDATE)
    Result update(@RequestParam(name = "repairOrderActSpVO") RepairOrderActSpVO repairOrderActSpVO);

    /**
     * 更新维修备件
     */
    @RequestMapping(RepairOrderActSpServiceProxy.SAVE)
    Result save(@RequestParam(name = "repairOrderActSpVO") RepairOrderActSpVO repairOrderActSpVO);

    /**
     * 获取维修备件
     */
    @RequestMapping(RepairOrderActSpServiceProxy.GET_BY_ID)
    Result<RepairOrderActSp> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个维修备件
     */
    @RequestMapping(RepairOrderActSpServiceProxy.GET_BY_IDS)
    Result<List<RepairOrderActSp>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询维修备件
     */
    @RequestMapping(RepairOrderActSpServiceProxy.QUERY_LIST)
    Result<List<RepairOrderActSp>> queryList(@RequestParam(name = "sample") RepairOrderActSpVO sample);

    /**
     * 分页查询维修备件
     */
    @RequestMapping(RepairOrderActSpServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<RepairOrderActSp>> queryPagedList(@RequestParam(name = "sample") RepairOrderActSpVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.RepairOrderActSpController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static RepairOrderActSpServiceProxy api() {
        return APIProxy.get(RepairOrderActSpServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
