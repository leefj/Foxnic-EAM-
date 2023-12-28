package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.ReportAcl;
import com.dt.platform.domain.common.ReportAclVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 报表ACL 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-12-28 19:53:14
 */
@FeignClient(value = ServiceNames.COMMON, contextId = ReportAclServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ReportAclServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-report-acl
     */
    public static final String API_CONTEXT_PATH = "sys-report-acl";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加报表ACL
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除报表ACL
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除报表ACL
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新报表ACL
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存报表ACL
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个报表ACL
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个报表ACL
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询报表ACL
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询报表ACL
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加报表ACL
     */
    @RequestMapping(ReportAclServiceProxy.INSERT)
    Result insert(@RequestParam(name = "reportAclVO") ReportAclVO reportAclVO);

    /**
     * 删除报表ACL
     */
    @RequestMapping(ReportAclServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除报表ACL
     */
    @RequestMapping(ReportAclServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新报表ACL
     */
    @RequestMapping(ReportAclServiceProxy.UPDATE)
    Result update(@RequestParam(name = "reportAclVO") ReportAclVO reportAclVO);

    /**
     * 更新报表ACL
     */
    @RequestMapping(ReportAclServiceProxy.SAVE)
    Result save(@RequestParam(name = "reportAclVO") ReportAclVO reportAclVO);

    /**
     * 获取报表ACL
     */
    @RequestMapping(ReportAclServiceProxy.GET_BY_ID)
    Result<ReportAcl> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个报表ACL
     */
    @RequestMapping(ReportAclServiceProxy.GET_BY_IDS)
    Result<List<ReportAcl>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询报表ACL
     */
    @RequestMapping(ReportAclServiceProxy.QUERY_LIST)
    Result<List<ReportAcl>> queryList(@RequestParam(name = "sample") ReportAclVO sample);

    /**
     * 分页查询报表ACL
     */
    @RequestMapping(ReportAclServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ReportAcl>> queryPagedList(@RequestParam(name = "sample") ReportAclVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.ReportAclController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ReportAclServiceProxy api() {
        return APIProxy.get(ReportAclServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
