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


import com.dt.platform.proxy.vehicle.LeInsuranceRecordServiceProxy;
import com.dt.platform.domain.vehicle.meta.LeInsuranceRecordVOMeta;
import com.dt.platform.domain.vehicle.LeInsuranceRecord;
import com.dt.platform.domain.vehicle.LeInsuranceRecordVO;
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
import com.dt.platform.domain.vehicle.meta.LeInsuranceRecordMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.vehicle.service.ILeInsuranceRecordService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 车辆保险记录接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-09 12:49:00
*/

@InDoc
@Api(tags = "车辆保险记录")
@RestController("OaVehicleInsuranceRecordController")
public class LeInsuranceRecordController extends SuperController {

	@Autowired
	private ILeInsuranceRecordService leInsuranceRecordService;

	/**
	 * 添加车辆保险记录
	*/
	@ApiOperation(value = "添加车辆保险记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.COMPANY_ID , value = "保险公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.COMPANY_NAME , value = "保险公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.INSURANCE_TYPE , value = "保险类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.HANDLER_NAME , value = "处理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.HANDLER_CONTACT , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = LeInsuranceRecordServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LeInsuranceRecordServiceProxy.INSERT)
	public Result insert(LeInsuranceRecordVO leInsuranceRecordVO) {
		
		Result result=leInsuranceRecordService.insert(leInsuranceRecordVO,false);
		return result;
	}



	/**
	 * 删除车辆保险记录
	*/
	@ApiOperation(value = "删除车辆保险记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = LeInsuranceRecordServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LeInsuranceRecordServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  leInsuranceRecordService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=leInsuranceRecordService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除车辆保险记录 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除车辆保险记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = LeInsuranceRecordServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LeInsuranceRecordServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = leInsuranceRecordService.hasRefers(ids);
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
			Result result=leInsuranceRecordService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=leInsuranceRecordService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新车辆保险记录
	*/
	@ApiOperation(value = "更新车辆保险记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.COMPANY_ID , value = "保险公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.COMPANY_NAME , value = "保险公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.INSURANCE_TYPE , value = "保险类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.HANDLER_NAME , value = "处理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.HANDLER_CONTACT , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { LeInsuranceRecordVOMeta.PAGE_INDEX , LeInsuranceRecordVOMeta.PAGE_SIZE , LeInsuranceRecordVOMeta.SEARCH_FIELD , LeInsuranceRecordVOMeta.FUZZY_FIELD , LeInsuranceRecordVOMeta.SEARCH_VALUE , LeInsuranceRecordVOMeta.DIRTY_FIELDS , LeInsuranceRecordVOMeta.SORT_FIELD , LeInsuranceRecordVOMeta.SORT_TYPE , LeInsuranceRecordVOMeta.DATA_ORIGIN , LeInsuranceRecordVOMeta.QUERY_LOGIC , LeInsuranceRecordVOMeta.REQUEST_ACTION , LeInsuranceRecordVOMeta.IDS } )
	@SentinelResource(value = LeInsuranceRecordServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LeInsuranceRecordServiceProxy.UPDATE)
	public Result update(LeInsuranceRecordVO leInsuranceRecordVO) {
		
		Result result=leInsuranceRecordService.update(leInsuranceRecordVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存车辆保险记录
	*/
	@ApiOperation(value = "保存车辆保险记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.COMPANY_ID , value = "保险公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.COMPANY_NAME , value = "保险公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.INSURANCE_TYPE , value = "保险类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.HANDLER_NAME , value = "处理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.HANDLER_CONTACT , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { LeInsuranceRecordVOMeta.PAGE_INDEX , LeInsuranceRecordVOMeta.PAGE_SIZE , LeInsuranceRecordVOMeta.SEARCH_FIELD , LeInsuranceRecordVOMeta.FUZZY_FIELD , LeInsuranceRecordVOMeta.SEARCH_VALUE , LeInsuranceRecordVOMeta.DIRTY_FIELDS , LeInsuranceRecordVOMeta.SORT_FIELD , LeInsuranceRecordVOMeta.SORT_TYPE , LeInsuranceRecordVOMeta.DATA_ORIGIN , LeInsuranceRecordVOMeta.QUERY_LOGIC , LeInsuranceRecordVOMeta.REQUEST_ACTION , LeInsuranceRecordVOMeta.IDS } )
	@SentinelResource(value = LeInsuranceRecordServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LeInsuranceRecordServiceProxy.SAVE)
	public Result save(LeInsuranceRecordVO leInsuranceRecordVO) {
		
		Result result=leInsuranceRecordService.save(leInsuranceRecordVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取车辆保险记录
	*/
	@ApiOperation(value = "获取车辆保险记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = LeInsuranceRecordServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LeInsuranceRecordServiceProxy.GET_BY_ID)
	public Result<LeInsuranceRecord> getById(String id) {
		
		Result<LeInsuranceRecord> result=new Result<>();
		LeInsuranceRecord leInsuranceRecord=leInsuranceRecordService.getById(id);
		result.success(true).data(leInsuranceRecord);
		return result;
	}


	/**
	 * 批量获取车辆保险记录 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取车辆保险记录")
		@ApiImplicitParams({
				@ApiImplicitParam(name = LeInsuranceRecordVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = LeInsuranceRecordServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LeInsuranceRecordServiceProxy.GET_BY_IDS)
	public Result<List<LeInsuranceRecord>> getByIds(List<String> ids) {
		
		Result<List<LeInsuranceRecord>> result=new Result<>();
		List<LeInsuranceRecord> list=leInsuranceRecordService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询车辆保险记录
	*/
	@ApiOperation(value = "查询车辆保险记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.COMPANY_ID , value = "保险公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.COMPANY_NAME , value = "保险公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.INSURANCE_TYPE , value = "保险类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.HANDLER_NAME , value = "处理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.HANDLER_CONTACT , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { LeInsuranceRecordVOMeta.PAGE_INDEX , LeInsuranceRecordVOMeta.PAGE_SIZE } )
	@SentinelResource(value = LeInsuranceRecordServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LeInsuranceRecordServiceProxy.QUERY_LIST)
	public Result<List<LeInsuranceRecord>> queryList(LeInsuranceRecordVO sample) {
		
		Result<List<LeInsuranceRecord>> result=new Result<>();
		List<LeInsuranceRecord> list=leInsuranceRecordService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询车辆保险记录
	*/
	@ApiOperation(value = "分页查询车辆保险记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.COMPANY_ID , value = "保险公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.COMPANY_NAME , value = "保险公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.INSURANCE_TYPE , value = "保险类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.HANDLER_NAME , value = "处理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.HANDLER_CONTACT , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeInsuranceRecordVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = LeInsuranceRecordServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LeInsuranceRecordServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<LeInsuranceRecord>> queryPagedList(LeInsuranceRecordVO sample) {
		
		Result<PagedList<LeInsuranceRecord>> result=new Result<>();
		PagedList<LeInsuranceRecord> list=leInsuranceRecordService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}