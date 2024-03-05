package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.InspectionProcessAction;
import com.dt.platform.domain.eam.InspectionProcessActionVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 处理方式 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-05 10:15:22
 */
@FeignClient(value = ServiceNames.EAM, contextId = InspectionProcessActionServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface InspectionProcessActionServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-inspection-process-action
     */
    public static final String API_CONTEXT_PATH = "eam-inspection-process-action";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加处理方式
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除处理方式
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除处理方式
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新处理方式
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存处理方式
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个处理方式
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个处理方式
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询处理方式
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询处理方式
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加处理方式
     */
    @RequestMapping(InspectionProcessActionServiceProxy.INSERT)
    Result insert(@RequestParam(name = "inspectionProcessActionVO") InspectionProcessActionVO inspectionProcessActionVO);

    /**
     * 删除处理方式
     */
    @RequestMapping(InspectionProcessActionServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除处理方式
     */
    @RequestMapping(InspectionProcessActionServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新处理方式
     */
    @RequestMapping(InspectionProcessActionServiceProxy.UPDATE)
    Result update(@RequestParam(name = "inspectionProcessActionVO") InspectionProcessActionVO inspectionProcessActionVO);

    /**
     * 更新处理方式
     */
    @RequestMapping(InspectionProcessActionServiceProxy.SAVE)
    Result save(@RequestParam(name = "inspectionProcessActionVO") InspectionProcessActionVO inspectionProcessActionVO);

    /**
     * 获取处理方式
     */
    @RequestMapping(InspectionProcessActionServiceProxy.GET_BY_ID)
    Result<InspectionProcessAction> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个处理方式
     */
    @RequestMapping(InspectionProcessActionServiceProxy.GET_BY_IDS)
    Result<List<InspectionProcessAction>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询处理方式
     */
    @RequestMapping(InspectionProcessActionServiceProxy.QUERY_LIST)
    Result<List<InspectionProcessAction>> queryList(@RequestParam(name = "sample") InspectionProcessActionVO sample);

    /**
     * 分页查询处理方式
     */
    @RequestMapping(InspectionProcessActionServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<InspectionProcessAction>> queryPagedList(@RequestParam(name = "sample") InspectionProcessActionVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.InspectionProcessActionController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static InspectionProcessActionServiceProxy api() {
        return APIProxy.get(InspectionProcessActionServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
