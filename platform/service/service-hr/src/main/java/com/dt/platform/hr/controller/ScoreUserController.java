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


import com.dt.platform.proxy.hr.ScoreUserServiceProxy;
import com.dt.platform.domain.hr.meta.ScoreUserVOMeta;
import com.dt.platform.domain.hr.ScoreUser;
import com.dt.platform.domain.hr.ScoreUserVO;
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
import com.dt.platform.domain.hr.meta.ScoreUserMeta;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Person;
import com.dt.platform.domain.hr.ScoreTpl;
import com.dt.platform.domain.hr.EvaluationRelation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IScoreUserService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 考评用户接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-14 17:36:10
*/

@InDoc
@Api(tags = "考评用户")
@RestController("HrScoreUserController")
public class ScoreUserController extends SuperController {

	@Autowired
	private IScoreUserService scoreUserService;

	/**
	 * 添加考评用户
	*/
	@ApiOperation(value = "添加考评用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.INST_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.ORG_ID , value = "部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.RELATIONSHIP , value = "关系" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.TPL_ID , value = "考评卷" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.RATER_ID , value = "评价人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.RATED_ID , value = "被评价人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreUserServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreUserServiceProxy.INSERT)
	public Result insert(ScoreUserVO scoreUserVO) {
		
		Result result=scoreUserService.insert(scoreUserVO,false);
		return result;
	}



	/**
	 * 删除考评用户
	*/
	@ApiOperation(value = "删除考评用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreUserServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreUserServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  scoreUserService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=scoreUserService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除考评用户 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除考评用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreUserVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = ScoreUserServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreUserServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = scoreUserService.hasRefers(ids);
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
			Result result=scoreUserService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=scoreUserService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新考评用户
	*/
	@ApiOperation(value = "更新考评用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.INST_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.ORG_ID , value = "部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.RELATIONSHIP , value = "关系" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.TPL_ID , value = "考评卷" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.RATER_ID , value = "评价人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.RATED_ID , value = "被评价人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScoreUserVOMeta.PAGE_INDEX , ScoreUserVOMeta.PAGE_SIZE , ScoreUserVOMeta.SEARCH_FIELD , ScoreUserVOMeta.FUZZY_FIELD , ScoreUserVOMeta.SEARCH_VALUE , ScoreUserVOMeta.DIRTY_FIELDS , ScoreUserVOMeta.SORT_FIELD , ScoreUserVOMeta.SORT_TYPE , ScoreUserVOMeta.DATA_ORIGIN , ScoreUserVOMeta.QUERY_LOGIC , ScoreUserVOMeta.REQUEST_ACTION , ScoreUserVOMeta.IDS } )
	@SentinelResource(value = ScoreUserServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreUserServiceProxy.UPDATE)
	public Result update(ScoreUserVO scoreUserVO) {
		
		Result result=scoreUserService.update(scoreUserVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存考评用户
	*/
	@ApiOperation(value = "保存考评用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.INST_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.ORG_ID , value = "部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.RELATIONSHIP , value = "关系" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.TPL_ID , value = "考评卷" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.RATER_ID , value = "评价人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.RATED_ID , value = "被评价人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ScoreUserVOMeta.PAGE_INDEX , ScoreUserVOMeta.PAGE_SIZE , ScoreUserVOMeta.SEARCH_FIELD , ScoreUserVOMeta.FUZZY_FIELD , ScoreUserVOMeta.SEARCH_VALUE , ScoreUserVOMeta.DIRTY_FIELDS , ScoreUserVOMeta.SORT_FIELD , ScoreUserVOMeta.SORT_TYPE , ScoreUserVOMeta.DATA_ORIGIN , ScoreUserVOMeta.QUERY_LOGIC , ScoreUserVOMeta.REQUEST_ACTION , ScoreUserVOMeta.IDS } )
	@SentinelResource(value = ScoreUserServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreUserServiceProxy.SAVE)
	public Result save(ScoreUserVO scoreUserVO) {
		
		Result result=scoreUserService.save(scoreUserVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取考评用户
	*/
	@ApiOperation(value = "获取考评用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreUserServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreUserServiceProxy.GET_BY_ID)
	public Result<ScoreUser> getById(String id) {
		
		Result<ScoreUser> result=new Result<>();
		ScoreUser scoreUser=scoreUserService.getById(id);
		// join 关联的对象
		scoreUserService.dao().fill(scoreUser)
			.with("organization")
			.with("raterUser")
			.with("ratedUser")
			.with(ScoreUserMeta.SCORE_TPL)
			.with(ScoreUserMeta.EVALUATION_RELATION)
			.execute();
		result.success(true).data(scoreUser);
		return result;
	}


	/**
	 * 批量获取考评用户 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取考评用户")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ScoreUserVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = ScoreUserServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreUserServiceProxy.GET_BY_IDS)
	public Result<List<ScoreUser>> getByIds(List<String> ids) {
		
		Result<List<ScoreUser>> result=new Result<>();
		List<ScoreUser> list=scoreUserService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询考评用户
	*/
	@ApiOperation(value = "查询考评用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.INST_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.ORG_ID , value = "部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.RELATIONSHIP , value = "关系" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.TPL_ID , value = "考评卷" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.RATER_ID , value = "评价人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.RATED_ID , value = "被评价人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScoreUserVOMeta.PAGE_INDEX , ScoreUserVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ScoreUserServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreUserServiceProxy.QUERY_LIST)
	public Result<List<ScoreUser>> queryList(ScoreUserVO sample) {
		
		Result<List<ScoreUser>> result=new Result<>();
		List<ScoreUser> list=scoreUserService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询考评用户
	*/
	@ApiOperation(value = "分页查询考评用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.INST_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.ORG_ID , value = "部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.RELATIONSHIP , value = "关系" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.TPL_ID , value = "考评卷" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.RATER_ID , value = "评价人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.RATED_ID , value = "被评价人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreUserVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreUserServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreUserServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ScoreUser>> queryPagedList(ScoreUserVO sample) {
		
		Result<PagedList<ScoreUser>> result=new Result<>();
		PagedList<ScoreUser> list=scoreUserService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		scoreUserService.dao().fill(list)
			.with("organization")
			.with("raterUser")
			.with("ratedUser")
			.with(ScoreUserMeta.SCORE_TPL)
			.with(ScoreUserMeta.EVALUATION_RELATION)
			.execute();
		result.success(true).data(list);
		return result;
	}





}