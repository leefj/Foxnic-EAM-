package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.FormDataExt;
import com.dt.platform.domain.common.FormDataExtVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 数据扩展 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-26 20:03:45
 */
@FeignClient(value = ServiceNames.COMMON, contextId = FormDataExtServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface FormDataExtServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-form-data-ext
     */
    public static final String API_CONTEXT_PATH = "sys-form-data-ext";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加数据扩展
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除数据扩展
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除数据扩展
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新数据扩展
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存数据扩展
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个数据扩展
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个数据扩展
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询数据扩展
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询数据扩展
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加数据扩展
     */
    @RequestMapping(FormDataExtServiceProxy.INSERT)
    Result insert(@RequestParam(name = "formDataExtVO") FormDataExtVO formDataExtVO);

    /**
     * 删除数据扩展
     */
    @RequestMapping(FormDataExtServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除数据扩展
     */
    @RequestMapping(FormDataExtServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新数据扩展
     */
    @RequestMapping(FormDataExtServiceProxy.UPDATE)
    Result update(@RequestParam(name = "formDataExtVO") FormDataExtVO formDataExtVO);

    /**
     * 更新数据扩展
     */
    @RequestMapping(FormDataExtServiceProxy.SAVE)
    Result save(@RequestParam(name = "formDataExtVO") FormDataExtVO formDataExtVO);

    /**
     * 获取数据扩展
     */
    @RequestMapping(FormDataExtServiceProxy.GET_BY_ID)
    Result<FormDataExt> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个数据扩展
     */
    @RequestMapping(FormDataExtServiceProxy.GET_BY_IDS)
    Result<List<FormDataExt>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询数据扩展
     */
    @RequestMapping(FormDataExtServiceProxy.QUERY_LIST)
    Result<List<FormDataExt>> queryList(@RequestParam(name = "sample") FormDataExtVO sample);

    /**
     * 分页查询数据扩展
     */
    @RequestMapping(FormDataExtServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<FormDataExt>> queryPagedList(@RequestParam(name = "sample") FormDataExtVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.FormDataExtController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static FormDataExtServiceProxy api() {
        return APIProxy.get(FormDataExtServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
