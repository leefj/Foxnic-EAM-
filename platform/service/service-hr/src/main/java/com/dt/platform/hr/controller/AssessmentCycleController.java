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


import com.dt.platform.proxy.hr.AssessmentCycleServiceProxy;
import com.dt.platform.domain.hr.meta.AssessmentCycleVOMeta;
import com.dt.platform.domain.hr.AssessmentCycle;
import com.dt.platform.domain.hr.AssessmentCycleVO;
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
import com.dt.platform.domain.hr.meta.AssessmentCycleMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IAssessmentCycleService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 考核周期接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-28 10:48:35
*/

@InDoc
@Api(tags = "考核周期")
@RestController("HrAssessmentCycleController")
public class AssessmentCycleController extends SuperController {

	@Autowired
	private IAssessmentCycleService assessmentCycleService;

	/**
	 * 添加考核周期
	*/
	@ApiOperation(value = "添加考核周期")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentCycleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.NAME , value = "考核主题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.INFO , value = "考核说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.YEAR , value = "年份" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.SDATE , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.EDATE , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.RCD_USER_ID , value = "提及人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssessmentCycleServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentCycleServiceProxy.INSERT)
	public Result insert(AssessmentCycleVO assessmentCycleVO) {
		
		Result result=assessmentCycleService.insert(assessmentCycleVO,false);
		return result;
	}



	/**
	 * 删除考核周期
	*/
	@ApiOperation(value = "删除考核周期")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentCycleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssessmentCycleServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentCycleServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  assessmentCycleService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=assessmentCycleService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除考核周期 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除考核周期")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentCycleVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AssessmentCycleServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentCycleServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = assessmentCycleService.hasRefers(ids);
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
			Result result=assessmentCycleService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=assessmentCycleService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新考核周期
	*/
	@ApiOperation(value = "更新考核周期")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentCycleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.NAME , value = "考核主题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.INFO , value = "考核说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.YEAR , value = "年份" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.SDATE , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.EDATE , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.RCD_USER_ID , value = "提及人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssessmentCycleVOMeta.PAGE_INDEX , AssessmentCycleVOMeta.PAGE_SIZE , AssessmentCycleVOMeta.SEARCH_FIELD , AssessmentCycleVOMeta.FUZZY_FIELD , AssessmentCycleVOMeta.SEARCH_VALUE , AssessmentCycleVOMeta.DIRTY_FIELDS , AssessmentCycleVOMeta.SORT_FIELD , AssessmentCycleVOMeta.SORT_TYPE , AssessmentCycleVOMeta.DATA_ORIGIN , AssessmentCycleVOMeta.QUERY_LOGIC , AssessmentCycleVOMeta.REQUEST_ACTION , AssessmentCycleVOMeta.IDS } )
	@SentinelResource(value = AssessmentCycleServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentCycleServiceProxy.UPDATE)
	public Result update(AssessmentCycleVO assessmentCycleVO) {
		
		Result result=assessmentCycleService.update(assessmentCycleVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存考核周期
	*/
	@ApiOperation(value = "保存考核周期")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentCycleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.NAME , value = "考核主题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.INFO , value = "考核说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.YEAR , value = "年份" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.SDATE , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.EDATE , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.RCD_USER_ID , value = "提及人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssessmentCycleVOMeta.PAGE_INDEX , AssessmentCycleVOMeta.PAGE_SIZE , AssessmentCycleVOMeta.SEARCH_FIELD , AssessmentCycleVOMeta.FUZZY_FIELD , AssessmentCycleVOMeta.SEARCH_VALUE , AssessmentCycleVOMeta.DIRTY_FIELDS , AssessmentCycleVOMeta.SORT_FIELD , AssessmentCycleVOMeta.SORT_TYPE , AssessmentCycleVOMeta.DATA_ORIGIN , AssessmentCycleVOMeta.QUERY_LOGIC , AssessmentCycleVOMeta.REQUEST_ACTION , AssessmentCycleVOMeta.IDS } )
	@SentinelResource(value = AssessmentCycleServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentCycleServiceProxy.SAVE)
	public Result save(AssessmentCycleVO assessmentCycleVO) {
		
		Result result=assessmentCycleService.save(assessmentCycleVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取考核周期
	*/
	@ApiOperation(value = "获取考核周期")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentCycleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssessmentCycleServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentCycleServiceProxy.GET_BY_ID)
	public Result<AssessmentCycle> getById(String id) {
		
		Result<AssessmentCycle> result=new Result<>();
		AssessmentCycle assessmentCycle=assessmentCycleService.getById(id);
		result.success(true).data(assessmentCycle);
		return result;
	}


	/**
	 * 批量获取考核周期 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取考核周期")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssessmentCycleVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AssessmentCycleServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentCycleServiceProxy.GET_BY_IDS)
	public Result<List<AssessmentCycle>> getByIds(List<String> ids) {
		
		Result<List<AssessmentCycle>> result=new Result<>();
		List<AssessmentCycle> list=assessmentCycleService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询考核周期
	*/
	@ApiOperation(value = "查询考核周期")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentCycleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.NAME , value = "考核主题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.INFO , value = "考核说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.YEAR , value = "年份" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.SDATE , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.EDATE , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.RCD_USER_ID , value = "提及人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssessmentCycleVOMeta.PAGE_INDEX , AssessmentCycleVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssessmentCycleServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentCycleServiceProxy.QUERY_LIST)
	public Result<List<AssessmentCycle>> queryList(AssessmentCycleVO sample) {
		
		Result<List<AssessmentCycle>> result=new Result<>();
		List<AssessmentCycle> list=assessmentCycleService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询考核周期
	*/
	@ApiOperation(value = "分页查询考核周期")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssessmentCycleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.NAME , value = "考核主题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.INFO , value = "考核说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.YEAR , value = "年份" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.SDATE , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.EDATE , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.RCD_USER_ID , value = "提及人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssessmentCycleVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssessmentCycleServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssessmentCycleServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssessmentCycle>> queryPagedList(AssessmentCycleVO sample) {
		
		Result<PagedList<AssessmentCycle>> result=new Result<>();
		PagedList<AssessmentCycle> list=assessmentCycleService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}