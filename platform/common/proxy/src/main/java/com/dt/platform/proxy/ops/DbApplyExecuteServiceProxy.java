package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.DbApplyExecute;
import com.dt.platform.domain.ops.DbApplyExecuteVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 数据库操作执行 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-31 15:04:12
 */
@FeignClient(value = ServiceNames.OPS, contextId = DbApplyExecuteServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface DbApplyExecuteServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-db-apply-execute
     */
    public static final String API_CONTEXT_PATH = "ops-db-apply-execute";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加数据库操作执行
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除数据库操作执行
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除数据库操作执行
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新数据库操作执行
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存数据库操作执行
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个数据库操作执行
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个数据库操作执行
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询数据库操作执行
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询数据库操作执行
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 分页查询数据库操作执行
     */
    public static final String QUERY_ORDER_LIST = API_PREFIX + "query-order-list";


    /**
     * 分页查询数据库操作执行
     */
    public static final String QUERY_DB_LIST = API_PREFIX + "query-db-list";

    /**
     * 分页查询数据库操作执行
     */
    public static final String QUERY_CUR_ASSOCIATED_SYSTEM= API_PREFIX + "query-cur-associated-system";

    public static final String QUERY_DB_USER= API_PREFIX + "query-db-user";

    public static final String VALID_CONTENT= API_PREFIX + "valid-content";

    public static final String CREATE_RB= API_PREFIX + "create-rb";


    /**
     * 添加数据库操作执行
     */
    @RequestMapping(DbApplyExecuteServiceProxy.QUERY_CUR_ASSOCIATED_SYSTEM)
    String queryCurAssociatedSystem();

    /**
     * 添加数据库操作执行
     */
    @RequestMapping(DbApplyExecuteServiceProxy.INSERT)
    Result insert(@RequestParam(name = "dbApplyExecuteVO") DbApplyExecuteVO dbApplyExecuteVO);

    /**
     * 删除数据库操作执行
     */
    @RequestMapping(DbApplyExecuteServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除数据库操作执行
     */
    @RequestMapping(DbApplyExecuteServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新数据库操作执行
     */
    @RequestMapping(DbApplyExecuteServiceProxy.UPDATE)
    Result update(@RequestParam(name = "dbApplyExecuteVO") DbApplyExecuteVO dbApplyExecuteVO);

    /**
     * 更新数据库操作执行
     */
    @RequestMapping(DbApplyExecuteServiceProxy.SAVE)
    Result save(@RequestParam(name = "dbApplyExecuteVO") DbApplyExecuteVO dbApplyExecuteVO);

    /**
     * 获取数据库操作执行
     */
    @RequestMapping(DbApplyExecuteServiceProxy.GET_BY_ID)
    Result<DbApplyExecute> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个数据库操作执行
     */
    @RequestMapping(DbApplyExecuteServiceProxy.GET_BY_IDS)
    Result<List<DbApplyExecute>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询数据库操作执行
     */
    @RequestMapping(DbApplyExecuteServiceProxy.QUERY_LIST)
    Result<List<DbApplyExecute>> queryList(@RequestParam(name = "sample") DbApplyExecuteVO sample);

    /**
     * 分页查询数据库操作执行
     */
    @RequestMapping(DbApplyExecuteServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<DbApplyExecute>> queryPagedList(@RequestParam(name = "sample") DbApplyExecuteVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.DbApplyExecuteController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static DbApplyExecuteServiceProxy api() {
        return APIProxy.get(DbApplyExecuteServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
