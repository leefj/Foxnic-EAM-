package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.VirtEquipment;
import com.dt.platform.domain.eam.VirtEquipmentVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 虚拟设备 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-06 19:37:42
 */
@FeignClient(value = ServiceNames.EAM, contextId = VirtEquipmentServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface VirtEquipmentServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , iot-virt-equipment
     */
    public static final String API_CONTEXT_PATH = "iot-virt-equipment";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加虚拟设备
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除虚拟设备
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除虚拟设备
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新虚拟设备
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存虚拟设备
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个虚拟设备
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个虚拟设备
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询虚拟设备
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询虚拟设备
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加虚拟设备
     */
    @RequestMapping(VirtEquipmentServiceProxy.INSERT)
    Result insert(@RequestParam(name = "virtEquipmentVO") VirtEquipmentVO virtEquipmentVO);

    /**
     * 删除虚拟设备
     */
    @RequestMapping(VirtEquipmentServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除虚拟设备
     */
    @RequestMapping(VirtEquipmentServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新虚拟设备
     */
    @RequestMapping(VirtEquipmentServiceProxy.UPDATE)
    Result update(@RequestParam(name = "virtEquipmentVO") VirtEquipmentVO virtEquipmentVO);

    /**
     * 更新虚拟设备
     */
    @RequestMapping(VirtEquipmentServiceProxy.SAVE)
    Result save(@RequestParam(name = "virtEquipmentVO") VirtEquipmentVO virtEquipmentVO);

    /**
     * 获取虚拟设备
     */
    @RequestMapping(VirtEquipmentServiceProxy.GET_BY_ID)
    Result<VirtEquipment> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个虚拟设备
     */
    @RequestMapping(VirtEquipmentServiceProxy.GET_BY_IDS)
    Result<List<VirtEquipment>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询虚拟设备
     */
    @RequestMapping(VirtEquipmentServiceProxy.QUERY_LIST)
    Result<List<VirtEquipment>> queryList(@RequestParam(name = "sample") VirtEquipmentVO sample);

    /**
     * 分页查询虚拟设备
     */
    @RequestMapping(VirtEquipmentServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<VirtEquipment>> queryPagedList(@RequestParam(name = "sample") VirtEquipmentVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.VirtEquipmentController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static VirtEquipmentServiceProxy api() {
        return APIProxy.get(VirtEquipmentServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
