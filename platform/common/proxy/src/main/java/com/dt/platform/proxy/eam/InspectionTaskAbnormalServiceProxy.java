package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.InspectionTaskAbnormal;
import com.dt.platform.domain.eam.InspectionTaskAbnormalVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 异常巡检任务单 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-22 21:58:40
 */
@FeignClient(value = ServiceNames.EAM, contextId = InspectionTaskAbnormalServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface InspectionTaskAbnormalServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-inspection-task-abnormal
     */
    public static final String API_CONTEXT_PATH = "eam-inspection-task-abnormal";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加异常巡检任务单
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除异常巡检任务单
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除异常巡检任务单
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新异常巡检任务单
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存异常巡检任务单
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个异常巡检任务单
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个异常巡检任务单
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询异常巡检任务单
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询异常巡检任务单
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加异常巡检任务单
     */
    @RequestMapping(InspectionTaskAbnormalServiceProxy.INSERT)
    Result insert(@RequestParam(name = "inspectionTaskAbnormalVO") InspectionTaskAbnormalVO inspectionTaskAbnormalVO);

    /**
     * 删除异常巡检任务单
     */
    @RequestMapping(InspectionTaskAbnormalServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除异常巡检任务单
     */
    @RequestMapping(InspectionTaskAbnormalServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新异常巡检任务单
     */
    @RequestMapping(InspectionTaskAbnormalServiceProxy.UPDATE)
    Result update(@RequestParam(name = "inspectionTaskAbnormalVO") InspectionTaskAbnormalVO inspectionTaskAbnormalVO);

    /**
     * 更新异常巡检任务单
     */
    @RequestMapping(InspectionTaskAbnormalServiceProxy.SAVE)
    Result save(@RequestParam(name = "inspectionTaskAbnormalVO") InspectionTaskAbnormalVO inspectionTaskAbnormalVO);

    /**
     * 获取异常巡检任务单
     */
    @RequestMapping(InspectionTaskAbnormalServiceProxy.GET_BY_ID)
    Result<InspectionTaskAbnormal> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个异常巡检任务单
     */
    @RequestMapping(InspectionTaskAbnormalServiceProxy.GET_BY_IDS)
    Result<List<InspectionTaskAbnormal>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询异常巡检任务单
     */
    @RequestMapping(InspectionTaskAbnormalServiceProxy.QUERY_LIST)
    Result<List<InspectionTaskAbnormal>> queryList(@RequestParam(name = "sample") InspectionTaskAbnormalVO sample);

    /**
     * 分页查询异常巡检任务单
     */
    @RequestMapping(InspectionTaskAbnormalServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<InspectionTaskAbnormal>> queryPagedList(@RequestParam(name = "sample") InspectionTaskAbnormalVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.InspectionTaskAbnormalController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static InspectionTaskAbnormalServiceProxy api() {
        return APIProxy.get(InspectionTaskAbnormalServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
