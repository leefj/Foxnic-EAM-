package com.dt.platform.proxy.hr;

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
import com.dt.platform.domain.hr.PersonLeave;
import com.dt.platform.domain.hr.PersonLeaveVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 员工离职 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-13 21:03:42
 */
@FeignClient(value = ServiceNames.HR, contextId = PersonLeaveServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PersonLeaveServiceProxy extends BpmCallbackController {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-person-leave
     */
    public static final String API_CONTEXT_PATH = "hr-person-leave";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加员工离职
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除员工离职
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除员工离职
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新员工离职
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存员工离职
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个员工离职
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个员工离职
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询员工离职
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询员工离职
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 流程事件回调接收接口
     */
    public static final String BPM_CALLBACK = API_PREFIX + "bpm-callback";

    /**
     * 添加员工离职
     */
    @RequestMapping(PersonLeaveServiceProxy.INSERT)
    Result insert(@RequestParam(name = "personLeaveVO") PersonLeaveVO personLeaveVO);

    /**
     * 删除员工离职
     */
    @RequestMapping(PersonLeaveServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除员工离职
     */
    @RequestMapping(PersonLeaveServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新员工离职
     */
    @RequestMapping(PersonLeaveServiceProxy.UPDATE)
    Result update(@RequestParam(name = "personLeaveVO") PersonLeaveVO personLeaveVO);

    /**
     * 更新员工离职
     */
    @RequestMapping(PersonLeaveServiceProxy.SAVE)
    Result save(@RequestParam(name = "personLeaveVO") PersonLeaveVO personLeaveVO);

    /**
     * 获取员工离职
     */
    @RequestMapping(PersonLeaveServiceProxy.GET_BY_ID)
    Result<PersonLeave> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个员工离职
     */
    @RequestMapping(PersonLeaveServiceProxy.GET_BY_IDS)
    Result<List<PersonLeave>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询员工离职
     */
    @RequestMapping(PersonLeaveServiceProxy.QUERY_LIST)
    Result<List<PersonLeave>> queryList(@RequestParam(name = "sample") PersonLeaveVO sample);

    /**
     * 分页查询员工离职
     */
    @RequestMapping(PersonLeaveServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<PersonLeave>> queryPagedList(@RequestParam(name = "sample") PersonLeaveVO sample);

    /**
     * 分页查询员工离职
     */
    @RequestMapping(PersonLeaveServiceProxy.BPM_CALLBACK)
    BpmActionResult onProcessCallback(@RequestParam(name = "event") BpmEvent event);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.PersonLeaveController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static PersonLeaveServiceProxy api() {
        return APIProxy.get(PersonLeaveServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
