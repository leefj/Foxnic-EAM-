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


import com.dt.platform.proxy.hr.ScoreTaskServiceProxy;
import com.dt.platform.domain.hr.meta.ScoreTaskVOMeta;
import com.dt.platform.domain.hr.ScoreTask;
import com.dt.platform.domain.hr.ScoreTaskVO;
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
import com.dt.platform.domain.hr.meta.ScoreTaskMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IScoreTaskService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 任务单接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-12 00:01:41
*/

@InDoc
@Api(tags = "任务单")
@RestController("HrScoreTaskController")
public class ScoreTaskController extends SuperController {

	@Autowired
	private IScoreTaskService scoreTaskService;

	/**
	 * 添加任务单
	*/
	@ApiOperation(value = "添加任务单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.CREATE_OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTaskServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskServiceProxy.INSERT)
	public Result insert(ScoreTaskVO scoreTaskVO) {
		
		Result result=scoreTaskService.insert(scoreTaskVO,false);
		return result;
	}



	/**
	 * 删除任务单
	*/
	@ApiOperation(value = "删除任务单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTaskServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  scoreTaskService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=scoreTaskService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除任务单 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除任务单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = ScoreTaskServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = scoreTaskService.hasRefers(ids);
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
			Result result=scoreTaskService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=scoreTaskService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新任务单
	*/
	@ApiOperation(value = "更新任务单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.CREATE_OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScoreTaskVOMeta.PAGE_INDEX , ScoreTaskVOMeta.PAGE_SIZE , ScoreTaskVOMeta.SEARCH_FIELD , ScoreTaskVOMeta.FUZZY_FIELD , ScoreTaskVOMeta.SEARCH_VALUE , ScoreTaskVOMeta.DIRTY_FIELDS , ScoreTaskVOMeta.SORT_FIELD , ScoreTaskVOMeta.SORT_TYPE , ScoreTaskVOMeta.DATA_ORIGIN , ScoreTaskVOMeta.QUERY_LOGIC , ScoreTaskVOMeta.REQUEST_ACTION , ScoreTaskVOMeta.IDS } )
	@SentinelResource(value = ScoreTaskServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskServiceProxy.UPDATE)
	public Result update(ScoreTaskVO scoreTaskVO) {
		
		Result result=scoreTaskService.update(scoreTaskVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存任务单
	*/
	@ApiOperation(value = "保存任务单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.CREATE_OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ScoreTaskVOMeta.PAGE_INDEX , ScoreTaskVOMeta.PAGE_SIZE , ScoreTaskVOMeta.SEARCH_FIELD , ScoreTaskVOMeta.FUZZY_FIELD , ScoreTaskVOMeta.SEARCH_VALUE , ScoreTaskVOMeta.DIRTY_FIELDS , ScoreTaskVOMeta.SORT_FIELD , ScoreTaskVOMeta.SORT_TYPE , ScoreTaskVOMeta.DATA_ORIGIN , ScoreTaskVOMeta.QUERY_LOGIC , ScoreTaskVOMeta.REQUEST_ACTION , ScoreTaskVOMeta.IDS } )
	@SentinelResource(value = ScoreTaskServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskServiceProxy.SAVE)
	public Result save(ScoreTaskVO scoreTaskVO) {
		
		Result result=scoreTaskService.save(scoreTaskVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取任务单
	*/
	@ApiOperation(value = "获取任务单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTaskServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskServiceProxy.GET_BY_ID)
	public Result<ScoreTask> getById(String id) {
		
		Result<ScoreTask> result=new Result<>();
		ScoreTask scoreTask=scoreTaskService.getById(id);
		result.success(true).data(scoreTask);
		return result;
	}


	/**
	 * 批量获取任务单 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取任务单")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ScoreTaskVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = ScoreTaskServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskServiceProxy.GET_BY_IDS)
	public Result<List<ScoreTask>> getByIds(List<String> ids) {
		
		Result<List<ScoreTask>> result=new Result<>();
		List<ScoreTask> list=scoreTaskService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询任务单
	*/
	@ApiOperation(value = "查询任务单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.CREATE_OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScoreTaskVOMeta.PAGE_INDEX , ScoreTaskVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ScoreTaskServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskServiceProxy.QUERY_LIST)
	public Result<List<ScoreTask>> queryList(ScoreTaskVO sample) {
		
		Result<List<ScoreTask>> result=new Result<>();
		List<ScoreTask> list=scoreTaskService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询任务单
	*/
	@ApiOperation(value = "分页查询任务单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.CREATE_OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTaskServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ScoreTask>> queryPagedList(ScoreTaskVO sample) {
		
		Result<PagedList<ScoreTask>> result=new Result<>();
		PagedList<ScoreTask> list=scoreTaskService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}