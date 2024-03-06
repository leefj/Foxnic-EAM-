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


import com.dt.platform.proxy.eam.AssetScanSceneServiceProxy;
import com.dt.platform.domain.eam.meta.AssetScanSceneVOMeta;
import com.dt.platform.domain.eam.AssetScanScene;
import com.dt.platform.domain.eam.AssetScanSceneVO;
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
import com.dt.platform.domain.eam.meta.AssetScanSceneMeta;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetScanSceneService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 扫码配置接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-06 15:28:16
*/

@InDoc
@Api(tags = "扫码配置")
@RestController("EamAssetScanSceneController")
public class AssetScanSceneController extends SuperController {

	@Autowired
	private IAssetScanSceneService assetScanSceneService;

	/**
	 * 添加扫码配置
	*/
	@ApiOperation(value = "添加扫码配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetScanSceneVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "817779842689794048"),
		@ApiImplicitParam(name = AssetScanSceneVOMeta.CODE , value = "场景编码" , required = false , dataTypeClass=String.class , example = "mobile_asset_scan"),
		@ApiImplicitParam(name = AssetScanSceneVOMeta.NAME , value = "场景名称" , required = false , dataTypeClass=String.class , example = "移动端资产扫码"),
		@ApiImplicitParam(name = AssetScanSceneVOMeta.METHOD , value = "方式" , required = false , dataTypeClass=String.class , example = "asset_url"),
		@ApiImplicitParam(name = AssetScanSceneVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetScanSceneServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetScanSceneServiceProxy.INSERT)
	public Result insert(AssetScanSceneVO assetScanSceneVO) {
		
		Result result=assetScanSceneService.insert(assetScanSceneVO,false);
		return result;
	}



	/**
	 * 删除扫码配置
	*/
	@ApiOperation(value = "删除扫码配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetScanSceneVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "817779842689794048")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetScanSceneServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetScanSceneServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  assetScanSceneService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=assetScanSceneService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除扫码配置 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除扫码配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetScanSceneVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AssetScanSceneServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetScanSceneServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = assetScanSceneService.hasRefers(ids);
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
			Result result=assetScanSceneService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=assetScanSceneService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新扫码配置
	*/
	@ApiOperation(value = "更新扫码配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetScanSceneVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "817779842689794048"),
		@ApiImplicitParam(name = AssetScanSceneVOMeta.CODE , value = "场景编码" , required = false , dataTypeClass=String.class , example = "mobile_asset_scan"),
		@ApiImplicitParam(name = AssetScanSceneVOMeta.NAME , value = "场景名称" , required = false , dataTypeClass=String.class , example = "移动端资产扫码"),
		@ApiImplicitParam(name = AssetScanSceneVOMeta.METHOD , value = "方式" , required = false , dataTypeClass=String.class , example = "asset_url"),
		@ApiImplicitParam(name = AssetScanSceneVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetScanSceneVOMeta.PAGE_INDEX , AssetScanSceneVOMeta.PAGE_SIZE , AssetScanSceneVOMeta.SEARCH_FIELD , AssetScanSceneVOMeta.FUZZY_FIELD , AssetScanSceneVOMeta.SEARCH_VALUE , AssetScanSceneVOMeta.DIRTY_FIELDS , AssetScanSceneVOMeta.SORT_FIELD , AssetScanSceneVOMeta.SORT_TYPE , AssetScanSceneVOMeta.DATA_ORIGIN , AssetScanSceneVOMeta.QUERY_LOGIC , AssetScanSceneVOMeta.REQUEST_ACTION , AssetScanSceneVOMeta.IDS } )
	@SentinelResource(value = AssetScanSceneServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetScanSceneServiceProxy.UPDATE)
	public Result update(AssetScanSceneVO assetScanSceneVO) {
		
		Result result=assetScanSceneService.update(assetScanSceneVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存扫码配置
	*/
	@ApiOperation(value = "保存扫码配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetScanSceneVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "817779842689794048"),
		@ApiImplicitParam(name = AssetScanSceneVOMeta.CODE , value = "场景编码" , required = false , dataTypeClass=String.class , example = "mobile_asset_scan"),
		@ApiImplicitParam(name = AssetScanSceneVOMeta.NAME , value = "场景名称" , required = false , dataTypeClass=String.class , example = "移动端资产扫码"),
		@ApiImplicitParam(name = AssetScanSceneVOMeta.METHOD , value = "方式" , required = false , dataTypeClass=String.class , example = "asset_url"),
		@ApiImplicitParam(name = AssetScanSceneVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetScanSceneVOMeta.PAGE_INDEX , AssetScanSceneVOMeta.PAGE_SIZE , AssetScanSceneVOMeta.SEARCH_FIELD , AssetScanSceneVOMeta.FUZZY_FIELD , AssetScanSceneVOMeta.SEARCH_VALUE , AssetScanSceneVOMeta.DIRTY_FIELDS , AssetScanSceneVOMeta.SORT_FIELD , AssetScanSceneVOMeta.SORT_TYPE , AssetScanSceneVOMeta.DATA_ORIGIN , AssetScanSceneVOMeta.QUERY_LOGIC , AssetScanSceneVOMeta.REQUEST_ACTION , AssetScanSceneVOMeta.IDS } )
	@SentinelResource(value = AssetScanSceneServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetScanSceneServiceProxy.SAVE)
	public Result save(AssetScanSceneVO assetScanSceneVO) {
		
		Result result=assetScanSceneService.save(assetScanSceneVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取扫码配置
	*/
	@ApiOperation(value = "获取扫码配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetScanSceneVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetScanSceneServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetScanSceneServiceProxy.GET_BY_ID)
	public Result<AssetScanScene> getById(String id) {
		
		Result<AssetScanScene> result=new Result<>();
		AssetScanScene assetScanScene=assetScanSceneService.getById(id);
		// join 关联的对象
		assetScanSceneService.dao().fill(assetScanScene)
			.with(AssetScanSceneMeta.METHOD_DICT)
			.execute();
		result.success(true).data(assetScanScene);
		return result;
	}


	/**
	 * 批量获取扫码配置 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取扫码配置")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetScanSceneVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AssetScanSceneServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetScanSceneServiceProxy.GET_BY_IDS)
	public Result<List<AssetScanScene>> getByIds(List<String> ids) {
		
		Result<List<AssetScanScene>> result=new Result<>();
		List<AssetScanScene> list=assetScanSceneService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询扫码配置
	*/
	@ApiOperation(value = "查询扫码配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetScanSceneVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "817779842689794048"),
		@ApiImplicitParam(name = AssetScanSceneVOMeta.CODE , value = "场景编码" , required = false , dataTypeClass=String.class , example = "mobile_asset_scan"),
		@ApiImplicitParam(name = AssetScanSceneVOMeta.NAME , value = "场景名称" , required = false , dataTypeClass=String.class , example = "移动端资产扫码"),
		@ApiImplicitParam(name = AssetScanSceneVOMeta.METHOD , value = "方式" , required = false , dataTypeClass=String.class , example = "asset_url"),
		@ApiImplicitParam(name = AssetScanSceneVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetScanSceneVOMeta.PAGE_INDEX , AssetScanSceneVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetScanSceneServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetScanSceneServiceProxy.QUERY_LIST)
	public Result<List<AssetScanScene>> queryList(AssetScanSceneVO sample) {
		
		Result<List<AssetScanScene>> result=new Result<>();
		List<AssetScanScene> list=assetScanSceneService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询扫码配置
	*/
	@ApiOperation(value = "分页查询扫码配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetScanSceneVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "817779842689794048"),
		@ApiImplicitParam(name = AssetScanSceneVOMeta.CODE , value = "场景编码" , required = false , dataTypeClass=String.class , example = "mobile_asset_scan"),
		@ApiImplicitParam(name = AssetScanSceneVOMeta.NAME , value = "场景名称" , required = false , dataTypeClass=String.class , example = "移动端资产扫码"),
		@ApiImplicitParam(name = AssetScanSceneVOMeta.METHOD , value = "方式" , required = false , dataTypeClass=String.class , example = "asset_url"),
		@ApiImplicitParam(name = AssetScanSceneVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetScanSceneServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetScanSceneServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetScanScene>> queryPagedList(AssetScanSceneVO sample) {
		
		Result<PagedList<AssetScanScene>> result=new Result<>();
		PagedList<AssetScanScene> list=assetScanSceneService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		assetScanSceneService.dao().fill(list)
			.with(AssetScanSceneMeta.METHOD_DICT)
			.execute();
		result.success(true).data(list);
		return result;
	}





}