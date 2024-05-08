package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.Equipment;
import com.dt.platform.domain.eam.EquipmentVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 设备列 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-08 07:36:19
 */
@FeignClient(value = ServiceNames.EAM, contextId = EquipmentServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface EquipmentServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , iot-equipment
     */
    public static final String API_CONTEXT_PATH = "iot-equipment";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加设备列
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除设备列
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除设备列
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新设备列
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存设备列
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个设备列
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个设备列
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询设备列
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询设备列
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加设备列
     */
    @RequestMapping(EquipmentServiceProxy.INSERT)
    Result insert(@RequestParam(name = "equipmentVO") EquipmentVO equipmentVO);

    /**
     * 删除设备列
     */
    @RequestMapping(EquipmentServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除设备列
     */
    @RequestMapping(EquipmentServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新设备列
     */
    @RequestMapping(EquipmentServiceProxy.UPDATE)
    Result update(@RequestParam(name = "equipmentVO") EquipmentVO equipmentVO);

    /**
     * 更新设备列
     */
    @RequestMapping(EquipmentServiceProxy.SAVE)
    Result save(@RequestParam(name = "equipmentVO") EquipmentVO equipmentVO);

    /**
     * 获取设备列
     */
    @RequestMapping(EquipmentServiceProxy.GET_BY_ID)
    Result<Equipment> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个设备列
     */
    @RequestMapping(EquipmentServiceProxy.GET_BY_IDS)
    Result<List<Equipment>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询设备列
     */
    @RequestMapping(EquipmentServiceProxy.QUERY_LIST)
    Result<List<Equipment>> queryList(@RequestParam(name = "sample") EquipmentVO sample);

    /**
     * 分页查询设备列
     */
    @RequestMapping(EquipmentServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Equipment>> queryPagedList(@RequestParam(name = "sample") EquipmentVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.EquipmentController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static EquipmentServiceProxy api() {
        return APIProxy.get(EquipmentServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}