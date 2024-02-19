package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.PersonStore;
import com.dt.platform.domain.hr.PersonStoreVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 人员信息 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-19 19:55:04
 */
@FeignClient(value = ServiceNames.HR, contextId = PersonStoreServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PersonStoreServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-person-store
     */
    public static final String API_CONTEXT_PATH = "hr-person-store";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加人员信息
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除人员信息
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除人员信息
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新人员信息
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存人员信息
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个人员信息
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个人员信息
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询人员信息
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询人员信息
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加人员信息
     */
    @RequestMapping(PersonStoreServiceProxy.INSERT)
    Result insert(@RequestParam(name = "personStoreVO") PersonStoreVO personStoreVO);

    /**
     * 删除人员信息
     */
    @RequestMapping(PersonStoreServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除人员信息
     */
    @RequestMapping(PersonStoreServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新人员信息
     */
    @RequestMapping(PersonStoreServiceProxy.UPDATE)
    Result update(@RequestParam(name = "personStoreVO") PersonStoreVO personStoreVO);

    /**
     * 更新人员信息
     */
    @RequestMapping(PersonStoreServiceProxy.SAVE)
    Result save(@RequestParam(name = "personStoreVO") PersonStoreVO personStoreVO);

    /**
     * 获取人员信息
     */
    @RequestMapping(PersonStoreServiceProxy.GET_BY_ID)
    Result<PersonStore> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个人员信息
     */
    @RequestMapping(PersonStoreServiceProxy.GET_BY_IDS)
    Result<List<PersonStore>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询人员信息
     */
    @RequestMapping(PersonStoreServiceProxy.QUERY_LIST)
    Result<List<PersonStore>> queryList(@RequestParam(name = "sample") PersonStoreVO sample);

    /**
     * 分页查询人员信息
     */
    @RequestMapping(PersonStoreServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<PersonStore>> queryPagedList(@RequestParam(name = "sample") PersonStoreVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.PersonStoreController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static PersonStoreServiceProxy api() {
        return APIProxy.get(PersonStoreServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
