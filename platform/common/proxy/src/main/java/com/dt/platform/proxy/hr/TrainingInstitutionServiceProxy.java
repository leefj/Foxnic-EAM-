package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.TrainingInstitution;
import com.dt.platform.domain.hr.TrainingInstitutionVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 培训机构 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-17 17:16:24
 */
@FeignClient(value = ServiceNames.HR, contextId = TrainingInstitutionServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface TrainingInstitutionServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-training-institution
     */
    public static final String API_CONTEXT_PATH = "hr-training-institution";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加培训机构
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除培训机构
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除培训机构
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新培训机构
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存培训机构
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个培训机构
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个培训机构
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询培训机构
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询培训机构
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加培训机构
     */
    @RequestMapping(TrainingInstitutionServiceProxy.INSERT)
    Result insert(@RequestParam(name = "trainingInstitutionVO") TrainingInstitutionVO trainingInstitutionVO);

    /**
     * 删除培训机构
     */
    @RequestMapping(TrainingInstitutionServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除培训机构
     */
    @RequestMapping(TrainingInstitutionServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新培训机构
     */
    @RequestMapping(TrainingInstitutionServiceProxy.UPDATE)
    Result update(@RequestParam(name = "trainingInstitutionVO") TrainingInstitutionVO trainingInstitutionVO);

    /**
     * 更新培训机构
     */
    @RequestMapping(TrainingInstitutionServiceProxy.SAVE)
    Result save(@RequestParam(name = "trainingInstitutionVO") TrainingInstitutionVO trainingInstitutionVO);

    /**
     * 获取培训机构
     */
    @RequestMapping(TrainingInstitutionServiceProxy.GET_BY_ID)
    Result<TrainingInstitution> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个培训机构
     */
    @RequestMapping(TrainingInstitutionServiceProxy.GET_BY_IDS)
    Result<List<TrainingInstitution>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询培训机构
     */
    @RequestMapping(TrainingInstitutionServiceProxy.QUERY_LIST)
    Result<List<TrainingInstitution>> queryList(@RequestParam(name = "sample") TrainingInstitutionVO sample);

    /**
     * 分页查询培训机构
     */
    @RequestMapping(TrainingInstitutionServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<TrainingInstitution>> queryPagedList(@RequestParam(name = "sample") TrainingInstitutionVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.TrainingInstitutionController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static TrainingInstitutionServiceProxy api() {
        return APIProxy.get(TrainingInstitutionServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
