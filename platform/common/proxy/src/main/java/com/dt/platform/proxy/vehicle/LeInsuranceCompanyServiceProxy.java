package com.dt.platform.proxy.vehicle;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.vehicle.LeInsuranceCompany;
import com.dt.platform.domain.vehicle.LeInsuranceCompanyVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 车辆保险公司 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-28 22:03:17
 */
@FeignClient(value = ServiceNames.VEHICLE, contextId = LeInsuranceCompanyServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface LeInsuranceCompanyServiceProxy {

    /**
     * 基础路径 , service-vehicle
     */
    public static final String API_BASIC_PATH = "service-vehicle";

    /**
     * API 上下文路径 , oa-vehicle-insurance-company
     */
    public static final String API_CONTEXT_PATH = "oa-vehicle-insurance-company";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加车辆保险公司
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除车辆保险公司
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除车辆保险公司
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新车辆保险公司
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存车辆保险公司
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个车辆保险公司
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个车辆保险公司
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询车辆保险公司
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询车辆保险公司
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加车辆保险公司
     */
    @RequestMapping(LeInsuranceCompanyServiceProxy.INSERT)
    Result insert(@RequestParam(name = "leInsuranceCompanyVO") LeInsuranceCompanyVO leInsuranceCompanyVO);

    /**
     * 删除车辆保险公司
     */
    @RequestMapping(LeInsuranceCompanyServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除车辆保险公司
     */
    @RequestMapping(LeInsuranceCompanyServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新车辆保险公司
     */
    @RequestMapping(LeInsuranceCompanyServiceProxy.UPDATE)
    Result update(@RequestParam(name = "leInsuranceCompanyVO") LeInsuranceCompanyVO leInsuranceCompanyVO);

    /**
     * 更新车辆保险公司
     */
    @RequestMapping(LeInsuranceCompanyServiceProxy.SAVE)
    Result save(@RequestParam(name = "leInsuranceCompanyVO") LeInsuranceCompanyVO leInsuranceCompanyVO);

    /**
     * 获取车辆保险公司
     */
    @RequestMapping(LeInsuranceCompanyServiceProxy.GET_BY_ID)
    Result<LeInsuranceCompany> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个车辆保险公司
     */
    @RequestMapping(LeInsuranceCompanyServiceProxy.GET_BY_IDS)
    Result<List<LeInsuranceCompany>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询车辆保险公司
     */
    @RequestMapping(LeInsuranceCompanyServiceProxy.QUERY_LIST)
    Result<List<LeInsuranceCompany>> queryList(@RequestParam(name = "sample") LeInsuranceCompanyVO sample);

    /**
     * 分页查询车辆保险公司
     */
    @RequestMapping(LeInsuranceCompanyServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<LeInsuranceCompany>> queryPagedList(@RequestParam(name = "sample") LeInsuranceCompanyVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.vehicle.controller.LeInsuranceCompanyController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static LeInsuranceCompanyServiceProxy api() {
        return APIProxy.get(LeInsuranceCompanyServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
