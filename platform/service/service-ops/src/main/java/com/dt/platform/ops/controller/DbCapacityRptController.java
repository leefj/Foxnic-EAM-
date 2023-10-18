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


import com.dt.platform.proxy.ops.DbCapacityRptServiceProxy;
import com.dt.platform.domain.ops.meta.DbCapacityRptVOMeta;
import com.dt.platform.domain.ops.DbCapacityRpt;
import com.dt.platform.domain.ops.DbCapacityRptVO;
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
import com.dt.platform.domain.ops.meta.DbCapacityRptMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IDbCapacityRptService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 数据库容量接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-17 16:14:55
*/

@InDoc
@Api(tags = "数据库容量")
@RestController("OpsDbCapacityRptController")
public class DbCapacityRptController extends SuperController {

	@Autowired
	private IDbCapacityRptService dbCapacityRptService;

	/**
	 * 添加数据库容量
	*/
	@ApiOperation(value = "添加数据库容量")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbCapacityRptVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "718960904019902464"),
		@ApiImplicitParam(name = DbCapacityRptVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "jj"),
		@ApiImplicitParam(name = DbCapacityRptVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class , example = "719091621919981569"),
		@ApiImplicitParam(name = DbCapacityRptVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "jjj"),
		@ApiImplicitParam(name = DbCapacityRptVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbCapacityRptServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbCapacityRptServiceProxy.INSERT)
	public Result insert(DbCapacityRptVO dbCapacityRptVO) {
		
		Result result=dbCapacityRptService.insert(dbCapacityRptVO,false);
		return result;
	}



	/**
	 * 删除数据库容量
	*/
	@ApiOperation(value = "删除数据库容量")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbCapacityRptVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "718960904019902464")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbCapacityRptServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbCapacityRptServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  dbCapacityRptService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=dbCapacityRptService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除数据库容量 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除数据库容量")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbCapacityRptVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = DbCapacityRptServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbCapacityRptServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = dbCapacityRptService.hasRefers(ids);
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
			Result result=dbCapacityRptService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=dbCapacityRptService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新数据库容量
	*/
	@ApiOperation(value = "更新数据库容量")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbCapacityRptVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "718960904019902464"),
		@ApiImplicitParam(name = DbCapacityRptVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "jj"),
		@ApiImplicitParam(name = DbCapacityRptVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class , example = "719091621919981569"),
		@ApiImplicitParam(name = DbCapacityRptVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "jjj"),
		@ApiImplicitParam(name = DbCapacityRptVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DbCapacityRptVOMeta.PAGE_INDEX , DbCapacityRptVOMeta.PAGE_SIZE , DbCapacityRptVOMeta.SEARCH_FIELD , DbCapacityRptVOMeta.FUZZY_FIELD , DbCapacityRptVOMeta.SEARCH_VALUE , DbCapacityRptVOMeta.DIRTY_FIELDS , DbCapacityRptVOMeta.SORT_FIELD , DbCapacityRptVOMeta.SORT_TYPE , DbCapacityRptVOMeta.DATA_ORIGIN , DbCapacityRptVOMeta.QUERY_LOGIC , DbCapacityRptVOMeta.REQUEST_ACTION , DbCapacityRptVOMeta.IDS } )
	@SentinelResource(value = DbCapacityRptServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbCapacityRptServiceProxy.UPDATE)
	public Result update(DbCapacityRptVO dbCapacityRptVO) {
		
		Result result=dbCapacityRptService.update(dbCapacityRptVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存数据库容量
	*/
	@ApiOperation(value = "保存数据库容量")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbCapacityRptVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "718960904019902464"),
		@ApiImplicitParam(name = DbCapacityRptVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "jj"),
		@ApiImplicitParam(name = DbCapacityRptVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class , example = "719091621919981569"),
		@ApiImplicitParam(name = DbCapacityRptVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "jjj"),
		@ApiImplicitParam(name = DbCapacityRptVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DbCapacityRptVOMeta.PAGE_INDEX , DbCapacityRptVOMeta.PAGE_SIZE , DbCapacityRptVOMeta.SEARCH_FIELD , DbCapacityRptVOMeta.FUZZY_FIELD , DbCapacityRptVOMeta.SEARCH_VALUE , DbCapacityRptVOMeta.DIRTY_FIELDS , DbCapacityRptVOMeta.SORT_FIELD , DbCapacityRptVOMeta.SORT_TYPE , DbCapacityRptVOMeta.DATA_ORIGIN , DbCapacityRptVOMeta.QUERY_LOGIC , DbCapacityRptVOMeta.REQUEST_ACTION , DbCapacityRptVOMeta.IDS } )
	@SentinelResource(value = DbCapacityRptServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbCapacityRptServiceProxy.SAVE)
	public Result save(DbCapacityRptVO dbCapacityRptVO) {
		
		Result result=dbCapacityRptService.save(dbCapacityRptVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取数据库容量
	*/
	@ApiOperation(value = "获取数据库容量")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbCapacityRptVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbCapacityRptServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbCapacityRptServiceProxy.GET_BY_ID)
	public Result<DbCapacityRpt> getById(String id) {
		
		Result<DbCapacityRpt> result=new Result<>();
		DbCapacityRpt dbCapacityRpt=dbCapacityRptService.getById(id);
		result.success(true).data(dbCapacityRpt);
		return result;
	}


	/**
	 * 批量获取数据库容量 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取数据库容量")
		@ApiImplicitParams({
				@ApiImplicitParam(name = DbCapacityRptVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = DbCapacityRptServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbCapacityRptServiceProxy.GET_BY_IDS)
	public Result<List<DbCapacityRpt>> getByIds(List<String> ids) {
		
		Result<List<DbCapacityRpt>> result=new Result<>();
		List<DbCapacityRpt> list=dbCapacityRptService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询数据库容量
	*/
	@ApiOperation(value = "查询数据库容量")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbCapacityRptVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "718960904019902464"),
		@ApiImplicitParam(name = DbCapacityRptVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "jj"),
		@ApiImplicitParam(name = DbCapacityRptVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class , example = "719091621919981569"),
		@ApiImplicitParam(name = DbCapacityRptVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "jjj"),
		@ApiImplicitParam(name = DbCapacityRptVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DbCapacityRptVOMeta.PAGE_INDEX , DbCapacityRptVOMeta.PAGE_SIZE } )
	@SentinelResource(value = DbCapacityRptServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbCapacityRptServiceProxy.QUERY_LIST)
	public Result<List<DbCapacityRpt>> queryList(DbCapacityRptVO sample) {
		
		Result<List<DbCapacityRpt>> result=new Result<>();
		List<DbCapacityRpt> list=dbCapacityRptService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询数据库容量
	*/
	@ApiOperation(value = "分页查询数据库容量")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbCapacityRptVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "718960904019902464"),
		@ApiImplicitParam(name = DbCapacityRptVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "jj"),
		@ApiImplicitParam(name = DbCapacityRptVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class , example = "719091621919981569"),
		@ApiImplicitParam(name = DbCapacityRptVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "jjj"),
		@ApiImplicitParam(name = DbCapacityRptVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbCapacityRptServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbCapacityRptServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<DbCapacityRpt>> queryPagedList(DbCapacityRptVO sample) {
		
		Result<PagedList<DbCapacityRpt>> result=new Result<>();
		PagedList<DbCapacityRpt> list=dbCapacityRptService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}