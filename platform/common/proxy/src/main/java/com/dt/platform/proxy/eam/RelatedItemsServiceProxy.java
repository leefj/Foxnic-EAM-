package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.RelatedItems;
import com.dt.platform.domain.eam.RelatedItemsVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 关联项 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-27 07:24:05
 */
@FeignClient(value = ServiceNames.EAM, contextId = RelatedItemsServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface RelatedItemsServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-related-items
     */
    public static final String API_CONTEXT_PATH = "eam-related-items";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加关联项
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除关联项
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除关联项
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新关联项
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存关联项
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个关联项
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个关联项
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询关联项
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询关联项
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加关联项
     */
    @RequestMapping(RelatedItemsServiceProxy.INSERT)
    Result insert(@RequestParam(name = "relatedItemsVO") RelatedItemsVO relatedItemsVO);

    /**
     * 删除关联项
     */
    @RequestMapping(RelatedItemsServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除关联项
     */
    @RequestMapping(RelatedItemsServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新关联项
     */
    @RequestMapping(RelatedItemsServiceProxy.UPDATE)
    Result update(@RequestParam(name = "relatedItemsVO") RelatedItemsVO relatedItemsVO);

    /**
     * 更新关联项
     */
    @RequestMapping(RelatedItemsServiceProxy.SAVE)
    Result save(@RequestParam(name = "relatedItemsVO") RelatedItemsVO relatedItemsVO);

    /**
     * 获取关联项
     */
    @RequestMapping(RelatedItemsServiceProxy.GET_BY_ID)
    Result<RelatedItems> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个关联项
     */
    @RequestMapping(RelatedItemsServiceProxy.GET_BY_IDS)
    Result<List<RelatedItems>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询关联项
     */
    @RequestMapping(RelatedItemsServiceProxy.QUERY_LIST)
    Result<List<RelatedItems>> queryList(@RequestParam(name = "sample") RelatedItemsVO sample);

    /**
     * 分页查询关联项
     */
    @RequestMapping(RelatedItemsServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<RelatedItems>> queryPagedList(@RequestParam(name = "sample") RelatedItemsVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.RelatedItemsController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static RelatedItemsServiceProxy api() {
        return APIProxy.get(RelatedItemsServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
