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


import com.dt.platform.proxy.common.PayOrderExtServiceProxy;
import com.dt.platform.domain.common.meta.PayOrderExtVOMeta;
import com.dt.platform.domain.common.PayOrderExt;
import com.dt.platform.domain.common.PayOrderExtVO;
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
import com.dt.platform.domain.common.meta.PayOrderExtMeta;
import com.dt.platform.domain.common.PayOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IPayOrderExtService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 支付订单接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-04 16:25:47
*/

@InDoc
@Api(tags = "支付订单")
@RestController("SysPayOrderExtController")
public class PayOrderExtController extends SuperController {

	@Autowired
	private IPayOrderExtService payOrderExtService;

	/**
	 * 添加支付订单
	*/
	@ApiOperation(value = "添加支付订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayOrderExtVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderExtVOMeta.ORDER_ID , value = "支付订单编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderExtVOMeta.CHANNEL_EXTRAS , value = "支付渠道的额外参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderExtVOMeta.CHANNEL_NOTIFY_DATA , value = "支付渠道异步通知的内容" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayOrderExtServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayOrderExtServiceProxy.INSERT)
	public Result insert(PayOrderExtVO payOrderExtVO) {
		
		Result result=payOrderExtService.insert(payOrderExtVO,false);
		return result;
	}



	/**
	 * 删除支付订单
	*/
	@ApiOperation(value = "删除支付订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayOrderExtVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayOrderExtServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayOrderExtServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  payOrderExtService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=payOrderExtService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除支付订单 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除支付订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayOrderExtVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PayOrderExtServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayOrderExtServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = payOrderExtService.hasRefers(ids);
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
			Result result=payOrderExtService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=payOrderExtService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新支付订单
	*/
	@ApiOperation(value = "更新支付订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayOrderExtVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderExtVOMeta.ORDER_ID , value = "支付订单编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderExtVOMeta.CHANNEL_EXTRAS , value = "支付渠道的额外参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderExtVOMeta.CHANNEL_NOTIFY_DATA , value = "支付渠道异步通知的内容" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PayOrderExtVOMeta.PAGE_INDEX , PayOrderExtVOMeta.PAGE_SIZE , PayOrderExtVOMeta.SEARCH_FIELD , PayOrderExtVOMeta.FUZZY_FIELD , PayOrderExtVOMeta.SEARCH_VALUE , PayOrderExtVOMeta.DIRTY_FIELDS , PayOrderExtVOMeta.SORT_FIELD , PayOrderExtVOMeta.SORT_TYPE , PayOrderExtVOMeta.DATA_ORIGIN , PayOrderExtVOMeta.QUERY_LOGIC , PayOrderExtVOMeta.REQUEST_ACTION , PayOrderExtVOMeta.IDS } )
	@SentinelResource(value = PayOrderExtServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayOrderExtServiceProxy.UPDATE)
	public Result update(PayOrderExtVO payOrderExtVO) {
		
		Result result=payOrderExtService.update(payOrderExtVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存支付订单
	*/
	@ApiOperation(value = "保存支付订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayOrderExtVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderExtVOMeta.ORDER_ID , value = "支付订单编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderExtVOMeta.CHANNEL_EXTRAS , value = "支付渠道的额外参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderExtVOMeta.CHANNEL_NOTIFY_DATA , value = "支付渠道异步通知的内容" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PayOrderExtVOMeta.PAGE_INDEX , PayOrderExtVOMeta.PAGE_SIZE , PayOrderExtVOMeta.SEARCH_FIELD , PayOrderExtVOMeta.FUZZY_FIELD , PayOrderExtVOMeta.SEARCH_VALUE , PayOrderExtVOMeta.DIRTY_FIELDS , PayOrderExtVOMeta.SORT_FIELD , PayOrderExtVOMeta.SORT_TYPE , PayOrderExtVOMeta.DATA_ORIGIN , PayOrderExtVOMeta.QUERY_LOGIC , PayOrderExtVOMeta.REQUEST_ACTION , PayOrderExtVOMeta.IDS } )
	@SentinelResource(value = PayOrderExtServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayOrderExtServiceProxy.SAVE)
	public Result save(PayOrderExtVO payOrderExtVO) {
		
		Result result=payOrderExtService.save(payOrderExtVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取支付订单
	*/
	@ApiOperation(value = "获取支付订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayOrderExtVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayOrderExtServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayOrderExtServiceProxy.GET_BY_ID)
	public Result<PayOrderExt> getById(String id) {
		
		Result<PayOrderExt> result=new Result<>();
		PayOrderExt payOrderExt=payOrderExtService.getById(id);
		// join 关联的对象
		payOrderExtService.dao().fill(payOrderExt)
			.with(PayOrderExtMeta.PAY_ORDER)
			.execute();
		result.success(true).data(payOrderExt);
		return result;
	}


	/**
	 * 批量获取支付订单 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取支付订单")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PayOrderExtVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PayOrderExtServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayOrderExtServiceProxy.GET_BY_IDS)
	public Result<List<PayOrderExt>> getByIds(List<String> ids) {
		
		Result<List<PayOrderExt>> result=new Result<>();
		List<PayOrderExt> list=payOrderExtService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询支付订单
	*/
	@ApiOperation(value = "查询支付订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayOrderExtVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderExtVOMeta.ORDER_ID , value = "支付订单编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderExtVOMeta.CHANNEL_EXTRAS , value = "支付渠道的额外参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderExtVOMeta.CHANNEL_NOTIFY_DATA , value = "支付渠道异步通知的内容" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PayOrderExtVOMeta.PAGE_INDEX , PayOrderExtVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PayOrderExtServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayOrderExtServiceProxy.QUERY_LIST)
	public Result<List<PayOrderExt>> queryList(PayOrderExtVO sample) {
		
		Result<List<PayOrderExt>> result=new Result<>();
		List<PayOrderExt> list=payOrderExtService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询支付订单
	*/
	@ApiOperation(value = "分页查询支付订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayOrderExtVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderExtVOMeta.ORDER_ID , value = "支付订单编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderExtVOMeta.CHANNEL_EXTRAS , value = "支付渠道的额外参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderExtVOMeta.CHANNEL_NOTIFY_DATA , value = "支付渠道异步通知的内容" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayOrderExtServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayOrderExtServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PayOrderExt>> queryPagedList(PayOrderExtVO sample) {
		
		Result<PagedList<PayOrderExt>> result=new Result<>();
		PagedList<PayOrderExt> list=payOrderExtService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		payOrderExtService.dao().fill(list)
			.with(PayOrderExtMeta.PAY_ORDER)
			.execute();
		result.success(true).data(list);
		return result;
	}





}