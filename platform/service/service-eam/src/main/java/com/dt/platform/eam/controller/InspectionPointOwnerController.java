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


import com.dt.platform.proxy.eam.InspectionPointOwnerServiceProxy;
import com.dt.platform.domain.eam.meta.InspectionPointOwnerVOMeta;
import com.dt.platform.domain.eam.InspectionPointOwner;
import com.dt.platform.domain.eam.InspectionPointOwnerVO;
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
import com.dt.platform.domain.eam.meta.InspectionPointOwnerMeta;
import com.dt.platform.domain.eam.InspectionPoint;
import com.dt.platform.domain.eam.CheckItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInspectionPointOwnerService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 巡检点接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-06 20:04:13
*/

@InDoc
@Api(tags = "巡检点")
@RestController("EamInspectionPointOwnerController")
public class InspectionPointOwnerController extends SuperController {

	@Autowired
	private IInspectionPointOwnerService inspectionPointOwnerService;

	/**
	 * 添加巡检点
	*/
	@ApiOperation(value = "添加巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1c2c458b-1bd3-11ee-a48e-00163e1b60a7"),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.OWNER_ID , value = "巡检计划" , required = false , dataTypeClass=String.class , example = "729365478572556288"),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.POINT_ID , value = "巡检点" , required = false , dataTypeClass=String.class , example = "729333314053210112"),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class , example = "1688630401000"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InspectionPointOwnerServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointOwnerServiceProxy.INSERT)
	public Result insert(InspectionPointOwnerVO inspectionPointOwnerVO) {
		
		Result result=inspectionPointOwnerService.insert(inspectionPointOwnerVO,false);
		return result;
	}



	/**
	 * 删除巡检点
	*/
	@ApiOperation(value = "删除巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1c2c458b-1bd3-11ee-a48e-00163e1b60a7")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InspectionPointOwnerServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointOwnerServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  inspectionPointOwnerService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=inspectionPointOwnerService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除巡检点 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = InspectionPointOwnerServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointOwnerServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = inspectionPointOwnerService.hasRefers(ids);
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
			Result result=inspectionPointOwnerService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=inspectionPointOwnerService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新巡检点
	*/
	@ApiOperation(value = "更新巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1c2c458b-1bd3-11ee-a48e-00163e1b60a7"),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.OWNER_ID , value = "巡检计划" , required = false , dataTypeClass=String.class , example = "729365478572556288"),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.POINT_ID , value = "巡检点" , required = false , dataTypeClass=String.class , example = "729333314053210112"),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class , example = "1688630401000"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { InspectionPointOwnerVOMeta.PAGE_INDEX , InspectionPointOwnerVOMeta.PAGE_SIZE , InspectionPointOwnerVOMeta.SEARCH_FIELD , InspectionPointOwnerVOMeta.FUZZY_FIELD , InspectionPointOwnerVOMeta.SEARCH_VALUE , InspectionPointOwnerVOMeta.DIRTY_FIELDS , InspectionPointOwnerVOMeta.SORT_FIELD , InspectionPointOwnerVOMeta.SORT_TYPE , InspectionPointOwnerVOMeta.DATA_ORIGIN , InspectionPointOwnerVOMeta.QUERY_LOGIC , InspectionPointOwnerVOMeta.REQUEST_ACTION , InspectionPointOwnerVOMeta.IDS } )
	@SentinelResource(value = InspectionPointOwnerServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointOwnerServiceProxy.UPDATE)
	public Result update(InspectionPointOwnerVO inspectionPointOwnerVO) {
		
		Result result=inspectionPointOwnerService.update(inspectionPointOwnerVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存巡检点
	*/
	@ApiOperation(value = "保存巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1c2c458b-1bd3-11ee-a48e-00163e1b60a7"),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.OWNER_ID , value = "巡检计划" , required = false , dataTypeClass=String.class , example = "729365478572556288"),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.POINT_ID , value = "巡检点" , required = false , dataTypeClass=String.class , example = "729333314053210112"),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class , example = "1688630401000"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InspectionPointOwnerVOMeta.PAGE_INDEX , InspectionPointOwnerVOMeta.PAGE_SIZE , InspectionPointOwnerVOMeta.SEARCH_FIELD , InspectionPointOwnerVOMeta.FUZZY_FIELD , InspectionPointOwnerVOMeta.SEARCH_VALUE , InspectionPointOwnerVOMeta.DIRTY_FIELDS , InspectionPointOwnerVOMeta.SORT_FIELD , InspectionPointOwnerVOMeta.SORT_TYPE , InspectionPointOwnerVOMeta.DATA_ORIGIN , InspectionPointOwnerVOMeta.QUERY_LOGIC , InspectionPointOwnerVOMeta.REQUEST_ACTION , InspectionPointOwnerVOMeta.IDS } )
	@SentinelResource(value = InspectionPointOwnerServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointOwnerServiceProxy.SAVE)
	public Result save(InspectionPointOwnerVO inspectionPointOwnerVO) {
		
		Result result=inspectionPointOwnerService.save(inspectionPointOwnerVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取巡检点
	*/
	@ApiOperation(value = "获取巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InspectionPointOwnerServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointOwnerServiceProxy.GET_BY_ID)
	public Result<InspectionPointOwner> getById(String id) {
		
		Result<InspectionPointOwner> result=new Result<>();
		InspectionPointOwner inspectionPointOwner=inspectionPointOwnerService.getById(id);
		result.success(true).data(inspectionPointOwner);
		return result;
	}


	/**
	 * 批量获取巡检点 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取巡检点")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InspectionPointOwnerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = InspectionPointOwnerServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointOwnerServiceProxy.GET_BY_IDS)
	public Result<List<InspectionPointOwner>> getByIds(List<String> ids) {
		
		Result<List<InspectionPointOwner>> result=new Result<>();
		List<InspectionPointOwner> list=inspectionPointOwnerService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询巡检点
	*/
	@ApiOperation(value = "查询巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1c2c458b-1bd3-11ee-a48e-00163e1b60a7"),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.OWNER_ID , value = "巡检计划" , required = false , dataTypeClass=String.class , example = "729365478572556288"),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.POINT_ID , value = "巡检点" , required = false , dataTypeClass=String.class , example = "729333314053210112"),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class , example = "1688630401000"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { InspectionPointOwnerVOMeta.PAGE_INDEX , InspectionPointOwnerVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InspectionPointOwnerServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointOwnerServiceProxy.QUERY_LIST)
	public Result<List<InspectionPointOwner>> queryList(InspectionPointOwnerVO sample) {
		
		Result<List<InspectionPointOwner>> result=new Result<>();
		List<InspectionPointOwner> list=inspectionPointOwnerService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询巡检点
	*/
	@ApiOperation(value = "分页查询巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1c2c458b-1bd3-11ee-a48e-00163e1b60a7"),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.OWNER_ID , value = "巡检计划" , required = false , dataTypeClass=String.class , example = "729365478572556288"),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.POINT_ID , value = "巡检点" , required = false , dataTypeClass=String.class , example = "729333314053210112"),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class , example = "1688630401000"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InspectionPointOwnerServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointOwnerServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<InspectionPointOwner>> queryPagedList(InspectionPointOwnerVO sample) {
		
		Result<PagedList<InspectionPointOwner>> result=new Result<>();
		PagedList<InspectionPointOwner> list=inspectionPointOwnerService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}