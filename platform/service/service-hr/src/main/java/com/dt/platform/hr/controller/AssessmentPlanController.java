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


import com.dt.platform.proxy.hr.AssessmentPlanServiceProxy;
import com.dt.platform.domain.hr.meta.AssessmentPlanVOMeta;
import com.dt.platform.domain.hr.AssessmentPlan;
import com.dt.platform.domain.hr.AssessmentPlanVO;
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
import com.dt.platform.domain.hr.meta.AssessmentPlanMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.hr.AssessmentTpl;
import com.dt.platform.domain.hr.AssessmentIndicator;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IAssessmentPlanService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 考核计划接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-04 07:40:30
*/

@InDoc
@Api(tags = "考核计划")
@RestController("HrAssessmentPlanController")
public class AssessmentPlanController extends SuperController implements BpmCallbackController{

	@Autowired
	private IAssessmentPlanService assessmentPlanService;

	/**
	 * 添加考核计划
	*/
	@ApiOperation(value = "添加考核计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.NAME , value = "考核名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.POS_ID , value = "岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.CYCLE , value = "周期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.METHOD , value = "考核方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.ASSESSEE_ID , value = "被考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.ASSESSOR_ID , value = "考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.ASSESSOR_SECOND_ID , value = "二级考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.TOTAL_WEIGHT , value = "指标总权重" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.TPL_ID , value = "考勤模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssessmentPlanServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentPlanServiceProxy.INSERT)
	public Result insert(AssessmentPlanVO assessmentPlanVO) {
		
		Result result=assessmentPlanService.insert(assessmentPlanVO,false);
		return result;
	}



	/**
	 * 删除考核计划
	*/
	@ApiOperation(value = "删除考核计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssessmentPlanServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentPlanServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  assessmentPlanService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=assessmentPlanService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除考核计划 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除考核计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentPlanVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AssessmentPlanServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentPlanServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = assessmentPlanService.hasRefers(ids);
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
			Result result=assessmentPlanService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=assessmentPlanService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新考核计划
	*/
	@ApiOperation(value = "更新考核计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.NAME , value = "考核名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.POS_ID , value = "岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.CYCLE , value = "周期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.METHOD , value = "考核方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.ASSESSEE_ID , value = "被考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.ASSESSOR_ID , value = "考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.ASSESSOR_SECOND_ID , value = "二级考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.TOTAL_WEIGHT , value = "指标总权重" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.TPL_ID , value = "考勤模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssessmentPlanVOMeta.PAGE_INDEX , AssessmentPlanVOMeta.PAGE_SIZE , AssessmentPlanVOMeta.SEARCH_FIELD , AssessmentPlanVOMeta.FUZZY_FIELD , AssessmentPlanVOMeta.SEARCH_VALUE , AssessmentPlanVOMeta.DIRTY_FIELDS , AssessmentPlanVOMeta.SORT_FIELD , AssessmentPlanVOMeta.SORT_TYPE , AssessmentPlanVOMeta.DATA_ORIGIN , AssessmentPlanVOMeta.QUERY_LOGIC , AssessmentPlanVOMeta.REQUEST_ACTION , AssessmentPlanVOMeta.IDS } )
	@SentinelResource(value = AssessmentPlanServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentPlanServiceProxy.UPDATE)
	public Result update(AssessmentPlanVO assessmentPlanVO) {
		
		Result result=assessmentPlanService.update(assessmentPlanVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存考核计划
	*/
	@ApiOperation(value = "保存考核计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.NAME , value = "考核名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.POS_ID , value = "岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.CYCLE , value = "周期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.METHOD , value = "考核方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.ASSESSEE_ID , value = "被考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.ASSESSOR_ID , value = "考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.ASSESSOR_SECOND_ID , value = "二级考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.TOTAL_WEIGHT , value = "指标总权重" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.TPL_ID , value = "考勤模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssessmentPlanVOMeta.PAGE_INDEX , AssessmentPlanVOMeta.PAGE_SIZE , AssessmentPlanVOMeta.SEARCH_FIELD , AssessmentPlanVOMeta.FUZZY_FIELD , AssessmentPlanVOMeta.SEARCH_VALUE , AssessmentPlanVOMeta.DIRTY_FIELDS , AssessmentPlanVOMeta.SORT_FIELD , AssessmentPlanVOMeta.SORT_TYPE , AssessmentPlanVOMeta.DATA_ORIGIN , AssessmentPlanVOMeta.QUERY_LOGIC , AssessmentPlanVOMeta.REQUEST_ACTION , AssessmentPlanVOMeta.IDS } )
	@SentinelResource(value = AssessmentPlanServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentPlanServiceProxy.SAVE)
	public Result save(AssessmentPlanVO assessmentPlanVO) {
		
		Result result=assessmentPlanService.save(assessmentPlanVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取考核计划
	*/
	@ApiOperation(value = "获取考核计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssessmentPlanServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentPlanServiceProxy.GET_BY_ID)
	public Result<AssessmentPlan> getById(String id) {
		
		Result<AssessmentPlan> result=new Result<>();
		AssessmentPlan assessmentPlan=assessmentPlanService.getById(id);
		// join 关联的对象
		assessmentPlanService.dao().fill(assessmentPlan)
			.with("assessorUser")
			.with("assesseeUser")
			.with(AssessmentPlanMeta.ASSESSMENT_TPL)
			.execute();
		// 填充流程相关的属性
		assessmentPlanService.joinProcess(assessmentPlan);
		result.success(true).data(assessmentPlan);
		return result;
	}


	/**
	 * 批量获取考核计划 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取考核计划")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssessmentPlanVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AssessmentPlanServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentPlanServiceProxy.GET_BY_IDS)
	public Result<List<AssessmentPlan>> getByIds(List<String> ids) {
		
		Result<List<AssessmentPlan>> result=new Result<>();
		List<AssessmentPlan> list=assessmentPlanService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询考核计划
	*/
	@ApiOperation(value = "查询考核计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.NAME , value = "考核名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.POS_ID , value = "岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.CYCLE , value = "周期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.METHOD , value = "考核方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.ASSESSEE_ID , value = "被考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.ASSESSOR_ID , value = "考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.ASSESSOR_SECOND_ID , value = "二级考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.TOTAL_WEIGHT , value = "指标总权重" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.TPL_ID , value = "考勤模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssessmentPlanVOMeta.PAGE_INDEX , AssessmentPlanVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssessmentPlanServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentPlanServiceProxy.QUERY_LIST)
	public Result<List<AssessmentPlan>> queryList(AssessmentPlanVO sample) {
		
		Result<List<AssessmentPlan>> result=new Result<>();
		List<AssessmentPlan> list=assessmentPlanService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询考核计划
	*/
	@ApiOperation(value = "分页查询考核计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.BUSINESS_CODE , value = "编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.NAME , value = "考核名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.POS_ID , value = "岗位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.CYCLE , value = "周期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.METHOD , value = "考核方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.ASSESSEE_ID , value = "被考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.ASSESSOR_ID , value = "考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.ASSESSOR_SECOND_ID , value = "二级考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.TOTAL_WEIGHT , value = "指标总权重" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.TPL_ID , value = "考勤模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentPlanVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssessmentPlanServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentPlanServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssessmentPlan>> queryPagedList(AssessmentPlanVO sample) {
		
		Result<PagedList<AssessmentPlan>> result=new Result<>();
		PagedList<AssessmentPlan> list=assessmentPlanService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		assessmentPlanService.dao().fill(list)
			.with("assessorUser")
			.with("assesseeUser")
			.with(AssessmentPlanMeta.ASSESSMENT_TPL)
			.execute();
		// 填充流程相关的属性
		assessmentPlanService.joinProcess(list);
		result.success(true).data(list);
		return result;
	}


	/**
     *  流程回调处理
     */
	@SentinelResource(value = AssessmentPlanServiceProxy.BPM_CALLBACK , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentPlanServiceProxy.BPM_CALLBACK)
    public BpmActionResult onProcessCallback(BpmEvent event){
		
		return assessmentPlanService.onProcessCallback(event);
	}



}