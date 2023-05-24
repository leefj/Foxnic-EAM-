package com.dt.platform.proxy.common;

import com.dt.platform.domain.common.FormData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.FormInfo;
import com.dt.platform.domain.common.FormInfoVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 表单信息 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-21 09:06:10
 */
@FeignClient(value = ServiceNames.COMMON, contextId = FormInfoServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface FormInfoServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-form-info
     */
    public static final String API_CONTEXT_PATH = "sys-form-info";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加表单信息
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除表单信息
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除表单信息
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新表单信息
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存表单信息
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个表单信息
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个表单信息
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询表单信息
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询表单信息
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 分页查询表单信息
     */
    public static final String COPY_DATA = API_PREFIX + "copy-data";

    public static final String CREATE_FORM = API_PREFIX + "create-form";

    public static final String SAVE_FORM_DATA = API_PREFIX + "save-form-data";


    public static final String CREATE_FORM_BY_CODE = API_PREFIX + "create-form-by-code";

    Result<FormData> createFormByCode(String id);


    @RequestMapping(FormInfoServiceProxy.CREATE_FORM)
    Result<FormData> createForm(String id);


    @RequestMapping(FormInfoServiceProxy.SAVE_FORM_DATA)
    Result saveFormData(FormData formData);

    /**
     * 添加表单信息
     */
    @RequestMapping(FormInfoServiceProxy.INSERT)
    Result insert(@RequestParam(name = "formInfoVO") FormInfoVO formInfoVO);

    /**
     * 删除表单信息
     */
    @RequestMapping(FormInfoServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除表单信息
     */
    @RequestMapping(FormInfoServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新表单信息
     */
    @RequestMapping(FormInfoServiceProxy.UPDATE)
    Result update(@RequestParam(name = "formInfoVO") FormInfoVO formInfoVO);

    /**
     * 更新表单信息
     */
    @RequestMapping(FormInfoServiceProxy.SAVE)
    Result save(@RequestParam(name = "formInfoVO") FormInfoVO formInfoVO);

    /**
     * 获取表单信息
     */
    @RequestMapping(FormInfoServiceProxy.GET_BY_ID)
    Result<FormInfo> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个表单信息
     */
    @RequestMapping(FormInfoServiceProxy.GET_BY_IDS)
    Result<List<FormInfo>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询表单信息
     */
    @RequestMapping(FormInfoServiceProxy.QUERY_LIST)
    Result<List<FormInfo>> queryList(@RequestParam(name = "sample") FormInfoVO sample);

    /**
     * 分页查询表单信息
     */
    @RequestMapping(FormInfoServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<FormInfo>> queryPagedList(@RequestParam(name = "sample") FormInfoVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.FormInfoController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static FormInfoServiceProxy api() {
        return APIProxy.get(FormInfoServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
