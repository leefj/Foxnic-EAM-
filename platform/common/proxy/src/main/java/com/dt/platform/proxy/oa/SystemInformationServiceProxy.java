package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.SystemInformation;
import com.dt.platform.domain.oa.SystemInformationVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 外部系统 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-08 20:48:08
 */
@FeignClient(value = ServiceNames.OA, contextId = SystemInformationServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface SystemInformationServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-system-information
     */
    public static final String API_CONTEXT_PATH = "oa-system-information";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加外部系统
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除外部系统
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除外部系统
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新外部系统
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存外部系统
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个外部系统
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个外部系统
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询外部系统
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询外部系统
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加外部系统
     */
    @RequestMapping(SystemInformationServiceProxy.INSERT)
    Result insert(@RequestParam(name = "systemInformationVO") SystemInformationVO systemInformationVO);

    /**
     * 删除外部系统
     */
    @RequestMapping(SystemInformationServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除外部系统
     */
    @RequestMapping(SystemInformationServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新外部系统
     */
    @RequestMapping(SystemInformationServiceProxy.UPDATE)
    Result update(@RequestParam(name = "systemInformationVO") SystemInformationVO systemInformationVO);

    /**
     * 更新外部系统
     */
    @RequestMapping(SystemInformationServiceProxy.SAVE)
    Result save(@RequestParam(name = "systemInformationVO") SystemInformationVO systemInformationVO);

    /**
     * 获取外部系统
     */
    @RequestMapping(SystemInformationServiceProxy.GET_BY_ID)
    Result<SystemInformation> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个外部系统
     */
    @RequestMapping(SystemInformationServiceProxy.GET_BY_IDS)
    Result<List<SystemInformation>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询外部系统
     */
    @RequestMapping(SystemInformationServiceProxy.QUERY_LIST)
    Result<List<SystemInformation>> queryList(@RequestParam(name = "sample") SystemInformationVO sample);

    /**
     * 分页查询外部系统
     */
    @RequestMapping(SystemInformationServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<SystemInformation>> queryPagedList(@RequestParam(name = "sample") SystemInformationVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.SystemInformationController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static SystemInformationServiceProxy api() {
        return APIProxy.get(SystemInformationServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
