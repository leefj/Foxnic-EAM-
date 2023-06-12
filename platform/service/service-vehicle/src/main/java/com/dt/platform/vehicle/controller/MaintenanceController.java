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


import com.dt.platform.proxy.vehicle.MaintenanceServiceProxy;
import com.dt.platform.domain.vehicle.meta.MaintenanceVOMeta;
import com.dt.platform.domain.vehicle.Maintenance;
import com.dt.platform.domain.vehicle.MaintenanceVO;
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
import com.dt.platform.domain.vehicle.meta.MaintenanceMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.vehicle.Info;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.vehicle.service.IMaintenanceService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 车辆维修保养接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 11:31:37
*/

@InDoc
@Api(tags = "车辆维修保养")
@RestController("VehicleMaintenanceController")
public class MaintenanceController extends SuperController {

	@Autowired
	private IMaintenanceService maintenanceService;

	/**
	 * 添加车辆维修保养
	*/
	@ApiOperation(value = "添加车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.TYPE , value = "报修类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.ACTUAL_FINISH_DATE , value = "实际完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPORT_USER_NAME , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MaintenanceServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintenanceServiceProxy.INSERT)
	public Result insert(MaintenanceVO maintenanceVO) {
		
		Result result=maintenanceService.insert(maintenanceVO,false);
		return result;
	}



	/**
	 * 删除车辆维修保养
	*/
	@ApiOperation(value = "删除车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MaintenanceServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintenanceServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  maintenanceService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=maintenanceService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除车辆维修保养 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintenanceVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = MaintenanceServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintenanceServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = maintenanceService.hasRefers(ids);
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
			Result result=maintenanceService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=maintenanceService.deleteByIdsLogical(canDeleteIds);
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
		@ApiImplicitParam(name = MaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.TYPE , value = "报修类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.ACTUAL_FINISH_DATE , value = "实际完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPORT_USER_NAME , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { MaintenanceVOMeta.PAGE_INDEX , MaintenanceVOMeta.PAGE_SIZE , MaintenanceVOMeta.SEARCH_FIELD , MaintenanceVOMeta.FUZZY_FIELD , MaintenanceVOMeta.SEARCH_VALUE , MaintenanceVOMeta.DIRTY_FIELDS , MaintenanceVOMeta.SORT_FIELD , MaintenanceVOMeta.SORT_TYPE , MaintenanceVOMeta.DATA_ORIGIN , MaintenanceVOMeta.QUERY_LOGIC , MaintenanceVOMeta.REQUEST_ACTION , MaintenanceVOMeta.IDS } )
	@SentinelResource(value = MaintenanceServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintenanceServiceProxy.UPDATE)
	public Result update(MaintenanceVO maintenanceVO) {
		
		Result result=maintenanceService.update(maintenanceVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存车辆维修保养
	*/
	@ApiOperation(value = "保存车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.TYPE , value = "报修类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.ACTUAL_FINISH_DATE , value = "实际完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPORT_USER_NAME , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MaintenanceVOMeta.PAGE_INDEX , MaintenanceVOMeta.PAGE_SIZE , MaintenanceVOMeta.SEARCH_FIELD , MaintenanceVOMeta.FUZZY_FIELD , MaintenanceVOMeta.SEARCH_VALUE , MaintenanceVOMeta.DIRTY_FIELDS , MaintenanceVOMeta.SORT_FIELD , MaintenanceVOMeta.SORT_TYPE , MaintenanceVOMeta.DATA_ORIGIN , MaintenanceVOMeta.QUERY_LOGIC , MaintenanceVOMeta.REQUEST_ACTION , MaintenanceVOMeta.IDS } )
	@SentinelResource(value = MaintenanceServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintenanceServiceProxy.SAVE)
	public Result save(MaintenanceVO maintenanceVO) {
		
		Result result=maintenanceService.save(maintenanceVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取车辆维修保养
	*/
	@ApiOperation(value = "获取车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MaintenanceServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintenanceServiceProxy.GET_BY_ID)
	public Result<Maintenance> getById(String id) {
		
		Result<Maintenance> result=new Result<>();
		Maintenance maintenance=maintenanceService.getById(id);
		// join 关联的对象
		maintenanceService.dao().fill(maintenance)
			.with(MaintenanceMeta.MAINTENANCE_DICT)
			.execute();
		result.success(true).data(maintenance);
		return result;
	}


	/**
	 * 批量获取车辆维修保养 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取车辆维修保养")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MaintenanceVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = MaintenanceServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintenanceServiceProxy.GET_BY_IDS)
	public Result<List<Maintenance>> getByIds(List<String> ids) {
		
		Result<List<Maintenance>> result=new Result<>();
		List<Maintenance> list=maintenanceService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询车辆维修保养
	*/
	@ApiOperation(value = "查询车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.TYPE , value = "报修类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.ACTUAL_FINISH_DATE , value = "实际完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPORT_USER_NAME , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { MaintenanceVOMeta.PAGE_INDEX , MaintenanceVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MaintenanceServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintenanceServiceProxy.QUERY_LIST)
	public Result<List<Maintenance>> queryList(MaintenanceVO sample) {
		
		Result<List<Maintenance>> result=new Result<>();
		List<Maintenance> list=maintenanceService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询车辆维修保养
	*/
	@ApiOperation(value = "分页查询车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.TYPE , value = "报修类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.ACTUAL_FINISH_DATE , value = "实际完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPORT_USER_NAME , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MaintenanceServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintenanceServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Maintenance>> queryPagedList(MaintenanceVO sample) {
		
		Result<PagedList<Maintenance>> result=new Result<>();
		PagedList<Maintenance> list=maintenanceService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		maintenanceService.dao().fill(list)
			.with(MaintenanceMeta.MAINTENANCE_DICT)
			.execute();
		result.success(true).data(list);
		return result;
	}





}