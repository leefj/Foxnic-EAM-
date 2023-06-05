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


import com.dt.platform.proxy.hr.RecruitPostRecServiceProxy;
import com.dt.platform.domain.hr.meta.RecruitPostRecVOMeta;
import com.dt.platform.domain.hr.RecruitPostRec;
import com.dt.platform.domain.hr.RecruitPostRecVO;
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
import com.dt.platform.domain.hr.meta.RecruitPostRecMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IRecruitPostRecService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 招聘岗位接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-05 15:28:54
*/

@InDoc
@Api(tags = "招聘岗位")
@RestController("HrRecruitPostRecController")
public class RecruitPostRecController extends SuperController {

	@Autowired
	private IRecruitPostRecService recruitPostRecService;

	/**
	 * 添加招聘岗位
	*/
	@ApiOperation(value = "添加招聘岗位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecruitPostRecVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPostRecVOMeta.NAME , value = "招聘说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPostRecVOMeta.POST_NAME , value = "岗位名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPostRecVOMeta.CONTENT , value = "招聘要求" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPostRecVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RecruitPostRecServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecruitPostRecServiceProxy.INSERT)
	public Result insert(RecruitPostRecVO recruitPostRecVO) {
		
		Result result=recruitPostRecService.insert(recruitPostRecVO,false);
		return result;
	}



	/**
	 * 删除招聘岗位
	*/
	@ApiOperation(value = "删除招聘岗位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecruitPostRecVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RecruitPostRecServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecruitPostRecServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  recruitPostRecService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=recruitPostRecService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除招聘岗位 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除招聘岗位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecruitPostRecVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = RecruitPostRecServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecruitPostRecServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = recruitPostRecService.hasRefers(ids);
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
			Result result=recruitPostRecService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=recruitPostRecService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新招聘岗位
	*/
	@ApiOperation(value = "更新招聘岗位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecruitPostRecVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPostRecVOMeta.NAME , value = "招聘说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPostRecVOMeta.POST_NAME , value = "岗位名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPostRecVOMeta.CONTENT , value = "招聘要求" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPostRecVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { RecruitPostRecVOMeta.PAGE_INDEX , RecruitPostRecVOMeta.PAGE_SIZE , RecruitPostRecVOMeta.SEARCH_FIELD , RecruitPostRecVOMeta.FUZZY_FIELD , RecruitPostRecVOMeta.SEARCH_VALUE , RecruitPostRecVOMeta.DIRTY_FIELDS , RecruitPostRecVOMeta.SORT_FIELD , RecruitPostRecVOMeta.SORT_TYPE , RecruitPostRecVOMeta.DATA_ORIGIN , RecruitPostRecVOMeta.QUERY_LOGIC , RecruitPostRecVOMeta.REQUEST_ACTION , RecruitPostRecVOMeta.IDS } )
	@SentinelResource(value = RecruitPostRecServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecruitPostRecServiceProxy.UPDATE)
	public Result update(RecruitPostRecVO recruitPostRecVO) {
		
		Result result=recruitPostRecService.update(recruitPostRecVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存招聘岗位
	*/
	@ApiOperation(value = "保存招聘岗位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecruitPostRecVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPostRecVOMeta.NAME , value = "招聘说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPostRecVOMeta.POST_NAME , value = "岗位名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPostRecVOMeta.CONTENT , value = "招聘要求" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPostRecVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RecruitPostRecVOMeta.PAGE_INDEX , RecruitPostRecVOMeta.PAGE_SIZE , RecruitPostRecVOMeta.SEARCH_FIELD , RecruitPostRecVOMeta.FUZZY_FIELD , RecruitPostRecVOMeta.SEARCH_VALUE , RecruitPostRecVOMeta.DIRTY_FIELDS , RecruitPostRecVOMeta.SORT_FIELD , RecruitPostRecVOMeta.SORT_TYPE , RecruitPostRecVOMeta.DATA_ORIGIN , RecruitPostRecVOMeta.QUERY_LOGIC , RecruitPostRecVOMeta.REQUEST_ACTION , RecruitPostRecVOMeta.IDS } )
	@SentinelResource(value = RecruitPostRecServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecruitPostRecServiceProxy.SAVE)
	public Result save(RecruitPostRecVO recruitPostRecVO) {
		
		Result result=recruitPostRecService.save(recruitPostRecVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取招聘岗位
	*/
	@ApiOperation(value = "获取招聘岗位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecruitPostRecVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RecruitPostRecServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecruitPostRecServiceProxy.GET_BY_ID)
	public Result<RecruitPostRec> getById(String id) {
		
		Result<RecruitPostRec> result=new Result<>();
		RecruitPostRec recruitPostRec=recruitPostRecService.getById(id);
		result.success(true).data(recruitPostRec);
		return result;
	}


	/**
	 * 批量获取招聘岗位 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取招聘岗位")
		@ApiImplicitParams({
				@ApiImplicitParam(name = RecruitPostRecVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = RecruitPostRecServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecruitPostRecServiceProxy.GET_BY_IDS)
	public Result<List<RecruitPostRec>> getByIds(List<String> ids) {
		
		Result<List<RecruitPostRec>> result=new Result<>();
		List<RecruitPostRec> list=recruitPostRecService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询招聘岗位
	*/
	@ApiOperation(value = "查询招聘岗位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecruitPostRecVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPostRecVOMeta.NAME , value = "招聘说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPostRecVOMeta.POST_NAME , value = "岗位名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPostRecVOMeta.CONTENT , value = "招聘要求" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPostRecVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { RecruitPostRecVOMeta.PAGE_INDEX , RecruitPostRecVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RecruitPostRecServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecruitPostRecServiceProxy.QUERY_LIST)
	public Result<List<RecruitPostRec>> queryList(RecruitPostRecVO sample) {
		
		Result<List<RecruitPostRec>> result=new Result<>();
		List<RecruitPostRec> list=recruitPostRecService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询招聘岗位
	*/
	@ApiOperation(value = "分页查询招聘岗位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecruitPostRecVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPostRecVOMeta.NAME , value = "招聘说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPostRecVOMeta.POST_NAME , value = "岗位名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPostRecVOMeta.CONTENT , value = "招聘要求" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPostRecVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RecruitPostRecServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecruitPostRecServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<RecruitPostRec>> queryPagedList(RecruitPostRecVO sample) {
		
		Result<PagedList<RecruitPostRec>> result=new Result<>();
		PagedList<RecruitPostRec> list=recruitPostRecService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}