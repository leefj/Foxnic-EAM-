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


import com.dt.platform.proxy.common.PayMerchantServiceProxy;
import com.dt.platform.domain.common.meta.PayMerchantVOMeta;
import com.dt.platform.domain.common.PayMerchant;
import com.dt.platform.domain.common.PayMerchantVO;
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
import com.dt.platform.domain.common.meta.PayMerchantMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IPayMerchantService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 商户信息接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-04 10:43:19
*/

@InDoc
@Api(tags = "商户信息")
@RestController("SysPayMerchantController")
public class PayMerchantController extends SuperController {

	@Autowired
	private IPayMerchantService payMerchantService;

	/**
	 * 添加商户信息
	*/
	@ApiOperation(value = "添加商户信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayMerchantVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "728560624543465472"),
		@ApiImplicitParam(name = PayMerchantVOMeta.NUMBER , value = "商户号" , required = false , dataTypeClass=String.class , example = "T1"),
		@ApiImplicitParam(name = PayMerchantVOMeta.NAME , value = "商户全称" , required = false , dataTypeClass=String.class , example = "示例商户"),
		@ApiImplicitParam(name = PayMerchantVOMeta.SHORT_NAME , value = "商户简称" , required = false , dataTypeClass=String.class , example = "示例商户"),
		@ApiImplicitParam(name = PayMerchantVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = PayMerchantVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayMerchantServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayMerchantServiceProxy.INSERT)
	public Result insert(PayMerchantVO payMerchantVO) {
		
		Result result=payMerchantService.insert(payMerchantVO,false);
		return result;
	}



	/**
	 * 删除商户信息
	*/
	@ApiOperation(value = "删除商户信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayMerchantVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "728560624543465472")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayMerchantServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayMerchantServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  payMerchantService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=payMerchantService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除商户信息 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除商户信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayMerchantVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PayMerchantServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayMerchantServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = payMerchantService.hasRefers(ids);
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
			Result result=payMerchantService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=payMerchantService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新商户信息
	*/
	@ApiOperation(value = "更新商户信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayMerchantVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "728560624543465472"),
		@ApiImplicitParam(name = PayMerchantVOMeta.NUMBER , value = "商户号" , required = false , dataTypeClass=String.class , example = "T1"),
		@ApiImplicitParam(name = PayMerchantVOMeta.NAME , value = "商户全称" , required = false , dataTypeClass=String.class , example = "示例商户"),
		@ApiImplicitParam(name = PayMerchantVOMeta.SHORT_NAME , value = "商户简称" , required = false , dataTypeClass=String.class , example = "示例商户"),
		@ApiImplicitParam(name = PayMerchantVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = PayMerchantVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PayMerchantVOMeta.PAGE_INDEX , PayMerchantVOMeta.PAGE_SIZE , PayMerchantVOMeta.SEARCH_FIELD , PayMerchantVOMeta.FUZZY_FIELD , PayMerchantVOMeta.SEARCH_VALUE , PayMerchantVOMeta.DIRTY_FIELDS , PayMerchantVOMeta.SORT_FIELD , PayMerchantVOMeta.SORT_TYPE , PayMerchantVOMeta.DATA_ORIGIN , PayMerchantVOMeta.QUERY_LOGIC , PayMerchantVOMeta.REQUEST_ACTION , PayMerchantVOMeta.IDS } )
	@SentinelResource(value = PayMerchantServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayMerchantServiceProxy.UPDATE)
	public Result update(PayMerchantVO payMerchantVO) {
		
		Result result=payMerchantService.update(payMerchantVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存商户信息
	*/
	@ApiOperation(value = "保存商户信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayMerchantVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "728560624543465472"),
		@ApiImplicitParam(name = PayMerchantVOMeta.NUMBER , value = "商户号" , required = false , dataTypeClass=String.class , example = "T1"),
		@ApiImplicitParam(name = PayMerchantVOMeta.NAME , value = "商户全称" , required = false , dataTypeClass=String.class , example = "示例商户"),
		@ApiImplicitParam(name = PayMerchantVOMeta.SHORT_NAME , value = "商户简称" , required = false , dataTypeClass=String.class , example = "示例商户"),
		@ApiImplicitParam(name = PayMerchantVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = PayMerchantVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PayMerchantVOMeta.PAGE_INDEX , PayMerchantVOMeta.PAGE_SIZE , PayMerchantVOMeta.SEARCH_FIELD , PayMerchantVOMeta.FUZZY_FIELD , PayMerchantVOMeta.SEARCH_VALUE , PayMerchantVOMeta.DIRTY_FIELDS , PayMerchantVOMeta.SORT_FIELD , PayMerchantVOMeta.SORT_TYPE , PayMerchantVOMeta.DATA_ORIGIN , PayMerchantVOMeta.QUERY_LOGIC , PayMerchantVOMeta.REQUEST_ACTION , PayMerchantVOMeta.IDS } )
	@SentinelResource(value = PayMerchantServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayMerchantServiceProxy.SAVE)
	public Result save(PayMerchantVO payMerchantVO) {
		
		Result result=payMerchantService.save(payMerchantVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取商户信息
	*/
	@ApiOperation(value = "获取商户信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayMerchantVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayMerchantServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayMerchantServiceProxy.GET_BY_ID)
	public Result<PayMerchant> getById(String id) {
		
		Result<PayMerchant> result=new Result<>();
		PayMerchant payMerchant=payMerchantService.getById(id);
		result.success(true).data(payMerchant);
		return result;
	}


	/**
	 * 批量获取商户信息 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取商户信息")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PayMerchantVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PayMerchantServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayMerchantServiceProxy.GET_BY_IDS)
	public Result<List<PayMerchant>> getByIds(List<String> ids) {
		
		Result<List<PayMerchant>> result=new Result<>();
		List<PayMerchant> list=payMerchantService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询商户信息
	*/
	@ApiOperation(value = "查询商户信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayMerchantVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "728560624543465472"),
		@ApiImplicitParam(name = PayMerchantVOMeta.NUMBER , value = "商户号" , required = false , dataTypeClass=String.class , example = "T1"),
		@ApiImplicitParam(name = PayMerchantVOMeta.NAME , value = "商户全称" , required = false , dataTypeClass=String.class , example = "示例商户"),
		@ApiImplicitParam(name = PayMerchantVOMeta.SHORT_NAME , value = "商户简称" , required = false , dataTypeClass=String.class , example = "示例商户"),
		@ApiImplicitParam(name = PayMerchantVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = PayMerchantVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PayMerchantVOMeta.PAGE_INDEX , PayMerchantVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PayMerchantServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayMerchantServiceProxy.QUERY_LIST)
	public Result<List<PayMerchant>> queryList(PayMerchantVO sample) {
		
		Result<List<PayMerchant>> result=new Result<>();
		List<PayMerchant> list=payMerchantService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询商户信息
	*/
	@ApiOperation(value = "分页查询商户信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PayMerchantVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "728560624543465472"),
		@ApiImplicitParam(name = PayMerchantVOMeta.NUMBER , value = "商户号" , required = false , dataTypeClass=String.class , example = "T1"),
		@ApiImplicitParam(name = PayMerchantVOMeta.NAME , value = "商户全称" , required = false , dataTypeClass=String.class , example = "示例商户"),
		@ApiImplicitParam(name = PayMerchantVOMeta.SHORT_NAME , value = "商户简称" , required = false , dataTypeClass=String.class , example = "示例商户"),
		@ApiImplicitParam(name = PayMerchantVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = PayMerchantVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PayMerchantServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PayMerchantServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PayMerchant>> queryPagedList(PayMerchantVO sample) {
		
		Result<PagedList<PayMerchant>> result=new Result<>();
		PagedList<PayMerchant> list=payMerchantService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}