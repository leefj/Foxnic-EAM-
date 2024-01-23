package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.PersonScore;
import com.dt.platform.domain.hr.PersonScoreVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 积分明细 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-22 09:34:36
 */
@FeignClient(value = ServiceNames.HR, contextId = PersonScoreServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PersonScoreServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-person-score
     */
    public static final String API_CONTEXT_PATH = "hr-person-score";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加积分明细
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除积分明细
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除积分明细
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新积分明细
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存积分明细
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个积分明细
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个积分明细
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询积分明细
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询积分明细
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加积分明细
     */
    @RequestMapping(PersonScoreServiceProxy.INSERT)
    Result insert(@RequestParam(name = "personScoreVO") PersonScoreVO personScoreVO);

    /**
     * 删除积分明细
     */
    @RequestMapping(PersonScoreServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除积分明细
     */
    @RequestMapping(PersonScoreServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新积分明细
     */
    @RequestMapping(PersonScoreServiceProxy.UPDATE)
    Result update(@RequestParam(name = "personScoreVO") PersonScoreVO personScoreVO);

    /**
     * 更新积分明细
     */
    @RequestMapping(PersonScoreServiceProxy.SAVE)
    Result save(@RequestParam(name = "personScoreVO") PersonScoreVO personScoreVO);

    /**
     * 获取积分明细
     */
    @RequestMapping(PersonScoreServiceProxy.GET_BY_ID)
    Result<PersonScore> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个积分明细
     */
    @RequestMapping(PersonScoreServiceProxy.GET_BY_IDS)
    Result<List<PersonScore>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询积分明细
     */
    @RequestMapping(PersonScoreServiceProxy.QUERY_LIST)
    Result<List<PersonScore>> queryList(@RequestParam(name = "sample") PersonScoreVO sample);

    /**
     * 分页查询积分明细
     */
    @RequestMapping(PersonScoreServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<PersonScore>> queryPagedList(@RequestParam(name = "sample") PersonScoreVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.PersonScoreController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static PersonScoreServiceProxy api() {
        return APIProxy.get(PersonScoreServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
