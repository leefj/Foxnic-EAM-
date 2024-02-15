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


import com.dt.platform.proxy.hr.ScoreTaskInstServiceProxy;
import com.dt.platform.domain.hr.meta.ScoreTaskInstVOMeta;
import com.dt.platform.domain.hr.ScoreTaskInst;
import com.dt.platform.domain.hr.ScoreTaskInstVO;
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
import com.dt.platform.domain.hr.meta.ScoreTaskInstMeta;
import com.dt.platform.domain.hr.ScoreTpl;
import com.dt.platform.domain.hr.EvaluationRelation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IScoreTaskInstService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 任务配置记录接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-14 20:23:39
*/

@InDoc
@Api(tags = "任务配置记录")
@RestController("HrScoreTaskInstController")
public class ScoreTaskInstController extends SuperController {

	@Autowired
	private IScoreTaskInstService scoreTaskInstService;

	/**
	 * 添加任务配置记录
	*/
	@ApiOperation(value = "添加任务配置记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "810204985697501184"),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.CONF_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.TPL_ID , value = "评分卷" , required = false , dataTypeClass=String.class , example = "809164670802853888"),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.RELATIONSHIP , value = "关系" , required = false , dataTypeClass=String.class , example = "same_level,higher_level,lower_level"),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTaskInstServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskInstServiceProxy.INSERT)
	public Result insert(ScoreTaskInstVO scoreTaskInstVO) {
		
		Result result=scoreTaskInstService.insert(scoreTaskInstVO,false);
		return result;
	}



	/**
	 * 删除任务配置记录
	*/
	@ApiOperation(value = "删除任务配置记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "810204985697501184")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTaskInstServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskInstServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  scoreTaskInstService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=scoreTaskInstService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除任务配置记录 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除任务配置记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = ScoreTaskInstServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskInstServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = scoreTaskInstService.hasRefers(ids);
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
			Result result=scoreTaskInstService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=scoreTaskInstService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新任务配置记录
	*/
	@ApiOperation(value = "更新任务配置记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "810204985697501184"),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.CONF_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.TPL_ID , value = "评分卷" , required = false , dataTypeClass=String.class , example = "809164670802853888"),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.RELATIONSHIP , value = "关系" , required = false , dataTypeClass=String.class , example = "same_level,higher_level,lower_level"),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScoreTaskInstVOMeta.PAGE_INDEX , ScoreTaskInstVOMeta.PAGE_SIZE , ScoreTaskInstVOMeta.SEARCH_FIELD , ScoreTaskInstVOMeta.FUZZY_FIELD , ScoreTaskInstVOMeta.SEARCH_VALUE , ScoreTaskInstVOMeta.DIRTY_FIELDS , ScoreTaskInstVOMeta.SORT_FIELD , ScoreTaskInstVOMeta.SORT_TYPE , ScoreTaskInstVOMeta.DATA_ORIGIN , ScoreTaskInstVOMeta.QUERY_LOGIC , ScoreTaskInstVOMeta.REQUEST_ACTION , ScoreTaskInstVOMeta.IDS } )
	@SentinelResource(value = ScoreTaskInstServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskInstServiceProxy.UPDATE)
	public Result update(ScoreTaskInstVO scoreTaskInstVO) {
		
		Result result=scoreTaskInstService.update(scoreTaskInstVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存任务配置记录
	*/
	@ApiOperation(value = "保存任务配置记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "810204985697501184"),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.CONF_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.TPL_ID , value = "评分卷" , required = false , dataTypeClass=String.class , example = "809164670802853888"),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.RELATIONSHIP , value = "关系" , required = false , dataTypeClass=String.class , example = "same_level,higher_level,lower_level"),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ScoreTaskInstVOMeta.PAGE_INDEX , ScoreTaskInstVOMeta.PAGE_SIZE , ScoreTaskInstVOMeta.SEARCH_FIELD , ScoreTaskInstVOMeta.FUZZY_FIELD , ScoreTaskInstVOMeta.SEARCH_VALUE , ScoreTaskInstVOMeta.DIRTY_FIELDS , ScoreTaskInstVOMeta.SORT_FIELD , ScoreTaskInstVOMeta.SORT_TYPE , ScoreTaskInstVOMeta.DATA_ORIGIN , ScoreTaskInstVOMeta.QUERY_LOGIC , ScoreTaskInstVOMeta.REQUEST_ACTION , ScoreTaskInstVOMeta.IDS } )
	@SentinelResource(value = ScoreTaskInstServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskInstServiceProxy.SAVE)
	public Result save(ScoreTaskInstVO scoreTaskInstVO) {
		
		Result result=scoreTaskInstService.save(scoreTaskInstVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取任务配置记录
	*/
	@ApiOperation(value = "获取任务配置记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTaskInstServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskInstServiceProxy.GET_BY_ID)
	public Result<ScoreTaskInst> getById(String id) {
		
		Result<ScoreTaskInst> result=new Result<>();
		ScoreTaskInst scoreTaskInst=scoreTaskInstService.getById(id);
		// join 关联的对象
		scoreTaskInstService.dao().fill(scoreTaskInst)
			.with(ScoreTaskInstMeta.SCORE_TPL)
			.with(ScoreTaskInstMeta.EVALUATION_RELATION)
			.execute();
		result.success(true).data(scoreTaskInst);
		return result;
	}


	/**
	 * 批量获取任务配置记录 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取任务配置记录")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ScoreTaskInstVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = ScoreTaskInstServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskInstServiceProxy.GET_BY_IDS)
	public Result<List<ScoreTaskInst>> getByIds(List<String> ids) {
		
		Result<List<ScoreTaskInst>> result=new Result<>();
		List<ScoreTaskInst> list=scoreTaskInstService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询任务配置记录
	*/
	@ApiOperation(value = "查询任务配置记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "810204985697501184"),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.CONF_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.TPL_ID , value = "评分卷" , required = false , dataTypeClass=String.class , example = "809164670802853888"),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.RELATIONSHIP , value = "关系" , required = false , dataTypeClass=String.class , example = "same_level,higher_level,lower_level"),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScoreTaskInstVOMeta.PAGE_INDEX , ScoreTaskInstVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ScoreTaskInstServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskInstServiceProxy.QUERY_LIST)
	public Result<List<ScoreTaskInst>> queryList(ScoreTaskInstVO sample) {
		
		Result<List<ScoreTaskInst>> result=new Result<>();
		List<ScoreTaskInst> list=scoreTaskInstService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询任务配置记录
	*/
	@ApiOperation(value = "分页查询任务配置记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "810204985697501184"),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.CONF_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.TPL_ID , value = "评分卷" , required = false , dataTypeClass=String.class , example = "809164670802853888"),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.RELATIONSHIP , value = "关系" , required = false , dataTypeClass=String.class , example = "same_level,higher_level,lower_level"),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskInstVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTaskInstServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskInstServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ScoreTaskInst>> queryPagedList(ScoreTaskInstVO sample) {
		
		Result<PagedList<ScoreTaskInst>> result=new Result<>();
		PagedList<ScoreTaskInst> list=scoreTaskInstService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		scoreTaskInstService.dao().fill(list)
			.with(ScoreTaskInstMeta.SCORE_TPL)
			.with(ScoreTaskInstMeta.EVALUATION_RELATION)
			.execute();
		result.success(true).data(list);
		return result;
	}





}