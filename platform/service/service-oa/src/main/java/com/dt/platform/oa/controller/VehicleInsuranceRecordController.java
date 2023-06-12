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


import com.dt.platform.proxy.oa.VehicleInsuranceRecordServiceProxy;
import com.dt.platform.domain.oa.meta.VehicleInsuranceRecordVOMeta;
import com.dt.platform.domain.oa.VehicleInsuranceRecord;
import com.dt.platform.domain.oa.VehicleInsuranceRecordVO;
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
import com.dt.platform.domain.oa.meta.VehicleInsuranceRecordMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.IVehicleInsuranceRecordService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 车辆保险记录接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 14:07:55
*/

@InDoc
@Api(tags = "车辆保险记录")
@RestController("OaVehicleInsuranceRecordController")
public class VehicleInsuranceRecordController extends SuperController {

	@Autowired
	private IVehicleInsuranceRecordService vehicleInsuranceRecordService;

	/**
	 * 添加车辆保险记录
	*/
	@ApiOperation(value = "添加车辆保险记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.COMPANY_ID , value = "保险公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.COMPANY_NAME , value = "保险公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.INSURANCE_TYPE , value = "保险类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.HANDLER_NAME , value = "处理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.HANDLER_CONTACT , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = VehicleInsuranceRecordServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleInsuranceRecordServiceProxy.INSERT)
	public Result insert(VehicleInsuranceRecordVO vehicleInsuranceRecordVO) {
		
		Result result=vehicleInsuranceRecordService.insert(vehicleInsuranceRecordVO,false);
		return result;
	}



	/**
	 * 删除车辆保险记录
	*/
	@ApiOperation(value = "删除车辆保险记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = VehicleInsuranceRecordServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleInsuranceRecordServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  vehicleInsuranceRecordService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=vehicleInsuranceRecordService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除车辆保险记录 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除车辆保险记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = VehicleInsuranceRecordServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleInsuranceRecordServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = vehicleInsuranceRecordService.hasRefers(ids);
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
			Result result=vehicleInsuranceRecordService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=vehicleInsuranceRecordService.deleteByIdsLogical(canDeleteIds);
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
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.COMPANY_ID , value = "保险公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.COMPANY_NAME , value = "保险公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.INSURANCE_TYPE , value = "保险类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.HANDLER_NAME , value = "处理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.HANDLER_CONTACT , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { VehicleInsuranceRecordVOMeta.PAGE_INDEX , VehicleInsuranceRecordVOMeta.PAGE_SIZE , VehicleInsuranceRecordVOMeta.SEARCH_FIELD , VehicleInsuranceRecordVOMeta.FUZZY_FIELD , VehicleInsuranceRecordVOMeta.SEARCH_VALUE , VehicleInsuranceRecordVOMeta.DIRTY_FIELDS , VehicleInsuranceRecordVOMeta.SORT_FIELD , VehicleInsuranceRecordVOMeta.SORT_TYPE , VehicleInsuranceRecordVOMeta.DATA_ORIGIN , VehicleInsuranceRecordVOMeta.QUERY_LOGIC , VehicleInsuranceRecordVOMeta.REQUEST_ACTION , VehicleInsuranceRecordVOMeta.IDS } )
	@SentinelResource(value = VehicleInsuranceRecordServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleInsuranceRecordServiceProxy.UPDATE)
	public Result update(VehicleInsuranceRecordVO vehicleInsuranceRecordVO) {
		
		Result result=vehicleInsuranceRecordService.update(vehicleInsuranceRecordVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存车辆保险记录
	*/
	@ApiOperation(value = "保存车辆保险记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.COMPANY_ID , value = "保险公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.COMPANY_NAME , value = "保险公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.INSURANCE_TYPE , value = "保险类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.HANDLER_NAME , value = "处理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.HANDLER_CONTACT , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { VehicleInsuranceRecordVOMeta.PAGE_INDEX , VehicleInsuranceRecordVOMeta.PAGE_SIZE , VehicleInsuranceRecordVOMeta.SEARCH_FIELD , VehicleInsuranceRecordVOMeta.FUZZY_FIELD , VehicleInsuranceRecordVOMeta.SEARCH_VALUE , VehicleInsuranceRecordVOMeta.DIRTY_FIELDS , VehicleInsuranceRecordVOMeta.SORT_FIELD , VehicleInsuranceRecordVOMeta.SORT_TYPE , VehicleInsuranceRecordVOMeta.DATA_ORIGIN , VehicleInsuranceRecordVOMeta.QUERY_LOGIC , VehicleInsuranceRecordVOMeta.REQUEST_ACTION , VehicleInsuranceRecordVOMeta.IDS } )
	@SentinelResource(value = VehicleInsuranceRecordServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleInsuranceRecordServiceProxy.SAVE)
	public Result save(VehicleInsuranceRecordVO vehicleInsuranceRecordVO) {
		
		Result result=vehicleInsuranceRecordService.save(vehicleInsuranceRecordVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取车辆保险记录
	*/
	@ApiOperation(value = "获取车辆保险记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = VehicleInsuranceRecordServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleInsuranceRecordServiceProxy.GET_BY_ID)
	public Result<VehicleInsuranceRecord> getById(String id) {
		
		Result<VehicleInsuranceRecord> result=new Result<>();
		VehicleInsuranceRecord vehicleInsuranceRecord=vehicleInsuranceRecordService.getById(id);
		result.success(true).data(vehicleInsuranceRecord);
		return result;
	}


	/**
	 * 批量获取车辆保险记录 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取车辆保险记录")
		@ApiImplicitParams({
				@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = VehicleInsuranceRecordServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleInsuranceRecordServiceProxy.GET_BY_IDS)
	public Result<List<VehicleInsuranceRecord>> getByIds(List<String> ids) {
		
		Result<List<VehicleInsuranceRecord>> result=new Result<>();
		List<VehicleInsuranceRecord> list=vehicleInsuranceRecordService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询车辆保险记录
	*/
	@ApiOperation(value = "查询车辆保险记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.COMPANY_ID , value = "保险公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.COMPANY_NAME , value = "保险公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.INSURANCE_TYPE , value = "保险类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.HANDLER_NAME , value = "处理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.HANDLER_CONTACT , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { VehicleInsuranceRecordVOMeta.PAGE_INDEX , VehicleInsuranceRecordVOMeta.PAGE_SIZE } )
	@SentinelResource(value = VehicleInsuranceRecordServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleInsuranceRecordServiceProxy.QUERY_LIST)
	public Result<List<VehicleInsuranceRecord>> queryList(VehicleInsuranceRecordVO sample) {
		
		Result<List<VehicleInsuranceRecord>> result=new Result<>();
		List<VehicleInsuranceRecord> list=vehicleInsuranceRecordService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询车辆保险记录
	*/
	@ApiOperation(value = "分页查询车辆保险记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.COMPANY_ID , value = "保险公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.COMPANY_NAME , value = "保险公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.INSURANCE_TYPE , value = "保险类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.HANDLER_NAME , value = "处理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.HANDLER_CONTACT , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleInsuranceRecordVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = VehicleInsuranceRecordServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleInsuranceRecordServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<VehicleInsuranceRecord>> queryPagedList(VehicleInsuranceRecordVO sample) {
		
		Result<PagedList<VehicleInsuranceRecord>> result=new Result<>();
		PagedList<VehicleInsuranceRecord> list=vehicleInsuranceRecordService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}