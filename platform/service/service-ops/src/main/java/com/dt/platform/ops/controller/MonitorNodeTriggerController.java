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


import com.dt.platform.proxy.ops.MonitorNodeTriggerServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorNodeTriggerVOMeta;
import com.dt.platform.domain.ops.MonitorNodeTrigger;
import com.dt.platform.domain.ops.MonitorNodeTriggerVO;
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
import com.dt.platform.domain.ops.meta.MonitorNodeTriggerMeta;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.MonitorNode;
import com.dt.platform.domain.ops.meta.MonitorTplTriggerMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorNodeTriggerService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 触发器接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-06-03 13:51:44
*/

@InDoc
@Api(tags = "触发器")
@RestController("OpsMonitorNodeTriggerController")
public class MonitorNodeTriggerController extends SuperController {

	@Autowired
	private IMonitorNodeTriggerService monitorNodeTriggerService;

	/**
	 * 添加触发器
	*/
	@ApiOperation(value = "添加触发器")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.TRIGGER_ID , value = "触发器" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.RULE_TYPE , value = "规则类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.WARN_LEVEL , value = "告警等级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.RULE , value = "告警规则" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.CONTENT_VALUE , value = "告警内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.MONITOR_TPL_CODE , value = "监控模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MonitorNodeTriggerServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeTriggerServiceProxy.INSERT)
	public Result insert(MonitorNodeTriggerVO monitorNodeTriggerVO) {
		
		Result result=monitorNodeTriggerService.insert(monitorNodeTriggerVO,false);
		return result;
	}



	/**
	 * 删除触发器
	*/
	@ApiOperation(value = "删除触发器")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MonitorNodeTriggerServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeTriggerServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  monitorNodeTriggerService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=monitorNodeTriggerService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除触发器 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除触发器")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = MonitorNodeTriggerServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeTriggerServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = monitorNodeTriggerService.hasRefers(ids);
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
			Result result=monitorNodeTriggerService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=monitorNodeTriggerService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新触发器
	*/
	@ApiOperation(value = "更新触发器")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.TRIGGER_ID , value = "触发器" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.RULE_TYPE , value = "规则类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.WARN_LEVEL , value = "告警等级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.RULE , value = "告警规则" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.CONTENT_VALUE , value = "告警内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.MONITOR_TPL_CODE , value = "监控模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { MonitorNodeTriggerVOMeta.PAGE_INDEX , MonitorNodeTriggerVOMeta.PAGE_SIZE , MonitorNodeTriggerVOMeta.SEARCH_FIELD , MonitorNodeTriggerVOMeta.FUZZY_FIELD , MonitorNodeTriggerVOMeta.SEARCH_VALUE , MonitorNodeTriggerVOMeta.DIRTY_FIELDS , MonitorNodeTriggerVOMeta.SORT_FIELD , MonitorNodeTriggerVOMeta.SORT_TYPE , MonitorNodeTriggerVOMeta.DATA_ORIGIN , MonitorNodeTriggerVOMeta.QUERY_LOGIC , MonitorNodeTriggerVOMeta.REQUEST_ACTION , MonitorNodeTriggerVOMeta.IDS } )
	@SentinelResource(value = MonitorNodeTriggerServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeTriggerServiceProxy.UPDATE)
	public Result update(MonitorNodeTriggerVO monitorNodeTriggerVO) {
		
		Result result=monitorNodeTriggerService.update(monitorNodeTriggerVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存触发器
	*/
	@ApiOperation(value = "保存触发器")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.TRIGGER_ID , value = "触发器" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.RULE_TYPE , value = "规则类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.WARN_LEVEL , value = "告警等级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.RULE , value = "告警规则" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.CONTENT_VALUE , value = "告警内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.MONITOR_TPL_CODE , value = "监控模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorNodeTriggerVOMeta.PAGE_INDEX , MonitorNodeTriggerVOMeta.PAGE_SIZE , MonitorNodeTriggerVOMeta.SEARCH_FIELD , MonitorNodeTriggerVOMeta.FUZZY_FIELD , MonitorNodeTriggerVOMeta.SEARCH_VALUE , MonitorNodeTriggerVOMeta.DIRTY_FIELDS , MonitorNodeTriggerVOMeta.SORT_FIELD , MonitorNodeTriggerVOMeta.SORT_TYPE , MonitorNodeTriggerVOMeta.DATA_ORIGIN , MonitorNodeTriggerVOMeta.QUERY_LOGIC , MonitorNodeTriggerVOMeta.REQUEST_ACTION , MonitorNodeTriggerVOMeta.IDS } )
	@SentinelResource(value = MonitorNodeTriggerServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeTriggerServiceProxy.SAVE)
	public Result save(MonitorNodeTriggerVO monitorNodeTriggerVO) {
		
		Result result=monitorNodeTriggerService.save(monitorNodeTriggerVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取触发器
	*/
	@ApiOperation(value = "获取触发器")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MonitorNodeTriggerServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeTriggerServiceProxy.GET_BY_ID)
	public Result<MonitorNodeTrigger> getById(String id) {
		
		Result<MonitorNodeTrigger> result=new Result<>();
		MonitorNodeTrigger monitorNodeTrigger=monitorNodeTriggerService.getById(id);
		// join 关联的对象
		monitorNodeTriggerService.dao().fill(monitorNodeTrigger)
			.with(MonitorTplTriggerMeta.TPL)
			.execute();
		result.success(true).data(monitorNodeTrigger);
		return result;
	}


	/**
	 * 批量获取触发器 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取触发器")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = MonitorNodeTriggerServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeTriggerServiceProxy.GET_BY_IDS)
	public Result<List<MonitorNodeTrigger>> getByIds(List<String> ids) {
		
		Result<List<MonitorNodeTrigger>> result=new Result<>();
		List<MonitorNodeTrigger> list=monitorNodeTriggerService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询触发器
	*/
	@ApiOperation(value = "查询触发器")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.TRIGGER_ID , value = "触发器" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.RULE_TYPE , value = "规则类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.WARN_LEVEL , value = "告警等级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.RULE , value = "告警规则" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.CONTENT_VALUE , value = "告警内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.MONITOR_TPL_CODE , value = "监控模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { MonitorNodeTriggerVOMeta.PAGE_INDEX , MonitorNodeTriggerVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MonitorNodeTriggerServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeTriggerServiceProxy.QUERY_LIST)
	public Result<List<MonitorNodeTrigger>> queryList(MonitorNodeTriggerVO sample) {
		
		Result<List<MonitorNodeTrigger>> result=new Result<>();
		List<MonitorNodeTrigger> list=monitorNodeTriggerService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询触发器
	*/
	@ApiOperation(value = "分页查询触发器")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.TRIGGER_ID , value = "触发器" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.RULE_TYPE , value = "规则类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.WARN_LEVEL , value = "告警等级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.RULE , value = "告警规则" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.CONTENT_VALUE , value = "告警内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.MONITOR_TPL_CODE , value = "监控模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeTriggerVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MonitorNodeTriggerServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeTriggerServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MonitorNodeTrigger>> queryPagedList(MonitorNodeTriggerVO sample) {
		
		Result<PagedList<MonitorNodeTrigger>> result=new Result<>();
		PagedList<MonitorNodeTrigger> list=monitorNodeTriggerService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		monitorNodeTriggerService.dao().fill(list)
			.with(MonitorTplTriggerMeta.TPL)
			.execute();
		result.success(true).data(list);
		return result;
	}





}