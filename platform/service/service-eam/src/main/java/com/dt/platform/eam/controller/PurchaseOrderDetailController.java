package com.dt.platform.eam.controller;

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


import com.dt.platform.proxy.eam.PurchaseOrderDetailServiceProxy;
import com.dt.platform.domain.eam.meta.PurchaseOrderDetailVOMeta;
import com.dt.platform.domain.eam.PurchaseOrderDetail;
import com.dt.platform.domain.eam.PurchaseOrderDetailVO;
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
import com.dt.platform.domain.eam.meta.PurchaseOrderDetailMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IPurchaseOrderDetailService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 清单明细接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-07 21:23:16
*/

@InDoc
@Api(tags = "清单明细")
@RestController("EamPurchaseOrderDetailController")
public class PurchaseOrderDetailController extends SuperController {

	@Autowired
	private IPurchaseOrderDetailService purchaseOrderDetailService;

	/**
	 * 添加清单明细
	*/
	@ApiOperation(value = "添加清单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ORDER_ID , value = "清单" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ASSET_ID , value = "资产" , required = true , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PurchaseOrderDetailServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseOrderDetailServiceProxy.INSERT)
	public Result insert(PurchaseOrderDetailVO purchaseOrderDetailVO) {
		
		Result result=purchaseOrderDetailService.insert(purchaseOrderDetailVO,false);
		return result;
	}



	/**
	 * 删除清单明细
	*/
	@ApiOperation(value = "删除清单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PurchaseOrderDetailServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseOrderDetailServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  purchaseOrderDetailService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=purchaseOrderDetailService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除清单明细 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除清单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PurchaseOrderDetailServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseOrderDetailServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = purchaseOrderDetailService.hasRefers(ids);
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
			Result result=purchaseOrderDetailService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=purchaseOrderDetailService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新清单明细
	*/
	@ApiOperation(value = "更新清单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ORDER_ID , value = "清单" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ASSET_ID , value = "资产" , required = true , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PurchaseOrderDetailVOMeta.PAGE_INDEX , PurchaseOrderDetailVOMeta.PAGE_SIZE , PurchaseOrderDetailVOMeta.SEARCH_FIELD , PurchaseOrderDetailVOMeta.FUZZY_FIELD , PurchaseOrderDetailVOMeta.SEARCH_VALUE , PurchaseOrderDetailVOMeta.DIRTY_FIELDS , PurchaseOrderDetailVOMeta.SORT_FIELD , PurchaseOrderDetailVOMeta.SORT_TYPE , PurchaseOrderDetailVOMeta.DATA_ORIGIN , PurchaseOrderDetailVOMeta.QUERY_LOGIC , PurchaseOrderDetailVOMeta.REQUEST_ACTION , PurchaseOrderDetailVOMeta.IDS } )
	@SentinelResource(value = PurchaseOrderDetailServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseOrderDetailServiceProxy.UPDATE)
	public Result update(PurchaseOrderDetailVO purchaseOrderDetailVO) {
		
		Result result=purchaseOrderDetailService.update(purchaseOrderDetailVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存清单明细
	*/
	@ApiOperation(value = "保存清单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ORDER_ID , value = "清单" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ASSET_ID , value = "资产" , required = true , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PurchaseOrderDetailVOMeta.PAGE_INDEX , PurchaseOrderDetailVOMeta.PAGE_SIZE , PurchaseOrderDetailVOMeta.SEARCH_FIELD , PurchaseOrderDetailVOMeta.FUZZY_FIELD , PurchaseOrderDetailVOMeta.SEARCH_VALUE , PurchaseOrderDetailVOMeta.DIRTY_FIELDS , PurchaseOrderDetailVOMeta.SORT_FIELD , PurchaseOrderDetailVOMeta.SORT_TYPE , PurchaseOrderDetailVOMeta.DATA_ORIGIN , PurchaseOrderDetailVOMeta.QUERY_LOGIC , PurchaseOrderDetailVOMeta.REQUEST_ACTION , PurchaseOrderDetailVOMeta.IDS } )
	@SentinelResource(value = PurchaseOrderDetailServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseOrderDetailServiceProxy.SAVE)
	public Result save(PurchaseOrderDetailVO purchaseOrderDetailVO) {
		
		Result result=purchaseOrderDetailService.save(purchaseOrderDetailVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取清单明细
	*/
	@ApiOperation(value = "获取清单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PurchaseOrderDetailServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseOrderDetailServiceProxy.GET_BY_ID)
	public Result<PurchaseOrderDetail> getById(String id) {
		
		Result<PurchaseOrderDetail> result=new Result<>();
		PurchaseOrderDetail purchaseOrderDetail=purchaseOrderDetailService.getById(id);
		result.success(true).data(purchaseOrderDetail);
		return result;
	}


	/**
	 * 批量获取清单明细 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取清单明细")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PurchaseOrderDetailServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseOrderDetailServiceProxy.GET_BY_IDS)
	public Result<List<PurchaseOrderDetail>> getByIds(List<String> ids) {
		
		Result<List<PurchaseOrderDetail>> result=new Result<>();
		List<PurchaseOrderDetail> list=purchaseOrderDetailService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询清单明细
	*/
	@ApiOperation(value = "查询清单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ORDER_ID , value = "清单" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ASSET_ID , value = "资产" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PurchaseOrderDetailVOMeta.PAGE_INDEX , PurchaseOrderDetailVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PurchaseOrderDetailServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseOrderDetailServiceProxy.QUERY_LIST)
	public Result<List<PurchaseOrderDetail>> queryList(PurchaseOrderDetailVO sample) {
		
		Result<List<PurchaseOrderDetail>> result=new Result<>();
		List<PurchaseOrderDetail> list=purchaseOrderDetailService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询清单明细
	*/
	@ApiOperation(value = "分页查询清单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ORDER_ID , value = "清单" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ASSET_ID , value = "资产" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PurchaseOrderDetailServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseOrderDetailServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PurchaseOrderDetail>> queryPagedList(PurchaseOrderDetailVO sample) {
		
		Result<PagedList<PurchaseOrderDetail>> result=new Result<>();
		PagedList<PurchaseOrderDetail> list=purchaseOrderDetailService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}