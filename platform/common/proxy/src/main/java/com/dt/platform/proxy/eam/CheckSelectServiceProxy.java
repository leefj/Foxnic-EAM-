package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.CheckSelect;
import com.dt.platform.domain.eam.CheckSelectVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 检查项选择 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-05 13:51:58
 */
@FeignClient(value = ServiceNames.EAM, contextId = CheckSelectServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CheckSelectServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-check-select
     */
    public static final String API_CONTEXT_PATH = "eam-check-select";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加检查项选择
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除检查项选择
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除检查项选择
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新检查项选择
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存检查项选择
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个检查项选择
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个检查项选择
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询检查项选择
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询检查项选择
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加检查项选择
     */
    @RequestMapping(CheckSelectServiceProxy.INSERT)
    Result insert(@RequestParam(name = "checkSelectVO") CheckSelectVO checkSelectVO);

    /**
     * 删除检查项选择
     */
    @RequestMapping(CheckSelectServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除检查项选择
     */
    @RequestMapping(CheckSelectServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新检查项选择
     */
    @RequestMapping(CheckSelectServiceProxy.UPDATE)
    Result update(@RequestParam(name = "checkSelectVO") CheckSelectVO checkSelectVO);

    /**
     * 更新检查项选择
     */
    @RequestMapping(CheckSelectServiceProxy.SAVE)
    Result save(@RequestParam(name = "checkSelectVO") CheckSelectVO checkSelectVO);

    /**
     * 获取检查项选择
     */
    @RequestMapping(CheckSelectServiceProxy.GET_BY_ID)
    Result<CheckSelect> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个检查项选择
     */
    @RequestMapping(CheckSelectServiceProxy.GET_BY_IDS)
    Result<List<CheckSelect>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询检查项选择
     */
    @RequestMapping(CheckSelectServiceProxy.QUERY_LIST)
    Result<List<CheckSelect>> queryList(@RequestParam(name = "sample") CheckSelectVO sample);

    /**
     * 分页查询检查项选择
     */
    @RequestMapping(CheckSelectServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CheckSelect>> queryPagedList(@RequestParam(name = "sample") CheckSelectVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.CheckSelectController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CheckSelectServiceProxy api() {
        return APIProxy.get(CheckSelectServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
