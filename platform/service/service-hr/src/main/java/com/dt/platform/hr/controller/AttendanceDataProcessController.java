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


import com.dt.platform.proxy.hr.AttendanceDataProcessServiceProxy;
import com.dt.platform.domain.hr.meta.AttendanceDataProcessVOMeta;
import com.dt.platform.domain.hr.AttendanceDataProcess;
import com.dt.platform.domain.hr.AttendanceDataProcessVO;
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
import com.dt.platform.domain.hr.meta.AttendanceDataProcessMeta;
import com.dt.platform.domain.hr.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IAttendanceDataProcessService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 处理记录接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-26 09:54:31
*/

@InDoc
@Api(tags = "处理记录")
@RestController("HrAttendanceDataProcessController")
public class AttendanceDataProcessController extends SuperController {

	@Autowired
	private IAttendanceDataProcessService attendanceDataProcessService;

	/**
	 * 添加处理记录
	*/
	@ApiOperation(value = "添加处理记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "814413143928209408"),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "process_failed"),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class , example = "801565609459449857"),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.KQ_RQ , value = "考勤日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.PROCESS_DATE , value = "处理时间" , required = false , dataTypeClass=Date.class , example = "2024-02-26 08:27:05"),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "失败,没有配置考勤组。"),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AttendanceDataProcessServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceDataProcessServiceProxy.INSERT)
	public Result insert(AttendanceDataProcessVO attendanceDataProcessVO) {
		
		Result result=attendanceDataProcessService.insert(attendanceDataProcessVO,false);
		return result;
	}



	/**
	 * 删除处理记录
	*/
	@ApiOperation(value = "删除处理记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "814413143928209408")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AttendanceDataProcessServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceDataProcessServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  attendanceDataProcessService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=attendanceDataProcessService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除处理记录 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除处理记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AttendanceDataProcessServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceDataProcessServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = attendanceDataProcessService.hasRefers(ids);
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
			Result result=attendanceDataProcessService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=attendanceDataProcessService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新处理记录
	*/
	@ApiOperation(value = "更新处理记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "814413143928209408"),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "process_failed"),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class , example = "801565609459449857"),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.KQ_RQ , value = "考勤日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.PROCESS_DATE , value = "处理时间" , required = false , dataTypeClass=Date.class , example = "2024-02-26 08:27:05"),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "失败,没有配置考勤组。"),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AttendanceDataProcessVOMeta.PAGE_INDEX , AttendanceDataProcessVOMeta.PAGE_SIZE , AttendanceDataProcessVOMeta.SEARCH_FIELD , AttendanceDataProcessVOMeta.FUZZY_FIELD , AttendanceDataProcessVOMeta.SEARCH_VALUE , AttendanceDataProcessVOMeta.DIRTY_FIELDS , AttendanceDataProcessVOMeta.SORT_FIELD , AttendanceDataProcessVOMeta.SORT_TYPE , AttendanceDataProcessVOMeta.DATA_ORIGIN , AttendanceDataProcessVOMeta.QUERY_LOGIC , AttendanceDataProcessVOMeta.REQUEST_ACTION , AttendanceDataProcessVOMeta.IDS } )
	@SentinelResource(value = AttendanceDataProcessServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceDataProcessServiceProxy.UPDATE)
	public Result update(AttendanceDataProcessVO attendanceDataProcessVO) {
		
		Result result=attendanceDataProcessService.update(attendanceDataProcessVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存处理记录
	*/
	@ApiOperation(value = "保存处理记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "814413143928209408"),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "process_failed"),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class , example = "801565609459449857"),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.KQ_RQ , value = "考勤日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.PROCESS_DATE , value = "处理时间" , required = false , dataTypeClass=Date.class , example = "2024-02-26 08:27:05"),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "失败,没有配置考勤组。"),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AttendanceDataProcessVOMeta.PAGE_INDEX , AttendanceDataProcessVOMeta.PAGE_SIZE , AttendanceDataProcessVOMeta.SEARCH_FIELD , AttendanceDataProcessVOMeta.FUZZY_FIELD , AttendanceDataProcessVOMeta.SEARCH_VALUE , AttendanceDataProcessVOMeta.DIRTY_FIELDS , AttendanceDataProcessVOMeta.SORT_FIELD , AttendanceDataProcessVOMeta.SORT_TYPE , AttendanceDataProcessVOMeta.DATA_ORIGIN , AttendanceDataProcessVOMeta.QUERY_LOGIC , AttendanceDataProcessVOMeta.REQUEST_ACTION , AttendanceDataProcessVOMeta.IDS } )
	@SentinelResource(value = AttendanceDataProcessServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceDataProcessServiceProxy.SAVE)
	public Result save(AttendanceDataProcessVO attendanceDataProcessVO) {
		
		Result result=attendanceDataProcessService.save(attendanceDataProcessVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取处理记录
	*/
	@ApiOperation(value = "获取处理记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AttendanceDataProcessServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceDataProcessServiceProxy.GET_BY_ID)
	public Result<AttendanceDataProcess> getById(String id) {
		
		Result<AttendanceDataProcess> result=new Result<>();
		AttendanceDataProcess attendanceDataProcess=attendanceDataProcessService.getById(id);
		// join 关联的对象
		attendanceDataProcessService.dao().fill(attendanceDataProcess)
			.with(AttendanceDataProcessMeta.PERSON)
			.execute();
		result.success(true).data(attendanceDataProcess);
		return result;
	}


	/**
	 * 批量获取处理记录 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取处理记录")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AttendanceDataProcessVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AttendanceDataProcessServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceDataProcessServiceProxy.GET_BY_IDS)
	public Result<List<AttendanceDataProcess>> getByIds(List<String> ids) {
		
		Result<List<AttendanceDataProcess>> result=new Result<>();
		List<AttendanceDataProcess> list=attendanceDataProcessService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询处理记录
	*/
	@ApiOperation(value = "查询处理记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "814413143928209408"),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "process_failed"),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class , example = "801565609459449857"),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.KQ_RQ , value = "考勤日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.PROCESS_DATE , value = "处理时间" , required = false , dataTypeClass=Date.class , example = "2024-02-26 08:27:05"),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "失败,没有配置考勤组。"),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AttendanceDataProcessVOMeta.PAGE_INDEX , AttendanceDataProcessVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AttendanceDataProcessServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceDataProcessServiceProxy.QUERY_LIST)
	public Result<List<AttendanceDataProcess>> queryList(AttendanceDataProcessVO sample) {
		
		Result<List<AttendanceDataProcess>> result=new Result<>();
		List<AttendanceDataProcess> list=attendanceDataProcessService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询处理记录
	*/
	@ApiOperation(value = "分页查询处理记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "814413143928209408"),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "process_failed"),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class , example = "801565609459449857"),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.KQ_RQ , value = "考勤日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.PROCESS_DATE , value = "处理时间" , required = false , dataTypeClass=Date.class , example = "2024-02-26 08:27:05"),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "失败,没有配置考勤组。"),
		@ApiImplicitParam(name = AttendanceDataProcessVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AttendanceDataProcessServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceDataProcessServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AttendanceDataProcess>> queryPagedList(AttendanceDataProcessVO sample) {
		
		Result<PagedList<AttendanceDataProcess>> result=new Result<>();
		PagedList<AttendanceDataProcess> list=attendanceDataProcessService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		attendanceDataProcessService.dao().fill(list)
			.with(AttendanceDataProcessMeta.PERSON)
			.execute();
		result.success(true).data(list);
		return result;
	}





}