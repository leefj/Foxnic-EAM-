package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.NetdiskOriginFile;
import com.dt.platform.domain.oa.NetdiskOriginFileVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 源文件 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-22 12:33:27
 */
@FeignClient(value = ServiceNames.OA, contextId = NetdiskOriginFileServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface NetdiskOriginFileServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-netdisk-origin-file
     */
    public static final String API_CONTEXT_PATH = "oa-netdisk-origin-file";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加源文件
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除源文件
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除源文件
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新源文件
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存源文件
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个源文件
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个源文件
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询源文件
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询源文件
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加源文件
     */
    @RequestMapping(NetdiskOriginFileServiceProxy.INSERT)
    Result insert(@RequestParam(name = "netdiskOriginFileVO") NetdiskOriginFileVO netdiskOriginFileVO);

    /**
     * 删除源文件
     */
    @RequestMapping(NetdiskOriginFileServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除源文件
     */
    @RequestMapping(NetdiskOriginFileServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新源文件
     */
    @RequestMapping(NetdiskOriginFileServiceProxy.UPDATE)
    Result update(@RequestParam(name = "netdiskOriginFileVO") NetdiskOriginFileVO netdiskOriginFileVO);

    /**
     * 更新源文件
     */
    @RequestMapping(NetdiskOriginFileServiceProxy.SAVE)
    Result save(@RequestParam(name = "netdiskOriginFileVO") NetdiskOriginFileVO netdiskOriginFileVO);

    /**
     * 获取源文件
     */
    @RequestMapping(NetdiskOriginFileServiceProxy.GET_BY_ID)
    Result<NetdiskOriginFile> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个源文件
     */
    @RequestMapping(NetdiskOriginFileServiceProxy.GET_BY_IDS)
    Result<List<NetdiskOriginFile>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询源文件
     */
    @RequestMapping(NetdiskOriginFileServiceProxy.QUERY_LIST)
    Result<List<NetdiskOriginFile>> queryList(@RequestParam(name = "sample") NetdiskOriginFileVO sample);

    /**
     * 分页查询源文件
     */
    @RequestMapping(NetdiskOriginFileServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<NetdiskOriginFile>> queryPagedList(@RequestParam(name = "sample") NetdiskOriginFileVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.NetdiskOriginFileController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static NetdiskOriginFileServiceProxy api() {
        return APIProxy.get(NetdiskOriginFileServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
