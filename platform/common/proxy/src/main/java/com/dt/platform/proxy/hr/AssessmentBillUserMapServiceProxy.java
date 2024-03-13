package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.AssessmentBillUserMap;
import com.dt.platform.domain.hr.AssessmentBillUserMapVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 人员映射 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-10 08:13:16
 */
@FeignClient(value = ServiceNames.HR, contextId = AssessmentBillUserMapServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssessmentBillUserMapServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-assessment-bill-user-map
     */
    public static final String API_CONTEXT_PATH = "hr-assessment-bill-user-map";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加人员映射
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除人员映射
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除人员映射
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新人员映射
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存人员映射
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个人员映射
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个人员映射
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询人员映射
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询人员映射
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    public static final String APPEND_DATA = API_PREFIX + "append-data";

    public static final String RESET_DATA = API_PREFIX + "reset-data";

    /**
     * 添加人员映射
     */
    @RequestMapping(AssessmentBillUserMapServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assessmentBillUserMapVO") AssessmentBillUserMapVO assessmentBillUserMapVO);

    /**
     * 删除人员映射
     */
    @RequestMapping(AssessmentBillUserMapServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除人员映射
     */
    @RequestMapping(AssessmentBillUserMapServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新人员映射
     */
    @RequestMapping(AssessmentBillUserMapServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assessmentBillUserMapVO") AssessmentBillUserMapVO assessmentBillUserMapVO);

    /**
     * 更新人员映射
     */
    @RequestMapping(AssessmentBillUserMapServiceProxy.SAVE)
    Result save(@RequestParam(name = "assessmentBillUserMapVO") AssessmentBillUserMapVO assessmentBillUserMapVO);

    /**
     * 获取人员映射
     */
    @RequestMapping(AssessmentBillUserMapServiceProxy.GET_BY_ID)
    Result<AssessmentBillUserMap> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个人员映射
     */
    @RequestMapping(AssessmentBillUserMapServiceProxy.GET_BY_IDS)
    Result<List<AssessmentBillUserMap>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询人员映射
     */
    @RequestMapping(AssessmentBillUserMapServiceProxy.QUERY_LIST)
    Result<List<AssessmentBillUserMap>> queryList(@RequestParam(name = "sample") AssessmentBillUserMapVO sample);

    /**
     * 分页查询人员映射
     */
    @RequestMapping(AssessmentBillUserMapServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssessmentBillUserMap>> queryPagedList(@RequestParam(name = "sample") AssessmentBillUserMapVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.AssessmentBillUserMapController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssessmentBillUserMapServiceProxy api() {
        return APIProxy.get(AssessmentBillUserMapServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
