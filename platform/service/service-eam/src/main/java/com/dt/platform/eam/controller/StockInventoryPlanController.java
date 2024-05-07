package com.dt.platform.eam.controller;

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


import com.dt.platform.proxy.eam.StockInventoryPlanServiceProxy;
import com.dt.platform.domain.eam.meta.StockInventoryPlanVOMeta;
import com.dt.platform.domain.eam.StockInventoryPlan;
import com.dt.platform.domain.eam.StockInventoryPlanVO;
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
import com.dt.platform.domain.eam.meta.StockInventoryPlanMeta;
import com.dt.platform.domain.eam.StockInventoryTask;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IStockInventoryPlanService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 盘点计划2接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-05-04 07:52:49
*/

@InDoc
@Api(tags = "盘点计划2")
@RestController("EamStockInventoryPlanController")
public class StockInventoryPlanController extends SuperController {

	@Autowired
	private IStockInventoryPlanService stockInventoryPlanService;

	/**
	 * 添加盘点计划2
	*/
	@ApiOperation(value = "添加盘点计划2")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "839043042928230400"),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.NAME , value = "计划名称" , required = false , dataTypeClass=String.class , example = "1234"),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.OWNER_CODE , value = "归属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.STATUS , value = "启用状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.PLAN_TYPE , value = "计划类型" , required = false , dataTypeClass=String.class , example = "plan"),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.TPL_ID , value = "模板" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "kj"),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = StockInventoryPlanServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockInventoryPlanServiceProxy.INSERT)
	public Result insert(StockInventoryPlanVO stockInventoryPlanVO) {
		
		Result result=stockInventoryPlanService.insert(stockInventoryPlanVO,false);
		return result;
	}


	/**
	 * 删除盘点计划2
	 */
	@ApiOperation(value = "删除盘点计划2")
	@ApiImplicitParams({
			@ApiImplicitParam(name = StockInventoryPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "839043042928230400")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = StockInventoryPlanServiceProxy.APPLY_TPL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockInventoryPlanServiceProxy.APPLY_TPL)
	public Result applyTpl(String id) {
		return stockInventoryPlanService.applyTpl(id);
	}


	/**
	 * 删除盘点计划2
	*/
	@ApiOperation(value = "删除盘点计划2")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "839043042928230400")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = StockInventoryPlanServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockInventoryPlanServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  stockInventoryPlanService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=stockInventoryPlanService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除盘点计划2 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除盘点计划2")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = StockInventoryPlanServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockInventoryPlanServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = stockInventoryPlanService.hasRefers(ids);
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
			Result result=stockInventoryPlanService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=stockInventoryPlanService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新盘点计划2
	*/
	@ApiOperation(value = "更新盘点计划2")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "839043042928230400"),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.NAME , value = "计划名称" , required = false , dataTypeClass=String.class , example = "1234"),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.OWNER_CODE , value = "归属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.STATUS , value = "启用状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.PLAN_TYPE , value = "计划类型" , required = false , dataTypeClass=String.class , example = "plan"),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.TPL_ID , value = "模板" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "kj"),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { StockInventoryPlanVOMeta.PAGE_INDEX , StockInventoryPlanVOMeta.PAGE_SIZE , StockInventoryPlanVOMeta.SEARCH_FIELD , StockInventoryPlanVOMeta.FUZZY_FIELD , StockInventoryPlanVOMeta.SEARCH_VALUE , StockInventoryPlanVOMeta.DIRTY_FIELDS , StockInventoryPlanVOMeta.SORT_FIELD , StockInventoryPlanVOMeta.SORT_TYPE , StockInventoryPlanVOMeta.DATA_ORIGIN , StockInventoryPlanVOMeta.QUERY_LOGIC , StockInventoryPlanVOMeta.REQUEST_ACTION , StockInventoryPlanVOMeta.IDS } )
	@SentinelResource(value = StockInventoryPlanServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockInventoryPlanServiceProxy.UPDATE)
	public Result update(StockInventoryPlanVO stockInventoryPlanVO) {
		
		Result result=stockInventoryPlanService.update(stockInventoryPlanVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存盘点计划2
	*/
	@ApiOperation(value = "保存盘点计划2")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "839043042928230400"),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.NAME , value = "计划名称" , required = false , dataTypeClass=String.class , example = "1234"),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.OWNER_CODE , value = "归属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.STATUS , value = "启用状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.PLAN_TYPE , value = "计划类型" , required = false , dataTypeClass=String.class , example = "plan"),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.TPL_ID , value = "模板" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "kj"),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { StockInventoryPlanVOMeta.PAGE_INDEX , StockInventoryPlanVOMeta.PAGE_SIZE , StockInventoryPlanVOMeta.SEARCH_FIELD , StockInventoryPlanVOMeta.FUZZY_FIELD , StockInventoryPlanVOMeta.SEARCH_VALUE , StockInventoryPlanVOMeta.DIRTY_FIELDS , StockInventoryPlanVOMeta.SORT_FIELD , StockInventoryPlanVOMeta.SORT_TYPE , StockInventoryPlanVOMeta.DATA_ORIGIN , StockInventoryPlanVOMeta.QUERY_LOGIC , StockInventoryPlanVOMeta.REQUEST_ACTION , StockInventoryPlanVOMeta.IDS } )
	@SentinelResource(value = StockInventoryPlanServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockInventoryPlanServiceProxy.SAVE)
	public Result save(StockInventoryPlanVO stockInventoryPlanVO) {
		
		Result result=stockInventoryPlanService.save(stockInventoryPlanVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取盘点计划2
	*/
	@ApiOperation(value = "获取盘点计划2")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = StockInventoryPlanServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockInventoryPlanServiceProxy.GET_BY_ID)
	public Result<StockInventoryPlan> getById(String id) {
		
		Result<StockInventoryPlan> result=new Result<>();
		StockInventoryPlan stockInventoryPlan=stockInventoryPlanService.getById(id);
		// join 关联的对象
		stockInventoryPlanService.dao().fill(stockInventoryPlan)
			.with(StockInventoryPlanMeta.INVENTORY_PLAN_TYPE)
				.with(StockInventoryPlanMeta.INVENTORY_TASK)
			.execute();
		result.success(true).data(stockInventoryPlan);
		return result;
	}


	/**
	 * 批量获取盘点计划2 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取盘点计划2")
		@ApiImplicitParams({
				@ApiImplicitParam(name = StockInventoryPlanVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = StockInventoryPlanServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockInventoryPlanServiceProxy.GET_BY_IDS)
	public Result<List<StockInventoryPlan>> getByIds(List<String> ids) {
		
		Result<List<StockInventoryPlan>> result=new Result<>();
		List<StockInventoryPlan> list=stockInventoryPlanService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询盘点计划2
	*/
	@ApiOperation(value = "查询盘点计划2")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "839043042928230400"),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.NAME , value = "计划名称" , required = false , dataTypeClass=String.class , example = "1234"),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.OWNER_CODE , value = "归属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.STATUS , value = "启用状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.PLAN_TYPE , value = "计划类型" , required = false , dataTypeClass=String.class , example = "plan"),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.TPL_ID , value = "模板" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "kj"),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { StockInventoryPlanVOMeta.PAGE_INDEX , StockInventoryPlanVOMeta.PAGE_SIZE } )
	@SentinelResource(value = StockInventoryPlanServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockInventoryPlanServiceProxy.QUERY_LIST)
	public Result<List<StockInventoryPlan>> queryList(StockInventoryPlanVO sample) {
		
		Result<List<StockInventoryPlan>> result=new Result<>();
		List<StockInventoryPlan> list=stockInventoryPlanService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询盘点计划2
	*/
	@ApiOperation(value = "分页查询盘点计划2")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "839043042928230400"),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.NAME , value = "计划名称" , required = false , dataTypeClass=String.class , example = "1234"),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.OWNER_CODE , value = "归属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.STATUS , value = "启用状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.PLAN_TYPE , value = "计划类型" , required = false , dataTypeClass=String.class , example = "plan"),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.TPL_ID , value = "模板" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "kj"),
		@ApiImplicitParam(name = StockInventoryPlanVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = StockInventoryPlanServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockInventoryPlanServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<StockInventoryPlan>> queryPagedList(StockInventoryPlanVO sample) {
		
		Result<PagedList<StockInventoryPlan>> result=new Result<>();
		PagedList<StockInventoryPlan> list=stockInventoryPlanService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		stockInventoryPlanService.dao().fill(list)
			.with(StockInventoryPlanMeta.INVENTORY_PLAN_TYPE)
				.with(StockInventoryPlanMeta.INVENTORY_TASK)
			.execute();
		result.success(true).data(list);
		return result;
	}





}