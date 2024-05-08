package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.DbApplyFile;
import com.dt.platform.domain.ops.DbApplyFileVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 附件 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-29 22:49:32
 */
@FeignClient(value = ServiceNames.OPS, contextId = DbApplyFileServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface DbApplyFileServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-db-apply-file
     */
    public static final String API_CONTEXT_PATH = "ops-db-apply-file";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加附件
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除附件
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除附件
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新附件
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存附件
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个附件
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个附件
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询附件
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询附件
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加附件
     */
    @RequestMapping(DbApplyFileServiceProxy.INSERT)
    Result insert(@RequestParam(name = "dbApplyFileVO") DbApplyFileVO dbApplyFileVO);

    /**
     * 删除附件
     */
    @RequestMapping(DbApplyFileServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除附件
     */
    @RequestMapping(DbApplyFileServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新附件
     */
    @RequestMapping(DbApplyFileServiceProxy.UPDATE)
    Result update(@RequestParam(name = "dbApplyFileVO") DbApplyFileVO dbApplyFileVO);

    /**
     * 更新附件
     */
    @RequestMapping(DbApplyFileServiceProxy.SAVE)
    Result save(@RequestParam(name = "dbApplyFileVO") DbApplyFileVO dbApplyFileVO);

    /**
     * 获取附件
     */
    @RequestMapping(DbApplyFileServiceProxy.GET_BY_ID)
    Result<DbApplyFile> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个附件
     */
    @RequestMapping(DbApplyFileServiceProxy.GET_BY_IDS)
    Result<List<DbApplyFile>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询附件
     */
    @RequestMapping(DbApplyFileServiceProxy.QUERY_LIST)
    Result<List<DbApplyFile>> queryList(@RequestParam(name = "sample") DbApplyFileVO sample);

    /**
     * 分页查询附件
     */
    @RequestMapping(DbApplyFileServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<DbApplyFile>> queryPagedList(@RequestParam(name = "sample") DbApplyFileVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.DbApplyFileController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static DbApplyFileServiceProxy api() {
        return APIProxy.get(DbApplyFileServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}