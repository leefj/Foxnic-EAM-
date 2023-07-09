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


import com.dt.platform.proxy.common.PayOrderServiceProxy;
import com.dt.platform.domain.common.meta.PayOrderVOMeta;
import com.dt.platform.domain.common.PayOrder;
import com.dt.platform.domain.common.PayOrderVO;
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
import com.dt.platform.domain.common.meta.PayOrderMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.common.PayChannel;
import com.dt.platform.domain.common.PayApp;
import com.dt.platform.domain.common.PayMerchant;
import com.dt.platform.domain.common.PayOrderExt;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IPayOrderService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 支付订单接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-04 15:51:26
*/

@InDoc
@Api(tags = "支付订单")
@RestController("SysPayOrderController")
public class PayOrderController extends SuperController {

	@Autowired
	private IPayOrderService payOrderService;

	/**
	 * 添加支付订单
	*/
	@ApiOperation(value = "添加支付订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.STATUS , value = "支付状态" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PayOrderVOMeta.TRADE_NO , value = "交易单号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.MERCHANT_ID , value = "商户编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.APP_ID , value = "应用编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.MERCHANT_ORDER_ID , value = "商户订单" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.SUBJECT , value = "商品标题" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.BODY , value = "商品描述" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.NOTIFY_URL , value = "异步通知地址" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.NOTIFY_STATUS , value = "回调状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.AMOUNT , value = "支付金额" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = PayOrderVOMeta.USER_IP , value = "用户" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.EXPIRE_TIME , value = "订单失效时间" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayOrderVOMeta.SUCCESS_TIME , value = "订单支付成功时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayOrderVOMeta.NOTIFY_TIME , value = "订单支付通知时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayOrderVOMeta.SUCCESS_EXTENSION_ID , value = "支付成功的订单拓展单编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.REFUND_STATUS , value = "退款状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.REFUND_TIMES , value = "退款次数" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PayOrderVOMeta.REFUND_AMOUNT , value = "退款总金额" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_ID , value = "渠道编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_CODE , value = "渠道编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_USER_ID , value = "渠道用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_FEE_RATE , value = "渠道手续费" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_FEE_AMOUNT , value = "渠道手续金额" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_ORDER_NO , value = "渠道订单" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayOrderServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayOrderServiceProxy.INSERT)
	public Result insert(PayOrderVO payOrderVO) {
		
		Result result=payOrderService.insert(payOrderVO,false);
		return result;
	}



	/**
	 * 删除支付订单
	*/
	@ApiOperation(value = "删除支付订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayOrderServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayOrderServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  payOrderService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=payOrderService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除支付订单 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除支付订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayOrderVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PayOrderServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayOrderServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = payOrderService.hasRefers(ids);
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
			Result result=payOrderService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=payOrderService.deleteByIdsLogical(canDeleteIds);
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
		@ApiImplicitParam(name = PayOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.STATUS , value = "支付状态" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PayOrderVOMeta.TRADE_NO , value = "交易单号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.MERCHANT_ID , value = "商户编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.APP_ID , value = "应用编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.MERCHANT_ORDER_ID , value = "商户订单" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.SUBJECT , value = "商品标题" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.BODY , value = "商品描述" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.NOTIFY_URL , value = "异步通知地址" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.NOTIFY_STATUS , value = "回调状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.AMOUNT , value = "支付金额" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = PayOrderVOMeta.USER_IP , value = "用户" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.EXPIRE_TIME , value = "订单失效时间" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayOrderVOMeta.SUCCESS_TIME , value = "订单支付成功时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayOrderVOMeta.NOTIFY_TIME , value = "订单支付通知时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayOrderVOMeta.SUCCESS_EXTENSION_ID , value = "支付成功的订单拓展单编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.REFUND_STATUS , value = "退款状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.REFUND_TIMES , value = "退款次数" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PayOrderVOMeta.REFUND_AMOUNT , value = "退款总金额" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_ID , value = "渠道编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_CODE , value = "渠道编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_USER_ID , value = "渠道用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_FEE_RATE , value = "渠道手续费" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_FEE_AMOUNT , value = "渠道手续金额" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_ORDER_NO , value = "渠道订单" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PayOrderVOMeta.PAGE_INDEX , PayOrderVOMeta.PAGE_SIZE , PayOrderVOMeta.SEARCH_FIELD , PayOrderVOMeta.FUZZY_FIELD , PayOrderVOMeta.SEARCH_VALUE , PayOrderVOMeta.DIRTY_FIELDS , PayOrderVOMeta.SORT_FIELD , PayOrderVOMeta.SORT_TYPE , PayOrderVOMeta.DATA_ORIGIN , PayOrderVOMeta.QUERY_LOGIC , PayOrderVOMeta.REQUEST_ACTION , PayOrderVOMeta.IDS } )
	@SentinelResource(value = PayOrderServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayOrderServiceProxy.UPDATE)
	public Result update(PayOrderVO payOrderVO) {
		
		Result result=payOrderService.update(payOrderVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存支付订单
	*/
	@ApiOperation(value = "保存支付订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.STATUS , value = "支付状态" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PayOrderVOMeta.TRADE_NO , value = "交易单号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.MERCHANT_ID , value = "商户编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.APP_ID , value = "应用编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.MERCHANT_ORDER_ID , value = "商户订单" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.SUBJECT , value = "商品标题" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.BODY , value = "商品描述" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.NOTIFY_URL , value = "异步通知地址" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.NOTIFY_STATUS , value = "回调状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.AMOUNT , value = "支付金额" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = PayOrderVOMeta.USER_IP , value = "用户" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.EXPIRE_TIME , value = "订单失效时间" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayOrderVOMeta.SUCCESS_TIME , value = "订单支付成功时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayOrderVOMeta.NOTIFY_TIME , value = "订单支付通知时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayOrderVOMeta.SUCCESS_EXTENSION_ID , value = "支付成功的订单拓展单编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.REFUND_STATUS , value = "退款状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.REFUND_TIMES , value = "退款次数" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PayOrderVOMeta.REFUND_AMOUNT , value = "退款总金额" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_ID , value = "渠道编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_CODE , value = "渠道编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_USER_ID , value = "渠道用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_FEE_RATE , value = "渠道手续费" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_FEE_AMOUNT , value = "渠道手续金额" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_ORDER_NO , value = "渠道订单" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PayOrderVOMeta.PAGE_INDEX , PayOrderVOMeta.PAGE_SIZE , PayOrderVOMeta.SEARCH_FIELD , PayOrderVOMeta.FUZZY_FIELD , PayOrderVOMeta.SEARCH_VALUE , PayOrderVOMeta.DIRTY_FIELDS , PayOrderVOMeta.SORT_FIELD , PayOrderVOMeta.SORT_TYPE , PayOrderVOMeta.DATA_ORIGIN , PayOrderVOMeta.QUERY_LOGIC , PayOrderVOMeta.REQUEST_ACTION , PayOrderVOMeta.IDS } )
	@SentinelResource(value = PayOrderServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayOrderServiceProxy.SAVE)
	public Result save(PayOrderVO payOrderVO) {
		
		Result result=payOrderService.save(payOrderVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取支付订单
	*/
	@ApiOperation(value = "获取支付订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayOrderServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayOrderServiceProxy.GET_BY_ID)
	public Result<PayOrder> getById(String id) {
		
		Result<PayOrder> result=new Result<>();
		PayOrder payOrder=payOrderService.getById(id);
		result.success(true).data(payOrder);
		return result;
	}


	/**
	 * 批量获取支付订单 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取支付订单")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PayOrderVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PayOrderServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayOrderServiceProxy.GET_BY_IDS)
	public Result<List<PayOrder>> getByIds(List<String> ids) {
		
		Result<List<PayOrder>> result=new Result<>();
		List<PayOrder> list=payOrderService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询支付订单
	*/
	@ApiOperation(value = "查询支付订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.STATUS , value = "支付状态" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PayOrderVOMeta.TRADE_NO , value = "交易单号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.MERCHANT_ID , value = "商户编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.APP_ID , value = "应用编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.MERCHANT_ORDER_ID , value = "商户订单" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.SUBJECT , value = "商品标题" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.BODY , value = "商品描述" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.NOTIFY_URL , value = "异步通知地址" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.NOTIFY_STATUS , value = "回调状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.AMOUNT , value = "支付金额" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = PayOrderVOMeta.USER_IP , value = "用户" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.EXPIRE_TIME , value = "订单失效时间" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayOrderVOMeta.SUCCESS_TIME , value = "订单支付成功时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayOrderVOMeta.NOTIFY_TIME , value = "订单支付通知时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayOrderVOMeta.SUCCESS_EXTENSION_ID , value = "支付成功的订单拓展单编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.REFUND_STATUS , value = "退款状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.REFUND_TIMES , value = "退款次数" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PayOrderVOMeta.REFUND_AMOUNT , value = "退款总金额" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_ID , value = "渠道编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_CODE , value = "渠道编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_USER_ID , value = "渠道用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_FEE_RATE , value = "渠道手续费" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_FEE_AMOUNT , value = "渠道手续金额" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_ORDER_NO , value = "渠道订单" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PayOrderVOMeta.PAGE_INDEX , PayOrderVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PayOrderServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayOrderServiceProxy.QUERY_LIST)
	public Result<List<PayOrder>> queryList(PayOrderVO sample) {
		
		Result<List<PayOrder>> result=new Result<>();
		List<PayOrder> list=payOrderService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询支付订单
	*/
	@ApiOperation(value = "分页查询支付订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.STATUS , value = "支付状态" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PayOrderVOMeta.TRADE_NO , value = "交易单号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.MERCHANT_ID , value = "商户编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.APP_ID , value = "应用编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.MERCHANT_ORDER_ID , value = "商户订单" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.SUBJECT , value = "商品标题" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.BODY , value = "商品描述" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.NOTIFY_URL , value = "异步通知地址" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.NOTIFY_STATUS , value = "回调状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.AMOUNT , value = "支付金额" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = PayOrderVOMeta.USER_IP , value = "用户" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.EXPIRE_TIME , value = "订单失效时间" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayOrderVOMeta.SUCCESS_TIME , value = "订单支付成功时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayOrderVOMeta.NOTIFY_TIME , value = "订单支付通知时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayOrderVOMeta.SUCCESS_EXTENSION_ID , value = "支付成功的订单拓展单编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.REFUND_STATUS , value = "退款状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.REFUND_TIMES , value = "退款次数" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PayOrderVOMeta.REFUND_AMOUNT , value = "退款总金额" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_ID , value = "渠道编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_CODE , value = "渠道编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_USER_ID , value = "渠道用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_FEE_RATE , value = "渠道手续费" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_FEE_AMOUNT , value = "渠道手续金额" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = PayOrderVOMeta.CHANNEL_ORDER_NO , value = "渠道订单" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayOrderServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayOrderServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PayOrder>> queryPagedList(PayOrderVO sample) {
		
		Result<PagedList<PayOrder>> result=new Result<>();
		PagedList<PayOrder> list=payOrderService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}