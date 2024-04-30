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


import com.dt.platform.proxy.eam.AssetHandleTypeServiceProxy;
import com.dt.platform.domain.eam.meta.AssetHandleTypeVOMeta;
import com.dt.platform.domain.eam.AssetHandleType;
import com.dt.platform.domain.eam.AssetHandleTypeVO;
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
import com.dt.platform.domain.eam.meta.AssetHandleTypeMeta;
import com.dt.platform.domain.eam.AssetStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetHandleTypeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 处置类型接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-30 12:38:09
*/

@InDoc
@Api(tags = "处置类型")
@RestController("EamAssetHandleTypeController")
public class AssetHandleTypeController extends SuperController {

	@Autowired
	private IAssetHandleTypeService assetHandleTypeService;

	/**
	 * 添加处置类型
	*/
	@ApiOperation(value = "添加处置类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "837667251493535744"),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "fq"),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.LABEL , value = "名称" , required = false , dataTypeClass=String.class , example = "废弃"),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "valid"),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.HANDLE_STATUS , value = "资产状态" , required = false , dataTypeClass=String.class , example = "handled"),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.CLEAN_STATUS , value = "是否清理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.ACTION_METHOD , value = "动作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetHandleTypeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetHandleTypeServiceProxy.INSERT)
	public Result insert(AssetHandleTypeVO assetHandleTypeVO) {
		
		Result result=assetHandleTypeService.insert(assetHandleTypeVO,false);
		return result;
	}



	/**
	 * 删除处置类型
	*/
	@ApiOperation(value = "删除处置类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "837667251493535744")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetHandleTypeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetHandleTypeServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  assetHandleTypeService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=assetHandleTypeService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除处置类型 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除处置类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AssetHandleTypeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetHandleTypeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = assetHandleTypeService.hasRefers(ids);
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
			Result result=assetHandleTypeService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=assetHandleTypeService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新处置类型
	*/
	@ApiOperation(value = "更新处置类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "837667251493535744"),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "fq"),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.LABEL , value = "名称" , required = false , dataTypeClass=String.class , example = "废弃"),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "valid"),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.HANDLE_STATUS , value = "资产状态" , required = false , dataTypeClass=String.class , example = "handled"),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.CLEAN_STATUS , value = "是否清理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.ACTION_METHOD , value = "动作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetHandleTypeVOMeta.PAGE_INDEX , AssetHandleTypeVOMeta.PAGE_SIZE , AssetHandleTypeVOMeta.SEARCH_FIELD , AssetHandleTypeVOMeta.FUZZY_FIELD , AssetHandleTypeVOMeta.SEARCH_VALUE , AssetHandleTypeVOMeta.DIRTY_FIELDS , AssetHandleTypeVOMeta.SORT_FIELD , AssetHandleTypeVOMeta.SORT_TYPE , AssetHandleTypeVOMeta.DATA_ORIGIN , AssetHandleTypeVOMeta.QUERY_LOGIC , AssetHandleTypeVOMeta.REQUEST_ACTION , AssetHandleTypeVOMeta.IDS } )
	@SentinelResource(value = AssetHandleTypeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetHandleTypeServiceProxy.UPDATE)
	public Result update(AssetHandleTypeVO assetHandleTypeVO) {
		
		Result result=assetHandleTypeService.update(assetHandleTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存处置类型
	*/
	@ApiOperation(value = "保存处置类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "837667251493535744"),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "fq"),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.LABEL , value = "名称" , required = false , dataTypeClass=String.class , example = "废弃"),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "valid"),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.HANDLE_STATUS , value = "资产状态" , required = false , dataTypeClass=String.class , example = "handled"),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.CLEAN_STATUS , value = "是否清理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.ACTION_METHOD , value = "动作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetHandleTypeVOMeta.PAGE_INDEX , AssetHandleTypeVOMeta.PAGE_SIZE , AssetHandleTypeVOMeta.SEARCH_FIELD , AssetHandleTypeVOMeta.FUZZY_FIELD , AssetHandleTypeVOMeta.SEARCH_VALUE , AssetHandleTypeVOMeta.DIRTY_FIELDS , AssetHandleTypeVOMeta.SORT_FIELD , AssetHandleTypeVOMeta.SORT_TYPE , AssetHandleTypeVOMeta.DATA_ORIGIN , AssetHandleTypeVOMeta.QUERY_LOGIC , AssetHandleTypeVOMeta.REQUEST_ACTION , AssetHandleTypeVOMeta.IDS } )
	@SentinelResource(value = AssetHandleTypeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetHandleTypeServiceProxy.SAVE)
	public Result save(AssetHandleTypeVO assetHandleTypeVO) {
		
		Result result=assetHandleTypeService.save(assetHandleTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取处置类型
	*/
	@ApiOperation(value = "获取处置类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetHandleTypeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetHandleTypeServiceProxy.GET_BY_ID)
	public Result<AssetHandleType> getById(String id) {
		
		Result<AssetHandleType> result=new Result<>();
		AssetHandleType assetHandleType=assetHandleTypeService.getById(id);
		// join 关联的对象
		assetHandleTypeService.dao().fill(assetHandleType)
			.with(AssetHandleTypeMeta.ASSET_STATUS_DATA)
			.execute();
		result.success(true).data(assetHandleType);
		return result;
	}


	/**
	 * 批量获取处置类型 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取处置类型")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetHandleTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AssetHandleTypeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetHandleTypeServiceProxy.GET_BY_IDS)
	public Result<List<AssetHandleType>> getByIds(List<String> ids) {
		
		Result<List<AssetHandleType>> result=new Result<>();
		List<AssetHandleType> list=assetHandleTypeService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询处置类型
	*/
	@ApiOperation(value = "查询处置类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "837667251493535744"),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "fq"),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.LABEL , value = "名称" , required = false , dataTypeClass=String.class , example = "废弃"),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "valid"),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.HANDLE_STATUS , value = "资产状态" , required = false , dataTypeClass=String.class , example = "handled"),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.CLEAN_STATUS , value = "是否清理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.ACTION_METHOD , value = "动作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetHandleTypeVOMeta.PAGE_INDEX , AssetHandleTypeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetHandleTypeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetHandleTypeServiceProxy.QUERY_LIST)
	public Result<List<AssetHandleType>> queryList(AssetHandleTypeVO sample) {
		
		Result<List<AssetHandleType>> result=new Result<>();
		List<AssetHandleType> list=assetHandleTypeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询处置类型
	*/
	@ApiOperation(value = "分页查询处置类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "837667251493535744"),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "fq"),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.LABEL , value = "名称" , required = false , dataTypeClass=String.class , example = "废弃"),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "valid"),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.HANDLE_STATUS , value = "资产状态" , required = false , dataTypeClass=String.class , example = "handled"),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.CLEAN_STATUS , value = "是否清理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.ACTION_METHOD , value = "动作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleTypeVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetHandleTypeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetHandleTypeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetHandleType>> queryPagedList(AssetHandleTypeVO sample) {
		
		Result<PagedList<AssetHandleType>> result=new Result<>();
		PagedList<AssetHandleType> list=assetHandleTypeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		assetHandleTypeService.dao().fill(list)
			.with(AssetHandleTypeMeta.ASSET_STATUS_DATA)
			.execute();
		result.success(true).data(list);
		return result;
	}





}