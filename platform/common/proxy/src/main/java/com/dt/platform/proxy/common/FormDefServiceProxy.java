package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.FormDef;
import com.dt.platform.domain.common.FormDefVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 表单定义 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-21 12:56:31
 */
@FeignClient(value = ServiceNames.COMMON, contextId = FormDefServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface FormDefServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-form-def
     */
    public static final String API_CONTEXT_PATH = "sys-form-def";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加表单定义
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除表单定义
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除表单定义
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新表单定义
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存表单定义
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个表单定义
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个表单定义
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询表单定义
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询表单定义
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 分页查询表单定义
     */
    public static final String COPY_DATA = API_PREFIX + "copy-data";

    /**
     * 分页查询表单定义
     */
    public static final String APPLY = API_PREFIX + "apply";

    /**
     * 分页查询表单定义
     */
    public static final String SAVE_FORM_BY_ID = API_PREFIX + "save-form-by-id";


    /**
     * 添加表单定义
     */
    @RequestMapping(FormDefServiceProxy.INSERT)
    Result insert(@RequestParam(name = "formDefVO") FormDefVO formDefVO);

    /**
     * 删除表单定义
     */
    @RequestMapping(FormDefServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除表单定义
     */
    @RequestMapping(FormDefServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新表单定义
     */
    @RequestMapping(FormDefServiceProxy.UPDATE)
    Result update(@RequestParam(name = "formDefVO") FormDefVO formDefVO);

    /**
     * 更新表单定义
     */
    @RequestMapping(FormDefServiceProxy.SAVE)
    Result save(@RequestParam(name = "formDefVO") FormDefVO formDefVO);

    /**
     * 获取表单定义
     */
    @RequestMapping(FormDefServiceProxy.GET_BY_ID)
    Result<FormDef> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个表单定义
     */
    @RequestMapping(FormDefServiceProxy.GET_BY_IDS)
    Result<List<FormDef>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询表单定义
     */
    @RequestMapping(FormDefServiceProxy.QUERY_LIST)
    Result<List<FormDef>> queryList(@RequestParam(name = "sample") FormDefVO sample);

    /**
     * 分页查询表单定义
     */
    @RequestMapping(FormDefServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<FormDef>> queryPagedList(@RequestParam(name = "sample") FormDefVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.FormDefController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static FormDefServiceProxy api() {
        return APIProxy.get(FormDefServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
