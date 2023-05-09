package com.dt.platform.proxy.vehicle;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.vehicle.Record;
import com.dt.platform.domain.vehicle.RecordVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 使用记录 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-09 12:47:55
 */
@FeignClient(value = ServiceNames.VEHICLE, contextId = RecordServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface RecordServiceProxy {

    /**
     * 基础路径 , service-vehicle
     */
    public static final String API_BASIC_PATH = "service-vehicle";

    /**
     * API 上下文路径 , oa-room-record
     */
    public static final String API_CONTEXT_PATH = "oa-room-record";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加使用记录
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除使用记录
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除使用记录
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新使用记录
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存使用记录
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个使用记录
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个使用记录
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询使用记录
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询使用记录
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加使用记录
     */
    @RequestMapping(RecordServiceProxy.INSERT)
    Result insert(@RequestParam(name = "recordVO") RecordVO recordVO);

    /**
     * 删除使用记录
     */
    @RequestMapping(RecordServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除使用记录
     */
    @RequestMapping(RecordServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新使用记录
     */
    @RequestMapping(RecordServiceProxy.UPDATE)
    Result update(@RequestParam(name = "recordVO") RecordVO recordVO);

    /**
     * 更新使用记录
     */
    @RequestMapping(RecordServiceProxy.SAVE)
    Result save(@RequestParam(name = "recordVO") RecordVO recordVO);

    /**
     * 获取使用记录
     */
    @RequestMapping(RecordServiceProxy.GET_BY_ID)
    Result<Record> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个使用记录
     */
    @RequestMapping(RecordServiceProxy.GET_BY_IDS)
    Result<List<Record>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询使用记录
     */
    @RequestMapping(RecordServiceProxy.QUERY_LIST)
    Result<List<Record>> queryList(@RequestParam(name = "sample") RecordVO sample);

    /**
     * 分页查询使用记录
     */
    @RequestMapping(RecordServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Record>> queryPagedList(@RequestParam(name = "sample") RecordVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.vehicle.controller.RecordController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static RecordServiceProxy api() {
        return APIProxy.get(RecordServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
