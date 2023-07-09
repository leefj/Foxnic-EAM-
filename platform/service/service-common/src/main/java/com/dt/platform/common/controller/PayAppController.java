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


import com.dt.platform.proxy.common.PayAppServiceProxy;
import com.dt.platform.domain.common.meta.PayAppVOMeta;
import com.dt.platform.domain.common.PayApp;
import com.dt.platform.domain.common.PayAppVO;
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
import com.dt.platform.domain.common.meta.PayAppMeta;
import com.dt.platform.domain.common.PayMerchant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IPayAppService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 应用接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-04 11:38:06
*/

@InDoc
@Api(tags = "应用")
@RestController("SysPayAppController")
public class PayAppController extends SuperController {

	@Autowired
	private IPayAppService payAppService;

	/**
	 * 添加应用
	*/
	@ApiOperation(value = "添加应用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayAppVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.CODE , value = "应用编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.NAME , value = "应用名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.PAY_NOTIFY_URL , value = "支付结果回调" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.REFUND_NOTIFY_URL , value = "退款结果回调" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.MERCHANT_ID , value = "商户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayAppServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayAppServiceProxy.INSERT)
	public Result insert(PayAppVO payAppVO) {
		
		Result result=payAppService.insert(payAppVO,false);
		return result;
	}



	/**
	 * 删除应用
	*/
	@ApiOperation(value = "删除应用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayAppVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayAppServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayAppServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  payAppService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=payAppService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除应用 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除应用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayAppVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PayAppServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayAppServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = payAppService.hasRefers(ids);
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
			Result result=payAppService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=payAppService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新应用
	*/
	@ApiOperation(value = "更新应用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayAppVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.CODE , value = "应用编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.NAME , value = "应用名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.PAY_NOTIFY_URL , value = "支付结果回调" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.REFUND_NOTIFY_URL , value = "退款结果回调" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.MERCHANT_ID , value = "商户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PayAppVOMeta.PAGE_INDEX , PayAppVOMeta.PAGE_SIZE , PayAppVOMeta.SEARCH_FIELD , PayAppVOMeta.FUZZY_FIELD , PayAppVOMeta.SEARCH_VALUE , PayAppVOMeta.DIRTY_FIELDS , PayAppVOMeta.SORT_FIELD , PayAppVOMeta.SORT_TYPE , PayAppVOMeta.DATA_ORIGIN , PayAppVOMeta.QUERY_LOGIC , PayAppVOMeta.REQUEST_ACTION , PayAppVOMeta.IDS } )
	@SentinelResource(value = PayAppServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayAppServiceProxy.UPDATE)
	public Result update(PayAppVO payAppVO) {
		
		Result result=payAppService.update(payAppVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存应用
	*/
	@ApiOperation(value = "保存应用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayAppVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.CODE , value = "应用编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.NAME , value = "应用名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.PAY_NOTIFY_URL , value = "支付结果回调" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.REFUND_NOTIFY_URL , value = "退款结果回调" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.MERCHANT_ID , value = "商户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PayAppVOMeta.PAGE_INDEX , PayAppVOMeta.PAGE_SIZE , PayAppVOMeta.SEARCH_FIELD , PayAppVOMeta.FUZZY_FIELD , PayAppVOMeta.SEARCH_VALUE , PayAppVOMeta.DIRTY_FIELDS , PayAppVOMeta.SORT_FIELD , PayAppVOMeta.SORT_TYPE , PayAppVOMeta.DATA_ORIGIN , PayAppVOMeta.QUERY_LOGIC , PayAppVOMeta.REQUEST_ACTION , PayAppVOMeta.IDS } )
	@SentinelResource(value = PayAppServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayAppServiceProxy.SAVE)
	public Result save(PayAppVO payAppVO) {
		
		Result result=payAppService.save(payAppVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取应用
	*/
	@ApiOperation(value = "获取应用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayAppVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayAppServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayAppServiceProxy.GET_BY_ID)
	public Result<PayApp> getById(String id) {
		
		Result<PayApp> result=new Result<>();
		PayApp payApp=payAppService.getById(id);
		// join 关联的对象
		payAppService.dao().fill(payApp)
			.with(PayAppMeta.PAY_MERCHANT)
			.execute();
		result.success(true).data(payApp);
		return result;
	}


	/**
	 * 批量获取应用 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取应用")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PayAppVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PayAppServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayAppServiceProxy.GET_BY_IDS)
	public Result<List<PayApp>> getByIds(List<String> ids) {
		
		Result<List<PayApp>> result=new Result<>();
		List<PayApp> list=payAppService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询应用
	*/
	@ApiOperation(value = "查询应用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayAppVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.CODE , value = "应用编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.NAME , value = "应用名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.PAY_NOTIFY_URL , value = "支付结果回调" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.REFUND_NOTIFY_URL , value = "退款结果回调" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.MERCHANT_ID , value = "商户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PayAppVOMeta.PAGE_INDEX , PayAppVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PayAppServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayAppServiceProxy.QUERY_LIST)
	public Result<List<PayApp>> queryList(PayAppVO sample) {
		
		Result<List<PayApp>> result=new Result<>();
		List<PayApp> list=payAppService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询应用
	*/
	@ApiOperation(value = "分页查询应用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayAppVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.CODE , value = "应用编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.NAME , value = "应用名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.PAY_NOTIFY_URL , value = "支付结果回调" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.REFUND_NOTIFY_URL , value = "退款结果回调" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.MERCHANT_ID , value = "商户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PayAppVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayAppServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayAppServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PayApp>> queryPagedList(PayAppVO sample) {
		
		Result<PagedList<PayApp>> result=new Result<>();
		PagedList<PayApp> list=payAppService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		payAppService.dao().fill(list)
			.with(PayAppMeta.PAY_MERCHANT)
			.execute();
		result.success(true).data(list);
		return result;
	}





}