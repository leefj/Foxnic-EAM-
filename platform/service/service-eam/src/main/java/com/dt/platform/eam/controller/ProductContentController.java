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


import com.dt.platform.proxy.eam.ProductContentServiceProxy;
import com.dt.platform.domain.eam.meta.ProductContentVOMeta;
import com.dt.platform.domain.eam.ProductContent;
import com.dt.platform.domain.eam.ProductContentVO;
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
import com.dt.platform.domain.eam.meta.ProductContentMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IProductContentService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 设备内容接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-08 07:37:34
*/

@InDoc
@Api(tags = "设备内容")
@RestController("IotProductContentController")
public class ProductContentController extends SuperController {

	@Autowired
	private IProductContentService productContentService;

	/**
	 * 添加设备内容
	*/
	@ApiOperation(value = "添加设备内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductContentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.OWNER_ID , value = "产品" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.CONF , value = "配置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.TSL , value = "TSL" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ProductContentServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductContentServiceProxy.INSERT)
	public Result insert(ProductContentVO productContentVO) {
		
		Result result=productContentService.insert(productContentVO,false);
		return result;
	}



	/**
	 * 删除设备内容
	*/
	@ApiOperation(value = "删除设备内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductContentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ProductContentServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductContentServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  productContentService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=productContentService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除设备内容 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除设备内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductContentVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = ProductContentServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductContentServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = productContentService.hasRefers(ids);
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
			Result result=productContentService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=productContentService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新设备内容
	*/
	@ApiOperation(value = "更新设备内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductContentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.OWNER_ID , value = "产品" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.CONF , value = "配置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.TSL , value = "TSL" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ProductContentVOMeta.PAGE_INDEX , ProductContentVOMeta.PAGE_SIZE , ProductContentVOMeta.SEARCH_FIELD , ProductContentVOMeta.FUZZY_FIELD , ProductContentVOMeta.SEARCH_VALUE , ProductContentVOMeta.DIRTY_FIELDS , ProductContentVOMeta.SORT_FIELD , ProductContentVOMeta.SORT_TYPE , ProductContentVOMeta.DATA_ORIGIN , ProductContentVOMeta.QUERY_LOGIC , ProductContentVOMeta.REQUEST_ACTION , ProductContentVOMeta.IDS } )
	@SentinelResource(value = ProductContentServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductContentServiceProxy.UPDATE)
	public Result update(ProductContentVO productContentVO) {
		
		Result result=productContentService.update(productContentVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存设备内容
	*/
	@ApiOperation(value = "保存设备内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductContentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.OWNER_ID , value = "产品" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.CONF , value = "配置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.TSL , value = "TSL" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ProductContentVOMeta.PAGE_INDEX , ProductContentVOMeta.PAGE_SIZE , ProductContentVOMeta.SEARCH_FIELD , ProductContentVOMeta.FUZZY_FIELD , ProductContentVOMeta.SEARCH_VALUE , ProductContentVOMeta.DIRTY_FIELDS , ProductContentVOMeta.SORT_FIELD , ProductContentVOMeta.SORT_TYPE , ProductContentVOMeta.DATA_ORIGIN , ProductContentVOMeta.QUERY_LOGIC , ProductContentVOMeta.REQUEST_ACTION , ProductContentVOMeta.IDS } )
	@SentinelResource(value = ProductContentServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductContentServiceProxy.SAVE)
	public Result save(ProductContentVO productContentVO) {
		
		Result result=productContentService.save(productContentVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取设备内容
	*/
	@ApiOperation(value = "获取设备内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductContentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ProductContentServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductContentServiceProxy.GET_BY_ID)
	public Result<ProductContent> getById(String id) {
		
		Result<ProductContent> result=new Result<>();
		ProductContent productContent=productContentService.getById(id);
		result.success(true).data(productContent);
		return result;
	}


	/**
	 * 批量获取设备内容 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取设备内容")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ProductContentVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = ProductContentServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductContentServiceProxy.GET_BY_IDS)
	public Result<List<ProductContent>> getByIds(List<String> ids) {
		
		Result<List<ProductContent>> result=new Result<>();
		List<ProductContent> list=productContentService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询设备内容
	*/
	@ApiOperation(value = "查询设备内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductContentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.OWNER_ID , value = "产品" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.CONF , value = "配置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.TSL , value = "TSL" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ProductContentVOMeta.PAGE_INDEX , ProductContentVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ProductContentServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductContentServiceProxy.QUERY_LIST)
	public Result<List<ProductContent>> queryList(ProductContentVO sample) {
		
		Result<List<ProductContent>> result=new Result<>();
		List<ProductContent> list=productContentService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询设备内容
	*/
	@ApiOperation(value = "分页查询设备内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductContentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.OWNER_ID , value = "产品" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.CONF , value = "配置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.TSL , value = "TSL" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductContentVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ProductContentServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductContentServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ProductContent>> queryPagedList(ProductContentVO sample) {
		
		Result<PagedList<ProductContent>> result=new Result<>();
		PagedList<ProductContent> list=productContentService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}