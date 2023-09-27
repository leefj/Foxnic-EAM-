package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.NetdiskRecycle;
import com.dt.platform.domain.oa.NetdiskRecycleVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 回收站 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-18 20:48:14
 */
@FeignClient(value = ServiceNames.OA, contextId = NetdiskRecycleServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface NetdiskRecycleServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-netdisk-recycle
     */
    public static final String API_CONTEXT_PATH = "oa-netdisk-recycle";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加回收站
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除回收站
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除回收站
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新回收站
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存回收站
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个回收站
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个回收站
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询回收站
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询回收站
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";


    /**
     * 分页查询回收站
     */
    public static final String RESTORE = API_PREFIX + "restore";

    /**
     * 清空回收站
     */
    public static final String CLEAR_RECYCLE= API_PREFIX + "clear-recycle";

    /**
     * 清空回收站
     */
    public static final String CLEAR_RECYCLE_BY_IDS= API_PREFIX + "clear-recycle-by-ids";

    /**
     * 添加回收站
     */
    @RequestMapping(NetdiskRecycleServiceProxy.INSERT)
    Result insert(@RequestParam(name = "netdiskRecycleVO") NetdiskRecycleVO netdiskRecycleVO);

    /**
     * 删除回收站
     */
    @RequestMapping(NetdiskRecycleServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除回收站
     */
    @RequestMapping(NetdiskRecycleServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新回收站
     */
    @RequestMapping(NetdiskRecycleServiceProxy.UPDATE)
    Result update(@RequestParam(name = "netdiskRecycleVO") NetdiskRecycleVO netdiskRecycleVO);

    /**
     * 更新回收站
     */
    @RequestMapping(NetdiskRecycleServiceProxy.SAVE)
    Result save(@RequestParam(name = "netdiskRecycleVO") NetdiskRecycleVO netdiskRecycleVO);

    /**
     * 获取回收站
     */
    @RequestMapping(NetdiskRecycleServiceProxy.GET_BY_ID)
    Result<NetdiskRecycle> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个回收站
     */
    @RequestMapping(NetdiskRecycleServiceProxy.GET_BY_IDS)
    Result<List<NetdiskRecycle>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询回收站
     */
    @RequestMapping(NetdiskRecycleServiceProxy.QUERY_LIST)
    Result<List<NetdiskRecycle>> queryList(@RequestParam(name = "sample") NetdiskRecycleVO sample);

    /**
     * 分页查询回收站
     */
    @RequestMapping(NetdiskRecycleServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<NetdiskRecycle>> queryPagedList(@RequestParam(name = "sample") NetdiskRecycleVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.NetdiskRecycleController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static NetdiskRecycleServiceProxy api() {
        return APIProxy.get(NetdiskRecycleServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
