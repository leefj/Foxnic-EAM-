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


import com.dt.platform.proxy.hr.RecruitPersonRecServiceProxy;
import com.dt.platform.domain.hr.meta.RecruitPersonRecVOMeta;
import com.dt.platform.domain.hr.RecruitPersonRec;
import com.dt.platform.domain.hr.RecruitPersonRecVO;
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
import com.dt.platform.domain.hr.meta.RecruitPersonRecMeta;
import com.dt.platform.domain.hr.RecruitPostRec;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IRecruitPersonRecService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 招聘记录接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-05 15:38:55
*/

@InDoc
@Api(tags = "招聘记录")
@RestController("HrRecruitPersonRecController")
public class RecruitPersonRecController extends SuperController {

	@Autowired
	private IRecruitPersonRecService recruitPersonRecService;

	/**
	 * 添加招聘记录
	*/
	@ApiOperation(value = "添加招聘记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.NAME , value = "招聘说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.POST_ID , value = "岗位名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.POST_NAME , value = "岗位名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.CONTENT , value = "招聘要求" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.START_DATE , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.END_DATE , value = "结束时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RecruitPersonRecServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecruitPersonRecServiceProxy.INSERT)
	public Result insert(RecruitPersonRecVO recruitPersonRecVO) {
		
		Result result=recruitPersonRecService.insert(recruitPersonRecVO,false);
		return result;
	}



	/**
	 * 删除招聘记录
	*/
	@ApiOperation(value = "删除招聘记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RecruitPersonRecServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecruitPersonRecServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  recruitPersonRecService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=recruitPersonRecService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除招聘记录 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除招聘记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = RecruitPersonRecServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecruitPersonRecServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = recruitPersonRecService.hasRefers(ids);
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
			Result result=recruitPersonRecService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=recruitPersonRecService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新招聘记录
	*/
	@ApiOperation(value = "更新招聘记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.NAME , value = "招聘说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.POST_ID , value = "岗位名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.POST_NAME , value = "岗位名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.CONTENT , value = "招聘要求" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.START_DATE , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.END_DATE , value = "结束时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { RecruitPersonRecVOMeta.PAGE_INDEX , RecruitPersonRecVOMeta.PAGE_SIZE , RecruitPersonRecVOMeta.SEARCH_FIELD , RecruitPersonRecVOMeta.FUZZY_FIELD , RecruitPersonRecVOMeta.SEARCH_VALUE , RecruitPersonRecVOMeta.DIRTY_FIELDS , RecruitPersonRecVOMeta.SORT_FIELD , RecruitPersonRecVOMeta.SORT_TYPE , RecruitPersonRecVOMeta.DATA_ORIGIN , RecruitPersonRecVOMeta.QUERY_LOGIC , RecruitPersonRecVOMeta.REQUEST_ACTION , RecruitPersonRecVOMeta.IDS } )
	@SentinelResource(value = RecruitPersonRecServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecruitPersonRecServiceProxy.UPDATE)
	public Result update(RecruitPersonRecVO recruitPersonRecVO) {
		
		Result result=recruitPersonRecService.update(recruitPersonRecVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存招聘记录
	*/
	@ApiOperation(value = "保存招聘记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.NAME , value = "招聘说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.POST_ID , value = "岗位名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.POST_NAME , value = "岗位名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.CONTENT , value = "招聘要求" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.START_DATE , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.END_DATE , value = "结束时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RecruitPersonRecVOMeta.PAGE_INDEX , RecruitPersonRecVOMeta.PAGE_SIZE , RecruitPersonRecVOMeta.SEARCH_FIELD , RecruitPersonRecVOMeta.FUZZY_FIELD , RecruitPersonRecVOMeta.SEARCH_VALUE , RecruitPersonRecVOMeta.DIRTY_FIELDS , RecruitPersonRecVOMeta.SORT_FIELD , RecruitPersonRecVOMeta.SORT_TYPE , RecruitPersonRecVOMeta.DATA_ORIGIN , RecruitPersonRecVOMeta.QUERY_LOGIC , RecruitPersonRecVOMeta.REQUEST_ACTION , RecruitPersonRecVOMeta.IDS } )
	@SentinelResource(value = RecruitPersonRecServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecruitPersonRecServiceProxy.SAVE)
	public Result save(RecruitPersonRecVO recruitPersonRecVO) {
		
		Result result=recruitPersonRecService.save(recruitPersonRecVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取招聘记录
	*/
	@ApiOperation(value = "获取招聘记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RecruitPersonRecServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecruitPersonRecServiceProxy.GET_BY_ID)
	public Result<RecruitPersonRec> getById(String id) {
		
		Result<RecruitPersonRec> result=new Result<>();
		RecruitPersonRec recruitPersonRec=recruitPersonRecService.getById(id);
		// join 关联的对象
		recruitPersonRecService.dao().fill(recruitPersonRec)
			.with(RecruitPersonRecMeta.RECRUIT_POST_REC)
			.execute();
		result.success(true).data(recruitPersonRec);
		return result;
	}


	/**
	 * 批量获取招聘记录 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取招聘记录")
		@ApiImplicitParams({
				@ApiImplicitParam(name = RecruitPersonRecVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = RecruitPersonRecServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecruitPersonRecServiceProxy.GET_BY_IDS)
	public Result<List<RecruitPersonRec>> getByIds(List<String> ids) {
		
		Result<List<RecruitPersonRec>> result=new Result<>();
		List<RecruitPersonRec> list=recruitPersonRecService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询招聘记录
	*/
	@ApiOperation(value = "查询招聘记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.NAME , value = "招聘说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.POST_ID , value = "岗位名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.POST_NAME , value = "岗位名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.CONTENT , value = "招聘要求" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.START_DATE , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.END_DATE , value = "结束时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { RecruitPersonRecVOMeta.PAGE_INDEX , RecruitPersonRecVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RecruitPersonRecServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecruitPersonRecServiceProxy.QUERY_LIST)
	public Result<List<RecruitPersonRec>> queryList(RecruitPersonRecVO sample) {
		
		Result<List<RecruitPersonRec>> result=new Result<>();
		List<RecruitPersonRec> list=recruitPersonRecService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询招聘记录
	*/
	@ApiOperation(value = "分页查询招聘记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.NAME , value = "招聘说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.POST_ID , value = "岗位名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.POST_NAME , value = "岗位名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.CONTENT , value = "招聘要求" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.START_DATE , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RecruitPersonRecVOMeta.END_DATE , value = "结束时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RecruitPersonRecServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RecruitPersonRecServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<RecruitPersonRec>> queryPagedList(RecruitPersonRecVO sample) {
		
		Result<PagedList<RecruitPersonRec>> result=new Result<>();
		PagedList<RecruitPersonRec> list=recruitPersonRecService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		recruitPersonRecService.dao().fill(list)
			.with(RecruitPersonRecMeta.RECRUIT_POST_REC)
			.execute();
		result.success(true).data(list);
		return result;
	}





}