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


import com.dt.platform.proxy.common.DashboardLayerEleServiceProxy;
import com.dt.platform.domain.common.meta.DashboardLayerEleVOMeta;
import com.dt.platform.domain.common.DashboardLayerEle;
import com.dt.platform.domain.common.DashboardLayerEleVO;
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
import com.dt.platform.domain.common.meta.DashboardLayerEleMeta;
import com.dt.platform.domain.common.DashboardLayer;
import com.dt.platform.domain.common.Report;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IDashboardLayerEleService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 组件接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-23 16:32:44
*/

@InDoc
@Api(tags = "组件")
@RestController("SysDashboardLayerEleController")
public class DashboardLayerEleController extends SuperController {

	@Autowired
	private IDashboardLayerEleService dashboardLayerEleService;

	/**
	 * 添加组件
	*/
	@ApiOperation(value = "添加组件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "768755922204884992"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.LAYER_ID , value = "面板" , required = false , dataTypeClass=String.class , example = "768750314323968000"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.DASHBOARD_ID , value = "面板分层" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class , example = "测试"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "card"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.SOURCE , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.JSON , value = "配置" , required = false , dataTypeClass=String.class , example = "{ ct:\"select 100 value\", desc:\"测试\" }"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DashboardLayerEleServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DashboardLayerEleServiceProxy.INSERT)
	public Result insert(DashboardLayerEleVO dashboardLayerEleVO) {
		
		Result result=dashboardLayerEleService.insert(dashboardLayerEleVO,false);
		return result;
	}



	/**
	 * 删除组件
	*/
	@ApiOperation(value = "删除组件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "768755922204884992")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DashboardLayerEleServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DashboardLayerEleServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  dashboardLayerEleService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=dashboardLayerEleService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除组件 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除组件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = DashboardLayerEleServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DashboardLayerEleServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = dashboardLayerEleService.hasRefers(ids);
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
			Result result=dashboardLayerEleService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=dashboardLayerEleService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新组件
	*/
	@ApiOperation(value = "更新组件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "768755922204884992"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.LAYER_ID , value = "面板" , required = false , dataTypeClass=String.class , example = "768750314323968000"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.DASHBOARD_ID , value = "面板分层" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class , example = "测试"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "card"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.SOURCE , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.JSON , value = "配置" , required = false , dataTypeClass=String.class , example = "{ ct:\"select 100 value\", desc:\"测试\" }"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DashboardLayerEleVOMeta.PAGE_INDEX , DashboardLayerEleVOMeta.PAGE_SIZE , DashboardLayerEleVOMeta.SEARCH_FIELD , DashboardLayerEleVOMeta.FUZZY_FIELD , DashboardLayerEleVOMeta.SEARCH_VALUE , DashboardLayerEleVOMeta.DIRTY_FIELDS , DashboardLayerEleVOMeta.SORT_FIELD , DashboardLayerEleVOMeta.SORT_TYPE , DashboardLayerEleVOMeta.DATA_ORIGIN , DashboardLayerEleVOMeta.QUERY_LOGIC , DashboardLayerEleVOMeta.REQUEST_ACTION , DashboardLayerEleVOMeta.IDS } )
	@SentinelResource(value = DashboardLayerEleServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DashboardLayerEleServiceProxy.UPDATE)
	public Result update(DashboardLayerEleVO dashboardLayerEleVO) {
		
		Result result=dashboardLayerEleService.update(dashboardLayerEleVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存组件
	*/
	@ApiOperation(value = "保存组件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "768755922204884992"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.LAYER_ID , value = "面板" , required = false , dataTypeClass=String.class , example = "768750314323968000"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.DASHBOARD_ID , value = "面板分层" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class , example = "测试"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "card"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.SOURCE , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.JSON , value = "配置" , required = false , dataTypeClass=String.class , example = "{ ct:\"select 100 value\", desc:\"测试\" }"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DashboardLayerEleVOMeta.PAGE_INDEX , DashboardLayerEleVOMeta.PAGE_SIZE , DashboardLayerEleVOMeta.SEARCH_FIELD , DashboardLayerEleVOMeta.FUZZY_FIELD , DashboardLayerEleVOMeta.SEARCH_VALUE , DashboardLayerEleVOMeta.DIRTY_FIELDS , DashboardLayerEleVOMeta.SORT_FIELD , DashboardLayerEleVOMeta.SORT_TYPE , DashboardLayerEleVOMeta.DATA_ORIGIN , DashboardLayerEleVOMeta.QUERY_LOGIC , DashboardLayerEleVOMeta.REQUEST_ACTION , DashboardLayerEleVOMeta.IDS } )
	@SentinelResource(value = DashboardLayerEleServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DashboardLayerEleServiceProxy.SAVE)
	public Result save(DashboardLayerEleVO dashboardLayerEleVO) {
		
		Result result=dashboardLayerEleService.save(dashboardLayerEleVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取组件
	*/
	@ApiOperation(value = "获取组件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DashboardLayerEleServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DashboardLayerEleServiceProxy.GET_BY_ID)
	public Result<DashboardLayerEle> getById(String id) {
		
		Result<DashboardLayerEle> result=new Result<>();
		DashboardLayerEle dashboardLayerEle=dashboardLayerEleService.getById(id);
		// join 关联的对象
		dashboardLayerEleService.dao().fill(dashboardLayerEle)
			.with(DashboardLayerEleMeta.DASHBOARD_LAYER)
			.with(DashboardLayerEleMeta.REPORT_CHART)
			.execute();
		result.success(true).data(dashboardLayerEle);
		return result;
	}


	/**
	 * 批量获取组件 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取组件")
		@ApiImplicitParams({
				@ApiImplicitParam(name = DashboardLayerEleVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = DashboardLayerEleServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DashboardLayerEleServiceProxy.GET_BY_IDS)
	public Result<List<DashboardLayerEle>> getByIds(List<String> ids) {
		
		Result<List<DashboardLayerEle>> result=new Result<>();
		List<DashboardLayerEle> list=dashboardLayerEleService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询组件
	*/
	@ApiOperation(value = "查询组件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "768755922204884992"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.LAYER_ID , value = "面板" , required = false , dataTypeClass=String.class , example = "768750314323968000"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.DASHBOARD_ID , value = "面板分层" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class , example = "测试"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "card"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.SOURCE , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.JSON , value = "配置" , required = false , dataTypeClass=String.class , example = "{ ct:\"select 100 value\", desc:\"测试\" }"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DashboardLayerEleVOMeta.PAGE_INDEX , DashboardLayerEleVOMeta.PAGE_SIZE } )
	@SentinelResource(value = DashboardLayerEleServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DashboardLayerEleServiceProxy.QUERY_LIST)
	public Result<List<DashboardLayerEle>> queryList(DashboardLayerEleVO sample) {
		
		Result<List<DashboardLayerEle>> result=new Result<>();
		List<DashboardLayerEle> list=dashboardLayerEleService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询组件
	*/
	@ApiOperation(value = "分页查询组件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "768755922204884992"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.LAYER_ID , value = "面板" , required = false , dataTypeClass=String.class , example = "768750314323968000"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.DASHBOARD_ID , value = "面板分层" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class , example = "测试"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "card"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.SOURCE , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.JSON , value = "配置" , required = false , dataTypeClass=String.class , example = "{ ct:\"select 100 value\", desc:\"测试\" }"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = DashboardLayerEleVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DashboardLayerEleServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DashboardLayerEleServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<DashboardLayerEle>> queryPagedList(DashboardLayerEleVO sample) {
		
		Result<PagedList<DashboardLayerEle>> result=new Result<>();
		PagedList<DashboardLayerEle> list=dashboardLayerEleService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		dashboardLayerEleService.dao().fill(list)
			.with(DashboardLayerEleMeta.DASHBOARD_LAYER)
			.with(DashboardLayerEleMeta.REPORT_CHART)
			.execute();
		result.success(true).data(list);
		return result;
	}





}