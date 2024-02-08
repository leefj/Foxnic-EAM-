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


import com.dt.platform.proxy.hr.PerformanceLevelServiceProxy;
import com.dt.platform.domain.hr.meta.PerformanceLevelVOMeta;
import com.dt.platform.domain.hr.PerformanceLevel;
import com.dt.platform.domain.hr.PerformanceLevelVO;
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
import com.dt.platform.domain.hr.meta.PerformanceLevelMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IPerformanceLevelService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 考核等级接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-28 16:05:00
*/

@InDoc
@Api(tags = "考核等级")
@RestController("HrPerformanceLevelController")
public class PerformanceLevelController extends SuperController {

	@Autowired
	private IPerformanceLevelService performanceLevelService;

	/**
	 * 添加考核等级
	*/
	@ApiOperation(value = "添加考核等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PerformanceLevelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PerformanceLevelVOMeta.CODE , value = "等级编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PerformanceLevelVOMeta.NAME , value = "等级名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PerformanceLevelVOMeta.LOWER_LIMIT , value = "成绩下限" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PerformanceLevelVOMeta.UPPER_LIMIT , value = "成绩上限" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PerformanceLevelVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PerformanceLevelServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PerformanceLevelServiceProxy.INSERT)
	public Result insert(PerformanceLevelVO performanceLevelVO) {
		
		Result result=performanceLevelService.insert(performanceLevelVO,false);
		return result;
	}



	/**
	 * 删除考核等级
	*/
	@ApiOperation(value = "删除考核等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PerformanceLevelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PerformanceLevelServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PerformanceLevelServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  performanceLevelService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=performanceLevelService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除考核等级 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除考核等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PerformanceLevelVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PerformanceLevelServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PerformanceLevelServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = performanceLevelService.hasRefers(ids);
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
			Result result=performanceLevelService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=performanceLevelService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新考核等级
	*/
	@ApiOperation(value = "更新考核等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PerformanceLevelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PerformanceLevelVOMeta.CODE , value = "等级编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PerformanceLevelVOMeta.NAME , value = "等级名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PerformanceLevelVOMeta.LOWER_LIMIT , value = "成绩下限" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PerformanceLevelVOMeta.UPPER_LIMIT , value = "成绩上限" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PerformanceLevelVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PerformanceLevelVOMeta.PAGE_INDEX , PerformanceLevelVOMeta.PAGE_SIZE , PerformanceLevelVOMeta.SEARCH_FIELD , PerformanceLevelVOMeta.FUZZY_FIELD , PerformanceLevelVOMeta.SEARCH_VALUE , PerformanceLevelVOMeta.DIRTY_FIELDS , PerformanceLevelVOMeta.SORT_FIELD , PerformanceLevelVOMeta.SORT_TYPE , PerformanceLevelVOMeta.DATA_ORIGIN , PerformanceLevelVOMeta.QUERY_LOGIC , PerformanceLevelVOMeta.REQUEST_ACTION , PerformanceLevelVOMeta.IDS } )
	@SentinelResource(value = PerformanceLevelServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PerformanceLevelServiceProxy.UPDATE)
	public Result update(PerformanceLevelVO performanceLevelVO) {
		
		Result result=performanceLevelService.update(performanceLevelVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存考核等级
	*/
	@ApiOperation(value = "保存考核等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PerformanceLevelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PerformanceLevelVOMeta.CODE , value = "等级编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PerformanceLevelVOMeta.NAME , value = "等级名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PerformanceLevelVOMeta.LOWER_LIMIT , value = "成绩下限" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PerformanceLevelVOMeta.UPPER_LIMIT , value = "成绩上限" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PerformanceLevelVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PerformanceLevelVOMeta.PAGE_INDEX , PerformanceLevelVOMeta.PAGE_SIZE , PerformanceLevelVOMeta.SEARCH_FIELD , PerformanceLevelVOMeta.FUZZY_FIELD , PerformanceLevelVOMeta.SEARCH_VALUE , PerformanceLevelVOMeta.DIRTY_FIELDS , PerformanceLevelVOMeta.SORT_FIELD , PerformanceLevelVOMeta.SORT_TYPE , PerformanceLevelVOMeta.DATA_ORIGIN , PerformanceLevelVOMeta.QUERY_LOGIC , PerformanceLevelVOMeta.REQUEST_ACTION , PerformanceLevelVOMeta.IDS } )
	@SentinelResource(value = PerformanceLevelServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PerformanceLevelServiceProxy.SAVE)
	public Result save(PerformanceLevelVO performanceLevelVO) {
		
		Result result=performanceLevelService.save(performanceLevelVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取考核等级
	*/
	@ApiOperation(value = "获取考核等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PerformanceLevelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PerformanceLevelServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PerformanceLevelServiceProxy.GET_BY_ID)
	public Result<PerformanceLevel> getById(String id) {
		
		Result<PerformanceLevel> result=new Result<>();
		PerformanceLevel performanceLevel=performanceLevelService.getById(id);
		result.success(true).data(performanceLevel);
		return result;
	}


	/**
	 * 批量获取考核等级 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取考核等级")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PerformanceLevelVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PerformanceLevelServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PerformanceLevelServiceProxy.GET_BY_IDS)
	public Result<List<PerformanceLevel>> getByIds(List<String> ids) {
		
		Result<List<PerformanceLevel>> result=new Result<>();
		List<PerformanceLevel> list=performanceLevelService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询考核等级
	*/
	@ApiOperation(value = "查询考核等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PerformanceLevelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PerformanceLevelVOMeta.CODE , value = "等级编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PerformanceLevelVOMeta.NAME , value = "等级名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PerformanceLevelVOMeta.LOWER_LIMIT , value = "成绩下限" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PerformanceLevelVOMeta.UPPER_LIMIT , value = "成绩上限" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PerformanceLevelVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PerformanceLevelVOMeta.PAGE_INDEX , PerformanceLevelVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PerformanceLevelServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PerformanceLevelServiceProxy.QUERY_LIST)
	public Result<List<PerformanceLevel>> queryList(PerformanceLevelVO sample) {
		
		Result<List<PerformanceLevel>> result=new Result<>();
		List<PerformanceLevel> list=performanceLevelService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询考核等级
	*/
	@ApiOperation(value = "分页查询考核等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PerformanceLevelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PerformanceLevelVOMeta.CODE , value = "等级编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PerformanceLevelVOMeta.NAME , value = "等级名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PerformanceLevelVOMeta.LOWER_LIMIT , value = "成绩下限" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PerformanceLevelVOMeta.UPPER_LIMIT , value = "成绩上限" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PerformanceLevelVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PerformanceLevelServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PerformanceLevelServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PerformanceLevel>> queryPagedList(PerformanceLevelVO sample) {
		
		Result<PagedList<PerformanceLevel>> result=new Result<>();
		PagedList<PerformanceLevel> list=performanceLevelService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}