package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.NetdiskVirtualFd;
import com.dt.platform.domain.oa.NetdiskVirtualFdVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 虚拟文件 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-18 21:00:45
 */
@FeignClient(value = ServiceNames.OA, contextId = NetdiskVirtualFdServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface NetdiskVirtualFdServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-netdisk-virtual-fd
     */
    public static final String API_CONTEXT_PATH = "oa-netdisk-virtual-fd";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加虚拟文件
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除虚拟文件
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除虚拟文件
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新虚拟文件
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存虚拟文件
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个虚拟文件
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个虚拟文件
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询虚拟文件
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询虚拟文件
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";


    public static final String RENAME = API_PREFIX + "rename";


    public static final String BATCH_DELETE = API_PREFIX + "batch-delete";


    public static final String DOWNLOAD_BY_ID = API_PREFIX + "download-by-id";


    public static final String UPLOAD_FILE = API_PREFIX + "upload-file";

    public static final String UPLOAD_FOLDER = API_PREFIX + "upload-folder";

    public static final String SHARE = API_PREFIX + "share";

    public static final String MOVE = API_PREFIX + "move";

    /**
     * 添加虚拟文件
     */
    @RequestMapping(NetdiskVirtualFdServiceProxy.INSERT)
    Result insert(@RequestParam(name = "netdiskVirtualFdVO") NetdiskVirtualFdVO netdiskVirtualFdVO);

    /**
     * 删除虚拟文件
     */
    @RequestMapping(NetdiskVirtualFdServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除虚拟文件
     */
    @RequestMapping(NetdiskVirtualFdServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新虚拟文件
     */
    @RequestMapping(NetdiskVirtualFdServiceProxy.UPDATE)
    Result update(@RequestParam(name = "netdiskVirtualFdVO") NetdiskVirtualFdVO netdiskVirtualFdVO);

    /**
     * 更新虚拟文件
     */
    @RequestMapping(NetdiskVirtualFdServiceProxy.SAVE)
    Result save(@RequestParam(name = "netdiskVirtualFdVO") NetdiskVirtualFdVO netdiskVirtualFdVO);

    /**
     * 获取虚拟文件
     */
    @RequestMapping(NetdiskVirtualFdServiceProxy.GET_BY_ID)
    Result<NetdiskVirtualFd> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个虚拟文件
     */
    @RequestMapping(NetdiskVirtualFdServiceProxy.GET_BY_IDS)
    Result<List<NetdiskVirtualFd>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询虚拟文件
     */
    @RequestMapping(NetdiskVirtualFdServiceProxy.QUERY_LIST)
    Result<List<NetdiskVirtualFd>> queryList(@RequestParam(name = "sample") NetdiskVirtualFdVO sample);

    /**
     * 分页查询虚拟文件
     */
    @RequestMapping(NetdiskVirtualFdServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<NetdiskVirtualFd>> queryPagedList(@RequestParam(name = "sample") NetdiskVirtualFdVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.NetdiskVirtualFdController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static NetdiskVirtualFdServiceProxy api() {
        return APIProxy.get(NetdiskVirtualFdServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
