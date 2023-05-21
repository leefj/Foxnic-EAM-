package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.FormCategory;
import com.dt.platform.domain.common.FormCategoryVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 表单类型 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-21 08:15:49
 */
@FeignClient(value = ServiceNames.COMMON, contextId = FormCategoryServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface FormCategoryServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-form-category
     */
    public static final String API_CONTEXT_PATH = "sys-form-category";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加表单类型
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除表单类型
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除表单类型
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新表单类型
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存表单类型
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个表单类型
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个表单类型
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询表单类型
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询表单类型
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加表单类型
     */
    @RequestMapping(FormCategoryServiceProxy.INSERT)
    Result insert(@RequestParam(name = "formCategoryVO") FormCategoryVO formCategoryVO);

    /**
     * 删除表单类型
     */
    @RequestMapping(FormCategoryServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除表单类型
     */
    @RequestMapping(FormCategoryServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新表单类型
     */
    @RequestMapping(FormCategoryServiceProxy.UPDATE)
    Result update(@RequestParam(name = "formCategoryVO") FormCategoryVO formCategoryVO);

    /**
     * 更新表单类型
     */
    @RequestMapping(FormCategoryServiceProxy.SAVE)
    Result save(@RequestParam(name = "formCategoryVO") FormCategoryVO formCategoryVO);

    /**
     * 获取表单类型
     */
    @RequestMapping(FormCategoryServiceProxy.GET_BY_ID)
    Result<FormCategory> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个表单类型
     */
    @RequestMapping(FormCategoryServiceProxy.GET_BY_IDS)
    Result<List<FormCategory>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询表单类型
     */
    @RequestMapping(FormCategoryServiceProxy.QUERY_LIST)
    Result<List<FormCategory>> queryList(@RequestParam(name = "sample") FormCategoryVO sample);

    /**
     * 分页查询表单类型
     */
    @RequestMapping(FormCategoryServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<FormCategory>> queryPagedList(@RequestParam(name = "sample") FormCategoryVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.FormCategoryController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static FormCategoryServiceProxy api() {
        return APIProxy.get(FormCategoryServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
