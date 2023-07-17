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


import com.dt.platform.proxy.eam.DeviceSpStatusServiceProxy;
import com.dt.platform.domain.eam.meta.DeviceSpStatusVOMeta;
import com.dt.platform.domain.eam.DeviceSpStatus;
import com.dt.platform.domain.eam.DeviceSpStatusVO;
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
import com.dt.platform.domain.eam.meta.DeviceSpStatusMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IDeviceSpStatusService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 修改状态接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-15 11:18:49
*/

@InDoc
@Api(tags = "修改状态")
@RestController("EamDeviceSpStatusController")
public class DeviceSpStatusController extends SuperController {

	@Autowired
	private IDeviceSpStatusService deviceSpStatusService;

	/**
	 * 添加修改状态
	*/
	@ApiOperation(value = "添加修改状态")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpStatusVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpStatusVOMeta.SP_ID , value = "备件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpStatusVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpStatusVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DeviceSpStatusServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceSpStatusServiceProxy.INSERT)
	public Result insert(DeviceSpStatusVO deviceSpStatusVO) {
		
		Result result=deviceSpStatusService.insert(deviceSpStatusVO,false);
		return result;
	}



	/**
	 * 删除修改状态
	*/
	@ApiOperation(value = "删除修改状态")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpStatusVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DeviceSpStatusServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceSpStatusServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  deviceSpStatusService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=deviceSpStatusService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除修改状态 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除修改状态")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpStatusVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = DeviceSpStatusServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceSpStatusServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = deviceSpStatusService.hasRefers(ids);
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
			Result result=deviceSpStatusService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=deviceSpStatusService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新修改状态
	*/
	@ApiOperation(value = "更新修改状态")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpStatusVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpStatusVOMeta.SP_ID , value = "备件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpStatusVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpStatusVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DeviceSpStatusVOMeta.PAGE_INDEX , DeviceSpStatusVOMeta.PAGE_SIZE , DeviceSpStatusVOMeta.SEARCH_FIELD , DeviceSpStatusVOMeta.FUZZY_FIELD , DeviceSpStatusVOMeta.SEARCH_VALUE , DeviceSpStatusVOMeta.DIRTY_FIELDS , DeviceSpStatusVOMeta.SORT_FIELD , DeviceSpStatusVOMeta.SORT_TYPE , DeviceSpStatusVOMeta.DATA_ORIGIN , DeviceSpStatusVOMeta.QUERY_LOGIC , DeviceSpStatusVOMeta.REQUEST_ACTION , DeviceSpStatusVOMeta.IDS } )
	@SentinelResource(value = DeviceSpStatusServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceSpStatusServiceProxy.UPDATE)
	public Result update(DeviceSpStatusVO deviceSpStatusVO) {
		
		Result result=deviceSpStatusService.update(deviceSpStatusVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存修改状态
	*/
	@ApiOperation(value = "保存修改状态")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpStatusVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpStatusVOMeta.SP_ID , value = "备件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpStatusVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpStatusVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DeviceSpStatusVOMeta.PAGE_INDEX , DeviceSpStatusVOMeta.PAGE_SIZE , DeviceSpStatusVOMeta.SEARCH_FIELD , DeviceSpStatusVOMeta.FUZZY_FIELD , DeviceSpStatusVOMeta.SEARCH_VALUE , DeviceSpStatusVOMeta.DIRTY_FIELDS , DeviceSpStatusVOMeta.SORT_FIELD , DeviceSpStatusVOMeta.SORT_TYPE , DeviceSpStatusVOMeta.DATA_ORIGIN , DeviceSpStatusVOMeta.QUERY_LOGIC , DeviceSpStatusVOMeta.REQUEST_ACTION , DeviceSpStatusVOMeta.IDS } )
	@SentinelResource(value = DeviceSpStatusServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceSpStatusServiceProxy.SAVE)
	public Result save(DeviceSpStatusVO deviceSpStatusVO) {
		
		Result result=deviceSpStatusService.save(deviceSpStatusVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取修改状态
	*/
	@ApiOperation(value = "获取修改状态")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpStatusVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DeviceSpStatusServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceSpStatusServiceProxy.GET_BY_ID)
	public Result<DeviceSpStatus> getById(String id) {
		
		Result<DeviceSpStatus> result=new Result<>();
		DeviceSpStatus deviceSpStatus=deviceSpStatusService.getById(id);
		result.success(true).data(deviceSpStatus);
		return result;
	}


	/**
	 * 批量获取修改状态 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取修改状态")
		@ApiImplicitParams({
				@ApiImplicitParam(name = DeviceSpStatusVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = DeviceSpStatusServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceSpStatusServiceProxy.GET_BY_IDS)
	public Result<List<DeviceSpStatus>> getByIds(List<String> ids) {
		
		Result<List<DeviceSpStatus>> result=new Result<>();
		List<DeviceSpStatus> list=deviceSpStatusService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询修改状态
	*/
	@ApiOperation(value = "查询修改状态")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpStatusVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpStatusVOMeta.SP_ID , value = "备件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpStatusVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpStatusVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DeviceSpStatusVOMeta.PAGE_INDEX , DeviceSpStatusVOMeta.PAGE_SIZE } )
	@SentinelResource(value = DeviceSpStatusServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceSpStatusServiceProxy.QUERY_LIST)
	public Result<List<DeviceSpStatus>> queryList(DeviceSpStatusVO sample) {
		
		Result<List<DeviceSpStatus>> result=new Result<>();
		List<DeviceSpStatus> list=deviceSpStatusService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询修改状态
	*/
	@ApiOperation(value = "分页查询修改状态")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeviceSpStatusVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpStatusVOMeta.SP_ID , value = "备件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpStatusVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeviceSpStatusVOMeta.CONTENT , value = "原因" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DeviceSpStatusServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeviceSpStatusServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<DeviceSpStatus>> queryPagedList(DeviceSpStatusVO sample) {
		
		Result<PagedList<DeviceSpStatus>> result=new Result<>();
		PagedList<DeviceSpStatus> list=deviceSpStatusService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}