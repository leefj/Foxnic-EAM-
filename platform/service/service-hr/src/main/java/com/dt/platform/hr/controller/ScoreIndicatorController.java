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


import com.dt.platform.proxy.hr.ScoreIndicatorServiceProxy;
import com.dt.platform.domain.hr.meta.ScoreIndicatorVOMeta;
import com.dt.platform.domain.hr.ScoreIndicator;
import com.dt.platform.domain.hr.ScoreIndicatorVO;
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
import com.dt.platform.domain.hr.meta.ScoreIndicatorMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IScoreIndicatorService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 评价指标接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-12 18:44:27
*/

@InDoc
@Api(tags = "评价指标")
@RestController("HrScoreIndicatorController")
public class ScoreIndicatorController extends SuperController {

	@Autowired
	private IScoreIndicatorService scoreIndicatorService;

	/**
	 * 添加评价指标
	*/
	@ApiOperation(value = "添加评价指标")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.WEIGHT , value = "权重" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreIndicatorServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreIndicatorServiceProxy.INSERT)
	public Result insert(ScoreIndicatorVO scoreIndicatorVO) {
		
		Result result=scoreIndicatorService.insert(scoreIndicatorVO,false);
		return result;
	}



	/**
	 * 删除评价指标
	*/
	@ApiOperation(value = "删除评价指标")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreIndicatorServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreIndicatorServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  scoreIndicatorService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=scoreIndicatorService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除评价指标 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除评价指标")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = ScoreIndicatorServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreIndicatorServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = scoreIndicatorService.hasRefers(ids);
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
			Result result=scoreIndicatorService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=scoreIndicatorService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新评价指标
	*/
	@ApiOperation(value = "更新评价指标")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.WEIGHT , value = "权重" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScoreIndicatorVOMeta.PAGE_INDEX , ScoreIndicatorVOMeta.PAGE_SIZE , ScoreIndicatorVOMeta.SEARCH_FIELD , ScoreIndicatorVOMeta.FUZZY_FIELD , ScoreIndicatorVOMeta.SEARCH_VALUE , ScoreIndicatorVOMeta.DIRTY_FIELDS , ScoreIndicatorVOMeta.SORT_FIELD , ScoreIndicatorVOMeta.SORT_TYPE , ScoreIndicatorVOMeta.DATA_ORIGIN , ScoreIndicatorVOMeta.QUERY_LOGIC , ScoreIndicatorVOMeta.REQUEST_ACTION , ScoreIndicatorVOMeta.IDS } )
	@SentinelResource(value = ScoreIndicatorServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreIndicatorServiceProxy.UPDATE)
	public Result update(ScoreIndicatorVO scoreIndicatorVO) {
		
		Result result=scoreIndicatorService.update(scoreIndicatorVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存评价指标
	*/
	@ApiOperation(value = "保存评价指标")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.WEIGHT , value = "权重" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ScoreIndicatorVOMeta.PAGE_INDEX , ScoreIndicatorVOMeta.PAGE_SIZE , ScoreIndicatorVOMeta.SEARCH_FIELD , ScoreIndicatorVOMeta.FUZZY_FIELD , ScoreIndicatorVOMeta.SEARCH_VALUE , ScoreIndicatorVOMeta.DIRTY_FIELDS , ScoreIndicatorVOMeta.SORT_FIELD , ScoreIndicatorVOMeta.SORT_TYPE , ScoreIndicatorVOMeta.DATA_ORIGIN , ScoreIndicatorVOMeta.QUERY_LOGIC , ScoreIndicatorVOMeta.REQUEST_ACTION , ScoreIndicatorVOMeta.IDS } )
	@SentinelResource(value = ScoreIndicatorServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreIndicatorServiceProxy.SAVE)
	public Result save(ScoreIndicatorVO scoreIndicatorVO) {
		
		Result result=scoreIndicatorService.save(scoreIndicatorVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取评价指标
	*/
	@ApiOperation(value = "获取评价指标")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreIndicatorServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreIndicatorServiceProxy.GET_BY_ID)
	public Result<ScoreIndicator> getById(String id) {
		
		Result<ScoreIndicator> result=new Result<>();
		ScoreIndicator scoreIndicator=scoreIndicatorService.getById(id);
		result.success(true).data(scoreIndicator);
		return result;
	}


	/**
	 * 批量获取评价指标 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取评价指标")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ScoreIndicatorVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = ScoreIndicatorServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreIndicatorServiceProxy.GET_BY_IDS)
	public Result<List<ScoreIndicator>> getByIds(List<String> ids) {
		
		Result<List<ScoreIndicator>> result=new Result<>();
		List<ScoreIndicator> list=scoreIndicatorService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询评价指标
	*/
	@ApiOperation(value = "查询评价指标")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.WEIGHT , value = "权重" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ScoreIndicatorVOMeta.PAGE_INDEX , ScoreIndicatorVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ScoreIndicatorServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreIndicatorServiceProxy.QUERY_LIST)
	public Result<List<ScoreIndicator>> queryList(ScoreIndicatorVO sample) {
		
		Result<List<ScoreIndicator>> result=new Result<>();
		List<ScoreIndicator> list=scoreIndicatorService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询评价指标
	*/
	@ApiOperation(value = "分页查询评价指标")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.WEIGHT , value = "权重" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ScoreIndicatorVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ScoreIndicatorServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ScoreIndicatorServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ScoreIndicator>> queryPagedList(ScoreIndicatorVO sample) {
		
		Result<PagedList<ScoreIndicator>> result=new Result<>();
		PagedList<ScoreIndicator> list=scoreIndicatorService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}