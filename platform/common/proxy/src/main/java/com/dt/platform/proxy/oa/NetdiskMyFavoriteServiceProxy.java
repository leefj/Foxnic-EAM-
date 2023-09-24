package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.NetdiskMyFavorite;
import com.dt.platform.domain.oa.NetdiskMyFavoriteVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 我的收藏 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-18 14:20:21
 */
@FeignClient(value = ServiceNames.OA, contextId = NetdiskMyFavoriteServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface NetdiskMyFavoriteServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-netdisk-my-favorite
     */
    public static final String API_CONTEXT_PATH = "oa-netdisk-my-favorite";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加我的收藏
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除我的收藏
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除我的收藏
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新我的收藏
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存我的收藏
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个我的收藏
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个我的收藏
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询我的收藏
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询我的收藏
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加我的收藏
     */
    @RequestMapping(NetdiskMyFavoriteServiceProxy.INSERT)
    Result insert(@RequestParam(name = "netdiskMyFavoriteVO") NetdiskMyFavoriteVO netdiskMyFavoriteVO);

    /**
     * 删除我的收藏
     */
    @RequestMapping(NetdiskMyFavoriteServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除我的收藏
     */
    @RequestMapping(NetdiskMyFavoriteServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新我的收藏
     */
    @RequestMapping(NetdiskMyFavoriteServiceProxy.UPDATE)
    Result update(@RequestParam(name = "netdiskMyFavoriteVO") NetdiskMyFavoriteVO netdiskMyFavoriteVO);

    /**
     * 更新我的收藏
     */
    @RequestMapping(NetdiskMyFavoriteServiceProxy.SAVE)
    Result save(@RequestParam(name = "netdiskMyFavoriteVO") NetdiskMyFavoriteVO netdiskMyFavoriteVO);

    /**
     * 获取我的收藏
     */
    @RequestMapping(NetdiskMyFavoriteServiceProxy.GET_BY_ID)
    Result<NetdiskMyFavorite> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个我的收藏
     */
    @RequestMapping(NetdiskMyFavoriteServiceProxy.GET_BY_IDS)
    Result<List<NetdiskMyFavorite>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询我的收藏
     */
    @RequestMapping(NetdiskMyFavoriteServiceProxy.QUERY_LIST)
    Result<List<NetdiskMyFavorite>> queryList(@RequestParam(name = "sample") NetdiskMyFavoriteVO sample);

    /**
     * 分页查询我的收藏
     */
    @RequestMapping(NetdiskMyFavoriteServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<NetdiskMyFavorite>> queryPagedList(@RequestParam(name = "sample") NetdiskMyFavoriteVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.NetdiskMyFavoriteController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static NetdiskMyFavoriteServiceProxy api() {
        return APIProxy.get(NetdiskMyFavoriteServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
