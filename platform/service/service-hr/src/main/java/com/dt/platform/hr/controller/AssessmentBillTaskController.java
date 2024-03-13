package com.dt.platform.hr.controller;

import java.util.*;


import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.sql.expr.ConditionExpr;
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


import com.dt.platform.proxy.hr.AssessmentBillTaskServiceProxy;
import com.dt.platform.domain.hr.meta.AssessmentBillTaskVOMeta;
import com.dt.platform.domain.hr.AssessmentBillTask;
import com.dt.platform.domain.hr.AssessmentBillTaskVO;
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
import com.dt.platform.domain.hr.meta.AssessmentBillTaskMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.hr.AssessmentTask;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IAssessmentBillTaskService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 单据任务接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-11 15:13:19
*/

@InDoc
@Api(tags = "单据任务")
@RestController("HrAssessmentBillTaskController")
public class AssessmentBillTaskController extends SuperController {

	@Autowired
	private IAssessmentBillTaskService assessmentBillTaskService;

	/**
	 * 添加单据任务
	*/
	@ApiOperation(value = "添加单据任务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.BILL_ID , value = "单据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.ASSESSOR_ID , value = "考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.RCD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssessmentBillTaskServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentBillTaskServiceProxy.INSERT)
	public Result insert(AssessmentBillTaskVO assessmentBillTaskVO) {
		
		Result result=assessmentBillTaskService.insert(assessmentBillTaskVO,false);
		return result;
	}



	/**
	 * 删除单据任务
	*/
	@ApiOperation(value = "删除单据任务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssessmentBillTaskServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentBillTaskServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  assessmentBillTaskService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=assessmentBillTaskService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除单据任务 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除单据任务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AssessmentBillTaskServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentBillTaskServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = assessmentBillTaskService.hasRefers(ids);
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
			Result result=assessmentBillTaskService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=assessmentBillTaskService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新单据任务
	*/
	@ApiOperation(value = "更新单据任务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.BILL_ID , value = "单据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.ASSESSOR_ID , value = "考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.RCD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssessmentBillTaskVOMeta.PAGE_INDEX , AssessmentBillTaskVOMeta.PAGE_SIZE , AssessmentBillTaskVOMeta.SEARCH_FIELD , AssessmentBillTaskVOMeta.FUZZY_FIELD , AssessmentBillTaskVOMeta.SEARCH_VALUE , AssessmentBillTaskVOMeta.DIRTY_FIELDS , AssessmentBillTaskVOMeta.SORT_FIELD , AssessmentBillTaskVOMeta.SORT_TYPE , AssessmentBillTaskVOMeta.DATA_ORIGIN , AssessmentBillTaskVOMeta.QUERY_LOGIC , AssessmentBillTaskVOMeta.REQUEST_ACTION , AssessmentBillTaskVOMeta.IDS } )
	@SentinelResource(value = AssessmentBillTaskServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentBillTaskServiceProxy.UPDATE)
	public Result update(AssessmentBillTaskVO assessmentBillTaskVO) {
		
		Result result=assessmentBillTaskService.update(assessmentBillTaskVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存单据任务
	*/
	@ApiOperation(value = "保存单据任务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.BILL_ID , value = "单据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.ASSESSOR_ID , value = "考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.RCD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssessmentBillTaskVOMeta.PAGE_INDEX , AssessmentBillTaskVOMeta.PAGE_SIZE , AssessmentBillTaskVOMeta.SEARCH_FIELD , AssessmentBillTaskVOMeta.FUZZY_FIELD , AssessmentBillTaskVOMeta.SEARCH_VALUE , AssessmentBillTaskVOMeta.DIRTY_FIELDS , AssessmentBillTaskVOMeta.SORT_FIELD , AssessmentBillTaskVOMeta.SORT_TYPE , AssessmentBillTaskVOMeta.DATA_ORIGIN , AssessmentBillTaskVOMeta.QUERY_LOGIC , AssessmentBillTaskVOMeta.REQUEST_ACTION , AssessmentBillTaskVOMeta.IDS } )
	@SentinelResource(value = AssessmentBillTaskServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentBillTaskServiceProxy.SAVE)
	public Result save(AssessmentBillTaskVO assessmentBillTaskVO) {
		
		Result result=assessmentBillTaskService.save(assessmentBillTaskVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取单据任务
	*/
	@ApiOperation(value = "获取单据任务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssessmentBillTaskServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentBillTaskServiceProxy.GET_BY_ID)
	public Result<AssessmentBillTask> getById(String id) {
		
		Result<AssessmentBillTask> result=new Result<>();
		AssessmentBillTask assessmentBillTask=assessmentBillTaskService.getById(id);


		// join 关联的对象
		assessmentBillTaskService.dao().fill(assessmentBillTask)
				.with(AssessmentBillTaskMeta.ASSESSOR)
				.with(AssessmentBillTaskMeta.ASSESSMENT_BILL)
				.with(AssessmentBillTaskMeta.ASSESSMENT_BILL_TASK_DTL_LIST)
				.execute();
		result.success(true).data(assessmentBillTask);

		return result;
	}


	/**
	 * 批量获取单据任务 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取单据任务")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssessmentBillTaskVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AssessmentBillTaskServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentBillTaskServiceProxy.GET_BY_IDS)
	public Result<List<AssessmentBillTask>> getByIds(List<String> ids) {
		
		Result<List<AssessmentBillTask>> result=new Result<>();
		List<AssessmentBillTask> list=assessmentBillTaskService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询单据任务
	*/
	@ApiOperation(value = "查询单据任务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.BILL_ID , value = "单据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.ASSESSOR_ID , value = "考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.RCD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssessmentBillTaskVOMeta.PAGE_INDEX , AssessmentBillTaskVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssessmentBillTaskServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentBillTaskServiceProxy.QUERY_LIST)
	public Result<List<AssessmentBillTask>> queryList(AssessmentBillTaskVO sample) {
		
		Result<List<AssessmentBillTask>> result=new Result<>();
		List<AssessmentBillTask> list=assessmentBillTaskService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询单据任务
	*/
	@ApiOperation(value = "分页查询单据任务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.BILL_ID , value = "单据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.ASSESSOR_ID , value = "考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.RCD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssessmentBillTaskVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssessmentBillTaskServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentBillTaskServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssessmentBillTask>> queryPagedList(AssessmentBillTaskVO sample) {
		
		Result<PagedList<AssessmentBillTask>> result=new Result<>();
		ConditionExpr expr = new ConditionExpr();
		expr.and("1=1");
		if (!StringUtil.isBlank(sample.getSOrgId())) {
			expr.and("assessor_id in (select distinct b.employee_id from hrm_position a,hrm_employee_position b where a.id=b.position_id and a.deleted=0 and b.deleted=0 and a.org_id in  (select id from hrm_organization where deleted=0 and type in ('com','dept') and (concat('/',hierarchy) like '%/" + sample.getSOrgId() + "/%' or id=?)))", sample.getSOrgId());
		}

		PagedList<AssessmentBillTask> list=assessmentBillTaskService.queryPagedList(sample,expr,sample.getPageSize(),sample.getPageIndex());

		// join 关联的对象
		assessmentBillTaskService.dao().fill(list)
			.with(AssessmentBillTaskMeta.ASSESSOR)
				.with(AssessmentBillTaskMeta.ASSESSMENT_BILL)
				.with(AssessmentBillTaskMeta.ASSESSMENT_BILL_TASK_DTL_LIST)
			.execute();
		result.success(true).data(list);


		List<Employee> employeeList = CollectorUtil.collectList(list, AssessmentBillTask::getAssessor);
		assessmentBillTaskService.dao().join(employeeList, Person.class);

		return result;
	}





}