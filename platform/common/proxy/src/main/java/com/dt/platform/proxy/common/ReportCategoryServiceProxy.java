package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.ReportCategory;
import com.dt.platform.domain.common.ReportCategoryVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 报表分类 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-19 12:06:29
 */
@FeignClient(value = ServiceNames.COMMON, contextId = ReportCategoryServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ReportCategoryServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-report-category
     */
    public static final String API_CONTEXT_PATH = "sys-report-category";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加报表分类
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除报表分类
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除报表分类
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新报表分类
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存报表分类
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个报表分类
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个报表分类
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询报表分类
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询报表分类
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加报表分类
     */
    @RequestMapping(ReportCategoryServiceProxy.INSERT)
    Result insert(@RequestParam(name = "reportCategoryVO") ReportCategoryVO reportCategoryVO);

    /**
     * 删除报表分类
     */
    @RequestMapping(ReportCategoryServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除报表分类
     */
    @RequestMapping(ReportCategoryServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新报表分类
     */
    @RequestMapping(ReportCategoryServiceProxy.UPDATE)
    Result update(@RequestParam(name = "reportCategoryVO") ReportCategoryVO reportCategoryVO);

    /**
     * 更新报表分类
     */
    @RequestMapping(ReportCategoryServiceProxy.SAVE)
    Result save(@RequestParam(name = "reportCategoryVO") ReportCategoryVO reportCategoryVO);

    /**
     * 获取报表分类
     */
    @RequestMapping(ReportCategoryServiceProxy.GET_BY_ID)
    Result<ReportCategory> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个报表分类
     */
    @RequestMapping(ReportCategoryServiceProxy.GET_BY_IDS)
    Result<List<ReportCategory>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询报表分类
     */
    @RequestMapping(ReportCategoryServiceProxy.QUERY_LIST)
    Result<List<ReportCategory>> queryList(@RequestParam(name = "sample") ReportCategoryVO sample);

    /**
     * 分页查询报表分类
     */
    @RequestMapping(ReportCategoryServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ReportCategory>> queryPagedList(@RequestParam(name = "sample") ReportCategoryVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.ReportCategoryController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ReportCategoryServiceProxy api() {
        return APIProxy.get(ReportCategoryServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
