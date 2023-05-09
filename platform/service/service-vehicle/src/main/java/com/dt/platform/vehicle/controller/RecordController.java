package com.dt.platform.vehicle.controller;

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


import com.dt.platform.proxy.vehicle.RecordServiceProxy;
import com.dt.platform.domain.vehicle.meta.RecordVOMeta;
import com.dt.platform.domain.vehicle.Record;
import com.dt.platform.domain.vehicle.RecordVO;
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
import com.dt.platform.domain.vehicle.meta.RecordMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.vehicle.service.IRecordService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 使用记录接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-09 12:47:55
*/

@InDoc
@Api(tags = "使用记录")
@RestController("OaRoomRecordController")
public class RecordController extends SuperController {

	@Autowired
	private IRecordService recordService;

	/**
	 * 添加使用记录
	*/
	@ApiOperation(value = "添加使用记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.BUSINESS_CODE , value = "单据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.BUSINESS_TYPE , value = "使用类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.ROOM_ID , value = "车辆" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.STIME , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RecordVOMeta.ETIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RecordVOMeta.INFO , value = "使用说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RecordServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecordServiceProxy.INSERT)
	public Result insert(RecordVO recordVO) {
		
		Result result=recordService.insert(recordVO,false);
		return result;
	}



	/**
	 * 删除使用记录
	*/
	@ApiOperation(value = "删除使用记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RecordServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecordServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  recordService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=recordService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除使用记录 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除使用记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecordVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = RecordServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecordServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = recordService.hasRefers(ids);
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
			Result result=recordService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=recordService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新使用记录
	*/
	@ApiOperation(value = "更新使用记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.BUSINESS_CODE , value = "单据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.BUSINESS_TYPE , value = "使用类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.ROOM_ID , value = "车辆" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.STIME , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RecordVOMeta.ETIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RecordVOMeta.INFO , value = "使用说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { RecordVOMeta.PAGE_INDEX , RecordVOMeta.PAGE_SIZE , RecordVOMeta.SEARCH_FIELD , RecordVOMeta.FUZZY_FIELD , RecordVOMeta.SEARCH_VALUE , RecordVOMeta.DIRTY_FIELDS , RecordVOMeta.SORT_FIELD , RecordVOMeta.SORT_TYPE , RecordVOMeta.DATA_ORIGIN , RecordVOMeta.QUERY_LOGIC , RecordVOMeta.REQUEST_ACTION , RecordVOMeta.IDS } )
	@SentinelResource(value = RecordServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecordServiceProxy.UPDATE)
	public Result update(RecordVO recordVO) {
		
		Result result=recordService.update(recordVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存使用记录
	*/
	@ApiOperation(value = "保存使用记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.BUSINESS_CODE , value = "单据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.BUSINESS_TYPE , value = "使用类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.ROOM_ID , value = "车辆" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.STIME , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RecordVOMeta.ETIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RecordVOMeta.INFO , value = "使用说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RecordVOMeta.PAGE_INDEX , RecordVOMeta.PAGE_SIZE , RecordVOMeta.SEARCH_FIELD , RecordVOMeta.FUZZY_FIELD , RecordVOMeta.SEARCH_VALUE , RecordVOMeta.DIRTY_FIELDS , RecordVOMeta.SORT_FIELD , RecordVOMeta.SORT_TYPE , RecordVOMeta.DATA_ORIGIN , RecordVOMeta.QUERY_LOGIC , RecordVOMeta.REQUEST_ACTION , RecordVOMeta.IDS } )
	@SentinelResource(value = RecordServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecordServiceProxy.SAVE)
	public Result save(RecordVO recordVO) {
		
		Result result=recordService.save(recordVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取使用记录
	*/
	@ApiOperation(value = "获取使用记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RecordServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecordServiceProxy.GET_BY_ID)
	public Result<Record> getById(String id) {
		
		Result<Record> result=new Result<>();
		Record record=recordService.getById(id);
		result.success(true).data(record);
		return result;
	}


	/**
	 * 批量获取使用记录 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取使用记录")
		@ApiImplicitParams({
				@ApiImplicitParam(name = RecordVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = RecordServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecordServiceProxy.GET_BY_IDS)
	public Result<List<Record>> getByIds(List<String> ids) {
		
		Result<List<Record>> result=new Result<>();
		List<Record> list=recordService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询使用记录
	*/
	@ApiOperation(value = "查询使用记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.BUSINESS_CODE , value = "单据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.BUSINESS_TYPE , value = "使用类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.ROOM_ID , value = "车辆" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.STIME , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RecordVOMeta.ETIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RecordVOMeta.INFO , value = "使用说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { RecordVOMeta.PAGE_INDEX , RecordVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RecordServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecordServiceProxy.QUERY_LIST)
	public Result<List<Record>> queryList(RecordVO sample) {
		
		Result<List<Record>> result=new Result<>();
		List<Record> list=recordService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询使用记录
	*/
	@ApiOperation(value = "分页查询使用记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.BUSINESS_CODE , value = "单据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.BUSINESS_TYPE , value = "使用类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.ROOM_ID , value = "车辆" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.STIME , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RecordVOMeta.ETIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RecordVOMeta.INFO , value = "使用说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecordVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RecordServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecordServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Record>> queryPagedList(RecordVO sample) {
		
		Result<PagedList<Record>> result=new Result<>();
		PagedList<Record> list=recordService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}