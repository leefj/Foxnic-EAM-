package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.DeviceSpRcd;
import com.dt.platform.domain.eam.DeviceSpRcdVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 备件记录 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-15 10:53:23
 */
@FeignClient(value = ServiceNames.EAM, contextId = DeviceSpRcdServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface DeviceSpRcdServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-device-sp-rcd
     */
    public static final String API_CONTEXT_PATH = "eam-device-sp-rcd";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加备件记录
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除备件记录
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除备件记录
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新备件记录
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存备件记录
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个备件记录
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个备件记录
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询备件记录
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询备件记录
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加备件记录
     */
    @RequestMapping(DeviceSpRcdServiceProxy.INSERT)
    Result insert(@RequestParam(name = "deviceSpRcdVO") DeviceSpRcdVO deviceSpRcdVO);

    /**
     * 删除备件记录
     */
    @RequestMapping(DeviceSpRcdServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除备件记录
     */
    @RequestMapping(DeviceSpRcdServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新备件记录
     */
    @RequestMapping(DeviceSpRcdServiceProxy.UPDATE)
    Result update(@RequestParam(name = "deviceSpRcdVO") DeviceSpRcdVO deviceSpRcdVO);

    /**
     * 更新备件记录
     */
    @RequestMapping(DeviceSpRcdServiceProxy.SAVE)
    Result save(@RequestParam(name = "deviceSpRcdVO") DeviceSpRcdVO deviceSpRcdVO);

    /**
     * 获取备件记录
     */
    @RequestMapping(DeviceSpRcdServiceProxy.GET_BY_ID)
    Result<DeviceSpRcd> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个备件记录
     */
    @RequestMapping(DeviceSpRcdServiceProxy.GET_BY_IDS)
    Result<List<DeviceSpRcd>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询备件记录
     */
    @RequestMapping(DeviceSpRcdServiceProxy.QUERY_LIST)
    Result<List<DeviceSpRcd>> queryList(@RequestParam(name = "sample") DeviceSpRcdVO sample);

    /**
     * 分页查询备件记录
     */
    @RequestMapping(DeviceSpRcdServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<DeviceSpRcd>> queryPagedList(@RequestParam(name = "sample") DeviceSpRcdVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.DeviceSpRcdController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static DeviceSpRcdServiceProxy api() {
        return APIProxy.get(DeviceSpRcdServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
