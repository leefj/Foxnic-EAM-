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


import com.dt.platform.proxy.hr.AssessmentTaskDtlServiceProxy;
import com.dt.platform.domain.hr.meta.AssessmentTaskDtlVOMeta;
import com.dt.platform.domain.hr.AssessmentTaskDtl;
import com.dt.platform.domain.hr.AssessmentTaskDtlVO;
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
import com.dt.platform.domain.hr.meta.AssessmentTaskDtlMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.hr.AssessmentIndicator;
import com.dt.platform.domain.hr.Position;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IAssessmentTaskDtlService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 考核任务单接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-02 16:13:19
*/

@InDoc
@Api(tags = "考核任务单")
@RestController("HrAssessmentTaskDtlController")
public class AssessmentTaskDtlController extends SuperController {

	@Autowired
	private IAssessmentTaskDtlService assessmentTaskDtlService;

	/**
	 * 添加考核任务单
	*/
	@ApiOperation(value = "添加考核任务单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.TASK_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.ASSESSEE_ID , value = "被考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.ASSESSOR_ID , value = "考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.SCORE_VALUE , value = "得分" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.EVALUATE_CONTENT , value = "综合评价" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.RCD_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssessmentTaskDtlServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentTaskDtlServiceProxy.INSERT)
	public Result insert(AssessmentTaskDtlVO assessmentTaskDtlVO) {
		
		Result result=assessmentTaskDtlService.insert(assessmentTaskDtlVO,false);
		return result;
	}



	/**
	 * 删除考核任务单
	*/
	@ApiOperation(value = "删除考核任务单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssessmentTaskDtlServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentTaskDtlServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  assessmentTaskDtlService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=assessmentTaskDtlService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除考核任务单 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除考核任务单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AssessmentTaskDtlServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentTaskDtlServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = assessmentTaskDtlService.hasRefers(ids);
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
			Result result=assessmentTaskDtlService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=assessmentTaskDtlService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新考核任务单
	*/
	@ApiOperation(value = "更新考核任务单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.TASK_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.ASSESSEE_ID , value = "被考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.ASSESSOR_ID , value = "考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.SCORE_VALUE , value = "得分" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.EVALUATE_CONTENT , value = "综合评价" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.RCD_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssessmentTaskDtlVOMeta.PAGE_INDEX , AssessmentTaskDtlVOMeta.PAGE_SIZE , AssessmentTaskDtlVOMeta.SEARCH_FIELD , AssessmentTaskDtlVOMeta.FUZZY_FIELD , AssessmentTaskDtlVOMeta.SEARCH_VALUE , AssessmentTaskDtlVOMeta.DIRTY_FIELDS , AssessmentTaskDtlVOMeta.SORT_FIELD , AssessmentTaskDtlVOMeta.SORT_TYPE , AssessmentTaskDtlVOMeta.DATA_ORIGIN , AssessmentTaskDtlVOMeta.QUERY_LOGIC , AssessmentTaskDtlVOMeta.REQUEST_ACTION , AssessmentTaskDtlVOMeta.IDS } )
	@SentinelResource(value = AssessmentTaskDtlServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentTaskDtlServiceProxy.UPDATE)
	public Result update(AssessmentTaskDtlVO assessmentTaskDtlVO) {
		
		Result result=assessmentTaskDtlService.update(assessmentTaskDtlVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存考核任务单
	*/
	@ApiOperation(value = "保存考核任务单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.TASK_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.ASSESSEE_ID , value = "被考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.ASSESSOR_ID , value = "考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.SCORE_VALUE , value = "得分" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.EVALUATE_CONTENT , value = "综合评价" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.RCD_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssessmentTaskDtlVOMeta.PAGE_INDEX , AssessmentTaskDtlVOMeta.PAGE_SIZE , AssessmentTaskDtlVOMeta.SEARCH_FIELD , AssessmentTaskDtlVOMeta.FUZZY_FIELD , AssessmentTaskDtlVOMeta.SEARCH_VALUE , AssessmentTaskDtlVOMeta.DIRTY_FIELDS , AssessmentTaskDtlVOMeta.SORT_FIELD , AssessmentTaskDtlVOMeta.SORT_TYPE , AssessmentTaskDtlVOMeta.DATA_ORIGIN , AssessmentTaskDtlVOMeta.QUERY_LOGIC , AssessmentTaskDtlVOMeta.REQUEST_ACTION , AssessmentTaskDtlVOMeta.IDS } )
	@SentinelResource(value = AssessmentTaskDtlServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentTaskDtlServiceProxy.SAVE)
	public Result save(AssessmentTaskDtlVO assessmentTaskDtlVO) {
		
		Result result=assessmentTaskDtlService.save(assessmentTaskDtlVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取考核任务单
	*/
	@ApiOperation(value = "获取考核任务单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssessmentTaskDtlServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentTaskDtlServiceProxy.GET_BY_ID)
	public Result<AssessmentTaskDtl> getById(String id) {
		
		Result<AssessmentTaskDtl> result=new Result<>();
		AssessmentTaskDtl assessmentTaskDtl=assessmentTaskDtlService.getById(id);
		result.success(true).data(assessmentTaskDtl);
		return result;
	}


	/**
	 * 批量获取考核任务单 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取考核任务单")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AssessmentTaskDtlServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentTaskDtlServiceProxy.GET_BY_IDS)
	public Result<List<AssessmentTaskDtl>> getByIds(List<String> ids) {
		
		Result<List<AssessmentTaskDtl>> result=new Result<>();
		List<AssessmentTaskDtl> list=assessmentTaskDtlService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询考核任务单
	*/
	@ApiOperation(value = "查询考核任务单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.TASK_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.ASSESSEE_ID , value = "被考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.ASSESSOR_ID , value = "考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.SCORE_VALUE , value = "得分" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.EVALUATE_CONTENT , value = "综合评价" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.RCD_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssessmentTaskDtlVOMeta.PAGE_INDEX , AssessmentTaskDtlVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssessmentTaskDtlServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentTaskDtlServiceProxy.QUERY_LIST)
	public Result<List<AssessmentTaskDtl>> queryList(AssessmentTaskDtlVO sample) {
		
		Result<List<AssessmentTaskDtl>> result=new Result<>();
		List<AssessmentTaskDtl> list=assessmentTaskDtlService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询考核任务单
	*/
	@ApiOperation(value = "分页查询考核任务单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.TASK_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.ASSESSEE_ID , value = "被考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.ASSESSOR_ID , value = "考核人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.SCORE_VALUE , value = "得分" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.EVALUATE_CONTENT , value = "综合评价" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.RCD_TIME , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssessmentTaskDtlVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssessmentTaskDtlServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentTaskDtlServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssessmentTaskDtl>> queryPagedList(AssessmentTaskDtlVO sample) {
		
		Result<PagedList<AssessmentTaskDtl>> result=new Result<>();
		PagedList<AssessmentTaskDtl> list=assessmentTaskDtlService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}