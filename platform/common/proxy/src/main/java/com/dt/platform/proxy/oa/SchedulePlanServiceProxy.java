package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.SchedulePlan;
import com.dt.platform.domain.oa.SchedulePlanVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 日程安排 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-25 10:32:46
 */
@FeignClient(value = ServiceNames.OA, contextId = SchedulePlanServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface SchedulePlanServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-schedule-plan
     */
    public static final String API_CONTEXT_PATH = "oa-schedule-plan";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加日程安排
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除日程安排
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除日程安排
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新日程安排
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存日程安排
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个日程安排
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个日程安排
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询日程安排
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询日程安排
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 分页查询日程安排
     */
    public static final String QUERY_PLAN = API_PREFIX + "query-plan";

    /**
     * 添加日程安排
     */
    @RequestMapping(SchedulePlanServiceProxy.INSERT)
    Result insert(@RequestParam(name = "schedulePlanVO") SchedulePlanVO schedulePlanVO);

    /**
     * 删除日程安排
     */
    @RequestMapping(SchedulePlanServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除日程安排
     */
    @RequestMapping(SchedulePlanServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新日程安排
     */
    @RequestMapping(SchedulePlanServiceProxy.UPDATE)
    Result update(@RequestParam(name = "schedulePlanVO") SchedulePlanVO schedulePlanVO);

    /**
     * 更新日程安排
     */
    @RequestMapping(SchedulePlanServiceProxy.SAVE)
    Result save(@RequestParam(name = "schedulePlanVO") SchedulePlanVO schedulePlanVO);

    /**
     * 获取日程安排
     */
    @RequestMapping(SchedulePlanServiceProxy.GET_BY_ID)
    Result<SchedulePlan> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个日程安排
     */
    @RequestMapping(SchedulePlanServiceProxy.GET_BY_IDS)
    Result<List<SchedulePlan>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询日程安排
     */
    @RequestMapping(SchedulePlanServiceProxy.QUERY_LIST)
    Result<List<SchedulePlan>> queryList(@RequestParam(name = "sample") SchedulePlanVO sample);

    /**
     * 分页查询日程安排
     */
    @RequestMapping(SchedulePlanServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<SchedulePlan>> queryPagedList(@RequestParam(name = "sample") SchedulePlanVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.SchedulePlanController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static SchedulePlanServiceProxy api() {
        return APIProxy.get(SchedulePlanServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
