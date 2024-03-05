package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.AttendanceTplDtl;
import com.dt.platform.domain.hr.AttendanceTplDtlVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 考勤组 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-27 13:36:26
 */
@FeignClient(value = ServiceNames.HR, contextId = AttendanceTplDtlServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AttendanceTplDtlServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-attendance-tpl-dtl
     */
    public static final String API_CONTEXT_PATH = "hr-attendance-tpl-dtl";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加考勤组
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除考勤组
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除考勤组
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新考勤组
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存考勤组
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个考勤组
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个考勤组
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询考勤组
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询考勤组
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加考勤组
     */
    @RequestMapping(AttendanceTplDtlServiceProxy.INSERT)
    Result insert(@RequestParam(name = "attendanceTplDtlVO") AttendanceTplDtlVO attendanceTplDtlVO);

    /**
     * 删除考勤组
     */
    @RequestMapping(AttendanceTplDtlServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除考勤组
     */
    @RequestMapping(AttendanceTplDtlServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新考勤组
     */
    @RequestMapping(AttendanceTplDtlServiceProxy.UPDATE)
    Result update(@RequestParam(name = "attendanceTplDtlVO") AttendanceTplDtlVO attendanceTplDtlVO);

    /**
     * 更新考勤组
     */
    @RequestMapping(AttendanceTplDtlServiceProxy.SAVE)
    Result save(@RequestParam(name = "attendanceTplDtlVO") AttendanceTplDtlVO attendanceTplDtlVO);

    /**
     * 获取考勤组
     */
    @RequestMapping(AttendanceTplDtlServiceProxy.GET_BY_ID)
    Result<AttendanceTplDtl> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个考勤组
     */
    @RequestMapping(AttendanceTplDtlServiceProxy.GET_BY_IDS)
    Result<List<AttendanceTplDtl>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询考勤组
     */
    @RequestMapping(AttendanceTplDtlServiceProxy.QUERY_LIST)
    Result<List<AttendanceTplDtl>> queryList(@RequestParam(name = "sample") AttendanceTplDtlVO sample);

    /**
     * 分页查询考勤组
     */
    @RequestMapping(AttendanceTplDtlServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AttendanceTplDtl>> queryPagedList(@RequestParam(name = "sample") AttendanceTplDtlVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.AttendanceTplDtlController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AttendanceTplDtlServiceProxy api() {
        return APIProxy.get(AttendanceTplDtlServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
