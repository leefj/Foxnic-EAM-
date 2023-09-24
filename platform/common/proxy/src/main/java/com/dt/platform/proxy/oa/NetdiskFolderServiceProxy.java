package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.NetdiskFolder;
import com.dt.platform.domain.oa.NetdiskFolderVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 文件夹 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-18 10:20:03
 */
@FeignClient(value = ServiceNames.OA, contextId = NetdiskFolderServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface NetdiskFolderServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-netdisk-folder
     */
    public static final String API_CONTEXT_PATH = "oa-netdisk-folder";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加文件夹
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除文件夹
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除文件夹
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新文件夹
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存文件夹
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个文件夹
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个文件夹
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询文件夹
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询文件夹
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";


    public static final String CREATE_FOLDER = API_PREFIX + "create-folder";
    /**
     * 添加文件夹
     */
    @RequestMapping(NetdiskFolderServiceProxy.INSERT)
    Result insert(@RequestParam(name = "netdiskFolderVO") NetdiskFolderVO netdiskFolderVO);

    /**
     * 删除文件夹
     */
    @RequestMapping(NetdiskFolderServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除文件夹
     */
    @RequestMapping(NetdiskFolderServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新文件夹
     */
    @RequestMapping(NetdiskFolderServiceProxy.UPDATE)
    Result update(@RequestParam(name = "netdiskFolderVO") NetdiskFolderVO netdiskFolderVO);

    /**
     * 更新文件夹
     */
    @RequestMapping(NetdiskFolderServiceProxy.SAVE)
    Result save(@RequestParam(name = "netdiskFolderVO") NetdiskFolderVO netdiskFolderVO);

    /**
     * 获取文件夹
     */
    @RequestMapping(NetdiskFolderServiceProxy.GET_BY_ID)
    Result<NetdiskFolder> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个文件夹
     */
    @RequestMapping(NetdiskFolderServiceProxy.GET_BY_IDS)
    Result<List<NetdiskFolder>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询文件夹
     */
    @RequestMapping(NetdiskFolderServiceProxy.QUERY_LIST)
    Result<List<NetdiskFolder>> queryList(@RequestParam(name = "sample") NetdiskFolderVO sample);

    /**
     * 分页查询文件夹
     */
    @RequestMapping(NetdiskFolderServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<NetdiskFolder>> queryPagedList(@RequestParam(name = "sample") NetdiskFolderVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.NetdiskFolderController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static NetdiskFolderServiceProxy api() {
        return APIProxy.get(NetdiskFolderServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
