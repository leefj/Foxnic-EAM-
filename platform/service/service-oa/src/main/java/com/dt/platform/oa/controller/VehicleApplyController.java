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


import com.dt.platform.proxy.oa.VehicleApplyServiceProxy;
import com.dt.platform.domain.oa.meta.VehicleApplyVOMeta;
import com.dt.platform.domain.oa.VehicleApply;
import com.dt.platform.domain.oa.VehicleApplyVO;
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
import com.dt.platform.domain.oa.meta.VehicleApplyMeta;
import com.dt.platform.domain.oa.VehicleInfo;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.IVehicleApplyService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 车辆申请接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 16:02:14
*/

@InDoc
@Api(tags = "车辆申请")
@RestController("OaVehicleApplyController")
public class VehicleApplyController extends SuperController {

	@Autowired
	private IVehicleApplyService vehicleApplyService;

	/**
	 * 添加车辆申请
	*/
	@ApiOperation(value = "添加车辆申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.ORG_ID , value = "部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.RECEIVER_ID , value = "领用人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.DRIVER , value = "驾驶员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.CONTACT , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.COLLECTION_DATE , value = "领用时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.PLAN_RETURN_DATE , value = "预计归还时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.ACT_RETURN_DATE , value = "实际归还时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.IF_RETURN , value = "是否归还" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.VEHICLE_ID , value = "车辆" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.RETURN_NOTES , value = "归还备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = VehicleApplyServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleApplyServiceProxy.INSERT)
	public Result insert(VehicleApplyVO vehicleApplyVO) {
		
		Result result=vehicleApplyService.insert(vehicleApplyVO,false);
		return result;
	}



	/**
	 * 删除车辆申请
	*/
	@ApiOperation(value = "删除车辆申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = VehicleApplyServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleApplyServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  vehicleApplyService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=vehicleApplyService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除车辆申请 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除车辆申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleApplyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = VehicleApplyServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleApplyServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = vehicleApplyService.hasRefers(ids);
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
			Result result=vehicleApplyService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=vehicleApplyService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新车辆申请
	*/
	@ApiOperation(value = "更新车辆申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.ORG_ID , value = "部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.RECEIVER_ID , value = "领用人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.DRIVER , value = "驾驶员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.CONTACT , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.COLLECTION_DATE , value = "领用时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.PLAN_RETURN_DATE , value = "预计归还时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.ACT_RETURN_DATE , value = "实际归还时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.IF_RETURN , value = "是否归还" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.VEHICLE_ID , value = "车辆" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.RETURN_NOTES , value = "归还备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { VehicleApplyVOMeta.PAGE_INDEX , VehicleApplyVOMeta.PAGE_SIZE , VehicleApplyVOMeta.SEARCH_FIELD , VehicleApplyVOMeta.FUZZY_FIELD , VehicleApplyVOMeta.SEARCH_VALUE , VehicleApplyVOMeta.DIRTY_FIELDS , VehicleApplyVOMeta.SORT_FIELD , VehicleApplyVOMeta.SORT_TYPE , VehicleApplyVOMeta.DATA_ORIGIN , VehicleApplyVOMeta.QUERY_LOGIC , VehicleApplyVOMeta.REQUEST_ACTION , VehicleApplyVOMeta.IDS } )
	@SentinelResource(value = VehicleApplyServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleApplyServiceProxy.UPDATE)
	public Result update(VehicleApplyVO vehicleApplyVO) {
		
		Result result=vehicleApplyService.update(vehicleApplyVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存车辆申请
	*/
	@ApiOperation(value = "保存车辆申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.ORG_ID , value = "部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.RECEIVER_ID , value = "领用人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.DRIVER , value = "驾驶员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.CONTACT , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.COLLECTION_DATE , value = "领用时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.PLAN_RETURN_DATE , value = "预计归还时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.ACT_RETURN_DATE , value = "实际归还时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.IF_RETURN , value = "是否归还" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.VEHICLE_ID , value = "车辆" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.RETURN_NOTES , value = "归还备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { VehicleApplyVOMeta.PAGE_INDEX , VehicleApplyVOMeta.PAGE_SIZE , VehicleApplyVOMeta.SEARCH_FIELD , VehicleApplyVOMeta.FUZZY_FIELD , VehicleApplyVOMeta.SEARCH_VALUE , VehicleApplyVOMeta.DIRTY_FIELDS , VehicleApplyVOMeta.SORT_FIELD , VehicleApplyVOMeta.SORT_TYPE , VehicleApplyVOMeta.DATA_ORIGIN , VehicleApplyVOMeta.QUERY_LOGIC , VehicleApplyVOMeta.REQUEST_ACTION , VehicleApplyVOMeta.IDS } )
	@SentinelResource(value = VehicleApplyServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleApplyServiceProxy.SAVE)
	public Result save(VehicleApplyVO vehicleApplyVO) {
		
		Result result=vehicleApplyService.save(vehicleApplyVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取车辆申请
	*/
	@ApiOperation(value = "获取车辆申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = VehicleApplyServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleApplyServiceProxy.GET_BY_ID)
	public Result<VehicleApply> getById(String id) {
		
		Result<VehicleApply> result=new Result<>();
		VehicleApply vehicleApply=vehicleApplyService.getById(id);
		// join 关联的对象
		vehicleApplyService.dao().fill(vehicleApply)
			.with("useOrganization")
			.with("receiver")
			.execute();
		result.success(true).data(vehicleApply);
		return result;
	}


	/**
	 * 批量获取车辆申请 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取车辆申请")
		@ApiImplicitParams({
				@ApiImplicitParam(name = VehicleApplyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = VehicleApplyServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleApplyServiceProxy.GET_BY_IDS)
	public Result<List<VehicleApply>> getByIds(List<String> ids) {
		
		Result<List<VehicleApply>> result=new Result<>();
		List<VehicleApply> list=vehicleApplyService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询车辆申请
	*/
	@ApiOperation(value = "查询车辆申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.ORG_ID , value = "部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.RECEIVER_ID , value = "领用人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.DRIVER , value = "驾驶员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.CONTACT , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.COLLECTION_DATE , value = "领用时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.PLAN_RETURN_DATE , value = "预计归还时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.ACT_RETURN_DATE , value = "实际归还时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.IF_RETURN , value = "是否归还" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.VEHICLE_ID , value = "车辆" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.RETURN_NOTES , value = "归还备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { VehicleApplyVOMeta.PAGE_INDEX , VehicleApplyVOMeta.PAGE_SIZE } )
	@SentinelResource(value = VehicleApplyServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleApplyServiceProxy.QUERY_LIST)
	public Result<List<VehicleApply>> queryList(VehicleApplyVO sample) {
		
		Result<List<VehicleApply>> result=new Result<>();
		List<VehicleApply> list=vehicleApplyService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询车辆申请
	*/
	@ApiOperation(value = "分页查询车辆申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VehicleApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.ORG_ID , value = "部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.RECEIVER_ID , value = "领用人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.DRIVER , value = "驾驶员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.CONTACT , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.COLLECTION_DATE , value = "领用时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.PLAN_RETURN_DATE , value = "预计归还时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.ACT_RETURN_DATE , value = "实际归还时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.IF_RETURN , value = "是否归还" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.VEHICLE_ID , value = "车辆" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.RETURN_NOTES , value = "归还备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = VehicleApplyVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = VehicleApplyServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VehicleApplyServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<VehicleApply>> queryPagedList(VehicleApplyVO sample) {
		
		Result<PagedList<VehicleApply>> result=new Result<>();
		PagedList<VehicleApply> list=vehicleApplyService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		vehicleApplyService.dao().fill(list)
			.with("useOrganization")
			.with("receiver")
			.execute();
		result.success(true).data(list);
		return result;
	}





}