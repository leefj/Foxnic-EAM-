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


import com.dt.platform.proxy.common.PayNotifyLogServiceProxy;
import com.dt.platform.domain.common.meta.PayNotifyLogVOMeta;
import com.dt.platform.domain.common.PayNotifyLog;
import com.dt.platform.domain.common.PayNotifyLogVO;
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
import com.dt.platform.domain.common.meta.PayNotifyLogMeta;
import com.dt.platform.domain.common.PayNotifyTask;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IPayNotifyLogService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 支付通知日志接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-04 16:30:02
*/

@InDoc
@Api(tags = "支付通知日志")
@RestController("SysPayNotifyLogController")
public class PayNotifyLogController extends SuperController {

	@Autowired
	private IPayNotifyLogService payNotifyLogService;

	/**
	 * 添加支付通知日志
	*/
	@ApiOperation(value = "添加支付通知日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayNotifyLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyLogVOMeta.STATUS , value = "通知状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyLogVOMeta.TASK_ID , value = "通知任务编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyLogVOMeta.NOTIFY_TIMES , value = "第几次被通知" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PayNotifyLogVOMeta.RESPONSE , value = "请求参数" , required = true , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayNotifyLogServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayNotifyLogServiceProxy.INSERT)
	public Result insert(PayNotifyLogVO payNotifyLogVO) {
		
		Result result=payNotifyLogService.insert(payNotifyLogVO,false);
		return result;
	}



	/**
	 * 删除支付通知日志
	*/
	@ApiOperation(value = "删除支付通知日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayNotifyLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayNotifyLogServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayNotifyLogServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  payNotifyLogService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=payNotifyLogService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除支付通知日志 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除支付通知日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayNotifyLogVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PayNotifyLogServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayNotifyLogServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = payNotifyLogService.hasRefers(ids);
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
			Result result=payNotifyLogService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=payNotifyLogService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新支付通知日志
	*/
	@ApiOperation(value = "更新支付通知日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayNotifyLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyLogVOMeta.STATUS , value = "通知状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyLogVOMeta.TASK_ID , value = "通知任务编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyLogVOMeta.NOTIFY_TIMES , value = "第几次被通知" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PayNotifyLogVOMeta.RESPONSE , value = "请求参数" , required = true , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PayNotifyLogVOMeta.PAGE_INDEX , PayNotifyLogVOMeta.PAGE_SIZE , PayNotifyLogVOMeta.SEARCH_FIELD , PayNotifyLogVOMeta.FUZZY_FIELD , PayNotifyLogVOMeta.SEARCH_VALUE , PayNotifyLogVOMeta.DIRTY_FIELDS , PayNotifyLogVOMeta.SORT_FIELD , PayNotifyLogVOMeta.SORT_TYPE , PayNotifyLogVOMeta.DATA_ORIGIN , PayNotifyLogVOMeta.QUERY_LOGIC , PayNotifyLogVOMeta.REQUEST_ACTION , PayNotifyLogVOMeta.IDS } )
	@SentinelResource(value = PayNotifyLogServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayNotifyLogServiceProxy.UPDATE)
	public Result update(PayNotifyLogVO payNotifyLogVO) {
		
		Result result=payNotifyLogService.update(payNotifyLogVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存支付通知日志
	*/
	@ApiOperation(value = "保存支付通知日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayNotifyLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyLogVOMeta.STATUS , value = "通知状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyLogVOMeta.TASK_ID , value = "通知任务编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyLogVOMeta.NOTIFY_TIMES , value = "第几次被通知" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PayNotifyLogVOMeta.RESPONSE , value = "请求参数" , required = true , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PayNotifyLogVOMeta.PAGE_INDEX , PayNotifyLogVOMeta.PAGE_SIZE , PayNotifyLogVOMeta.SEARCH_FIELD , PayNotifyLogVOMeta.FUZZY_FIELD , PayNotifyLogVOMeta.SEARCH_VALUE , PayNotifyLogVOMeta.DIRTY_FIELDS , PayNotifyLogVOMeta.SORT_FIELD , PayNotifyLogVOMeta.SORT_TYPE , PayNotifyLogVOMeta.DATA_ORIGIN , PayNotifyLogVOMeta.QUERY_LOGIC , PayNotifyLogVOMeta.REQUEST_ACTION , PayNotifyLogVOMeta.IDS } )
	@SentinelResource(value = PayNotifyLogServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayNotifyLogServiceProxy.SAVE)
	public Result save(PayNotifyLogVO payNotifyLogVO) {
		
		Result result=payNotifyLogService.save(payNotifyLogVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取支付通知日志
	*/
	@ApiOperation(value = "获取支付通知日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayNotifyLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayNotifyLogServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayNotifyLogServiceProxy.GET_BY_ID)
	public Result<PayNotifyLog> getById(String id) {
		
		Result<PayNotifyLog> result=new Result<>();
		PayNotifyLog payNotifyLog=payNotifyLogService.getById(id);
		// join 关联的对象
		payNotifyLogService.dao().fill(payNotifyLog)
			.with(PayNotifyLogMeta.PAY_NOTIFY_TASK)
			.execute();
		result.success(true).data(payNotifyLog);
		return result;
	}


	/**
	 * 批量获取支付通知日志 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取支付通知日志")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PayNotifyLogVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PayNotifyLogServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayNotifyLogServiceProxy.GET_BY_IDS)
	public Result<List<PayNotifyLog>> getByIds(List<String> ids) {
		
		Result<List<PayNotifyLog>> result=new Result<>();
		List<PayNotifyLog> list=payNotifyLogService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询支付通知日志
	*/
	@ApiOperation(value = "查询支付通知日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayNotifyLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyLogVOMeta.STATUS , value = "通知状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyLogVOMeta.TASK_ID , value = "通知任务编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyLogVOMeta.NOTIFY_TIMES , value = "第几次被通知" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PayNotifyLogVOMeta.RESPONSE , value = "请求参数" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PayNotifyLogVOMeta.PAGE_INDEX , PayNotifyLogVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PayNotifyLogServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayNotifyLogServiceProxy.QUERY_LIST)
	public Result<List<PayNotifyLog>> queryList(PayNotifyLogVO sample) {
		
		Result<List<PayNotifyLog>> result=new Result<>();
		List<PayNotifyLog> list=payNotifyLogService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询支付通知日志
	*/
	@ApiOperation(value = "分页查询支付通知日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayNotifyLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyLogVOMeta.STATUS , value = "通知状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyLogVOMeta.TASK_ID , value = "通知任务编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyLogVOMeta.NOTIFY_TIMES , value = "第几次被通知" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PayNotifyLogVOMeta.RESPONSE , value = "请求参数" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayNotifyLogServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayNotifyLogServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PayNotifyLog>> queryPagedList(PayNotifyLogVO sample) {
		
		Result<PagedList<PayNotifyLog>> result=new Result<>();
		PagedList<PayNotifyLog> list=payNotifyLogService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		payNotifyLogService.dao().fill(list)
			.with(PayNotifyLogMeta.PAY_NOTIFY_TASK)
			.execute();
		result.success(true).data(list);
		return result;
	}





}