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


import com.dt.platform.proxy.hr.ScoreTaskDtlServiceProxy;
import com.dt.platform.domain.hr.meta.ScoreTaskDtlVOMeta;
import com.dt.platform.domain.hr.ScoreTaskDtl;
import com.dt.platform.domain.hr.ScoreTaskDtlVO;
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
import com.dt.platform.domain.hr.meta.ScoreTaskDtlMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IScoreTaskDtlService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 任务单明细接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-12 00:04:02
*/

@InDoc
@Api(tags = "任务单明细")
@RestController("HrScoreTaskDtlController")
public class ScoreTaskDtlController extends SuperController {

	@Autowired
	private IScoreTaskDtlService scoreTaskDtlService;

	/**
	 * 添加任务单明细
	*/
	@ApiOperation(value = "添加任务单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.TASK_ID , value = "任务单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.RATER_ID , value = "评分人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.RATED_ID , value = "被评分人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.TOTAL_SCORE , value = "总分" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTaskDtlServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskDtlServiceProxy.INSERT)
	public Result insert(ScoreTaskDtlVO scoreTaskDtlVO) {
		
		Result result=scoreTaskDtlService.insert(scoreTaskDtlVO,false);
		return result;
	}



	/**
	 * 删除任务单明细
	*/
	@ApiOperation(value = "删除任务单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTaskDtlServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskDtlServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  scoreTaskDtlService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=scoreTaskDtlService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除任务单明细 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除任务单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = ScoreTaskDtlServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskDtlServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = scoreTaskDtlService.hasRefers(ids);
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
			Result result=scoreTaskDtlService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=scoreTaskDtlService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新任务单明细
	*/
	@ApiOperation(value = "更新任务单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.TASK_ID , value = "任务单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.RATER_ID , value = "评分人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.RATED_ID , value = "被评分人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.TOTAL_SCORE , value = "总分" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScoreTaskDtlVOMeta.PAGE_INDEX , ScoreTaskDtlVOMeta.PAGE_SIZE , ScoreTaskDtlVOMeta.SEARCH_FIELD , ScoreTaskDtlVOMeta.FUZZY_FIELD , ScoreTaskDtlVOMeta.SEARCH_VALUE , ScoreTaskDtlVOMeta.DIRTY_FIELDS , ScoreTaskDtlVOMeta.SORT_FIELD , ScoreTaskDtlVOMeta.SORT_TYPE , ScoreTaskDtlVOMeta.DATA_ORIGIN , ScoreTaskDtlVOMeta.QUERY_LOGIC , ScoreTaskDtlVOMeta.REQUEST_ACTION , ScoreTaskDtlVOMeta.IDS } )
	@SentinelResource(value = ScoreTaskDtlServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskDtlServiceProxy.UPDATE)
	public Result update(ScoreTaskDtlVO scoreTaskDtlVO) {
		
		Result result=scoreTaskDtlService.update(scoreTaskDtlVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存任务单明细
	*/
	@ApiOperation(value = "保存任务单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.TASK_ID , value = "任务单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.RATER_ID , value = "评分人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.RATED_ID , value = "被评分人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.TOTAL_SCORE , value = "总分" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ScoreTaskDtlVOMeta.PAGE_INDEX , ScoreTaskDtlVOMeta.PAGE_SIZE , ScoreTaskDtlVOMeta.SEARCH_FIELD , ScoreTaskDtlVOMeta.FUZZY_FIELD , ScoreTaskDtlVOMeta.SEARCH_VALUE , ScoreTaskDtlVOMeta.DIRTY_FIELDS , ScoreTaskDtlVOMeta.SORT_FIELD , ScoreTaskDtlVOMeta.SORT_TYPE , ScoreTaskDtlVOMeta.DATA_ORIGIN , ScoreTaskDtlVOMeta.QUERY_LOGIC , ScoreTaskDtlVOMeta.REQUEST_ACTION , ScoreTaskDtlVOMeta.IDS } )
	@SentinelResource(value = ScoreTaskDtlServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskDtlServiceProxy.SAVE)
	public Result save(ScoreTaskDtlVO scoreTaskDtlVO) {
		
		Result result=scoreTaskDtlService.save(scoreTaskDtlVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取任务单明细
	*/
	@ApiOperation(value = "获取任务单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTaskDtlServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskDtlServiceProxy.GET_BY_ID)
	public Result<ScoreTaskDtl> getById(String id) {
		
		Result<ScoreTaskDtl> result=new Result<>();
		ScoreTaskDtl scoreTaskDtl=scoreTaskDtlService.getById(id);
		result.success(true).data(scoreTaskDtl);
		return result;
	}


	/**
	 * 批量获取任务单明细 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取任务单明细")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ScoreTaskDtlVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = ScoreTaskDtlServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskDtlServiceProxy.GET_BY_IDS)
	public Result<List<ScoreTaskDtl>> getByIds(List<String> ids) {
		
		Result<List<ScoreTaskDtl>> result=new Result<>();
		List<ScoreTaskDtl> list=scoreTaskDtlService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询任务单明细
	*/
	@ApiOperation(value = "查询任务单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.TASK_ID , value = "任务单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.RATER_ID , value = "评分人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.RATED_ID , value = "被评分人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.TOTAL_SCORE , value = "总分" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScoreTaskDtlVOMeta.PAGE_INDEX , ScoreTaskDtlVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ScoreTaskDtlServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskDtlServiceProxy.QUERY_LIST)
	public Result<List<ScoreTaskDtl>> queryList(ScoreTaskDtlVO sample) {
		
		Result<List<ScoreTaskDtl>> result=new Result<>();
		List<ScoreTaskDtl> list=scoreTaskDtlService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询任务单明细
	*/
	@ApiOperation(value = "分页查询任务单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.TASK_ID , value = "任务单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.RATER_ID , value = "评分人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.RATED_ID , value = "被评分人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.TOTAL_SCORE , value = "总分" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskDtlVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTaskDtlServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskDtlServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ScoreTaskDtl>> queryPagedList(ScoreTaskDtlVO sample) {
		
		Result<PagedList<ScoreTaskDtl>> result=new Result<>();
		PagedList<ScoreTaskDtl> list=scoreTaskDtlService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}