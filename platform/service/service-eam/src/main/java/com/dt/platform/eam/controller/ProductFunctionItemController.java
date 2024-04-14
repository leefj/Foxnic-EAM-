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


import com.dt.platform.proxy.eam.ProductFunctionItemServiceProxy;
import com.dt.platform.domain.eam.meta.ProductFunctionItemVOMeta;
import com.dt.platform.domain.eam.ProductFunctionItem;
import com.dt.platform.domain.eam.ProductFunctionItemVO;
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
import com.dt.platform.domain.eam.meta.ProductFunctionItemMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IProductFunctionItemService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 内容接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-08 07:38:31
*/

@InDoc
@Api(tags = "内容")
@RestController("IotProductFunctionItemController")
public class ProductFunctionItemController extends SuperController {

	@Autowired
	private IProductFunctionItemService productFunctionItemService;

	/**
	 * 添加内容
	*/
	@ApiOperation(value = "添加内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.IDENTIFIER , value = "标识符" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.FUNCTION_DESC , value = "描述" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.FUNCTION_UNIT , value = "单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.DATA_TYPE , value = "数据类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.DATA_VALUE , value = "内容定义" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ProductFunctionItemServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductFunctionItemServiceProxy.INSERT)
	public Result insert(ProductFunctionItemVO productFunctionItemVO) {
		
		Result result=productFunctionItemService.insert(productFunctionItemVO,false);
		return result;
	}



	/**
	 * 删除内容
	*/
	@ApiOperation(value = "删除内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ProductFunctionItemServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductFunctionItemServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  productFunctionItemService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=productFunctionItemService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除内容 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = ProductFunctionItemServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductFunctionItemServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = productFunctionItemService.hasRefers(ids);
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
			Result result=productFunctionItemService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=productFunctionItemService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新内容
	*/
	@ApiOperation(value = "更新内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.IDENTIFIER , value = "标识符" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.FUNCTION_DESC , value = "描述" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.FUNCTION_UNIT , value = "单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.DATA_TYPE , value = "数据类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.DATA_VALUE , value = "内容定义" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ProductFunctionItemVOMeta.PAGE_INDEX , ProductFunctionItemVOMeta.PAGE_SIZE , ProductFunctionItemVOMeta.SEARCH_FIELD , ProductFunctionItemVOMeta.FUZZY_FIELD , ProductFunctionItemVOMeta.SEARCH_VALUE , ProductFunctionItemVOMeta.DIRTY_FIELDS , ProductFunctionItemVOMeta.SORT_FIELD , ProductFunctionItemVOMeta.SORT_TYPE , ProductFunctionItemVOMeta.DATA_ORIGIN , ProductFunctionItemVOMeta.QUERY_LOGIC , ProductFunctionItemVOMeta.REQUEST_ACTION , ProductFunctionItemVOMeta.IDS } )
	@SentinelResource(value = ProductFunctionItemServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductFunctionItemServiceProxy.UPDATE)
	public Result update(ProductFunctionItemVO productFunctionItemVO) {
		
		Result result=productFunctionItemService.update(productFunctionItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存内容
	*/
	@ApiOperation(value = "保存内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.IDENTIFIER , value = "标识符" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.FUNCTION_DESC , value = "描述" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.FUNCTION_UNIT , value = "单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.DATA_TYPE , value = "数据类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.DATA_VALUE , value = "内容定义" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ProductFunctionItemVOMeta.PAGE_INDEX , ProductFunctionItemVOMeta.PAGE_SIZE , ProductFunctionItemVOMeta.SEARCH_FIELD , ProductFunctionItemVOMeta.FUZZY_FIELD , ProductFunctionItemVOMeta.SEARCH_VALUE , ProductFunctionItemVOMeta.DIRTY_FIELDS , ProductFunctionItemVOMeta.SORT_FIELD , ProductFunctionItemVOMeta.SORT_TYPE , ProductFunctionItemVOMeta.DATA_ORIGIN , ProductFunctionItemVOMeta.QUERY_LOGIC , ProductFunctionItemVOMeta.REQUEST_ACTION , ProductFunctionItemVOMeta.IDS } )
	@SentinelResource(value = ProductFunctionItemServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductFunctionItemServiceProxy.SAVE)
	public Result save(ProductFunctionItemVO productFunctionItemVO) {
		
		Result result=productFunctionItemService.save(productFunctionItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取内容
	*/
	@ApiOperation(value = "获取内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ProductFunctionItemServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductFunctionItemServiceProxy.GET_BY_ID)
	public Result<ProductFunctionItem> getById(String id) {
		
		Result<ProductFunctionItem> result=new Result<>();
		ProductFunctionItem productFunctionItem=productFunctionItemService.getById(id);
		result.success(true).data(productFunctionItem);
		return result;
	}


	/**
	 * 批量获取内容 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取内容")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ProductFunctionItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = ProductFunctionItemServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductFunctionItemServiceProxy.GET_BY_IDS)
	public Result<List<ProductFunctionItem>> getByIds(List<String> ids) {
		
		Result<List<ProductFunctionItem>> result=new Result<>();
		List<ProductFunctionItem> list=productFunctionItemService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询内容
	*/
	@ApiOperation(value = "查询内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.IDENTIFIER , value = "标识符" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.FUNCTION_DESC , value = "描述" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.FUNCTION_UNIT , value = "单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.DATA_TYPE , value = "数据类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.DATA_VALUE , value = "内容定义" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ProductFunctionItemVOMeta.PAGE_INDEX , ProductFunctionItemVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ProductFunctionItemServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductFunctionItemServiceProxy.QUERY_LIST)
	public Result<List<ProductFunctionItem>> queryList(ProductFunctionItemVO sample) {
		
		Result<List<ProductFunctionItem>> result=new Result<>();
		List<ProductFunctionItem> list=productFunctionItemService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询内容
	*/
	@ApiOperation(value = "分页查询内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.IDENTIFIER , value = "标识符" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.FUNCTION_DESC , value = "描述" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.FUNCTION_UNIT , value = "单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.DATA_TYPE , value = "数据类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.DATA_VALUE , value = "内容定义" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductFunctionItemVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ProductFunctionItemServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductFunctionItemServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ProductFunctionItem>> queryPagedList(ProductFunctionItemVO sample) {
		
		Result<PagedList<ProductFunctionItem>> result=new Result<>();
		PagedList<ProductFunctionItem> list=productFunctionItemService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}