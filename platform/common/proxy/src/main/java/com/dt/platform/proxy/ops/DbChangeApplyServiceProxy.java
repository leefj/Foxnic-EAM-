package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.DbChangeApply;
import com.dt.platform.domain.ops.DbChangeApplyVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 数据库变更申请 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-31 15:10:36
 */
@FeignClient(value = ServiceNames.OPS, contextId = DbChangeApplyServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface DbChangeApplyServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-db-change-apply
     */
    public static final String API_CONTEXT_PATH = "ops-db-change-apply";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加数据库变更申请
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除数据库变更申请
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除数据库变更申请
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新数据库变更申请
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存数据库变更申请
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个数据库变更申请
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个数据库变更申请
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询数据库变更申请
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询数据库变更申请
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 分页查询变更数据库
     */
    public static final String SUBMIT = API_PREFIX + "submit";

    public static final String VALID = API_PREFIX + "valid";

    public static final String CREATE_RB = API_PREFIX + "create-rb";

    /**
     * 添加数据库变更申请
     */
    @RequestMapping(DbChangeApplyServiceProxy.INSERT)
    Result insert(@RequestParam(name = "dbChangeApplyVO") DbChangeApplyVO dbChangeApplyVO);

    /**
     * 删除数据库变更申请
     */
    @RequestMapping(DbChangeApplyServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除数据库变更申请
     */
    @RequestMapping(DbChangeApplyServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新数据库变更申请
     */
    @RequestMapping(DbChangeApplyServiceProxy.UPDATE)
    Result update(@RequestParam(name = "dbChangeApplyVO") DbChangeApplyVO dbChangeApplyVO);

    /**
     * 更新数据库变更申请
     */
    @RequestMapping(DbChangeApplyServiceProxy.SAVE)
    Result save(@RequestParam(name = "dbChangeApplyVO") DbChangeApplyVO dbChangeApplyVO);

    /**
     * 获取数据库变更申请
     */
    @RequestMapping(DbChangeApplyServiceProxy.GET_BY_ID)
    Result<DbChangeApply> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个数据库变更申请
     */
    @RequestMapping(DbChangeApplyServiceProxy.GET_BY_IDS)
    Result<List<DbChangeApply>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询数据库变更申请
     */
    @RequestMapping(DbChangeApplyServiceProxy.QUERY_LIST)
    Result<List<DbChangeApply>> queryList(@RequestParam(name = "sample") DbChangeApplyVO sample);

    /**
     * 分页查询数据库变更申请
     */
    @RequestMapping(DbChangeApplyServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<DbChangeApply>> queryPagedList(@RequestParam(name = "sample") DbChangeApplyVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.DbChangeApplyController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static DbChangeApplyServiceProxy api() {
        return APIProxy.get(DbChangeApplyServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
