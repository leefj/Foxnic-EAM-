package com.dt.platform.eam.controller;

import java.util.*;

import com.dt.platform.domain.eam.*;
import org.github.foxnic.web.domain.hrm.Person;
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


import com.dt.platform.proxy.eam.StockInventoryTaskServiceProxy;
import com.dt.platform.domain.eam.meta.StockInventoryTaskVOMeta;
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
import com.dt.platform.domain.eam.meta.StockInventoryTaskMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.pcm.Catalog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IStockInventoryTaskService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 盘点任务2接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-05-04 08:33:48
*/

@InDoc
@Api(tags = "盘点任务2")
@RestController("EamStockInventoryTaskController")
public class StockInventoryTaskController extends SuperController {

	@Autowired
	private IStockInventoryTaskService stockInventoryTaskService;

	/**
	 * 添加盘点任务2
	*/
	@ApiOperation(value = "添加盘点任务2")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "839057059126181888"),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.BUSINESS_CODE , value = "业务编码" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.STATUS , value = "业务状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.NAME , value = "盘点名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.INVENTORY_STATUS , value = "盘点状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.DATA_STATUS , value = "数据状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.START_TIME , value = "盘点开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.FINISH_TIME , value = "盘点结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.DIRECTOR_ID , value = "负责人" , required = false , dataTypeClass=String.class , example = "617107757929070592"),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "121212"),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.PLAN_ID , value = "计划编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.OWNER_CODE , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = StockInventoryTaskServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockInventoryTaskServiceProxy.INSERT)
	public Result insert(StockInventoryTaskVO stockInventoryTaskVO) {
		
		Result result=stockInventoryTaskService.insert(stockInventoryTaskVO,false);
		return result;
	}



	/**
	 *
	 */
	@ApiOperation(value = "取消")
	@ApiImplicitParams({
			@ApiImplicitParam(name = StockInventoryTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "839057059126181888")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = StockInventoryTaskServiceProxy.CANCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockInventoryTaskServiceProxy.CANCEL)
	public Result cancel(String id) {
		return stockInventoryTaskService.cancel(id);
	}

	/**
	 *
	 */
	@ApiOperation(value = "start")
	@ApiImplicitParams({
			@ApiImplicitParam(name = StockInventoryTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "839057059126181888")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = StockInventoryTaskServiceProxy.START , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockInventoryTaskServiceProxy.START)
	public Result start(String id) {
		return stockInventoryTaskService.start(id);
	}


	@ApiOperation(value = "finish")
	@ApiImplicitParams({
			@ApiImplicitParam(name = StockInventoryTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "839057059126181888")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = StockInventoryTaskServiceProxy.FINISH , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockInventoryTaskServiceProxy.FINISH)
	public Result finish(String id) {
		return stockInventoryTaskService.finish(id);
	}

	@ApiOperation(value = "finish")
	@ApiImplicitParams({
			@ApiImplicitParam(name = StockInventoryTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "839057059126181888")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = StockInventoryTaskServiceProxy.DATA_SYNC , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockInventoryTaskServiceProxy.DATA_SYNC)
	public Result dataSync(String id) {
		return stockInventoryTaskService.dataSync(id);
	}

	@ApiOperation(value = "finish")
	@ApiImplicitParams({
			@ApiImplicitParam(name = StockInventoryTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "839057059126181888")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = StockInventoryTaskServiceProxy.INVENTORY_ASSET , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockInventoryTaskServiceProxy.INVENTORY_ASSET)
	public Result inventoryAsset(StockInventoryAssetVO stockInventoryAssetVO) {
		return stockInventoryTaskService.inventoryAsset(stockInventoryAssetVO);
	}


	/**
	 * 删除盘点任务2
	*/
	@ApiOperation(value = "删除盘点任务2")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "839057059126181888")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = StockInventoryTaskServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockInventoryTaskServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  stockInventoryTaskService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=stockInventoryTaskService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除盘点任务2 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除盘点任务2")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = StockInventoryTaskServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockInventoryTaskServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = stockInventoryTaskService.hasRefers(ids);
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
			Result result=stockInventoryTaskService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=stockInventoryTaskService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新盘点任务2
	*/
	@ApiOperation(value = "更新盘点任务2")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "839057059126181888"),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.BUSINESS_CODE , value = "业务编码" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.STATUS , value = "业务状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.NAME , value = "盘点名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.INVENTORY_STATUS , value = "盘点状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.DATA_STATUS , value = "数据状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.START_TIME , value = "盘点开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.FINISH_TIME , value = "盘点结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.DIRECTOR_ID , value = "负责人" , required = false , dataTypeClass=String.class , example = "617107757929070592"),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "121212"),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.PLAN_ID , value = "计划编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.OWNER_CODE , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { StockInventoryTaskVOMeta.PAGE_INDEX , StockInventoryTaskVOMeta.PAGE_SIZE , StockInventoryTaskVOMeta.SEARCH_FIELD , StockInventoryTaskVOMeta.FUZZY_FIELD , StockInventoryTaskVOMeta.SEARCH_VALUE , StockInventoryTaskVOMeta.DIRTY_FIELDS , StockInventoryTaskVOMeta.SORT_FIELD , StockInventoryTaskVOMeta.SORT_TYPE , StockInventoryTaskVOMeta.DATA_ORIGIN , StockInventoryTaskVOMeta.QUERY_LOGIC , StockInventoryTaskVOMeta.REQUEST_ACTION , StockInventoryTaskVOMeta.IDS } )
	@SentinelResource(value = StockInventoryTaskServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockInventoryTaskServiceProxy.UPDATE)
	public Result update(StockInventoryTaskVO stockInventoryTaskVO) {
		
		Result result=stockInventoryTaskService.update(stockInventoryTaskVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存盘点任务2
	*/
	@ApiOperation(value = "保存盘点任务2")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "839057059126181888"),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.BUSINESS_CODE , value = "业务编码" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.STATUS , value = "业务状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.NAME , value = "盘点名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.INVENTORY_STATUS , value = "盘点状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.DATA_STATUS , value = "数据状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.START_TIME , value = "盘点开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.FINISH_TIME , value = "盘点结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.DIRECTOR_ID , value = "负责人" , required = false , dataTypeClass=String.class , example = "617107757929070592"),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "121212"),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.PLAN_ID , value = "计划编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.OWNER_CODE , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { StockInventoryTaskVOMeta.PAGE_INDEX , StockInventoryTaskVOMeta.PAGE_SIZE , StockInventoryTaskVOMeta.SEARCH_FIELD , StockInventoryTaskVOMeta.FUZZY_FIELD , StockInventoryTaskVOMeta.SEARCH_VALUE , StockInventoryTaskVOMeta.DIRTY_FIELDS , StockInventoryTaskVOMeta.SORT_FIELD , StockInventoryTaskVOMeta.SORT_TYPE , StockInventoryTaskVOMeta.DATA_ORIGIN , StockInventoryTaskVOMeta.QUERY_LOGIC , StockInventoryTaskVOMeta.REQUEST_ACTION , StockInventoryTaskVOMeta.IDS } )
	@SentinelResource(value = StockInventoryTaskServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockInventoryTaskServiceProxy.SAVE)
	public Result save(StockInventoryTaskVO stockInventoryTaskVO) {
		
		Result result=stockInventoryTaskService.save(stockInventoryTaskVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取盘点任务2
	*/
	@ApiOperation(value = "获取盘点任务2")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = StockInventoryTaskServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockInventoryTaskServiceProxy.GET_BY_ID)
	public Result<StockInventoryTask> getById(String id) {
		
		Result<StockInventoryTask> result=new Result<>();
		StockInventoryTask stockInventoryTask=stockInventoryTaskService.getById(id);
		// join 关联的对象
		stockInventoryTaskService.dao().fill(stockInventoryTask)
			.with("originator")
			.with("director")
				.with(StockInventoryTaskMeta.INVENTORY_USER_LIST)
			.with(StockInventoryTaskMeta.WAREHOUSE_LIST)
				.with(StockInventoryTaskMeta.INVENTORY_ASSET_INFO_LIST)
			.execute();

		stockInventoryTaskService.dao().join(stockInventoryTask.getOriginator(), Person.class);
		stockInventoryTaskService.dao().join(stockInventoryTask.getDirector(), Person.class);
		stockInventoryTaskService.dao().join(stockInventoryTask.getInventoryUserList(), Person.class);

		result.success(true).data(stockInventoryTask);
		return result;
	}


	/**
	 * 批量获取盘点任务2 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取盘点任务2")
		@ApiImplicitParams({
				@ApiImplicitParam(name = StockInventoryTaskVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = StockInventoryTaskServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockInventoryTaskServiceProxy.GET_BY_IDS)
	public Result<List<StockInventoryTask>> getByIds(List<String> ids) {
		
		Result<List<StockInventoryTask>> result=new Result<>();
		List<StockInventoryTask> list=stockInventoryTaskService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询盘点任务2
	*/
	@ApiOperation(value = "查询盘点任务2")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "839057059126181888"),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.BUSINESS_CODE , value = "业务编码" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.STATUS , value = "业务状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.NAME , value = "盘点名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.INVENTORY_STATUS , value = "盘点状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.DATA_STATUS , value = "数据状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.START_TIME , value = "盘点开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.FINISH_TIME , value = "盘点结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.DIRECTOR_ID , value = "负责人" , required = false , dataTypeClass=String.class , example = "617107757929070592"),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "121212"),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.PLAN_ID , value = "计划编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.OWNER_CODE , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { StockInventoryTaskVOMeta.PAGE_INDEX , StockInventoryTaskVOMeta.PAGE_SIZE } )
	@SentinelResource(value = StockInventoryTaskServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockInventoryTaskServiceProxy.QUERY_LIST)
	public Result<List<StockInventoryTask>> queryList(StockInventoryTaskVO sample) {
		
		Result<List<StockInventoryTask>> result=new Result<>();
		List<StockInventoryTask> list=stockInventoryTaskService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询盘点任务2
	*/
	@ApiOperation(value = "分页查询盘点任务2")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "839057059126181888"),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.BUSINESS_CODE , value = "业务编码" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.STATUS , value = "业务状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.NAME , value = "盘点名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.INVENTORY_STATUS , value = "盘点状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.DATA_STATUS , value = "数据状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.START_TIME , value = "盘点开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.FINISH_TIME , value = "盘点结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.DIRECTOR_ID , value = "负责人" , required = false , dataTypeClass=String.class , example = "617107757929070592"),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "121212"),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.PLAN_ID , value = "计划编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.OWNER_CODE , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryTaskVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = StockInventoryTaskServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockInventoryTaskServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<StockInventoryTask>> queryPagedList(StockInventoryTaskVO sample) {
		
		Result<PagedList<StockInventoryTask>> result=new Result<>();
		PagedList<StockInventoryTask> list=stockInventoryTaskService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		stockInventoryTaskService.dao().fill(list)
			.with("originator")
			.with("director")
			.with(StockInventoryTaskMeta.WAREHOUSE_LIST)
				.with(StockInventoryTaskMeta.INVENTORY_USER_LIST)
				.with(StockInventoryTaskMeta.INVENTORY_ASSET_INFO_LIST)
			.execute();

		List<List<Employee>> usersList = CollectorUtil.collectList(list.getList(), StockInventoryTask::getInventoryUserList);
		List<Employee> users = usersList.stream().collect(ArrayList::new, ArrayList::addAll, ArrayList::addAll);
		stockInventoryTaskService.dao().join(users, Person.class);


		List<Employee> oUserList = CollectorUtil.collectList(list.getList(), StockInventoryTask::getOriginator);
		stockInventoryTaskService.dao().join(oUserList, Person.class);

		List<Employee> dUserList = CollectorUtil.collectList(list.getList(), StockInventoryTask::getDirector);
		stockInventoryTaskService.dao().join(dUserList, Person.class);

		result.success(true).data(list);
		return result;
	}





}