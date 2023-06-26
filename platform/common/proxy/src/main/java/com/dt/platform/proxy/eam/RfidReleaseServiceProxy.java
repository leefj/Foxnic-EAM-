package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.RfidRelease;
import com.dt.platform.domain.eam.RfidReleaseVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * RFID发卡 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-23 18:17:32
 */
@FeignClient(value = ServiceNames.EAM, contextId = RfidReleaseServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface RfidReleaseServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-rfid-release
     */
    public static final String API_CONTEXT_PATH = "eam-rfid-release";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加RFID发卡
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除RFID发卡
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除RFID发卡
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新RFID发卡
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存RFID发卡
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个RFID发卡
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个RFID发卡
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询RFID发卡
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询RFID发卡
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * RFID发卡
     */
    public static final String RELEASE_DATA = API_PREFIX + "release-data";

    /**
     * 添加RFID发卡
     */
    @RequestMapping(RfidReleaseServiceProxy.INSERT)
    Result insert(@RequestParam(name = "rfidReleaseVO") RfidReleaseVO rfidReleaseVO);

    /**
     * 删除RFID发卡
     */
    @RequestMapping(RfidReleaseServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除RFID发卡
     */
    @RequestMapping(RfidReleaseServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新RFID发卡
     */
    @RequestMapping(RfidReleaseServiceProxy.UPDATE)
    Result update(@RequestParam(name = "rfidReleaseVO") RfidReleaseVO rfidReleaseVO);

    /**
     * 更新RFID发卡
     */
    @RequestMapping(RfidReleaseServiceProxy.SAVE)
    Result save(@RequestParam(name = "rfidReleaseVO") RfidReleaseVO rfidReleaseVO);

    /**
     * 获取RFID发卡
     */
    @RequestMapping(RfidReleaseServiceProxy.GET_BY_ID)
    Result<RfidRelease> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个RFID发卡
     */
    @RequestMapping(RfidReleaseServiceProxy.GET_BY_IDS)
    Result<List<RfidRelease>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询RFID发卡
     */
    @RequestMapping(RfidReleaseServiceProxy.QUERY_LIST)
    Result<List<RfidRelease>> queryList(@RequestParam(name = "sample") RfidReleaseVO sample);

    /**
     * 分页查询RFID发卡
     */
    @RequestMapping(RfidReleaseServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<RfidRelease>> queryPagedList(@RequestParam(name = "sample") RfidReleaseVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.RfidReleaseController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static RfidReleaseServiceProxy api() {
        return APIProxy.get(RfidReleaseServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
