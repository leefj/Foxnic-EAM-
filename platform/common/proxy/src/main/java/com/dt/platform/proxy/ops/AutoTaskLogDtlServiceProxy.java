package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.AutoTaskLogDtl;
import com.dt.platform.domain.ops.AutoTaskLogDtlVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 明细日志 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-01 15:48:22
 */
@FeignClient(value = ServiceNames.OPS, contextId = AutoTaskLogDtlServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AutoTaskLogDtlServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-auto-task-log-dtl
     */
    public static final String API_CONTEXT_PATH = "ops-auto-task-log-dtl";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加明细日志
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除明细日志
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除明细日志
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新明细日志
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存明细日志
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个明细日志
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个明细日志
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询明细日志
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询明细日志
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加明细日志
     */
    @RequestMapping(AutoTaskLogDtlServiceProxy.INSERT)
    Result insert(@RequestParam(name = "autoTaskLogDtlVO") AutoTaskLogDtlVO autoTaskLogDtlVO);

    /**
     * 删除明细日志
     */
    @RequestMapping(AutoTaskLogDtlServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除明细日志
     */
    @RequestMapping(AutoTaskLogDtlServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新明细日志
     */
    @RequestMapping(AutoTaskLogDtlServiceProxy.UPDATE)
    Result update(@RequestParam(name = "autoTaskLogDtlVO") AutoTaskLogDtlVO autoTaskLogDtlVO);

    /**
     * 更新明细日志
     */
    @RequestMapping(AutoTaskLogDtlServiceProxy.SAVE)
    Result save(@RequestParam(name = "autoTaskLogDtlVO") AutoTaskLogDtlVO autoTaskLogDtlVO);

    /**
     * 获取明细日志
     */
    @RequestMapping(AutoTaskLogDtlServiceProxy.GET_BY_ID)
    Result<AutoTaskLogDtl> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个明细日志
     */
    @RequestMapping(AutoTaskLogDtlServiceProxy.GET_BY_IDS)
    Result<List<AutoTaskLogDtl>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询明细日志
     */
    @RequestMapping(AutoTaskLogDtlServiceProxy.QUERY_LIST)
    Result<List<AutoTaskLogDtl>> queryList(@RequestParam(name = "sample") AutoTaskLogDtlVO sample);

    /**
     * 分页查询明细日志
     */
    @RequestMapping(AutoTaskLogDtlServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AutoTaskLogDtl>> queryPagedList(@RequestParam(name = "sample") AutoTaskLogDtlVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.AutoTaskLogDtlController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AutoTaskLogDtlServiceProxy api() {
        return APIProxy.get(AutoTaskLogDtlServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
