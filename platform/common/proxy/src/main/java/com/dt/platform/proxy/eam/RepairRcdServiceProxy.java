package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.RepairRcd;
import com.dt.platform.domain.eam.RepairRcdVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 维修记录 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-12 12:15:37
 */
@FeignClient(value = ServiceNames.EAM, contextId = RepairRcdServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface RepairRcdServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-repair-rcd
     */
    public static final String API_CONTEXT_PATH = "eam-repair-rcd";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加维修记录
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除维修记录
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除维修记录
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新维修记录
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存维修记录
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个维修记录
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个维修记录
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询维修记录
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询维修记录
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加维修记录
     */
    @RequestMapping(RepairRcdServiceProxy.INSERT)
    Result insert(@RequestParam(name = "repairRcdVO") RepairRcdVO repairRcdVO);

    /**
     * 删除维修记录
     */
    @RequestMapping(RepairRcdServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除维修记录
     */
    @RequestMapping(RepairRcdServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新维修记录
     */
    @RequestMapping(RepairRcdServiceProxy.UPDATE)
    Result update(@RequestParam(name = "repairRcdVO") RepairRcdVO repairRcdVO);

    /**
     * 更新维修记录
     */
    @RequestMapping(RepairRcdServiceProxy.SAVE)
    Result save(@RequestParam(name = "repairRcdVO") RepairRcdVO repairRcdVO);

    /**
     * 获取维修记录
     */
    @RequestMapping(RepairRcdServiceProxy.GET_BY_ID)
    Result<RepairRcd> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个维修记录
     */
    @RequestMapping(RepairRcdServiceProxy.GET_BY_IDS)
    Result<List<RepairRcd>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询维修记录
     */
    @RequestMapping(RepairRcdServiceProxy.QUERY_LIST)
    Result<List<RepairRcd>> queryList(@RequestParam(name = "sample") RepairRcdVO sample);

    /**
     * 分页查询维修记录
     */
    @RequestMapping(RepairRcdServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<RepairRcd>> queryPagedList(@RequestParam(name = "sample") RepairRcdVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.RepairRcdController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static RepairRcdServiceProxy api() {
        return APIProxy.get(RepairRcdServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
