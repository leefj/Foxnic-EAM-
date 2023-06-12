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


import com.dt.platform.proxy.ops.DbInspectionServiceProxy;
import com.dt.platform.domain.ops.meta.DbInspectionVOMeta;
import com.dt.platform.domain.ops.DbInspection;
import com.dt.platform.domain.ops.DbInspectionVO;
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
import com.dt.platform.domain.ops.meta.DbInspectionMeta;
import com.dt.platform.domain.ops.DbInstance;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IDbInspectionService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 数据库巡检接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-11 09:33:49
*/

@InDoc
@Api(tags = "数据库巡检")
@RestController("OpsDbInspectionController")
public class DbInspectionController extends SuperController {

	@Autowired
	private IDbInspectionService dbInspectionService;

	/**
	 * 添加数据库巡检
	*/
	@ApiOperation(value = "添加数据库巡检")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbInspectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "720207508114767872"),
		@ApiImplicitParam(name = DbInspectionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "阿斯顿发"),
		@ApiImplicitParam(name = DbInspectionVOMeta.ACTION_USER , value = "巡检方" , required = false , dataTypeClass=String.class , example = "阿道夫"),
		@ApiImplicitParam(name = DbInspectionVOMeta.RESULT , value = "巡检结果" , required = false , dataTypeClass=String.class , example = "阿道夫"),
		@ApiImplicitParam(name = DbInspectionVOMeta.RCD_DATE , value = "记录时间" , required = false , dataTypeClass=Date.class , example = "2023-06-07 12:00:00"),
		@ApiImplicitParam(name = DbInspectionVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class , example = "720207503857549313"),
		@ApiImplicitParam(name = DbInspectionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "阿道夫"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbInspectionServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbInspectionServiceProxy.INSERT)
	public Result insert(DbInspectionVO dbInspectionVO) {
		
		Result result=dbInspectionService.insert(dbInspectionVO,false);
		return result;
	}



	/**
	 * 删除数据库巡检
	*/
	@ApiOperation(value = "删除数据库巡检")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbInspectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "720207508114767872")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbInspectionServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbInspectionServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  dbInspectionService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=dbInspectionService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除数据库巡检 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除数据库巡检")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbInspectionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = DbInspectionServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbInspectionServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = dbInspectionService.hasRefers(ids);
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
			Result result=dbInspectionService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=dbInspectionService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新数据库巡检
	*/
	@ApiOperation(value = "更新数据库巡检")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbInspectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "720207508114767872"),
		@ApiImplicitParam(name = DbInspectionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "阿斯顿发"),
		@ApiImplicitParam(name = DbInspectionVOMeta.ACTION_USER , value = "巡检方" , required = false , dataTypeClass=String.class , example = "阿道夫"),
		@ApiImplicitParam(name = DbInspectionVOMeta.RESULT , value = "巡检结果" , required = false , dataTypeClass=String.class , example = "阿道夫"),
		@ApiImplicitParam(name = DbInspectionVOMeta.RCD_DATE , value = "记录时间" , required = false , dataTypeClass=Date.class , example = "2023-06-07 12:00:00"),
		@ApiImplicitParam(name = DbInspectionVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class , example = "720207503857549313"),
		@ApiImplicitParam(name = DbInspectionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "阿道夫"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DbInspectionVOMeta.PAGE_INDEX , DbInspectionVOMeta.PAGE_SIZE , DbInspectionVOMeta.SEARCH_FIELD , DbInspectionVOMeta.FUZZY_FIELD , DbInspectionVOMeta.SEARCH_VALUE , DbInspectionVOMeta.DIRTY_FIELDS , DbInspectionVOMeta.SORT_FIELD , DbInspectionVOMeta.SORT_TYPE , DbInspectionVOMeta.DATA_ORIGIN , DbInspectionVOMeta.QUERY_LOGIC , DbInspectionVOMeta.REQUEST_ACTION , DbInspectionVOMeta.IDS } )
	@SentinelResource(value = DbInspectionServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbInspectionServiceProxy.UPDATE)
	public Result update(DbInspectionVO dbInspectionVO) {
		
		Result result=dbInspectionService.update(dbInspectionVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存数据库巡检
	*/
	@ApiOperation(value = "保存数据库巡检")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbInspectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "720207508114767872"),
		@ApiImplicitParam(name = DbInspectionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "阿斯顿发"),
		@ApiImplicitParam(name = DbInspectionVOMeta.ACTION_USER , value = "巡检方" , required = false , dataTypeClass=String.class , example = "阿道夫"),
		@ApiImplicitParam(name = DbInspectionVOMeta.RESULT , value = "巡检结果" , required = false , dataTypeClass=String.class , example = "阿道夫"),
		@ApiImplicitParam(name = DbInspectionVOMeta.RCD_DATE , value = "记录时间" , required = false , dataTypeClass=Date.class , example = "2023-06-07 12:00:00"),
		@ApiImplicitParam(name = DbInspectionVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class , example = "720207503857549313"),
		@ApiImplicitParam(name = DbInspectionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "阿道夫"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DbInspectionVOMeta.PAGE_INDEX , DbInspectionVOMeta.PAGE_SIZE , DbInspectionVOMeta.SEARCH_FIELD , DbInspectionVOMeta.FUZZY_FIELD , DbInspectionVOMeta.SEARCH_VALUE , DbInspectionVOMeta.DIRTY_FIELDS , DbInspectionVOMeta.SORT_FIELD , DbInspectionVOMeta.SORT_TYPE , DbInspectionVOMeta.DATA_ORIGIN , DbInspectionVOMeta.QUERY_LOGIC , DbInspectionVOMeta.REQUEST_ACTION , DbInspectionVOMeta.IDS } )
	@SentinelResource(value = DbInspectionServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbInspectionServiceProxy.SAVE)
	public Result save(DbInspectionVO dbInspectionVO) {
		
		Result result=dbInspectionService.save(dbInspectionVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取数据库巡检
	*/
	@ApiOperation(value = "获取数据库巡检")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbInspectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbInspectionServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbInspectionServiceProxy.GET_BY_ID)
	public Result<DbInspection> getById(String id) {
		
		Result<DbInspection> result=new Result<>();
		DbInspection dbInspection=dbInspectionService.getById(id);
		result.success(true).data(dbInspection);
		return result;
	}


	/**
	 * 批量获取数据库巡检 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取数据库巡检")
		@ApiImplicitParams({
				@ApiImplicitParam(name = DbInspectionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = DbInspectionServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbInspectionServiceProxy.GET_BY_IDS)
	public Result<List<DbInspection>> getByIds(List<String> ids) {
		
		Result<List<DbInspection>> result=new Result<>();
		List<DbInspection> list=dbInspectionService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询数据库巡检
	*/
	@ApiOperation(value = "查询数据库巡检")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbInspectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "720207508114767872"),
		@ApiImplicitParam(name = DbInspectionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "阿斯顿发"),
		@ApiImplicitParam(name = DbInspectionVOMeta.ACTION_USER , value = "巡检方" , required = false , dataTypeClass=String.class , example = "阿道夫"),
		@ApiImplicitParam(name = DbInspectionVOMeta.RESULT , value = "巡检结果" , required = false , dataTypeClass=String.class , example = "阿道夫"),
		@ApiImplicitParam(name = DbInspectionVOMeta.RCD_DATE , value = "记录时间" , required = false , dataTypeClass=Date.class , example = "2023-06-07 12:00:00"),
		@ApiImplicitParam(name = DbInspectionVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class , example = "720207503857549313"),
		@ApiImplicitParam(name = DbInspectionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "阿道夫"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DbInspectionVOMeta.PAGE_INDEX , DbInspectionVOMeta.PAGE_SIZE } )
	@SentinelResource(value = DbInspectionServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbInspectionServiceProxy.QUERY_LIST)
	public Result<List<DbInspection>> queryList(DbInspectionVO sample) {
		
		Result<List<DbInspection>> result=new Result<>();
		List<DbInspection> list=dbInspectionService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询数据库巡检
	*/
	@ApiOperation(value = "分页查询数据库巡检")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbInspectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "720207508114767872"),
		@ApiImplicitParam(name = DbInspectionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "阿斯顿发"),
		@ApiImplicitParam(name = DbInspectionVOMeta.ACTION_USER , value = "巡检方" , required = false , dataTypeClass=String.class , example = "阿道夫"),
		@ApiImplicitParam(name = DbInspectionVOMeta.RESULT , value = "巡检结果" , required = false , dataTypeClass=String.class , example = "阿道夫"),
		@ApiImplicitParam(name = DbInspectionVOMeta.RCD_DATE , value = "记录时间" , required = false , dataTypeClass=Date.class , example = "2023-06-07 12:00:00"),
		@ApiImplicitParam(name = DbInspectionVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class , example = "720207503857549313"),
		@ApiImplicitParam(name = DbInspectionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "阿道夫"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbInspectionServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbInspectionServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<DbInspection>> queryPagedList(DbInspectionVO sample) {
		
		Result<PagedList<DbInspection>> result=new Result<>();
		PagedList<DbInspection> list=dbInspectionService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}