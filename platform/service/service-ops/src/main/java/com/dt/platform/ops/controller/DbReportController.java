package com.dt.platform.ops.controller;

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


import com.dt.platform.proxy.ops.DbReportServiceProxy;
import com.dt.platform.domain.ops.meta.DbReportVOMeta;
import com.dt.platform.domain.ops.DbReport;
import com.dt.platform.domain.ops.DbReportVO;
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
import com.dt.platform.domain.ops.meta.DbReportMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IDbReportService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 性能报接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-23 11:34:08
*/

@InDoc
@Api(tags = "性能报")
@RestController("OpsDbReportController")
public class DbReportController extends SuperController {

	@Autowired
	private IDbReportService dbReportService;

	/**
	 * 添加性能报
	*/
	@ApiOperation(value = "添加性能报")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbReportVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbReportVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbReportVOMeta.CONTENT , value = "报告内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbReportVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbReportVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbReportVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbReportServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbReportServiceProxy.INSERT)
	public Result insert(DbReportVO dbReportVO) {
		
		Result result=dbReportService.insert(dbReportVO,false);
		return result;
	}



	/**
	 * 删除性能报
	*/
	@ApiOperation(value = "删除性能报")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbReportVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbReportServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbReportServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  dbReportService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=dbReportService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除性能报 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除性能报")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbReportVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = DbReportServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbReportServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = dbReportService.hasRefers(ids);
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
			Result result=dbReportService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=dbReportService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新性能报
	*/
	@ApiOperation(value = "更新性能报")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbReportVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbReportVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbReportVOMeta.CONTENT , value = "报告内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbReportVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbReportVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbReportVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DbReportVOMeta.PAGE_INDEX , DbReportVOMeta.PAGE_SIZE , DbReportVOMeta.SEARCH_FIELD , DbReportVOMeta.FUZZY_FIELD , DbReportVOMeta.SEARCH_VALUE , DbReportVOMeta.DIRTY_FIELDS , DbReportVOMeta.SORT_FIELD , DbReportVOMeta.SORT_TYPE , DbReportVOMeta.DATA_ORIGIN , DbReportVOMeta.QUERY_LOGIC , DbReportVOMeta.REQUEST_ACTION , DbReportVOMeta.IDS } )
	@SentinelResource(value = DbReportServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbReportServiceProxy.UPDATE)
	public Result update(DbReportVO dbReportVO) {
		
		Result result=dbReportService.update(dbReportVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存性能报
	*/
	@ApiOperation(value = "保存性能报")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbReportVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbReportVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbReportVOMeta.CONTENT , value = "报告内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbReportVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbReportVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbReportVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DbReportVOMeta.PAGE_INDEX , DbReportVOMeta.PAGE_SIZE , DbReportVOMeta.SEARCH_FIELD , DbReportVOMeta.FUZZY_FIELD , DbReportVOMeta.SEARCH_VALUE , DbReportVOMeta.DIRTY_FIELDS , DbReportVOMeta.SORT_FIELD , DbReportVOMeta.SORT_TYPE , DbReportVOMeta.DATA_ORIGIN , DbReportVOMeta.QUERY_LOGIC , DbReportVOMeta.REQUEST_ACTION , DbReportVOMeta.IDS } )
	@SentinelResource(value = DbReportServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbReportServiceProxy.SAVE)
	public Result save(DbReportVO dbReportVO) {
		
		Result result=dbReportService.save(dbReportVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取性能报
	*/
	@ApiOperation(value = "获取性能报")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbReportVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbReportServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbReportServiceProxy.GET_BY_ID)
	public Result<DbReport> getById(String id) {
		
		Result<DbReport> result=new Result<>();
		DbReport dbReport=dbReportService.getById(id);
		result.success(true).data(dbReport);
		return result;
	}


	/**
	 * 批量获取性能报 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取性能报")
		@ApiImplicitParams({
				@ApiImplicitParam(name = DbReportVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = DbReportServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbReportServiceProxy.GET_BY_IDS)
	public Result<List<DbReport>> getByIds(List<String> ids) {
		
		Result<List<DbReport>> result=new Result<>();
		List<DbReport> list=dbReportService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询性能报
	*/
	@ApiOperation(value = "查询性能报")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbReportVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbReportVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbReportVOMeta.CONTENT , value = "报告内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbReportVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbReportVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbReportVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DbReportVOMeta.PAGE_INDEX , DbReportVOMeta.PAGE_SIZE } )
	@SentinelResource(value = DbReportServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbReportServiceProxy.QUERY_LIST)
	public Result<List<DbReport>> queryList(DbReportVO sample) {
		
		Result<List<DbReport>> result=new Result<>();
		List<DbReport> list=dbReportService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询性能报
	*/
	@ApiOperation(value = "分页查询性能报")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbReportVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbReportVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbReportVOMeta.CONTENT , value = "报告内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbReportVOMeta.FILE_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbReportVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbReportVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbReportServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbReportServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<DbReport>> queryPagedList(DbReportVO sample) {
		
		Result<PagedList<DbReport>> result=new Result<>();
		PagedList<DbReport> list=dbReportService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}