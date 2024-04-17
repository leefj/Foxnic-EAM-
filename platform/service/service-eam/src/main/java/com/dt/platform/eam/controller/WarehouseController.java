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


import com.dt.platform.proxy.eam.WarehouseServiceProxy;
import com.dt.platform.domain.eam.meta.WarehouseVOMeta;
import com.dt.platform.domain.eam.Warehouse;
import com.dt.platform.domain.eam.WarehouseVO;
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
import com.dt.platform.domain.eam.meta.WarehouseMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IWarehouseService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 仓库接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-17 18:36:11
*/

@InDoc
@Api(tags = "仓库")
@RestController("EamWarehouseController")
public class WarehouseController extends SuperController {

	@Autowired
	private IWarehouseService warehouseService;

	/**
	 * 添加仓库
	*/
	@ApiOperation(value = "添加仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WarehouseVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "558599358870716416"),
		@ApiImplicitParam(name = WarehouseVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class , example = "c1"),
		@ApiImplicitParam(name = WarehouseVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = WarehouseVOMeta.WAREHOUSE_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "上海仓库"),
		@ApiImplicitParam(name = WarehouseVOMeta.WAREHOUSE_NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "上海仓库"),
		@ApiImplicitParam(name = WarehouseVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = WarehouseServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WarehouseServiceProxy.INSERT)
	public Result insert(WarehouseVO warehouseVO) {
		
		Result result=warehouseService.insert(warehouseVO,false);
		return result;
	}



	/**
	 * 删除仓库
	*/
	@ApiOperation(value = "删除仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WarehouseVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "558599358870716416")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = WarehouseServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WarehouseServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  warehouseService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=warehouseService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除仓库 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WarehouseVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = WarehouseServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WarehouseServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = warehouseService.hasRefers(ids);
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
			Result result=warehouseService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=warehouseService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新仓库
	*/
	@ApiOperation(value = "更新仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WarehouseVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "558599358870716416"),
		@ApiImplicitParam(name = WarehouseVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class , example = "c1"),
		@ApiImplicitParam(name = WarehouseVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = WarehouseVOMeta.WAREHOUSE_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "上海仓库"),
		@ApiImplicitParam(name = WarehouseVOMeta.WAREHOUSE_NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "上海仓库"),
		@ApiImplicitParam(name = WarehouseVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { WarehouseVOMeta.PAGE_INDEX , WarehouseVOMeta.PAGE_SIZE , WarehouseVOMeta.SEARCH_FIELD , WarehouseVOMeta.FUZZY_FIELD , WarehouseVOMeta.SEARCH_VALUE , WarehouseVOMeta.DIRTY_FIELDS , WarehouseVOMeta.SORT_FIELD , WarehouseVOMeta.SORT_TYPE , WarehouseVOMeta.DATA_ORIGIN , WarehouseVOMeta.QUERY_LOGIC , WarehouseVOMeta.REQUEST_ACTION , WarehouseVOMeta.IDS } )
	@SentinelResource(value = WarehouseServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WarehouseServiceProxy.UPDATE)
	public Result update(WarehouseVO warehouseVO) {
		
		Result result=warehouseService.update(warehouseVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存仓库
	*/
	@ApiOperation(value = "保存仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WarehouseVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "558599358870716416"),
		@ApiImplicitParam(name = WarehouseVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class , example = "c1"),
		@ApiImplicitParam(name = WarehouseVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = WarehouseVOMeta.WAREHOUSE_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "上海仓库"),
		@ApiImplicitParam(name = WarehouseVOMeta.WAREHOUSE_NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "上海仓库"),
		@ApiImplicitParam(name = WarehouseVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { WarehouseVOMeta.PAGE_INDEX , WarehouseVOMeta.PAGE_SIZE , WarehouseVOMeta.SEARCH_FIELD , WarehouseVOMeta.FUZZY_FIELD , WarehouseVOMeta.SEARCH_VALUE , WarehouseVOMeta.DIRTY_FIELDS , WarehouseVOMeta.SORT_FIELD , WarehouseVOMeta.SORT_TYPE , WarehouseVOMeta.DATA_ORIGIN , WarehouseVOMeta.QUERY_LOGIC , WarehouseVOMeta.REQUEST_ACTION , WarehouseVOMeta.IDS } )
	@SentinelResource(value = WarehouseServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WarehouseServiceProxy.SAVE)
	public Result save(WarehouseVO warehouseVO) {
		
		Result result=warehouseService.save(warehouseVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取仓库
	*/
	@ApiOperation(value = "获取仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WarehouseVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = WarehouseServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WarehouseServiceProxy.GET_BY_ID)
	public Result<Warehouse> getById(String id) {
		
		Result<Warehouse> result=new Result<>();
		Warehouse warehouse=warehouseService.getById(id);
		result.success(true).data(warehouse);
		return result;
	}


	/**
	 * 批量获取仓库 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取仓库")
		@ApiImplicitParams({
				@ApiImplicitParam(name = WarehouseVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = WarehouseServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WarehouseServiceProxy.GET_BY_IDS)
	public Result<List<Warehouse>> getByIds(List<String> ids) {
		
		Result<List<Warehouse>> result=new Result<>();
		List<Warehouse> list=warehouseService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询仓库
	*/
	@ApiOperation(value = "查询仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WarehouseVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "558599358870716416"),
		@ApiImplicitParam(name = WarehouseVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class , example = "c1"),
		@ApiImplicitParam(name = WarehouseVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = WarehouseVOMeta.WAREHOUSE_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "上海仓库"),
		@ApiImplicitParam(name = WarehouseVOMeta.WAREHOUSE_NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "上海仓库"),
		@ApiImplicitParam(name = WarehouseVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { WarehouseVOMeta.PAGE_INDEX , WarehouseVOMeta.PAGE_SIZE } )
	@SentinelResource(value = WarehouseServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WarehouseServiceProxy.QUERY_LIST)
	public Result<List<Warehouse>> queryList(WarehouseVO sample) {
		
		Result<List<Warehouse>> result=new Result<>();
		List<Warehouse> list=warehouseService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询仓库
	*/
	@ApiOperation(value = "分页查询仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WarehouseVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "558599358870716416"),
		@ApiImplicitParam(name = WarehouseVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class , example = "c1"),
		@ApiImplicitParam(name = WarehouseVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = WarehouseVOMeta.WAREHOUSE_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "上海仓库"),
		@ApiImplicitParam(name = WarehouseVOMeta.WAREHOUSE_NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "上海仓库"),
		@ApiImplicitParam(name = WarehouseVOMeta.UPDATE_BY , value = "修改人ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = WarehouseServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WarehouseServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Warehouse>> queryPagedList(WarehouseVO sample) {
		
		Result<PagedList<Warehouse>> result=new Result<>();
		PagedList<Warehouse> list=warehouseService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}