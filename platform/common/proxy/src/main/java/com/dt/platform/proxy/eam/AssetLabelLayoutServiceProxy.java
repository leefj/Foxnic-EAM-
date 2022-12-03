package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetLabelLayout;
import com.dt.platform.domain.eam.AssetLabelLayoutVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 标签布局 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-12-02 19:38:47
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetLabelLayoutServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetLabelLayoutServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-label-layout
     */
    public static final String API_CONTEXT_PATH = "eam-asset-label-layout";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加标签布局
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除标签布局
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除标签布局
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新标签布局
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存标签布局
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个标签布局
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个标签布局
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询标签布局
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询标签布局
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加标签布局
     */
    @RequestMapping(AssetLabelLayoutServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetLabelLayoutVO") AssetLabelLayoutVO assetLabelLayoutVO);

    /**
     * 删除标签布局
     */
    @RequestMapping(AssetLabelLayoutServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除标签布局
     */
    @RequestMapping(AssetLabelLayoutServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新标签布局
     */
    @RequestMapping(AssetLabelLayoutServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetLabelLayoutVO") AssetLabelLayoutVO assetLabelLayoutVO);

    /**
     * 更新标签布局
     */
    @RequestMapping(AssetLabelLayoutServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetLabelLayoutVO") AssetLabelLayoutVO assetLabelLayoutVO);

    /**
     * 获取标签布局
     */
    @RequestMapping(AssetLabelLayoutServiceProxy.GET_BY_ID)
    Result<AssetLabelLayout> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个标签布局
     */
    @RequestMapping(AssetLabelLayoutServiceProxy.GET_BY_IDS)
    Result<List<AssetLabelLayout>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询标签布局
     */
    @RequestMapping(AssetLabelLayoutServiceProxy.QUERY_LIST)
    Result<List<AssetLabelLayout>> queryList(@RequestParam(name = "sample") AssetLabelLayoutVO sample);

    /**
     * 分页查询标签布局
     */
    @RequestMapping(AssetLabelLayoutServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetLabelLayout>> queryPagedList(@RequestParam(name = "sample") AssetLabelLayoutVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetLabelLayoutController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetLabelLayoutServiceProxy api() {
        return APIProxy.get(AssetLabelLayoutServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
