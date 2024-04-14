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


import com.dt.platform.proxy.eam.EquipmentLogServiceProxy;
import com.dt.platform.domain.eam.meta.EquipmentLogVOMeta;
import com.dt.platform.domain.eam.EquipmentLog;
import com.dt.platform.domain.eam.EquipmentLogVO;
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
import com.dt.platform.domain.eam.meta.EquipmentLogMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IEquipmentLogService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 设备日志接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-08 07:39:38
*/

@InDoc
@Api(tags = "设备日志")
@RestController("IotEquipmentLogController")
public class EquipmentLogController extends SuperController {

	@Autowired
	private IEquipmentLogService equipmentLogService;

	/**
	 * 添加设备日志
	*/
	@ApiOperation(value = "添加设备日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EquipmentLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.IDENTIFIER , value = "标识符" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.RCD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = EquipmentLogServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EquipmentLogServiceProxy.INSERT)
	public Result insert(EquipmentLogVO equipmentLogVO) {
		
		Result result=equipmentLogService.insert(equipmentLogVO,false);
		return result;
	}



	/**
	 * 删除设备日志
	*/
	@ApiOperation(value = "删除设备日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EquipmentLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = EquipmentLogServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EquipmentLogServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  equipmentLogService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=equipmentLogService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除设备日志 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除设备日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EquipmentLogVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = EquipmentLogServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EquipmentLogServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = equipmentLogService.hasRefers(ids);
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
			Result result=equipmentLogService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=equipmentLogService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新设备日志
	*/
	@ApiOperation(value = "更新设备日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EquipmentLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.IDENTIFIER , value = "标识符" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.RCD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { EquipmentLogVOMeta.PAGE_INDEX , EquipmentLogVOMeta.PAGE_SIZE , EquipmentLogVOMeta.SEARCH_FIELD , EquipmentLogVOMeta.FUZZY_FIELD , EquipmentLogVOMeta.SEARCH_VALUE , EquipmentLogVOMeta.DIRTY_FIELDS , EquipmentLogVOMeta.SORT_FIELD , EquipmentLogVOMeta.SORT_TYPE , EquipmentLogVOMeta.DATA_ORIGIN , EquipmentLogVOMeta.QUERY_LOGIC , EquipmentLogVOMeta.REQUEST_ACTION , EquipmentLogVOMeta.IDS } )
	@SentinelResource(value = EquipmentLogServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EquipmentLogServiceProxy.UPDATE)
	public Result update(EquipmentLogVO equipmentLogVO) {
		
		Result result=equipmentLogService.update(equipmentLogVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存设备日志
	*/
	@ApiOperation(value = "保存设备日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EquipmentLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.IDENTIFIER , value = "标识符" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.RCD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { EquipmentLogVOMeta.PAGE_INDEX , EquipmentLogVOMeta.PAGE_SIZE , EquipmentLogVOMeta.SEARCH_FIELD , EquipmentLogVOMeta.FUZZY_FIELD , EquipmentLogVOMeta.SEARCH_VALUE , EquipmentLogVOMeta.DIRTY_FIELDS , EquipmentLogVOMeta.SORT_FIELD , EquipmentLogVOMeta.SORT_TYPE , EquipmentLogVOMeta.DATA_ORIGIN , EquipmentLogVOMeta.QUERY_LOGIC , EquipmentLogVOMeta.REQUEST_ACTION , EquipmentLogVOMeta.IDS } )
	@SentinelResource(value = EquipmentLogServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EquipmentLogServiceProxy.SAVE)
	public Result save(EquipmentLogVO equipmentLogVO) {
		
		Result result=equipmentLogService.save(equipmentLogVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取设备日志
	*/
	@ApiOperation(value = "获取设备日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EquipmentLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = EquipmentLogServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EquipmentLogServiceProxy.GET_BY_ID)
	public Result<EquipmentLog> getById(String id) {
		
		Result<EquipmentLog> result=new Result<>();
		EquipmentLog equipmentLog=equipmentLogService.getById(id);
		result.success(true).data(equipmentLog);
		return result;
	}


	/**
	 * 批量获取设备日志 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取设备日志")
		@ApiImplicitParams({
				@ApiImplicitParam(name = EquipmentLogVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = EquipmentLogServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EquipmentLogServiceProxy.GET_BY_IDS)
	public Result<List<EquipmentLog>> getByIds(List<String> ids) {
		
		Result<List<EquipmentLog>> result=new Result<>();
		List<EquipmentLog> list=equipmentLogService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询设备日志
	*/
	@ApiOperation(value = "查询设备日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EquipmentLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.IDENTIFIER , value = "标识符" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.RCD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { EquipmentLogVOMeta.PAGE_INDEX , EquipmentLogVOMeta.PAGE_SIZE } )
	@SentinelResource(value = EquipmentLogServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EquipmentLogServiceProxy.QUERY_LIST)
	public Result<List<EquipmentLog>> queryList(EquipmentLogVO sample) {
		
		Result<List<EquipmentLog>> result=new Result<>();
		List<EquipmentLog> list=equipmentLogService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询设备日志
	*/
	@ApiOperation(value = "分页查询设备日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EquipmentLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.IDENTIFIER , value = "标识符" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.RCD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = EquipmentLogVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = EquipmentLogServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(EquipmentLogServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<EquipmentLog>> queryPagedList(EquipmentLogVO sample) {
		
		Result<PagedList<EquipmentLog>> result=new Result<>();
		PagedList<EquipmentLog> list=equipmentLogService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}