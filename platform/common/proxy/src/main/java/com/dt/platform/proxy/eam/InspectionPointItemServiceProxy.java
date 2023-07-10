package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.InspectionPointItem;
import com.dt.platform.domain.eam.InspectionPointItemVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 巡检点项 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-10 12:35:13
 */
@FeignClient(value = ServiceNames.EAM, contextId = InspectionPointItemServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface InspectionPointItemServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-inspection-point-item
     */
    public static final String API_CONTEXT_PATH = "eam-inspection-point-item";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加巡检点项
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除巡检点项
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除巡检点项
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新巡检点项
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存巡检点项
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个巡检点项
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个巡检点项
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询巡检点项
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询巡检点项
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加巡检点项
     */
    @RequestMapping(InspectionPointItemServiceProxy.INSERT)
    Result insert(@RequestParam(name = "inspectionPointItemVO") InspectionPointItemVO inspectionPointItemVO);

    /**
     * 删除巡检点项
     */
    @RequestMapping(InspectionPointItemServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除巡检点项
     */
    @RequestMapping(InspectionPointItemServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新巡检点项
     */
    @RequestMapping(InspectionPointItemServiceProxy.UPDATE)
    Result update(@RequestParam(name = "inspectionPointItemVO") InspectionPointItemVO inspectionPointItemVO);

    /**
     * 更新巡检点项
     */
    @RequestMapping(InspectionPointItemServiceProxy.SAVE)
    Result save(@RequestParam(name = "inspectionPointItemVO") InspectionPointItemVO inspectionPointItemVO);

    /**
     * 获取巡检点项
     */
    @RequestMapping(InspectionPointItemServiceProxy.GET_BY_ID)
    Result<InspectionPointItem> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个巡检点项
     */
    @RequestMapping(InspectionPointItemServiceProxy.GET_BY_IDS)
    Result<List<InspectionPointItem>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询巡检点项
     */
    @RequestMapping(InspectionPointItemServiceProxy.QUERY_LIST)
    Result<List<InspectionPointItem>> queryList(@RequestParam(name = "sample") InspectionPointItemVO sample);

    /**
     * 分页查询巡检点项
     */
    @RequestMapping(InspectionPointItemServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<InspectionPointItem>> queryPagedList(@RequestParam(name = "sample") InspectionPointItemVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.InspectionPointItemController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static InspectionPointItemServiceProxy api() {
        return APIProxy.get(InspectionPointItemServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
