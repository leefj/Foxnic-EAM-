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


import com.dt.platform.proxy.common.ScreenDsCategoryServiceProxy;
import com.dt.platform.domain.common.meta.ScreenDsCategoryVOMeta;
import com.dt.platform.domain.common.ScreenDsCategory;
import com.dt.platform.domain.common.ScreenDsCategoryVO;
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
import com.dt.platform.domain.common.meta.ScreenDsCategoryMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IScreenDsCategoryService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 数据分类接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-28 07:41:51
*/

@InDoc
@Api(tags = "数据分类")
@RestController("SysScreenDsCategoryController")
public class ScreenDsCategoryController extends SuperController {

	@Autowired
	private IScreenDsCategoryService screenDsCategoryService;

	/**
	 * 添加数据分类
	*/
	@ApiOperation(value = "添加数据分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenDsCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsCategoryVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsCategoryVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScreenDsCategoryServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenDsCategoryServiceProxy.INSERT)
	public Result insert(ScreenDsCategoryVO screenDsCategoryVO) {
		
		Result result=screenDsCategoryService.insert(screenDsCategoryVO,false);
		return result;
	}



	/**
	 * 删除数据分类
	*/
	@ApiOperation(value = "删除数据分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenDsCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScreenDsCategoryServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenDsCategoryServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  screenDsCategoryService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=screenDsCategoryService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除数据分类 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除数据分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenDsCategoryVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = ScreenDsCategoryServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenDsCategoryServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = screenDsCategoryService.hasRefers(ids);
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
			Result result=screenDsCategoryService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=screenDsCategoryService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新数据分类
	*/
	@ApiOperation(value = "更新数据分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenDsCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsCategoryVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsCategoryVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScreenDsCategoryVOMeta.PAGE_INDEX , ScreenDsCategoryVOMeta.PAGE_SIZE , ScreenDsCategoryVOMeta.SEARCH_FIELD , ScreenDsCategoryVOMeta.FUZZY_FIELD , ScreenDsCategoryVOMeta.SEARCH_VALUE , ScreenDsCategoryVOMeta.DIRTY_FIELDS , ScreenDsCategoryVOMeta.SORT_FIELD , ScreenDsCategoryVOMeta.SORT_TYPE , ScreenDsCategoryVOMeta.DATA_ORIGIN , ScreenDsCategoryVOMeta.QUERY_LOGIC , ScreenDsCategoryVOMeta.REQUEST_ACTION , ScreenDsCategoryVOMeta.IDS } )
	@SentinelResource(value = ScreenDsCategoryServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenDsCategoryServiceProxy.UPDATE)
	public Result update(ScreenDsCategoryVO screenDsCategoryVO) {
		
		Result result=screenDsCategoryService.update(screenDsCategoryVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存数据分类
	*/
	@ApiOperation(value = "保存数据分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenDsCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsCategoryVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsCategoryVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ScreenDsCategoryVOMeta.PAGE_INDEX , ScreenDsCategoryVOMeta.PAGE_SIZE , ScreenDsCategoryVOMeta.SEARCH_FIELD , ScreenDsCategoryVOMeta.FUZZY_FIELD , ScreenDsCategoryVOMeta.SEARCH_VALUE , ScreenDsCategoryVOMeta.DIRTY_FIELDS , ScreenDsCategoryVOMeta.SORT_FIELD , ScreenDsCategoryVOMeta.SORT_TYPE , ScreenDsCategoryVOMeta.DATA_ORIGIN , ScreenDsCategoryVOMeta.QUERY_LOGIC , ScreenDsCategoryVOMeta.REQUEST_ACTION , ScreenDsCategoryVOMeta.IDS } )
	@SentinelResource(value = ScreenDsCategoryServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenDsCategoryServiceProxy.SAVE)
	public Result save(ScreenDsCategoryVO screenDsCategoryVO) {
		
		Result result=screenDsCategoryService.save(screenDsCategoryVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取数据分类
	*/
	@ApiOperation(value = "获取数据分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenDsCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScreenDsCategoryServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenDsCategoryServiceProxy.GET_BY_ID)
	public Result<ScreenDsCategory> getById(String id) {
		
		Result<ScreenDsCategory> result=new Result<>();
		ScreenDsCategory screenDsCategory=screenDsCategoryService.getById(id);
		result.success(true).data(screenDsCategory);
		return result;
	}


	/**
	 * 批量获取数据分类 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取数据分类")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ScreenDsCategoryVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = ScreenDsCategoryServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenDsCategoryServiceProxy.GET_BY_IDS)
	public Result<List<ScreenDsCategory>> getByIds(List<String> ids) {
		
		Result<List<ScreenDsCategory>> result=new Result<>();
		List<ScreenDsCategory> list=screenDsCategoryService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询数据分类
	*/
	@ApiOperation(value = "查询数据分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenDsCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsCategoryVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsCategoryVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScreenDsCategoryVOMeta.PAGE_INDEX , ScreenDsCategoryVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ScreenDsCategoryServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenDsCategoryServiceProxy.QUERY_LIST)
	public Result<List<ScreenDsCategory>> queryList(ScreenDsCategoryVO sample) {
		
		Result<List<ScreenDsCategory>> result=new Result<>();
		List<ScreenDsCategory> list=screenDsCategoryService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询数据分类
	*/
	@ApiOperation(value = "分页查询数据分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScreenDsCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsCategoryVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScreenDsCategoryVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScreenDsCategoryServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScreenDsCategoryServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ScreenDsCategory>> queryPagedList(ScreenDsCategoryVO sample) {
		
		Result<PagedList<ScreenDsCategory>> result=new Result<>();
		PagedList<ScreenDsCategory> list=screenDsCategoryService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}