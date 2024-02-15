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


import com.dt.platform.proxy.hr.ScoreTaskOrgServiceProxy;
import com.dt.platform.domain.hr.meta.ScoreTaskOrgVOMeta;
import com.dt.platform.domain.hr.ScoreTaskOrg;
import com.dt.platform.domain.hr.ScoreTaskOrgVO;
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
import com.dt.platform.domain.hr.meta.ScoreTaskOrgMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IScoreTaskOrgService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 任务部门接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-14 17:20:59
*/

@InDoc
@Api(tags = "任务部门")
@RestController("HrScoreTaskOrgController")
public class ScoreTaskOrgController extends SuperController {

	@Autowired
	private IScoreTaskOrgService scoreTaskOrgService;

	/**
	 * 添加任务部门
	*/
	@ApiOperation(value = "添加任务部门")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.CONFIG_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.RELATIONSHIP , value = "关系" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.ORG_INCLUDE , value = "包含部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.ORG_EXCLUDE , value = "排除部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTaskOrgServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskOrgServiceProxy.INSERT)
	public Result insert(ScoreTaskOrgVO scoreTaskOrgVO) {
		
		Result result=scoreTaskOrgService.insert(scoreTaskOrgVO,false);
		return result;
	}



	/**
	 * 删除任务部门
	*/
	@ApiOperation(value = "删除任务部门")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTaskOrgServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskOrgServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  scoreTaskOrgService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=scoreTaskOrgService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除任务部门 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除任务部门")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = ScoreTaskOrgServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskOrgServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = scoreTaskOrgService.hasRefers(ids);
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
			Result result=scoreTaskOrgService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=scoreTaskOrgService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新任务部门
	*/
	@ApiOperation(value = "更新任务部门")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.CONFIG_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.RELATIONSHIP , value = "关系" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.ORG_INCLUDE , value = "包含部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.ORG_EXCLUDE , value = "排除部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScoreTaskOrgVOMeta.PAGE_INDEX , ScoreTaskOrgVOMeta.PAGE_SIZE , ScoreTaskOrgVOMeta.SEARCH_FIELD , ScoreTaskOrgVOMeta.FUZZY_FIELD , ScoreTaskOrgVOMeta.SEARCH_VALUE , ScoreTaskOrgVOMeta.DIRTY_FIELDS , ScoreTaskOrgVOMeta.SORT_FIELD , ScoreTaskOrgVOMeta.SORT_TYPE , ScoreTaskOrgVOMeta.DATA_ORIGIN , ScoreTaskOrgVOMeta.QUERY_LOGIC , ScoreTaskOrgVOMeta.REQUEST_ACTION , ScoreTaskOrgVOMeta.IDS } )
	@SentinelResource(value = ScoreTaskOrgServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskOrgServiceProxy.UPDATE)
	public Result update(ScoreTaskOrgVO scoreTaskOrgVO) {
		
		Result result=scoreTaskOrgService.update(scoreTaskOrgVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存任务部门
	*/
	@ApiOperation(value = "保存任务部门")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.CONFIG_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.RELATIONSHIP , value = "关系" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.ORG_INCLUDE , value = "包含部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.ORG_EXCLUDE , value = "排除部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ScoreTaskOrgVOMeta.PAGE_INDEX , ScoreTaskOrgVOMeta.PAGE_SIZE , ScoreTaskOrgVOMeta.SEARCH_FIELD , ScoreTaskOrgVOMeta.FUZZY_FIELD , ScoreTaskOrgVOMeta.SEARCH_VALUE , ScoreTaskOrgVOMeta.DIRTY_FIELDS , ScoreTaskOrgVOMeta.SORT_FIELD , ScoreTaskOrgVOMeta.SORT_TYPE , ScoreTaskOrgVOMeta.DATA_ORIGIN , ScoreTaskOrgVOMeta.QUERY_LOGIC , ScoreTaskOrgVOMeta.REQUEST_ACTION , ScoreTaskOrgVOMeta.IDS } )
	@SentinelResource(value = ScoreTaskOrgServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskOrgServiceProxy.SAVE)
	public Result save(ScoreTaskOrgVO scoreTaskOrgVO) {
		
		Result result=scoreTaskOrgService.save(scoreTaskOrgVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取任务部门
	*/
	@ApiOperation(value = "获取任务部门")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTaskOrgServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskOrgServiceProxy.GET_BY_ID)
	public Result<ScoreTaskOrg> getById(String id) {
		
		Result<ScoreTaskOrg> result=new Result<>();
		ScoreTaskOrg scoreTaskOrg=scoreTaskOrgService.getById(id);
		result.success(true).data(scoreTaskOrg);
		return result;
	}


	/**
	 * 批量获取任务部门 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取任务部门")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ScoreTaskOrgVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = ScoreTaskOrgServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskOrgServiceProxy.GET_BY_IDS)
	public Result<List<ScoreTaskOrg>> getByIds(List<String> ids) {
		
		Result<List<ScoreTaskOrg>> result=new Result<>();
		List<ScoreTaskOrg> list=scoreTaskOrgService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询任务部门
	*/
	@ApiOperation(value = "查询任务部门")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.CONFIG_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.RELATIONSHIP , value = "关系" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.ORG_INCLUDE , value = "包含部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.ORG_EXCLUDE , value = "排除部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScoreTaskOrgVOMeta.PAGE_INDEX , ScoreTaskOrgVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ScoreTaskOrgServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskOrgServiceProxy.QUERY_LIST)
	public Result<List<ScoreTaskOrg>> queryList(ScoreTaskOrgVO sample) {
		
		Result<List<ScoreTaskOrg>> result=new Result<>();
		List<ScoreTaskOrg> list=scoreTaskOrgService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询任务部门
	*/
	@ApiOperation(value = "分页查询任务部门")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.CONFIG_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.RELATIONSHIP , value = "关系" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.ORG_INCLUDE , value = "包含部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.ORG_EXCLUDE , value = "排除部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreTaskOrgVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreTaskOrgServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreTaskOrgServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ScoreTaskOrg>> queryPagedList(ScoreTaskOrgVO sample) {
		
		Result<PagedList<ScoreTaskOrg>> result=new Result<>();
		PagedList<ScoreTaskOrg> list=scoreTaskOrgService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}