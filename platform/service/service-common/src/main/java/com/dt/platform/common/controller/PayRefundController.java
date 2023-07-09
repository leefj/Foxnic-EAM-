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


import com.dt.platform.proxy.common.PayRefundServiceProxy;
import com.dt.platform.domain.common.meta.PayRefundVOMeta;
import com.dt.platform.domain.common.PayRefund;
import com.dt.platform.domain.common.PayRefundVO;
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
import com.dt.platform.domain.common.meta.PayRefundMeta;
import com.dt.platform.domain.common.PayMerchant;
import com.dt.platform.domain.common.PayApp;
import com.dt.platform.domain.common.PayChannel;
import com.dt.platform.domain.common.PayOrder;
import com.dt.platform.domain.common.meta.PayOrderMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IPayRefundService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 退款订单接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-04 16:15:46
*/

@InDoc
@Api(tags = "退款订单")
@RestController("SysPayRefundController")
public class PayRefundController extends SuperController {

	@Autowired
	private IPayRefundService payRefundService;

	/**
	 * 添加退款订单
	*/
	@ApiOperation(value = "添加退款订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayRefundVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.STATUS , value = "退款状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.MERCHANT_ID , value = "商户编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.APP_ID , value = "应用编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_ID , value = "渠道编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_CODE , value = "渠道编码" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.ORDER_ID , value = "支付订单" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.TRADE_NO , value = "交易订单" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.MERCHANT_ORDER_ID , value = "商户订单编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.MERCHANT_REFUND_NO , value = "商户退款订单号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.NOTIFY_URL , value = "异步通知商户地址" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.NOTIFY_STATUS , value = "回调状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.TYPE , value = "退款类型" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.PAY_AMOUNT , value = "支付金额" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = PayRefundVOMeta.REFUND_AMOUNT , value = "退款金额" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = PayRefundVOMeta.REASON , value = "退款原因" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.USER_IP , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_ORDER_NO , value = "渠道订单号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_REFUND_NO , value = "渠道退款单号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_ERROR_CODE , value = "渠道调用报错时" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_ERROR_MSG , value = "渠道调用报错时" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_EXTRAS , value = "支付渠道的额外参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.EXPIRE_TIME , value = "退款失效时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayRefundVOMeta.SUCCESS_TIME , value = "退款成功时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayRefundVOMeta.NOTIFY_TIME , value = "退款通知时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayRefundServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayRefundServiceProxy.INSERT)
	public Result insert(PayRefundVO payRefundVO) {
		
		Result result=payRefundService.insert(payRefundVO,false);
		return result;
	}



	/**
	 * 删除退款订单
	*/
	@ApiOperation(value = "删除退款订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayRefundVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayRefundServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayRefundServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  payRefundService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=payRefundService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除退款订单 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除退款订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayRefundVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PayRefundServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayRefundServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = payRefundService.hasRefers(ids);
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
			Result result=payRefundService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=payRefundService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新退款订单
	*/
	@ApiOperation(value = "更新退款订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayRefundVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.STATUS , value = "退款状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.MERCHANT_ID , value = "商户编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.APP_ID , value = "应用编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_ID , value = "渠道编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_CODE , value = "渠道编码" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.ORDER_ID , value = "支付订单" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.TRADE_NO , value = "交易订单" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.MERCHANT_ORDER_ID , value = "商户订单编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.MERCHANT_REFUND_NO , value = "商户退款订单号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.NOTIFY_URL , value = "异步通知商户地址" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.NOTIFY_STATUS , value = "回调状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.TYPE , value = "退款类型" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.PAY_AMOUNT , value = "支付金额" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = PayRefundVOMeta.REFUND_AMOUNT , value = "退款金额" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = PayRefundVOMeta.REASON , value = "退款原因" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.USER_IP , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_ORDER_NO , value = "渠道订单号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_REFUND_NO , value = "渠道退款单号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_ERROR_CODE , value = "渠道调用报错时" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_ERROR_MSG , value = "渠道调用报错时" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_EXTRAS , value = "支付渠道的额外参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.EXPIRE_TIME , value = "退款失效时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayRefundVOMeta.SUCCESS_TIME , value = "退款成功时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayRefundVOMeta.NOTIFY_TIME , value = "退款通知时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PayRefundVOMeta.PAGE_INDEX , PayRefundVOMeta.PAGE_SIZE , PayRefundVOMeta.SEARCH_FIELD , PayRefundVOMeta.FUZZY_FIELD , PayRefundVOMeta.SEARCH_VALUE , PayRefundVOMeta.DIRTY_FIELDS , PayRefundVOMeta.SORT_FIELD , PayRefundVOMeta.SORT_TYPE , PayRefundVOMeta.DATA_ORIGIN , PayRefundVOMeta.QUERY_LOGIC , PayRefundVOMeta.REQUEST_ACTION , PayRefundVOMeta.IDS } )
	@SentinelResource(value = PayRefundServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayRefundServiceProxy.UPDATE)
	public Result update(PayRefundVO payRefundVO) {
		
		Result result=payRefundService.update(payRefundVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存退款订单
	*/
	@ApiOperation(value = "保存退款订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayRefundVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.STATUS , value = "退款状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.MERCHANT_ID , value = "商户编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.APP_ID , value = "应用编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_ID , value = "渠道编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_CODE , value = "渠道编码" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.ORDER_ID , value = "支付订单" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.TRADE_NO , value = "交易订单" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.MERCHANT_ORDER_ID , value = "商户订单编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.MERCHANT_REFUND_NO , value = "商户退款订单号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.NOTIFY_URL , value = "异步通知商户地址" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.NOTIFY_STATUS , value = "回调状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.TYPE , value = "退款类型" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.PAY_AMOUNT , value = "支付金额" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = PayRefundVOMeta.REFUND_AMOUNT , value = "退款金额" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = PayRefundVOMeta.REASON , value = "退款原因" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.USER_IP , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_ORDER_NO , value = "渠道订单号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_REFUND_NO , value = "渠道退款单号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_ERROR_CODE , value = "渠道调用报错时" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_ERROR_MSG , value = "渠道调用报错时" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_EXTRAS , value = "支付渠道的额外参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.EXPIRE_TIME , value = "退款失效时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayRefundVOMeta.SUCCESS_TIME , value = "退款成功时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayRefundVOMeta.NOTIFY_TIME , value = "退款通知时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PayRefundVOMeta.PAGE_INDEX , PayRefundVOMeta.PAGE_SIZE , PayRefundVOMeta.SEARCH_FIELD , PayRefundVOMeta.FUZZY_FIELD , PayRefundVOMeta.SEARCH_VALUE , PayRefundVOMeta.DIRTY_FIELDS , PayRefundVOMeta.SORT_FIELD , PayRefundVOMeta.SORT_TYPE , PayRefundVOMeta.DATA_ORIGIN , PayRefundVOMeta.QUERY_LOGIC , PayRefundVOMeta.REQUEST_ACTION , PayRefundVOMeta.IDS } )
	@SentinelResource(value = PayRefundServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayRefundServiceProxy.SAVE)
	public Result save(PayRefundVO payRefundVO) {
		
		Result result=payRefundService.save(payRefundVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取退款订单
	*/
	@ApiOperation(value = "获取退款订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayRefundVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayRefundServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayRefundServiceProxy.GET_BY_ID)
	public Result<PayRefund> getById(String id) {
		
		Result<PayRefund> result=new Result<>();
		PayRefund payRefund=payRefundService.getById(id);
		// join 关联的对象
		payRefundService.dao().fill(payRefund)
			.with(PayOrderMeta.PAY_MERCHANT)
			.with(PayOrderMeta.PAY_APP)
			.with(PayOrderMeta.PAY_CHANNEL)
			.with(PayRefundMeta.PAY_ORDER)
			.execute();
		result.success(true).data(payRefund);
		return result;
	}


	/**
	 * 批量获取退款订单 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取退款订单")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PayRefundVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PayRefundServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayRefundServiceProxy.GET_BY_IDS)
	public Result<List<PayRefund>> getByIds(List<String> ids) {
		
		Result<List<PayRefund>> result=new Result<>();
		List<PayRefund> list=payRefundService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询退款订单
	*/
	@ApiOperation(value = "查询退款订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayRefundVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.STATUS , value = "退款状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.MERCHANT_ID , value = "商户编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.APP_ID , value = "应用编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_ID , value = "渠道编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_CODE , value = "渠道编码" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.ORDER_ID , value = "支付订单" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.TRADE_NO , value = "交易订单" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.MERCHANT_ORDER_ID , value = "商户订单编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.MERCHANT_REFUND_NO , value = "商户退款订单号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.NOTIFY_URL , value = "异步通知商户地址" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.NOTIFY_STATUS , value = "回调状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.TYPE , value = "退款类型" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.PAY_AMOUNT , value = "支付金额" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = PayRefundVOMeta.REFUND_AMOUNT , value = "退款金额" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = PayRefundVOMeta.REASON , value = "退款原因" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.USER_IP , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_ORDER_NO , value = "渠道订单号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_REFUND_NO , value = "渠道退款单号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_ERROR_CODE , value = "渠道调用报错时" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_ERROR_MSG , value = "渠道调用报错时" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_EXTRAS , value = "支付渠道的额外参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.EXPIRE_TIME , value = "退款失效时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayRefundVOMeta.SUCCESS_TIME , value = "退款成功时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayRefundVOMeta.NOTIFY_TIME , value = "退款通知时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PayRefundVOMeta.PAGE_INDEX , PayRefundVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PayRefundServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayRefundServiceProxy.QUERY_LIST)
	public Result<List<PayRefund>> queryList(PayRefundVO sample) {
		
		Result<List<PayRefund>> result=new Result<>();
		List<PayRefund> list=payRefundService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询退款订单
	*/
	@ApiOperation(value = "分页查询退款订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayRefundVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.STATUS , value = "退款状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.MERCHANT_ID , value = "商户编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.APP_ID , value = "应用编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_ID , value = "渠道编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_CODE , value = "渠道编码" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.ORDER_ID , value = "支付订单" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.TRADE_NO , value = "交易订单" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.MERCHANT_ORDER_ID , value = "商户订单编号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.MERCHANT_REFUND_NO , value = "商户退款订单号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.NOTIFY_URL , value = "异步通知商户地址" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.NOTIFY_STATUS , value = "回调状态" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.TYPE , value = "退款类型" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.PAY_AMOUNT , value = "支付金额" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = PayRefundVOMeta.REFUND_AMOUNT , value = "退款金额" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = PayRefundVOMeta.REASON , value = "退款原因" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.USER_IP , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_ORDER_NO , value = "渠道订单号" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_REFUND_NO , value = "渠道退款单号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_ERROR_CODE , value = "渠道调用报错时" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_ERROR_MSG , value = "渠道调用报错时" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.CHANNEL_EXTRAS , value = "支付渠道的额外参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayRefundVOMeta.EXPIRE_TIME , value = "退款失效时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayRefundVOMeta.SUCCESS_TIME , value = "退款成功时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PayRefundVOMeta.NOTIFY_TIME , value = "退款通知时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayRefundServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayRefundServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PayRefund>> queryPagedList(PayRefundVO sample) {
		
		Result<PagedList<PayRefund>> result=new Result<>();
		PagedList<PayRefund> list=payRefundService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		payRefundService.dao().fill(list)
			.with(PayOrderMeta.PAY_MERCHANT)
			.with(PayOrderMeta.PAY_APP)
			.with(PayOrderMeta.PAY_CHANNEL)
			.with(PayRefundMeta.PAY_ORDER)
			.execute();
		result.success(true).data(list);
		return result;
	}





}