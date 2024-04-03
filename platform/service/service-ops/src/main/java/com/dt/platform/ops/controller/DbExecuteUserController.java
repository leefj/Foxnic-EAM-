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


import com.dt.platform.proxy.ops.DbExecuteUserServiceProxy;
import com.dt.platform.domain.ops.meta.DbExecuteUserVOMeta;
import com.dt.platform.domain.ops.DbExecuteUser;
import com.dt.platform.domain.ops.DbExecuteUserVO;
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
import com.dt.platform.domain.ops.meta.DbExecuteUserMeta;
import com.dt.platform.domain.ops.DbInfoApply;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IDbExecuteUserService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 数据库人员接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-31 21:12:53
*/

@InDoc
@Api(tags = "数据库人员")
@RestController("OpsDbExecuteUserController")
public class DbExecuteUserController extends SuperController {

	@Autowired
	private IDbExecuteUserService dbExecuteUserService;

	/**
	 * 添加数据库人员
	*/
	@ApiOperation(value = "添加数据库人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbExecuteUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExecuteUserVOMeta.USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExecuteUserVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExecuteUserVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbExecuteUserServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbExecuteUserServiceProxy.INSERT)
	public Result insert(DbExecuteUserVO dbExecuteUserVO) {
		
		Result result=dbExecuteUserService.insert(dbExecuteUserVO,false);
		return result;
	}



	/**
	 * 删除数据库人员
	*/
	@ApiOperation(value = "删除数据库人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbExecuteUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbExecuteUserServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbExecuteUserServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  dbExecuteUserService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=dbExecuteUserService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除数据库人员 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除数据库人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbExecuteUserVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = DbExecuteUserServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbExecuteUserServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = dbExecuteUserService.hasRefers(ids);
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
			Result result=dbExecuteUserService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=dbExecuteUserService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新数据库人员
	*/
	@ApiOperation(value = "更新数据库人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbExecuteUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExecuteUserVOMeta.USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExecuteUserVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExecuteUserVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DbExecuteUserVOMeta.PAGE_INDEX , DbExecuteUserVOMeta.PAGE_SIZE , DbExecuteUserVOMeta.SEARCH_FIELD , DbExecuteUserVOMeta.FUZZY_FIELD , DbExecuteUserVOMeta.SEARCH_VALUE , DbExecuteUserVOMeta.DIRTY_FIELDS , DbExecuteUserVOMeta.SORT_FIELD , DbExecuteUserVOMeta.SORT_TYPE , DbExecuteUserVOMeta.DATA_ORIGIN , DbExecuteUserVOMeta.QUERY_LOGIC , DbExecuteUserVOMeta.REQUEST_ACTION , DbExecuteUserVOMeta.IDS } )
	@SentinelResource(value = DbExecuteUserServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbExecuteUserServiceProxy.UPDATE)
	public Result update(DbExecuteUserVO dbExecuteUserVO) {
		
		Result result=dbExecuteUserService.update(dbExecuteUserVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存数据库人员
	*/
	@ApiOperation(value = "保存数据库人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbExecuteUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExecuteUserVOMeta.USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExecuteUserVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExecuteUserVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DbExecuteUserVOMeta.PAGE_INDEX , DbExecuteUserVOMeta.PAGE_SIZE , DbExecuteUserVOMeta.SEARCH_FIELD , DbExecuteUserVOMeta.FUZZY_FIELD , DbExecuteUserVOMeta.SEARCH_VALUE , DbExecuteUserVOMeta.DIRTY_FIELDS , DbExecuteUserVOMeta.SORT_FIELD , DbExecuteUserVOMeta.SORT_TYPE , DbExecuteUserVOMeta.DATA_ORIGIN , DbExecuteUserVOMeta.QUERY_LOGIC , DbExecuteUserVOMeta.REQUEST_ACTION , DbExecuteUserVOMeta.IDS } )
	@SentinelResource(value = DbExecuteUserServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbExecuteUserServiceProxy.SAVE)
	public Result save(DbExecuteUserVO dbExecuteUserVO) {
		
		Result result=dbExecuteUserService.save(dbExecuteUserVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取数据库人员
	*/
	@ApiOperation(value = "获取数据库人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbExecuteUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbExecuteUserServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbExecuteUserServiceProxy.GET_BY_ID)
	public Result<DbExecuteUser> getById(String id) {
		
		Result<DbExecuteUser> result=new Result<>();
		DbExecuteUser dbExecuteUser=dbExecuteUserService.getById(id);
		result.success(true).data(dbExecuteUser);
		return result;
	}


	/**
	 * 批量获取数据库人员 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取数据库人员")
		@ApiImplicitParams({
				@ApiImplicitParam(name = DbExecuteUserVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = DbExecuteUserServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbExecuteUserServiceProxy.GET_BY_IDS)
	public Result<List<DbExecuteUser>> getByIds(List<String> ids) {
		
		Result<List<DbExecuteUser>> result=new Result<>();
		List<DbExecuteUser> list=dbExecuteUserService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询数据库人员
	*/
	@ApiOperation(value = "查询数据库人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbExecuteUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExecuteUserVOMeta.USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExecuteUserVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExecuteUserVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DbExecuteUserVOMeta.PAGE_INDEX , DbExecuteUserVOMeta.PAGE_SIZE } )
	@SentinelResource(value = DbExecuteUserServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbExecuteUserServiceProxy.QUERY_LIST)
	public Result<List<DbExecuteUser>> queryList(DbExecuteUserVO sample) {
		
		Result<List<DbExecuteUser>> result=new Result<>();
		List<DbExecuteUser> list=dbExecuteUserService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询数据库人员
	*/
	@ApiOperation(value = "分页查询数据库人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbExecuteUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExecuteUserVOMeta.USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExecuteUserVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbExecuteUserVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbExecuteUserServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbExecuteUserServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<DbExecuteUser>> queryPagedList(DbExecuteUserVO sample) {
		
		Result<PagedList<DbExecuteUser>> result=new Result<>();
		PagedList<DbExecuteUser> list=dbExecuteUserService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}