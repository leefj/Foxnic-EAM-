package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.InspectionTask;
import com.dt.platform.domain.eam.InspectionTaskVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 巡检任务  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-13 10:28:04
 */
@FeignClient(value = ServiceNames.EAM, contextId = InspectionTaskServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface InspectionTaskServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-inspection-task
     */
    public static final String API_CONTEXT_PATH = "eam-inspection-task";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加巡检任务
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除巡检任务
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除巡检任务
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新巡检任务
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存巡检任务
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个巡检任务
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";


    public static final String EXECUTE = API_PREFIX + "execute";
    public static final String CANCEL = API_PREFIX + "cancel";
    public static final String FINISH = API_PREFIX + "finish";
    public static final String CHECK = API_PREFIX + "check";




    public static final String QUERY_DATA_BY_CAL = API_PREFIX + "query-data-by-cal";


    /**
     * 获取多个巡检任务
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询巡检任务
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询巡检任务
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出巡检任务数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载巡检任务导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入巡检任务数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";



    /**
     * 添加巡检任务
     */
    @RequestMapping(InspectionTaskServiceProxy.INSERT)
    Result insert(@RequestParam(name = "inspectionTaskVO") InspectionTaskVO inspectionTaskVO);

    /**
     * 删除巡检任务
     */
    @RequestMapping(InspectionTaskServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除巡检任务
     */
    @RequestMapping(InspectionTaskServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新巡检任务
     */
    @RequestMapping(InspectionTaskServiceProxy.UPDATE)
    Result update(@RequestParam(name = "inspectionTaskVO") InspectionTaskVO inspectionTaskVO);

    /**
     * 更新巡检任务
     */
    @RequestMapping(InspectionTaskServiceProxy.SAVE)
    Result save(@RequestParam(name = "inspectionTaskVO") InspectionTaskVO inspectionTaskVO);

    /**
     * 获取巡检任务
     */
    @RequestMapping(InspectionTaskServiceProxy.GET_BY_ID)
    Result<InspectionTask> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个巡检任务
     */
    @RequestMapping(InspectionTaskServiceProxy.GET_BY_IDS)
    Result<List<InspectionTask>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询巡检任务
     */
    @RequestMapping(InspectionTaskServiceProxy.QUERY_LIST)
    Result<List<InspectionTask>> queryList(@RequestParam(name = "sample") InspectionTaskVO sample);

    /**
     * 分页查询巡检任务
     */
    @RequestMapping(InspectionTaskServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<InspectionTask>> queryPagedList(@RequestParam(name = "sample") InspectionTaskVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.InspectionTaskController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static InspectionTaskServiceProxy api() {
        return APIProxy.get(InspectionTaskServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
