package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.DeviceSpStatus;
import com.dt.platform.domain.eam.DeviceSpStatusVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 修改状态 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-15 11:18:48
 */
@FeignClient(value = ServiceNames.EAM, contextId = DeviceSpStatusServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface DeviceSpStatusServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-device-sp-status
     */
    public static final String API_CONTEXT_PATH = "eam-device-sp-status";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加修改状态
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除修改状态
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除修改状态
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新修改状态
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存修改状态
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个修改状态
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个修改状态
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询修改状态
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询修改状态
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加修改状态
     */
    @RequestMapping(DeviceSpStatusServiceProxy.INSERT)
    Result insert(@RequestParam(name = "deviceSpStatusVO") DeviceSpStatusVO deviceSpStatusVO);

    /**
     * 删除修改状态
     */
    @RequestMapping(DeviceSpStatusServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除修改状态
     */
    @RequestMapping(DeviceSpStatusServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新修改状态
     */
    @RequestMapping(DeviceSpStatusServiceProxy.UPDATE)
    Result update(@RequestParam(name = "deviceSpStatusVO") DeviceSpStatusVO deviceSpStatusVO);

    /**
     * 更新修改状态
     */
    @RequestMapping(DeviceSpStatusServiceProxy.SAVE)
    Result save(@RequestParam(name = "deviceSpStatusVO") DeviceSpStatusVO deviceSpStatusVO);

    /**
     * 获取修改状态
     */
    @RequestMapping(DeviceSpStatusServiceProxy.GET_BY_ID)
    Result<DeviceSpStatus> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个修改状态
     */
    @RequestMapping(DeviceSpStatusServiceProxy.GET_BY_IDS)
    Result<List<DeviceSpStatus>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询修改状态
     */
    @RequestMapping(DeviceSpStatusServiceProxy.QUERY_LIST)
    Result<List<DeviceSpStatus>> queryList(@RequestParam(name = "sample") DeviceSpStatusVO sample);

    /**
     * 分页查询修改状态
     */
    @RequestMapping(DeviceSpStatusServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<DeviceSpStatus>> queryPagedList(@RequestParam(name = "sample") DeviceSpStatusVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.DeviceSpStatusController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static DeviceSpStatusServiceProxy api() {
        return APIProxy.get(DeviceSpStatusServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
