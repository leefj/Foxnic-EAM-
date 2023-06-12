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


import com.dt.platform.proxy.oa.VehicleMaintenanceServiceProxy;
import com.dt.platform.domain.oa.meta.VehicleMaintenanceVOMeta;
import com.dt.platform.domain.oa.VehicleMaintenance;
import com.dt.platform.domain.oa.VehicleMaintenanceVO;
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
import com.dt.platform.domain.oa.meta.VehicleMaintenanceMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.oa.VehicleInfo;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.IVehicleMaintenanceService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 车辆维修保养接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 16:04:49
*/

@InDoc
@Api(tags = "车辆维修保养")
@RestController("OaVehicleMaintenanceController")
public class VehicleMaintenanceController extends SuperController {

	@Autowired
	private IVehicleMaintenanceService vehicleMaintenanceService;

	/**
	 * 添加车辆维修保养
	*/
	@ApiOperation(value = "添加车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.TYPE , value = "报修类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.ACTUAL_FINISH_DATE , value = "实际完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.REPORT_USER_NAME , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.VEHICLE_ID , value = "车辆" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = VehicleMaintenanceServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleMaintenanceServiceProxy.INSERT)
	public Result insert(VehicleMaintenanceVO vehicleMaintenanceVO) {
		
		Result result=vehicleMaintenanceService.insert(vehicleMaintenanceVO,false);
		return result;
	}



	/**
	 * 删除车辆维修保养
	*/
	@ApiOperation(value = "删除车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = VehicleMaintenanceServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleMaintenanceServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  vehicleMaintenanceService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=vehicleMaintenanceService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除车辆维修保养 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = VehicleMaintenanceServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleMaintenanceServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = vehicleMaintenanceService.hasRefers(ids);
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
			Result result=vehicleMaintenanceService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=vehicleMaintenanceService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新车辆维修保养
	*/
	@ApiOperation(value = "更新车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.TYPE , value = "报修类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.ACTUAL_FINISH_DATE , value = "实际完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.REPORT_USER_NAME , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.VEHICLE_ID , value = "车辆" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { VehicleMaintenanceVOMeta.PAGE_INDEX , VehicleMaintenanceVOMeta.PAGE_SIZE , VehicleMaintenanceVOMeta.SEARCH_FIELD , VehicleMaintenanceVOMeta.FUZZY_FIELD , VehicleMaintenanceVOMeta.SEARCH_VALUE , VehicleMaintenanceVOMeta.DIRTY_FIELDS , VehicleMaintenanceVOMeta.SORT_FIELD , VehicleMaintenanceVOMeta.SORT_TYPE , VehicleMaintenanceVOMeta.DATA_ORIGIN , VehicleMaintenanceVOMeta.QUERY_LOGIC , VehicleMaintenanceVOMeta.REQUEST_ACTION , VehicleMaintenanceVOMeta.IDS } )
	@SentinelResource(value = VehicleMaintenanceServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleMaintenanceServiceProxy.UPDATE)
	public Result update(VehicleMaintenanceVO vehicleMaintenanceVO) {
		
		Result result=vehicleMaintenanceService.update(vehicleMaintenanceVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存车辆维修保养
	*/
	@ApiOperation(value = "保存车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.TYPE , value = "报修类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.ACTUAL_FINISH_DATE , value = "实际完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.REPORT_USER_NAME , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.VEHICLE_ID , value = "车辆" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { VehicleMaintenanceVOMeta.PAGE_INDEX , VehicleMaintenanceVOMeta.PAGE_SIZE , VehicleMaintenanceVOMeta.SEARCH_FIELD , VehicleMaintenanceVOMeta.FUZZY_FIELD , VehicleMaintenanceVOMeta.SEARCH_VALUE , VehicleMaintenanceVOMeta.DIRTY_FIELDS , VehicleMaintenanceVOMeta.SORT_FIELD , VehicleMaintenanceVOMeta.SORT_TYPE , VehicleMaintenanceVOMeta.DATA_ORIGIN , VehicleMaintenanceVOMeta.QUERY_LOGIC , VehicleMaintenanceVOMeta.REQUEST_ACTION , VehicleMaintenanceVOMeta.IDS } )
	@SentinelResource(value = VehicleMaintenanceServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleMaintenanceServiceProxy.SAVE)
	public Result save(VehicleMaintenanceVO vehicleMaintenanceVO) {
		
		Result result=vehicleMaintenanceService.save(vehicleMaintenanceVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取车辆维修保养
	*/
	@ApiOperation(value = "获取车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = VehicleMaintenanceServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleMaintenanceServiceProxy.GET_BY_ID)
	public Result<VehicleMaintenance> getById(String id) {
		
		Result<VehicleMaintenance> result=new Result<>();
		VehicleMaintenance vehicleMaintenance=vehicleMaintenanceService.getById(id);
		// join 关联的对象
		vehicleMaintenanceService.dao().fill(vehicleMaintenance)
			.with(VehicleMaintenanceMeta.MAINTENANCE_DICT)
			.with(VehicleMaintenanceMeta.VEHICLE_INFO)
			.execute();
		result.success(true).data(vehicleMaintenance);
		return result;
	}


	/**
	 * 批量获取车辆维修保养 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取车辆维修保养")
		@ApiImplicitParams({
				@ApiImplicitParam(name = VehicleMaintenanceVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = VehicleMaintenanceServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleMaintenanceServiceProxy.GET_BY_IDS)
	public Result<List<VehicleMaintenance>> getByIds(List<String> ids) {
		
		Result<List<VehicleMaintenance>> result=new Result<>();
		List<VehicleMaintenance> list=vehicleMaintenanceService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询车辆维修保养
	*/
	@ApiOperation(value = "查询车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.TYPE , value = "报修类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.ACTUAL_FINISH_DATE , value = "实际完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.REPORT_USER_NAME , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.VEHICLE_ID , value = "车辆" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { VehicleMaintenanceVOMeta.PAGE_INDEX , VehicleMaintenanceVOMeta.PAGE_SIZE } )
	@SentinelResource(value = VehicleMaintenanceServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleMaintenanceServiceProxy.QUERY_LIST)
	public Result<List<VehicleMaintenance>> queryList(VehicleMaintenanceVO sample) {
		
		Result<List<VehicleMaintenance>> result=new Result<>();
		List<VehicleMaintenance> list=vehicleMaintenanceService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询车辆维修保养
	*/
	@ApiOperation(value = "分页查询车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.TYPE , value = "报修类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.ACTUAL_FINISH_DATE , value = "实际完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.REPORT_USER_NAME , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.VEHICLE_ID , value = "车辆" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleMaintenanceVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = VehicleMaintenanceServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleMaintenanceServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<VehicleMaintenance>> queryPagedList(VehicleMaintenanceVO sample) {
		
		Result<PagedList<VehicleMaintenance>> result=new Result<>();
		PagedList<VehicleMaintenance> list=vehicleMaintenanceService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		vehicleMaintenanceService.dao().fill(list)
			.with(VehicleMaintenanceMeta.MAINTENANCE_DICT)
			.with(VehicleMaintenanceMeta.VEHICLE_INFO)
			.execute();
		result.success(true).data(list);
		return result;
	}





}