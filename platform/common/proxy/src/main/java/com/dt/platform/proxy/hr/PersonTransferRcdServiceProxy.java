package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.PersonTransferRcd;
import com.dt.platform.domain.hr.PersonTransferRcdVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 员工调动记录 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-23 20:23:44
 */
@FeignClient(value = ServiceNames.HR, contextId = PersonTransferRcdServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PersonTransferRcdServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-person-transfer-rcd
     */
    public static final String API_CONTEXT_PATH = "hr-person-transfer-rcd";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加员工调动记录
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除员工调动记录
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除员工调动记录
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新员工调动记录
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存员工调动记录
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个员工调动记录
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个员工调动记录
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询员工调动记录
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询员工调动记录
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";



    /**
     * 添加员工调动记录
     */
    @RequestMapping(PersonTransferRcdServiceProxy.INSERT)
    Result insert(@RequestParam(name = "personTransferRcdVO") PersonTransferRcdVO personTransferRcdVO);

    /**
     * 删除员工调动记录
     */
    @RequestMapping(PersonTransferRcdServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除员工调动记录
     */
    @RequestMapping(PersonTransferRcdServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新员工调动记录
     */
    @RequestMapping(PersonTransferRcdServiceProxy.UPDATE)
    Result update(@RequestParam(name = "personTransferRcdVO") PersonTransferRcdVO personTransferRcdVO);

    /**
     * 更新员工调动记录
     */
    @RequestMapping(PersonTransferRcdServiceProxy.SAVE)
    Result save(@RequestParam(name = "personTransferRcdVO") PersonTransferRcdVO personTransferRcdVO);

    /**
     * 获取员工调动记录
     */
    @RequestMapping(PersonTransferRcdServiceProxy.GET_BY_ID)
    Result<PersonTransferRcd> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个员工调动记录
     */
    @RequestMapping(PersonTransferRcdServiceProxy.GET_BY_IDS)
    Result<List<PersonTransferRcd>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询员工调动记录
     */
    @RequestMapping(PersonTransferRcdServiceProxy.QUERY_LIST)
    Result<List<PersonTransferRcd>> queryList(@RequestParam(name = "sample") PersonTransferRcdVO sample);

    /**
     * 分页查询员工调动记录
     */
    @RequestMapping(PersonTransferRcdServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<PersonTransferRcd>> queryPagedList(@RequestParam(name = "sample") PersonTransferRcdVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.PersonTransferRcdController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static PersonTransferRcdServiceProxy api() {
        return APIProxy.get(PersonTransferRcdServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
