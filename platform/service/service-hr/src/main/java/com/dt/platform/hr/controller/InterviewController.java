package com.dt.platform.hr.controller;

import java.util.*;

import com.dt.platform.domain.hr.PersonConfirmApply;
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


import com.dt.platform.proxy.hr.InterviewServiceProxy;
import com.dt.platform.domain.hr.meta.InterviewVOMeta;
import com.dt.platform.domain.hr.Interview;
import com.dt.platform.domain.hr.InterviewVO;
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
import com.dt.platform.domain.hr.meta.InterviewMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IInterviewService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 招聘面试接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-19 13:27:03
*/

@InDoc
@Api(tags = "招聘面试")
@RestController("HrInterviewController")
public class InterviewController extends SuperController {

	@Autowired
	private IInterviewService interviewService;

	/**
	 * 添加招聘面试
	*/
	@ApiOperation(value = "添加招聘面试")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InterviewVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.NAME , value = "标题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.INTERVIEW_DATE , value = "面试日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InterviewVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.USER_ID , value = "登记人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InterviewServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InterviewServiceProxy.INSERT)
	public Result insert(InterviewVO interviewVO) {
		
		Result result=interviewService.insert(interviewVO,false);
		return result;
	}



	/**
	 * 删除招聘面试
	*/
	@ApiOperation(value = "删除招聘面试")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InterviewVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InterviewServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InterviewServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  interviewService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=interviewService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除招聘面试 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除招聘面试")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InterviewVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = InterviewServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InterviewServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = interviewService.hasRefers(ids);
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
			Result result=interviewService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=interviewService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新招聘面试
	*/
	@ApiOperation(value = "更新招聘面试")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InterviewVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.NAME , value = "标题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.INTERVIEW_DATE , value = "面试日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InterviewVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.USER_ID , value = "登记人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { InterviewVOMeta.PAGE_INDEX , InterviewVOMeta.PAGE_SIZE , InterviewVOMeta.SEARCH_FIELD , InterviewVOMeta.FUZZY_FIELD , InterviewVOMeta.SEARCH_VALUE , InterviewVOMeta.DIRTY_FIELDS , InterviewVOMeta.SORT_FIELD , InterviewVOMeta.SORT_TYPE , InterviewVOMeta.DATA_ORIGIN , InterviewVOMeta.QUERY_LOGIC , InterviewVOMeta.REQUEST_ACTION , InterviewVOMeta.IDS } )
	@SentinelResource(value = InterviewServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InterviewServiceProxy.UPDATE)
	public Result update(InterviewVO interviewVO) {
		
		Result result=interviewService.update(interviewVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存招聘面试
	*/
	@ApiOperation(value = "保存招聘面试")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InterviewVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.NAME , value = "标题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.INTERVIEW_DATE , value = "面试日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InterviewVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.USER_ID , value = "登记人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InterviewVOMeta.PAGE_INDEX , InterviewVOMeta.PAGE_SIZE , InterviewVOMeta.SEARCH_FIELD , InterviewVOMeta.FUZZY_FIELD , InterviewVOMeta.SEARCH_VALUE , InterviewVOMeta.DIRTY_FIELDS , InterviewVOMeta.SORT_FIELD , InterviewVOMeta.SORT_TYPE , InterviewVOMeta.DATA_ORIGIN , InterviewVOMeta.QUERY_LOGIC , InterviewVOMeta.REQUEST_ACTION , InterviewVOMeta.IDS } )
	@SentinelResource(value = InterviewServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InterviewServiceProxy.SAVE)
	public Result save(InterviewVO interviewVO) {
		
		Result result=interviewService.save(interviewVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取招聘面试
	*/
	@ApiOperation(value = "获取招聘面试")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InterviewVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InterviewServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InterviewServiceProxy.GET_BY_ID)
	public Result<Interview> getById(String id) {
		
		Result<Interview> result=new Result<>();
		Interview interview=interviewService.getById(id);

		interviewService.dao().fill(interview).with(InterviewMeta.EMPLOYEE).execute();

		interviewService.dao().join(interview.getEmployee(), Person.class);

		result.success(true).data(interview);
		return result;
	}


	/**
	 * 批量获取招聘面试 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取招聘面试")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InterviewVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = InterviewServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InterviewServiceProxy.GET_BY_IDS)
	public Result<List<Interview>> getByIds(List<String> ids) {
		
		Result<List<Interview>> result=new Result<>();
		List<Interview> list=interviewService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询招聘面试
	*/
	@ApiOperation(value = "查询招聘面试")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InterviewVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.NAME , value = "标题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.INTERVIEW_DATE , value = "面试日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InterviewVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.USER_ID , value = "登记人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { InterviewVOMeta.PAGE_INDEX , InterviewVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InterviewServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InterviewServiceProxy.QUERY_LIST)
	public Result<List<Interview>> queryList(InterviewVO sample) {
		
		Result<List<Interview>> result=new Result<>();
		List<Interview> list=interviewService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询招聘面试
	*/
	@ApiOperation(value = "分页查询招聘面试")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InterviewVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.NAME , value = "标题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.INTERVIEW_DATE , value = "面试日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InterviewVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.USER_ID , value = "登记人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InterviewVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InterviewServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InterviewServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Interview>> queryPagedList(InterviewVO sample) {
		
		Result<PagedList<Interview>> result=new Result<>();
		PagedList<Interview> list=interviewService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());

		interviewService.dao().fill(list).with(InterviewMeta.EMPLOYEE).execute();

		List<Employee> employees = CollectorUtil.collectList(list, Interview::getEmployee);
		interviewService.dao().join(employees, Person.class);


		result.success(true).data(list);
		return result;
	}





}