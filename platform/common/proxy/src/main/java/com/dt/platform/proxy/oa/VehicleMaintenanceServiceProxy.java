package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.VehicleMaintenance;
import com.dt.platform.domain.oa.VehicleMaintenanceVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 车辆维修保养 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 16:04:49
 */
@FeignClient(value = ServiceNames.OA, contextId = VehicleMaintenanceServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface VehicleMaintenanceServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-vehicle-maintenance
     */
    public static final String API_CONTEXT_PATH = "oa-vehicle-maintenance";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加车辆维修保养
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除车辆维修保养
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除车辆维修保养
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新车辆维修保养
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存车辆维修保养
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个车辆维修保养
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个车辆维修保养
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询车辆维修保养
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询车辆维修保养
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加车辆维修保养
     */
    @RequestMapping(VehicleMaintenanceServiceProxy.INSERT)
    Result insert(@RequestParam(name = "vehicleMaintenanceVO") VehicleMaintenanceVO vehicleMaintenanceVO);

    /**
     * 删除车辆维修保养
     */
    @RequestMapping(VehicleMaintenanceServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除车辆维修保养
     */
    @RequestMapping(VehicleMaintenanceServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新车辆维修保养
     */
    @RequestMapping(VehicleMaintenanceServiceProxy.UPDATE)
    Result update(@RequestParam(name = "vehicleMaintenanceVO") VehicleMaintenanceVO vehicleMaintenanceVO);

    /**
     * 更新车辆维修保养
     */
    @RequestMapping(VehicleMaintenanceServiceProxy.SAVE)
    Result save(@RequestParam(name = "vehicleMaintenanceVO") VehicleMaintenanceVO vehicleMaintenanceVO);

    /**
     * 获取车辆维修保养
     */
    @RequestMapping(VehicleMaintenanceServiceProxy.GET_BY_ID)
    Result<VehicleMaintenance> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个车辆维修保养
     */
    @RequestMapping(VehicleMaintenanceServiceProxy.GET_BY_IDS)
    Result<List<VehicleMaintenance>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询车辆维修保养
     */
    @RequestMapping(VehicleMaintenanceServiceProxy.QUERY_LIST)
    Result<List<VehicleMaintenance>> queryList(@RequestParam(name = "sample") VehicleMaintenanceVO sample);

    /**
     * 分页查询车辆维修保养
     */
    @RequestMapping(VehicleMaintenanceServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<VehicleMaintenance>> queryPagedList(@RequestParam(name = "sample") VehicleMaintenanceVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.VehicleMaintenanceController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static VehicleMaintenanceServiceProxy api() {
        return APIProxy.get(VehicleMaintenanceServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
