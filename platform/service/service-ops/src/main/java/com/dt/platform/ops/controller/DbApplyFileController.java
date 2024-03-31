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


import com.dt.platform.proxy.ops.DbApplyFileServiceProxy;
import com.dt.platform.domain.ops.meta.DbApplyFileVOMeta;
import com.dt.platform.domain.ops.DbApplyFile;
import com.dt.platform.domain.ops.DbApplyFileVO;
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
import com.dt.platform.domain.ops.meta.DbApplyFileMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IDbApplyFileService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 附件接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-29 22:49:32
*/

@InDoc
@Api(tags = "附件")
@RestController("OpsDbApplyFileController")
public class DbApplyFileController extends SuperController {

	@Autowired
	private IDbApplyFileService dbApplyFileService;

	/**
	 * 添加附件
	*/
	@ApiOperation(value = "添加附件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbApplyFileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbApplyFileVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbApplyFileVOMeta.FILE_ID , value = "SQL文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbApplyFileVOMeta.SN , value = "执行顺序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = DbApplyFileVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbApplyFileServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbApplyFileServiceProxy.INSERT)
	public Result insert(DbApplyFileVO dbApplyFileVO) {
		
		Result result=dbApplyFileService.insert(dbApplyFileVO,false);
		return result;
	}



	/**
	 * 删除附件
	*/
	@ApiOperation(value = "删除附件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbApplyFileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbApplyFileServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbApplyFileServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  dbApplyFileService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=dbApplyFileService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除附件 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除附件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbApplyFileVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = DbApplyFileServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbApplyFileServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = dbApplyFileService.hasRefers(ids);
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
			Result result=dbApplyFileService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=dbApplyFileService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新附件
	*/
	@ApiOperation(value = "更新附件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbApplyFileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbApplyFileVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbApplyFileVOMeta.FILE_ID , value = "SQL文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbApplyFileVOMeta.SN , value = "执行顺序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = DbApplyFileVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DbApplyFileVOMeta.PAGE_INDEX , DbApplyFileVOMeta.PAGE_SIZE , DbApplyFileVOMeta.SEARCH_FIELD , DbApplyFileVOMeta.FUZZY_FIELD , DbApplyFileVOMeta.SEARCH_VALUE , DbApplyFileVOMeta.DIRTY_FIELDS , DbApplyFileVOMeta.SORT_FIELD , DbApplyFileVOMeta.SORT_TYPE , DbApplyFileVOMeta.DATA_ORIGIN , DbApplyFileVOMeta.QUERY_LOGIC , DbApplyFileVOMeta.REQUEST_ACTION , DbApplyFileVOMeta.IDS } )
	@SentinelResource(value = DbApplyFileServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbApplyFileServiceProxy.UPDATE)
	public Result update(DbApplyFileVO dbApplyFileVO) {
		
		Result result=dbApplyFileService.update(dbApplyFileVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存附件
	*/
	@ApiOperation(value = "保存附件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbApplyFileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbApplyFileVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbApplyFileVOMeta.FILE_ID , value = "SQL文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbApplyFileVOMeta.SN , value = "执行顺序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = DbApplyFileVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DbApplyFileVOMeta.PAGE_INDEX , DbApplyFileVOMeta.PAGE_SIZE , DbApplyFileVOMeta.SEARCH_FIELD , DbApplyFileVOMeta.FUZZY_FIELD , DbApplyFileVOMeta.SEARCH_VALUE , DbApplyFileVOMeta.DIRTY_FIELDS , DbApplyFileVOMeta.SORT_FIELD , DbApplyFileVOMeta.SORT_TYPE , DbApplyFileVOMeta.DATA_ORIGIN , DbApplyFileVOMeta.QUERY_LOGIC , DbApplyFileVOMeta.REQUEST_ACTION , DbApplyFileVOMeta.IDS } )
	@SentinelResource(value = DbApplyFileServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbApplyFileServiceProxy.SAVE)
	public Result save(DbApplyFileVO dbApplyFileVO) {
		
		Result result=dbApplyFileService.save(dbApplyFileVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取附件
	*/
	@ApiOperation(value = "获取附件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbApplyFileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbApplyFileServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbApplyFileServiceProxy.GET_BY_ID)
	public Result<DbApplyFile> getById(String id) {
		
		Result<DbApplyFile> result=new Result<>();
		DbApplyFile dbApplyFile=dbApplyFileService.getById(id);
		result.success(true).data(dbApplyFile);
		return result;
	}


	/**
	 * 批量获取附件 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取附件")
		@ApiImplicitParams({
				@ApiImplicitParam(name = DbApplyFileVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = DbApplyFileServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbApplyFileServiceProxy.GET_BY_IDS)
	public Result<List<DbApplyFile>> getByIds(List<String> ids) {
		
		Result<List<DbApplyFile>> result=new Result<>();
		List<DbApplyFile> list=dbApplyFileService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询附件
	*/
	@ApiOperation(value = "查询附件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbApplyFileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbApplyFileVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbApplyFileVOMeta.FILE_ID , value = "SQL文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbApplyFileVOMeta.SN , value = "执行顺序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = DbApplyFileVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DbApplyFileVOMeta.PAGE_INDEX , DbApplyFileVOMeta.PAGE_SIZE } )
	@SentinelResource(value = DbApplyFileServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbApplyFileServiceProxy.QUERY_LIST)
	public Result<List<DbApplyFile>> queryList(DbApplyFileVO sample) {
		
		Result<List<DbApplyFile>> result=new Result<>();
		List<DbApplyFile> list=dbApplyFileService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询附件
	*/
	@ApiOperation(value = "分页查询附件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbApplyFileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbApplyFileVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbApplyFileVOMeta.FILE_ID , value = "SQL文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbApplyFileVOMeta.SN , value = "执行顺序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = DbApplyFileVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbApplyFileServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbApplyFileServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<DbApplyFile>> queryPagedList(DbApplyFileVO sample) {
		
		Result<PagedList<DbApplyFile>> result=new Result<>();
		PagedList<DbApplyFile> list=dbApplyFileService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}