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


import com.dt.platform.proxy.eam.AssetDataPermissionsWhServiceProxy;
import com.dt.platform.domain.eam.meta.AssetDataPermissionsWhVOMeta;
import com.dt.platform.domain.eam.AssetDataPermissionsWh;
import com.dt.platform.domain.eam.AssetDataPermissionsWhVO;
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
import com.dt.platform.domain.eam.meta.AssetDataPermissionsWhMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetDataPermissionsWhService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 仓库接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-26 07:46:41
*/

@InDoc
@Api(tags = "仓库")
@RestController("EamAssetDataPermissionsWhController")
public class AssetDataPermissionsWhController extends SuperController {

	@Autowired
	private IAssetDataPermissionsWhService assetDataPermissionsWhService;

	/**
	 * 添加仓库
	*/
	@ApiOperation(value = "添加仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataPermissionsWhVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataPermissionsWhVOMeta.PERMISSION_ID , value = "权限" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataPermissionsWhVOMeta.VALUE , value = "值" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetDataPermissionsWhServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataPermissionsWhServiceProxy.INSERT)
	public Result insert(AssetDataPermissionsWhVO assetDataPermissionsWhVO) {
		
		Result result=assetDataPermissionsWhService.insert(assetDataPermissionsWhVO,false);
		return result;
	}



	/**
	 * 删除仓库
	*/
	@ApiOperation(value = "删除仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataPermissionsWhVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetDataPermissionsWhServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataPermissionsWhServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  assetDataPermissionsWhService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=assetDataPermissionsWhService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除仓库 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataPermissionsWhVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AssetDataPermissionsWhServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataPermissionsWhServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = assetDataPermissionsWhService.hasRefers(ids);
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
			Result result=assetDataPermissionsWhService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=assetDataPermissionsWhService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新仓库
	*/
	@ApiOperation(value = "更新仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataPermissionsWhVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataPermissionsWhVOMeta.PERMISSION_ID , value = "权限" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataPermissionsWhVOMeta.VALUE , value = "值" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetDataPermissionsWhVOMeta.PAGE_INDEX , AssetDataPermissionsWhVOMeta.PAGE_SIZE , AssetDataPermissionsWhVOMeta.SEARCH_FIELD , AssetDataPermissionsWhVOMeta.FUZZY_FIELD , AssetDataPermissionsWhVOMeta.SEARCH_VALUE , AssetDataPermissionsWhVOMeta.DIRTY_FIELDS , AssetDataPermissionsWhVOMeta.SORT_FIELD , AssetDataPermissionsWhVOMeta.SORT_TYPE , AssetDataPermissionsWhVOMeta.DATA_ORIGIN , AssetDataPermissionsWhVOMeta.QUERY_LOGIC , AssetDataPermissionsWhVOMeta.REQUEST_ACTION , AssetDataPermissionsWhVOMeta.IDS } )
	@SentinelResource(value = AssetDataPermissionsWhServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataPermissionsWhServiceProxy.UPDATE)
	public Result update(AssetDataPermissionsWhVO assetDataPermissionsWhVO) {
		
		Result result=assetDataPermissionsWhService.update(assetDataPermissionsWhVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存仓库
	*/
	@ApiOperation(value = "保存仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataPermissionsWhVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataPermissionsWhVOMeta.PERMISSION_ID , value = "权限" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataPermissionsWhVOMeta.VALUE , value = "值" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetDataPermissionsWhVOMeta.PAGE_INDEX , AssetDataPermissionsWhVOMeta.PAGE_SIZE , AssetDataPermissionsWhVOMeta.SEARCH_FIELD , AssetDataPermissionsWhVOMeta.FUZZY_FIELD , AssetDataPermissionsWhVOMeta.SEARCH_VALUE , AssetDataPermissionsWhVOMeta.DIRTY_FIELDS , AssetDataPermissionsWhVOMeta.SORT_FIELD , AssetDataPermissionsWhVOMeta.SORT_TYPE , AssetDataPermissionsWhVOMeta.DATA_ORIGIN , AssetDataPermissionsWhVOMeta.QUERY_LOGIC , AssetDataPermissionsWhVOMeta.REQUEST_ACTION , AssetDataPermissionsWhVOMeta.IDS } )
	@SentinelResource(value = AssetDataPermissionsWhServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataPermissionsWhServiceProxy.SAVE)
	public Result save(AssetDataPermissionsWhVO assetDataPermissionsWhVO) {
		
		Result result=assetDataPermissionsWhService.save(assetDataPermissionsWhVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取仓库
	*/
	@ApiOperation(value = "获取仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataPermissionsWhVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetDataPermissionsWhServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataPermissionsWhServiceProxy.GET_BY_ID)
	public Result<AssetDataPermissionsWh> getById(String id) {
		
		Result<AssetDataPermissionsWh> result=new Result<>();
		AssetDataPermissionsWh assetDataPermissionsWh=assetDataPermissionsWhService.getById(id);
		result.success(true).data(assetDataPermissionsWh);
		return result;
	}


	/**
	 * 批量获取仓库 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取仓库")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetDataPermissionsWhVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AssetDataPermissionsWhServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataPermissionsWhServiceProxy.GET_BY_IDS)
	public Result<List<AssetDataPermissionsWh>> getByIds(List<String> ids) {
		
		Result<List<AssetDataPermissionsWh>> result=new Result<>();
		List<AssetDataPermissionsWh> list=assetDataPermissionsWhService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询仓库
	*/
	@ApiOperation(value = "查询仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataPermissionsWhVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataPermissionsWhVOMeta.PERMISSION_ID , value = "权限" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataPermissionsWhVOMeta.VALUE , value = "值" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetDataPermissionsWhVOMeta.PAGE_INDEX , AssetDataPermissionsWhVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetDataPermissionsWhServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataPermissionsWhServiceProxy.QUERY_LIST)
	public Result<List<AssetDataPermissionsWh>> queryList(AssetDataPermissionsWhVO sample) {
		
		Result<List<AssetDataPermissionsWh>> result=new Result<>();
		List<AssetDataPermissionsWh> list=assetDataPermissionsWhService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询仓库
	*/
	@ApiOperation(value = "分页查询仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataPermissionsWhVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataPermissionsWhVOMeta.PERMISSION_ID , value = "权限" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataPermissionsWhVOMeta.VALUE , value = "值" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetDataPermissionsWhServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataPermissionsWhServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetDataPermissionsWh>> queryPagedList(AssetDataPermissionsWhVO sample) {
		
		Result<PagedList<AssetDataPermissionsWh>> result=new Result<>();
		PagedList<AssetDataPermissionsWh> list=assetDataPermissionsWhService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}