package com.dt.platform.oa.controller;

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


import com.dt.platform.proxy.oa.DownloadLogServiceProxy;
import com.dt.platform.domain.oa.meta.DownloadLogVOMeta;
import com.dt.platform.domain.oa.DownloadLog;
import com.dt.platform.domain.oa.DownloadLogVO;
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
import com.dt.platform.domain.oa.meta.DownloadLogMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.IDownloadLogService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 下载日志接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-28 22:03:10
*/

@InDoc
@Api(tags = "下载日志")
@RestController("OaDownloadLogController")
public class DownloadLogController extends SuperController {

	@Autowired
	private IDownloadLogService downloadLogService;

	/**
	 * 添加下载日志
	*/
	@ApiOperation(value = "添加下载日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DownloadLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadLogVOMeta.REC_ID , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadLogVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DownloadLogServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DownloadLogServiceProxy.INSERT)
	public Result insert(DownloadLogVO downloadLogVO) {
		
		Result result=downloadLogService.insert(downloadLogVO,false);
		return result;
	}



	/**
	 * 删除下载日志
	*/
	@ApiOperation(value = "删除下载日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DownloadLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DownloadLogServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DownloadLogServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  downloadLogService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=downloadLogService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除下载日志 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除下载日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DownloadLogVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = DownloadLogServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DownloadLogServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = downloadLogService.hasRefers(ids);
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
			Result result=downloadLogService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=downloadLogService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新下载日志
	*/
	@ApiOperation(value = "更新下载日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DownloadLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadLogVOMeta.REC_ID , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadLogVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DownloadLogVOMeta.PAGE_INDEX , DownloadLogVOMeta.PAGE_SIZE , DownloadLogVOMeta.SEARCH_FIELD , DownloadLogVOMeta.FUZZY_FIELD , DownloadLogVOMeta.SEARCH_VALUE , DownloadLogVOMeta.DIRTY_FIELDS , DownloadLogVOMeta.SORT_FIELD , DownloadLogVOMeta.SORT_TYPE , DownloadLogVOMeta.DATA_ORIGIN , DownloadLogVOMeta.QUERY_LOGIC , DownloadLogVOMeta.REQUEST_ACTION , DownloadLogVOMeta.IDS } )
	@SentinelResource(value = DownloadLogServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DownloadLogServiceProxy.UPDATE)
	public Result update(DownloadLogVO downloadLogVO) {
		
		Result result=downloadLogService.update(downloadLogVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存下载日志
	*/
	@ApiOperation(value = "保存下载日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DownloadLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadLogVOMeta.REC_ID , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadLogVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DownloadLogVOMeta.PAGE_INDEX , DownloadLogVOMeta.PAGE_SIZE , DownloadLogVOMeta.SEARCH_FIELD , DownloadLogVOMeta.FUZZY_FIELD , DownloadLogVOMeta.SEARCH_VALUE , DownloadLogVOMeta.DIRTY_FIELDS , DownloadLogVOMeta.SORT_FIELD , DownloadLogVOMeta.SORT_TYPE , DownloadLogVOMeta.DATA_ORIGIN , DownloadLogVOMeta.QUERY_LOGIC , DownloadLogVOMeta.REQUEST_ACTION , DownloadLogVOMeta.IDS } )
	@SentinelResource(value = DownloadLogServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DownloadLogServiceProxy.SAVE)
	public Result save(DownloadLogVO downloadLogVO) {
		
		Result result=downloadLogService.save(downloadLogVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取下载日志
	*/
	@ApiOperation(value = "获取下载日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DownloadLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DownloadLogServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DownloadLogServiceProxy.GET_BY_ID)
	public Result<DownloadLog> getById(String id) {
		
		Result<DownloadLog> result=new Result<>();
		DownloadLog downloadLog=downloadLogService.getById(id);
		result.success(true).data(downloadLog);
		return result;
	}


	/**
	 * 批量获取下载日志 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取下载日志")
		@ApiImplicitParams({
				@ApiImplicitParam(name = DownloadLogVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = DownloadLogServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DownloadLogServiceProxy.GET_BY_IDS)
	public Result<List<DownloadLog>> getByIds(List<String> ids) {
		
		Result<List<DownloadLog>> result=new Result<>();
		List<DownloadLog> list=downloadLogService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询下载日志
	*/
	@ApiOperation(value = "查询下载日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DownloadLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadLogVOMeta.REC_ID , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadLogVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DownloadLogVOMeta.PAGE_INDEX , DownloadLogVOMeta.PAGE_SIZE } )
	@SentinelResource(value = DownloadLogServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DownloadLogServiceProxy.QUERY_LIST)
	public Result<List<DownloadLog>> queryList(DownloadLogVO sample) {
		
		Result<List<DownloadLog>> result=new Result<>();
		List<DownloadLog> list=downloadLogService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询下载日志
	*/
	@ApiOperation(value = "分页查询下载日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DownloadLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadLogVOMeta.REC_ID , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DownloadLogVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DownloadLogServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DownloadLogServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<DownloadLog>> queryPagedList(DownloadLogVO sample) {
		
		Result<PagedList<DownloadLog>> result=new Result<>();
		PagedList<DownloadLog> list=downloadLogService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}