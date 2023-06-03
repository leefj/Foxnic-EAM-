package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.DemoTest;
import com.dt.platform.domain.common.DemoTestVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 测试 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-03 06:53:40
 */
@FeignClient(value = ServiceNames.COMMON, contextId = DemoTestServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface DemoTestServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-demo-test
     */
    public static final String API_CONTEXT_PATH = "sys-demo-test";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加测试
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除测试
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除测试
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新测试
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存测试
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个测试
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个测试
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询测试
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询测试
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加测试
     */
    @RequestMapping(DemoTestServiceProxy.INSERT)
    Result insert(@RequestParam(name = "demoTestVO") DemoTestVO demoTestVO);

    /**
     * 删除测试
     */
    @RequestMapping(DemoTestServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除测试
     */
    @RequestMapping(DemoTestServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新测试
     */
    @RequestMapping(DemoTestServiceProxy.UPDATE)
    Result update(@RequestParam(name = "demoTestVO") DemoTestVO demoTestVO);

    /**
     * 更新测试
     */
    @RequestMapping(DemoTestServiceProxy.SAVE)
    Result save(@RequestParam(name = "demoTestVO") DemoTestVO demoTestVO);

    /**
     * 获取测试
     */
    @RequestMapping(DemoTestServiceProxy.GET_BY_ID)
    Result<DemoTest> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个测试
     */
    @RequestMapping(DemoTestServiceProxy.GET_BY_IDS)
    Result<List<DemoTest>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询测试
     */
    @RequestMapping(DemoTestServiceProxy.QUERY_LIST)
    Result<List<DemoTest>> queryList(@RequestParam(name = "sample") DemoTestVO sample);

    /**
     * 分页查询测试
     */
    @RequestMapping(DemoTestServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<DemoTest>> queryPagedList(@RequestParam(name = "sample") DemoTestVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.DemoTestController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static DemoTestServiceProxy api() {
        return APIProxy.get(DemoTestServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
