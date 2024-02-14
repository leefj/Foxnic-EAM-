package com.dt.platform.hr.controller;

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


import com.dt.platform.proxy.hr.AttendanceTypeServiceProxy;
import com.dt.platform.domain.hr.meta.AttendanceTypeVOMeta;
import com.dt.platform.domain.hr.AttendanceType;
import com.dt.platform.domain.hr.AttendanceTypeVO;
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
import com.dt.platform.domain.hr.meta.AttendanceTypeMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IAttendanceTypeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 考勤类型接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-13 12:52:21
*/

@InDoc
@Api(tags = "考勤类型")
@RestController("HrAttendanceTypeController")
public class AttendanceTypeController extends SuperController {

	@Autowired
	private IAttendanceTypeService attendanceTypeService;

	/**
	 * 添加考勤类型
	*/
	@ApiOperation(value = "添加考勤类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "809768011765383168"),
		@ApiImplicitParam(name = AttendanceTypeVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class , example = "nj"),
		@ApiImplicitParam(name = AttendanceTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "年假"),
		@ApiImplicitParam(name = AttendanceTypeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AttendanceTypeVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTypeVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AttendanceTypeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTypeServiceProxy.INSERT)
	public Result insert(AttendanceTypeVO attendanceTypeVO) {
		
		Result result=attendanceTypeService.insert(attendanceTypeVO,false);
		return result;
	}



	/**
	 * 删除考勤类型
	*/
	@ApiOperation(value = "删除考勤类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "809768011765383168")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AttendanceTypeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTypeServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  attendanceTypeService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=attendanceTypeService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除考勤类型 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除考勤类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AttendanceTypeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTypeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = attendanceTypeService.hasRefers(ids);
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
			Result result=attendanceTypeService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=attendanceTypeService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新考勤类型
	*/
	@ApiOperation(value = "更新考勤类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "809768011765383168"),
		@ApiImplicitParam(name = AttendanceTypeVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class , example = "nj"),
		@ApiImplicitParam(name = AttendanceTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "年假"),
		@ApiImplicitParam(name = AttendanceTypeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AttendanceTypeVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTypeVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AttendanceTypeVOMeta.PAGE_INDEX , AttendanceTypeVOMeta.PAGE_SIZE , AttendanceTypeVOMeta.SEARCH_FIELD , AttendanceTypeVOMeta.FUZZY_FIELD , AttendanceTypeVOMeta.SEARCH_VALUE , AttendanceTypeVOMeta.DIRTY_FIELDS , AttendanceTypeVOMeta.SORT_FIELD , AttendanceTypeVOMeta.SORT_TYPE , AttendanceTypeVOMeta.DATA_ORIGIN , AttendanceTypeVOMeta.QUERY_LOGIC , AttendanceTypeVOMeta.REQUEST_ACTION , AttendanceTypeVOMeta.IDS } )
	@SentinelResource(value = AttendanceTypeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTypeServiceProxy.UPDATE)
	public Result update(AttendanceTypeVO attendanceTypeVO) {
		
		Result result=attendanceTypeService.update(attendanceTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存考勤类型
	*/
	@ApiOperation(value = "保存考勤类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "809768011765383168"),
		@ApiImplicitParam(name = AttendanceTypeVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class , example = "nj"),
		@ApiImplicitParam(name = AttendanceTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "年假"),
		@ApiImplicitParam(name = AttendanceTypeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AttendanceTypeVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTypeVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AttendanceTypeVOMeta.PAGE_INDEX , AttendanceTypeVOMeta.PAGE_SIZE , AttendanceTypeVOMeta.SEARCH_FIELD , AttendanceTypeVOMeta.FUZZY_FIELD , AttendanceTypeVOMeta.SEARCH_VALUE , AttendanceTypeVOMeta.DIRTY_FIELDS , AttendanceTypeVOMeta.SORT_FIELD , AttendanceTypeVOMeta.SORT_TYPE , AttendanceTypeVOMeta.DATA_ORIGIN , AttendanceTypeVOMeta.QUERY_LOGIC , AttendanceTypeVOMeta.REQUEST_ACTION , AttendanceTypeVOMeta.IDS } )
	@SentinelResource(value = AttendanceTypeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTypeServiceProxy.SAVE)
	public Result save(AttendanceTypeVO attendanceTypeVO) {
		
		Result result=attendanceTypeService.save(attendanceTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取考勤类型
	*/
	@ApiOperation(value = "获取考勤类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AttendanceTypeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTypeServiceProxy.GET_BY_ID)
	public Result<AttendanceType> getById(String id) {
		
		Result<AttendanceType> result=new Result<>();
		AttendanceType attendanceType=attendanceTypeService.getById(id);
		result.success(true).data(attendanceType);
		return result;
	}


	/**
	 * 批量获取考勤类型 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取考勤类型")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AttendanceTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AttendanceTypeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTypeServiceProxy.GET_BY_IDS)
	public Result<List<AttendanceType>> getByIds(List<String> ids) {
		
		Result<List<AttendanceType>> result=new Result<>();
		List<AttendanceType> list=attendanceTypeService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询考勤类型
	*/
	@ApiOperation(value = "查询考勤类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "809768011765383168"),
		@ApiImplicitParam(name = AttendanceTypeVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class , example = "nj"),
		@ApiImplicitParam(name = AttendanceTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "年假"),
		@ApiImplicitParam(name = AttendanceTypeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AttendanceTypeVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTypeVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AttendanceTypeVOMeta.PAGE_INDEX , AttendanceTypeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AttendanceTypeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTypeServiceProxy.QUERY_LIST)
	public Result<List<AttendanceType>> queryList(AttendanceTypeVO sample) {
		
		Result<List<AttendanceType>> result=new Result<>();
		List<AttendanceType> list=attendanceTypeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询考勤类型
	*/
	@ApiOperation(value = "分页查询考勤类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "809768011765383168"),
		@ApiImplicitParam(name = AttendanceTypeVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class , example = "nj"),
		@ApiImplicitParam(name = AttendanceTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "年假"),
		@ApiImplicitParam(name = AttendanceTypeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AttendanceTypeVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTypeVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AttendanceTypeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTypeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AttendanceType>> queryPagedList(AttendanceTypeVO sample) {
		
		Result<PagedList<AttendanceType>> result=new Result<>();
		PagedList<AttendanceType> list=attendanceTypeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}