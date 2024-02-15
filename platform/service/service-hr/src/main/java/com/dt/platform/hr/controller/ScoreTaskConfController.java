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


import com.dt.platform.proxy.hr.ScoreTaskConfServiceProxy;
import com.dt.platform.domain.hr.meta.ScoreTaskConfVOMeta;
import com.dt.platform.domain.hr.ScoreTaskConf;
import com.dt.platform.domain.hr.ScoreTaskConfVO;
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
import com.dt.platform.domain.hr.meta.ScoreTaskConfMeta;
import com.dt.platform.domain.hr.ScoreTpl;
import com.dt.platform.domain.hr.EvaluationRelation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IScoreTaskConfService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 任务配置接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-14 17:34:02
*/

@InDoc
@Api(tags = "任务配置")
@RestController("HrScoreTaskConfController")
public class ScoreTaskConfController extends SuperController {

	@Autowired
	private IScoreTaskConfService scoreTaskConfService;

	/**
	 * 添加任务配置
	*/
	@ApiOperation(value = "添加任务配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.RELATIONSHIP , value = "关系" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.TPL_ID , value = "评分卷" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTaskConfServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskConfServiceProxy.INSERT)
	public Result insert(ScoreTaskConfVO scoreTaskConfVO) {
		
		Result result=scoreTaskConfService.insert(scoreTaskConfVO,false);
		return result;
	}



	/**
	 * 删除任务配置
	*/
	@ApiOperation(value = "删除任务配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTaskConfServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskConfServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  scoreTaskConfService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=scoreTaskConfService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除任务配置 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除任务配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = ScoreTaskConfServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskConfServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = scoreTaskConfService.hasRefers(ids);
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
			Result result=scoreTaskConfService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=scoreTaskConfService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新任务配置
	*/
	@ApiOperation(value = "更新任务配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.RELATIONSHIP , value = "关系" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.TPL_ID , value = "评分卷" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScoreTaskConfVOMeta.PAGE_INDEX , ScoreTaskConfVOMeta.PAGE_SIZE , ScoreTaskConfVOMeta.SEARCH_FIELD , ScoreTaskConfVOMeta.FUZZY_FIELD , ScoreTaskConfVOMeta.SEARCH_VALUE , ScoreTaskConfVOMeta.DIRTY_FIELDS , ScoreTaskConfVOMeta.SORT_FIELD , ScoreTaskConfVOMeta.SORT_TYPE , ScoreTaskConfVOMeta.DATA_ORIGIN , ScoreTaskConfVOMeta.QUERY_LOGIC , ScoreTaskConfVOMeta.REQUEST_ACTION , ScoreTaskConfVOMeta.IDS } )
	@SentinelResource(value = ScoreTaskConfServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskConfServiceProxy.UPDATE)
	public Result update(ScoreTaskConfVO scoreTaskConfVO) {
		
		Result result=scoreTaskConfService.update(scoreTaskConfVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存任务配置
	*/
	@ApiOperation(value = "保存任务配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.RELATIONSHIP , value = "关系" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.TPL_ID , value = "评分卷" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ScoreTaskConfVOMeta.PAGE_INDEX , ScoreTaskConfVOMeta.PAGE_SIZE , ScoreTaskConfVOMeta.SEARCH_FIELD , ScoreTaskConfVOMeta.FUZZY_FIELD , ScoreTaskConfVOMeta.SEARCH_VALUE , ScoreTaskConfVOMeta.DIRTY_FIELDS , ScoreTaskConfVOMeta.SORT_FIELD , ScoreTaskConfVOMeta.SORT_TYPE , ScoreTaskConfVOMeta.DATA_ORIGIN , ScoreTaskConfVOMeta.QUERY_LOGIC , ScoreTaskConfVOMeta.REQUEST_ACTION , ScoreTaskConfVOMeta.IDS } )
	@SentinelResource(value = ScoreTaskConfServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskConfServiceProxy.SAVE)
	public Result save(ScoreTaskConfVO scoreTaskConfVO) {
		
		Result result=scoreTaskConfService.save(scoreTaskConfVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取任务配置
	*/
	@ApiOperation(value = "获取任务配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTaskConfServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskConfServiceProxy.GET_BY_ID)
	public Result<ScoreTaskConf> getById(String id) {
		
		Result<ScoreTaskConf> result=new Result<>();
		ScoreTaskConf scoreTaskConf=scoreTaskConfService.getById(id);
		// join 关联的对象
		scoreTaskConfService.dao().fill(scoreTaskConf)
			.with(ScoreTaskConfMeta.SCORE_TPL)
			.with(ScoreTaskConfMeta.EVALUATION_RELATION)
			.execute();
		result.success(true).data(scoreTaskConf);
		return result;
	}


	/**
	 * 批量获取任务配置 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取任务配置")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ScoreTaskConfVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = ScoreTaskConfServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskConfServiceProxy.GET_BY_IDS)
	public Result<List<ScoreTaskConf>> getByIds(List<String> ids) {
		
		Result<List<ScoreTaskConf>> result=new Result<>();
		List<ScoreTaskConf> list=scoreTaskConfService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询任务配置
	*/
	@ApiOperation(value = "查询任务配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.RELATIONSHIP , value = "关系" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.TPL_ID , value = "评分卷" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScoreTaskConfVOMeta.PAGE_INDEX , ScoreTaskConfVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ScoreTaskConfServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskConfServiceProxy.QUERY_LIST)
	public Result<List<ScoreTaskConf>> queryList(ScoreTaskConfVO sample) {
		
		Result<List<ScoreTaskConf>> result=new Result<>();
		List<ScoreTaskConf> list=scoreTaskConfService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询任务配置
	*/
	@ApiOperation(value = "分页查询任务配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.RELATIONSHIP , value = "关系" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.TPL_ID , value = "评分卷" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskConfVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTaskConfServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskConfServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ScoreTaskConf>> queryPagedList(ScoreTaskConfVO sample) {
		
		Result<PagedList<ScoreTaskConf>> result=new Result<>();
		PagedList<ScoreTaskConf> list=scoreTaskConfService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		scoreTaskConfService.dao().fill(list)
			.with(ScoreTaskConfMeta.SCORE_TPL)
			.with(ScoreTaskConfMeta.EVALUATION_RELATION)
			.execute();
		result.success(true).data(list);
		return result;
	}





}