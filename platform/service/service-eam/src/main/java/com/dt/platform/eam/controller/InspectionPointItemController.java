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


import com.dt.platform.proxy.eam.InspectionPointItemServiceProxy;
import com.dt.platform.domain.eam.meta.InspectionPointItemVOMeta;
import com.dt.platform.domain.eam.InspectionPointItem;
import com.dt.platform.domain.eam.InspectionPointItemVO;
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
import com.dt.platform.domain.eam.meta.InspectionPointItemMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInspectionPointItemService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 巡检点项接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-06 07:50:25
*/

@InDoc
@Api(tags = "巡检点项")
@RestController("EamInspectionPointItemController")
public class InspectionPointItemController extends SuperController {

	@Autowired
	private IInspectionPointItemService inspectionPointItemService;

	/**
	 * 添加巡检点项
	*/
	@ApiOperation(value = "添加巡检点项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointItemVOMeta.POINT_ID , value = "巡检点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointItemVOMeta.ITEM_ID , value = "巡检项" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointItemVOMeta.SELECT_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InspectionPointItemServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointItemServiceProxy.INSERT)
	public Result insert(InspectionPointItemVO inspectionPointItemVO) {
		
		Result result=inspectionPointItemService.insert(inspectionPointItemVO,false);
		return result;
	}



	/**
	 * 删除巡检点项
	*/
	@ApiOperation(value = "删除巡检点项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InspectionPointItemServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointItemServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  inspectionPointItemService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=inspectionPointItemService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除巡检点项 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除巡检点项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = InspectionPointItemServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointItemServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = inspectionPointItemService.hasRefers(ids);
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
			Result result=inspectionPointItemService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=inspectionPointItemService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新巡检点项
	*/
	@ApiOperation(value = "更新巡检点项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointItemVOMeta.POINT_ID , value = "巡检点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointItemVOMeta.ITEM_ID , value = "巡检项" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointItemVOMeta.SELECT_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { InspectionPointItemVOMeta.PAGE_INDEX , InspectionPointItemVOMeta.PAGE_SIZE , InspectionPointItemVOMeta.SEARCH_FIELD , InspectionPointItemVOMeta.FUZZY_FIELD , InspectionPointItemVOMeta.SEARCH_VALUE , InspectionPointItemVOMeta.DIRTY_FIELDS , InspectionPointItemVOMeta.SORT_FIELD , InspectionPointItemVOMeta.SORT_TYPE , InspectionPointItemVOMeta.DATA_ORIGIN , InspectionPointItemVOMeta.QUERY_LOGIC , InspectionPointItemVOMeta.REQUEST_ACTION , InspectionPointItemVOMeta.IDS } )
	@SentinelResource(value = InspectionPointItemServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointItemServiceProxy.UPDATE)
	public Result update(InspectionPointItemVO inspectionPointItemVO) {
		
		Result result=inspectionPointItemService.update(inspectionPointItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存巡检点项
	*/
	@ApiOperation(value = "保存巡检点项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointItemVOMeta.POINT_ID , value = "巡检点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointItemVOMeta.ITEM_ID , value = "巡检项" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointItemVOMeta.SELECT_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InspectionPointItemVOMeta.PAGE_INDEX , InspectionPointItemVOMeta.PAGE_SIZE , InspectionPointItemVOMeta.SEARCH_FIELD , InspectionPointItemVOMeta.FUZZY_FIELD , InspectionPointItemVOMeta.SEARCH_VALUE , InspectionPointItemVOMeta.DIRTY_FIELDS , InspectionPointItemVOMeta.SORT_FIELD , InspectionPointItemVOMeta.SORT_TYPE , InspectionPointItemVOMeta.DATA_ORIGIN , InspectionPointItemVOMeta.QUERY_LOGIC , InspectionPointItemVOMeta.REQUEST_ACTION , InspectionPointItemVOMeta.IDS } )
	@SentinelResource(value = InspectionPointItemServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointItemServiceProxy.SAVE)
	public Result save(InspectionPointItemVO inspectionPointItemVO) {
		
		Result result=inspectionPointItemService.save(inspectionPointItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取巡检点项
	*/
	@ApiOperation(value = "获取巡检点项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InspectionPointItemServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointItemServiceProxy.GET_BY_ID)
	public Result<InspectionPointItem> getById(String id) {
		
		Result<InspectionPointItem> result=new Result<>();
		InspectionPointItem inspectionPointItem=inspectionPointItemService.getById(id);
		result.success(true).data(inspectionPointItem);
		return result;
	}


	/**
	 * 批量获取巡检点项 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取巡检点项")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InspectionPointItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = InspectionPointItemServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointItemServiceProxy.GET_BY_IDS)
	public Result<List<InspectionPointItem>> getByIds(List<String> ids) {
		
		Result<List<InspectionPointItem>> result=new Result<>();
		List<InspectionPointItem> list=inspectionPointItemService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询巡检点项
	*/
	@ApiOperation(value = "查询巡检点项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointItemVOMeta.POINT_ID , value = "巡检点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointItemVOMeta.ITEM_ID , value = "巡检项" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointItemVOMeta.SELECT_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { InspectionPointItemVOMeta.PAGE_INDEX , InspectionPointItemVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InspectionPointItemServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointItemServiceProxy.QUERY_LIST)
	public Result<List<InspectionPointItem>> queryList(InspectionPointItemVO sample) {
		
		Result<List<InspectionPointItem>> result=new Result<>();
		List<InspectionPointItem> list=inspectionPointItemService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询巡检点项
	*/
	@ApiOperation(value = "分页查询巡检点项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointItemVOMeta.POINT_ID , value = "巡检点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointItemVOMeta.ITEM_ID , value = "巡检项" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointItemVOMeta.SELECT_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InspectionPointItemServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointItemServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<InspectionPointItem>> queryPagedList(InspectionPointItemVO sample) {
		
		Result<PagedList<InspectionPointItem>> result=new Result<>();
		PagedList<InspectionPointItem> list=inspectionPointItemService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}