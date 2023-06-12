package com.dt.platform.oa.controller;

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


import com.dt.platform.proxy.oa.VehicleMSelectItemServiceProxy;
import com.dt.platform.domain.oa.meta.VehicleMSelectItemVOMeta;
import com.dt.platform.domain.oa.VehicleMSelectItem;
import com.dt.platform.domain.oa.VehicleMSelectItemVO;
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
import com.dt.platform.domain.oa.meta.VehicleMSelectItemMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.IVehicleMSelectItemService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 车辆数据接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 13:50:53
*/

@InDoc
@Api(tags = "车辆数据")
@RestController("OaVehicleMSelectItemController")
public class VehicleMSelectItemController extends SuperController {

	@Autowired
	private IVehicleMSelectItemService vehicleMSelectItemService;

	/**
	 * 添加车辆数据
	*/
	@ApiOperation(value = "添加车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleMSelectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMSelectItemVOMeta.HANDLE_ID , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMSelectItemVOMeta.ASSET_ID , value = "车辆" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = VehicleMSelectItemServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleMSelectItemServiceProxy.INSERT)
	public Result insert(VehicleMSelectItemVO vehicleMSelectItemVO) {
		
		Result result=vehicleMSelectItemService.insert(vehicleMSelectItemVO,false);
		return result;
	}



	/**
	 * 删除车辆数据
	*/
	@ApiOperation(value = "删除车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleMSelectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = VehicleMSelectItemServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleMSelectItemServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  vehicleMSelectItemService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=vehicleMSelectItemService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除车辆数据 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleMSelectItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = VehicleMSelectItemServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleMSelectItemServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = vehicleMSelectItemService.hasRefers(ids);
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
			Result result=vehicleMSelectItemService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=vehicleMSelectItemService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新车辆数据
	*/
	@ApiOperation(value = "更新车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleMSelectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMSelectItemVOMeta.HANDLE_ID , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMSelectItemVOMeta.ASSET_ID , value = "车辆" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { VehicleMSelectItemVOMeta.PAGE_INDEX , VehicleMSelectItemVOMeta.PAGE_SIZE , VehicleMSelectItemVOMeta.SEARCH_FIELD , VehicleMSelectItemVOMeta.FUZZY_FIELD , VehicleMSelectItemVOMeta.SEARCH_VALUE , VehicleMSelectItemVOMeta.DIRTY_FIELDS , VehicleMSelectItemVOMeta.SORT_FIELD , VehicleMSelectItemVOMeta.SORT_TYPE , VehicleMSelectItemVOMeta.DATA_ORIGIN , VehicleMSelectItemVOMeta.QUERY_LOGIC , VehicleMSelectItemVOMeta.REQUEST_ACTION , VehicleMSelectItemVOMeta.IDS } )
	@SentinelResource(value = VehicleMSelectItemServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleMSelectItemServiceProxy.UPDATE)
	public Result update(VehicleMSelectItemVO vehicleMSelectItemVO) {
		
		Result result=vehicleMSelectItemService.update(vehicleMSelectItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存车辆数据
	*/
	@ApiOperation(value = "保存车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleMSelectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMSelectItemVOMeta.HANDLE_ID , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMSelectItemVOMeta.ASSET_ID , value = "车辆" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { VehicleMSelectItemVOMeta.PAGE_INDEX , VehicleMSelectItemVOMeta.PAGE_SIZE , VehicleMSelectItemVOMeta.SEARCH_FIELD , VehicleMSelectItemVOMeta.FUZZY_FIELD , VehicleMSelectItemVOMeta.SEARCH_VALUE , VehicleMSelectItemVOMeta.DIRTY_FIELDS , VehicleMSelectItemVOMeta.SORT_FIELD , VehicleMSelectItemVOMeta.SORT_TYPE , VehicleMSelectItemVOMeta.DATA_ORIGIN , VehicleMSelectItemVOMeta.QUERY_LOGIC , VehicleMSelectItemVOMeta.REQUEST_ACTION , VehicleMSelectItemVOMeta.IDS } )
	@SentinelResource(value = VehicleMSelectItemServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleMSelectItemServiceProxy.SAVE)
	public Result save(VehicleMSelectItemVO vehicleMSelectItemVO) {
		
		Result result=vehicleMSelectItemService.save(vehicleMSelectItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取车辆数据
	*/
	@ApiOperation(value = "获取车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleMSelectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = VehicleMSelectItemServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleMSelectItemServiceProxy.GET_BY_ID)
	public Result<VehicleMSelectItem> getById(String id) {
		
		Result<VehicleMSelectItem> result=new Result<>();
		VehicleMSelectItem vehicleMSelectItem=vehicleMSelectItemService.getById(id);
		result.success(true).data(vehicleMSelectItem);
		return result;
	}


	/**
	 * 批量获取车辆数据 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取车辆数据")
		@ApiImplicitParams({
				@ApiImplicitParam(name = VehicleMSelectItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = VehicleMSelectItemServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleMSelectItemServiceProxy.GET_BY_IDS)
	public Result<List<VehicleMSelectItem>> getByIds(List<String> ids) {
		
		Result<List<VehicleMSelectItem>> result=new Result<>();
		List<VehicleMSelectItem> list=vehicleMSelectItemService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询车辆数据
	*/
	@ApiOperation(value = "查询车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleMSelectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMSelectItemVOMeta.HANDLE_ID , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMSelectItemVOMeta.ASSET_ID , value = "车辆" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { VehicleMSelectItemVOMeta.PAGE_INDEX , VehicleMSelectItemVOMeta.PAGE_SIZE } )
	@SentinelResource(value = VehicleMSelectItemServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleMSelectItemServiceProxy.QUERY_LIST)
	public Result<List<VehicleMSelectItem>> queryList(VehicleMSelectItemVO sample) {
		
		Result<List<VehicleMSelectItem>> result=new Result<>();
		List<VehicleMSelectItem> list=vehicleMSelectItemService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询车辆数据
	*/
	@ApiOperation(value = "分页查询车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleMSelectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMSelectItemVOMeta.HANDLE_ID , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMSelectItemVOMeta.ASSET_ID , value = "车辆" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = VehicleMSelectItemServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleMSelectItemServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<VehicleMSelectItem>> queryPagedList(VehicleMSelectItemVO sample) {
		
		Result<PagedList<VehicleMSelectItem>> result=new Result<>();
		PagedList<VehicleMSelectItem> list=vehicleMSelectItemService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}