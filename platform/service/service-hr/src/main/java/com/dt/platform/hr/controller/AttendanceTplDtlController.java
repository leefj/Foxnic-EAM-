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


import com.dt.platform.proxy.hr.AttendanceTplDtlServiceProxy;
import com.dt.platform.domain.hr.meta.AttendanceTplDtlVOMeta;
import com.dt.platform.domain.hr.AttendanceTplDtl;
import com.dt.platform.domain.hr.AttendanceTplDtlVO;
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
import com.dt.platform.domain.hr.meta.AttendanceTplDtlMeta;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.hr.AttendanceTplGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IAttendanceTplDtlService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 考勤组接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-27 13:36:26
*/

@InDoc
@Api(tags = "考勤组")
@RestController("HrAttendanceTplDtlController")
public class AttendanceTplDtlController extends SuperController {

	@Autowired
	private IAttendanceTplDtlService attendanceTplDtlService;

	/**
	 * 添加考勤组
	*/
	@ApiOperation(value = "添加考勤组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "814224996120395701"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.OWNER_ID , value = "编码" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.WEEK , value = "周" , required = false , dataTypeClass=String.class , example = "w1"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.IS_WORK_DAY , value = "是否上班" , required = false , dataTypeClass=String.class , example = "yes"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.DAY_TYPE , value = "上班类型" , required = false , dataTypeClass=String.class , example = "day_full"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.FIRST_WORK , value = "1天1次" , required = false , dataTypeClass=String.class , example = "814851231850692608"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.SECOND_WORK , value = "1天2次" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AttendanceTplDtlServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTplDtlServiceProxy.INSERT)
	public Result insert(AttendanceTplDtlVO attendanceTplDtlVO) {
		
		Result result=attendanceTplDtlService.insert(attendanceTplDtlVO,false);
		return result;
	}



	/**
	 * 删除考勤组
	*/
	@ApiOperation(value = "删除考勤组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "814224996120395701")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AttendanceTplDtlServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTplDtlServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  attendanceTplDtlService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=attendanceTplDtlService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除考勤组 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除考勤组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AttendanceTplDtlServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTplDtlServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = attendanceTplDtlService.hasRefers(ids);
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
			Result result=attendanceTplDtlService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=attendanceTplDtlService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新考勤组
	*/
	@ApiOperation(value = "更新考勤组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "814224996120395701"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.OWNER_ID , value = "编码" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.WEEK , value = "周" , required = false , dataTypeClass=String.class , example = "w1"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.IS_WORK_DAY , value = "是否上班" , required = false , dataTypeClass=String.class , example = "yes"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.DAY_TYPE , value = "上班类型" , required = false , dataTypeClass=String.class , example = "day_full"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.FIRST_WORK , value = "1天1次" , required = false , dataTypeClass=String.class , example = "814851231850692608"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.SECOND_WORK , value = "1天2次" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AttendanceTplDtlVOMeta.PAGE_INDEX , AttendanceTplDtlVOMeta.PAGE_SIZE , AttendanceTplDtlVOMeta.SEARCH_FIELD , AttendanceTplDtlVOMeta.FUZZY_FIELD , AttendanceTplDtlVOMeta.SEARCH_VALUE , AttendanceTplDtlVOMeta.DIRTY_FIELDS , AttendanceTplDtlVOMeta.SORT_FIELD , AttendanceTplDtlVOMeta.SORT_TYPE , AttendanceTplDtlVOMeta.DATA_ORIGIN , AttendanceTplDtlVOMeta.QUERY_LOGIC , AttendanceTplDtlVOMeta.REQUEST_ACTION , AttendanceTplDtlVOMeta.IDS } )
	@SentinelResource(value = AttendanceTplDtlServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTplDtlServiceProxy.UPDATE)
	public Result update(AttendanceTplDtlVO attendanceTplDtlVO) {
		
		Result result=attendanceTplDtlService.update(attendanceTplDtlVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存考勤组
	*/
	@ApiOperation(value = "保存考勤组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "814224996120395701"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.OWNER_ID , value = "编码" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.WEEK , value = "周" , required = false , dataTypeClass=String.class , example = "w1"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.IS_WORK_DAY , value = "是否上班" , required = false , dataTypeClass=String.class , example = "yes"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.DAY_TYPE , value = "上班类型" , required = false , dataTypeClass=String.class , example = "day_full"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.FIRST_WORK , value = "1天1次" , required = false , dataTypeClass=String.class , example = "814851231850692608"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.SECOND_WORK , value = "1天2次" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AttendanceTplDtlVOMeta.PAGE_INDEX , AttendanceTplDtlVOMeta.PAGE_SIZE , AttendanceTplDtlVOMeta.SEARCH_FIELD , AttendanceTplDtlVOMeta.FUZZY_FIELD , AttendanceTplDtlVOMeta.SEARCH_VALUE , AttendanceTplDtlVOMeta.DIRTY_FIELDS , AttendanceTplDtlVOMeta.SORT_FIELD , AttendanceTplDtlVOMeta.SORT_TYPE , AttendanceTplDtlVOMeta.DATA_ORIGIN , AttendanceTplDtlVOMeta.QUERY_LOGIC , AttendanceTplDtlVOMeta.REQUEST_ACTION , AttendanceTplDtlVOMeta.IDS } )
	@SentinelResource(value = AttendanceTplDtlServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTplDtlServiceProxy.SAVE)
	public Result save(AttendanceTplDtlVO attendanceTplDtlVO) {
		
		Result result=attendanceTplDtlService.save(attendanceTplDtlVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取考勤组
	*/
	@ApiOperation(value = "获取考勤组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AttendanceTplDtlServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTplDtlServiceProxy.GET_BY_ID)
	public Result<AttendanceTplDtl> getById(String id) {
		
		Result<AttendanceTplDtl> result=new Result<>();
		AttendanceTplDtl attendanceTplDtl=attendanceTplDtlService.getById(id);
		// join 关联的对象
		attendanceTplDtlService.dao().fill(attendanceTplDtl)
			.with(AttendanceTplDtlMeta.FIRST_GROUP)
			.with(AttendanceTplDtlMeta.SECOND_GROUP)
			.with(AttendanceTplDtlMeta.WEEK_DICT)
			.execute();
		result.success(true).data(attendanceTplDtl);
		return result;
	}


	/**
	 * 批量获取考勤组 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取考勤组")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AttendanceTplDtlVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AttendanceTplDtlServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTplDtlServiceProxy.GET_BY_IDS)
	public Result<List<AttendanceTplDtl>> getByIds(List<String> ids) {
		
		Result<List<AttendanceTplDtl>> result=new Result<>();
		List<AttendanceTplDtl> list=attendanceTplDtlService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询考勤组
	*/
	@ApiOperation(value = "查询考勤组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "814224996120395701"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.OWNER_ID , value = "编码" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.WEEK , value = "周" , required = false , dataTypeClass=String.class , example = "w1"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.IS_WORK_DAY , value = "是否上班" , required = false , dataTypeClass=String.class , example = "yes"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.DAY_TYPE , value = "上班类型" , required = false , dataTypeClass=String.class , example = "day_full"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.FIRST_WORK , value = "1天1次" , required = false , dataTypeClass=String.class , example = "814851231850692608"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.SECOND_WORK , value = "1天2次" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AttendanceTplDtlVOMeta.PAGE_INDEX , AttendanceTplDtlVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AttendanceTplDtlServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTplDtlServiceProxy.QUERY_LIST)
	public Result<List<AttendanceTplDtl>> queryList(AttendanceTplDtlVO sample) {
		
		Result<List<AttendanceTplDtl>> result=new Result<>();
		List<AttendanceTplDtl> list=attendanceTplDtlService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询考勤组
	*/
	@ApiOperation(value = "分页查询考勤组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "814224996120395701"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.OWNER_ID , value = "编码" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.WEEK , value = "周" , required = false , dataTypeClass=String.class , example = "w1"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.IS_WORK_DAY , value = "是否上班" , required = false , dataTypeClass=String.class , example = "yes"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.DAY_TYPE , value = "上班类型" , required = false , dataTypeClass=String.class , example = "day_full"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.FIRST_WORK , value = "1天1次" , required = false , dataTypeClass=String.class , example = "814851231850692608"),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.SECOND_WORK , value = "1天2次" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AttendanceTplDtlVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AttendanceTplDtlServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AttendanceTplDtlServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AttendanceTplDtl>> queryPagedList(AttendanceTplDtlVO sample) {
		
		Result<PagedList<AttendanceTplDtl>> result=new Result<>();
		PagedList<AttendanceTplDtl> list=attendanceTplDtlService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		attendanceTplDtlService.dao().fill(list)
			.with(AttendanceTplDtlMeta.FIRST_GROUP)
			.with(AttendanceTplDtlMeta.SECOND_GROUP)
			.with(AttendanceTplDtlMeta.WEEK_DICT)
			.execute();
		result.success(true).data(list);
		return result;
	}





}