package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.InspectionPoint;
import com.dt.platform.domain.eam.InspectionPointVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 巡检点  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-11 08:31:05
 */
@FeignClient(value = ServiceNames.EAM, contextId = InspectionPointServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface InspectionPointServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-inspection-point
     */
    public static final String API_CONTEXT_PATH = "eam-inspection-point";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加巡检点
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除巡检点
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除巡检点
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新巡检点
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存巡检点
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个巡检点
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个巡检点
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询巡检点
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询巡检点
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出巡检点数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载巡检点导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入巡检点数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     *
     */

    public static final String QUERY_PAGED_LIST_BY_SELECTED = API_PREFIX + "query-paged-list-by-selected";
    /**
     *
     */
    public static final String QUERY_PAGED_LIST_BY_SELECT = API_PREFIX + "query-paged-list-by-select";


    public static final String SELECTED = API_PREFIX + "selected";

    /**
     * 分页查询检查项
     */
    public static final String SELECT_SAVE_IDS = API_PREFIX + "select-save-ids";

    /**
     * 分页查询检查项
     */
    public static final String SELECT_DELETE_BY_ID = API_PREFIX + "select-delete-by-id";

    /**
     * 添加巡检点
     */
    @RequestMapping(InspectionPointServiceProxy.INSERT)
    Result insert(@RequestParam(name = "inspectionPointVO") InspectionPointVO inspectionPointVO);

    /**
     * 删除巡检点
     */
    @RequestMapping(InspectionPointServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除巡检点
     */
    @RequestMapping(InspectionPointServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新巡检点
     */
    @RequestMapping(InspectionPointServiceProxy.UPDATE)
    Result update(@RequestParam(name = "inspectionPointVO") InspectionPointVO inspectionPointVO);

    /**
     * 更新巡检点
     */
    @RequestMapping(InspectionPointServiceProxy.SAVE)
    Result save(@RequestParam(name = "inspectionPointVO") InspectionPointVO inspectionPointVO);

    /**
     * 获取巡检点
     */
    @RequestMapping(InspectionPointServiceProxy.GET_BY_ID)
    Result<InspectionPoint> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个巡检点
     */
    @RequestMapping(InspectionPointServiceProxy.GET_BY_IDS)
    Result<List<InspectionPoint>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询巡检点
     */
    @RequestMapping(InspectionPointServiceProxy.QUERY_LIST)
    Result<List<InspectionPoint>> queryList(@RequestParam(name = "sample") InspectionPointVO sample);

    /**
     * 分页查询巡检点
     */
    @RequestMapping(InspectionPointServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<InspectionPoint>> queryPagedList(@RequestParam(name = "sample") InspectionPointVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.InspectionPointController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static InspectionPointServiceProxy api() {
        return APIProxy.get(InspectionPointServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
