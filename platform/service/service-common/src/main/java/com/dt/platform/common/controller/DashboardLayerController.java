package com.dt.platform.common.controller;

import java.util.*;
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


import com.dt.platform.proxy.common.DashboardLayerServiceProxy;
import com.dt.platform.domain.common.meta.DashboardLayerVOMeta;
import com.dt.platform.domain.common.DashboardLayer;
import com.dt.platform.domain.common.DashboardLayerVO;
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
import com.dt.platform.domain.common.meta.DashboardLayerMeta;
import com.dt.platform.domain.common.DashboardLayerEle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IDashboardLayerService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 面板层接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-23 15:37:14
*/

@InDoc
@Api(tags = "面板层")
@RestController("SysDashboardLayerController")
public class DashboardLayerController extends SuperController {

	@Autowired
	private IDashboardLayerService dashboardLayerService;

	/**
	 * 添加面板层
	*/
	@ApiOperation(value = "添加面板层")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DashboardLayerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "768750314323968000"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.DASHBOARD_ID , value = "面板" , required = false , dataTypeClass=String.class , example = "768578249050554368"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "列6"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.COL_TYPE , value = "列数" , required = false , dataTypeClass=String.class , example = "six"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DashboardLayerServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DashboardLayerServiceProxy.INSERT)
	public Result insert(DashboardLayerVO dashboardLayerVO) {
		
		Result result=dashboardLayerService.insert(dashboardLayerVO,false);
		return result;
	}



	/**
	 * 删除面板层
	*/
	@ApiOperation(value = "删除面板层")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DashboardLayerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "768750314323968000")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DashboardLayerServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DashboardLayerServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  dashboardLayerService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=dashboardLayerService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除面板层 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除面板层")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DashboardLayerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = DashboardLayerServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DashboardLayerServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = dashboardLayerService.hasRefers(ids);
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
			Result result=dashboardLayerService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=dashboardLayerService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新面板层
	*/
	@ApiOperation(value = "更新面板层")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DashboardLayerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "768750314323968000"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.DASHBOARD_ID , value = "面板" , required = false , dataTypeClass=String.class , example = "768578249050554368"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "列6"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.COL_TYPE , value = "列数" , required = false , dataTypeClass=String.class , example = "six"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DashboardLayerVOMeta.PAGE_INDEX , DashboardLayerVOMeta.PAGE_SIZE , DashboardLayerVOMeta.SEARCH_FIELD , DashboardLayerVOMeta.FUZZY_FIELD , DashboardLayerVOMeta.SEARCH_VALUE , DashboardLayerVOMeta.DIRTY_FIELDS , DashboardLayerVOMeta.SORT_FIELD , DashboardLayerVOMeta.SORT_TYPE , DashboardLayerVOMeta.DATA_ORIGIN , DashboardLayerVOMeta.QUERY_LOGIC , DashboardLayerVOMeta.REQUEST_ACTION , DashboardLayerVOMeta.IDS } )
	@SentinelResource(value = DashboardLayerServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DashboardLayerServiceProxy.UPDATE)
	public Result update(DashboardLayerVO dashboardLayerVO) {
		
		Result result=dashboardLayerService.update(dashboardLayerVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存面板层
	*/
	@ApiOperation(value = "保存面板层")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DashboardLayerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "768750314323968000"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.DASHBOARD_ID , value = "面板" , required = false , dataTypeClass=String.class , example = "768578249050554368"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "列6"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.COL_TYPE , value = "列数" , required = false , dataTypeClass=String.class , example = "six"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DashboardLayerVOMeta.PAGE_INDEX , DashboardLayerVOMeta.PAGE_SIZE , DashboardLayerVOMeta.SEARCH_FIELD , DashboardLayerVOMeta.FUZZY_FIELD , DashboardLayerVOMeta.SEARCH_VALUE , DashboardLayerVOMeta.DIRTY_FIELDS , DashboardLayerVOMeta.SORT_FIELD , DashboardLayerVOMeta.SORT_TYPE , DashboardLayerVOMeta.DATA_ORIGIN , DashboardLayerVOMeta.QUERY_LOGIC , DashboardLayerVOMeta.REQUEST_ACTION , DashboardLayerVOMeta.IDS } )
	@SentinelResource(value = DashboardLayerServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DashboardLayerServiceProxy.SAVE)
	public Result save(DashboardLayerVO dashboardLayerVO) {
		
		Result result=dashboardLayerService.save(dashboardLayerVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取面板层
	*/
	@ApiOperation(value = "获取面板层")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DashboardLayerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DashboardLayerServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DashboardLayerServiceProxy.GET_BY_ID)
	public Result<DashboardLayer> getById(String id) {
		
		Result<DashboardLayer> result=new Result<>();
		DashboardLayer dashboardLayer=dashboardLayerService.getById(id);
		result.success(true).data(dashboardLayer);
		return result;
	}


	/**
	 * 批量获取面板层 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取面板层")
		@ApiImplicitParams({
				@ApiImplicitParam(name = DashboardLayerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = DashboardLayerServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DashboardLayerServiceProxy.GET_BY_IDS)
	public Result<List<DashboardLayer>> getByIds(List<String> ids) {
		
		Result<List<DashboardLayer>> result=new Result<>();
		List<DashboardLayer> list=dashboardLayerService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询面板层
	*/
	@ApiOperation(value = "查询面板层")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DashboardLayerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "768750314323968000"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.DASHBOARD_ID , value = "面板" , required = false , dataTypeClass=String.class , example = "768578249050554368"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "列6"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.COL_TYPE , value = "列数" , required = false , dataTypeClass=String.class , example = "six"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DashboardLayerVOMeta.PAGE_INDEX , DashboardLayerVOMeta.PAGE_SIZE } )
	@SentinelResource(value = DashboardLayerServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DashboardLayerServiceProxy.QUERY_LIST)
	public Result<List<DashboardLayer>> queryList(DashboardLayerVO sample) {
		
		Result<List<DashboardLayer>> result=new Result<>();
		List<DashboardLayer> list=dashboardLayerService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询面板层
	*/
	@ApiOperation(value = "分页查询面板层")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DashboardLayerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "768750314323968000"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.DASHBOARD_ID , value = "面板" , required = false , dataTypeClass=String.class , example = "768578249050554368"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "列6"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.COL_TYPE , value = "列数" , required = false , dataTypeClass=String.class , example = "six"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = DashboardLayerVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DashboardLayerServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DashboardLayerServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<DashboardLayer>> queryPagedList(DashboardLayerVO sample) {
		
		Result<PagedList<DashboardLayer>> result=new Result<>();
		PagedList<DashboardLayer> list=dashboardLayerService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}