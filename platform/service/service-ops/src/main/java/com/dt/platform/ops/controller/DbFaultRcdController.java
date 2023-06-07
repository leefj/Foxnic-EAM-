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


import com.dt.platform.proxy.ops.DbFaultRcdServiceProxy;
import com.dt.platform.domain.ops.meta.DbFaultRcdVOMeta;
import com.dt.platform.domain.ops.DbFaultRcd;
import com.dt.platform.domain.ops.DbFaultRcdVO;
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
import com.dt.platform.domain.ops.meta.DbFaultRcdMeta;
import com.dt.platform.domain.ops.DbInstance;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IDbFaultRcdService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 数据库故障接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-07 22:59:26
*/

@InDoc
@Api(tags = "数据库故障")
@RestController("OpsDbFaultRcdController")
public class DbFaultRcdController extends SuperController {

	@Autowired
	private IDbFaultRcdService dbFaultRcdService;

	/**
	 * 添加数据库故障
	*/
	@ApiOperation(value = "添加数据库故障")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbFaultRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "718961003030642688"),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "jk"),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.DB_INSTANCE_ID , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.REASON , value = "原因" , required = false , dataTypeClass=String.class , example = "手工"),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.PROCESS , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.RCD_DATE , value = "记录时间" , required = false , dataTypeClass=Date.class , example = "2023-06-22 12:00:00"),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbFaultRcdServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbFaultRcdServiceProxy.INSERT)
	public Result insert(DbFaultRcdVO dbFaultRcdVO) {
		
		Result result=dbFaultRcdService.insert(dbFaultRcdVO,false);
		return result;
	}



	/**
	 * 删除数据库故障
	*/
	@ApiOperation(value = "删除数据库故障")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbFaultRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "718961003030642688")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbFaultRcdServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbFaultRcdServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  dbFaultRcdService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=dbFaultRcdService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除数据库故障 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除数据库故障")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbFaultRcdVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = DbFaultRcdServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbFaultRcdServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = dbFaultRcdService.hasRefers(ids);
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
			Result result=dbFaultRcdService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=dbFaultRcdService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新数据库故障
	*/
	@ApiOperation(value = "更新数据库故障")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbFaultRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "718961003030642688"),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "jk"),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.DB_INSTANCE_ID , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.REASON , value = "原因" , required = false , dataTypeClass=String.class , example = "手工"),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.PROCESS , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.RCD_DATE , value = "记录时间" , required = false , dataTypeClass=Date.class , example = "2023-06-22 12:00:00"),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DbFaultRcdVOMeta.PAGE_INDEX , DbFaultRcdVOMeta.PAGE_SIZE , DbFaultRcdVOMeta.SEARCH_FIELD , DbFaultRcdVOMeta.FUZZY_FIELD , DbFaultRcdVOMeta.SEARCH_VALUE , DbFaultRcdVOMeta.DIRTY_FIELDS , DbFaultRcdVOMeta.SORT_FIELD , DbFaultRcdVOMeta.SORT_TYPE , DbFaultRcdVOMeta.DATA_ORIGIN , DbFaultRcdVOMeta.QUERY_LOGIC , DbFaultRcdVOMeta.REQUEST_ACTION , DbFaultRcdVOMeta.IDS } )
	@SentinelResource(value = DbFaultRcdServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbFaultRcdServiceProxy.UPDATE)
	public Result update(DbFaultRcdVO dbFaultRcdVO) {
		
		Result result=dbFaultRcdService.update(dbFaultRcdVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存数据库故障
	*/
	@ApiOperation(value = "保存数据库故障")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbFaultRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "718961003030642688"),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "jk"),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.DB_INSTANCE_ID , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.REASON , value = "原因" , required = false , dataTypeClass=String.class , example = "手工"),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.PROCESS , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.RCD_DATE , value = "记录时间" , required = false , dataTypeClass=Date.class , example = "2023-06-22 12:00:00"),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DbFaultRcdVOMeta.PAGE_INDEX , DbFaultRcdVOMeta.PAGE_SIZE , DbFaultRcdVOMeta.SEARCH_FIELD , DbFaultRcdVOMeta.FUZZY_FIELD , DbFaultRcdVOMeta.SEARCH_VALUE , DbFaultRcdVOMeta.DIRTY_FIELDS , DbFaultRcdVOMeta.SORT_FIELD , DbFaultRcdVOMeta.SORT_TYPE , DbFaultRcdVOMeta.DATA_ORIGIN , DbFaultRcdVOMeta.QUERY_LOGIC , DbFaultRcdVOMeta.REQUEST_ACTION , DbFaultRcdVOMeta.IDS } )
	@SentinelResource(value = DbFaultRcdServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbFaultRcdServiceProxy.SAVE)
	public Result save(DbFaultRcdVO dbFaultRcdVO) {
		
		Result result=dbFaultRcdService.save(dbFaultRcdVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取数据库故障
	*/
	@ApiOperation(value = "获取数据库故障")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbFaultRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbFaultRcdServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbFaultRcdServiceProxy.GET_BY_ID)
	public Result<DbFaultRcd> getById(String id) {
		
		Result<DbFaultRcd> result=new Result<>();
		DbFaultRcd dbFaultRcd=dbFaultRcdService.getById(id);
		// join 关联的对象
		dbFaultRcdService.dao().fill(dbFaultRcd)
			.with(DbFaultRcdMeta.DB_INSTANCE)
			.execute();
		result.success(true).data(dbFaultRcd);
		return result;
	}


	/**
	 * 批量获取数据库故障 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取数据库故障")
		@ApiImplicitParams({
				@ApiImplicitParam(name = DbFaultRcdVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = DbFaultRcdServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbFaultRcdServiceProxy.GET_BY_IDS)
	public Result<List<DbFaultRcd>> getByIds(List<String> ids) {
		
		Result<List<DbFaultRcd>> result=new Result<>();
		List<DbFaultRcd> list=dbFaultRcdService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询数据库故障
	*/
	@ApiOperation(value = "查询数据库故障")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbFaultRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "718961003030642688"),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "jk"),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.DB_INSTANCE_ID , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.REASON , value = "原因" , required = false , dataTypeClass=String.class , example = "手工"),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.PROCESS , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.RCD_DATE , value = "记录时间" , required = false , dataTypeClass=Date.class , example = "2023-06-22 12:00:00"),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DbFaultRcdVOMeta.PAGE_INDEX , DbFaultRcdVOMeta.PAGE_SIZE } )
	@SentinelResource(value = DbFaultRcdServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbFaultRcdServiceProxy.QUERY_LIST)
	public Result<List<DbFaultRcd>> queryList(DbFaultRcdVO sample) {
		
		Result<List<DbFaultRcd>> result=new Result<>();
		List<DbFaultRcd> list=dbFaultRcdService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询数据库故障
	*/
	@ApiOperation(value = "分页查询数据库故障")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbFaultRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "718961003030642688"),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "jk"),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.DB_INSTANCE_ID , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.REASON , value = "原因" , required = false , dataTypeClass=String.class , example = "手工"),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.PROCESS , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.RCD_DATE , value = "记录时间" , required = false , dataTypeClass=Date.class , example = "2023-06-22 12:00:00"),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbFaultRcdVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbFaultRcdServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbFaultRcdServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<DbFaultRcd>> queryPagedList(DbFaultRcdVO sample) {
		
		Result<PagedList<DbFaultRcd>> result=new Result<>();
		PagedList<DbFaultRcd> list=dbFaultRcdService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		dbFaultRcdService.dao().fill(list)
			.with(DbFaultRcdMeta.DB_INSTANCE)
			.execute();
		result.success(true).data(list);
		return result;
	}





}