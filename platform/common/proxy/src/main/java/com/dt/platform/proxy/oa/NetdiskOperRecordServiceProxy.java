package com.dt.platform.proxy.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.oa.NetdiskOperRecord;
import com.dt.platform.domain.oa.NetdiskOperRecordVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 操作记录 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-30 10:52:17
 */
@FeignClient(value = ServiceNames.OA, contextId = NetdiskOperRecordServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface NetdiskOperRecordServiceProxy {

    /**
     * 基础路径 , service-oa
     */
    public static final String API_BASIC_PATH = "service-oa";

    /**
     * API 上下文路径 , oa-netdisk-oper-record
     */
    public static final String API_CONTEXT_PATH = "oa-netdisk-oper-record";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加操作记录
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除操作记录
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除操作记录
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新操作记录
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存操作记录
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个操作记录
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个操作记录
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询操作记录
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询操作记录
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加操作记录
     */
    @RequestMapping(NetdiskOperRecordServiceProxy.INSERT)
    Result insert(@RequestParam(name = "netdiskOperRecordVO") NetdiskOperRecordVO netdiskOperRecordVO);

    /**
     * 删除操作记录
     */
    @RequestMapping(NetdiskOperRecordServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除操作记录
     */
    @RequestMapping(NetdiskOperRecordServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新操作记录
     */
    @RequestMapping(NetdiskOperRecordServiceProxy.UPDATE)
    Result update(@RequestParam(name = "netdiskOperRecordVO") NetdiskOperRecordVO netdiskOperRecordVO);

    /**
     * 更新操作记录
     */
    @RequestMapping(NetdiskOperRecordServiceProxy.SAVE)
    Result save(@RequestParam(name = "netdiskOperRecordVO") NetdiskOperRecordVO netdiskOperRecordVO);

    /**
     * 获取操作记录
     */
    @RequestMapping(NetdiskOperRecordServiceProxy.GET_BY_ID)
    Result<NetdiskOperRecord> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个操作记录
     */
    @RequestMapping(NetdiskOperRecordServiceProxy.GET_BY_IDS)
    Result<List<NetdiskOperRecord>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询操作记录
     */
    @RequestMapping(NetdiskOperRecordServiceProxy.QUERY_LIST)
    Result<List<NetdiskOperRecord>> queryList(@RequestParam(name = "sample") NetdiskOperRecordVO sample);

    /**
     * 分页查询操作记录
     */
    @RequestMapping(NetdiskOperRecordServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<NetdiskOperRecord>> queryPagedList(@RequestParam(name = "sample") NetdiskOperRecordVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.oa.controller.NetdiskOperRecordController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static NetdiskOperRecordServiceProxy api() {
        return APIProxy.get(NetdiskOperRecordServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
