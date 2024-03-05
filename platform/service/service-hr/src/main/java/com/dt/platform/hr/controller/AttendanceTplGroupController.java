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


import com.dt.platform.proxy.hr.AttendanceTplGroupServiceProxy;
import com.dt.platform.domain.hr.meta.AttendanceTplGroupVOMeta;
import com.dt.platform.domain.hr.AttendanceTplGroup;
import com.dt.platform.domain.hr.AttendanceTplGroupVO;
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
import com.dt.platform.domain.hr.meta.AttendanceTplGroupMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IAttendanceTplGroupService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 考勤班组接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-27 13:25:42
*/

@InDoc
@Api(tags = "考勤班组")
@RestController("HrAttendanceTplGroupController")
public class AttendanceTplGroupController extends SuperController {

	@Autowired
	private IAttendanceTplGroupService attendanceTplGroupService;

	/**
	 * 添加考勤班组
	*/
	@ApiOperation(value = "添加考勤班组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.NAME , value = "名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.ON_WORK_TIME , value = "上班时间" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.ON_WORK_TIME_UP , value = "上班打卡上限" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.ON_WORK_TIME_DOWN , value = "上班打卡下限" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.OFF_WORK_TIME , value = "下班时间" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.OFF_WORK_TIME_UP , value = "下班打卡上限" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.OFF_WORK_TIME_DOWN , value = "下班打卡下限" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.HALF_WORK_UP , value = "上班打卡" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.HALF_WORK_DOWN , value = "下班打卡" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AttendanceTplGroupServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTplGroupServiceProxy.INSERT)
	public Result insert(AttendanceTplGroupVO attendanceTplGroupVO) {
		
		Result result=attendanceTplGroupService.insert(attendanceTplGroupVO,false);
		return result;
	}



	/**
	 * 删除考勤班组
	*/
	@ApiOperation(value = "删除考勤班组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AttendanceTplGroupServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTplGroupServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  attendanceTplGroupService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=attendanceTplGroupService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除考勤班组 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除考勤班组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AttendanceTplGroupServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTplGroupServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = attendanceTplGroupService.hasRefers(ids);
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
			Result result=attendanceTplGroupService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=attendanceTplGroupService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新考勤班组
	*/
	@ApiOperation(value = "更新考勤班组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.NAME , value = "名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.ON_WORK_TIME , value = "上班时间" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.ON_WORK_TIME_UP , value = "上班打卡上限" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.ON_WORK_TIME_DOWN , value = "上班打卡下限" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.OFF_WORK_TIME , value = "下班时间" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.OFF_WORK_TIME_UP , value = "下班打卡上限" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.OFF_WORK_TIME_DOWN , value = "下班打卡下限" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.HALF_WORK_UP , value = "上班打卡" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.HALF_WORK_DOWN , value = "下班打卡" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AttendanceTplGroupVOMeta.PAGE_INDEX , AttendanceTplGroupVOMeta.PAGE_SIZE , AttendanceTplGroupVOMeta.SEARCH_FIELD , AttendanceTplGroupVOMeta.FUZZY_FIELD , AttendanceTplGroupVOMeta.SEARCH_VALUE , AttendanceTplGroupVOMeta.DIRTY_FIELDS , AttendanceTplGroupVOMeta.SORT_FIELD , AttendanceTplGroupVOMeta.SORT_TYPE , AttendanceTplGroupVOMeta.DATA_ORIGIN , AttendanceTplGroupVOMeta.QUERY_LOGIC , AttendanceTplGroupVOMeta.REQUEST_ACTION , AttendanceTplGroupVOMeta.IDS } )
	@SentinelResource(value = AttendanceTplGroupServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTplGroupServiceProxy.UPDATE)
	public Result update(AttendanceTplGroupVO attendanceTplGroupVO) {
		
		Result result=attendanceTplGroupService.update(attendanceTplGroupVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存考勤班组
	*/
	@ApiOperation(value = "保存考勤班组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.NAME , value = "名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.ON_WORK_TIME , value = "上班时间" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.ON_WORK_TIME_UP , value = "上班打卡上限" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.ON_WORK_TIME_DOWN , value = "上班打卡下限" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.OFF_WORK_TIME , value = "下班时间" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.OFF_WORK_TIME_UP , value = "下班打卡上限" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.OFF_WORK_TIME_DOWN , value = "下班打卡下限" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.HALF_WORK_UP , value = "上班打卡" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.HALF_WORK_DOWN , value = "下班打卡" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AttendanceTplGroupVOMeta.PAGE_INDEX , AttendanceTplGroupVOMeta.PAGE_SIZE , AttendanceTplGroupVOMeta.SEARCH_FIELD , AttendanceTplGroupVOMeta.FUZZY_FIELD , AttendanceTplGroupVOMeta.SEARCH_VALUE , AttendanceTplGroupVOMeta.DIRTY_FIELDS , AttendanceTplGroupVOMeta.SORT_FIELD , AttendanceTplGroupVOMeta.SORT_TYPE , AttendanceTplGroupVOMeta.DATA_ORIGIN , AttendanceTplGroupVOMeta.QUERY_LOGIC , AttendanceTplGroupVOMeta.REQUEST_ACTION , AttendanceTplGroupVOMeta.IDS } )
	@SentinelResource(value = AttendanceTplGroupServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTplGroupServiceProxy.SAVE)
	public Result save(AttendanceTplGroupVO attendanceTplGroupVO) {
		
		Result result=attendanceTplGroupService.save(attendanceTplGroupVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取考勤班组
	*/
	@ApiOperation(value = "获取考勤班组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AttendanceTplGroupServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTplGroupServiceProxy.GET_BY_ID)
	public Result<AttendanceTplGroup> getById(String id) {
		
		Result<AttendanceTplGroup> result=new Result<>();
		AttendanceTplGroup attendanceTplGroup=attendanceTplGroupService.getById(id);
		result.success(true).data(attendanceTplGroup);
		return result;
	}


	/**
	 * 批量获取考勤班组 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取考勤班组")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AttendanceTplGroupVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AttendanceTplGroupServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTplGroupServiceProxy.GET_BY_IDS)
	public Result<List<AttendanceTplGroup>> getByIds(List<String> ids) {
		
		Result<List<AttendanceTplGroup>> result=new Result<>();
		List<AttendanceTplGroup> list=attendanceTplGroupService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询考勤班组
	*/
	@ApiOperation(value = "查询考勤班组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.NAME , value = "名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.ON_WORK_TIME , value = "上班时间" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.ON_WORK_TIME_UP , value = "上班打卡上限" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.ON_WORK_TIME_DOWN , value = "上班打卡下限" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.OFF_WORK_TIME , value = "下班时间" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.OFF_WORK_TIME_UP , value = "下班打卡上限" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.OFF_WORK_TIME_DOWN , value = "下班打卡下限" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.HALF_WORK_UP , value = "上班打卡" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.HALF_WORK_DOWN , value = "下班打卡" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AttendanceTplGroupVOMeta.PAGE_INDEX , AttendanceTplGroupVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AttendanceTplGroupServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTplGroupServiceProxy.QUERY_LIST)
	public Result<List<AttendanceTplGroup>> queryList(AttendanceTplGroupVO sample) {
		
		Result<List<AttendanceTplGroup>> result=new Result<>();
		List<AttendanceTplGroup> list=attendanceTplGroupService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询考勤班组
	*/
	@ApiOperation(value = "分页查询考勤班组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.NAME , value = "名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.ON_WORK_TIME , value = "上班时间" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.ON_WORK_TIME_UP , value = "上班打卡上限" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.ON_WORK_TIME_DOWN , value = "上班打卡下限" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.OFF_WORK_TIME , value = "下班时间" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.OFF_WORK_TIME_UP , value = "下班打卡上限" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.OFF_WORK_TIME_DOWN , value = "下班打卡下限" , required = true , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.HALF_WORK_UP , value = "上班打卡" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.HALF_WORK_DOWN , value = "下班打卡" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplGroupVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AttendanceTplGroupServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTplGroupServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AttendanceTplGroup>> queryPagedList(AttendanceTplGroupVO sample) {
		
		Result<PagedList<AttendanceTplGroup>> result=new Result<>();
		PagedList<AttendanceTplGroup> list=attendanceTplGroupService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}