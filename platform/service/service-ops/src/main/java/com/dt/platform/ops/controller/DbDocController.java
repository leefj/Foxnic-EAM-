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


import com.dt.platform.proxy.ops.DbDocServiceProxy;
import com.dt.platform.domain.ops.meta.DbDocVOMeta;
import com.dt.platform.domain.ops.DbDoc;
import com.dt.platform.domain.ops.DbDocVO;
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
import com.dt.platform.domain.ops.meta.DbDocMeta;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IDbDocService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 数据库文档接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-14 20:44:37
*/

@InDoc
@Api(tags = "数据库文档")
@RestController("OpsDbDocController")
public class DbDocController extends SuperController {

	@Autowired
	private IDbDocService dbDocService;

	/**
	 * 添加数据库文档
	*/
	@ApiOperation(value = "添加数据库文档")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbDocVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "718914490640367616"),
		@ApiImplicitParam(name = DbDocVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = DbDocVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "doc_tpl"),
		@ApiImplicitParam(name = DbDocVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "valid"),
		@ApiImplicitParam(name = DbDocVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class , example = "718915325168451584"),
		@ApiImplicitParam(name = DbDocVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "121212"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbDocServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbDocServiceProxy.INSERT)
	public Result insert(DbDocVO dbDocVO) {
		
		Result result=dbDocService.insert(dbDocVO,false);
		return result;
	}



	/**
	 * 删除数据库文档
	*/
	@ApiOperation(value = "删除数据库文档")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbDocVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "718914490640367616")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbDocServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbDocServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  dbDocService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=dbDocService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除数据库文档 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除数据库文档")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbDocVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = DbDocServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbDocServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = dbDocService.hasRefers(ids);
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
			Result result=dbDocService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=dbDocService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新数据库文档
	*/
	@ApiOperation(value = "更新数据库文档")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbDocVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "718914490640367616"),
		@ApiImplicitParam(name = DbDocVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = DbDocVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "doc_tpl"),
		@ApiImplicitParam(name = DbDocVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "valid"),
		@ApiImplicitParam(name = DbDocVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class , example = "718915325168451584"),
		@ApiImplicitParam(name = DbDocVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "121212"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DbDocVOMeta.PAGE_INDEX , DbDocVOMeta.PAGE_SIZE , DbDocVOMeta.SEARCH_FIELD , DbDocVOMeta.FUZZY_FIELD , DbDocVOMeta.SEARCH_VALUE , DbDocVOMeta.DIRTY_FIELDS , DbDocVOMeta.SORT_FIELD , DbDocVOMeta.SORT_TYPE , DbDocVOMeta.DATA_ORIGIN , DbDocVOMeta.QUERY_LOGIC , DbDocVOMeta.REQUEST_ACTION , DbDocVOMeta.IDS } )
	@SentinelResource(value = DbDocServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbDocServiceProxy.UPDATE)
	public Result update(DbDocVO dbDocVO) {
		
		Result result=dbDocService.update(dbDocVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存数据库文档
	*/
	@ApiOperation(value = "保存数据库文档")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbDocVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "718914490640367616"),
		@ApiImplicitParam(name = DbDocVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = DbDocVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "doc_tpl"),
		@ApiImplicitParam(name = DbDocVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "valid"),
		@ApiImplicitParam(name = DbDocVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class , example = "718915325168451584"),
		@ApiImplicitParam(name = DbDocVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "121212"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DbDocVOMeta.PAGE_INDEX , DbDocVOMeta.PAGE_SIZE , DbDocVOMeta.SEARCH_FIELD , DbDocVOMeta.FUZZY_FIELD , DbDocVOMeta.SEARCH_VALUE , DbDocVOMeta.DIRTY_FIELDS , DbDocVOMeta.SORT_FIELD , DbDocVOMeta.SORT_TYPE , DbDocVOMeta.DATA_ORIGIN , DbDocVOMeta.QUERY_LOGIC , DbDocVOMeta.REQUEST_ACTION , DbDocVOMeta.IDS } )
	@SentinelResource(value = DbDocServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbDocServiceProxy.SAVE)
	public Result save(DbDocVO dbDocVO) {
		
		Result result=dbDocService.save(dbDocVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取数据库文档
	*/
	@ApiOperation(value = "获取数据库文档")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbDocVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbDocServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbDocServiceProxy.GET_BY_ID)
	public Result<DbDoc> getById(String id) {
		
		Result<DbDoc> result=new Result<>();
		DbDoc dbDoc=dbDocService.getById(id);
		// join 关联的对象
		dbDocService.dao().fill(dbDoc)
			.with(DbDocMeta.TYPE_DATA)
			.execute();
		result.success(true).data(dbDoc);
		return result;
	}


	/**
	 * 批量获取数据库文档 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取数据库文档")
		@ApiImplicitParams({
				@ApiImplicitParam(name = DbDocVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = DbDocServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbDocServiceProxy.GET_BY_IDS)
	public Result<List<DbDoc>> getByIds(List<String> ids) {
		
		Result<List<DbDoc>> result=new Result<>();
		List<DbDoc> list=dbDocService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询数据库文档
	*/
	@ApiOperation(value = "查询数据库文档")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbDocVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "718914490640367616"),
		@ApiImplicitParam(name = DbDocVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = DbDocVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "doc_tpl"),
		@ApiImplicitParam(name = DbDocVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "valid"),
		@ApiImplicitParam(name = DbDocVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class , example = "718915325168451584"),
		@ApiImplicitParam(name = DbDocVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "121212"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DbDocVOMeta.PAGE_INDEX , DbDocVOMeta.PAGE_SIZE } )
	@SentinelResource(value = DbDocServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbDocServiceProxy.QUERY_LIST)
	public Result<List<DbDoc>> queryList(DbDocVO sample) {
		
		Result<List<DbDoc>> result=new Result<>();
		List<DbDoc> list=dbDocService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询数据库文档
	*/
	@ApiOperation(value = "分页查询数据库文档")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbDocVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "718914490640367616"),
		@ApiImplicitParam(name = DbDocVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = DbDocVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "doc_tpl"),
		@ApiImplicitParam(name = DbDocVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "valid"),
		@ApiImplicitParam(name = DbDocVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class , example = "718915325168451584"),
		@ApiImplicitParam(name = DbDocVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "121212"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbDocServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbDocServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<DbDoc>> queryPagedList(DbDocVO sample) {
		
		Result<PagedList<DbDoc>> result=new Result<>();
		PagedList<DbDoc> list=dbDocService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		dbDocService.dao().fill(list)
			.with(DbDocMeta.TYPE_DATA)
			.execute();
		result.success(true).data(list);
		return result;
	}





}