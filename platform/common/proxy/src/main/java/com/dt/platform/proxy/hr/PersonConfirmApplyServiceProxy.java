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
import com.dt.platform.domain.hr.PersonConfirmApply;
import com.dt.platform.domain.hr.PersonConfirmApplyVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 转正申请 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-13 21:05:19
 */
@FeignClient(value = ServiceNames.HR, contextId = PersonConfirmApplyServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PersonConfirmApplyServiceProxy extends BpmCallbackController {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-person-confirm-apply
     */
    public static final String API_CONTEXT_PATH = "hr-person-confirm-apply";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加转正申请
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除转正申请
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除转正申请
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新转正申请
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存转正申请
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个转正申请
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个转正申请
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询转正申请
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询转正申请
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 流程事件回调接收接口
     */
    public static final String BPM_CALLBACK = API_PREFIX + "bpm-callback";

    /**
     * 添加转正申请
     */
    @RequestMapping(PersonConfirmApplyServiceProxy.INSERT)
    Result insert(@RequestParam(name = "personConfirmApplyVO") PersonConfirmApplyVO personConfirmApplyVO);

    /**
     * 删除转正申请
     */
    @RequestMapping(PersonConfirmApplyServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除转正申请
     */
    @RequestMapping(PersonConfirmApplyServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新转正申请
     */
    @RequestMapping(PersonConfirmApplyServiceProxy.UPDATE)
    Result update(@RequestParam(name = "personConfirmApplyVO") PersonConfirmApplyVO personConfirmApplyVO);

    /**
     * 更新转正申请
     */
    @RequestMapping(PersonConfirmApplyServiceProxy.SAVE)
    Result save(@RequestParam(name = "personConfirmApplyVO") PersonConfirmApplyVO personConfirmApplyVO);

    /**
     * 获取转正申请
     */
    @RequestMapping(PersonConfirmApplyServiceProxy.GET_BY_ID)
    Result<PersonConfirmApply> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个转正申请
     */
    @RequestMapping(PersonConfirmApplyServiceProxy.GET_BY_IDS)
    Result<List<PersonConfirmApply>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询转正申请
     */
    @RequestMapping(PersonConfirmApplyServiceProxy.QUERY_LIST)
    Result<List<PersonConfirmApply>> queryList(@RequestParam(name = "sample") PersonConfirmApplyVO sample);

    /**
     * 分页查询转正申请
     */
    @RequestMapping(PersonConfirmApplyServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<PersonConfirmApply>> queryPagedList(@RequestParam(name = "sample") PersonConfirmApplyVO sample);

    /**
     * 分页查询转正申请
     */
    @RequestMapping(PersonConfirmApplyServiceProxy.BPM_CALLBACK)
    BpmActionResult onProcessCallback(@RequestParam(name = "event") BpmEvent event);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.PersonConfirmApplyController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static PersonConfirmApplyServiceProxy api() {
        return APIProxy.get(PersonConfirmApplyServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
