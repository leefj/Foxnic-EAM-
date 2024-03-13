package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.AssessmentBill;
import com.dt.platform.domain.hr.AssessmentBillVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 考核单据 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-08 20:54:09
 */
@FeignClient(value = ServiceNames.HR, contextId = AssessmentBillServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssessmentBillServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-assessment-bill
     */
    public static final String API_CONTEXT_PATH = "hr-assessment-bill";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加考核单据
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除考核单据
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除考核单据
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新考核单据
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存考核单据
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个考核单据
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个考核单据
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询考核单据
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询考核单据
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    public static final String CANCEL = API_PREFIX + "cancel";

    public static final String RESET = API_PREFIX + "reset";

    public static final String RELEASE = API_PREFIX + "release";

    public static final String COPY = API_PREFIX + "copy";

    public static final String CREATE_PAPER = API_PREFIX + "create-paper";



    /**
     * 添加考核单据
     */
    @RequestMapping(AssessmentBillServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assessmentBillVO") AssessmentBillVO assessmentBillVO);

    /**
     * 删除考核单据
     */
    @RequestMapping(AssessmentBillServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除考核单据
     */
    @RequestMapping(AssessmentBillServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新考核单据
     */
    @RequestMapping(AssessmentBillServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assessmentBillVO") AssessmentBillVO assessmentBillVO);

    /**
     * 更新考核单据
     */
    @RequestMapping(AssessmentBillServiceProxy.SAVE)
    Result save(@RequestParam(name = "assessmentBillVO") AssessmentBillVO assessmentBillVO);

    /**
     * 获取考核单据
     */
    @RequestMapping(AssessmentBillServiceProxy.GET_BY_ID)
    Result<AssessmentBill> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个考核单据
     */
    @RequestMapping(AssessmentBillServiceProxy.GET_BY_IDS)
    Result<List<AssessmentBill>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询考核单据
     */
    @RequestMapping(AssessmentBillServiceProxy.QUERY_LIST)
    Result<List<AssessmentBill>> queryList(@RequestParam(name = "sample") AssessmentBillVO sample);

    /**
     * 分页查询考核单据
     */
    @RequestMapping(AssessmentBillServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssessmentBill>> queryPagedList(@RequestParam(name = "sample") AssessmentBillVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.AssessmentBillController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssessmentBillServiceProxy api() {
        return APIProxy.get(AssessmentBillServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
