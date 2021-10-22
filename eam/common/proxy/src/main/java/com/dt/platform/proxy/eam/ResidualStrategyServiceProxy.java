package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.platform.domain.eam.ResidualStrategy;
import com.dt.platform.domain.eam.ResidualStrategyVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 折旧策略  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-22 21:48:01
*/

@FeignClient(value = ServiceNames.EAM, contextId = ResidualStrategyServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface ResidualStrategyServiceProxy {

	/**
	 * 基础路径 , service-eam
	*/
	public static final String API_BASIC_PATH = "service-eam";

	/**
	 * API 上下文路径 , eam-residual-strategy
	*/
	public static final String API_CONTEXT_PATH = "eam-residual-strategy";

	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";

	/**
	 * 添加折旧策略
	 */
	public static final String INSERT = API_PREFIX + "insert";

;
	/**
	 * 删除折旧策略
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除折旧策略
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

	/**
	 * 更新折旧策略
	 */
	public static final String UPDATE = API_PREFIX + "update";


	/**
	 * 保存折旧策略
	 */
	public static final String SAVE = API_PREFIX + "save";

	/**
	 * 获取单个折旧策略
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个折旧策略
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

	/**
	 * 查询折旧策略
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";

	/**
	 * 分页查询折旧策略
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

	/**
	 * 导出折旧策略数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载折旧策略导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

	/**
	 * 导入折旧策略数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

	/**
	 * 添加折旧策略
	*/
	@RequestMapping(ResidualStrategyServiceProxy.INSERT)
	Result insert(ResidualStrategyVO residualStrategyVO);

	/**
	 * 删除折旧策略
	*/
	@RequestMapping(ResidualStrategyServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除折旧策略
	*/
	@RequestMapping(ResidualStrategyServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新折旧策略
	*/
	@RequestMapping(ResidualStrategyServiceProxy.UPDATE)
	Result update(ResidualStrategyVO residualStrategyVO);

	/**
	 * 更新折旧策略
	*/
	@RequestMapping(ResidualStrategyServiceProxy.SAVE)
	Result save(ResidualStrategyVO residualStrategyVO);

	/**
	 * 获取折旧策略
	*/
	@RequestMapping(ResidualStrategyServiceProxy.GET_BY_ID)
	Result<ResidualStrategy> getById(String id);

	/**
	 * 批量删除折旧策略
	*/
	@RequestMapping(ResidualStrategyServiceProxy.GET_BY_IDS)
	Result<List<ResidualStrategy>> getByIds(List<String> ids);
	/**
	 * 查询折旧策略
	*/
	@RequestMapping(ResidualStrategyServiceProxy.QUERY_LIST)
	Result<List<ResidualStrategy>> queryList(ResidualStrategyVO sample);

	/**
	 * 分页查询折旧策略
	*/
	@RequestMapping(ResidualStrategyServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<ResidualStrategy>> queryPagedList(ResidualStrategyVO sample);


	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.eam.controller.ResidualStrategyController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static ResidualStrategyServiceProxy api() {
		return APIProxy.get(ResidualStrategyServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}