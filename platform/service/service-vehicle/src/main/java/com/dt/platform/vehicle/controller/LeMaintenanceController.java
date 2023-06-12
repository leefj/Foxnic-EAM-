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


import com.dt.platform.proxy.vehicle.LeMaintenanceServiceProxy;
import com.dt.platform.domain.vehicle.meta.LeMaintenanceVOMeta;
import com.dt.platform.domain.vehicle.LeMaintenance;
import com.dt.platform.domain.vehicle.LeMaintenanceVO;
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
import com.dt.platform.domain.vehicle.meta.LeMaintenanceMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.vehicle.Info;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.vehicle.meta.MaintenanceMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.vehicle.service.ILeMaintenanceService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 车辆维修保养接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-09 12:43:11
*/

@InDoc
@Api(tags = "车辆维修保养")
@RestController("OaVehicleMaintenanceController1212121")
public class LeMaintenanceController extends SuperController {

	@Autowired
	private ILeMaintenanceService leMaintenanceService;

	/**
	 * 添加车辆维修保养
	*/
	@ApiOperation(value = "添加车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LeMaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.TYPE , value = "报修类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.ACTUAL_FINISH_DATE , value = "实际完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.REPORT_USER_NAME , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = LeMaintenanceServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LeMaintenanceServiceProxy.INSERT)
	public Result insert(LeMaintenanceVO leMaintenanceVO) {
		
		Result result=leMaintenanceService.insert(leMaintenanceVO,false);
		return result;
	}



	/**
	 * 删除车辆维修保养
	*/
	@ApiOperation(value = "删除车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LeMaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = LeMaintenanceServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LeMaintenanceServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  leMaintenanceService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=leMaintenanceService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除车辆维修保养 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LeMaintenanceVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = LeMaintenanceServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LeMaintenanceServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = leMaintenanceService.hasRefers(ids);
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
			Result result=leMaintenanceService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=leMaintenanceService.deleteByIdsLogical(canDeleteIds);
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
		@ApiImplicitParam(name = LeMaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.TYPE , value = "报修类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.ACTUAL_FINISH_DATE , value = "实际完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.REPORT_USER_NAME , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { LeMaintenanceVOMeta.PAGE_INDEX , LeMaintenanceVOMeta.PAGE_SIZE , LeMaintenanceVOMeta.SEARCH_FIELD , LeMaintenanceVOMeta.FUZZY_FIELD , LeMaintenanceVOMeta.SEARCH_VALUE , LeMaintenanceVOMeta.DIRTY_FIELDS , LeMaintenanceVOMeta.SORT_FIELD , LeMaintenanceVOMeta.SORT_TYPE , LeMaintenanceVOMeta.DATA_ORIGIN , LeMaintenanceVOMeta.QUERY_LOGIC , LeMaintenanceVOMeta.REQUEST_ACTION , LeMaintenanceVOMeta.IDS } )
	@SentinelResource(value = LeMaintenanceServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LeMaintenanceServiceProxy.UPDATE)
	public Result update(LeMaintenanceVO leMaintenanceVO) {
		
		Result result=leMaintenanceService.update(leMaintenanceVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存车辆维修保养
	*/
	@ApiOperation(value = "保存车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LeMaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.TYPE , value = "报修类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.ACTUAL_FINISH_DATE , value = "实际完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.REPORT_USER_NAME , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { LeMaintenanceVOMeta.PAGE_INDEX , LeMaintenanceVOMeta.PAGE_SIZE , LeMaintenanceVOMeta.SEARCH_FIELD , LeMaintenanceVOMeta.FUZZY_FIELD , LeMaintenanceVOMeta.SEARCH_VALUE , LeMaintenanceVOMeta.DIRTY_FIELDS , LeMaintenanceVOMeta.SORT_FIELD , LeMaintenanceVOMeta.SORT_TYPE , LeMaintenanceVOMeta.DATA_ORIGIN , LeMaintenanceVOMeta.QUERY_LOGIC , LeMaintenanceVOMeta.REQUEST_ACTION , LeMaintenanceVOMeta.IDS } )
	@SentinelResource(value = LeMaintenanceServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LeMaintenanceServiceProxy.SAVE)
	public Result save(LeMaintenanceVO leMaintenanceVO) {
		
		Result result=leMaintenanceService.save(leMaintenanceVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取车辆维修保养
	*/
	@ApiOperation(value = "获取车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LeMaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = LeMaintenanceServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LeMaintenanceServiceProxy.GET_BY_ID)
	public Result<LeMaintenance> getById(String id) {
		
		Result<LeMaintenance> result=new Result<>();
		LeMaintenance leMaintenance=leMaintenanceService.getById(id);
		// join 关联的对象
		leMaintenanceService.dao().fill(leMaintenance)
			.with(MaintenanceMeta.MAINTENANCE_DICT)
			.execute();
		result.success(true).data(leMaintenance);
		return result;
	}


	/**
	 * 批量获取车辆维修保养 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取车辆维修保养")
		@ApiImplicitParams({
				@ApiImplicitParam(name = LeMaintenanceVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = LeMaintenanceServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LeMaintenanceServiceProxy.GET_BY_IDS)
	public Result<List<LeMaintenance>> getByIds(List<String> ids) {
		
		Result<List<LeMaintenance>> result=new Result<>();
		List<LeMaintenance> list=leMaintenanceService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询车辆维修保养
	*/
	@ApiOperation(value = "查询车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LeMaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.TYPE , value = "报修类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.ACTUAL_FINISH_DATE , value = "实际完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.REPORT_USER_NAME , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { LeMaintenanceVOMeta.PAGE_INDEX , LeMaintenanceVOMeta.PAGE_SIZE } )
	@SentinelResource(value = LeMaintenanceServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LeMaintenanceServiceProxy.QUERY_LIST)
	public Result<List<LeMaintenance>> queryList(LeMaintenanceVO sample) {
		
		Result<List<LeMaintenance>> result=new Result<>();
		List<LeMaintenance> list=leMaintenanceService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询车辆维修保养
	*/
	@ApiOperation(value = "分页查询车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LeMaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.TYPE , value = "报修类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.ACTUAL_FINISH_DATE , value = "实际完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.REPORT_USER_NAME , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = LeMaintenanceVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = LeMaintenanceServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LeMaintenanceServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<LeMaintenance>> queryPagedList(LeMaintenanceVO sample) {
		
		Result<PagedList<LeMaintenance>> result=new Result<>();
		PagedList<LeMaintenance> list=leMaintenanceService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		leMaintenanceService.dao().fill(list)
			.with(MaintenanceMeta.MAINTENANCE_DICT)
			.execute();
		result.success(true).data(list);
		return result;
	}





}