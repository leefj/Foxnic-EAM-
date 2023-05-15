package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.CCustRepairType;
import com.dt.platform.domain.eam.CCustRepairTypeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 报修类型 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-14 08:57:14
 */
@FeignClient(value = ServiceNames.EAM, contextId = CCustRepairTypeServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CCustRepairTypeServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-c-cust-repair-type
     */
    public static final String API_CONTEXT_PATH = "eam-c-cust-repair-type";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加报修类型
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除报修类型
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除报修类型
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新报修类型
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存报修类型
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个报修类型
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个报修类型
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询报修类型
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询报修类型
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加报修类型
     */
    @RequestMapping(CCustRepairTypeServiceProxy.INSERT)
    Result insert(@RequestParam(name = "cCustRepairTypeVO") CCustRepairTypeVO cCustRepairTypeVO);

    /**
     * 删除报修类型
     */
    @RequestMapping(CCustRepairTypeServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除报修类型
     */
    @RequestMapping(CCustRepairTypeServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新报修类型
     */
    @RequestMapping(CCustRepairTypeServiceProxy.UPDATE)
    Result update(@RequestParam(name = "cCustRepairTypeVO") CCustRepairTypeVO cCustRepairTypeVO);

    /**
     * 更新报修类型
     */
    @RequestMapping(CCustRepairTypeServiceProxy.SAVE)
    Result save(@RequestParam(name = "cCustRepairTypeVO") CCustRepairTypeVO cCustRepairTypeVO);

    /**
     * 获取报修类型
     */
    @RequestMapping(CCustRepairTypeServiceProxy.GET_BY_ID)
    Result<CCustRepairType> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个报修类型
     */
    @RequestMapping(CCustRepairTypeServiceProxy.GET_BY_IDS)
    Result<List<CCustRepairType>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询报修类型
     */
    @RequestMapping(CCustRepairTypeServiceProxy.QUERY_LIST)
    Result<List<CCustRepairType>> queryList(@RequestParam(name = "sample") CCustRepairTypeVO sample);

    /**
     * 分页查询报修类型
     */
    @RequestMapping(CCustRepairTypeServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CCustRepairType>> queryPagedList(@RequestParam(name = "sample") CCustRepairTypeVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.CCustRepairTypeController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CCustRepairTypeServiceProxy api() {
        return APIProxy.get(CCustRepairTypeServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
