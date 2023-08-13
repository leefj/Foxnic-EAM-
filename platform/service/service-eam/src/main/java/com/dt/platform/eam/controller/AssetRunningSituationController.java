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


import com.dt.platform.proxy.eam.AssetRunningSituationServiceProxy;
import com.dt.platform.domain.eam.meta.AssetRunningSituationVOMeta;
import com.dt.platform.domain.eam.AssetRunningSituation;
import com.dt.platform.domain.eam.AssetRunningSituationVO;
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
import com.dt.platform.domain.eam.meta.AssetRunningSituationMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetRunningSituationService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 运行情况接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-11 19:57:54
*/

@InDoc
@Api(tags = "运行情况")
@RestController("EamAssetRunningSituationController")
public class AssetRunningSituationController extends SuperController {

	@Autowired
	private IAssetRunningSituationService assetRunningSituationService;

	/**
	 * 添加运行情况
	*/
	@ApiOperation(value = "添加运行情况")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetRunningSituationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRunningSituationVOMeta.ASSET_ID , value = "设备" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRunningSituationVOMeta.STATUS , value = "设备" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRunningSituationVOMeta.REC_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetRunningSituationVOMeta.SOURCE , value = "记录来源" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetRunningSituationServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetRunningSituationServiceProxy.INSERT)
	public Result insert(AssetRunningSituationVO assetRunningSituationVO) {
		
		Result result=assetRunningSituationService.insert(assetRunningSituationVO,false);
		return result;
	}



	/**
	 * 删除运行情况
	*/
	@ApiOperation(value = "删除运行情况")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetRunningSituationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetRunningSituationServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetRunningSituationServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  assetRunningSituationService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=assetRunningSituationService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除运行情况 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除运行情况")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetRunningSituationVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AssetRunningSituationServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetRunningSituationServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = assetRunningSituationService.hasRefers(ids);
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
			Result result=assetRunningSituationService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=assetRunningSituationService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新运行情况
	*/
	@ApiOperation(value = "更新运行情况")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetRunningSituationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRunningSituationVOMeta.ASSET_ID , value = "设备" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRunningSituationVOMeta.STATUS , value = "设备" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRunningSituationVOMeta.REC_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetRunningSituationVOMeta.SOURCE , value = "记录来源" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetRunningSituationVOMeta.PAGE_INDEX , AssetRunningSituationVOMeta.PAGE_SIZE , AssetRunningSituationVOMeta.SEARCH_FIELD , AssetRunningSituationVOMeta.FUZZY_FIELD , AssetRunningSituationVOMeta.SEARCH_VALUE , AssetRunningSituationVOMeta.DIRTY_FIELDS , AssetRunningSituationVOMeta.SORT_FIELD , AssetRunningSituationVOMeta.SORT_TYPE , AssetRunningSituationVOMeta.DATA_ORIGIN , AssetRunningSituationVOMeta.QUERY_LOGIC , AssetRunningSituationVOMeta.REQUEST_ACTION , AssetRunningSituationVOMeta.IDS } )
	@SentinelResource(value = AssetRunningSituationServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetRunningSituationServiceProxy.UPDATE)
	public Result update(AssetRunningSituationVO assetRunningSituationVO) {
		
		Result result=assetRunningSituationService.update(assetRunningSituationVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存运行情况
	*/
	@ApiOperation(value = "保存运行情况")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetRunningSituationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRunningSituationVOMeta.ASSET_ID , value = "设备" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRunningSituationVOMeta.STATUS , value = "设备" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRunningSituationVOMeta.REC_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetRunningSituationVOMeta.SOURCE , value = "记录来源" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetRunningSituationVOMeta.PAGE_INDEX , AssetRunningSituationVOMeta.PAGE_SIZE , AssetRunningSituationVOMeta.SEARCH_FIELD , AssetRunningSituationVOMeta.FUZZY_FIELD , AssetRunningSituationVOMeta.SEARCH_VALUE , AssetRunningSituationVOMeta.DIRTY_FIELDS , AssetRunningSituationVOMeta.SORT_FIELD , AssetRunningSituationVOMeta.SORT_TYPE , AssetRunningSituationVOMeta.DATA_ORIGIN , AssetRunningSituationVOMeta.QUERY_LOGIC , AssetRunningSituationVOMeta.REQUEST_ACTION , AssetRunningSituationVOMeta.IDS } )
	@SentinelResource(value = AssetRunningSituationServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetRunningSituationServiceProxy.SAVE)
	public Result save(AssetRunningSituationVO assetRunningSituationVO) {
		
		Result result=assetRunningSituationService.save(assetRunningSituationVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取运行情况
	*/
	@ApiOperation(value = "获取运行情况")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetRunningSituationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetRunningSituationServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetRunningSituationServiceProxy.GET_BY_ID)
	public Result<AssetRunningSituation> getById(String id) {
		
		Result<AssetRunningSituation> result=new Result<>();
		AssetRunningSituation assetRunningSituation=assetRunningSituationService.getById(id);
		result.success(true).data(assetRunningSituation);
		return result;
	}


	/**
	 * 批量获取运行情况 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取运行情况")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetRunningSituationVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AssetRunningSituationServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetRunningSituationServiceProxy.GET_BY_IDS)
	public Result<List<AssetRunningSituation>> getByIds(List<String> ids) {
		
		Result<List<AssetRunningSituation>> result=new Result<>();
		List<AssetRunningSituation> list=assetRunningSituationService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询运行情况
	*/
	@ApiOperation(value = "查询运行情况")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetRunningSituationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRunningSituationVOMeta.ASSET_ID , value = "设备" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRunningSituationVOMeta.STATUS , value = "设备" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRunningSituationVOMeta.REC_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetRunningSituationVOMeta.SOURCE , value = "记录来源" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetRunningSituationVOMeta.PAGE_INDEX , AssetRunningSituationVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetRunningSituationServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetRunningSituationServiceProxy.QUERY_LIST)
	public Result<List<AssetRunningSituation>> queryList(AssetRunningSituationVO sample) {
		
		Result<List<AssetRunningSituation>> result=new Result<>();
		List<AssetRunningSituation> list=assetRunningSituationService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询运行情况
	*/
	@ApiOperation(value = "分页查询运行情况")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetRunningSituationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRunningSituationVOMeta.ASSET_ID , value = "设备" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRunningSituationVOMeta.STATUS , value = "设备" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRunningSituationVOMeta.REC_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetRunningSituationVOMeta.SOURCE , value = "记录来源" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetRunningSituationServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetRunningSituationServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetRunningSituation>> queryPagedList(AssetRunningSituationVO sample) {
		
		Result<PagedList<AssetRunningSituation>> result=new Result<>();
		PagedList<AssetRunningSituation> list=assetRunningSituationService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}