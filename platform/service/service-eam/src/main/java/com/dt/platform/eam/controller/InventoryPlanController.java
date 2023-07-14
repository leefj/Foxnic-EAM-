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


import com.dt.platform.proxy.eam.InventoryPlanServiceProxy;
import com.dt.platform.domain.eam.meta.InventoryPlanVOMeta;
import com.dt.platform.domain.eam.InventoryPlan;
import com.dt.platform.domain.eam.InventoryPlanVO;
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
import com.dt.platform.domain.eam.meta.InventoryPlanMeta;
import com.dt.platform.domain.eam.Inventory;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInventoryPlanService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 盘点计划接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-14 21:19:28
*/

@InDoc
@Api(tags = "盘点计划")
@RestController("EamInventoryPlanController")
public class InventoryPlanController extends SuperController {

	@Autowired
	private IInventoryPlanService inventoryPlanService;

	/**
	 * 添加盘点计划
	*/
	@ApiOperation(value = "添加盘点计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "732341628848570368"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.NAME , value = "计划名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.OWNER_CODE , value = "归属" , required = false , dataTypeClass=String.class , example = "asset"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.STATUS , value = "启用状态" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.PLAN_TYPE , value = "计划类型" , required = false , dataTypeClass=String.class , example = "plan"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.TPL_ID , value = "模板" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InventoryPlanServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryPlanServiceProxy.INSERT)
	public Result insert(InventoryPlanVO inventoryPlanVO) {
		
		Result result=inventoryPlanService.insert(inventoryPlanVO,false);
		return result;
	}



	/**
	 * 删除盘点计划
	*/
	@ApiOperation(value = "删除盘点计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "732341628848570368")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InventoryPlanServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryPlanServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  inventoryPlanService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=inventoryPlanService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除盘点计划 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除盘点计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryPlanVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = InventoryPlanServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryPlanServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = inventoryPlanService.hasRefers(ids);
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
			Result result=inventoryPlanService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=inventoryPlanService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新盘点计划
	*/
	@ApiOperation(value = "更新盘点计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "732341628848570368"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.NAME , value = "计划名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.OWNER_CODE , value = "归属" , required = false , dataTypeClass=String.class , example = "asset"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.STATUS , value = "启用状态" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.PLAN_TYPE , value = "计划类型" , required = false , dataTypeClass=String.class , example = "plan"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.TPL_ID , value = "模板" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { InventoryPlanVOMeta.PAGE_INDEX , InventoryPlanVOMeta.PAGE_SIZE , InventoryPlanVOMeta.SEARCH_FIELD , InventoryPlanVOMeta.FUZZY_FIELD , InventoryPlanVOMeta.SEARCH_VALUE , InventoryPlanVOMeta.DIRTY_FIELDS , InventoryPlanVOMeta.SORT_FIELD , InventoryPlanVOMeta.SORT_TYPE , InventoryPlanVOMeta.DATA_ORIGIN , InventoryPlanVOMeta.QUERY_LOGIC , InventoryPlanVOMeta.REQUEST_ACTION , InventoryPlanVOMeta.IDS } )
	@SentinelResource(value = InventoryPlanServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryPlanServiceProxy.UPDATE)
	public Result update(InventoryPlanVO inventoryPlanVO) {
		
		Result result=inventoryPlanService.update(inventoryPlanVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存盘点计划
	*/
	@ApiOperation(value = "保存盘点计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "732341628848570368"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.NAME , value = "计划名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.OWNER_CODE , value = "归属" , required = false , dataTypeClass=String.class , example = "asset"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.STATUS , value = "启用状态" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.PLAN_TYPE , value = "计划类型" , required = false , dataTypeClass=String.class , example = "plan"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.TPL_ID , value = "模板" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InventoryPlanVOMeta.PAGE_INDEX , InventoryPlanVOMeta.PAGE_SIZE , InventoryPlanVOMeta.SEARCH_FIELD , InventoryPlanVOMeta.FUZZY_FIELD , InventoryPlanVOMeta.SEARCH_VALUE , InventoryPlanVOMeta.DIRTY_FIELDS , InventoryPlanVOMeta.SORT_FIELD , InventoryPlanVOMeta.SORT_TYPE , InventoryPlanVOMeta.DATA_ORIGIN , InventoryPlanVOMeta.QUERY_LOGIC , InventoryPlanVOMeta.REQUEST_ACTION , InventoryPlanVOMeta.IDS } )
	@SentinelResource(value = InventoryPlanServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryPlanServiceProxy.SAVE)
	public Result save(InventoryPlanVO inventoryPlanVO) {
		
		Result result=inventoryPlanService.save(inventoryPlanVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取盘点计划
	*/
	@ApiOperation(value = "获取盘点计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InventoryPlanServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryPlanServiceProxy.GET_BY_ID)
	public Result<InventoryPlan> getById(String id) {
		
		Result<InventoryPlan> result=new Result<>();
		InventoryPlan inventoryPlan=inventoryPlanService.getById(id);
		// join 关联的对象
		inventoryPlanService.dao().fill(inventoryPlan)
			.with(InventoryPlanMeta.INVENTORY_PLAN_TYPE)
			.execute();
		result.success(true).data(inventoryPlan);
		return result;
	}


	/**
	 * 批量获取盘点计划 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取盘点计划")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InventoryPlanVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = InventoryPlanServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryPlanServiceProxy.GET_BY_IDS)
	public Result<List<InventoryPlan>> getByIds(List<String> ids) {
		
		Result<List<InventoryPlan>> result=new Result<>();
		List<InventoryPlan> list=inventoryPlanService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询盘点计划
	*/
	@ApiOperation(value = "查询盘点计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "732341628848570368"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.NAME , value = "计划名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.OWNER_CODE , value = "归属" , required = false , dataTypeClass=String.class , example = "asset"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.STATUS , value = "启用状态" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.PLAN_TYPE , value = "计划类型" , required = false , dataTypeClass=String.class , example = "plan"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.TPL_ID , value = "模板" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { InventoryPlanVOMeta.PAGE_INDEX , InventoryPlanVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InventoryPlanServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryPlanServiceProxy.QUERY_LIST)
	public Result<List<InventoryPlan>> queryList(InventoryPlanVO sample) {
		
		Result<List<InventoryPlan>> result=new Result<>();
		List<InventoryPlan> list=inventoryPlanService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询盘点计划
	*/
	@ApiOperation(value = "分页查询盘点计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "732341628848570368"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.NAME , value = "计划名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.OWNER_CODE , value = "归属" , required = false , dataTypeClass=String.class , example = "asset"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.STATUS , value = "启用状态" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.PLAN_TYPE , value = "计划类型" , required = false , dataTypeClass=String.class , example = "plan"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.TPL_ID , value = "模板" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InventoryPlanServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryPlanServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<InventoryPlan>> queryPagedList(InventoryPlanVO sample) {
		
		Result<PagedList<InventoryPlan>> result=new Result<>();
		PagedList<InventoryPlan> list=inventoryPlanService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		inventoryPlanService.dao().fill(list)
			.with(InventoryPlanMeta.INVENTORY_PLAN_TYPE)
			.execute();
		result.success(true).data(list);
		return result;
	}





}