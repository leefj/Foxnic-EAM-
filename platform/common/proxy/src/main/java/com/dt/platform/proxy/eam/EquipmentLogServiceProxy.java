package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.EquipmentLog;
import com.dt.platform.domain.eam.EquipmentLogVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 设备日志 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-08 07:39:38
 */
@FeignClient(value = ServiceNames.EAM, contextId = EquipmentLogServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface EquipmentLogServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , iot-equipment-log
     */
    public static final String API_CONTEXT_PATH = "iot-equipment-log";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加设备日志
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除设备日志
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除设备日志
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新设备日志
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存设备日志
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个设备日志
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个设备日志
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询设备日志
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询设备日志
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加设备日志
     */
    @RequestMapping(EquipmentLogServiceProxy.INSERT)
    Result insert(@RequestParam(name = "equipmentLogVO") EquipmentLogVO equipmentLogVO);

    /**
     * 删除设备日志
     */
    @RequestMapping(EquipmentLogServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除设备日志
     */
    @RequestMapping(EquipmentLogServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新设备日志
     */
    @RequestMapping(EquipmentLogServiceProxy.UPDATE)
    Result update(@RequestParam(name = "equipmentLogVO") EquipmentLogVO equipmentLogVO);

    /**
     * 更新设备日志
     */
    @RequestMapping(EquipmentLogServiceProxy.SAVE)
    Result save(@RequestParam(name = "equipmentLogVO") EquipmentLogVO equipmentLogVO);

    /**
     * 获取设备日志
     */
    @RequestMapping(EquipmentLogServiceProxy.GET_BY_ID)
    Result<EquipmentLog> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个设备日志
     */
    @RequestMapping(EquipmentLogServiceProxy.GET_BY_IDS)
    Result<List<EquipmentLog>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询设备日志
     */
    @RequestMapping(EquipmentLogServiceProxy.QUERY_LIST)
    Result<List<EquipmentLog>> queryList(@RequestParam(name = "sample") EquipmentLogVO sample);

    /**
     * 分页查询设备日志
     */
    @RequestMapping(EquipmentLogServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<EquipmentLog>> queryPagedList(@RequestParam(name = "sample") EquipmentLogVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.EquipmentLogController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static EquipmentLogServiceProxy api() {
        return APIProxy.get(EquipmentLogServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
