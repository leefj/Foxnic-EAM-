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


import com.dt.platform.proxy.eam.RelatedItemsServiceProxy;
import com.dt.platform.domain.eam.meta.RelatedItemsVOMeta;
import com.dt.platform.domain.eam.RelatedItems;
import com.dt.platform.domain.eam.RelatedItemsVO;
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
import com.dt.platform.domain.eam.meta.RelatedItemsMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IRelatedItemsService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 关联项接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-27 07:24:05
*/

@InDoc
@Api(tags = "关联项")
@RestController("EamRelatedItemsController")
public class RelatedItemsController extends SuperController {

	@Autowired
	private IRelatedItemsService relatedItemsService;

	/**
	 * 添加关联项
	*/
	@ApiOperation(value = "添加关联项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RelatedItemsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RelatedItemsVOMeta.OWNER_ID , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RelatedItemsVOMeta.ITEM_ID , value = "项目" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RelatedItemsVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RelatedItemsServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RelatedItemsServiceProxy.INSERT)
	public Result insert(RelatedItemsVO relatedItemsVO) {
		
		Result result=relatedItemsService.insert(relatedItemsVO,false);
		return result;
	}



	/**
	 * 删除关联项
	*/
	@ApiOperation(value = "删除关联项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RelatedItemsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RelatedItemsServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RelatedItemsServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  relatedItemsService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=relatedItemsService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除关联项 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除关联项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RelatedItemsVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = RelatedItemsServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RelatedItemsServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = relatedItemsService.hasRefers(ids);
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
			Result result=relatedItemsService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=relatedItemsService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新关联项
	*/
	@ApiOperation(value = "更新关联项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RelatedItemsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RelatedItemsVOMeta.OWNER_ID , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RelatedItemsVOMeta.ITEM_ID , value = "项目" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RelatedItemsVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { RelatedItemsVOMeta.PAGE_INDEX , RelatedItemsVOMeta.PAGE_SIZE , RelatedItemsVOMeta.SEARCH_FIELD , RelatedItemsVOMeta.FUZZY_FIELD , RelatedItemsVOMeta.SEARCH_VALUE , RelatedItemsVOMeta.DIRTY_FIELDS , RelatedItemsVOMeta.SORT_FIELD , RelatedItemsVOMeta.SORT_TYPE , RelatedItemsVOMeta.DATA_ORIGIN , RelatedItemsVOMeta.QUERY_LOGIC , RelatedItemsVOMeta.REQUEST_ACTION , RelatedItemsVOMeta.IDS } )
	@SentinelResource(value = RelatedItemsServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RelatedItemsServiceProxy.UPDATE)
	public Result update(RelatedItemsVO relatedItemsVO) {
		
		Result result=relatedItemsService.update(relatedItemsVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存关联项
	*/
	@ApiOperation(value = "保存关联项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RelatedItemsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RelatedItemsVOMeta.OWNER_ID , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RelatedItemsVOMeta.ITEM_ID , value = "项目" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RelatedItemsVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RelatedItemsVOMeta.PAGE_INDEX , RelatedItemsVOMeta.PAGE_SIZE , RelatedItemsVOMeta.SEARCH_FIELD , RelatedItemsVOMeta.FUZZY_FIELD , RelatedItemsVOMeta.SEARCH_VALUE , RelatedItemsVOMeta.DIRTY_FIELDS , RelatedItemsVOMeta.SORT_FIELD , RelatedItemsVOMeta.SORT_TYPE , RelatedItemsVOMeta.DATA_ORIGIN , RelatedItemsVOMeta.QUERY_LOGIC , RelatedItemsVOMeta.REQUEST_ACTION , RelatedItemsVOMeta.IDS } )
	@SentinelResource(value = RelatedItemsServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RelatedItemsServiceProxy.SAVE)
	public Result save(RelatedItemsVO relatedItemsVO) {
		
		Result result=relatedItemsService.save(relatedItemsVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取关联项
	*/
	@ApiOperation(value = "获取关联项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RelatedItemsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RelatedItemsServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RelatedItemsServiceProxy.GET_BY_ID)
	public Result<RelatedItems> getById(String id) {
		
		Result<RelatedItems> result=new Result<>();
		RelatedItems relatedItems=relatedItemsService.getById(id);
		result.success(true).data(relatedItems);
		return result;
	}


	/**
	 * 批量获取关联项 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取关联项")
		@ApiImplicitParams({
				@ApiImplicitParam(name = RelatedItemsVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = RelatedItemsServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RelatedItemsServiceProxy.GET_BY_IDS)
	public Result<List<RelatedItems>> getByIds(List<String> ids) {
		
		Result<List<RelatedItems>> result=new Result<>();
		List<RelatedItems> list=relatedItemsService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询关联项
	*/
	@ApiOperation(value = "查询关联项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RelatedItemsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RelatedItemsVOMeta.OWNER_ID , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RelatedItemsVOMeta.ITEM_ID , value = "项目" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RelatedItemsVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { RelatedItemsVOMeta.PAGE_INDEX , RelatedItemsVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RelatedItemsServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RelatedItemsServiceProxy.QUERY_LIST)
	public Result<List<RelatedItems>> queryList(RelatedItemsVO sample) {
		
		Result<List<RelatedItems>> result=new Result<>();
		List<RelatedItems> list=relatedItemsService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询关联项
	*/
	@ApiOperation(value = "分页查询关联项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RelatedItemsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RelatedItemsVOMeta.OWNER_ID , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RelatedItemsVOMeta.ITEM_ID , value = "项目" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RelatedItemsVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RelatedItemsServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RelatedItemsServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<RelatedItems>> queryPagedList(RelatedItemsVO sample) {
		
		Result<PagedList<RelatedItems>> result=new Result<>();
		PagedList<RelatedItems> list=relatedItemsService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}