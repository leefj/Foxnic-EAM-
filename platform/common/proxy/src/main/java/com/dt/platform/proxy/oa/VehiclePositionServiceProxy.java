package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.VehiclePosition;
import com.dt.platform.domain.oa.VehiclePositionVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 车辆位置 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 13:44:22
 */
@FeignClient(value = ServiceNames.OA, contextId = VehiclePositionServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface VehiclePositionServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-vehicle-position
     */
    public static final String API_CONTEXT_PATH = "oa-vehicle-position";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加车辆位置
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除车辆位置
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除车辆位置
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新车辆位置
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存车辆位置
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个车辆位置
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个车辆位置
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询车辆位置
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询车辆位置
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加车辆位置
     */
    @RequestMapping(VehiclePositionServiceProxy.INSERT)
    Result insert(@RequestParam(name = "vehiclePositionVO") VehiclePositionVO vehiclePositionVO);

    /**
     * 删除车辆位置
     */
    @RequestMapping(VehiclePositionServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除车辆位置
     */
    @RequestMapping(VehiclePositionServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新车辆位置
     */
    @RequestMapping(VehiclePositionServiceProxy.UPDATE)
    Result update(@RequestParam(name = "vehiclePositionVO") VehiclePositionVO vehiclePositionVO);

    /**
     * 更新车辆位置
     */
    @RequestMapping(VehiclePositionServiceProxy.SAVE)
    Result save(@RequestParam(name = "vehiclePositionVO") VehiclePositionVO vehiclePositionVO);

    /**
     * 获取车辆位置
     */
    @RequestMapping(VehiclePositionServiceProxy.GET_BY_ID)
    Result<VehiclePosition> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个车辆位置
     */
    @RequestMapping(VehiclePositionServiceProxy.GET_BY_IDS)
    Result<List<VehiclePosition>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询车辆位置
     */
    @RequestMapping(VehiclePositionServiceProxy.QUERY_LIST)
    Result<List<VehiclePosition>> queryList(@RequestParam(name = "sample") VehiclePositionVO sample);

    /**
     * 分页查询车辆位置
     */
    @RequestMapping(VehiclePositionServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<VehiclePosition>> queryPagedList(@RequestParam(name = "sample") VehiclePositionVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.VehiclePositionController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static VehiclePositionServiceProxy api() {
        return APIProxy.get(VehiclePositionServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
