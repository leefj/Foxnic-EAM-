package com.dt.platform.hr.controller;

import java.util.*;

import com.dt.platform.domain.hr.PersonnelRequirementApply;
import org.github.foxnic.web.domain.hrm.Person;
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


import com.dt.platform.proxy.hr.RecruitmentPlanApplyServiceProxy;
import com.dt.platform.domain.hr.meta.RecruitmentPlanApplyVOMeta;
import com.dt.platform.domain.hr.RecruitmentPlanApply;
import com.dt.platform.domain.hr.RecruitmentPlanApplyVO;
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
import com.dt.platform.domain.hr.meta.RecruitmentPlanApplyMeta;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IRecruitmentPlanApplyService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 招聘计划申请接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-19 15:58:49
*/

@InDoc
@Api(tags = "招聘计划申请")
@RestController("HrRecruitmentPlanApplyController")
public class RecruitmentPlanApplyController extends SuperController implements BpmCallbackController{

	@Autowired
	private IRecruitmentPlanApplyService recruitmentPlanApplyService;

	/**
	 * 添加招聘计划申请
	*/
	@ApiOperation(value = "添加招聘计划申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.BUSINESS_CODE , value = "流程编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.TITLE , value = "招聘主题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.ORG_ID , value = "招聘部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.SALARY , value = "薪酬范围" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.POS , value = "招聘岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.PERSON_NUMBER , value = "招聘人数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.METHOD , value = "招聘方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.SDATE , value = "开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.EDATE , value = "结束日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.JOB_REQUIREMENT , value = "岗位要求" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.WORK_CONTENT , value = "工作内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.NOTES , value = "工作内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.APPLY_USER_ID , value = "申请人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.PROCESS_CODE , value = "选择流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RecruitmentPlanApplyServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecruitmentPlanApplyServiceProxy.INSERT)
	public Result insert(RecruitmentPlanApplyVO recruitmentPlanApplyVO) {
		
		Result result=recruitmentPlanApplyService.insert(recruitmentPlanApplyVO,false);
		return result;
	}



	/**
	 * 删除招聘计划申请
	*/
	@ApiOperation(value = "删除招聘计划申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RecruitmentPlanApplyServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecruitmentPlanApplyServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  recruitmentPlanApplyService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=recruitmentPlanApplyService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除招聘计划申请 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除招聘计划申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = RecruitmentPlanApplyServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecruitmentPlanApplyServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = recruitmentPlanApplyService.hasRefers(ids);
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
			Result result=recruitmentPlanApplyService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=recruitmentPlanApplyService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新招聘计划申请
	*/
	@ApiOperation(value = "更新招聘计划申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.BUSINESS_CODE , value = "流程编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.TITLE , value = "招聘主题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.ORG_ID , value = "招聘部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.SALARY , value = "薪酬范围" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.POS , value = "招聘岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.PERSON_NUMBER , value = "招聘人数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.METHOD , value = "招聘方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.SDATE , value = "开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.EDATE , value = "结束日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.JOB_REQUIREMENT , value = "岗位要求" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.WORK_CONTENT , value = "工作内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.NOTES , value = "工作内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.APPLY_USER_ID , value = "申请人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.PROCESS_CODE , value = "选择流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { RecruitmentPlanApplyVOMeta.PAGE_INDEX , RecruitmentPlanApplyVOMeta.PAGE_SIZE , RecruitmentPlanApplyVOMeta.SEARCH_FIELD , RecruitmentPlanApplyVOMeta.FUZZY_FIELD , RecruitmentPlanApplyVOMeta.SEARCH_VALUE , RecruitmentPlanApplyVOMeta.DIRTY_FIELDS , RecruitmentPlanApplyVOMeta.SORT_FIELD , RecruitmentPlanApplyVOMeta.SORT_TYPE , RecruitmentPlanApplyVOMeta.DATA_ORIGIN , RecruitmentPlanApplyVOMeta.QUERY_LOGIC , RecruitmentPlanApplyVOMeta.REQUEST_ACTION , RecruitmentPlanApplyVOMeta.IDS } )
	@SentinelResource(value = RecruitmentPlanApplyServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecruitmentPlanApplyServiceProxy.UPDATE)
	public Result update(RecruitmentPlanApplyVO recruitmentPlanApplyVO) {
		
		Result result=recruitmentPlanApplyService.update(recruitmentPlanApplyVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存招聘计划申请
	*/
	@ApiOperation(value = "保存招聘计划申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.BUSINESS_CODE , value = "流程编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.TITLE , value = "招聘主题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.ORG_ID , value = "招聘部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.SALARY , value = "薪酬范围" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.POS , value = "招聘岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.PERSON_NUMBER , value = "招聘人数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.METHOD , value = "招聘方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.SDATE , value = "开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.EDATE , value = "结束日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.JOB_REQUIREMENT , value = "岗位要求" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.WORK_CONTENT , value = "工作内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.NOTES , value = "工作内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.APPLY_USER_ID , value = "申请人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.PROCESS_CODE , value = "选择流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RecruitmentPlanApplyVOMeta.PAGE_INDEX , RecruitmentPlanApplyVOMeta.PAGE_SIZE , RecruitmentPlanApplyVOMeta.SEARCH_FIELD , RecruitmentPlanApplyVOMeta.FUZZY_FIELD , RecruitmentPlanApplyVOMeta.SEARCH_VALUE , RecruitmentPlanApplyVOMeta.DIRTY_FIELDS , RecruitmentPlanApplyVOMeta.SORT_FIELD , RecruitmentPlanApplyVOMeta.SORT_TYPE , RecruitmentPlanApplyVOMeta.DATA_ORIGIN , RecruitmentPlanApplyVOMeta.QUERY_LOGIC , RecruitmentPlanApplyVOMeta.REQUEST_ACTION , RecruitmentPlanApplyVOMeta.IDS } )
	@SentinelResource(value = RecruitmentPlanApplyServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecruitmentPlanApplyServiceProxy.SAVE)
	public Result save(RecruitmentPlanApplyVO recruitmentPlanApplyVO) {
		
		Result result=recruitmentPlanApplyService.save(recruitmentPlanApplyVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取招聘计划申请
	*/
	@ApiOperation(value = "获取招聘计划申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RecruitmentPlanApplyServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecruitmentPlanApplyServiceProxy.GET_BY_ID)
	public Result<RecruitmentPlanApply> getById(String id) {
		
		Result<RecruitmentPlanApply> result=new Result<>();
		RecruitmentPlanApply recruitmentPlanApply=recruitmentPlanApplyService.getById(id);
		// join 关联的对象
		recruitmentPlanApplyService.dao().fill(recruitmentPlanApply)
			.with("organization")
			.with("person")
			.execute();

		recruitmentPlanApplyService.dao().join(recruitmentPlanApply.getPerson(), Person.class);

		// 填充流程相关的属性
		recruitmentPlanApplyService.joinProcess(recruitmentPlanApply);
		result.success(true).data(recruitmentPlanApply);
		return result;
	}


	/**
	 * 批量获取招聘计划申请 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取招聘计划申请")
		@ApiImplicitParams({
				@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = RecruitmentPlanApplyServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecruitmentPlanApplyServiceProxy.GET_BY_IDS)
	public Result<List<RecruitmentPlanApply>> getByIds(List<String> ids) {
		
		Result<List<RecruitmentPlanApply>> result=new Result<>();
		List<RecruitmentPlanApply> list=recruitmentPlanApplyService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询招聘计划申请
	*/
	@ApiOperation(value = "查询招聘计划申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.BUSINESS_CODE , value = "流程编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.TITLE , value = "招聘主题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.ORG_ID , value = "招聘部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.SALARY , value = "薪酬范围" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.POS , value = "招聘岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.PERSON_NUMBER , value = "招聘人数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.METHOD , value = "招聘方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.SDATE , value = "开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.EDATE , value = "结束日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.JOB_REQUIREMENT , value = "岗位要求" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.WORK_CONTENT , value = "工作内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.NOTES , value = "工作内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.APPLY_USER_ID , value = "申请人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.PROCESS_CODE , value = "选择流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { RecruitmentPlanApplyVOMeta.PAGE_INDEX , RecruitmentPlanApplyVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RecruitmentPlanApplyServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecruitmentPlanApplyServiceProxy.QUERY_LIST)
	public Result<List<RecruitmentPlanApply>> queryList(RecruitmentPlanApplyVO sample) {
		
		Result<List<RecruitmentPlanApply>> result=new Result<>();
		List<RecruitmentPlanApply> list=recruitmentPlanApplyService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询招聘计划申请
	*/
	@ApiOperation(value = "分页查询招聘计划申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.BUSINESS_CODE , value = "流程编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.TITLE , value = "招聘主题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.ORG_ID , value = "招聘部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.SALARY , value = "薪酬范围" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.POS , value = "招聘岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.PERSON_NUMBER , value = "招聘人数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.METHOD , value = "招聘方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.SDATE , value = "开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.EDATE , value = "结束日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.JOB_REQUIREMENT , value = "岗位要求" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.WORK_CONTENT , value = "工作内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.NOTES , value = "工作内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.APPLY_USER_ID , value = "申请人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.PROCESS_CODE , value = "选择流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitmentPlanApplyVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RecruitmentPlanApplyServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecruitmentPlanApplyServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<RecruitmentPlanApply>> queryPagedList(RecruitmentPlanApplyVO sample) {
		
		Result<PagedList<RecruitmentPlanApply>> result=new Result<>();
		PagedList<RecruitmentPlanApply> list=recruitmentPlanApplyService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		recruitmentPlanApplyService.dao().fill(list)
			.with("organization")
			.with("person")
			.execute();

		List<Employee> employees = CollectorUtil.collectList(list, RecruitmentPlanApply::getPerson);
		recruitmentPlanApplyService.dao().join(employees, Person.class);


		// 填充流程相关的属性
		recruitmentPlanApplyService.joinProcess(list);
		result.success(true).data(list);
		return result;
	}


	/**
     *  流程回调处理
     */
	@SentinelResource(value = RecruitmentPlanApplyServiceProxy.BPM_CALLBACK , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecruitmentPlanApplyServiceProxy.BPM_CALLBACK)
    public BpmActionResult onProcessCallback(BpmEvent event){
		
		return recruitmentPlanApplyService.onProcessCallback(event);
	}



}