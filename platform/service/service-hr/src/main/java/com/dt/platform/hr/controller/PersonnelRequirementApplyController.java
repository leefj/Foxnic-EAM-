package com.dt.platform.hr.controller;

import java.util.*;

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


import com.dt.platform.proxy.hr.PersonnelRequirementApplyServiceProxy;
import com.dt.platform.domain.hr.meta.PersonnelRequirementApplyVOMeta;
import com.dt.platform.domain.hr.PersonnelRequirementApply;
import com.dt.platform.domain.hr.PersonnelRequirementApplyVO;
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
import com.dt.platform.domain.hr.meta.PersonnelRequirementApplyMeta;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IPersonnelRequirementApplyService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 人员需求申请接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-19 15:59:07
*/

@InDoc
@Api(tags = "人员需求申请")
@RestController("HrPersonnelRequirementApplyController")
public class PersonnelRequirementApplyController extends SuperController implements BpmCallbackController{

	@Autowired
	private IPersonnelRequirementApplyService personnelRequirementApplyService;

	/**
	 * 添加人员需求申请
	*/
	@ApiOperation(value = "添加人员需求申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.BUSINESS_CODE , value = "流程编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.TITLE , value = "征集主题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.ORG_ID , value = "需求部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.SALARY , value = "薪酬范围" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.POS , value = "需求岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.PERSON_NUMBER , value = "需求人数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.METHOD , value = "招聘方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.SDATE , value = "开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.EDATE , value = "结束日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.JOB_REQUIREMENT , value = "岗位要求" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.WORK_CONTENT , value = "工作内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.APPLY_USER_ID , value = "申请人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.PROCESS_CODE , value = "选择流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonnelRequirementApplyServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonnelRequirementApplyServiceProxy.INSERT)
	public Result insert(PersonnelRequirementApplyVO personnelRequirementApplyVO) {
		
		Result result=personnelRequirementApplyService.insert(personnelRequirementApplyVO,false);
		return result;
	}



	/**
	 * 删除人员需求申请
	*/
	@ApiOperation(value = "删除人员需求申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonnelRequirementApplyServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonnelRequirementApplyServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  personnelRequirementApplyService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=personnelRequirementApplyService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除人员需求申请 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除人员需求申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PersonnelRequirementApplyServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonnelRequirementApplyServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = personnelRequirementApplyService.hasRefers(ids);
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
			Result result=personnelRequirementApplyService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=personnelRequirementApplyService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新人员需求申请
	*/
	@ApiOperation(value = "更新人员需求申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.BUSINESS_CODE , value = "流程编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.TITLE , value = "征集主题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.ORG_ID , value = "需求部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.SALARY , value = "薪酬范围" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.POS , value = "需求岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.PERSON_NUMBER , value = "需求人数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.METHOD , value = "招聘方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.SDATE , value = "开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.EDATE , value = "结束日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.JOB_REQUIREMENT , value = "岗位要求" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.WORK_CONTENT , value = "工作内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.APPLY_USER_ID , value = "申请人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.PROCESS_CODE , value = "选择流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonnelRequirementApplyVOMeta.PAGE_INDEX , PersonnelRequirementApplyVOMeta.PAGE_SIZE , PersonnelRequirementApplyVOMeta.SEARCH_FIELD , PersonnelRequirementApplyVOMeta.FUZZY_FIELD , PersonnelRequirementApplyVOMeta.SEARCH_VALUE , PersonnelRequirementApplyVOMeta.DIRTY_FIELDS , PersonnelRequirementApplyVOMeta.SORT_FIELD , PersonnelRequirementApplyVOMeta.SORT_TYPE , PersonnelRequirementApplyVOMeta.DATA_ORIGIN , PersonnelRequirementApplyVOMeta.QUERY_LOGIC , PersonnelRequirementApplyVOMeta.REQUEST_ACTION , PersonnelRequirementApplyVOMeta.IDS } )
	@SentinelResource(value = PersonnelRequirementApplyServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonnelRequirementApplyServiceProxy.UPDATE)
	public Result update(PersonnelRequirementApplyVO personnelRequirementApplyVO) {
		
		Result result=personnelRequirementApplyService.update(personnelRequirementApplyVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存人员需求申请
	*/
	@ApiOperation(value = "保存人员需求申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.BUSINESS_CODE , value = "流程编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.TITLE , value = "征集主题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.ORG_ID , value = "需求部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.SALARY , value = "薪酬范围" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.POS , value = "需求岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.PERSON_NUMBER , value = "需求人数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.METHOD , value = "招聘方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.SDATE , value = "开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.EDATE , value = "结束日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.JOB_REQUIREMENT , value = "岗位要求" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.WORK_CONTENT , value = "工作内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.APPLY_USER_ID , value = "申请人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.PROCESS_CODE , value = "选择流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PersonnelRequirementApplyVOMeta.PAGE_INDEX , PersonnelRequirementApplyVOMeta.PAGE_SIZE , PersonnelRequirementApplyVOMeta.SEARCH_FIELD , PersonnelRequirementApplyVOMeta.FUZZY_FIELD , PersonnelRequirementApplyVOMeta.SEARCH_VALUE , PersonnelRequirementApplyVOMeta.DIRTY_FIELDS , PersonnelRequirementApplyVOMeta.SORT_FIELD , PersonnelRequirementApplyVOMeta.SORT_TYPE , PersonnelRequirementApplyVOMeta.DATA_ORIGIN , PersonnelRequirementApplyVOMeta.QUERY_LOGIC , PersonnelRequirementApplyVOMeta.REQUEST_ACTION , PersonnelRequirementApplyVOMeta.IDS } )
	@SentinelResource(value = PersonnelRequirementApplyServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonnelRequirementApplyServiceProxy.SAVE)
	public Result save(PersonnelRequirementApplyVO personnelRequirementApplyVO) {
		
		Result result=personnelRequirementApplyService.save(personnelRequirementApplyVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取人员需求申请
	*/
	@ApiOperation(value = "获取人员需求申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonnelRequirementApplyServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonnelRequirementApplyServiceProxy.GET_BY_ID)
	public Result<PersonnelRequirementApply> getById(String id) {
		
		Result<PersonnelRequirementApply> result=new Result<>();
		PersonnelRequirementApply personnelRequirementApply=personnelRequirementApplyService.getById(id);
		// join 关联的对象
		personnelRequirementApplyService.dao().fill(personnelRequirementApply)
			.with("organization")
			.with("person")
			.execute();

		personnelRequirementApplyService.dao().join(personnelRequirementApply.getPerson(), Person.class);


		// 填充流程相关的属性
		personnelRequirementApplyService.joinProcess(personnelRequirementApply);
		result.success(true).data(personnelRequirementApply);
		return result;
	}


	/**
	 * 批量获取人员需求申请 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取人员需求申请")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PersonnelRequirementApplyServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonnelRequirementApplyServiceProxy.GET_BY_IDS)
	public Result<List<PersonnelRequirementApply>> getByIds(List<String> ids) {
		
		Result<List<PersonnelRequirementApply>> result=new Result<>();
		List<PersonnelRequirementApply> list=personnelRequirementApplyService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询人员需求申请
	*/
	@ApiOperation(value = "查询人员需求申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.BUSINESS_CODE , value = "流程编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.TITLE , value = "征集主题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.ORG_ID , value = "需求部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.SALARY , value = "薪酬范围" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.POS , value = "需求岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.PERSON_NUMBER , value = "需求人数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.METHOD , value = "招聘方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.SDATE , value = "开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.EDATE , value = "结束日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.JOB_REQUIREMENT , value = "岗位要求" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.WORK_CONTENT , value = "工作内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.APPLY_USER_ID , value = "申请人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.PROCESS_CODE , value = "选择流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonnelRequirementApplyVOMeta.PAGE_INDEX , PersonnelRequirementApplyVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PersonnelRequirementApplyServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonnelRequirementApplyServiceProxy.QUERY_LIST)
	public Result<List<PersonnelRequirementApply>> queryList(PersonnelRequirementApplyVO sample) {
		
		Result<List<PersonnelRequirementApply>> result=new Result<>();
		List<PersonnelRequirementApply> list=personnelRequirementApplyService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询人员需求申请
	*/
	@ApiOperation(value = "分页查询人员需求申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.BUSINESS_CODE , value = "流程编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.TITLE , value = "征集主题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.ORG_ID , value = "需求部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.SALARY , value = "薪酬范围" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.POS , value = "需求岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.PERSON_NUMBER , value = "需求人数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.METHOD , value = "招聘方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.SDATE , value = "开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.EDATE , value = "结束日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.JOB_REQUIREMENT , value = "岗位要求" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.WORK_CONTENT , value = "工作内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.APPLY_USER_ID , value = "申请人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.PROCESS_CODE , value = "选择流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonnelRequirementApplyVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonnelRequirementApplyServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonnelRequirementApplyServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PersonnelRequirementApply>> queryPagedList(PersonnelRequirementApplyVO sample) {
		
		Result<PagedList<PersonnelRequirementApply>> result=new Result<>();
		PagedList<PersonnelRequirementApply> list=personnelRequirementApplyService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		personnelRequirementApplyService.dao().fill(list)
			.with("organization")
			.with("person")
			.execute();
		// 填充流程相关的属性

		List<Employee> employees = CollectorUtil.collectList(list, PersonnelRequirementApply::getPerson);
		personnelRequirementApplyService.dao().join(employees, Person.class);

		personnelRequirementApplyService.joinProcess(list);
		result.success(true).data(list);
		return result;
	}


	/**
     *  流程回调处理
     */
	@SentinelResource(value = PersonnelRequirementApplyServiceProxy.BPM_CALLBACK , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonnelRequirementApplyServiceProxy.BPM_CALLBACK)
    public BpmActionResult onProcessCallback(BpmEvent event){
		
		return personnelRequirementApplyService.onProcessCallback(event);
	}



}