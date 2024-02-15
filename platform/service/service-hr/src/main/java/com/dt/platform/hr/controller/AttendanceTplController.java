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


import com.dt.platform.proxy.hr.AttendanceTplServiceProxy;
import com.dt.platform.domain.hr.meta.AttendanceTplVOMeta;
import com.dt.platform.domain.hr.AttendanceTpl;
import com.dt.platform.domain.hr.AttendanceTplVO;
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
import com.dt.platform.domain.hr.meta.AttendanceTplMeta;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IAttendanceTplService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 考勤模版接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-15 14:43:16
*/

@InDoc
@Api(tags = "考勤模版")
@RestController("HrAttendanceTplController")
public class AttendanceTplController extends SuperController {

	@Autowired
	private IAttendanceTplService attendanceTplService;

	/**
	 * 添加考勤模版
	*/
	@ApiOperation(value = "添加考勤模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "810507735081680896"),
		@ApiImplicitParam(name = AttendanceTplVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = AttendanceTplVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "默认模版"),
		@ApiImplicitParam(name = AttendanceTplVOMeta.ON_WORK_TIME , value = "上班时间" , required = false , dataTypeClass=Date.class , example = "2024-02-15 08:30:00"),
		@ApiImplicitParam(name = AttendanceTplVOMeta.OFF_WORK_TIME , value = "下班时间" , required = false , dataTypeClass=Date.class , example = "2024-01-30 05:30:00"),
		@ApiImplicitParam(name = AttendanceTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AttendanceTplServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTplServiceProxy.INSERT)
	public Result insert(AttendanceTplVO attendanceTplVO) {
		
		Result result=attendanceTplService.insert(attendanceTplVO,false);
		return result;
	}



	/**
	 * 删除考勤模版
	*/
	@ApiOperation(value = "删除考勤模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "810507735081680896")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AttendanceTplServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTplServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  attendanceTplService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=attendanceTplService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除考勤模版 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除考勤模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTplVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AttendanceTplServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTplServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = attendanceTplService.hasRefers(ids);
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
			Result result=attendanceTplService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=attendanceTplService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新考勤模版
	*/
	@ApiOperation(value = "更新考勤模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "810507735081680896"),
		@ApiImplicitParam(name = AttendanceTplVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = AttendanceTplVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "默认模版"),
		@ApiImplicitParam(name = AttendanceTplVOMeta.ON_WORK_TIME , value = "上班时间" , required = false , dataTypeClass=Date.class , example = "2024-02-15 08:30:00"),
		@ApiImplicitParam(name = AttendanceTplVOMeta.OFF_WORK_TIME , value = "下班时间" , required = false , dataTypeClass=Date.class , example = "2024-01-30 05:30:00"),
		@ApiImplicitParam(name = AttendanceTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AttendanceTplVOMeta.PAGE_INDEX , AttendanceTplVOMeta.PAGE_SIZE , AttendanceTplVOMeta.SEARCH_FIELD , AttendanceTplVOMeta.FUZZY_FIELD , AttendanceTplVOMeta.SEARCH_VALUE , AttendanceTplVOMeta.DIRTY_FIELDS , AttendanceTplVOMeta.SORT_FIELD , AttendanceTplVOMeta.SORT_TYPE , AttendanceTplVOMeta.DATA_ORIGIN , AttendanceTplVOMeta.QUERY_LOGIC , AttendanceTplVOMeta.REQUEST_ACTION , AttendanceTplVOMeta.IDS } )
	@SentinelResource(value = AttendanceTplServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTplServiceProxy.UPDATE)
	public Result update(AttendanceTplVO attendanceTplVO) {
		
		Result result=attendanceTplService.update(attendanceTplVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存考勤模版
	*/
	@ApiOperation(value = "保存考勤模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "810507735081680896"),
		@ApiImplicitParam(name = AttendanceTplVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = AttendanceTplVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "默认模版"),
		@ApiImplicitParam(name = AttendanceTplVOMeta.ON_WORK_TIME , value = "上班时间" , required = false , dataTypeClass=Date.class , example = "2024-02-15 08:30:00"),
		@ApiImplicitParam(name = AttendanceTplVOMeta.OFF_WORK_TIME , value = "下班时间" , required = false , dataTypeClass=Date.class , example = "2024-01-30 05:30:00"),
		@ApiImplicitParam(name = AttendanceTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AttendanceTplVOMeta.PAGE_INDEX , AttendanceTplVOMeta.PAGE_SIZE , AttendanceTplVOMeta.SEARCH_FIELD , AttendanceTplVOMeta.FUZZY_FIELD , AttendanceTplVOMeta.SEARCH_VALUE , AttendanceTplVOMeta.DIRTY_FIELDS , AttendanceTplVOMeta.SORT_FIELD , AttendanceTplVOMeta.SORT_TYPE , AttendanceTplVOMeta.DATA_ORIGIN , AttendanceTplVOMeta.QUERY_LOGIC , AttendanceTplVOMeta.REQUEST_ACTION , AttendanceTplVOMeta.IDS } )
	@SentinelResource(value = AttendanceTplServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTplServiceProxy.SAVE)
	public Result save(AttendanceTplVO attendanceTplVO) {
		
		Result result=attendanceTplService.save(attendanceTplVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取考勤模版
	*/
	@ApiOperation(value = "获取考勤模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AttendanceTplServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTplServiceProxy.GET_BY_ID)
	public Result<AttendanceTpl> getById(String id) {
		
		Result<AttendanceTpl> result=new Result<>();
		AttendanceTpl attendanceTpl=attendanceTplService.getById(id);
		// join 关联的对象
		attendanceTplService.dao().fill(attendanceTpl)
			.with(AttendanceTplMeta.WEEK_DICT)
			.execute();
		result.success(true).data(attendanceTpl);
		return result;
	}


	/**
	 * 批量获取考勤模版 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取考勤模版")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AttendanceTplVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AttendanceTplServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTplServiceProxy.GET_BY_IDS)
	public Result<List<AttendanceTpl>> getByIds(List<String> ids) {
		
		Result<List<AttendanceTpl>> result=new Result<>();
		List<AttendanceTpl> list=attendanceTplService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询考勤模版
	*/
	@ApiOperation(value = "查询考勤模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "810507735081680896"),
		@ApiImplicitParam(name = AttendanceTplVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = AttendanceTplVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "默认模版"),
		@ApiImplicitParam(name = AttendanceTplVOMeta.ON_WORK_TIME , value = "上班时间" , required = false , dataTypeClass=Date.class , example = "2024-02-15 08:30:00"),
		@ApiImplicitParam(name = AttendanceTplVOMeta.OFF_WORK_TIME , value = "下班时间" , required = false , dataTypeClass=Date.class , example = "2024-01-30 05:30:00"),
		@ApiImplicitParam(name = AttendanceTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AttendanceTplVOMeta.PAGE_INDEX , AttendanceTplVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AttendanceTplServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTplServiceProxy.QUERY_LIST)
	public Result<List<AttendanceTpl>> queryList(AttendanceTplVO sample) {
		
		Result<List<AttendanceTpl>> result=new Result<>();
		List<AttendanceTpl> list=attendanceTplService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询考勤模版
	*/
	@ApiOperation(value = "分页查询考勤模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "810507735081680896"),
		@ApiImplicitParam(name = AttendanceTplVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = AttendanceTplVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "默认模版"),
		@ApiImplicitParam(name = AttendanceTplVOMeta.ON_WORK_TIME , value = "上班时间" , required = false , dataTypeClass=Date.class , example = "2024-02-15 08:30:00"),
		@ApiImplicitParam(name = AttendanceTplVOMeta.OFF_WORK_TIME , value = "下班时间" , required = false , dataTypeClass=Date.class , example = "2024-01-30 05:30:00"),
		@ApiImplicitParam(name = AttendanceTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AttendanceTplServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTplServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AttendanceTpl>> queryPagedList(AttendanceTplVO sample) {
		
		Result<PagedList<AttendanceTpl>> result=new Result<>();
		PagedList<AttendanceTpl> list=attendanceTplService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		attendanceTplService.dao().fill(list)
			.with(AttendanceTplMeta.WEEK_DICT)
			.execute();
		result.success(true).data(list);
		return result;
	}





}