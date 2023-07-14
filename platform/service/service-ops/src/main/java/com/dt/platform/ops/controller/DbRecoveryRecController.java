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


import com.dt.platform.proxy.ops.DbRecoveryRecServiceProxy;
import com.dt.platform.domain.ops.meta.DbRecoveryRecVOMeta;
import com.dt.platform.domain.ops.DbRecoveryRec;
import com.dt.platform.domain.ops.DbRecoveryRecVO;
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
import com.dt.platform.domain.ops.meta.DbRecoveryRecMeta;
import com.dt.platform.domain.ops.DbInstance;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IDbRecoveryRecService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 数据库恢复接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-14 20:47:35
*/

@InDoc
@Api(tags = "数据库恢复")
@RestController("OpsDbRecoveryRecController")
public class DbRecoveryRecController extends SuperController {

	@Autowired
	private IDbRecoveryRecService dbRecoveryRecService;

	/**
	 * 添加数据库恢复
	*/
	@ApiOperation(value = "添加数据库恢复")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.DB_INSTANCE_ID , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.REC_DATE , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbRecoveryRecServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbRecoveryRecServiceProxy.INSERT)
	public Result insert(DbRecoveryRecVO dbRecoveryRecVO) {
		
		Result result=dbRecoveryRecService.insert(dbRecoveryRecVO,false);
		return result;
	}



	/**
	 * 删除数据库恢复
	*/
	@ApiOperation(value = "删除数据库恢复")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbRecoveryRecServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbRecoveryRecServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  dbRecoveryRecService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=dbRecoveryRecService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除数据库恢复 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除数据库恢复")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = DbRecoveryRecServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbRecoveryRecServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = dbRecoveryRecService.hasRefers(ids);
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
			Result result=dbRecoveryRecService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=dbRecoveryRecService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新数据库恢复
	*/
	@ApiOperation(value = "更新数据库恢复")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.DB_INSTANCE_ID , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.REC_DATE , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DbRecoveryRecVOMeta.PAGE_INDEX , DbRecoveryRecVOMeta.PAGE_SIZE , DbRecoveryRecVOMeta.SEARCH_FIELD , DbRecoveryRecVOMeta.FUZZY_FIELD , DbRecoveryRecVOMeta.SEARCH_VALUE , DbRecoveryRecVOMeta.DIRTY_FIELDS , DbRecoveryRecVOMeta.SORT_FIELD , DbRecoveryRecVOMeta.SORT_TYPE , DbRecoveryRecVOMeta.DATA_ORIGIN , DbRecoveryRecVOMeta.QUERY_LOGIC , DbRecoveryRecVOMeta.REQUEST_ACTION , DbRecoveryRecVOMeta.IDS } )
	@SentinelResource(value = DbRecoveryRecServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbRecoveryRecServiceProxy.UPDATE)
	public Result update(DbRecoveryRecVO dbRecoveryRecVO) {
		
		Result result=dbRecoveryRecService.update(dbRecoveryRecVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存数据库恢复
	*/
	@ApiOperation(value = "保存数据库恢复")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.DB_INSTANCE_ID , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.REC_DATE , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DbRecoveryRecVOMeta.PAGE_INDEX , DbRecoveryRecVOMeta.PAGE_SIZE , DbRecoveryRecVOMeta.SEARCH_FIELD , DbRecoveryRecVOMeta.FUZZY_FIELD , DbRecoveryRecVOMeta.SEARCH_VALUE , DbRecoveryRecVOMeta.DIRTY_FIELDS , DbRecoveryRecVOMeta.SORT_FIELD , DbRecoveryRecVOMeta.SORT_TYPE , DbRecoveryRecVOMeta.DATA_ORIGIN , DbRecoveryRecVOMeta.QUERY_LOGIC , DbRecoveryRecVOMeta.REQUEST_ACTION , DbRecoveryRecVOMeta.IDS } )
	@SentinelResource(value = DbRecoveryRecServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbRecoveryRecServiceProxy.SAVE)
	public Result save(DbRecoveryRecVO dbRecoveryRecVO) {
		
		Result result=dbRecoveryRecService.save(dbRecoveryRecVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取数据库恢复
	*/
	@ApiOperation(value = "获取数据库恢复")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbRecoveryRecServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbRecoveryRecServiceProxy.GET_BY_ID)
	public Result<DbRecoveryRec> getById(String id) {
		
		Result<DbRecoveryRec> result=new Result<>();
		DbRecoveryRec dbRecoveryRec=dbRecoveryRecService.getById(id);
		// join 关联的对象
		dbRecoveryRecService.dao().fill(dbRecoveryRec)
			.with(DbRecoveryRecMeta.DB_INSTANCE)
			.execute();
		result.success(true).data(dbRecoveryRec);
		return result;
	}


	/**
	 * 批量获取数据库恢复 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取数据库恢复")
		@ApiImplicitParams({
				@ApiImplicitParam(name = DbRecoveryRecVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = DbRecoveryRecServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbRecoveryRecServiceProxy.GET_BY_IDS)
	public Result<List<DbRecoveryRec>> getByIds(List<String> ids) {
		
		Result<List<DbRecoveryRec>> result=new Result<>();
		List<DbRecoveryRec> list=dbRecoveryRecService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询数据库恢复
	*/
	@ApiOperation(value = "查询数据库恢复")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.DB_INSTANCE_ID , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.REC_DATE , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DbRecoveryRecVOMeta.PAGE_INDEX , DbRecoveryRecVOMeta.PAGE_SIZE } )
	@SentinelResource(value = DbRecoveryRecServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbRecoveryRecServiceProxy.QUERY_LIST)
	public Result<List<DbRecoveryRec>> queryList(DbRecoveryRecVO sample) {
		
		Result<List<DbRecoveryRec>> result=new Result<>();
		List<DbRecoveryRec> list=dbRecoveryRecService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询数据库恢复
	*/
	@ApiOperation(value = "分页查询数据库恢复")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.DB_INSTANCE_ID , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.REC_DATE , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbRecoveryRecVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbRecoveryRecServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbRecoveryRecServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<DbRecoveryRec>> queryPagedList(DbRecoveryRecVO sample) {
		
		Result<PagedList<DbRecoveryRec>> result=new Result<>();
		PagedList<DbRecoveryRec> list=dbRecoveryRecService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		dbRecoveryRecService.dao().fill(list)
			.with(DbRecoveryRecMeta.DB_INSTANCE)
			.execute();
		result.success(true).data(list);
		return result;
	}





}