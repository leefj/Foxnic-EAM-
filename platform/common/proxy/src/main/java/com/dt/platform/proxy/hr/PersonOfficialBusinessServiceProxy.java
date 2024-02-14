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
import com.dt.platform.domain.hr.PersonOfficialBusiness;
import com.dt.platform.domain.hr.PersonOfficialBusinessVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 出差申请 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-13 21:10:56
 */
@FeignClient(value = ServiceNames.HR, contextId = PersonOfficialBusinessServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PersonOfficialBusinessServiceProxy extends BpmCallbackController {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-person-official-business
     */
    public static final String API_CONTEXT_PATH = "hr-person-official-business";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加出差申请
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除出差申请
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除出差申请
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新出差申请
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存出差申请
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个出差申请
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个出差申请
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询出差申请
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询出差申请
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 流程事件回调接收接口
     */
    public static final String BPM_CALLBACK = API_PREFIX + "bpm-callback";

    /**
     * 添加出差申请
     */
    @RequestMapping(PersonOfficialBusinessServiceProxy.INSERT)
    Result insert(@RequestParam(name = "personOfficialBusinessVO") PersonOfficialBusinessVO personOfficialBusinessVO);

    /**
     * 删除出差申请
     */
    @RequestMapping(PersonOfficialBusinessServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除出差申请
     */
    @RequestMapping(PersonOfficialBusinessServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新出差申请
     */
    @RequestMapping(PersonOfficialBusinessServiceProxy.UPDATE)
    Result update(@RequestParam(name = "personOfficialBusinessVO") PersonOfficialBusinessVO personOfficialBusinessVO);

    /**
     * 更新出差申请
     */
    @RequestMapping(PersonOfficialBusinessServiceProxy.SAVE)
    Result save(@RequestParam(name = "personOfficialBusinessVO") PersonOfficialBusinessVO personOfficialBusinessVO);

    /**
     * 获取出差申请
     */
    @RequestMapping(PersonOfficialBusinessServiceProxy.GET_BY_ID)
    Result<PersonOfficialBusiness> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个出差申请
     */
    @RequestMapping(PersonOfficialBusinessServiceProxy.GET_BY_IDS)
    Result<List<PersonOfficialBusiness>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询出差申请
     */
    @RequestMapping(PersonOfficialBusinessServiceProxy.QUERY_LIST)
    Result<List<PersonOfficialBusiness>> queryList(@RequestParam(name = "sample") PersonOfficialBusinessVO sample);

    /**
     * 分页查询出差申请
     */
    @RequestMapping(PersonOfficialBusinessServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<PersonOfficialBusiness>> queryPagedList(@RequestParam(name = "sample") PersonOfficialBusinessVO sample);

    /**
     * 分页查询出差申请
     */
    @RequestMapping(PersonOfficialBusinessServiceProxy.BPM_CALLBACK)
    BpmActionResult onProcessCallback(@RequestParam(name = "event") BpmEvent event);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.PersonOfficialBusinessController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static PersonOfficialBusinessServiceProxy api() {
        return APIProxy.get(PersonOfficialBusinessServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
