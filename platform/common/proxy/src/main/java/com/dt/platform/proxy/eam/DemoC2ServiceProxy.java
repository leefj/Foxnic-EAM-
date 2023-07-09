package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.DemoC2;
import com.dt.platform.domain.eam.DemoC2VO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * demo 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-08 08:04:40
 */
@FeignClient(value = ServiceNames.EAM, contextId = DemoC2ServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface DemoC2ServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-demo-c2
     */
    public static final String API_CONTEXT_PATH = "eam-demo-c2";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加demo
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除demo
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除demo
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新demo
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存demo
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个demo
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个demo
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询demo
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询demo
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加demo
     */
    @RequestMapping(DemoC2ServiceProxy.INSERT)
    Result insert(@RequestParam(name = "demoC2VO") DemoC2VO demoC2VO);

    /**
     * 删除demo
     */
    @RequestMapping(DemoC2ServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除demo
     */
    @RequestMapping(DemoC2ServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新demo
     */
    @RequestMapping(DemoC2ServiceProxy.UPDATE)
    Result update(@RequestParam(name = "demoC2VO") DemoC2VO demoC2VO);

    /**
     * 更新demo
     */
    @RequestMapping(DemoC2ServiceProxy.SAVE)
    Result save(@RequestParam(name = "demoC2VO") DemoC2VO demoC2VO);

    /**
     * 获取demo
     */
    @RequestMapping(DemoC2ServiceProxy.GET_BY_ID)
    Result<DemoC2> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个demo
     */
    @RequestMapping(DemoC2ServiceProxy.GET_BY_IDS)
    Result<List<DemoC2>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询demo
     */
    @RequestMapping(DemoC2ServiceProxy.QUERY_LIST)
    Result<List<DemoC2>> queryList(@RequestParam(name = "sample") DemoC2VO sample);

    /**
     * 分页查询demo
     */
    @RequestMapping(DemoC2ServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<DemoC2>> queryPagedList(@RequestParam(name = "sample") DemoC2VO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.DemoC2Controller";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static DemoC2ServiceProxy api() {
        return APIProxy.get(DemoC2ServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
