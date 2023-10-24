package com.dt.platform.common.controller;

import java.util.*;

import com.dt.platform.domain.common.DashboardLayer;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.api.swagger.InDoc;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;


import com.dt.platform.proxy.common.DashboardServiceProxy;
import com.dt.platform.domain.common.meta.DashboardVOMeta;
import com.dt.platform.domain.common.Dashboard;
import com.dt.platform.domain.common.DashboardVO;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.foxnic.dao.data.PagedList;
import java.util.Date;
import java.sql.Timestamp;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.commons.io.StreamUtil;
import java.util.Map;
import com.github.foxnic.dao.excel.ValidateResult;
import java.io.InputStream;
import com.dt.platform.domain.common.meta.DashboardMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IDashboardService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 面板接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-22 20:42:09
*/

@InDoc
@Api(tags = "面板")
@RestController("SysDashboardController")
public class DashboardController extends SuperController {

	@Autowired
	private IDashboardService dashboardService;

	/**
	 * 添加面板
	*/
	@ApiOperation(value = "添加面板")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DashboardVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DashboardServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DashboardServiceProxy.INSERT)
	public Result insert(DashboardVO dashboardVO) {
		
		Result result=dashboardService.insert(dashboardVO,false);
		return result;
	}



	/**
	 * 删除面板
	*/
	@ApiOperation(value = "删除面板")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DashboardVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DashboardServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DashboardServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  dashboardService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=dashboardService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除面板 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除面板")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DashboardVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = DashboardServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DashboardServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = dashboardService.hasRefers(ids);
		// 收集可以删除的ID值
		List<String> canDeleteIds = new ArrayList<>();
		for (Map.Entry<String, ReferCause> e : causeMap.entrySet()) {
			if (!e.getValue().hasRefer()) {
				canDeleteIds.add(e.getKey());
			}
		}

		// 执行删除
		if (canDeleteIds.isEmpty()) {
			// 如果没有一行可以被删除
			return ErrorDesc.failure().message("无法删除您选中的数据行：").data(0)
				.addErrors(CollectorUtil.collectArray(CollectorUtil.filter(causeMap.values(),(e)->{return e.hasRefer();}),ReferCause::message,String.class))
				.messageLevel4Confirm();
		} else if (canDeleteIds.size() == ids.size()) {
			// 如果全部可以删除
			Result result=dashboardService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=dashboardService.deleteByIdsLogical(canDeleteIds);
			if (result.failure()) {
				return result;
			} else {
				return ErrorDesc.success().message("已删除 " + canDeleteIds.size() + " 行，但另有 " + (ids.size() - canDeleteIds.size()) + " 行数据无法删除").data(canDeleteIds.size())
				.addErrors(CollectorUtil.collectArray(CollectorUtil.filter(causeMap.values(),(e)->{return e.hasRefer();}),ReferCause::message,String.class))
				.messageLevel4Confirm();
			}
		} else {
			// 理论上，这个分支不存在
			return ErrorDesc.success().message("数据删除未处理");
		}
	}

	/**
	 * 更新面板
	*/
	@ApiOperation(value = "更新面板")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DashboardVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DashboardVOMeta.PAGE_INDEX , DashboardVOMeta.PAGE_SIZE , DashboardVOMeta.SEARCH_FIELD , DashboardVOMeta.FUZZY_FIELD , DashboardVOMeta.SEARCH_VALUE , DashboardVOMeta.DIRTY_FIELDS , DashboardVOMeta.SORT_FIELD , DashboardVOMeta.SORT_TYPE , DashboardVOMeta.DATA_ORIGIN , DashboardVOMeta.QUERY_LOGIC , DashboardVOMeta.REQUEST_ACTION , DashboardVOMeta.IDS } )
	@SentinelResource(value = DashboardServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DashboardServiceProxy.UPDATE)
	public Result update(DashboardVO dashboardVO) {
		
		Result result=dashboardService.update(dashboardVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}

	/**
	 * 获取面板
	 */
	@ApiOperation(value = "获取面板")
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DashboardVOMeta.PAGE_INDEX , DashboardVOMeta.PAGE_SIZE , DashboardVOMeta.SEARCH_FIELD , DashboardVOMeta.FUZZY_FIELD , DashboardVOMeta.SEARCH_VALUE , DashboardVOMeta.DIRTY_FIELDS , DashboardVOMeta.SORT_FIELD , DashboardVOMeta.SORT_TYPE , DashboardVOMeta.DATA_ORIGIN , DashboardVOMeta.QUERY_LOGIC , DashboardVOMeta.REQUEST_ACTION , DashboardVOMeta.IDS } )
	@SentinelResource(value = DashboardServiceProxy.QUERY_BY_CODE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DashboardServiceProxy.QUERY_BY_CODE)
	public Result<List<DashboardLayer>> queryByCode(String code) {
		Result<List<DashboardLayer>> res=new Result<>();
		res.data(dashboardService.queryByCode(code));
		res.success(true);
		return res;

	}


	/**
	 * 保存面板
	*/
	@ApiOperation(value = "保存面板")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DashboardVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DashboardVOMeta.PAGE_INDEX , DashboardVOMeta.PAGE_SIZE , DashboardVOMeta.SEARCH_FIELD , DashboardVOMeta.FUZZY_FIELD , DashboardVOMeta.SEARCH_VALUE , DashboardVOMeta.DIRTY_FIELDS , DashboardVOMeta.SORT_FIELD , DashboardVOMeta.SORT_TYPE , DashboardVOMeta.DATA_ORIGIN , DashboardVOMeta.QUERY_LOGIC , DashboardVOMeta.REQUEST_ACTION , DashboardVOMeta.IDS } )
	@SentinelResource(value = DashboardServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DashboardServiceProxy.SAVE)
	public Result save(DashboardVO dashboardVO) {
		
		Result result=dashboardService.save(dashboardVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取面板
	*/
	@ApiOperation(value = "获取面板")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DashboardVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DashboardServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DashboardServiceProxy.GET_BY_ID)
	public Result<Dashboard> getById(String id) {
		
		Result<Dashboard> result=new Result<>();
		Dashboard dashboard=dashboardService.getById(id);
		result.success(true).data(dashboard);
		return result;
	}


	/**
	 * 批量获取面板 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取面板")
		@ApiImplicitParams({
				@ApiImplicitParam(name = DashboardVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = DashboardServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DashboardServiceProxy.GET_BY_IDS)
	public Result<List<Dashboard>> getByIds(List<String> ids) {
		
		Result<List<Dashboard>> result=new Result<>();
		List<Dashboard> list=dashboardService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询面板
	*/
	@ApiOperation(value = "查询面板")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DashboardVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DashboardVOMeta.PAGE_INDEX , DashboardVOMeta.PAGE_SIZE } )
	@SentinelResource(value = DashboardServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DashboardServiceProxy.QUERY_LIST)
	public Result<List<Dashboard>> queryList(DashboardVO sample) {
		
		Result<List<Dashboard>> result=new Result<>();
		List<Dashboard> list=dashboardService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询面板
	*/
	@ApiOperation(value = "分页查询面板")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DashboardVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DashboardServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DashboardServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Dashboard>> queryPagedList(DashboardVO sample) {
		
		Result<PagedList<Dashboard>> result=new Result<>();
		PagedList<Dashboard> list=dashboardService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}