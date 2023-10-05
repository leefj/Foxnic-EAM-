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


import com.dt.platform.proxy.ops.MonitorTplGraphItemServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorTplGraphItemVOMeta;
import com.dt.platform.domain.ops.MonitorTplGraphItem;
import com.dt.platform.domain.ops.MonitorTplGraphItemVO;
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
import com.dt.platform.domain.ops.meta.MonitorTplGraphItemMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorTplGraphItemService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 图形指标接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-04 09:22:12
*/

@InDoc
@Api(tags = "图形指标")
@RestController("OpsMonitorTplGraphItemController")
public class MonitorTplGraphItemController extends SuperController {

	@Autowired
	private IMonitorTplGraphItemService monitorTplGraphItemService;

	/**
	 * 添加图形指标
	*/
	@ApiOperation(value = "添加图形指标")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.GRAPH_ID , value = "图形" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.INDICATOR_CODE , value = "指标" , required = false , dataTypeClass=String.class , example = "os.cpu"),
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "CPU用户使用率"),
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.ROUTE , value = "数据" , required = false , dataTypeClass=String.class , example = "cpu_user"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MonitorTplGraphItemServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplGraphItemServiceProxy.INSERT)
	public Result insert(MonitorTplGraphItemVO monitorTplGraphItemVO) {
		
		Result result=monitorTplGraphItemService.insert(monitorTplGraphItemVO,false);
		return result;
	}



	/**
	 * 删除图形指标
	*/
	@ApiOperation(value = "删除图形指标")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MonitorTplGraphItemServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplGraphItemServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  monitorTplGraphItemService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=monitorTplGraphItemService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除图形指标 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除图形指标")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = MonitorTplGraphItemServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplGraphItemServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = monitorTplGraphItemService.hasRefers(ids);
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
			Result result=monitorTplGraphItemService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=monitorTplGraphItemService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新图形指标
	*/
	@ApiOperation(value = "更新图形指标")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.GRAPH_ID , value = "图形" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.INDICATOR_CODE , value = "指标" , required = false , dataTypeClass=String.class , example = "os.cpu"),
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "CPU用户使用率"),
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.ROUTE , value = "数据" , required = false , dataTypeClass=String.class , example = "cpu_user"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { MonitorTplGraphItemVOMeta.PAGE_INDEX , MonitorTplGraphItemVOMeta.PAGE_SIZE , MonitorTplGraphItemVOMeta.SEARCH_FIELD , MonitorTplGraphItemVOMeta.FUZZY_FIELD , MonitorTplGraphItemVOMeta.SEARCH_VALUE , MonitorTplGraphItemVOMeta.DIRTY_FIELDS , MonitorTplGraphItemVOMeta.SORT_FIELD , MonitorTplGraphItemVOMeta.SORT_TYPE , MonitorTplGraphItemVOMeta.DATA_ORIGIN , MonitorTplGraphItemVOMeta.QUERY_LOGIC , MonitorTplGraphItemVOMeta.REQUEST_ACTION , MonitorTplGraphItemVOMeta.IDS } )
	@SentinelResource(value = MonitorTplGraphItemServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplGraphItemServiceProxy.UPDATE)
	public Result update(MonitorTplGraphItemVO monitorTplGraphItemVO) {
		
		Result result=monitorTplGraphItemService.update(monitorTplGraphItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存图形指标
	*/
	@ApiOperation(value = "保存图形指标")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.GRAPH_ID , value = "图形" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.INDICATOR_CODE , value = "指标" , required = false , dataTypeClass=String.class , example = "os.cpu"),
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "CPU用户使用率"),
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.ROUTE , value = "数据" , required = false , dataTypeClass=String.class , example = "cpu_user"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorTplGraphItemVOMeta.PAGE_INDEX , MonitorTplGraphItemVOMeta.PAGE_SIZE , MonitorTplGraphItemVOMeta.SEARCH_FIELD , MonitorTplGraphItemVOMeta.FUZZY_FIELD , MonitorTplGraphItemVOMeta.SEARCH_VALUE , MonitorTplGraphItemVOMeta.DIRTY_FIELDS , MonitorTplGraphItemVOMeta.SORT_FIELD , MonitorTplGraphItemVOMeta.SORT_TYPE , MonitorTplGraphItemVOMeta.DATA_ORIGIN , MonitorTplGraphItemVOMeta.QUERY_LOGIC , MonitorTplGraphItemVOMeta.REQUEST_ACTION , MonitorTplGraphItemVOMeta.IDS } )
	@SentinelResource(value = MonitorTplGraphItemServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplGraphItemServiceProxy.SAVE)
	public Result save(MonitorTplGraphItemVO monitorTplGraphItemVO) {
		
		Result result=monitorTplGraphItemService.save(monitorTplGraphItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取图形指标
	*/
	@ApiOperation(value = "获取图形指标")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MonitorTplGraphItemServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplGraphItemServiceProxy.GET_BY_ID)
	public Result<MonitorTplGraphItem> getById(String id) {
		
		Result<MonitorTplGraphItem> result=new Result<>();
		MonitorTplGraphItem monitorTplGraphItem=monitorTplGraphItemService.getById(id);
		result.success(true).data(monitorTplGraphItem);
		return result;
	}


	/**
	 * 批量获取图形指标 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取图形指标")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = MonitorTplGraphItemServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplGraphItemServiceProxy.GET_BY_IDS)
	public Result<List<MonitorTplGraphItem>> getByIds(List<String> ids) {
		
		Result<List<MonitorTplGraphItem>> result=new Result<>();
		List<MonitorTplGraphItem> list=monitorTplGraphItemService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询图形指标
	*/
	@ApiOperation(value = "查询图形指标")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.GRAPH_ID , value = "图形" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.INDICATOR_CODE , value = "指标" , required = false , dataTypeClass=String.class , example = "os.cpu"),
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "CPU用户使用率"),
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.ROUTE , value = "数据" , required = false , dataTypeClass=String.class , example = "cpu_user"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { MonitorTplGraphItemVOMeta.PAGE_INDEX , MonitorTplGraphItemVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MonitorTplGraphItemServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplGraphItemServiceProxy.QUERY_LIST)
	public Result<List<MonitorTplGraphItem>> queryList(MonitorTplGraphItemVO sample) {
		
		Result<List<MonitorTplGraphItem>> result=new Result<>();
		List<MonitorTplGraphItem> list=monitorTplGraphItemService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询图形指标
	*/
	@ApiOperation(value = "分页查询图形指标")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.GRAPH_ID , value = "图形" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.INDICATOR_CODE , value = "指标" , required = false , dataTypeClass=String.class , example = "os.cpu"),
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "CPU用户使用率"),
		@ApiImplicitParam(name = MonitorTplGraphItemVOMeta.ROUTE , value = "数据" , required = false , dataTypeClass=String.class , example = "cpu_user"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MonitorTplGraphItemServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplGraphItemServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MonitorTplGraphItem>> queryPagedList(MonitorTplGraphItemVO sample) {
		
		Result<PagedList<MonitorTplGraphItem>> result=new Result<>();
		PagedList<MonitorTplGraphItem> list=monitorTplGraphItemService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}