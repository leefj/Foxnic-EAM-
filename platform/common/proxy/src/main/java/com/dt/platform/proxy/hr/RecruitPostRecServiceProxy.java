package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.RecruitPostRec;
import com.dt.platform.domain.hr.RecruitPostRecVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 招聘岗位 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-05 15:28:54
 */
@FeignClient(value = ServiceNames.HR, contextId = RecruitPostRecServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface RecruitPostRecServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-recruit-post-rec
     */
    public static final String API_CONTEXT_PATH = "hr-recruit-post-rec";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加招聘岗位
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除招聘岗位
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除招聘岗位
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新招聘岗位
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存招聘岗位
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个招聘岗位
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个招聘岗位
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询招聘岗位
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询招聘岗位
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加招聘岗位
     */
    @RequestMapping(RecruitPostRecServiceProxy.INSERT)
    Result insert(@RequestParam(name = "recruitPostRecVO") RecruitPostRecVO recruitPostRecVO);

    /**
     * 删除招聘岗位
     */
    @RequestMapping(RecruitPostRecServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除招聘岗位
     */
    @RequestMapping(RecruitPostRecServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新招聘岗位
     */
    @RequestMapping(RecruitPostRecServiceProxy.UPDATE)
    Result update(@RequestParam(name = "recruitPostRecVO") RecruitPostRecVO recruitPostRecVO);

    /**
     * 更新招聘岗位
     */
    @RequestMapping(RecruitPostRecServiceProxy.SAVE)
    Result save(@RequestParam(name = "recruitPostRecVO") RecruitPostRecVO recruitPostRecVO);

    /**
     * 获取招聘岗位
     */
    @RequestMapping(RecruitPostRecServiceProxy.GET_BY_ID)
    Result<RecruitPostRec> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个招聘岗位
     */
    @RequestMapping(RecruitPostRecServiceProxy.GET_BY_IDS)
    Result<List<RecruitPostRec>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询招聘岗位
     */
    @RequestMapping(RecruitPostRecServiceProxy.QUERY_LIST)
    Result<List<RecruitPostRec>> queryList(@RequestParam(name = "sample") RecruitPostRecVO sample);

    /**
     * 分页查询招聘岗位
     */
    @RequestMapping(RecruitPostRecServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<RecruitPostRec>> queryPagedList(@RequestParam(name = "sample") RecruitPostRecVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.RecruitPostRecController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static RecruitPostRecServiceProxy api() {
        return APIProxy.get(RecruitPostRecServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
