package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.CheckItem;
import com.dt.platform.domain.eam.CheckItemVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 检查项 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-05 15:25:23
 */
@FeignClient(value = ServiceNames.EAM, contextId = CheckItemServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CheckItemServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-check-item
     */
    public static final String API_CONTEXT_PATH = "eam-check-item";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加检查项
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除检查项
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除检查项
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新检查项
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存检查项
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个检查项
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个检查项
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询检查项
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询检查项
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 分页查询检查项
     */
    public static final String QUERY_SELECT_PAGED_LIST = API_PREFIX + "query-select-paged-list";

    /**
     * 分页查询检查项
     */
    public static final String QUERY_SELECTED_PAGED_LIST = API_PREFIX + "query-selected-paged-list";

    /**
     * 分页查询检查项
     */
    public static final String SELECT_SAVE_IDS = API_PREFIX + "select-save-ids";

    /**
     * 分页查询检查项
     */
    public static final String SELECT_DELETE_BY_ID = API_PREFIX + "select-delete-by-id";
    /**
     * 添加检查项
     */
    @RequestMapping(CheckItemServiceProxy.INSERT)
    Result insert(@RequestParam(name = "checkItemVO") CheckItemVO checkItemVO);

    /**
     * 删除检查项
     */
    @RequestMapping(CheckItemServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除检查项
     */
    @RequestMapping(CheckItemServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新检查项
     */
    @RequestMapping(CheckItemServiceProxy.UPDATE)
    Result update(@RequestParam(name = "checkItemVO") CheckItemVO checkItemVO);

    /**
     * 更新检查项
     */
    @RequestMapping(CheckItemServiceProxy.SAVE)
    Result save(@RequestParam(name = "checkItemVO") CheckItemVO checkItemVO);

    /**
     * 获取检查项
     */
    @RequestMapping(CheckItemServiceProxy.GET_BY_ID)
    Result<CheckItem> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个检查项
     */
    @RequestMapping(CheckItemServiceProxy.GET_BY_IDS)
    Result<List<CheckItem>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询检查项
     */
    @RequestMapping(CheckItemServiceProxy.QUERY_LIST)
    Result<List<CheckItem>> queryList(@RequestParam(name = "sample") CheckItemVO sample);

    /**
     * 分页查询检查项
     */
    @RequestMapping(CheckItemServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CheckItem>> queryPagedList(@RequestParam(name = "sample") CheckItemVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.CheckItemController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CheckItemServiceProxy api() {
        return APIProxy.get(CheckItemServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
