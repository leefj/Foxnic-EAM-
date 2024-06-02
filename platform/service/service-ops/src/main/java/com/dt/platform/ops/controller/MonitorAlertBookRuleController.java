package com.dt.platform.ops.controller;

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


import com.dt.platform.proxy.ops.MonitorAlertBookRuleServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorAlertBookRuleVOMeta;
import com.dt.platform.domain.ops.MonitorAlertBookRule;
import com.dt.platform.domain.ops.MonitorAlertBookRuleVO;
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
import com.dt.platform.domain.ops.meta.MonitorAlertBookRuleMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorAlertBookRuleService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 订阅规则接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-06-01 07:08:52
*/

@InDoc
@Api(tags = "订阅规则")
@RestController("OpsMonitorAlertBookRuleController")
public class MonitorAlertBookRuleController extends SuperController {

	@Autowired
	private IMonitorAlertBookRuleService monitorAlertBookRuleService;

	/**
	 * 添加订阅规则
	*/
	@ApiOperation(value = "添加订阅规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertBookRuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookRuleVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookRuleVOMeta.BOOK_ID , value = "订阅" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookRuleVOMeta.VALUE , value = "数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookRuleVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MonitorAlertBookRuleServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorAlertBookRuleServiceProxy.INSERT)
	public Result insert(MonitorAlertBookRuleVO monitorAlertBookRuleVO) {
		
		Result result=monitorAlertBookRuleService.insert(monitorAlertBookRuleVO,false);
		return result;
	}



	/**
	 * 删除订阅规则
	*/
	@ApiOperation(value = "删除订阅规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertBookRuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MonitorAlertBookRuleServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorAlertBookRuleServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  monitorAlertBookRuleService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=monitorAlertBookRuleService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除订阅规则 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除订阅规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertBookRuleVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = MonitorAlertBookRuleServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorAlertBookRuleServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = monitorAlertBookRuleService.hasRefers(ids);
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
			Result result=monitorAlertBookRuleService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=monitorAlertBookRuleService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新订阅规则
	*/
	@ApiOperation(value = "更新订阅规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertBookRuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookRuleVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookRuleVOMeta.BOOK_ID , value = "订阅" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookRuleVOMeta.VALUE , value = "数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookRuleVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { MonitorAlertBookRuleVOMeta.PAGE_INDEX , MonitorAlertBookRuleVOMeta.PAGE_SIZE , MonitorAlertBookRuleVOMeta.SEARCH_FIELD , MonitorAlertBookRuleVOMeta.FUZZY_FIELD , MonitorAlertBookRuleVOMeta.SEARCH_VALUE , MonitorAlertBookRuleVOMeta.DIRTY_FIELDS , MonitorAlertBookRuleVOMeta.SORT_FIELD , MonitorAlertBookRuleVOMeta.SORT_TYPE , MonitorAlertBookRuleVOMeta.DATA_ORIGIN , MonitorAlertBookRuleVOMeta.QUERY_LOGIC , MonitorAlertBookRuleVOMeta.REQUEST_ACTION , MonitorAlertBookRuleVOMeta.IDS } )
	@SentinelResource(value = MonitorAlertBookRuleServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorAlertBookRuleServiceProxy.UPDATE)
	public Result update(MonitorAlertBookRuleVO monitorAlertBookRuleVO) {
		
		Result result=monitorAlertBookRuleService.update(monitorAlertBookRuleVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存订阅规则
	*/
	@ApiOperation(value = "保存订阅规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertBookRuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookRuleVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookRuleVOMeta.BOOK_ID , value = "订阅" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookRuleVOMeta.VALUE , value = "数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookRuleVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorAlertBookRuleVOMeta.PAGE_INDEX , MonitorAlertBookRuleVOMeta.PAGE_SIZE , MonitorAlertBookRuleVOMeta.SEARCH_FIELD , MonitorAlertBookRuleVOMeta.FUZZY_FIELD , MonitorAlertBookRuleVOMeta.SEARCH_VALUE , MonitorAlertBookRuleVOMeta.DIRTY_FIELDS , MonitorAlertBookRuleVOMeta.SORT_FIELD , MonitorAlertBookRuleVOMeta.SORT_TYPE , MonitorAlertBookRuleVOMeta.DATA_ORIGIN , MonitorAlertBookRuleVOMeta.QUERY_LOGIC , MonitorAlertBookRuleVOMeta.REQUEST_ACTION , MonitorAlertBookRuleVOMeta.IDS } )
	@SentinelResource(value = MonitorAlertBookRuleServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorAlertBookRuleServiceProxy.SAVE)
	public Result save(MonitorAlertBookRuleVO monitorAlertBookRuleVO) {
		
		Result result=monitorAlertBookRuleService.save(monitorAlertBookRuleVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取订阅规则
	*/
	@ApiOperation(value = "获取订阅规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertBookRuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MonitorAlertBookRuleServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorAlertBookRuleServiceProxy.GET_BY_ID)
	public Result<MonitorAlertBookRule> getById(String id) {
		
		Result<MonitorAlertBookRule> result=new Result<>();
		MonitorAlertBookRule monitorAlertBookRule=monitorAlertBookRuleService.getById(id);
		result.success(true).data(monitorAlertBookRule);
		return result;
	}


	/**
	 * 批量获取订阅规则 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取订阅规则")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MonitorAlertBookRuleVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = MonitorAlertBookRuleServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorAlertBookRuleServiceProxy.GET_BY_IDS)
	public Result<List<MonitorAlertBookRule>> getByIds(List<String> ids) {
		
		Result<List<MonitorAlertBookRule>> result=new Result<>();
		List<MonitorAlertBookRule> list=monitorAlertBookRuleService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询订阅规则
	*/
	@ApiOperation(value = "查询订阅规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertBookRuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookRuleVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookRuleVOMeta.BOOK_ID , value = "订阅" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookRuleVOMeta.VALUE , value = "数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookRuleVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { MonitorAlertBookRuleVOMeta.PAGE_INDEX , MonitorAlertBookRuleVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MonitorAlertBookRuleServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorAlertBookRuleServiceProxy.QUERY_LIST)
	public Result<List<MonitorAlertBookRule>> queryList(MonitorAlertBookRuleVO sample) {
		
		Result<List<MonitorAlertBookRule>> result=new Result<>();
		List<MonitorAlertBookRule> list=monitorAlertBookRuleService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询订阅规则
	*/
	@ApiOperation(value = "分页查询订阅规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertBookRuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookRuleVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookRuleVOMeta.BOOK_ID , value = "订阅" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookRuleVOMeta.VALUE , value = "数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookRuleVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MonitorAlertBookRuleServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorAlertBookRuleServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MonitorAlertBookRule>> queryPagedList(MonitorAlertBookRuleVO sample) {
		
		Result<PagedList<MonitorAlertBookRule>> result=new Result<>();
		PagedList<MonitorAlertBookRule> list=monitorAlertBookRuleService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}