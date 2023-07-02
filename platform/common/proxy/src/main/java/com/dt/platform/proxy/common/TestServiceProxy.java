package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.Test;
import com.dt.platform.domain.common.TestVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 车辆保险公司 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 13:27:09
 */
@FeignClient(value = ServiceNames.COMMON, contextId = TestServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface TestServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-test
     */
    public static final String API_CONTEXT_PATH = "sys-test";

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
    @RequestMapping(TestServiceProxy.INSERT)
    Result insert(@RequestParam(name = "testVO") TestVO testVO);

    /**
     * 删除车辆保险公司
     */
    @RequestMapping(TestServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除车辆保险公司
     */
    @RequestMapping(TestServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新车辆保险公司
     */
    @RequestMapping(TestServiceProxy.UPDATE)
    Result update(@RequestParam(name = "testVO") TestVO testVO);

    /**
     * 更新车辆保险公司
     */
    @RequestMapping(TestServiceProxy.SAVE)
    Result save(@RequestParam(name = "testVO") TestVO testVO);

    /**
     * 获取车辆保险公司
     */
    @RequestMapping(TestServiceProxy.GET_BY_ID)
    Result<Test> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个车辆保险公司
     */
    @RequestMapping(TestServiceProxy.GET_BY_IDS)
    Result<List<Test>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询车辆保险公司
     */
    @RequestMapping(TestServiceProxy.QUERY_LIST)
    Result<List<Test>> queryList(@RequestParam(name = "sample") TestVO sample);

    /**
     * 分页查询车辆保险公司
     */
    @RequestMapping(TestServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Test>> queryPagedList(@RequestParam(name = "sample") TestVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.TestController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static TestServiceProxy api() {
        return APIProxy.get(TestServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}