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
import org.github.foxnic.web.proxy.bpm.BpmCallbackController;
import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;


import com.dt.platform.proxy.hr.PersonAbsenceApplyServiceProxy;
import com.dt.platform.domain.hr.meta.PersonAbsenceApplyVOMeta;
import com.dt.platform.domain.hr.PersonAbsenceApply;
import com.dt.platform.domain.hr.PersonAbsenceApplyVO;
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
import com.dt.platform.domain.hr.meta.PersonAbsenceApplyMeta;
import org.github.foxnic.web.domain.hrm.Person;
import com.dt.platform.domain.hr.AttendanceType;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IPersonAbsenceApplyService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 请假申请接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-13 21:44:06
*/

@InDoc
@Api(tags = "请假申请")
@RestController("HrPersonAbsenceApplyController")
public class PersonAbsenceApplyController extends SuperController implements BpmCallbackController{

	@Autowired
	private IPersonAbsenceApplyService personAbsenceApplyService;

	/**
	 * 添加请假申请
	*/
	@ApiOperation(value = "添加请假申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.APPLY_TYPE , value = "请假类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.PERSON_ID , value = "申请人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.APPLY_S_DATE , value = "开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.APPLY_E_DATE , value = "结束日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.FILE_IDS , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonAbsenceApplyServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonAbsenceApplyServiceProxy.INSERT)
	public Result insert(PersonAbsenceApplyVO personAbsenceApplyVO) {
		
		Result result=personAbsenceApplyService.insert(personAbsenceApplyVO,false);
		return result;
	}



	/**
	 * 删除请假申请
	*/
	@ApiOperation(value = "删除请假申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonAbsenceApplyServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonAbsenceApplyServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  personAbsenceApplyService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=personAbsenceApplyService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除请假申请 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除请假申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PersonAbsenceApplyServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonAbsenceApplyServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = personAbsenceApplyService.hasRefers(ids);
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
			Result result=personAbsenceApplyService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=personAbsenceApplyService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新请假申请
	*/
	@ApiOperation(value = "更新请假申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.APPLY_TYPE , value = "请假类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.PERSON_ID , value = "申请人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.APPLY_S_DATE , value = "开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.APPLY_E_DATE , value = "结束日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.FILE_IDS , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonAbsenceApplyVOMeta.PAGE_INDEX , PersonAbsenceApplyVOMeta.PAGE_SIZE , PersonAbsenceApplyVOMeta.SEARCH_FIELD , PersonAbsenceApplyVOMeta.FUZZY_FIELD , PersonAbsenceApplyVOMeta.SEARCH_VALUE , PersonAbsenceApplyVOMeta.DIRTY_FIELDS , PersonAbsenceApplyVOMeta.SORT_FIELD , PersonAbsenceApplyVOMeta.SORT_TYPE , PersonAbsenceApplyVOMeta.DATA_ORIGIN , PersonAbsenceApplyVOMeta.QUERY_LOGIC , PersonAbsenceApplyVOMeta.REQUEST_ACTION , PersonAbsenceApplyVOMeta.IDS } )
	@SentinelResource(value = PersonAbsenceApplyServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonAbsenceApplyServiceProxy.UPDATE)
	public Result update(PersonAbsenceApplyVO personAbsenceApplyVO) {
		
		Result result=personAbsenceApplyService.update(personAbsenceApplyVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存请假申请
	*/
	@ApiOperation(value = "保存请假申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.APPLY_TYPE , value = "请假类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.PERSON_ID , value = "申请人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.APPLY_S_DATE , value = "开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.APPLY_E_DATE , value = "结束日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.FILE_IDS , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PersonAbsenceApplyVOMeta.PAGE_INDEX , PersonAbsenceApplyVOMeta.PAGE_SIZE , PersonAbsenceApplyVOMeta.SEARCH_FIELD , PersonAbsenceApplyVOMeta.FUZZY_FIELD , PersonAbsenceApplyVOMeta.SEARCH_VALUE , PersonAbsenceApplyVOMeta.DIRTY_FIELDS , PersonAbsenceApplyVOMeta.SORT_FIELD , PersonAbsenceApplyVOMeta.SORT_TYPE , PersonAbsenceApplyVOMeta.DATA_ORIGIN , PersonAbsenceApplyVOMeta.QUERY_LOGIC , PersonAbsenceApplyVOMeta.REQUEST_ACTION , PersonAbsenceApplyVOMeta.IDS } )
	@SentinelResource(value = PersonAbsenceApplyServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonAbsenceApplyServiceProxy.SAVE)
	public Result save(PersonAbsenceApplyVO personAbsenceApplyVO) {
		
		Result result=personAbsenceApplyService.save(personAbsenceApplyVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取请假申请
	*/
	@ApiOperation(value = "获取请假申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonAbsenceApplyServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonAbsenceApplyServiceProxy.GET_BY_ID)
	public Result<PersonAbsenceApply> getById(String id) {
		
		Result<PersonAbsenceApply> result=new Result<>();
		PersonAbsenceApply personAbsenceApply=personAbsenceApplyService.getById(id);
		// join 关联的对象
		personAbsenceApplyService.dao().fill(personAbsenceApply)
			.with("person")
			.with(PersonAbsenceApplyMeta.ATTENDANCE_TYPE)
			.execute();
		// 填充流程相关的属性
		personAbsenceApplyService.joinProcess(personAbsenceApply);
		result.success(true).data(personAbsenceApply);
		return result;
	}


	/**
	 * 批量获取请假申请 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取请假申请")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PersonAbsenceApplyServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonAbsenceApplyServiceProxy.GET_BY_IDS)
	public Result<List<PersonAbsenceApply>> getByIds(List<String> ids) {
		
		Result<List<PersonAbsenceApply>> result=new Result<>();
		List<PersonAbsenceApply> list=personAbsenceApplyService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询请假申请
	*/
	@ApiOperation(value = "查询请假申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.APPLY_TYPE , value = "请假类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.PERSON_ID , value = "申请人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.APPLY_S_DATE , value = "开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.APPLY_E_DATE , value = "结束日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.FILE_IDS , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonAbsenceApplyVOMeta.PAGE_INDEX , PersonAbsenceApplyVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PersonAbsenceApplyServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonAbsenceApplyServiceProxy.QUERY_LIST)
	public Result<List<PersonAbsenceApply>> queryList(PersonAbsenceApplyVO sample) {
		
		Result<List<PersonAbsenceApply>> result=new Result<>();
		List<PersonAbsenceApply> list=personAbsenceApplyService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询请假申请
	*/
	@ApiOperation(value = "分页查询请假申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.APPLY_TYPE , value = "请假类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.PERSON_ID , value = "申请人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.APPLY_S_DATE , value = "开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.APPLY_E_DATE , value = "结束日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.FILE_IDS , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonAbsenceApplyVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonAbsenceApplyServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonAbsenceApplyServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PersonAbsenceApply>> queryPagedList(PersonAbsenceApplyVO sample) {
		
		Result<PagedList<PersonAbsenceApply>> result=new Result<>();
		PagedList<PersonAbsenceApply> list=personAbsenceApplyService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		personAbsenceApplyService.dao().fill(list)
			.with("person")
			.with(PersonAbsenceApplyMeta.ATTENDANCE_TYPE)
			.execute();
		// 填充流程相关的属性
		personAbsenceApplyService.joinProcess(list);
		result.success(true).data(list);
		return result;
	}


	/**
     *  流程回调处理
     */
	@SentinelResource(value = PersonAbsenceApplyServiceProxy.BPM_CALLBACK , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonAbsenceApplyServiceProxy.BPM_CALLBACK)
    public BpmActionResult onProcessCallback(BpmEvent event){
		
		return personAbsenceApplyService.onProcessCallback(event);
	}



}