package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.VehicleInsuranceRecord;
import com.dt.platform.domain.oa.VehicleInsuranceRecordVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 车辆保险记录 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 14:07:55
 */
@FeignClient(value = ServiceNames.OA, contextId = VehicleInsuranceRecordServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface VehicleInsuranceRecordServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-vehicle-insurance-record
     */
    public static final String API_CONTEXT_PATH = "oa-vehicle-insurance-record";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加车辆保险记录
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除车辆保险记录
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除车辆保险记录
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新车辆保险记录
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存车辆保险记录
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个车辆保险记录
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个车辆保险记录
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询车辆保险记录
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询车辆保险记录
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加车辆保险记录
     */
    @RequestMapping(VehicleInsuranceRecordServiceProxy.INSERT)
    Result insert(@RequestParam(name = "vehicleInsuranceRecordVO") VehicleInsuranceRecordVO vehicleInsuranceRecordVO);

    /**
     * 删除车辆保险记录
     */
    @RequestMapping(VehicleInsuranceRecordServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除车辆保险记录
     */
    @RequestMapping(VehicleInsuranceRecordServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新车辆保险记录
     */
    @RequestMapping(VehicleInsuranceRecordServiceProxy.UPDATE)
    Result update(@RequestParam(name = "vehicleInsuranceRecordVO") VehicleInsuranceRecordVO vehicleInsuranceRecordVO);

    /**
     * 更新车辆保险记录
     */
    @RequestMapping(VehicleInsuranceRecordServiceProxy.SAVE)
    Result save(@RequestParam(name = "vehicleInsuranceRecordVO") VehicleInsuranceRecordVO vehicleInsuranceRecordVO);

    /**
     * 获取车辆保险记录
     */
    @RequestMapping(VehicleInsuranceRecordServiceProxy.GET_BY_ID)
    Result<VehicleInsuranceRecord> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个车辆保险记录
     */
    @RequestMapping(VehicleInsuranceRecordServiceProxy.GET_BY_IDS)
    Result<List<VehicleInsuranceRecord>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询车辆保险记录
     */
    @RequestMapping(VehicleInsuranceRecordServiceProxy.QUERY_LIST)
    Result<List<VehicleInsuranceRecord>> queryList(@RequestParam(name = "sample") VehicleInsuranceRecordVO sample);

    /**
     * 分页查询车辆保险记录
     */
    @RequestMapping(VehicleInsuranceRecordServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<VehicleInsuranceRecord>> queryPagedList(@RequestParam(name = "sample") VehicleInsuranceRecordVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.VehicleInsuranceRecordController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static VehicleInsuranceRecordServiceProxy api() {
        return APIProxy.get(VehicleInsuranceRecordServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
