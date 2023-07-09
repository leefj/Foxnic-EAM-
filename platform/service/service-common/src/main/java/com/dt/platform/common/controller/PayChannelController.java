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


import com.dt.platform.proxy.common.PayChannelServiceProxy;
import com.dt.platform.domain.common.meta.PayChannelVOMeta;
import com.dt.platform.domain.common.PayChannel;
import com.dt.platform.domain.common.PayChannelVO;
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
import com.dt.platform.domain.common.meta.PayChannelMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.common.PayMerchant;
import com.dt.platform.domain.common.PayApp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IPayChannelService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 支付渠道接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-04 11:37:37
*/

@InDoc
@Api(tags = "支付渠道")
@RestController("SysPayChannelController")
public class PayChannelController extends SuperController {

	@Autowired
	private IPayChannelService payChannelService;

	/**
	 * 添加支付渠道
	*/
	@ApiOperation(value = "添加支付渠道")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayChannelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.MERCHANT_ID , value = "商户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.APP_ID , value = "应用" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.CODE , value = "渠道编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.NAME , value = "渠道名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.FEE_RATE , value = "渠道费率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PayChannelVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.CONFIG , value = "配置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayChannelServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayChannelServiceProxy.INSERT)
	public Result insert(PayChannelVO payChannelVO) {
		
		Result result=payChannelService.insert(payChannelVO,false);
		return result;
	}



	/**
	 * 删除支付渠道
	*/
	@ApiOperation(value = "删除支付渠道")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayChannelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayChannelServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayChannelServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  payChannelService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=payChannelService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除支付渠道 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除支付渠道")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayChannelVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PayChannelServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayChannelServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = payChannelService.hasRefers(ids);
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
			Result result=payChannelService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=payChannelService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新支付渠道
	*/
	@ApiOperation(value = "更新支付渠道")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayChannelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.MERCHANT_ID , value = "商户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.APP_ID , value = "应用" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.CODE , value = "渠道编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.NAME , value = "渠道名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.FEE_RATE , value = "渠道费率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PayChannelVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.CONFIG , value = "配置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PayChannelVOMeta.PAGE_INDEX , PayChannelVOMeta.PAGE_SIZE , PayChannelVOMeta.SEARCH_FIELD , PayChannelVOMeta.FUZZY_FIELD , PayChannelVOMeta.SEARCH_VALUE , PayChannelVOMeta.DIRTY_FIELDS , PayChannelVOMeta.SORT_FIELD , PayChannelVOMeta.SORT_TYPE , PayChannelVOMeta.DATA_ORIGIN , PayChannelVOMeta.QUERY_LOGIC , PayChannelVOMeta.REQUEST_ACTION , PayChannelVOMeta.IDS } )
	@SentinelResource(value = PayChannelServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayChannelServiceProxy.UPDATE)
	public Result update(PayChannelVO payChannelVO) {
		
		Result result=payChannelService.update(payChannelVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存支付渠道
	*/
	@ApiOperation(value = "保存支付渠道")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayChannelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.MERCHANT_ID , value = "商户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.APP_ID , value = "应用" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.CODE , value = "渠道编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.NAME , value = "渠道名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.FEE_RATE , value = "渠道费率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PayChannelVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.CONFIG , value = "配置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PayChannelVOMeta.PAGE_INDEX , PayChannelVOMeta.PAGE_SIZE , PayChannelVOMeta.SEARCH_FIELD , PayChannelVOMeta.FUZZY_FIELD , PayChannelVOMeta.SEARCH_VALUE , PayChannelVOMeta.DIRTY_FIELDS , PayChannelVOMeta.SORT_FIELD , PayChannelVOMeta.SORT_TYPE , PayChannelVOMeta.DATA_ORIGIN , PayChannelVOMeta.QUERY_LOGIC , PayChannelVOMeta.REQUEST_ACTION , PayChannelVOMeta.IDS } )
	@SentinelResource(value = PayChannelServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayChannelServiceProxy.SAVE)
	public Result save(PayChannelVO payChannelVO) {
		
		Result result=payChannelService.save(payChannelVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取支付渠道
	*/
	@ApiOperation(value = "获取支付渠道")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayChannelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayChannelServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayChannelServiceProxy.GET_BY_ID)
	public Result<PayChannel> getById(String id) {
		
		Result<PayChannel> result=new Result<>();
		PayChannel payChannel=payChannelService.getById(id);
		// join 关联的对象
		payChannelService.dao().fill(payChannel)
			.with(PayChannelMeta.PAY_MERCHANT)
			.with(PayChannelMeta.PAY_APP)
			.execute();
		result.success(true).data(payChannel);
		return result;
	}


	/**
	 * 批量获取支付渠道 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取支付渠道")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PayChannelVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PayChannelServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayChannelServiceProxy.GET_BY_IDS)
	public Result<List<PayChannel>> getByIds(List<String> ids) {
		
		Result<List<PayChannel>> result=new Result<>();
		List<PayChannel> list=payChannelService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询支付渠道
	*/
	@ApiOperation(value = "查询支付渠道")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayChannelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.MERCHANT_ID , value = "商户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.APP_ID , value = "应用" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.CODE , value = "渠道编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.NAME , value = "渠道名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.FEE_RATE , value = "渠道费率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PayChannelVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.CONFIG , value = "配置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PayChannelVOMeta.PAGE_INDEX , PayChannelVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PayChannelServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayChannelServiceProxy.QUERY_LIST)
	public Result<List<PayChannel>> queryList(PayChannelVO sample) {
		
		Result<List<PayChannel>> result=new Result<>();
		List<PayChannel> list=payChannelService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询支付渠道
	*/
	@ApiOperation(value = "分页查询支付渠道")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayChannelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.MERCHANT_ID , value = "商户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.APP_ID , value = "应用" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.CODE , value = "渠道编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.NAME , value = "渠道名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.FEE_RATE , value = "渠道费率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = PayChannelVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.CONFIG , value = "配置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayChannelVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayChannelServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayChannelServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PayChannel>> queryPagedList(PayChannelVO sample) {
		
		Result<PagedList<PayChannel>> result=new Result<>();
		PagedList<PayChannel> list=payChannelService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		payChannelService.dao().fill(list)
			.with(PayChannelMeta.PAY_MERCHANT)
			.with(PayChannelMeta.PAY_APP)
			.execute();
		result.success(true).data(list);
		return result;
	}





}