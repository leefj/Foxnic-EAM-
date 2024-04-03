package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.DbInfoApply;
import com.dt.platform.domain.ops.DbInfoApplyVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 变更数据库 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-31 15:11:46
 */
@FeignClient(value = ServiceNames.OPS, contextId = DbInfoApplyServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface DbInfoApplyServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-db-info-apply
     */
    public static final String API_CONTEXT_PATH = "ops-db-info-apply";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加变更数据库
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除变更数据库
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除变更数据库
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新变更数据库
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存变更数据库
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个变更数据库
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个变更数据库
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询变更数据库
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询变更数据库
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 分页查询变更数据库
     */
    public static final String QUERY_EXECUTE_DB_PAGED_LIST = API_PREFIX + "query-execute-db-paged-list";


    /**
     * 添加变更数据库
     */
    @RequestMapping(DbInfoApplyServiceProxy.INSERT)
    Result insert(@RequestParam(name = "dbInfoApplyVO") DbInfoApplyVO dbInfoApplyVO);

    /**
     * 删除变更数据库
     */
    @RequestMapping(DbInfoApplyServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除变更数据库
     */
    @RequestMapping(DbInfoApplyServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新变更数据库
     */
    @RequestMapping(DbInfoApplyServiceProxy.UPDATE)
    Result update(@RequestParam(name = "dbInfoApplyVO") DbInfoApplyVO dbInfoApplyVO);

    /**
     * 更新变更数据库
     */
    @RequestMapping(DbInfoApplyServiceProxy.SAVE)
    Result save(@RequestParam(name = "dbInfoApplyVO") DbInfoApplyVO dbInfoApplyVO);

    /**
     * 获取变更数据库
     */
    @RequestMapping(DbInfoApplyServiceProxy.GET_BY_ID)
    Result<DbInfoApply> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个变更数据库
     */
    @RequestMapping(DbInfoApplyServiceProxy.GET_BY_IDS)
    Result<List<DbInfoApply>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询变更数据库
     */
    @RequestMapping(DbInfoApplyServiceProxy.QUERY_LIST)
    Result<List<DbInfoApply>> queryList(@RequestParam(name = "sample") DbInfoApplyVO sample);

    /**
     * 分页查询变更数据库
     */
    @RequestMapping(DbInfoApplyServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<DbInfoApply>> queryPagedList(@RequestParam(name = "sample") DbInfoApplyVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.DbInfoApplyController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static DbInfoApplyServiceProxy api() {
        return APIProxy.get(DbInfoApplyServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
