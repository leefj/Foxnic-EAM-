package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.VehicleApply;
import com.dt.platform.domain.oa.VehicleApplyVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 车辆申请 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 16:02:14
 */
@FeignClient(value = ServiceNames.OA, contextId = VehicleApplyServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface VehicleApplyServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-vehicle-apply
     */
    public static final String API_CONTEXT_PATH = "oa-vehicle-apply";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加车辆申请
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除车辆申请
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除车辆申请
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新车辆申请
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存车辆申请
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个车辆申请
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个车辆申请
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询车辆申请
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询车辆申请
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加车辆申请
     */
    @RequestMapping(VehicleApplyServiceProxy.INSERT)
    Result insert(@RequestParam(name = "vehicleApplyVO") VehicleApplyVO vehicleApplyVO);

    /**
     * 删除车辆申请
     */
    @RequestMapping(VehicleApplyServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除车辆申请
     */
    @RequestMapping(VehicleApplyServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新车辆申请
     */
    @RequestMapping(VehicleApplyServiceProxy.UPDATE)
    Result update(@RequestParam(name = "vehicleApplyVO") VehicleApplyVO vehicleApplyVO);

    /**
     * 更新车辆申请
     */
    @RequestMapping(VehicleApplyServiceProxy.SAVE)
    Result save(@RequestParam(name = "vehicleApplyVO") VehicleApplyVO vehicleApplyVO);

    /**
     * 获取车辆申请
     */
    @RequestMapping(VehicleApplyServiceProxy.GET_BY_ID)
    Result<VehicleApply> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个车辆申请
     */
    @RequestMapping(VehicleApplyServiceProxy.GET_BY_IDS)
    Result<List<VehicleApply>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询车辆申请
     */
    @RequestMapping(VehicleApplyServiceProxy.QUERY_LIST)
    Result<List<VehicleApply>> queryList(@RequestParam(name = "sample") VehicleApplyVO sample);

    /**
     * 分页查询车辆申请
     */
    @RequestMapping(VehicleApplyServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<VehicleApply>> queryPagedList(@RequestParam(name = "sample") VehicleApplyVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.VehicleApplyController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static VehicleApplyServiceProxy api() {
        return APIProxy.get(VehicleApplyServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
