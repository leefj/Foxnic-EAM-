package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.PersonFileOut;
import com.dt.platform.domain.hr.PersonFileOutVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 档案调出 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-03 21:13:26
 */
@FeignClient(value = ServiceNames.HR, contextId = PersonFileOutServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PersonFileOutServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-person-file-out
     */
    public static final String API_CONTEXT_PATH = "hr-person-file-out";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加档案调出
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除档案调出
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除档案调出
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新档案调出
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存档案调出
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个档案调出
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个档案调出
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询档案调出
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询档案调出
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 分页查询档案调出
     */
    public static final String CONFIRM = API_PREFIX + "confirm";


    /**
     * 添加档案调出
     */
    @RequestMapping(PersonFileOutServiceProxy.INSERT)
    Result insert(@RequestParam(name = "personFileOutVO") PersonFileOutVO personFileOutVO);

    /**
     * 删除档案调出
     */
    @RequestMapping(PersonFileOutServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除档案调出
     */
    @RequestMapping(PersonFileOutServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新档案调出
     */
    @RequestMapping(PersonFileOutServiceProxy.UPDATE)
    Result update(@RequestParam(name = "personFileOutVO") PersonFileOutVO personFileOutVO);

    /**
     * 更新档案调出
     */
    @RequestMapping(PersonFileOutServiceProxy.SAVE)
    Result save(@RequestParam(name = "personFileOutVO") PersonFileOutVO personFileOutVO);

    /**
     * 获取档案调出
     */
    @RequestMapping(PersonFileOutServiceProxy.GET_BY_ID)
    Result<PersonFileOut> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个档案调出
     */
    @RequestMapping(PersonFileOutServiceProxy.GET_BY_IDS)
    Result<List<PersonFileOut>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询档案调出
     */
    @RequestMapping(PersonFileOutServiceProxy.QUERY_LIST)
    Result<List<PersonFileOut>> queryList(@RequestParam(name = "sample") PersonFileOutVO sample);

    /**
     * 分页查询档案调出
     */
    @RequestMapping(PersonFileOutServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<PersonFileOut>> queryPagedList(@RequestParam(name = "sample") PersonFileOutVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.PersonFileOutController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static PersonFileOutServiceProxy api() {
        return APIProxy.get(PersonFileOutServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
