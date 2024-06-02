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


import com.dt.platform.proxy.ops.MonitorAlertBookServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorAlertBookVOMeta;
import com.dt.platform.domain.ops.MonitorAlertBook;
import com.dt.platform.domain.ops.MonitorAlertBookVO;
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
import com.dt.platform.domain.ops.meta.MonitorAlertBookMeta;
import org.github.foxnic.web.domain.system.BusiRole;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.ops.MonitorNodeGroup;
import com.dt.platform.domain.ops.MonitorNode;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.ops.MonitorAlertMethod;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorAlertBookService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 告警订阅接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-06-01 17:54:29
*/

@InDoc
@Api(tags = "告警订阅")
@RestController("OpsMonitorAlertBookController")
public class MonitorAlertBookController extends SuperController {

	@Autowired
	private IMonitorAlertBookService monitorAlertBookService;

	/**
	 * 添加告警订阅
	*/
	@ApiOperation(value = "添加告警订阅")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "849233044161167360"),
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "告警"),
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.MONITOR_IS_ALL , value = "全部对象" , required = false , dataTypeClass=String.class , example = "no"),
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MonitorAlertBookServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorAlertBookServiceProxy.INSERT)
	public Result insert(MonitorAlertBookVO monitorAlertBookVO) {
		
		Result result=monitorAlertBookService.insert(monitorAlertBookVO,false);
		return result;
	}



	/**
	 * 删除告警订阅
	*/
	@ApiOperation(value = "删除告警订阅")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "849233044161167360")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MonitorAlertBookServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorAlertBookServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  monitorAlertBookService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=monitorAlertBookService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除告警订阅 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除告警订阅")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = MonitorAlertBookServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorAlertBookServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = monitorAlertBookService.hasRefers(ids);
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
			Result result=monitorAlertBookService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=monitorAlertBookService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新告警订阅
	*/
	@ApiOperation(value = "更新告警订阅")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "849233044161167360"),
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "告警"),
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.MONITOR_IS_ALL , value = "全部对象" , required = false , dataTypeClass=String.class , example = "no"),
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { MonitorAlertBookVOMeta.PAGE_INDEX , MonitorAlertBookVOMeta.PAGE_SIZE , MonitorAlertBookVOMeta.SEARCH_FIELD , MonitorAlertBookVOMeta.FUZZY_FIELD , MonitorAlertBookVOMeta.SEARCH_VALUE , MonitorAlertBookVOMeta.DIRTY_FIELDS , MonitorAlertBookVOMeta.SORT_FIELD , MonitorAlertBookVOMeta.SORT_TYPE , MonitorAlertBookVOMeta.DATA_ORIGIN , MonitorAlertBookVOMeta.QUERY_LOGIC , MonitorAlertBookVOMeta.REQUEST_ACTION , MonitorAlertBookVOMeta.IDS } )
	@SentinelResource(value = MonitorAlertBookServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorAlertBookServiceProxy.UPDATE)
	public Result update(MonitorAlertBookVO monitorAlertBookVO) {
		
		Result result=monitorAlertBookService.update(monitorAlertBookVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存告警订阅
	*/
	@ApiOperation(value = "保存告警订阅")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "849233044161167360"),
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "告警"),
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.MONITOR_IS_ALL , value = "全部对象" , required = false , dataTypeClass=String.class , example = "no"),
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorAlertBookVOMeta.PAGE_INDEX , MonitorAlertBookVOMeta.PAGE_SIZE , MonitorAlertBookVOMeta.SEARCH_FIELD , MonitorAlertBookVOMeta.FUZZY_FIELD , MonitorAlertBookVOMeta.SEARCH_VALUE , MonitorAlertBookVOMeta.DIRTY_FIELDS , MonitorAlertBookVOMeta.SORT_FIELD , MonitorAlertBookVOMeta.SORT_TYPE , MonitorAlertBookVOMeta.DATA_ORIGIN , MonitorAlertBookVOMeta.QUERY_LOGIC , MonitorAlertBookVOMeta.REQUEST_ACTION , MonitorAlertBookVOMeta.IDS } )
	@SentinelResource(value = MonitorAlertBookServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorAlertBookServiceProxy.SAVE)
	public Result save(MonitorAlertBookVO monitorAlertBookVO) {
		
		Result result=monitorAlertBookService.save(monitorAlertBookVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取告警订阅
	*/
	@ApiOperation(value = "获取告警订阅")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MonitorAlertBookServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorAlertBookServiceProxy.GET_BY_ID)
	public Result<MonitorAlertBook> getById(String id) {
		
		Result<MonitorAlertBook> result=new Result<>();
		MonitorAlertBook monitorAlertBook=monitorAlertBookService.getById(id);
		// join 关联的对象
		monitorAlertBookService.dao().fill(monitorAlertBook)
			.with(MonitorAlertBookMeta.ALERT_METHOD_LIST)
			.with(MonitorAlertBookMeta.LEVEL_LIST)
			.with(MonitorAlertBookMeta.NODE_GROUP_LIST)
			.with(MonitorAlertBookMeta.NODE_LIST)
			.with(MonitorAlertBookMeta.USER_GROUP_LIST)
				.with(MonitorAlertBookMeta.USER_LIST)
			.execute();
		result.success(true).data(monitorAlertBook);


		return result;
	}


	/**
	 * 批量获取告警订阅 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取告警订阅")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MonitorAlertBookVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = MonitorAlertBookServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorAlertBookServiceProxy.GET_BY_IDS)
	public Result<List<MonitorAlertBook>> getByIds(List<String> ids) {
		
		Result<List<MonitorAlertBook>> result=new Result<>();
		List<MonitorAlertBook> list=monitorAlertBookService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询告警订阅
	*/
	@ApiOperation(value = "查询告警订阅")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "849233044161167360"),
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "告警"),
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.MONITOR_IS_ALL , value = "全部对象" , required = false , dataTypeClass=String.class , example = "no"),
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { MonitorAlertBookVOMeta.PAGE_INDEX , MonitorAlertBookVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MonitorAlertBookServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorAlertBookServiceProxy.QUERY_LIST)
	public Result<List<MonitorAlertBook>> queryList(MonitorAlertBookVO sample) {
		
		Result<List<MonitorAlertBook>> result=new Result<>();
		List<MonitorAlertBook> list=monitorAlertBookService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询告警订阅
	*/
	@ApiOperation(value = "分页查询告警订阅")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "849233044161167360"),
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "告警"),
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.MONITOR_IS_ALL , value = "全部对象" , required = false , dataTypeClass=String.class , example = "no"),
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorAlertBookVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MonitorAlertBookServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorAlertBookServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MonitorAlertBook>> queryPagedList(MonitorAlertBookVO sample) {
		
		Result<PagedList<MonitorAlertBook>> result=new Result<>();
		PagedList<MonitorAlertBook> list=monitorAlertBookService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		monitorAlertBookService.dao().fill(list)
			.with(MonitorAlertBookMeta.ALERT_METHOD_LIST)
			.with(MonitorAlertBookMeta.LEVEL_LIST)
			.with(MonitorAlertBookMeta.NODE_GROUP_LIST)
			.with(MonitorAlertBookMeta.NODE_LIST)
			.with(MonitorAlertBookMeta.USER_GROUP_LIST)
				.with(MonitorAlertBookMeta.USER_LIST)
			.execute();
		result.success(true).data(list);
		return result;
	}





}