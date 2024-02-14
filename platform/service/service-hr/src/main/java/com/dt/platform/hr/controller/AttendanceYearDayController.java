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


import com.dt.platform.proxy.hr.AttendanceYearDayServiceProxy;
import com.dt.platform.domain.hr.meta.AttendanceYearDayVOMeta;
import com.dt.platform.domain.hr.AttendanceYearDay;
import com.dt.platform.domain.hr.AttendanceYearDayVO;
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
import com.dt.platform.domain.hr.meta.AttendanceYearDayMeta;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.hrm.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IAttendanceYearDayService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 年假记录接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-13 23:07:05
*/

@InDoc
@Api(tags = "年假记录")
@RestController("HrAttendanceYearDayController")
public class AttendanceYearDayController extends SuperController {

	@Autowired
	private IAttendanceYearDayService attendanceYearDayService;

	/**
	 * 添加年假记录
	*/
	@ApiOperation(value = "添加年假记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.SDATE , value = "开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.EDATE , value = "结束日期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.DAYS , value = "本周期" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.LAST_DAYS , value = "上一周期" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AttendanceYearDayServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceYearDayServiceProxy.INSERT)
	public Result insert(AttendanceYearDayVO attendanceYearDayVO) {
		
		Result result=attendanceYearDayService.insert(attendanceYearDayVO,false);
		return result;
	}



	/**
	 * 删除年假记录
	*/
	@ApiOperation(value = "删除年假记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AttendanceYearDayServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceYearDayServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  attendanceYearDayService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=attendanceYearDayService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除年假记录 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除年假记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AttendanceYearDayServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceYearDayServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = attendanceYearDayService.hasRefers(ids);
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
			Result result=attendanceYearDayService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=attendanceYearDayService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新年假记录
	*/
	@ApiOperation(value = "更新年假记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.SDATE , value = "开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.EDATE , value = "结束日期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.DAYS , value = "本周期" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.LAST_DAYS , value = "上一周期" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AttendanceYearDayVOMeta.PAGE_INDEX , AttendanceYearDayVOMeta.PAGE_SIZE , AttendanceYearDayVOMeta.SEARCH_FIELD , AttendanceYearDayVOMeta.FUZZY_FIELD , AttendanceYearDayVOMeta.SEARCH_VALUE , AttendanceYearDayVOMeta.DIRTY_FIELDS , AttendanceYearDayVOMeta.SORT_FIELD , AttendanceYearDayVOMeta.SORT_TYPE , AttendanceYearDayVOMeta.DATA_ORIGIN , AttendanceYearDayVOMeta.QUERY_LOGIC , AttendanceYearDayVOMeta.REQUEST_ACTION , AttendanceYearDayVOMeta.IDS } )
	@SentinelResource(value = AttendanceYearDayServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceYearDayServiceProxy.UPDATE)
	public Result update(AttendanceYearDayVO attendanceYearDayVO) {
		
		Result result=attendanceYearDayService.update(attendanceYearDayVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存年假记录
	*/
	@ApiOperation(value = "保存年假记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.SDATE , value = "开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.EDATE , value = "结束日期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.DAYS , value = "本周期" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.LAST_DAYS , value = "上一周期" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AttendanceYearDayVOMeta.PAGE_INDEX , AttendanceYearDayVOMeta.PAGE_SIZE , AttendanceYearDayVOMeta.SEARCH_FIELD , AttendanceYearDayVOMeta.FUZZY_FIELD , AttendanceYearDayVOMeta.SEARCH_VALUE , AttendanceYearDayVOMeta.DIRTY_FIELDS , AttendanceYearDayVOMeta.SORT_FIELD , AttendanceYearDayVOMeta.SORT_TYPE , AttendanceYearDayVOMeta.DATA_ORIGIN , AttendanceYearDayVOMeta.QUERY_LOGIC , AttendanceYearDayVOMeta.REQUEST_ACTION , AttendanceYearDayVOMeta.IDS } )
	@SentinelResource(value = AttendanceYearDayServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceYearDayServiceProxy.SAVE)
	public Result save(AttendanceYearDayVO attendanceYearDayVO) {
		
		Result result=attendanceYearDayService.save(attendanceYearDayVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取年假记录
	*/
	@ApiOperation(value = "获取年假记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AttendanceYearDayServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceYearDayServiceProxy.GET_BY_ID)
	public Result<AttendanceYearDay> getById(String id) {
		
		Result<AttendanceYearDay> result=new Result<>();
		AttendanceYearDay attendanceYearDay=attendanceYearDayService.getById(id);
		// join 关联的对象
		attendanceYearDayService.dao().fill(attendanceYearDay)
			.with("person")
			.execute();
		result.success(true).data(attendanceYearDay);
		return result;
	}


	/**
	 * 批量获取年假记录 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取年假记录")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AttendanceYearDayVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AttendanceYearDayServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceYearDayServiceProxy.GET_BY_IDS)
	public Result<List<AttendanceYearDay>> getByIds(List<String> ids) {
		
		Result<List<AttendanceYearDay>> result=new Result<>();
		List<AttendanceYearDay> list=attendanceYearDayService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询年假记录
	*/
	@ApiOperation(value = "查询年假记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.SDATE , value = "开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.EDATE , value = "结束日期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.DAYS , value = "本周期" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.LAST_DAYS , value = "上一周期" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AttendanceYearDayVOMeta.PAGE_INDEX , AttendanceYearDayVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AttendanceYearDayServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceYearDayServiceProxy.QUERY_LIST)
	public Result<List<AttendanceYearDay>> queryList(AttendanceYearDayVO sample) {
		
		Result<List<AttendanceYearDay>> result=new Result<>();
		List<AttendanceYearDay> list=attendanceYearDayService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询年假记录
	*/
	@ApiOperation(value = "分页查询年假记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.SDATE , value = "开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.EDATE , value = "结束日期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.DAYS , value = "本周期" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.LAST_DAYS , value = "上一周期" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceYearDayVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AttendanceYearDayServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceYearDayServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AttendanceYearDay>> queryPagedList(AttendanceYearDayVO sample) {
		
		Result<PagedList<AttendanceYearDay>> result=new Result<>();
		PagedList<AttendanceYearDay> list=attendanceYearDayService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		attendanceYearDayService.dao().fill(list)
			.with("person")
			.execute();
		result.success(true).data(list);
		return result;
	}





}