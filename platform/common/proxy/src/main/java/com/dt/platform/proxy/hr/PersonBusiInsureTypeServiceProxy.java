package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.PersonBusiInsureType;
import com.dt.platform.domain.hr.PersonBusiInsureTypeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 商业保险类别 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-06 13:12:19
 */
@FeignClient(value = ServiceNames.HR, contextId = PersonBusiInsureTypeServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PersonBusiInsureTypeServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-person-busi-insure-type
     */
    public static final String API_CONTEXT_PATH = "hr-person-busi-insure-type";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加商业保险类别
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除商业保险类别
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除商业保险类别
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新商业保险类别
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存商业保险类别
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个商业保险类别
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个商业保险类别
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询商业保险类别
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询商业保险类别
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加商业保险类别
     */
    @RequestMapping(PersonBusiInsureTypeServiceProxy.INSERT)
    Result insert(@RequestParam(name = "personBusiInsureTypeVO") PersonBusiInsureTypeVO personBusiInsureTypeVO);

    /**
     * 删除商业保险类别
     */
    @RequestMapping(PersonBusiInsureTypeServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除商业保险类别
     */
    @RequestMapping(PersonBusiInsureTypeServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新商业保险类别
     */
    @RequestMapping(PersonBusiInsureTypeServiceProxy.UPDATE)
    Result update(@RequestParam(name = "personBusiInsureTypeVO") PersonBusiInsureTypeVO personBusiInsureTypeVO);

    /**
     * 更新商业保险类别
     */
    @RequestMapping(PersonBusiInsureTypeServiceProxy.SAVE)
    Result save(@RequestParam(name = "personBusiInsureTypeVO") PersonBusiInsureTypeVO personBusiInsureTypeVO);

    /**
     * 获取商业保险类别
     */
    @RequestMapping(PersonBusiInsureTypeServiceProxy.GET_BY_ID)
    Result<PersonBusiInsureType> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个商业保险类别
     */
    @RequestMapping(PersonBusiInsureTypeServiceProxy.GET_BY_IDS)
    Result<List<PersonBusiInsureType>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询商业保险类别
     */
    @RequestMapping(PersonBusiInsureTypeServiceProxy.QUERY_LIST)
    Result<List<PersonBusiInsureType>> queryList(@RequestParam(name = "sample") PersonBusiInsureTypeVO sample);

    /**
     * 分页查询商业保险类别
     */
    @RequestMapping(PersonBusiInsureTypeServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<PersonBusiInsureType>> queryPagedList(@RequestParam(name = "sample") PersonBusiInsureTypeVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.PersonBusiInsureTypeController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static PersonBusiInsureTypeServiceProxy api() {
        return APIProxy.get(PersonBusiInsureTypeServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
