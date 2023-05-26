package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.github.foxnic.web.proxy.bpm.BpmCallbackController;
import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.BpmFormData;
import com.dt.platform.domain.common.BpmFormDataVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 流程表单 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-25 19:09:34
 */
@FeignClient(value = ServiceNames.COMMON, contextId = BpmFormDataServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface BpmFormDataServiceProxy extends BpmCallbackController {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-bpm-form-data
     */
    public static final String API_CONTEXT_PATH = "sys-bpm-form-data";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加流程表单
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除流程表单
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除流程表单
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新流程表单
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存流程表单
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个流程表单
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个流程表单
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询流程表单
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询流程表单
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 流程事件回调接收接口
     */
    public static final String BPM_CALLBACK = API_PREFIX + "bpm-callback";

    /**
     * 添加流程表单
     */
    @RequestMapping(BpmFormDataServiceProxy.INSERT)
    Result insert(@RequestParam(name = "bpmFormDataVO") BpmFormDataVO bpmFormDataVO);

    /**
     * 删除流程表单
     */
    @RequestMapping(BpmFormDataServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除流程表单
     */
    @RequestMapping(BpmFormDataServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新流程表单
     */
    @RequestMapping(BpmFormDataServiceProxy.UPDATE)
    Result update(@RequestParam(name = "bpmFormDataVO") BpmFormDataVO bpmFormDataVO);

    /**
     * 更新流程表单
     */
    @RequestMapping(BpmFormDataServiceProxy.SAVE)
    Result save(@RequestParam(name = "bpmFormDataVO") BpmFormDataVO bpmFormDataVO);

    /**
     * 获取流程表单
     */
    @RequestMapping(BpmFormDataServiceProxy.GET_BY_ID)
    Result<BpmFormData> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个流程表单
     */
    @RequestMapping(BpmFormDataServiceProxy.GET_BY_IDS)
    Result<List<BpmFormData>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询流程表单
     */
    @RequestMapping(BpmFormDataServiceProxy.QUERY_LIST)
    Result<List<BpmFormData>> queryList(@RequestParam(name = "sample") BpmFormDataVO sample);

    /**
     * 分页查询流程表单
     */
    @RequestMapping(BpmFormDataServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<BpmFormData>> queryPagedList(@RequestParam(name = "sample") BpmFormDataVO sample);

    /**
     * 分页查询流程表单
     */
    @RequestMapping(BpmFormDataServiceProxy.BPM_CALLBACK)
    BpmActionResult onProcessCallback(@RequestParam(name = "event") BpmEvent event);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.BpmFormDataController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static BpmFormDataServiceProxy api() {
        return APIProxy.get(BpmFormDataServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
