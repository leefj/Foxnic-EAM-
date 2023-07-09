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


import com.dt.platform.proxy.common.PayNotifyTaskServiceProxy;
import com.dt.platform.domain.common.meta.PayNotifyTaskVOMeta;
import com.dt.platform.domain.common.PayNotifyTask;
import com.dt.platform.domain.common.PayNotifyTaskVO;
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
import com.dt.platform.domain.common.meta.PayNotifyTaskMeta;
import com.dt.platform.domain.common.PayMerchant;
import com.dt.platform.domain.common.PayApp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IPayNotifyTaskService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 任务通知接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-04 14:01:11
*/

@InDoc
@Api(tags = "任务通知")
@RestController("SysPayNotifyTaskController")
public class PayNotifyTaskController extends SuperController {

	@Autowired
	private IPayNotifyTaskService payNotifyTaskService;

	/**
	 * 添加任务通知
	*/
	@ApiOperation(value = "添加任务通知")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.ID , value = "任务编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.STATUS , value = "通知状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.MERCHANT_ID , value = "商户编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.APP_ID , value = "应用编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.TYPE , value = "通知类型" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.DATA_ID , value = "数据编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.MERCHANT_ORDER_ID , value = "商户订单编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.NEXT_NOTIFY_TIME , value = "下一次通知时间" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.LAST_EXECUTE_TIME , value = "最后一次执行时间" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.NOTIFY_TIMES , value = "当前通知次数" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.MAX_NOTIFY_TIMES , value = "最大可通知次数" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.NOTIFY_URL , value = "异步通知地址" , required = true , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayNotifyTaskServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayNotifyTaskServiceProxy.INSERT)
	public Result insert(PayNotifyTaskVO payNotifyTaskVO) {
		
		Result result=payNotifyTaskService.insert(payNotifyTaskVO,false);
		return result;
	}



	/**
	 * 删除任务通知
	*/
	@ApiOperation(value = "删除任务通知")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.ID , value = "任务编号" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayNotifyTaskServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayNotifyTaskServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  payNotifyTaskService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=payNotifyTaskService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除任务通知 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除任务通知")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PayNotifyTaskServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayNotifyTaskServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = payNotifyTaskService.hasRefers(ids);
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
			Result result=payNotifyTaskService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=payNotifyTaskService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新任务通知
	*/
	@ApiOperation(value = "更新任务通知")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.ID , value = "任务编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.STATUS , value = "通知状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.MERCHANT_ID , value = "商户编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.APP_ID , value = "应用编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.TYPE , value = "通知类型" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.DATA_ID , value = "数据编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.MERCHANT_ORDER_ID , value = "商户订单编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.NEXT_NOTIFY_TIME , value = "下一次通知时间" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.LAST_EXECUTE_TIME , value = "最后一次执行时间" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.NOTIFY_TIMES , value = "当前通知次数" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.MAX_NOTIFY_TIMES , value = "最大可通知次数" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.NOTIFY_URL , value = "异步通知地址" , required = true , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PayNotifyTaskVOMeta.PAGE_INDEX , PayNotifyTaskVOMeta.PAGE_SIZE , PayNotifyTaskVOMeta.SEARCH_FIELD , PayNotifyTaskVOMeta.FUZZY_FIELD , PayNotifyTaskVOMeta.SEARCH_VALUE , PayNotifyTaskVOMeta.DIRTY_FIELDS , PayNotifyTaskVOMeta.SORT_FIELD , PayNotifyTaskVOMeta.SORT_TYPE , PayNotifyTaskVOMeta.DATA_ORIGIN , PayNotifyTaskVOMeta.QUERY_LOGIC , PayNotifyTaskVOMeta.REQUEST_ACTION , PayNotifyTaskVOMeta.IDS } )
	@SentinelResource(value = PayNotifyTaskServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayNotifyTaskServiceProxy.UPDATE)
	public Result update(PayNotifyTaskVO payNotifyTaskVO) {
		
		Result result=payNotifyTaskService.update(payNotifyTaskVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存任务通知
	*/
	@ApiOperation(value = "保存任务通知")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.ID , value = "任务编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.STATUS , value = "通知状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.MERCHANT_ID , value = "商户编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.APP_ID , value = "应用编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.TYPE , value = "通知类型" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.DATA_ID , value = "数据编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.MERCHANT_ORDER_ID , value = "商户订单编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.NEXT_NOTIFY_TIME , value = "下一次通知时间" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.LAST_EXECUTE_TIME , value = "最后一次执行时间" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.NOTIFY_TIMES , value = "当前通知次数" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.MAX_NOTIFY_TIMES , value = "最大可通知次数" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.NOTIFY_URL , value = "异步通知地址" , required = true , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PayNotifyTaskVOMeta.PAGE_INDEX , PayNotifyTaskVOMeta.PAGE_SIZE , PayNotifyTaskVOMeta.SEARCH_FIELD , PayNotifyTaskVOMeta.FUZZY_FIELD , PayNotifyTaskVOMeta.SEARCH_VALUE , PayNotifyTaskVOMeta.DIRTY_FIELDS , PayNotifyTaskVOMeta.SORT_FIELD , PayNotifyTaskVOMeta.SORT_TYPE , PayNotifyTaskVOMeta.DATA_ORIGIN , PayNotifyTaskVOMeta.QUERY_LOGIC , PayNotifyTaskVOMeta.REQUEST_ACTION , PayNotifyTaskVOMeta.IDS } )
	@SentinelResource(value = PayNotifyTaskServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayNotifyTaskServiceProxy.SAVE)
	public Result save(PayNotifyTaskVO payNotifyTaskVO) {
		
		Result result=payNotifyTaskService.save(payNotifyTaskVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取任务通知
	*/
	@ApiOperation(value = "获取任务通知")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayNotifyTaskServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayNotifyTaskServiceProxy.GET_BY_ID)
	public Result<PayNotifyTask> getById(String id) {
		
		Result<PayNotifyTask> result=new Result<>();
		PayNotifyTask payNotifyTask=payNotifyTaskService.getById(id);
		// join 关联的对象
		payNotifyTaskService.dao().fill(payNotifyTask)
			.with(PayNotifyTaskMeta.PAY_MERCHANT)
			.with(PayNotifyTaskMeta.PAY_APP)
			.execute();
		result.success(true).data(payNotifyTask);
		return result;
	}


	/**
	 * 批量获取任务通知 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取任务通知")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PayNotifyTaskVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PayNotifyTaskServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayNotifyTaskServiceProxy.GET_BY_IDS)
	public Result<List<PayNotifyTask>> getByIds(List<String> ids) {
		
		Result<List<PayNotifyTask>> result=new Result<>();
		List<PayNotifyTask> list=payNotifyTaskService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询任务通知
	*/
	@ApiOperation(value = "查询任务通知")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.ID , value = "任务编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.STATUS , value = "通知状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.MERCHANT_ID , value = "商户编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.APP_ID , value = "应用编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.TYPE , value = "通知类型" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.DATA_ID , value = "数据编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.MERCHANT_ORDER_ID , value = "商户订单编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.NEXT_NOTIFY_TIME , value = "下一次通知时间" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.LAST_EXECUTE_TIME , value = "最后一次执行时间" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.NOTIFY_TIMES , value = "当前通知次数" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.MAX_NOTIFY_TIMES , value = "最大可通知次数" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.NOTIFY_URL , value = "异步通知地址" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PayNotifyTaskVOMeta.PAGE_INDEX , PayNotifyTaskVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PayNotifyTaskServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayNotifyTaskServiceProxy.QUERY_LIST)
	public Result<List<PayNotifyTask>> queryList(PayNotifyTaskVO sample) {
		
		Result<List<PayNotifyTask>> result=new Result<>();
		List<PayNotifyTask> list=payNotifyTaskService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询任务通知
	*/
	@ApiOperation(value = "分页查询任务通知")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.ID , value = "任务编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.STATUS , value = "通知状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.MERCHANT_ID , value = "商户编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.APP_ID , value = "应用编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.TYPE , value = "通知类型" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.DATA_ID , value = "数据编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.MERCHANT_ORDER_ID , value = "商户订单编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.NEXT_NOTIFY_TIME , value = "下一次通知时间" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.LAST_EXECUTE_TIME , value = "最后一次执行时间" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.NOTIFY_TIMES , value = "当前通知次数" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.MAX_NOTIFY_TIMES , value = "最大可通知次数" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PayNotifyTaskVOMeta.NOTIFY_URL , value = "异步通知地址" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayNotifyTaskServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayNotifyTaskServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PayNotifyTask>> queryPagedList(PayNotifyTaskVO sample) {
		
		Result<PagedList<PayNotifyTask>> result=new Result<>();
		PagedList<PayNotifyTask> list=payNotifyTaskService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		payNotifyTaskService.dao().fill(list)
			.with(PayNotifyTaskMeta.PAY_MERCHANT)
			.with(PayNotifyTaskMeta.PAY_APP)
			.execute();
		result.success(true).data(list);
		return result;
	}





}